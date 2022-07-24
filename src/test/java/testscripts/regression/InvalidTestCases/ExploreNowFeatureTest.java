package testscripts.regression.InvalidTestCases;

import com.relevantcodes.extentreports.LogStatus;
import org.apache.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.Test;
import testscripts.BaseTestScript;
import uipages.flexbook2feature.ExploreNowFeature;
import uipages.flexbook2feature.LoginPage;
import uipages.flexbook2feature.StudentDashBoardPage;


//This is here because Explore Now Pop Up is not coming in the execution through Jenkins

public class ExploreNowFeatureTest extends BaseTestScript {
    private static final Logger logger = Logger.getLogger(ExploreNowFeatureTest.class);
    private String testCaseFailureText = "Test failed for method: ";
    private String assertFailurePreText = "Failed to verify: ";
    public String assertSuccessPreText = "Successfully verified: ";

    private StudentDashBoardPage studentDashBoardPage;
    private ExploreNowFeature exploreNowFeature;



    @Test(priority = 1, dataProvider = "CK12DataProvider", description = "Verify Explore Button Is present in Dashboard Page after Student login.")
    public void verifyExploreNowButtonIsVisible(String email, String password) {
        boolean result = true;
        try {
            studentDashBoardPage = new StudentDashBoardPage(webDriver,extentTest,extentReports);
            exploreNowFeature = new ExploreNowFeature(webDriver,extentTest,extentReports);

            new LoginPage(webDriver,extentTest, extentReports).teacherLogin(email, password);

            String assertTextVTPOG = "Student profile icon after login";
            Assert.assertTrue(studentDashBoardPage.verifyStudentProfileOnGamma(), assertFailurePreText + assertTextVTPOG);
            reportLog(assertTextVTPOG);

            exploreNowFeature.clickOnCk12FoundationIcon();

            String assertTextVHI = "Presence Of 'Explore Now' Button";
            Assert.assertTrue(exploreNowFeature.verifyExploreNowButton(), assertFailurePreText + assertTextVHI);
            reportLog(assertTextVHI);

        } catch (Exception e) {
            result = handleException(e);
        }
        Assert.assertTrue(result, testCaseFailureText + currentMethodName + errorMessage);
    }

    @Test(priority = 3, description = "Verify Functionality Of 'Explore Now'  button of DashBoard Page.")
    public void verifyFunctionalityOfExploreNowButton() {
        boolean result = true;
        try {
            exploreNowFeature.clickOnExploreNowButton();

            String assertTextVTPOG = "Presence Of 'India Ck12' Banner";
            Assert.assertTrue(exploreNowFeature.verifyIndiaCK12Banner(), assertFailurePreText + assertTextVTPOG);
            reportLog(assertTextVTPOG);

            String assertTextVHI = "Presence Of 'Math Container' FlexBook";
            Assert.assertTrue(exploreNowFeature.verifyMathFlexBookContainer(), assertFailurePreText + assertTextVHI);
            reportLog(assertTextVHI);

            String assertTextVSO = "Presence Of 'You Are Viewing' Text.";
            Assert.assertTrue(exploreNowFeature.verifyYouAreViewingText(), assertFailurePreText + assertTextVSO);
            reportLog(assertTextVSO);

        } catch (Exception e) {
            result = handleException(e);
        }
        Assert.assertTrue(result, testCaseFailureText + currentMethodName + errorMessage);
    }

    @Test(priority = 5, description = "Verify FlexBook Are Available for Math, Science, Biology.")
    public void verifyAvailableFlexBook() {
        boolean result = true;
        try {
            String assertTextVHI = "Presence Of 'Math Container' FlexBook";
            Assert.assertTrue(exploreNowFeature.verifyMathFlexBookContainer(), assertFailurePreText + assertTextVHI);
            reportLog(assertTextVHI);

            String assertTextVTPOG = "Presence Of 'Biology Container' FlexBook";
            Assert.assertTrue(exploreNowFeature.verifyBiologyFlexBookContainer(), assertFailurePreText + assertTextVTPOG);
            reportLog(assertTextVTPOG);

            String assertTextVSO = "Presence Of 'Chemistry Container' FlexBook.";
            Assert.assertTrue(exploreNowFeature.verifyChemistryFlexBookContainer(), assertFailurePreText + assertTextVSO);
            reportLog(assertTextVSO);

        } catch (Exception e) {
            result = handleException(e);
        }
        Assert.assertTrue(result, testCaseFailureText + currentMethodName + errorMessage);
    }

