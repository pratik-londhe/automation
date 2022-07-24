package testscripts.regression.teacherlogin.CreateNewFeature.CreateNewDropDownFeature;

import com.relevantcodes.extentreports.LogStatus;
import org.apache.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.Test;
import testscripts.BaseTestScript;
import uipages.flexbook2feature.*;

public class CBookCreationDifferentTypeTest extends BaseTestScript {
    private static final Logger logger = Logger.getLogger(CBookCreationDifferentTypeTest.class);

    @Test(priority = 1, dataProvider = "CK12DataProvider", description = "verify 'Search Ck12' link After Clicking Add Contents DropDown")
    public void verifySearchCk12Link(String email, String password) {
        boolean result = true;
        try {
            TeacherDashboardPage teacherDashboardPage = new TeacherDashboardPage(webDriver, extentTest, extentReports);
            CourseBookCreateEditAssignDelete courseBookCreateEditAssignDelete = new CourseBookCreateEditAssignDelete(webDriver, extentTest, extentReports);
            CreateFlexBookPage createFlexBookPage = new CreateFlexBookPage(webDriver, extentTest, extentReports);

            String courseBookTitle = "FlexBook_";

            new LoginPage(webDriver, extentTest, extentReports).teacherLogin(email, password);

            Assert.assertTrue(teacherDashboardPage.verifyTeacherProfileOnGamma(), "Failed to verified user profile for CreateCBookUsingModalityTest.");
            extentTest.log(LogStatus.PASS, "User Successfully logged in and verified profile icon.");
            logger.info("User Successfully logged in and verified profile icon.");

            new PageMenuTab(webDriver, extentTest, extentReports).clickOnLibraryTab();

            Assert.assertTrue(courseBookCreateEditAssignDelete.verifyCreateNewDropDown(), "Failed to verified Create New DropDown");
            extentTest.log(LogStatus.PASS, "Successfully verified Create New DropDown");
            logger.info("Successfully verified Create New DropDown");

            courseBookCreateEditAssignDelete.clickOnCreateNewDropDown();

            Assert.assertTrue(courseBookCreateEditAssignDelete.verifyFlexBook2Link(), "Failed to verified FlexBook2 Link.");
            extentTest.log(LogStatus.PASS, "Successfully verified FlexBook2 Link.");
            logger.info("Successfully verified FlexBook2 Link.");

            courseBookCreateEditAssignDelete.clickOnFlexBook2Link();
            createFlexBookPage.clickOnGotItButtonPopUp();

            Assert.assertTrue(courseBookCreateEditAssignDelete.verifyAddContentOptions(), "Failed to verified Add Content DropDown.");
            extentTest.log(LogStatus.PASS, "Successfully verified Add Content DropDown.");
            logger.info("Successfully verified Add Content DropDown.");

            createFlexBookPage.enterCourseBookTitle(courseBookTitle);
            courseBookCreateEditAssignDelete.clickOnAddContentDropDown();

            Assert.assertTrue(courseBookCreateEditAssignDelete.verifySearchCk12Link(), "Failed to verified Search Ck12 Link.");
            extentTest.log(LogStatus.PASS, "Successfully verified Search Ck12 Link.");
            logger.info("Successfully verified Search Ck12 Link.");

        } catch (Exception e) {
            result = handleException(e);
        }
        Assert.assertTrue(result, "Test script failed for  : " + errorMessage);
    }

    @Test(priority = 2, description = "verify  Functionality of 'Search Ck12' link After Clicking Add Contents DropDown")
    public void verifyFunctionalityOfSearchCk12Link() {
        boolean result = true;
        try {
            CourseBookCreateEditAssignDelete courseBookCreateEditAssignDelete = new CourseBookCreateEditAssignDelete(webDriver, extentTest, extentReports);
            CreateFlexBookPage createFlexBookPage = new CreateFlexBookPage(webDriver, extentTest, extentReports);

            courseBookCreateEditAssignDelete.clickOnSearchCk12Link();

            Assert.assertTrue(createFlexBookPage.verifySearchButton(), "Failed to verified Search Button.");
            extentTest.log(LogStatus.PASS, "Successfully verified Save Search Button.");
            logger.info("Successfully verified Save Search Button.");

            Assert.assertTrue(createFlexBookPage.verifyAddToFlexBookButton(), "Failed to verified Add To FlexBook Button.");
            extentTest.log(LogStatus.PASS, "Successfully verified Save Add To FlexBook Button.");
            logger.info("Successfully verified Save Add To FlexBook Button.");

        } catch (Exception e) {
            result = handleException(e);
        }
        Assert.assertTrue(result, "Test script failed for  : " + errorMessage);
    }

