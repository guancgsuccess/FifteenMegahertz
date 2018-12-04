package com.fm.dao;

import com.fm.entity.CustVerify;
import com.fm.entity.CustVerifyExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface CustVerifyDao {
    long countByExample(CustVerifyExample example);

    int deleteByExample(CustVerifyExample example);

    int deleteByPrimaryKey(Integer verifyId);

    int insert(CustVerify record);

    int insertSelective(CustVerify record);

    List<CustVerify> selectByExample(CustVerifyExample example);

    CustVerify selectByPrimaryKey(Integer verifyId);

    int updateByExampleSelective(@Param("record") CustVerify record, @Param("example") CustVerifyExample example);

    int updateByExample(@Param("record") CustVerify record, @Param("example") CustVerifyExample example);

    int updateByPrimaryKeySelective(CustVerify record);

    int updateByPrimaryKey(CustVerify record);
}