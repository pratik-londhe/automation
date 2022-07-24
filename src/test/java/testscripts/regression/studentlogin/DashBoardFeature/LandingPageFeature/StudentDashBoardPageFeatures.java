package testscripts.regression.studentlogin.DashBoardFeature.LandingPageFeature;

import com.relevantcodes.extentreports.LogStatus;
import org.apache.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.Test;
import testscripts.BaseTestScript;
import uipages.flexbook2feature.*;

public class StudentDashBoardPageFeatures extends BaseTestScript {
    private static final Logger logger = Logger.getLogger(StudentDashBoardPageFeatures.class);
    private String testCaseFailureText = "Test failed for method: ";
    private String assertFailurePreText = "Failed to verify: ";
    public String assertSuccessPreText = "Successfully verified: ";

    @Test(priority = 1, dataProvider = "CK12DataProvider", description = "Verify UI Page Of Student DashBoard Page")
    public void verifyStudentDashBoardUiPage(String email, String password) {
        boolean result = true;
        try {
            StudentDashBoardPage studentDashBoardPage = new StudentDashBoardPage(webDriver, extentTest, extentReports);

            new LoginPage(webDriver, extentTest, extentReports).teacherLogin(email, password);

            String assertTextVTPOG = "Student profile icon after login";
            Assert.assertTrue(studentDashBoardPage.verifyStudentProfileOnGamma(), assertFailurePreText + assertTextVTPOG);
            reportLog(assertTextVTPOG);

            webDriver.navigate().to("https://master.ck12.org/my/dashboard/#groupActivity");

            String assertTextVHI = "Presence Of 'Class Activity' Tab";
            Assert.assertTrue(studentDashBoardPage.verifyClassActivityTab(), assertFailurePreText + assertTextVHI);
            reportLog(assertTextVHI);

            String assertTextVSO = "Presence Of 'Self Study' Tab.";
            Assert.assertTrue(studentDashBoardPage.verifySelfStudyTab(), assertFailurePreText + assertTextVSO);
            reportLog(assertTextVSO);

        } catch (Exception e) {
            result = handleException(e);
        }
        Assert.assertTrue(result, testCaseFailureText + currentMethodName + errorMessage);
    }

    @Test(priority = 3, description = "Verify Class Activity is Display In Student DashBoard Page, If Student Already Joined Any Class.")
    public void verifyClassActivity() {
        boolean result = true;
        try {
            StudentDashBoardPage studentDashBoardPage = new StudentDashBoardPage(webDriver, extentTest, extentReports);

            studentDashBoardPage.clickOnClassActivityTab();

            String assertTextVHI = "Presence Of 'Class Activity' Tab";
            Assert.assertTrue(studentDashBoardPage.verifyClassActivityTab(), assertFailurePreText + assertTextVHI);
            reportLog(assertTextVHI);

            String assertTextVSO = "Presence Of 'Class Name' Title.";
            Assert.assertTrue(studentDashBoardPage.verifyClassNameTitle(), assertFailurePreText + assertTextVSO);
            reportLog(assertTextVSO);

            String assertTextVH = "Presence Of 'Latest Activity' Patch.";
            Assert.assertTrue(studentDashBoardPage.verifyLatestActivityPatch(), assertFailurePreText + assertTextVH);
            reportLog(assertTextVH);

            String assertTextVENT = "Presence Of 'Member Image' Icon.";
            Assert.assertTrue(studentDashBoardPage.verifyMemberImageIcon(), assertFailurePreText + assertTextVENT);
            reportLog(assertTextVENT);

        } catch (Exception e) {
            result = handleException(e);
        }
        Assert.assertTrue(result, testCaseFailureText + currentMethodName + errorMessage);
    }

