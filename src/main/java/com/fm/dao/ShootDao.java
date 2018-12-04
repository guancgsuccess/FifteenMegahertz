package com.fm.dao;

import com.fm.entity.Shoot;
import com.fm.entity.ShootExample;
import com.fm.entity.shoot.PageModel;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ShootDao {
    long countByExample(ShootExample example);

    int deleteByExample(ShootExample example);

    int deleteByPrimaryKey(Integer shootId);

    int insert(Shoot record);

    int insertSelective(Shoot record);

    List<Shoot> selectByExample(ShootExample example);

    Shoot selectByPrimaryKey(Integer shootId);

    int updateByExampleSelective(@Param("record") Shoot record, @Param("example") ShootExample example);

    int updateByExample(@Param("record") Shoot record, @Param("example") ShootExample example);

    int updateByPrimaryKeySelective(Shoot record);

    int updateByPrimaryKey(Shoot record);

    List<Shoot> selectAllById(Integer shootThemeId);

    List<Shoot> getAllByPage(@Param("page") PageModel<Shoot> page, @Param("themeId") Integer themeId);

    Integer getCount(Integer themeId);

    Integer getLocCount(String shootLoc);

    List<Shoot> getAllByLoc(@Param("page") PageModel<Shoot> page, @Param("shootLoc") String shootLoc);

}