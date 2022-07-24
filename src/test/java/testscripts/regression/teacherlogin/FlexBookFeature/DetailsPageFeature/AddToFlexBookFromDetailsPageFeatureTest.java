package testscripts.regression.teacherlogin.FlexBookFeature.DetailsPageFeature;

import com.relevantcodes.extentreports.LogStatus;
import org.apache.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.Test;
import testscripts.BaseTestScript;
import uipages.flexbook2feature.CBookLandingPage;
import uipages.flexbook2feature.CBookOptionDropDownFeatures;
import uipages.flexbook2feature.CBookPageStudent;
import uipages.flexbook2feature.CourseBookDetailsPage;

public class AddToFlexBookFromDetailsPageFeatureTest extends BaseTestScript {
    private static final Logger logger = Logger.getLogger(AddToFlexBookFromDetailsPageFeatureTest.class);
    private String testCaseFailureText = "Test failed for method: ";
    private String assertFailurePreText = "Failed to verify: ";
    public String assertSuccessPreText = "Successfully verified: ";
    private CourseBookDetailsPage courseBookDetailsPage;
    private CBookOptionDropDownFeatures cBookOptionDropDownFeatures;
    public CBookLandingPage cBookLandingPage;

    @Test(priority = 1, dataProvider = "CK12DataProvider", description = "Verify Functionality Of 'Resume' dropdown.")
    public void verifyFunctionalityOfChooseDropDown(String email, String password, String url) {
        boolean result = true;
        try {
            CBookLandingPage cBookLandingPage = new CBookLandingPage(webDriver, extentTest, extentReports);
            CourseBookDetailsPage courseBookDetailsPage = new CourseBookDetailsPage(webDriver, extentTest, extentReports);

            webDriver.navigate().to(url);
            cBookLandingPage.clickOnTryItNow(email, password);
            courseBookDetailsPage.clickOnFirstFlexBook();

            String assertTextVAL = "Presence of the 'Author' link.";
            Assert.assertTrue(courseBookDetailsPage.verifyAuthorLink(), assertFailurePreText + assertTextVAL);
            reportLog(assertTextVAL);

            Assert.assertTrue(courseBookDetailsPage.verifyChooseButton(), "Test Script Field to Verify Choose Button");
            extentTest.log(LogStatus.PASS, "Teacher Successfully  Verify Choose Button");
            logger.info("Teacher Successfully verify Choose Button");

            courseBookDetailsPage.clickOnChooseButton();

            Assert.assertTrue(courseBookDetailsPage.verifyAssignButton(), "Test Script Field to Verify Assign Button");
            extentTest.log(LogStatus.PASS, "Teacher Successfully Verify Assign Button");
            logger.info("Teacher Successfully Verify Assign Button");

            String assertTextVSDB = "Presence of 'Add To FlexBook' Link.";
            Assert.assertTrue(courseBookDetailsPage.verifyAddToFlexBookLink(), assertFailurePreText + assertTextVSDB);
            reportLog(assertTextVSDB);

        } catch (Exception e) {
            result = handleException(e);
        }
        Assert.assertTrue(result, testCaseFailureText + currentMethodName + errorMessage);
    }

    @Test(priority = 7, description = "Verify the Functionality of 'Add To FlexBook' Button .")
    public void verifyFunctionalityOfAddToFlexBookButton() {
        boolean result = true;
        try {
            CourseBookDetailsPage courseBookDetailsPage = new CourseBookDetailsPage(webDriver, extentTest, extentReports);
            CBookOptionDropDownFeatures cBookOptionDropDownFeatures = new CBookOptionDropDownFeatures(webDriver, extentTest, extentReports);

            courseBookDetailsPage.clickOnAddToFlexBookLink();

            String assertTextVOB = "Presence of 'Ok' button.";
            Assert.assertTrue(cBookOptionDropDownFeatures.verifyOkayButton(), assertFailurePreText + assertTextVOB);
            reportLog(assertTextVOB);

        } catch (Exception e) {
            result = handleException(e);
        }
        Assert.assertTrue(result, testCaseFailureText + currentMethodName + errorMessage);
    }