    @Test(priority = 3, description = "verify  Functionality of 'Add To FlexBook' Button Without Adding Any Concept")
    public void verifyFunctionalityOfAddToFlexBookButtonWithoutSelectingConcept() {
        boolean result = true;
        try {
            CourseBookCreateEditAssignDelete courseBookCreateEditAssignDelete = new CourseBookCreateEditAssignDelete(webDriver, extentTest, extentReports);
            CreateFlexBookPage createFlexBookPage = new CreateFlexBookPage(webDriver, extentTest, extentReports);

            createFlexBookPage.clickOnAddConceptToFlexbook();

            Assert.assertTrue(courseBookCreateEditAssignDelete.verifyPleaseAddContentText(), "Failed to verified Please Add Content Text");
            extentTest.log(LogStatus.PASS, "Successfully verified Please Add Content Text.");
            logger.info("Successfully verified Please Add Content Text.");

            Assert.assertTrue(courseBookCreateEditAssignDelete.verifyOkButton(), "Failed to verified Ok Button.");
            extentTest.log(LogStatus.PASS, "Successfully verified Ok Button.");
            logger.info("Successfully verified Ok Button.");

        } catch (Exception e) {
            result = handleException(e);
        }
        Assert.assertTrue(result, "Test script failed for  : " + errorMessage);
    }

    @Test(priority = 4, description = "verify  Functionality of 'Ok' Button After Clicking Add To FlexBook Button")
    public void verifyFunctionalityOfOk() {
        boolean result = true;
        try {
            CourseBookCreateEditAssignDelete courseBookCreateEditAssignDelete = new CourseBookCreateEditAssignDelete(webDriver, extentTest, extentReports);
            CreateFlexBookPage createFlexBookPage = new CreateFlexBookPage(webDriver, extentTest, extentReports);

            courseBookCreateEditAssignDelete.clickOnOkButton();

            Assert.assertTrue(createFlexBookPage.verifySearchButton(), "Failed to verified Search Button.");
            extentTest.log(LogStatus.PASS, "Successfully verified Save Search Button.");
            logger.info("Successfully verified Save Search Button.");

            Assert.assertTrue(createFlexBookPage.verifyAddToFlexBookButton(), "Failed to verified Add To FlexBook Button.");
            extentTest.log(LogStatus.PASS, "Successfully verified Save Add To FlexBook Button.");
            logger.info("Successfully verified Save Add To FlexBook Button.");

        } catch (Exception e) {
            result = handleException(e);
        }
        Assert.assertTrue(result, "Test script failed for  : " + errorMessage);
    }

    @Test(priority = 5, description = "verify  Functionality of 'Search' Button Without Giving Any Concept Name")
    public void verifyFunctionalityOfSearchButtonWithoutConceptName() {
        boolean result = true;
        try {
            CourseBookCreateEditAssignDelete courseBookCreateEditAssignDelete = new CourseBookCreateEditAssignDelete(webDriver, extentTest, extentReports);
            CreateFlexBookPage createFlexBookPage = new CreateFlexBookPage(webDriver, extentTest, extentReports);

            createFlexBookPage.clickOnSearchButton();

            Assert.assertTrue(courseBookCreateEditAssignDelete.verifyPleaseEnterSearchTermText(), "Failed to verified Please Enter Search Term Text.");
            extentTest.log(LogStatus.PASS, "Successfully verified Please Enter Search Term Text");
            logger.info("Successfully verified Please Enter Search Term Text.");

            Assert.assertTrue(createFlexBookPage.verifySearchButton(), "Failed to verified Search Button.");
            extentTest.log(LogStatus.PASS, "Successfully verified Save Search Button.");
            logger.info("Successfully verified Save Search Button.");

        } catch (Exception e) {
            result = handleException(e);
        }
        Assert.assertTrue(result, "Test script failed for  : " + errorMessage);
    }

