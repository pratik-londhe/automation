package testscripts.regression.teacherlogin.FlexBookModalityFeature.OpenToolBarFeature;


// Test cases are blocked coz need seprate account and same student insight this

import com.relevantcodes.extentreports.LogStatus;
import org.apache.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.Test;
import testscripts.BaseTestScript;
import uipages.flexbook2feature.*;

public class InsightsFeatureTest extends BaseTestScript {
    private static final Logger logger = Logger.getLogger(OpenToolbarFeatureTest.class);
    private String testCaseFailureText = "Test failed for method: ";
    private String assertFailurePreText = "Failed to verify: ";
    private String assertSuccessPreText = "Successfully verified: ";



    @Test(priority = 1, dataProvider = "CK12DataProvider", description = "Verify Insight button is available inside the learning tool container.")
    public void verifyInsightsButtonIsVisible(String email, String password) {
        boolean result = true;
        try {
            CourseBookDetailsPage courseBookDetailsPage = new CourseBookDetailsPage(webDriver, extentTest, extentReports);
            CBookModalityPage cBookModalityPage = new CBookModalityPage(webDriver, extentTest, extentReports);
            OpenToolbarFeature openToolbarFeature = new OpenToolbarFeature(webDriver, extentTest, extentReports);


            courseBookDetailsPage.clickOnFirstCBookAndFurtherProcess(email, password);
            new CBookPrimaryConceptPage(webDriver, extentTest, extentReports).clickOnStart();

            /*Assert.assertTrue(cBookModalityPage.verifyAssignAssignmentButton(), "Test Script Field to verify Assign Pop Up");
            extentTest.log(LogStatus.PASS, "Teacher Successfully verify Assign Pop Up");
            logger.info("Teacher Successfully verify Assign Pop Up");*/

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

            /*String assertTextVLN = "Presence of 'Insights' Button.";
            Assert.assertTrue(insightsFeature.verifyInsightsButton(), assertFailurePreText + assertTextVLN);
            reportLog(assertTextVLN);*/

        } catch (Exception e) {
            result = handleException(e);
        }
        Assert.assertTrue(result, testCaseFailureText + currentMethodName + errorMessage);
    }

    // @Test(priority = 3, description = "Verify Functionality of Insight button.")
    public void verifyFunctionalityOfInsightsButton() {
        boolean result = true;
        try {
            InsightsFeature insightsFeature = new InsightsFeature(webDriver, extentTest, extentReports);

            insightsFeature.clickOnInsightsButton();

            String assertTextVTIA = "Presence of 'Insights' Text.";
            Assert.assertTrue(insightsFeature.verifyInsightsText(), assertFailurePreText + assertTextVTIA);
            reportLog(assertTextVTIA);

            String assertTextVLPC = "Presence of 'Group Class DropDown'.";
            Assert.assertTrue(insightsFeature.verifyGroupClassDropDown(), assertFailurePreText + assertTextVLPC);
            reportLog(assertTextVLPC);

        } catch (Exception e) {
            result = handleException(e);
        }
        Assert.assertTrue(result, testCaseFailureText + currentMethodName + errorMessage);
    }

    //@Test(priority = 5, description = "Verify Functionality of Back Insights Icon.")
    public void verifyFunctionalityOfBackInsightsIcon() {
        boolean result = true;
        try {
            InsightsFeature insightsFeature = new InsightsFeature(webDriver, extentTest, extentReports);
            OpenToolbarFeature openToolbarFeature = new OpenToolbarFeature(webDriver, extentTest, extentReports);

            String assertTextVTIA = "Presence of 'Back Insights' Icon.";
            Assert.assertTrue(insightsFeature.verifyBackInsightsIcon(), assertFailurePreText + assertTextVTIA);
            reportLog(assertTextVTIA);

            insightsFeature.clickOnBackInsightsIcon();

            String assertTextVTCN = "Presence of 'Toolbar' Text.";
            Assert.assertTrue(openToolbarFeature.verifyToolbarText(), assertFailurePreText + assertTextVTCN);
            reportLog(assertTextVTCN);

            String assertTextVLN = "Presence of 'Insights' Button.";
            Assert.assertTrue(insightsFeature.verifyInsightsButton(), assertFailurePreText + assertTextVLN);
            reportLog(assertTextVLN);

            insightsFeature.clickOnInsightsButton();

            String assertTextVLNC = "Presence of 'Insights' Text.";
            Assert.assertTrue(insightsFeature.verifyInsightsText(), assertFailurePreText + assertTextVLNC);
            reportLog(assertTextVLNC);

        } catch (Exception e) {
            result = handleException(e);
        }
        Assert.assertTrue(result, testCaseFailureText + currentMethodName + errorMessage);
    }

