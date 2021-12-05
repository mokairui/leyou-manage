package com.leyou.upload.web;

import com.leyou.upload.service.UploadService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;

/**
 * @Description
 * @Author Mokairui
 * @Since 2021/10/20
 */
@RestController
@RequestMapping("/upload")
public class UploadController {

    @Resource
    private UploadService uploadService;

    @PostMapping("/image")
    public ResponseEntity<String> uploadImage(@RequestParam("file")MultipartFile file) {
        return ResponseEntity.ok(uploadService.uploadImage(file));
    }

}
