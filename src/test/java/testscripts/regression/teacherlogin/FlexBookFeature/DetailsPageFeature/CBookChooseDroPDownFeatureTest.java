package testscripts.regression.teacherlogin.FlexBookFeature.DetailsPageFeature;

import org.apache.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.Test;
import testscripts.BaseTestScript;
import uipages.flexbook2feature.*;

public class CBookChooseDroPDownFeatureTest extends BaseTestScript {
    private static final Logger logger = Logger.getLogger(CBookChooseDroPDownFeatureTest.class);
    public CBookLandingPage cBookLandingPage;
    public CourseBookDetailsPage courseBookDetailsPage;
    public CreateFlexBookPage createFlexBookPage;
    public CourseBookCreateEditAssignDelete courseBookCreateEditAssignDelete;
    public LibraryPage libraryPage;

    @Test(priority = 1, dataProvider = "CK12DataProvider", description = "Verify the Functionality of 'Customize' Button After Clicking On Choose DropDown")
    public void verifyFunctionalityOfChooseDropDown(String email, String password, String url) {
        boolean result = true;
        try {
            CBookLandingPage cBookLandingPage = new CBookLandingPage(webDriver, extentTest, extentReports);
            CourseBookDetailsPage courseBookDetailsPage = new CourseBookDetailsPage(webDriver, extentTest, extentReports);
            CreateFlexBookPage createFlexBookPage = new CreateFlexBookPage(webDriver, extentTest, extentReports);
            CourseBookCreateEditAssignDelete courseBookCreateEditAssignDelete = new CourseBookCreateEditAssignDelete(webDriver, extentTest, extentReports);

            webDriver.navigate().to(url);
            cBookLandingPage.clickOnTryItNow(email, password);
            courseBookDetailsPage.clickOnFirstFlexBook();

            Assert.assertTrue(courseBookDetailsPage.verifyAuthorLink(), "Test Script Field to Verify Author Link");
            reportLog( "Teacher Successfully Verify Author Link ");
           

            Assert.assertTrue(courseBookDetailsPage.verifyChooseButton(), "Test Script Field to Verify Choose Button");
            reportLog( "Teacher Successfully  Verify Choose Button");

            courseBookDetailsPage.clickOnChooseButton();

            Assert.assertTrue(courseBookDetailsPage.verifyAssignButton(), "Test Script Field to Verify Assign Button");
            reportLog( "Teacher Successfully Verify Assign Button");

            Assert.assertTrue(courseBookDetailsPage.verifyCustomizeButton(), "Test Script Field to Verify Customize Button");
            reportLog( "Teacher Successfully Verify Customize Button");

            courseBookDetailsPage.clickOnCustomizeButton();
            createFlexBookPage.clickOnGotItButtonPopUp();

            Assert.assertTrue(courseBookCreateEditAssignDelete.verifyAddContentOptions(), "Failed to verified Add Content DropDown.");
            reportLog( "Successfully verified Add Content DropDown.");

            Assert.assertTrue(courseBookCreateEditAssignDelete.verifySaveButton(), "Failed to verified Save Button.");
            reportLog( "Successfully verified Save Button.");

        } catch (Exception e) {
            result = handleException(e);
        }
        Assert.assertTrue(result, "Test script failed : " + errorMessage);
    }

    @Test(priority = 2, description = "Verify the Functionality of 'Save' Button  After Clicking On Customize Button")
    public void verifySaveButtonAfterCustomize() {
        boolean result = true;
        try {
            CourseBookDetailsPage courseBookDetailsPage = new CourseBookDetailsPage(webDriver, extentTest, extentReports);
            CourseBookCreateEditAssignDelete courseBookCreateEditAssignDelete = new CourseBookCreateEditAssignDelete(webDriver, extentTest, extentReports);

            courseBookCreateEditAssignDelete.clickOnSaveButton();

            Assert.assertTrue(courseBookDetailsPage.verifyChooseButton(), "Test Script Field to Verify Choose Button");
            reportLog( "Teacher Successfully  Verify Choose Button");

            courseBookDetailsPage.clickOnChooseButton();

            Assert.assertTrue(courseBookDetailsPage.verifyAssignButton(), "Test Script Field to Verify Assign Button");
            reportLog( "Teacher Successfully Verify Assign Button");

            Assert.assertTrue(courseBookDetailsPage.verifyPublishButton(), "Test Script Field to Verify Publish Button");
            reportLog( "Teacher Successfully Verify Publish Button");

        } catch (Exception e) {
            result = handleException(e);
        }
        Assert.assertTrue(result, "Failed To Verify" + errorMessage);
    }

