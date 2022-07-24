package testscripts.regression.teacherlogin.DashBoardFeature.ProfileFeature;

import com.relevantcodes.extentreports.LogStatus;
import org.apache.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.Test;
import testscripts.BaseTestScript;
import uipages.flexbook2feature.*;

public class SchoolFeatureTest extends BaseTestScript {
    private static final Logger logger = Logger.getLogger(SchoolFeatureTest.class);
    private String testCaseFailureText = "Test failed for method: ";
    private String assertFailurePreText = "Failed to verify: ";
    public String assertSuccessPreText = "Successfully verified: ";

    @Test(priority = 1, dataProvider = "CK12DataProvider", description = "Verify Functionality Of School link of Header Container.")
    public void verifyFunctionalityOfSchoolLink(String email, String password) {
        boolean result = true;
        try {
            SchoolFeature schoolFeature = new SchoolFeature(webDriver,extentTest,extentReports);

            new LoginPage(webDriver,extentTest, extentReports).teacherLogin(email, password);

            String assertTextVSPOG = "Teacher profile icon after logging in.";
            Assert.assertTrue(new TeacherDashboardPage(webDriver,extentTest,extentReports).verifyTeacherProfileOnGamma(), assertFailurePreText + assertTextVSPOG);
            reportLog(assertTextVSPOG);

            String assertTextVCNDD = "Presence of 'Header' Container.";
            Assert.assertTrue(schoolFeature.verifyHeaderContainer(), assertFailurePreText + assertTextVCNDD);
            reportLog(assertTextVCNDD);

            schoolFeature.clickOnHeaderContainer();

            String assertTextVEB = "Presence of 'School' link.";
            Assert.assertTrue(schoolFeature.verifySchoolLink(), assertFailurePreText + assertTextVEB);
            reportLog(assertTextVEB);

            schoolFeature.clickOnSchoolLink();

            String assertTextVAB = "Presence of 'School' Text.";
            Assert.assertTrue(schoolFeature.verifySchoolText(), assertFailurePreText + assertTextVAB);
            reportLog(assertTextVAB);

        } catch (Exception e) {
            result = handleException(e);
        }
        Assert.assertTrue(result, testCaseFailureText + currentMethodName + errorMessage);
    }

    @Test(priority = 3, description = "Verify UI Of School Page.")
    public void verifyUIOfSchoolPage() {
        boolean result = true;
        try {
            SchoolFeature schoolFeature = new SchoolFeature(webDriver,extentTest,extentReports);

            String assertTextVCNDD = "Presence of 'Heart' image.";
            Assert.assertTrue(schoolFeature.verifyHeartImage(), assertFailurePreText + assertTextVCNDD);
            reportLog(assertTextVCNDD);

            String assertTextVEB = "Presence of 'View School' link.";
            Assert.assertTrue(schoolFeature.verifyViewSchoolLink(), assertFailurePreText + assertTextVEB);
            reportLog(assertTextVEB);

            String assertTextVAB = "Presence of 'School Title' Link.";
            Assert.assertTrue(schoolFeature.verifySchoolTitleLink(), assertFailurePreText + assertTextVAB);
            reportLog(assertTextVAB);

        } catch (Exception e) {
            result = handleException(e);
        }
        Assert.assertTrue(result, testCaseFailureText + currentMethodName + errorMessage);
    }

    @Test(priority = 5, description = "Verify California State Is Bydefault Selected inside the state Conatainer.")
    public void verifyCaliforniaStateIsByDefaultSelected() {
        boolean result = true;
        try {
            SchoolFeature schoolFeature = new SchoolFeature(webDriver,extentTest,extentReports);

            String assertTextVCNDD = "Presence of 'State' image.";
            Assert.assertTrue(schoolFeature.verifyStateDropDown(), assertFailurePreText + assertTextVCNDD);
            reportLog(assertTextVCNDD);

//            String assertTextVEB = "Presence of 'California State ' is Selected.";
//            Assert.assertTrue(schoolFeature.verifyCaliforniaStateIsSelected(), assertFailurePreText + assertTextVEB);
//            reportLog(assertTextVEB);

            String assertTextVAB = "Presence of 'School Title' Link.";
            Assert.assertTrue(schoolFeature.verifySchoolTitleLink(), assertFailurePreText + assertTextVAB);
            reportLog(assertTextVAB);

        } catch (Exception e) {
            result = handleException(e);
        }
        Assert.assertTrue(result, testCaseFailureText + currentMethodName + errorMessage);
    }

