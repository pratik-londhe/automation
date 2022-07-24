package testscripts.regression.teacherlogin.CreateNewFeature.CreateNewDropDownFeature;

import com.relevantcodes.extentreports.LogStatus;
import org.apache.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.Test;
import testscripts.BaseTestScript;
import uipages.flexbook2feature.*;

public class CreateStandardAlignedFlexBookTest extends BaseTestScript {
    private static final Logger logger = Logger.getLogger(CreateStandardAlignedFlexBookTest.class);
    private String testCaseFailureText = "Test failed for method: ";
    private String assertFailurePreText = "Failed to verify: ";
    public String assertSuccessPreText = "Successfully verified: ";

    @Test(priority = 1, dataProvider = "CK12DataProvider", description = "Verify 'Standard Aligned FlexBook' Option Is Available inside the Create New DropDown.")
    public void verifyModalityOptionIsPresent(String email, String password) {
        boolean result = true;
        try {
            TeacherDashboardPage teacherDashboardPage = new TeacherDashboardPage(webDriver,extentTest,extentReports);
            CourseBookCreateEditAssignDelete courseBookCreateEditAssignDelete = new CourseBookCreateEditAssignDelete(webDriver,extentTest,extentReports);
            CreateStandardAlignedFlexBook createStandardAlignedFlexBook = new CreateStandardAlignedFlexBook(webDriver,extentTest,extentReports);

            new LoginPage(webDriver,extentTest, extentReports).teacherLogin(email, password);

            Assert.assertTrue(teacherDashboardPage.verifyTeacherProfileOnGamma(), "Failed to verified user profile for CreateCBookUsingModalityTest.");
            reportLog("User Successfully logged in and verified profile icon.");

            new PageMenuTab(webDriver,extentTest,extentReports).clickOnLibraryTab();

            Assert.assertTrue(courseBookCreateEditAssignDelete.verifyCreateNewDropDown(), "Failed to verified Create New DropDown");
            reportLog("Successfully verified Create New DropDown");

            courseBookCreateEditAssignDelete.clickOnCreateNewDropDown();

            String assertTextVML = "Presence of Stand Aligned FlexBook link Inside Create New DropDown";
            Assert.assertTrue(createStandardAlignedFlexBook.verifyStandardAlignedFlexBookLink(), assertFailurePreText + assertTextVML);
            reportLog(assertTextVML);

        } catch (Exception e) {
            result = handleException(e);
        }
        Assert.assertTrue(result, testCaseFailureText + currentMethodName + errorMessage);
    }

    @Test(priority = 3, description = "Verify Functionality Of 'Standard Aligned FlexBook' link.")
    public void verifyFunctionalityOfModalityLink() {
        boolean result = true;
        try {
            CreateStandardAlignedFlexBook createStandardAlignedFlexBook = new CreateStandardAlignedFlexBook(webDriver,extentTest,extentReports);

            createStandardAlignedFlexBook.clickOnStandardAlignedFlexBookLink();

            String assertTextVML = "Presence of Create Standard Aligned FlexBookText";
            Assert.assertTrue(createStandardAlignedFlexBook.verifyCreateStandardAlignedFlexBookText(), assertFailurePreText + assertTextVML);
            reportLog(assertTextVML);

            String assertTextVRL = "Presence of 'Close Modal' Icon";
            Assert.assertTrue(createStandardAlignedFlexBook.verifyCloseModalIcon(), assertFailurePreText + assertTextVRL);
            reportLog(assertTextVRL);

        } catch (Exception e) {
            result = handleException(e);
        }
        Assert.assertTrue(result, testCaseFailureText + currentMethodName + errorMessage);
    }

