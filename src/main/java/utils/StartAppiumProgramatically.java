package utils;

import org.apache.log4j.Logger;
import java.io.IOException;

public class StartAppiumProgramatically {

    private static Logger logger = Logger.getLogger(StartAppiumProgramatically.class);
    public void startServer() {
        Runtime runtime = Runtime.getRuntime();
        try {
            runtime.exec("cmd.exe /c start cmd.exe /k \"appium --chromedriver-executable .\\src\\main\\resources\\drivers\\mobile\\chromedriver.exe -a 127.0.0.1 -p 4723");
            Thread.sleep(20000);
        } catch (IOException | InterruptedException e) {
            logger.info("Exception thrown");
        }
    }

    public void stopServer() {
        Runtime runtime = Runtime.getRuntime();
        try {
            runtime.exec("taskkill /F /IM node.exe");
            runtime.exec("taskkill /F /IM cmd.exe");
        } catch (IOException e) {
            logger.info("Exception thrown");
        }
    }
}
