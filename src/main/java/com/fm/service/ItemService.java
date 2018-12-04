package com.fm.service;

import com.fm.entity.common.ServerResponse;

/**
 * @author liuyuan
 */
public interface ItemService{
    /**
     * 获得所有比赛信息
     * @return 所有比赛信息
     */
    ServerResponse findAllItem();

    /**
     * 获得正在进行的比赛信息
     * @return 正在进行的比赛信息
     */
    ServerResponse findNowItem();

    /**
     * 获得已经结束的比赛信息
     * @return 已经结束的比赛信息
     */
    ServerResponse findEndItem();

    /**
     *根据活动id获得比赛信息
     * @param itemId 比赛id
     * @return 比赛信息
     */
    ServerResponse findItemDetail(Integer itemId);
}
