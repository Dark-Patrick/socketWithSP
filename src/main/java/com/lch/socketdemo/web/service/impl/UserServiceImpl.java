package com.lch.socketdemo.web.service.impl;

import com.lch.socketdemo.dao.RecordDao;
import com.lch.socketdemo.dao.UserDao;
import com.lch.socketdemo.entity.*;
import com.lch.socketdemo.exception.LoginException;
import com.lch.socketdemo.web.service.UserService;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

@Service
public class UserServiceImpl implements UserService {

    @Resource
    private UserDao userDao;
    @Resource
    private RecordDao recordDao;

    @Override
    public User getUser(String userName, String password) throws LoginException{
        User user = userDao.getUser(userName, password);
        if(user == null){throw new LoginException("账号或密码错误");}
        return user;
    }

    @Override
    public boolean insertRecord(String cid, String eid, String des) {
        Date date =new Date();
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        return (1 == recordDao.insertRecord(cid, eid, des, formatter.format(date)));
    }

    /*根据员工id和摄像头id查询表，并判断两者级别
    * 返回model*/
    @Override
    public Model getModelRec(Integer cid, String eid) {
        Camera camera = userDao.getCamera(cid);
        Employee employee = userDao.getEmployee(eid);
        Model model = new Model();
        model.setCategory(employee.getName());
        model.setCl(camera.getCname());
        if(camera.getLevel() > employee.getLevel()){
            model.setDes("边界入侵！人员级别与监控区域不符");
        }
        else {
            model.setDes("无违规行为");
        }
        return model;
    }

    @Override
    public List<Pojo4Path> getPath(String id, String time) {
        return recordDao.getPath(id, time);
    }

    @Override
    public List<Camera> listCamera(Integer index, Integer size) {

        return userDao.listCamera((index - 1) * size, size);
    }

    @Override
    public Boolean insertCamera(Camera camera) {
        return 1 == userDao.insertCamera(camera);
    }

    @Override
    public Boolean deleteCamera(Integer cid) {
        return 1 == userDao.deleteCamera(cid);
    }
}
