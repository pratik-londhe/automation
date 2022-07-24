package testscripts.regression.InvalidTestCases;

import com.relevantcodes.extentreports.LogStatus;
import org.apache.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.Test;
import testscripts.BaseTestScript;
import uipages.flexbook2feature.LatestAssignmentFeature;
import uipages.flexbook2feature.LoginPage;
import uipages.flexbook2feature.StudentDashBoardPage;

public class LatestAssignmentFeatureTest extends BaseTestScript {
    private static final Logger logger = Logger.getLogger(LatestAssignmentFeatureTest.class);
    private String testCaseFailureText = "Test failed for method: ";
    private String assertFailurePreText = "Failed to verify: ";
    public String assertSuccessPreText = "Successfully verified: ";

    private LatestAssignmentFeature latestAssignmentFeature;



    @Test(priority = 1, dataProvider = "CK12DataProvider", description = "Verify Latest Assignment Tab is Display On Student DashBoard Page.")
    public void verifyLatestAssignmentTabIsDisplay(String email, String pass) {
        boolean result = true;
        try {
            latestAssignmentFeature = new LatestAssignmentFeature(webDriver,extentTest,extentReports);
            String url = "https://master.ck12.org/my/dashboard/#latestAssignments";

            new LoginPage(webDriver,extentTest, extentReports).studentLogin(email, pass);

            String assertTextVTPOG = "Student profile icon after login";
            Assert.assertTrue(new StudentDashBoardPage(webDriver,extentTest,extentReports).verifyStudentProfileOnGamma(), assertFailurePreText + assertTextVTPOG);
            reportLog(assertTextVTPOG);

            webDriver.navigate().to(url);

            String assertTextVML = "Presence of 'Latest Assignment' Tab.";
            Assert.assertTrue(latestAssignmentFeature.verifyLatestAssignmentTab(), assertFailurePreText + assertTextVML);
            reportLog(assertTextVML);

        } catch (Exception e) {
            result = handleException(e);
        }
        Assert.assertTrue(result, testCaseFailureText + currentMethodName + errorMessage);
    }

    @Test(priority = 3, description = "Verify Class name, assignment are display on assignments container.")
    public void verifyAssignmentContainer() {
        boolean result = true;
        try {
            String assertTextVML = "Presence of 'Class Name' Text.";
            Assert.assertTrue(latestAssignmentFeature.verifyClassNameText(), assertFailurePreText + assertTextVML);
            reportLog(assertTextVML);

            String assertTextVM = "Presence of 'Assignment Title' Text.";
            Assert.assertTrue(latestAssignmentFeature.verifyAssignmentTitleText(), assertFailurePreText + assertTextVM);
            reportLog(assertTextVM);

            String assertTextVSB = "Presence of 'Start' button.";
            Assert.assertTrue(latestAssignmentFeature.verifyStartButton(), assertFailurePreText + assertTextVSB);
            reportLog(assertTextVSB);

        } catch (Exception e) {
            result = handleException(e);
        }
        Assert.assertTrue(result, testCaseFailureText + currentMethodName + errorMessage);
    }

    @Test(priority = 5, description = "Verify Functionality Of Expand Open Icon.")
    public void verifyFunctionalityOfExpandOpenIcon() {
        boolean result = true;
        try {
            String assertTextVML = "Presence of 'Expand Open' Icon.";
            Assert.assertTrue(latestAssignmentFeature.verifyExpandOpenIcon(), assertFailurePreText + assertTextVML);
            reportLog(assertTextVML);

            latestAssignmentFeature.clickOnExpandOpenIcon();

            String assertTextVM = "Presence of 'Assignment Concept' link.";
            Assert.assertTrue(latestAssignmentFeature.verifyAssignmentConceptLink(), assertFailurePreText + assertTextVM);
            reportLog(assertTextVM);

        } catch (Exception e) {
            result = handleException(e);
        }
        Assert.assertTrue(result, testCaseFailureText + currentMethodName + errorMessage);
    }

    @Test(priority = 7, description = "Verify Functionality Of Expand Close Icon.")
    public void verifyFunctionalityOfExpandCloseIcon() {
        boolean result = true;
        try {
            String assertTextVML = "Presence of 'Expand Close' Icon.";
            Assert.assertTrue(latestAssignmentFeature.verifyExpandCloseIcon(), assertFailurePreText + assertTextVML);
            reportLog(assertTextVML);

            latestAssignmentFeature.clickOnExpandCloseIcon();

            String assertTextVAT = "Presence of 'Latest Assignment' Tab.";
            Assert.assertTrue(latestAssignmentFeature.verifyLatestAssignmentTab(), assertFailurePreText + assertTextVAT);
            reportLog(assertTextVAT);

            String assertTextVM = "Presence of 'Expand Open' Icon.";
            Assert.assertTrue(latestAssignmentFeature.verifyExpandOpenIcon(), assertFailurePreText + assertTextVM);
            reportLog(assertTextVM);

        } catch (Exception e) {
            result = handleException(e);
        }
        Assert.assertTrue(result, testCaseFailureText + currentMethodName + errorMessage);
    }

