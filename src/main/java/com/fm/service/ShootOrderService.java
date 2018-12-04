package com.fm.service;

import com.fm.entity.ShootOrder;

import java.util.List;
import java.util.Map;

public interface ShootOrderService extends BaseService<ShootOrder> {
    @Override
    Integer deleteById(Integer id);

    @Override
    Integer update(ShootOrder entity);

    @Override
    Integer save(ShootOrder entity);

    @Override
    List<ShootOrder> findAll();

    @Override
    ShootOrder findById(Integer id);

    Map<String,Object> selectById(Integer custId);

    Integer getCount(Integer custId, Integer shootId);

    Integer deleteByCustIdAndOrderId(Integer custId, Integer orderId);
    Integer updateOrderStatus(Integer orderId,Integer orderPay);
}
