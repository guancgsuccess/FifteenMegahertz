package com.fm.service;

import com.fm.entity.CommunityComment;
import com.fm.util.community.Page;

import java.util.Map;

/**
 * 社区信息评论Service层接口
 * YftPaper
 */
public interface CommunityCommentService {

    /**
     * 查询某条信息的评论数
     *
     * @param messageId 信息ID
     * @return 评论数
     */
    Integer selectCommunityCommentCountByMessageId(Integer messageId);

    /**
     * 分页查询某条信息的评论
     *
     * @param page      页码
     * @param messageId 信息ID
     * @return 以装载评论的分页模型
     */
    Map<String, Object> selectCommentByMessageId(Page<CommunityComment> page, Integer messageId);

    /**
     * 根据评论Id查询该条评论
     *
     * @param commentId 评论ID
     * @return 评论信息实体
     */
    CommunityComment selectCommunityCommentByCommentId(Integer commentId);

    /**
     * 添加新的评论
     *
     * @param communityComment 评论实体类
     * @return 成功返回1 反之0
     */
    Integer addCommunityComment(CommunityComment communityComment);

    /**
     * 删除评论 会删除该条评论的衍生评论
     *
     * @param commentId 评论id
     * @return 成功返回1 反之0
     */
    Integer deleteCommunityComment(Integer commentId);
}