    //@Test(priority = 7, description = "Verify Functionality of Class group DropDown.")
    public void verifyFunctionalityOfClassGroupDropDown() {
        boolean result = true;
        try {
            InsightsFeature insightsFeature = new InsightsFeature(webDriver,extentTest,extentReports);

            String assertTextVLPC = "Presence of 'Group Class DropDown'.";
            Assert.assertTrue(insightsFeature.verifyGroupClassDropDown(), assertFailurePreText + assertTextVLPC);
            reportLog(assertTextVLPC);

            insightsFeature.clickOnGroupClassDropDown();

            String assertTextVTIA = "Presence of 'Group Classes Link' Icon.";
            Assert.assertTrue(insightsFeature.verifyGroupClassesLink(), assertFailurePreText + assertTextVTIA);
            reportLog(assertTextVTIA);

        } catch (Exception e) {
            result = handleException(e);
        }
        Assert.assertTrue(result, testCaseFailureText + currentMethodName + errorMessage);
    }

    //@Test(priority = 9, description = "Verify Selected class are Are redirecting Current status of class.")
    public void verifyFunctionalityOfClassLink() {
        boolean result = true;
        try {
            InsightsFeature insightsFeature = new InsightsFeature(webDriver,extentTest,extentReports);

            String assertTextVLPC = "Presence of 'Class With Assignment' link.";
            Assert.assertTrue(insightsFeature.verifyClassWithAssignmentLink(), assertFailurePreText + assertTextVLPC);
            reportLog(assertTextVLPC);

            insightsFeature.clickOnClassWithAssignmentLink();

            String assertTextVLNC = "Presence of 'Insights' Text.";
            Assert.assertTrue(insightsFeature.verifyInsightsText(), assertFailurePreText + assertTextVLNC);
            reportLog(assertTextVLNC);

            String assertTextVTCN = "Presence of 'Sort By ' DropDown.";
            Assert.assertTrue(insightsFeature.verifySortByDropDown(), assertFailurePreText + assertTextVTCN);
            reportLog(assertTextVTCN);

        } catch (Exception e) {
            result = handleException(e);
        }
        Assert.assertTrue(result, testCaseFailureText + currentMethodName + errorMessage);
    }

    //@Test(priority = 11, description = "Verify Functionality of Sort by dropDown.")
    public void verifyFunctionalityOfSortByDropDown() {
        boolean result = true;
        try {
            InsightsFeature insightsFeature = new InsightsFeature(webDriver,extentTest,extentReports);

            insightsFeature.clickOnSortByDropDown();

            String assertTextVLPC = "Presence of 'Class With Assignment' link.";
            Assert.assertTrue(insightsFeature.verifyPerformanceHighToLowLink(), assertFailurePreText + assertTextVLPC);
            reportLog(assertTextVLPC);

            String assertTextVTIA = "Presence of 'Alphabetical A to Z' link.";
            Assert.assertTrue(insightsFeature.verifyAlphabeticalAToZLink(), assertFailurePreText + assertTextVTIA);
            reportLog(assertTextVTIA);

            String assertTextVLN = "Presence of 'Alphabetical Z to A' link.";
            Assert.assertTrue(insightsFeature.verifyAlphabeticalZToALink(), assertFailurePreText + assertTextVLN);
            reportLog(assertTextVLN);

        } catch (Exception e) {
            result = handleException(e);
        }
        Assert.assertTrue(result, testCaseFailureText + currentMethodName + errorMessage);
    }

