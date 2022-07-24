package testscripts.regression.teacherlogin.LibraryFeature.FilterByFeature;

import com.relevantcodes.extentreports.LogStatus;
import org.apache.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.Test;
import testscripts.BaseTestScript;
import uipages.flexbook2feature.*;

public class FilterBySourceFeatureTest extends BaseTestScript {
    private static final Logger logger = Logger.getLogger(FilterBySourceFeatureTest.class);
    private String testCaseFailureText = "Test failed for method: ";
    private String assertFailurePreText = "Failed to verify: ";
    public String assertSuccessPreText = "Successfully verified: ";



    @Test(priority = 1, dataProvider = "CK12DataProvider", description = "Verify All The 'Filter Source' Are Present Inside Filter By Source Container.")
    public void verifyAllTheFilterTypesArePresentInsideFilterBySourceContainer(String email, String password) {
        boolean result = true;
        try {
            TeacherDashboardPage teacherDashboardPage = new TeacherDashboardPage(webDriver, extentTest, extentReports);
            CourseBookCreateEditAssignDelete courseBookCreateEditAssignDelete = new CourseBookCreateEditAssignDelete(webDriver, extentTest, extentReports);
            FilterByTypeFeature filterByTypeFeature = new FilterByTypeFeature(webDriver, extentTest, extentReports);

            new LoginPage(webDriver, extentTest, extentReports).teacherLogin(email, password);

            Assert.assertTrue(teacherDashboardPage.verifyTeacherProfileOnGamma(), "Failed to verified user profile for CreateCBookUsingModalityTest.");
            extentTest.log(LogStatus.PASS, "User Successfully logged in and verified profile icon.");
            logger.info("User Successfully logged in and verified profile icon.");

            new PageMenuTab(webDriver, extentTest, extentReports).clickOnLibraryTab();

            Assert.assertTrue(courseBookCreateEditAssignDelete.verifyCreateNewDropDown(), "Failed to verified Create New DropDown");
            extentTest.log(LogStatus.PASS, "Successfully verified Create New DropDown");
            logger.info("Successfully verified Create New DropDown");

            String assertTextVML = "Presence of 'Filter By Type' Text";
            Assert.assertTrue(filterByTypeFeature.verifyFilterByTypeText(), assertFailurePreText + assertTextVML);
            reportLog(assertTextVML);

            String assertTextVFTT = "Presence of 'Created By Me' Filter Source CheckBox";
            Assert.assertTrue(filterByTypeFeature.verifyCreateByMeCheckBox(), assertFailurePreText + assertTextVFTT);
            reportLog(assertTextVFTT);

        } catch (Exception e) {
            result = handleException(e);
        }
        Assert.assertTrue(result, testCaseFailureText + currentMethodName + errorMessage);
    }

    @Test(priority = 3, description = "Verify Functionality Of 'Created By Me' Filter By Source CheckBox.")
    public void verifyFunctionalityOfCreatedByMeCheckBox() {
        boolean result = true;
        try {
            FilterByTypeFeature filterByTypeFeature = new FilterByTypeFeature(webDriver, extentTest, extentReports);

            filterByTypeFeature.clickOnCreateByMeCheckBox();

            String assertTextVML = "Presence of 'Filter By Type' Text";
            Assert.assertTrue(filterByTypeFeature.verifyFilterByTypeText(), assertFailurePreText + assertTextVML);
            reportLog(assertTextVML);

            String assertTextVFTT = "Presence of 'Created By Me' Filter Source CheckBox";
            Assert.assertTrue(filterByTypeFeature.verifyFirstItemOfLibraryListIsCreatedByMe(), assertFailurePreText + assertTextVFTT);
            reportLog(assertTextVFTT);

        } catch (Exception e) {
            result = handleException(e);
        }
        Assert.assertTrue(result, testCaseFailureText + currentMethodName + errorMessage);
    }

