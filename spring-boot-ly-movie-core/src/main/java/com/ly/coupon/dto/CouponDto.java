package com.ly.coupon.dto;

import com.ly.coupon.entity.Coupon;

public class CouponDto extends Coupon {

    private Integer pageNum=1;
    private Integer pageSize=10;
    /**
     * 发送优惠券类型1（根据pageNum,pageSize单页用户推送）
     *              2（所有用户）
     */
    private Integer couponType=1;

    public Integer getPageNum() {
        return pageNum;
    }

    public void setPageNum(Integer pageNum) {
        this.pageNum = pageNum;
    }

    public Integer getPageSize() {
        return pageSize;
    }

    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }

    public Integer getCouponType() {
        return couponType;
    }

    public void setCouponType(Integer couponType) {
        this.couponType = couponType;
    }
}
