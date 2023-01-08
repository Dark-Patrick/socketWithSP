package com.lch.socketdemo.dao;

import com.lch.socketdemo.entity.FileRecord;
import com.lch.socketdemo.entity.MyFile;

import java.util.List;

public interface FileDao {
    int insertFile(MyFile myFile);

    List<FileRecord> listMyFile();

    int insertRecord(FileRecord fileRecord);
}
