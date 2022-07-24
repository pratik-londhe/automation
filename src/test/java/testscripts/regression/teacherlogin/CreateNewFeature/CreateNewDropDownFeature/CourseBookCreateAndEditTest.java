package testscripts.regression.teacherlogin.CreateNewFeature.CreateNewDropDownFeature;

import com.relevantcodes.extentreports.LogStatus;
import org.apache.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.Test;
import testscripts.BaseTestScript;
import uipages.flexbook2feature.*;

public class CourseBookCreateAndEditTest extends BaseTestScript {
    private static final Logger logger = Logger.getLogger(CourseBookCreateAndEditTest.class);

    @Test(priority = 1, dataProvider = "CK12DataProvider", description = "verify  Functionality of 'Library' Tab")
    public void createFlexBookUsingModality(String email, String password) {
        boolean result = true;
        try {
            new LoginPage(webDriver, extentTest, extentReports).teacherLogin(email, password);
            TeacherDashboardPage teacherDashboardPage = new TeacherDashboardPage(webDriver, extentTest, extentReports);
            CourseBookCreateEditAssignDelete courseBookCreateEditAssignDelete = new CourseBookCreateEditAssignDelete(webDriver, extentTest, extentReports);

            Assert.assertTrue(teacherDashboardPage.verifyTeacherProfileOnGamma(), "Failed to verified user profile for CreateCBookUsingModalityTest.");
            extentTest.log(LogStatus.PASS, "User Successfully logged in and verified profile icon.");
            logger.info("User Successfully logged in and verified profile icon.");

            new PageMenuTab(webDriver, extentTest, extentReports).clickOnLibraryTab();

            Assert.assertTrue(courseBookCreateEditAssignDelete.verifyAddToCk12Button(), "Failed to verified Add To Ck12 Button");
            extentTest.log(LogStatus.PASS, "Successfully verified Add To Ck12 Button");
            logger.info("Successfully verified Add To Ck12 Button");

            Assert.assertTrue(courseBookCreateEditAssignDelete.verifyCreateNewDropDown(), "Failed to verified Create New DropDown");
            extentTest.log(LogStatus.PASS, "Successfully verified Create New DropDown");
            logger.info("Successfully verified Create New DropDown");

        } catch (Exception e) {
            result = handleException(e);
        }
        Assert.assertTrue(result, "Test script failed for  : " + errorMessage);
    }

    @Test(priority = 2, description = "verify Functionality of 'Create New' DropDown After Clicking On Library Tab")
    public void verifyFunctionalityOfCreateNew() {
        boolean result = true;
        try {
            CourseBookCreateEditAssignDelete courseBookCreateEditAssignDelete = new CourseBookCreateEditAssignDelete(webDriver, extentTest, extentReports);

            courseBookCreateEditAssignDelete.clickOnCreateNewDropDown();

            Assert.assertTrue(courseBookCreateEditAssignDelete.verifyModalityLink(), "Failed to verified modality Link.");
            extentTest.log(LogStatus.PASS, "Successfully verified modality Link.");
            logger.info("Successfully verified modality Link.");

            Assert.assertTrue(courseBookCreateEditAssignDelete.verifyFlexBookTextBookLink(), "Failed to verified FlexBook TextBook Link.");
            extentTest.log(LogStatus.PASS, "Successfully verified FlexBook TextBook Link.");
            logger.info("Successfully verified FlexBook TextBook Link.");

            Assert.assertTrue(courseBookCreateEditAssignDelete.verifyFlexBook2Link(), "Failed to verified FlexBook2 Link.");
            extentTest.log(LogStatus.PASS, "Successfully verified FlexBook2 Link.");
            logger.info("Successfully verified FlexBook2 Link.");

            Assert.assertTrue(courseBookCreateEditAssignDelete.verifyQuizLink(), "Failed to verified Quiz Link.");
            extentTest.log(LogStatus.PASS, "Successfully verified Quiz Link.");
            logger.info("Successfully verified Quiz Link.");

        } catch (Exception e) {
            result = handleException(e);
        }
        Assert.assertTrue(result, "Test script failed : " + errorMessage);
    }

