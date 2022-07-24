package testscripts.regression.teacherlogin.ReportFeature.TryNewReports;

//Test Cases is blocked due to Ui during execution is different only on Qa-flash. Test Nu 7 is Blocked


import com.relevantcodes.extentreports.LogStatus;
import org.apache.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.Test;
import testscripts.BaseTestScript;
import uipages.flexbook2feature.*;

public class StandardAlignedFlexBookFeatureTest extends BaseTestScript {
    private static final Logger logger = Logger.getLogger(StandardAlignedFlexBookFeatureTest.class);
    private String testCaseFailureText = "Test failed for method: ";
    private String assertFailurePreText = "Failed to verify: ";
    public String assertSuccessPreText = "Successfully verified: ";
    private StandardAlignedFlexBook standardAlignedFlexBook;



    @Test(priority = 1, dataProvider = "CK12DataProvider", description = "Verify Recommend By Subject And Standard Aligned FlexBook Links are available on teacher landing page.")
    public void verifyLinksOnLandingPage(String email, String password) {
        boolean result = true;
        try {
            LoginPage loginPage = new LoginPage(webDriver,extentTest, extentReports);
            CBookLandingPage cBookLandingPage = new CBookLandingPage(webDriver,extentTest,extentReports);
            standardAlignedFlexBook = new StandardAlignedFlexBook(webDriver,extentTest,extentReports);

            cBookLandingPage.clickOnFlexBookLink();
            cBookLandingPage.clickOnSignInIcon();
            loginPage.login(email, password);
            cBookLandingPage.clickOnSignInButton();

            String assertTextVSAI = "Presence of 'Teacher icon' after logging in.";
            Assert.assertTrue(cBookLandingPage.verifyTeacherAccountIcon(), assertFailurePreText + assertTextVSAI);
            reportLog(assertTextVSAI);

            String URL = "https://master.ck12.org/my/dashboard-new/";

            webDriver.navigate().to(URL);

            String assertTextVSA = "Presence of 'Standard Aligned FlexBook' Link.";
            Assert.assertTrue(standardAlignedFlexBook.verifyStandardAlignedFlexBookLink(), assertFailurePreText + assertTextVSA);
            reportLog(assertTextVSA);

        } catch (RuntimeException e) {
            result = handleException(e);
        }
        Assert.assertTrue(result, testCaseFailureText + currentMethodName + errorMessage);
    }

    @Test(priority = 3, description = "Verify Functionality of Recommended By Subjects link.")
    public void verifyFunctionalityOfRecommendBySubjectLink() {
        boolean result = true;
        try {
            String assertTextVSAI = "Presence of 'Trending' Text.";
            Assert.assertTrue(standardAlignedFlexBook.verifyTrendingText(), assertFailurePreText + assertTextVSAI);
            reportLog(assertTextVSAI);

            String assertTextVCAC = "Presence of 'Read' Container.";
            Assert.assertTrue(standardAlignedFlexBook.verifyReadContainer(), assertFailurePreText + assertTextVCAC);
            reportLog(assertTextVCAC);

            String assertTextVSA = "Presence of 'Practice' Container.";
            Assert.assertTrue(standardAlignedFlexBook.verifyPracticeContainer(), assertFailurePreText + assertTextVSA);
            reportLog(assertTextVSA);

        } catch (RuntimeException e) {
            result = handleException(e);
        }
        Assert.assertTrue(result, testCaseFailureText + currentMethodName + errorMessage);
    }

    @Test(priority = 5, description = "Verify Functionality Of Standard Aligned FlexBook link.")
    public void verifyFunctionalityOfStandardAlignedFlexBookLink() {
        boolean result = true;
        try {
            String assertTextVSA = "Presence of 'Standard Aligned FlexBook' Link.";
            Assert.assertTrue(standardAlignedFlexBook.verifyStandardAlignedFlexBookLink(), assertFailurePreText + assertTextVSA);
            reportLog(assertTextVSA);

            standardAlignedFlexBook.clickOnStandardAlignedFlexBookLink();

            String assertTextVSAI = "Presence of 'Standard Aligned FlexBook' Text.";
            Assert.assertTrue(standardAlignedFlexBook.verifyStandardAlignedFlexBookText(), assertFailurePreText + assertTextVSAI);
            reportLog(assertTextVSAI);

            String assertTextVCAC = "Presence of 'Filter' Text.";
            Assert.assertTrue(standardAlignedFlexBook.verifyFilterText(), assertFailurePreText + assertTextVCAC);
            reportLog(assertTextVCAC);

        } catch (RuntimeException e) {
            result = handleException(e);
        }
        Assert.assertTrue(result, testCaseFailureText + currentMethodName + errorMessage);
    }

