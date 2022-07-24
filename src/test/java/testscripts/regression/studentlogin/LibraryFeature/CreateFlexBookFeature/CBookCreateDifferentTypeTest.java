package testscripts.regression.studentlogin.LibraryFeature.CreateFlexBookFeature;

import org.apache.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.Test;
import testscripts.BaseTestScript;
import uipages.flexbook2feature.*;

public class CBookCreateDifferentTypeTest extends BaseTestScript {
    private static final Logger logger = Logger.getLogger(CBookCreateDifferentTypeTest.class);
    private String testCaseFailureText = "Test failed for method: ";
    private String assertFailurePreText = "Failed to verify: ";
    public String assertSuccessPreText = "Successfully verified: ";

    @Test(priority = 1, dataProvider = "CK12DataProvider", description = "verify  Functionality of 'Archive' Button After Clicking On Filter Option")
    public void verifyFunctionalityOfArchiveButton(String email, String password) {
        boolean result = true;
        try {
            LibraryPage libraryPage = new LibraryPage(webDriver,extentTest,extentReports);
            CourseBookCreateEditAssignDelete courseBookCreateEditAssignDelete = new CourseBookCreateEditAssignDelete(webDriver,extentTest,extentReports);
            StudentDashBoardPage studentDashBoardPage = new StudentDashBoardPage(webDriver,extentTest,extentReports);

            new LoginPage(webDriver,extentTest, extentReports).teacherLogin(email, password);

            String assertTextVSPOG = "Student profile icon after logging in.";
            Assert.assertTrue(studentDashBoardPage.verifyStudentProfileOnGamma(), assertFailurePreText + assertTextVSPOG);
            reportLog(assertTextVSPOG);

            new PageMenuTab(webDriver,extentTest,extentReports).clickOnLibraryTab();

            String assertTextVCNDD = "Presence of 'Create New' dropdown.";
            Assert.assertTrue(courseBookCreateEditAssignDelete.verifyCreateNewDropDown(), assertFailurePreText + assertTextVCNDD);
            reportLog(assertTextVCNDD);

            libraryPage.clickOnElipsisIconForEdit();

            String assertTextVEB = "Presence of 'Edit' link.";
            Assert.assertTrue(libraryPage.verifyEditButton(), assertFailurePreText + assertTextVEB);
            reportLog(assertTextVEB);

            String assertTextVAB = "Presence of 'Archive' button.";
            Assert.assertTrue(libraryPage.verifyArchiveButton(), assertFailurePreText + assertTextVAB);
            reportLog(assertTextVAB);

            libraryPage.clickOnArchive();

        } catch (Exception e) {
            result = handleException(e);
        }
        Assert.assertTrue(result, testCaseFailureText + currentMethodName + errorMessage);
    }

    @Test(priority = 2, description = "verify  Functionality of ' Ok Archive' Button After Clicking On Archive Button")
    public void verifyFunctionalityOfOkArchiveButton() {
        boolean result = true;
        try {
            LibraryPage libraryPage = new LibraryPage(webDriver,extentTest,extentReports);
            CourseBookCreateEditAssignDelete courseBookCreateEditAssignDelete = new CourseBookCreateEditAssignDelete(webDriver,extentTest,extentReports);

            String assertTextVOAB = "Presence of 'Ok Archive' button after clicking on 'Archive'";
            Assert.assertTrue(libraryPage.verifyOkArchiveButton(), assertFailurePreText + assertTextVOAB);
            reportLog(assertTextVOAB);

            libraryPage.clickOnOK();

            String assertTextVCNDD = "Presence of 'Create New' dropdown.";
            Assert.assertTrue(courseBookCreateEditAssignDelete.verifyCreateNewDropDown(), assertFailurePreText + assertTextVCNDD);
            reportLog(assertTextVCNDD);

        } catch (Exception e) {
            result = handleException(e);
        }
        Assert.assertTrue(result, testCaseFailureText + currentMethodName + errorMessage);
    }

