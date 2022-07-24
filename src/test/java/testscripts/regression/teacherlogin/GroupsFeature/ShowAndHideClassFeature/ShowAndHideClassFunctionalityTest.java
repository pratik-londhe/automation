package testscripts.regression.teacherlogin.GroupsFeature.ShowAndHideClassFeature;

import com.relevantcodes.extentreports.LogStatus;
import org.apache.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.Test;
import testscripts.BaseTestScript;
import uipages.flexbook2feature.*;

public class ShowAndHideClassFunctionalityTest extends BaseTestScript {
    private static final Logger logger = Logger.getLogger(ShowAndHideClassFunctionalityTest.class);

    @Test(priority = 1, dataProvider = "CK12DataProvider", description = "verify Functionality of 'Current Classes' Button After Clicking Show Classes DropDown")
    public void verifyFunctionalityOfCurrentClasses(String email, String Password) {
        boolean result = true;
        try {
            LoginPage loginPage = new LoginPage(webDriver, extentTest, extentReports);
            TeacherDashboardPage teacherDashboardPage = new TeacherDashboardPage(webDriver, extentTest, extentReports);
            PageMenuTab pageMenuTab = new PageMenuTab(webDriver, extentTest, extentReports);
            ShowAndHideClassFunctionality showAndHideClassFunctionality = new ShowAndHideClassFunctionality(webDriver, extentTest, extentReports);

            loginPage.clickOnSignInLink();
            loginPage.login(email, Password);
            loginPage.clickOnBtnSignIn();

            Assert.assertTrue(teacherDashboardPage.verifyTeacherProfileOnGamma(), "Failed to verify.");
            extentTest.log(LogStatus.PASS, "User Successfully logged in and verified profile icon.");
            logger.info("User Successfully verify and Verify icon as well");

            pageMenuTab.clickOnClassesTab();

            Assert.assertTrue(showAndHideClassFunctionality.verifyShowClassesDropDown(), "Failed to verified Show Classes DropDown");
            extentTest.log(LogStatus.PASS, "User Successfully logged in and verified Show Classes DropDown");
            logger.info("User Successfully verify and verified Show Classes DropDown");

            showAndHideClassFunctionality.clickOnMoreOptionsDropDown();

            Assert.assertTrue(showAndHideClassFunctionality.verifyHideFromDashBoardLink(), "Failed to verified Hide From DashBoard Link");
            extentTest.log(LogStatus.PASS, "User Successfully logged in and verified Hide From DashBoard Link");
            logger.info("User Successfully verify and verified Hide From DashBoard Link");

        } catch (Exception e) {
            result = handleException(e);
        }
        Assert.assertTrue(result, "Test script failed : " + errorMessage);
    }

    @Test(priority = 2, description = "verify Functionality of 'Cancel Hide' Button After Clicking Hide From DashBoard Link")
    public void verifyFunctionalityOfCancelHideButton() {
        boolean result = true;
        try {
            ShowAndHideClassFunctionality showAndHideClassFunctionality = new ShowAndHideClassFunctionality(webDriver, extentTest, extentReports);

            showAndHideClassFunctionality.getCountOfClassesBefore();
            showAndHideClassFunctionality.clickOnHideFromDashBoardLink();

            Assert.assertTrue(showAndHideClassFunctionality.verifyHideButton(), "Failed to verified Hide Button");
            extentTest.log(LogStatus.PASS, "User Successfully logged in and verified Hide Button");
            logger.info("User Successfully verify and verified Hide Button");

            Assert.assertTrue(showAndHideClassFunctionality.verifyHideCancelButton(), "Failed to verified Cancel Hide Button");
            extentTest.log(LogStatus.PASS, "User Successfully logged in and verified Cancel Hide Button");
            logger.info("User Successfully verify and verified Cancel Hide Button");

            showAndHideClassFunctionality.clickOnHideCancelButton();

            Assert.assertTrue(showAndHideClassFunctionality.verifyShowClassesDropDown(), "Failed to verified Show Classes DropDown");
            extentTest.log(LogStatus.PASS, "User Successfully logged in and verified Show Classes DropDown");
            logger.info("User Successfully verify and verified Show Classes DropDown");

            showAndHideClassFunctionality.getCountOfClassesAfter();

            Assert.assertTrue(showAndHideClassFunctionality.verifyCountOfClassesAfterCancelHide(), "Failed to verified Count Of Classes After Cancel Hide");
            extentTest.log(LogStatus.PASS, "User Successfully logged in and verified Count Of Classes After Cancel Hide");
            logger.info("User Successfully verify and verified Count Of Classes After Cancel Hide");

        } catch (Exception e) {
            result = handleException(e);
        }
        Assert.assertTrue(result, "Test script failed : " + errorMessage);
    }

