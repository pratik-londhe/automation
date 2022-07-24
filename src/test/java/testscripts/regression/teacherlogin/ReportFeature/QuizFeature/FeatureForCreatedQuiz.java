package testscripts.regression.teacherlogin.ReportFeature.QuizFeature;

import com.relevantcodes.extentreports.LogStatus;
import org.apache.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.Test;
import testscripts.BaseTestScript;
import uipages.flexbook2feature.*;
import uipages.reports2feature.AssignAndCloseFeatureOnAssignment;
import uipages.reports2feature.CreateAnAssignment;

public class FeatureForCreatedQuiz extends BaseTestScript {
    private static final Logger logger = Logger.getLogger(FeatureForCreatedQuiz.class);
    private String testCaseFailureText = "Test failed for method: ";
    private String assertFailurePreText = "Failed to verify: ";
    public String assertSuccessPreText = "Successfully verified: ";



    @Test(priority = 1, dataProvider = "CK12DataProvider", description = "Verify the Functionality Of 'Add A Quiz' icon after clicking on Create An Assignment Button")
    public void verifyFunctionalityOfAddAQuizButton(String email, String password) {
        String asssignmentURL = "https://master.ck12.org/group-assignments/617412";
        boolean result = true;
        try {
            TeacherDashboardPage teacherDashboardPage = new TeacherDashboardPage(webDriver,extentTest,extentReports);
            PageMenuTab pageMenuTab = new PageMenuTab(webDriver,extentTest,extentReports);
            CreateAnAssignment createAnAssignment = new CreateAnAssignment(webDriver,extentTest,extentReports);
            AssignAndCloseFeatureOnAssignment assignAndCloseFeatureOnAssignment = new AssignAndCloseFeatureOnAssignment(webDriver,extentTest,extentReports);

            new LoginPage(webDriver,extentTest, extentReports).teacherLogin(email, password);

            String assertTextVTPOG = "Teacher profile icon after login";
            Assert.assertTrue(teacherDashboardPage.verifyTeacherProfileOnGamma(), assertFailurePreText + assertTextVTPOG);
            reportLog(assertTextVTPOG);

            pageMenuTab.clickOnClassesTab();
            webDriver.navigate().to(asssignmentURL);
            String assertTextVCAB = "Presence Of Create assignment button.";
            Assert.assertTrue(assignAndCloseFeatureOnAssignment.verifyCreateAssignmentButton(), assertFailurePreText + assertTextVCAB);
            reportLog(assertTextVCAB);

            assignAndCloseFeatureOnAssignment.clickOnCreateAssignmentButton();
            createAnAssignment.clickOnIconCloseHeadsUp();

            String assertTextVCB = "Presence Of close button.";
            Assert.assertTrue(assignAndCloseFeatureOnAssignment.verifyCloseButton(), assertFailurePreText + assertTextVCB);
            reportLog(assertTextVCB);

            createAnAssignment.clickOnJoinPlusButton();

            String assertTextVCBA = "Presence Of close button.";
            Assert.assertTrue(assignAndCloseFeatureOnAssignment.verifyCloseButton(), assertFailurePreText + assertTextVCBA);
            reportLog(assertTextVCBA);

            String assertTextVSI = "Presence Of Search Icon.";
            Assert.assertTrue(assignAndCloseFeatureOnAssignment.verifySearchIcon(), assertFailurePreText + assertTextVSI);
            reportLog(assertTextVSI);

        } catch (Exception e) {
            result = handleException(e);
        }
        Assert.assertTrue(result, testCaseFailureText + currentMethodName + errorMessage);
    }

    @Test(priority = 3, description = "Verify the Functionality Of 'Select All' Button after clicking On Add A Quiz Icon")
    public void verifyFunctionalityOfSelectAllButton() {
        boolean result = true;
        try {
            SaveAndDeleteAssignment saveAndDeleteAssignment = new SaveAndDeleteAssignment(webDriver,extentTest,extentReports);
            Reports reports = new Reports(webDriver,extentTest,extentReports);

            /*String assertTextVSB = "Presence Of Select Button";
            Assert.assertTrue(saveAndDeleteAssignment.verifySelectButton(), assertFailurePreText + assertTextVSB);
            reportLog(assertTextVSB);*/

            saveAndDeleteAssignment.getCountOfUnSelectedCheckBox();
            saveAndDeleteAssignment.clickOnSelectButton();
            saveAndDeleteAssignment.getCountOfSelectedCheckBox();

            String assertTextVASP = "All Present Assignment Is Selected.";
            Assert.assertTrue(saveAndDeleteAssignment.verifyAllPresentAssignmentIsSelected(), assertFailurePreText + assertTextVASP);
            reportLog(assertTextVASP);

            String assertTextVSBB = "Presence Of Save Button.";
            Assert.assertTrue(reports.verifySaveButton(), assertFailurePreText + assertTextVSBB);
            reportLog(assertTextVSBB);

        } catch (Exception e) {
            result = handleException(e);
        }
        Assert.assertTrue(result, testCaseFailureText + currentMethodName + errorMessage);
    }

