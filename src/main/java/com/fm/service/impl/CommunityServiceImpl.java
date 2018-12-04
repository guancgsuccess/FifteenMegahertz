package com.fm.service.impl;

import com.fm.dao.*;
import com.fm.entity.*;
import com.fm.service.CommunityService;
import com.fm.util.community.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 社区Service层接口实现
 * YftPaper
 */
@Service
@SuppressWarnings("all")
public class CommunityServiceImpl implements CommunityService {

    @Autowired
    private CommunityMessageDao communityMessageDao;
    @Autowired
    private CommunityMembersDao communityMembersDao;
    @Autowired
    private ImageCategoryDao imageCategoryDao;
    @Autowired
    private CommunityDao communityDao;
    @Autowired
    private CustomerDao customerDao;

    @Override
    public boolean selectCommunityNameByName(String commName) {
        if (communityDao.selectCommunityNameByName(commName) != null) {
            return true;
        }
        return false;
    }

    @Override
    public Map<String, Object> selectCommunityByCustId(Page<Community> page, Integer custId) {

        Map<String, Object> pageMap = new HashMap<>();
        pageMap.put("status", 0);

        if (custId == null)
            return pageMap;

        //查询总数
        Integer count = communityDao.selectMyCommunityCountByCustId(custId);
        int remainder = count % page.getPageSize();
        int totalPages = count / page.getPageSize();
        Integer offset = (page.getCurrentPage() - 1) * page.getPageSize();
        Integer limit = page.getPageSize();

        page.setTotalRecord(count);
        page.setTotalPages(remainder > 0 ? totalPages + 1 : totalPages);
        page.setOffset(offset);

        pageMap.put("currentPage", page.getCurrentPage());
        pageMap.put("totalPages", page.getTotalPages());

        pageMap.put("isFirstPage", 0);
        pageMap.put("isLastPage", 0);
        if (page.getCurrentPage() == 1)
            pageMap.put("isFirstPage", 1);
        if (page.getCurrentPage().equals(page.getTotalPages()))
            pageMap.put("isLastPage", 1);

        Map<String, Object> condition = new HashMap<>();
        condition.put("custId", custId);
        condition.put("offset", offset);
        condition.put("limit", limit);

        List<Community> communityList = communityDao.selectMyCommunityByCustId(condition);

        if (0 != communityList.size()) {

            pageMap.put("status", 1);
            List<Map<String, Object>> communityMaps = new ArrayList<>();

            for (Community comm : communityList) {
                Map<String, Object> map = new HashMap<>();
                map.put("commId", comm.getCommunityId());
                map.put("commName", comm.getCommunityName());
                communityMaps.add(map);
            }
            pageMap.put("communityList", communityMaps);
        }

        return pageMap;
    }

    @Override
    public Map<String, Object> selectCommunityByMessageId(String messId, Integer custId) {

        Integer messageId = Integer.parseInt(messId);

        Community community = communityDao.selectByPrimaryKey
                (communityMessageDao.selectByPrimaryKey(messageId).getCommunityId());

        if (community == null)
            return null;

        Map<String, Object> commMap = tablesOneSelect(community);

        if (custId != null) {
            commMap.put("isJoin", isJoin(community.getCommunityId(), custId));
        }
        return commMap;
    }

    @Override
    public Map<String, Object> selectCommunityById(String commId, Integer custId) {

        Integer communityId = Integer.parseInt(commId);
        Community community = communityDao.selectByPrimaryKey(communityId);

        if (community == null)
            return null;

        Map<String, Object> commMap = tablesOneSelect(community);

        if (custId != null) {
            commMap.put("isJoin", isJoin(communityId, custId));
        }
        return commMap;
    }

    @Override
    public Map<String, Object> selectAllCommunityByPage(Page<Community> page) {

        Map<String, Object> pageMap = new HashMap<>();

        //查询总数
        Integer count = communityDao.selectAllCount();
        int remainder = count % page.getPageSize();
        int totalPages = count / page.getPageSize();
        Integer offset = (page.getCurrentPage() - 1) * page.getPageSize();
        Integer limit = page.getPageSize();

        page.setTotalRecord(count);
        page.setTotalPages(remainder > 0 ? totalPages + 1 : totalPages);
        page.setOffset(offset);

        pageMap.put("status", 0);
        pageMap.put("currentPage", page.getCurrentPage());
        pageMap.put("totalPages", page.getTotalPages());

        pageMap.put("isFirstPage", 0);
        pageMap.put("isLastPage", 0);
        if (page.getCurrentPage() == 1)
            pageMap.put("isFirstPage", 1);
        if (page.getCurrentPage().equals(page.getTotalPages()))
            pageMap.put("isLastPage", 1);

        Map<String, Object> condition = new HashMap<>();
        condition.put("offset", offset);
        condition.put("limit", limit);

        List<Community> communityList = communityDao.selectAllCommunityByPage(condition);

        if (0 != communityList.size()) {
            pageMap.put("status", 1);
            pageMap.put("communityList", tablesSelect(communityList));
        }

        return pageMap;
    }

