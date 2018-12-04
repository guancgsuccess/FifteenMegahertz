package com.fm.controller;

import com.aliyuncs.exceptions.ClientException;
import com.fm.entity.CustVerify;
import com.fm.entity.Customer;
import com.fm.entity.common.ServerResponse;
import com.fm.service.*;
import com.fm.util.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.Map;

/**
 * Created on 2018/10/8.
 * @author haonan.
 */
@SuppressWarnings("all")
@Controller
@RequestMapping("/customer")
public class CustomerController {
    /**
     * 定义统一返回数据格式
     */
    private ServerResponse result=null;
    @Autowired
    private CustomerService customerService;

    @Autowired
    private CustLikeService custLikeService;

    @Autowired
    private ImageFavoriteService imageFavoriteService;

    @Autowired
    private CustomerFollowService customerFollowService;

    @Autowired
    private CustVerifyService custVerifyService;

    @Autowired
    private ImageOrderService imageOrderService;

    /**
     * 注册发送验证码
     * @param custPhone 用户输入手机号
     */
    @GetMapping("setRegisterCode")
    @ResponseBody
    public ServerResponse setRegisterCode(String custPhone,HttpSession session) throws ClientException {
        ServerResponse response = customerService.setRegisterCode(custPhone);
        for (Map.Entry<String, Object> entry : response.getData().entrySet()) {
            if ("message".equals(entry.getKey())) {
                session.setAttribute("message", entry.getValue());
            }
            if ("phone".equals(entry.getKey())) {
                session.setAttribute("phone", entry.getValue());
            }
            if ("getMessageTime".equals(entry.getKey())) {
                session.setAttribute("getMessageTime", entry.getValue());
            }
        }
        return  response;
    }

    /**
     * 用户注册
     * @param custPhone 手机号
     * @param custPassword 密码
     * @param getCode 获取验证码
     * @return map.registerCode:0代表已注册
     *             registerCode:1代表注册失败,
     *             registerCode:2代表注册成功
     */
    @GetMapping("register")
    @ResponseBody
    public ServerResponse registerCustomer(String custPhone, String custPassword, String getCode, HttpSession session){
        String code= (String) session.getAttribute("message");
        String sessionCustPhone=(String) session.getAttribute("phone");
        Long getMessageTime=(Long)session.getAttribute("getMessageTime");
        ServerResponse response=customerService.registerCustomer(custPhone,custPassword,code,getCode,sessionCustPhone,getMessageTime);
        for (Object v:response.getData().values()) {
            if((Integer)v==1 || (Integer)v==2 || (Integer)v==4 ){
                session.removeAttribute("message");
            }
        }
        return response;
    }


    /**
     * 手机或者邮箱登录
     * @param custPhoneOrEmail 用户手机或邮箱
     * @param custPassword 用户密码
     * @return 统一返回格式
     */
    @GetMapping("login")
    @ResponseBody
    public ServerResponse loginCustomer(String custPhoneOrEmail, String custPassword,String getLoginIp,HttpSession session){
        ServerResponse response=customerService.loginCustomer(custPhoneOrEmail,custPassword,getLoginIp);
        for(Map.Entry<String, Object> entry: response.getData().entrySet()){
            if("custId".equals(entry.getKey())){
                session.setAttribute("custId",entry.getValue());
            }
            if("custProfile".equals(entry.getKey())){
                session.setAttribute("custProfile",entry.getValue());
            }
            if("custNick".equals(entry.getKey())){
                session.setAttribute("custNick",entry.getValue());
            }
        }
        return response;
    }

    /**
     * 快捷登录获取的验证码
     * @param custPhone 手机号
     */
    @GetMapping("setLoginCode")
    @ResponseBody
    public ServerResponse setLoginCode(String custPhone,HttpSession session) throws ClientException {
        ServerResponse response = customerService.setLoginCode(custPhone);
        for (Map.Entry<String, Object> entry : response.getData().entrySet()) {
            if ("message".equals(entry.getKey())) {
                session.setAttribute("message", entry.getValue());
            }
            if ("phone".equals(entry.getKey())) {
                session.setAttribute("phone", entry.getValue());
            }
            if ("getMessageTime".equals(entry.getKey())) {
                session.setAttribute("getMessageTime", entry.getValue());
            }
        }
        return  response;
    }

