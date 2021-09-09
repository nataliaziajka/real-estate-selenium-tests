package config;


import java.io.*;
import java.util.Properties;

public class PropertiesFile {

    public static Properties readPropertiesFile(){
         Properties prop = PropertiesFile.readPropertiesFile();
        try{
            InputStream input = PropertiesFile.class.getClass().getClassLoader().getResourceAsStream("src/test/resources/config.properties");
            prop.load(input);
        }
        catch (Exception e) {
            e.printStackTrace();

        }
        return prop;
    }

}
