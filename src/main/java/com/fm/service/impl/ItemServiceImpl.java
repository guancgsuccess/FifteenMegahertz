package com.fm.service.impl;

import com.fm.dao.ItemDao;
import com.fm.entity.Item;
import com.fm.entity.ItemExample;
import com.fm.entity.common.ServerResponse;
import com.fm.service.ItemService;
import com.fm.util.DateUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

/**
 * @author liuyuan
 */
@Service
public class ItemServiceImpl implements ItemService {
    /**
     * 定义统一返回数据格式
     */
    private ServerResponse result = null;

    @Autowired
    private ItemDao itemDao;

    /**
     * 获得所有比赛信息
     * @return 所有比赛信息
     */
    @Override
    public ServerResponse findAllItem() {
        ItemExample itemExample = new ItemExample();
        itemExample.setOrderByClause("item_end_time desc");
        Map<String,Object> map = new HashMap<>(1);
        List<Map<String,Object>> allActive = new ArrayList<>();
        List<Item> itemList = itemDao.selectByExample(itemExample);
        String itemTime;
        for (Item item:itemList){
            Integer itemId = item.getItemId();
            String itemName = item.getItemName();
            String itemPrize = item.getItemPrize();
            Date itemEndTime = item.getItemEndTime();
            String itemImgPath = item.getItemImgPath();
            Integer itemStatus = item.getItemStatus();
            if(itemStatus==0){
                itemTime="此活动已结束";
            }else {
                Date now = new Date();
                Long lastDays = (itemEndTime.getTime()-now.getTime())/(24*60*60*1000);
                itemTime="距活动截止还剩"+ lastDays +"天";
            }

            Map<String,Object> itemMap = new HashMap<>(6);
            itemMap.put("itemId", itemId);
            itemMap.put("itemName",itemName);
            itemMap.put("itemPrize", itemPrize);
            itemMap.put("itemImgPath", itemImgPath);
            itemMap.put("itemTime",itemTime);
            itemMap.put("itemStatus", itemStatus);
            allActive.add(itemMap);
        }
        map.put("allActive", allActive);
        result= ServerResponse.createBySuccess("",map);
        return result;
    }

    /**
     * 获得正在进行的比赛信息
     * @return 正在进行的比赛信息
     */
    @Override
    public ServerResponse findNowItem() {
        Map<String,Object> map = new HashMap<>(1);
        List<Map<String,Object>> nowActive = new ArrayList<>();
        ItemExample itemExample = new ItemExample();
        itemExample.createCriteria().andItemStatusEqualTo(1);
        itemExample.setOrderByClause("item_end_time desc");
        List<Item> itemList = itemDao.selectByExample(itemExample);
        Date now = new Date();

        for (Item item:itemList){
            Integer itemId = item.getItemId();
            String itemName = item.getItemName();
            String itemPrize = item.getItemPrize();
            Date itemEndTime = item.getItemEndTime();
            String itemImgPath = item.getItemImgPath();
            Integer itemStatus = item.getItemStatus();
            Long lastDays = (itemEndTime.getTime()-now.getTime())/(24*60*60*1000);
            String itemTime = "距活动截止还剩"+ lastDays +"天";

            Map<String,Object> itemMap = new HashMap<>(6);
            itemMap.put("itemId", itemId);
            itemMap.put("itemName",itemName);
            itemMap.put("itemPrize", itemPrize);
            itemMap.put("itemImgPath", itemImgPath);
            itemMap.put("itemTime",itemTime);
            itemMap.put("itemStatus",itemStatus);
            nowActive.add(itemMap);
        }
        map.put("nowActive",nowActive);
        result= ServerResponse.createBySuccess("",map);
        return result;
    }

    /**
     * 获得已经结束的比赛信息
     * @return 已经结束的比赛信息
     */
    @Override
    public ServerResponse findEndItem() {
        Map<String,Object> map = new HashMap<>();
        List<Map<String,Object>> endActive = new ArrayList<>();
        ItemExample itemExample = new ItemExample();
        itemExample.createCriteria().andItemStatusEqualTo(0);
        List<Item> itemList = itemDao.selectByExample(itemExample);
        for (Item item:itemList){
            Integer itemId = item.getItemId();
            String itemName = item.getItemName();
            String itemPrize = item.getItemPrize();
            String itemImgPath = item.getItemImgPath();
            Integer itemStatus = item.getItemStatus();
            String itemTime = "此活动已结束";

            Map<String,Object> itemMap = new HashMap<>();
            itemMap.put("itemId", itemId);
            itemMap.put("itemName",itemName);
            itemMap.put("itemPrize", itemPrize);
            itemMap.put("itemImgPath", itemImgPath);
            itemMap.put("itemTime",itemTime);
            itemMap.put("itemStatus",itemStatus);
            endActive.add(itemMap);
        }
        map.put("endActive",endActive);
        result= ServerResponse.createBySuccess("",map);
        return result;
    }

    /**
     * 根据活动id获得比赛信息
     * @param itemId 比赛id
     * @return 比赛信息
     */
    @Override
    public ServerResponse findItemDetail(Integer itemId) {
        Map<String,Object> itemDetail = new HashMap<>(1);
        Item item = itemDao.selectByPrimaryKey(itemId);

        Date itemCreateTime = item.getItemCreateTime();
        Date itemEndTime = item.getItemEndTime();
        String itemTopic = item.getItemTopic();
        String itemRuler = item.getItemRuler();
        String itemPrize = item.getItemPrize();
        String itemInfo = item.getItemInfo();
        String itemImgPath = item.getItemImgPath();
        String createTime  = DateUtil.date2String(itemCreateTime, "yyyy年MM月dd日");
        String endTime = DateUtil.date2String(itemEndTime, "yyyy年MM月dd日");

        itemDetail.put("itemCreateTime", createTime);
        itemDetail.put("itemEndTime", endTime);
        itemDetail.put("itemTopic", itemTopic);
        itemDetail.put("itemRuler", itemRuler);
        itemDetail.put("itemPrize", itemPrize);
        itemDetail.put("itemInfo", itemInfo);
        itemDetail.put("itemImgPath", itemImgPath);
        result= ServerResponse.createBySuccess("", itemDetail);
        return result;
    }
}
