package utils;

import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import org.apache.commons.io.FileUtils;
import org.apache.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import java.io.File;
import java.io.IOException;

public class TakeScreenshots {
    private static final Logger logger = Logger.getLogger(TakeScreenshots.class);

    public void captureScreenshot(ExtentTest logger, WebDriver webDriver) throws IOException {
        String Base64StringOfScreenshot = "";
        File src = ((TakesScreenshot) webDriver).getScreenshotAs(OutputType.FILE);
        byte[] fileContent = FileUtils.readFileToByteArray(src);
        Base64StringOfScreenshot = "data:image/png;base64," + java.util.Base64.getEncoder().encodeToString(fileContent);
        logger.log(LogStatus.FAIL, "Snapshot below: ");
        logger.log(LogStatus.FAIL, "\n" + logger.addBase64ScreenShot(Base64StringOfScreenshot));
    }
}