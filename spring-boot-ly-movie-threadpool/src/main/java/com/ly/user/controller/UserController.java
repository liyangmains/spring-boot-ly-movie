package com.ly.user.controller;

import com.ly.user.entity.User;
import com.ly.user.service.UserService;
import com.ly.util.page.PageBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/find")
    public User getUserList(Integer id){
        return userService.selectUserInfoById(id);
    }

    @GetMapping("/page")
    public PageBean<User> getUserPage(PageBean<User> page){
        return userService.userPage(page);
    }

}
