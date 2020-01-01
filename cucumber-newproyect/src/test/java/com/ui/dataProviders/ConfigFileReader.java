package com.ui.dataProviders;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

public class ConfigFileReader {

    private Properties properties;
    private final String propertyFilePath= "src/test/resources/Configs/Configuration.properties";

    public ConfigFileReader(){
        BufferedReader reader;
        try {
            reader = new BufferedReader(new FileReader(propertyFilePath));
            properties = new Properties();
            try {
                properties.load(reader);
                reader.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            throw new RuntimeException("Configuration.properties not found at " + propertyFilePath);
        }
    }

    public String getChromeDriverPath(){
        String chromeDriverPath = properties.getProperty("chromeDriverPath");
        if(chromeDriverPath!= null) return chromeDriverPath;
        else throw new RuntimeException("chromeDriverPath not specified in the Configuration.properties file.");
    }

    public String getChromeDriver(){
        String chromeDriver = properties.getProperty("chromeDriver");
        if(chromeDriver!= null) return chromeDriver;
        else throw new RuntimeException("chromeDriver not specified in the Configuration.properties file.");
    }
}


