package com.lch.socketdemo.web.controller;

import com.lch.socketdemo.entity.Camera;
import com.lch.socketdemo.entity.Pojo4Path;
import com.lch.socketdemo.entity.User;
import com.lch.socketdemo.exception.LoginException;
import com.lch.socketdemo.utils.JWTUtil;
import com.lch.socketdemo.web.service.UserService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.List;
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

    @PostMapping("/getPath")
    public Map<String, Object> getPath(@RequestBody Map<String, String> httpMap){
        List<Pojo4Path> pathList = userService.getPath(httpMap.get("id"), httpMap.get("time"));
        Map<String, Object> map = new HashMap<>();
        if(pathList.size() > 0){
            map.put("success", true);
            map.put("msg", pathList);
            return map;
        }
        map.put("success", false);
        return map;
    }

    @GetMapping("/camera/list")
    public Map<String, Object> listCamera(@RequestParam("index") Integer index, @RequestParam("size")Integer size){
        List<Camera> cameraList = userService.listCamera(index, size);
        Map<String, Object> map = new HashMap<>();
        if(!cameraList.isEmpty()){
            map.put("success", true);
            map.put("msg", cameraList);
            return map;
        }
        map.put("success", false);
        return map;
    }

    @PostMapping("/camera/insert")
    public Boolean insertCamera(@RequestBody Camera camera){
        return userService.insertCamera(camera);
    }

    @PostMapping("/camera/delete")
    public Boolean deleteCamera(@RequestBody Map<String, Integer> httpMap){
        return userService.deleteCamera(httpMap.get("cid"));
    }


}