    // @Test(priority = 13, description = "Verify Functionality of Performance Low to high link.")
    public void verifyFunctionalityOfPerformanceLowToHighLink() {
        boolean result = true;
        try {
            InsightsFeature insightsFeature = new InsightsFeature(webDriver,extentTest,extentReports);

            String assertTextVLNC = "Presence of 'Performance Low To High' link.";
            Assert.assertTrue(insightsFeature.verifyPerformanceLowToHighLink(), assertFailurePreText + assertTextVLNC);
            reportLog(assertTextVLNC);

            insightsFeature.clickOnPerformanceLowToHighLink();

            String assertTextVNC = "Presence of 'Insights' Text.";
            Assert.assertTrue(insightsFeature.verifyInsightsText(), assertFailurePreText + assertTextVNC);
            reportLog(assertTextVNC);

            String assertTextVLP = "Performance Low To High Sort By Is Selected";
            Assert.assertTrue(insightsFeature.verifyPerformanceLowToHighSortByIsSelected(), assertFailurePreText + assertTextVLP);
            reportLog(assertTextVLP);

            String assertTextVC = "Presence of 'First Student After Selecting Performance Low To High'.";
            Assert.assertTrue(insightsFeature.verifyFirstStudentAfterSelectingPerformanceLowToHigh(), assertFailurePreText + assertTextVC);
            reportLog(assertTextVC);

        } catch (Exception e) {
            result = handleException(e);
        }
        Assert.assertTrue(result, testCaseFailureText + currentMethodName + errorMessage);
    }

    // @Test(priority = 15, description = "Verify Functionality of Performance High to Low link.")
    public void verifyFunctionalityOfPerformanceHighToLinkLink() {
        boolean result = true;
        try {
            InsightsFeature insightsFeature = new InsightsFeature(webDriver,extentTest,extentReports);

            String assertTextVTCN = "Presence of 'Sort By ' DropDown.";
            Assert.assertTrue(insightsFeature.verifySortByDropDown(), assertFailurePreText + assertTextVTCN);
            reportLog(assertTextVTCN);

            insightsFeature.clickOnSortByDropDown();

            String assertTextVLPC = "Presence of 'Class With Assignment' link.";
            Assert.assertTrue(insightsFeature.verifyPerformanceHighToLowLink(), assertFailurePreText + assertTextVLPC);
            reportLog(assertTextVLPC);

            insightsFeature.clickOnPerformanceHighToLowLink();

            String assertTextVNC = "Presence of 'Insights' Text.";
            Assert.assertTrue(insightsFeature.verifyInsightsText(), assertFailurePreText + assertTextVNC);
            reportLog(assertTextVNC);

            String assertTextVLP = "Performance High To Low Sort By Is Selected";
            Assert.assertTrue(insightsFeature.verifyPerformanceHighToLowSortByIsSelected(), assertFailurePreText + assertTextVLP);
            reportLog(assertTextVLP);

            String assertTextVC = "Presence of 'First Student After Selecting Performance High To Low'.";
            Assert.assertTrue(insightsFeature.verifyFirstStudentAfterSelectingPerformanceHighToLow(), assertFailurePreText + assertTextVC);
            reportLog(assertTextVC);

        } catch (Exception e) {
            result = handleException(e);
        }
        Assert.assertTrue(result, testCaseFailureText + currentMethodName + errorMessage);
    }

    //@Test(priority = 17, description = "Verify the Functionality of Alphabetical A-Z link.")
    public void verifyFunctionalityOfAlphabeticalAToZLink() {
        boolean result = true;
        try {
            InsightsFeature insightsFeature = new InsightsFeature(webDriver,extentTest,extentReports);

            String assertTextVTCN = "Presence of 'Sort By ' DropDown.";
            Assert.assertTrue(insightsFeature.verifySortByDropDown(), assertFailurePreText + assertTextVTCN);
            reportLog(assertTextVTCN);

            insightsFeature.clickOnSortByDropDown();

            String assertTextVTIA = "Presence of 'Alphabetical A to Z' link.";
            Assert.assertTrue(insightsFeature.verifyAlphabeticalAToZLink(), assertFailurePreText + assertTextVTIA);
            reportLog(assertTextVTIA);

            insightsFeature.clickOnAlphabeticalAToZLink();

            String assertTextVNC = "Presence of 'Insights' Text.";
            Assert.assertTrue(insightsFeature.verifyInsightsText(), assertFailurePreText + assertTextVNC);
            reportLog(assertTextVNC);

            String assertTextVLP = "Alphabetical A To Z Sort By Is Selected";
            Assert.assertTrue(insightsFeature.verifyAlphabeticalAtoZSortByIsSelected(), assertFailurePreText + assertTextVLP);
            reportLog(assertTextVLP);

            String assertTextVC = "Presence of 'First Student After Selecting Alphabetical A To Z'.";
            Assert.assertTrue(insightsFeature.verifyFirstStudentAfterSelectingAlphabeticalAtoZ(), assertFailurePreText + assertTextVC);
            reportLog(assertTextVC);

        } catch (Exception e) {
            result = handleException(e);
        }
        Assert.assertTrue(result, testCaseFailureText + currentMethodName + errorMessage);
    }

