package testscripts.regression.teacherlogin.ReportFeature.CreateAssignmentFeature;

import com.relevantcodes.extentreports.LogStatus;
import org.apache.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.Test;
import testscripts.BaseTestScript;
import uipages.flexbook2feature.*;
import uipages.reports2feature.AssignAndCloseFeatureOnAssignment;
import uipages.reports2feature.AvailableAssignmentFeature;
import uipages.reports2feature.CreateAnAssignment;

public class AvailableAssignmentFeatureTest extends BaseTestScript {
    private static final Logger logger = Logger.getLogger(AvailableAssignmentFeatureTest.class);
    private String testCaseFailureText = "Test failed for method: ";
    private String assertFailurePreText = "Failed to verify: ";
    public String assertSuccessPreText = "Successfully verified: ";



    @Test(priority = 1, dataProvider = "CK12DataProvider", description = "Verify the Functionality Of 'Available Assignment' Tab After Clicking on Assignment Button")
    public void verifyFunctionalityOfAvailableAssignmentTab(String email, String password) {
        String assignmentURL = "https://master.ck12.org/group-assignments/632826";
        boolean result = true;
        try {
            TeacherDashboardPage teacherDashboardPage = new TeacherDashboardPage(webDriver,extentTest,extentReports);
            PageMenuTab pageMenuTab = new PageMenuTab(webDriver,extentTest,extentReports);
            AssignAndCloseFeatureOnAssignment assignAndCloseFeatureOnAssignment = new AssignAndCloseFeatureOnAssignment(webDriver,extentTest,extentReports);
            AvailableAssignmentFeature availableAssignmentFeature = new AvailableAssignmentFeature(webDriver,extentTest,extentReports);

            new LoginPage(webDriver,extentTest, extentReports).teacherLogin(email, password);

            String assertTextVTPOG = "Teacher profile icon after login";
            Assert.assertTrue(teacherDashboardPage.verifyTeacherProfileOnGamma(), assertFailurePreText + assertTextVTPOG);
            reportLog(assertTextVTPOG);

            pageMenuTab.clickOnClassesTab();

            webDriver.navigate().to(assignmentURL);

            String assertTextVCAB = "Presence Of Create assignment button.";
            Assert.assertTrue(assignAndCloseFeatureOnAssignment.verifyCreateAssignmentButton(), assertFailurePreText + assertTextVCAB);
            reportLog(assertTextVCAB);

            availableAssignmentFeature.clickOnAvailableAssignmentTab();

            String assertTextVCABA = "Presence Of Create assignment button.";
            Assert.assertTrue(assignAndCloseFeatureOnAssignment.verifyCreateAssignmentButton(), assertFailurePreText + assertTextVCABA);
            reportLog(assertTextVCABA);

        } catch (Exception e) {
            result = handleException(e);
        }
        Assert.assertTrue(result, testCaseFailureText + currentMethodName + errorMessage);
    }

    @Test(priority = 3, description = "Verify the Functionality Of 'Status' DropDown After Clicking On Available Assignment Button")
    public void verifyFunctionalityOfStatusDropDown() {
        boolean result = true;
        try {
            AvailableAssignmentFeature availableAssignmentFeature = new AvailableAssignmentFeature(webDriver,extentTest,extentReports);

            String assertTextVSD = "Presence Of Status DropDown.";
            Assert.assertTrue(availableAssignmentFeature.verifyStatusDropDown(), assertFailurePreText + assertTextVSD);
            reportLog(assertTextVSD);

            availableAssignmentFeature.clickOnStatusDropDown();

            String assertTextVPUAL = "Presence Of UnAssign Link.";
            Assert.assertTrue(availableAssignmentFeature.verifyUnAssignLink(), assertFailurePreText + assertTextVPUAL);
            reportLog(assertTextVPUAL);

            String assertTextVPAL = "Presence Of Assign Link.";
            Assert.assertTrue(availableAssignmentFeature.verifyAssignLink(), assertFailurePreText + assertTextVPAL);
            reportLog(assertTextVPAL);

        } catch (Exception e) {
            result = handleException(e);
        }
        Assert.assertTrue(result, testCaseFailureText + currentMethodName + errorMessage);
    }

