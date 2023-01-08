package com.lch.socketdemo.web.service;

import com.lch.socketdemo.entity.FileRecord;
import com.lch.socketdemo.entity.Model;
import com.lch.socketdemo.entity.MyFile;

import java.util.List;

public interface FileService {

    boolean upload(MyFile image);

    List<FileRecord> listImage();

    boolean uploadRecord(FileRecord record);

    //recordService公用 不再新加一个接口

    Model listRecord();

}
