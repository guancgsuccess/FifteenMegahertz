package com.fm.service;

/**
 * Created on 2018/10/16.
 *
 * @author guochangji
 */
public interface CustLikeService{

    /**
     * 查看是否点赞过
     * @param custId 用户ID
     * @param imageId 图片ID
     * @return true:代表已点赞,false:代表未点赞
     */
    public Boolean isLiked(Integer custId,Integer imageId);

    /**
     * 点赞
     * @param custId 用户ID
     * @param imageId 图片ID
     */
    public void doLike(Integer custId,Integer imageId) throws Exception;

    /**
     * 取消点赞
     * @param custId 用户ID
     * @param imageId 点赞的图片ID
     * @return 返回操作码
     */
    public void cancelLike(Integer custId,Integer imageId) throws Exception;
}
