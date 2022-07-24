package testscripts.regression.studentlogin.DashBoardFeature.LandingPageFeature;

import com.relevantcodes.extentreports.LogStatus;
import org.apache.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.Test;
import testscripts.BaseTestScript;
import uipages.flexbook2feature.*;

public class BrowsePageFeatureTest extends BaseTestScript {
    private static final Logger logger = Logger.getLogger(BrowsePageFeatureTest.class);
    private String testCaseFailureText = "Test failed for method: ";
    private String assertFailurePreText = "Failed to verify: ";
    public String assertSuccessPreText = "Successfully verified: ";

    @Test(priority = 1, dataProvider = "CK12DataProvider", description = "Verify the 'FlexBook 2.0' container is present inside the explore dropdown.")
    public void verifyFlexBook2LinkIsVisible(String email, String pass) {
        boolean result = true;
        try {
            SchoolFeature schoolFeature = new SchoolFeature(webDriver, extentTest, extentReports);
            BrowseFeature browseFeature = new BrowseFeature(webDriver, extentTest, extentReports);

            new LoginPage(webDriver, extentTest, extentReports).studentLogin(email, pass);

            String assertTextVTPOG = "Student profile icon after login";
            Assert.assertTrue(new StudentDashBoardPage(webDriver, extentTest, extentReports).verifyStudentProfileOnGamma(), assertFailurePreText + assertTextVTPOG);
            reportLog(assertTextVTPOG);

            String assertTextVCNDD = "Presence of 'Header' Container.";
            Assert.assertTrue(schoolFeature.verifyHeaderContainer(), assertFailurePreText + assertTextVCNDD);
            reportLog(assertTextVCNDD);

            schoolFeature.clickOnHeaderContainer();

            String assertTextVML = "Presence of 'FlexBook 2.0 ' Link.";
            Assert.assertTrue(browseFeature.verifyFlexBook2Link(), assertFailurePreText + assertTextVML);
            reportLog(assertTextVML);

        } catch (Exception e) {
            result = handleException(e);
        }
        Assert.assertTrue(result, testCaseFailureText + currentMethodName + errorMessage);
    }

    @Test(priority = 3, description = "Verify Functionality Of 'FlexBook 2.0' Link and verify it redirects to FlexBook Landing Page.")
    public void verifyFunctionalityOfFlexBook2Link() {
        boolean result = true;
        try {
            BrowseFeature browseFeature = new BrowseFeature(webDriver, extentTest, extentReports);

            browseFeature.clickOnFlexBook2Link();
            webDriver.navigate().refresh();

            String assertTextVCNDD = "Presence of 'Ck12 Logo ' Icon.";
            Assert.assertTrue(browseFeature.verifyCk12LogoIcon(), assertFailurePreText + assertTextVCNDD);
            reportLog(assertTextVCNDD);

            String assertTextVTPOG = "Presence Of 'Student Name' Text";
            Assert.assertTrue(browseFeature.verifyStudentNameText(), assertFailurePreText + assertTextVTPOG);
            reportLog(assertTextVTPOG);

        } catch (Exception e) {
            result = handleException(e);
        }
        Assert.assertTrue(result, testCaseFailureText + currentMethodName + errorMessage);
    }

    @Test(priority = 5, description = "Verify Subject DropDown And Donate Icon Are Visible in FlexBook Landing Page.")
    public void verifyDonateAndSubjectDropDownAreVisible() {
        boolean result = true;
        try {
            BrowseFeature browseFeature = new BrowseFeature(webDriver, extentTest, extentReports);

            String assertTextVCNDD = "Presence of 'Donate' Icon.";
            Assert.assertTrue(browseFeature.verifyDonateIcon(), assertFailurePreText + assertTextVCNDD);
            reportLog(assertTextVCNDD);

            String assertTextVTPOG = "Presence Of 'SSubject Arrow Down' Icon";
            Assert.assertTrue(browseFeature.verifySubjectArrowDown(), assertFailurePreText + assertTextVTPOG);
            reportLog(assertTextVTPOG);

        } catch (Exception e) {
            result = handleException(e);
        }
        Assert.assertTrue(result, testCaseFailureText + currentMethodName + errorMessage);
    }

