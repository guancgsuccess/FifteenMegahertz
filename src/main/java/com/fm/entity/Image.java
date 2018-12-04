package com.fm.entity;

import java.io.Serializable;
import java.util.Date;

/**
 * @author 
 */
public class Image implements Serializable {
    /**
     * 图片ID
     */
    private Integer imageId;

    /**
     * 用户ID
     */
    private Integer custId;

    /**
     * 搜索关键字
     */
    private String imageKeyword;

    /**
     * 图片类别
     */
    private Integer categoryId;

    /**
     * 图片名称
     */
    private String imageName;

    /**
     * 图片点击量
     */
    private Integer imageClicks;

    /**
     * 图片收藏量
     */
    private Integer imageCollections;

    /**
     * 图片点赞量
     */
    private Integer imageLikes;

    /**
     * 图片下载量
     */
    private Integer imageDownloads;

    /**
     * 图片是否收费
     */
    private Integer imageIsFree;

    /**
     * 图片删除字段
     */
    private Integer imageStatus;

    /**
     * 焦距
     */
    private String cameraFocalLenth;

    /**
     * 光圈
     */
    private String cameraAperture;

    /**
     * ISO感光度
     */
    private String cameraIso;

    /**
     * 曝光补偿
     */
    private String cameraExposureTime;

    /**
     * 图片上传时间
     */
    private Date imageUploadTime;

    /**
     * 图片价格
     */
    private Integer imagePrice;

    /**
     * 压缩图片存放路劲
     */
    private String comprePath;

    /**
     * 原图存放路径
     */
    private String nocomprePath;

    /**
     * 图片亮度
     */
    private String imageBrightness;

    /**
     * 保留字段
     */
    private String blank2;

    /**
     * 品牌
     */
    private String cameraBrand;

    /**
     * 型号
     */
    private String cameraModel;

    private static final long serialVersionUID = 1L;

    public Integer getImageId() {
        return imageId;
    }

    public void setImageId(Integer imageId) {
        this.imageId = imageId;
    }

    public Integer getCustId() {
        return custId;
    }

    public void setCustId(Integer custId) {
        this.custId = custId;
    }

    public String getImageKeyword() {
        return imageKeyword;
    }

    public void setImageKeyword(String imageKeyword) {
        this.imageKeyword = imageKeyword;
    }

    public Integer getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(Integer categoryId) {
        this.categoryId = categoryId;
    }

    public String getImageName() {
        return imageName;
    }

    public void setImageName(String imageName) {
        this.imageName = imageName;
    }

    public Integer getImageClicks() {
        return imageClicks;
    }

    public void setImageClicks(Integer imageClicks) {
        this.imageClicks = imageClicks;
    }

    public Integer getImageCollections() {
        return imageCollections;
    }

    public void setImageCollections(Integer imageCollections) {
        this.imageCollections = imageCollections;
    }

    public Integer getImageLikes() {
        return imageLikes;
    }

    public void setImageLikes(Integer imageLikes) {
        this.imageLikes = imageLikes;
    }

    public Integer getImageDownloads() {
        return imageDownloads;
    }

    public void setImageDownloads(Integer imageDownloads) {
        this.imageDownloads = imageDownloads;
    }

    public Integer getImageIsFree() {
        return imageIsFree;
    }

    public void setImageIsFree(Integer imageIsFree) {
        this.imageIsFree = imageIsFree;
    }

    public Integer getImageStatus() {
        return imageStatus;
    }

    public void setImageStatus(Integer imageStatus) {
        this.imageStatus = imageStatus;
    }

    public String getCameraFocalLenth() {
        return cameraFocalLenth;
    }

    public void setCameraFocalLenth(String cameraFocalLenth) {
        this.cameraFocalLenth = cameraFocalLenth;
    }

    public String getCameraAperture() {
        return cameraAperture;
    }

    public void setCameraAperture(String cameraAperture) {
        this.cameraAperture = cameraAperture;
    }

    public String getCameraIso() {
        return cameraIso;
    }

    public void setCameraIso(String cameraIso) {
        this.cameraIso = cameraIso;
    }

