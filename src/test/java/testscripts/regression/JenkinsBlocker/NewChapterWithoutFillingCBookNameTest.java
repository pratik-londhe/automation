package testscripts.regression.JenkinsBlocker;

import com.relevantcodes.extentreports.LogStatus;
import org.apache.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.Test;
import testscripts.BaseTestScript;
import uipages.flexbook2feature.*;

/**
 * Created by pratik.londhe on 8/24/2018.
 */
public class NewChapterWithoutFillingCBookNameTest extends BaseTestScript {
    private static final Logger logger = Logger.getLogger(NewChapterWithoutFillingCBookNameTest.class);
    public CreateFlexBookPage createFlexBookPage;
    public LibraryPage libraryPage;
    public PageMenuTab pageMenuTab;
    public CourseBookCreateEditAssignDelete courseBookCreateEditAssignDelete;

    @Test(priority = 1, dataProvider = "CK12DataProvider", description = "Verify the click on functionality on \"New Chapter\" option without filling FlexBook name.")
    public void WriteModalityWithoutFillingFlexBookName(String email, String password) {
        boolean result = true;
        try {
            createFlexBookPage = new CreateFlexBookPage(webDriver,extentTest,extentReports);
            libraryPage = new LibraryPage(webDriver,extentTest,extentReports);
            pageMenuTab = new PageMenuTab(webDriver,extentTest,extentReports);
            courseBookCreateEditAssignDelete = new CourseBookCreateEditAssignDelete(webDriver,extentTest,extentReports);

            new LoginPage(webDriver,extentTest, extentReports).teacherLogin(email, password);

            Assert.assertTrue(new TeacherDashboardPage(webDriver,extentTest,extentReports).verifyTeacherProfileOnGamma(), "Failed to verify user profile for CbookAssignFromModalityPageTest.");
            extentTest.log(LogStatus.PASS, "User Successfully logged in and verified profile icon.");
            logger.info("User Successfully logged in and verified profile icon.");

            pageMenuTab.clickOnLibraryTab();

            Assert.assertTrue(courseBookCreateEditAssignDelete.verifyCreateNewDropDown(), "Failed to verified Create New DropDown");
            extentTest.log(LogStatus.PASS, "Successfully verified Create New DropDown");
            logger.info("Successfully verified Create New DropDown");

            courseBookCreateEditAssignDelete.clickOnCreateNewDropDown();

            libraryPage.clickOnLinkFlexBook();
            createFlexBookPage.clickOnGotItButtonPopUp();
            createFlexBookPage.clickOnAddContentBtn();
            createFlexBookPage.clickOnNewChapterLink();

            Assert.assertTrue(createFlexBookPage.isInvalidTitleOnPopUpVisible(), "Failed to verify Invalid Title on validation pop up.");
            extentTest.log(LogStatus.PASS, "Successfully verified Invalid Title on validation pop up.");
            logger.info("Successfully verified Invalid Title on validation pop up.");

            Assert.assertTrue(createFlexBookPage.isMessageOnPopUpVisible(), "Failed to verify message on validation pop up.");
            extentTest.log(LogStatus.PASS, "Successfully verified message on validation pop up.");
            logger.info("Successfully verified message on validation pop up.");

            Assert.assertTrue(createFlexBookPage.isCancelBtnOnPopUpVisible(), "Failed to verify cancel button on validation pop up.");
            extentTest.log(LogStatus.PASS, "Successfully verified Cancel button on validation pop up.");
            logger.info("Successfully verified Cancel button on validation pop up.");

            Assert.assertTrue(createFlexBookPage.isEditTitleBtnOnPopUpVisible(), "Failed to verify Edit Title button on validation pop up.");
            extentTest.log(LogStatus.PASS, "Successfully verified Edit Title button on validation pop up.");
            logger.info("Successfully verified Edit Title button on validation pop up.");

        } catch (Exception e) {
            result = handleException(e);
        }
        Assert.assertTrue(result, "Test script failed for WriteModalityWithoutFillingFlexBookName method." + errorMessage);
    }

