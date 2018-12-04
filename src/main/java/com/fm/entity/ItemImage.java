package com.fm.entity;

import java.io.Serializable;

/**
 * @author 
 */
public class ItemImage implements Serializable {
    /**
     * 主键
     */
    private Integer competitionId;

    /**
     * 项目ID
     */
    private Integer itemId;

    /**
     * 用户ID
     */
    private Integer custId;

    /**
     * 图片ID
     */
    private Integer imageId;

    /**
     * 作品的支持数
     */
    private Integer imagePopularity;

    private static final long serialVersionUID = 1L;

    public Integer getCompetitionId() {
        return competitionId;
    }

    public void setCompetitionId(Integer competitionId) {
        this.competitionId = competitionId;
    }

    public Integer getItemId() {
        return itemId;
    }

    public void setItemId(Integer itemId) {
        this.itemId = itemId;
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

    public Integer getImagePopularity() {
        return imagePopularity;
    }

    public void setImagePopularity(Integer imagePopularity) {
        this.imagePopularity = imagePopularity;
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
        ItemImage other = (ItemImage) that;
        return (this.getCompetitionId() == null ? other.getCompetitionId() == null : this.getCompetitionId().equals(other.getCompetitionId()))
            && (this.getItemId() == null ? other.getItemId() == null : this.getItemId().equals(other.getItemId()))
            && (this.getCustId() == null ? other.getCustId() == null : this.getCustId().equals(other.getCustId()))
            && (this.getImageId() == null ? other.getImageId() == null : this.getImageId().equals(other.getImageId()))
            && (this.getImagePopularity() == null ? other.getImagePopularity() == null : this.getImagePopularity().equals(other.getImagePopularity()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getCompetitionId() == null) ? 0 : getCompetitionId().hashCode());
        result = prime * result + ((getItemId() == null) ? 0 : getItemId().hashCode());
        result = prime * result + ((getCustId() == null) ? 0 : getCustId().hashCode());
        result = prime * result + ((getImageId() == null) ? 0 : getImageId().hashCode());
        result = prime * result + ((getImagePopularity() == null) ? 0 : getImagePopularity().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", competitionId=").append(competitionId);
        sb.append(", itemId=").append(itemId);
        sb.append(", custId=").append(custId);
        sb.append(", imageId=").append(imageId);
        sb.append(", imagePopularity=").append(imagePopularity);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}