    @Test(priority = 3, description = "verify 'Search Ck12' link After Clicking Add Contents DropDown")
    public void verifySearchCk12Link() {
        boolean result = true;
        try {
            CourseBookCreateEditAssignDelete courseBookCreateEditAssignDelete = new CourseBookCreateEditAssignDelete(webDriver,extentTest,extentReports);
            CreateFlexBookPage createFlexBookPage = new CreateFlexBookPage(webDriver,extentTest,extentReports);

            String courseBookTitle = "FlexBook_";

            courseBookCreateEditAssignDelete.clickOnCreateNewDropDown();

            String assertTextVFBL = "Presence of 'Flexbook 2.0' link.";
            Assert.assertTrue(courseBookCreateEditAssignDelete.verifyFlexBook2Link(), assertFailurePreText + assertTextVFBL);
            reportLog(assertTextVFBL);

            courseBookCreateEditAssignDelete.clickOnFlexBook2Link();
            createFlexBookPage.clickOnGotItButtonPopUp();

            String assertTextVACDD = "Presence of 'Add Content' dropdown.";
            Assert.assertTrue(courseBookCreateEditAssignDelete.verifyAddContentOptions(), assertFailurePreText + assertTextVACDD);
            reportLog(assertTextVACDD);

            createFlexBookPage.enterCourseBookTitle(courseBookTitle);
            //courseBookCreateEditAssignDelete.clickOnAddContentDropDown();

            String assertTextVSCL = "Presence of 'Search CK-12' link.";
            Assert.assertTrue(courseBookCreateEditAssignDelete.verifySearchCk12Link(), assertFailurePreText + assertTextVSCL);
            reportLog(assertTextVSCL);

        } catch (Exception e) {
            result = handleException(e);
        }
        Assert.assertTrue(result, testCaseFailureText + currentMethodName + errorMessage);
    }

    @Test(priority = 5, description = "verify  Functionality of 'Search Ck12' link After Clicking Add Contents DropDown")
    public void verifyFunctionalityOfSearchCk12Link() {
        boolean result = true;
        try {
            CourseBookCreateEditAssignDelete courseBookCreateEditAssignDelete = new CourseBookCreateEditAssignDelete(webDriver,extentTest,extentReports);
            CreateFlexBookPage createFlexBookPage = new CreateFlexBookPage(webDriver,extentTest,extentReports);

            courseBookCreateEditAssignDelete.clickOnSearchCk12Link();

            String assertTextVSB = "Presence of 'Save Search' button";
            Assert.assertTrue(createFlexBookPage.verifySearchButton(), assertFailurePreText + assertTextVSB);
            reportLog(assertTextVSB);

            String assertTextVAFBB = "Presence of 'Add to Flexbook' button.";
            Assert.assertTrue(createFlexBookPage.verifyAddToFlexBookButton(), assertFailurePreText + assertTextVAFBB);
            reportLog(assertTextVAFBB);

        } catch (Exception e) {
            result = handleException(e);
        }
        Assert.assertTrue(result, testCaseFailureText + currentMethodName + errorMessage);
    }

    @Test(priority = 7, description = "verify  Functionality of 'Add To FlexBook' Button Without Adding Any Concept")
    public void verifyFunctionalityOfAddToFlexBookButtonWithoutSelectingConcept() {
        boolean result = true;
        try {
            CourseBookCreateEditAssignDelete courseBookCreateEditAssignDelete = new CourseBookCreateEditAssignDelete(webDriver,extentTest,extentReports);
            CreateFlexBookPage createFlexBookPage = new CreateFlexBookPage(webDriver,extentTest,extentReports);

            createFlexBookPage.clickOnAddConceptToFlexbook();

            String assertTextVPACT = "Presence of 'Please add content' text.";
            Assert.assertTrue(courseBookCreateEditAssignDelete.verifyPleaseAddContentText(), assertFailurePreText + assertTextVPACT);
            reportLog(assertTextVPACT);

            String assertTextVOB = "Presence of 'Ok' button.";
            Assert.assertTrue(courseBookCreateEditAssignDelete.verifyOkButton(), assertFailurePreText + assertTextVOB);
            reportLog(assertTextVOB);

        } catch (Exception e) {
            result = handleException(e);
        }
        Assert.assertTrue(result, testCaseFailureText + currentMethodName + errorMessage);
    }

    @Test(priority = 8, description = "verify  Functionality of 'Ok' Button After Clicking Add To FlexBook Button")
    public void verifyFunctionalityOfOk() {
        boolean result = true;
        try {
            CourseBookCreateEditAssignDelete courseBookCreateEditAssignDelete = new CourseBookCreateEditAssignDelete(webDriver,extentTest,extentReports);
            CreateFlexBookPage createFlexBookPage = new CreateFlexBookPage(webDriver,extentTest,extentReports);

            courseBookCreateEditAssignDelete.clickOnOkButton();

            String assertTextVSB = "Presence of 'Save Search' button.";
            Assert.assertTrue(createFlexBookPage.verifySearchButton(), assertFailurePreText + assertTextVSB);
            reportLog(assertTextVSB);

            String assertTextVAFBB = "Presence of 'Add to Flexbook' button.";
            Assert.assertTrue(createFlexBookPage.verifyAddToFlexBookButton(), assertFailurePreText + assertTextVAFBB);
            reportLog(assertTextVAFBB);

        } catch (Exception e) {
            result = handleException(e);
        }
        Assert.assertTrue(result, testCaseFailureText + currentMethodName + errorMessage);
    }

