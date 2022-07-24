package testscripts.regression.studentlogin.GroupsFeature.QAFeature;

import com.relevantcodes.extentreports.LogStatus;
import org.apache.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.Test;
import testscripts.BaseTestScript;
import uipages.flexbook2feature.*;

public class StudentGroupDiscussionPageTest extends BaseTestScript {
    private static final Logger logger = Logger.getLogger(StudentGroupDiscussionPageTest.class);

    @Test(priority = 1, dataProvider = "CK12DataProvider", description = "Verify the Functionality of 'Q And A' Button On Student Class Page")
    public void verifyFunctionalityOfQAndAButton(String email, String password) {
        boolean result = true;
        try {
            LoginPage loginPage = new LoginPage(webDriver,extentTest, extentReports);
            StudentMemberPage studentMemberPage = new StudentMemberPage(webDriver,extentTest,extentReports);
            TeacherGroupDiscussionInClass teacherGroupDiscussionInClass = new TeacherGroupDiscussionInClass(webDriver,extentTest,extentReports);

            loginPage.clickOnSignInLink();
            loginPage.login(email, password);
            loginPage.clickOnBtnSignIn();

            Assert.assertTrue(new StudentDashBoardPage(webDriver,extentTest,extentReports).verifyStudentProfileOnGamma(), "Failed to verify user profile for StudentLoginTest.");
            reportLog("User Successfully logged in and verified profile icon.");

            new PageMenuTab(webDriver,extentTest,extentReports).clickOnClassesTab();
            studentMemberPage.clickOnClassName();

            Assert.assertTrue(teacherGroupDiscussionInClass.verifyButtonQAndA(), "Failed to verify Q And A Button");
            reportLog("Successfully Verify Q And A Button");

            teacherGroupDiscussionInClass.clickOnQAndAButton();

            Assert.assertTrue(teacherGroupDiscussionInClass.verifyHowDoesThisWorkLink(), "Failed to verify How Does this Work Link");
            reportLog("Successfully Verify How Does this Work Link");

        } catch (Exception e) {
            result = handleException(e);
        }
        Assert.assertTrue(result, "Test script failed : " + errorMessage);
    }

    @Test(priority = 2, description = "Verify the Functionality of 'How Does This Work' Link On Student Group Discussion Page")
    public void verifyFunctionalityHowDoesThisWorkTab() {
        boolean result = true;
        try {
            TeacherGroupDiscussionInClass teacherGroupDiscussionInClass = new TeacherGroupDiscussionInClass(webDriver,extentTest,extentReports);

            teacherGroupDiscussionInClass.clickOnHowDoesThisWorkLink();

            Assert.assertTrue(teacherGroupDiscussionInClass.verifyOkShowMeButton(), "Failed to verify Show Me Noe Button");
            reportLog("Successfully verify Show Me Noe Button");

            Assert.assertTrue(teacherGroupDiscussionInClass.verifyNoThanksButton(), "Failed to verify No Thanks Button");
            reportLog("Successfully Verify No Thanks Button");

            teacherGroupDiscussionInClass.clickOnNoThanksButton();
            teacherGroupDiscussionInClass.clickOnHowDoesThisWorkLink();

            Assert.assertTrue(teacherGroupDiscussionInClass.verifyOkShowMeButton(), "Failed to verify Show Me Noe Button");
            reportLog("Successfully verify Show Me Now Button");

        } catch (Exception e) {
            result = handleException(e);
        }
        Assert.assertTrue(result, "Test script failed : " + errorMessage);
    }

    @Test(priority = 3, description = "Verify the Functionality of 'Ok Show Me' Button After clicking How Does This Work Link")
    public void verifyFunctionalityOfShowMeNowButton() {
        boolean result = true;
        try {
            TeacherGroupDiscussionInClass teacherGroupDiscussionInClass = new TeacherGroupDiscussionInClass(webDriver,extentTest,extentReports);

            teacherGroupDiscussionInClass.clickOnShowMeButton();

            Assert.assertTrue(teacherGroupDiscussionInClass.verifyNowWhatHappenButton(), "Failed to verify Now What Happen Button");
            reportLog("Successfully Verify Now What Happen Button");

            teacherGroupDiscussionInClass.clickOnNowWhatHappenButton();

            Assert.assertTrue(teacherGroupDiscussionInClass.verifyCommentButton(), "Failed to verify Comment Button");
            reportLog("Successfully verify Comment Button");

            teacherGroupDiscussionInClass.clickOnExitCloseIcon();

            Assert.assertTrue(teacherGroupDiscussionInClass.verifyAskQuestionPlaceHolder(), "Failed to verify Ask Question Place Holder");
            reportLog("Successfully Verify Ask Question Place Holder");

        } catch (Exception e) {
            result = handleException(e);
        }
        Assert.assertTrue(result, "Test script failed : " + errorMessage);
    }

