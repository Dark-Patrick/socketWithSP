package com.lch.socketdemo.dao;

import com.lch.socketdemo.entity.Camera;
import com.lch.socketdemo.entity.Employee;
import com.lch.socketdemo.entity.User;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface UserDao {
    User getUser(@Param("userName") String userName, @Param("password") String password);

    Camera getCamera(Integer cid);

    Employee getEmployee(String eid);

    List<Camera> listCamera(@Param("index") Integer index, @Param("size") Integer size);

    int insertCamera(Camera camera);

    int deleteCamera(Integer cid);
}
