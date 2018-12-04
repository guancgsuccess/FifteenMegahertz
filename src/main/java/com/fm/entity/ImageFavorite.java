package com.fm.entity;

import java.io.Serializable;

/**
 * @author 
 */
public class ImageFavorite implements Serializable {
    /**
     * 收藏ID
     */
    private Integer favoriteId;

    /**
     * 用户ID
     */
    private Integer custId;

    /**
     * 图片ID
     */
    private Integer imageId;

    /**
     * 状态字段
     */
    private Integer favoriteStatus;

    /**
     * 保留字段
     */
    private String blank1;

    private static final long serialVersionUID = 1L;

    public Integer getFavoriteId() {
        return favoriteId;
    }

    public void setFavoriteId(Integer favoriteId) {
        this.favoriteId = favoriteId;
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

    public Integer getFavoriteStatus() {
        return favoriteStatus;
    }

    public void setFavoriteStatus(Integer favoriteStatus) {
        this.favoriteStatus = favoriteStatus;
    }

    public String getBlank1() {
        return blank1;
    }

    public void setBlank1(String blank1) {
        this.blank1 = blank1;
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
        ImageFavorite other = (ImageFavorite) that;
        return (this.getFavoriteId() == null ? other.getFavoriteId() == null : this.getFavoriteId().equals(other.getFavoriteId()))
            && (this.getCustId() == null ? other.getCustId() == null : this.getCustId().equals(other.getCustId()))
            && (this.getImageId() == null ? other.getImageId() == null : this.getImageId().equals(other.getImageId()))
            && (this.getFavoriteStatus() == null ? other.getFavoriteStatus() == null : this.getFavoriteStatus().equals(other.getFavoriteStatus()))
            && (this.getBlank1() == null ? other.getBlank1() == null : this.getBlank1().equals(other.getBlank1()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getFavoriteId() == null) ? 0 : getFavoriteId().hashCode());
        result = prime * result + ((getCustId() == null) ? 0 : getCustId().hashCode());
        result = prime * result + ((getImageId() == null) ? 0 : getImageId().hashCode());
        result = prime * result + ((getFavoriteStatus() == null) ? 0 : getFavoriteStatus().hashCode());
        result = prime * result + ((getBlank1() == null) ? 0 : getBlank1().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", favoriteId=").append(favoriteId);
        sb.append(", custId=").append(custId);
        sb.append(", imageId=").append(imageId);
        sb.append(", favoriteStatus=").append(favoriteStatus);
        sb.append(", blank1=").append(blank1);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}