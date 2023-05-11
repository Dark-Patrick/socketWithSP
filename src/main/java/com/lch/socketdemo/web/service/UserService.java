package com.lch.socketdemo.web.service;

import com.lch.socketdemo.entity.Camera;
import com.lch.socketdemo.entity.Model;
import com.lch.socketdemo.entity.Pojo4Path;
import com.lch.socketdemo.entity.User;
import com.lch.socketdemo.exception.LoginException;

import java.util.List;

public interface UserService {
    User getUser(String userName, String password) throws LoginException;

    boolean insertRecord(String cid, String eid, String des);

    Model getModelRec(Integer cid, String eid);

    List<Pojo4Path> getPath(String id, String time);

    List<Camera> listCamera(Integer index, Integer size);

    Boolean insertCamera(Camera camera);

    Boolean deleteCamera(Integer cid);
}
