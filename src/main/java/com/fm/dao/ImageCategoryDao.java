package com.fm.dao;

import com.fm.entity.ImageCategory;
import com.fm.entity.ImageCategoryExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;
/**
 * Created on 2018/9/29.
 *
 * @author guochangji
 */
@SuppressWarnings("all")
public interface ImageCategoryDao {
    long countByExample(ImageCategoryExample example);

    int deleteByExample(ImageCategoryExample example);

    int deleteByPrimaryKey(Integer categoryId);

    int insert(ImageCategory record);

    int insertSelective(ImageCategory record);

    List<ImageCategory> selectByExample(ImageCategoryExample example);

    ImageCategory selectByPrimaryKey(Integer categoryId);

    int updateByExampleSelective(@Param("record") ImageCategory record, @Param("example") ImageCategoryExample example);

    int updateByExample(@Param("record") ImageCategory record, @Param("example") ImageCategoryExample example);

    int updateByPrimaryKeySelective(ImageCategory record);

    int updateByPrimaryKey(ImageCategory record);

    /*===================姚倾==========================*/
    List<ImageCategory> selectCustomerByCategoryIds(List ids);
}