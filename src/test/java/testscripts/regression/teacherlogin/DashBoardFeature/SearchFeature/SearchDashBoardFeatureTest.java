package testscripts.regression.teacherlogin.DashBoardFeature.SearchFeature;

import com.relevantcodes.extentreports.LogStatus;
import org.apache.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.Test;
import testscripts.BaseTestScript;
import uipages.flexbook2feature.LoginPage;
import uipages.flexbook2feature.SearchFeature;
import uipages.flexbook2feature.TeacherDashboardPage;

public class SearchDashBoardFeatureTest extends BaseTestScript {
    private static final Logger logger = Logger.getLogger(SearchDashBoardFeatureTest.class);
    private String testCaseFailureText = "Test failed for method: ";
    private String assertFailurePreText = "Failed to verify: ";
    public String assertSuccessPreText = "Successfully verified: ";



    @Test(priority = 1, description = "Verify Search field exist in teacher landing page.")
    public void verifySearchFieldOnLandingPage() {
        boolean result = true;
        try {
            SearchFeature searchFeature = new SearchFeature(webDriver,extentTest,extentReports);

            String assertTextVML = "Presence of 'Search Field' On Landing Page.";
            Assert.assertTrue(searchFeature.verifySearchIcon(), assertFailurePreText + assertTextVML);
            reportLog(assertTextVML);

        } catch (Exception e) {
            result = handleException(e);
        }
        Assert.assertTrue(result, testCaseFailureText + currentMethodName + errorMessage);
    }

    @Test(priority = 3, description = "Verify Search field exist in before and after login .")
    public void verifySearchFieldBeforeAndAfterLogin() {
        boolean result = true;
        try {
            SearchFeature searchFeature = new SearchFeature(webDriver,extentTest,extentReports);
            TeacherDashboardPage teacherDashboardPage = new TeacherDashboardPage(webDriver,extentTest,extentReports);

            String email = "teacher+testuser@ck12.org";
            String pass = "Pratikck12";

            new LoginPage(webDriver,extentTest, extentReports).teacherLogin(email, pass);

            Assert.assertTrue(teacherDashboardPage.verifyTeacherProfileOnGamma(), "Failed to verify.");
            reportLog("User Successfully logged in and verified profile icon.");

            String assertTextVML = "Presence of 'Search Field' On Landing Page.";
            Assert.assertTrue(searchFeature.verifySearchIcon(), assertFailurePreText + assertTextVML);
            reportLog(assertTextVML);

        } catch (Exception e) {
            result = handleException(e);
        }
        Assert.assertTrue(result, testCaseFailureText + currentMethodName + errorMessage);
    }

    @Test(priority = 5, description = "Verify 'What do you want to learn today?' place holder text renders in landing page search field")
    public void verifyWhatDoYouWantToLearnTodayText() {
        boolean result = true;
        try {
            SearchFeature searchFeature = new SearchFeature(webDriver,extentTest,extentReports);

            String assertTextVML = "Presence of 'Search PlaceHolder' On Landing Page.";
            Assert.assertTrue(searchFeature.verifySearchPlaceHolder(), assertFailurePreText + assertTextVML);
            reportLog(assertTextVML);

            String assertTextVODD = "Presence of 'Renders Text' Inside Search Place Holder.";
            Assert.assertTrue(searchFeature.verifyWhatDoYouWantToLEarnTodayTextInsideSearchPlaceHolder(), assertFailurePreText + assertTextVODD);
            reportLog(assertTextVODD);

        } catch (Exception e) {
            result = handleException(e);
        }
        Assert.assertTrue(result, testCaseFailureText + currentMethodName + errorMessage);
    }

    @Test(priority = 7, description = "Load icon animation should be render while typing some text inside the search bar.")
    public void verifyLoadIcon() {
        boolean result = true;
        try {
            SearchFeature searchFeature = new SearchFeature(webDriver,extentTest,extentReports);

            String searchText = "y";

            String assertTextVML = "Presence of 'Search PlaceHolder' On Landing Page.";
            Assert.assertTrue(searchFeature.verifySearchPlaceHolder(), assertFailurePreText + assertTextVML);
            reportLog(assertTextVML);

            searchFeature.setValueInSearchPlaceHolder(searchText);

//            String assertTextVODD = "Presence of 'Loading ICon'.";
//            Assert.assertTrue(searchFeature.verifyLoadingIcon(), assertFailurePreText + assertTextVODD);
//            reportLog(assertTextVODD);

        } catch (Exception e) {
            result = handleException(e);
        }
        Assert.assertTrue(result, testCaseFailureText + currentMethodName + errorMessage);
    }

    @Test(priority = 9, description = "Verify the auto search suggestion count should not be more then 10 results.")
    public void verifyAutoGenerateCount() {
        boolean result = true;
        try {
            SearchFeature searchFeature = new SearchFeature(webDriver,extentTest,extentReports);

            searchFeature.getCountOfAutoGenerateListItems();

            String assertTextVML = "Presence of 'AutoGenerate List Of Items' On Landing Page.";
            Assert.assertTrue(searchFeature.verifyAutoGenerateCountOfList(), assertFailurePreText + assertTextVML);
            reportLog(assertTextVML);

        } catch (Exception e) {
            result = handleException(e);
        }
        Assert.assertTrue(result, testCaseFailureText + currentMethodName + errorMessage);
    }

