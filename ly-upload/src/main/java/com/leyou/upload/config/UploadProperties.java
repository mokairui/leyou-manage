package com.leyou.upload.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;

import java.util.List;

/**
 * @Description
 * @Author Mokairui
 * @Since 2021/10/22
 */
@Data
@ConfigurationProperties(prefix = "ly.upload")
public class UploadProperties {
    private String baseUrl;
    private List<String> allowTypes;
}