    @Override
    public Map<String, Object> selectAnythingByContext(String context) {

        //返回值集合
        Map<String, Object> searchMap = new HashMap<>();
        //集合初始状态
        searchMap.put("status", 0);

        //社区集合
        List<Community> communityList = communityDao.selectCommunityByContext(context);
        //社区信息集合
        List<CommunityMessage> communityMessageList = communityMessageDao.selectCommunityMessageByContext(context);

        //如果其中之一不为空
        if (0 != communityList.size() || 0 != communityMessageList.size()) {
            //改变状态
            searchMap.put("status", 1);

            //装入集合
            List<Map<String, Object>> searchMaps = new ArrayList<>();
            for (Community c : communityList) {
                Map<String, Object> map = new HashMap<>(2);
                map.put("commId", c.getCommunityId());
                map.put("commName", c.getCommunityName());
                searchMaps.add(map);
            }
            for (CommunityMessage cm : communityMessageList) {
                Map<String, Object> map = new HashMap<>(2);
                map.put("commMessId", cm.getMessageId());
                map.put("commMessContext", cm.getMessageContent());
                searchMaps.add(map);
            }
            searchMap.put("searchList", searchMaps);
        }
        return searchMap;
    }

    @Override
    public Map<String, Object> selectCommunityByNew() {

        Map<String, Object> commMap = new HashMap<>();
        //返回状态
        commMap.put("status", 0);

        List<Community> communityList = communityDao.selectCommunityByNewN(5);

        if (0 != communityList.size()) {
            commMap.put("status", 1);
            commMap.put("communityList", tablesSelect(communityList));
        }
        return commMap;
    }

    @Override
    public List<Map<String, Object>> selectCommunityByCategoryId(Integer categoryId) {

        List<Community> communityList = communityDao.selectCommunityByCategoryId(categoryId);

        //返回列表是否为空
        if (0 == communityList.size())
            return null;

        return tablesSelect(communityList);
    }

    @Override
    public List<Map<String, Object>> selectCommunityByContext(String context) {

        //查询
        List<Community> communityList = communityDao.selectCommunityByContext(context);

        //返回列表是否为空
        if (0 == communityList.size())
            return null;

        return tablesSelect(communityList);
    }

    @Override
    public Integer addCommunity(Community community) {

        return communityDao.insertSelective(community);
    }

    @Override
    public Integer updateCommunity(Community community) {

        return communityDao.updateByPrimaryKeySelective(community);
    }

    @Override
    public Integer deleteCommunity(Integer communityId) {

        return communityDao.updateCommunityByCommunityId(communityId);
    }

    /**
     * 判断是否存在与此社区
     *
     * @param communityId 社区id
     * @param custId      用户id
     * @return 是否存在
     */
    private int isJoin(Integer communityId, Integer custId) {

        CommunityMembersKey communityMembersKey = new CommunityMembersKey();
        communityMembersKey.setCommunityId(communityId);
        communityMembersKey.setCustId(custId);
        CommunityMembers communityMembers = communityMembersDao.selectByPrimaryKey(communityMembersKey);
        if (communityMembers != null) {
            if (communityMembers.getCustStatus() == 1)
                return 1;
            else
                return 2;
        }
        return 0;
    }

    /**
     * 多表联合查询单次
     *
     * @param community 主表实体
     * @return 封装完成
     */
    private Map<String, Object> tablesOneSelect(Community community) {

        Map<String, Object> commMap = new HashMap<>();
        commMap.put("isJoin", 0);
        commMap.put("commId", community.getCommunityId());
        commMap.put("commPhoto", community.getCommunityPhoto());
        commMap.put("commName", community.getCommunityName());
        commMap.put("commLabel", community.getCommunityLabel());
        commMap.put("categoryId", community.getCategoryId());
        commMap.put("categoryName", imageCategoryDao.selectByPrimaryKey
                (community.getCategoryId()).getCategoryName());
        commMap.put("custId", community.getCustId());
        commMap.put("custNick", customerDao.selectByPrimaryKey
                (community.getCustId()).getCustNick());
        Map<String, Object> condition = new HashMap<>();
        condition.put("custStatus", 1);
        condition.put("communityId", community.getCommunityId());
        commMap.put("commPeopleCount", communityMembersDao.selectAllCountByCommunityId(condition));
        commMap.put("commMessageCount", communityMessageDao.selectCommunityMessageCountByCommunityId
                (community.getCommunityId()));

        return commMap;
    }

    /**
     * 多表联合查询页面
     *
     * @param communityList 主表集合
     * @return 总和所得
     */
    private List<Map<String, Object>> tablesSelect(List<Community> communityList) {

        List<Customer> customerList = customerDao.selectCustomerByCustomerIds(communityList);
        List<ImageCategory> imageCategoryList = imageCategoryDao.selectCustomerByCategoryIds(communityList);
        Map<String, Object> condition = new HashMap<>();
        condition.put("custStatus", 1);

        //处理数据
        List<Map<String, Object>> communityMaps = new ArrayList<>();
        for (Community c : communityList) {

            Customer customer = null;
            for (Customer u : customerList) {
                if (u.getCustId().equals(c.getCustId())) {
                    customer = u;
                    break;
                }
            }
            ImageCategory category = null;
            for (ImageCategory i : imageCategoryList) {
                if (i.getCategoryId().equals(c.getCategoryId())) {
                    category = i;
                    break;
                }
            }

            Map<String, Object> map = new HashMap<>();
            map.put("commPhoto", c.getCommunityPhoto());
            map.put("commId", c.getCommunityId());
            map.put("commName", c.getCommunityName());
            map.put("custId", c.getCustId());
            map.put("custProfile", customer.getCustProfile());
            map.put("custNick", customer.getCustNick());
            map.put("commLabel", c.getCommunityLabel());
            map.put("categoryId", c.getCategoryId());
            map.put("categoryName", category.getCategoryName());
            condition.put("communityId", c.getCommunityId());
            map.put("commPeopleCount", communityMembersDao.selectAllCountByCommunityId(condition));
            communityMaps.add(map);
        }
        return communityMaps;
    }
}
