package testscripts.regression.teacherlogin.LibraryFeature.TeacherLibraryFeature;

import com.relevantcodes.extentreports.LogStatus;
import org.apache.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.Test;
import testscripts.BaseTestScript;
import uipages.flexbook2feature.*;

public class TeacherLibraryPageTest extends BaseTestScript {
    private static final Logger logger = Logger.getLogger(TeacherLibraryPageTest.class);
    private String testCaseFailureText = "Test failed for method: ";
    private String assertFailurePreText = "Failed to verify: ";
    public String assertSuccessPreText = "Successfully verified: ";



    @Test(priority = 1, dataProvider = "CK12DataProvider", description = "Verify Library Page When User is Not Created Any FlexBook.")
    public void verifyUiOfLibraryPage(String email, String password) {
        boolean result = true;
        try {
            TeacherDashboardPage teacherDashboardPage = new TeacherDashboardPage(webDriver, extentTest, extentReports);
            CourseBookCreateEditAssignDelete courseBookCreateEditAssignDelete = new CourseBookCreateEditAssignDelete(webDriver, extentTest, extentReports);
            LibraryPage libraryPage = new LibraryPage(webDriver, extentTest, extentReports);

            new LoginPage(webDriver, extentTest, extentReports).teacherLogin(email, password);

            Assert.assertTrue(teacherDashboardPage.verifyTeacherProfileOnGamma(), "Failed to verified user profile for CreateCBookUsingModalityTest.");
            extentTest.log(LogStatus.PASS, "User Successfully logged in and verified profile icon.");
            logger.info("User Successfully logged in and verified profile icon.");

            new PageMenuTab(webDriver, extentTest, extentReports).clickOnLibraryTab();

            Assert.assertTrue(courseBookCreateEditAssignDelete.verifyCreateNewDropDown(), "Failed to verified Create New DropDown");
            extentTest.log(LogStatus.PASS, "Successfully verified Create New DropDown");
            logger.info("Successfully verified Create New DropDown");

            String assertTextVML = "Presence of 'No Items In Library' text";
            Assert.assertTrue(libraryPage.verifyNoItemsInLibraryText(), assertFailurePreText + assertTextVML);
            reportLog(assertTextVML);

        } catch (Exception e) {
            result = handleException(e);
        }
        Assert.assertTrue(result, testCaseFailureText + currentMethodName + errorMessage);
    }

    @Test(priority = 3, description = "Verify Functionality Of View Archiew Button When No Items Are Added In Library.")
    public void verifyFunctionalityOfViewArchiveButton() {
        boolean result = true;
        try {
            LibraryPage libraryPage = new LibraryPage(webDriver, extentTest, extentReports);

            String assertTextVML = "Presence of 'No Items In Library' text";
            Assert.assertTrue(libraryPage.verifyViewArchiveButton(), assertFailurePreText + assertTextVML);
            reportLog(assertTextVML);

            libraryPage.clickOnViewArchive();

            String assertTextVLB = "Presence of 'View Library' Button";
            Assert.assertTrue(libraryPage.verifyViewLibraryButton(), assertFailurePreText + assertTextVLB);
            reportLog(assertTextVLB);

            String assertTextVL = "Presence of 'No Items In Library' text";
            Assert.assertTrue(libraryPage.verifyNoItemsInLibraryText(), assertFailurePreText + assertTextVL);
            reportLog(assertTextVL);

        } catch (Exception e) {
            result = handleException(e);
        }
        Assert.assertTrue(result, testCaseFailureText + currentMethodName + errorMessage);
    }

