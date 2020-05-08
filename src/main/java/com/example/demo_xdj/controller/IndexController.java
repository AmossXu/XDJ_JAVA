package com.example.demo_xdj.controller;

import com.alibaba.fastjson.JSONObject;
import com.example.demo_xdj.bean.AjaxResult;
import com.example.demo_xdj.entity.User;
import com.example.demo_xdj.entity.UserHealth;
import com.example.demo_xdj.service.IIndexService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.*;

@RestController
public class IndexController {

    @Autowired
    private IIndexService indexService;

    @RequestMapping("users_get")
    public AjaxResult users_get(){
        AjaxResult ajaxResult = new AjaxResult();
        List<User> users = indexService.queryUsers();
        ajaxResult.success(users);
        return ajaxResult;
    }

    @RequestMapping("userHealth_get")
    public AjaxResult userHealth_get(){
        AjaxResult ajaxResult = new AjaxResult();
        List<UserHealth> users = indexService.queryUserHealth();
        ajaxResult.success(users);
        return ajaxResult;
    }
//
//    @RequestMapping("user_get")
//    public AjaxResult user_get(){
//        System.out.println("请求users");
//
//        return indexService.user_get();
//    }

    @RequestMapping("login")
    public AjaxResult login(@RequestBody Map<String, String> params){
        System.out.println(params.get("username"));
        return indexService.login(params.get("username"),params.get("password"));
    }

    @RequestMapping("t")
    public JSONObject t(){
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("msg","hello");
        return jsonObject;
    }

    @RequestMapping("register")//用户注册
    public AjaxResult register(@RequestBody Map<String,String> params){
        System.out.println(params.get("username"));
        return indexService.register(params.get("username"),params.get("password"));
    }

    @RequestMapping("insertHealth")//用户个人健康信息插入
    public AjaxResult insertHealth(@RequestBody Map<String,String> params){
        System.out.println(params.get("username"));
        return indexService.insertHealth(params.get("username"),params.get("name"),params.get("rbc"),params.get("hct"));

    }


    @RequestMapping("updatePassword")
    public AjaxResult updatePassword(@RequestBody Map<String,String> params){
        System.out.println(params.get("username"));
        return indexService.updatePassword(params.get("username"),params.get("password"));
    }

    @RequestMapping("updateUserInfo")
    public AjaxResult updateUserInfo(@RequestBody Map<String,String> params){
        System.out.println("更新个人信息");
        return indexService.updateUserInfo(params.get("username"),params.get("place"),params.get("sex"),params.get("phonenumber"),Integer.valueOf(params.get("age")).intValue(),params.get("workplace"));
    }

    @RequestMapping("updateUserHealthInfo")
    public AjaxResult updateUserHealthInfo(){
        return null;
    }

    @RequestMapping("deleteUser")
    public AjaxResult deleteUser(@RequestBody Map<String,String> params){
        System.out.println(params.get("username"));
        return  indexService.deleteUser(params.get("username"));
    }

    @RequestMapping("userHealth")//单个用户的健康信息
    public AjaxResult userHealth(@RequestBody Map<String,String> params){
        System.out.println(params.get("username"));
        return  indexService.userHealth(params.get("username"));
    }

    @RequestMapping("userInfo")//单个用户的信息
    public AjaxResult userInfo(@RequestBody Map<String,String> params){
        System.out.println(params.get("username"));
        return  indexService.userInfo(params.get("username"));
    }

    @RequestMapping("subscribe") // 预约
    public AjaxResult subscribe(@RequestBody Map<String,String> params){
        System.out.println(params.get("username"));
        return  indexService.subscribe(params.get("username"), params.get("date"), params.get("time"));
    }
}
