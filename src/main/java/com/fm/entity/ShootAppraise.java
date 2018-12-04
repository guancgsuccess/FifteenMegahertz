package com.fm.entity;

import java.io.Serializable;
import java.util.Date;

/**
 * shoot_appraise
 * @author 
 */
public class ShootAppraise implements Serializable {
    /**
     * 评价ID
     */
    private Integer appraiseId;

    /**
     * 评价人ID
     */
    private Integer custId;

    private Integer custAnswerId;

    /**
     * 套餐ID
     */
    private Integer shootId;

    /**
     * 评价时间
     */
    private Date appraiseCreateTime;

    /**
     * 评价等级(1,2,3,4,5星)
     */
    private Integer appraiseRange;

    /**
     * 显示状态(用于删除)
     */
    private Integer appraiseStatus;

    private String blank1;

    private String blank2;

    /**
     * 评价内容
     */
    private String appraiseContent;

    private static final long serialVersionUID = 1L;

    public Integer getAppraiseId() {
        return appraiseId;
    }

    public void setAppraiseId(Integer appraiseId) {
        this.appraiseId = appraiseId;
    }

    public Integer getCustId() {
        return custId;
    }

    public void setCustId(Integer custId) {
        this.custId = custId;
    }

    public Integer getCustAnswerId() {
        return custAnswerId;
    }

    public void setCustAnswerId(Integer custAnswerId) {
        this.custAnswerId = custAnswerId;
    }

    public Integer getShootId() {
        return shootId;
    }

    public void setShootId(Integer shootId) {
        this.shootId = shootId;
    }

    public Date getAppraiseCreateTime() {
        return appraiseCreateTime;
    }

    public void setAppraiseCreateTime(Date appraiseCreateTime) {
        this.appraiseCreateTime = appraiseCreateTime;
    }

    public Integer getAppraiseRange() {
        return appraiseRange;
    }

    public void setAppraiseRange(Integer appraiseRange) {
        this.appraiseRange = appraiseRange;
    }

    public Integer getAppraiseStatus() {
        return appraiseStatus;
    }

    public void setAppraiseStatus(Integer appraiseStatus) {
        this.appraiseStatus = appraiseStatus;
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

    public String getAppraiseContent() {
        return appraiseContent;
    }

    public void setAppraiseContent(String appraiseContent) {
        this.appraiseContent = appraiseContent;
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
        ShootAppraise other = (ShootAppraise) that;
        return (this.getAppraiseId() == null ? other.getAppraiseId() == null : this.getAppraiseId().equals(other.getAppraiseId()))
            && (this.getCustId() == null ? other.getCustId() == null : this.getCustId().equals(other.getCustId()))
            && (this.getCustAnswerId() == null ? other.getCustAnswerId() == null : this.getCustAnswerId().equals(other.getCustAnswerId()))
            && (this.getShootId() == null ? other.getShootId() == null : this.getShootId().equals(other.getShootId()))
            && (this.getAppraiseCreateTime() == null ? other.getAppraiseCreateTime() == null : this.getAppraiseCreateTime().equals(other.getAppraiseCreateTime()))
            && (this.getAppraiseRange() == null ? other.getAppraiseRange() == null : this.getAppraiseRange().equals(other.getAppraiseRange()))
            && (this.getAppraiseStatus() == null ? other.getAppraiseStatus() == null : this.getAppraiseStatus().equals(other.getAppraiseStatus()))
            && (this.getBlank1() == null ? other.getBlank1() == null : this.getBlank1().equals(other.getBlank1()))
            && (this.getBlank2() == null ? other.getBlank2() == null : this.getBlank2().equals(other.getBlank2()))
            && (this.getAppraiseContent() == null ? other.getAppraiseContent() == null : this.getAppraiseContent().equals(other.getAppraiseContent()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getAppraiseId() == null) ? 0 : getAppraiseId().hashCode());
        result = prime * result + ((getCustId() == null) ? 0 : getCustId().hashCode());
        result = prime * result + ((getCustAnswerId() == null) ? 0 : getCustAnswerId().hashCode());
        result = prime * result + ((getShootId() == null) ? 0 : getShootId().hashCode());
        result = prime * result + ((getAppraiseCreateTime() == null) ? 0 : getAppraiseCreateTime().hashCode());
        result = prime * result + ((getAppraiseRange() == null) ? 0 : getAppraiseRange().hashCode());
        result = prime * result + ((getAppraiseStatus() == null) ? 0 : getAppraiseStatus().hashCode());
        result = prime * result + ((getBlank1() == null) ? 0 : getBlank1().hashCode());
        result = prime * result + ((getBlank2() == null) ? 0 : getBlank2().hashCode());
        result = prime * result + ((getAppraiseContent() == null) ? 0 : getAppraiseContent().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", appraiseId=").append(appraiseId);
        sb.append(", custId=").append(custId);
        sb.append(", custAnswerId=").append(custAnswerId);
        sb.append(", shootId=").append(shootId);
        sb.append(", appraiseCreateTime=").append(appraiseCreateTime);
        sb.append(", appraiseRange=").append(appraiseRange);
        sb.append(", appraiseStatus=").append(appraiseStatus);
        sb.append(", blank1=").append(blank1);
        sb.append(", blank2=").append(blank2);
        sb.append(", appraiseContent=").append(appraiseContent);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}