    @Test(priority = 7, description = "Verify User Viewing flexBook For CBSE Board.")
    public void verifyFlexBookForCBSEBoard() {
        boolean result = true;
        try {
            String assertTextVSO = "Presence Of 'You Are Viewing' Text.";
            Assert.assertTrue(exploreNowFeature.verifyYouAreViewingText(), assertFailurePreText + assertTextVSO);
            reportLog(assertTextVSO);

            String assertTextVHI = "CbSE Contain Is Selected";
            Assert.assertTrue(exploreNowFeature.verifyCBSEContainIsSelected(), assertFailurePreText + assertTextVHI);
            reportLog(assertTextVHI);

            String assertTextVTPOG = "Presence Of 'Biology Container' FlexBook";
            Assert.assertTrue(exploreNowFeature.verifyBiologyFlexBookContainer(), assertFailurePreText + assertTextVTPOG);
            reportLog(assertTextVTPOG);

        } catch (Exception e) {
            result = handleException(e);
        }
        Assert.assertTrue(result, testCaseFailureText + currentMethodName + errorMessage);
    }

    @Test(priority = 9, description = "Verify Location Is 'India' is By default selected.")
    public void verifyLocationIsIndia() {
        boolean result = true;
        try {
            String assertTextVSO = "Presence Of 'FlexBook In' Text.";
            Assert.assertTrue(exploreNowFeature.verifyFlexBookInText(), assertFailurePreText + assertTextVSO);
            reportLog(assertTextVSO);

            String assertTextVHI = "Presence Of 'India' Location.";
            Assert.assertTrue(exploreNowFeature.verifyIndiaLocationIsSelected(), assertFailurePreText + assertTextVHI);
            reportLog(assertTextVHI);

            String assertTextVTPOG = "Presence Of 'For' Text";
            Assert.assertTrue(exploreNowFeature.verifyForText(), assertFailurePreText + assertTextVTPOG);
            reportLog(assertTextVTPOG);

        } catch (Exception e) {
            result = handleException(e);
        }
        Assert.assertTrue(result, testCaseFailureText + currentMethodName + errorMessage);
    }

    @Test(priority = 11, description = "Verify Functionality Of All Subject DropDown.")
    public void verifyFunctionalityOfSubjectDropDown() {
        boolean result = true;
        try {
            String assertTextVSO = "Presence Of 'Subject' DropDown.";
            Assert.assertTrue(exploreNowFeature.verifySubjectDropDown(), assertFailurePreText + assertTextVSO);
            reportLog(assertTextVSO);

            exploreNowFeature.clickOnSubjectDropDown();

            String assertTextVHI = "Presence Of 'All Subjects' Link.";
            Assert.assertTrue(exploreNowFeature.verifyAllSubjectLink(), assertFailurePreText + assertTextVHI);
            reportLog(assertTextVHI);

            String assertTextVTPOG = "Presence Of 'Math' Link";
            Assert.assertTrue(exploreNowFeature.verifyMathLink(), assertFailurePreText + assertTextVTPOG);
            reportLog(assertTextVTPOG);

        } catch (Exception e) {
            result = handleException(e);
        }
        Assert.assertTrue(result, testCaseFailureText + currentMethodName + errorMessage);
    }

    @Test(priority = 13, description = "Verify Functionality Of All Grade DropDown.")
    public void verifyFunctionalityOfGradeDropDown() {
        boolean result = true;
        try {
            String assertTextVSO = "Presence Of 'Grade' DropDown.";
            Assert.assertTrue(exploreNowFeature.verifyGradeDropDown(), assertFailurePreText + assertTextVSO);
            reportLog(assertTextVSO);

            exploreNowFeature.clickOnGradeDropDown();

            String assertTextVHI = "Presence Of 'All Grade' Link.";
            Assert.assertTrue(exploreNowFeature.verifyAllGradeLink(), assertFailurePreText + assertTextVHI);
            reportLog(assertTextVHI);

            String assertTextVTPOG = "Presence Of '9 th' Link";
            Assert.assertTrue(exploreNowFeature.verifyNienthLink(), assertFailurePreText + assertTextVTPOG);
            reportLog(assertTextVTPOG);

        } catch (Exception e) {
            result = handleException(e);
        }
        Assert.assertTrue(result, testCaseFailureText + currentMethodName + errorMessage);
    }
}