    @Test(priority = 8, description = "Verify the Functionality of 'Cancel' Button After Clicking Add To FlexBook Button")
    public void verifyFunctionalityOfCancelButton() {
        boolean result = true;
        try {
            CourseBookDetailsPage courseBookDetailsPage = new CourseBookDetailsPage(webDriver, extentTest, extentReports);
            CBookOptionDropDownFeatures cBookOptionDropDownFeatures = new CBookOptionDropDownFeatures(webDriver, extentTest, extentReports);

            cBookOptionDropDownFeatures.clickOnCancelButton();

            String assertTextVAL = "Presence of the 'Author' link.";
            Assert.assertTrue(courseBookDetailsPage.verifyAuthorLink(), assertFailurePreText + assertTextVAL);
            reportLog(assertTextVAL);

            Assert.assertTrue(courseBookDetailsPage.verifyChooseButton(), "Test Script Field to Verify Choose Button");
            extentTest.log(LogStatus.PASS, "Teacher Successfully  Verify Choose Button");
            logger.info("Teacher Successfully verify Choose Button");

            courseBookDetailsPage.clickOnChooseButton();

            Assert.assertTrue(courseBookDetailsPage.verifyAssignButton(), "Test Script Field to Verify Assign Button");
            extentTest.log(LogStatus.PASS, "Teacher Successfully Verify Assign Button");
            logger.info("Teacher Successfully Verify Assign Button");

            String assertTextVSDB = "Presence of 'Add To FlexBook' Link.";
            Assert.assertTrue(courseBookDetailsPage.verifyAddToFlexBookLink(), assertFailurePreText + assertTextVSDB);
            reportLog(assertTextVSDB);

            courseBookDetailsPage.clickOnAddToFlexBookLink();

            String assertTextVOB = "Presence of 'Ok' button.";
            Assert.assertTrue(cBookOptionDropDownFeatures.verifyOkayButton(), assertFailurePreText + assertTextVOB);
            reportLog(assertTextVOB);

        } catch (Exception e) {
            result = handleException(e);
        }
        Assert.assertTrue(result, testCaseFailureText + currentMethodName + errorMessage);
    }

    @Test(priority = 11, description = "Verify the Functionality of 'Okay' Button Without Giving Title Of FlexBook")
    public void verifyFunctionalityOfOkayButtonWithoutGivingTitleOfFlexBook() {
        boolean result = true;
        try {
            CBookOptionDropDownFeatures cBookOptionDropDownFeatures = new CBookOptionDropDownFeatures(webDriver, extentTest, extentReports);

            cBookOptionDropDownFeatures.clickOnPlusIcon();

            String assertTextVPT = "Presence of 'Placeholder' text.";
            Assert.assertTrue(cBookOptionDropDownFeatures.verifyPlaceHolderText(), assertFailurePreText + assertTextVPT);
            reportLog(assertTextVPT);

            cBookOptionDropDownFeatures.clickOnOkayButton();

            String assertTextVOBA = "Presence of 'Ok' button.";
            Assert.assertTrue(cBookOptionDropDownFeatures.verifyOkButtonAgain(), assertFailurePreText + assertTextVOBA);
            reportLog(assertTextVOBA);

            cBookOptionDropDownFeatures.clickOnOkButtonAgain();

            String assertTextVOB = "Presence of 'Ok' button.";
            Assert.assertTrue(cBookOptionDropDownFeatures.verifyOkayButton(), assertFailurePreText + assertTextVOB);
            reportLog(assertTextVOB);

        } catch (Exception e) {
            result = handleException(e);
        }
        Assert.assertTrue(result, testCaseFailureText + currentMethodName + errorMessage);
    }

    @Test(priority = 12, description = "Verify the Functionality of 'Okay' Button After Giving Valid Name.")
    public void verifyFunctionalityOfOkayButtonWithValidName() {
        boolean result = true;
        try {
            CourseBookDetailsPage courseBookDetailsPage = new CourseBookDetailsPage(webDriver, extentTest, extentReports);
            CBookOptionDropDownFeatures cBookOptionDropDownFeatures = new CBookOptionDropDownFeatures(webDriver, extentTest, extentReports);

            String name = "FlexBook-";

            cBookOptionDropDownFeatures.setNameInPlaceHolder(name);
            cBookOptionDropDownFeatures.clickOnOkayButton();

            String assertTextVNTPH = "Presence of 'Name' of placeholder.";
            Assert.assertTrue(cBookOptionDropDownFeatures.verifyNameTextOfPlaceHolder(), assertFailurePreText + assertTextVNTPH);
            reportLog(assertTextVNTPH);

            String assertTextVODD = "Presence of 'Success' Text.";
            Assert.assertTrue(courseBookDetailsPage.verifySuccessText(), assertFailurePreText + assertTextVODD);
            reportLog(assertTextVODD);

        } catch (Exception e) {
            result = handleException(e);
        }
        Assert.assertTrue(result, testCaseFailureText + currentMethodName + errorMessage);
    }
}