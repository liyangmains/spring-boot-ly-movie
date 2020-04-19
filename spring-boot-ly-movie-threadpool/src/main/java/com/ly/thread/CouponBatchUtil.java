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
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@Service
public class CouponBatchUtil {

    @Autowired
    private UserService userService;
    @Autowired
    private CouponService couponService;

    private static final Logger log = LoggerFactory.getLogger(CouponBatchUtil.class);
    //每个线程处理的数据量
    private int count=100;
    //定义默认线程池大小
    private static ExecutorService execPool = Executors.newFixedThreadPool(8);

    public String batchAddData(CouponDto couponDto){
        PageBean<User> page = new PageBean<User>();
        page.setPageSize(count);
        Integer pageNum=1;
        while(true){
            page.setPageNum(pageNum++);
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
            execPool.submit(new InsertDate(couponList));
        }
        return null;
    }

    /**
     * 内部类,开启线程批量保存数据
     *
     */
    class  InsertDate  extends Thread{

        private List<Coupon> couponList;
        public  InsertDate(List<Coupon> couponList){
            this.couponList=couponList;
        }

        public void run() {
            couponService.addBatchCouponUserRecord(couponList);
            couponList=null;
        }
    }
}