    @Test(priority = 3, description = "Verify the Functionality of 'Publish' Button  After Clicking On Choose DropDown")
    public void verifyFunctionalityOfPublishButton() {
        boolean result = true;
        try {
            CourseBookDetailsPage courseBookDetailsPage = new CourseBookDetailsPage(webDriver, extentTest, extentReports);

            courseBookDetailsPage.clickOnPublishButton();

            Assert.assertTrue(courseBookDetailsPage.verifyPublishTab(), "Test Script Field to Verify Publish Tab");
            reportLog( "Teacher Successfully  Verify  Publish Tab");

            Assert.assertTrue(courseBookDetailsPage.verifyCk12ContentDriveCheckBox(), "Test Script Field to Verify Ck12 Content Drive CheckBox");
            reportLog( "Teacher Successfully Verify Ck12 Content Drive CheckBox");

        } catch (Exception e) {
            result = handleException(e);
        }
        Assert.assertTrue(result, "Failed To Verify" + errorMessage);
    }

    @Test(priority = 4, description = "Verify the Functionality of 'Publish' Tab Without Selecting CheckBox")
    public void verifyFunctionalityOfPublishTabWithoutSelectingCheckBox() {
        boolean result = true;
        try {
            CourseBookDetailsPage courseBookDetailsPage = new CourseBookDetailsPage(webDriver, extentTest, extentReports);

            courseBookDetailsPage.clickOnPublishTab();

            Assert.assertTrue(courseBookDetailsPage.verifyErrorPublishMessage(), "Test Script Field to Verify Error Publish Message");
            reportLog( "Teacher Successfully  Verify Error Publish Message");

            Assert.assertTrue(courseBookDetailsPage.verifyCk12ContentDriveCheckBox(), "Test Script Field to Verify Ck12 Content Drive CheckBox");
            reportLog( "Teacher Successfully Verify Ck12 Content Drive CheckBox");

        } catch (Exception e) {
            result = handleException(e);
        }
        Assert.assertTrue(result, "Failed To Verify" + errorMessage);
    }

    @Test(priority = 5, description = "Verify the Functionality of 'Publish' Tab After Selecting  CheckBox")
    public void verifyFunctionalityOfPublishTabWithSelectingCheckBox() {
        boolean result = true;
        try {
            CourseBookDetailsPage courseBookDetailsPage = new CourseBookDetailsPage(webDriver, extentTest, extentReports);

            courseBookDetailsPage.clickOnPublishTab();

            Assert.assertTrue(courseBookDetailsPage.verifyCk12ContentDriveCheckBox(), "Test Script Field to Verify Ck12 Content Drive CheckBox");
            reportLog( "Teacher Successfully Verify Ck12 Content Drive CheckBox");

            courseBookDetailsPage.clickOnCk12ContentDriveCheckBox();

            Assert.assertTrue(courseBookDetailsPage.verifyPublishTab(), "Test Script Field to Verify Publish Tab");
            reportLog( "Teacher Successfully  Verify  Publish Tab");

            courseBookDetailsPage.clickOnPublishTab();

            Assert.assertTrue(courseBookDetailsPage.verifyThanksForMessage(), "Test Script Field to Verify Thanks For Message Text");
            reportLog( "Teacher Successfully  Verify  Thanks For Message Text");

        } catch (Exception e) {
            result = handleException(e);
        }
        Assert.assertTrue(result, "Failed To Verify" + errorMessage);
    }