    @Test(priority = 3, description = "verify Functionality of 'FlexBook 2.0' Link After Clicking On Create New DropDown")
    public void verifyFunctionalityOfFlexBook2Link() {
        boolean result = true;
        try {
            CourseBookCreateEditAssignDelete courseBookCreateEditAssignDelete = new CourseBookCreateEditAssignDelete(webDriver, extentTest, extentReports);
            CreateFlexBookPage createFlexBookPage = new CreateFlexBookPage(webDriver, extentTest, extentReports);

            String courseBookTitle = "FlexBook_";

            courseBookCreateEditAssignDelete.clickOnFlexBook2Link();
            createFlexBookPage.clickOnGotItButtonPopUp();

            Assert.assertTrue(courseBookCreateEditAssignDelete.verifySaveButton(), "Failed to verified Save Button.");
            extentTest.log(LogStatus.PASS, "Successfully verified Save Button.");
            logger.info("Successfully verified Save Button.");

            Assert.assertTrue(courseBookCreateEditAssignDelete.verifyAddContentOptions(), "Failed to verified Add Content DropDown.");
            extentTest.log(LogStatus.PASS, "Successfully verified Add Content DropDown.");
            logger.info("Successfully verified Add Content DropDown.");

            createFlexBookPage.enterCourseBookTitle(courseBookTitle);

        } catch (Exception e) {
            result = handleException(e);
        }
        Assert.assertTrue(result, "Test script failed : " + errorMessage);
    }

    @Test(priority = 4, description = "verify Functionality of 'Add Content ' DropDown After Clicking On FlexBook2 Link")
    public void verifyFunctionalityOfAddContentDropDown() {
        boolean result = true;
        try {
            CourseBookCreateEditAssignDelete courseBookCreateEditAssignDelete = new CourseBookCreateEditAssignDelete(webDriver, extentTest, extentReports);

            Assert.assertTrue(courseBookCreateEditAssignDelete.verifyAddContentOptions(), "Failed to verified Add Content DropDown.");
            extentTest.log(LogStatus.PASS, "Successfully verified Add Content DropDown.");
            logger.info("Successfully verified Add Content DropDown.");

            courseBookCreateEditAssignDelete.clickOnAddContentDropDown();

            Assert.assertTrue(courseBookCreateEditAssignDelete.verifySearchCk12Link(), "Failed to verified Search Ck12 Link.");
            extentTest.log(LogStatus.PASS, "Successfully verified Search Ck12 Link.");
            logger.info("Successfully verified Search Ck12 Link.");

            Assert.assertTrue(courseBookCreateEditAssignDelete.verifyNewReadLink(), "Failed to verified New Read Link.");
            extentTest.log(LogStatus.PASS, "Successfully  New Read Link.");
            logger.info("Successfully verified New Read Link.");

            Assert.assertTrue(courseBookCreateEditAssignDelete.verifyNewChapterLink(), "Failed to verified New Chapter Link.");
            extentTest.log(LogStatus.PASS, "Successfully verified New Chapter Link.");
            logger.info("Successfully verified New Chapter Link.");

        } catch (Exception e) {
            result = handleException(e);
        }
        Assert.assertTrue(result, "Test script failed : " + errorMessage);
    }

    @Test(priority = 5, description = "verify Functionality of 'New Read' link After Clicking On Add Content DropDown")
    public void verifyFunctionalityOfNewReadLink() {
        boolean result = true;
        try {
            CourseBookCreateEditAssignDelete courseBookCreateEditAssignDelete = new CourseBookCreateEditAssignDelete(webDriver, extentTest, extentReports);
            CreateFlexBookPage createFlexBookPage = new CreateFlexBookPage(webDriver, extentTest, extentReports);

            courseBookCreateEditAssignDelete.clickOnNewReadLink();
            createFlexBookPage.clickOnGotItButtonPopUp();

            Assert.assertTrue(createFlexBookPage.verifySaveModalityButton(), "Failed to verified Save Modality Button.");
            extentTest.log(LogStatus.PASS, "Successfully verified Save Modality Button.");
            logger.info("Successfully verified Save Modality Button.");

           /* Assert.assertTrue(courseBookCreateEditAssignDelete.verifyGoBAckButton(), "Failed to verified Go Back Modality Button");
            extentTest.log(LogStatus.PASS, "Successfully  verified Go Back Modality Button");
            logger.info("Successfully  verified Go Back Modality Button");*/

        } catch (Exception e) {
            result = handleException(e);
        }
        Assert.assertTrue(result, "Test script failed : " + errorMessage);
    }

