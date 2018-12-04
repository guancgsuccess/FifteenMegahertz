package com.fm.entity;

import java.io.Serializable;
import java.util.Date;

/**
 * @author 
 */
public class ImageComment implements Serializable {
    /**
     * 评论ID
     */
    private Integer commentId;

    /**
     * 图片ID
     */
    private Integer imageId;

    /**
     * 评论人ID
     */
    private Integer custFromId;

    /**
     * 目标人ID
     */
    private Integer custToId;

    /**
     * 评论内容
     */
    private String commentContent;

    /**
     * 评论时间
     */
    private Date commentCreateTime;

    /**
     * 用于删除字段
     */
    private Integer commentStatus;

    private String blank1;

    private String blank2;

    private static final long serialVersionUID = 1L;

    public Integer getCommentId() {
        return commentId;
    }

    public void setCommentId(Integer commentId) {
        this.commentId = commentId;
    }

    public Integer getImageId() {
        return imageId;
    }

    public void setImageId(Integer imageId) {
        this.imageId = imageId;
    }

    public Integer getCustFromId() {
        return custFromId;
    }

    public void setCustFromId(Integer custFromId) {
        this.custFromId = custFromId;
    }

    public Integer getCustToId() {
        return custToId;
    }

    public void setCustToId(Integer custToId) {
        this.custToId = custToId;
    }

    public String getCommentContent() {
        return commentContent;
    }

    public void setCommentContent(String commentContent) {
        this.commentContent = commentContent;
    }

    public Date getCommentCreateTime() {
        return commentCreateTime;
    }

    public void setCommentCreateTime(Date commentCreateTime) {
        this.commentCreateTime = commentCreateTime;
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
        ImageComment other = (ImageComment) that;
        return (this.getCommentId() == null ? other.getCommentId() == null : this.getCommentId().equals(other.getCommentId()))
            && (this.getImageId() == null ? other.getImageId() == null : this.getImageId().equals(other.getImageId()))
            && (this.getCustFromId() == null ? other.getCustFromId() == null : this.getCustFromId().equals(other.getCustFromId()))
            && (this.getCustToId() == null ? other.getCustToId() == null : this.getCustToId().equals(other.getCustToId()))
            && (this.getCommentContent() == null ? other.getCommentContent() == null : this.getCommentContent().equals(other.getCommentContent()))
            && (this.getCommentCreateTime() == null ? other.getCommentCreateTime() == null : this.getCommentCreateTime().equals(other.getCommentCreateTime()))
            && (this.getCommentStatus() == null ? other.getCommentStatus() == null : this.getCommentStatus().equals(other.getCommentStatus()))
            && (this.getBlank1() == null ? other.getBlank1() == null : this.getBlank1().equals(other.getBlank1()))
            && (this.getBlank2() == null ? other.getBlank2() == null : this.getBlank2().equals(other.getBlank2()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getCommentId() == null) ? 0 : getCommentId().hashCode());
        result = prime * result + ((getImageId() == null) ? 0 : getImageId().hashCode());
        result = prime * result + ((getCustFromId() == null) ? 0 : getCustFromId().hashCode());
        result = prime * result + ((getCustToId() == null) ? 0 : getCustToId().hashCode());
        result = prime * result + ((getCommentContent() == null) ? 0 : getCommentContent().hashCode());
        result = prime * result + ((getCommentCreateTime() == null) ? 0 : getCommentCreateTime().hashCode());
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
        sb.append(", imageId=").append(imageId);
        sb.append(", custFromId=").append(custFromId);
        sb.append(", custToId=").append(custToId);
        sb.append(", commentContent=").append(commentContent);
        sb.append(", commentCreateTime=").append(commentCreateTime);
        sb.append(", commentStatus=").append(commentStatus);
        sb.append(", blank1=").append(blank1);
        sb.append(", blank2=").append(blank2);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}