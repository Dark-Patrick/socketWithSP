package com.lch.socketdemo.web.controller;

import com.lch.socketdemo.entity.FileRecord;
import com.lch.socketdemo.entity.MyFile;
import com.lch.socketdemo.web.service.FileService;
import org.springframework.stereotype.Controller;
import org.springframework.util.ResourceUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

@Controller
@CrossOrigin
public class FileController {
    @Resource
    private FileService fileService;

//    private final static String rootPath =
//            System.getProperty("user.home")+File.separator+fileDir+File.separator;

    @RequestMapping(value = "/file/save", method = RequestMethod.POST)
    @ResponseBody
    public Map<String, Object> fileUpload(@RequestParam("file")MultipartFile file, HttpServletRequest request) throws IOException {
        System.out.println("上传文件函数执行！");
        Map<String, Object> map = new HashMap<>();
        if(file.isEmpty()){
            map.put("success", false);
            return map;
        }
        //文件上传的地址
        String path = ResourceUtils.getURL("classpath:").getPath()+"static/upload";
        String realPath = path.replace('/', '\\').substring(1,path.length());

        String originalFileName = file.getOriginalFilename();
        assert originalFileName != null;
        String newFileName = UUID.randomUUID() + originalFileName.substring(originalFileName.lastIndexOf("."));

        File filePath = new File(realPath, newFileName);
        if(!filePath.getParentFile().exists() || !filePath.getParentFile().isDirectory()){
            filePath.getParentFile().mkdirs();
            System.out.println("创建目录：" + filePath);
        }

        String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + request.getContextPath() + "/";
        System.out.println(basePath);
        MyFile myFile = new MyFile();
        myFile.setPath(newFileName);
        if(fileService.upload(myFile)){
            file.transferTo(filePath);
            String url = realPath;
            map.put("success", true);
            map.put("path", newFileName);
            return map;
        }
        map.put("success", false);
        return map;
    }

    @RequestMapping(value = "/file/upload", method = RequestMethod.POST)
    @ResponseBody
    public boolean upload(HttpServletRequest request, @RequestBody FileRecord record){
        System.out.println("执行了上传方法" + record.getBoilerName());
        return fileService.uploadRecord(record);
    }

    @RequestMapping(value = "/file/list", method = RequestMethod.GET)
    @ResponseBody
    public Map<String, Object> listRecord(){
        Map<String, Object> map = new HashMap<>();
        List<FileRecord> list =  fileService.listImage();
        if(list.size() > 0){
            map.put("success", true);
            map.put("msg", list);
            return map;
        }
        map.put("success", false);
        return map;
    }
}