    @Test(priority = 6, description = "verify  Functionality of 'Search' Button With Giving Concept Name")
    public void verifyFunctionalityOfSearchButtonWithConceptName() {
        boolean result = true;
        try {
            CourseBookCreateEditAssignDelete courseBookCreateEditAssignDelete = new CourseBookCreateEditAssignDelete(webDriver, extentTest, extentReports);
            CreateFlexBookPage createFlexBookPage = new CreateFlexBookPage(webDriver, extentTest, extentReports);

            String conceptName = "Alcohol and Ketone";

            createFlexBookPage.enterConceptAddLibrary(conceptName);
            createFlexBookPage.clickOnSearchButton();
            createFlexBookPage.selectConceptFromList();

            Assert.assertTrue(createFlexBookPage.verifyAddToFlexBookButton(), "Failed to verified Add To FlexBook Button.");
            extentTest.log(LogStatus.PASS, "Successfully verified Save Add To FlexBook Button.");
            logger.info("Successfully verified Save Add To FlexBook Button.");

        } catch (Exception e) {
            result = handleException(e);
        }
        Assert.assertTrue(result, "Test script failed for  : " + errorMessage);
    }

    @Test(priority = 7, description = "verify  Functionality of 'Add To FlexBook' Button After Selecting Concept")
    public void verifyFunctionalityOfAddToFlexBook() {
        boolean result = true;
        try {
            CourseBookCreateEditAssignDelete courseBookCreateEditAssignDelete = new CourseBookCreateEditAssignDelete(webDriver, extentTest, extentReports);
            CreateFlexBookPage createFlexBookPage = new CreateFlexBookPage(webDriver, extentTest, extentReports);

            createFlexBookPage.clickOnAddConceptToFlexbook();

            Assert.assertTrue(courseBookCreateEditAssignDelete.verifySaveButton(), "Failed to verified Save Button.");
            extentTest.log(LogStatus.PASS, "Successfully verified Save Button.");
            logger.info("Successfully verified Save Button.");

            courseBookCreateEditAssignDelete.getCountOfContentsBefore();

            Assert.assertTrue(courseBookCreateEditAssignDelete.verifyContentList(), "Failed to verified Recently Added Contents");
            extentTest.log(LogStatus.PASS, "Successfully  verified Recently Added Contents");
            logger.info("Successfully  verified Recently Added Contents");

        } catch (Exception e) {
            result = handleException(e);
        }
        Assert.assertTrue(result, "Test script failed for  : " + errorMessage);
    }

    @Test(priority = 8, description = "verify  Functionality of 'New Chapter' Link After Clicking On Add Content DropDown")
    public void verifyFunctionalityOfNewChapterLink() {
        boolean result = true;
        try {
            CourseBookCreateEditAssignDelete courseBookCreateEditAssignDelete = new CourseBookCreateEditAssignDelete(webDriver, extentTest, extentReports);
            CreateFlexBookPage createFlexBookPage = new CreateFlexBookPage(webDriver, extentTest, extentReports);

            Assert.assertTrue(courseBookCreateEditAssignDelete.verifyAddContentOptions(), "Failed to verified Add Content DropDown.");
            extentTest.log(LogStatus.PASS, "Successfully verified Add Content DropDown.");
            logger.info("Successfully verified Add Content DropDown.");

            Assert.assertTrue(courseBookCreateEditAssignDelete.verifyNewChapterLink(), "Failed to verified New Chapter Link.");
            extentTest.log(LogStatus.PASS, "Successfully verified New Chapter Link.");
            logger.info("Successfully verified New Chapter Link.");

            courseBookCreateEditAssignDelete.clickOnNewChapterLink();

            Assert.assertTrue(courseBookCreateEditAssignDelete.verifyNewChapterDoneButton(), "Failed to verified Save Chapter Button.");
            extentTest.log(LogStatus.PASS, "Successfully verified Save Chapter Button.");
            logger.info("Successfully verified Save Chapter Button.");

        } catch (Exception e) {
            result = handleException(e);
        }
        Assert.assertTrue(result, "Test script failed for  : " + errorMessage);
    }

