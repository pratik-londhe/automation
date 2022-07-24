package utils;

import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import io.qameta.allure.Allure;
import io.qameta.allure.Attachment;
import org.apache.commons.io.FileUtils;
import org.apache.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.IOException;

/**
 * Created by pratik.londhe on 8/18/2018.
 */
public class TakePhoto {
    private static final Logger logger = Logger.getLogger(TakePhoto.class);

    /*public void capture(String fileName, (WebDriver webDriver, ExtentTest extentTest)) {
        try {
            File source = ((TakesScreenshot) webDriver).getScreenshotAs(OutputType.FILE);
            FileUtils.copyFile(source, new File("screenshots/" + fileName));

        } catch (IOException io) {
            logger.error(io);
        }
    }*/
    public void captureScreenshot(ExtentTest logger, WebDriver webDriver) throws IOException {
        String Base64StringOfScreenshot = "";
        File src = ((TakesScreenshot) webDriver).getScreenshotAs(OutputType.FILE);
        byte[] fileContent = FileUtils.readFileToByteArray(src);
        Base64StringOfScreenshot = "data:image/png;base64," + java.util.Base64.getEncoder().encodeToString(fileContent);
        logger.log(LogStatus.FAIL, "Snapshot below: ");
        logger.log(LogStatus.FAIL, "\n" + logger.addBase64ScreenShot(Base64StringOfScreenshot));
        Allure.addAttachment("Screenshot", new ByteArrayInputStream(((TakesScreenshot) webDriver).getScreenshotAs(OutputType.BYTES)));
    }
}
