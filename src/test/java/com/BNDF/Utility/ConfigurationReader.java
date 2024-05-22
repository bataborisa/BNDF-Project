package com.BNDF.Utility;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ConfigurationReader {

    private  static Properties properties = new Properties();

    static {

        try {
            //2- Open file using FileInputStream
            FileInputStream file = new FileInputStream("configuration.properties");
            //3- Load the "properties" object with "file"
            properties.load(file);

            //Close the file in memory
            file.close();

        } catch (IOException e) {
            System.out.println("FILE NOT FOUND WITH GIVEN PATH!!!");
            e.printStackTrace();
        }

    }

    //Create a utility method to use the object to read
    //4- Use properties object to read from the file

    public static String getProperty(String keyword){
        return  properties.getProperty(keyword);
    }


}
