package com.fm.entity;

import java.io.Serializable;
import java.util.Date;

/**
 * @author
 */
public class Customer implements Serializable {
    /**
     * 用户ID
     */
    private Integer custId;

    /**
     * 用户名
     */
    private String custNick;

    /**
     * 用户密码

     */
    private String custPassword;

    /**
     * 用户个性签名
     */
    private String custIntro;

    /**
     * 用户电话
     */
    private String custPhone;

    /**
     * 用户积分
     */
    private Integer custCredits;

    /**
     * 用户等级经验
     */
    private Integer rangeExp;

    /**
     * 用户等级
     */
    private Integer rangeLevel;

    /**
     * 用户是否活跃
     */
    private Integer custStatus;

    /**
     * 用户头像路径
     */
    private String custProfile;

    /**
     * 用户真实姓名
     */
    private String custName;

    /**
     * 用户性别
     */
    private Integer custGender;

    /**
     * 用户姓名
     */
    private Integer custAge;

    /**
     * 用户邮箱
     */
    private String custEmail;

    /**
     * 用户省份
     */
    private String custProvince;

    /**
     * 用户城市
     */
    private String custCity;

    /**
     * 是否签约本网站
     */
    private Integer custIsSign;

    /**
     * 注册时间
     */
    private Date custCreatetime;

    /**
     * 修改时间
     */
    private Date custUpdateTime;

    /**
     * 保留字段
     */
    private String blank1;

    /**
     * 保留字段
     */
    private String blank2;

    public Customer() {
    }


    public Customer(String custNick,String custPhone, String custPassword, String custProfile, Date custCreatetime){
        this.custNick=custNick;
        this.custPhone=custPhone;
        this.custPassword=custPassword;
        this.custProfile=custProfile;
        this.custCreatetime=custCreatetime;
    }

    public Customer(Integer custId,String custNick,String custIntro){
        this.custId=custId;
        this.custNick=custNick;
        this.custIntro=custIntro;
    }

    public Customer(Integer custId,String custProfile){
        this.custId=custId;
        this.custProfile=custProfile;
    }









    private static final long serialVersionUID = 1L;

    public Integer getCustId() {
        return custId;
    }

    public void setCustId(Integer custId) {
        this.custId = custId;
    }

    public String getCustNick() {
        return custNick;
    }

    public void setCustNick(String custNick) {
        this.custNick = custNick;
    }

    public String getCustPassword() {
        return custPassword;
    }

    public void setCustPassword(String custPassword) {
        this.custPassword = custPassword;
    }

    public String getCustIntro() {
        return custIntro;
    }

    public void setCustIntro(String custIntro) {
        this.custIntro = custIntro;
    }

    public String getCustPhone() {
        return custPhone;
    }

    public void setCustPhone(String custPhone) {
        this.custPhone = custPhone;
    }

    public Integer getCustCredits() {
        return custCredits;
    }

    public void setCustCredits(Integer custCredits) {
        this.custCredits = custCredits;
    }

    public Integer getRangeExp() {
        return rangeExp;
    }

    public void setRangeExp(Integer rangeExp) {
        this.rangeExp = rangeExp;
    }

    public Integer getRangeLevel() {
        return rangeLevel;
    }

    public void setRangeLevel(Integer rangeLevel) {
        this.rangeLevel = rangeLevel;
    }

    public Integer getCustStatus() {
        return custStatus;
    }

    public void setCustStatus(Integer custStatus) {
        this.custStatus = custStatus;
    }

    public String getCustProfile() {
        return custProfile;
    }

    public void setCustProfile(String custProfile) {
        this.custProfile = custProfile;
    }

    public String getCustName() {
        return custName;
    }

    public void setCustName(String custName) {
        this.custName = custName;
    }

    public Integer getCustGender() {
        return custGender;
    }

    public void setCustGender(Integer custGender) {
        this.custGender = custGender;
    }

    public Integer getCustAge() {
        return custAge;
    }

    public void setCustAge(Integer custAge) {
        this.custAge = custAge;
    }

    public String getCustEmail() {
        return custEmail;
    }

