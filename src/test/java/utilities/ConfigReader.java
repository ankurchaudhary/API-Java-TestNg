package utilities;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ConfigReader {

    public static final String DEFAULT_PROPERTIES =
            "src/test/resources/data.properties";

    public static Properties properties;

    public static void initialize() throws IOException {
        properties = new Properties();
        properties.load(new FileInputStream
                (DEFAULT_PROPERTIES));
    }

    public static String get(String key){
        return properties.getProperty(key);
    }
}
