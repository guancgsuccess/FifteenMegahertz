package com.fm.service.impl;

import com.fm.dao.*;
import com.fm.entity.Community;
import com.fm.entity.CommunityMessage;
import com.fm.entity.Customer;
import com.fm.entity.Image;
import com.fm.service.CommunityMessageService;
import com.fm.util.community.FormatConversion;
import com.fm.util.community.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

/**
 * 社区信息Service层接口实现
 * YftPaper
 */
@Service
@SuppressWarnings("all")
public class CommunityMessageServiceImpl implements CommunityMessageService {

    @Autowired
    private CommunityMessageDao communityMessageDAO;
    @Autowired
    private CommunityCommentDao communityCommentDao;
    @Autowired
    private CommunityDao communityDao;
    @Autowired
    private CustomerDao customerDao;
    @Autowired
    private ImageDao imageDao;

    @Override
    public Map<String, Object> selectMessageByCustId(Page<CommunityMessage> page, Integer custId) {

        //页码信息model
        Map<String, Object> pageMap = new HashMap<>();

        //分页信息
        Integer count = communityMessageDAO.selectAllCountByCustId(custId);
        int remainder = count % page.getPageSize();
        int totalPages = count / page.getPageSize();
        Integer offset = (page.getCurrentPage() - 1) * page.getPageSize();
        Integer limit = page.getPageSize();

        page.setTotalRecord(count);
        page.setTotalPages(remainder > 0 ? totalPages + 1 : totalPages);
        page.setOffset(offset);

        //状态
        pageMap.put("status", 0);
        //当前页
        pageMap.put("currentPage", page.getCurrentPage());
        //总页
        pageMap.put("totalPages", page.getTotalPages());

        //是否第一页
        pageMap.put("isFirstPage", 0);
        //是否最后一页
        pageMap.put("isLastPage", 0);
        if (page.getCurrentPage() == 1)
            pageMap.put("isFirstPage", 1);
        if (page.getCurrentPage().equals(page.getTotalPages()))
            pageMap.put("isLastPage", 1);

        //条件map
        Map<String, Object> condition = new HashMap<>();
        condition.put("custId", custId);
        condition.put("offset", offset);
        condition.put("limit", limit);

        //查询数据库
        List<CommunityMessage> communityMessageList = communityMessageDAO.selectMyMessageByCustomerId(condition);

        //不是空
        if (0 != communityMessageList.size()) {
            pageMap.put("status", 1);

            List<Community> communityList = communityDao.selectCommunityByCommunityIds(communityMessageList);
            List<Map<String, Object>> communityMessageMaps = new ArrayList<>();

            for (CommunityMessage mess : communityMessageList) {

                Community community = null;
                for (Community comm : communityList) {
                    if (comm.getCommunityId().equals(mess.getCommunityId())) {
                        community = comm;
                        break;
                    }
                }

                Map<String, Object> map = new HashMap<>();
                map.put("commName", community.getCommunityName());
                map.put("messContent", mess.getMessageContent());
                map.put("messCreateTime", FormatConversion.dateToString
                        (mess.getMessageCreateTime(), FormatConversion.PATTERN_TWO));
                map.put("messStatus", mess.getMessageStatus());
                map.put("commId", mess.getCommunityId());
                communityMessageMaps.add(map);
            }
            pageMap.put("messageList", communityMessageMaps);
            return pageMap;
        }
        return null;
    }

    @Override
    public List<Map<String, Object>> selectMessageByContext(String context) {

        List<CommunityMessage> communityMessageList = communityMessageDAO.selectCommunityMessageByContext(context);
        if (0 == communityMessageList.size())
            return null;
        return tablesSelect(communityMessageList);
    }

    @Override
    public Map<String, Object> selectNCommunityMessage(Integer n) {

        Map<String, Object> pageMap = new HashMap<>();

        pageMap.put("status", 0);

        List<CommunityMessage> communityMessageList = communityMessageDAO.selectAllCommunityMessage(n);

        if (0 != communityMessageList.size()) {
            pageMap.put("status", 1);
            pageMap.put("messageList", tablesSelect(communityMessageList));
        }
        return pageMap;
    }