    public void setCustEmail(String custEmail) {
        this.custEmail = custEmail;
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

    public Integer getCustIsSign() {
        return custIsSign;
    }

    public void setCustIsSign(Integer custIsSign) {
        this.custIsSign = custIsSign;
    }

    public Date getCustCreatetime() {
        return custCreatetime;
    }

    public void setCustCreatetime(Date custCreatetime) {
        this.custCreatetime = custCreatetime;
    }

    public Date getCustUpdateTime() {
        return custUpdateTime;
    }

    public void setCustUpdateTime(Date custUpdateTime) {
        this.custUpdateTime = custUpdateTime;
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
        Customer other = (Customer) that;
        return (this.getCustId() == null ? other.getCustId() == null : this.getCustId().equals(other.getCustId()))
                && (this.getCustNick() == null ? other.getCustNick() == null : this.getCustNick().equals(other.getCustNick()))
                && (this.getCustPassword() == null ? other.getCustPassword() == null : this.getCustPassword().equals(other.getCustPassword()))
                && (this.getCustIntro() == null ? other.getCustIntro() == null : this.getCustIntro().equals(other.getCustIntro()))
                && (this.getCustPhone() == null ? other.getCustPhone() == null : this.getCustPhone().equals(other.getCustPhone()))
                && (this.getCustCredits() == null ? other.getCustCredits() == null : this.getCustCredits().equals(other.getCustCredits()))
                && (this.getRangeExp() == null ? other.getRangeExp() == null : this.getRangeExp().equals(other.getRangeExp()))
                && (this.getRangeLevel() == null ? other.getRangeLevel() == null : this.getRangeLevel().equals(other.getRangeLevel()))
                && (this.getCustStatus() == null ? other.getCustStatus() == null : this.getCustStatus().equals(other.getCustStatus()))
                && (this.getCustProfile() == null ? other.getCustProfile() == null : this.getCustProfile().equals(other.getCustProfile()))
                && (this.getCustName() == null ? other.getCustName() == null : this.getCustName().equals(other.getCustName()))
                && (this.getCustGender() == null ? other.getCustGender() == null : this.getCustGender().equals(other.getCustGender()))
                && (this.getCustAge() == null ? other.getCustAge() == null : this.getCustAge().equals(other.getCustAge()))
                && (this.getCustEmail() == null ? other.getCustEmail() == null : this.getCustEmail().equals(other.getCustEmail()))
                && (this.getCustProvince() == null ? other.getCustProvince() == null : this.getCustProvince().equals(other.getCustProvince()))
                && (this.getCustCity() == null ? other.getCustCity() == null : this.getCustCity().equals(other.getCustCity()))
                && (this.getCustIsSign() == null ? other.getCustIsSign() == null : this.getCustIsSign().equals(other.getCustIsSign()))
                && (this.getCustCreatetime() == null ? other.getCustCreatetime() == null : this.getCustCreatetime().equals(other.getCustCreatetime()))
                && (this.getCustUpdateTime() == null ? other.getCustUpdateTime() == null : this.getCustUpdateTime().equals(other.getCustUpdateTime()))
                && (this.getBlank1() == null ? other.getBlank1() == null : this.getBlank1().equals(other.getBlank1()))
                && (this.getBlank2() == null ? other.getBlank2() == null : this.getBlank2().equals(other.getBlank2()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getCustId() == null) ? 0 : getCustId().hashCode());
        result = prime * result + ((getCustNick() == null) ? 0 : getCustNick().hashCode());
        result = prime * result + ((getCustPassword() == null) ? 0 : getCustPassword().hashCode());
        result = prime * result + ((getCustIntro() == null) ? 0 : getCustIntro().hashCode());
        result = prime * result + ((getCustPhone() == null) ? 0 : getCustPhone().hashCode());
        result = prime * result + ((getCustCredits() == null) ? 0 : getCustCredits().hashCode());
        result = prime * result + ((getRangeExp() == null) ? 0 : getRangeExp().hashCode());
        result = prime * result + ((getRangeLevel() == null) ? 0 : getRangeLevel().hashCode());
        result = prime * result + ((getCustStatus() == null) ? 0 : getCustStatus().hashCode());
        result = prime * result + ((getCustProfile() == null) ? 0 : getCustProfile().hashCode());
        result = prime * result + ((getCustName() == null) ? 0 : getCustName().hashCode());
        result = prime * result + ((getCustGender() == null) ? 0 : getCustGender().hashCode());
        result = prime * result + ((getCustAge() == null) ? 0 : getCustAge().hashCode());
        result = prime * result + ((getCustEmail() == null) ? 0 : getCustEmail().hashCode());
        result = prime * result + ((getCustProvince() == null) ? 0 : getCustProvince().hashCode());
        result = prime * result + ((getCustCity() == null) ? 0 : getCustCity().hashCode());
        result = prime * result + ((getCustIsSign() == null) ? 0 : getCustIsSign().hashCode());
        result = prime * result + ((getCustCreatetime() == null) ? 0 : getCustCreatetime().hashCode());
        result = prime * result + ((getCustUpdateTime() == null) ? 0 : getCustUpdateTime().hashCode());
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
        sb.append(", custId=").append(custId);
        sb.append(", custNick=").append(custNick);
        sb.append(", custPassword=").append(custPassword);
        sb.append(", custIntro=").append(custIntro);
        sb.append(", custPhone=").append(custPhone);
        sb.append(", custCredits=").append(custCredits);
        sb.append(", rangeExp=").append(rangeExp);
        sb.append(", rangeLevel=").append(rangeLevel);
        sb.append(", custStatus=").append(custStatus);
        sb.append(", custProfile=").append(custProfile);
        sb.append(", custName=").append(custName);
        sb.append(", custGender=").append(custGender);
        sb.append(", custAge=").append(custAge);
        sb.append(", custEmail=").append(custEmail);
        sb.append(", custProvince=").append(custProvince);
        sb.append(", custCity=").append(custCity);
        sb.append(", custIsSign=").append(custIsSign);
        sb.append(", custCreatetime=").append(custCreatetime);
        sb.append(", custUpdateTime=").append(custUpdateTime);
        sb.append(", blank1=").append(blank1);
        sb.append(", blank2=").append(blank2);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}