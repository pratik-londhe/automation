package environment;

import constants.Constants;
import org.apache.log4j.Logger;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class PropertyReader {
    private static final Logger logger = Logger.getLogger(PropertyReader.class);
    private static Properties properties = null;

    private PropertyReader() {
    }

    public static Properties getConfigData() {
        try {
            FileInputStream proFileWeb = new FileInputStream(new File(System.getProperty(Constants.USER_DIR) + Constants.PROPERTY_FILE_WEB));
            FileInputStream proFileMobile = new FileInputStream(new File(System.getProperty(Constants.USER_DIR) + Constants.PROPERTY_FILE_MOBILE));
            FileInputStream proFileLogger = new FileInputStream(new File(System.getProperty(Constants.USER_DIR) + Constants.LOGGERS_PROPERTY_FILE));
            properties = new Properties();
            properties.load(proFileWeb);
            properties.load(proFileMobile);
            properties.load(proFileLogger);
        } catch (IOException io) {
            logger.error(io);
        }
        return properties;
    }
}