    @Test(priority = 9, description = "verify  Functionality of 'Save Chapter' Button Without Giving Chapter Name")
    public void verifyFunctionalityOfSaveChapterButtonWithoutTitle() {
        boolean result = true;
        try {
            CourseBookCreateEditAssignDelete courseBookCreateEditAssignDelete = new CourseBookCreateEditAssignDelete(webDriver, extentTest, extentReports);
            CreateFlexBookPage createFlexBookPage = new CreateFlexBookPage(webDriver, extentTest, extentReports);

            courseBookCreateEditAssignDelete.clickOnNewChapterDoneButton();

            Assert.assertTrue(courseBookCreateEditAssignDelete.verifyEditTitleButton(), "Failed to verify Edit Title button on validation pop up.");
            extentTest.log(LogStatus.PASS, "Successfully verified Edit Title button on validation pop up.");
            logger.info("Successfully verified Edit Title button on validation pop up.");

            courseBookCreateEditAssignDelete.clickOnEditTitleButton();

            Assert.assertTrue(courseBookCreateEditAssignDelete.verifyNewChapterDoneButton(), "Failed to verified Save Chapter Button.");
            extentTest.log(LogStatus.PASS, "Successfully verified Save Chapter Button.");
            logger.info("Successfully verified Save Chapter Button.");

            courseBookCreateEditAssignDelete.clickOnCloseIcon();

        } catch (Exception e) {
            result = handleException(e);
        }
        Assert.assertTrue(result, "Test script failed for  : " + errorMessage);
    }

    // @Test(priority = 10, description = "verify  Functionality of 'Save Chapter ' Button After Giving Chapter  Name")
    public void verifyFunctionalityOfEditTitleAfterNewChapterLink() {
        boolean result = true;
        try {
            CourseBookCreateEditAssignDelete courseBookCreateEditAssignDelete = new CourseBookCreateEditAssignDelete(webDriver, extentTest, extentReports);
            CreateFlexBookPage createFlexBookPage = new CreateFlexBookPage(webDriver, extentTest, extentReports);

            String modality = "EnterChapter";

            courseBookCreateEditAssignDelete.getCountOfContentsBefore();

            Assert.assertTrue(courseBookCreateEditAssignDelete.verifyAddContentOptions(), "Failed to verified Add Content DropDown.");
            extentTest.log(LogStatus.PASS, "Successfully verified Add Content DropDown.");
            logger.info("Successfully verified Add Content DropDown.");

            Assert.assertTrue(courseBookCreateEditAssignDelete.verifyNewChapterLink(), "Failed to verified New Chapter Link.");
            extentTest.log(LogStatus.PASS, "Successfully verified New Chapter Link.");
            logger.info("Successfully verified New Chapter Link.");

            courseBookCreateEditAssignDelete.clickOnNewChapterLink();

            Assert.assertTrue(courseBookCreateEditAssignDelete.verifyNewChapterDoneButton(), "Failed to verified Save Chapter Button.");
            extentTest.log(LogStatus.PASS, "Successfully verified Save Chapter Button.");
            logger.info("Successfully verified Save Chapter Button.");

            courseBookCreateEditAssignDelete.clickOnNewChapterDoneButton();

            Assert.assertTrue(courseBookCreateEditAssignDelete.verifyEditTitleButton(), "Failed to verify Edit Title button on validation pop up.");
            extentTest.log(LogStatus.PASS, "Successfully verified Edit Title button on validation pop up.");
            logger.info("Successfully verified Edit Title button on validation pop up.");

            courseBookCreateEditAssignDelete.clickOnEditTitleButton();

            Assert.assertTrue(courseBookCreateEditAssignDelete.verifySaveButton(), "Failed to verified Save Button.");
            extentTest.log(LogStatus.PASS, "Successfully verified Save Button.");
            logger.info("Successfully verified Save Button.");

            courseBookCreateEditAssignDelete.setChapterName(modality);
            courseBookCreateEditAssignDelete.clickOnNewChapterDoneButton();
            courseBookCreateEditAssignDelete.getCountOfContentsAfter();

            Assert.assertTrue(courseBookCreateEditAssignDelete.verifyContentListCountAfterSave(), "Failed to verified Recently Added Chapter.");
            extentTest.log(LogStatus.PASS, "Successfully verified Recently Added Chapter.");
            logger.info("Successfully verified Recently Added Chapter.");

            courseBookCreateEditAssignDelete.clickOnSaveButton();

            Assert.assertTrue(new CourseBookDetailsPage(webDriver, extentTest, extentReports).verifyChooseButton(), "Failed to verified Choose Button.");
            extentTest.log(LogStatus.PASS, "Successfully verified Choose Button.");
            logger.info("Successfully verified Choose Button.");

            Assert.assertTrue(courseBookCreateEditAssignDelete.verifyFlexBookNameAddedInList(), "Failed to verified Recently Added FlexBook Name.");
            extentTest.log(LogStatus.PASS, "Successfully verified Recently Added FlexBook Name.");
            logger.info("Successfully verified Recently Added FlexBook Name.");

            new CourseBookDetailsPage(webDriver, extentTest, extentReports).clickOnChooseButton();
            courseBookCreateEditAssignDelete.clickOnEditButton();
            createFlexBookPage.clickOnGotItButtonPopUp();
            new PageMenuTab(webDriver, extentTest, extentReports).clickOnLibraryTab();

        } catch (Exception e) {
            result = handleException(e);
        }
        Assert.assertTrue(result, "Test script failed for  : " + errorMessage);
    }

