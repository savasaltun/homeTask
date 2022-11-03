package com.utilities;

public class ApiUtils {
    public  static String getBaseUrl(){
        String baseUrl = ConfigurationReader.getProperty("apiUrl");
        return baseUrl;
    }
}
