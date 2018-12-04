package com.fm.service;

import com.fm.entity.Shoot;
import com.fm.entity.shoot.PageModel;

import java.util.List;
import java.util.Map;

public interface ShootService extends BaseService<Shoot> {
    @Override
    Integer deleteById(Integer id);

    @Override
    Integer update(Shoot entity);

    @Override
    Integer save(Shoot entity);

    @Override
    List<Shoot> findAll();

    @Override
    Shoot findById(Integer id);

    List<Shoot> selectAllById(Integer shootThemeId);

    PageModel<Shoot> getAllByPage(Integer pagecode, PageModel<Shoot> page, Integer themeId);

    Integer getCount(Integer themeId);

    Integer getLocCount(String shootLoc);

    PageModel<Shoot> getAllByLoc(Integer pagecode, PageModel<Shoot> page, String shootLoc);

    Map<String,Object> selectById(Integer shootId);
}
