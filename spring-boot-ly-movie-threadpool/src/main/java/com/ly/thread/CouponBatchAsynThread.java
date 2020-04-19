package com.ly.thread;

import com.ly.coupon.dto.CouponDto;
import com.ly.coupon.service.CouponService;
import com.ly.user.entity.User;
import com.ly.user.service.UserService;
import com.ly.util.page.PageBean;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class CouponBatchAsynThread {

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

    public CouponBatchAsynThread(UserService userService, CouponService couponService, CouponDto couponDto){
        this.userService = userService;
        this.couponService = couponService;
        this.couponDto = couponDto;
    }

    public String batchAddData(){
        try{
            getTotalPageNum();
            execPool = Executors.newFixedThreadPool(totalPageNum);

            for(int i=0 ; i<100 ; i++){
                Integer pageNum=1;
                while(pageNum <= totalPageNum){
                    PageBean<User> page = new PageBean<User>();
                    page.setPageSize(pageSize);
                    page.setPageNum(pageNum);
                    execPool.submit(()->{
                        new BatchAsynThread(userService,couponService,couponDto,page).run();
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
}