    @Test(priority = 7, description = "Verify Functionality Of Filter Container.")
    public void verifyFunctionalityOfFilterContainer() {
        boolean result = true;
        try {
            String assertTextVSA = "Presence of 'Filter' Container.";
            Assert.assertTrue(standardAlignedFlexBook.verifyFilterContainer(), assertFailurePreText + assertTextVSA);
            reportLog(assertTextVSA);

            standardAlignedFlexBook.clickOnFilterContainer();

            String assertTextVSAI = "Presence of 'International State CBSC' Link.";
            Assert.assertTrue(standardAlignedFlexBook.verifyInternationalStateCBSCLink(), assertFailurePreText + assertTextVSAI);
            reportLog(assertTextVSAI);

            String assertTextVCAC = "Presence of 'United State California Link' Text.";
            Assert.assertTrue(standardAlignedFlexBook.verifyUnitedStateCaliforniaLink(), assertFailurePreText + assertTextVCAC);
            reportLog(assertTextVCAC);

        } catch (RuntimeException e) {
            result = handleException(e);
        }
        Assert.assertTrue(result, testCaseFailureText + currentMethodName + errorMessage);
    }

    @Test(priority = 9, description = "Verify Functionality Of View More Standards Link.")
    public void verifyFunctionalityOfViewMoreStandardsLink() {
        boolean result = true;
        try {
            String assertTextVSA = "Presence of 'View More Standard' Link.";
            Assert.assertTrue(standardAlignedFlexBook.verifyViewMoreStandardsLink(), assertFailurePreText + assertTextVSA);
            reportLog(assertTextVSA);

            standardAlignedFlexBook.clickOnViewMoreStandardsLink();

            String assertTextVSAI = "Presence of 'International State' Text.";
            Assert.assertTrue(standardAlignedFlexBook.verifyInternationalText(), assertFailurePreText + assertTextVSAI);
            reportLog(assertTextVSAI);

            String assertTextVCAC = "Presence of 'United State' Text.";
            Assert.assertTrue(standardAlignedFlexBook.verifyUnitedStateText(), assertFailurePreText + assertTextVCAC);
            reportLog(assertTextVCAC);

        } catch (RuntimeException e) {
            result = handleException(e);
        }
        Assert.assertTrue(result, testCaseFailureText + currentMethodName + errorMessage);
    }

    @Test(priority = 11, description = "Verify Functionality Of Collapse Link.")
    public void verifyFunctionalityOfCollapseLink() {
        boolean result = true;
        try {
            String assertTextVSA = "Presence of 'Collapse' Link.";
            Assert.assertTrue(standardAlignedFlexBook.verifyCollapseLink(), assertFailurePreText + assertTextVSA);
            reportLog(assertTextVSA);

            standardAlignedFlexBook.clickOnCollapseLink();

            String assertTextVSAI = "Not Presence of 'International State' Text.";
            Assert.assertTrue(standardAlignedFlexBook.verifyInternationalTextIsNotPresent(), assertFailurePreText + assertTextVSAI);
            reportLog(assertTextVSAI);

            String assertTextVCAC = "Not Presence of 'United State' Text.";
            Assert.assertTrue(standardAlignedFlexBook.verifyUnitedStateTextIsNotPresent(), assertFailurePreText + assertTextVCAC);
            reportLog(assertTextVCAC);

        } catch (RuntimeException e) {
            result = handleException(e);
        }
        Assert.assertTrue(result, testCaseFailureText + currentMethodName + errorMessage);
    }

    @Test(priority = 13, description = "Verify Functionality Of Filter Container With International State CBSE Link .")
    public void verifyFunctionalityOfInternationalStateLink() {
        boolean result = true;
        try {
            ExploreNowFeature exploreNowFeature = new ExploreNowFeature(webDriver,extentTest,extentReports);

            String assertTextVSAI = "Presence of 'International State CBSC' Link.";
            Assert.assertTrue(standardAlignedFlexBook.verifyInternationalStateCBSCLink(), assertFailurePreText + assertTextVSAI);
            reportLog(assertTextVSAI);

            standardAlignedFlexBook.clickOnInternationalStateCBSCLink();
//
//            String assertTextVTPOG = "Presence Of 'India Ck12' Banner";
//            Assert.assertTrue(exploreNowFeature.verifyIndiaCK12Banner(), assertFailurePreText + assertTextVTPOG);
//            reportLog(assertTextVTPOG);

            String assertTextVHI = "Presence Of 'Math Container' FlexBook";
            Assert.assertTrue(exploreNowFeature.verifyMathFlexBookContainer(), assertFailurePreText + assertTextVHI);
            reportLog(assertTextVHI);

            String assertTextVSO = "Presence Of 'You Are Viewing' Text.";
            Assert.assertTrue(exploreNowFeature.verifyYouAreViewingText(), assertFailurePreText + assertTextVSO);
            reportLog(assertTextVSO);

        } catch (RuntimeException e) {
            result = handleException(e);
        }
        Assert.assertTrue(result, testCaseFailureText + currentMethodName + errorMessage);
    }

