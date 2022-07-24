package testscripts.regression.teacherlogin.ExploreFeature.AdaptivePracticeFeature;

import com.relevantcodes.extentreports.LogStatus;
import org.apache.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.Test;
import testscripts.BaseTestScript;
import uipages.flexbook2feature.AdaptivePracticeFeature;
import uipages.flexbook2feature.LoginPage;
import uipages.flexbook2feature.SchoolFeature;
import uipages.flexbook2feature.TeacherDashboardPage;

public class AdaptivePracticeFeatureTest extends BaseTestScript {
    private static final Logger logger = Logger.getLogger(AdaptivePracticeFeatureTest.class);
    private String testCaseFailureText = "Test failed for method: ";
    private String assertFailurePreText = "Failed to verify: ";
    public String assertSuccessPreText = "Successfully verified: ";

    @Test(priority = 1, dataProvider = "CK12DataProvider", description = "Verify 'Adaptive Practice' Container Are Available inside the explore DropDown.")
    public void verifyAdaptivePracticeContainerIsVisible(String email, String password) {
        boolean result = true;
        try {
            SchoolFeature schoolFeature = new SchoolFeature(webDriver, extentTest, extentReports);
            AdaptivePracticeFeature adaptivePracticeFeature = new AdaptivePracticeFeature(webDriver, extentTest, extentReports);

            new LoginPage(webDriver, extentTest, extentReports).teacherLogin(email, password);

            String assertTextVSPOG = "Teacher profile icon after logging in.";
            Assert.assertTrue(new TeacherDashboardPage(webDriver, extentTest, extentReports).verifyTeacherProfileOnGamma(), assertFailurePreText + assertTextVSPOG);
            reportLog(assertTextVSPOG);

            String assertTextVCNDD = "Presence of 'Header' Container.";
            Assert.assertTrue(schoolFeature.verifyHeaderContainer(), assertFailurePreText + assertTextVCNDD);
            reportLog(assertTextVCNDD);

            schoolFeature.clickOnHeaderContainer();

            String assertTextVEB = "Presence of 'Adaptive Practice' Container.";
            Assert.assertTrue(adaptivePracticeFeature.verifyAdaptivePracticeContainer(), assertFailurePreText + assertTextVEB);
            reportLog(assertTextVEB);

        } catch (Exception e) {
            result = handleException(e);
        }
        Assert.assertTrue(result, testCaseFailureText + currentMethodName + errorMessage);
    }

    @Test(priority = 3, description = "Verify Functionality Of 'Adaptive Practice' Container.")
    public void verifyFunctionalityOfAdaptivePracticeContainer() {
        boolean result = true;
        try {
            AdaptivePracticeFeature adaptivePracticeFeature = new AdaptivePracticeFeature(webDriver, extentTest, extentReports);

            adaptivePracticeFeature.clickOnAdaptivePracticeContainer();

            String assertTextVSPOG = "Presence of 'Adaptive Practice' Text.";
            Assert.assertTrue(adaptivePracticeFeature.verifyAdaptivePracticeText(), assertFailurePreText + assertTextVSPOG);
            reportLog(assertTextVSPOG);

            String assertTextVCNDD = "Presence of 'Browse Back' Icon.";
            Assert.assertTrue(adaptivePracticeFeature.verifyBrowseBackIcon(), assertFailurePreText + assertTextVCNDD);
            reportLog(assertTextVCNDD);

        } catch (Exception e) {
            result = handleException(e);
        }
        Assert.assertTrue(result, testCaseFailureText + currentMethodName + errorMessage);
    }

    @Test(priority = 5, description = "Verify Ui Page Of Subject Container.")
    public void verifyUiPageOfSubjectContainer() {
        boolean result = true;
        try {
            AdaptivePracticeFeature adaptivePracticeFeature = new AdaptivePracticeFeature(webDriver, extentTest, extentReports);

            String assertTextVSPOG = "Presence of 'Search' Place Holder.";
            Assert.assertTrue(adaptivePracticeFeature.verifySearchPlaceHolder(), assertFailurePreText + assertTextVSPOG);
            reportLog(assertTextVSPOG);

            String assertTextVCNDD = "Presence of 'Grade Subject Title' Text.";
            Assert.assertTrue(adaptivePracticeFeature.verifyGradeSubjectTitleText(), assertFailurePreText + assertTextVCNDD);
            reportLog(assertTextVCNDD);

            String assertTextVEB = "Presence of 'Math Subject Title' Text.";
            Assert.assertTrue(adaptivePracticeFeature.verifyMathSubjectTitleText(), assertFailurePreText + assertTextVEB);
            reportLog(assertTextVEB);

        } catch (Exception e) {
            result = handleException(e);
        }
        Assert.assertTrue(result, testCaseFailureText + currentMethodName + errorMessage);
    }

