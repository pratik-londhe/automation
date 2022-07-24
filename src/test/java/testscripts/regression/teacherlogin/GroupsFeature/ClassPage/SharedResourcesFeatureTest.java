package testscripts.regression.teacherlogin.GroupsFeature.ClassPage;

import com.relevantcodes.extentreports.LogStatus;
import org.apache.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.Test;
import testscripts.BaseTestScript;
import uipages.flexbook2feature.LoginPage;
import uipages.flexbook2feature.SharedResourcesFeature;
import uipages.flexbook2feature.TeacherDashboardPage;

public class SharedResourcesFeatureTest extends BaseTestScript {
    private static final Logger logger = Logger.getLogger(SharedResourcesFeatureTest.class);
    private String testCaseFailureText = "Test failed for method: ";
    private String assertFailurePreText = "Failed to verify: ";
    public String assertSuccessPreText = "Successfully verified: ";

    @Test(priority = 1, dataProvider = "CK12DataProvider", description = "Verify 'Shared Resources' Ui Page Of Student.")
    public void verifySharedResourcesUIPage(String email, String password) {
        boolean result = true;
        try {
            TeacherDashboardPage teacherDashboardPage = new TeacherDashboardPage(webDriver, extentTest, extentReports);
            SharedResourcesFeature sharedResourcesFeature = new SharedResourcesFeature(webDriver, extentTest, extentReports);

            String url = "https://master.ck12.org/group-resources/575381";

            new LoginPage(webDriver, extentTest, extentReports).teacherLogin(email, password);

            Assert.assertTrue(teacherDashboardPage.verifyTeacherProfileOnGamma(), "Failed to verify.");
            extentTest.log(LogStatus.PASS, "User Successfully logged in and verified profile icon.");
            logger.info("User Successfully verify and Verify icon as well");

            webDriver.navigate().to(url);

            String assertTextVML = "Presence of 'Sort By' text";
            Assert.assertTrue(sharedResourcesFeature.verifySortByText(), assertFailurePreText + assertTextVML);
            reportLog(assertTextVML);

            String assertTextVODD = "Presence of 'Show' text.";
            Assert.assertTrue(sharedResourcesFeature.verifyShowText(), assertFailurePreText + assertTextVODD);
            reportLog(assertTextVODD);

        } catch (Exception e) {
            result = handleException(e);
        }
        Assert.assertTrue(result, testCaseFailureText + currentMethodName + errorMessage);
    }

    @Test(priority = 3, description = "Verify Title 'Type' of Sort by is ByDefault Selected.")
    public void verifyTypeSortIsByDefaultSelected() {
        boolean result = true;
        try {
            SharedResourcesFeature sharedResourcesFeature = new SharedResourcesFeature(webDriver, extentTest, extentReports);

            String assertTextVML = "Presence of 'Type' Title link.";
            Assert.assertTrue(sharedResourcesFeature.verifyTypeTitleLink(), assertFailurePreText + assertTextVML);
            reportLog(assertTextVML);

            String assertTextVODD = "Presence of 'Read' text.";
            Assert.assertTrue(sharedResourcesFeature.verifyReadText(), assertFailurePreText + assertTextVODD);
            reportLog(assertTextVODD);

        } catch (Exception e) {
            result = handleException(e);
        }
        Assert.assertTrue(result, testCaseFailureText + currentMethodName + errorMessage);
    }

    @Test(priority = 5, description = "Verify Functionality Of Title 'Sort By' dropdown.")
    public void verifyFunctionalityOfTitleSortByDropDown() {
        boolean result = true;
        try {
            SharedResourcesFeature sharedResourcesFeature = new SharedResourcesFeature(webDriver, extentTest, extentReports);

            String assertTextVML = "Presence of 'Sort By' DropDown";
            Assert.assertTrue(sharedResourcesFeature.verifySortByDropDown(), assertFailurePreText + assertTextVML);
            reportLog(assertTextVML);

            sharedResourcesFeature.clickOnSortByDropDown();

            String assertTextVL = "Presence of 'Sort By' text";
            Assert.assertTrue(sharedResourcesFeature.verifySortByText(), assertFailurePreText + assertTextVL);
            reportLog(assertTextVL);

            String assertTextVODD = "Presence of 'Type' link.";
            Assert.assertTrue(sharedResourcesFeature.verifyTypeLink(), assertFailurePreText + assertTextVODD);
            reportLog(assertTextVODD);

            String assertTextVOD = "Presence of 'Members' link.";
            Assert.assertTrue(sharedResourcesFeature.verifyMembersLink(), assertFailurePreText + assertTextVOD);
            reportLog(assertTextVOD);

        } catch (Exception e) {
            result = handleException(e);
        }
        Assert.assertTrue(result, testCaseFailureText + currentMethodName + errorMessage);
    }