    @Test(priority = 5, description = "Verify the Functionality Of 'UnAssign' Link After Clicking On Status DropDown")
    public void verifyFunctionalityOfUnAssignLink() {
        boolean result = true;
        try {
            AvailableAssignmentFeature availableAssignmentFeature = new AvailableAssignmentFeature(webDriver,extentTest,extentReports);

            availableAssignmentFeature.clickOnUnAssignLink();

            String assertTextVAAT = "Presence Of Available Assignment Tab.";
            Assert.assertTrue(availableAssignmentFeature.verifyAvailableAssignmentTab(), assertFailurePreText + assertTextVAAT);
            reportLog(assertTextVAAT);

            availableAssignmentFeature.getCountOfAssignmentForUnAssign();

            String assertTextVCOA = "Count Of Assignment In Available Assignment Page.";
            Assert.assertTrue(availableAssignmentFeature.verifyCountOfAssignment(), assertFailurePreText + assertTextVCOA);
            reportLog(assertTextVCOA);

        } catch (Exception e) {
            result = handleException(e);
        }
        Assert.assertTrue(result, testCaseFailureText + currentMethodName + errorMessage);
    }

    @Test(priority = 7, description = "Verify the Functionality Of 'Sort By ' DropDown After Clicking On UnAssign Link")
    public void verifyFunctionalityOfSortByDropDown() {
        boolean result = true;
        try {
            AvailableAssignmentFeature availableAssignmentFeature = new AvailableAssignmentFeature(webDriver,extentTest,extentReports);

            availableAssignmentFeature.clickOnSortByDropDown();

            String assertTextVLCDL = "Presence Of Latest Creation Date Link.";
            Assert.assertTrue(availableAssignmentFeature.verifyLatestCreationDateLink(), assertFailurePreText + assertTextVLCDL);
            reportLog(assertTextVLCDL);

            String assertTextVECDL = "Presence Of Earliest Creation Date Link.";
            Assert.assertTrue(availableAssignmentFeature.verifyEarliestCreationDateLink(), assertFailurePreText + assertTextVECDL);
            reportLog(assertTextVECDL);

            String assertTextVAAL = "Presence Of Alphabetical Link.";
            Assert.assertTrue(availableAssignmentFeature.verifyAlphabeticalLink(), assertFailurePreText + assertTextVAAL);
            reportLog(assertTextVAAL);

        } catch (Exception e) {
            result = handleException(e);
        }
        Assert.assertTrue(result, testCaseFailureText + currentMethodName + errorMessage);
    }

    @Test(priority = 9, description = "Verify the Functionality Of 'Latest Creation Date' Link  After Clicking On UnAssign Link")
    public void verifyFunctionalityOfLatestCreationDateLink() {
        boolean result = true;
        try {
            AvailableAssignmentFeature availableAssignmentFeature = new AvailableAssignmentFeature(webDriver,extentTest,extentReports);

            availableAssignmentFeature.clickOnLatestCreationDateLink();

            String assertTextVAAT = "Presence Of Available Assignment Tab.";
            Assert.assertTrue(availableAssignmentFeature.verifyAvailableAssignmentTab(), assertFailurePreText + assertTextVAAT);
            reportLog(assertTextVAAT);

            String assertTextVFAFLCD = "Text Of First Assignment for Latest Creation Date Link.";
            Assert.assertTrue(availableAssignmentFeature.verifyTextOfFirstAssignmentForLatestCreationDate(), assertFailurePreText + assertTextVFAFLCD);
            reportLog(assertTextVFAFLCD);


        } catch (Exception e) {
            result = handleException(e);
        }
        Assert.assertTrue(result, testCaseFailureText + currentMethodName + errorMessage);
    }

    @Test(priority = 11, description = "Verify the Functionality Of 'Earliest Creation Date' Link  After Clicking On UnAssign Link")
    public void verifyFunctionalityOfEarliestCreationDateLink() {
        boolean result = true;
        try {
            AvailableAssignmentFeature availableAssignmentFeature = new AvailableAssignmentFeature(webDriver,extentTest,extentReports);

            availableAssignmentFeature.clickOnSortByDropDown();
            availableAssignmentFeature.clickOnEarliestCreationDateLink();

            String assertTextVAAT = "Presence Of Available Assignment Tab.";
            Assert.assertTrue(availableAssignmentFeature.verifyAvailableAssignmentTab(), assertFailurePreText + assertTextVAAT);
            reportLog(assertTextVAAT);

            String assertTextVFAFECD = "Text Of First Assignment for Earliest Creation Date Link.";
            Assert.assertTrue(availableAssignmentFeature.verifyTextOfFirstAssignmentForEarliestCreationDate(), assertFailurePreText + assertTextVFAFECD);
            reportLog(assertTextVFAFECD);

        } catch (Exception e) {
            result = handleException(e);
        }
        Assert.assertTrue(result, testCaseFailureText + currentMethodName + errorMessage);
    }