    @Test(priority = 7, description = "Verify Functionality Of Ck12 Image Icon and Verify It Redirects to Ck12 Dashboard Page.")
    public void verifyFunctionalityOfCk12Icon() {
        boolean result = true;
        try {
            SchoolFeature schoolFeature = new SchoolFeature(webDriver, extentTest, extentReports);
            AdaptivePracticeFeature adaptivePracticeFeature = new AdaptivePracticeFeature(webDriver, extentTest, extentReports);

            String assertTextVSPOG = "Presence of 'Ck12' Icon.";
            Assert.assertTrue(adaptivePracticeFeature.verifyCk12Icon(), assertFailurePreText + assertTextVSPOG);
            reportLog(assertTextVSPOG);

            adaptivePracticeFeature.clickOnCk12Icon();

            String assertTextVCNDD = "Presence of 'Header' Container.";
            Assert.assertTrue(schoolFeature.verifyHeaderContainer(), assertFailurePreText + assertTextVCNDD);
            reportLog(assertTextVCNDD);

            schoolFeature.clickOnHeaderContainer();

            String assertTextVEB = "Presence of 'Adaptive Practice' Container.";
            Assert.assertTrue(adaptivePracticeFeature.verifyAdaptivePracticeContainer(), assertFailurePreText + assertTextVEB);
            reportLog(assertTextVEB);

            adaptivePracticeFeature.clickOnAdaptivePracticeContainer();

            String assertTextVAB = "Presence of 'Adaptive Practice' Text.";
            Assert.assertTrue(adaptivePracticeFeature.verifyAdaptivePracticeText(), assertFailurePreText + assertTextVAB);
            reportLog(assertTextVAB);

        } catch (Exception e) {
            result = handleException(e);
        }
        Assert.assertTrue(result, testCaseFailureText + currentMethodName + errorMessage);
    }

    @Test(priority = 9, description = "Verify Functionality Of Browse Back Icon.")
    public void verifyFunctionalityOfBrowseBackIcon() {
        boolean result = true;
        try {
            SchoolFeature schoolFeature = new SchoolFeature(webDriver, extentTest, extentReports);
            AdaptivePracticeFeature adaptivePracticeFeature = new AdaptivePracticeFeature(webDriver, extentTest, extentReports);

            String assertTextVSPOG = "Presence of 'Browse Back' Icon.";
            Assert.assertTrue(adaptivePracticeFeature.verifyBrowseBackIcon(), assertFailurePreText + assertTextVSPOG);
            reportLog(assertTextVSPOG);

            adaptivePracticeFeature.clickOnBrowseBackIcon();

            String assertTextVCNDD = "Presence of 'Header' Container.";
            Assert.assertTrue(schoolFeature.verifyHeaderContainer(), assertFailurePreText + assertTextVCNDD);
            reportLog(assertTextVCNDD);

            schoolFeature.clickOnHeaderContainer();

            String assertTextVEB = "Presence of 'Adaptive Practice' Container.";
            Assert.assertTrue(adaptivePracticeFeature.verifyAdaptivePracticeContainer(), assertFailurePreText + assertTextVEB);
            reportLog(assertTextVEB);

            adaptivePracticeFeature.clickOnAdaptivePracticeContainer();

            String assertTextVAB = "Presence of 'Adaptive Practice' Text.";
            Assert.assertTrue(adaptivePracticeFeature.verifyAdaptivePracticeText(), assertFailurePreText + assertTextVAB);
            reportLog(assertTextVAB);

        } catch (Exception e) {
            result = handleException(e);
        }
        Assert.assertTrue(result, testCaseFailureText + currentMethodName + errorMessage);
    }

