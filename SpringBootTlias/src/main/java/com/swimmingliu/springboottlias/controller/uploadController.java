package com.swimmingliu.springboottlias.controller;

import com.swimmingliu.springboottlias.pojo.Result;
import com.swimmingliu.springboottlias.utils.QiNiuCloudOSS;
import jakarta.annotation.Resource;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

@Slf4j
@RestController
public class uploadController {
    @Autowired
    private QiNiuCloudOSS qiNiuCloudOSS;

    @PostMapping("/upload")
    public Result uploadFile(@RequestBody MultipartFile image) throws Exception {
        log.info("上传文件: {}",image);
        String url = qiNiuCloudOSS.uploadFiles(image);
        return Result.success(url);
    }
}