    @Test(priority = 7, description = "Verify 'Start Learning' Tab Is Display on FlexBook Landing Page When the user is Student.")
    public void verifyStartLearningTabIsDisplay() {
        boolean result = true;
        try {
            BrowseFeature browseFeature = new BrowseFeature(webDriver, extentTest, extentReports);

            String assertTextVTPOG = "Presence Of 'Student Name' Text";
            Assert.assertTrue(browseFeature.verifyStudentNameText(), assertFailurePreText + assertTextVTPOG);
            reportLog(assertTextVTPOG);

            String assertTextVCNDD = "Presence of 'Start Learning' Tab.";
            Assert.assertTrue(browseFeature.verifyStartLearningTab(), assertFailurePreText + assertTextVCNDD);
            reportLog(assertTextVCNDD);

        } catch (Exception e) {
            result = handleException(e);
        }
        Assert.assertTrue(result, testCaseFailureText + currentMethodName + errorMessage);
    }

    @Test(priority = 9, description = "Verify Functionality Of 'Start Learning' Tab And Verify it redirects to Math FlexBook Container.")
    public void verifyFunctionalityOfStartLearningTab() {
        boolean result = true;
        try {
            BrowseFeature browseFeature = new BrowseFeature(webDriver, extentTest, extentReports);

            browseFeature.clickOnStartLearningTab();

            String assertTextVTPOG = "Presence Of 'What Do You Want To Learn' Text";
            Assert.assertTrue(browseFeature.verifyWhatDoYouWantToLEarnTodayText(), assertFailurePreText + assertTextVTPOG);
            reportLog(assertTextVTPOG);

            String assertTextVCNDD = "Presence of 'Math' Container.";
            Assert.assertTrue(browseFeature.verifyMathContainer(), assertFailurePreText + assertTextVCNDD);
            reportLog(assertTextVCNDD);

            String assertTextVML = "Presence of 'Ck12 Math FlexBook' Link.";
            Assert.assertTrue(browseFeature.verifyCk12MathFlexBooks(), assertFailurePreText + assertTextVML);
            reportLog(assertTextVML);

        } catch (Exception e) {
            result = handleException(e);
        }
        Assert.assertTrue(result, testCaseFailureText + currentMethodName + errorMessage);
    }

    @Test(priority = 11, description = "Verify Functionality Of Subject DropDown with icon 'arrow down'.")
    public void verifyFunctionalityOfSubjectDownArrowIcon() {
        boolean result = true;
        try {
            BrowseFeature browseFeature = new BrowseFeature(webDriver, extentTest, extentReports);

            browseFeature.scrollScreen();

            String assertTextVCNDD = "Presence of 'Ck12 Logo ' Icon.";
            Assert.assertTrue(browseFeature.verifyCk12LogoIcon(), assertFailurePreText + assertTextVCNDD);
            reportLog(assertTextVCNDD);

            String assertTextVTPOG = "Presence Of 'SSubject Arrow Down' Icon";
            Assert.assertTrue(browseFeature.verifySubjectArrowDown(), assertFailurePreText + assertTextVTPOG);
            reportLog(assertTextVTPOG);

            browseFeature.clickOnSubjectArrowDown();

            String assertTextVML = "Presence of 'Science' Text.";
            Assert.assertTrue(browseFeature.verifyScienceText(), assertFailurePreText + assertTextVML);
            reportLog(assertTextVML);

            String assertTextVNDD = "Presence of 'College' Text.";
            Assert.assertTrue(browseFeature.verifyCollegeText(), assertFailurePreText + assertTextVNDD);
            reportLog(assertTextVNDD);

        } catch (Exception e) {
            result = handleException(e);
        }
        Assert.assertTrue(result, testCaseFailureText + currentMethodName + errorMessage);
    }

    @Test(priority = 13, description = "Verify Functionality Of Subject DropDown with icon 'arrow Up'.")
    public void verifyFunctionalityOfSubjectUpArrowIcon() {
        boolean result = true;
        try {
            BrowseFeature browseFeature = new BrowseFeature(webDriver, extentTest, extentReports);

            String assertTextVCNDD = "Presence of 'Subject Arrow Up' Icon.";
            Assert.assertTrue(browseFeature.verifySubjectArrowUp(), assertFailurePreText + assertTextVCNDD);
            reportLog(assertTextVCNDD);

            browseFeature.clickOnSubjectArrowUp();

            String assertTextVNDD = "Presence of 'Ck12 Logo ' Icon.";
            Assert.assertTrue(browseFeature.verifyCk12LogoIcon(), assertFailurePreText + assertTextVNDD);
            reportLog(assertTextVNDD);

            String assertTextVTPOG = "Presence Of 'SSubject Arrow Down' Icon";
            Assert.assertTrue(browseFeature.verifySubjectArrowDown(), assertFailurePreText + assertTextVTPOG);
            reportLog(assertTextVTPOG);

        } catch (Exception e) {
            result = handleException(e);
        }
        Assert.assertTrue(result, testCaseFailureText + currentMethodName + errorMessage);
    }
}