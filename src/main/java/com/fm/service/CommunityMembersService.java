package com.fm.service;

import com.fm.entity.CommunityMembers;
import com.fm.util.community.Page;

import java.util.Map;

/**
 * 社区人员Service层接口
 * YftPaper
 */
public interface CommunityMembersService {

    /**
     * 根据用户id查询其所在社区集合
     *
     * @param customerId 用户id
     * @return 社区集合
     */
    Map<String, Object> selectCommunityByCustomerId(Integer customerId);

    /**
     * 根据社区id分页查询社区人员
     *
     * @param page   页码
     * @param commId 社区ID
     * @return 社区人员列表
     */
    Map<String, Object> selectCustByCommunityId(Page<CommunityMembers> page, Integer commId);

    /**
     * 进入社区
     *
     * @param commId 社区id
     * @param custId 用户id
     * @return 成功返回1 反之0
     */
    Integer addCommunityMembers(String commId, Integer custId);

    /**
     * 修改社区人员状态
     *
     * @param communityMembers 社区人员实体
     * @return 成功返回1 反之0
     */
    Integer updateCommunityMembersStatus(CommunityMembers communityMembers);

    /**
     * 退出社区
     *
     * @param commId 社区id
     * @param custId 用户id
     * @return 成功返回1
     */
    Integer deleteCommunityMembers(String commId, Integer custId);
}
