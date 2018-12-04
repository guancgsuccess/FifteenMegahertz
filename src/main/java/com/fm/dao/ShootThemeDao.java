package com.fm.dao;

import com.fm.entity.ShootTheme;
import com.fm.entity.ShootThemeExample;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ShootThemeDao {
    long countByExample(ShootThemeExample example);

    int deleteByExample(ShootThemeExample example);

    int deleteByPrimaryKey(Integer themeId);

    int insert(ShootTheme record);

    int insertSelective(ShootTheme record);

    List<ShootTheme> selectByExampleWithBLOBs(ShootThemeExample example);

    List<ShootTheme> selectByExample(ShootThemeExample example);

    ShootTheme selectByPrimaryKey(Integer themeId);

    int updateByExampleSelective(@Param("record") ShootTheme record, @Param("example") ShootThemeExample example);

    int updateByExampleWithBLOBs(@Param("record") ShootTheme record, @Param("example") ShootThemeExample example);

    int updateByExample(@Param("record") ShootTheme record, @Param("example") ShootThemeExample example);

    int updateByPrimaryKeySelective(ShootTheme record);

    int updateByPrimaryKeyWithBLOBs(ShootTheme record);

    int updateByPrimaryKey(ShootTheme record);
}