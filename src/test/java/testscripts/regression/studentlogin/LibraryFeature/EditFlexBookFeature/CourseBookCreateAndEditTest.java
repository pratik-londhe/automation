package testscripts.regression.studentlogin.LibraryFeature.EditFlexBookFeature;

import org.apache.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.Test;
import testscripts.BaseTestScript;
import uipages.flexbook2feature.*;

public class CourseBookCreateAndEditTest extends BaseTestScript {
    private static final Logger logger = Logger.getLogger(CourseBookCreateAndEditTest.class);

    @Test(priority = 1, dataProvider = "CK12DataProvider", description = "Verify the Create CBook with default AutoPopulated CBook title")
    public void verifyFunctionalityOfAutoPopulatedCBookTitle(String email, String password) {
        boolean result = true;
        try {
            StudentDashBoardPage studentDashBoardPage = new StudentDashBoardPage(webDriver, extentTest, extentReports);
            CourseBookCreateEditAssignDelete courseBookCreateEditAssignDelete = new CourseBookCreateEditAssignDelete(webDriver, extentTest, extentReports);
            CreateFlexBookPage createFlexBookPage = new CreateFlexBookPage(webDriver, extentTest, extentReports);

            new LoginPage(webDriver, extentTest, extentReports).studentLogin(email, password);

            Assert.assertTrue(studentDashBoardPage.verifyStudentProfileOnGamma(), "Failed to verify user profile for Create CBook Using ChapterTest.");
            reportLog("User Successfully logged in and verified profile icon.");

            new PageMenuTab(webDriver, extentTest, extentReports).clickOnLibraryTab();

            Assert.assertTrue(courseBookCreateEditAssignDelete.verifyCreateNewDropDown(), "Failed to verified Create New DropDown");
            reportLog("Successfully verified Create New DropDown");

            courseBookCreateEditAssignDelete.clickOnCreateNewDropDown();

            Assert.assertTrue(courseBookCreateEditAssignDelete.verifyFlexBook2Link(), "Failed to verified FlexBook2 Link.");
            reportLog("Successfully verified FlexBook2 Link.");

            courseBookCreateEditAssignDelete.clickOnFlexBook2Link();
            createFlexBookPage.clickOnGotItButtonPopUp();

            Assert.assertTrue(courseBookCreateEditAssignDelete.verifySaveButton(), "Failed to verified Save Button.");
            reportLog("Successfully verified Save Button.");

            courseBookCreateEditAssignDelete.clickOnSaveButton();

            Assert.assertTrue(createFlexBookPage.isMessageOnPopUpVisible(), "Failed to verify.");
            reportLog("Validation message is displaying in page.");

            Assert.assertTrue(createFlexBookPage.isInvalidTitleOnPopUpVisible(), "Failed to verify invalid title.");
            reportLog("Invalid Title text is displaying in pop up.");

            Assert.assertTrue(createFlexBookPage.isCancelBtnOnPopUpVisible(), "Failed to verify Cancel Button");
            reportLog("Successfully Verified Cancel Button");

            //createFlexBookPage.clickOnCancelButton();

            String courseBookTitle = "FlexBook_";

            Assert.assertTrue(createFlexBookPage.isEditTitleBtnOnPopUpVisible(), "Failed to verify Edit Title Button");
            reportLog("Successfully Verified Edit Title Button");

            createFlexBookPage.clickOnEditTitleButton();
            createFlexBookPage.enterCourseBookTitle(courseBookTitle);

        } catch (Exception e) {
            result = handleException(e);
        }
        Assert.assertTrue(result, "Test script failed for  : " + errorMessage);
    }