    @Test(priority = 7, description = "Verify Functionality Of Title 'Members' link of sort by dropDown.")
    public void verifyFunctionalityOfTitleMembers() {
        boolean result = true;
        try {
            SharedResourcesFeature sharedResourcesFeature = new SharedResourcesFeature(webDriver, extentTest, extentReports);

            sharedResourcesFeature.clickOnMembersLink();

            String assertTextVL = "Presence of 'Sort By' text";
            Assert.assertTrue(sharedResourcesFeature.verifySortByText(), assertFailurePreText + assertTextVL);
            reportLog(assertTextVL);

            String assertTextVODD = "Presence of 'Resource Name' text.";
            Assert.assertTrue(sharedResourcesFeature.verifyResourceNameText(), assertFailurePreText + assertTextVODD);
            reportLog(assertTextVODD);

        } catch (Exception e) {
            result = handleException(e);
        }
        Assert.assertTrue(result, testCaseFailureText + currentMethodName + errorMessage);
    }

    @Test(priority = 9, description = "Verify Functionality Of Title 'Type' link of sort by dropDown.")
    public void verifyFunctionalityOfTitleType() {
        boolean result = true;
        try {
            SharedResourcesFeature sharedResourcesFeature = new SharedResourcesFeature(webDriver, extentTest, extentReports);

            String assertTextVML = "Presence of 'Sort By' DropDown";
            Assert.assertTrue(sharedResourcesFeature.verifySortByDropDown(), assertFailurePreText + assertTextVML);
            reportLog(assertTextVML);

            sharedResourcesFeature.clickOnSortByDropDown();

            String assertTextVL = "Presence of 'Sort By' text";
            Assert.assertTrue(sharedResourcesFeature.verifySortByText(), assertFailurePreText + assertTextVL);
            reportLog(assertTextVL);

            String assertTextVODD = "Presence of 'Type' link.";
            Assert.assertTrue(sharedResourcesFeature.verifyTypeLink(), assertFailurePreText + assertTextVODD);
            reportLog(assertTextVODD);

            sharedResourcesFeature.clickOnTypeLink();

            String assertTextVST = "Presence of 'Sort By' text";
            Assert.assertTrue(sharedResourcesFeature.verifySortByText(), assertFailurePreText + assertTextVST);
            reportLog(assertTextVST);

            String assertTextVDD = "Presence of 'Read' text.";
            Assert.assertTrue(sharedResourcesFeature.verifyReadText(), assertFailurePreText + assertTextVDD);
            reportLog(assertTextVDD);

        } catch (Exception e) {
            result = handleException(e);
        }
        Assert.assertTrue(result, testCaseFailureText + currentMethodName + errorMessage);
    }

    @Test(priority = 11, description = "Verify Shred Resources when only shared by others checkBox Is Selected ")
    public void verifySharedResourcesWhenOnlySharedByOthersCheckBoxIsSelected() {
        boolean result = true;
        try {
            SharedResourcesFeature sharedResourcesFeature = new SharedResourcesFeature(webDriver, extentTest, extentReports);

            String assertTextVML = "Presence of 'Share By Me' CheckBox";
            Assert.assertTrue(sharedResourcesFeature.verifySharedByMeCheckBox(), assertFailurePreText + assertTextVML);
            reportLog(assertTextVML);

            sharedResourcesFeature.clickOnSharedByMeCheckBox();

            String assertTextVL = "Presence of 'Sort By' text";
            Assert.assertTrue(sharedResourcesFeature.verifySortByText(), assertFailurePreText + assertTextVL);
            reportLog(assertTextVL);

            String assertTextVDD = "Presence of 'No Resources Text' text.";
            Assert.assertTrue(sharedResourcesFeature.verifyNoResourcesText(), assertFailurePreText + assertTextVDD);
            reportLog(assertTextVDD);

        } catch (Exception e) {
            result = handleException(e);
        }
        Assert.assertTrue(result, testCaseFailureText + currentMethodName + errorMessage);
    }

