package com.fm.service;

import com.fm.entity.ItemImage;
import com.fm.entity.common.ServerResponse;

/**
 * @author liuyuan
 */
public interface ItemImageService{
    /**
     * 获得当前比赛当前页码作者信息
     * @param currentPage 当前页码
     * @param itemId 活动id
     * @param custId 用户id
     * @return 当前页码作者的详细信息
     */
    ServerResponse findAuthorPage(Integer currentPage, Integer itemId, Integer custId);

    /**
     * 获得当前比赛当前页码图片信息
     * @param currentPage 当前页码
     * @param itemId 活动id
     * @return 当前页码图片的详细信息
     */
    ServerResponse findImagePage(Integer currentPage, Integer itemId);

    /**
     * 获得用户可以参加比赛的图片
     * @param custId 用户id
     * @param itemId 比赛id
     * @return 用户可以参加比赛的图片的路径和id
     */
    ServerResponse findMyImage(Integer custId, Integer itemId);

    /**
     * 保存参加比赛的图片信息
     * @param itemImage 比赛图片信息
     * @return true:保存成功,false:保存失败
     */
    Boolean saveSelective(ItemImage itemImage);
}