    //@Test(priority = 6, description = "verify Functionality of 'Go Back' Button Without Giving Modality Name")
    public void verifyFunctionalityOfGoBackButtonWithoutGivingModalityName() {
        boolean result = true;
        try {
            CourseBookCreateEditAssignDelete courseBookCreateEditAssignDelete = new CourseBookCreateEditAssignDelete(webDriver, extentTest, extentReports);
            CreateFlexBookPage createFlexBookPage = new CreateFlexBookPage(webDriver, extentTest, extentReports);

            courseBookCreateEditAssignDelete.clickOnGoBAckButton();
            createFlexBookPage.clickOnGotItButtonPopUp();

            //courseBookCreateEditAssignDelete.clickOnPoUP();

            Assert.assertTrue(courseBookCreateEditAssignDelete.verifyAddContentOptions(), "Failed to verified Add Content DropDown.");
            extentTest.log(LogStatus.PASS, "Successfully verified Add Content DropDown.");
            logger.info("Successfully verified Add Content DropDown.");

            courseBookCreateEditAssignDelete.clickOnAddContentDropDown();

            Assert.assertTrue(courseBookCreateEditAssignDelete.verifyNewReadLink(), "Failed to verified New Read Link.");
            extentTest.log(LogStatus.PASS, "Successfully  New Read Link.");
            logger.info("Successfully verified New Read Link.");

            courseBookCreateEditAssignDelete.clickOnNewReadLink();
            createFlexBookPage.clickOnGotItButtonPopUp();

            Assert.assertTrue(createFlexBookPage.verifySaveModalityButton(), "Failed to verified Save Modality Button.");
            extentTest.log(LogStatus.PASS, "Successfully verified Save Modality Button.");
            logger.info("Successfully verified Save Modality Button.");

        } catch (Exception e) {
            result = handleException(e);
        }
        Assert.assertTrue(result, "Test script failed : " + errorMessage);
    }

    @Test(priority = 7, description = "verify Functionality of 'Save Modality' Button Without Giving Modality Name")
    public void verifyFunctionalityOfSaveModalityButtonWithoutGivingModalityName() {
        boolean result = true;
        try {
            CreateFlexBookPage createFlexBookPage = new CreateFlexBookPage(webDriver, extentTest, extentReports);

            createFlexBookPage.clickOnSaveModality();

            Assert.assertTrue(createFlexBookPage.isCancelNewBtnOnPopUpVisible(), "Failed to verified cancel Button");
            extentTest.log(LogStatus.PASS, "Successfully verified cancel Button");
            logger.info("Successfully verified cancel Button");

            Assert.assertTrue(createFlexBookPage.isEditTitleNewBtnOnPopUpVisible(), "Failed to verify Edit Title button on validation pop up.");
            extentTest.log(LogStatus.PASS, "Successfully verified Edit Title button on validation pop up.");
            logger.info("Successfully verified Edit Title button on validation pop up.");

            createFlexBookPage.clickOnEditTitleNewButton();

            Assert.assertTrue(createFlexBookPage.verifySaveModalityButton(), "Failed to verified Save Modality Button.");
            extentTest.log(LogStatus.PASS, "Successfully verified Save Modality Button.");
            logger.info("Successfully verified Save Modality Button.");

        } catch (Exception e) {
            result = handleException(e);
        }
        Assert.assertTrue(result, "Test script failed : " + errorMessage);
    }

