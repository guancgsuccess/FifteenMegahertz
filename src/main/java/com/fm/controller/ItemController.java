package com.fm.controller;

import com.fm.entity.ItemImage;
import com.fm.entity.common.ServerResponse;
import com.fm.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;

/**
 * @author liuyuan
 */
@SuppressWarnings("all")
@Controller
@RequestMapping("/item")
public class ItemController {
    @Autowired
    private ItemImageService itemImageService;

    @Autowired
    private CustomerService customerService;

    @Autowired
    private ImageService imageService;

    @Autowired
    private CustomerFollowService customerFollowService;

    @Autowired
    private ItemService itemService;

    /**
     * 获得所有比赛信息
     * @return 所有比赛信息
     */
    @RequestMapping("getAllItem")
    @ResponseBody
    public ServerResponse getAllItem(){
        return itemService.findAllItem();
    }

    /**
     * 获得正在进行的比赛信息
     * @return 正在进行的比赛信息
     */
    @RequestMapping("getNowItem")
    @ResponseBody
    public ServerResponse getNowActive(){
        return itemService.findNowItem();
    }

    /**
     * 获得已经结束的比赛信息
     * @return 已经结束的比赛信息
     */
    @RequestMapping("getEndItem")
    @ResponseBody
    public ServerResponse getEndActive(){
        return itemService.findEndItem();
    }

    /**
     * 获得比赛详情信息
     * @param itemId 比赛id
     * @return 比赛详细信息
     */
    @RequestMapping("getItemDetail/{itemId}")
    @ResponseBody
    public ServerResponse getItemDetail(@PathVariable Integer itemId){
        return itemService.findItemDetail(itemId);
    }

    /**
     * 获得参加比赛的所有作者信息
     * @param itemId 比赛id
     * @return 所有参加比赛的作者信息
     */
    @RequestMapping("itemImage/getAllAuthor/{currentPage}/{itemId}")
    @ResponseBody
    public ServerResponse getAllAuthor(@PathVariable Integer currentPage, @PathVariable Integer itemId, HttpSession session){
        Integer custId = (Integer) session.getAttribute("custId");
        if(custId==null){
            custId=0;
        }
        return itemImageService.findAuthorPage(currentPage,itemId,custId);
    }

    /**
     * 获得当前活动当前页码信息
     * @param currentPage 当前页码
     * @param itemId 活动id
     * @return 当前页码的详细信息
     */
    @RequestMapping("itemImage/getAllImage/{currentPage}/{itemId}")
    @ResponseBody
    public ServerResponse getAllImage(@PathVariable Integer currentPage, @PathVariable Integer itemId){
        return itemImageService.findImagePage(currentPage,itemId);
    }

    /**
     * 保存参加活动的图片信息
     * @param itemImage 活动图片信息
     * @return true:保存成功,false:保存失败
     */
    @RequestMapping("itemImage/save")
    @ResponseBody
    public Boolean save(ItemImage itemImage, HttpSession session){
        Integer custId= (Integer) session.getAttribute("custId");
        itemImage.setCustId(custId);
        return itemImageService.saveSelective(itemImage);
    }
}
