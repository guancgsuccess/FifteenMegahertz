package com.fm.service.impl;

import com.fm.dao.CustomerDao;
import com.fm.dao.ImageDao;
import com.fm.dao.ItemImageDao;
import com.fm.entity.*;
import com.fm.entity.common.ServerResponse;
import com.fm.service.CustomerFollowService;
import com.fm.service.ItemImageService;
import com.fm.util.PageModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author liuyuan
 */
@Service
public class ItemImageServiceImpl implements ItemImageService {
    /**
     * 定义统一返回数据格式
     */
    private ServerResponse result = null;

    @Autowired
    private ItemImageDao itemImageDao;

    @Autowired
    private ImageDao imageDao;

    @Autowired
    private CustomerDao customerDao;

    @Autowired
    private CustomerFollowService customerFollowService;

    /**
     * 获得当前活动当前页码作者信息
      * @param currentPage 当前页码
     * @param itemId 活动id
     * @param custId 用户id
     * @return 当前页码的作者详细信息
     */
    @Override
    public ServerResponse findAuthorPage(Integer currentPage, Integer itemId, Integer custId) {
        Map<String,Object> pageMap = new HashMap<>(1);
        PageModel pageModel = new PageModel();
        //每页显示记录数
        pageModel.setPageSize(5);
        //当前页码
        pageModel.setCurrentPageCode(currentPage);
        //总记录数
        pageModel.setTotalRecord(itemImageDao.queryCustCount(itemId));
        //总页数
        pageModel.setTotalPages((pageModel.getTotalRecord() % pageModel.getPageSize() ==0 ? pageModel.getTotalRecord() / pageModel.getPageSize() : pageModel.getTotalRecord() / pageModel.getPageSize() +1));
        //从第几条记录开始查询
        pageModel.setStartRecord((pageModel.getCurrentPageCode()-1) * pageModel.getPageSize());

        List<Map<String,Object>> authorList = new ArrayList<>();
        List<Map> rs = itemImageDao.queryCustIdByItemId(itemId,pageModel.getStartRecord(),pageModel.getPageSize());
        List<Integer> custIds=new ArrayList<>();
        for(Map map:rs){
            custIds.add((Integer) map.get("cust_id"));
        }

        for(Integer id:custIds){
            Customer customer = customerDao.selectByPrimaryKey(id);
            Integer authorId = customer.getCustId();
            String authorNick = customer.getCustNick();
            String authorIntro = customer.getCustIntro();
            String authorProfile = customer.getCustProfile();
            boolean isFollow = customerFollowService.IsFollowed(custId,authorId);

            Map<String,Object> map = new HashMap<>(6);
            map.put("custId",custId);
            map.put("authorId",authorId);
            map.put("authorNick",authorNick);
            map.put("authorIntro",authorIntro);
            map.put("authorProfile",authorProfile);
            map.put("isFollow", isFollow);

            ItemImageExample itemImageExample = new ItemImageExample();
            itemImageExample.createCriteria().andItemIdEqualTo(itemId).andCustIdEqualTo(authorId);
            itemImageExample.setLimit(3);
            List<ItemImage> itemImageList = itemImageDao.selectByExample(itemImageExample);
            List<Map<String,Object>> imgPathList = new ArrayList<>();

            for (ItemImage itemImage:itemImageList){
                Map<String,Object> map1 = new HashMap<>(2);
                Image image = imageDao.selectByPrimaryKey(itemImage.getImageId());
                Integer imageId = image.getImageId();
                String Path = image.getNocomprePath();
                map1.put("imageId",imageId);
                map1.put("path", Path);
                imgPathList.add(map1);
            }
            map.put("imgPathList",imgPathList);
            authorList.add(map);
        }
        pageModel.setModelList(authorList);

        Map<String,Object> map = new HashMap<>(6);
        map.put("totalRecord",pageModel.getTotalRecord());
        map.put("totalPages",pageModel.getTotalPages());
        map.put("pageSize",pageModel.getPageSize());
        map.put("currentPageCode",pageModel.getCurrentPageCode());
        map.put("startRecord",pageModel.getStartRecord());
        map.put("authorList",pageModel.getModelList());

        pageMap.put("pageModel",map);
        result= ServerResponse.createBySuccess("",pageMap);
        return result;
    }