    public String getCameraExposureTime() {
        return cameraExposureTime;
    }

    public void setCameraExposureTime(String cameraExposureTime) {
        this.cameraExposureTime = cameraExposureTime;
    }

    public Date getImageUploadTime() {
        return imageUploadTime;
    }

    public void setImageUploadTime(Date imageUploadTime) {
        this.imageUploadTime = imageUploadTime;
    }

    public Integer getImagePrice() {
        return imagePrice;
    }

    public void setImagePrice(Integer imagePrice) {
        this.imagePrice = imagePrice;
    }

    public String getComprePath() {
        return comprePath;
    }

    public void setComprePath(String comprePath) {
        this.comprePath = comprePath;
    }

    public String getNocomprePath() {
        return nocomprePath;
    }

    public void setNocomprePath(String nocomprePath) {
        this.nocomprePath = nocomprePath;
    }

    public String getImageBrightness() {
        return imageBrightness;
    }

    public void setImageBrightness(String imageBrightness) {
        this.imageBrightness = imageBrightness;
    }

    public String getBlank2() {
        return blank2;
    }

    public void setBlank2(String blank2) {
        this.blank2 = blank2;
    }

    public String getCameraBrand() {
        return cameraBrand;
    }

    public void setCameraBrand(String cameraBrand) {
        this.cameraBrand = cameraBrand;
    }

    public String getCameraModel() {
        return cameraModel;
    }

