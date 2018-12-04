package com.fm.service;

import com.fm.entity.ShootTheme;

import java.util.List;
import java.util.Map;

public interface ShootThemeService extends BaseService<ShootTheme> {
    @Override
    Integer deleteById(Integer id);

    @Override
    Integer update(ShootTheme entity);

    @Override
    Integer save(ShootTheme entity);

    @Override
    List<ShootTheme> findAll();

    @Override
    ShootTheme findById(Integer id);

    Map<String,Object> selectAll();
}
