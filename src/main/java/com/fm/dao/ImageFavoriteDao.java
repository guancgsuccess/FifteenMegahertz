package com.fm.dao;

import com.fm.entity.ImageFavorite;
import com.fm.entity.ImageFavoriteExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ImageFavoriteDao {
    long countByExample(ImageFavoriteExample example);

    int deleteByExample(ImageFavoriteExample example);

    int deleteByPrimaryKey(Integer favoriteId);

    int insert(ImageFavorite record);

    int insertSelective(ImageFavorite record);

    List<ImageFavorite> selectByExample(ImageFavoriteExample example);

    ImageFavorite selectByPrimaryKey(Integer favoriteId);

    int updateByExampleSelective(@Param("record") ImageFavorite record, @Param("example") ImageFavoriteExample example);

    int updateByExample(@Param("record") ImageFavorite record, @Param("example") ImageFavoriteExample example);

    int updateByPrimaryKeySelective(ImageFavorite record);

    int updateByPrimaryKey(ImageFavorite record);
}