    // @Test(priority = 19, description = "Verify the Functionality of Alphabetical Z-A link.")
    public void verifyFunctionalityOfAlphabeticalZToALink() {
        boolean result = true;
        try {
            InsightsFeature insightsFeature = new InsightsFeature(webDriver,extentTest,extentReports);

            String assertTextVTCN = "Presence of 'Sort By ' DropDown.";
            Assert.assertTrue(insightsFeature.verifySortByDropDown(), assertFailurePreText + assertTextVTCN);
            reportLog(assertTextVTCN);

            insightsFeature.clickOnSortByDropDown();

            String assertTextVLN = "Presence of 'Alphabetical Z to A' link.";
            Assert.assertTrue(insightsFeature.verifyAlphabeticalZToALink(), assertFailurePreText + assertTextVLN);
            reportLog(assertTextVLN);

            insightsFeature.clickOnAlphabeticalZToALink();

            String assertTextVNC = "Presence of 'Insights' Text.";
            Assert.assertTrue(insightsFeature.verifyInsightsText(), assertFailurePreText + assertTextVNC);
            reportLog(assertTextVNC);

            String assertTextVLP = "Alphabetical Z To A Sort By Is Selected";
            Assert.assertTrue(insightsFeature.verifyAlphabeticalZtoASortByIsSelected(), assertFailurePreText + assertTextVLP);
            reportLog(assertTextVLP);

            String assertTextVC = "Presence of 'First Student After Selecting Alphabetical Z To A'.";
            Assert.assertTrue(insightsFeature.verifyFirstStudentAfterSelectingAlphabeticalZtoA(), assertFailurePreText + assertTextVC);
            reportLog(assertTextVC);

        } catch (Exception e) {
            result = handleException(e);
        }
        Assert.assertTrue(result, testCaseFailureText + currentMethodName + errorMessage);
    }

    // @Test(priority = 23, description = "Verify Sort by dropDown is not available when the assignment is not assigned in class.")
    public void verifyFunctionalityOfClassWithoutAssignment() {
        boolean result = true;
        try {
            InsightsFeature insightsFeature = new InsightsFeature(webDriver,extentTest,extentReports);

            String assertTextVLPC = "Presence of 'Group Class DropDown'.";
            Assert.assertTrue(insightsFeature.verifyGroupClassDropDown(), assertFailurePreText + assertTextVLPC);
            reportLog(assertTextVLPC);

            insightsFeature.clickOnGroupClassDropDown();

            String assertTextVTIA = "Presence of 'Group Classes Link' Icon.";
            Assert.assertTrue(insightsFeature.verifyGroupClassesLink(), assertFailurePreText + assertTextVTIA);
            reportLog(assertTextVTIA);

            String assertTextVTCN = "Presence of 'Class Without Assignment' Link.";
            Assert.assertTrue(insightsFeature.verifyClassWithoutAssignmentLink(), assertFailurePreText + assertTextVTCN);
            reportLog(assertTextVTCN);

        } catch (Exception e) {
            result = handleException(e);
        }
        Assert.assertTrue(result, testCaseFailureText + currentMethodName + errorMessage);
    }

    //@Test(priority = 25, description = "Verify Message is display If Assignment Is not assign in the class.")
    public void verifyMessageIsDisplay() {
        boolean result = true;
        try {
            InsightsFeature insightsFeature = new InsightsFeature(webDriver,extentTest,extentReports);

            insightsFeature.clickOnClassWithoutAssignmentLink();

            String assertTextVNC = "Presence of 'Insights' Text.";
            Assert.assertTrue(insightsFeature.verifyInsightsText(), assertFailurePreText + assertTextVNC);
            reportLog(assertTextVNC);

//            String assertTextVLN = "Not Presence of 'Sort By DropDown'.";
////            Assert.assertTrue(insightsFeature.verifySortByDropDownIsNotPresent(), assertFailurePreText + assertTextVLN);
////            reportLog(assertTextVLN);

            String assertTextVLNC = "Presence of 'Need To Assign' Text.";
            Assert.assertTrue(insightsFeature.verifyNeedToAssignText(), assertFailurePreText + assertTextVLNC);
            reportLog(assertTextVLNC);

        } catch (Exception e) {
            result = handleException(e);
        }
        Assert.assertTrue(result, testCaseFailureText + currentMethodName + errorMessage);
    }
}