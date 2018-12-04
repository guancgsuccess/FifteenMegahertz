package com.fm.service.impl;

import com.fm.dao.ImageDao;
import com.fm.dao.ImageFavoriteDao;
import com.fm.entity.Image;
import com.fm.entity.ImageExample;
import com.fm.entity.ImageFavorite;
import com.fm.entity.ImageFavoriteExample;
import com.fm.service.ImageFavoriteService;
import com.fm.util.PageModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created on 2018/10/16.
 *
 * @author guochangji
 */
@Service
@SuppressWarnings("all")
public class ImageFavoriteServiceImpl implements ImageFavoriteService {
    @Autowired
    private ImageFavoriteDao imageFavoriteDao;
    @Autowired
    private ImageDao imageDao;

    /**
     * 判断是否收藏过
     * @param imageId 图片ID
     * @param custId 用户ID
     * @return
     */
    @Override
    public Boolean isCollected(Integer imageId, Integer custId) {
        ImageFavoriteExample imageFavoriteExample=new ImageFavoriteExample();
        imageFavoriteExample.createCriteria().andImageIdEqualTo(imageId).andCustIdEqualTo(custId);
        List<ImageFavorite> ifs=this.imageFavoriteDao.selectByExample(imageFavoriteExample);
        return ifs.size() != 0;
    }

    /**
     * 加入收藏夹
     * @param imageId 图片ID
     * @param custId 用户ID
     * @throws Exception
     */
    @Transactional(rollbackFor = Exception.class)
    @Override
    public void addCollection(Integer imageId, Integer custId) throws Exception {
        ImageFavorite imageFavorite=new ImageFavorite();
        imageFavorite.setCustId(custId);
        imageFavorite.setImageId(imageId);
        Image image=imageDao.selectByPrimaryKey(imageId);
        image.setImageCollections(image.getImageCollections()+1);
        try {
            this.imageFavoriteDao.insert(imageFavorite);
            this.imageDao.updateByPrimaryKey(image);
        }catch (Exception ignored){
            throw new Exception();
        }


    }

    /**
     *  取消收藏
     * @param imageId 图片ID
     * @param custId 用户ID
     * @throws Exception 回滚异常
     */
    @Transactional(rollbackFor = Exception.class)
    @Override
    public void cancelCollect(Integer imageId, Integer custId) throws Exception {
        ImageFavoriteExample imageFavoriteExample=new ImageFavoriteExample();
        imageFavoriteExample.createCriteria().andCustIdEqualTo(custId).andImageIdEqualTo(imageId);
        Image image=imageDao.selectByPrimaryKey(imageId);
        image.setImageCollections(image.getImageCollections()-1);
        try {
            this.imageFavoriteDao.deleteByExample(imageFavoriteExample);
            this.imageDao.updateByPrimaryKey(image);
        }catch (Exception ignored){
            throw new Exception();
        }
    }

    /**
     * 根据个人的收藏的分页查询
     * @param pageModel 分页类
     * @param custId 用户Id
     * @return 返回pagemodel
     */
    @Override
    public PageModel findLikesByPage(PageModel pageModel, Integer custId,Integer sessionCustId) {
        //根据用户id查询收藏的图片id
        ImageFavoriteExample favoriteExample=new ImageFavoriteExample();
        ImageFavoriteExample.Criteria criteria=favoriteExample.createCriteria();
        criteria.andCustIdEqualTo(custId);
        criteria.andFavoriteStatusEqualTo(1);

        List<ImageFavorite> imageFavoriteList=imageFavoriteDao.selectByExample(favoriteExample);

        List<Integer> imageIdList=new ArrayList<>();

        for (ImageFavorite image:imageFavoriteList){
            imageIdList.add(image.getImageId());
        }

        //根据图片id找出总共多少张收藏的
        ImageExample imageExample=new ImageExample();
        imageExample.createCriteria().andImageIdIn(imageIdList);
        imageExample.createCriteria().andImageStatusEqualTo(1);
        //总记录数
        Long total=imageDao.countByExample(imageExample);

        pageModel.setTotalRecord(total.intValue());
        //设置每页显示数量
        pageModel.setPageSize(30);
        //总页数
        pageModel.setTotalPages((pageModel.getTotalRecord() % pageModel.getPageSize()==0? pageModel.getTotalRecord()/pageModel.getPageSize():pageModel.getTotalRecord()/pageModel.getPageSize()+1));

        //从第几条记录开始显示
        pageModel.setStartRecord((pageModel.getCurrentPageCode()-1) * pageModel.getPageSize());

        imageExample.setOffset(pageModel.getStartRecord());
        //每页显示数量
        imageExample.setLimit(pageModel.getPageSize());
        List<Image> images=imageDao.selectByExample(imageExample);
        List<Map<String,Object>> imageInfo=new ArrayList<>();
        for (Image image:images){
            Map<String,Object> map=new HashMap<>();
            map.put("imageId",image.getImageId());
            map.put("imageCompressPath",image.getComprePath());
            if(sessionCustId!=null) {
                ImageFavoriteExample imageFavoriteExample = new ImageFavoriteExample();
                ImageFavoriteExample.Criteria criteria1=imageFavoriteExample.createCriteria();
                criteria1.andCustIdEqualTo(sessionCustId);
                criteria1.andImageIdEqualTo(image.getImageId());
                List<ImageFavorite> imageFavorites = imageFavoriteDao.selectByExample(imageFavoriteExample);
                if (imageFavorites != null && imageFavorites.size() > 0) {
                    map.put("isLike", 1);
                } else {
                    map.put("isLike", 0);
                }
            }else {
                map.put("isLike",2);
            }
            imageInfo.add(map);
        }
        //当前页显示记录对象集合
        pageModel.setModelList(imageInfo);
        return pageModel;

    }

}