    @Test(priority = 2, description = "verify Functionality of 'New Read' Link Without Giving CourseBook Name")
    public void verifyFunctionalityOfNewReadLinkWithoutGivingCourseBookName() {
        boolean result = true;
        try {
            CourseBookCreateEditAssignDelete courseBookCreateEditAssignDelete = new CourseBookCreateEditAssignDelete(webDriver, extentTest, extentReports);
            CreateFlexBookPage createFlexBookPage = new CreateFlexBookPage(webDriver, extentTest, extentReports);

            Assert.assertTrue(courseBookCreateEditAssignDelete.verifyAddContentOptions(), "Failed to verified Add Content DropDown.");
            reportLog("Successfully verified Add Content DropDown.");

            //courseBookCreateEditAssignDelete.clickOnAddContentDropDown();

            Assert.assertTrue(courseBookCreateEditAssignDelete.verifyNewReadLink(), "Failed to verified New Read Link.");
            reportLog("Successfully  New Read Link.");

            courseBookCreateEditAssignDelete.clickOnNewReadLink();

            /*Assert.assertTrue(createFlexBookPage.isMessageOnPopUpVisible(), "Failed to verify.");
            reportLog("Validation message is displaying in page.");

            Assert.assertTrue(createFlexBookPage.isInvalidTitleOnPopUpVisible(), "Failed to verify invalid title.");
            reportLog("Invalid Title text is displaying in pop up.");

            Assert.assertTrue(createFlexBookPage.isCancelBtnOnPopUpVisible(), "Failed to verify Cancel Button");
            reportLog("Successfully Verified Cancel Button");*/

        } catch (Exception e) {
            result = handleException(e);
        }
        Assert.assertTrue(result, "Test script failed : " + errorMessage);
    }

    @Test(priority = 3, description = "verify Functionality of 'New Read' Link After Giving CourseBook Name")
    public void verifyFunctionalityOfNewReadLinkAfterGivingCourseBookName() {
        boolean result = true;
        try {
            CourseBookCreateEditAssignDelete courseBookCreateEditAssignDelete = new CourseBookCreateEditAssignDelete(webDriver, extentTest, extentReports);
            CreateFlexBookPage createFlexBookPage = new CreateFlexBookPage(webDriver, extentTest, extentReports);

/*            String courseBookTitle = "FlexBook_";

            Assert.assertTrue(createFlexBookPage.isEditTitleBtnOnPopUpVisible(), "Failed to verify Edit Title Button");
            reportLog("Successfully Verified Edit Title Button");

            createFlexBookPage.clickOnEditTitleButton();
            createFlexBookPage.enterCourseBookTitle(courseBookTitle);

            Assert.assertTrue(courseBookCreateEditAssignDelete.verifyNewReadLink(), "Failed to verified New Read Link.");
            reportLog("Successfully  New Read Link.");

            courseBookCreateEditAssignDelete.clickOnNewReadLink();

            createFlexBookPage.clickOnGotItButtonPopUp(); */

            Assert.assertTrue(createFlexBookPage.verifySaveModalityButton(), "Failed to verified Save Modality Button.");
            reportLog("Successfully verified Save Modality Button.");

            Assert.assertTrue(courseBookCreateEditAssignDelete.isDeleteRowButtonPresent(), "Failed to verify Delete row button for New Read feature");
            reportLog("Successfully  verified Go Back Modality Button");

        } catch (Exception e) {
            result = handleException(e);
        }
        Assert.assertTrue(result, "Test script failed : " + errorMessage);
    }

    @Test(priority = 4, description = "Verify Functionality of 'Go Back' Button Without Giving Modality Name")
    public void verifyFunctionalityOfGoBackButtonWithoutGivingModalityName() {
        boolean result = true;
        try {
            CourseBookCreateEditAssignDelete courseBookCreateEditAssignDelete = new CourseBookCreateEditAssignDelete(webDriver, extentTest, extentReports);
            CreateFlexBookPage createFlexBookPage = new CreateFlexBookPage(webDriver, extentTest, extentReports);

            //courseBookCreateEditAssignDelete.clickOnGoBAckButton();
            courseBookCreateEditAssignDelete.clickOnCloseIcon();
            //createFlexBookPage.clickOnGotItButtonPopUp();

            Assert.assertTrue(courseBookCreateEditAssignDelete.verifyAddContentOptions(), "Failed to verified Add Content DropDown.");
            reportLog("Successfully verified Add Content DropDown.");

            //courseBookCreateEditAssignDelete.clickOnAddContentDropDown();

            Assert.assertTrue(courseBookCreateEditAssignDelete.verifyNewReadLink(), "Failed to verified New Read Link.");
            reportLog("Successfully  New Read Link.");

            courseBookCreateEditAssignDelete.clickOnNewReadLink();
            //createFlexBookPage.clickOnGotItButtonPopUp();

            Assert.assertTrue(createFlexBookPage.verifySaveModalityButton(), "Failed to verified Save Modality Button.");
            reportLog("Successfully verified Save Modality Button.");

        } catch (Exception e) {
            result = handleException(e);
        }
        Assert.assertTrue(result, "Test script failed : " + errorMessage);
    }