    @Test(priority = 7, description = "Verify Functionality Of State Container DropDown.")
    public void VerifyFunctionalityOfStateContainerDropDown() {
        boolean result = true;
        try {
            SchoolFeature schoolFeature = new SchoolFeature(webDriver,extentTest,extentReports);

            String assertTextVCNDD = "Presence of 'State' image.";
            Assert.assertTrue(schoolFeature.verifyStateDropDown(), assertFailurePreText + assertTextVCNDD);
            reportLog(assertTextVCNDD);

            schoolFeature.clickOnStateDropDown();

            String assertTextVEB = "Presence of 'Alaska State' Link.";
            Assert.assertTrue(schoolFeature.verifyAlaskaStateLink(), assertFailurePreText + assertTextVEB);
            reportLog(assertTextVEB);

            String assertTextVAB = "Presence of 'Alabama State ' Link.";
            Assert.assertTrue(schoolFeature.verifyAlabamaStateLink(), assertFailurePreText + assertTextVAB);
            reportLog(assertTextVAB);

        } catch (Exception e) {
            result = handleException(e);
        }
        Assert.assertTrue(result, testCaseFailureText + currentMethodName + errorMessage);
    }

    @Test(priority = 9, description = "Verify Functionality Of State link and verify updated state text in State DropDown .")
    public void VerifyFunctionalityOfStateLink() {
        boolean result = true;
        try {
            SchoolFeature schoolFeature = new SchoolFeature(webDriver,extentTest,extentReports);

            schoolFeature.getTextOfStateAlaska();
            schoolFeature.clickOnStateAlaskaLink();

            String assertTextVCNDD = "Presence of 'State' image.";
            Assert.assertTrue(schoolFeature.verifyStateDropDown(), assertFailurePreText + assertTextVCNDD);
            reportLog(assertTextVCNDD);

            String assertTextVEB = "Presence of 'Alaska State' Is Update In State DropDown.";
            Assert.assertTrue(schoolFeature.verifyStateLinkIsUpdatedInStateDropDown(), assertFailurePreText + assertTextVEB);
            reportLog(assertTextVEB);

        } catch (Exception e) {
            result = handleException(e);
        }
        Assert.assertTrue(result, testCaseFailureText + currentMethodName + errorMessage);
    }

    @Test(priority = 11, description = "Verify Functionality Of View School Icon.")
    public void VerifyFunctionalityOfViewSchoolIcon() {
        boolean result = true;
        try {
            SchoolFeature schoolFeature = new SchoolFeature(webDriver,extentTest,extentReports);

            String assertTextVEB = "Presence of 'View School' link.";
            Assert.assertTrue(schoolFeature.verifyViewSchoolLink(), assertFailurePreText + assertTextVEB);
            reportLog(assertTextVEB);

            schoolFeature.clickOnViewSchoolLink();

            String assertTextVCNDD = "Presence of 'Embed School' Icon.";
            Assert.assertTrue(schoolFeature.verifyEmbedSchoolIcon(), assertFailurePreText + assertTextVCNDD);
            reportLog(assertTextVCNDD);

            String assertTextVAB = "Presence of 'Alabama State Name ' Link.";
            Assert.assertTrue(schoolFeature.verifyStateNameLink(), assertFailurePreText + assertTextVAB);
            reportLog(assertTextVAB);

        } catch (Exception e) {
            result = handleException(e);
        }
        Assert.assertTrue(result, testCaseFailureText + currentMethodName + errorMessage);
    }

    @Test(priority = 13, description = "Verify Functionality Of School Embed Icon.")
    public void VerifyFunctionalityOfSchoolEmbedIcon() {
        boolean result = true;
        try {
            SchoolFeature schoolFeature = new SchoolFeature(webDriver,extentTest,extentReports);

            schoolFeature.clickOnEmbedSchoolIcon();

            String assertTextVCNDD = "Presence of 'Copy Embed Code' Icon.";
            Assert.assertTrue(schoolFeature.verifyCopyEmbedCodeText(), assertFailurePreText + assertTextVCNDD);
            reportLog(assertTextVCNDD);

            String assertTextVAB = "Presence of 'Copy And Paste' text.";
            Assert.assertTrue(schoolFeature.verifyCopyAndPasteText(), assertFailurePreText + assertTextVAB);
            reportLog(assertTextVAB);

        } catch (Exception e) {
            result = handleException(e);
        }
        Assert.assertTrue(result, testCaseFailureText + currentMethodName + errorMessage);
    }