    @Test(priority = 13, description = "Verify the Functionality Of 'Alphabetical' Link  After Clicking On UnAssign Link")
    public void verifyFunctionalityOfAlphabeticalLink() {
        boolean result = true;
        try {
            AvailableAssignmentFeature availableAssignmentFeature = new AvailableAssignmentFeature(webDriver,extentTest,extentReports);

            availableAssignmentFeature.clickOnSortByDropDown();
            availableAssignmentFeature.clickOnAlphabeticalLink();

            String assertTextVAAT = "Presence Of Available Assignment Tab.";
            Assert.assertTrue(availableAssignmentFeature.verifyAvailableAssignmentTab(), assertFailurePreText + assertTextVAAT);
            reportLog(assertTextVAAT);

            String assertTextVFAFAL = "Text Of First Assignment forAlphabetical Link.";
            Assert.assertTrue(availableAssignmentFeature.verifyTextOfFirstAssignmentForAlphabetical(), assertFailurePreText + assertTextVFAFAL);
            reportLog(assertTextVFAFAL);

        } catch (Exception e) {
            result = handleException(e);
        }
        Assert.assertTrue(result, testCaseFailureText + currentMethodName + errorMessage);
    }

    @Test(priority = 15, description = "Verify the Functionality Of 'Assign' Link  After Clicking On Status DropDown")
    public void verifyFunctionalityOfAssignLink() {
        boolean result = true;
        try {
            AvailableAssignmentFeature availableAssignmentFeature = new AvailableAssignmentFeature(webDriver,extentTest,extentReports);

            availableAssignmentFeature.clickOnStatusDropDown();

            String assertTextVAL = "Presence Of Assign Link.";
            Assert.assertTrue(availableAssignmentFeature.verifyAssignLink(), assertFailurePreText + assertTextVAL);
            reportLog(assertTextVAL);

            availableAssignmentFeature.clickOnAssignLink();

            String assertTextVAAT = "Presence Of Available Assignment Tab.";
            Assert.assertTrue(availableAssignmentFeature.verifyAvailableAssignmentTab(), assertFailurePreText + assertTextVAAT);
            reportLog(assertTextVAAT);

            availableAssignmentFeature.getCountOfAssignmentForAssign();

            String assertTextVCOA = "Count Of Assignment In Available Assignment Page.";
            Assert.assertTrue(availableAssignmentFeature.verifyCountOfAssignment(), assertFailurePreText + assertTextVCOA);
            reportLog(assertTextVCOA);

        } catch (Exception e) {
            result = handleException(e);
        }
        Assert.assertTrue(result, testCaseFailureText + currentMethodName + errorMessage);
    }

    @Test(priority = 17, description = "Verify the Functionality Of 'Sort By' DropDown  After Clicking On Status DropDown")
    public void verifyFunctionalityOfSortBy() {
        boolean result = true;
        try {
            AvailableAssignmentFeature availableAssignmentFeature = new AvailableAssignmentFeature(webDriver,extentTest,extentReports);
            AssignAndCloseFeatureOnAssignment assignAndCloseFeatureOnAssignment = new AssignAndCloseFeatureOnAssignment(webDriver,extentTest,extentReports);

            assignAndCloseFeatureOnAssignment.scrollDownScreen();
            availableAssignmentFeature.clickOnAssignSortByDropDown();

            String assertTextVLDDL = "Presence Of Latest Due Date Link.";
            Assert.assertTrue(availableAssignmentFeature.verifyLatestDueDateLink(), assertFailurePreText + assertTextVLDDL);
            reportLog(assertTextVLDDL);

            String assertTextVEDL = "Presence Of Earliest Due Date Link.";
            Assert.assertTrue(availableAssignmentFeature.verifyEarliestDueDateLink(), assertFailurePreText + assertTextVEDL);
            reportLog(assertTextVEDL);

            String assertTextVLSD = "Presence Of Latest Start Date Link.";
            Assert.assertTrue(availableAssignmentFeature.verifyLatestStartDateLink(), assertFailurePreText + assertTextVLSD);
            reportLog(assertTextVLSD);

            String assertTextVESD = "Presence Of Earliest Start Date Link.";
            Assert.assertTrue(availableAssignmentFeature.verifyEarliestStartDateLink(), assertFailurePreText + assertTextVESD);
            reportLog(assertTextVESD);

            String assertTextVLCD = "Presence Of Assign Latest Creation Date Link.";
            Assert.assertTrue(availableAssignmentFeature.verifyAssignLatestCreationDateLink(), assertFailurePreText + assertTextVLCD);
            reportLog(assertTextVLCD);

            String assertTextVECD = "Presence Of Earliest Creation Date Link.";
            Assert.assertTrue(availableAssignmentFeature.verifyAssignEarliestCreationDateLink(), assertFailurePreText + assertTextVECD);
            reportLog(assertTextVECD);

            String assertTextVAAL = "Presence Of Assign Alphabetical Date Link.";
            Assert.assertTrue(availableAssignmentFeature.verifyAssignAlphabeticalLink(), assertFailurePreText + assertTextVAAL);
            reportLog(assertTextVAAL);

        } catch (Exception e) {
            result = handleException(e);
        }
        Assert.assertTrue(result, testCaseFailureText + currentMethodName + errorMessage);
    }

