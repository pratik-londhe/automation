package testscripts.regression.JenkinsBlocker;

import com.relevantcodes.extentreports.LogStatus;
import org.apache.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.Test;
import testscripts.BaseTestScript;
import uipages.flexbook2feature.*;

public class SupportFeatureTest  extends BaseTestScript {
    private static final Logger logger = Logger.getLogger(SupportFeatureTest.class);
    private String testCaseFailureText = "Test failed for method: ";
    private String assertFailurePreText = "Failed to verify: ";
    public String assertSuccessPreText = "Successfully verified: ";

    TeacherDashboardPage teacherDashboardPage;
    private SupportFeature supportFeature;



    @Test(priority = 1, description = "Verify 'Support' Button is present Before Teacher Login.")
    public void verifySupportButton() {
        boolean result = true;
        try {
            teacherDashboardPage = new TeacherDashboardPage(webDriver,extentTest,extentReports);
            supportFeature = new SupportFeature(webDriver,extentTest,extentReports);

            new PageMenuTab(webDriver,extentTest,extentReports).clickOnLibraryTab();

            String assertTextVML = "Presence of Support Button";
            Assert.assertTrue(supportFeature.verifySupportButton(), assertFailurePreText + assertTextVML);
            reportLog(assertTextVML);

        } catch (Exception e) {
            result = handleException(e);
        }
        Assert.assertTrue(result, testCaseFailureText + currentMethodName + errorMessage);
    }

    @Test(priority = 2, dataProvider = "CK12DataProvider", description = "Verify 'Support' Button is present in Teacher Dashboard Page.")
    public void verifySupportButton(String email, String password) {
        boolean result = true;
        try {
            new LoginPage(webDriver,extentTest, extentReports).teacherLogin(email, password);

            Assert.assertTrue(teacherDashboardPage.verifyTeacherProfileOnGamma(), "Failed to verify.");
            extentTest.log(LogStatus.PASS, "User Successfully logged in and verified profile icon.");
            logger.info("User Successfully verify and Verify icon as well");

            new PageMenuTab(webDriver,extentTest,extentReports).clickOnLibraryTab();

            Assert.assertTrue(new CourseBookCreateEditAssignDelete(webDriver,extentTest,extentReports).verifyCreateNewDropDown(), "Failed to verified Create New DropDown");
            extentTest.log(LogStatus.PASS, "Successfully verified Create New DropDown");
            logger.info("Successfully verified Create New DropDown");

            String assertTextVML = "Presence of Support Button";
            Assert.assertTrue(supportFeature.verifySupportButton(), assertFailurePreText + assertTextVML);
            reportLog(assertTextVML);

        } catch (Exception e) {
            result = handleException(e);
        }
        Assert.assertTrue(result, testCaseFailureText + currentMethodName + errorMessage);
    }

    @Test(priority = 3, description = "Verify Functionality Of 'Support' Button.")
    public void verifyFunctionalityOfSupportButton() {
        boolean result = true;
        try {
            supportFeature.clickOnSupportButton();
            supportFeature.enterInToParentFrameOfSupport();

            String assertTextVML = "Presence of Support Text";
            Assert.assertTrue(supportFeature.verifySupportText(), assertFailurePreText + assertTextVML);
            reportLog(assertTextVML);

        } catch (Exception e) {
            result = handleException(e);
        }
        Assert.assertTrue(result, testCaseFailureText + currentMethodName + errorMessage);
    }

    @Test(priority = 5, description = "Verify Functionality Of 'Dash' Icon Of support Pop Up.")
    public void verifyFunctionalityOfDashIcon() {
        boolean result = true;
        try {
            String assertTextVML = "Presence of Dash Icon";
            Assert.assertTrue(supportFeature.verifyDashIcon(), assertFailurePreText + assertTextVML);
            reportLog(assertTextVML);

            supportFeature.clickOnDashIcon();
            supportFeature.removeFromParentFrameOfSupport();

            String assertTextVSL = "Presence of Support Button";
            Assert.assertTrue(supportFeature.verifySupportButton(), assertFailurePreText + assertTextVSL);
            reportLog(assertTextVSL);

        } catch (Exception e) {
            result = handleException(e);
        }
        Assert.assertTrue(result, testCaseFailureText + currentMethodName + errorMessage);
    }