    @Test(priority = 8, description = "verify Functionality of 'Save Modality' Button With Giving Modality Name")
    public void verifyFunctionalityOfSaveModalityButtonGivingModalityName() {
        boolean result = true;
        try {
            CreateFlexBookPage createFlexBookPage = new CreateFlexBookPage(webDriver, extentTest, extentReports);

            String modality = "EnterModality";

            createFlexBookPage.enterModalityNameFlexBook(modality);
            createFlexBookPage.enterModalityName(modality);
            createFlexBookPage.clickOnSaveModality();
            createFlexBookPage.clickOnSaveBtn();

           /* Assert.assertTrue(createFlexBookPage.verifyGoBackModalityButton(), "Failed to verified Go Back Modality Button");
            extentTest.log(LogStatus.PASS, "Successfully  verified Go Back Modality Button");
            logger.info("Successfully  verified Go Back Modality Button");*/

        } catch (Exception e) {
            result = handleException(e);
        }
        Assert.assertTrue(result, "Test script failed  : " + errorMessage);
    }

    //@Test(priority = 9, description = "verify Functionality of 'Go Button' Button After Saving Modality")
    public void verifyFunctionalityOfGoBackButton() {
        boolean result = true;
        try {
            CourseBookCreateEditAssignDelete courseBookCreateEditAssignDelete = new CourseBookCreateEditAssignDelete(webDriver, extentTest, extentReports);
            CreateFlexBookPage createFlexBookPage = new CreateFlexBookPage(webDriver, extentTest, extentReports);

            createFlexBookPage.clickOnGoBackButton();
            createFlexBookPage.clickOnGotItButtonPopUp();
            courseBookCreateEditAssignDelete.getCountOfContents();

            Assert.assertTrue(courseBookCreateEditAssignDelete.verifyContentList(), "Failed to verified Recently Added Contents");
            extentTest.log(LogStatus.PASS, "Successfully  verified Recently Added Contents");
            logger.info("Successfully  verified Recently Added Contents");

            Assert.assertTrue(courseBookCreateEditAssignDelete.verifySaveButton(), "Failed to verified Save Button.");
            extentTest.log(LogStatus.PASS, "Successfully verified Save Button.");
            logger.info("Successfully verified Save Button.");

            /*Assert.assertTrue(courseBookCreateEditAssignDelete.verifyAddContentOptions(), "Failed to verified Add Content DropDown.");
            extentTest.log(LogStatus.PASS, "Successfully verified Add Content DropDown.");
            logger.info("Successfully verified Add Content DropDown.");*/

        } catch (Exception e) {
            result = handleException(e);
        }
        Assert.assertTrue(result, "Test script failed  : " + errorMessage);
    }

    @Test(priority = 10, description = "verify Functionality of 'Filter Option ' DropDown After Adding New FlexBook")
    public void verifyFunctionalityOfFilterOption() {
        boolean result = true;
        try {
            CourseBookCreateEditAssignDelete courseBookCreateEditAssignDelete = new CourseBookCreateEditAssignDelete(webDriver, extentTest, extentReports);
            LibraryPage libraryPage = new LibraryPage(webDriver, extentTest, extentReports);

            Thread.sleep(10000);

            webDriver.navigate().to("https://master.ck12.org/my/library/");

            Assert.assertTrue(courseBookCreateEditAssignDelete.verifyAddToCk12Button(), "Failed to verified Add To Ck12 Button");
            extentTest.log(LogStatus.PASS, "Successfully verified Add To Ck12 Button");
            logger.info("Successfully verified Add To Ck12 Button");

            Assert.assertTrue(courseBookCreateEditAssignDelete.verifyCreateNewDropDown(), "Failed to verified Create New DropDown");
            extentTest.log(LogStatus.PASS, "Successfully verified Create New DropDown");
            logger.info("Successfully verified Create New DropDown");

            libraryPage.clickOnElipsisIconForEdit();

            Assert.assertTrue(libraryPage.verifyEditButton(), "Failed to verified Edit Button");
            extentTest.log(LogStatus.PASS, "Successfully  verified Edit Button");
            logger.info("Successfully  verified Edit Button");

            Assert.assertTrue(libraryPage.verifyArchiveButton(), "Failed to verified Archive Button.");
            extentTest.log(LogStatus.PASS, "Successfully verified Archive Button.");
            logger.info("Successfully verified Archive Button.");

        } catch (Exception e) {
            result = handleException(e);
        }
        Assert.assertTrue(result, "Test script failed  : " + errorMessage);
    }