    @Test(priority = 15, description = "Verify Functionality Of Filter Container With United State California Link.")
    public void verifyFunctionalityOfUnitedStateLink() {
        boolean result = true;
        try {
            String url = "https://master.ck12.org/my/dashboard-new/content/standards/";

            webDriver.navigate().to(url);

            String assertTextVSAI = "Presence of 'Standard Aligned FlexBook' Text.";
            Assert.assertTrue(standardAlignedFlexBook.verifyStandardAlignedFlexBookText(), assertFailurePreText + assertTextVSAI);
            reportLog(assertTextVSAI);

            String assertTextVSA = "Presence of 'Filter' Container.";
            Assert.assertTrue(standardAlignedFlexBook.verifyFilterContainer(), assertFailurePreText + assertTextVSA);
            reportLog(assertTextVSA);

            standardAlignedFlexBook.clickOnFilterContainer();

            String assertTextVSI = "Presence of 'International State CBSC' Link.";
            Assert.assertTrue(standardAlignedFlexBook.verifyInternationalStateCBSCLink(), assertFailurePreText + assertTextVSI);
            reportLog(assertTextVSI);

            String assertTextVCAC = "Presence of 'United State California Link' Text.";
            Assert.assertTrue(standardAlignedFlexBook.verifyUnitedStateCaliforniaLink(), assertFailurePreText + assertTextVCAC);
            reportLog(assertTextVCAC);

            standardAlignedFlexBook.clickOnUnitedStateCaliforniaLink();

            String assertTextVTPOG = "Presence of 'Standard Aligned FlexBook' Text.";
            Assert.assertTrue(standardAlignedFlexBook.verifyStandardAlignedFlexBookText(), assertFailurePreText + assertTextVTPOG);
            reportLog(assertTextVTPOG);

        } catch (RuntimeException e) {
            result = handleException(e);
        }
        Assert.assertTrue(result, testCaseFailureText + currentMethodName + errorMessage);
    }

    @Test(priority = 17, description = "Verify Functionality Of Subject Container After Selecting United State.")
    public void verifyFunctionalityOfSubjectContainer() {
        boolean result = true;
        try {
            String assertTextVSAI = "Presence of 'Subject' Container.";
            Assert.assertTrue(standardAlignedFlexBook.verifySubjectContainer(), assertFailurePreText + assertTextVSAI);
            reportLog(assertTextVSAI);

            standardAlignedFlexBook.clickOnSubjectContainer();

            String assertTextVSA = "Presence of 'Algebra Subject' Link.";
            Assert.assertTrue(standardAlignedFlexBook.verifyAlgebraSubjectLink(), assertFailurePreText + assertTextVSA);
            reportLog(assertTextVSA);

            String assertTextVSI = "Presence of 'Biology Subject' Link.";
            Assert.assertTrue(standardAlignedFlexBook.verifyBiologySubjectLink(), assertFailurePreText + assertTextVSI);
            reportLog(assertTextVSI);

            standardAlignedFlexBook.clickOnAlgebraSubjectLink();

            String assertTextVTPOG = "Presence of 'Standard Aligned FlexBook' Text.";
            Assert.assertTrue(standardAlignedFlexBook.verifyStandardAlignedFlexBookText(), assertFailurePreText + assertTextVTPOG);
            reportLog(assertTextVTPOG);

        } catch (RuntimeException e) {
            result = handleException(e);
        }
        Assert.assertTrue(result, testCaseFailureText + currentMethodName + errorMessage);
    }

    @Test(priority = 19, description = "Verify Functionality Of Grade Container After Selecting Subject.")
    public void verifyFunctionalityOfGradeContainer() {
        boolean result = true;
        try {
            String assertTextVSAI = "Presence of 'Grade' Container.";
            Assert.assertTrue(standardAlignedFlexBook.verifyGradeContainer(), assertFailurePreText + assertTextVSAI);
            reportLog(assertTextVSAI);

            standardAlignedFlexBook.clickOnGradeContainer();

            String assertTextVSA = "Presence of '9th Grade' Link.";
            Assert.assertTrue(standardAlignedFlexBook.verify9thGradeLink(), assertFailurePreText + assertTextVSA);
            reportLog(assertTextVSA);

            standardAlignedFlexBook.clickOn9thGradeLink();

            String assertTextVTPOG = "Presence of 'Standard Aligned FlexBook' Text.";
            Assert.assertTrue(standardAlignedFlexBook.verifyStandardAlignedFlexBookText(), assertFailurePreText + assertTextVTPOG);
            reportLog(assertTextVTPOG);

        } catch (RuntimeException e) {
            result = handleException(e);
        }
        Assert.assertTrue(result, testCaseFailureText + currentMethodName + errorMessage);
    }

