package com.iot.brillinx.utils;

import org.apache.log4j.Logger;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 * Created by kaizhao on 10/10/16.
 */
public class Configuration {

    private static final Logger logger = Logger.getLogger(Configuration.class);

    public static final String CONFIG_FILE = "brillinx_iotweb.properties";
    // the restful service url
    public static final String IOT_REST_SERVICE_URL = "IoT_rest_service_url";
    // the upload file directory root, without the suffix like /upload
    public static final String IOT_UPLOAD_FILE_DIRECTORY_ROOT = "IoT_upload_file_directory_root";
    private static Properties properties = null;


    static
    {
        properties = new Properties();
        String configFile = System.getProperty(CONFIG_FILE);
        if(configFile != null) {
            try {
                InputStream ins = new FileInputStream(configFile);
                properties.load(ins);
                ins.close();
            } catch (IOException e) {
                logger.error("configuration",e);
                e.printStackTrace();
            }
        } else {
            try {
                ClassLoader cl = Configuration.class.getClassLoader();
                InputStream ins = cl.getResourceAsStream(CONFIG_FILE);
                properties.load(ins);
            } catch (Exception e) {
                logger.error("configuration",e);
                //e.printStackTrace();
            }
        }
        //System.out.println(properties.getProperty(COLUMN_NAME_WRAPPER));
    }

    /**
     * Initialize from the external file manually, the existing properties will be cleared first.
     * @param file
     */
    public static void initFromFile(File file) {
        properties.clear();
        try {
            InputStream ins = new FileInputStream(file);
            properties.load(ins);
            ins.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Given a key, return the value in configuration file
     * @param key
     * @return
     */
    public static String getValue(String key)
    {
        String value = null;

        if(properties.containsKey(key))
        {
            value = properties.getProperty(key);
        }

        return value;
    }

    public static void main(String[] args)
    {
        String url  = Configuration.getValue(Configuration.IOT_REST_SERVICE_URL);
        System.out.println(url);
    }
}
