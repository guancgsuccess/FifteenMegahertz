package com.fm.controller;

import com.aliyuncs.exceptions.ClientException;
import com.fm.entity.Shoot;
import com.fm.entity.ShootAppraise;
import com.fm.entity.ShootOrder;
import com.fm.entity.ShootTheme;
import com.fm.entity.common.ServerResponse;
import com.fm.entity.shoot.PageModel;
import com.fm.service.*;
import com.fm.util.GenerateCode;
import com.fm.util.SmsApi;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.*;

@Controller
@RequestMapping("/shoot")
public class ShootController {
    private ServerResponse result = null;

    private final ShootThemeService shootThemeService;
    private final ShootService shootService;
    private final CustomerService customerService;
    private final ImageService imageService;
    private final ShootAppraiseService shootAppraiseService;
    private final ShootOrderService shootOrderService;

    @Autowired
    public ShootController(ShootThemeService shootThemeService, ShootService shootService, CustomerService customerService, ImageService imageService, ShootAppraiseService shootAppraiseService, ShootOrderService shootOrderService) {
        this.shootThemeService = shootThemeService;
        this.shootService = shootService;
        this.customerService = customerService;
        this.imageService = imageService;
        this.shootAppraiseService = shootAppraiseService;
        this.shootOrderService = shootOrderService;
    }

    /**
     * 获得套餐分类
     * @return 返回所有分类
     */
    @GetMapping("theme")
    @ResponseBody
    public ServerResponse getTheme(){
        Map<String,Object> data = shootThemeService.selectAll();
        result = ServerResponse.createBySuccess("",data);
        return result;
    }

    /**
     * 获得所有套餐
     * @param pagecode 当前页码
     * @return 返回所有套餐的信息
     */
    @GetMapping("getByPage")
    @ResponseBody
    public ServerResponse getAllByPage(Integer pagecode){
        Map<String,Object> data = new HashMap<>();
        List<Object> list = new ArrayList<>();
        List<ShootTheme> shootThemeList = shootThemeService.findAll();
        for (ShootTheme shootTheme:shootThemeList){
            PageModel<Shoot> page = new PageModel<>();
            page = shootService.getAllByPage(pagecode,page,shootTheme.getThemeId());
            Map<String,Object> map1 = new HashMap<>();
            map1.put("page",page);
            list.add(map1);
        }
        data.put("shootThemeList",list);
        result = ServerResponse.createBySuccess("",data);
        return result;
    }

    /**
     * 获得当前页的所有套餐
     * @param page 当前页码
     * @return 返回所有套餐的信息
     */
    @GetMapping("getByPage/page/{page}")
    @ResponseBody
    public ServerResponse getAllByPage2(@PathVariable Integer page){
        return getAllByPage(page);
    }

    /**
     * 获得签约摄影师的信息
     * @return 返回摄影师的信息
     */
    @GetMapping("photographer")
    @ResponseBody
    public ServerResponse getPhotographer(){
        Map<String,Object> data = customerService.getPhotographer();
        result = ServerResponse.createBySuccess("",data);
        return result;
    }

    /**
     * 获得点击量最高的五个作品信息
     * @return 返回作品信息
     */
    @GetMapping("image")
    @ResponseBody
    public ServerResponse getImageInfo(){
        Map<String,Object> data = imageService.selectImages();
        result = ServerResponse.createBySuccess("",data);
        return result;
    }

    /**
     * 根据地址获得套餐
     * @param pagecode 当前页码
     * @return 返回套餐信息
     */
    @GetMapping("getAllByLoc")
    @ResponseBody
    public ServerResponse getAllByLoc(Integer pagecode){
        Map<String,Object> data = new HashMap<>();
        List<Object> list = new ArrayList<>();
        List<String> shootLocList = new ArrayList<>();
        shootLocList.add("杭州集合");
        shootLocList.add("苏州集合");
        shootLocList.add("成都集合");
        shootLocList.add("云南集合");
        for (String shootLoc:shootLocList){
            Map<String,Object> map1 = new HashMap<>();
            PageModel<Shoot> page = new PageModel<>();
            page = shootService.getAllByLoc(pagecode,page,shootLoc);
            map1.put("page",page);
            list.add(map1);
        }
        data.put("shootLocList",list);
        result = ServerResponse.createBySuccess("",data);
        return result;
    }

    /**
     * 根据地址获得当前页的所有套餐
     * @param page 当前页码
     * @return 返回套餐信息
     */
    @GetMapping("getAllByLoc/page/{page}")
    @ResponseBody
    public ServerResponse getAllByLoc2(@PathVariable Integer page){
        return getAllByLoc(page);
    }

    /**
     * 根据套餐Id获得套餐详情
     * @param shootId 套餐Id
     * @return 返回
     */
    @GetMapping("productInfo/{shootId}")
    @ResponseBody
    public ServerResponse getInfo(@PathVariable Integer shootId, HttpSession session){
        Integer custId = (Integer) session.getAttribute("custId");
        Map<String,Object> data = shootService.selectById(shootId);
        data.put("custId",custId);
        result = ServerResponse.createBySuccess("",data);
        return result;
    }