    @Test(priority = 5, description = "Verify Name Of Class Creator And Total Number Of Class Member Are Display On DashBoard Widget.")
    public void verifyAuthorNameAndMemberCount() {
        boolean result = true;
        try {
            StudentDashBoardPage studentDashBoardPage = new StudentDashBoardPage(webDriver, extentTest, extentReports);

            String assertTextVHI = "Presence Of 'Group Owner Name' Text";
            Assert.assertTrue(studentDashBoardPage.verifyOwnerNameText(), assertFailurePreText + assertTextVHI);
            reportLog(assertTextVHI);

            String assertTextVSO = "Presence Of 'Member' Count.";
            Assert.assertTrue(studentDashBoardPage.verifyMemberCountLink(), assertFailurePreText + assertTextVSO);
            reportLog(assertTextVSO);

        } catch (Exception e) {
            result = handleException(e);
        }
        Assert.assertTrue(result, testCaseFailureText + currentMethodName + errorMessage);
    }

    @Test(priority = 7, description = "Verify Functionality Of 'Self Study' Tab of DashBoard Page.")
    public void verifyFunctionalityOfSelfStudyTab() {
        boolean result = true;
        try {
            StudentDashBoardPage studentDashBoardPage = new StudentDashBoardPage(webDriver, extentTest, extentReports);

            String assertTextVSO = "Presence Of 'Self Study' Tab.";
            Assert.assertTrue(studentDashBoardPage.verifySelfStudyTab(), assertFailurePreText + assertTextVSO);
            reportLog(assertTextVSO);

            studentDashBoardPage.clickOnSelfStudyTab();

            String assertTextVHI = "Presence Of 'Class Activity' Tab";
            Assert.assertTrue(studentDashBoardPage.verifyClassActivityTab(), assertFailurePreText + assertTextVHI);
            reportLog(assertTextVHI);

            //studentDashBoardPage.scrollScreen()

        } catch (Exception e) {
            result = handleException(e);
        }
        Assert.assertTrue(result, testCaseFailureText + currentMethodName + errorMessage);
    }

    //  @Test(priority = 9, description = "Verify Functionality Of 'All Subject Progress' Link Inside Self- Study Page.")
    public void verifyFunctionalityOfAllSubjectProgressLink() {
        boolean result = true;
        try {
            StudentDashBoardPage studentDashBoardPage = new StudentDashBoardPage(webDriver, extentTest, extentReports);

//            String assertTextVENT = "Presence Of 'All Subject' Link.";
//            Assert.assertTrue(studentDashBoardPage.verifyAllSubjectProgressLink(), assertFailurePreText + assertTextVENT);
//            reportLog(assertTextVENT);
//
//            studentDashBoardPage.clickOnAllSubjectProgressLink();

            String assertTextVHI = "Presence Of 'Class Activity' Tab";
            Assert.assertTrue(studentDashBoardPage.verifyClassActivityTab(), assertFailurePreText + assertTextVHI);
            reportLog(assertTextVHI);

            String assertTextVSO = "Presence Of 'Subject Selector' DropDown.";
            Assert.assertTrue(studentDashBoardPage.verifySubjectSelectorDropDown(), assertFailurePreText + assertTextVSO);
            reportLog(assertTextVSO);

            String assertTextVENT = "Presence Of 'Latest Self Study View' Icon.";
            Assert.assertTrue(studentDashBoardPage.verifyLatestSelfStudyViewIcon(), assertFailurePreText + assertTextVENT);
            reportLog(assertTextVENT);

        } catch (Exception e) {
            result = handleException(e);
        }
        Assert.assertTrue(result, testCaseFailureText + currentMethodName + errorMessage);
    }

