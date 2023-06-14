package com.harding.qa.utilities;

import java.io.FileInputStream;
import java.util.*;

public class ConfigReader {
    private static Properties properties;
    static {
        String path = "src/configuration.properties";
        try {
            FileInputStream fileInputStream = new FileInputStream(path);
            properties = new Properties();
            properties.load(fileInputStream);
            fileInputStream.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public static String getProperty(String key){

        return properties.getProperty(key);
    }

    public static void main(String[] args) {
        List<Integer> a=new ArrayList();

    }
}