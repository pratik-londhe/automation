package testscripts.regression.teacherlogin.FlexBookFeature.LandingPageFeature;

import com.relevantcodes.extentreports.LogStatus;
import org.apache.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.Test;
import testscripts.BaseTestScript;
import uipages.flexbook2feature.*;

public class GetStartedFeatureTest extends BaseTestScript {
    private static final Logger logger = Logger.getLogger(CBookLandingPageTest.class);
    private String testCaseFailureText = "Test failed for method: ";
    private String assertFailurePreText = "Failed to verify: ";
    public String assertSuccessPreText = "Successfully verified: ";

    @Test(priority = 1, dataProvider = "CK12DataProvider", description = "Verify the 'FlexBook' container is present inside the explore dropdown.")
    public void verifyFlexBookContainerIsVisible(String email, String password) {
        boolean result = true;
        try {
            BrowseFeature browseFeature = new BrowseFeature(webDriver,extentTest,extentReports);

            new LoginPage(webDriver,extentTest, extentReports).teacherLogin(email, password);

            Assert.assertTrue(new TeacherDashboardPage(webDriver,extentTest,extentReports).verifyTeacherProfileOnGamma(), "Failed to verified user profile for CreateCBookUsingModalityTest.");
            extentTest.log(LogStatus.PASS, "User Successfully logged in and verified profile icon.");

            String assertTextVCNDD = "Presence of 'Header' Container.";
            Assert.assertTrue(new SchoolFeature(webDriver,extentTest,extentReports).verifyHeaderContainer(), assertFailurePreText + assertTextVCNDD);
            reportLog(assertTextVCNDD);

            new SchoolFeature(webDriver,extentTest,extentReports).clickOnHeaderContainer();

            String assertTextVLD = "Presence of 'FlexBook 2' Link";
            Assert.assertTrue(browseFeature.verifyFlexBook2Link(), assertFailurePreText + assertTextVLD);
            reportLog(assertTextVLD);

            String assertTextVLC = "Presence of 'FlexBook' link";
            Assert.assertTrue(browseFeature.verifyFlexBookLink(), assertFailurePreText + assertTextVLC);
            reportLog(assertTextVLC);

        } catch (Exception e) {
            result = handleException(e);
        }
        Assert.assertTrue(result, testCaseFailureText + currentMethodName + errorMessage);
    }

    @Test(priority = 3, description = "Verify Functionality Of 'FlexBook' Link and verify it redirects to Browse FlexBook Page.")
    public void verifyFunctionalityOfFlexBookContainer() {
        boolean result = true;
        try {
            BrowseFeature browseFeature = new BrowseFeature(webDriver,extentTest,extentReports);

            String url = "https://master.ck12.org/my/dashboard-new/groups/";
            String browseURL = "https://master.ck12.org/fbbrowse/";

            //browseFeature.clickOnFlexBookLink();
            webDriver.navigate().to(browseURL);

            String assertTextVLL = "Presence of 'Customized Digital FlexBook' link";
            Assert.assertTrue(browseFeature.verifyCustomizedDigitalFlexBookLink(), assertFailurePreText + assertTextVLL);
            reportLog(assertTextVLL);

            webDriver.navigate().to(url);

            String assertTextVCNDD = "Presence of 'Header' Container.";
            Assert.assertTrue(new SchoolFeature(webDriver,extentTest,extentReports).verifyHeaderContainer(), assertFailurePreText + assertTextVCNDD);
            reportLog(assertTextVCNDD);

            new SchoolFeature(webDriver,extentTest,extentReports).clickOnHeaderContainer();

            String assertTextVLD = "Presence of 'FlexBook 2' Link";
            Assert.assertTrue(browseFeature.verifyFlexBook2Link(), assertFailurePreText + assertTextVLD);
            reportLog(assertTextVLD);

            browseFeature.clickOnFlexBook2Link();

            String assertTextVLC = "Presence of 'Ck12 Logo ' Icon";
            Assert.assertTrue(browseFeature.verifyCk12LogoIcon(), assertFailurePreText + assertTextVLC);
            reportLog(assertTextVLC);

        } catch (Exception e) {
            result = handleException(e);
        }
        Assert.assertTrue(result, testCaseFailureText + currentMethodName + errorMessage);
    }

    @Test(priority = 5, description = "Verify 'Get Started ' Tab Is Display on FlexBook LAnding Page When the user is a teacher.\n")
    public void verifyGetStartedTAbIsDisplay() {
        boolean result = true;
        try {
            BrowseFeature browseFeature = new BrowseFeature(webDriver,extentTest,extentReports);

            browseFeature.clickOnFlexBookLink();

            String assertTextVLL = "Presence of 'Donate' Icon";
            Assert.assertTrue(browseFeature.verifyDonateIcon(), assertFailurePreText + assertTextVLL);
            reportLog(assertTextVLL);

            String assertTextVLD = "Presence of 'FlexBook 2' Link";
            Assert.assertTrue(browseFeature.verifyGetStartedTab(), assertFailurePreText + assertTextVLD);
            reportLog(assertTextVLD);

        } catch (Exception e) {
            result = handleException(e);
        }
        Assert.assertTrue(result, testCaseFailureText + currentMethodName + errorMessage);
    }

    @Test(priority = 7, description = "Verify Functionality Of 'Get Started' Tab And Verify it redirects to Math FlexBook Container.")
    public void verifyFunctionalityOfGetStartedTab() {
        boolean result = true;
        try {
            BrowseFeature browseFeature = new BrowseFeature(webDriver,extentTest,extentReports);

            browseFeature.clickOnGetStartedTab();

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
}