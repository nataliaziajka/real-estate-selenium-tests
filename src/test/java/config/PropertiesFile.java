package config;


import java.io.*;
import java.util.Properties;

public class PropertiesFile {

    public static Properties readPropertiesFile(){
         Properties prop = new Properties();
        try{
            InputStream input = getClass().getClassLoader().getResourceAsStream(prop);
            prop.load(input);
        }
        catch (Exception e) {
            e.printStackTrace();

        }
        return prop;
    }

}
