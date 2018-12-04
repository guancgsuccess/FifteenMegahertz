package com.fm.service.impl;

import com.fm.dao.CustomerDao;
import com.fm.dao.ShootAppraiseDao;
import com.fm.entity.Customer;
import com.fm.entity.ShootAppraise;
import com.fm.entity.shoot.PageModel;
import com.fm.service.ShootAppraiseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class ShootAppraiseServiceImpl implements ShootAppraiseService {

    private final ShootAppraiseDao shootAppraiseDao;
    private final CustomerDao customerMapper;

    @Autowired
    public ShootAppraiseServiceImpl(ShootAppraiseDao shootAppraiseDao, CustomerDao customerMapper) {
        this.shootAppraiseDao = shootAppraiseDao;
        this.customerMapper = customerMapper;
    }

    @Override
    public Integer deleteById(Integer id) {
        return shootAppraiseDao.deleteByPrimaryKey(id);
    }

    @Override
    public Integer update(ShootAppraise entity) {
        return shootAppraiseDao.updateByPrimaryKey(entity);
    }

    @Override
    public Integer save(ShootAppraise entity) {
        return shootAppraiseDao.insert(entity);
    }

    @Override
    public List<ShootAppraise> findAll() {
        return shootAppraiseDao.selectByExample(null);
    }

    @Override
    public ShootAppraise findById(Integer id) {
        return shootAppraiseDao.selectByPrimaryKey(id);
    }

    @Override
    public List<ShootAppraise> selectById(Integer id) {
        return shootAppraiseDao.selectById(id);
    }

    @Override
    public Integer getCount(Integer id) {
        return shootAppraiseDao.getCount(id);
    }

    /**
     * 根据套餐Id获得当前页码的用户评价
     * @param pagecode 当前页码
     * @param shootId 套餐Id
     * @return 返回所有套餐
     */
    @Override
    public Map<String,Object> selectByPage(Integer pagecode,Integer shootId) {
        Map<String,Object> map = new HashMap<>();
        List<Object> list = new ArrayList<>();

        PageModel<ShootAppraise> page = new PageModel<>();
        if (pagecode==null){
            page.setCurrentPageCode(1);
        }else {
            page.setCurrentPageCode(pagecode);
        }
        page.setTotalRecord(shootAppraiseDao.getCount(shootId));
        page.setTotalPages(page.getTotalRecord()%page.getPageSize()==0?page.getTotalRecord()/page.getPageSize():page.getTotalRecord()/page.getPageSize()+1);
        page.setStartRecord((page.getCurrentPageCode()-1)*page.getPageSize());
        page.setModelList(shootAppraiseDao.selectByPage(page,shootId));

        for (ShootAppraise shootAppraise:page.getModelList()){
            Customer customer = customerMapper.selectByPrimaryKey(shootAppraise.getCustId());
            Map<String,Object> map1 = new HashMap<>();
            //用户名
            map1.put("custNick",customer.getCustNick());
            //用户头像
            map1.put("custProfile",customer.getCustProfile());
            list.add(map1);
        }
        map.put("page",page);
        map.put("appraiseList",list);

        return map;
    }
}