    @Test(priority = 5, description = "Verify the Functionality Of 'Select None' Button after clicking On Select All Button")
    public void verifyFunctionalityOfSelectNoneButton() {
        boolean result = true;
        try {
            AssignAndCloseFeatureOnAssignment assignAndCloseFeatureOnAssignment = new AssignAndCloseFeatureOnAssignment(webDriver,extentTest,extentReports);
            SaveAndDeleteAssignment saveAndDeleteAssignment = new SaveAndDeleteAssignment(webDriver,extentTest,extentReports);

            /*String assertTextVSB = "Presence Of Select Button";
            Assert.assertTrue(saveAndDeleteAssignment.verifySelectButton(), assertFailurePreText + assertTextVSB);
            reportLog(assertTextVSB);
*/
            saveAndDeleteAssignment.getCountOfSelectedCheckBox();
            saveAndDeleteAssignment.clickOnSelectButton();
            saveAndDeleteAssignment.getCountOfUnSelectedCheckBox();

            String assertTextVASP = "All Present Assignment Is Not Selected.";
            Assert.assertTrue(saveAndDeleteAssignment.verifyAllPresentAssignmentIsNotSelected(), assertFailurePreText + assertTextVASP);
            reportLog(assertTextVASP);

            String assertTextVCBA = "Presence Of close button.";
            Assert.assertTrue(assignAndCloseFeatureOnAssignment.verifyCloseButton(), assertFailurePreText + assertTextVCBA);
            reportLog(assertTextVCBA);

        } catch (Exception e) {
            result = handleException(e);
        }
        Assert.assertTrue(result, testCaseFailureText + currentMethodName + errorMessage);
    }

    @Test(priority = 7, description = "Verify the Functionality Of 'Select' CheckBox of Present Assignment")
    public void verifyFunctionalityOfSelectCheckBox() {
        boolean result = true;
        try {
            Reports reports = new Reports(webDriver,extentTest,extentReports);

            /*
            /*String assertTextVSB = "Presence Of Select Button";
            Assert.assertTrue(saveAndDeleteAssignment.verifySelectButton(), assertFailurePreText + assertTextVSB);
            reportLog(assertTextVSB);*/

            reports.clickOnFirstAssignmentCheckBox();

            String assertTextVSBB = "Presence Of Save Button.";
            Assert.assertTrue(reports.verifySaveButton(), assertFailurePreText + assertTextVSBB);
            reportLog(assertTextVSBB);

        } catch (Exception e) {
            result = handleException(e);
        }
        Assert.assertTrue(result, testCaseFailureText + currentMethodName + errorMessage);
    }

    @Test(priority = 9, description = "Verify the Functionality Of 'Remove Concept ' Icon After Selecting Assignment")
    public void verifyFunctionalityOfRemoveConceptIcon() {
        boolean result = true;
        try {
            SaveAndDeleteAssignment saveAndDeleteAssignment = new SaveAndDeleteAssignment(webDriver,extentTest,extentReports);
            AssignAndCloseFeatureOnAssignment assignAndCloseFeatureOnAssignment = new AssignAndCloseFeatureOnAssignment(webDriver,extentTest,extentReports);

            String assertTextVRCI = "Presence Of Remove Concept Icon.";
            Assert.assertTrue(saveAndDeleteAssignment.verifyRemoveConceptIcon(), assertFailurePreText + assertTextVRCI);
            reportLog(assertTextVRCI);

            saveAndDeleteAssignment.getCountOfAssignmentsBeforeRemove();
            saveAndDeleteAssignment.clickOnRemoveConceptIcon();
            saveAndDeleteAssignment.getCountOfAssignmentsAfterRemove();

            String assertTextVCBA = "Presence Of close button.";
            Assert.assertTrue(assignAndCloseFeatureOnAssignment.verifyCloseButton(), assertFailurePreText + assertTextVCBA);
            reportLog(assertTextVCBA);

            String assertTextVCARA = "Count After Remove Assignment";
            Assert.assertTrue(saveAndDeleteAssignment.verifyCountAfterRemove(), assertFailurePreText + assertTextVCARA);
            reportLog(assertTextVCARA);

        } catch (Exception e) {
            result = handleException(e);
        }
        Assert.assertTrue(result, testCaseFailureText + currentMethodName + errorMessage);
    }
}