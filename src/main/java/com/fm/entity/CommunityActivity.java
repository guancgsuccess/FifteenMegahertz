package com.fm.entity;

import java.io.Serializable;
import java.util.Date;

/**
 * community_activity
 * YftPaper
 *
 * @author
 */
public class CommunityActivity extends CommunityActivityKey implements Serializable {
    /**
     * 活动名
     */
    private String activityName;

    /**
     * 活动开始时间
     */
    private Date activityCreateTime;

    /**
     * 活动结束时间
     */
    private Date activityEndTime;

    /**
     * 活动地点
     */
    private String activityLoc;

    /**
     * 预留1
     */
    private String blank1;

    /**
     * 预留2
     */
    private String blank2;

    /**
     * 活动参与方式
     */
    private String activityParticipate;

    private static final long serialVersionUID = 1L;

    public String getActivityName() {
        return activityName;
    }

    public void setActivityName(String activityName) {
        this.activityName = activityName;
    }

    public Date getActivityCreateTime() {
        return activityCreateTime;
    }

    public void setActivityCreateTime(Date activityCreateTime) {
        this.activityCreateTime = activityCreateTime;
    }

    public Date getActivityEndTime() {
        return activityEndTime;
    }

    public void setActivityEndTime(Date activityEndTime) {
        this.activityEndTime = activityEndTime;
    }

    public String getActivityLoc() {
        return activityLoc;
    }

    public void setActivityLoc(String activityLoc) {
        this.activityLoc = activityLoc;
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

    public String getActivityParticipate() {
        return activityParticipate;
    }

    public void setActivityParticipate(String activityParticipate) {
        this.activityParticipate = activityParticipate;
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
        CommunityActivity other = (CommunityActivity) that;
        return (this.getCommunityId() == null ? other.getCommunityId() == null : this.getCommunityId().equals(other.getCommunityId()))
                && (this.getActivityId() == null ? other.getActivityId() == null : this.getActivityId().equals(other.getActivityId()))
                && (this.getActivityName() == null ? other.getActivityName() == null : this.getActivityName().equals(other.getActivityName()))
                && (this.getActivityCreateTime() == null ? other.getActivityCreateTime() == null : this.getActivityCreateTime().equals(other.getActivityCreateTime()))
                && (this.getActivityEndTime() == null ? other.getActivityEndTime() == null : this.getActivityEndTime().equals(other.getActivityEndTime()))
                && (this.getActivityLoc() == null ? other.getActivityLoc() == null : this.getActivityLoc().equals(other.getActivityLoc()))
                && (this.getBlank1() == null ? other.getBlank1() == null : this.getBlank1().equals(other.getBlank1()))
                && (this.getBlank2() == null ? other.getBlank2() == null : this.getBlank2().equals(other.getBlank2()))
                && (this.getActivityParticipate() == null ? other.getActivityParticipate() == null : this.getActivityParticipate().equals(other.getActivityParticipate()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getCommunityId() == null) ? 0 : getCommunityId().hashCode());
        result = prime * result + ((getActivityId() == null) ? 0 : getActivityId().hashCode());
        result = prime * result + ((getActivityName() == null) ? 0 : getActivityName().hashCode());
        result = prime * result + ((getActivityCreateTime() == null) ? 0 : getActivityCreateTime().hashCode());
        result = prime * result + ((getActivityEndTime() == null) ? 0 : getActivityEndTime().hashCode());
        result = prime * result + ((getActivityLoc() == null) ? 0 : getActivityLoc().hashCode());
        result = prime * result + ((getBlank1() == null) ? 0 : getBlank1().hashCode());
        result = prime * result + ((getBlank2() == null) ? 0 : getBlank2().hashCode());
        result = prime * result + ((getActivityParticipate() == null) ? 0 : getActivityParticipate().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", activityName=").append(activityName);
        sb.append(", activityCreateTime=").append(activityCreateTime);
        sb.append(", activityEndTime=").append(activityEndTime);
        sb.append(", activityLoc=").append(activityLoc);
        sb.append(", blank1=").append(blank1);
        sb.append(", blank2=").append(blank2);
        sb.append(", activityParticipate=").append(activityParticipate);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}