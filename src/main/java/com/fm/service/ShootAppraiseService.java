package com.fm.service;

import com.fm.entity.ShootAppraise;

import java.util.List;
import java.util.Map;

public interface ShootAppraiseService extends BaseService<ShootAppraise> {
    @Override
    Integer deleteById(Integer id);

    @Override
    Integer update(ShootAppraise entity);

    @Override
    Integer save(ShootAppraise entity);

    @Override
    List<ShootAppraise> findAll();

    List<ShootAppraise> selectById(Integer id);

    Integer getCount(Integer id);

    Map<String,Object> selectByPage(Integer pagecode, Integer shootId);
}
