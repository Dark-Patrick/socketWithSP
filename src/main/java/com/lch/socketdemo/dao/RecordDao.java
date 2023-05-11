package com.lch.socketdemo.dao;

import com.lch.socketdemo.entity.Model;
import com.lch.socketdemo.entity.Pojo4Path;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface RecordDao {
    Model listRecord();

    int insertRecord(@Param("cl") String cid, @Param("category") String eid,
                     @Param("des") String des, @Param("time") String time);

    List<Pojo4Path> getPath(@Param("name") String name, @Param("time") String time);
}
