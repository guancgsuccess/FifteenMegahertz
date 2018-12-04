package com.fm.dao;

import com.fm.entity.ItemImage;
import com.fm.entity.ItemImageExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

public interface ItemImageDao {
    long countByExample(ItemImageExample example);

    int deleteByExample(ItemImageExample example);

    int deleteByPrimaryKey(Integer competitionId);

    int insert(ItemImage record);

    int insertSelective(ItemImage record);

    List<ItemImage> selectByExample(ItemImageExample example);

    ItemImage selectByPrimaryKey(Integer competitionId);

    int updateByExampleSelective(@Param("record") ItemImage record, @Param("example") ItemImageExample example);

    int updateByExample(@Param("record") ItemImage record, @Param("example") ItemImageExample example);

    int updateByPrimaryKeySelective(ItemImage record);

    int updateByPrimaryKey(ItemImage record);

    int queryCustCount(Integer itemId);

    List<Map> queryCustIdByItemId(@Param("itemId") Integer itemId, @Param("start") Integer startCode, @Param("size") Integer size);

}