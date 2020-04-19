package com.ly.coupon.dao;

import com.ly.coupon.entity.Coupon;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface CouponMapper {

    int insertBatchCouponUserRecord(@Param("couponUserList")List<Coupon> couponUserList);
}