    @Test(priority = 21, description = "Verify The Results Of FlexBook Are Available After Selecting state, Subject, Grade.")
    public void verifyResultOfFlexBook() {
        boolean result = true;
        try {
            String assertTextVSAI = "Presence of 'FlexBook' Link.";
            Assert.assertTrue(standardAlignedFlexBook.verifyFlexBookLink(), assertFailurePreText + assertTextVSAI);
            reportLog(assertTextVSAI);

            String assertTextVSA = "Presence of 'CA' Link.";
            Assert.assertTrue(standardAlignedFlexBook.verifyCALink(), assertFailurePreText + assertTextVSA);
            reportLog(assertTextVSA);

        } catch (RuntimeException e) {
            result = handleException(e);
        }
        Assert.assertTrue(result, testCaseFailureText + currentMethodName + errorMessage);
    }

    @Test(priority = 23, description = "Verify The Results Of Recommendation Are Visible For All.")
    public void verifyAllRecommendAreVisible() {
        boolean result = true;
        try {
            String assertTextVCAC = "Presence of 'Recommend By Subject' Link.";
            Assert.assertTrue(standardAlignedFlexBook.verifyRecommendBySubjectLink(), assertFailurePreText + assertTextVCAC);
            reportLog(assertTextVCAC);

            String assertTextVSAI = "Presence of 'Trending' Text.";
            Assert.assertTrue(standardAlignedFlexBook.verifyTrendingText(), assertFailurePreText + assertTextVSAI);
            reportLog(assertTextVSAI);

            String assertTextVCC = "Presence of 'Read' Container.";
            Assert.assertTrue(standardAlignedFlexBook.verifyReadContainer(), assertFailurePreText + assertTextVCC);
            reportLog(assertTextVCC);

            String assertTextVSA = "Presence of 'Practice' Container.";
            Assert.assertTrue(standardAlignedFlexBook.verifyPracticeContainer(), assertFailurePreText + assertTextVSA);
            reportLog(assertTextVSA);

        } catch (RuntimeException e) {
            result = handleException(e);
        }
        Assert.assertTrue(result, testCaseFailureText + currentMethodName + errorMessage);
    }

    @Test(priority = 25, description = "Verify The Functionality Of Icon Arrow Right.")
    public void verifyFunctionalityOfIconArrowRight() {
        boolean result = true;
        try {
            String assertTextVCC = "Presence of 'Right Arrow' Icon.";
            Assert.assertTrue(standardAlignedFlexBook.verifyRightArrowIcon(), assertFailurePreText + assertTextVCC);
            reportLog(assertTextVCC);

            standardAlignedFlexBook.clickOnRightArrowIcon();

            String assertTextVCAC = "Presence of 'Recommend By Subject' Link.";
            Assert.assertTrue(standardAlignedFlexBook.verifyRecommendBySubjectLink(), assertFailurePreText + assertTextVCAC);
            reportLog(assertTextVCAC);

            String assertTextVSA = "Presence of 'Left Arrow' Icon.";
            Assert.assertTrue(standardAlignedFlexBook.verifyLeftArrowIcon(), assertFailurePreText + assertTextVSA);
            reportLog(assertTextVSA);

        } catch (RuntimeException e) {
            result = handleException(e);
        }
        Assert.assertTrue(result, testCaseFailureText + currentMethodName + errorMessage);
    }

    @Test(priority = 27, description = "Verify The Functionality Of Icon Arrow Left.")
    public void verifyFunctionalityOfIconArrowLeft() {
        boolean result = true;
        try {
            standardAlignedFlexBook.clickOnLeftArrowIcon();

            String assertTextVCAC = "Presence of 'Recommend By Subject' Link.";
            Assert.assertTrue(standardAlignedFlexBook.verifyRecommendBySubjectLink(), assertFailurePreText + assertTextVCAC);
            reportLog(assertTextVCAC);

            String assertTextVCC = "Presence of 'Right Arrow' Icon.";
            Assert.assertTrue(standardAlignedFlexBook.verifyRightArrowIcon(), assertFailurePreText + assertTextVCC);
            reportLog(assertTextVCC);

            String assertTextVSA = "Presence of 'Read' Container.";
            Assert.assertTrue(standardAlignedFlexBook.verifyReadContainer(), assertFailurePreText + assertTextVSA);
            reportLog(assertTextVSA);

        } catch (RuntimeException e) {
            result = handleException(e);
        }
        Assert.assertTrue(result, testCaseFailureText + currentMethodName + errorMessage);
    }
}