    //@Test(priority = 11, description = "verify  Functionality of 'Archive' Button After Clicking On Filter Option")
    public void verifyFunctionalityOfArchiveButton() {
        boolean result = true;
        try {
            LibraryPage libraryPage = new LibraryPage(webDriver,extentTest,extentReports);
            libraryPage.clickOnElipsisIconForEdit();

            Assert.assertTrue(libraryPage.verifyEditButton(), "Failed to verified Edit Button");
            extentTest.log(LogStatus.PASS, "Successfully  verified Edit Button");
            logger.info("Successfully  verified Edit Button");

            Assert.assertTrue(libraryPage.verifyArchiveButton(), "Failed to verified Archive Button.");
            extentTest.log(LogStatus.PASS, "Successfully verified Archive Button.");
            logger.info("Successfully verified Archive Button.");

            libraryPage.clickOnArchive();

            Assert.assertTrue(libraryPage.isArchivedSuccessMessageDisplaying(), "Failed to verified Archive Success Message.");
            extentTest.log(LogStatus.PASS, "Successfully verified Archive Success Message.");
            logger.info("Successfully verified Archive Success Message.");

        } catch (Exception e) {
            result = handleException(e);
        }
        Assert.assertTrue(result, "Test script failed for  : " + errorMessage);
    }

    //@Test(priority = 12, description = "verify  Functionality of ' Ok Archive' Button After Clicking On Archive Button")
    public void verifyFunctionalityOfOkArchiveButton() {
        boolean result = true;
        try {
            LibraryPage libraryPage = new LibraryPage(webDriver,extentTest,extentReports);

            Assert.assertTrue(libraryPage.verifyOkArchiveButton(), "Failed to verified Ok Archive Button.");
            extentTest.log(LogStatus.PASS, "Successfully verified Ok Archive Button.");
            logger.info("Successfully verified Archive Ok Archive Button.");

            libraryPage.clickOnOK();
            libraryPage.clickOnElipsisIconForEdit();

            Assert.assertTrue(libraryPage.verifyEditButton(), "Failed to verified Edit Button");
            extentTest.log(LogStatus.PASS, "Successfully  verified Edit Button");
            logger.info("Successfully  verified Edit Button");

            Assert.assertTrue(libraryPage.verifyArchiveButton(), "Failed to verified Archive Button.");
            extentTest.log(LogStatus.PASS, "Successfully verified Archive Button.");
            logger.info("Successfully verified Archive Button.");

            libraryPage.clickOnArchive();

            Assert.assertTrue(libraryPage.isArchivedSuccessMessageDisplaying(), "Failed to verified Archive Success Message.");
            extentTest.log(LogStatus.PASS, "Successfully verified Archive Success Message.");
            logger.info("Successfully verified Archive Success Message.");

            Assert.assertTrue(libraryPage.verifyOkArchiveButton(), "Failed to verified Ok Archive Button.");
            extentTest.log(LogStatus.PASS, "Successfully verified Ok Archive Button.");
            logger.info("Successfully verified Archive Ok Archive Button.");

            libraryPage.clickOnOK();

        } catch (Exception e) {
            result = handleException(e);
        }
        Assert.assertTrue(result, "Test script failed for  : " + errorMessage);
    }
}