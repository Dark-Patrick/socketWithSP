package com.lch.socketdemo.web.service;

import com.lch.socketdemo.entity.User;
import com.lch.socketdemo.exception.LoginException;

public interface UserService {
    public User getUser(String userName, String password) throws LoginException;
}
