package com.fm.dao;

import com.fm.entity.CommunityBulletin;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

/**
 * CommunityBulletinDao继承基类
 * YftPaper
 */
@Repository
public interface CommunityBulletinDao extends MyBatisBaseDao<CommunityBulletin, Integer> {

    /**
     * 查询近一个月的公告情况
     *
     * @return 查询所得到的公告列表
     */
    List<CommunityBulletin> selectCurrentOneMonthNewCommBulletin();

    /**
     * 分页按条件查询公告
     *
     * @param condition 包含开始记录数 结束记录数 需要查询的日期
     * @return 查询所得到的公告列表
     */
    List<CommunityBulletin> selectCommunityBulletinByPage(Map<String, Object> condition);
}