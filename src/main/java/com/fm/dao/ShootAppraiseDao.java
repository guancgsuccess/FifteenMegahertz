package com.fm.dao;

import com.fm.entity.ShootAppraise;
import com.fm.entity.ShootAppraiseExample;
import com.fm.entity.shoot.PageModel;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ShootAppraiseDao {
    long countByExample(ShootAppraiseExample example);

    int deleteByExample(ShootAppraiseExample example);

    int deleteByPrimaryKey(Integer appraiseId);

    int insert(ShootAppraise record);

    int insertSelective(ShootAppraise record);

    List<ShootAppraise> selectByExampleWithBLOBs(ShootAppraiseExample example);

    List<ShootAppraise> selectByExample(ShootAppraiseExample example);

    ShootAppraise selectByPrimaryKey(Integer appraiseId);

    int updateByExampleSelective(@Param("record") ShootAppraise record, @Param("example") ShootAppraiseExample example);

    int updateByExampleWithBLOBs(@Param("record") ShootAppraise record, @Param("example") ShootAppraiseExample example);

    int updateByExample(@Param("record") ShootAppraise record, @Param("example") ShootAppraiseExample example);

    int updateByPrimaryKeySelective(ShootAppraise record);

    int updateByPrimaryKeyWithBLOBs(ShootAppraise record);

    int updateByPrimaryKey(ShootAppraise record);

    Integer getCount(Integer id);

    List<ShootAppraise> selectById(Integer id);

    List<ShootAppraise> selectByPage(@Param("page") PageModel<ShootAppraise> page, @Param("shootId") Integer shootId);

}