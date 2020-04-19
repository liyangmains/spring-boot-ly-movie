package com.ly.thread;

import com.google.common.collect.Lists;
import com.ly.coupon.dto.CouponDto;
import com.ly.coupon.entity.Coupon;
import com.ly.coupon.service.CouponService;
import com.ly.user.entity.User;
import com.ly.user.service.UserService;
import com.ly.util.page.PageBean;

import java.util.List;

public class BatchAsynThread implements Runnable{

    private UserService userService;
    private CouponService couponService;
    private CouponDto couponDto;
    private PageBean<User> page;

    public BatchAsynThread(UserService userService, CouponService couponService, CouponDto couponDto,PageBean<User> page){
        this.userService = userService;
        this.couponService = couponService;
        this.couponDto = couponDto;
        this.page = page;
    }
    public String batchAddData(){
        page = userService.userPage(page);
        List<User> userList = page.getPage();
        if(userList== null || userList.size()==0){
            return null;
        }
        List<Coupon> couponList = Lists.newArrayListWithCapacity(userList.size());
        userList.forEach(user -> {
            Coupon coupon = new Coupon();
            coupon.setUserId(user.getId());
            coupon.setCouponName(this.couponDto.getCouponName());
            coupon.setCreateTime(couponDto.getCreateTime());
            coupon.setNewTime(couponDto.getNewTime());
            coupon.setVersion(1);
            coupon.setState(0);
            coupon.setCreateid(1001);
            couponList.add(coupon);
                });
        userList=null;
        couponService.addBatchCouponUserRecord(couponList);
        return null;
    }
    @Override
    public void run() {
        batchAddData();
    }
}