    @Test(priority = 3, description = "verify Functionality of 'Hide' Button After Clicking Hide From DashBoard Link")
    public void verifyFunctionalityOfHideButton() {
        boolean result = true;
        try {
            ShowAndHideClassFunctionality showAndHideClassFunctionality = new ShowAndHideClassFunctionality(webDriver, extentTest, extentReports);

            showAndHideClassFunctionality.getCountOfClassesBefore();
            showAndHideClassFunctionality.clickOnMoreOptionsDropDown();

            Assert.assertTrue(showAndHideClassFunctionality.verifyHideFromDashBoardLink(), "Failed to verified Hide From DashBoard Link");
            extentTest.log(LogStatus.PASS, "User Successfully logged in and verified Hide From DashBoard Link");
            logger.info("User Successfully verify and verified Hide From DashBoard Link");

            showAndHideClassFunctionality.clickOnHideFromDashBoardLink();

            Assert.assertTrue(showAndHideClassFunctionality.verifyHideButton(), "Failed to verified Hide Button");
            extentTest.log(LogStatus.PASS, "User Successfully logged in and verified Hide Button");
            logger.info("User Successfully verify and verified Hide Button");

            showAndHideClassFunctionality.clickOnHideButton();

            Assert.assertTrue(showAndHideClassFunctionality.verifyShowClassesDropDown(), "Failed to verified Show Classes DropDown");
            extentTest.log(LogStatus.PASS, "User Successfully logged in and verified Show Classes DropDown");
            logger.info("User Successfully verify and verified Show Classes DropDown");

            // showAndHideClassFunctionality.getCountOfClassesAfter();

//            Assert.assertTrue(showAndHideClassFunctionality.verifyCountOfClassesAfterHide(), "Failed to verified Count Of Classes After Hide");
//            extentTest.log(LogStatus.PASS, "User Successfully logged in and verified Count Of Classes After Hide");
//            logger.info("User Successfully verify and verified Count Of Classes After Hide");

        } catch (Exception e) {
            result = handleException(e);
        }
        Assert.assertTrue(result, "Test script failed : " + errorMessage);
    }

    @Test(priority = 4, description = "verify Functionality of 'Hidden Classes' Button After Clicking Show Classes DropDown")
    public void verifyFunctionalityHiddenClassesButton() {
        boolean result = true;
        try {
            ShowAndHideClassFunctionality showAndHideClassFunctionality = new ShowAndHideClassFunctionality(webDriver, extentTest, extentReports);

            Assert.assertTrue(showAndHideClassFunctionality.verifyShowClassesDropDown(), "Failed to verified Show Classes DropDown");
            extentTest.log(LogStatus.PASS, "User Successfully logged in and verified Show Classes DropDown");
            logger.info("User Successfully verify and verified Show Classes DropDown");

            showAndHideClassFunctionality.clickOnHiddenClassesButton();

            Assert.assertTrue(showAndHideClassFunctionality.verifyShowClassesDropDown(), "Failed to verified Show Classes DropDown");
            extentTest.log(LogStatus.PASS, "User Successfully logged in and verified Show Classes DropDown");
            logger.info("User Successfully verify and verified Show Classes DropDown");

            showAndHideClassFunctionality.clickOnMoreOptionsDropDown();

            Assert.assertTrue(showAndHideClassFunctionality.verifyDisplayOnDashBoardLink(), "Failed to verified Display On DashBoard Link");
            extentTest.log(LogStatus.PASS, "User Successfully logged in and verified Display On DashBoard Link");
            logger.info("User Successfully verify and verified Display On DashBoard Link");

        } catch (Exception e) {
            result = handleException(e);
        }
        Assert.assertTrue(result, "Test script failed : " + errorMessage);
    }

