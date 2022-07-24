package testscripts.regression.studentlogin.GroupsFeature.NonLoginUserFeature;

import com.relevantcodes.extentreports.LogStatus;
import org.apache.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.Test;
import testscripts.BaseTestScript;
import uipages.flexbook2feature.*;

public class UserCBookHighLightFunctionalityTest extends BaseTestScript {
    private static final Logger logger = Logger.getLogger(UserCBookHighLightFunctionalityTest.class);

    @Test(priority = 1, description = "Verify the Functionality of 'Highlight' Button On CourseBook Modality Page")
    public void verifyFunctionalityOfHighlightButtonOnModalityPage() {
        boolean result = true;
        try {
            CourseBookDetailsPage courseBookDetailsPage = new CourseBookDetailsPage(webDriver,extentTest,extentReports);
            CBookModalityPage cBookModalityPage = new CBookModalityPage(webDriver,extentTest,extentReports);
            CBookHighLightFunctionality cBookHighLightFunctionality = new CBookHighLightFunctionality(webDriver,extentTest,extentReports);
            CBookLandingPage cBookLandingPage = new CBookLandingPage(webDriver,extentTest,extentReports);
            UserCBookPage userCBookPage = new UserCBookPage(webDriver,extentTest,extentReports);

            cBookLandingPage.clickOnFlexBookLink();
            courseBookDetailsPage.userLogin();
            new CBookPrimaryConceptPage(webDriver,extentTest,extentReports).clickOnStart();

            Assert.assertTrue(cBookModalityPage.verifyLinkOfNextConcept(), "Test Script Field to verify Next Concept Link");
            reportLog("Student Successfully verify Next Concept Link");

            Assert.assertTrue(cBookModalityPage.verifyTocIcon(), "Test Script Field to verify Toc Icon");
            reportLog("Student Successfully verify Toc Icon");

            Assert.assertTrue(cBookHighLightFunctionality.verifyHighlightButton(), "Test Script Field to verify Highlight button");
            reportLog("User Successfully verify Highlight button");

            cBookHighLightFunctionality.clickOnHighLightButton();

            Assert.assertTrue(userCBookPage.verifySignInGoogleButton(), "Test Script Field to verify Yellow Shade Text After HighLight");
            reportLog("User Successfully verify Yellow Shade Text After HighLight");

            webDriver.navigate().refresh();

        } catch (Exception e) {
            result = handleException(e);
        }
        Assert.assertTrue(result, "Test script failed : " + errorMessage);
    }

    @Test(priority = 5, description = "Verify the Functionality of 'Add Note' Button On CourseBook Modality Page")
    public void verifyFunctionalityOfAddNotesButtonOnModalityPage() {
        boolean result = true;
        try {
            CBookHighLightFunctionality cBookHighLightFunctionality = new CBookHighLightFunctionality(webDriver,extentTest,extentReports);
            UserCBookPage userCBookPage = new UserCBookPage(webDriver,extentTest,extentReports);

            Assert.assertTrue(cBookHighLightFunctionality.verifyAddNoteButton(), "Test Script Field to verify Add Note button");
            reportLog("User Successfully verify Add Note button");

            cBookHighLightFunctionality.clickOnAddNotesButton();

            Assert.assertTrue(userCBookPage.verifySignInGoogleButton(), "Test Script Field to verify Yellow Shade Text After HighLight");
            reportLog("User Successfully verify Yellow Shade Text After HighLight");

            webDriver.navigate().refresh();

        } catch (Exception e) {
            result = handleException(e);
        }
        Assert.assertTrue(result, "Failed To Verify" + errorMessage);
    }

    //@Test(priority = 15, description = "Verify the Functionality of 'Highlight' Icon On CourseBook Modality Toolbar")
    public void verifyFunctionalityOfHighlightIconToolbar() {
        boolean result = true;
        try {
            CBookHighLightFunctionality cBookHighLightFunctionality = new CBookHighLightFunctionality(webDriver,extentTest,extentReports);
            UserCBookPage userCBookPage = new UserCBookPage(webDriver,extentTest,extentReports);

            new CBookLandingPage(webDriver,extentTest,extentReports).clickOnFeedBackIcon();

            Assert.assertTrue(cBookHighLightFunctionality.verifyHighlightIcon(), "Test Script Field to verify  Highlight Icon");
            reportLog("User Successfully verify Highlight Icon");

            cBookHighLightFunctionality.clickOnHighlightIcon();

            Assert.assertTrue(cBookHighLightFunctionality.verifyTextHighlightNotes(), "Test Script Field to verify Text Highlight Notes");
            reportLog("User Successfully verify Text Highlight Notes");

            Assert.assertTrue(userCBookPage.verifyPleaseSignInMessageText(), "Test Script Field to verify Please Sign In message Text");
            reportLog("User Successfully verify Please Sign In message Text");

        } catch (Exception e) {
            result = handleException(e);
        }
        Assert.assertTrue(result, "Failed To Verify" + errorMessage);
    }
}