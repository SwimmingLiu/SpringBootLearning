package com.swimmingliu.springbootautoconfigurationtest.controller;

import com.swimmingliu.qiniuyunossspringbootautoconfigure.QiNiuCloudOSS;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

@RestController
public class UploadController {

    @Autowired
    private QiNiuCloudOSS qiNiuCloudOSS;

    @PostMapping("/upload")
    public String upload(MultipartFile image) throws Exception {
        //上传文件到阿里云 OSS
        String url = qiNiuCloudOSS.uploadFiles(image);
        return url;
    }

}
