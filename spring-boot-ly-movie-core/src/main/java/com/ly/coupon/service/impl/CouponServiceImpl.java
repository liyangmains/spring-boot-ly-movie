package com.ly.coupon.service.impl;

import com.ly.coupon.dao.CouponMapper;
import com.ly.coupon.entity.Coupon;
import com.ly.coupon.service.CouponService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CouponServiceImpl implements CouponService {

    @Autowired
    private CouponMapper couponMapper;

    @Override
    public int addBatchCouponUserRecord(List<Coupon> couponUserList) {
        return couponMapper.insertBatchCouponUserRecord(couponUserList);
    }
}
