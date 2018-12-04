package com.fm.dao;

import com.fm.entity.CommunityComment;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

/**
 * CommunityCommentDao继承基类
 * YftPaper
 */
@Repository
public interface CommunityCommentDao extends MyBatisBaseDao<CommunityComment, Integer> {

    /**
     * 查询某条信息的评论数量
     *
     * @param condition 信息ID 状态码
     * @return 该条信息评论数量
     */
    int updateCommentStatusByMessId(Map<String, Object> condition);

    /**
     * 查询某条信息的评论数量
     *
     * @param messageId 信息ID
     * @return 该条信息评论数量
     */
    int selectCommentCountByMessageId(Integer messageId);

    /**
     * 查询某条信息的评论信息
     *
     * @param messageId 信息ID
     * @return 评论信息列表
     */
    List<CommunityComment> selectAllCommentByMessageId(Integer messageId);

    /**
     * 分页查询某条信息的评论信息
     *
     * @param condition 条件包含 从第几条开始 到第几条结束 信息ID
     * @return 评论信息列表
     */
    List<CommunityComment> selectCommentByMessageId(Map<String, Object> condition);

    /**
     * 查询某条评论的衍生评论
     *
     * @param superCommentId 某条评论ID
     * @return 衍生评论列表
     */
    List<CommunityComment> selectCommentBySuperCommentId(Integer superCommentId);
}