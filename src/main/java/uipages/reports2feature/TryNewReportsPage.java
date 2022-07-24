package uipages.reports2feature;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import org.openqa.selenium.WebDriver;
import uipages.BasePage;
import utils.GuiControl;

public class TryNewReportsPage extends BasePage {

    private final GuiControl btnCreateAssignment = new GuiControl(getElementMap().get("btnCreateAssignment"), webDriver);
    private final GuiControl className = new GuiControl(getElementMap().get("className"), webDriver);
    private final GuiControl checkboxHeatMap = new GuiControl(getElementMap().get("checkboxHeatMap"), webDriver);
    private final GuiControl iconDownloadCsv = new GuiControl(getElementMap().get("iconDownloadCsv"), webDriver);
    private final GuiControl linkReadReport = new GuiControl(getElementMap().get("linkReadReport"), webDriver);
    private final GuiControl tableReport = new GuiControl(getElementMap().get("tableReport"), webDriver);

    public TryNewReportsPage(WebDriver webDriver, ExtentTest extentTest, ExtentReports extentReports) {
        super(webDriver, extentTest, extentReports);
    }

    public boolean verifyCreateAssignment() {
        return btnCreateAssignment.isElementPresent();
    }

    public boolean verifyClassNameOnNewReportPage() {
        return className.isElementPresent();
    }

    public boolean verifyHeatMapCheckBox() {
        return checkboxHeatMap.isElementPresent();
    }

    public boolean verifyCsvIcon() {
        return iconDownloadCsv.isElementPresent();
    }

    public boolean verifyReadReportLink() {
        return linkReadReport.isElementPresent();
    }

    public boolean verifyTableOnNewReport() {
        return tableReport.isElementPresent();
    }
}