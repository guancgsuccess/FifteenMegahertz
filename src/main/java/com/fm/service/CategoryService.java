package com.fm.service;

import com.fm.entity.ImageCategory;

import java.util.List;
import java.util.Map;

/**
 * Created on 2018/10/7.
 *
 * @author guochangji
 */
public interface CategoryService extends BaseService<ImageCategory> {
    /**
     * 封装类别信息(ID,Name);
     * @return  List<Map<String,Object>>
     */
    public List<Map<String,Object>> findAllCategoryInfo();
}
