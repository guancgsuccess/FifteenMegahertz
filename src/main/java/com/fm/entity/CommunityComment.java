package com.fm.entity;

import java.io.Serializable;
import java.util.Date;

/**
 * community_comment
 * YftPaper
 *
 * @author
 */
public class CommunityComment implements Serializable {
    /**
     * 评论id
     */
    private Integer commentId;

    /**
     * 留言信息id
     */
    private Integer messageId;

    /**
     * 上级评论id
     */
    private Integer superCommentId;

    /**
     * 用户id
     */
    private Integer custId;

    /**
     * 评论发表时间
     */
    private Date commentCreateTime;

    /**
     * 评论内容
     */
    private String commentContent;

    /**
     * 评论状态
     */
    private Integer commentStatus;

    /**
     * 预留1
     */
    private String blank1;

    /**
     * 预留2
     */
    private String blank2;

    private static final long serialVersionUID = 1L;

    public Integer getCommentId() {
        return commentId;
    }

    public void setCommentId(Integer commentId) {
        this.commentId = commentId;
    }

    public Integer getMessageId() {
        return messageId;
    }

    public void setMessageId(Integer messageId) {
        this.messageId = messageId;
    }

    public Integer getSuperCommentId() {
        return superCommentId;
    }

    public void setSuperCommentId(Integer superCommentId) {
        this.superCommentId = superCommentId;
    }

    public Integer getCustId() {
        return custId;
    }

    public void setCustId(Integer custId) {
        this.custId = custId;
    }

    public Date getCommentCreateTime() {
        return commentCreateTime;
    }

    public void setCommentCreateTime(Date commentCreateTime) {
        this.commentCreateTime = commentCreateTime;
    }

    public String getCommentContent() {
        return commentContent;
    }

    public void setCommentContent(String commentContent) {
        this.commentContent = commentContent;
    }

    public Integer getCommentStatus() {
        return commentStatus;
    }

    public void setCommentStatus(Integer commentStatus) {
        this.commentStatus = commentStatus;
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
        CommunityComment other = (CommunityComment) that;
        return (this.getCommentId() == null ? other.getCommentId() == null : this.getCommentId().equals(other.getCommentId()))
                && (this.getMessageId() == null ? other.getMessageId() == null : this.getMessageId().equals(other.getMessageId()))
                && (this.getSuperCommentId() == null ? other.getSuperCommentId() == null : this.getSuperCommentId().equals(other.getSuperCommentId()))
                && (this.getCustId() == null ? other.getCustId() == null : this.getCustId().equals(other.getCustId()))
                && (this.getCommentCreateTime() == null ? other.getCommentCreateTime() == null : this.getCommentCreateTime().equals(other.getCommentCreateTime()))
                && (this.getCommentContent() == null ? other.getCommentContent() == null : this.getCommentContent().equals(other.getCommentContent()))
                && (this.getCommentStatus() == null ? other.getCommentStatus() == null : this.getCommentStatus().equals(other.getCommentStatus()))
                && (this.getBlank1() == null ? other.getBlank1() == null : this.getBlank1().equals(other.getBlank1()))
                && (this.getBlank2() == null ? other.getBlank2() == null : this.getBlank2().equals(other.getBlank2()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getCommentId() == null) ? 0 : getCommentId().hashCode());
        result = prime * result + ((getMessageId() == null) ? 0 : getMessageId().hashCode());
        result = prime * result + ((getSuperCommentId() == null) ? 0 : getSuperCommentId().hashCode());
        result = prime * result + ((getCustId() == null) ? 0 : getCustId().hashCode());
        result = prime * result + ((getCommentCreateTime() == null) ? 0 : getCommentCreateTime().hashCode());
        result = prime * result + ((getCommentContent() == null) ? 0 : getCommentContent().hashCode());
        result = prime * result + ((getCommentStatus() == null) ? 0 : getCommentStatus().hashCode());
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
        sb.append(", commentId=").append(commentId);
        sb.append(", messageId=").append(messageId);
        sb.append(", superCommentId=").append(superCommentId);
        sb.append(", custId=").append(custId);
        sb.append(", commentCreateTime=").append(commentCreateTime);
        sb.append(", commentContent=").append(commentContent);
        sb.append(", commentStatus=").append(commentStatus);
        sb.append(", blank1=").append(blank1);
        sb.append(", blank2=").append(blank2);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}