    /**
     * 获得当前活动当前页码图片信息
     * @param currentPage 当前页码
     * @param itemId 活动id
     * @return 当前页码的图片详细信息
     */
    @Override
    public ServerResponse findImagePage(Integer currentPage, Integer itemId) {
        Map<String,Object> pageMap = new HashMap<>(1);
        List<Map<String,Object>> pageList = new ArrayList<>();
        PageModel pageModel=new PageModel();
        //每页显示记录数
        pageModel.setPageSize(30);
        //当前页码
        pageModel.setCurrentPageCode(currentPage);

        ItemImageExample itemImageExample= new ItemImageExample();
        itemImageExample.createCriteria().andItemIdEqualTo(itemId);
        Long total=itemImageDao.countByExample(itemImageExample);

        //总记录数
        pageModel.setTotalRecord(total.intValue());
        //总页数
        pageModel.setTotalPages((pageModel.getTotalRecord() % pageModel.getPageSize() ==0 ? pageModel.getTotalRecord() / pageModel.getPageSize() : pageModel.getTotalRecord() / pageModel.getPageSize() +1));
        ////从第几条记录开始查询
        pageModel.setStartRecord((pageModel.getCurrentPageCode()-1) * pageModel.getPageSize());
        itemImageExample.setOffset(pageModel.getStartRecord());
        itemImageExample.setLimit(pageModel.getPageSize());

        List<ItemImage> itemImageList = itemImageDao.selectByExample(itemImageExample);
        List<Map<String,Object>> imgList = new ArrayList<>();
        for (ItemImage itemImage:itemImageList){
            Image image = imageDao.selectByPrimaryKey(itemImage.getImageId());
            String path = image.getComprePath();

            Map<String,Object> map = new HashMap<>(2);
            map.put("imageId",image.getImageId());
            map.put("path",path);
            imgList.add(map);
        }
        pageModel.setModelList(imgList);

        Map<String,Object> map = new HashMap<>(6);
        map.put("totalRecord",pageModel.getTotalRecord());
        map.put("totalPages",pageModel.getTotalPages());
        map.put("pageSize",pageModel.getPageSize());
        map.put("currentPageCode",pageModel.getCurrentPageCode());
        map.put("startRecord",pageModel.getStartRecord());
        map.put("imgList",pageModel.getModelList());

        pageList.add(map);
        pageMap.put("pageModel",pageList);
        result= ServerResponse.createBySuccess("",pageMap);
        return result;
    }

    /**
     * 获得用户可以参加比赛的图片
     * @param custId 用户id
     * @param itemId 比赛id
     * @return 用户可以参加比赛的图片的路径和id
     */
    @Override
    public ServerResponse findMyImage(Integer custId, Integer itemId) {
        ItemImageExample itemImageExample = new ItemImageExample();
        itemImageExample.createCriteria().andItemIdEqualTo(itemId).andCustIdEqualTo(custId);
        ImageExample imageExample=new ImageExample();
        imageExample.createCriteria().andCustIdEqualTo(custId).andCategoryIdNotEqualTo(15);
        //获得用户所有已经参加比赛的作品id
        List<Integer> imageIdList = new ArrayList<>();
        List<ItemImage> itemImageList = itemImageDao.selectByExample(itemImageExample);
        for(ItemImage itemImage:itemImageList){
            Integer imageId = itemImage.getImageId();
            imageIdList.add(imageId);
        }
        //从用户的所有图片中筛选出未参加比赛的图片
        List<Image> imageList = imageDao.selectByExample(imageExample);
        Map<String,Object> myImage = new HashMap<>(1);
        List<Map<String,Object>> pathList = new ArrayList<>();
        for (Image image:imageList){
            Integer imageId = image.getImageId();
            if(!imageIdList.contains(imageId)){
                String path = image.getNocomprePath();
                Map<String,Object> map = new HashMap<>(2);
                map.put("path",path);
                map.put("imageId",imageId);
                pathList.add(map);
            }
        }
        myImage.put("myImageMap",pathList);
        result= ServerResponse.createBySuccess("",myImage);
        return result;
    }

    /**
     * 保存参加活动的图片信息
     * @param itemImage 活动图片信息
     * @return true:保存成功,false:保存失败
     */
    @Override
    public Boolean saveSelective(ItemImage itemImage) {
        int rows = itemImageDao.insertSelective(itemImage);
        if(rows!=0){
            return true;
        }else {
            return false;
        }
    }
}

