package com.fm.entity;

import java.io.Serializable;
import java.util.Date;

/**
 * shoot_order
 * @author 
 */
public class ShootOrder implements Serializable {
    /**
     * 订单编号
     */
    private Integer orderId;

    /**
     * 顾客ID
     */
    private Integer custId;

    /**
     * 套餐ID
     */
    private Integer shootId;

    /**
     * 拍摄地点
     */
    private String shootLoc;

    /**
     * 拍摄时间
     */
    private Date shootTime;

    /**
     * 是否付款(1付款,0未付款)
     */
    private Integer orderPay;

    /**
     * 订单生成时间
     */
    private Date orderCreateTime;

    /**
     * 订单是否结算(1未完成,0已完成)
     */
    private Integer orderStatus;

    private String orderPhone;

    private String blank2;

    private static final long serialVersionUID = 1L;

    public Integer getOrderId() {
        return orderId;
    }

    public void setOrderId(Integer orderId) {
        this.orderId = orderId;
    }

    public Integer getCustId() {
        return custId;
    }

    public void setCustId(Integer custId) {
        this.custId = custId;
    }

    public Integer getShootId() {
        return shootId;
    }

    public void setShootId(Integer shootId) {
        this.shootId = shootId;
    }

    public String getShootLoc() {
        return shootLoc;
    }

    public void setShootLoc(String shootLoc) {
        this.shootLoc = shootLoc;
    }

    public Date getShootTime() {
        return shootTime;
    }

    public void setShootTime(Date shootTime) {
        this.shootTime = shootTime;
    }

    public Integer getOrderPay() {
        return orderPay;
    }

    public void setOrderPay(Integer orderPay) {
        this.orderPay = orderPay;
    }

    public Date getOrderCreateTime() {
        return orderCreateTime;
    }

    public void setOrderCreateTime(Date orderCreateTime) {
        this.orderCreateTime = orderCreateTime;
    }

    public Integer getOrderStatus() {
        return orderStatus;
    }

    public void setOrderStatus(Integer orderStatus) {
        this.orderStatus = orderStatus;
    }

    public String getOrderPhone() {
        return orderPhone;
    }

    public void setOrderPhone(String orderPhone) {
        this.orderPhone = orderPhone;
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
        ShootOrder other = (ShootOrder) that;
        return (this.getOrderId() == null ? other.getOrderId() == null : this.getOrderId().equals(other.getOrderId()))
            && (this.getCustId() == null ? other.getCustId() == null : this.getCustId().equals(other.getCustId()))
            && (this.getShootId() == null ? other.getShootId() == null : this.getShootId().equals(other.getShootId()))
            && (this.getShootLoc() == null ? other.getShootLoc() == null : this.getShootLoc().equals(other.getShootLoc()))
            && (this.getShootTime() == null ? other.getShootTime() == null : this.getShootTime().equals(other.getShootTime()))
            && (this.getOrderPay() == null ? other.getOrderPay() == null : this.getOrderPay().equals(other.getOrderPay()))
            && (this.getOrderCreateTime() == null ? other.getOrderCreateTime() == null : this.getOrderCreateTime().equals(other.getOrderCreateTime()))
            && (this.getOrderStatus() == null ? other.getOrderStatus() == null : this.getOrderStatus().equals(other.getOrderStatus()))
            && (this.getOrderPhone() == null ? other.getOrderPhone() == null : this.getOrderPhone().equals(other.getOrderPhone()))
            && (this.getBlank2() == null ? other.getBlank2() == null : this.getBlank2().equals(other.getBlank2()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getOrderId() == null) ? 0 : getOrderId().hashCode());
        result = prime * result + ((getCustId() == null) ? 0 : getCustId().hashCode());
        result = prime * result + ((getShootId() == null) ? 0 : getShootId().hashCode());
        result = prime * result + ((getShootLoc() == null) ? 0 : getShootLoc().hashCode());
        result = prime * result + ((getShootTime() == null) ? 0 : getShootTime().hashCode());
        result = prime * result + ((getOrderPay() == null) ? 0 : getOrderPay().hashCode());
        result = prime * result + ((getOrderCreateTime() == null) ? 0 : getOrderCreateTime().hashCode());
        result = prime * result + ((getOrderStatus() == null) ? 0 : getOrderStatus().hashCode());
        result = prime * result + ((getOrderPhone() == null) ? 0 : getOrderPhone().hashCode());
        result = prime * result + ((getBlank2() == null) ? 0 : getBlank2().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", orderId=").append(orderId);
        sb.append(", custId=").append(custId);
        sb.append(", shootId=").append(shootId);
        sb.append(", shootLoc=").append(shootLoc);
        sb.append(", shootTime=").append(shootTime);
        sb.append(", orderPay=").append(orderPay);
        sb.append(", orderCreateTime=").append(orderCreateTime);
        sb.append(", orderStatus=").append(orderStatus);
        sb.append(", orderPhone=").append(orderPhone);
        sb.append(", blank2=").append(blank2);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}