    @Test(priority = 6, description = "Verify the Functionality of 'Got It' Button After Clicking On Publish Tab")
    public void verifyFunctionalityOfGotIt() {
        boolean result = true;
        try {
            CourseBookDetailsPage courseBookDetailsPage = new CourseBookDetailsPage(webDriver, extentTest, extentReports);

            Assert.assertTrue(courseBookDetailsPage.verifyGotItButton(), "Test Script Field to Verify Got It Button");
            reportLog( "Teacher Successfully Verify  Got It Button");

            courseBookDetailsPage.clickOnGotItButton();

            Assert.assertTrue(courseBookDetailsPage.verifyChooseButton(), "Test Script Field to Verify Choose Button");
            reportLog( "Teacher Successfully  Verify Choose Button");

            courseBookDetailsPage.clickOnChooseButton();

            Assert.assertTrue(courseBookDetailsPage.verifyAssignButton(), "Test Script Field to Verify Assign Button");
            reportLog( "Teacher Successfully Verify Assign Button");

            Assert.assertTrue(courseBookDetailsPage.verifyEditButton(), "Test Script Field to Verify Edit Button");
            reportLog( "Teacher Successfully Verify Edit Button");

        } catch (Exception e) {
            result = handleException(e);
        }
        Assert.assertTrue(result, "Failed To Verify" + errorMessage);
    }

    @Test(priority = 7, description = "Verify the Functionality of 'Edit' Button After Clicking On Choose DropDown")
    public void verifyFunctionalityOfEdit() {
        boolean result = true;
        try {
            CourseBookDetailsPage courseBookDetailsPage = new CourseBookDetailsPage(webDriver, extentTest, extentReports);
            CourseBookCreateEditAssignDelete courseBookCreateEditAssignDelete = new CourseBookCreateEditAssignDelete(webDriver, extentTest, extentReports);

            courseBookDetailsPage.clickOnEditButton();
            new CreateFlexBookPage(webDriver, extentTest, extentReports).clickOnGotItButtonPopUp();

            Assert.assertTrue(courseBookCreateEditAssignDelete.verifyAddContentOptions(), "Failed to verified Add Content DropDown.");
            reportLog( "Successfully verified Add Content DropDown.");

            Assert.assertTrue(courseBookCreateEditAssignDelete.verifySaveButton(), "Failed to verified Save Button.");
            reportLog( "Successfully verified Save Button.");

            courseBookCreateEditAssignDelete.clickOnSaveButton();

            Assert.assertTrue(courseBookDetailsPage.verifyChooseButton(), "Test Script Field to Verify Choose Button");
            reportLog( "Teacher Successfully  Verify Choose Button");

        } catch (Exception e) {
            result = handleException(e);
        }
        Assert.assertTrue(result, "Failed To Verify" + errorMessage);
    }

    @Test(priority = 8, description = "Verify The FlexBook Is Added In The Library")
    public void verifyFunctionalityOfAssignButton() {
        boolean result = true;
        try {
            CourseBookCreateEditAssignDelete courseBookCreateEditAssignDelete = new CourseBookCreateEditAssignDelete(webDriver, extentTest, extentReports);

            Assert.assertTrue(cBookLandingPage.verifyTeacherAccountIcon(), "Test Script Field to Verify Teacher Account");
            reportLog( "Teacher Successfully logged in and verify Teacher icon ");

            cBookLandingPage.clickOnAccountIcon();

            Assert.assertTrue(cBookLandingPage.verifyLinkLibrary(), "Test Script Field");
            reportLog( "User Successfully verify My Library Link ");

            cBookLandingPage.clickOnLinkLibrary();

            Assert.assertTrue(courseBookCreateEditAssignDelete.verifyCreateNewDropDown(), "Failed to verified Create New DropDown");
            reportLog( "Successfully verified Create New DropDown");

            libraryPage.clickOnElipsisIconForEdit();

            Assert.assertTrue(libraryPage.verifyEditButton(), "Failed to verified Edit Button");
            reportLog( "Successfully  verified Edit Button");

            Assert.assertTrue(libraryPage.verifyArchiveButton(), "Failed to verified Archive Button.");
            reportLog( "Successfully verified Archive Button.");

            libraryPage.clickOnArchive();

            Assert.assertTrue(libraryPage.isArchivedSuccessMessageDisplaying(), "Failed to verified Archive Success Message.");
            reportLog( "Successfully verified Archive Success Message.");
            logger.info("Successfully verified Archive Success Message.");

            Assert.assertTrue(libraryPage.verifyOkArchiveButton(), "Failed to verified Ok Archive Button.");
            reportLog( "Successfully verified Ok Archive Button.");

            libraryPage.clickOnOK();

        } catch (Exception e) {
            result = handleException(e);
        }
        Assert.assertTrue(result, "Failed To Verify" + errorMessage);
    }
}
