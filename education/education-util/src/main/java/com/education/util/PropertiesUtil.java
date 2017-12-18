package com.education.util;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 * 文件上传下载工具类
 * @author Administrator
 *
 */
public class PropertiesUtil {
    /**
     * 视频存放位置
     */
    public static String video;
    /**
     * 图片存放位置
     */
    public static String img;
    
    /**
     * 文档存放位置
     */
    public static String doc;
    /**
     * 文件下载的ninx服务器位置
     */
    public static String  download;
    static {
        Properties prop = new Properties();
        InputStream in = PropertiesUtil.class.getResourceAsStream("/file.properties");
        try {
            prop.load(in);
            video = prop.getProperty("video").trim();
            img = prop.getProperty("img").trim();
            doc= prop.getProperty("doc").trim();
            download=prop.getProperty("download").trim();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
