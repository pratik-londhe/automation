package testscripts.regression.studentlogin.DashBoardFeature.SearchFeature;

import com.relevantcodes.extentreports.LogStatus;
import org.apache.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.Test;
import testscripts.BaseTestScript;
import uipages.flexbook2feature.*;

public class SearchFeatureTest extends BaseTestScript {
    private static final Logger logger = Logger.getLogger(SearchFeatureTest.class);
    private String testCaseFailureText = "Test failed for method: ";
    private String assertFailurePreText = "Failed to verify: ";
    public String assertSuccessPreText = "Successfully verified: ";

    @Test(priority = 1, description = "Verify only ck12 content & community contributed is displayed in search result before login")
    public void verifyMyLibraryResultIsNotDisplay() {
        boolean result = true;
        try {
            SearchFeature searchFeature = new SearchFeature(webDriver, extentTest, extentReports);
            new LoginPage(webDriver, extentTest, extentReports).closeTouSystemMessage();
            String searchText = "a";

            String assertTextVML = "Presence of 'Search PlaceHolder' On Landing Page.";
            Assert.assertTrue(searchFeature.verifySearchPlaceHolder(), assertFailurePreText + assertTextVML);
            reportLog(assertTextVML);

            searchFeature.setValueInSearchPlaceHolder(searchText);

            String assertTextVM = "Presence of 'Search Field' On Landing Page.";
            Assert.assertTrue(searchFeature.verifySearchIcon(), assertFailurePreText + assertTextVM);
            reportLog(assertTextVM);

            searchFeature.clickOnSearchIcon();

            String assertTextVODD = "Presence of 'Search Result' Text.";
            Assert.assertTrue(searchFeature.verifyLSearchResultText(), assertFailurePreText + assertTextVODD);
            reportLog(assertTextVODD);

            String assertTextVOD = "Presence of 'Community Contribute' Tab.";
            Assert.assertTrue(searchFeature.verifyCommunityContributedTab(), assertFailurePreText + assertTextVOD);
            reportLog(assertTextVOD);

            String assertTextVD = "Presence of 'Ck12 Content TAb' Tab.";
            Assert.assertTrue(searchFeature.verifyCk12ContentTab(), assertFailurePreText + assertTextVD);
            reportLog(assertTextVD);

        } catch (Exception e) {
            result = handleException(e);
        }
        Assert.assertTrue(result, testCaseFailureText + currentMethodName + errorMessage);
    }

    @Test(priority = 3, description = "Verify Grade 1 to Grade 12 Filters.")
    public void verifyGradeFilter() {
        boolean result = true;
        try {
            SearchFeature searchFeature = new SearchFeature(webDriver, extentTest, extentReports);

            String email = "student1+testuser@ck12.org";
            String pass = "Pratikck12";

            new LoginPage(webDriver, extentTest, extentReports).teacherLogin(email, pass);

            String assertTextVTPOG = "Student profile icon after login";
            Assert.assertTrue(new StudentDashBoardPage(webDriver, extentTest, extentReports).verifyStudentProfileOnGamma(), assertFailurePreText + assertTextVTPOG);
            reportLog(assertTextVTPOG);

            String assertTextVML = "Presence of 'Search Field' On Landing Page.";
            Assert.assertTrue(searchFeature.verifySearchIcon(), assertFailurePreText + assertTextVML);
            reportLog(assertTextVML);

            String assertTextVODD = "Presence of 'Grades' Text.";
            Assert.assertTrue(searchFeature.verifyGradesText(), assertFailurePreText + assertTextVODD);
            reportLog(assertTextVODD);

            String assertTextVOD = "Presence of 'All Grades Links' Tab.";
            Assert.assertTrue(searchFeature.verifyAllGradesLinks(), assertFailurePreText + assertTextVOD);
            reportLog(assertTextVOD);

            String assertTextVD = "Presence of 'Ck12 Content TAb' Tab.";
            Assert.assertTrue(searchFeature.verifyCk12ContentTab(), assertFailurePreText + assertTextVD);
            reportLog(assertTextVD);

        } catch (Exception e) {
            result = handleException(e);
        }
        Assert.assertTrue(result, testCaseFailureText + currentMethodName + errorMessage);
    }

    @Test(priority = 5, description = "Verify Functionality Of 'Grade' Filters and verify First item of list of selected Grade Filter.")
    public void verifyFunctionalityOfGradeFilter() {
        boolean result = true;
        try {
            SearchFeature searchFeature = new SearchFeature(webDriver, extentTest, extentReports);

            String assertTextVML = "Presence of 'Grade' Link.";
            Assert.assertTrue(searchFeature.verifyGradesLink(), assertFailurePreText + assertTextVML);
            reportLog(assertTextVML);

            searchFeature.clickOnGradeLink();

            String assertTextVM = "Presence of 'Search Field' On Landing Page.";
            Assert.assertTrue(searchFeature.verifySearchIcon(), assertFailurePreText + assertTextVM);
            reportLog(assertTextVM);

            String assertTextVD = "Presence of 'Grades Of First Item In List'.";
            Assert.assertTrue(searchFeature.verifyGradesOfFirstItemInList(), assertFailurePreText + assertTextVD);
            reportLog(assertTextVD);

        } catch (Exception e) {
            result = handleException(e);
        }
        Assert.assertTrue(result, testCaseFailureText + currentMethodName + errorMessage);
    }

    @Test(priority = 7, description = "Verify ' Clear all' link in search results page.")
    public void verifyFunctionalityOfClearAllButton() {
        boolean result = true;
        try {
            SearchFeature searchFeature = new SearchFeature(webDriver, extentTest, extentReports);

            String assertTextVML = "Presence of 'Grade' Link.";
            Assert.assertTrue(searchFeature.verifyClearAllButton(), assertFailurePreText + assertTextVML);
            reportLog(assertTextVML);

            searchFeature.clickOnClearAllButton();

            String assertTextVM = "Presence of 'Search Field' On Landing Page.";
            Assert.assertTrue(searchFeature.verifySearchIcon(), assertFailurePreText + assertTextVM);
            reportLog(assertTextVM);

            String assertTextVODD = "Presence of 'Grades' Text.";
            Assert.assertTrue(searchFeature.verifyGradesText(), assertFailurePreText + assertTextVODD);
            reportLog(assertTextVODD);

        } catch (Exception e) {
            result = handleException(e);
        }
        Assert.assertTrue(result, testCaseFailureText + currentMethodName + errorMessage);
    }
}