    /**
     * 发送验证码
     * @param orderPhone 联系手机号
     */
    @GetMapping("setContactTelCode")
    @ResponseBody
    public ServerResponse setContactTelCode(String orderPhone, HttpSession session) throws ClientException {
        Map<String,Object> data = new HashMap<>();
      String randCode = GenerateCode.getCode();
      SmsApi.sendSms(orderPhone,randCode);
        //验证码
        session.setAttribute("message",randCode);
        //发送验证码时的时间
        session.setAttribute("getMessageTime",System.currentTimeMillis());
        result = ServerResponse.createBySuccess("success",data);
        return result;
    }

    /**
     * 根据套餐Id获得所有用户评论
     * @param pagecode 用户评论的当前页码
     * @param shootId 套餐Id
     * @return 返回查询到的用评论的信息
     */
    @GetMapping("get/{shootId}")
    @ResponseBody
    public ServerResponse getAppraise(Integer pagecode, @PathVariable Integer shootId){
        Map<String,Object> data = shootAppraiseService.selectByPage(pagecode,shootId);
        result = ServerResponse.createBySuccess("",data);
        return result;
    }

    /**
     * 获得当前页的用户评论
     * @param page 当前页码
     * @param shootId 套餐Id
     * @return 返回该页所有用户评论的信息
     */
    @GetMapping("get/{page}/{shootId}")
    @ResponseBody
    public ServerResponse getByPage(@PathVariable Integer page, @PathVariable Integer shootId){
        return getAppraise(page,shootId);
    }

    /**
     * 添加用户评论
     * @param appraise 用户的评论
     * @return 返回添加失败或是成功
     */
    @PostMapping("save")
    @ResponseBody
    public ServerResponse save(@RequestBody ShootAppraise appraise, HttpSession session){
        Integer custId = (Integer)session.getAttribute("custId");
        appraise.setCustId(custId);
        appraise.setAppraiseCreateTime(new Date());
        appraise.setAppraiseStatus(1);
        Map<String,Object> data = new HashMap<>();
        int count = this.shootAppraiseService.save(appraise);
        if (count!=0){
            result = ServerResponse.createBySuccess("success",data);
            return result;
        }
        else{
            result = ServerResponse.createByFailure("fail");
            return result;
        }

    }

    /**
     * 根据用户Id获得该用户的所有订单
     * @param custId 用户Id
     * @return 返回订单详情
     */
    @GetMapping("all")
    @ResponseBody
    @SuppressWarnings("all")
    public ServerResponse getAll(HttpSession session){
        Integer custId = (Integer)session.getAttribute("custId");
        Map<String,Object> data = shootOrderService.selectById(custId);
        result = ServerResponse.createBySuccess("",data);
        return result;
    }

    /**
     * 接收验证码并进行验证
     * @param getCode 接收到的验证码
     * @param session 存储页面中的验证码等信息
     * @return 返回验证结果
     */
    @PostMapping("receiveCode")
    @ResponseBody
    public ServerResponse receiveCode(String getCode, HttpSession session){
        Map<String,Object> data = new HashMap<>();
        String code = (String) session.getAttribute("message");
//        String code = session.getAttribute("message")+"";
        Long getMessageTime = (Long)session.getAttribute("getMessageTime");
        Long nowTime = System.currentTimeMillis();
        int smsTime = 300000;
        if (nowTime-getMessageTime<smsTime){
            if (getCode.equals(code)){
                result = ServerResponse.createBySuccess("success", data);
            }else {
                //验证码错误
                result = ServerResponse.createByFailure("验证码错误");
            }
        }else {
            //验证码已经超过一分钟
            result = ServerResponse.createByFailure("验证码失效");
        }
        return result;
    }

    /**
     * 添加订单
     * @param shootOrder 要添加的订单
     * @param session 存储验证码等信息
     * @return 返回添加结果
     */
    @PostMapping("orderAdd")
    @ResponseBody
    @SuppressWarnings("all")
    public ServerResponse addOrder(@RequestBody ShootOrder shootOrder, HttpSession session){
        Integer custId = (Integer)session.getAttribute("custId");
        shootOrder.setCustId(custId);
        shootOrder.setOrderCreateTime(new Date());
        shootOrder.setOrderStatus(1);
        Map<String,Object> data = new HashMap<>();
        int count = shootOrderService.save(shootOrder);
        if (count != 0){
            result = ServerResponse.createBySuccess("success", data);
            session.removeAttribute("message");
            session.removeAttribute("getMessageTime");
        } else
            result = ServerResponse.createByFailure("fail");
        return result;
    }

    /**
     * 根据订单Id删除订单
     * @param orderId 订单Id
     * @return 返回删除订单结果
     */
    @DeleteMapping("orderDelete/{orderId}")
    @ResponseBody
    @SuppressWarnings("all")
    public ServerResponse deleteOrder(@PathVariable Integer orderId, HttpSession session){
        Integer custId = (Integer)session.getAttribute("custId");
        Integer count = shootOrderService.deleteByCustIdAndOrderId(custId,orderId);
        Map<String,Object> data = new HashMap<>();
        if (count==0){
            result = ServerResponse.createByFailure("fail");
            return result;
        }else{
            result = ServerResponse.createBySuccess("success",data);
            return result;
        }
    }


}
