package reports;

import com.relevantcodes.extentreports.ExtentReports;
import environment.PropertyReader;

import java.util.Properties;

public class ExtentManager {
    private static ExtentReports extentReports;
    private static Properties properties;

    private ExtentManager() {
    }

    //Create ExtentReport .html file
    public static synchronized ExtentReports getReporter() {
        properties = PropertyReader.getConfigData();
        if (extentReports == null) {
            extentReports = new ExtentReports("./ExtentReport.html", true);
            extentReports.addSystemInfo("Environment", "<a href='https://qa.csqa.me'>QA</a>").addSystemInfo("Browser Name:", properties.getProperty("browserName")).addSystemInfo("Host-Name", System.getProperty("os.name"));
        }
        return extentReports;
    }
}