package com.fm.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;

/**
 * Created on 2018/9/30.
 * 该Controller为页面跳转Controller
 * @author guochangji
 */
@Controller
@RequestMapping("/view")
public class ViewController {
    /**
     * 图库页面跳转
     * @return 跳转页面地址
     */
    @RequestMapping("all_image")
    public String go2AllImage(){
        return "WEB-INF/view/picture/all_image";
    }

    /**
     * 图片详情页面跳转
     * @return 跳转页面地址
     */
    @RequestMapping("image_info")
    public String go2ImageDetail(){
        return "WEB-INF/view/picture/image_info";
    }
    /**
     * 个人中心页面跳转
     * @return 跳转页面地址
     */
    @RequestMapping("personal")
    public String goToPersonal(){
        return "WEB-INF/view/customer/personalCenter";
    }

    /**
     * 测试上传
     * @return
     */
    @RequestMapping("upload")
    public String goToUpload(){
        return "WEB-INF/view/customer/upload";
    }


    @RequestMapping("sign")
    public String go2Sign(){
        return "WEB-INF/view/customer/sign";
    }
    /**
     * 跳转到全部活动页面
     * @return
     */
    @RequestMapping("active")
    public String go2Active(){return "/WEB-INF/view/active/active";}

    /**
     * 跳转到活动详情页面
     * @return
     */
    @RequestMapping("activedetail")
    public String go2Activedetail(){
        return "WEB-INF/view/active/activedetail";
    }

    /**
     * 跳转到修改密码界面
     * @return
     */
    @RequestMapping("go2UpdatePwd")
    public String go2UpdatePwd(){
        return "WEB-INF/view/customer/reset_pwd";
    }


    /**
     *  跳转到定制摄影主页
     * @return
     */
    @RequestMapping("all")
    public String getAll(){
        return "WEB-INF/view/shoot/all_products";
    }

    /**
     * 跳转到指定套餐详情
     * @return
     */

    @RequestMapping("productInfo")
    public String getInfo(){
        return "WEB-INF/view/shoot/product";
    }

    /**
     * 跳转社区主页
     *
     * @return 跳转页面地址
     */
    @RequestMapping("comm")
    public String toCommunityMain() {
        return "WEB-INF/view/community/main";
    }

    /**
     * 跳转搜索页并存数据
     *
     * @return 跳转页面地址
     */
    @RequestMapping("search")
    public String toCommunitySearch(HttpSession session, String context, String categoryId) {

        session.setAttribute("context", context);
        session.setAttribute("categoryId", categoryId);
        return "WEB-INF/view/community/search";
    }

    /**
     * 跳转社区中心页并存数据
     *
     * @return 跳转页面地址
     */
    @RequestMapping("center")
    public String toCommunityCenter() {

        return "WEB-INF/view/community/center";
    }

    /**
     * 跳转全部社区页
     *
     * @return 跳转页面地址
     */
    @RequestMapping("allComm")
    public String toCommunityCommunity() {

        return "WEB-INF/view/community/community";
    }

    /**
     * 跳转社区详情页并存数据
     *
     * @return 跳转页面地址
     */
    @RequestMapping("info")
    public String toCommunityInfo(HttpSession session, String commId, String messId) {

        session.setAttribute("commId", commId);
        session.setAttribute("messId", messId);
        return "WEB-INF/view/community/info";
    }

    /**
     * 跳转公告详情页并存数据
     *
     * @return 跳转页面地址
     */
    @RequestMapping("bulletin")
    public String toCommunityBulletin(HttpSession session, String bulletinId) {

        session.setAttribute("bulletinId", bulletinId);
        return "WEB-INF/view/community/bulletin";
    }
}