    @Test(priority = 11, description = "Verify Functionality Of Search PlaceHolder With InValid Data.")
    public void verifyFunctionalityOfSearchPlaceHolderWithInvalidData() {
        boolean result = true;
        try {
            SchoolFeature schoolFeature = new SchoolFeature(webDriver, extentTest, extentReports);
            AdaptivePracticeFeature adaptivePracticeFeature = new AdaptivePracticeFeature(webDriver, extentTest, extentReports);

            String text = "ABC";

            String assertTextVSPOG = "Presence of 'Search' Place Holder.";
            Assert.assertTrue(adaptivePracticeFeature.verifySearchPlaceHolder(), assertFailurePreText + assertTextVSPOG);
            reportLog(assertTextVSPOG);

            adaptivePracticeFeature.setTextInSearchPlaceHolder(text);

            String assertTextVAB = "Presence of 'Adaptive Practice' Text.";
            Assert.assertTrue(adaptivePracticeFeature.verifyAdaptivePracticeText(), assertFailurePreText + assertTextVAB);
            reportLog(assertTextVAB);

            String assertTextVCNDD = "Presence of 'Search Result' Text.";
            Assert.assertTrue(adaptivePracticeFeature.verifySearchResultText(), assertFailurePreText + assertTextVCNDD);
            reportLog(assertTextVCNDD);

            String assertTextVEB = "Presence of 'Search Not Found' Text.";
            Assert.assertTrue(adaptivePracticeFeature.verifySearchNotFoundText(), assertFailurePreText + assertTextVEB);
            reportLog(assertTextVEB);

        } catch (Exception e) {
            result = handleException(e);
        }
        Assert.assertTrue(result, testCaseFailureText + currentMethodName + errorMessage);
    }

    @Test(priority = 13, description = "Verify Functionality Of Search PlaceHolder With Valid Data.")
    public void verifyFunctionalityOfSearchPlaceHolderWithValidData() {
        boolean result = true;
        try {
            AdaptivePracticeFeature adaptivePracticeFeature = new AdaptivePracticeFeature(webDriver, extentTest, extentReports);

            String text = "History";

            String assertTextVSPOG = "Presence of 'Search' Place Holder.";
            Assert.assertTrue(adaptivePracticeFeature.verifySearchPlaceHolder(), assertFailurePreText + assertTextVSPOG);
            reportLog(assertTextVSPOG);

            adaptivePracticeFeature.setTextInSearchPlaceHolder(text);

            String assertTextVAB = "Presence of 'Adaptive Practice' Text.";
            Assert.assertTrue(adaptivePracticeFeature.verifyAdaptivePracticeText(), assertFailurePreText + assertTextVAB);
            reportLog(assertTextVAB);

            String assertTextVCNDD = "Presence of 'Search Result' Text.";
            Assert.assertTrue(adaptivePracticeFeature.verifySearchResultText(), assertFailurePreText + assertTextVCNDD);
            reportLog(assertTextVCNDD);

            String assertTextVEB = "Presence of 'Concept Name Link' Text.";
            Assert.assertTrue(adaptivePracticeFeature.verifyConceptNameLink(), assertFailurePreText + assertTextVEB);
            reportLog(assertTextVEB);

        } catch (Exception e) {
            result = handleException(e);
        }
        Assert.assertTrue(result, testCaseFailureText + currentMethodName + errorMessage);
    }

    @Test(priority = 15, description = "Verify User Is Login And Verify Functionality Of USer Profile Icon.")
    public void verifyFunctionalityOfUserProfileIcon() {
        boolean result = true;
        try {
            AdaptivePracticeFeature adaptivePracticeFeature = new AdaptivePracticeFeature(webDriver, extentTest, extentReports);

            String assertTextVSPOG = "Presence of 'Browse Back' Icon.";
            Assert.assertTrue(adaptivePracticeFeature.verifyBrowseBackIcon(), assertFailurePreText + assertTextVSPOG);
            reportLog(assertTextVSPOG);

            adaptivePracticeFeature.clickOnBrowseBackIcon();

            String assertTextVAB = "Presence of 'Adaptive Practice' Text.";
            Assert.assertTrue(adaptivePracticeFeature.verifyAdaptivePracticeText(), assertFailurePreText + assertTextVAB);
            reportLog(assertTextVAB);

            String assertTextVCNDD = "Presence of 'User' Icon.";
            Assert.assertTrue(adaptivePracticeFeature.verifyUserIcon(), assertFailurePreText + assertTextVCNDD);
            reportLog(assertTextVCNDD);

            adaptivePracticeFeature.clickOnUserIcon();

            /*String assertTextVEB = "Presence of 'Email Id' Text.";
            Assert.assertTrue(adaptivePracticeFeature.verifyUserEmailIdText(), assertFailurePreText + assertTextVEB);
            reportLog(assertTextVEB);*/

            String assertTextVA = "Presence of 'User Name' Text.";
            Assert.assertTrue(adaptivePracticeFeature.verifyUserNameText(), assertFailurePreText + assertTextVA);
            reportLog(assertTextVA);

        } catch (Exception e) {
            result = handleException(e);
        }
        Assert.assertTrue(result, testCaseFailureText + currentMethodName + errorMessage);
    }

