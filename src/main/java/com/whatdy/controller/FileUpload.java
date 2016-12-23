package com.whatdy.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;

@RequestMapping(value = "/uploadfile")
@Controller
public class FileUpload {

    private static  final String SUCCESS = "success";
    @RequestMapping(value = "upload")
    public String upload(@RequestParam("file")MultipartFile file){
        String originalFilename = file.getOriginalFilename();
        long size = file.getSize();
        System.out.println("文件原名称:"+originalFilename);
        System.out.println("文件原来大小(字节):"+size);
        //文件存储位置
        String path="D://file";
        File targetFile = new File(path,originalFilename);
        if (!targetFile.exists()) {
            targetFile.mkdirs();
        }
        try {
            file.transferTo(targetFile);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return SUCCESS;
    }

}