    @Test(priority = 5, description = "Verify Functionality Of 'Draft' CheckBox when the Creator Is Owner.")
    public void verifyFunctionalityOfDraftCheckbox() {
        boolean result = true;
        try {
            FilterByTypeFeature filterByTypeFeature = new FilterByTypeFeature(webDriver, extentTest, extentReports);

            String assertTextVFT = "Presence of 'Draft' Filter Source CheckBox";
            Assert.assertTrue(filterByTypeFeature.verifyDraftCheckBox(), assertFailurePreText + assertTextVFT);
            reportLog(assertTextVFT);

            filterByTypeFeature.clickOnDraftCheckBox();

            String assertTextVML = "Presence of 'Filter By Type' Text";
            Assert.assertTrue(filterByTypeFeature.verifyFilterByTypeText(), assertFailurePreText + assertTextVML);
            reportLog(assertTextVML);

            String assertTextVT = "No Items In Library List";
            Assert.assertTrue(filterByTypeFeature.verifyNoItemsInLibraryText(), assertFailurePreText + assertTextVT);
            reportLog(assertTextVT);

        } catch (Exception e) {
            result = handleException(e);
        }
        Assert.assertTrue(result, testCaseFailureText + currentMethodName + errorMessage);
    }

    @Test(priority = 7, description = "Verify Functionality Of 'Finalize' CheckBox when the Creator Is Owner.")
    public void verifyFunctionalityOfFinalizeCheckbox() {
        boolean result = true;
        try {
            FilterByTypeFeature filterByTypeFeature = new FilterByTypeFeature(webDriver, extentTest, extentReports);

            String assertTextVFT = "Presence of 'Finalize' Filter Source CheckBox";
            Assert.assertTrue(filterByTypeFeature.verifyFinalizeCheckBox(), assertFailurePreText + assertTextVFT);
            reportLog(assertTextVFT);

            filterByTypeFeature.clickOnFinalizeCheckBox();

            String assertTextVML = "Presence of 'Filter By Type' Text";
            Assert.assertTrue(filterByTypeFeature.verifyFilterByTypeText(), assertFailurePreText + assertTextVML);
            reportLog(assertTextVML);

            String assertTextVFTT = "Presence of 'Created By Me' Filter Source CheckBox";
            Assert.assertTrue(filterByTypeFeature.verifyFirstItemOfLibraryListIsCreatedByMe(), assertFailurePreText + assertTextVFTT);
            reportLog(assertTextVFTT);

        } catch (Exception e) {
            result = handleException(e);
        }
        Assert.assertTrue(result, testCaseFailureText + currentMethodName + errorMessage);
    }

    @Test(priority = 9, description = "Verify Functionality Of 'Add To Library' CheckBox when Creater Is Othets.")
    public void verifyFunctionalityOfOthersCheckbox() {
        boolean result = true;
        try {
            FilterByTypeFeature filterByTypeFeature = new FilterByTypeFeature(webDriver, extentTest, extentReports);

            String assertTextVFT = "Presence of 'Add To Library' Filter Source CheckBox";
            Assert.assertTrue(filterByTypeFeature.verifyAddToLibraryCheckBox(), assertFailurePreText + assertTextVFT);
            reportLog(assertTextVFT);

            filterByTypeFeature.clickOnAddToLibraryCheckBox();

            String assertTextVML = "Presence of 'Filter By Type' Text";
            Assert.assertTrue(filterByTypeFeature.verifyFilterByTypeText(), assertFailurePreText + assertTextVML);
            reportLog(assertTextVML);

            String assertTextVT = "No In Library List empty";
            Assert.assertTrue(filterByTypeFeature.verifyLibraryIsNotEmpty(), assertFailurePreText + assertTextVT);
            reportLog(assertTextVT);

        } catch (Exception e) {
            result = handleException(e);
        }
        Assert.assertTrue(result, testCaseFailureText + currentMethodName + errorMessage);
    }
}