    @Test(priority = 5, description = "Verify the add modality with default AutoPopulated modality title")
    public void verifyFunctionalityOfSaveModalityButtonWithoutGivingModalityName() {
        boolean result = true;
        try {
            CreateFlexBookPage createFlexBookPage = new CreateFlexBookPage(webDriver, extentTest, extentReports);

            createFlexBookPage.clickOnSaveModality();

            Assert.assertTrue(createFlexBookPage.isCancelBtnOnPopUpVisibleReadMod(), "Failed to verified cancel Button");
            reportLog("Successfully verified cancel Button");

            Assert.assertTrue(createFlexBookPage.isEditTitleBtnOnPopUpVisibleReadMod(), "Failed to verify Edit Title button on validation pop up.");
            reportLog("Successfully verified Edit Title button on validation pop up.");

            createFlexBookPage.clickOnEditTitleButtonReadMod();

            Assert.assertTrue(createFlexBookPage.verifySaveModalityButton(), "Failed to verified Save Modality Button.");
            reportLog("Successfully verified Save Modality Button.");

        } catch (Exception e) {
            result = handleException(e);
        }
        Assert.assertTrue(result, "Test script failed : " + errorMessage);
    }

    @Test(priority = 6, description = "Verify Functionality of 'Save Modality' Button After Giving Modality Name")
    public void verifyFunctionalityOfSaveModalityButtonGivingModalityName() {
        boolean result = true;
        try {
            CreateFlexBookPage createFlexBookPage = new CreateFlexBookPage(webDriver, extentTest, extentReports);

            String modality = "EnterModality";

            createFlexBookPage.enterModalityName(modality);
            createFlexBookPage.clickOnSaveModality();

            /*Assert.assertTrue(createFlexBookPage.verifyGoBackModalityButton(), "Failed to verified Go Back Modality Button");
            reportLog("Successfully  verified Go Back Modality Button");*/

        } catch (Exception e) {
            result = handleException(e);
        }
        Assert.assertTrue(result, "Test script failed  : " + errorMessage);
    }

    @Test(priority = 7, description = "Verify Functionality of 'Go Button' Button After Saving Modality")
    public void verifyFunctionalityOfGoBackButton() {
        boolean result = true;
        try {
            CourseBookCreateEditAssignDelete courseBookCreateEditAssignDelete = new CourseBookCreateEditAssignDelete(webDriver, extentTest, extentReports);
            CreateFlexBookPage createFlexBookPage = new CreateFlexBookPage(webDriver, extentTest, extentReports);

            //createFlexBookPage.clickOnGoBackButton();
            //createFlexBookPage.clickOnGotItButtonPopUp();
            courseBookCreateEditAssignDelete.getCountOfContents();

            Assert.assertTrue(courseBookCreateEditAssignDelete.verifyContentList(), "Failed to verified Recently Added Contents");
            reportLog("Successfully  verified Recently Added Contents");

            Assert.assertTrue(courseBookCreateEditAssignDelete.verifySaveButton(), "Failed to verified Save Button.");
            reportLog("Successfully verified Save Button.");

            Assert.assertTrue(courseBookCreateEditAssignDelete.verifyAddContentOptions(), "Failed to verified Add Content DropDown.");
            reportLog("Successfully verified Add Content DropDown.");

        } catch (Exception e) {
            result = handleException(e);
        }
        Assert.assertTrue(result, "Test script failed  : " + errorMessage);
    }

    @Test(priority = 8, description = "Verify Functionality of 'Filter Option ' DropDown After Adding New FlexBook")
    public void verifyFunctionalityOfFilterOption() {
        boolean result = true;
        try {
            CourseBookCreateEditAssignDelete courseBookCreateEditAssignDelete = new CourseBookCreateEditAssignDelete(webDriver, extentTest, extentReports);
            LibraryPage libraryPage = new LibraryPage(webDriver, extentTest, extentReports);
            BrowseFeature browseFeature = new BrowseFeature(webDriver, extentTest, extentReports);
            CBookLandingPage cBookLandingPage = new CBookLandingPage(webDriver, extentTest, extentReports);

            //new PageMenuTab(webDriver, extentTest, extentReports).clickOnLibraryTab();
            Assert.assertTrue(courseBookCreateEditAssignDelete.verifySaveButton(), "Failed to verified Save Button.");
            reportLog("Successfully verified Save Button.");

            courseBookCreateEditAssignDelete.clickOnSaveButton();
            browseFeature.clickUsernameDropDownFB2LandingPage();
            cBookLandingPage.clickOnLinkLibrary();

            Assert.assertTrue(courseBookCreateEditAssignDelete.verifyAddToCk12Button(), "Failed to verified Add To Ck12 Button");
            reportLog("Successfully verified Add To Ck12 Button");

            Assert.assertTrue(courseBookCreateEditAssignDelete.verifyCreateNewDropDown(), "Failed to verified Create New DropDown");
            reportLog("Successfully verified Create New DropDown");

            libraryPage.clickOnElipsisIconForEdit();

            Assert.assertTrue(libraryPage.verifyEditButton(), "Failed to verified Edit Button");
            reportLog("Successfully  verified Edit Button");

            Assert.assertTrue(libraryPage.verifyArchiveButton(), "Failed to verified Archive Button.");
            reportLog("Successfully verified Archive Button.");

        } catch (Exception e) {
            result = handleException(e);
        }
        Assert.assertTrue(result, "Test script failed  : " + errorMessage);
    }

