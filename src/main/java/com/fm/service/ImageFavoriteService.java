package com.fm.service;

import com.fm.util.PageModel;

/**
 * Created on 2018/10/16.
 *
 * @author guochangji
 */
public interface ImageFavoriteService {

    /**
     * 查询图片是否已被该用户收藏
     * @param imageId 图片ID
     * @param custId 用户ID
     * @return 返回true:已收藏,false:未收藏
     */
    public Boolean isCollected(Integer imageId,Integer custId);


    /**
     * 加入收藏夹
     * @param imageId 图片ID
     * @param custId 用户ID
     */
    public void addCollection(Integer imageId,Integer custId) throws Exception;

    /**
     * 移除收藏夹
     * @param imageId 图片ID
     * @param custId 用户ID
     */
    public void cancelCollect(Integer imageId,Integer custId) throws Exception;


    /**
     * 根据个人的收藏的分页查询
     * @param pageModel 分页类
     * @param custId 用户Id
     * @return 返回pagemodel
     */
    PageModel findLikesByPage(PageModel pageModel, Integer custId,Integer sessionCustId);
}