    @Test(priority = 5, description = "verify Functionality of 'What Are Hidden Classes' link After Clicking Hidden Classes Button")
    public void verifyFunctionalityWhatAreHiddenClassesLink() {
        boolean result = true;
        try {
            ShowAndHideClassFunctionality showAndHideClassFunctionality = new ShowAndHideClassFunctionality(webDriver, extentTest, extentReports);

            showAndHideClassFunctionality.clickOnWhatAreHiddenClassesLink();

            Assert.assertTrue(showAndHideClassFunctionality.verifyHiddenClassInformationText(), "Failed to verified Hidden Classes Information Text");
            extentTest.log(LogStatus.PASS, "User Successfully logged in and verified Hidden Classes Information Text");
            logger.info("User Successfully verify and verified Hidden Classes Information Text");

            showAndHideClassFunctionality.clickOnWhatAreHiddenClassesLink();

            Assert.assertTrue(showAndHideClassFunctionality.verifyShowClassesDropDown(), "Failed to verified Show Classes DropDown");
            extentTest.log(LogStatus.PASS, "User Successfully logged in and verified Show Classes DropDown");
            logger.info("User Successfully verify and verified Show Classes DropDown");

        } catch (Exception e) {
            result = handleException(e);
        }
        Assert.assertTrue(result, "Test script failed : " + errorMessage);
    }

    @Test(priority = 6, description = "verify Functionality of 'More Option' DropDown")
    public void verifyFunctionalityMoreOptionsDropDown() {
        boolean result = true;
        try {
            ShowAndHideClassFunctionality showAndHideClassFunctionality = new ShowAndHideClassFunctionality(webDriver, extentTest, extentReports);

            Assert.assertTrue(showAndHideClassFunctionality.verifyShowClassesDropDown(), "Failed to verified Show Classes DropDown");
            extentTest.log(LogStatus.PASS, "User Successfully logged in and verified Show Classes DropDown");
            logger.info("User Successfully verify and verified Show Classes DropDown");

            Assert.assertTrue(showAndHideClassFunctionality.verifyDisplayOnDashBoardLink(), "Failed to verified Display On DashBoard Link");
            extentTest.log(LogStatus.PASS, "User Successfully logged in and verified Display On DashBoard Link");
            logger.info("User Successfully verify and verified Display On DashBoard Link");

            Assert.assertTrue(showAndHideClassFunctionality.verifyShowClassesDropDown(), "Failed to verified Show Classes DropDown");
            extentTest.log(LogStatus.PASS, "User Successfully logged in and verified Show Classes DropDown");
            logger.info("User Successfully verify and verified Show Classes DropDown");

        } catch (Exception e) {
            result = handleException(e);
        }
        Assert.assertTrue(result, "Test script failed : " + errorMessage);
    }

    @Test(priority = 7, description = "verify Functionality of 'Cancel Display' Button After Clicking Display On DashBoard Button")
    public void verifyFunctionalityOfCancelDisplayButton() {
        boolean result = true;
        try {
            ShowAndHideClassFunctionality showAndHideClassFunctionality = new ShowAndHideClassFunctionality(webDriver, extentTest, extentReports);

            showAndHideClassFunctionality.getCountOfClassesBefore();

            Assert.assertTrue(showAndHideClassFunctionality.verifyDisplayOnDashBoardLink(), "Failed to verified Display Button");
            extentTest.log(LogStatus.PASS, "User Successfully logged in and verified Display Button");
            logger.info("User Successfully verify and verified Display Button");

            showAndHideClassFunctionality.clickOnDisplayOnDashBoardLink();

            Assert.assertTrue(showAndHideClassFunctionality.verifyDisplayButton(), "Failed to verified Display Button");
            extentTest.log(LogStatus.PASS, "User Successfully logged in and verified Display Button");
            logger.info("User Successfully verify and verified Display Button");

            Assert.assertTrue(showAndHideClassFunctionality.verifyCancelDisplayButton(), "Failed to verified Cancel Display Button");
            extentTest.log(LogStatus.PASS, "User Successfully logged in and verified Cancel Display Button");
            logger.info("User Successfully verify and verified Cancel Display Button");

            showAndHideClassFunctionality.clickOnCancelDisplayButton();

            Assert.assertTrue(showAndHideClassFunctionality.verifyShowClassesDropDown(), "Failed to verified Show Classes DropDown");
            extentTest.log(LogStatus.PASS, "User Successfully logged in and verified Show Classes DropDown");
            logger.info("User Successfully verify and verified Show Classes DropDown");

            showAndHideClassFunctionality.getCountOfClassesAfter();

            Assert.assertTrue(showAndHideClassFunctionality.verifyCountOfClassesAfterCancelHide(), "Failed to verified Count Of Classes After Cancel Display");
            extentTest.log(LogStatus.PASS, "User Successfully logged in and verified Count Of Classes After Cancel Display");
            logger.info("User Successfully verify and verified Count Of Classes After Cancel Display");

        } catch (Exception e) {
            result = handleException(e);
        }
        Assert.assertTrue(result, "Test script failed : " + errorMessage);
    }

