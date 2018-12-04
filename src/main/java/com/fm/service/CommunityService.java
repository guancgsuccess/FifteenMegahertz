package com.fm.service;

import com.fm.entity.Community;
import com.fm.util.community.Page;

import java.util.List;
import java.util.Map;

/**
 * 社区Service层接口
 * YftPaper
 */
public interface CommunityService {

    /**
     * 查询名字是否存在
     * @param commName 社区名
     * @return 存在true
     */
    boolean selectCommunityNameByName(String commName);

    /**
     * 分页查询用户所拥有的社区
     * @param page 页码
     * @param custId 用户id
     * @return 查询所得集合
     */
    Map<String,Object> selectCommunityByCustId(Page<Community> page, Integer custId);

    /**
     * 根据信息id查询社区并比较该用户是否已经加入社区
     *
     * @param messId 信息id
     * @param custId 用户id
     * @return 查询所得值
     */
    Map<String, Object> selectCommunityByMessageId(String messId, Integer custId);

    /**
     * 根据社区id查询社区并比较该用户是否已经加入社区
     *
     * @param commId 社区id
     * @param custId 用户id
     * @return 查询所得值
     */
    Map<String, Object> selectCommunityById(String commId, Integer custId);

    /**
     * 分页查询全部社区
     *
     * @param page 页码
     * @return 查询所得
     */
    Map<String, Object> selectAllCommunityByPage(Page<Community> page);

    /**
     * 查询任何有关关键字的任何东西
     *
     * @param context 关键字
     * @return 查询所得
     */
    Map<String, Object> selectAnythingByContext(String context);

    /**
     * 查询最新几个社区
     *
     * @return 最新几个社区集合
     */
    Map<String, Object> selectCommunityByNew();

    /**
     * 根据类别查询社区
     *
     * @param categoryId 类别Id
     * @return 社区集合
     */
    List<Map<String, Object>> selectCommunityByCategoryId(Integer categoryId);

    /**
     * 根据关键字模糊查询社区
     *
     * @param context 关键字
     * @return 社区集合
     */
    List<Map<String, Object>> selectCommunityByContext(String context);

    /**
     * 添加社区
     *
     * @param community 社区实体信息
     * @return 是否成功
     */
    Integer addCommunity(Community community);

    /**
     * 修改社区信息
     *
     * @param community 社区实体信息
     * @return 是否成功
     */
    Integer updateCommunity(Community community);

    /**
     * 删除社区
     *
     * @param communityId 社区实体信息
     * @return 是否成功
     */
    Integer deleteCommunity(Integer communityId);
}