    //@Test(priority = 9, description = "Verify Functionality of Start Button..")
    public void verifyFunctionalityOfStartButton() {
        boolean result = true;
        try {
            String assertTextVML = "Presence of 'Start' Button.";
            Assert.assertTrue(latestAssignmentFeature.verifyStartButton(), assertFailurePreText + assertTextVML);
            reportLog(assertTextVML);

            latestAssignmentFeature.clickOnStartButton();

            String assertTextVAT = "Presence of 'Header Container' Text.";
            Assert.assertTrue(latestAssignmentFeature.verifyHeaderContainerText(), assertFailurePreText + assertTextVAT);
            reportLog(assertTextVAT);

            String assertTextVM = "Presence of 'Turn In' Button.";
            Assert.assertTrue(latestAssignmentFeature.verifyTurnInButton(), assertFailurePreText + assertTextVM);
            reportLog(assertTextVM);

        } catch (Exception e) {
            result = handleException(e);
        }
        Assert.assertTrue(result, testCaseFailureText + currentMethodName + errorMessage);
    }

    //@Test(priority = 11, description = "Verify Functionality Of Close icon and Verify it redirects to dashboard Page.")
    public void verifyFunctionalityCloseIcon() {
        boolean result = true;
        try {
            String assertTextVML = "Presence of 'Close' Icon.";
            Assert.assertTrue(latestAssignmentFeature.verifyCloseIcon(), assertFailurePreText + assertTextVML);
            reportLog(assertTextVML);

            latestAssignmentFeature.clickOnCloseIcon();

            String assertTextVAT = "Presence of 'Latest Assignment' Tab.";
            Assert.assertTrue(latestAssignmentFeature.verifyLatestAssignmentTab(), assertFailurePreText + assertTextVAT);
            reportLog(assertTextVAT);

        } catch (Exception e) {
            result = handleException(e);
        }
        Assert.assertTrue(result, testCaseFailureText + currentMethodName + errorMessage);
    }

    //@Test(priority = 13, description = "Verify Functionality Of Concept link and Verify it redirects to Assignment Page.")
    public void verifyFunctionalityConceptLink() {
        boolean result = true;
        try {
            String assertTextVML = "Presence of 'Expand Open' Icon.";
            Assert.assertTrue(latestAssignmentFeature.verifyExpandOpenIcon(), assertFailurePreText + assertTextVML);
            reportLog(assertTextVML);

            latestAssignmentFeature.clickOnExpandOpenIcon();

            String assertTextVM = "Presence of 'Assignment Concept' link.";
            Assert.assertTrue(latestAssignmentFeature.verifyAssignmentConceptLink(), assertFailurePreText + assertTextVM);
            reportLog(assertTextVM);

            latestAssignmentFeature.clickOnAssignmentConceptLink();

            String assertTextVAT = "Presence of 'Header Container' Text.";
            Assert.assertTrue(latestAssignmentFeature.verifyHeaderContainerText(), assertFailurePreText + assertTextVAT);
            reportLog(assertTextVAT);

            String assertTextVCI = "Presence of 'Close' Icon.";
            Assert.assertTrue(latestAssignmentFeature.verifyCloseIcon(), assertFailurePreText + assertTextVCI);
            reportLog(assertTextVCI);

            latestAssignmentFeature.clickOnCloseIcon();

            String assertTextVSB = "Presence of 'Latest Assignment' Tab.";
            Assert.assertTrue(latestAssignmentFeature.verifyLatestAssignmentTab(), assertFailurePreText + assertTextVSB);
            reportLog(assertTextVSB);

        } catch (Exception e) {
            result = handleException(e);
        }
        Assert.assertTrue(result, testCaseFailureText + currentMethodName + errorMessage);
    }

   // @Test(priority = 15, description = "Verify Functionality Of Quiz Icon.")
    public void verifyFunctionalityQuizIcon() {
        boolean result = true;
        try {
            String assertTextVML = "Presence of 'Quiz' Icon.";
            Assert.assertTrue(latestAssignmentFeature.verifyQuizIcon(), assertFailurePreText + assertTextVML);
            reportLog(assertTextVML);

            latestAssignmentFeature.clickOnQuizIcon();

            String assertTextVAT = "Presence of 'Header Container' Text.";
            Assert.assertTrue(latestAssignmentFeature.verifyHeaderContainerText(), assertFailurePreText + assertTextVAT);
            reportLog(assertTextVAT);

            String assertTextVCI = "Presence of 'Close' Icon.";
            Assert.assertTrue(latestAssignmentFeature.verifyCloseIcon(), assertFailurePreText + assertTextVCI);
            reportLog(assertTextVCI);

        } catch (Exception e) {
            result = handleException(e);
        }
        Assert.assertTrue(result, testCaseFailureText + currentMethodName + errorMessage);
    }
}