package com.fm.dao;

import com.fm.entity.Customer;
import com.fm.entity.CustomerExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface CustomerDao {
    long countByExample(CustomerExample example);

    int deleteByExample(CustomerExample example);

    int deleteByPrimaryKey(Integer custId);

    int insert(Customer record);

    int insertSelective(Customer record);

    List<Customer> selectByExample(CustomerExample example);

    Customer selectByPrimaryKey(Integer custId);

    int updateByExampleSelective(@Param("record") Customer record, @Param("example") CustomerExample example);

    int updateByExample(@Param("record") Customer record, @Param("example") CustomerExample example);

    int updateByPrimaryKeySelective(Customer record);

    int updateByPrimaryKey(Customer record);

    int updateCreditsByPrimaryKey(@Param("money") Integer money,@Param("custId") Integer custId);

    int updateExpByPrimaryKey(@Param("exp") Integer exp,@Param("custId") Integer custId);

    int updateLevelByPrimaryKey(Integer custId);

    int updatePwdByEmail(@Param("mail") String mail,@Param("pwd") String pwd);

    /*==========================姚倾============================*/
    /**
     * 根据ids集合查询用户
     *
     * @param customerIds 用户的id集合
     * @return 用户集合
     */
    List<Customer> selectCustomerByCustomerIds(List customerIds);
}