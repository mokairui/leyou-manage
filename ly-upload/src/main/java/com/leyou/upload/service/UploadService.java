package com.leyou.upload.service;

import com.github.tobato.fastdfs.domain.StorePath;
import com.github.tobato.fastdfs.service.FastFileStorageClient;
import com.leyou.common.enums.ExceptionEnum;
import com.leyou.common.exception.LyException;
import com.leyou.upload.config.UploadProperties;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;

/**
 * @Description
 * @Author Mokairui
 * @Since 2021/10/20
 */
@Service
@Slf4j
@EnableConfigurationProperties({UploadProperties.class})
public class UploadService {

    @Resource
    private FastFileStorageClient storageClient;

    @Resource
    private UploadProperties uploadProperties;

    public String uploadImage(MultipartFile file) {
        try {
            // 检验文件
            String contentType = file.getContentType();
            if (!uploadProperties.getAllowTypes().contains(contentType)) {
                throw new LyException(ExceptionEnum.INVALID_FILE_TYPE);
            }
            // 校验文件内容
            BufferedImage image = ImageIO.read(file.getInputStream());
            if (image == null) {
                throw new LyException(ExceptionEnum.INVALID_FILE_TYPE);
            }

            // 上传到FastDFS
            String extension = StringUtils.substringAfterLast(file.getOriginalFilename(), ".");
            StorePath storePath = storageClient.uploadFile(file.getInputStream(), file.getSize(), extension, null);

            // 返回路径
            return uploadProperties.getBaseUrl() + storePath.getFullPath();
        } catch (IOException e) {
            log.error("上传文件失败!", e);
            throw new LyException(ExceptionEnum.UPLOAD_FILE_ERROR);
        }
    }
}
