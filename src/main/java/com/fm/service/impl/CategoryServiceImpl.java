package com.fm.service.impl;

import com.fm.dao.ImageCategoryDao;
import com.fm.entity.ImageCategory;
import com.fm.entity.ImageCategoryExample;
import com.fm.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created on 2018/10/7.
 *
 * @author guochangji
 */
@Service
public class CategoryServiceImpl implements CategoryService {

    @Autowired
    private ImageCategoryDao imageCategoryDao;
    @Override
    public Integer deleteById(Integer id) {
        return null;
    }

    @Override
    public Integer update(ImageCategory entity) {
        return null;
    }

    @Override
    public Integer save(ImageCategory entity) {
        return null;
    }

    @Override
    public List<ImageCategory> findAll() {
        ImageCategoryExample imageCategoryExample=new ImageCategoryExample();
        imageCategoryExample.createCriteria().andCategoryStatusEqualTo(1);
        return this.imageCategoryDao.selectByExample(imageCategoryExample);
    }

    @Override
    public ImageCategory findById(Integer id) {
        return this.imageCategoryDao.selectByPrimaryKey(id);
    }

    @Override
    public List<Map<String, Object>> findAllCategoryInfo() {
        //封装类别信息
        List<ImageCategory> categoryList=findAll();
        List<Map<String,Object>> categoryInfo=new ArrayList<>();
        for(ImageCategory ic:categoryList){
            Map<String,Object> map=new HashMap<>(2);
            map.put("categoryId",ic.getCategoryId());
            map.put("categoryName",ic.getCategoryName());
            categoryInfo.add(map);
        }
        return categoryInfo;
    }
}