    // @Test(priority = 11, description = "Verify Functionality Of 'Latest Self Study View' Icon Of Progress PAge.")
    public void verifyFunctionalityOfLatestSelfStudyViewIcon() {
        boolean result = true;
        try {
            StudentDashBoardPage studentDashBoardPage = new StudentDashBoardPage(webDriver, extentTest, extentReports);

            studentDashBoardPage.clickOnLatestSelfStudyViewIcon();

            String assertTextVHI = "Presence Of 'Class Activity' Tab";
            Assert.assertTrue(studentDashBoardPage.verifyClassActivityTab(), assertFailurePreText + assertTextVHI);
            reportLog(assertTextVHI);

            studentDashBoardPage.scrollScreen();

            String assertTextVENT = "Presence Of 'All Subject' Link.";
            Assert.assertTrue(studentDashBoardPage.verifyAllSubjectProgressLink(), assertFailurePreText + assertTextVENT);
            reportLog(assertTextVENT);

            studentDashBoardPage.clickOnAllSubjectProgressLink();

            String assertTextVSO = "Presence Of 'Class Activity' Tab";
            Assert.assertTrue(studentDashBoardPage.verifyClassActivityTab(), assertFailurePreText + assertTextVSO);
            reportLog(assertTextVSO);

        } catch (Exception e) {
            result = handleException(e);
        }
        Assert.assertTrue(result, testCaseFailureText + currentMethodName + errorMessage);
    }

    // @Test(priority = 13, description = "Verify Functionality Of 'Subject Selector'  DropDown Icon Of Progress Page.")
    public void verifyFunctionalityOfSubjectSelectorContainer() {
        boolean result = true;
        try {
            StudentDashBoardPage studentDashBoardPage = new StudentDashBoardPage(webDriver, extentTest, extentReports);

            String assertTextVSO = "Presence Of 'Subject Selector' DropDown.";
            Assert.assertTrue(studentDashBoardPage.verifySubjectSelectorDropDown(), assertFailurePreText + assertTextVSO);
            reportLog(assertTextVSO);

            studentDashBoardPage.clickOnSubjectSelectorDropDown();

            String assertTextVHI = "Presence Of 'Class Activity' Tab";
            Assert.assertTrue(studentDashBoardPage.verifyClassActivityTab(), assertFailurePreText + assertTextVHI);
            reportLog(assertTextVHI);

            String assertTextVENT = "Presence Of 'Subject List' Link.";
            Assert.assertTrue(studentDashBoardPage.verifySubjectListLink(), assertFailurePreText + assertTextVENT);
            reportLog(assertTextVENT);

            studentDashBoardPage.clickOnSubjectListLink();

            String assertTextVI = "Presence Of 'Class Activity' Tab";
            Assert.assertTrue(studentDashBoardPage.verifyClassActivityTab(), assertFailurePreText + assertTextVI);
            reportLog(assertTextVI);

        } catch (Exception e) {
            result = handleException(e);
        }
        Assert.assertTrue(result, testCaseFailureText + currentMethodName + errorMessage);
    }

    // @Test(priority = 15, description = "Verify Functionality Of 'Grid' View Icon and verify subject are display in grid view.")
    public void verifyFunctionalityOfGridViewIcon() {
        boolean result = true;
        try {
            StudentDashBoardPage studentDashBoardPage = new StudentDashBoardPage(webDriver, extentTest, extentReports);

            String assertTextVSO = "Presence Of 'Grid View' Icon.";
            Assert.assertTrue(studentDashBoardPage.verifyGridViewIcon(), assertFailurePreText + assertTextVSO);
            reportLog(assertTextVSO);

            studentDashBoardPage.clickOnGridViewIcon();

            String assertTextVHI = "Presence Of 'Class Activity' Tab";
            Assert.assertTrue(studentDashBoardPage.verifyClassActivityTab(), assertFailurePreText + assertTextVHI);
            reportLog(assertTextVHI);

            String assertTextVENT = "Presence Of 'Start' button.";
            Assert.assertTrue(studentDashBoardPage.verifyStartButton(), assertFailurePreText + assertTextVENT);
            reportLog(assertTextVENT);

        } catch (Exception e) {
            result = handleException(e);
        }
        Assert.assertTrue(result, testCaseFailureText + currentMethodName + errorMessage);
    }