    @Test(priority = 5, description = "Verify Functionality Of Restore Items Button When There Is No Items In Archive Library .")
    public void verifyFunctionalityOfRestoreItemsButton() {
        boolean result = true;
        try {
            LibraryPage libraryPage = new LibraryPage(webDriver, extentTest, extentReports);

            String assertTextVML = "Presence of 'Restore' Button";
            Assert.assertTrue(libraryPage.verifyRestoreButton(), assertFailurePreText + assertTextVML);
            reportLog(assertTextVML);

            libraryPage.clickOnRestoreButton();

            String assertTextVL = "Presence of 'Please Select Items' text";
            Assert.assertTrue(libraryPage.verifyPleaseSelectItemText(), assertFailurePreText + assertTextVL);
            reportLog(assertTextVL);

            String assertTextVOB = "Presence of 'Ok' Button";
            Assert.assertTrue(libraryPage.verifyOkButton(), assertFailurePreText + assertTextVOB);
            reportLog(assertTextVOB);

            libraryPage.clickOnOkButton();

            String assertTextVLB = "Presence of 'View Library' Button";
            Assert.assertTrue(libraryPage.verifyViewLibraryButton(), assertFailurePreText + assertTextVLB);
            reportLog(assertTextVLB);

        } catch (Exception e) {
            result = handleException(e);
        }
        Assert.assertTrue(result, testCaseFailureText + currentMethodName + errorMessage);
    }

    @Test(priority = 7, description = "Verify Functionality Of 'Add To Ck12' Button.")
    public void verifyFunctionalityOfAddToCk12Button() {
        boolean result = true;
        try {
            LibraryPage libraryPage = new LibraryPage(webDriver, extentTest, extentReports);

            String assertTextVML = "Presence of 'Restore' Button";
            Assert.assertTrue(libraryPage.verifyAddToCk12Button(), assertFailurePreText + assertTextVML);
            reportLog(assertTextVML);

            libraryPage.clickOnAddToCk12Button();

            String assertTextVL = "Presence of 'Please Select Items' text";
            Assert.assertTrue(libraryPage.verifyDragThisLinkText(), assertFailurePreText + assertTextVL);
            reportLog(assertTextVL);

        } catch (Exception e) {
            result = handleException(e);
        }
        Assert.assertTrue(result, testCaseFailureText + currentMethodName + errorMessage);
    }

    @Test(priority = 9, description = "Verify Functionality Of 'Ok' button of Drag this Item Pop Up.")
    public void verifyFunctionalityOfOkButton() {
        boolean result = true;
        try {
            LibraryPage libraryPage = new LibraryPage(webDriver, extentTest, extentReports);

            String assertTextVOB = "Presence of 'Ok' Button";
            Assert.assertTrue(libraryPage.verifyOkButton(), assertFailurePreText + assertTextVOB);
            reportLog(assertTextVOB);

            libraryPage.clickOnOkButton();

            String assertTextVLB = "Presence of 'View Library' Button";
            Assert.assertTrue(libraryPage.verifyViewLibraryButton(), assertFailurePreText + assertTextVLB);
            reportLog(assertTextVLB);

            String assertTextVL = "Presence of 'No Items In Library' text";
            Assert.assertTrue(libraryPage.verifyNoItemsInLibraryText(), assertFailurePreText + assertTextVL);
            reportLog(assertTextVL);

        } catch (Exception e) {
            result = handleException(e);
        }
        Assert.assertTrue(result, testCaseFailureText + currentMethodName + errorMessage);
    }

    @Test(priority = 11, description = "Verify Functionality Of 'Close Book-Market' Icon of Library Page.")
    public void verifyFunctionalityOfCloseIcon() {
        boolean result = true;
        try {
            LibraryPage libraryPage = new LibraryPage(webDriver, extentTest, extentReports);

            String assertTextVOB = "Presence of 'Close Book-Marklet' Button";
            Assert.assertTrue(libraryPage.verifyCloseBookMarketIcon(), assertFailurePreText + assertTextVOB);
            reportLog(assertTextVOB);

            libraryPage.clickOnCloseBookMarketIcon();

            String assertTextVLB = "Presence of 'View Library' Button";
            Assert.assertTrue(libraryPage.verifyViewLibraryButton(), assertFailurePreText + assertTextVLB);
            reportLog(assertTextVLB);

        } catch (Exception e) {
            result = handleException(e);
        }
        Assert.assertTrue(result, testCaseFailureText + currentMethodName + errorMessage);
    }
}