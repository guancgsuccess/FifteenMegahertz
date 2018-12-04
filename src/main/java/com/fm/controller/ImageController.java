package com.fm.controller;

import com.fm.entity.Customer;
import com.fm.entity.Image;
import com.fm.entity.ImageCategory;
import com.fm.entity.ImageComment;
import com.fm.entity.common.ServerResponse;
import com.fm.service.*;
import com.fm.util.PageModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.*;

/**
 * Created on 2018/9/29.
 * @author guochangji
 */
@SuppressWarnings("all")
@Controller
@RequestMapping("/image")
public class ImageController {
    /**
     * 定义统一返回数据格式
     */
    private ServerResponse result=null;

    @Autowired
    private ImageService imageService;

    @Autowired
    private CategoryService categoryService;

    @Autowired
    private CustomerService customerService;

    @Autowired
    private CustomerFollowService customerFollowService;

    @Autowired
    private ImageCommentService imageCommentService;

    @Autowired
    private CustLikeService custLikeService;

    @Autowired
    private ImageFavoriteService imageFavoriteService;

    @Autowired
    private ImageOrderService imageOrderService;

    @Autowired
    private ItemImageService itemImageService;

    /**
     *  多条件组合查询图片
     * @param currentPage 当前页数
     * @param categoryId 类别ID
     * @param priceType 价格类型(0:全部;1:免费;2:收费.)
     * @param sortType 排序类型(0:默认;1:浏览量降序;2:下载量降序;3:收藏量降序;4:点赞量降序;5:发布时间降序)
     * @param keyword 关键字
     * @return 返回查询结果
     */
    @GetMapping("get/{categoryId}/{priceType}/{sortType}/{currentPage}")
    @ResponseBody
    public ServerResponse getImageByPageWithCondition(@PathVariable Integer currentPage,@PathVariable Integer categoryId,@PathVariable Integer priceType,@PathVariable Integer sortType,String keyword){
        Map<String,Object> data=new HashMap<>(6);
        data.put("categoryInfo",this.categoryService.findAllCategoryInfo());
        PageModel imagesPageModel=imageService.findByPageWithCondition(currentPage,categoryId,priceType,sortType,keyword);
        data.put("pageModel",imagesPageModel);
        data.put("categoryId",categoryId);
        data.put("priceType",priceType);
        data.put("sortType",sortType);
        if(keyword!=null&&"\"\"".equals(keyword.trim())){
            keyword=null;
        }
        data.put("keyword",keyword);
        result=ServerResponse.createBySuccess("",data);
        return result;
    }


    /**
     * 获取图片详细信息
     * @param imageId 图片ID
     * @return 返回查询数据对象
     */
    @SuppressWarnings("all")
    @GetMapping("get/{imageId}")
    @ResponseBody
    public ServerResponse getImageDetail(@PathVariable Integer imageId, HttpSession session){
        //增加浏览量+1
        this.imageService.updateClicks(imageId);
        Integer custId= (Integer) session.getAttribute("custId");
        Map<String,Object> data=new HashMap<>();
        //图片信息
        Image image=this.imageService.findById(imageId);
        data.put("imageInfo",image);
        //类别信息
        data.put("categoryName",this.categoryService.findById(image.getCategoryId()).getCategoryName());
        //作者信息
        Customer author=this.customerService.findById(image.getCustId());
        data.put("authorId",author.getCustId());
        data.put("authorNick",author.getCustNick());
        data.put("authorProfile",author.getCustProfile());
        data.put("followerCount",customerFollowService.findFollowCount(image.getCustId()));
        //读取用户登录信息
        if(custId!=null){
            Customer cust=this.customerService.findById(custId);
            data.put("custId",custId);
            data.put("custCredits",cust.getCustCredits());
            //关注信息(是否已关注)
            data.put("isFollowed",this.customerFollowService.IsFollowed(custId,author.getCustId()));
            //喜欢状态(是否点过喜欢按钮)
            data.put("isLiked",this.custLikeService.isLiked(custId,imageId));
            //收藏状态(是否加入过收藏)
            data.put("isCollected",this.imageFavoriteService.isCollected(imageId,custId));
        }else {
            data.put("custId",null);
            data.put("custCredits",null);
            //关注信息(是否已关注)
            data.put("isFollowed",false);
            //喜欢状态(是否点过喜欢按钮)
            data.put("isLiked",false);
            //收藏状态(是否加入过收藏)
            data.put("isCollected",false);
        }
        //评论信息
        data.put("commentCount",this.imageCommentService.findImageCommentCount(imageId));
        data.put("commentInfo",this.imageCommentService.findCommentInfo(imageId));
        result=ServerResponse.createBySuccess("",data);
        return result;
    }