    @Test(priority = 5, description = "Verify Functionality Of 'Close Modal' Icon Of Create Standard Aligned FlexBook Pop Up.")
    public void verifyFunctionalityOfCloseModalIcon() {
        boolean result = true;
        try {
            CourseBookCreateEditAssignDelete courseBookCreateEditAssignDelete = new CourseBookCreateEditAssignDelete(webDriver,extentTest,extentReports);
            CreateStandardAlignedFlexBook createStandardAlignedFlexBook = new CreateStandardAlignedFlexBook(webDriver,extentTest,extentReports);

            createStandardAlignedFlexBook.clickOnCloseModalIcon();

            Assert.assertTrue(courseBookCreateEditAssignDelete.verifyCreateNewDropDown(), "Failed to verified Create New DropDown");
            extentTest.log(LogStatus.PASS, "Successfully verified Create New DropDown");
            logger.info("Successfully verified Create New DropDown");

            courseBookCreateEditAssignDelete.clickOnCreateNewDropDown();

            String assertTextVML = "Presence of Stand Aligned FlexBook link Inside Create New DropDown";
            Assert.assertTrue(createStandardAlignedFlexBook.verifyStandardAlignedFlexBookLink(), assertFailurePreText + assertTextVML);
            reportLog(assertTextVML);

            createStandardAlignedFlexBook.clickOnStandardAlignedFlexBookLink();

            String assertTextVCSAF = "Presence of Create Standard Aligned FlexBookText";
            Assert.assertTrue(createStandardAlignedFlexBook.verifyCreateStandardAlignedFlexBookText(), assertFailurePreText + assertTextVCSAF);
            reportLog(assertTextVCSAF);

        } catch (Exception e) {
            result = handleException(e);
        }
        Assert.assertTrue(result, testCaseFailureText + currentMethodName + errorMessage);
    }

    @Test(priority = 7, description = "Verify Functionality Of 'Subject' DropDown Of Create Standard Aligned FlexBook Pop Up.")
    public void verifyFunctionalityOfSubjectDropDown() {
        boolean result = true;
        try {
            CreateStandardAlignedFlexBook createStandardAlignedFlexBook = new CreateStandardAlignedFlexBook(webDriver,extentTest,extentReports);

            String assertTextVML = "Presence of 'Select Subject' DropDown ";
            Assert.assertTrue(createStandardAlignedFlexBook.verifySelectSubjectDropDown(), assertFailurePreText + assertTextVML);
            reportLog(assertTextVML);

            createStandardAlignedFlexBook.clickOnSelectSubjectDropDown();

            String assertTextVCSAF = "Presence of Create Standard Aligned FlexBookText";
            Assert.assertTrue(createStandardAlignedFlexBook.verifyCreateStandardAlignedFlexBookText(), assertFailurePreText + assertTextVCSAF);
            reportLog(assertTextVCSAF);

        } catch (Exception e) {
            result = handleException(e);
        }
        Assert.assertTrue(result, testCaseFailureText + currentMethodName + errorMessage);
    }

    @Test(priority = 9, description = "Verify Selected Subject Option Is displayed in the 'Select Subject' Dropdown.")
    public void verifySelectedSubjectIsDisplay() {
        boolean result = true;
        try {
            CreateStandardAlignedFlexBook createStandardAlignedFlexBook = new CreateStandardAlignedFlexBook(webDriver,extentTest,extentReports);

            String assertTextVML = "Presence of 'Analysis Subject' Link ";
            Assert.assertTrue(createStandardAlignedFlexBook.verifyAnalysisSubjectLink(), assertFailurePreText + assertTextVML);
            reportLog(assertTextVML);

            createStandardAlignedFlexBook.clickOnAnalysisSubjectLink();

            String assertTextVCSAF = "Presence of Create Standard Aligned FlexBookText";
            Assert.assertTrue(createStandardAlignedFlexBook.verifyCreateStandardAlignedFlexBookText(), assertFailurePreText + assertTextVCSAF);
            reportLog(assertTextVCSAF);

            String assertTextVSST = "Presence of 'Selected Subject Text' In select Subject DropDown";
            Assert.assertTrue(createStandardAlignedFlexBook.verifySelectedSubjectText(), assertFailurePreText + assertTextVSST);
            reportLog(assertTextVSST);

        } catch (Exception e) {
            result = handleException(e);
        }
        Assert.assertTrue(result, testCaseFailureText + currentMethodName + errorMessage);
    }

