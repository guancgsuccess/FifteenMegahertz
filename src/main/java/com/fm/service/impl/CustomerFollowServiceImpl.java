package com.fm.service.impl;

import com.fm.dao.CustFollowDao;
import com.fm.dao.CustomerDao;
import com.fm.dao.ImageDao;
import com.fm.entity.*;
import com.fm.service.CustomerFollowService;
import com.fm.util.PageModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServlet;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created on 2018/10/13.
 *
 * @author guochangji
 */
@Service
@SuppressWarnings("all")
public class CustomerFollowServiceImpl implements CustomerFollowService {

    @Autowired
    private CustFollowDao custFollowDao;

    @Autowired
    private CustomerDao customerDao;

    @Autowired
    private ImageDao imageDao;

    @Override
    public Integer deleteById(Integer id) {
        return null;
    }

    @Override
    public Integer update(CustFollow entity) {
        return null;
    }

    @Override
    public Integer save(CustFollow entity) {
        return null;
    }

    @Override
    public List<CustFollow> findAll() {
        return null;
    }

    @Override
    public CustFollow findById(Integer id) {
        return null;
    }

    @Override
    public Integer findFollowCount(Integer custId) {
        CustFollowExample custFollowExample=new CustFollowExample();
        custFollowExample.createCriteria().andCustIdEqualTo(custId);
        Long count=this.custFollowDao.countByExample(custFollowExample);
        return count.intValue();
    }

    @Override
    public Boolean IsFollowed(Integer custId, Integer authorId) {
        CustFollowExample custFollowExample=new CustFollowExample();
        custFollowExample.createCriteria().andFollowerIdEqualTo(custId);
        List<CustFollow> custFollows=this.custFollowDao.selectByExample(custFollowExample);
        for(CustFollow custFollow:custFollows){
            if(custFollow.getCustId().equals(authorId)){
                return true;
            }
        }
        return false;
    }

    @Override
    public Boolean addFollow(Integer custId, Integer authorId) {
        CustFollow custFollow=new CustFollow();
        custFollow.setFollowerId(custId);
        custFollow.setCustId(authorId);
        Integer result=this.custFollowDao.insert(custFollow);
        return result != 0;
    }

    @Override
    public Boolean cancelFollow(Integer custId, Integer authorId) {
        CustFollowExample custFollowExample=new CustFollowExample();
        custFollowExample.createCriteria().andFollowerIdEqualTo(custId).andCustIdEqualTo(authorId);
        Integer result=this.custFollowDao.deleteByExample(custFollowExample);
        return result != 0;
    }




    /**
     * 查询我的关注（偶像）
     * @param pageModel 分页类
     * @param followId 粉丝Id
     * @return 返回pageModel
     */
    @Override
    public PageModel findIdolsByPage(PageModel pageModel, Integer followId,Integer sessionCustId) {

        CustFollowExample custFollowExample = new CustFollowExample();
        custFollowExample.createCriteria().andFollowerIdEqualTo(followId);
        List<CustFollow> custFollowList = custFollowDao.selectByExample(custFollowExample);

        //总记录数
        pageModel.setTotalRecord(custFollowList.size());

        //每页显示记录数
        pageModel.setPageSize(5);
        //总页数
        pageModel.setTotalPages((pageModel.getTotalRecord() % pageModel.getPageSize() == 0 ? pageModel.getTotalRecord() / pageModel.getPageSize() : pageModel.getTotalRecord() / pageModel.getPageSize() + 1));
        //从第几条记录开始显示
        pageModel.setStartRecord((pageModel.getCurrentPageCode() - 1) * pageModel.getPageSize());

        //根据粉丝id查找所有关注的用户id
        List<Integer> custIds = new ArrayList<>();
        for (CustFollow custFollow : custFollowList) {
            custIds.add(custFollow.getCustId());
        }

        //查找出所有关注的信息
        CustomerExample customerExample = new CustomerExample();
        customerExample.createCriteria().andCustIdIn(custIds);
        customerExample.setOffset(pageModel.getStartRecord());
        customerExample.setLimit(pageModel.getPageSize());
        List<Customer> customers = customerDao.selectByExample(customerExample);

        List<Map<String, Object>> info = new ArrayList<>();
        //查找所有偶像的信息
        for (Customer customer : customers) {
            //查找所有偶像的图片信息，只取前三张
            ImageExample imageExample = new ImageExample();
            imageExample.createCriteria().andCustIdEqualTo(customer.getCustId()).andCategoryIdNotEqualTo(15);
            imageExample.setLimit(3);
            List<Image> images = imageDao.selectByExample(imageExample);
            Map<String, Object> map = new HashMap<>();
            map.put("custId", customer.getCustId());
            map.put("custNick", customer.getCustNick());
            map.put("custIntro", customer.getCustIntro());
            map.put("custProfile", customer.getCustProfile());
            map.put("images",images);

            if(sessionCustId!=null){
                CustFollowExample followExample=new CustFollowExample();
                CustFollowExample.Criteria criteria=followExample.createCriteria();
                criteria.andCustIdEqualTo(customer.getCustId());
                criteria.andFollowerIdEqualTo(sessionCustId);
                List<CustFollow> custFollows=custFollowDao.selectByExample(followExample);
                if(custFollows!=null && custFollows.size()>0 ){
                    map.put("isFollow",1);
                }else {
                    map.put("isFollow",0);
                }
            }else{
                map.put("isFollow",2);
            }
            info.add(map);
        }
        pageModel.setModelList(info);
        return pageModel;
    }



