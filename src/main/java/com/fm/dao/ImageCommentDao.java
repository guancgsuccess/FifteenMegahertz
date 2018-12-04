package com.fm.dao;

import com.fm.entity.ImageComment;
import com.fm.entity.ImageCommentExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ImageCommentDao {
    long countByExample(ImageCommentExample example);

    int deleteByExample(ImageCommentExample example);

    int deleteByPrimaryKey(Integer commentId);

    int insert(ImageComment record);

    int insertSelective(ImageComment record);

    List<ImageComment> selectByExample(ImageCommentExample example);

    ImageComment selectByPrimaryKey(Integer commentId);

    int updateByExampleSelective(@Param("record") ImageComment record, @Param("example") ImageCommentExample example);

    int updateByExample(@Param("record") ImageComment record, @Param("example") ImageCommentExample example);

    int updateByPrimaryKeySelective(ImageComment record);

    int updateByPrimaryKey(ImageComment record);
}