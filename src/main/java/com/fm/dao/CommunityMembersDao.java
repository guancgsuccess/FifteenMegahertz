package com.fm.dao;

import com.fm.entity.CommunityMembers;
import com.fm.entity.CommunityMembersKey;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

/**
 * CommunityMembersDao继承基类
 * YftPaper
 */
@Repository
public interface CommunityMembersDao extends MyBatisBaseDao<CommunityMembers, CommunityMembersKey> {

    /**
     * 根据用户id查询所有社区id
     *
     * @param customerId 用户id
     * @return 社区人员集合
     */
    List<CommunityMembers> selectCommunityByCustomerId(Integer customerId);

    /**
     * 分页查询查询每个社区全部人数
     *
     * @param condition 包含 第几条记录开始 到第几条记录数 社区id 用户状态
     * @return 社区人员集合
     */
    List<CommunityMembers> selectCommunityMemberByCommunityId(Map<String, Object> condition);


    /**
     * 按用户状态查询该社区ID内的人员总数
     *
     * @param condition 社区ID 用户状态
     * @return 人员总数
     */
    int selectAllCountByCommunityId(Map<String, Object> condition);
}