    @Test(priority = 9, description = "verify  Functionality of 'Search' Button Without Giving Any Concept Name")
    public void verifyFunctionalityOfSearchButtonWithoutConceptName() {
        boolean result = true;
        try {
            CourseBookCreateEditAssignDelete courseBookCreateEditAssignDelete = new CourseBookCreateEditAssignDelete(webDriver,extentTest,extentReports);
            CreateFlexBookPage createFlexBookPage = new CreateFlexBookPage(webDriver,extentTest,extentReports);

            createFlexBookPage.clickOnSearchButton();

            String assertTextVPESTT = "Presence of 'Please Enter Search Term' text.";
            Assert.assertTrue(courseBookCreateEditAssignDelete.verifyPleaseEnterSearchTermText(), assertFailurePreText + assertTextVPESTT);
            reportLog(assertTextVPESTT);

            String assertTextVSB = "Presence of 'Save Search' button.";
            Assert.assertTrue(createFlexBookPage.verifySearchButton(), assertFailurePreText + assertTextVSB);
            reportLog(assertTextVSB);

        } catch (Exception e) {
            result = handleException(e);
        }
        Assert.assertTrue(result, testCaseFailureText + currentMethodName + errorMessage);
    }

    @Test(priority = 10, description = "verify  Functionality of 'Search' Button With Giving Concept Name")
    public void verifyFunctionalityOfSearchButtonWithConceptName() {
        boolean result = true;
        try {
            CreateFlexBookPage createFlexBookPage = new CreateFlexBookPage(webDriver,extentTest,extentReports);

            String conceptName = "Alcohol and Keton";

            createFlexBookPage.enterConceptAddLibrary(conceptName);
            createFlexBookPage.clickOnSearchButton();
            createFlexBookPage.selectConceptFromList();

            String assertTextVAFBB = "Presence of 'Add to Flexbook' button.";
            Assert.assertTrue(createFlexBookPage.verifyAddToFlexBookButton(), assertFailurePreText + assertTextVAFBB);
            reportLog(assertTextVAFBB);

        } catch (Exception e) {
            result = handleException(e);
        }
        Assert.assertTrue(result, testCaseFailureText + currentMethodName + errorMessage);
    }

    @Test(priority = 11, description = "verify  Functionality of 'Add To FlexBook' Button After Selecting Concept")
    public void verifyFunctionalityOfAddToFlexBook() {
        boolean result = true;
        try {
            CourseBookCreateEditAssignDelete courseBookCreateEditAssignDelete = new CourseBookCreateEditAssignDelete(webDriver,extentTest,extentReports);
            CreateFlexBookPage createFlexBookPage = new CreateFlexBookPage(webDriver,extentTest,extentReports);

            createFlexBookPage.clickOnAddConceptToFlexbook();

            String assertTextVSB = "Presence of 'Save' button.";
            Assert.assertTrue(courseBookCreateEditAssignDelete.verifySaveButton(), assertFailurePreText + assertTextVSB);
            reportLog(assertTextVSB);

            courseBookCreateEditAssignDelete.getCountOfContentsBefore();

            String assertTextVCL = "Presence of 'Recently Added' contents.";
            Assert.assertTrue(courseBookCreateEditAssignDelete.verifyContentList(), assertFailurePreText + assertTextVCL);
            reportLog(assertTextVCL);

        } catch (Exception e) {
            result = handleException(e);
        }
        Assert.assertTrue(result, testCaseFailureText + currentMethodName + errorMessage);
    }

    @Test(priority = 12, description = "verify  Functionality of 'New Chapter' Link After Clicking On Add Content DropDown")
    public void verifyFunctionalityOfNewChapterLink() {
        boolean result = true;
        try {
            CourseBookCreateEditAssignDelete courseBookCreateEditAssignDelete = new CourseBookCreateEditAssignDelete(webDriver,extentTest,extentReports);

            String assertTextVACDD = "Presence of 'Add Content' dropdown.";
            Assert.assertTrue(courseBookCreateEditAssignDelete.verifyAddContentOptions(), assertFailurePreText + assertTextVACDD);
            reportLog(assertTextVACDD);

            String assertTextVNCL = "Presence of 'New Chapter' link.";
            Assert.assertTrue(courseBookCreateEditAssignDelete.verifyNewChapterLink(), assertFailurePreText + assertTextVNCL);
            reportLog(assertTextVNCL);

            courseBookCreateEditAssignDelete.clickOnNewChapterLink();

            String assertTextVSCB = "Presence of 'Save Chapter' button.";
            Assert.assertTrue(courseBookCreateEditAssignDelete.verifyNewChapterDoneButton(), assertFailurePreText + assertTextVSCB);
            reportLog(assertTextVSCB);

        } catch (Exception e) {
            result = handleException(e);
        }
        Assert.assertTrue(result, testCaseFailureText + currentMethodName + errorMessage);
    }