    @Test(priority = 11, description = " Verify Functionality Of 'State or Standard Ser' DropDown Of Create Standard Aligned FlexBook Pop Up.")
    public void verifyFunctionalityOfStateDropDown() {
        boolean result = true;
        try {
            CreateStandardAlignedFlexBook createStandardAlignedFlexBook = new CreateStandardAlignedFlexBook(webDriver,extentTest,extentReports);

            String assertTextVML = "Presence of 'Select State' DropDown ";
            Assert.assertTrue(createStandardAlignedFlexBook.verifyStateDropDown(), assertFailurePreText + assertTextVML);
            reportLog(assertTextVML);

            createStandardAlignedFlexBook.clickOnStateDropDown();

            String assertTextVCSAF = "Presence of Create Standard Aligned FlexBookText";
            Assert.assertTrue(createStandardAlignedFlexBook.verifyCreateStandardAlignedFlexBookText(), assertFailurePreText + assertTextVCSAF);
            reportLog(assertTextVCSAF);

        } catch (Exception e) {
            result = handleException(e);
        }
        Assert.assertTrue(result, testCaseFailureText + currentMethodName + errorMessage);
    }

    @Test(priority = 13, description = "Verify Selected State Option Is displayed in the 'Select State or standard set' Dropdown.")
    public void verifySelectedStatesDisplay() {
        boolean result = true;
        try {
            CreateStandardAlignedFlexBook createStandardAlignedFlexBook = new CreateStandardAlignedFlexBook(webDriver,extentTest,extentReports);

            String assertTextVML = "Presence of 'CCSS State' Link ";
            Assert.assertTrue(createStandardAlignedFlexBook.verifyCCSSStateLink(), assertFailurePreText + assertTextVML);
            reportLog(assertTextVML);

            createStandardAlignedFlexBook.clickOnCCSSStateLink();

            String assertTextVCSAF = "Presence of Create Standard Aligned FlexBookText";
            Assert.assertTrue(createStandardAlignedFlexBook.verifyCreateStandardAlignedFlexBookText(), assertFailurePreText + assertTextVCSAF);
            reportLog(assertTextVCSAF);

            String assertTextVSST = "Presence of 'Selected State Text' In select State DropDown";
            Assert.assertTrue(createStandardAlignedFlexBook.verifySelectedStateText(), assertFailurePreText + assertTextVSST);
            reportLog(assertTextVSST);

        } catch (Exception e) {
            result = handleException(e);
        }
        Assert.assertTrue(result, testCaseFailureText + currentMethodName + errorMessage);
    }

    @Test(priority = 15, description = "Verify Functionality Of 'Grade' DropDown Of Create Standard Aligned FlexBook Pop Up.")
    public void verifyFunctionalityOfGradeDropDown() {
        boolean result = true;
        try {
            CreateStandardAlignedFlexBook createStandardAlignedFlexBook = new CreateStandardAlignedFlexBook(webDriver,extentTest,extentReports);

            String assertTextVML = "Presence of 'Select Grade' DropDown ";
            Assert.assertTrue(createStandardAlignedFlexBook.verifyGradeDropDown(), assertFailurePreText + assertTextVML);
            reportLog(assertTextVML);

            createStandardAlignedFlexBook.clickOnGradeDropDown();

            String assertTextVCSAF = "Presence of Create Standard Aligned FlexBookText";
            Assert.assertTrue(createStandardAlignedFlexBook.verifyCreateStandardAlignedFlexBookText(), assertFailurePreText + assertTextVCSAF);
            reportLog(assertTextVCSAF);

        } catch (Exception e) {
            result = handleException(e);
        }
        Assert.assertTrue(result, testCaseFailureText + currentMethodName + errorMessage);
    }