    @Test(priority = 2, description = "Verify the 'Cancel' Button Functionality On Invalid Title Pop Up")
    public void cancelButtonOfInvalidTitle() {
        boolean result = true;
        try {
            createFlexBookPage.clickOnCancelButton();

            Assert.assertTrue(createFlexBookPage.verifyNewChapterLink(), "Failed to verify New Chapter Link.");
            extentTest.log(LogStatus.PASS, "Successfully verified New Chapter link in Add Content Drop down.");
            logger.info("Successfully verified New Chapter link in Add Content Drop down.");

            Assert.assertTrue(createFlexBookPage.verifySaveButton(), "Failed to verify Title Of Chapter.");
            extentTest.log(LogStatus.PASS, "Successfully verified Title of Chapter Field");
            logger.info("Successfully verified  Title of Chapter Field");

        } catch (Exception e) {
            result = handleException(e);
        }
        Assert.assertTrue(result, "Test script failed for cancelButtonOfInavlidTitle method." + errorMessage);
    }

    @Test(priority = 3, description = "verify  Functionality of 'Edit Title' button in Invalid Title PopUp")
    public void editTitleButtonOfInvalidTitle() {
        boolean result = true;
        try {
            createFlexBookPage.clickOnNewChapterLink();

            Assert.assertTrue(createFlexBookPage.isEditTitleBtnOnPopUpVisible(), "Failed to verify Edit Title button on validation pop up.");
            extentTest.log(LogStatus.PASS, "Successfully verified Edit Title button on validation pop up.");
            logger.info("Successfully verified Edit Title button on validation pop up.");

            createFlexBookPage.clickOnEditTitleButton();

            Assert.assertTrue(createFlexBookPage.verifyNewChapterLink(), "Failed to verify New Chapter Link.");
            extentTest.log(LogStatus.PASS, "Successfully verified New Chapter link in Add Content Drop down.");
            logger.info("Successfully verified New Chapter link in Add Content Drop down.");

            Assert.assertTrue(createFlexBookPage.verifySaveButton(), "Failed to verify Title Of Chapter.");
            extentTest.log(LogStatus.PASS, "Successfully verified Title of Chapter Field");
            logger.info("Successfully verified  Title of Chapter Field");

        } catch (Exception e) {
            result = handleException(e);
        }
        Assert.assertTrue(result, "Test script failed for editTitleButtonOfInavliTitle method." + errorMessage);
    }

    @Test(priority = 4, description = "Verify the 'Cross Bar'  Functionality On Invalid Title Pop Up")
    public void crossBarOfInvalidTitlePopUp() {
        boolean result = true;
        try {
            createFlexBookPage.clickOnNewChapterLink();

            Assert.assertTrue(createFlexBookPage.verifyCrossIcon(), " Failed To Verify");
            extentTest.log(LogStatus.PASS, "User Successfully verified After Cancel Button..");
            logger.info("User Successfully  verified After Cancel Button.");

            createFlexBookPage.clickOnCrossIcon();

            Assert.assertTrue(createFlexBookPage.verifyNewChapterLink(), "Failed to verify New Chapter Link.");
            extentTest.log(LogStatus.PASS, "Successfully verified New Chapter link in Add Content Drop down.");
            logger.info("Successfully verified New Chapter link in Add Content Drop down.");

            Assert.assertTrue(createFlexBookPage.verifySaveButton(), "Failed to verify Title Of Chapter.");
            extentTest.log(LogStatus.PASS, "Successfully verified Title of Chapter Field");
            logger.info("Successfully verified  Title of Chapter Field");

        } catch (Exception e) {
            result = handleException(e);
        }
        Assert.assertTrue(result, "Test script failed for crossBarOfInvalidTitlePopUp method." + errorMessage);
    }
}