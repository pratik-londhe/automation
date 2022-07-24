package testscripts.regression.teacherlogin.ExploreFeature.CafeFeature;

import com.relevantcodes.extentreports.LogStatus;
import org.apache.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.Test;
import testscripts.BaseTestScript;
import uipages.flexbook2feature.*;

public class CafeSortedByFeatureTest extends BaseTestScript {
    private static final Logger logger = Logger.getLogger(CafeSortedByFeatureTest.class);
    private String testCaseFailureText = "Test failed for method: ";
    private String assertFailurePreText = "Failed to verify: ";
    public String assertSuccessPreText = "Successfully verified: ";

    @Test(priority = 1, dataProvider = "CK12DataProvider", description = "Verify 'Sorted By' DropDown. is present On the Forum UI Page.")
    public void verifyCafeFilter(String email, String password) {
        boolean result = true;
        try {
            SchoolFeature schoolFeature = new SchoolFeature(webDriver,extentTest,extentReports);
            CafeFeature cafeFeature= new CafeFeature(webDriver,extentTest,extentReports);
            CafeForumUIFeature cafeForumUIFeature= new CafeForumUIFeature(webDriver,extentTest,extentReports);

            new LoginPage(webDriver,extentTest, extentReports).teacherLogin(email, password);

            String assertTextVSPOG = "Teacher profile icon after logging in.";
            Assert.assertTrue(new TeacherDashboardPage(webDriver,extentTest,extentReports).verifyTeacherProfileOnGamma(), assertFailurePreText + assertTextVSPOG);
            reportLog(assertTextVSPOG);

            String assertTextVCNDD = "Presence of 'Header' Container.";
            Assert.assertTrue(schoolFeature.verifyHeaderContainer(), assertFailurePreText + assertTextVCNDD);
            reportLog(assertTextVCNDD);

            schoolFeature.clickOnHeaderContainer();

            String assertTextVEB = "Presence of 'Cafe' Container.";
            Assert.assertTrue(cafeFeature.verifyCafeLink(), assertFailurePreText + assertTextVEB);
            reportLog(assertTextVEB);

            cafeFeature.clickOnCafeLink();

            String assertTextVPOG = "Presence of 'Take The Tour ' Tab.";
            Assert.assertTrue(cafeFeature.verifyTakeTheTourTab(), assertFailurePreText + assertTextVPOG);
            reportLog(assertTextVPOG);

            String assertTextVSOG = "Presence of 'Continue' button.";
            Assert.assertTrue(cafeFeature.verifyForumContainerLink(), assertFailurePreText + assertTextVSOG);
            reportLog(assertTextVSOG);

            cafeFeature.clickOnForumContainerLink();

            String assertTextVSPG = "Presence of 'Forum ' Name.";
            Assert.assertTrue(cafeFeature.verifyForumName(), assertFailurePreText + assertTextVSPG);
            reportLog(assertTextVSPG);

            String assertTextVPG = "Presence of 'Sorted By' Text.";
            Assert.assertTrue(cafeForumUIFeature.verifySortedByText(), assertFailurePreText + assertTextVPG);
            reportLog(assertTextVPG);

        } catch (Exception e) {
            result = handleException(e);
        }
        Assert.assertTrue(result, testCaseFailureText + currentMethodName + errorMessage);
    }

    @Test(priority = 3, description = "Verify Functionality Of 'Sorted By' DropDown.")
    public void verifyFunctionalityOfStudentFilter() {
        boolean result = true;
        try {
            CafeForumUIFeature cafeForumUIFeature= new CafeForumUIFeature(webDriver,extentTest,extentReports);

            String assertTextVSPOG = "Presence of 'Sorted By' DropDown.";
            Assert.assertTrue(cafeForumUIFeature.verifySortedByDropDown(), assertFailurePreText + assertTextVSPOG);
            reportLog(assertTextVSPOG);

            cafeForumUIFeature.clickOnSortedByDropDown();

            String assertTextVEB = "Presence of 'Newest' Link.";
            Assert.assertTrue(cafeForumUIFeature.verifyNewestLink(), assertFailurePreText + assertTextVEB);
            reportLog(assertTextVEB);

        } catch (Exception e) {
            result = handleException(e);
        }
        Assert.assertTrue(result, testCaseFailureText + currentMethodName + errorMessage);
    }

    @Test(priority = 5, description = "Verify Functionality Of 'Popular' link.")
    public void verifyFunctionalityOfPopularLink() {
        boolean result = true;
        try {
            CafeForumUIFeature cafeForumUIFeature= new CafeForumUIFeature(webDriver,extentTest,extentReports);

            String assertTextVCNDD = "Presence of 'Header' Container.";
            Assert.assertTrue(cafeForumUIFeature.verifyPopularLink(), assertFailurePreText + assertTextVCNDD);
            reportLog(assertTextVCNDD);

            cafeForumUIFeature.clickOnUnPopularLink();

            String assertTextVSPOG = "Presence of 'Sorted By' DropDown.";
            Assert.assertTrue(cafeForumUIFeature.verifySortedByDropDown(), assertFailurePreText + assertTextVSPOG);
            reportLog(assertTextVSPOG);

            String assertTextVPOG = "Presence of 'Popular Link Filter ' Tab.";
            Assert.assertTrue(cafeForumUIFeature.verifyPopularFilterIsSelected(), assertFailurePreText + assertTextVPOG);
            reportLog(assertTextVPOG);

        } catch (Exception e) {
            result = handleException(e);
        }
        Assert.assertTrue(result, testCaseFailureText + currentMethodName + errorMessage);
    }