    @Test(priority = 19, description = "Verify the Functionality Of 'Latest Due Date' link  After Clicking On Assign Link")
    public void verifyFunctionalityOfLatestDueDateLink() {
        boolean result = true;
        try {
            AvailableAssignmentFeature availableAssignmentFeature = new AvailableAssignmentFeature(webDriver,extentTest,extentReports);

            availableAssignmentFeature.clickOnLatestDueDateLink();

            String assertTextVAAT = "Presence Of Available Assignment Tab.";
            Assert.assertTrue(availableAssignmentFeature.verifyAvailableAssignmentTab(), assertFailurePreText + assertTextVAAT);
            reportLog(assertTextVAAT);

            String assertTextVFAFLD = "Text Of First Assignment for Latest Due Date Link";
            Assert.assertTrue(availableAssignmentFeature.verifyTextOfFirstAssignmentForLatestDueDateLink(), assertFailurePreText + assertTextVFAFLD);
            reportLog(assertTextVFAFLD);

        } catch (Exception e) {
            result = handleException(e);
        }
        Assert.assertTrue(result, testCaseFailureText + currentMethodName + errorMessage);
    }

    @Test(priority = 21, description = "Verify the Functionality Of 'Earliest Due Date' link  After Clicking On Assign Link")
    public void verifyFunctionalityOfEarliestDueDateLink() {
        boolean result = true;
        try {
            AvailableAssignmentFeature availableAssignmentFeature = new AvailableAssignmentFeature(webDriver,extentTest,extentReports);

            availableAssignmentFeature.clickOnAssignSortByDropDown();
            availableAssignmentFeature.clickOnEarliestDueDateLink();

            String assertTextVAAT = "Presence Of Available Assignment Tab.";
            Assert.assertTrue(availableAssignmentFeature.verifyAvailableAssignmentTab(), assertFailurePreText + assertTextVAAT);
            reportLog(assertTextVAAT);

            String assertTextVFAFEDD = "Text Of First Assignment for Earliest Due Date Link";
            Assert.assertTrue(availableAssignmentFeature.verifyTextOfFirstAssignmentForEarliestDueDateLink(), assertFailurePreText + assertTextVFAFEDD);
            reportLog(assertTextVFAFEDD);

        } catch (Exception e) {
            result = handleException(e);
        }
        Assert.assertTrue(result, testCaseFailureText + currentMethodName + errorMessage);
    }

    @Test(priority = 23, description = "Verify the Functionality Of 'Earliest Start Date' link  After Clicking On Assign Link")
    public void verifyFunctionalityOfEarliestStartDateLink() {
        boolean result = true;
        try {
            AvailableAssignmentFeature availableAssignmentFeature = new AvailableAssignmentFeature(webDriver,extentTest,extentReports);

            availableAssignmentFeature.clickOnAssignSortByDropDown();
            availableAssignmentFeature.clickOnEarliestStartDateLink();

            String assertTextVAAT = "Presence Of Available Assignment Tab.";
            Assert.assertTrue(availableAssignmentFeature.verifyAvailableAssignmentTab(), assertFailurePreText + assertTextVAAT);
            reportLog(assertTextVAAT);

            String assertTextVFAFEEDD = "Text Of First Assignment for Earliest Start Date Link";
            Assert.assertTrue(availableAssignmentFeature.verifyTextOfFirstAssignmentForEarliestStartDateLink(), assertFailurePreText + assertTextVFAFEEDD);
            reportLog(assertTextVFAFEEDD);

        } catch (Exception e) {
            result = handleException(e);
        }
        Assert.assertTrue(result, testCaseFailureText + currentMethodName + errorMessage);
    }

