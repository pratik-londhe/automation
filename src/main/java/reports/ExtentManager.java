package reports;

import com.relevantcodes.extentreports.ExtentReports;

/**
 * Created by pratik.londhe on 8/8/2018.
 */
public class ExtentManager {
    protected static ExtentReports extentReports;

    public synchronized ExtentReports getReporter() {
        if (extentReports == null) {
            extentReports = new ExtentReports("./ExtentReport.html", true);
            extentReports.addSystemInfo("Host Name", "Jenkins-FA-Slave").addSystemInfo("Environment", "QA");
        }
        return extentReports;
    }
}