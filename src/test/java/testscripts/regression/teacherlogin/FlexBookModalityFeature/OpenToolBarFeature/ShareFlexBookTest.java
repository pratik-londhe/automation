package testscripts.regression.teacherlogin.FlexBookModalityFeature.OpenToolBarFeature;

import com.relevantcodes.extentreports.LogStatus;
import org.apache.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.Test;
import testscripts.BaseTestScript;
import uipages.flexbook2feature.*;

public class ShareFlexBookTest  extends BaseTestScript {
    private static final Logger logger = Logger.getLogger(ShareFlexBookTest.class);
    private String testCaseFailureText = "Test failed for method: ";
    private String assertFailurePreText = "Failed to verify: ";
    public String assertSuccessPreText = "Successfully verified: ";



    @Test(priority = 1, dataProvider = "CK12DataProvider", description = "Verify Share button is available inside action Categary.")
    public void verifyShareButtonIsAvailable(String email, String password) {
        boolean result = true;
        try {
            CourseBookDetailsPage courseBookDetailsPage = new CourseBookDetailsPage(webDriver,extentTest,extentReports);
            CBookModalityPage cBookModalityPage = new CBookModalityPage(webDriver,extentTest,extentReports);
            OpenToolbarFeature openToolbarFeature = new OpenToolbarFeature(webDriver,extentTest,extentReports);

            courseBookDetailsPage.clickOnFirstCBookAndFurtherProcess(email, password);
            new CBookPrimaryConceptPage(webDriver,extentTest,extentReports).clickOnStart();

            /*Assert.assertTrue(cBookModalityPage.verifyAssignAssignmentButton(), "Test Script Field to verify Assign Pop Up");
            extentTest.log(LogStatus.PASS, "Teacher Successfully verify Assign Pop Up");
            logger.info("Teacher Successfully verify Assign Pop Up");
*/
            String assertTextVLNC = "Presence of 'Next Concept' link.";
            Assert.assertTrue(cBookModalityPage.verifyLinkOfNextConcept(), assertFailurePreText + assertTextVLNC);
            reportLog(assertTextVLNC);

            String assertTextVTI = "Presence of 'Open' Button.";
            Assert.assertTrue(openToolbarFeature.verifyOpenButton(), assertFailurePreText + assertTextVTI);
            reportLog(assertTextVTI);

            openToolbarFeature.clickOnOpenButton();

            String assertTextVTIA = "Presence of 'Toolbar' Text.";
            Assert.assertTrue(openToolbarFeature.verifyToolbarText(), assertFailurePreText + assertTextVTIA);
            reportLog(assertTextVTIA);

            String assertTextVODD = "Presence of 'Share' btn.";
            Assert.assertTrue(openToolbarFeature.verifyShareButton(), assertFailurePreText + assertTextVODD);
            reportLog(assertTextVODD);

        } catch (Exception e) {
            result = handleException(e);
        }
        Assert.assertTrue(result, testCaseFailureText + currentMethodName + errorMessage);
    }

    @Test(priority = 2, description = "Verify the Functionality of 'Share' Button")
    public void verifyFunctionalityOfShareButton() {
        boolean result = true;
        try {
            ShareMePage shareMePage=new ShareMePage(webDriver,extentTest,extentReports);
            OpenToolbarFeature openToolbarFeature = new OpenToolbarFeature(webDriver,extentTest,extentReports);

            openToolbarFeature.clickOnShareButton();

            String assertTextVSB = "Presence of 'Send' button.";
            Assert.assertTrue(shareMePage.verifySendButton(), assertFailurePreText + assertTextVSB);
            reportLog(assertTextVSB);

        } catch (Exception e) {
            result = handleException(e);
        }
        Assert.assertTrue(result, testCaseFailureText + currentMethodName + errorMessage);
    }

    @Test(priority = 3, description = "Verify the Functionality of 'Send' Button With InValid Email")
    public void verifyFunctionalitySendButtonWithInValidEmail() {
        boolean result = true;
        try {
            CBookOptionDropDownFeatures cBookOptionDropDownFeatures = new CBookOptionDropDownFeatures(webDriver,extentTest,extentReports);
            ShareMePage shareMePage=new ShareMePage(webDriver,extentTest,extentReports);

            String email = "Pratik";

            cBookOptionDropDownFeatures.clickOnEmailPlaceHolder(email);
            shareMePage.clickOnSendButton();

            String assertTextVSB = "Presence of 'Send' button.";
            Assert.assertTrue(shareMePage.verifySendButton(), assertFailurePreText + assertTextVSB);
            reportLog(assertTextVSB);

            String assertTextVERE = "Presence of Email error message.";
            Assert.assertTrue(shareMePage.verifyEmailRecipientErrMsg(), assertFailurePreText + assertTextVERE);
            reportLog(assertTextVERE);

        } catch (Exception e) {
            result = handleException(e);
        }
        Assert.assertTrue(result, testCaseFailureText + currentMethodName + errorMessage);
    }

    @Test(priority = 4, description = "Verify the Functionality of 'Send' Button With Valid Email")
    public void verifyFunctionalitySendButtonWithValidEmail() {
        boolean result = true;
        try {
            CBookOptionDropDownFeatures cBookOptionDropDownFeatures = new CBookOptionDropDownFeatures(webDriver,extentTest,extentReports);
            ShareMePage shareMePage=new ShareMePage(webDriver,extentTest,extentReports);

            String email = "pratik.londhe@ck12.org";

            cBookOptionDropDownFeatures.clickOnEmailPlaceHolder(email);
            shareMePage.clickOnSendButton();

            String assertTextVDB = "Presence of 'Done' button.";
            Assert.assertTrue(cBookOptionDropDownFeatures.verifyDoneButton(), assertFailurePreText + assertTextVDB);
            reportLog(assertTextVDB);

        } catch (Exception e) {
            result = handleException(e);
        }
        Assert.assertTrue(result, testCaseFailureText + currentMethodName + errorMessage);
    }
}