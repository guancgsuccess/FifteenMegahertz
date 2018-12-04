package com.fm.service;

import com.fm.entity.CommunityBulletin;
import com.fm.util.community.Page;

import java.util.Map;

/**
 * 社区公告Service层接口
 * YftPaper
 */
public interface CommunityBulletinService {

    /**
     * 根据公告ID查询公告信息
     *
     * @param communityBulletinId 公告ID
     * @return 公告信息
     */
    Map<String, Object> selectByPrimaryKey(Integer communityBulletinId);

    /**
     * 按条件分页查询公告信息
     *
     * @param page 页数
     * @return 符合条件的公告信息列表
     */
    Map<String, Object> selectCommunityBulletinByPage(Page<CommunityBulletin> page);

    /**
     * 发布一条新的公告
     *
     * @param communityBulletin 公告实体类
     * @return 成功返回1 反之0
     */
    Integer addCommunityBulletin(CommunityBulletin communityBulletin);


    /**
     * 删除一条公告信息
     *
     * @param communityBulletinId 公告信息ID
     * @return 成功返回1 反之0
     */
    Integer deleteCommunityBulletin(Integer communityBulletinId);
}
