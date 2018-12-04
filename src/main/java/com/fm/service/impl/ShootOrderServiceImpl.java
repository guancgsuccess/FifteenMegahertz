package com.fm.service.impl;

import com.fm.dao.ShootDao;
import com.fm.dao.ShootOrderDao;
import com.fm.entity.Shoot;
import com.fm.entity.ShootOrder;
import com.fm.service.ShootOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class ShootOrderServiceImpl implements ShootOrderService {
    private final ShootOrderDao shootOrderDao;
    private final ShootDao shootDao;

    @Autowired
    public ShootOrderServiceImpl(ShootOrderDao shootOrderDao, ShootDao shootDao) {
        this.shootOrderDao = shootOrderDao;
        this.shootDao = shootDao;
    }

    @Override
    public Integer deleteById(Integer id) {
        return shootOrderDao.deleteByPrimaryKey(id);
    }

    @Override
    public Integer update(ShootOrder entity) {
        return shootOrderDao.updateByPrimaryKey(entity);
    }

    @Override
    public Integer save(ShootOrder entity) {
        return shootOrderDao.insert(entity);
    }

    @Override
    public List<ShootOrder> findAll() {
        return shootOrderDao.selectByExample(null);
    }

    @Override
    public ShootOrder findById(Integer id) {
        return shootOrderDao.selectByPrimaryKey(id);
    }

    /**
     * 根据用户Id获得所有订单
     * @param custId 用户Id
     * @return 返回查询到的所有订单
     */
    @Override
    public Map<String, Object> selectById(Integer custId) {
        Map<String,Object> map = new HashMap<>();
        List<ShootOrder> shootOrderList = shootOrderDao.selectById(custId);
        List<Object> list = new ArrayList<>();

        for (ShootOrder shootOrder:shootOrderList){
            Map<String,Object> map1 = new HashMap<>();
            Shoot shoot = shootDao.selectByPrimaryKey(shootOrder.getShootId());
            //订单创建时间
            map1.put("orderCreateTime",shootOrder.getOrderCreateTime());
            //订单Id
            map1.put("orderId",shootOrder.getOrderId());
            //套餐Id
            map1.put("shootId",shootOrder.getShootId());
            //套餐主题
            map1.put("shootDesc",shoot.getShootDesc());
            //拍摄时间
            map1.put("shootTime",shootOrder.getShootTime());
            //套餐价格
            map1.put("shootPrice",shoot.getShootPrice());
            //集合地点
            map1.put("shootLoc",shootOrder.getShootLoc());
            //订单状态
            map1.put("orderPay",shootOrder.getOrderPay());
            //联系电话
            map1.put("orderPhone",shootOrder.getOrderPhone());
            list.add(map1);
            map.put("orderList",list);
        }
        return map;
    }

    @Override
    public Integer getCount(Integer custId, Integer shootId) {
        return shootOrderDao.getCount(custId,shootId);
    }

    @Override
    public Integer deleteByCustIdAndOrderId(Integer custId, Integer orderId) {
        return shootOrderDao.deleteByCustIdAndOrderId(custId,orderId);
    }
    @Override
    public Integer updateOrderStatus(Integer orderId, Integer orderPay) {
        int result = shootOrderDao.updateOrderPayByOrderId(orderPay,orderId);
        return result;
    }
}
