package com.ly.coupon.service;

import com.ly.coupon.entity.Coupon;

import java.util.List;

public interface CouponService {

    int addBatchCouponUserRecord(List<Coupon> couponUserList);
}