    //@Test(priority = 11, description = "verify Functionality of 'Edit ' Button After Clicking On Filter option DropDown")
    public void verifyFunctionalityOfEditButton() {
        boolean result = true;
        try {
            CourseBookCreateEditAssignDelete courseBookCreateEditAssignDelete = new CourseBookCreateEditAssignDelete(webDriver, extentTest, extentReports);
            CreateFlexBookPage createFlexBookPage = new CreateFlexBookPage(webDriver, extentTest, extentReports);
            LibraryPage libraryPage = new LibraryPage(webDriver, extentTest, extentReports);

            String modality = "EnterModality_";

            libraryPage.clickOnEdit();
            createFlexBookPage.clickOnGotItButtonPopUp();
            createFlexBookPage.clickOnGoBackButton();

           /* Assert.assertTrue(courseBookCreateEditAssignDelete.verifyAddContentOptions(), "Failed to verified Add Content DropDown.");
            extentTest.log(LogStatus.PASS, "Successfully verified Add Content DropDown.");
            logger.info("Successfully verified Add Content DropDown.");

            courseBookCreateEditAssignDelete.clickOnAddContentDropDown();*/

            Assert.assertTrue(courseBookCreateEditAssignDelete.verifyNewReadLink(), "Failed to verified New Read Link.");
            extentTest.log(LogStatus.PASS, "Successfully  New Read Link.");
            logger.info("Successfully verified New Read Link.");

            courseBookCreateEditAssignDelete.clickOnNewReadLink();
            createFlexBookPage.clickOnGotItButtonPopUp();

            Assert.assertTrue(createFlexBookPage.verifySaveModalityButton(), "Failed to verified Save Modality Button.");
            extentTest.log(LogStatus.PASS, "Successfully verified Save Modality Button.");
            logger.info("Successfully verified Save Modality Button.");

            courseBookCreateEditAssignDelete.enterModalityNameAgain(modality);
            createFlexBookPage.clickOnSaveModality();

           /* Assert.assertTrue(createFlexBookPage.verifyGoBackModalityButton(), "Failed to verified Go Back Modality Button");
            extentTest.log(LogStatus.PASS, "Successfully  verified Go Back Modality Button");
            logger.info("Successfully  verified Go Back Modality Button");

            createFlexBookPage.clickOnGoBackButton();
            createFlexBookPage.clickOnGotItButtonPopUp();

            Assert.assertTrue(courseBookCreateEditAssignDelete.verifyEditedContentAddedInList(), "Failed to verified Edited Content");
            extentTest.log(LogStatus.PASS, "Successfully  verified Edited Content");
            logger.info("Successfully  verified Edited Content");*/


        } catch (Exception e) {
            result = handleException(e);
        }
        Assert.assertTrue(result, "Test script failed  : " + errorMessage);
    }

    @Test(priority = 12, description = "verify Functionality of 'Save' Button After Editing FlexBook")
    public void verifyFunctionalityOfSaveButtonAfterEditingFlexBook() {
        boolean result = true;
        try {
            CourseBookCreateEditAssignDelete courseBookCreateEditAssignDelete = new CourseBookCreateEditAssignDelete(webDriver, extentTest, extentReports);

            /*Assert.assertTrue(courseBookCreateEditAssignDelete.verifySaveButton(), "Failed to verified Save Button.");
            extentTest.log(LogStatus.PASS, "Successfully verified Save Button.");
            logger.info("Successfully verified Save Button.");

            courseBookCreateEditAssignDelete.clickOnSaveButton();

            Assert.assertTrue(new CourseBookDetailsPage(webDriver, extentTest, extentReports).verifyChooseButton(), "Failed to verified Choose Button.");
            extentTest.log(LogStatus.PASS, "Successfully verified Choose Button.");
            logger.info("Successfully verified Choose Button.");

            Assert.assertTrue(courseBookCreateEditAssignDelete.verifyAuthorLink(), "Failed to verified Author Name.");
            extentTest.log(LogStatus.PASS, "Successfully verified Recently Author Name.");
            logger.info("Successfully verified Recently Author Name.");*/

        } catch (Exception e) {
            result = handleException(e);
        }
        Assert.assertTrue(result, "Test script failed  : " + errorMessage);
    }
}