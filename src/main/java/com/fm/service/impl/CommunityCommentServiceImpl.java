package com.fm.service.impl;

import com.fm.dao.CommunityCommentDao;
import com.fm.dao.CustomerDao;
import com.fm.entity.CommunityComment;
import com.fm.entity.Customer;
import com.fm.service.CommunityCommentService;
import com.fm.util.community.FormatConversion;
import com.fm.util.community.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 社区信息评论Service层接口实现
 * YftPaper
 */
@Service
@SuppressWarnings("all")
public class CommunityCommentServiceImpl implements CommunityCommentService {

    @Autowired
    private CommunityCommentDao communityCommentDAO;
    @Autowired
    private CustomerDao customerDao;

    @Override
    public Integer selectCommunityCommentCountByMessageId(Integer messageId) {

        return communityCommentDAO.selectCommentCountByMessageId(messageId);
    }

    @Override
    public Map<String, Object> selectCommentByMessageId(Page<CommunityComment> page, Integer messageId) {

        //页码信息model
        Map<String, Object> pageMap = new HashMap<>();

        //分页信息
        Integer count = communityCommentDAO.selectCommentCountByMessageId(messageId);
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
        condition.put("messageId", messageId);
        condition.put("offset", offset);
        condition.put("limit", limit);

        //查询数据库
        List<CommunityComment> communityCommentList = communityCommentDAO.selectCommentByMessageId(condition);
        List<CommunityComment> allCommunityCommentList = communityCommentDAO.selectAllCommentByMessageId(messageId);
        //不是空
        if (0 != communityCommentList.size()) {
            pageMap.put("status", 1);

            List<Customer> customerList = customerDao.selectCustomerByCustomerIds(allCommunityCommentList);
            List<Map<String, Object>> communityCommentMaps = new ArrayList<>();

            for (CommunityComment comment : communityCommentList) {

                Customer customer = null;
                for (Customer cust : customerList) {
                    if (cust.getCustId().equals(comment.getCustId())) {
                        customer = cust;
                        break;
                    }
                }

                CommunityComment superCommunity = null;
                Customer superCustomer = null;
                if (comment.getSuperCommentId() != null) {

                    for (CommunityComment com : allCommunityCommentList) {
                        if (comment.getSuperCommentId().equals(com.getCommentId())) {
                            superCommunity = com;
                            break;
                        }
                    }
                    for (Customer cust : customerList) {
                        if (cust.getCustId().equals(superCommunity.getCustId())) {
                            superCustomer = cust;
                            break;
                        }
                    }
                }

                Map<String, Object> map = new HashMap<>();
                map.put("commentId", comment.getCommentId());
                map.put("custId", comment.getCustId());
                map.put("custProfile", customer.getCustProfile());
                map.put("custNick", customer.getCustNick());
                map.put("superCustId", superCustomer == null ? null : superCustomer.getCustId());
                map.put("superCustNick", superCustomer == null ? null : superCustomer.getCustNick());
                map.put("commentContent", comment.getCommentContent());
                map.put("commentContentCreateTime", FormatConversion.dateToString
                        (comment.getCommentCreateTime(), FormatConversion.PATTERN_TWO));
                communityCommentMaps.add(map);
            }
            pageMap.put("commentList", communityCommentMaps);
            return pageMap;
        }
        return null;
    }

    @Override
    public CommunityComment selectCommunityCommentByCommentId(Integer commentId) {

        return communityCommentDAO.selectByPrimaryKey(commentId);
    }

    @Override
    public Integer addCommunityComment(CommunityComment communityComment) {

        return communityCommentDAO.insertSelective(communityComment);
    }

    @Override
    public Integer deleteCommunityComment(Integer commentId) {

        //查询下级回复
        List<CommunityComment> communityCommentList = communityCommentDAO.selectCommentBySuperCommentId(commentId);

        //下级回复为空直接删除
        if (communityCommentList.size() == 0) {
            return communityCommentDAO.deleteByPrimaryKey(commentId);
        }
        deleteSubCommunityComment(communityCommentList);
        return communityCommentDAO.deleteByPrimaryKey(commentId);
    }

    /**
     * 递归删除衍生评论
     *
     * @param communityCommentList 衍生评论列表
     */
    private void deleteSubCommunityComment(List<CommunityComment> communityCommentList) {

        for (CommunityComment communityComment : communityCommentList) {
            List<CommunityComment> communityCommentNewList = communityCommentDAO.selectCommentBySuperCommentId(communityComment.getCommentId());
            if (communityCommentNewList.size() != 0) {
                deleteSubCommunityComment(communityCommentNewList);
            }
            communityCommentDAO.deleteByPrimaryKey(communityComment.getCommentId());
        }
    }
}
