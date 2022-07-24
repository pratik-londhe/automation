package testscripts.regression.teacherlogin.GroupsFeature.CreateAndEditClassFeature;

import com.relevantcodes.extentreports.LogStatus;
import org.apache.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.Test;
import testscripts.BaseTestScript;
import uipages.*;
import uipages.flexbook2feature.*;

public class ChangingClassNameAndDescriptionTest extends BaseTestScript {
    private static final Logger logger = Logger.getLogger(ChangingClassNameAndDescriptionTest.class);
    private BasePage basePage = new BasePage(webDriver, extentTest, extentReports);

    private final long timeStamp = basePage.currentTimeStamp();

    @Test(priority = 1, dataProvider = "CK12DataProvider", description = "Verify Functionality of 'Add Description' Link After Clicking On ClassName")
    public void verifyFunctionalityAddDescriptionLink(String email, String password) {
        boolean result = true;
        try {
            TeacherDashboardPage teacherDashboardPage = new TeacherDashboardPage(webDriver, extentTest, extentReports);
            PageMenuTab pageMenuTab = new PageMenuTab(webDriver, extentTest, extentReports);
            TeacherGroupDiscussionInClass teacherGroupDiscussionInClass = new TeacherGroupDiscussionInClass(webDriver, extentTest, extentReports);
            TeacherAddStudentInClass teacherAddStudentInClass = new TeacherAddStudentInClass(webDriver, extentTest, extentReports);
            ChangingClassNameAndDescription changingClassNameAndDescription = new ChangingClassNameAndDescription(webDriver, extentTest, extentReports);

            new LoginPage(webDriver, extentTest, extentReports).teacherLogin(email, password);

            Assert.assertTrue(teacherDashboardPage.verifyTeacherProfileOnGamma(), "Failed to verify.");
            extentTest.log(LogStatus.PASS, "User Successfully logged in and verified profile icon.");
            logger.info("User Successfully verify and Verify icon as well");

            pageMenuTab.clickOnClassesTab();
            teacherAddStudentInClass.clickOnClassNameIcon();

            Assert.assertTrue(teacherGroupDiscussionInClass.verifyButtonQAndA(), "Failed to verify Q And A Button");
            extentTest.log(LogStatus.PASS, "Successfully Verify Q And A Button");
            logger.info("Teacher successfully Verified Q And A Button");

            Assert.assertTrue(changingClassNameAndDescription.verifyAddDescriptionLink(), "Failed to verify Add Description link");
            extentTest.log(LogStatus.PASS, "Successfully Verify Add Description link");
            logger.info("Teacher successfully Verified Add Description link");

            changingClassNameAndDescription.clickOnAddDescriptionLink();

        } catch (Exception e) {
            result = handleException(e);
        }
        Assert.assertTrue(result, "Test script failed : " + errorMessage);
    }

    @Test(priority = 3, description = "Verify Functionality of 'Cancel Description' Button  After Clicking On Add Description Button ")
    public void verifyFunctionalityCancelDescriptionButton() {
        boolean result = true;
        try {
            ChangingClassNameAndDescription changingClassNameAndDescription = new ChangingClassNameAndDescription(webDriver, extentTest, extentReports);

            Assert.assertTrue(changingClassNameAndDescription.verifySaveDescriptionButton(), "Failed to verify Save Description Button");
            extentTest.log(LogStatus.PASS, "Successfully Verify  Save Description Button");
            logger.info("Teacher successfully Verified  Save Description Button");

            Assert.assertTrue(changingClassNameAndDescription.verifyCancelDescriptionButton(), "Failed to verify Cancel Description Button");
            extentTest.log(LogStatus.PASS, "Successfully Verify  Cancel Description Button");
            logger.info("Teacher successfully Verified  Cancel Description Button");

            changingClassNameAndDescription.clickOnCancelDescriptionButton();

            Assert.assertTrue(changingClassNameAndDescription.verifyAddDescriptionLink(), "Failed to verify Add Description link");
            extentTest.log(LogStatus.PASS, "Successfully Verify Add Description link");
            logger.info("Teacher successfully Verified Add Description link");

            changingClassNameAndDescription.clickOnAddDescriptionLink();

        } catch (Exception e) {
            result = handleException(e);
        }
        Assert.assertTrue(result, "Test script failed : " + errorMessage);
    }

