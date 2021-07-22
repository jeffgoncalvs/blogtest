package Helper;

import io.cucumber.messages.internal.com.google.gson.internal.bind.util.ISO8601Utils;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class PropertyHelper {

    private Properties prop;
    private String filePath="1";

    public PropertyHelper() {
        filePath = System.getProperty("user.dir") + "/src/test/resources/config.properties";
        try (InputStream input = new FileInputStream(filePath)) {
            prop = new Properties();
            // load a properties file
            prop.load(input);
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
    public String getUrlBase(String siteName) {
        String keyName = "url."
                .concat(siteName.toLowerCase()).concat(".")
                .concat("base");
        return prop.getProperty(keyName);
    }
}