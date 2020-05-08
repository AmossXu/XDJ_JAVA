package com.example.demo_xdj.service.impl;

import com.example.demo_xdj.bean.AjaxResult;
import com.example.demo_xdj.entity.User;
import com.example.demo_xdj.entity.UserHealth;
import com.example.demo_xdj.mapper.IndexMapper;
import com.example.demo_xdj.service.IIndexService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class IndexServiceImpl implements IIndexService {

    @Autowired
    private IndexMapper indexMapper;

    @Override
    public List<User> queryUsers() {
        List<User> users = indexMapper.queryUsers();
        return users;
    }

    @Override
    public List<UserHealth> queryUserHealth() {
        List<UserHealth> userHealth = indexMapper.queryUserHealth();
        return userHealth;
    }

    @Override
    public AjaxResult login(String username, String password) {
        AjaxResult ajaxResult = new AjaxResult();
        User user = indexMapper.findUser(username,password);
        if (user == null) {
            ajaxResult.error();
            ajaxResult.setMsg("登录失败");
        } else {
            user.setPassword("");
            ajaxResult.success("登录成功",user);
        }
        return ajaxResult;
    }

    @Override
    public AjaxResult register(String username, String password) {
        AjaxResult ajaxResult = new AjaxResult();
        User user = indexMapper.findUserByName(username);
        System.out.println("111");
        if(user != null ){
            ajaxResult.error();
            ajaxResult.setMsg("注册失败，用户名已被注册");
        }else{
            indexMapper.registerUser(username,password);
            ajaxResult.success("注册成功",user);
        }
        return ajaxResult;
    }

    @Override
    public AjaxResult updatePassword(String username, String password) {
        AjaxResult ajaxResult = new AjaxResult();
        User user = indexMapper.findUserByName(username);
        if(user == null ){
            ajaxResult.error();
            ajaxResult.setMsg("失败，用户名不存在" );
        }else{
            indexMapper.updatePassword(username,password);
            ajaxResult.success("修改成功",user);
        }
        return ajaxResult;
    }

    @Override
    public AjaxResult deleteUser(String username) {
        AjaxResult ajaxResult = new AjaxResult();
        User user = indexMapper.findUserByName(username);
        if(user == null ){
            ajaxResult.error();
            ajaxResult.setMsg("失败，用户名不存在" );
        }else{
            indexMapper.deleteUser(username);
            ajaxResult.success("删除成功",user);
        }
        return ajaxResult;
    }

    @Override
    public AjaxResult userHealth(String username) {//单个用户的健康情况调用
        AjaxResult ajaxResult = new AjaxResult();
        User user = indexMapper.findUserByName(username);
        List<UserHealth> userHealth = indexMapper.userHealth(username);
        if(user == null ){
            ajaxResult.error();
            ajaxResult.setMsg("失败，用户名不存在" );
        }else{
            ajaxResult.success("调出成功",userHealth);
        }
        return ajaxResult;
    }

    @Override
    public AjaxResult insertHealth(String username, String name, String rbc, String hct) {
        AjaxResult ajaxResult = new AjaxResult();
        User user = indexMapper.findUserByName(username);
        if(user == null ){
            ajaxResult.error();
            ajaxResult.setMsg("插入失败，用户名不存在");
        }else{
            Date date=new Date();
            indexMapper.insertHealth(username,name,rbc,hct,date);
            ajaxResult.success("插入成功",user);
        }
        return ajaxResult;
    }

    @Override
    public AjaxResult userInfo(String username) {
        AjaxResult ajaxResult = new AjaxResult();
        User user = indexMapper.findUserByName(username);
        if(user == null ){
            ajaxResult.error();
            ajaxResult.setMsg("失败，用户名不存在" );
        }else{
            ajaxResult.success("调出成功",user);
        }
        return ajaxResult;
    }

    @Override
    public AjaxResult updateUserInfo(String username,String place, String sex, String phonenumber, Integer age, String workplace) {
        AjaxResult ajaxResult = new AjaxResult();
        User user = indexMapper.findUserByName(username);
        if(user == null ){
            ajaxResult.error();
            ajaxResult.setMsg("失败，用户名不存在" );
        }else{
            indexMapper.updateUserInfo(username,place,sex,phonenumber,age,workplace);
            ajaxResult.success("修改成功",user);
        }
        return ajaxResult;
    }

    @Override
    public AjaxResult subscribe(String username, String date , String time) {
        AjaxResult ajaxResult = new AjaxResult();
        User user = indexMapper.findUserByName(username);
        if(user == null ){
            ajaxResult.error();
            ajaxResult.setMsg("失败，用户名不存在" );
        }else{
            indexMapper.insertSubscribe(username,date,time,0);
            ajaxResult.success("调出成功",user);
        }
        return ajaxResult;
    }
}