    /**
     * 手机验证码登录
     * @param custPhone 用户手机号码
     * @param getCode  用户输入的验证码
     * @param getLoginIp 登录IP
     * @return 统一返回
     */
    @GetMapping("userCodeLogin")
    @ResponseBody
    public ServerResponse queryByPhoneAndCode(String custPhone,String getCode,String getLoginIp,HttpSession session){
        String sessionCode= (String) session.getAttribute("message");
        String sessionPhone=(String) session.getAttribute("phone");
        Long getMessageTime=(Long)session.getAttribute("getMessageTime");
        ServerResponse response=customerService.codeLoginCustomer(custPhone,sessionPhone,getCode,sessionCode,getMessageTime,getLoginIp);
        for(Map.Entry<String, Object> entry: response.getData().entrySet()) {
            if("custId".equals(entry.getKey())){
                session.setAttribute("custId",entry.getValue());
            }
            if("custProfile".equals(entry.getKey())){
                session.setAttribute("custProfile",entry.getValue());
            }
            if("custNick".equals(entry.getKey())){
                session.setAttribute("custNick",entry.getValue());
            }
            if("2".equals(entry.getValue()) || "4".equals(entry.getValue())){
                session.removeAttribute("message");
            }
        }
        return response;
    }


    /**
     * 个人中心加载
     * @return
     */
    @GetMapping("personal")
    @ResponseBody
    public ServerResponse Personal(Integer custId,HttpSession session){
        Integer sessionCustId=(Integer) session.getAttribute("custId");
        return customerService.personalCenter(custId,sessionCustId);
    }


    /**
     * 修改用户名和个性签名
     * @param custNick 用户名
     * @param custIntro 个性签名
     * @return map
     */
    @GetMapping("personal/modifyNickAndIntro")
    @ResponseBody
    public ServerResponse modifyNickAndIntro(String custNick,String custIntro,HttpSession session)  {
        Integer custId=(Integer) session.getAttribute("custId");
        return customerService.modifyNickAndIntro(custId,custNick,custIntro);
    }


    /**
     * 修改个人头像
     * @param portraitUrl 头像的URL
     * @return 返回1:成功;0:失败
     */
    @GetMapping("personal/modifyHeadPortrait")
    @ResponseBody
    public ServerResponse modifyHeadPortrait( String portraitUrl,HttpSession session){
        Integer custId=(Integer) session.getAttribute("custId");
        return customerService.modifyHeadPortrait(custId,portraitUrl);
    }


    /**
     * 修改密码
     * @param oldPwd 旧密码
     * @param repeatNewPassword 新密码
     * @return 1:修改成功;2:失败;0:原密码错误
     */
    @GetMapping("personal/modifyPassword")
    @ResponseBody
    public ServerResponse modifyPassword(String oldPwd,String repeatNewPassword,HttpSession session){
        Integer custId=(Integer) session.getAttribute("custId");
        return customerService.modifyPassword(custId,oldPwd,repeatNewPassword);
    }

    /**
     * 用户退出
     * @return 返回操作结果
     */
    @RequestMapping("signOut")
    @ResponseBody
    public ServerResponse signOut(HttpSession session){
        Map<String,Object> data=new HashMap<>();
        Integer custId=(Integer)session.getAttribute("custId");
        if(custId!=null){
            session.removeAttribute("custId");
            session.removeAttribute("custNick");
            session.removeAttribute("custProfile");
            data.put("signOutMsg",1);
        }
        return ServerResponse.createBySuccess("退出成功",data);
    }

    /**
     * 取消关注
     * @param authorId
     * @return
     */
    @DeleteMapping("deleteIdols/{authorId}")
    @ResponseBody
    public ServerResponse deleteIdols(@PathVariable Integer authorId,HttpSession session){
        Integer custId=(Integer) session.getAttribute("custId");
        boolean status=this.customerFollowService.cancelFollow(custId,authorId);
        Map<String,Object> data=new HashMap<>();
        if(status){
            data.put("sessionCustId",custId);
            data.put("idols",customerService.countByIdol(custId));
            result=ServerResponse.createBySuccess("成功取消关注!",data);
        }else {
            result=ServerResponse.createByFailure("系统繁忙!");
        }
        return result;
    }

