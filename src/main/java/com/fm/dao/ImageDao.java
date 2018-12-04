package com.fm.dao;

import com.fm.entity.Image;
import com.fm.entity.ImageExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

public interface ImageDao {

    long countByExample(ImageExample example);

    int deleteByExample(ImageExample example);

    int deleteByPrimaryKey(Integer imageId);

    int insert(Image record);

    int insertSelective(Image record);

    List<Image> selectByExample(ImageExample example);

    Image selectByPrimaryKey(Integer imageId);

    int updateByExampleSelective(@Param("record") Image record, @Param("example") ImageExample example);

    int updateByExample(@Param("record") Image record, @Param("example") ImageExample example);

    int updateByPrimaryKeySelective(Image record);


    List<Image> selectImages();

    List<Image> getImages();

    int updateByPrimaryKey(Image record);

    int updateClicksIncrementByPrimaryKey(@Param("increment") Integer increment, @Param("imageId") Integer imageId);

    List<Map<String, Object>> selectKeyWordLike(String keyword);

    /************** 姚倾部分 *********/

    List<Image> selectImageByIds(List list);

    int insertReturnId(Image record);
}