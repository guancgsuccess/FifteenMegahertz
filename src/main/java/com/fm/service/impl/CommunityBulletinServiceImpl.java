package com.fm.service.impl;

import com.fm.dao.CommunityBulletinDao;
import com.fm.dao.CustomerDao;
import com.fm.entity.CommunityBulletin;
import com.fm.service.CommunityBulletinService;
import com.fm.util.community.FormatConversion;
import com.fm.util.community.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

/**
 * 社区公告Service层接口实现
 * YftPaper
 */
@Service
@SuppressWarnings("all")
public class CommunityBulletinServiceImpl implements CommunityBulletinService {

    @Autowired
    private CommunityBulletinDao communityBulletinDAO;
    @Autowired
    private CustomerDao customerDao;

    @Override
    public Map<String, Object> selectByPrimaryKey(Integer communityBulletinId) {

        CommunityBulletin communityBulletin = communityBulletinDAO.selectByPrimaryKey(communityBulletinId);

        if (communityBulletin == null)
            return null;

        Map<String, Object> bulletinMap = new HashMap<>();
        bulletinMap.put("bullTitle", communityBulletin.getBulletinTitle());
        bulletinMap.put("bullContent", communityBulletin.getBulletinContent());
        bulletinMap.put("custId", communityBulletin.getCustId());
        bulletinMap.put("custNick", customerDao.selectByPrimaryKey
                (communityBulletin.getCustId()).getCustNick());
        bulletinMap.put("bullCreateTime", FormatConversion.dateToString
                (communityBulletin.getBulletinCreateTime(), FormatConversion.PATTERN_TWO));
        return bulletinMap;
    }

    @Override
    public Map<String, Object> selectCommunityBulletinByPage(Page<CommunityBulletin> page) {

        Map<String, Object> pageMap = new HashMap<>();

        //查询总数
        Integer count = communityBulletinDAO.selectAllCount();
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

        List<CommunityBulletin> communityBulletinList =
                communityBulletinDAO.selectCommunityBulletinByPage(condition);

        if (0 != communityBulletinList.size()) {
            pageMap.put("status", 1);
            List<Map<String, Object>> communityBulletinMaps = new ArrayList<>();
            for (CommunityBulletin cb : communityBulletinList) {
                Map<String, Object> map = new HashMap<>(3);
                map.put("bulletinId", cb.getBulletinId());
                map.put("bulletinTitle", cb.getBulletinTitle());
                map.put("bulletinTime", FormatConversion.dateToString(
                        cb.getBulletinCreateTime(), FormatConversion.PATTERN_ONE));
                communityBulletinMaps.add(map);
            }
            pageMap.put("bulletinList", communityBulletinMaps);
        }

        return pageMap;
    }

    @Override
    public Integer addCommunityBulletin(CommunityBulletin communityBulletin) {

        return communityBulletinDAO.insertSelective(communityBulletin);
    }


    @Override
    public Integer deleteCommunityBulletin(Integer communityBulletinId) {

        return communityBulletinDAO.deleteByPrimaryKey(communityBulletinId);
    }

    /**
     * 根据创建时间排序
     *
     * @param communityBulletinList 操作数组
     */
    private void listSort(List<CommunityBulletin> communityBulletinList) {

        communityBulletinList.sort(new Comparator<CommunityBulletin>() {
            @Override
            public int compare(CommunityBulletin o1, CommunityBulletin o2) {
                return o2.getBulletinCreateTime().compareTo(o1.getBulletinCreateTime());
            }
        });
    }
}
