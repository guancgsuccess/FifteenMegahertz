package com.fm.dao;

import com.fm.entity.CustLike;
import com.fm.entity.CustLikeExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface CustLikeDao {
    long countByExample(CustLikeExample example);

    int deleteByExample(CustLikeExample example);

    int deleteByPrimaryKey(Integer likeId);

    int insert(CustLike record);

    int insertSelective(CustLike record);

    List<CustLike> selectByExample(CustLikeExample example);

    CustLike selectByPrimaryKey(Integer likeId);

    int updateByExampleSelective(@Param("record") CustLike record, @Param("example") CustLikeExample example);

    int updateByExample(@Param("record") CustLike record, @Param("example") CustLikeExample example);

    int updateByPrimaryKeySelective(CustLike record);

    int updateByPrimaryKey(CustLike record);
}