    public void setCameraModel(String cameraModel) {
        this.cameraModel = cameraModel;
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
        Image other = (Image) that;
        return (this.getImageId() == null ? other.getImageId() == null : this.getImageId().equals(other.getImageId()))
            && (this.getCustId() == null ? other.getCustId() == null : this.getCustId().equals(other.getCustId()))
            && (this.getImageKeyword() == null ? other.getImageKeyword() == null : this.getImageKeyword().equals(other.getImageKeyword()))
            && (this.getCategoryId() == null ? other.getCategoryId() == null : this.getCategoryId().equals(other.getCategoryId()))
            && (this.getImageName() == null ? other.getImageName() == null : this.getImageName().equals(other.getImageName()))
            && (this.getImageClicks() == null ? other.getImageClicks() == null : this.getImageClicks().equals(other.getImageClicks()))
            && (this.getImageCollections() == null ? other.getImageCollections() == null : this.getImageCollections().equals(other.getImageCollections()))
            && (this.getImageLikes() == null ? other.getImageLikes() == null : this.getImageLikes().equals(other.getImageLikes()))
            && (this.getImageDownloads() == null ? other.getImageDownloads() == null : this.getImageDownloads().equals(other.getImageDownloads()))
            && (this.getImageIsFree() == null ? other.getImageIsFree() == null : this.getImageIsFree().equals(other.getImageIsFree()))
            && (this.getImageStatus() == null ? other.getImageStatus() == null : this.getImageStatus().equals(other.getImageStatus()))
            && (this.getCameraFocalLenth() == null ? other.getCameraFocalLenth() == null : this.getCameraFocalLenth().equals(other.getCameraFocalLenth()))
            && (this.getCameraAperture() == null ? other.getCameraAperture() == null : this.getCameraAperture().equals(other.getCameraAperture()))
            && (this.getCameraIso() == null ? other.getCameraIso() == null : this.getCameraIso().equals(other.getCameraIso()))
            && (this.getCameraExposureTime() == null ? other.getCameraExposureTime() == null : this.getCameraExposureTime().equals(other.getCameraExposureTime()))
            && (this.getImageUploadTime() == null ? other.getImageUploadTime() == null : this.getImageUploadTime().equals(other.getImageUploadTime()))
            && (this.getImagePrice() == null ? other.getImagePrice() == null : this.getImagePrice().equals(other.getImagePrice()))
            && (this.getComprePath() == null ? other.getComprePath() == null : this.getComprePath().equals(other.getComprePath()))
            && (this.getNocomprePath() == null ? other.getNocomprePath() == null : this.getNocomprePath().equals(other.getNocomprePath()))
            && (this.getImageBrightness() == null ? other.getImageBrightness() == null : this.getImageBrightness().equals(other.getImageBrightness()))
            && (this.getBlank2() == null ? other.getBlank2() == null : this.getBlank2().equals(other.getBlank2()))
            && (this.getCameraBrand() == null ? other.getCameraBrand() == null : this.getCameraBrand().equals(other.getCameraBrand()))
            && (this.getCameraModel() == null ? other.getCameraModel() == null : this.getCameraModel().equals(other.getCameraModel()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getImageId() == null) ? 0 : getImageId().hashCode());
        result = prime * result + ((getCustId() == null) ? 0 : getCustId().hashCode());
        result = prime * result + ((getImageKeyword() == null) ? 0 : getImageKeyword().hashCode());
        result = prime * result + ((getCategoryId() == null) ? 0 : getCategoryId().hashCode());
        result = prime * result + ((getImageName() == null) ? 0 : getImageName().hashCode());
        result = prime * result + ((getImageClicks() == null) ? 0 : getImageClicks().hashCode());
        result = prime * result + ((getImageCollections() == null) ? 0 : getImageCollections().hashCode());
        result = prime * result + ((getImageLikes() == null) ? 0 : getImageLikes().hashCode());
        result = prime * result + ((getImageDownloads() == null) ? 0 : getImageDownloads().hashCode());
        result = prime * result + ((getImageIsFree() == null) ? 0 : getImageIsFree().hashCode());
        result = prime * result + ((getImageStatus() == null) ? 0 : getImageStatus().hashCode());
        result = prime * result + ((getCameraFocalLenth() == null) ? 0 : getCameraFocalLenth().hashCode());
        result = prime * result + ((getCameraAperture() == null) ? 0 : getCameraAperture().hashCode());
        result = prime * result + ((getCameraIso() == null) ? 0 : getCameraIso().hashCode());
        result = prime * result + ((getCameraExposureTime() == null) ? 0 : getCameraExposureTime().hashCode());
        result = prime * result + ((getImageUploadTime() == null) ? 0 : getImageUploadTime().hashCode());
        result = prime * result + ((getImagePrice() == null) ? 0 : getImagePrice().hashCode());
        result = prime * result + ((getComprePath() == null) ? 0 : getComprePath().hashCode());
        result = prime * result + ((getNocomprePath() == null) ? 0 : getNocomprePath().hashCode());
        result = prime * result + ((getImageBrightness() == null) ? 0 : getImageBrightness().hashCode());
        result = prime * result + ((getBlank2() == null) ? 0 : getBlank2().hashCode());
        result = prime * result + ((getCameraBrand() == null) ? 0 : getCameraBrand().hashCode());
        result = prime * result + ((getCameraModel() == null) ? 0 : getCameraModel().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", imageId=").append(imageId);
        sb.append(", custId=").append(custId);
        sb.append(", imageKeyword=").append(imageKeyword);
        sb.append(", categoryId=").append(categoryId);
        sb.append(", imageName=").append(imageName);
        sb.append(", imageClicks=").append(imageClicks);
        sb.append(", imageCollections=").append(imageCollections);
        sb.append(", imageLikes=").append(imageLikes);
        sb.append(", imageDownloads=").append(imageDownloads);
        sb.append(", imageIsFree=").append(imageIsFree);
        sb.append(", imageStatus=").append(imageStatus);
        sb.append(", cameraFocalLenth=").append(cameraFocalLenth);
        sb.append(", cameraAperture=").append(cameraAperture);
        sb.append(", cameraIso=").append(cameraIso);
        sb.append(", cameraExposureTime=").append(cameraExposureTime);
        sb.append(", imageUploadTime=").append(imageUploadTime);
        sb.append(", imagePrice=").append(imagePrice);
        sb.append(", comprePath=").append(comprePath);
        sb.append(", nocomprePath=").append(nocomprePath);
        sb.append(", imageBrightness=").append(imageBrightness);
        sb.append(", blank2=").append(blank2);
        sb.append(", cameraBrand=").append(cameraBrand);
        sb.append(", cameraModel=").append(cameraModel);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}