    @Test(priority = 17, description = "Verify Selected Grade Option Is displayed in the 'Select Grade' Dropdown.")
    public void verifySelectedGradeDisplay() {
        boolean result = true;
        try {
            CreateStandardAlignedFlexBook createStandardAlignedFlexBook = new CreateStandardAlignedFlexBook(webDriver,extentTest,extentReports);

            String assertTextVML = "Presence of '9th Grade' Link ";
            Assert.assertTrue(createStandardAlignedFlexBook.verify9thGradeLink(), assertFailurePreText + assertTextVML);
            reportLog(assertTextVML);

            createStandardAlignedFlexBook.clickOn9thGradeLink();

            String assertTextVCSAF = "Presence of Create Standard Aligned FlexBookText";
            Assert.assertTrue(createStandardAlignedFlexBook.verifyCreateStandardAlignedFlexBookText(), assertFailurePreText + assertTextVCSAF);
            reportLog(assertTextVCSAF);

            String assertTextVSST = "Presence of 'Selected Grade Text' In select Grade DropDown";
            Assert.assertTrue(createStandardAlignedFlexBook.verifySelectedGradeText(), assertFailurePreText + assertTextVSST);
            reportLog(assertTextVSST);

        } catch (Exception e) {
            result = handleException(e);
        }
        Assert.assertTrue(result, testCaseFailureText + currentMethodName + errorMessage);
    }

    @Test(priority = 19, description = "Verify FlexBook Title Is Visible After Selecting Grade Of FlexBook.")
    public void verifyFlexBookTitle() {
        boolean result = true;
        try {
            CreateStandardAlignedFlexBook createStandardAlignedFlexBook = new CreateStandardAlignedFlexBook(webDriver,extentTest,extentReports);

            String assertTextVML = "Presence of 'FlexBook Title' Text";
            Assert.assertTrue(createStandardAlignedFlexBook.verifyFlexBookTitleText(), assertFailurePreText + assertTextVML);
            reportLog(assertTextVML);

            String assertTextVCSAF = "Presence of 'Text Area' Container";
            Assert.assertTrue(createStandardAlignedFlexBook.verifyContainerTextArea(), assertFailurePreText + assertTextVCSAF);
            reportLog(assertTextVCSAF);

        } catch (Exception e) {
            result = handleException(e);
        }
        Assert.assertTrue(result, testCaseFailureText + currentMethodName + errorMessage);
    }

    @Test(priority = 21, description = "Verify Functionality Of 'Cancel' button After Selecting All the Fields. ")
    public void verifyFunctionalityOfCancelButton() {
        boolean result = true;
        try {
            CourseBookCreateEditAssignDelete courseBookCreateEditAssignDelete = new CourseBookCreateEditAssignDelete(webDriver,extentTest,extentReports);
            CreateStandardAlignedFlexBook createStandardAlignedFlexBook = new CreateStandardAlignedFlexBook(webDriver,extentTest,extentReports);

            String assertTextVML = "Presence of 'Cancel' Button ";
            Assert.assertTrue(createStandardAlignedFlexBook.verifyCancelButton(), assertFailurePreText + assertTextVML);
            reportLog(assertTextVML);

            createStandardAlignedFlexBook.clickOnCancelButton();

            Assert.assertTrue(courseBookCreateEditAssignDelete.verifyCreateNewDropDown(), "Failed to verified Create New DropDown");
            reportLog( "Successfully verified Create New DropDown");

            courseBookCreateEditAssignDelete.clickOnCreateNewDropDown();

            String assertTextVSA = "Presence of Stand Aligned FlexBook link Inside Create New DropDown";
            Assert.assertTrue(createStandardAlignedFlexBook.verifyStandardAlignedFlexBookLink(), assertFailurePreText + assertTextVSA);
            reportLog(assertTextVSA);

            createStandardAlignedFlexBook.clickOnStandardAlignedFlexBookLink();

            String assertTextVCSA = "Presence of Create Standard Aligned FlexBookText";
            Assert.assertTrue(createStandardAlignedFlexBook.verifyCreateStandardAlignedFlexBookText(), assertFailurePreText + assertTextVCSA);
            reportLog(assertTextVCSA);

        } catch (Exception e) {
            result = handleException(e);
        }
        Assert.assertTrue(result, testCaseFailureText + currentMethodName + errorMessage);
    }

