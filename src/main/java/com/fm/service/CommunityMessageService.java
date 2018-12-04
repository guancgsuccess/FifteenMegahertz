package com.fm.service;

import com.fm.entity.CommunityMessage;
import com.fm.entity.Image;
import com.fm.util.community.Page;

import java.util.List;
import java.util.Map;

/**
 * 社区信息Service层接口
 * YftPaper
 */
public interface CommunityMessageService {

    /**
     * 分页查询属于该用户id的信息
     *
     * @param page   页码
     * @param custId 用户id
     * @return 查询所得
     */
    Map<String, Object> selectMessageByCustId(Page<CommunityMessage> page, Integer custId);

    /**
     * 根据关键字模糊查询信息内容
     *
     * @param context
     * @return
     */
    List<Map<String, Object>> selectMessageByContext(String context);

    /**
     * 查询最新的N条信息
     *
     * @param n n条
     * @return 查询所得的信息集合
     */
    Map<String, Object> selectNCommunityMessage(Integer n);

    /**
     * 按条件分页查询社区信息
     *
     * @param page   页码
     * @param commId 社区id
     * @return 查询所得
     */
    Map<String, Object> selectMessageByCommunityId(Page<CommunityMessage> page, Integer commId, Integer custId);

    /**
     * 添加一条新的社区信息
     *
     * @param communityMessage 社区信息实体类
     * @return 成功返回1 反之0
     */
    Integer addCommunityMessage(Image image, CommunityMessage communityMessage);

    /**
     * 删除一条信息
     *
     * @param messageId 信息Id
     * @return 成功返回1 反之0
     */
    Integer deleteCommunityMessage(Integer messageId);
}