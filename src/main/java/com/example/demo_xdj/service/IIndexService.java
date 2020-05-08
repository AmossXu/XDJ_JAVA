package com.example.demo_xdj.service;

import com.example.demo_xdj.bean.AjaxResult;
import com.example.demo_xdj.entity.User;
import com.example.demo_xdj.entity.UserHealth;

import java.util.Date;
import java.util.List;

public interface IIndexService {

    List<User> queryUsers();

    List<UserHealth> queryUserHealth();

    AjaxResult login(String username, String password);

    AjaxResult register(String username, String password);


    AjaxResult updatePassword(String username, String password);

    AjaxResult deleteUser(String username);

    AjaxResult userHealth(String username);

    AjaxResult insertHealth(String username, String name, String rbc, String hct);

    AjaxResult userInfo(String username);

    AjaxResult updateUserInfo(String username,String place, String sex, String phonenumber, Integer age, String workplace);

    AjaxResult subscribe(String username, String date ,String time);
}
