package com.lch.socketdemo.web.service.impl;

import com.lch.socketdemo.dao.UserDao;
import com.lch.socketdemo.entity.User;
import com.lch.socketdemo.exception.LoginException;
import com.lch.socketdemo.web.service.UserService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class UserServiceImpl implements UserService {

    @Resource
    private UserDao userDao;

    @Override
    public User getUser(String userName, String password) throws LoginException{
        User user = userDao.getUser(userName, password);
        if(user == null){throw new LoginException("账号或密码错误");}
        return user;
    }
}