    @Test(priority = 4, description = "Verify the Functionality of 'Ask Question' Place Holder of student Group discussion page")
    public void verifyFunctionalityOfAskQuestionButton() {
        boolean result = true;
        try {
            TeacherGroupDiscussionInClass teacherGroupDiscussionInClass = new TeacherGroupDiscussionInClass(webDriver,extentTest,extentReports);

            teacherGroupDiscussionInClass.getCountOfQuestionBefore();
            teacherGroupDiscussionInClass.clickOnAskQuestionPlaceHolder();

            Assert.assertTrue(teacherGroupDiscussionInClass.verifyEditTextContainerLayout(), "Failed to verify Container layout");
            reportLog("Successfully Verify Container layout");

        } catch (Exception e) {
            result = handleException(e);
        }
        Assert.assertTrue(result, "Test script failed : " + errorMessage);
    }

    @Test(priority = 5, description = "Verify the Functionality of 'Post'Button Without Question")
    public void verifyFunctionalityOfPostButtonWithoutQuestion() {
        boolean result = true;
        try {
            TeacherGroupDiscussionInClass teacherGroupDiscussionInClass = new TeacherGroupDiscussionInClass(webDriver,extentTest,extentReports);

            teacherGroupDiscussionInClass.clickOnPostButton();

            Assert.assertTrue(teacherGroupDiscussionInClass.verifyPleaseWriteQuestionText(), "Failed to verify Please Write Question Text");
            reportLog("Successfully Verify Please Write Question Text");

        } catch (Exception e) {
            result = handleException(e);
        }
        Assert.assertTrue(result, "Test script failed : " + errorMessage);
    }

    @Test(priority = 6, description = "Verify the Functionality of 'Post' Button With Question ")
    public void verifyFunctionalityOfPostButtonWithQuestion() {
        boolean result = true;
        try {
            TeacherGroupDiscussionInClass teacherGroupDiscussionInClass = new TeacherGroupDiscussionInClass(webDriver,extentTest,extentReports);

            String text1 = "Message_";

            teacherGroupDiscussionInClass.setTextInAskQuestionPlaceHolder(text1);
            teacherGroupDiscussionInClass.getPlaceHolderTextBeforePost();
            teacherGroupDiscussionInClass.clickOnPostButton();
            teacherGroupDiscussionInClass.getCountOfQuestionAfter();

            Assert.assertTrue(teacherGroupDiscussionInClass.verifyQuestionAddedAfterPost(), "Failed to verify Commented Text After Post");
            reportLog("Successfully Verify Commented Text After Post");

        } catch (Exception e) {
            result = handleException(e);
        }
        Assert.assertTrue(result, "Test script failed : " + errorMessage);
    }

    @Test(priority = 7, description = "Verify the Functionality of 'Edit' Button On Student Group Discussion Page")
    public void verifyFunctionalityOfEditButton() {
        boolean result = true;
        try {
            TeacherGroupDiscussionInClass teacherGroupDiscussionInClass = new TeacherGroupDiscussionInClass(webDriver,extentTest,extentReports);

            Assert.assertTrue(teacherGroupDiscussionInClass.verifyHowDoesThisWorkLink(), "Failed to verify How Does this Work Link");
            reportLog("Successfully Verify How Does this Work Link");

            teacherGroupDiscussionInClass.clickOnEditButton();

            Assert.assertTrue(teacherGroupDiscussionInClass.verifyCancelButton(), "Failed to verify Cancel Button");
            reportLog("Successfully Verify Cancel Button");

        } catch (Exception e) {
            result = handleException(e);
        }
        Assert.assertTrue(result, "Test script failed : " + errorMessage);
    }

