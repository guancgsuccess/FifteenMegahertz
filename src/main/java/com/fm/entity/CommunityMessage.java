package com.fm.entity;

import java.io.Serializable;
import java.util.Date;

/**
 * community_message
 * YftPaper
 *
 * @author
 */
public class CommunityMessage implements Serializable {
    /**
     * 留言ID
     */
    private Integer messageId;

    /**
     * 用户ID
     */
    private Integer custId;

    /**
     * 配图ID
     */
    private Integer imageId;

    /**
     * 社区id
     */
    private Integer communityId;

    /**
     * 用于删除
     */
    private Integer messageStatus;

    /**
     * 留言时间
     */
    private Date messageCreateTime;

    /**
     * 预留2
     */
    private String blank2;

    /**
     * 预留1
     */
    private String blank1;

    /**
     * 留言信息
     */
    private String messageContent;

    private static final long serialVersionUID = 1L;

    public Integer getMessageId() {
        return messageId;
    }

    public void setMessageId(Integer messageId) {
        this.messageId = messageId;
    }

    public Integer getCustId() {
        return custId;
    }

    public void setCustId(Integer custId) {
        this.custId = custId;
    }

    public Integer getImageId() {
        return imageId;
    }

    public void setImageId(Integer imageId) {
        this.imageId = imageId;
    }

    public Integer getCommunityId() {
        return communityId;
    }

    public void setCommunityId(Integer communityId) {
        this.communityId = communityId;
    }

    public Integer getMessageStatus() {
        return messageStatus;
    }

    public void setMessageStatus(Integer messageStatus) {
        this.messageStatus = messageStatus;
    }

    public Date getMessageCreateTime() {
        return messageCreateTime;
    }

    public void setMessageCreateTime(Date messageCreateTime) {
        this.messageCreateTime = messageCreateTime;
    }

    public String getBlank2() {
        return blank2;
    }

    public void setBlank2(String blank2) {
        this.blank2 = blank2;
    }

    public String getBlank1() {
        return blank1;
    }

    public void setBlank1(String blank1) {
        this.blank1 = blank1;
    }

    public String getMessageContent() {
        return messageContent;
    }

    public void setMessageContent(String messageContent) {
        this.messageContent = messageContent;
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
        CommunityMessage other = (CommunityMessage) that;
        return (this.getMessageId() == null ? other.getMessageId() == null : this.getMessageId().equals(other.getMessageId()))
                && (this.getCustId() == null ? other.getCustId() == null : this.getCustId().equals(other.getCustId()))
                && (this.getImageId() == null ? other.getImageId() == null : this.getImageId().equals(other.getImageId()))
                && (this.getCommunityId() == null ? other.getCommunityId() == null : this.getCommunityId().equals(other.getCommunityId()))
                && (this.getMessageStatus() == null ? other.getMessageStatus() == null : this.getMessageStatus().equals(other.getMessageStatus()))
                && (this.getMessageCreateTime() == null ? other.getMessageCreateTime() == null : this.getMessageCreateTime().equals(other.getMessageCreateTime()))
                && (this.getBlank2() == null ? other.getBlank2() == null : this.getBlank2().equals(other.getBlank2()))
                && (this.getBlank1() == null ? other.getBlank1() == null : this.getBlank1().equals(other.getBlank1()))
                && (this.getMessageContent() == null ? other.getMessageContent() == null : this.getMessageContent().equals(other.getMessageContent()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getMessageId() == null) ? 0 : getMessageId().hashCode());
        result = prime * result + ((getCustId() == null) ? 0 : getCustId().hashCode());
        result = prime * result + ((getImageId() == null) ? 0 : getImageId().hashCode());
        result = prime * result + ((getCommunityId() == null) ? 0 : getCommunityId().hashCode());
        result = prime * result + ((getMessageStatus() == null) ? 0 : getMessageStatus().hashCode());
        result = prime * result + ((getMessageCreateTime() == null) ? 0 : getMessageCreateTime().hashCode());
        result = prime * result + ((getBlank2() == null) ? 0 : getBlank2().hashCode());
        result = prime * result + ((getBlank1() == null) ? 0 : getBlank1().hashCode());
        result = prime * result + ((getMessageContent() == null) ? 0 : getMessageContent().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", messageId=").append(messageId);
        sb.append(", custId=").append(custId);
        sb.append(", imageId=").append(imageId);
        sb.append(", communityId=").append(communityId);
        sb.append(", messageStatus=").append(messageStatus);
        sb.append(", messageCreateTime=").append(messageCreateTime);
        sb.append(", blank2=").append(blank2);
        sb.append(", blank1=").append(blank1);
        sb.append(", messageContent=").append(messageContent);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}