    @Test(priority = 7, description = "Verify Functionality Of 'Search' icon after putting value in placeHolder .")
    public void verifyFunctionalityOfSearchIconWithValue() {
        boolean result = true;
        try {
            String text = "Ck12";
            supportFeature.clickOnSupportButton();
            supportFeature.enterInToParentFrameOfSupport();

            String assertTextVML = "Presence of Support Text";
            Assert.assertTrue(supportFeature.verifySupportText(), assertFailurePreText + assertTextVML);
            reportLog(assertTextVML);

            supportFeature.putValueInSearchFieldPlaceHolder(text);

            String assertTextVSL = "Presence of Search  Button";
            Assert.assertTrue(supportFeature.verifySearchIcon(), assertFailurePreText + assertTextVSL);
            reportLog(assertTextVSL);

            supportFeature.clickOnSearchIcon();

            String assertTextVSLh = "Presence of Support Text";
            Assert.assertTrue(supportFeature.verifySupportText(), assertFailurePreText + assertTextVSLh);
            reportLog(assertTextVSLh);

            String assertTextVSLl = "Presence of Top result text";
            Assert.assertTrue(supportFeature.verifyTopResultText(), assertFailurePreText + assertTextVSLl);
            reportLog(assertTextVSLl);

        } catch (Exception e) {
            result = handleException(e);
        }
        Assert.assertTrue(result, testCaseFailureText + currentMethodName + errorMessage);
    }

    @Test(priority = 9, description = "Verify last results is displayed After clicking On  'Support' button .")
    public void verifyLastResultIsDisplay() {
        boolean result = true;
        try {
            supportFeature.clickOnDashIcon();
            supportFeature.removeFromParentFrameOfSupport();

            String assertTextVSL = "Presence of Support Button";
            Assert.assertTrue(supportFeature.verifySupportButton(), assertFailurePreText + assertTextVSL);
            reportLog(assertTextVSL);

            supportFeature.clickOnSupportButton();
            supportFeature.enterInToParentFrameOfSupport();

            String assertTextVML = "Presence of Top Result Text Text";
            Assert.assertTrue(supportFeature.verifyTopResultText(), assertFailurePreText + assertTextVML);
            reportLog(assertTextVML);

        } catch (Exception e) {
            result = handleException(e);
        }
        Assert.assertTrue(result, testCaseFailureText + currentMethodName + errorMessage);
    }

    @Test(priority = 11, description = "Verify Functionality Of 'First Result' Link.")
    public void verifyFunctionalityFirstResultLink() {
        boolean result = true;
        try {
            String assertTextVSL = "Presence of  First Result Link";
            Assert.assertTrue(supportFeature.verifyFirstResultLink(), assertFailurePreText + assertTextVSL);
            reportLog(assertTextVSL);

            supportFeature.clickOnFirstResultLink();

            String assertTextVML = "Presence of Back Icon";
            Assert.assertTrue(supportFeature.verifyBackIcon(), assertFailurePreText + assertTextVML);
            reportLog(assertTextVML);

            String assertTextVSLh = "Presence of Support Text";
            Assert.assertTrue(supportFeature.verifySupportText(), assertFailurePreText + assertTextVSLh);
            reportLog(assertTextVSLh);

        } catch (Exception e) {
            result = handleException(e);
        }
        Assert.assertTrue(result, testCaseFailureText + currentMethodName + errorMessage);
    }

    @Test(priority = 13, description = "Verify Functionality Of 'Back' Icon.")
    public void verifyFunctionalityOfBackIcon() {
        boolean result = true;
        try {
            supportFeature.clickOnBackIcon();

            String assertTextVML = "Presence of Top Result Text Text";
            Assert.assertTrue(supportFeature.verifyTopResultText(), assertFailurePreText + assertTextVML);
            reportLog(assertTextVML);

            String assertTextVSLh = "Presence of Support Text";
            Assert.assertTrue(supportFeature.verifySupportText(), assertFailurePreText + assertTextVSLh);
            reportLog(assertTextVSLh);;

        } catch (Exception e) {
            result = handleException(e);
        }
        Assert.assertTrue(result, testCaseFailureText + currentMethodName + errorMessage);
    }
}