    @Test(priority = 8, description = "Verify the Functionality of 'Cancel' Button After Clicking Edit Button")
    public void verifyFunctionalityOfCancelButton() {
        boolean result = true;
        try {
            TeacherGroupDiscussionInClass teacherGroupDiscussionInClass = new TeacherGroupDiscussionInClass(webDriver,extentTest,extentReports);

            teacherGroupDiscussionInClass.clickOnCancelEditButton();
            teacherGroupDiscussionInClass.getListOfQuestionBefore();
            teacherGroupDiscussionInClass.clickOnEditButton();

            Assert.assertTrue(teacherGroupDiscussionInClass.verifyCancelButton(), "Failed to verify Cancel Button");
            reportLog("Successfully Verify Cancel Button");

            teacherGroupDiscussionInClass.clickOnCancelEditButton();
            teacherGroupDiscussionInClass.getListOfQuestionAfter();

            Assert.assertTrue(teacherGroupDiscussionInClass.verifyQuestionsAfterCancel(), "Failed To Verify that before-cancel and after-cancel questions lists are the same");
            reportLog("Successfully Verified that before-cancel and after-cancel questions lists are the same");

        } catch (Exception e) {
            result = handleException(e);
        }
        Assert.assertTrue(result, "Test script failed : " + errorMessage);
    }

    @Test(priority = 9, description = "Verify the Functionality of 'Save' Button Without Making change")
    public void verifyFunctionalitySaveButtonWithoutMakingChange() {
        boolean result = true;
        try {
            TeacherGroupDiscussionInClass teacherGroupDiscussionInClass = new TeacherGroupDiscussionInClass(webDriver,extentTest,extentReports);

            teacherGroupDiscussionInClass.getListOfQuestionBefore();
            teacherGroupDiscussionInClass.clickOnEditButton();

            Assert.assertTrue(teacherGroupDiscussionInClass.verifyCancelButton(), "Failed to verify Cancel Button");
            reportLog("Successfully Verify Cancel Button");

            Assert.assertTrue(teacherGroupDiscussionInClass.verifySaveButton(), "Failed to verify Save Button");
            reportLog("Successfully Verify Save Button");

            teacherGroupDiscussionInClass.clickOnSaveButton();
            teacherGroupDiscussionInClass.getListOfQuestionAfter();

            Assert.assertTrue(teacherGroupDiscussionInClass.verifyQuestionsAfterCancel(), "Failed To Verify that before-cancel and after-cancel questions lists are the same");
            reportLog("Successfully Verified that before-cancel and after-cancel questions lists are the same");

        } catch (Exception e) {
            result = handleException(e);
        }
        Assert.assertTrue(result, "Test script failed : " + errorMessage);
    }

    @Test(priority = 10, description = "Verify the Functionality of 'Save' Button After Making change And Verify Questions Are Visible to other Members")
    public void verifyFunctionalitySaveButtonAfterMakingChange() {
        boolean result = true;
        try {
            TeacherGroupDiscussionInClass teacherGroupDiscussionInClass = new TeacherGroupDiscussionInClass(webDriver,extentTest,extentReports);
            TeacherAddStudentInClass teacherAddStudentInClass = new TeacherAddStudentInClass(webDriver,extentTest,extentReports);

            String text1 = "Message_";

            Assert.assertTrue(teacherAddStudentInClass.verifyHomeIcon(), "Failed to verify Home icon.");
            reportLog("Successfully Verified Home Icon");

            teacherGroupDiscussionInClass.getListOfQuestionBefore();

            teacherGroupDiscussionInClass.clickOnEditButton();

            Assert.assertTrue(teacherGroupDiscussionInClass.verifyCancelButton(), "Failed to verify Cancel Button");
            reportLog("Successfully Verify Cancel Button");

            Assert.assertTrue(teacherGroupDiscussionInClass.verifySaveButton(), "Failed to verify Save Button");
            reportLog("Successfully Verify Save Button");

            teacherGroupDiscussionInClass.clickOnEditPlaceHolder();
            teacherGroupDiscussionInClass.setTextInEditPlaceHolder(text1);
            teacherGroupDiscussionInClass.getPlaceHolderTextBeforeSave();
            teacherGroupDiscussionInClass.clickOnSaveButton();

            Assert.assertTrue(teacherGroupDiscussionInClass.verifyHowDoesThisWorkLink(), "Failed to verify How Does this Work Link");
            reportLog("Successfully Verify How Does this Work Link");

        } catch (Exception e) {
            result = handleException(e);
        }
        Assert.assertTrue(result, "Test script failed : " + errorMessage);
    }

