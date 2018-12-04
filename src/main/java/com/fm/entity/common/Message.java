package com.fm.entity.common;

import java.io.Serializable;
import java.util.Date;

/**
 * @author 
 */
public class Message implements Serializable {
    /**
     * 消息ID
     */
    private Integer messageId;

    /**
     * 发送人ID
     */
    private Integer fromId;

    /**
     * 发送人名称
     */
    private String fromName;

    /**
     * 发送人头像
     */
    private String fromProfile;

    /**
     * 接收人ID
     */
    private Integer toId;

    /**
     * 发送内容
     */
    private String messageText;

    /**
     * 发送时间
     */
    private Date messageTime;

    /**
     * 1(已读),0(未读)
     */
    private Integer messageStatus;

    private static final long serialVersionUID = 1L;

    public Integer getMessageId() {
        return messageId;
    }

    public void setMessageId(Integer messageId) {
        this.messageId = messageId;
    }

    public Integer getFromId() {
        return fromId;
    }

    public void setFromId(Integer fromId) {
        this.fromId = fromId;
    }

    public String getFromName() {
        return fromName;
    }

    public void setFromName(String fromName) {
        this.fromName = fromName;
    }

    public String getFromProfile() {
        return fromProfile;
    }

    public void setFromProfile(String fromProfile) {
        this.fromProfile = fromProfile;
    }

    public Integer getToId() {
        return toId;
    }

    public void setToId(Integer toId) {
        this.toId = toId;
    }

    public String getMessageText() {
        return messageText;
    }

    public void setMessageText(String messageText) {
        this.messageText = messageText;
    }

    public Date getMessageTime() {
        return messageTime;
    }

    public void setMessageTime(Date messageTime) {
        this.messageTime = messageTime;
    }

    public Integer getMessageStatus() {
        return messageStatus;
    }

    public void setMessageStatus(Integer messageStatus) {
        this.messageStatus = messageStatus;
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
        Message other = (Message) that;
        return (this.getMessageId() == null ? other.getMessageId() == null : this.getMessageId().equals(other.getMessageId()))
            && (this.getFromId() == null ? other.getFromId() == null : this.getFromId().equals(other.getFromId()))
            && (this.getFromName() == null ? other.getFromName() == null : this.getFromName().equals(other.getFromName()))
            && (this.getFromProfile() == null ? other.getFromProfile() == null : this.getFromProfile().equals(other.getFromProfile()))
            && (this.getToId() == null ? other.getToId() == null : this.getToId().equals(other.getToId()))
            && (this.getMessageText() == null ? other.getMessageText() == null : this.getMessageText().equals(other.getMessageText()))
            && (this.getMessageTime() == null ? other.getMessageTime() == null : this.getMessageTime().equals(other.getMessageTime()))
            && (this.getMessageStatus() == null ? other.getMessageStatus() == null : this.getMessageStatus().equals(other.getMessageStatus()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getMessageId() == null) ? 0 : getMessageId().hashCode());
        result = prime * result + ((getFromId() == null) ? 0 : getFromId().hashCode());
        result = prime * result + ((getFromName() == null) ? 0 : getFromName().hashCode());
        result = prime * result + ((getFromProfile() == null) ? 0 : getFromProfile().hashCode());
        result = prime * result + ((getToId() == null) ? 0 : getToId().hashCode());
        result = prime * result + ((getMessageText() == null) ? 0 : getMessageText().hashCode());
        result = prime * result + ((getMessageTime() == null) ? 0 : getMessageTime().hashCode());
        result = prime * result + ((getMessageStatus() == null) ? 0 : getMessageStatus().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", messageId=").append(messageId);
        sb.append(", fromId=").append(fromId);
        sb.append(", fromName=").append(fromName);
        sb.append(", fromProfile=").append(fromProfile);
        sb.append(", toId=").append(toId);
        sb.append(", messageText=").append(messageText);
        sb.append(", messageTime=").append(messageTime);
        sb.append(", messageStatus=").append(messageStatus);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}