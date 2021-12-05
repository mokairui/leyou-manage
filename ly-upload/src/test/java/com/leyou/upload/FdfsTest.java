package com.leyou.upload;

import com.github.tobato.fastdfs.domain.StorePath;
import com.github.tobato.fastdfs.domain.ThumbImageConfig;
import com.github.tobato.fastdfs.service.FastFileStorageClient;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

/**
 * @Description
 * @Author Mokairui
 * @Since 2021/10/22
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class FdfsTest {

    @Resource
    private FastFileStorageClient storageClient;

    @Resource
    private ThumbImageConfig thumbImageConfig;

    @Test
    public void testUpload() throws FileNotFoundException {
        File file = new File("D:\\test\\baby.png");
        // 上传并且生产缩微图
        StorePath storePath = this.storageClient.uploadFile(
                new FileInputStream(file), file.length(), "png", null);
        // 带分组路径
        System.out.println(storePath.getFullPath());
        // 不带分组路径
        System.out.println(storePath.getPath());
    }

    @Test
    public void testUploadAndCreateThumb() throws FileNotFoundException {
        File file = new File("D:\\test\\baby.png");
        // 上传并且生成缩微图
        StorePath storePath = this.storageClient.uploadImageAndCrtThumbImage(
                new FileInputStream(file), file.length(), "png", null);
        // 获取缩微图路径
        String path = thumbImageConfig.getThumbImagePath(storePath.getPath());
        System.out.println(path);
    }

}