    @Test(priority = 11, description = "Verify the Functionality of 'Delete' Icon Of Student Group Discussion page")
    public void verifyFunctionalityDeleteIcon() {
        boolean result = true;
        try {
            TeacherGroupDiscussionInClass teacherGroupDiscussionInClass = new TeacherGroupDiscussionInClass(webDriver,extentTest,extentReports);

            Assert.assertTrue(teacherGroupDiscussionInClass.verifyDeleteIcon(), "Failed to verify Delete Icon");
            reportLog("Successfully Verified the Delete Icon");

            teacherGroupDiscussionInClass.clickOnDeleteIcon();

            Assert.assertTrue(teacherGroupDiscussionInClass.verifyDeleteButton(), "Failed to verify Delete Button.");
            reportLog("Successfully Verify Delete Button");

            Assert.assertTrue(teacherGroupDiscussionInClass.verifyCloseIcon(), "Failed to verify Close Button.");
            reportLog("Successfully Verify Close Button");

            teacherGroupDiscussionInClass.clickOnCloseIcon();

        } catch (Exception e) {
            result = handleException(e);
        }
        Assert.assertTrue(result, "Test script failed : " + errorMessage);
    }

    @Test(priority = 12, description = "Verify the Functionality of 'Cancel' Button After Clicking Delete Icon")
    public void verifyFunctionalityCancelDeleteButton() {
        boolean result = true;
        try {
            TeacherGroupDiscussionInClass teacherGroupDiscussionInClass = new TeacherGroupDiscussionInClass(webDriver,extentTest,extentReports);

            Assert.assertTrue(teacherGroupDiscussionInClass.verifyDeleteIcon(), "Failed to verify Delete Icon");
            reportLog("Successfully Verify Delete Icon");

            teacherGroupDiscussionInClass.getCountOfQuestionBefore();
            teacherGroupDiscussionInClass.clickOnDeleteIcon();

            Assert.assertTrue(teacherGroupDiscussionInClass.verifyCancelDeleteButton(), "Failed to verify Cancel Delete Button.");
            reportLog("Successfully Verify Cancel Delete Button");

            teacherGroupDiscussionInClass.clickOnCancelDeleteButton();

            Assert.assertTrue(teacherGroupDiscussionInClass.verifyDeleteIcon(), "Failed to verify Delete Icon");
            reportLog("Successfully Verify Delete Icon");

            teacherGroupDiscussionInClass.getCountOfQuestionAfter();

            Assert.assertTrue(teacherGroupDiscussionInClass.verifyCountOfQuestionAfterCancelButton(), "Failed to verify Question count After Cancel Button");
            reportLog("Successfully Verify Question count After Cancel Button");

        } catch (Exception e) {
            result = handleException(e);
        }
        Assert.assertTrue(result, "Test script failed : " + errorMessage);
    }

    @Test(priority = 13, description = "Verify the Functionality of 'Delete' Button After Clicking Delete Icon")
    public void verifyFunctionalityDeleteButton() {
        boolean result = true;
        try {
            TeacherGroupDiscussionInClass teacherGroupDiscussionInClass = new TeacherGroupDiscussionInClass(webDriver,extentTest,extentReports);

            teacherGroupDiscussionInClass.getCountOfQuestionBefore();
            teacherGroupDiscussionInClass.clickOnDeleteIcon();

            Assert.assertTrue(teacherGroupDiscussionInClass.verifyDeleteButton(), "Failed to verify Delete Button.");
            reportLog("Successfully Verify Delete Button");

            teacherGroupDiscussionInClass.clickOnDeleteButton();

            /*Assert.assertTrue(teacherGroupDiscussionInClass.verifyDeleteIcon(), "Failed to verify Delete Icon");
            reportLog("Successfully Verify Delete Icon");

            teacherGroupDiscussionInClass.getCountOfQuestionAfter();

            Assert.assertTrue(teacherGroupDiscussionInClass.verifyCountOfQuestionAfterDeleteButton(), "Failed to verify Question count After Delete Button");
            reportLog("Successfully Verify Question count After Delete Button");*/

        } catch (Exception e) {
            result = handleException(e);
        }
        Assert.assertTrue(result, "Test script failed : " + errorMessage);
    }
}
