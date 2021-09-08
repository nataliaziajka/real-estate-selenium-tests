package config;


import java.io.*;
import java.util.Properties;

public class PropertiesFile {

    public static void readPropertiesFile(){
         Properties prop = new Properties();
        try{
            InputStream input = new FileInputStream("src/test/java/config/config.properties");
            prop.load(input);
        }
        catch (Exception e) {
            e.printStackTrace();

        }}

}
