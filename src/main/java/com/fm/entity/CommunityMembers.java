package com.fm.entity;

import java.io.Serializable;

/**
 * community_members
 * YftPaper
 *
 * @author
 */
public class CommunityMembers extends CommunityMembersKey implements Serializable {
    /**
     * 用户状态表
     */
    private Integer custStatus;

    /**
     * 预留1
     */
    private String blank1;

    /**
     * 预留2
     */
    private String blank2;

    private static final long serialVersionUID = 1L;

    public Integer getCustStatus() {
        return custStatus;
    }

    public void setCustStatus(Integer custStatus) {
        this.custStatus = custStatus;
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
        CommunityMembers other = (CommunityMembers) that;
        return (this.getCommunityId() == null ? other.getCommunityId() == null : this.getCommunityId().equals(other.getCommunityId()))
                && (this.getCustId() == null ? other.getCustId() == null : this.getCustId().equals(other.getCustId()))
                && (this.getCustStatus() == null ? other.getCustStatus() == null : this.getCustStatus().equals(other.getCustStatus()))
                && (this.getBlank1() == null ? other.getBlank1() == null : this.getBlank1().equals(other.getBlank1()))
                && (this.getBlank2() == null ? other.getBlank2() == null : this.getBlank2().equals(other.getBlank2()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getCommunityId() == null) ? 0 : getCommunityId().hashCode());
        result = prime * result + ((getCustId() == null) ? 0 : getCustId().hashCode());
        result = prime * result + ((getCustStatus() == null) ? 0 : getCustStatus().hashCode());
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
        sb.append(", custStatus=").append(custStatus);
        sb.append(", blank1=").append(blank1);
        sb.append(", blank2=").append(blank2);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}