    // @Test(priority = 17, description = "Verify Functionality Of 'List' View Icon and verify subject are display in List view.")
    public void verifyFunctionalityOfListViewIcon() {
        boolean result = true;
        try {
            StudentDashBoardPage studentDashBoardPage = new StudentDashBoardPage(webDriver, extentTest, extentReports);

            String assertTextVSO = "Presence Of 'List View' Icon.";
            Assert.assertTrue(studentDashBoardPage.verifyListViewIcon(), assertFailurePreText + assertTextVSO);
            reportLog(assertTextVSO);

            studentDashBoardPage.clickOnListViewIcon();

            String assertTextVHI = "Presence Of 'Class Activity' Tab";
            Assert.assertTrue(studentDashBoardPage.verifyClassActivityTab(), assertFailurePreText + assertTextVHI);
            reportLog(assertTextVHI);

            String assertTextVENT = "Presence Of 'Track' Text.";
            Assert.assertTrue(studentDashBoardPage.verifyTrackText(), assertFailurePreText + assertTextVENT);
            reportLog(assertTextVENT);

            String assertTextVET = "Presence Of 'Progress' Text.";
            Assert.assertTrue(studentDashBoardPage.verifyProgressText(), assertFailurePreText + assertTextVET);
            reportLog(assertTextVET);

        } catch (Exception e) {
            result = handleException(e);
        }
        Assert.assertTrue(result, testCaseFailureText + currentMethodName + errorMessage);
    }

    //@Test(priority = 19, description = "Verify Functionality Of 'Class Activity' Tab of DashBoard Page.")
    public void verifyFunctionalityOfClassActivityTab() {
        boolean result = true;
        try {
            StudentDashBoardPage studentDashBoardPage = new StudentDashBoardPage(webDriver, extentTest, extentReports);

            studentDashBoardPage.clickOnClassActivityTab();

            String assertTextVHI = "Presence Of 'Class Activity' Tab";
            Assert.assertTrue(studentDashBoardPage.verifyClassActivityTab(), assertFailurePreText + assertTextVHI);
            reportLog(assertTextVHI);

            String assertTextVSO = "Presence Of 'Class Name' Title.";
            Assert.assertTrue(studentDashBoardPage.verifyClassNameTitle(), assertFailurePreText + assertTextVSO);
            reportLog(assertTextVSO);

            String assertTextVI = "Presence Of 'Latest Activity' Patch.";
            Assert.assertTrue(studentDashBoardPage.verifyLatestActivityPatch(), assertFailurePreText + assertTextVI);
            reportLog(assertTextVI);

        } catch (Exception e) {
            result = handleException(e);
        }
        Assert.assertTrue(result, testCaseFailureText + currentMethodName + errorMessage);
    }

    // @Test(priority = 21, description = "Verify Functionality Of 'Join Class' Icon of DashBoard Page.")
    public void verifyFunctionalityOfJoinClassIcon() {
        boolean result = true;
        try {
            StudentDashBoardPage studentDashBoardPage = new StudentDashBoardPage(webDriver, extentTest, extentReports);

            String assertTextVHI = "Presence Of 'Join Class' Icon";
            Assert.assertTrue(studentDashBoardPage.verifyJoinClassIcon(), assertFailurePreText + assertTextVHI);
            reportLog(assertTextVHI);

            studentDashBoardPage.clickOnJoinClassIcon();

            String assertTextVSO = "Presence Of 'Join' Button.";
            Assert.assertTrue(studentDashBoardPage.verifyJoinButton(), assertFailurePreText + assertTextVSO);
            reportLog(assertTextVSO);

            String assertTextVI = "Presence Of 'Classes' Text.";
            Assert.assertTrue(studentDashBoardPage.verifyClassesText(), assertFailurePreText + assertTextVI);
            reportLog(assertTextVI);

        } catch (Exception e) {
            result = handleException(e);
        }
        Assert.assertTrue(result, testCaseFailureText + currentMethodName + errorMessage);
    }
}