    @Override
    public Map<String, Object> selectMessageByCommunityId
            (Page<CommunityMessage> page, Integer commId, Integer custId) {

        //页码信息model
        Map<String, Object> pageMap = new HashMap<>();

        //分页信息
        Integer count = communityMessageDAO.selectAllCountByCommunityId(commId);
        int remainder = count % page.getPageSize();
        int totalPages = count / page.getPageSize();
        Integer offset = (page.getCurrentPage() - 1) * page.getPageSize();
        Integer limit = page.getPageSize();

        page.setTotalRecord(count);
        page.setTotalPages(remainder > 0 ? totalPages + 1 : totalPages);
        page.setOffset(offset);

        //状态
        pageMap.put("status", 0);
        //当前页
        pageMap.put("currentPage", page.getCurrentPage());
        //总页
        pageMap.put("totalPages", page.getTotalPages());

        //是否第一页
        pageMap.put("isFirstPage", 0);
        //是否最后一页
        pageMap.put("isLastPage", 0);
        if (page.getCurrentPage() == 1)
            pageMap.put("isFirstPage", 1);
        if (page.getCurrentPage().equals(page.getTotalPages()))
            pageMap.put("isLastPage", 1);

        //条件map
        Map<String, Object> condition = new HashMap<>();
        condition.put("communityId", commId);
        condition.put("offset", offset);
        condition.put("limit", limit);

        //查询数据库
        List<CommunityMessage> communityMessageList = communityMessageDAO
                .selectCommunityMessageByCondition(condition);

        //不是空
        if (0 != communityMessageList.size()) {
            pageMap.put("status", 1);

            List<Customer> customerList = customerDao.selectCustomerByCustomerIds(communityMessageList);
            List<Image> imageList = imageDao.selectImageByIds(communityMessageList);
            List<Map<String, Object>> communityMessageMaps = new ArrayList<>();

            for (CommunityMessage mess : communityMessageList) {

                Customer customer = null;
                for (Customer cust : customerList) {
                    if (cust.getCustId().equals(mess.getCustId())) {
                        customer = cust;
                        break;
                    }
                }
                Image image = null;
                for (Image img : imageList) {
                    if (img.getImageId().equals(mess.getImageId())) {
                        image = img;
                        break;
                    }
                }

                Map<String, Object> map = new HashMap<>();
                map.put("messId", mess.getMessageId());
                map.put("messImagePath", image == null ? null : image.getComprePath());
                map.put("messContent", mess.getMessageContent());
                map.put("custId", mess.getCustId());
                map.put("custProfile", customer.getCustProfile());
                map.put("custNick", customer.getCustNick());
                map.put("messCreateTime", FormatConversion.dateToString
                        (mess.getMessageCreateTime(), FormatConversion.PATTERN_TWO));
                map.put("isOperation", custId == null ? 0 :
                        (custId == communityDao.selectByPrimaryKey(commId).getCustId()
                                ? 1 : (custId) == mess.getCustId() ? 1 : 0));
                map.put("messCommentCount", communityCommentDao.selectCommentCountByMessageId(mess.getMessageId()));
                communityMessageMaps.add(map);
            }
            pageMap.put("messageList", communityMessageMaps);
            return pageMap;
        }
        return null;
    }

    @Override
    public Integer addCommunityMessage(Image image, CommunityMessage communityMessage) {

        if (image != null){
            Integer imageId = imageDao.insertReturnId(image);
            if (imageId != null){
                communityMessage.setImageId(image.getImageId());
            }
        }
        return communityMessageDAO.insertSelective(communityMessage);
    }

    @Override
    public Integer deleteCommunityMessage(Integer messageId) {

        Map<String, Object> condition = new HashMap<>();
        condition.put("messageId", messageId);
        condition.put("commentStatus", 0);
        communityCommentDao.updateCommentStatusByMessId(condition);

        CommunityMessage communityMessage = new CommunityMessage();
        communityMessage.setMessageId(messageId);
        communityMessage.setMessageStatus(0);
        return communityMessageDAO.updateByPrimaryKeySelective(communityMessage);
    }

    /**
     * 多表联合查询 查询其他表字段
     *
     * @param communityMessageList 主表字段
     * @return 查询完成并处理完成的集合
     */
    private List<Map<String, Object>> tablesSelect(List<CommunityMessage> communityMessageList) {

        List<Customer> customerList = customerDao.selectCustomerByCustomerIds(communityMessageList);
        List<Community> CommunityList = communityDao.selectCommunityByCommunityIds(communityMessageList);
        List<Image> imageList = imageDao.selectImageByIds(communityMessageList);
        List<Map<String, Object>> communityMessageMaps = new ArrayList<>();

        for (CommunityMessage mess : communityMessageList) {

            Customer customer = null;
            for (Customer cust : customerList) {
                if (cust.getCustId().equals(mess.getCustId())) {
                    customer = cust;
                    break;
                }
            }
            Community community = null;
            for (Community comm : CommunityList) {
                if (comm.getCommunityId().equals(mess.getCommunityId())) {
                    community = comm;
                    break;
                }
            }
            Image image = null;
            for (Image img : imageList) {
                if (img.getImageId().equals(mess.getImageId())) {
                    image = img;
                    break;
                }
            }

            Map<String, Object> map = new HashMap<>();
            map.put("messId", mess.getMessageId());
            map.put("messContent", mess.getMessageContent());
            map.put("messImagePath", image == null ? null : image.getComprePath());
            map.put("commId", mess.getCommunityId());
            map.put("commPhotoPath", community.getCommunityPhoto());
            map.put("commName", community.getCommunityName());
            map.put("custId", mess.getCustId());
            map.put("custNick", customer.getCustNick());
            map.put("messTime", FormatConversion.dateToString(mess.
                    getMessageCreateTime(), FormatConversion.PATTERN_ONE));
            communityMessageMaps.add(map);
        }

        return communityMessageMaps;
    }

    /**
     * 排序
     *
     * @param communityMessageList 被排序集合
     */
    private void listSort(List<CommunityMessage> communityMessageList) {

        communityMessageList.sort(new Comparator<CommunityMessage>() {
            @Override
            public int compare(CommunityMessage o1, CommunityMessage o2) {
                return o2.getMessageCreateTime().compareTo(o1.getMessageCreateTime());
            }
        });
    }
}
