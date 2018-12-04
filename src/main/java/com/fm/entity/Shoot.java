package com.fm.entity;

import java.io.Serializable;

/**
 * shoot
 * @author 
 */
public class Shoot implements Serializable {
    /**
     * 套餐ID
     */
    private Integer shootId;

    /**
     * 主题ID
     */
    private Integer themeId;

    /**
     * 套餐概览
     */
    private String shootDesc;

    /**
     * 套餐价格
     */
    private Double shootPrice;

    /**
     * 用于删除字段
     */
    private Integer shootStatus;

    /**
     * 集合地点
     */
    private String shootLoc;

    private String img1Path;

    private String img2Path;

    private String img3Path;

    private String img4Path;

    private String img5Path;

    private String img6Path;

    private String img7Path;

    private String img8Path;

    private static final long serialVersionUID = 1L;

    public Shoot(Integer shootId, Integer themeId, String shootDesc, Double shootPrice, Integer shootStatus, String shootLoc, String img1Path, String img2Path, String img3Path, String img4Path, String img5Path, String img6Path, String img7Path, String img8Path) {
        this.shootId = shootId;
        this.themeId = themeId;
        this.shootDesc = shootDesc;
        this.shootPrice = shootPrice;
        this.shootStatus = shootStatus;
        this.shootLoc = shootLoc;
        this.img1Path = img1Path;
        this.img2Path = img2Path;
        this.img3Path = img3Path;
        this.img4Path = img4Path;
        this.img5Path = img5Path;
        this.img6Path = img6Path;
        this.img7Path = img7Path;
        this.img8Path = img8Path;
    }

    public Integer getShootId() {
        return shootId;
    }

    public void setShootId(Integer shootId) {
        this.shootId = shootId;
    }

    public Integer getThemeId() {
        return themeId;
    }

    public void setThemeId(Integer themeId) {
        this.themeId = themeId;
    }

    public String getShootDesc() {
        return shootDesc;
    }

    public void setShootDesc(String shootDesc) {
        this.shootDesc = shootDesc;
    }

    public Double getShootPrice() {
        return shootPrice;
    }

    public void setShootPrice(Double shootPrice) {
        this.shootPrice = shootPrice;
    }

    public Integer getShootStatus() {
        return shootStatus;
    }

    public void setShootStatus(Integer shootStatus) {
        this.shootStatus = shootStatus;
    }

    public String getShootLoc() {
        return shootLoc;
    }

    public void setShootLoc(String shootLoc) {
        this.shootLoc = shootLoc;
    }

    public String getImg1Path() {
        return img1Path;
    }

    public void setImg1Path(String img1Path) {
        this.img1Path = img1Path;
    }

    public String getImg2Path() {
        return img2Path;
    }

    public void setImg2Path(String img2Path) {
        this.img2Path = img2Path;
    }

    public String getImg3Path() {
        return img3Path;
    }

    public void setImg3Path(String img3Path) {
        this.img3Path = img3Path;
    }

    public String getImg4Path() {
        return img4Path;
    }

    public void setImg4Path(String img4Path) {
        this.img4Path = img4Path;
    }

    public String getImg5Path() {
        return img5Path;
    }

    public void setImg5Path(String img5Path) {
        this.img5Path = img5Path;
    }

    public String getImg6Path() {
        return img6Path;
    }

    public void setImg6Path(String img6Path) {
        this.img6Path = img6Path;
    }

    public String getImg7Path() {
        return img7Path;
    }

    public void setImg7Path(String img7Path) {
        this.img7Path = img7Path;
    }

    public String getImg8Path() {
        return img8Path;
    }

    public void setImg8Path(String img8Path) {
        this.img8Path = img8Path;
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
        Shoot other = (Shoot) that;
        return (this.getShootId() == null ? other.getShootId() == null : this.getShootId().equals(other.getShootId()))
            && (this.getThemeId() == null ? other.getThemeId() == null : this.getThemeId().equals(other.getThemeId()))
            && (this.getShootDesc() == null ? other.getShootDesc() == null : this.getShootDesc().equals(other.getShootDesc()))
            && (this.getShootPrice() == null ? other.getShootPrice() == null : this.getShootPrice().equals(other.getShootPrice()))
            && (this.getShootStatus() == null ? other.getShootStatus() == null : this.getShootStatus().equals(other.getShootStatus()))
            && (this.getShootLoc() == null ? other.getShootLoc() == null : this.getShootLoc().equals(other.getShootLoc()))
            && (this.getImg1Path() == null ? other.getImg1Path() == null : this.getImg1Path().equals(other.getImg1Path()))
            && (this.getImg2Path() == null ? other.getImg2Path() == null : this.getImg2Path().equals(other.getImg2Path()))
            && (this.getImg3Path() == null ? other.getImg3Path() == null : this.getImg3Path().equals(other.getImg3Path()))
            && (this.getImg4Path() == null ? other.getImg4Path() == null : this.getImg4Path().equals(other.getImg4Path()))
            && (this.getImg5Path() == null ? other.getImg5Path() == null : this.getImg5Path().equals(other.getImg5Path()))
            && (this.getImg6Path() == null ? other.getImg6Path() == null : this.getImg6Path().equals(other.getImg6Path()))
            && (this.getImg7Path() == null ? other.getImg7Path() == null : this.getImg7Path().equals(other.getImg7Path()))
            && (this.getImg8Path() == null ? other.getImg8Path() == null : this.getImg8Path().equals(other.getImg8Path()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getShootId() == null) ? 0 : getShootId().hashCode());
        result = prime * result + ((getThemeId() == null) ? 0 : getThemeId().hashCode());
        result = prime * result + ((getShootDesc() == null) ? 0 : getShootDesc().hashCode());
        result = prime * result + ((getShootPrice() == null) ? 0 : getShootPrice().hashCode());
        result = prime * result + ((getShootStatus() == null) ? 0 : getShootStatus().hashCode());
        result = prime * result + ((getShootLoc() == null) ? 0 : getShootLoc().hashCode());
        result = prime * result + ((getImg1Path() == null) ? 0 : getImg1Path().hashCode());
        result = prime * result + ((getImg2Path() == null) ? 0 : getImg2Path().hashCode());
        result = prime * result + ((getImg3Path() == null) ? 0 : getImg3Path().hashCode());
        result = prime * result + ((getImg4Path() == null) ? 0 : getImg4Path().hashCode());
        result = prime * result + ((getImg5Path() == null) ? 0 : getImg5Path().hashCode());
        result = prime * result + ((getImg6Path() == null) ? 0 : getImg6Path().hashCode());
        result = prime * result + ((getImg7Path() == null) ? 0 : getImg7Path().hashCode());
        result = prime * result + ((getImg8Path() == null) ? 0 : getImg8Path().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", shootId=").append(shootId);
        sb.append(", themeId=").append(themeId);
        sb.append(", shootDesc=").append(shootDesc);
        sb.append(", shootPrice=").append(shootPrice);
        sb.append(", shootStatus=").append(shootStatus);
        sb.append(", shootLoc=").append(shootLoc);
        sb.append(", img1Path=").append(img1Path);
        sb.append(", img2Path=").append(img2Path);
        sb.append(", img3Path=").append(img3Path);
        sb.append(", img4Path=").append(img4Path);
        sb.append(", img5Path=").append(img5Path);
        sb.append(", img6Path=").append(img6Path);
        sb.append(", img7Path=").append(img7Path);
        sb.append(", img8Path=").append(img8Path);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}