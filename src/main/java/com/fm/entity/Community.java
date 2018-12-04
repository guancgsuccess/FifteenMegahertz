package com.fm.entity;

import java.io.Serializable;

/**
 * community
 * YftPaper
 *
 * @author
 */
public class Community implements Serializable {
    /**
     * 社区ID
     */
    private Integer communityId;

    /**
     * 社区名
     */
    private String communityName;

    /**
     * 类别ID
     */
    private Integer categoryId;

    /**
     * 管理人员ID
     */
    private Integer custId;

    /**
     * 社区头像
     */
    private String communityPhoto;

    /**
     * 社区简介
     */
    private String communityLabel;

    /**
     * 社区显示状态
     */
    private Integer communityStatus;

    /**
     * 预留字段1
     */
    private String blank1;

    /**
     * 预留字段2
     */
    private String blank2;

    private static final long serialVersionUID = 1L;

    public Integer getCommunityId() {
        return communityId;
    }

    public void setCommunityId(Integer communityId) {
        this.communityId = communityId;
    }

    public String getCommunityName() {
        return communityName;
    }

    public void setCommunityName(String communityName) {
        this.communityName = communityName;
    }

    public Integer getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(Integer categoryId) {
        this.categoryId = categoryId;
    }

    public Integer getCustId() {
        return custId;
    }

    public void setCustId(Integer custId) {
        this.custId = custId;
    }

    public String getCommunityPhoto() {
        return communityPhoto;
    }

    public void setCommunityPhoto(String communityPhoto) {
        this.communityPhoto = communityPhoto;
    }

    public String getCommunityLabel() {
        return communityLabel;
    }

    public void setCommunityLabel(String communityLabel) {
        this.communityLabel = communityLabel;
    }

    public Integer getCommunityStatus() {
        return communityStatus;
    }

    public void setCommunityStatus(Integer communityStatus) {
        this.communityStatus = communityStatus;
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
        Community other = (Community) that;
        return (this.getCommunityId() == null ? other.getCommunityId() == null : this.getCommunityId().equals(other.getCommunityId()))
                && (this.getCommunityName() == null ? other.getCommunityName() == null : this.getCommunityName().equals(other.getCommunityName()))
                && (this.getCategoryId() == null ? other.getCategoryId() == null : this.getCategoryId().equals(other.getCategoryId()))
                && (this.getCustId() == null ? other.getCustId() == null : this.getCustId().equals(other.getCustId()))
                && (this.getCommunityPhoto() == null ? other.getCommunityPhoto() == null : this.getCommunityPhoto().equals(other.getCommunityPhoto()))
                && (this.getCommunityLabel() == null ? other.getCommunityLabel() == null : this.getCommunityLabel().equals(other.getCommunityLabel()))
                && (this.getCommunityStatus() == null ? other.getCommunityStatus() == null : this.getCommunityStatus().equals(other.getCommunityStatus()))
                && (this.getBlank1() == null ? other.getBlank1() == null : this.getBlank1().equals(other.getBlank1()))
                && (this.getBlank2() == null ? other.getBlank2() == null : this.getBlank2().equals(other.getBlank2()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getCommunityId() == null) ? 0 : getCommunityId().hashCode());
        result = prime * result + ((getCommunityName() == null) ? 0 : getCommunityName().hashCode());
        result = prime * result + ((getCategoryId() == null) ? 0 : getCategoryId().hashCode());
        result = prime * result + ((getCustId() == null) ? 0 : getCustId().hashCode());
        result = prime * result + ((getCommunityPhoto() == null) ? 0 : getCommunityPhoto().hashCode());
        result = prime * result + ((getCommunityLabel() == null) ? 0 : getCommunityLabel().hashCode());
        result = prime * result + ((getCommunityStatus() == null) ? 0 : getCommunityStatus().hashCode());
        result = prime * result + ((getBlank1() == null) ? 0 : getBlank1().hashCode());
        result = prime * result + ((getBlank2() == null) ? 0 : getBlank2().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", communityId=").append(communityId);
        sb.append(", communityName=").append(communityName);
        sb.append(", categoryId=").append(categoryId);
        sb.append(", custId=").append(custId);
        sb.append(", communityPhoto=").append(communityPhoto);
        sb.append(", communityLabel=").append(communityLabel);
        sb.append(", communityStatus=").append(communityStatus);
        sb.append(", blank1=").append(blank1);
        sb.append(", blank2=").append(blank2);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}