    @Test(priority = 13, description = "Verify Shred Resources when only shared by Me checkBox Is Selected ")
    public void verifySharedResourcesWhenOnlySharedByMeCheckBoxIsSelected() {
        boolean result = true;
        try {
            SharedResourcesFeature sharedResourcesFeature = new SharedResourcesFeature(webDriver, extentTest, extentReports);

            String assertTextVML = "Presence of 'Share By Me' CheckBox";
            Assert.assertTrue(sharedResourcesFeature.verifySharedByMeCheckBox(), assertFailurePreText + assertTextVML);
            reportLog(assertTextVML);

            sharedResourcesFeature.clickOnSharedByMeCheckBox();

            String assertTextVL = "Presence of 'Share By Others' CheckBox";
            Assert.assertTrue(sharedResourcesFeature.verifySharedByOthersCheckBox(), assertFailurePreText + assertTextVL);
            reportLog(assertTextVL);

            sharedResourcesFeature.clickOnSharedByOthersCheckBox();

            String assertTextVST = "Presence of 'Sort By' text";
            Assert.assertTrue(sharedResourcesFeature.verifySortByText(), assertFailurePreText + assertTextVST);
            reportLog(assertTextVST);

            String assertTextVDD = "Presence of 'Read' text.";
            Assert.assertTrue(sharedResourcesFeature.verifyReadText(), assertFailurePreText + assertTextVDD);
            reportLog(assertTextVDD);

        } catch (Exception e) {
            result = handleException(e);
        }
        Assert.assertTrue(result, testCaseFailureText + currentMethodName + errorMessage);
    }

    @Test(priority = 15, description = "Verify Shred Resources when both 'shared by Me' and 'Shared By Others' checkBox Is Selected ")
    public void verifySharedResourcesWhenBothCheckBoxIsSelected() {
        boolean result = true;
        try {
            SharedResourcesFeature sharedResourcesFeature = new SharedResourcesFeature(webDriver, extentTest, extentReports);

            String assertTextVL = "Presence of 'Share By Others' CheckBox";
            Assert.assertTrue(sharedResourcesFeature.verifySharedByOthersCheckBox(), assertFailurePreText + assertTextVL);
            reportLog(assertTextVL);

            sharedResourcesFeature.clickOnSharedByOthersCheckBox();

            String assertTextVST = "Presence of 'Sort By' text";
            Assert.assertTrue(sharedResourcesFeature.verifySortByText(), assertFailurePreText + assertTextVST);
            reportLog(assertTextVST);

            String assertTextVDD = "Presence of 'Read' text.";
            Assert.assertTrue(sharedResourcesFeature.verifyReadText(), assertFailurePreText + assertTextVDD);
            reportLog(assertTextVDD);

        } catch (Exception e) {
            result = handleException(e);
        }
        Assert.assertTrue(result, testCaseFailureText + currentMethodName + errorMessage);
    }

    @Test(priority = 17, description = "Verify Functionality of 'Delete Icon' when resources is 'Shared By Me'.")
    public void verifyFunctionalityOfDeleteIcon() {
        boolean result = true;
        try {
            SharedResourcesFeature sharedResourcesFeature = new SharedResourcesFeature(webDriver, extentTest, extentReports);

            String assertTextVL = "Presence of 'Delete' Icon";
            Assert.assertTrue(sharedResourcesFeature.verifyDeleteIcon(), assertFailurePreText + assertTextVL);
            reportLog(assertTextVL);

            sharedResourcesFeature.clickOnDeleteIcon();

            String assertTextVST = "Presence of 'Remove Resources' text";
            Assert.assertTrue(sharedResourcesFeature.verifyRemoveResourcesText(), assertFailurePreText + assertTextVST);
            reportLog(assertTextVST);

            String assertTextVDI = "Presence of 'Delete Resources' Button";
            Assert.assertTrue(sharedResourcesFeature.verifyDeleteResourcesButton(), assertFailurePreText + assertTextVDI);
            reportLog(assertTextVDI);

        } catch (Exception e) {
            result = handleException(e);
        }
        Assert.assertTrue(result, testCaseFailureText + currentMethodName + errorMessage);
    }

    @Test(priority = 19, description = "Verify Functionality of 'Cancel Delete' button of Remove Resources Pop Up.")
    public void verifyFunctionalityOfCancelDeleteButton() {
        boolean result = true;
        try {
            SharedResourcesFeature sharedResourcesFeature = new SharedResourcesFeature(webDriver, extentTest, extentReports);

            String assertTextVL = "Presence of 'Cancel Delete' Button";
            Assert.assertTrue(sharedResourcesFeature.verifyCancelDeleteResourcesButton(), assertFailurePreText + assertTextVL);
            reportLog(assertTextVL);

            sharedResourcesFeature.clickOnCancelDeleteButton();

            String assertTextVST = "Presence of 'Sort By' text";
            Assert.assertTrue(sharedResourcesFeature.verifySortByText(), assertFailurePreText + assertTextVST);
            reportLog(assertTextVST);

            String assertTextVDI = "Presence of 'Delete' Icon";
            Assert.assertTrue(sharedResourcesFeature.verifyDeleteIcon(), assertFailurePreText + assertTextVDI);
            reportLog(assertTextVDI);

        } catch (Exception e) {
            result = handleException(e);
        }
        Assert.assertTrue(result, testCaseFailureText + currentMethodName + errorMessage);
    }
}