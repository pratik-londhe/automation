/*
package testscripts.regression.studentlogin.GroupsFeature.JoinClassFeature;

import com.relevantcodes.extentreports.LogStatus;
import org.apache.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.Test;
import testscripts.BaseTestScript;
import uipages.flexbook2feature.*;

public class StudentJoinClassTest extends BaseTestScript {
    private static final Logger logger = Logger.getLogger(StudentJoinClassTest.class);
    private String testCaseFailureText = "Test failed for method: ";
    private String assertFailurePreText = "Failed to verify: ";
    public String assertSuccessPreText = "Successfully verified: ";

    private JoinClass joinClass;



    @Test(priority = 1, dataProvider = "CK12DataProvider", description = "Verify Teacher Successfully Remove Student From Class.")
    public void verifyTeacherRemoveStudentFromClass(String email, String password) {
        boolean result = true;
        try {
            TeacherDashboardPage teacherDashboardPage = new TeacherDashboardPage(webDriver,extentTest,extentReports);
            joinClass = new JoinClass(webDriver,extentTest,extentReports);

            String url = "https://qa-flash.ck12.org/group-members/215946";

            new LoginPage(webDriver,extentTest,extentReports).teacherLogin(email, password);

            Assert.assertTrue(teacherDashboardPage.verifyTeacherProfileOnGamma(), "Failed to verify.");
            extentTest.log(LogStatus.PASS, "User Successfully logged in and verified profile icon.");
            logger.info("User Successfully verify and Verify icon as well");

            webDriver.navigate().to(url);

            String assertTextVML = "Presence of More Option 'Icon'";
            Assert.assertTrue(joinClass.verifyMoreOptionIcon(), assertFailurePreText + assertTextVML);
            reportLog(assertTextVML);

            joinClass.clickOnMoreOptionIcon();

            String assertTextVODD = "Presence of 'Remove From Class' Link.";
            Assert.assertTrue(joinClass.verifyRemoveFromClassLink(), assertFailurePreText + assertTextVODD);
            reportLog(assertTextVODD);

            joinClass.clickOnRemoveFromClassLink();

            String assertTextVAFBA = "Presence of 'Remove' button.";
            Assert.assertTrue(joinClass.verifyRemoveButton(), assertFailurePreText + assertTextVAFBA);
            reportLog(assertTextVAFBA);

            joinClass.clickOnRemoveButton();

            String assertTextVSB = "Presence of 'Add Student' button.";
            Assert.assertTrue(joinClass.verifyAddStudentButton(), assertFailurePreText + assertTextVSB);
            reportLog(assertTextVSB);

        } catch (Exception e) {
            result = handleException(e);
        }
        Assert.assertTrue(result, testCaseFailureText + currentMethodName + errorMessage);
    }

    @Test(priority = 3, description = "Verify Successfully Login Through Student Account.")
    public void verifyStudentLoginSuccessfully() {
        boolean result = true;
        try {
            CBookLandingPage cBookLandingPage = new CBookLandingPage(webDriver,extentTest,extentReports);
            TurnInFeature  turnInFeature = new TurnInFeature(webDriver,extentTest,extentReports);

            String flexBookUrl = "https://qa-flash.ck12.org/teacher/";
            String email = "studentjoinclass+testuser@ck12.org";
            String pass = "Student123";

            webDriver.navigate().to(flexBookUrl);

            String assertTextVFO = "Presence of Try It Now Button.";
            Assert.assertTrue(cBookLandingPage.verifyFlexBookLink(), assertFailurePreText + assertTextVFO);
            reportLog(assertTextVFO);

            cBookLandingPage.clickOnFlexBookLink();

            String assertTextVCAC = "Presence of Profile Icon.";
            Assert.assertTrue(turnInFeature.verifyProfileIcon(), assertFailurePreText + assertTextVCAC);
            reportLog(assertTextVCAC);

            turnInFeature.clickOnProfileIcon();

            String assertTextVSO = "Presence of Sign Out Link.";
            Assert.assertTrue(turnInFeature.verifyLinkSignOut(), assertFailurePreText + assertTextVSO);
            reportLog(assertTextVSO);

            turnInFeature.clickOnLinkSignOut();

            cBookLandingPage.clickOnSignInIcon();
            new LoginPage(webDriver,extentTest,extentReports).login(email, pass);
            cBookLandingPage.clickOnSignInButton();

            String assertTextVSAI = "Presence of 'Student icon' after logging in.";
            Assert.assertTrue(turnInFeature.verifyStudentAccountIcon(), assertFailurePreText + assertTextVSAI);
            reportLog(assertTextVSAI);

        } catch (RuntimeException e) {
            result = handleException(e);
        }
        Assert.assertTrue(result, testCaseFailureText + currentMethodName + errorMessage);
    }

    @Test(priority = 5, description = "Verify UI Page Of Student Join Class")
    public void verifyUIPageOfStudentJoinClass() {
        boolean result = true;
        try {
            String joinClassUrl = "https://qa-flash.ck12.org/my/groups/#";

            webDriver.navigate().to(joinClassUrl);

            String assertTextVFO = "Presence of 'Join Class' Button.";
            Assert.assertTrue(joinClass.verifyJoinClassButton(), assertFailurePreText + assertTextVFO);
            reportLog(assertTextVFO);

            String assertTextVCAC = "Presence of 'Join A Class' Text";
            Assert.assertTrue(joinClass.verifyJoinAClassText(), assertFailurePreText + assertTextVCAC);
            reportLog(assertTextVCAC);

        } catch (RuntimeException e) {
            result = handleException(e);
        }
        Assert.assertTrue(result, testCaseFailureText + currentMethodName + errorMessage);
    }

    @Test(priority = 7, description = "Verify Functionality Of 'Join Class' button without Giving Class Code.")
    public void verifyFunctionalityOfJoinClassButtonWithoutCode() {
        boolean result = true;
        try {
            joinClass.clickOnJoinClassButton();

            String assertTextVSAI = "Presence of 'Empty Error' Text.";
            Assert.assertTrue(joinClass.verifyEmptyErrorText(), assertFailurePreText + assertTextVSAI);
            reportLog(assertTextVSAI);

            String assertTextVFO = "Presence of 'Join Class' Button.";
            Assert.assertTrue(joinClass.verifyJoinClassButton(), assertFailurePreText + assertTextVFO);
            reportLog(assertTextVFO);

        } catch (RuntimeException e) {
            result = handleException(e);
        }
        Assert.assertTrue(result, testCaseFailureText + currentMethodName + errorMessage);
    }

    @Test(priority = 9, description = "Verify Functionality Of 'Join Class' button with After Giving Wrong Class Code.")
    public void verifyFunctionalityOfJoinClassButtonWithWrongCode() {
        boolean result = true;
        try {
            String classCode = "6vix";

            joinClass.setValueInCassCodePlaceHolder(classCode);
            joinClass.clickOnJoinClassButton();

            String assertTextVSAI = "Presence of 'Wrong Error' Text.";
            Assert.assertTrue(joinClass.verifyWrongErrorText(), assertFailurePreText + assertTextVSAI);
            reportLog(assertTextVSAI);

            String assertTextVFO = "Presence of 'Join Class' Button.";
            Assert.assertTrue(joinClass.verifyJoinClassButton(), assertFailurePreText + assertTextVFO);
            reportLog(assertTextVFO);

        } catch (RuntimeException e) {
            result = handleException(e);
        }
        Assert.assertTrue(result, testCaseFailureText + currentMethodName + errorMessage);
    }

    @Test(priority = 13, description = "Verify Functionality Of 'Join Class' button with After Giving Valid Class Code.")
    public void verifyFunctionalityOfJoinClassButtonWithValidCode() {
        boolean result = true;
        try {
            String code = "r6vix";

            joinClass.setValueInCassCodePlaceHolder(code);
            joinClass.clickOnJoinClassButton();

            Assert.assertTrue(new TeacherGroupDiscussionInClass(webDriver,extentTest,extentReports).verifyButtonQAndA(), "Failed to verify Q And A Button");
            extentTest.log(LogStatus.PASS, "Successfully Verify Q And A Button");
            logger.info("successfully Verified Q And A Button");

        } catch (RuntimeException e) {
            result = handleException(e);
        }
        Assert.assertTrue(result, testCaseFailureText + currentMethodName + errorMessage);
    }
}
*/