    /**
     * 获取当前图片的作者的所有作品
     * @param imageId 图片ID
     * @return 返回ID集合,且当前作品排在list首个位置.
     */
    @GetMapping("get/idList/{imageId}")
    @ResponseBody
    public ServerResponse getImageIdByAuthorId(@PathVariable Integer imageId){
        Map<String,Object> data=new HashMap<>(1);
        data.put("imageIdList",this.imageService.findImageIdsByAuthorId(imageId));
        result=ServerResponse.createBySuccess("",data);
        return result;
    }

    /**
     * 购买该图片
     * @param custId 用户ID
     * @param imageId 图片ID
     * @return 返回操作结果
     */
    @PostMapping("order/save")
    @ResponseBody
    public ServerResponse addOrder(Integer custId, Integer imageId){
        Map<String,Object> data=new HashMap<>(2);
        Integer status=0;
        try {
            status=this.imageOrderService.saveOrder(custId,imageId);
        } catch (Exception e) {
            return ServerResponse.createByFailure("系统繁忙!");
        }
        Image image=this.imageService.findById(imageId);
        if(status==1) {
            data.put("imageName", image.getImageName());
            data.put("imageUrl", image.getNocomprePath());
            result = ServerResponse.createBySuccess("购买成功,即将下载!", data);
        }
        if(status==2){
            data.put("imageName",image.getImageName());
            data.put("imageUrl",image.getNocomprePath());
            result=ServerResponse.createBySuccess("已购买,本次下载不收费!",data);
        }
        return result;
    }


    /**
     * 图片添加评论
     * @param comment 评论内容
     * @param custId 评论人ID
     * @param authorId 被评论人ID
     * @param imageId 图片ID
     * @return 返回操作结果
     */
    @PostMapping("comment/save")
    @ResponseBody
    public ServerResponse addImageComment(String comment, Integer custId, Integer authorId, Integer imageId){
        if(imageCommentService.addImageComment(comment,custId,authorId,imageId)){
            result=ServerResponse.createBySuccess("评论成功!",null);
        }else {
            result=ServerResponse.createByFailure("评论失败,请重试!");
        }
        return result;
    }

    /**
     * 获得图片全部类别信息
     * @return
     */
    @GetMapping("category/get/list")
    @ResponseBody
    public ServerResponse getAllCategory(){
        Map<String,Object> data=new HashMap<>();
        List<Map<String,Object>> categoryList=this.categoryService.findAllCategoryInfo();
        data.put("categoryInfo",categoryList);
        result=ServerResponse.createBySuccess("加载类别信息成功!",data);
        return result;
    }

    /**
     * 上传图片
     * @param session
     * @param image 图片对象
     * @return
     */
    @PostMapping("save")
    @ResponseBody
    public ServerResponse saveImageInfo(HttpSession session,Image image){
        Integer custId= (Integer) session.getAttribute("custId");
        Integer status= null;
        try {
            status = this.imageService.addImage(custId,image);
        } catch (Exception e) {
            result=ServerResponse.createByFailure("系统繁忙,请稍后再试!");
        }
        if(status==0){
            result=ServerResponse.createBySuccess("作品上传成功,请前往个人中心查看!",null);
        }else if(status==2){
            result=ServerResponse.createByFailure("上传失败,该图片已存在!");
        }
        return result;
    }

    /**
     * 根据输入关键词获取搜索提示
     * @param keyword
     * @return 存关键字的Set集合
     */
    @GetMapping("search/{keyword}")
    @ResponseBody
    public ServerResponse getSearchSuggest(@PathVariable String keyword){
        Set<String> keys=this.imageService.findSearchKey(keyword);
        Map<String,Object> data=new HashMap<>(1);
        data.put("keys",keys);
        result=ServerResponse.createBySuccess("",data);
        return result;
    }

    /**
     *  查询作品
     * @param currentPage
     * @param session
     * @return
     */
    @GetMapping("personal/myWorks")
    @ResponseBody
    public ServerResponse getPersonWorks(Integer currentPage,Integer custId,HttpSession session){
        Map<String,Object> data=new HashMap<>();
        PageModel pageModel=new PageModel();
        if(currentPage==null){
            pageModel.setCurrentPageCode(1);
        }else{
            pageModel.setCurrentPageCode(currentPage);
        }
        Integer sessionCustId=(Integer) session.getAttribute("custId");
        data.put("pagemodel",imageService.findWorksByPage(pageModel,custId,sessionCustId));
        data.put("sessionCustId",sessionCustId);
        result=ServerResponse.createBySuccess("",data);
        return result;
    }

