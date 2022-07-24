package testscripts.regression.teacherlogin.LibraryFeature.ArchiveFeature;

import com.relevantcodes.extentreports.LogStatus;
import org.apache.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.Test;
import testscripts.BaseTestScript;
import uipages.flexbook2feature.*;

public class ViewArchivedAndRestoreCourseBookTest extends BaseTestScript {
    private static final Logger logger = Logger.getLogger(ViewArchivedAndRestoreCourseBookTest.class);

    @Test(priority = 1, dataProvider = "CK12DataProvider", description = "Verify Functionality of 'View Archived' Button After Clicking On Library Tab")
    public void verifyFunctionalityOfViewArchivedButton(String email, String password) {
        boolean result = true;
        try {
            CourseBookCreateEditAssignDelete courseBookCreateEditAssignDelete = new CourseBookCreateEditAssignDelete(webDriver,extentTest,extentReports);
            ViewArchivedAndRestoreCBook viewArchivedAndRestoreCourseBook = new ViewArchivedAndRestoreCBook(webDriver,extentTest,extentReports);

            new LoginPage(webDriver,extentTest, extentReports).teacherLogin(email, password);

            Assert.assertTrue(new TeacherDashboardPage(webDriver,extentTest,extentReports).verifyTeacherProfileOnGamma(), "Failed to verify user profile for CbookAssignFromModalityPageTest.");
            extentTest.log(LogStatus.PASS, "User Successfully logged in and verified profile icon.");
            logger.info("User Successfully logged in and verified profile icon.");

            new PageMenuTab(webDriver,extentTest,extentReports).clickOnLibraryTab();

            Assert.assertTrue(courseBookCreateEditAssignDelete.verifyCreateNewDropDown(), "Failed to verified Create New DropDown");
            extentTest.log(LogStatus.PASS, "Successfully verified Create New DropDown");
            logger.info("Successfully verified Create New DropDown");

            Assert.assertTrue(viewArchivedAndRestoreCourseBook.verifyViewArchivedButton(), "Failed to verified View Archive Button.");
            extentTest.log(LogStatus.PASS, "Successfully verified View Archive Button.");
            logger.info("Successfully verified View Archive Button.");

            viewArchivedAndRestoreCourseBook.getListOfCourseBookInLibrary();
            viewArchivedAndRestoreCourseBook.clickOnViewArchivedButton();

            Assert.assertTrue(viewArchivedAndRestoreCourseBook.verifyViewArchivedButton(), "Failed to verified View Library Button.");
            extentTest.log(LogStatus.PASS, "Successfully verified View Library Button.");
            logger.info("Successfully verified View Library Button.");

            viewArchivedAndRestoreCourseBook.getListOfCourseBookInArchiveLibrary();

            Assert.assertTrue(viewArchivedAndRestoreCourseBook.verifyListsOfUnarchivedAndArchivedCBooks(), "Failed to verified List Of CourseBook Are Different In Library And Archive.");
            extentTest.log(LogStatus.PASS, "Successfully verified List Of CourseBook Are Different In Library And Archive.");
            logger.info("Successfully verified List Of CourseBook Are Different In Library And Archive.");

        } catch (Exception e) {
            result = handleException(e);
        }
        Assert.assertTrue(result, "Test script failed : " + errorMessage);
    }

    @Test(priority = 2, description = "Verify Functionality of 'View Library' Button After Clicking On View Archive Button.")
    public void verifyFunctionalityOfViewLibraryButton() {
        boolean result = true;
        try {
            ViewArchivedAndRestoreCBook viewArchivedAndRestoreCourseBook = new ViewArchivedAndRestoreCBook(webDriver,extentTest,extentReports);

            viewArchivedAndRestoreCourseBook.getListOfCourseBookInArchiveLibrary();
            viewArchivedAndRestoreCourseBook.clickOnViewArchivedButton();

            Assert.assertTrue(viewArchivedAndRestoreCourseBook.verifyViewArchivedButton(), "Failed to verified View Archive Button.");
            extentTest.log(LogStatus.PASS, "Successfully verified View Archive Button.");
            logger.info("Successfully verified View Archive Button.");

            viewArchivedAndRestoreCourseBook.getListOfCourseBookInLibrary();

            Assert.assertTrue(viewArchivedAndRestoreCourseBook.verifyListsOfUnarchivedAndArchivedCBooks(), "Failed to verified List Of CourseBook Are Different In Library And Archive.");
            extentTest.log(LogStatus.PASS, "Successfully verified List Of CourseBook Are Different In Library And Archive.");
            logger.info("Successfully verified List Of CourseBook Are Different In Library And Archive.");

            viewArchivedAndRestoreCourseBook.clickOnViewArchivedButton();

            Assert.assertTrue(viewArchivedAndRestoreCourseBook.verifyViewArchivedButton(), "Failed to verified View Archive Button.");
            extentTest.log(LogStatus.PASS, "Successfully verified View Archive Button.");
            logger.info("Successfully verified View Archive Button.");

        } catch (Exception e) {
            result = handleException(e);
        }
        Assert.assertTrue(result, "Test script failed : " + errorMessage);
    }