    @Test(priority = 11, description = "Verify search with special characters(, - : ; _).")
    public void verifySearchWithSpecialCharacter() {
        SearchFeature searchFeature = new SearchFeature(webDriver,extentTest,extentReports);

        boolean result = true;
        try {
            String searchText = "_;:";

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

//            String assertTextVOD = "Presence of 'Search Item' List.";
//            Assert.assertTrue(searchFeature.verifyLSearchItemList(), assertFailurePreText + assertTextVOD);
//            reportLog(assertTextVOD);

        } catch (Exception e) {
            result = handleException(e);
        }
        Assert.assertTrue(result, testCaseFailureText + currentMethodName + errorMessage);
    }

    @Test(priority = 12, description = "Verify ck12 content, community contributed & my library is displayed in search result after login")
    public void verifyAllTabsAreDisplayAfterLogin() {
        boolean result = true;
        try {
            SearchFeature searchFeature = new SearchFeature(webDriver,extentTest,extentReports);

            String assertTextVOD = "Presence of 'Community Contribute' Tab.";
            Assert.assertTrue(searchFeature.verifyCommunityContributedTab(), assertFailurePreText + assertTextVOD);
            reportLog(assertTextVOD);

            String assertTextVD = "Presence of 'Ck12 Content TAb' Tab.";
            Assert.assertTrue(searchFeature.verifyCk12ContentTab(), assertFailurePreText + assertTextVD);
            reportLog(assertTextVD);

            String assertTextVLPS = "Presence of 'My Library' TAb.";
            Assert.assertTrue(searchFeature.verifyMyLibraryTab(), assertFailurePreText + assertTextVLPS);
            reportLog(assertTextVLPS);

        } catch (Exception e) {
            result = handleException(e);
        }
        Assert.assertTrue(result, testCaseFailureText + currentMethodName + errorMessage);
    }

    @Test(priority = 13, description = "Verify search with unicode characters(& ^ % $ #).")
    public void verifySearchWithUniCodeCharacter() {
        boolean result = true;
        try {
            SearchFeature searchFeature = new SearchFeature(webDriver,extentTest,extentReports);

            String searchText = "&#";

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

        } catch (Exception e) {
            result = handleException(e);
        }
        Assert.assertTrue(result, testCaseFailureText + currentMethodName + errorMessage);
    }

    @Test(priority = 15, description = "Verify search with numeric(1,2,3,4...).")
    public void verifySearchWithNumeric() {
        boolean result = true;
        try {
            SearchFeature searchFeature = new SearchFeature(webDriver,extentTest,extentReports);

            String searchText = "12";

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

        } catch (Exception e) {
            result = handleException(e);
        }
        Assert.assertTrue(result, testCaseFailureText + currentMethodName + errorMessage);
    }

    @Test(priority = 16, description = "Verify search with  combination of all numeric, special characters & alphabets.")
    public void verifySearchWithNumericAndSpecialCharacter() {
        boolean result = true;
        try {
            SearchFeature searchFeature = new SearchFeature(webDriver,extentTest,extentReports);

            String searchText = "12&A";

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

        } catch (Exception e) {
            result = handleException(e);
        }
        Assert.assertTrue(result, testCaseFailureText + currentMethodName + errorMessage);
    }

    @Test(priority = 18, description = "Verify Try 'Previous Search' hyperlink in zero search results suggestion information.")
    public void verifyZeroSearchResult() {
        boolean result = true;
        try {
            SearchFeature searchFeature = new SearchFeature(webDriver,extentTest,extentReports);

            String searchText = "haguruivkjhyueqweoqwdkljsbcdoqaisb";

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

            searchFeature.clickOnCommunityContributedTab();

            String assertTextVD = "Presence of 'Ck12 Content TAb' Tab.";
            Assert.assertTrue(searchFeature.verifyCk12ContentTab(), assertFailurePreText + assertTextVD);
            reportLog(assertTextVD);

            searchFeature.clickOnCk12ContentTab();

            String assertTextVLPS = "Presence of 'Previous Search Link'.";
            Assert.assertTrue(searchFeature.verifyPreviousSearchLink(), assertFailurePreText + assertTextVLPS);
            reportLog(assertTextVLPS);

        } catch (Exception e) {
            result = handleException(e);
        }
        Assert.assertTrue(result, testCaseFailureText + currentMethodName + errorMessage);
    }

    @Test(priority = 20, description = "Verify Functionality Of  'Previous Search' hyperlink in zero search results suggestion information.")
    public void verifyFunctionalityOfZeroSearch() {
        boolean result = true;
        try {
            SearchFeature searchFeature = new SearchFeature(webDriver,extentTest,extentReports);

            searchFeature.clickOnPreviousSearchLink();

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
}