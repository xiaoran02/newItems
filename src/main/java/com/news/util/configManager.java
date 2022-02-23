package com.news.util;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 *  读取Properties文件的配置类
 */
public class configManager {

    private static Properties props = null;

    static {
        InputStream resourceAsStream = configManager.class.getClassLoader().getResourceAsStream
                ("database.properties");
        if (resourceAsStream == null) throw new RuntimeException("找不到数据库参数配置文件！");
        //创建properties对象
        props = new Properties();
        try {
            props.load(resourceAsStream);
        } catch (IOException e) {
            throw  new RuntimeException("数据库配置参数加载错误！",e);

        }finally {
            try {
                resourceAsStream.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public static String getProperty(String key){ //键 Driver
        return props.getProperty(key);   //值
    }
}



