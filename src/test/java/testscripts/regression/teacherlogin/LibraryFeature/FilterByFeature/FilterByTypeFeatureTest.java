package testscripts.regression.teacherlogin.LibraryFeature.FilterByFeature;

import com.relevantcodes.extentreports.LogStatus;
import org.apache.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.Test;
import testscripts.BaseTestScript;
import uipages.flexbook2feature.*;

public class FilterByTypeFeatureTest extends BaseTestScript {
    private static final Logger logger = Logger.getLogger(FilterByTypeFeatureTest.class);
    private String testCaseFailureText = "Test failed for method: ";
    private String assertFailurePreText = "Failed to verify: ";
    public String assertSuccessPreText = "Successfully verified: ";



    @Test(priority = 1, dataProvider = "CK12DataProvider", description = "Verify All The 'Filter Types' Are Present Inside Filter By Type Container.")
    public void verifyAllTheFilterTypesArePresentInsideFilterByTypeContainer(String email, String password) {
        boolean result = true;
        try {
            TeacherDashboardPage teacherDashboardPage = new TeacherDashboardPage(webDriver, extentTest, extentReports);
            CourseBookCreateEditAssignDelete courseBookCreateEditAssignDelete = new CourseBookCreateEditAssignDelete(webDriver, extentTest, extentReports);
            FilterByTypeFeature filterByTypeFeature = new FilterByTypeFeature(webDriver, extentTest, extentReports);

            new LoginPage(webDriver, extentTest, extentReports).teacherLogin(email, password);

            Assert.assertTrue(teacherDashboardPage.verifyTeacherProfileOnGamma(), "Failed to verified user profile for CreateCBookUsingModalityTest.");
            extentTest.log(LogStatus.PASS, "User Successfully logged in and verified profile icon.");
            logger.info("User Successfully logged in and verified profile icon.");

            new PageMenuTab(webDriver, extentTest, extentReports).clickOnLibraryTab();

            Assert.assertTrue(courseBookCreateEditAssignDelete.verifyCreateNewDropDown(), "Failed to verified Create New DropDown");
            extentTest.log(LogStatus.PASS, "Successfully verified Create New DropDown");
            logger.info("Successfully verified Create New DropDown");

            String assertTextVML = "Presence of 'Filter By Type' Text";
            Assert.assertTrue(filterByTypeFeature.verifyFilterByTypeText(), assertFailurePreText + assertTextVML);
            reportLog(assertTextVML);

            String assertTextVFTT = "Presence of 'FlexBook TextBook' Filter Type CheckBox";
            Assert.assertTrue(filterByTypeFeature.verifyFlexBookTextBookCheckBox(), assertFailurePreText + assertTextVFTT);
            reportLog(assertTextVFTT);

            String assertTextVFT = "Presence of 'FlexBook' Filter Type CheckBox";
            Assert.assertTrue(filterByTypeFeature.verifyFlexBookCheckBox(), assertFailurePreText + assertTextVFT);
            reportLog(assertTextVFT);

            String assertTextVRT = "Presence of 'Read' Filter Type CheckBox";
            Assert.assertTrue(filterByTypeFeature.verifyReadCheckBox(), assertFailurePreText + assertTextVRT);
            reportLog(assertTextVRT);

            String assertTextVQT = "Presence of 'Quizzes' Filter Type CheckBox";
            Assert.assertTrue(filterByTypeFeature.verifyQuizzesCheckBox(), assertFailurePreText + assertTextVQT);
            reportLog(assertTextVQT);

        } catch (Exception e) {
            result = handleException(e);
        }
        Assert.assertTrue(result, testCaseFailureText + currentMethodName + errorMessage);
    }

    @Test(priority = 2, description = "Verify Functionality 'Filter By Type' CheckBox If Items Are Not Available In Library List.")
    public void verifyFunctionalityFilterByTypeIfItemsAreNotAvailable() {
        boolean result = true;
        try {
            FilterByTypeFeature filterByTypeFeature = new FilterByTypeFeature(webDriver, extentTest, extentReports);

            String assertTextVQT = "Presence of 'WorkBook' Filter Type CheckBox";
            Assert.assertTrue(filterByTypeFeature.verifyWorkBookCheckBox(), assertFailurePreText + assertTextVQT);
            reportLog(assertTextVQT);

            filterByTypeFeature.clickOnWorkBookCheckBox();

            String assertTextVML = "Presence of 'Filter By Type' Text";
            Assert.assertTrue(filterByTypeFeature.verifyFilterByTypeText(), assertFailurePreText + assertTextVML);
            reportLog(assertTextVML);

            String assertTextVFT = "No Items In Library List";
            Assert.assertTrue(filterByTypeFeature.verifyNoItemsInLibraryText(), assertFailurePreText + assertTextVFT);
            reportLog(assertTextVFT);

        } catch (Exception e) {
            result = handleException(e);
        }
        Assert.assertTrue(result, testCaseFailureText + currentMethodName + errorMessage);
    }