    @Test(priority = 7, description = "Verify Functionality Of 'Newest' link.")
    public void verifyFunctionalityOfNewestLink() {
        boolean result = true;
        try {
            CafeForumUIFeature cafeForumUIFeature= new CafeForumUIFeature(webDriver,extentTest,extentReports);

            cafeForumUIFeature.clickOnSortedByDropDown();

            String assertTextVEB = "Presence of 'Newest' Link.";
            Assert.assertTrue(cafeForumUIFeature.verifyNewestLink(), assertFailurePreText + assertTextVEB);
            reportLog(assertTextVEB);

            cafeForumUIFeature.clickOnNewestLink();

            String assertTextVSPOG = "Presence of 'Sorted By' DropDown.";
            Assert.assertTrue(cafeForumUIFeature.verifySortedByDropDown(), assertFailurePreText + assertTextVSPOG);
            reportLog(assertTextVSPOG);

            String assertTextVPOG = "Presence of 'Newest Link Filter ' Tab.";
            Assert.assertTrue(cafeForumUIFeature.verifyNewestFilterIsSelected(), assertFailurePreText + assertTextVPOG);
            reportLog(assertTextVPOG);

        } catch (Exception e) {
            result = handleException(e);
        }
        Assert.assertTrue(result, testCaseFailureText + currentMethodName + errorMessage);
    }

    @Test(priority = 9, description = "Verify Functionality Of 'UnAnswered' link.")
    public void verifyFunctionalityOfUnAnsweredLink() {
        boolean result = true;
        try {
            CafeForumUIFeature cafeForumUIFeature= new CafeForumUIFeature(webDriver,extentTest,extentReports);

            cafeForumUIFeature.clickOnSortedByDropDown();

            String assertTextVEB = "Presence of 'UnAnswered' Link.";
            Assert.assertTrue(cafeForumUIFeature.verifyUnAnsweredLink(), assertFailurePreText + assertTextVEB);
            reportLog(assertTextVEB);

            cafeForumUIFeature.clickOnUnAnsweredLink();

            String assertTextVSPOG = "Presence of 'Sorted By' DropDown.";
            Assert.assertTrue(cafeForumUIFeature.verifySortedByDropDown(), assertFailurePreText + assertTextVSPOG);
            reportLog(assertTextVSPOG);

            String assertTextVPOG = "Presence of 'UnAnswered Link Filter ' Tab.";
            Assert.assertTrue(cafeForumUIFeature.verifyUnAnsweredFilterIsSelected(), assertFailurePreText + assertTextVPOG);
            reportLog(assertTextVPOG);

            String assertTextVSOG = "Presence of 'UnAnswered' Data.";
            Assert.assertTrue(cafeForumUIFeature.verifyUnAnsweredFilterDataIsDisplay(), assertFailurePreText + assertTextVSOG);
            reportLog(assertTextVSOG);

        } catch (Exception e) {
            result = handleException(e);
        }
        Assert.assertTrue(result, testCaseFailureText + currentMethodName + errorMessage);
    }

    @Test(priority = 11, description = "Verify Functionality Of 'Question Of The Week' link.")
    public void verifyFunctionalityOfQuestionOfTheWeekLink() {
        boolean result = true;
        try {
            CafeForumUIFeature cafeForumUIFeature= new CafeForumUIFeature(webDriver,extentTest,extentReports);

            cafeForumUIFeature.clickOnSortedByDropDown();

            String assertTextVEB = "Presence of 'Question Of The Week' Link.";
            Assert.assertTrue(cafeForumUIFeature.verifyQuestionOfTheWeekLink(), assertFailurePreText + assertTextVEB);
            reportLog(assertTextVEB);

            cafeForumUIFeature.clickOnUnQuestionOfTheWeekrLink();

            String assertTextVSPOG = "Presence of 'Sorted By' DropDown.";
            Assert.assertTrue(cafeForumUIFeature.verifySortedByDropDown(), assertFailurePreText + assertTextVSPOG);
            reportLog(assertTextVSPOG);

            String assertTextVPOG = "Presence of 'Question Of The Week Link Filter ' Tab.";
            Assert.assertTrue(cafeForumUIFeature.verifyQuestionOfTheWeekFilterIsSelected(), assertFailurePreText + assertTextVPOG);
            reportLog(assertTextVPOG);

            String assertTextVSOG = "Presence of 'Question Of The Week ' Data.";
            Assert.assertTrue(cafeForumUIFeature.verifyQuestionOfTheWeekFilterDataIsDisplay(), assertFailurePreText + assertTextVSOG);
            reportLog(assertTextVSOG);

        } catch (Exception e) {
            result = handleException(e);
        }
        Assert.assertTrue(result, testCaseFailureText + currentMethodName + errorMessage);
    }
}