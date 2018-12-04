package com.fm.dao;

import com.fm.entity.CommunityMessage;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

/**
 * CommunityMessageDao继承基类
 * YftPaper
 */
@Repository
public interface CommunityMessageDao extends MyBatisBaseDao<CommunityMessage, Integer> {

    /**
     * 查询社区的留言数量
     *
     * @param communityId 社区id
     * @return 留言数量
     */
    int selectCommunityMessageCountByCommunityId(Integer communityId);

    /**
     * 根据内容大概查询信息
     *
     * @param context 内容大概
     * @return 信息集合
     */
    List<CommunityMessage> selectCommunityMessageByContext(String context);

    /**
     * 查询N条最新社区信息
     *
     * @param n 数量
     * @return 社区信息集合
     */
    List<CommunityMessage> selectAllCommunityMessage(Integer n);

    /**
     * 根据用户id分页查询其所发信息
     *
     * @param condition 条件
     * @return 查询所得集合
     */
    List<CommunityMessage> selectMyMessageByCustomerId(Map<String, Object> condition);

    /**
     * 分页根据条件
     * 条件包含(offset,limit,communityId(社区id))
     * 查询 该用户所发的信息
     *
     * @param condition 条件信息
     * @return 查询所得信息集合
     */
    List<CommunityMessage> selectCommunityMessageByCondition(Map<String, Object> condition);

    /**
     * 查询该社区ID内的信息总数
     *
     * @param communityId 社区ID
     * @return 信息总数
     */
    int selectAllCountByCommunityId(Integer communityId);

    /**
     * 查询该用户id的信息总数
     *
     * @param custId 用户id
     * @return 信息数量
     */
    int selectAllCountByCustId(Integer custId);
}