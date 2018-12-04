package com.fm.dao;

import com.fm.entity.CustFollow;
import com.fm.entity.CustFollowExample;
import com.fm.entity.CustFollowKey;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface CustFollowDao {
    long countByExample(CustFollowExample example);

    int deleteByExample(CustFollowExample example);

    int deleteByPrimaryKey(CustFollowKey key);

    int insert(CustFollow record);

    int insertSelective(CustFollow record);

    List<CustFollow> selectByExample(CustFollowExample example);

    CustFollow selectByPrimaryKey(CustFollowKey key);

    int updateByExampleSelective(@Param("record") CustFollow record, @Param("example") CustFollowExample example);

    int updateByExample(@Param("record") CustFollow record, @Param("example") CustFollowExample example);

    int updateByPrimaryKeySelective(CustFollow record);

    int updateByPrimaryKey(CustFollow record);
}