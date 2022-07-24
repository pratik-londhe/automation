package environment;

import org.apache.log4j.Logger;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

/**
 * Created by pratik.londhe on 8/18/2018.
 */
public class PropertyReader {
    private static final Logger logger = Logger.getLogger(PropertyReader.class);
    private static Properties properties = null;

    private PropertyReader() {

    }

    public static Properties getConfigData() {
        try {
            FileInputStream fileInputStream = new FileInputStream(new File(System.getProperty("user.dir") + "/CK12Config.properties"));
            properties = new Properties();
            properties.load(fileInputStream);
        } catch (IOException io) {
            logger.error(io);
        }
        return properties;
    }
}
