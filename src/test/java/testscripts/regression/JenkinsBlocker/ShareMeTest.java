package testscripts.regression.JenkinsBlocker;

import com.relevantcodes.extentreports.LogStatus;
import org.apache.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.Test;
import testscripts.BaseTestScript;
import uipages.BasePage;
import uipages.flexbook2feature.CBookPageStudent;
import uipages.flexbook2feature.CourseBookDetailsPage;
import uipages.flexbook2feature.ShareMePage;

public class ShareMeTest extends BaseTestScript {
    private static final Logger logger = Logger.getLogger(ShareMeTest.class);

    private BasePage basePage = new BasePage(webDriver,extentTest,extentReports);

    private final long timeStamp = basePage.currentTimeStamp();
    private final String temFullName = "testStudent_" + timeStamp;
    private final String tempEmailFrom = temFullName + "@test.com";
    private final String tempEmailRecipient = temFullName + "@test1.com";

    private ShareMePage shareMePage;

    @Test(priority = 1, dataProvider = "CK12DataProvider", description = "Verify UI validation when 'Full Name' field on 'Share Me' popup is blank")
    public void shareMeEmptyFullName(String email, String password) {
        boolean result = true;
        try {
            shareMePage = new ShareMePage(webDriver,extentTest,extentReports);
            CourseBookDetailsPage courseBookDetailsPage = new CourseBookDetailsPage(webDriver,extentTest,extentReports);
            CBookPageStudent cBookPageStudent = new CBookPageStudent(webDriver,extentTest,extentReports);

            cBookPageStudent.clickOnTryItNowPopUp(email, password);
            courseBookDetailsPage.clickOnFirstFlexBook();

            Assert.assertTrue(courseBookDetailsPage.verifyChooseButton(), "Test Script Field to Verify Choose Button");
            extentTest.log(LogStatus.PASS, "Teacher Successfully  Verify Choose Button");
            logger.info("Teacher Successfully verify Choose Button");

            shareMePage.clickOnShareMeWidget();
            shareMePage.setFullNameField("");
            shareMePage.setEmailFromField(tempEmailFrom);
            shareMePage.setEmailRecipientField(tempEmailRecipient);
            shareMePage.clickOnSendButton();

            Assert.assertTrue(shareMePage.verifyFullNameErrMsg(), "Failed to verify full name.");
            extentTest.log(LogStatus.PASS, "UI validation for empty 'Full Name' field verified.");
            logger.info("UI validation for empty Full Name field verified.");

        } catch (Exception e) {
            result = handleException(e);
        }
        Assert.assertTrue(result, "Test script failed for shareMeEmptyFullName method: " + errorMessage);
    }


    @Test(priority = 2, description = "Verify UI validation when 'Email From' field on 'Share Me' popup is blank")
    public void shareMeEmptyEmailFrom() {
        boolean result = true;
        try {
            shareMePage.clickOnCloseButton();
            shareMePage.clickOnShareMeWidget();
            shareMePage.setFullNameField(temFullName);
            shareMePage.setEmailFromField("");
            shareMePage.setEmailRecipientField(tempEmailRecipient);
            shareMePage.clickOnSendButton();

            Assert.assertTrue(shareMePage.verifyEmailFromErrMsg(), "Failed to verify empty email.");
            extentTest.log(LogStatus.PASS, "UI validation for empty 'Email From' field verified.");
            logger.info("UI validation for empty 'Email From' field verified.");
        } catch (Exception e) {
            result = handleException(e);
        }
        Assert.assertTrue(result, "Test script failed for shareMeEmptyEmailFrom method: " + errorMessage);
    }

    @Test(priority = 3, description = "Verify UI validation when 'Email Recipient' field on 'Share Me' popup is blank")
    public void shareMeEmptyEmailRecipient() {
        boolean result = true;
        try {
            shareMePage.clickOnCloseButton();
            shareMePage.clickOnShareMeWidget();
            shareMePage.setFullNameField(temFullName);
            shareMePage.setEmailFromField(tempEmailFrom);
            shareMePage.setEmailRecipientField("");
            shareMePage.clickOnSendButton();
            Assert.assertTrue(shareMePage.verifyEmailRecipientErrMsg());

            Assert.assertTrue(shareMePage.verifyEmailRecipientErrMsg(), "Failed to verify error message.");
            extentTest.log(LogStatus.PASS, "UI validation for empty 'Email Recipient' field verified.");
            logger.info("UI validation for empty 'Email Recipient' field verified.");
        } catch (Exception e) {
            result = handleException(e);
        }
        Assert.assertTrue(result, "Test script failed for shareMeEmptyEmailRecipient method: " + errorMessage);
    }
}