    @Test(priority = 5, description = "Verify Functionality of 'Save Description' Button Without Giving Description ")
    public void verifyFunctionalitySaveDescriptionButtonWithoutGivingDescription() {
        boolean result = true;
        try {
            ChangingClassNameAndDescription changingClassNameAndDescription = new ChangingClassNameAndDescription(webDriver, extentTest, extentReports);

            Assert.assertTrue(changingClassNameAndDescription.verifySaveDescriptionButton(), "Failed to verify Save Description Button");
            extentTest.log(LogStatus.PASS, "Successfully Verify  Save Description Button");
            logger.info("Teacher successfully Verified  Save Description Button");

            changingClassNameAndDescription.clickOnSaveDescriptionButton();

            Assert.assertTrue(changingClassNameAndDescription.verifyAddDescriptionLink(), "Failed to verify Add Description link");
            extentTest.log(LogStatus.PASS, "Successfully Verify Add Description link");
            logger.info("Teacher successfully Verified Add Description link");

            changingClassNameAndDescription.clickOnAddDescriptionLink();

        } catch (Exception e) {
            result = handleException(e);
        }
        Assert.assertTrue(result, "Test script failed : " + errorMessage);
    }

    @Test(priority = 7, description = "Verify Functionality of 'Save Description' Button After Giving Description ")
    public void verifyFunctionalitySaveDescriptionButtonWithDescription() {
        boolean result = true;
        try {
            ChangingClassNameAndDescription changingClassNameAndDescription = new ChangingClassNameAndDescription(webDriver, extentTest, extentReports);

            String text = "this Is Important";

            Assert.assertTrue(changingClassNameAndDescription.verifySaveDescriptionButton(), "Failed to verify Save Description Button");
            extentTest.log(LogStatus.PASS, "Successfully Verify  Save Description Button");
            logger.info("Teacher successfully Verified  Save Description Button");

            changingClassNameAndDescription.setValueInDescriptionPlaceHolder(text);
            changingClassNameAndDescription.clickOnSaveDescriptionButton();

            Assert.assertTrue(changingClassNameAndDescription.verifyDescriptionText(), "Failed to verify Description Text");
            extentTest.log(LogStatus.PASS, "Successfully Verify Description Text");
            logger.info("Teacher successfully Verified Description Text");

        } catch (Exception e) {
            result = handleException(e);
        }
        Assert.assertTrue(result, "Test script failed : " + errorMessage);
    }

    @Test(priority = 9, description = "Verify Functionality of 'Edit Description' Icon After Giving Description Text ")
    public void verifyFunctionalityEditDescriptionIcon() {
        boolean result = true;
        try {
            ChangingClassNameAndDescription changingClassNameAndDescription = new ChangingClassNameAndDescription(webDriver, extentTest, extentReports);

            String text = "";

            Assert.assertTrue(changingClassNameAndDescription.verifyEditDescriptionIcon(), "Failed to verify Edit Description Icon");
            extentTest.log(LogStatus.PASS, "Successfully Verify Edit Description Icon");
            logger.info("Teacher successfully Verified Edit Description Icon");

            changingClassNameAndDescription.clickOnEditDescriptionIcon();

            Assert.assertTrue(changingClassNameAndDescription.verifySaveDescriptionButton(), "Failed to verify Save Description Button");
            extentTest.log(LogStatus.PASS, "Successfully Verify  Save Description Button");
            logger.info("Teacher successfully Verified  Save Description Button");

            changingClassNameAndDescription.clearValueInDescriptionPlaceHolder(text);
            changingClassNameAndDescription.clickOnSaveDescriptionButton();

            Assert.assertTrue(changingClassNameAndDescription.verifyAddDescriptionLink(), "Failed to verify Add Description link");
            extentTest.log(LogStatus.PASS, "Successfully Verify Add Description link");
            logger.info("Teacher successfully Verified Add Description link");

        } catch (Exception e) {
            result = handleException(e);
        }
        Assert.assertTrue(result, "Test script failed : " + errorMessage);
    }

    @Test(priority = 11, description = "Verify Functionality of 'Edit ClassName' Icon ")
    public void verifyFunctionalityEditClassNameIcon() {
        boolean result = true;
        try {
            ChangingClassNameAndDescription changingClassNameAndDescription = new ChangingClassNameAndDescription(webDriver, extentTest, extentReports);

            Assert.assertTrue(changingClassNameAndDescription.verifyEditClassIcon(), "Failed to verify Edit ClassName Icon");
            extentTest.log(LogStatus.PASS, "Successfully Verify Edit ClassName Icon");
            logger.info("Teacher successfully Verified Edit ClassName Icon");

            changingClassNameAndDescription.clickOnEditClassIcon();

            Assert.assertTrue(changingClassNameAndDescription.verifySaveButton(), "Failed to verify Save Button");
            extentTest.log(LogStatus.PASS, "Successfully Verify  Save  Button");
            logger.info("Teacher successfully Verified  Save  Button");

            Assert.assertTrue(changingClassNameAndDescription.verifyCancelButton(), "Failed to verify Cancel Button");
            extentTest.log(LogStatus.PASS, "Successfully Verify  Cancel Button");
            logger.info("Teacher successfully Verified  Cancel Button");

        } catch (Exception e) {
            result = handleException(e);
        }
        Assert.assertTrue(result, "Test script failed : " + errorMessage);
    }

