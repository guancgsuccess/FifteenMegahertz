package com.fm.dao;

import com.fm.entity.CommunityActivity;
import com.fm.entity.CommunityActivityKey;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

/**
 * CommunityActivityDao继承基类
 * YftPaper
 */
@Repository
public interface CommunityActivityDao extends MyBatisBaseDao<CommunityActivity, CommunityActivityKey> {

    /**
     * 查询活动数量 或 正在进行活动数量
     *
     * @param condition =1正在进行 反之不是
     * @return 按条件所查得到数
     */
    int selectActivityCountByEndTime(Map<String, Object> condition);

    /**
     * 查询近两月的新建的活动
     *
     * @return 进两月新建活动列表
     */
    List<CommunityActivity> selectCurrentTwoMonthNewCommActivity();

    /**
     * 分页查询活动
     *
     * @param condition 条件包含 开始记录数 结束记录数 正在进行活动
     * @return 活动列表
     */
    List<CommunityActivity> selectCommActivityByPage(Map<String, Object> condition);
}