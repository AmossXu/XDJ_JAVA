package com.example.demo_xdj.mapper;

import com.example.demo_xdj.entity.User;
import com.example.demo_xdj.entity.UserHealth;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public interface IndexMapper {

    @Select("SELECT * FROM `users`")
    List<User> queryUsers();

    @Select("select * from `users` where username = #{0} and password = #{pwd}")
    User findUser(@Param("0") String username, @Param("pwd") String password);

    @Select("select * from `users` where username = #{0}")
    User findUserByName(@Param("0") String username);

    @Insert({"INSERT INTO users (username,password,isManager) VALUES (#{username},#{password},0)"})
    void registerUser(@Param("username")String username, @Param("password")String password);

    @Select("SELECT * FROM `users_health`")
    List<UserHealth> queryUserHealth();

    @Update("UPDATE users SET `password` = #{password} WHERE username =  #{username}")
    void updatePassword(@Param("username")String username, @Param("password")String password);

    @Delete("DELETE FROM users WHERE username = #{username}")
    void deleteUser(@Param("username") String username);

    @Select("select * from `users_health` where username = #{0}")
    List<UserHealth> userHealth(@Param("0") String username);

    @Insert("INSERT INTO users_health (username,name,rbc,hct,date) VALUES (#{username},#{name},#{rbc},#{hct},#{date})")
    void insertHealth(@Param("username")String username,@Param("name") String name,@Param("rbc") String rbc,@Param("hct") String hct,@Param("date") Date date);

    @Update("UPDATE users SET `sex` = #{sex},`phonenumber` = #{phonenumber},`age` = #{age},`workplace` = #{workplace},`place` = #{place} WHERE username =  #{username}")
    void updateUserInfo(@Param("username")String username, @Param("place")String place,@Param("sex") String sex, @Param("phonenumber")String phonenumber,@Param("age") Integer age, @Param("workplace")String workplace);

    @Insert("INSERT INTO subscribe (username,date,time ,flag) VALUES (#{username},#{date},#{time}, #{flag})")
    void insertSubscribe(@Param("username")String username,@Param("date")String date,@Param("time")String time,@Param("flag")Integer flag);
}
