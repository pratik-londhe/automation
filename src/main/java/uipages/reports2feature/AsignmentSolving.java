//package uipages.reports2feature;
//
//import org.apache.log4j.Logger;
//import org.openqa.selenium.WebDriver;
//import uipages.BasePage;
//import utils.GuiControl;
//
//public class AsignmentSolving  extends BasePage {
//    private static final Logger logger = Logger.getLogger(AsignmentSolving.class);
//
//    private final GuiControl linkAssignment = new GuiControl(getElementMap().get("linkAssignment"), webDriver);
//    private final GuiControl iconExpandClose = new GuiControl(getElementMap().get("iconExpandClose"), webDriver);
//
//    public AsignmentSolving(WebDriver webDriver, ExtentTest extentTest, ExtentReports extentReports) {
//        super(webDriver, extentTest, extentReports);
//    }
//
//    public void clickOnAssignmentLink() {
//        if (linkAssignment.isElementPresent()) {
//            linkAssignment.clickJScript();
//            logger.info("Successfully click on Assignment Name Link");
//        }
//    }
//
//    public boolean verifyExpandCloseIcon(){
//        return iconExpandClose.isElementPresent();
//    }
//    public void clickOnExpandCloseIcon() {
//        if (iconExpandClose.isElementPresent()) {
//            iconExpandClose.clickJScript();
//            logger.info("Successfully click on Expand Close Icon");
//        }
//    }
//}
