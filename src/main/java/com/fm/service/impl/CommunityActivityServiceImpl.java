package com.fm.service.impl;

import com.fm.dao.CommunityActivityDao;
import com.fm.entity.CommunityActivity;
import com.fm.entity.CommunityActivityKey;
import com.fm.service.CommunityActivityService;
import com.fm.util.community.Container;
import com.fm.util.community.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

/**
 * 社区活动Service层接口实现
 * YftPaper
 */
@Service
public class CommunityActivityServiceImpl implements CommunityActivityService {

    @Autowired
    private CommunityActivityDao communityActivityDAO;

    @Override
    public CommunityActivity selectByPrimaryKey(CommunityActivityKey communityActivityKey) {

        return communityActivityDAO.selectByPrimaryKey(communityActivityKey);
    }

    @Override
    public List<CommunityActivity> selectCurrentTwoMonthNewCommActivity() {

        List<CommunityActivity> communityActivityList = communityActivityDAO.selectCurrentTwoMonthNewCommActivity();
        //根据我规定规则排序
        listSort(communityActivityList);
        return communityActivityList;
    }

    @Override
    public Map<String, Object> selectCommunityActivityByPage(Page<CommunityActivity> page, Integer underway) {

        //条件map
        Map<String, Object> condition = new HashMap<>();
        //是否是正在进行
        condition.put("underway", 0);

        //获得总数
        Integer count = communityActivityDAO.selectActivityCountByEndTime(condition);
        //计算余数
        int remainder = count % page.getPageSize();
        //计算临时最大页数
        int totalPages = count / page.getPageSize();
        //计算从第几条记录开始
        Integer offset = (page.getCurrentPage() - 1) * page.getPageSize();
        //取几条数据
        Integer limit = page.getPageSize();

        //设置总记录数
        page.setTotalRecord(count);
        //计算最终总页数
        page.setTotalPages(remainder > 0 ? totalPages + 1 : totalPages);
        //设置开始记录数
        page.setOffset(offset);

        //条件添加
        condition.put("offset", offset);
        condition.put("limit", limit);

        //输出map能更好的转换成json
        Map<String, Object> pageMap = new HashMap<>();

        //状态
        pageMap.put("status", 0);
        //当前页
        pageMap.put("currentPage", page.getCurrentPage());
        //总页
        pageMap.put("totalPages", page.getTotalPages());

        //是否为首页
        pageMap.put("isFirstPage", 0);
        //是否为尾页
        pageMap.put("isLastPage", 0);
        //判断是否为首页
        if (page.getCurrentPage() == 1)
            pageMap.put("isFirstPage", 1);
        //判断是否为尾页
        if (page.getCurrentPage().equals(page.getTotalPages()))
            pageMap.put("isLastPage", 1);

        //查询所得活动集合
        List<CommunityActivity> communityActivityList = communityActivityDAO.selectCommActivityByPage(condition);
        //查询所得集合是否为空
        if (0 != communityActivityList.size()) {
            pageMap.put("status", 1);

            //将活动集合转换成k-v格式便于转成json
            List<Map<String, Object>> communityActivityMaps = new ArrayList<>();
            List<Map<String, Object>> communityUnderwayActivityMaps = new ArrayList<>();
            for (CommunityActivity ca : communityActivityList) {
                //每一个活动对象
                Map<String, Object> map = new HashMap<>();
                map.put("activityId", ca.getActivityId());
                map.put("activityName", ca.getActivityName());
                map.put("activityPart", ca.getActivityParticipate());
                map.put("activityDeadline", ca.getActivityCreateTime().compareTo(new Date()) > 0 ? -1
                        :(ca.getActivityEndTime().compareTo(new Date()) < 0 ? 0 : (ca
                        .getActivityEndTime().getTime() - System.currentTimeMillis()) / (24 * 60 * 60 * 1000) + 1));
                //当结束时间大于当前时间将记录
                if (ca.getActivityEndTime().compareTo(new Date()) > 0) {
                    //装入容器
                    Container.underwayActivityContainer(map);
                    communityUnderwayActivityMaps.add(map);
                }
                //装入容器
                Container.activityContainer(map);
                communityActivityMaps.add(map);
            }
            //结果集合装入map
            pageMap.put("activityList", communityActivityMaps);
            //如果为正在进行将返回正在进行时的
            if (1 == underway) {
                pageMap.put("activityList", communityUnderwayActivityMaps);
            }
        }

        //返回结果集
        return pageMap;
    }

    @Override
    public Integer addCommunityActivity(CommunityActivity communityActivity) {

        return communityActivityDAO.insertSelective(communityActivity);
    }

    @Override
    public Integer updateCommunityActivity(CommunityActivity communityActivity) {

        return communityActivityDAO.updateByPrimaryKeySelective(communityActivity);
    }

    @Override
    public Integer deleteCommunityActivity(CommunityActivityKey communityActivityKey) {

        return communityActivityDAO.deleteByPrimaryKey(communityActivityKey);
    }

    private void listSort(List<CommunityActivity> communityActivityList) {

        communityActivityList.sort(new Comparator<CommunityActivity>() {
            @Override
            public int compare(CommunityActivity o1, CommunityActivity o2) {
                return o2.getActivityEndTime().compareTo(o1.getActivityEndTime());
            }
        });
    }
}
