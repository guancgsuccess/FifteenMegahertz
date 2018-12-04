package com.fm.dao;

import com.fm.entity.Community;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

/**
 * CommunityDao继承基类
 * YftPaper
 */
@Repository
public interface CommunityDao extends MyBatisBaseDao<Community, Integer> {

    /**
     * 根据社区名查询社区
     * @param commName 社区名字
     * @return 社区
     */
    Community selectCommunityNameByName(String commName);

    /**
     * 分页查询用户所拥有的社区
     *
     * @param condition 条件
     * @return 查询所得集合
     */
    List<Community> selectMyCommunityByCustId(Map<String, Object> condition);

    /**
     * 分页按社区人数倒序排序查询
     *
     * @param condition 条件
     * @return 查询所得集合
     */
    List<Community> selectAllCommunityByPage(Map<String, Object> condition);

    /**
     * 查询最新几个社区
     *
     * @param n 数量
     * @return 社区集合
     */
    List<Community> selectCommunityByNewN(Integer n);

    /**
     * 根据社区id集合查询社区集合
     *
     * @param communityIds 社区id集合
     * @return 社区集合
     */
    List<Community> selectCommunityByCommunityIds(List communityIds);

    /**
     * 根据社区类别查询社区
     *
     * @param id 社区类别id
     * @return 查询所得社区列表
     */
    List<Community> selectCommunityByCategoryId(Integer id);
    /**
     * 根据关键字模糊查询社区
     *
     * @param context 关键字
     * @return 社区列表
     */
    List<Community> selectCommunityByContext(String context);

    /**
     * 根据社区ID修改社区状态
     *
     * @param id 社区ID
     * @return 修改行记录
     */
    int updateCommunityByCommunityId(Integer id);

    /**
     * 查询用户所拥有的社区数量
     *
     * @param custId 用户id
     * @return 返回数量
     */
    int selectMyCommunityCountByCustId(Integer custId);

}