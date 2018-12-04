package com.fm.service.impl;

import com.fm.dao.CommunityDao;
import com.fm.dao.CommunityMembersDao;
import com.fm.dao.CustomerDao;
import com.fm.entity.Community;
import com.fm.entity.CommunityMembers;
import com.fm.entity.CommunityMembersKey;
import com.fm.entity.Customer;
import com.fm.service.CommunityMembersService;
import com.fm.util.community.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 社区人员Service层接口实现
 * YftPaper
 */
@Service
@SuppressWarnings("all")
public class CommunityMembersServiceImpl implements CommunityMembersService {

    @Autowired
    private CommunityMembersDao communityMembersDAO;
    @Autowired
    private CommunityDao communityDao;
    @Autowired
    private CustomerDao customerDAO;

    @Override
    public Map<String, Object> selectCommunityByCustomerId(Integer customerId) {

        //返回集合
        Map<String, Object> custCommMap = new HashMap<>();
        custCommMap.put("status", 0);

        List<CommunityMembers> communityMembersList = communityMembersDAO.selectCommunityByCustomerId(customerId);
        if (0 != communityMembersList.size()) {
            custCommMap.put("status", 1);
            List<Community> communityList = communityDao.selectCommunityByCommunityIds(communityMembersList);
            List<Map<String, Object>> communityMaps = new ArrayList<>();
            for (Community c : communityList) {
                Map<String, Object> map = new HashMap<>();
                map.put("commId", c.getCommunityId());
                map.put("commName", c.getCommunityName());
                communityMaps.add(map);
            }
            custCommMap.put("communityList", communityMaps);
        }
        return custCommMap;
    }

    @Override
    public Map<String, Object> selectCustByCommunityId(Page<CommunityMembers> page, Integer commId) {

        Map<String, Object> pageMap = new HashMap<>();
        pageMap.put("status", 0);

        if (commId == null)
            return pageMap;

        Map<String, Object> condition = new HashMap<>();
        condition.put("communityId", commId);

        Integer count = communityMembersDAO.selectAllCountByCommunityId(condition);
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

        condition.put("offset", offset);
        condition.put("limit", limit);

        List<CommunityMembers> communityMembersList = communityMembersDAO.selectCommunityMemberByCommunityId(condition);

        if (0 != communityMembersList.size()) {

            pageMap.put("status", 1);
            List<Customer> customerList = customerDAO.selectCustomerByCustomerIds(communityMembersList);
            List<Map<String, Object>> communityMembersMaps = new ArrayList<>();

            for (CommunityMembers members : communityMembersList) {

                Customer customer = null;
                for (Customer cust : customerList) {
                    if (cust.getCustId().equals(members.getCustId())){
                        customer = cust;
                        break;
                    }
                }

                Map<String, Object> map = new HashMap<>();
                map.put("custNick", customer.getCustNick());
                map.put("custIntro", customer.getCustIntro());
                map.put("custStatus", members.getCustStatus());
                map.put("commId", members.getCommunityId());
                map.put("custId", members.getCustId());
                communityMembersMaps.add(map);
            }
            pageMap.put("membersList", communityMembersMaps);
        }
        return pageMap;
    }

    @Override
    public Integer addCommunityMembers(String commId, Integer custId) {

        CommunityMembers communityMembers = new CommunityMembers();
        communityMembers.setCommunityId(Integer.parseInt(commId));
        communityMembers.setCustId(custId);
        return communityMembersDAO.insertSelective(communityMembers);
    }

    @Override
    public Integer updateCommunityMembersStatus(CommunityMembers communityMembers) {

        return communityMembersDAO.updateByPrimaryKeySelective(communityMembers);
    }

    @Override
    public Integer deleteCommunityMembers(String commId, Integer custId) {

        CommunityMembersKey communityMembersKey = new CommunityMembersKey();
        communityMembersKey.setCommunityId(Integer.parseInt(commId));
        communityMembersKey.setCustId(custId);
        return communityMembersDAO.deleteByPrimaryKey(communityMembersKey);
    }
}
