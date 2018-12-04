package com.fm.service;

import com.fm.entity.CommunityActivity;
import com.fm.entity.CommunityActivityKey;
import com.fm.util.community.Page;

import java.util.List;
import java.util.Map;

/**
 * 社区活动Service层接口
 * YftPaper
 */
public interface CommunityActivityService {

    /**
     * 根据社区活动主键查询活动信息
     *
     * @param communityActivityKey 主键包含 社区ID 和活动ID
     * @return 单个活动信息
     */
    CommunityActivity selectByPrimaryKey(CommunityActivityKey communityActivityKey);

    /**
     * 查询近两个月新建的活动信息
     *
     * @return 活动列表
     */
    List<CommunityActivity> selectCurrentTwoMonthNewCommActivity();

    /**
     * 按条件分页查询活动信息
     *
     * @param page     页码
     * @param underway 是否正在进行的活动
     * @return 对应条件活动列表
     */
    Map<String,Object> selectCommunityActivityByPage(Page<CommunityActivity> page, Integer underway);

    /**
     * 添加新的活动信息
     *
     * @param communityActivity 活动实体类
     * @return 成功返回1 反之0
     */
    Integer addCommunityActivity(CommunityActivity communityActivity);

    /**
     * 修改活动信息根据主键
     *
     * @param communityActivity 活动实体类
     * @return 成功返回1 反之0
     */
    Integer updateCommunityActivity(CommunityActivity communityActivity);

    /**
     * 根据主键删除活动信息
     *
     * @param communityActivityKey 活动主键信息实体
     * @return 成功返回1 反之0
     */
    Integer deleteCommunityActivity(CommunityActivityKey communityActivityKey);
}
