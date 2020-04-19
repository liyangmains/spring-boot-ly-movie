package com.ly.thread;

import com.google.common.collect.Lists;
import com.ly.coupon.dto.CouponDto;
import com.ly.coupon.entity.Coupon;
import com.ly.coupon.service.CouponService;
import com.ly.user.entity.User;
import com.ly.user.service.UserService;
import com.ly.util.page.PageBean;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Date;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class CouponBatchThread implements Runnable {

    private UserService userService;
    private CouponService couponService;
    private CouponDto couponDto;

    private static final Logger log = LoggerFactory.getLogger(CouponBatchThread.class);

    //每个线程处理的数据量
    private int pageSize=100;
    //总页数
    private int totalPageNum;
    //定义默认线程池大小
    private ExecutorService execPool;

    public Boolean getTotalPageNum(){
        int totalNum = userService.selectUserCount();
        if(totalNum == 0){
            this.totalPageNum = 0;
            return false;
        }else {
            this.totalPageNum = totalNum / this.pageSize;
            if (totalNum % this.pageSize > 0) {
                this.totalPageNum++;
            }
        }
        return true;
    }

    public CouponBatchThread(UserService userService, CouponService couponService, CouponDto couponDto){
        this.userService = userService;
        this.couponService = couponService;
        this.couponDto = couponDto;
    }
    public String batchAddData(CouponDto couponDto){
        try{
            PageBean<User> page = new PageBean<User>();
            page.setPageSize(pageSize);
            getTotalPageNum();
            execPool = Executors.newFixedThreadPool(totalPageNum);
            for(int i=0;i<100;i++){
                Integer pageNum=1;
                while(pageNum <= totalPageNum){
                    page.setPageNum(pageNum);
                    page = userService.userPage(page);
                    List<User> userList = page.getPage();
                    if(userList== null || userList.size()==0){
                        break;
                    }
                    List<Coupon> couponList = Lists.newArrayListWithCapacity(userList.size());
                    Date date = new Date();
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
                    userList=null;
                    /*map.put(pageNum,couponList);*/
                    execPool.submit(new Runnable(){
                        public void run(){
                            log.info("数据：{}",couponList);
                            couponService.addBatchCouponUserRecord(couponList);
                        }
                    });
                    pageNum++;
                }
            }

        }catch (Exception e){
            e.printStackTrace();
            log.error(e.toString() + " 错误所在行数：" + e.getStackTrace()[0].getLineNumber());
        }

        return null;
    }
    @Override
    public void run() {
        batchAddData(couponDto);

    }
}
