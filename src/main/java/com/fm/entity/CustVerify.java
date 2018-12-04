package com.fm.entity;

import java.io.Serializable;
import java.util.Date;

/**
 * @author 
 */
public class CustVerify implements Serializable {
    /**
     * 主键
     */
    private Integer verifyId;

    /**
     * 用户ID
     */
    private Integer custId;

    /**
     * 发起时间
     */
    private Date verifyCreatTime;

    /**
     * 审核状态(通过1,未通过0,正在审核2)
     */
    private Integer verifyStatus;

    /**
     * 用户真实姓名
     */
    private String custName;

    /**
     * 用户年龄
     */
    private Integer custAge;

    /**
     * 用户省份
     */
    private String custProvince;

    /**
     * 用户城市
     */
    private String custCity;

    /**
     * 用户邮箱
     */
    private String custEmail;

    private String blank1;

    private String blank2;

    private static final long serialVersionUID = 1L;

    public Integer getVerifyId() {
        return verifyId;
    }

    public void setVerifyId(Integer verifyId) {
        this.verifyId = verifyId;
    }

    public Integer getCustId() {
        return custId;
    }

    public void setCustId(Integer custId) {
        this.custId = custId;
    }

    public Date getVerifyCreatTime() {
        return verifyCreatTime;
    }

    public void setVerifyCreatTime(Date verifyCreatTime) {
        this.verifyCreatTime = verifyCreatTime;
    }

    public Integer getVerifyStatus() {
        return verifyStatus;
    }

    public void setVerifyStatus(Integer verifyStatus) {
        this.verifyStatus = verifyStatus;
    }

    public String getCustName() {
        return custName;
    }

    public void setCustName(String custName) {
        this.custName = custName;
    }

    public Integer getCustAge() {
        return custAge;
    }

    public void setCustAge(Integer custAge) {
        this.custAge = custAge;
    }

    public String getCustProvince() {
        return custProvince;
    }

    public void setCustProvince(String custProvince) {
        this.custProvince = custProvince;
    }

    public String getCustCity() {
        return custCity;
    }

    public void setCustCity(String custCity) {
        this.custCity = custCity;
    }

    public String getCustEmail() {
        return custEmail;
    }

    public void setCustEmail(String custEmail) {
        this.custEmail = custEmail;
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
        CustVerify other = (CustVerify) that;
        return (this.getVerifyId() == null ? other.getVerifyId() == null : this.getVerifyId().equals(other.getVerifyId()))
            && (this.getCustId() == null ? other.getCustId() == null : this.getCustId().equals(other.getCustId()))
            && (this.getVerifyCreatTime() == null ? other.getVerifyCreatTime() == null : this.getVerifyCreatTime().equals(other.getVerifyCreatTime()))
            && (this.getVerifyStatus() == null ? other.getVerifyStatus() == null : this.getVerifyStatus().equals(other.getVerifyStatus()))
            && (this.getCustName() == null ? other.getCustName() == null : this.getCustName().equals(other.getCustName()))
            && (this.getCustAge() == null ? other.getCustAge() == null : this.getCustAge().equals(other.getCustAge()))
            && (this.getCustProvince() == null ? other.getCustProvince() == null : this.getCustProvince().equals(other.getCustProvince()))
            && (this.getCustCity() == null ? other.getCustCity() == null : this.getCustCity().equals(other.getCustCity()))
            && (this.getCustEmail() == null ? other.getCustEmail() == null : this.getCustEmail().equals(other.getCustEmail()))
            && (this.getBlank1() == null ? other.getBlank1() == null : this.getBlank1().equals(other.getBlank1()))
            && (this.getBlank2() == null ? other.getBlank2() == null : this.getBlank2().equals(other.getBlank2()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getVerifyId() == null) ? 0 : getVerifyId().hashCode());
        result = prime * result + ((getCustId() == null) ? 0 : getCustId().hashCode());
        result = prime * result + ((getVerifyCreatTime() == null) ? 0 : getVerifyCreatTime().hashCode());
        result = prime * result + ((getVerifyStatus() == null) ? 0 : getVerifyStatus().hashCode());
        result = prime * result + ((getCustName() == null) ? 0 : getCustName().hashCode());
        result = prime * result + ((getCustAge() == null) ? 0 : getCustAge().hashCode());
        result = prime * result + ((getCustProvince() == null) ? 0 : getCustProvince().hashCode());
        result = prime * result + ((getCustCity() == null) ? 0 : getCustCity().hashCode());
        result = prime * result + ((getCustEmail() == null) ? 0 : getCustEmail().hashCode());
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
        sb.append(", verifyId=").append(verifyId);
        sb.append(", custId=").append(custId);
        sb.append(", verifyCreatTime=").append(verifyCreatTime);
        sb.append(", verifyStatus=").append(verifyStatus);
        sb.append(", custName=").append(custName);
        sb.append(", custAge=").append(custAge);
        sb.append(", custProvince=").append(custProvince);
        sb.append(", custCity=").append(custCity);
        sb.append(", custEmail=").append(custEmail);
        sb.append(", blank1=").append(blank1);
        sb.append(", blank2=").append(blank2);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}