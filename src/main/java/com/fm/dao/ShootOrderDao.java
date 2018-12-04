package com.fm.dao;

import com.fm.entity.ShootOrder;
import com.fm.entity.ShootOrderExample;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ShootOrderDao {
    long countByExample(ShootOrderExample example);

    int deleteByExample(ShootOrderExample example);

    int deleteByPrimaryKey(Integer orderId);

    int insert(ShootOrder record);

    int insertSelective(ShootOrder record);

    List<ShootOrder> selectByExample(ShootOrderExample example);

    ShootOrder selectByPrimaryKey(Integer orderId);

    int updateByExampleSelective(@Param("record") ShootOrder record, @Param("example") ShootOrderExample example);

    int updateByExample(@Param("record") ShootOrder record, @Param("example") ShootOrderExample example);

    int updateByPrimaryKeySelective(ShootOrder record);

    int updateByPrimaryKey(ShootOrder record);

    Integer getCount(@Param("custId") Integer custId, @Param("shootId") Integer shootId);

    List<ShootOrder> selectById(Integer custId);

    Integer deleteByCustIdAndOrderId(@Param("custId") Integer custId, @Param("orderId") Integer orderId);
    Integer updateOrderPayByOrderId(@Param("orderPay") Integer orderPay, @Param("orderId") Integer orderId);
}