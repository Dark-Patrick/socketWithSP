package com.lch.socketdemo.dao;

import com.lch.socketdemo.entity.User;
import org.apache.ibatis.annotations.Param;

public interface UserDao {
    User getUser(@Param("userName") String userName, @Param("password") String password);
}