    @Test(priority = 13, description = "verify  Functionality of 'Save Chapter' Button Without Giving Chapter Name")
    public void verifyFunctionalityOfSaveChapterButtonWithoutTitle() {
        boolean result = true;
        try {
            CourseBookCreateEditAssignDelete courseBookCreateEditAssignDelete = new CourseBookCreateEditAssignDelete(webDriver,extentTest,extentReports);

            courseBookCreateEditAssignDelete.clickOnNewChapterDoneButton();

            String assertTextVETB = "Presence of 'Edit Title' button on validation pop up";
            Assert.assertTrue(courseBookCreateEditAssignDelete.verifyEditTitleButton(), assertFailurePreText + assertTextVETB);
            reportLog(assertTextVETB);

            courseBookCreateEditAssignDelete.clickOnEditTitleButton();

            String assertTextVSCB = "Presence of 'Save Chapter' button.";
            Assert.assertTrue(courseBookCreateEditAssignDelete.verifyNewChapterDoneButton(), assertFailurePreText + assertTextVSCB);
            reportLog(assertTextVSCB);

            courseBookCreateEditAssignDelete.clickOnCloseIcon();

        } catch (Exception e) {
            result = handleException(e);
        }
        Assert.assertTrue(result, testCaseFailureText + currentMethodName + errorMessage);
    }

    @Test(priority = 14, description = "verify  Functionality of 'Save Chapter ' Button After Giving Chapter Name")
    public void verifyFunctionalityOfEditTitleAfterNewChapterLink() {
        boolean result = true;
        try {
            CourseBookCreateEditAssignDelete courseBookCreateEditAssignDelete = new CourseBookCreateEditAssignDelete(webDriver,extentTest,extentReports);

            String modality = "EnterChapter";

            courseBookCreateEditAssignDelete.getCountOfContentsBefore();

            String assertTextVACDD = "Presence of 'Add Content' dropdown.";
            Assert.assertTrue(courseBookCreateEditAssignDelete.verifyAddContentOptions(), assertFailurePreText + assertTextVACDD);
            reportLog(assertTextVACDD);

            String assertTextVNCL = "Presence of 'New Chapter' link.";
            Assert.assertTrue(courseBookCreateEditAssignDelete.verifyNewChapterLink(), assertFailurePreText + assertTextVNCL);
            reportLog(assertTextVNCL);

            courseBookCreateEditAssignDelete.clickOnNewChapterLink();

            String assertTextVSCB = "Presence of 'Save Chapter' button.";
            Assert.assertTrue(courseBookCreateEditAssignDelete.verifyNewChapterDoneButton(), assertFailurePreText + assertTextVSCB);
            reportLog(assertTextVSCB);

            courseBookCreateEditAssignDelete.clickOnNewChapterDoneButton();

            String assertTextVETB = "Presence of 'Edit Title' button on validation pop up";
            Assert.assertTrue(courseBookCreateEditAssignDelete.verifyEditTitleButton(), assertFailurePreText + assertTextVETB);
            reportLog(assertTextVETB);

            courseBookCreateEditAssignDelete.clickOnEditTitleButton();

            String assertTextVSB = "Presence of 'Sav' button on the LHS to save the FB2.0";
            Assert.assertTrue(courseBookCreateEditAssignDelete.verifySaveButton(), assertFailurePreText + assertTextVSB);
            reportLog(assertTextVSB);

            courseBookCreateEditAssignDelete.setChapterName(modality);
            courseBookCreateEditAssignDelete.clickOnNewChapterDoneButton();
            courseBookCreateEditAssignDelete.getCountOfContentsAfter();

            String assertTextVCLCAS = "Count of 'Content' list after saving.";
            Assert.assertTrue(courseBookCreateEditAssignDelete.verifyContentListCountAfterSave(), assertFailurePreText + assertTextVCLCAS);
            reportLog(assertTextVCLCAS);

            courseBookCreateEditAssignDelete.clickOnSaveButton();

            String assertTextVAL = "Presence of 'Author' link.";
            Assert.assertTrue(courseBookCreateEditAssignDelete.verifyAuthorLink(), assertFailurePreText + assertTextVAL);
            reportLog(assertTextVAL);

        } catch (Exception e) {
            result = handleException(e);
        }
        Assert.assertTrue(result, testCaseFailureText + currentMethodName + errorMessage);
    }
}