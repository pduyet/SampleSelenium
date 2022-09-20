package com.companyName.Utils;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.Properties;

public class PropertiesFile {
    private static Properties properties;

    // get current project path
    static String projectPath = System.getProperty("user.dir");
    static String propertiesFilePath = "src/test/resources/config.properties";
    static String fullPathPropertiesFile = projectPath + "/" + propertiesFilePath;

    public static void setPropertiesFile() {
        properties = new Properties();

        try {
            FileInputStream fileIn = new FileInputStream(fullPathPropertiesFile);

            // load properties file
            properties.load(fileIn);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            System.out.println(e.getCause());
            e.printStackTrace();
        }
    }

    public static void setValue(String key, String value) {
        try {
            FileOutputStream fileOut = new FileOutputStream(fullPathPropertiesFile);
            properties.setProperty(key, value);
            properties.store(fileOut, "Set value in properties file");
        } catch (Exception e) {
            System.out.println(e.getMessage());
            System.out.println(e.getCause());
            e.printStackTrace();
        }
    }

    public static String getPropValue(String key) {
        String value;
        try {
            value = properties.getProperty(key);
            return value;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            System.out.println(e.getCause());
            e.printStackTrace();
        }
        return null;
    }
}