    @Test(priority = 3, description = "Verify Functionality Of 'FlexBook TextBook' CheckBox Of Filter By Type.")
    public void verifyFunctionalityOfFlexBookTextBookCheckBox() {
        boolean result = true;
        try {
            FilterByTypeFeature filterByTypeFeature = new FilterByTypeFeature(webDriver, extentTest, extentReports);

            String assertTextVFTT = "Presence of 'FlexBook TextBook' Filter Type CheckBox";
            Assert.assertTrue(filterByTypeFeature.verifyFlexBookTextBookCheckBox(), assertFailurePreText + assertTextVFTT);
            reportLog(assertTextVFTT);

            filterByTypeFeature.clickOnFlexBookTextBookCheckBox();

            String assertTextVML = "Presence of 'Filter By Type' Text";
            Assert.assertTrue(filterByTypeFeature.verifyFilterByTypeText(), assertFailurePreText + assertTextVML);
            reportLog(assertTextVML);

            String assertTextVTT = "Presence of 'FlexBook TextBook' Title Of First Library Item ";
            Assert.assertTrue(filterByTypeFeature.verifyFirstItemOfLibraryListIsFlexBookTextBook(), assertFailurePreText + assertTextVTT);
            reportLog(assertTextVTT);

            String assertTextVFT = "Presence of 'FlexBook TextBook' Items In Library List";
            Assert.assertTrue(filterByTypeFeature.verifyOnlyFlexBookTextBookItemsArePresent(), assertFailurePreText + assertTextVFT);
            reportLog(assertTextVFT);

        } catch (Exception e) {
            result = handleException(e);
        }
        Assert.assertTrue(result, testCaseFailureText + currentMethodName + errorMessage);
    }

    @Test(priority = 5, description = "Verify Functionality Of 'FlexBook' CheckBox Of Filter By Type.")
    public void verifyFunctionalityOfFlexBookCheckBox() {
        boolean result = true;
        try {
            FilterByTypeFeature filterByTypeFeature = new FilterByTypeFeature(webDriver, extentTest, extentReports);

            String assertTextVFT = "Presence of 'FlexBook' Filter Type CheckBox";
            Assert.assertTrue(filterByTypeFeature.verifyFlexBookCheckBox(), assertFailurePreText + assertTextVFT);
            reportLog(assertTextVFT);

            filterByTypeFeature.clickOnFlexBookCheckBox();

            String assertTextVML = "Presence of 'Filter By Type' Text";
            Assert.assertTrue(filterByTypeFeature.verifyFilterByTypeText(), assertFailurePreText + assertTextVML);
            reportLog(assertTextVML);

            String assertTextVFTT = "Presence of 'FlexBook' Title Of First Library Item ";
            Assert.assertTrue(filterByTypeFeature.getListOfBookAndVerifyFlexBook(), assertFailurePreText + assertTextVFTT);
            reportLog(assertTextVFTT);

            String assertTextVRT = "Presence of 'FlexBook TextBook And FlexBook' Items In Library List";
            Assert.assertTrue(filterByTypeFeature.verifyOnlyFlexBookTextBookAndFlexBookItemsArePresent(), assertFailurePreText + assertTextVRT);
            reportLog(assertTextVRT);

        } catch (Exception e) {
            result = handleException(e);
        }
        Assert.assertTrue(result, testCaseFailureText + currentMethodName + errorMessage);
    }

    @Test(priority = 7, description = "Verify Functionality Of 'Read' CheckBox Of Filter By Type.")
    public void verifyFunctionalityOfReadCheckBox() {
        boolean result = true;
        try {
            FilterByTypeFeature filterByTypeFeature = new FilterByTypeFeature(webDriver, extentTest, extentReports);

            String assertTextVFT = "Presence of 'Read' Filter Type CheckBox";
            Assert.assertTrue(filterByTypeFeature.verifyReadCheckBox(), assertFailurePreText + assertTextVFT);
            reportLog(assertTextVFT);

            filterByTypeFeature.clickOnReadCheckBox();

            String assertTextVML = "Presence of 'Filter By Type' Text";
            Assert.assertTrue(filterByTypeFeature.verifyFilterByTypeText(), assertFailurePreText + assertTextVML);
            reportLog(assertTextVML);

            String assertTextVFTT = "Presence of 'Read Modality' Title Of First Library Item ";
            Assert.assertTrue(filterByTypeFeature.verifyFirstItemOfLibraryListIsReadModality(), assertFailurePreText + assertTextVFTT);
            reportLog(assertTextVFTT);

            String assertTextVRT = "Presence of 'Read, FlexBook & FlexBook TextBook' Items In Library.";
            Assert.assertTrue(filterByTypeFeature.verifyPresentLibraryItemsAfterClickingOnReadCheckBox(), assertFailurePreText + assertTextVRT);
            reportLog(assertTextVRT);

        } catch (Exception e) {
            result = handleException(e);
        }
        Assert.assertTrue(result, testCaseFailureText + currentMethodName + errorMessage);
    }

