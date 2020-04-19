package com.ly.coupon.controller;

import com.google.common.collect.Lists;
import com.ly.coupon.dto.CouponDto;
import com.ly.coupon.entity.Coupon;
import com.ly.coupon.service.CouponService;
import com.ly.thread.CouponBatchAsynThread;
import com.ly.thread.CouponBatchUtil;
import com.ly.user.entity.User;
import com.ly.user.service.UserService;
import com.ly.util.page.PageBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;
import java.util.List;

/**
 * https://www.jianshu.com/p/e1adaae523ec
 */
@RestController
@RequestMapping("/coupon")
public class CouponController {

    @Autowired
    private UserService userService;
    @Autowired
    private CouponService couponService;
    @Autowired
    private CouponBatchUtil couponBatchUtil;

    @PostMapping("/add")
    public Boolean addCoupon(@RequestBody CouponDto couponDto){
        Date date = new Date();
        couponDto.setCreateTime(date);
        couponDto.setNewTime(date);
        if(couponDto.getCouponType() == 2){
//            couponBatchUtil.batchAddData(couponDto);
            new CouponBatchAsynThread(userService,couponService,couponDto).batchAddData();
        }else {
            PageBean<User> page = new PageBean<User>();
            page.setPageNum(couponDto.getPageNum());
            page.setPageSize(couponDto.getPageSize());
            page = userService.userPage(page);
            List<User> userList = page.getPage();
            if (userList == null || userList.size() == 0) {
                return false;
            }
            List<Coupon> couponList = Lists.newArrayListWithCapacity(userList.size());
            userList.forEach(user -> {
                Coupon coupon = new Coupon();
                coupon.setUserId(user.getId());
                coupon.setCouponName(couponDto.getCouponName());
                coupon.setCreateTime(date);
                coupon.setNewTime(date);
                coupon.setVersion(1);
                coupon.setState(0);
                coupon.setCreateid(1001);
                couponList.add(coupon);
            });
            couponService.addBatchCouponUserRecord(couponList);
        }
        return true;
    }
}