    /**
     * 加关注
     * @param authorId 偶像Id
     * @return
     */
    @RequestMapping("idols/save/{authorId}")
    @ResponseBody
    public ServerResponse saveIdols(@PathVariable Integer authorId,HttpSession session){
        Integer custId=(Integer) session.getAttribute("custId");
        Map<String,Object> data=new HashMap<>();
        if(custId!=null) {
            data.put("sessionCustId",custId);
            if (custId.equals(authorId)) {
                data.put("saveIdolsMsg",2);
            } else {
                boolean status = this.customerFollowService.addFollow(custId, authorId);
                if (status) {
                    data.put("saveIdolsMsg", 1);
                    data.put("idols",customerService.countByIdol(custId));
                } else {
                    result = ServerResponse.createByFailure("系统繁忙!");
                }
            }
        }else{
            data.put("saveIdolsMsg",0);
        }
        result=ServerResponse.createBySuccess("",data);
        return result;
    }

    /**
     * 检验邮箱并且发送邮件
     * @param mail 邮箱号码
     * @return
     */
    @PostMapping("mail/send")
    @ResponseBody
    public ServerResponse checkMail(String mail,HttpSession session){
        String sessionId=session.getId();
        System.out.println(sessionId);
        ServerResponse response=this.customerService.sendEmail(mail,sessionId);
        if(response.getStatus()==1){
            session.setAttribute("mail",mail);
            session.setAttribute("code",response.getData().get("code"));
        }
        return response;
    }

    /**
     * 忘记密码时通过邮箱修改密码
     * @param token
     * @param pwd
     * @return
     */
    @PostMapping("mail/updatePwd")
    @ResponseBody
    public ServerResponse updatePwdByMail(String token,String pwd){
        MySessionContext myc= MySessionContext.getInstance();
        HttpSession session = myc.getSession(md5.md5Decrypt(token));
        System.out.println(token);
        System.out.println(session);
        if(this.customerService.updatePwdByEmail((String) session.getAttribute("mail"),pwd)){
            session.removeAttribute("mail");
            result=ServerResponse.createBySuccess("修改密码成功",null);
        }else {
            result=ServerResponse.createByFailure("修改密码失败!");
        }
        return result;
    }

    /**
     * 获取用户订单
     * @param session
     * @return
     */
    @GetMapping("order/get/list")
    @ResponseBody
    public ServerResponse getAllOrder(HttpSession session){
        Integer custId= (Integer) session.getAttribute("custId");
        Map<String ,Object> data=new HashMap<>();
        data.put("orderList",this.imageOrderService.getAllImageOrder(custId));
        result=ServerResponse.createBySuccess("操作成功!",data);
        return result;
    }




    /**
     * 获取用户的登录状态(顶部单独请求)
     * @return 已登录返回用户信息,反则返回未登录信息
     */
    @GetMapping("isLogin")
    @ResponseBody
    public ServerResponse isLogin(HttpSession session){
        Map<String,Object> data=new HashMap<>(3);
        Integer custId= (Integer) session.getAttribute("custId");
        if(custId!=null){
            Customer customer=this.customerService.findById(custId);
            data.put("custId",custId);
            data.put("custNick",customer.getCustNick());
            data.put("custProfile",customer.getCustProfile());
            data.put("rangeLevel",customer.getRangeLevel());
            data.put("custIntro",customer.getCustIntro());
            result=ServerResponse.createByHasLogin(data);
        }else {
            result=ServerResponse.createByNeedLogin();
        }
        return result;
    }

    /**
     * 添加关注
     * @param authorId 被关注人ID
     * @return
     */
    @PostMapping("follow/save")
    @ResponseBody
    public ServerResponse following(Integer authorId,HttpSession session){
        Integer custId= (Integer) session.getAttribute("custId");
        boolean status=this.customerFollowService.addFollow(custId,authorId);
        if(status){
            result=ServerResponse.createBySuccess("关注成功!",null);
        }else {
            result=ServerResponse.createByFailure("系统繁忙!");
        }
        return result;
    }