    @Test(priority = 8, description = "verify Functionality of 'Display' Button After Clicking Display On DashBoard Button")
    public void verifyFunctionalityOfDisplayButton() {
        boolean result = true;
        try {
            ShowAndHideClassFunctionality showAndHideClassFunctionality = new ShowAndHideClassFunctionality(webDriver, extentTest, extentReports);

            showAndHideClassFunctionality.clickOnMoreOptionsDropDown();
            new CourseBookCreateEditAssignDelete(webDriver, extentTest, extentReports).clickOnPoUP();

            Assert.assertTrue(showAndHideClassFunctionality.verifyDisplayOnDashBoardLink(), "Failed to verified Display Button");
            extentTest.log(LogStatus.PASS, "User Successfully logged in and verified Display Button");
            logger.info("User Successfully verify and verified Display Button");

            showAndHideClassFunctionality.clickOnDisplayOnDashBoardLink();

            Assert.assertTrue(showAndHideClassFunctionality.verifyDisplayButton(), "Failed to verified Display Button");
            extentTest.log(LogStatus.PASS, "User Successfully logged in and verified Display Button");
            logger.info("User Successfully verify and verified Display Button");

            showAndHideClassFunctionality.clickOnDisplayButton();

            Assert.assertTrue(showAndHideClassFunctionality.verifyShowClassesDropDown(), "Failed to verified Show Classes DropDown");
            extentTest.log(LogStatus.PASS, "User Successfully logged in and verified Show Classes DropDown");
            logger.info("User Successfully verify and verified Show Classes DropDown");

        } catch (Exception e) {
            result = handleException(e);
        }
        Assert.assertTrue(result, "Test script failed : " + errorMessage);
    }

    @Test(priority = 9, description = "verify Functionality of 'Current Classes' link After Clicking Display Button")
    public void verifyFunctionalityOfCurrentClassesLink() {
        boolean result = true;
        try {
            ShowAndHideClassFunctionality showAndHideClassFunctionality = new ShowAndHideClassFunctionality(webDriver, extentTest, extentReports);

            showAndHideClassFunctionality.clickOnCurrentClassesLink();

            Assert.assertTrue(showAndHideClassFunctionality.verifyShowClassesDropDown(), "Failed to verified Show Classes DropDown");
            extentTest.log(LogStatus.PASS, "User Successfully logged in and verified Show Classes DropDown");
            logger.info("User Successfully verify and verified Show Classes DropDown");

            showAndHideClassFunctionality.clickOnMoreOptionsDropDown();

            Assert.assertTrue(showAndHideClassFunctionality.verifyHideFromDashBoardLink(), "Failed to verified Hide From DashBoard Link");
            extentTest.log(LogStatus.PASS, "User Successfully logged in and verified Hide From DashBoard Link");
            logger.info("User Successfully verify and verified Hide From DashBoard Link");

        } catch (Exception e) {
            result = handleException(e);
        }
        Assert.assertTrue(result, "Test script failed : " + errorMessage);
    }

    @Test(priority = 10, description = "verify Functionality of 'Hide From DashBoard' Button After Clicking More Option DopDown")
    public void verifyFunctionalityOfHiddenClassesButton() {
        boolean result = true;
        try {
            ShowAndHideClassFunctionality showAndHideClassFunctionality = new ShowAndHideClassFunctionality(webDriver, extentTest, extentReports);

            showAndHideClassFunctionality.clickOnHideFromDashBoardLink();

            Assert.assertTrue(showAndHideClassFunctionality.verifyHideButton(), "Failed to verified Hide Button");
            extentTest.log(LogStatus.PASS, "User Successfully logged in and verified Hide Button");
            logger.info("User Successfully verify and verified Hide Button");

            Assert.assertTrue(showAndHideClassFunctionality.verifyHideCancelButton(), "Failed to verified Hide Cancel Button");
            extentTest.log(LogStatus.PASS, "User Successfully logged in and verified Hide Cancel Button");
            logger.info("User Successfully verify and verified Hide Cancel Button");

        } catch (Exception e) {
            result = handleException(e);
        }
        Assert.assertTrue(result, "Test script failed : " + errorMessage);
    }
}
