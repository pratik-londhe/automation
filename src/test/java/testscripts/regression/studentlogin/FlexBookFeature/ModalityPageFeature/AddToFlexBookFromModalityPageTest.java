package testscripts.regression.studentlogin.FlexBookFeature.ModalityPageFeature;

import com.relevantcodes.extentreports.LogStatus;
import org.apache.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.Test;
import testscripts.BaseTestScript;
import uipages.flexbook2feature.*;

public class AddToFlexBookFromModalityPageTest  extends BaseTestScript {
    private static final Logger logger = Logger.getLogger(AddToFlexBookFromModalityPageTest.class);
    private String testCaseFailureText = "Test failed for method: ";
    private String assertFailurePreText = "Failed to verify: ";
    private String assertSuccessPreText = "Successfully verified: ";

    @Test(priority = 1, dataProvider = "CK12DataProvider", description = "Verify Add to flexbook button is available inside action Categary.")
    public void verifyAddToFlexBookButtonIsAvailable(String email, String Password) {
        boolean result = true;
        try {
            CBookModalityPage cBookModalityPage = new CBookModalityPage(webDriver,extentTest,extentReports);
            CBookPageStudent cBookPageStudent = new CBookPageStudent(webDriver,extentTest,extentReports);
            OpenToolbarFeature openToolbarFeature = new OpenToolbarFeature(webDriver,extentTest,extentReports);
            CourseBookDetailsPage courseBookDetailsPage = new CourseBookDetailsPage(webDriver,extentTest,extentReports);

            cBookPageStudent.clickOnTryItNowPopUp(email, Password);
            courseBookDetailsPage.clickOnFirstFlexBook();

            String assertTextVSCDB = "Presence of 'Start Course Details' button.";
            Assert.assertTrue(cBookPageStudent.verifyStartCourseDetailsButton(), assertFailurePreText + assertTextVSCDB);
            reportLog(assertTextVSCDB);

            cBookPageStudent.clickOnStartCourseDetailButton();
            new CBookPrimaryConceptPage(webDriver,extentTest,extentReports).clickOnStart();

            String assertTextVLNC = "Presence of 'Next Concept' link.";
            Assert.assertTrue(cBookModalityPage.verifyLinkOfNextConcept(), assertFailurePreText + assertTextVLNC);
            reportLog(assertTextVLNC);

            String assertTextVTI = "Presence of 'Open' Button.";
            Assert.assertTrue(openToolbarFeature.verifyOpenButton(), assertFailurePreText + assertTextVTI);
            reportLog(assertTextVTI);

            openToolbarFeature.clickOnOpenButton();

            String assertTextVTIA = "Presence of 'Toolbar' Text.";
            Assert.assertTrue(openToolbarFeature.verifyToolbarText(), assertFailurePreText + assertTextVTIA);
            reportLog(assertTextVTIA);

            String assertTextVLN = "Presence of 'Add To FlexBook' Button.";
            Assert.assertTrue(openToolbarFeature.verifyAddToFlexBookButton(), assertFailurePreText + assertTextVLN);
            reportLog(assertTextVLN);

        } catch (Exception e) {
            result = handleException(e);
        }
        Assert.assertTrue(result, testCaseFailureText + currentMethodName + errorMessage);
    }

    @Test(priority = 3, description = "Verify the Functionality of 'Add To FlexBook' Button After Clicking Option DropDown")
    public void verifyFunctionalityOfAddToFlexBookButton() {
        boolean result = true;
        try {
            CBookOptionDropDownFeatures cBookOptionDropDownFeatures = new CBookOptionDropDownFeatures(webDriver,extentTest,extentReports);
            OpenToolbarFeature openToolbarFeature = new OpenToolbarFeature(webDriver,extentTest,extentReports);

            openToolbarFeature.clickOnAddToFlexBookButton();

            String assertTextVOB = "Presence of 'Ok' button.";
            Assert.assertTrue(cBookOptionDropDownFeatures.verifyOkayButton(), assertFailurePreText + assertTextVOB);
            reportLog(assertTextVOB);

            String assertTextVODD = "Presence of 'Close Add To FlexBook' Icon.";
            Assert.assertTrue(openToolbarFeature.verifyCloseAddToFlexBookIcon(), assertFailurePreText + assertTextVODD);
            reportLog(assertTextVODD);

        } catch (Exception e) {
            result = handleException(e);
        }
        Assert.assertTrue(result, testCaseFailureText + currentMethodName + errorMessage);
    }

