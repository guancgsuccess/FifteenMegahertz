package com.fm.service.impl;

import com.fm.dao.ShootThemeDao;
import com.fm.entity.ShootTheme;
import com.fm.service.ShootThemeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class ShootThemeServiceImpl implements ShootThemeService {
    private final ShootThemeDao mapper;

    @Autowired
    public ShootThemeServiceImpl(ShootThemeDao mapper) {
        this.mapper = mapper;
    }

    @Override
    public Integer deleteById(Integer id) {
        return mapper.deleteByPrimaryKey(id);
    }

    @Override
    public Integer update(ShootTheme entity) {
        return mapper.updateByPrimaryKey(entity);
    }

    @Override
    public Integer save(ShootTheme entity) {
        return mapper.insert(entity);
    }

    @Override
    public List<ShootTheme> findAll() {
        return mapper.selectByExample(null);
    }

    @Override
    public ShootTheme findById(Integer id) {
        return mapper.selectByPrimaryKey(id);
    }

    /**
     * 获得所有套餐分类
     * @return 返回所有分类
     */
    @Override
    public Map<String, Object> selectAll() {
        List<ShootTheme> shootThemeList = mapper.selectByExample(null);
        Map<String, Object> map = new HashMap<>();
        List<Object> list = new ArrayList<>();

        for (ShootTheme shootTheme : shootThemeList) {
            Map<String, Object> map1 = new HashMap<>();
            //套餐分类名
            map1.put("shootThemeName", shootTheme.getThemeName());
            //套餐分类Id
            map1.put("shootThemeId", shootTheme.getThemeId());
            list.add(map1);
        }
        map.put("shootThemeList", list);
        return map;
    }


}