    @Test(priority = 17, description = "Verify Functionality Of Subject Grade link.")
    public void verifyFunctionalityOfSubjectGradeLink() {
        boolean result = true;
        try {
            AdaptivePracticeFeature adaptivePracticeFeature = new AdaptivePracticeFeature(webDriver, extentTest, extentReports);

            String assertTextVSPOG = "Presence of 'Subject Grade' link.";
            Assert.assertTrue(adaptivePracticeFeature.verifySubjectGradeLink(), assertFailurePreText + assertTextVSPOG);
            reportLog(assertTextVSPOG);

            adaptivePracticeFeature.clickOnSubjectGradeLink();

            String assertTextVAB = "Presence of 'Adaptive Practice' Text.";
            Assert.assertTrue(adaptivePracticeFeature.verifyAdaptivePracticeText(), assertFailurePreText + assertTextVAB);
            reportLog(assertTextVAB);

            String assertTextVCNDD = "Presence of 'Track' Icon.";
            Assert.assertTrue(adaptivePracticeFeature.verifyTrackIcon(), assertFailurePreText + assertTextVCNDD);
            reportLog(assertTextVCNDD);

        } catch (Exception e) {
            result = handleException(e);
        }
        Assert.assertTrue(result, testCaseFailureText + currentMethodName + errorMessage);
    }

    @Test(priority = 19, description = "Verify functionality Of Subject Dropdown.")
    public void verifyFunctionalityOfSubjectDropDown() {
        boolean result = true;
        try {
            AdaptivePracticeFeature adaptivePracticeFeature = new AdaptivePracticeFeature(webDriver, extentTest, extentReports);

            String assertTextVSPOG = "Presence of 'Subject' Text.";
            Assert.assertTrue(adaptivePracticeFeature.verifySubjectText(), assertFailurePreText + assertTextVSPOG);
            reportLog(assertTextVSPOG);

            String assertTextVAB = "Presence of 'Subject' DropDown.";
            Assert.assertTrue(adaptivePracticeFeature.verifySubjectDropDown(), assertFailurePreText + assertTextVAB);
            reportLog(assertTextVAB);

            adaptivePracticeFeature.clickOnSubjectDropDown();

            String assertTextVCNDD = "Presence of 'Arithmetic' Branch Name Link.";
            Assert.assertTrue(adaptivePracticeFeature.verifyArithmeticBranchLink(), assertFailurePreText + assertTextVCNDD);
            reportLog(assertTextVCNDD);

        } catch (Exception e) {
            result = handleException(e);
        }
        Assert.assertTrue(result, testCaseFailureText + currentMethodName + errorMessage);
    }

    @Test(priority = 21, description = "Verify Functionality Of Subject Branch List and Verify It redirects to Corresponding Page.")
    public void verifyUpdatedSubjectBranchName() {
        boolean result = true;
        try {
            AdaptivePracticeFeature adaptivePracticeFeature = new AdaptivePracticeFeature(webDriver, extentTest, extentReports);

            adaptivePracticeFeature.getTextOfBranchLink();
            adaptivePracticeFeature.clickOnArithmeticBranchLink();

            String assertTextVAB = "Presence of 'Adaptive Practice' Text.";
            Assert.assertTrue(adaptivePracticeFeature.verifyAdaptivePracticeText(), assertFailurePreText + assertTextVAB);
            reportLog(assertTextVAB);

            String assertTextVSPOG = "Presence of 'Subject' Text.";
            Assert.assertTrue(adaptivePracticeFeature.verifySubjectText(), assertFailurePreText + assertTextVSPOG);
            reportLog(assertTextVSPOG);

            String assertTextVCNDD = "Presence of Updated Subject Branch Name'.";
            Assert.assertTrue(adaptivePracticeFeature.verifyUpdatedSubjectBranchName(), assertFailurePreText + assertTextVCNDD);
            reportLog(assertTextVCNDD);

        } catch (Exception e) {
            result = handleException(e);
        }
        Assert.assertTrue(result, testCaseFailureText + currentMethodName + errorMessage);
    }
}