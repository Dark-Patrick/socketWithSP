package com.lch.socketdemo.web.controller;

import com.lch.socketdemo.entity.User;
import com.lch.socketdemo.exception.LoginException;
import com.lch.socketdemo.utils.JWTUtil;
import com.lch.socketdemo.web.service.UserService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

@RestController
//@RestController = @Controller + @ResponseBody
public class UserController {

    @Resource
    private UserService userService;

    @PostMapping("/login")
    public Map<String, String> login(@RequestBody Map<String, String> httpMap){
        System.out.println(httpMap.get("userName"));
        System.out.println(httpMap.get("password"));
        Map<String, String> map = new HashMap<>();
        try {
            User user = userService.getUser(httpMap.get("userName"), httpMap.get("password"));
            String token = JWTUtil.createToken(user.getUserName(), user.getPassword());
            map.put("success", "true");
            map.put("userName", user.getUserName());
            map.put("token", token);
            return map;

        } catch (Exception e) {
            map.put("success", "false");
            map.put("userName", e.getMessage());
        }
        return map;
    }

    @GetMapping("/checkToken")
    public Boolean checkToken(HttpServletRequest request){
        String token = request.getHeader("token");
        return  JWTUtil.checkToken(token);
    }

}