    @Test(priority = 9, description = "Verify Functionality Of 'Quiz' CheckBox Of Filter By Type.")
    public void verifyFunctionalityOfQuizCheckBox() {
        boolean result = true;
        try {
            FilterByTypeFeature filterByTypeFeature = new FilterByTypeFeature(webDriver, extentTest, extentReports);

            String assertTextVQT = "Presence of 'Quizzes' Filter Type CheckBox";
            Assert.assertTrue(filterByTypeFeature.verifyQuizzesCheckBox(), assertFailurePreText + assertTextVQT);
            reportLog(assertTextVQT);

            filterByTypeFeature.clickOnQuizzesCheckBox();

            String assertTextVML = "Presence of 'Filter By Type' Text";
            Assert.assertTrue(filterByTypeFeature.verifyFilterByTypeText(), assertFailurePreText + assertTextVML);
            reportLog(assertTextVML);

            String assertTextVFTT = "Presence of 'Quiz' Title Of First Library Item ";
            Assert.assertTrue(filterByTypeFeature.getListOfBookAndVerifyQuiz(), assertFailurePreText + assertTextVFTT);
            reportLog(assertTextVFTT);

            String assertTextVRT = "Presence of 'Quiz, Read, FlexBook & FlexBook TextBook' Items In Library.";
            Assert.assertTrue(filterByTypeFeature.verifyPresentLibraryItemsAfterClickingOnQuizCheckBox(), assertFailurePreText + assertTextVRT);
            reportLog(assertTextVRT);

        } catch (Exception e) {
            result = handleException(e);
        }
        Assert.assertTrue(result, testCaseFailureText + currentMethodName + errorMessage);
    }

    @Test(priority = 11, description = "Verify Functionality Of 'More' Link of Filter By Type.")
    public void verifyFunctionalityOfMoreLink() {
        boolean result = true;
        try {
            FilterByTypeFeature filterByTypeFeature = new FilterByTypeFeature(webDriver, extentTest, extentReports);

            filterByTypeFeature.scrollScreen();

            String assertTextVML = "Presence of 'Filter By Type' Text";
            Assert.assertTrue(filterByTypeFeature.verifyFilterByTypeText(), assertFailurePreText + assertTextVML);
            reportLog(assertTextVML);

            String assertTextVQT = "Presence of 'More' link.";
            Assert.assertTrue(filterByTypeFeature.verifyMoreLink(), assertFailurePreText + assertTextVQT);
            reportLog(assertTextVQT);

            filterByTypeFeature.clickOnMoreLink();

            String assertTextVFTT = "Presence of 'Video' Checkbox Filter By Type.";
            Assert.assertTrue(filterByTypeFeature.verifyVideoCheckBox(), assertFailurePreText + assertTextVFTT);
            reportLog(assertTextVFTT);

            String assertTextVRT = "Presence of 'Study Aids' CheckBox Filter By Type..";
            Assert.assertTrue(filterByTypeFeature.verifyStudyAidsCheckBox(), assertFailurePreText + assertTextVRT);
            reportLog(assertTextVRT);

        } catch (Exception e) {
            result = handleException(e);
        }
        Assert.assertTrue(result, testCaseFailureText + currentMethodName + errorMessage);
    }

    @Test(priority = 13, description = "Verify Functionality Of 'Video' Link of Filter By Type.")
    public void verifyFunctionalityOfVideoCheckBox() {
        boolean result = true;
        try {
            FilterByTypeFeature filterByTypeFeature = new FilterByTypeFeature(webDriver, extentTest, extentReports);

            filterByTypeFeature.clickOnVideoCheckBox();

            String assertTextVML = "Presence of 'Filter By Type' Text";
            Assert.assertTrue(filterByTypeFeature.verifyFilterByTypeText(), assertFailurePreText + assertTextVML);
            reportLog(assertTextVML);

            String assertTextVFTT = "Presence of 'Video' Title Of First Library Item ";
            Assert.assertTrue(filterByTypeFeature.getListOfBookAndVerifyVideo(), assertFailurePreText + assertTextVFTT);
            reportLog(assertTextVFTT);

            filterByTypeFeature.scrollScreen();

            String assertTextVRT = "Presence of 'Study Aids' CheckBox Filter By Type..";
            Assert.assertTrue(filterByTypeFeature.verifyStudyAidsCheckBox(), assertFailurePreText + assertTextVRT);
            reportLog(assertTextVRT);

        } catch (Exception e) {
            result = handleException(e);
        }
        Assert.assertTrue(result, testCaseFailureText + currentMethodName + errorMessage);
    }