    @Test(priority = 13, description = "Verify Functionality of 'Save ' Button without Giving ClassName")
    public void verifyFunctionalitySaveButtonWithoutGivingName() {
        boolean result = true;
        try {
            ChangingClassNameAndDescription changingClassNameAndDescription = new ChangingClassNameAndDescription(webDriver, extentTest, extentReports);

            String text = "";

            changingClassNameAndDescription.clearValueInClassNamePlaceHolder(text);
            changingClassNameAndDescription.clickOnSaveButton();

            Assert.assertTrue(changingClassNameAndDescription.verifyErrorTextMessage(), "Failed to verify Error Text Message");
            extentTest.log(LogStatus.PASS, "Successfully Verify Error Text Message");
            logger.info("Teacher successfully Verified  Error Text Message");

        } catch (Exception e) {
            result = handleException(e);
        }
        Assert.assertTrue(result, "Test script failed : " + errorMessage);
    }

    @Test(priority = 15, description = "Verify Functionality of 'Save ' Button After Changing ClassName")
    public void verifyFunctionalitySaveButtonAfterChangingClassName() {
        boolean result = true;
        try {
            ChangingClassNameAndDescription changingClassNameAndDescription = new ChangingClassNameAndDescription(webDriver, extentTest, extentReports);

            String text = "NewClass" + timeStamp;

            changingClassNameAndDescription.setValueInClassNamePlaceHolder(text);

            Assert.assertTrue(changingClassNameAndDescription.verifySaveButton(), "Failed to verify Save Button");
            extentTest.log(LogStatus.PASS, "Successfully Verify  Save  Button");
            logger.info("Teacher successfully Verified  Save  Button");

            changingClassNameAndDescription.clickOnSaveButton();

            Assert.assertTrue(changingClassNameAndDescription.verifyClassNameText(), "Failed to verify Class Name Text");
            extentTest.log(LogStatus.PASS, "Successfully Verify Class Name Text");
            logger.info("Teacher successfully Verified Class Name Text");

        } catch (Exception e) {
            result = handleException(e);
        }
        Assert.assertTrue(result, "Test script failed : " + errorMessage);
    }

    @Test(priority = 17, description = "Verify Functionality of 'Cancel ' Button After Clicking On Edit ClassName Icon")
    public void verifyFunctionalityCancelButton() {
        boolean result = true;
        try {
            ChangingClassNameAndDescription changingClassNameAndDescription = new ChangingClassNameAndDescription(webDriver, extentTest, extentReports);

            String text = "Class1";

            Assert.assertTrue(changingClassNameAndDescription.verifyEditClassIcon(), "Failed to verify Edit ClassName Icon");
            extentTest.log(LogStatus.PASS, "Successfully Verify Edit ClassName Icon");
            logger.info("Teacher successfully Verified Edit ClassName Icon");

            changingClassNameAndDescription.clickOnEditClassIcon();

            Assert.assertTrue(changingClassNameAndDescription.verifySaveButton(), "Failed to verify Save Button");
            extentTest.log(LogStatus.PASS, "Successfully Verify  Save  Button");
            logger.info("Teacher successfully Verified  Save  Button");

            Assert.assertTrue(changingClassNameAndDescription.verifyCancelButton(), "Failed to verify Cancel Button");
            extentTest.log(LogStatus.PASS, "Successfully Verify  Cancel Button");
            logger.info("Teacher successfully Verified  Cancel Button");

            changingClassNameAndDescription.clickOnCancelButton();

            Assert.assertTrue(changingClassNameAndDescription.verifyEditClassIcon(), "Failed to verify Edit ClassName Icon");
            extentTest.log(LogStatus.PASS, "Successfully Verify Edit ClassName Icon");
            logger.info("Teacher successfully Verified Edit ClassName Icon");

            changingClassNameAndDescription.clickOnEditClassIcon();

            Assert.assertTrue(changingClassNameAndDescription.verifySaveButton(), "Failed to verify Save Button");
            extentTest.log(LogStatus.PASS, "Successfully Verify  Save  Button");
            logger.info("Teacher successfully Verified  Save  Button");

            changingClassNameAndDescription.setValueInClassNamePlaceHolder(text);
            changingClassNameAndDescription.clickOnSaveButton();

        } catch (Exception e) {
            result = handleException(e);
        }
        Assert.assertTrue(result, "Test script failed : " + errorMessage);
    }
}
