package com.fm.entity;

import java.io.Serializable;
import java.util.Date;

/**
 * community_bulletin
 * YftPaper
 *
 * @author
 */
public class CommunityBulletin implements Serializable {
    /**
     * 公告ID
     */
    private Integer bulletinId;

    /**
     * 公告标题
     */
    private String bulletinTitle;

    /**
     * 公告发布时间
     */
    private Date bulletinCreateTime;

    /**
     * 发表人ID
     */
    private Integer custId;

    /**
     * 预留1
     */
    private String blank1;

    /**
     * 预留2
     */
    private String blank2;

    /**
     * 公告内容
     */
    private String bulletinContent;

    private static final long serialVersionUID = 1L;

    public Integer getBulletinId() {
        return bulletinId;
    }

    public void setBulletinId(Integer bulletinId) {
        this.bulletinId = bulletinId;
    }

    public String getBulletinTitle() {
        return bulletinTitle;
    }

    public void setBulletinTitle(String bulletinTitle) {
        this.bulletinTitle = bulletinTitle;
    }

    public Date getBulletinCreateTime() {
        return bulletinCreateTime;
    }

    public void setBulletinCreateTime(Date bulletinCreateTime) {
        this.bulletinCreateTime = bulletinCreateTime;
    }

    public Integer getCustId() {
        return custId;
    }

    public void setCustId(Integer custId) {
        this.custId = custId;
    }

    public String getBlank1() {
        return blank1;
    }

    public void setBlank1(String blank1) {
        this.blank1 = blank1;
    }

    public String getBlank2() {
        return blank2;
    }

    public void setBlank2(String blank2) {
        this.blank2 = blank2;
    }

    public String getBulletinContent() {
        return bulletinContent;
    }

    public void setBulletinContent(String bulletinContent) {
        this.bulletinContent = bulletinContent;
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
        CommunityBulletin other = (CommunityBulletin) that;
        return (this.getBulletinId() == null ? other.getBulletinId() == null : this.getBulletinId().equals(other.getBulletinId()))
                && (this.getBulletinTitle() == null ? other.getBulletinTitle() == null : this.getBulletinTitle().equals(other.getBulletinTitle()))
                && (this.getBulletinCreateTime() == null ? other.getBulletinCreateTime() == null : this.getBulletinCreateTime().equals(other.getBulletinCreateTime()))
                && (this.getCustId() == null ? other.getCustId() == null : this.getCustId().equals(other.getCustId()))
                && (this.getBlank1() == null ? other.getBlank1() == null : this.getBlank1().equals(other.getBlank1()))
                && (this.getBlank2() == null ? other.getBlank2() == null : this.getBlank2().equals(other.getBlank2()))
                && (this.getBulletinContent() == null ? other.getBulletinContent() == null : this.getBulletinContent().equals(other.getBulletinContent()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getBulletinId() == null) ? 0 : getBulletinId().hashCode());
        result = prime * result + ((getBulletinTitle() == null) ? 0 : getBulletinTitle().hashCode());
        result = prime * result + ((getBulletinCreateTime() == null) ? 0 : getBulletinCreateTime().hashCode());
        result = prime * result + ((getCustId() == null) ? 0 : getCustId().hashCode());
        result = prime * result + ((getBlank1() == null) ? 0 : getBlank1().hashCode());
        result = prime * result + ((getBlank2() == null) ? 0 : getBlank2().hashCode());
        result = prime * result + ((getBulletinContent() == null) ? 0 : getBulletinContent().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", bulletinId=").append(bulletinId);
        sb.append(", bulletinTitle=").append(bulletinTitle);
        sb.append(", bulletinCreateTime=").append(bulletinCreateTime);
        sb.append(", custId=").append(custId);
        sb.append(", blank1=").append(blank1);
        sb.append(", blank2=").append(blank2);
        sb.append(", bulletinContent=").append(bulletinContent);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}