    @Test(priority = 15, description = "Verify Functionality Of 'Study Aids' CheckBox of Filter By Type.")
    public void verifyFunctionalityOfStudyAidsCheckBox() {
        boolean result = true;
        try {
            FilterByTypeFeature filterByTypeFeature = new FilterByTypeFeature(webDriver, extentTest, extentReports);

            filterByTypeFeature.clickOnStudyAidsCheckBox();

            String assertTextVML = "Presence of 'Filter By Type' Text";
            Assert.assertTrue(filterByTypeFeature.verifyFilterByTypeText(), assertFailurePreText + assertTextVML);
            reportLog(assertTextVML);

            String assertTextVFTT = "Presence of 'Study Aids' Title Of First Library Item ";
            Assert.assertTrue(filterByTypeFeature.getListOfBookAndVerifyStudyGuide(), assertFailurePreText + assertTextVFTT);
            reportLog(assertTextVFTT);

        } catch (Exception e) {
            result = handleException(e);
        }
        Assert.assertTrue(result, testCaseFailureText + currentMethodName + errorMessage);
    }

    @Test(priority = 17, description = "Verify Functionality Of 'Clear' button After selecting Filter By Type CheckBox.")
    public void verifyFunctionalityOfClearButton() {
        boolean result = true;
        try {
            FilterByTypeFeature filterByTypeFeature = new FilterByTypeFeature(webDriver, extentTest, extentReports);

            String assertTextVRT = "Presence of 'Clear' button.";
            Assert.assertTrue(filterByTypeFeature.verifyClearButton(), assertFailurePreText + assertTextVRT);
            reportLog(assertTextVRT);

            filterByTypeFeature.clickOnClearButton();

            String assertTextVML = "Presence of 'Filter By Type' Text";
            Assert.assertTrue(filterByTypeFeature.verifyFilterByTypeText(), assertFailurePreText + assertTextVML);
            reportLog(assertTextVML);

            String assertTextVQT = "Presence of 'WorkBook' Filter Type CheckBox";
            Assert.assertTrue(filterByTypeFeature.verifyWorkBookCheckBox(), assertFailurePreText + assertTextVQT);
            reportLog(assertTextVQT);

            filterByTypeFeature.clickOnWorkBookCheckBox();

            String assertTextVL = "Presence of 'Filter By Type' Text";
            Assert.assertTrue(filterByTypeFeature.verifyFilterByTypeText(), assertFailurePreText + assertTextVL);
            reportLog(assertTextVL);

            String assertTextVFT = "No Items In Library List";
            Assert.assertTrue(filterByTypeFeature.verifyNoItemsInLibraryText(), assertFailurePreText + assertTextVFT);
            reportLog(assertTextVFT);

        } catch (Exception e) {
            result = handleException(e);
        }
        Assert.assertTrue(result, testCaseFailureText + currentMethodName + errorMessage);
    }

    @Test(priority = 19, description = "Verify Functionality Of 'Clear All' button After selecting Filter By Type CheckBox.")
    public void verifyFunctionalityOfClearAllButton() {
        boolean result = true;
        try {
            FilterByTypeFeature filterByTypeFeature = new FilterByTypeFeature(webDriver, extentTest, extentReports);

            String assertTextVRT = "Presence of 'ClearAll' button.";
            Assert.assertTrue(filterByTypeFeature.verifyClearAllButton(), assertFailurePreText + assertTextVRT);
            reportLog(assertTextVRT);

            filterByTypeFeature.clickOnClearAllButton();

            String assertTextVML = "Presence of 'Filter By Type' Text";
            Assert.assertTrue(filterByTypeFeature.verifyFilterByTypeText(), assertFailurePreText + assertTextVML);
            reportLog(assertTextVML);

            String assertTextVQT = "Presence of 'WorkBook' Filter Type CheckBox";
            Assert.assertTrue(filterByTypeFeature.verifyWorkBookCheckBox(), assertFailurePreText + assertTextVQT);
            reportLog(assertTextVQT);

            filterByTypeFeature.clickOnWorkBookCheckBox();

            String assertTextVL = "Presence of 'Filter By Type' Text";
            Assert.assertTrue(filterByTypeFeature.verifyFilterByTypeText(), assertFailurePreText + assertTextVL);
            reportLog(assertTextVL);

            String assertTextVFT = "No Items In Library List";
            Assert.assertTrue(filterByTypeFeature.verifyNoItemsInLibraryText(), assertFailurePreText + assertTextVFT);
            reportLog(assertTextVFT);

        } catch (Exception e) {
            result = handleException(e);
        }
        Assert.assertTrue(result, testCaseFailureText + currentMethodName + errorMessage);
    }
}