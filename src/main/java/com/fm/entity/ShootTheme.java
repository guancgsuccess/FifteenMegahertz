package com.fm.entity;

import java.io.Serializable;

/**
 * shoot_theme
 * @author 
 */
public class ShootTheme implements Serializable {
    /**
     * 拍摄主题ID
     */
    private Integer themeId;

    /**
     * 主题名称
     */
    private String themeName;

    /**
     * 用于删除
     */
    private Integer themeStatus;

    private String blank1;

    private String blank2;

    /**
     * 主题描述
     */
    private String themeDesc;

    private static final long serialVersionUID = 1L;

    public Integer getThemeId() {
        return themeId;
    }

    public void setThemeId(Integer themeId) {
        this.themeId = themeId;
    }

    public String getThemeName() {
        return themeName;
    }

    public void setThemeName(String themeName) {
        this.themeName = themeName;
    }

    public Integer getThemeStatus() {
        return themeStatus;
    }

    public void setThemeStatus(Integer themeStatus) {
        this.themeStatus = themeStatus;
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

    public String getThemeDesc() {
        return themeDesc;
    }

    public void setThemeDesc(String themeDesc) {
        this.themeDesc = themeDesc;
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
        ShootTheme other = (ShootTheme) that;
        return (this.getThemeId() == null ? other.getThemeId() == null : this.getThemeId().equals(other.getThemeId()))
            && (this.getThemeName() == null ? other.getThemeName() == null : this.getThemeName().equals(other.getThemeName()))
            && (this.getThemeStatus() == null ? other.getThemeStatus() == null : this.getThemeStatus().equals(other.getThemeStatus()))
            && (this.getBlank1() == null ? other.getBlank1() == null : this.getBlank1().equals(other.getBlank1()))
            && (this.getBlank2() == null ? other.getBlank2() == null : this.getBlank2().equals(other.getBlank2()))
            && (this.getThemeDesc() == null ? other.getThemeDesc() == null : this.getThemeDesc().equals(other.getThemeDesc()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getThemeId() == null) ? 0 : getThemeId().hashCode());
        result = prime * result + ((getThemeName() == null) ? 0 : getThemeName().hashCode());
        result = prime * result + ((getThemeStatus() == null) ? 0 : getThemeStatus().hashCode());
        result = prime * result + ((getBlank1() == null) ? 0 : getBlank1().hashCode());
        result = prime * result + ((getBlank2() == null) ? 0 : getBlank2().hashCode());
        result = prime * result + ((getThemeDesc() == null) ? 0 : getThemeDesc().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", themeId=").append(themeId);
        sb.append(", themeName=").append(themeName);
        sb.append(", themeStatus=").append(themeStatus);
        sb.append(", blank1=").append(blank1);
        sb.append(", blank2=").append(blank2);
        sb.append(", themeDesc=").append(themeDesc);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}