    @Test(priority = 15, description = "Verify Functionality Of Cancel Button.")
    public void VerifyFunctionalityOfCopyButton() {
        boolean result = true;
        try {
            SchoolFeature schoolFeature = new SchoolFeature(webDriver,extentTest,extentReports);

            String assertTextVEB = "Presence of 'Copy' button.";
            //Assert.assertTrue(schoolFeature.verifyCopyButton(), assertFailurePreText + assertTextVEB);
            reportLog(assertTextVEB);

            //schoolFeature.clickOnCopyButton();

            String assertTextVCNDD = "Presence of 'Embed School' Icon.";
            //Assert.assertTrue(schoolFeature.verifyEmbedSchoolIcon(), assertFailurePreText + assertTextVCNDD);
            reportLog(assertTextVCNDD);

        } catch (Exception e) {
            result = handleException(e);
        }
        Assert.assertTrue(result, testCaseFailureText + currentMethodName + errorMessage);
    }

    @Test(priority = 17, description = "Verify Functionality Of Close Icon.")
    public void VerifyFunctionalityOfCloseIcon() {
        boolean result = true;
        try {
            SchoolFeature schoolFeature = new SchoolFeature(webDriver,extentTest,extentReports);

            String assertTextVCNDD = "Presence of 'Copy Embed Code' Icon.";
            Assert.assertTrue(schoolFeature.verifyCopyEmbedCodeText(), assertFailurePreText + assertTextVCNDD);
            reportLog(assertTextVCNDD);

            String assertTextVEB = "Presence of 'Close' Icon.";
            Assert.assertTrue(schoolFeature.verifyCloseIcon(), assertFailurePreText + assertTextVEB);
            reportLog(assertTextVEB);

            schoolFeature.clickOnCloseIcon();

            String assertTextVCND = "Presence of 'Embed School' Icon.";
            Assert.assertTrue(schoolFeature.verifyEmbedSchoolIcon(), assertFailurePreText + assertTextVCND);
            reportLog(assertTextVCND);

        } catch (Exception e) {
            result = handleException(e);
        }
        Assert.assertTrue(result, testCaseFailureText + currentMethodName + errorMessage);
    }

    @Test(priority = 19, description = "Hover the FlexBook Which Are Showing in results and verify description and creator Information are display..")
    public void hoverTheResultsFlexBook() {
        boolean result = true;
        try {
            SchoolFeature schoolFeature = new SchoolFeature(webDriver,extentTest,extentReports);

            String assertTextVCNDD = "Presence of 'FlexBook Cover'.";
            Assert.assertTrue(schoolFeature.verifyFlexBookBookCoverAreVisible(), assertFailurePreText + assertTextVCNDD);
            reportLog(assertTextVCNDD);

            schoolFeature.hoverFlexBookBookCover();

            String assertTextVEB = "Presence of 'Description' Text.";
            Assert.assertTrue(schoolFeature.verifyDescriptionText(), assertFailurePreText + assertTextVEB);
            reportLog(assertTextVEB);

            String assertTextVCND = "Presence of 'Created By' Text.";
            Assert.assertTrue(schoolFeature.verifyCreatedByText(), assertFailurePreText + assertTextVCND);
            reportLog(assertTextVCND);

        } catch (Exception e) {
            result = handleException(e);
        }
        Assert.assertTrue(result, testCaseFailureText + currentMethodName + errorMessage);
    }

    @Test(priority = 21, description = "Verify Functionality Of State link And verify it redirects school home page.")
    public void verifyFunctionalityOfStateLink() {
        boolean result = true;
        try {
            SchoolFeature schoolFeature = new SchoolFeature(webDriver,extentTest,extentReports);

            String assertTextVCNDD = "Presence of 'State Name' Link.";
            Assert.assertTrue(schoolFeature.verifyStateNameLink(), assertFailurePreText + assertTextVCNDD);
            reportLog(assertTextVCNDD);

            schoolFeature.clickOnStateNameLink();

            String assertTextVEB = "Presence of 'School' Text.";
            Assert.assertTrue(schoolFeature.verifySchoolText(), assertFailurePreText + assertTextVEB);
            reportLog(assertTextVEB);

            String assertTextVCND = "Presence of 'View School' Link.";
            Assert.assertTrue(schoolFeature.verifyViewSchoolLink(), assertFailurePreText + assertTextVCND);
            reportLog(assertTextVCND);

        } catch (Exception e) {
            result = handleException(e);
        }
        Assert.assertTrue(result, testCaseFailureText + currentMethodName + errorMessage);
    }
}