    /**
     * 查询我的追随者（粉丝）
     * @param pageModel 分页类
     * @param custId 偶像Id
     * @return 返回pageModel
     */
    @Override
    public PageModel findFollowByPage(PageModel pageModel, Integer custId,Integer sessionCustId) {
        CustFollowExample custFollowExample = new CustFollowExample();
        custFollowExample.createCriteria().andCustIdEqualTo(custId);
        List<CustFollow> custFollowList = custFollowDao.selectByExample(custFollowExample);
        //总记录数
        pageModel.setTotalRecord(custFollowList.size());
        //每页显示记录数
        pageModel.setPageSize(5);
        //总页数
        pageModel.setTotalPages((pageModel.getTotalRecord() % pageModel.getPageSize() == 0 ? pageModel.getTotalRecord() / pageModel.getPageSize() : pageModel.getTotalRecord() / pageModel.getPageSize() + 1));
        //从第几条记录开始显示
        pageModel.setStartRecord((pageModel.getCurrentPageCode() - 1) * pageModel.getPageSize());

        //根据关注id查找所有粉丝的用户id
        List<Integer> followerIds = new ArrayList<>();
        for (CustFollow custFollow : custFollowList) {
            followerIds.add(custFollow.getFollowerId());
        }
        //查找出所有追随者的信息
        CustomerExample customerExample = new CustomerExample();
        customerExample.createCriteria().andCustIdIn(followerIds);
        customerExample.setOffset(pageModel.getStartRecord());
        customerExample.setLimit(pageModel.getPageSize());
        List<Customer> customers = customerDao.selectByExample(customerExample);

        List<Map<String, Object>> info = new ArrayList<>();
        //查找所有粉丝的信息
        for (Customer customer : customers) {
            //查找所有粉丝的图片信息，只取前三张
            ImageExample imageExample = new ImageExample();
            imageExample.createCriteria().andCustIdEqualTo(customer.getCustId()).andCategoryIdNotEqualTo(15);
            imageExample.setLimit(3);
            List<Image> images = imageDao.selectByExample(imageExample);
            Map<String, Object> map = new HashMap<>();
            map.put("custId", customer.getCustId());
            map.put("custNick", customer.getCustNick());
            map.put("custIntro", customer.getCustIntro());
            map.put("custProfile", customer.getCustProfile());
            map.put("images",images);
            if(sessionCustId!=null){
                CustFollowExample followExample=new CustFollowExample();
                CustFollowExample.Criteria criteria=followExample.createCriteria();
                criteria.andCustIdEqualTo(customer.getCustId());
                criteria.andFollowerIdEqualTo(sessionCustId);
                List<CustFollow> custFollows=custFollowDao.selectByExample(followExample);
                if(custFollows!=null && custFollows.size()>0){
                    map.put("isFollow",1);
                }else {
                    map.put("isFollow",0);
                }
            }else{
                map.put("isFollow",2);
            }
            info.add(map);
        }
        pageModel.setModelList(info);
        return pageModel;
    }
}