    /**
     * 取消关注
     * @param authorId 被取消关注人ID
     * @return
     */
    @DeleteMapping("follow/delete/{authorId}")
    @ResponseBody
    public ServerResponse unFollow(@PathVariable Integer authorId,HttpSession session){
        Integer custId= (Integer) session.getAttribute("custId");
        boolean status=this.customerFollowService.cancelFollow(custId,authorId);
        if(status){
            result=ServerResponse.createBySuccess("成功取消关注!",null);
        }else {
            result=ServerResponse.createByFailure("系统繁忙!");
        }
        return result;
    }

    /**
     * 用户点赞
     * @param imageId 图片ID
     * @return 返回操作结果
     */
    @PostMapping("like/save")
    @ResponseBody
    public ServerResponse addImageLike(Integer imageId, HttpSession session){
        Integer custId= (Integer) session.getAttribute("custId");
        result=ServerResponse.createBySuccess("点赞成功!",null);
        try {
            this.custLikeService.doLike(custId,imageId);
        } catch (Exception e) {
            result=ServerResponse.createByFailure("系统繁忙,请稍后再试!");
        }
        return result;
    }

    /**
     * 用户取消点赞
     * @param imageId 图片ID
     * @return 返回操作结果
     */
    @DeleteMapping("like/delete/{imageId}")
    @ResponseBody
    public ServerResponse deleteImageLike(@PathVariable Integer imageId, HttpSession session){
        Integer custId= (Integer) session.getAttribute("custId");
        result=ServerResponse.createBySuccess("取消成功!",null);
        try {
            this.custLikeService.cancelLike(custId,imageId);
        } catch (Exception e) {
            result=ServerResponse.createByFailure("系统繁忙,请稍后再试!");
        }
        return result;
    }

    /**
     * 用户收藏
     * @param imageId 图片ID
     * @return 返回操作结果
     */
    @PostMapping("collect/save")
    @ResponseBody
    public ServerResponse addCollections(Integer imageId, HttpSession session){
        Integer custId= (Integer) session.getAttribute("custId");
        result= ServerResponse.createBySuccess("成功加入收藏夹!", null);
        try {
            this.imageFavoriteService.addCollection(imageId,custId);
        } catch (Exception e) {
            result =ServerResponse.createByFailure("系统繁忙,请稍后再试!");
        }
        return result;
    }
    /**
     * 用户取消收藏
     * @param imageId 图片ID
     * @return 返回操作结果
     */
    @DeleteMapping("collect/delete/{imageId}")
    @ResponseBody
    public ServerResponse cancelCollection(@PathVariable  Integer imageId, HttpSession session){
        Integer custId= (Integer) session.getAttribute("custId");
        result= ServerResponse.createBySuccess("成功移除收藏夹!", null);
        try {
            this.imageFavoriteService.cancelCollect(imageId,custId);
        } catch (Exception e) {
            result =ServerResponse.createByFailure("系统繁忙,请稍后再试!");
        }
        return result;
    }

    /**
     * 获取用户的订单列表
     * @return
     */
    @GetMapping("imageOrder/get/list")
    @ResponseBody
    public ServerResponse getAllImageOrder(HttpSession session){
        Integer custId= (Integer) session.getAttribute("custId");
        Map<String,Object> data=new HashMap<>(1);
        data.put("imageOrders",imageOrderService.getAllImageOrder(custId));
        return ServerResponse.createBySuccess("",data);
    }



    /**
     * 获取用户等级
     * @return 用户等级
     */
    @RequestMapping("verify/getRangeLevel")
    @ResponseBody
    public ServerResponse getRangeLevel(HttpSession session){
        Integer custId= (Integer) session.getAttribute("custId");
        return customerService.findRangeLevelByPrimaryKey(custId);
    }

    /**
     * 获取用户审核状态
     * @return 0:未通过审核,1:通过审核,2:正在审核,null:未提交审核
     */
    @RequestMapping("verify/getVerifyStatus")
    @ResponseBody
    public ServerResponse findVerifyStatusByCustId(HttpSession session){
        Integer custId= (Integer) session.getAttribute("custId");
        return custVerifyService.findByExample(custId);
    }

    /**
     *保存用户签约信息
     * @param custVerify 签约信息
     * @return true:保存成功,false:保存失败
     */
    @RequestMapping("verify/save")
    @ResponseBody
    public Boolean saveCustVerify(CustVerify custVerify,HttpSession session){
        custVerify.setCustId((Integer) session.getAttribute("custId"));
        return custVerifyService.saveSelective(custVerify);
    }







 }