    @Test(priority = 23, description = "Verify Functionality Of 'Save' button when selected Grade Content is not available. ")
    public void verifyFunctionalityOfSaveButtonWhenContentNotAvailable() {
        boolean result = true;
        try {
            CreateStandardAlignedFlexBook createStandardAlignedFlexBook = new CreateStandardAlignedFlexBook(webDriver,extentTest,extentReports);

            createStandardAlignedFlexBook.clickOnSelectSubjectDropDown();

            String assertTextVCSAF = "Presence of Create Standard Aligned FlexBookText";
            Assert.assertTrue(createStandardAlignedFlexBook.verifyCreateStandardAlignedFlexBookText(), assertFailurePreText + assertTextVCSAF);
            reportLog(assertTextVCSAF);

            createStandardAlignedFlexBook.clickOnAnalysisSubjectLink();

            String assertTextVSAF = "Presence of Create Standard Aligned FlexBookText";
            Assert.assertTrue(createStandardAlignedFlexBook.verifyCreateStandardAlignedFlexBookText(), assertFailurePreText + assertTextVSAF);
            reportLog(assertTextVSAF);

            createStandardAlignedFlexBook.clickOnStateDropDown();

            String assertTextVCSA = "Presence of Create Standard Aligned FlexBookText";
            Assert.assertTrue(createStandardAlignedFlexBook.verifyCreateStandardAlignedFlexBookText(), assertFailurePreText + assertTextVCSA);
            reportLog(assertTextVCSA);

            String assertTextVML = "Presence of 'Texas State' Link ";
            Assert.assertTrue(createStandardAlignedFlexBook.verifyTexasStateLink(), assertFailurePreText + assertTextVML);
            reportLog(assertTextVML);

            createStandardAlignedFlexBook.clickOnTexasStateLink();

            String assertTextVCS = "Presence of Create Standard Aligned FlexBookText";
            Assert.assertTrue(createStandardAlignedFlexBook.verifyCreateStandardAlignedFlexBookText(), assertFailurePreText + assertTextVCS);
            reportLog(assertTextVCS);

            createStandardAlignedFlexBook.clickOnGradeDropDown();

            String assertTextVC = "Presence of Create Standard Aligned FlexBookText";
            Assert.assertTrue(createStandardAlignedFlexBook.verifyCreateStandardAlignedFlexBookText(), assertFailurePreText + assertTextVC);
            reportLog(assertTextVC);

            String assertTextVL = "Presence of '7th Grade' Link ";
            Assert.assertTrue(createStandardAlignedFlexBook.verify7thGradeLink(), assertFailurePreText + assertTextVL);
            reportLog(assertTextVL);

            createStandardAlignedFlexBook.clickOn7thGradeLink();

            String assertTextVCAF = "Presence of Create Standard Aligned FlexBookText";
            Assert.assertTrue(createStandardAlignedFlexBook.verifyCreateStandardAlignedFlexBookText(), assertFailurePreText + assertTextVCAF);
            reportLog(assertTextVCAF);

            String assertTextVM = "Presence of 'Save' Link ";
            Assert.assertTrue(createStandardAlignedFlexBook.verifySaveButton(), assertFailurePreText + assertTextVM);
            reportLog(assertTextVM);

            createStandardAlignedFlexBook.clickOnSaveButton();

            String assertTextVCNA = "Presence of 'Content Not Available' Text ";
            Assert.assertTrue(createStandardAlignedFlexBook.verifyContentNotAvailableText(), assertFailurePreText + assertTextVCNA);
            reportLog(assertTextVCNA);

        } catch (Exception e) {
            result = handleException(e);
        }
        Assert.assertTrue(result, testCaseFailureText + currentMethodName + errorMessage);
    }

    @Test(priority = 25, description = "Verify Functionality Of 'Ok' button of Content Not Available Pop UP. ")
    public void verifyFunctionalityOfOkButton() {
        boolean result = true;
        try {
            CreateStandardAlignedFlexBook createStandardAlignedFlexBook = new CreateStandardAlignedFlexBook(webDriver,extentTest,extentReports);

            String assertTextVCSAF = "Presence of 'Ok' button.";
            Assert.assertTrue(createStandardAlignedFlexBook.verifyOkButton(), assertFailurePreText + assertTextVCSAF);
            reportLog(assertTextVCSAF);

            createStandardAlignedFlexBook.clickOnOkButton();

            String assertTextVSAF = "Presence of Create Standard Aligned FlexBookText";
            Assert.assertTrue(createStandardAlignedFlexBook.verifyCreateStandardAlignedFlexBookText(), assertFailurePreText + assertTextVSAF);
            reportLog(assertTextVSAF);

        } catch (Exception e) {
            result = handleException(e);
        }
        Assert.assertTrue(result, testCaseFailureText + currentMethodName + errorMessage);
    }

