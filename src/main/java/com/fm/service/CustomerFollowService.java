package com.fm.service;

import com.fm.entity.CustFollow;
import com.fm.util.PageModel;

/**
 * Created on 2018/10/13.
 *
 * @author guochangji
 */
public interface CustomerFollowService extends BaseService<CustFollow> {

    /**
     * 查询粉丝数量
     * @param  custId 用户的ID
     * @return 返回Int类型的个数
     */
    public Integer findFollowCount(Integer custId);

    /**
     * 判断是否已关注
     * @param custId 用户ID1
     * @param authorId 用户ID2
     * @return true代表已关注,false代表未关注
     */
    public Boolean IsFollowed(Integer custId,Integer authorId);

    /**
     * 添加关注记录
     * @param custId 用户ID
     * @param authorId 被关注人ID
     * @return 返回是否成功关注
     */
    public Boolean addFollow(Integer custId,Integer authorId);

    /**
     * 取消关注
     * @param custId 用户ID
     * @param authorId 被关注人ID
     * @return 返回操作状态
     */
    public Boolean cancelFollow(Integer custId,Integer authorId);





    /**
     * 查询我的关注（偶像）
     * @param pageModel 分页类
     * @param followId 粉丝Id
     * @return 返回pageModel
     */
    PageModel findIdolsByPage(PageModel pageModel, Integer followId,Integer sessionCustId);


    /**
     * 查询我的追随者（粉丝）
     * @param pageModel 分页类
     * @param custId 偶像Id
     * @return 返回pageModel
     */
    PageModel findFollowByPage(PageModel pageModel,Integer custId,Integer sessionCustId);

}