    @Test(priority = 25, description = "Verify the Functionality Of 'Latest Start Date' link  After Clicking On Assign Link")
    public void verifyFunctionalityOfLatestStartDateLink() {
        boolean result = true;
        try {
            AvailableAssignmentFeature availableAssignmentFeature = new AvailableAssignmentFeature(webDriver,extentTest,extentReports);

            availableAssignmentFeature.clickOnAssignSortByDropDown();
            availableAssignmentFeature.clickOnLatestStartDateLink();

            String assertTextVAAT = "Presence Of Available Assignment Tab.";
            Assert.assertTrue(availableAssignmentFeature.verifyAvailableAssignmentTab(), assertFailurePreText + assertTextVAAT);
            reportLog(assertTextVAAT);

            String assertTextVFAFLEDD = "Text Of First Assignment for Latest Start Date Link";
            Assert.assertTrue(availableAssignmentFeature.verifyTextOfFirstAssignmentForLatestStartDateLink(), assertFailurePreText + assertTextVFAFLEDD);
            reportLog(assertTextVFAFLEDD);

        } catch (Exception e) {
            result = handleException(e);
        }
        Assert.assertTrue(result, testCaseFailureText + currentMethodName + errorMessage);
    }

    @Test(priority = 26, description = "Verify the Functionality Of 'Assign Latest Creation Date' link  After Clicking On Assign Link")
    public void verifyFunctionalityOfAssignLatestCreationDateLink() {
        boolean result = true;
        try {
            AvailableAssignmentFeature availableAssignmentFeature = new AvailableAssignmentFeature(webDriver,extentTest,extentReports);

            availableAssignmentFeature.clickOnAssignSortByDropDown();
            availableAssignmentFeature.clickOnAssignLatestCreationDateLink();

            String assertTextVAAT = "Presence Of Available Assignment Tab.";
            Assert.assertTrue(availableAssignmentFeature.verifyAvailableAssignmentTab(), assertFailurePreText + assertTextVAAT);
            reportLog(assertTextVAAT);

            String assertTextVFAFLCDD = "Text Of First Assignment for Latest Creation Date Link";
            Assert.assertTrue(availableAssignmentFeature.verifyTextOfFirstAssignmentForAssignLatestCreationDateLink(), assertFailurePreText + assertTextVFAFLCDD);
            reportLog(assertTextVFAFLCDD);

        } catch (Exception e) {
            result = handleException(e);
        }
        Assert.assertTrue(result, testCaseFailureText + currentMethodName + errorMessage);
    }

    @Test(priority = 27, description = "Verify the Functionality Of 'Assign Earliest Creation Date' link  After Clicking On Assign Link")
    public void verifyFunctionalityOfAssignEarliestCreationDateLink() {
        boolean result = true;
        try {
            AvailableAssignmentFeature availableAssignmentFeature = new AvailableAssignmentFeature(webDriver,extentTest,extentReports);

            availableAssignmentFeature.clickOnAssignSortByDropDown();
            availableAssignmentFeature.clickOnAssignEarliestCreationDateLink();

            String assertTextVAAT = "Presence Of Available Assignment Tab.";
            Assert.assertTrue(availableAssignmentFeature.verifyAvailableAssignmentTab(), assertFailurePreText + assertTextVAAT);
            reportLog(assertTextVAAT);

            String assertTextVFAFLCDD = "Text Of First Assignment for Earliest Creation Date Link";
            Assert.assertTrue(availableAssignmentFeature.verifyTextOfFirstAssignmentForAssignEarliestCreationDateLink(), assertFailurePreText + assertTextVFAFLCDD);
            reportLog(assertTextVFAFLCDD);

        } catch (Exception e) {
            result = handleException(e);
        }
        Assert.assertTrue(result, testCaseFailureText + currentMethodName + errorMessage);
    }

    @Test(priority = 29, description = "Verify the Functionality Of 'Assign Alphabetical ' link  After Clicking On Assign Link")
    public void verifyFunctionalityOfAssignAlphabeticalLink() {
        boolean result = true;
        try {
            AvailableAssignmentFeature availableAssignmentFeature = new AvailableAssignmentFeature(webDriver,extentTest,extentReports);

            availableAssignmentFeature.clickOnAssignSortByDropDown();
            availableAssignmentFeature.clickOnAssignAlphabeticalLink();

            String assertTextVAAT = "Presence Of Available Assignment Tab.";
            Assert.assertTrue(availableAssignmentFeature.verifyAvailableAssignmentTab(), assertFailurePreText + assertTextVAAT);
            reportLog(assertTextVAAT);

            String assertTextVFAFLCDD = "Text Of First Assignment for Alphabetical Date Link";
            Assert.assertTrue(availableAssignmentFeature.verifyTextOfFirstAssignmentForAssignAlphabeticalLink(), assertFailurePreText + assertTextVFAFLCDD);
            reportLog(assertTextVFAFLCDD);

        } catch (Exception e) {
            result = handleException(e);
        }
        Assert.assertTrue(result, testCaseFailureText + currentMethodName + errorMessage);
    }
}