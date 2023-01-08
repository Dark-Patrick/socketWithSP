package com.lch.socketdemo.web.service.impl;

import com.lch.socketdemo.dao.FileDao;
import com.lch.socketdemo.dao.RecordDao;
import com.lch.socketdemo.entity.FileRecord;
import com.lch.socketdemo.entity.Model;
import com.lch.socketdemo.entity.MyFile;
import com.lch.socketdemo.web.service.FileService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class FileServiceImpl implements FileService {
    @Resource
    private FileDao fileDao;
    @Resource
    private RecordDao recordDao;

    @Override
    public boolean upload(MyFile myFile) {
        return 1 == fileDao.insertFile(myFile);
    }

    @Override
    public List<FileRecord> listImage() {
        return fileDao.listMyFile();
    }

    @Override
    public boolean uploadRecord(FileRecord record) {
        return 1 == fileDao.insertRecord(record);
    }

    @Override
    public Model listRecord() {
        return recordDao.listRecord();
    }
}
