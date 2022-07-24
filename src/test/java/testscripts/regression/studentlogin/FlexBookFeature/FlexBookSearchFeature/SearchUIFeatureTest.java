package testscripts.regression.studentlogin.FlexBookFeature.FlexBookSearchFeature;

import com.relevantcodes.extentreports.LogStatus;
import org.apache.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.Test;
import testscripts.BaseTestScript;
import uipages.flexbook2feature.*;

/**
 * Created by basidali.mahimkar on 9/27/2019.
 */
public class SearchUIFeatureTest extends BaseTestScript {
    private static final Logger logger = Logger.getLogger(SearchUIFeatureTest.class);
    private String testCaseFailureText = "Test failed for method: ";
    private String assertFailurePreText = "Failed to verify: ";
    public String assertSuccessPreText = "Successfully verified: ";

    @Test(priority = 1, dataProvider = "CK12DataProvider", description = "Verify new search UI is available in the FB 2.0 pages in header.")
    public void verifySearchUIisAvailable(String email, String Password) {
        boolean result = true;
        try {
            CourseBookDetailsPage courseBookDetailsPage = new CourseBookDetailsPage(webDriver,extentTest,extentReports);
            CBookModalityPage cBookModalityPage = new CBookModalityPage(webDriver,extentTest,extentReports);
            CBookPageStudent cBookPageStudent = new CBookPageStudent(webDriver,extentTest,extentReports);

            cBookPageStudent.clickOnTryItNowPopUp(email, Password);
            courseBookDetailsPage.clickOnFirstFlexBook();

            String assertTextVSCDB = "Presence of 'Start Course Details' button.";
            Assert.assertTrue(cBookPageStudent.verifyStartCourseDetailsButton(), assertFailurePreText + assertTextVSCDB);
            reportLog(assertTextVSCDB);

            cBookPageStudent.clickOnStartCourseDetailButton();
            new CBookPrimaryConceptPage(webDriver,extentTest,extentReports).clickOnStart();

            String assertTextVLNC = "Presence of 'Next Concept; link.";
            Assert.assertTrue(cBookModalityPage.verifyLinkOfNextConcept(), assertFailurePreText + assertTextVLNC);
            reportLog(assertTextVLNC);

//            String assertTextVML = "Presence of 'Search Field' On Landing Page.";
//            Assert.assertTrue(searchFeature.verifySearchIcon(), assertFailurePreText + assertTextVML);
//            reportLog(assertTextVML);

        } catch (Exception e) {
            result = handleException(e);
        }
        Assert.assertTrue(result, testCaseFailureText + currentMethodName + errorMessage);
    }

    @Test(priority = 3, description = "Verify search place holder (what do you want to learn today) text renders properly.")
    public void verifySearchPlaceHolder() {
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

    @Test(priority = 5, description = "Verify filter icon available in the right side of the FB2.0 search bar.")
    public void verifyFilterIconIsAvailable() {
        boolean result = true;
        try {
            SearchFeature searchFeature = new SearchFeature(webDriver,extentTest,extentReports);

            String assertTextVML = "Presence of 'Search Filter' button.";
            Assert.assertTrue(searchFeature.verifySearchFilterButton(), assertFailurePreText + assertTextVML);
            reportLog(assertTextVML);

        } catch (Exception e) {
            result = handleException(e);
        }
        Assert.assertTrue(result, testCaseFailureText + currentMethodName + errorMessage);
    }

    @Test(priority = 7, description = "Verify filter icon working properly in the FB2.0 search bar")
    public void verifyFunctionalityOfFilterButton() {
        boolean result = true;
        try {
            SearchFeature searchFeature = new SearchFeature(webDriver,extentTest,extentReports);

            searchFeature.clickOnSearchFilterButton();

            String assertTextVML = "Presence of 'MAth Filter' button.";
            Assert.assertTrue(searchFeature.verifyMathFilterButton(), assertFailurePreText + assertTextVML);
            reportLog(assertTextVML);

            String assertTextVHB = "Presence of 'Science Filter' button.";
            Assert.assertTrue(searchFeature.verifyScienceFilterButton(), assertFailurePreText + assertTextVHB);
            reportLog(assertTextVHB);

        } catch (Exception e) {
            result = handleException(e);
        }
        Assert.assertTrue(result, testCaseFailureText + currentMethodName + errorMessage);
    }

    @Test(priority = 9, description = "Verify Math filter icon working properly in the FB2.0 search bar")
    public void verifyFunctionalityOfMathFilterButton() {
        boolean result = true;
        try {
            SearchFeature searchFeature = new SearchFeature(webDriver,extentTest,extentReports);

            searchFeature.clickOnMathFilterButton();

            String assertTextVML = "Presence of 'MAth Filter' button.";
            Assert.assertTrue(searchFeature.verifyMathSubMenuButton(), assertFailurePreText + assertTextVML);
            reportLog(assertTextVML);

            String assertTextVHB = "Presence of 'Science Filter' button.";
            Assert.assertTrue(searchFeature.verifyScienceFilterButton(), assertFailurePreText + assertTextVHB);
            reportLog(assertTextVHB);

        } catch (Exception e) {
            result = handleException(e);
        }
        Assert.assertTrue(result, testCaseFailureText + currentMethodName + errorMessage);
    }

    @Test(priority = 11, description = "Verify Science filter icon working properly in the FB2.0 search bar")
    public void verifyFunctionalityOScienceFilterButton() {
        boolean result = true;
        try {
            SearchFeature searchFeature = new SearchFeature(webDriver,extentTest,extentReports);

            searchFeature.clickOnScienceFilterButton();

            String assertTextVML = "Presence of 'Science Filter' button.";
            Assert.assertTrue(searchFeature.verifScienceSubMenuButton(), assertFailurePreText + assertTextVML);
            reportLog(assertTextVML);

        } catch (Exception e) {
            result = handleException(e);
        }
        Assert.assertTrue(result, testCaseFailureText + currentMethodName + errorMessage);
    }

    @Test(priority = 13, description = "Verify SubMenu Filter IS Display in Filter Icon After Selected")
    public void verifyFunctionalityOfSubmenuFilter() {
        boolean result = true;
        try {
            SearchFeature searchFeature = new SearchFeature(webDriver,extentTest,extentReports);

            searchFeature.clickOnScienceSubMenuButton();

            String assertTextVML = "Presence of 'Science Filter' is Display.";
            Assert.assertTrue(searchFeature.verifySelectedSearchFilterIsDisplay(), assertFailurePreText + assertTextVML);
            reportLog(assertTextVML);

        } catch (Exception e) {
            result = handleException(e);
        }
        Assert.assertTrue(result, testCaseFailureText + currentMethodName + errorMessage);
    }

    @Test(priority = 15, description = "Verify Functionality Of Remove Filter ICon")
    public void verifyFunctionalityOfRemoveFilterIcon() {
        boolean result = true;
        try {
            SearchFeature searchFeature = new SearchFeature(webDriver,extentTest,extentReports);

            String assertTextVML = "Presence of 'Science Filter' is Display.";
            Assert.assertTrue(searchFeature.verifyRemoveFilterIcon(), assertFailurePreText + assertTextVML);
            reportLog(assertTextVML);

            searchFeature.clickOnRemoveFilterIcon();

            String assertTextVHB = "Presence of 'Search Filter' button.";
            Assert.assertTrue(searchFeature.verifySearchFilterButton(), assertFailurePreText + assertTextVHB);
            reportLog(assertTextVHB);

        } catch (Exception e) {
            result = handleException(e);
        }
        Assert.assertTrue(result, testCaseFailureText + currentMethodName + errorMessage);
    }
}