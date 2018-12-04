package com.fm.dao;

import com.fm.entity.CustOrder;
import com.fm.entity.CustOrderExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface CustOrderDao {
    long countByExample(CustOrderExample example);

    int deleteByExample(CustOrderExample example);

    int deleteByPrimaryKey(Integer orderId);

    int insert(CustOrder record);

    int insertSelective(CustOrder record);

    List<CustOrder> selectByExample(CustOrderExample example);

    CustOrder selectByPrimaryKey(Integer orderId);

    int updateByExampleSelective(@Param("record") CustOrder record, @Param("example") CustOrderExample example);

    int updateByExample(@Param("record") CustOrder record, @Param("example") CustOrderExample example);

    int updateByPrimaryKeySelective(CustOrder record);

    int updateByPrimaryKey(CustOrder record);
}