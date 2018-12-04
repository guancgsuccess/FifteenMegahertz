package com.fm.service;

import com.fm.entity.ImageComment;

import java.util.List;
import java.util.Map;

/**
 * Created on 2018/10/7.
 *
 * @author guochangji
 */
public interface ImageCommentService extends BaseService<ImageComment> {

    /**
     * 根据图片ID查询图片下所有评论
     * @param imageId 图片ID
     * @return 评论集合
     */
    public List<ImageComment> findByImageId(Integer imageId);

    /**
     * 根据该图片下评论条数
     * @param imageId 图片ID
     * @return 返回评论数
     */
    public Integer findImageCommentCount(Integer imageId);

    /**
     * 添加评论
     * @param comment 评论内容
     * @param custId 评论人ID
     * @param authorId 被评论人ID
     * @param imageId 图片ID
     */
    public boolean addImageComment(String comment,Integer custId,Integer authorId,Integer imageId);

    /**
     * 查询并封装评论信息
     * @param imageId 图片ID
     * @return 返回封装的List对象
     */
    List<Map<String,Object>> findCommentInfo(Integer imageId);
}