    // @Test(priority = 9, description = "Verify Functionality of 'Edit ' Button After Clicking On Filter option DropDown")
    public void verifyFunctionalityOfEditButton() {
        boolean result = true;
        try {
            CourseBookCreateEditAssignDelete courseBookCreateEditAssignDelete = new CourseBookCreateEditAssignDelete(webDriver, extentTest, extentReports);
            LibraryPage libraryPage = new LibraryPage(webDriver, extentTest, extentReports);
            CreateFlexBookPage createFlexBookPage = new CreateFlexBookPage(webDriver, extentTest, extentReports);

            String modality = "EnterModality_";

            libraryPage.clickOnEdit();
            createFlexBookPage.clickOnGotItButtonPopUp();

            Assert.assertTrue(courseBookCreateEditAssignDelete.verifyAddContentOptions(), "Failed to verified Add Content DropDown.");
            reportLog("Successfully verified Add Content DropDown.");

            courseBookCreateEditAssignDelete.clickOnAddContentDropDown();

            Assert.assertTrue(courseBookCreateEditAssignDelete.verifyNewReadLink(), "Failed to verified New Read Link.");
            reportLog("Successfully  New Read Link.");

            courseBookCreateEditAssignDelete.clickOnNewReadLink();
            createFlexBookPage.clickOnGotItButtonPopUp();

            Assert.assertTrue(createFlexBookPage.verifySaveModalityButton(), "Failed to verified Save Modality Button.");
            reportLog("Successfully verified Save Modality Button.");

            courseBookCreateEditAssignDelete.enterModalityNameAgain(modality);
            createFlexBookPage.clickOnSaveModality();

            Assert.assertTrue(createFlexBookPage.verifyGoBackModalityButton(), "Failed to verified Go Back Modality Button");
            reportLog("Successfully  verified Go Back Modality Button");

            createFlexBookPage.clickOnGoBackButton();
            createFlexBookPage.clickOnGotItButtonPopUp();

            Assert.assertTrue(courseBookCreateEditAssignDelete.verifyEditedContentAddedInList(), "Failed to verified Edited Content");
            reportLog("Successfully  verified Edited Content");

        } catch (Exception e) {
            result = handleException(e);
        }
        Assert.assertTrue(result, "Test script failed  : " + errorMessage);
    }

    //@Test(priority = 10,description = "Verify Functionality of 'Save' Button After Editing FlexBook")
    public void verifyFunctionalityOfSaveButtonAfterEditingFlexBook() {
        boolean result = true;
        try {
            CourseBookCreateEditAssignDelete courseBookCreateEditAssignDelete = new CourseBookCreateEditAssignDelete(webDriver, extentTest, extentReports);

            Assert.assertTrue(courseBookCreateEditAssignDelete.verifySaveButton(), "Failed to verified Save Button.");
            reportLog("Successfully verified Save Button.");

            courseBookCreateEditAssignDelete.clickOnSaveButton();

            Assert.assertTrue(new CourseBookDetailsPage(webDriver, extentTest, extentReports).verifyChooseButton(), "Failed to verified Choose Button.");
            reportLog("Successfully verified Choose Button.");

            Assert.assertTrue(courseBookCreateEditAssignDelete.verifyAuthorLink(), "Failed to verified Author Name.");
            reportLog("Successfully verified Recently Author Name.");

        } catch (Exception e) {
            result = handleException(e);
        }
        Assert.assertTrue(result, "Test script failed for  : " + errorMessage);
    }
}