    @Test(priority = 5, description = "Verify the Functionality of 'Close Add To FlexBook' Icon.")
    public void verifyFunctionalityOfCloseAddToFlexBookIcon() {
        boolean result = true;
        try {
            CBookOptionDropDownFeatures cBookOptionDropDownFeatures = new CBookOptionDropDownFeatures(webDriver,extentTest,extentReports);
            OpenToolbarFeature openToolbarFeature = new OpenToolbarFeature(webDriver,extentTest,extentReports);

            openToolbarFeature.clickOnCloseAddToFlexBookIcon();

            String assertTextVTI = "Presence of 'Open' Button.";
            Assert.assertTrue(openToolbarFeature.verifyOpenButton(), assertFailurePreText + assertTextVTI);
            reportLog(assertTextVTI);

            openToolbarFeature.clickOnOpenButton();

            String assertTextVTIA = "Presence of 'Toolbar' Text.";
            Assert.assertTrue(openToolbarFeature.verifyToolbarText(), assertFailurePreText + assertTextVTIA);
            reportLog(assertTextVTIA);

            String assertTextVLN = "Presence of 'Add To FlexBook' Button.";
            Assert.assertTrue(openToolbarFeature.verifyAddToFlexBookButton(), assertFailurePreText + assertTextVLN);
            reportLog(assertTextVLN);

            openToolbarFeature.clickOnAddToFlexBookButton();

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
            CBookOptionDropDownFeatures cBookOptionDropDownFeatures = new CBookOptionDropDownFeatures(webDriver,extentTest,extentReports);
            OpenToolbarFeature openToolbarFeature = new OpenToolbarFeature(webDriver,extentTest,extentReports);

            cBookOptionDropDownFeatures.clickOnCancelButton();

            String assertTextVTI = "Presence of 'Open' Button.";
            Assert.assertTrue(openToolbarFeature.verifyOpenButton(), assertFailurePreText + assertTextVTI);
            reportLog(assertTextVTI);

            openToolbarFeature.clickOnOpenButton();

            String assertTextVTIA = "Presence of 'Toolbar' Text.";
            Assert.assertTrue(openToolbarFeature.verifyToolbarText(), assertFailurePreText + assertTextVTIA);
            reportLog(assertTextVTIA);

            String assertTextVLN = "Presence of 'Add To FlexBook' Button.";
            Assert.assertTrue(openToolbarFeature.verifyAddToFlexBookButton(), assertFailurePreText + assertTextVLN);
            reportLog(assertTextVLN);

            openToolbarFeature.clickOnAddToFlexBookButton();

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
            CBookOptionDropDownFeatures cBookOptionDropDownFeatures = new CBookOptionDropDownFeatures(webDriver,extentTest,extentReports);
            OpenToolbarFeature openToolbarFeature = new OpenToolbarFeature(webDriver,extentTest,extentReports);

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

    @Test(priority = 12, description = "Verify the Functionality of 'Okay' Button After Giving Valid Name")
    public void verifyFunctionalityOfOkayButtonWithValidName() {
        boolean result = true;
        try {
            CBookOptionDropDownFeatures cBookOptionDropDownFeatures = new CBookOptionDropDownFeatures(webDriver,extentTest,extentReports);
            OpenToolbarFeature openToolbarFeature = new OpenToolbarFeature(webDriver,extentTest,extentReports);

            String name = "Pratik-";

            cBookOptionDropDownFeatures.setNameInPlaceHolder(name);
            cBookOptionDropDownFeatures.clickOnOkayButton();

            String assertTextVNTPH = "Presence of 'Name' of placeholder.";
            Assert.assertTrue(cBookOptionDropDownFeatures.verifyNameTextOfPlaceHolder(), assertFailurePreText + assertTextVNTPH);
            reportLog(assertTextVNTPH);

            cBookOptionDropDownFeatures.getNameOfCreatedFlexBook();
            cBookOptionDropDownFeatures.clickOnOkButtonAgain();

            String assertTextVTI = "Presence of 'Open' Button.";
            Assert.assertTrue(openToolbarFeature.verifyOpenButton(), assertFailurePreText + assertTextVTI);
            reportLog(assertTextVTI);

        } catch (Exception e) {
            result = handleException(e);
        }
        Assert.assertTrue(result, testCaseFailureText + currentMethodName + errorMessage);
    }
}