    @Test(priority = 27, description = "Verify Functionality Of 'Save-Book' button With All Valid Fields.")
    public void verifyFunctionalityOfSaveButton() {
        boolean result = true;
        try {
            CreateStandardAlignedFlexBook createStandardAlignedFlexBook = new CreateStandardAlignedFlexBook(webDriver,extentTest,extentReports);

            createStandardAlignedFlexBook.clickOnSelectSubjectDropDown();

            String assertTextVCSF = "Presence of Create Standard Aligned FlexBookText";
            Assert.assertTrue(createStandardAlignedFlexBook.verifyCreateStandardAlignedFlexBookText(), assertFailurePreText + assertTextVCSF);
            reportLog(assertTextVCSF);

            String assertTextVML = "Presence of 'Algebra Subject' Link ";
            Assert.assertTrue(createStandardAlignedFlexBook.verifyAlgebraSubjectLink(), assertFailurePreText + assertTextVML);
            reportLog(assertTextVML);

            createStandardAlignedFlexBook.clickOnAlgebraSubjectLink();

            String assertTextVCSAF = "Presence of Create Standard Aligned FlexBookText";
            Assert.assertTrue(createStandardAlignedFlexBook.verifyCreateStandardAlignedFlexBookText(), assertFailurePreText + assertTextVCSAF);
            reportLog(assertTextVCSAF);

            createStandardAlignedFlexBook.clickOnStateDropDown();

            String assertTextVSAF = "Presence of Create Standard Aligned FlexBookText";
            Assert.assertTrue(createStandardAlignedFlexBook.verifyCreateStandardAlignedFlexBookText(), assertFailurePreText + assertTextVSAF);
            reportLog(assertTextVSAF);

            String assertTextVC = "Presence of 'CCSS State' Link ";
            Assert.assertTrue(createStandardAlignedFlexBook.verifyCCSSStateLink(), assertFailurePreText + assertTextVC);
            reportLog(assertTextVC);

            createStandardAlignedFlexBook.clickOnCCSSStateLink();

            String assertTextVCSA = "Presence of Create Standard Aligned FlexBookText";
            Assert.assertTrue(createStandardAlignedFlexBook.verifyCreateStandardAlignedFlexBookText(), assertFailurePreText + assertTextVCSA);
            reportLog(assertTextVCSA);

            createStandardAlignedFlexBook.clickOnGradeDropDown();

            String assertTextVAC = "Presence of Create Standard Aligned FlexBookText";
            Assert.assertTrue(createStandardAlignedFlexBook.verifyCreateStandardAlignedFlexBookText(), assertFailurePreText + assertTextVAC);
            reportLog(assertTextVAC);

            String assertTextVL = "Presence of '9th Grade' Link ";
            Assert.assertTrue(createStandardAlignedFlexBook.verify9thGradeLink(), assertFailurePreText + assertTextVL);
            reportLog(assertTextVL);

            createStandardAlignedFlexBook.clickOn9thGradeLink();

            String assertTextVCS = "Presence of Create Standard Aligned FlexBookText";
            Assert.assertTrue(createStandardAlignedFlexBook.verifyCreateStandardAlignedFlexBookText(), assertFailurePreText + assertTextVCS);
            reportLog(assertTextVCS);

            String assertTextVM = "Presence of 'Save' Link ";
            Assert.assertTrue(createStandardAlignedFlexBook.verifySaveButton(), assertFailurePreText + assertTextVM);
            reportLog(assertTextVM);

            createStandardAlignedFlexBook.clickOnSaveButton();

            String assertTextVTOF = "Presence of 'Title Of' FlexBook ";
            Assert.assertTrue(createStandardAlignedFlexBook.verifyTitleOfFlexBook(), assertFailurePreText + assertTextVTOF);
            reportLog(assertTextVTOF);

        } catch (Exception e) {
            result = handleException(e);
        }
        Assert.assertTrue(result, testCaseFailureText + currentMethodName + errorMessage);
    }
}