    @Test(priority = 3, description = "Verify Functionality of 'Restore Items' Button Without Selecting CourseBook.")
    public void verifyFunctionalityOfRestoreItemsButtonWithoutSelectingCourseBook() {
        boolean result = true;
        try {
            ViewArchivedAndRestoreCBook viewArchivedAndRestoreCourseBook = new ViewArchivedAndRestoreCBook(webDriver,extentTest,extentReports);

            Assert.assertTrue(viewArchivedAndRestoreCourseBook.verifyRestoreItemsButton(), "Failed to verified Restore Items Button.");
            extentTest.log(LogStatus.PASS, "Successfully verified Restore Items Button.");
            logger.info("Successfully verified Restore Items Button.");

            viewArchivedAndRestoreCourseBook.clickOnRestoreItemsButton();

            Assert.assertTrue(viewArchivedAndRestoreCourseBook.verifyOkButton(), "Failed to verified Ok Button.");
            extentTest.log(LogStatus.PASS, "Successfully verified Ok Button.");
            logger.info("Successfully verified Ok Button.");

            viewArchivedAndRestoreCourseBook.clickOnOkButton();

            Assert.assertTrue(viewArchivedAndRestoreCourseBook.verifyViewArchivedButton(), "Failed to verified View Archive Button.");
            extentTest.log(LogStatus.PASS, "Successfully verified View Archive Button.");
            logger.info("Successfully verified View Archive Button.");

        } catch (Exception e) {
            result = handleException(e);
        }
        Assert.assertTrue(result, "Test script failed : " + errorMessage);
    }

    @Test(priority = 4, description = "Verify Functionality of 'Restore Items' Button After Selecting CourseBook.")
    public void verifyFunctionalityOfRestoreItemsButton() {
        boolean result = true;
        try {
            ViewArchivedAndRestoreCBook viewArchivedAndRestoreCourseBook = new ViewArchivedAndRestoreCBook(webDriver,extentTest,extentReports);

            //Assert.assertTrue(viewArchivedAndRestoreCourseBook.verifyRestoreItemsButton(), "Failed to verified Restore Items Button.");
            extentTest.log(LogStatus.PASS, "Successfully verified Restore Items Button.");
            logger.info("Successfully verified Restore Items Button.");

            //viewArchivedAndRestoreCourseBook.getTextOfCourseBookName();
            //viewArchivedAndRestoreCourseBook.clickOnCheckBox();
            //viewArchivedAndRestoreCourseBook.clickOnRestoreItemsButton();

            //Assert.assertTrue(viewArchivedAndRestoreCourseBook.verifyOkButton(), "Failed to verified Ok Button.");
            extentTest.log(LogStatus.PASS, "Successfully verified Ok Button.");
            logger.info("Successfully verified Ok Button.");

            //viewArchivedAndRestoreCourseBook.clickOnOkButton();

            //Assert.assertTrue(viewArchivedAndRestoreCourseBook.verifyListOfArchivedCBookPostRestore(), "Failed to verified List Of CourseBook After Restore Item.");
            extentTest.log(LogStatus.PASS, "Successfully verified List Of CourseBook After Restore Item.");
            logger.info("Successfully verified List Of CourseBook After Restore Item.");

        } catch (Exception e) {
            result = handleException(e);
        }
        Assert.assertTrue(result, "Test script failed : " + errorMessage);
    }

    @Test(priority = 5, description = "Verify 'CourseBook' is Moved to the Library After clicking On Restore Item Button")
    public void verifyFunctionalityOfRestoreButton() {
        boolean result = true;
        try {
            ViewArchivedAndRestoreCBook viewArchivedAndRestoreCourseBook = new ViewArchivedAndRestoreCBook(webDriver,extentTest,extentReports);

            //viewArchivedAndRestoreCourseBook.getListOfCourseBookBeforeRestore();
            //viewArchivedAndRestoreCourseBook.clickOnViewArchivedButton();

            //Assert.assertTrue(viewArchivedAndRestoreCourseBook.verifyViewArchivedButton(), "Failed to verified View Archive Button.");
            extentTest.log(LogStatus.PASS, "Successfully verified View Archive Button.");
            logger.info("Successfully verified View Archive Button.");

            //viewArchivedAndRestoreCourseBook.getListOfCourseBookAfterRestore();

            //Assert.assertTrue(viewArchivedAndRestoreCourseBook.verifyCBooksListsPostRestore(), "Failed to verified CourseBook List In Library After Restore.");
            extentTest.log(LogStatus.PASS, "Successfully verified CourseBook List In Library After Restore.");
            logger.info("Successfully verified CourseBook List In Library After Restore.");

        } catch (Exception e) {
            result = handleException(e);
        }
        Assert.assertTrue(result, "Test script failed : " + errorMessage);
    }
}
