package com.fm.dao;

import com.fm.entity.CustLogin;
import com.fm.entity.CustLoginExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface CustLoginDao {
    long countByExample(CustLoginExample example);

    int deleteByExample(CustLoginExample example);

    int deleteByPrimaryKey(Integer loginId);

    int insert(CustLogin record);

    int insertSelective(CustLogin record);

    List<CustLogin> selectByExample(CustLoginExample example);

    CustLogin selectByPrimaryKey(Integer loginId);

    int updateByExampleSelective(@Param("record") CustLogin record, @Param("example") CustLoginExample example);

    int updateByExample(@Param("record") CustLogin record, @Param("example") CustLoginExample example);

    int updateByPrimaryKeySelective(CustLogin record);

    int updateByPrimaryKey(CustLogin record);
}