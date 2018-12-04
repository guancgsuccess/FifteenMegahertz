package com.fm.entity;

import java.io.Serializable;
import java.util.Date;

/**
 * @author 
 */
public class Item implements Serializable {
    /**
     * 比赛项目ID
     */
    private Integer itemId;

    /**
     * 比赛名称
     */
    private String itemName;

    /**
     * 比赛主题
     */
    private String itemTopic;

    /**
     * 比赛开始时间
     */
    private Date itemCreateTime;

    /**
     * 比赛结束时间
     */
    private Date itemEndTime;

    /**
     * 比赛介绍
     */
    private String itemInfo;

    /**
     * 比赛规则
     */
    private String itemRuler;

    /**
     * 比赛奖品
     */
    private String itemPrize;

    /**
     * 比赛图片
     */
    private String itemImgPath;

    /**
     * 比赛状态(0:已结束,1:正在进行)
     */
    private Integer itemStatus;

    private static final long serialVersionUID = 1L;

    public Integer getItemId() {
        return itemId;
    }

    public void setItemId(Integer itemId) {
        this.itemId = itemId;
    }

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public String getItemTopic() {
        return itemTopic;
    }

    public void setItemTopic(String itemTopic) {
        this.itemTopic = itemTopic;
    }

    public Date getItemCreateTime() {
        return itemCreateTime;
    }

    public void setItemCreateTime(Date itemCreateTime) {
        this.itemCreateTime = itemCreateTime;
    }

    public Date getItemEndTime() {
        return itemEndTime;
    }

    public void setItemEndTime(Date itemEndTime) {
        this.itemEndTime = itemEndTime;
    }

    public String getItemInfo() {
        return itemInfo;
    }

    public void setItemInfo(String itemInfo) {
        this.itemInfo = itemInfo;
    }

    public String getItemRuler() {
        return itemRuler;
    }

    public void setItemRuler(String itemRuler) {
        this.itemRuler = itemRuler;
    }

    public String getItemPrize() {
        return itemPrize;
    }

    public void setItemPrize(String itemPrize) {
        this.itemPrize = itemPrize;
    }

    public String getItemImgPath() {
        return itemImgPath;
    }

    public void setItemImgPath(String itemImgPath) {
        this.itemImgPath = itemImgPath;
    }

    public Integer getItemStatus() {
        return itemStatus;
    }

    public void setItemStatus(Integer itemStatus) {
        this.itemStatus = itemStatus;
    }

    @Override
    public boolean equals(Object that) {
        if (this == that) {
            return true;
        }
        if (that == null) {
            return false;
        }
        if (getClass() != that.getClass()) {
            return false;
        }
        Item other = (Item) that;
        return (this.getItemId() == null ? other.getItemId() == null : this.getItemId().equals(other.getItemId()))
            && (this.getItemName() == null ? other.getItemName() == null : this.getItemName().equals(other.getItemName()))
            && (this.getItemTopic() == null ? other.getItemTopic() == null : this.getItemTopic().equals(other.getItemTopic()))
            && (this.getItemCreateTime() == null ? other.getItemCreateTime() == null : this.getItemCreateTime().equals(other.getItemCreateTime()))
            && (this.getItemEndTime() == null ? other.getItemEndTime() == null : this.getItemEndTime().equals(other.getItemEndTime()))
            && (this.getItemInfo() == null ? other.getItemInfo() == null : this.getItemInfo().equals(other.getItemInfo()))
            && (this.getItemRuler() == null ? other.getItemRuler() == null : this.getItemRuler().equals(other.getItemRuler()))
            && (this.getItemPrize() == null ? other.getItemPrize() == null : this.getItemPrize().equals(other.getItemPrize()))
            && (this.getItemImgPath() == null ? other.getItemImgPath() == null : this.getItemImgPath().equals(other.getItemImgPath()))
            && (this.getItemStatus() == null ? other.getItemStatus() == null : this.getItemStatus().equals(other.getItemStatus()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getItemId() == null) ? 0 : getItemId().hashCode());
        result = prime * result + ((getItemName() == null) ? 0 : getItemName().hashCode());
        result = prime * result + ((getItemTopic() == null) ? 0 : getItemTopic().hashCode());
        result = prime * result + ((getItemCreateTime() == null) ? 0 : getItemCreateTime().hashCode());
        result = prime * result + ((getItemEndTime() == null) ? 0 : getItemEndTime().hashCode());
        result = prime * result + ((getItemInfo() == null) ? 0 : getItemInfo().hashCode());
        result = prime * result + ((getItemRuler() == null) ? 0 : getItemRuler().hashCode());
        result = prime * result + ((getItemPrize() == null) ? 0 : getItemPrize().hashCode());
        result = prime * result + ((getItemImgPath() == null) ? 0 : getItemImgPath().hashCode());
        result = prime * result + ((getItemStatus() == null) ? 0 : getItemStatus().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", itemId=").append(itemId);
        sb.append(", itemName=").append(itemName);
        sb.append(", itemTopic=").append(itemTopic);
        sb.append(", itemCreateTime=").append(itemCreateTime);
        sb.append(", itemEndTime=").append(itemEndTime);
        sb.append(", itemInfo=").append(itemInfo);
        sb.append(", itemRuler=").append(itemRuler);
        sb.append(", itemPrize=").append(itemPrize);
        sb.append(", itemImgPath=").append(itemImgPath);
        sb.append(", itemStatus=").append(itemStatus);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}