package utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class PropertiesReader {
    private Properties prop;
    public PropertiesReader() throws IOException {
        if(this.prop == null)
            loadProperties();
    }
    private void loadProperties() throws IOException {
        this.prop = new Properties();
        FileInputStream file = new FileInputStream(new File(System.getProperty("user.dir")+"\\src\\main\\resources\\config.properties"));
        this.prop.load(file);
    }

    public String getProperties(String key){
        return this.prop.getProperty(key);
    }

}