    /**
     *我的收藏
     * @param currentPage
     * @return
     */
    @GetMapping("personal/myLikes")
    @ResponseBody
    public ServerResponse getPersonLikes(Integer currentPage,Integer custId,HttpSession session){
        Map<String,Object> data=new HashMap<>(5);
        PageModel pageModel=new PageModel();
        if(currentPage==null){
            pageModel.setCurrentPageCode(1);
        }else{
            pageModel.setCurrentPageCode(currentPage);
        }
        Integer sessionCustId=(Integer) session.getAttribute("custId");
        data.put("pagemodel",imageFavoriteService.findLikesByPage(pageModel,custId,sessionCustId));
        data.put("sessionCustId",sessionCustId);
        //收藏数量
        result=ServerResponse.createBySuccess("",data);
        return result;


    }

    /**
     *根据粉丝Id查询我的关注
     * @param currentPage 页码
     * @return
     */
    @GetMapping("personal/myIdols")
    @ResponseBody
    public ServerResponse myIdols(Integer currentPage,Integer custId,HttpSession session){
        Map<String,Object> data=new HashMap<>();
        PageModel pageModel=new PageModel();
        if(currentPage==null){
            pageModel.setCurrentPageCode(1);
        }else{
            pageModel.setCurrentPageCode(currentPage);
        }
        Integer sessionCustId=(Integer) session.getAttribute("custId");
        data.put("pagemodel",customerFollowService.findIdolsByPage(pageModel,custId,sessionCustId));
        data.put("sessionCustId",sessionCustId);
        result=ServerResponse.createBySuccess("",data);
        return  result;
    }

    /**
     *根据偶像Id查询我的粉丝
     * @param currentPage
     * @return
     */
    @GetMapping("personal/myFollowers")
    @ResponseBody
    public ServerResponse myFollowers(Integer currentPage,Integer custId,HttpSession session){
        Map<String,Object> data=new HashMap<>();

        PageModel pageModel=new PageModel();
        if(currentPage==null){
            pageModel.setCurrentPageCode(1);
        }else{
            pageModel.setCurrentPageCode(currentPage);
        }
        Integer sessionCustId=(Integer) session.getAttribute("custId");
        data.put("pagemodel",customerFollowService.findFollowByPage(pageModel,custId,sessionCustId));
        data.put("sessionCustId",sessionCustId);
        result=ServerResponse.createBySuccess("",data);
        return  result;
    }

    /**
     * 删除图片（修改状态）
     * @param imageId 图片ID
     * @return
     */
    @RequestMapping("deleteImage/{imageId}")
    @ResponseBody
    public ServerResponse deleteImage(@PathVariable Integer imageId,HttpSession session){
        Boolean rows=imageService.modifyImageStatus(imageId);
        Integer custId=(Integer) session.getAttribute("custId");
        Map<String,Object> data=new HashMap<>();
        if (rows) {
            //删除成功
            data.put("deleteImageMsg",1);
            data.put("works",customerService.countByImage(custId));
            data.put("likes",customerService.countByImageFavorite(custId));
        }else{
            data.put("deleteImageMsg",0);
        }
        result=ServerResponse.createBySuccess("",data);
        return result;
    }

    /**
     * 取消收藏
     * @param imageId 图片Id
     * @return
     */
    @DeleteMapping("removeMylikes/{imageId}")
    @ResponseBody
    public ServerResponse removeMylikes(@PathVariable Integer imageId,HttpSession session){
        Integer custId= (Integer) session.getAttribute("custId");
        Map<String,Object> data=new HashMap<>();
        data.put("custId",custId);
        try {
            this.imageFavoriteService.cancelCollect(imageId,custId);
            data.put("likes",customerService.countByImageFavorite(custId));
        } catch (Exception e) {
            result =ServerResponse.createByFailure("系统繁忙,请稍后再试!");
        }
        result= ServerResponse.createBySuccess("成功移除收藏夹!", data);
        return result;
    }

    /**
     * 添加收藏
     * @param imageId 图片ID
     * @return
     */
    @RequestMapping("insertMyLikes/{imageId}")
    @ResponseBody
    public ServerResponse insertMyLikes(@PathVariable Integer imageId,HttpSession session){
        Integer custId= (Integer) session.getAttribute("custId");
        Map<String,Object> data=new HashMap<>();
        data.put("custId",custId);
        try {
            this.imageFavoriteService.addCollection(imageId,custId);
        } catch (Exception e) {
            result =ServerResponse.createByFailure("系统繁忙,请稍后再试!");
        }
        result= ServerResponse.createBySuccess("加入收藏夹成功!", data);
        return result;

    }


    /**
     * 获得用户可以参加比赛的图片
     * @param itemId 比赛id
     * @return 用户可以参加比赛的图片的路径和id
     */
    @RequestMapping("itemImage/getMyImage/{itemId}")
    @ResponseBody
    public ServerResponse getMyImage(@PathVariable Integer itemId,HttpSession session){
        Integer custId = (Integer) session.getAttribute("custId");
        return itemImageService.findMyImage(custId,itemId);
    }
}
