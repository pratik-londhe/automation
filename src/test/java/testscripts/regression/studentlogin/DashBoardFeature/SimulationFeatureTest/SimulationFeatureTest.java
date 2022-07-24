package testscripts.regression.studentlogin.DashBoardFeature.SimulationFeatureTest;

import com.relevantcodes.extentreports.LogStatus;
import org.apache.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.Test;
import testscripts.BaseTestScript;
import uipages.flexbook2feature.*;

public class SimulationFeatureTest extends BaseTestScript {
    private static final Logger logger = Logger.getLogger(SimulationFeatureTest.class);
    private String testCaseFailureText = "Test failed for method: ";
    private String assertFailurePreText = "Failed to verify: ";
    public String assertSuccessPreText = "Successfully verified: ";

    @Test(priority = 1, dataProvider = "CK12DataProvider", description = "Verify Simulation Container is available inside the explore container.")
    public void verifySimulationContainerIsVisible(String email, String password) {
        boolean result = true;
        try {
            SchoolFeature schoolFeature = new SchoolFeature(webDriver, extentTest, extentReports);
            SimulationFeature simulationFeature = new SimulationFeature(webDriver, extentTest, extentReports);

            new LoginPage(webDriver, extentTest, extentReports).studentLogin(email, password);

            String assertTextVSPOG = "Student profile icon after logging in.";
            Assert.assertTrue(new StudentDashBoardPage(webDriver, extentTest, extentReports).verifyStudentProfileOnGamma(), assertFailurePreText + assertTextVSPOG);
            reportLog(assertTextVSPOG);

            String assertTextVCNDD = "Presence of 'Header' Container.";
            Assert.assertTrue(schoolFeature.verifyHeaderContainer(), assertFailurePreText + assertTextVCNDD);
            reportLog(assertTextVCNDD);

            schoolFeature.clickOnHeaderContainer();

            String assertTextVEB = "Presence of 'Simulation' Container.";
            Assert.assertTrue(simulationFeature.verifySimulationContainer(), assertFailurePreText + assertTextVEB);
            reportLog(assertTextVEB);

        } catch (Exception e) {
            result = handleException(e);
        }
        Assert.assertTrue(result, testCaseFailureText + currentMethodName + errorMessage);
    }

    @Test(priority = 3, description = "Verify Functionality Of 'Simulation' Container.")
    public void verifyFunctionalityOfSimulationContainer() {
        boolean result = true;
        try {
            SimulationFeature simulationFeature = new SimulationFeature(webDriver, extentTest, extentReports);

            simulationFeature.clickOnSimulationContainer();

            String assertTextVSPOG = "Presence of 'Exploration Series' Text.";
            Assert.assertTrue(simulationFeature.verifyExplorationSeriesText(), assertFailurePreText + assertTextVSPOG);
            reportLog(assertTextVSPOG);

            String assertTextVCNDD = "Presence of 'Ck12 Image' Icon.";
            Assert.assertTrue(simulationFeature.verifyCk12ImageIcon(), assertFailurePreText + assertTextVCNDD);
            reportLog(assertTextVCNDD);

        } catch (Exception e) {
            result = handleException(e);
        }
        Assert.assertTrue(result, testCaseFailureText + currentMethodName + errorMessage);
    }

    @Test(priority = 5, description = "Verify Functionality Of 'Ck-12' image icon.")
    public void verifyFunctionalityOfCk12ImageIcon() {
        boolean result = true;
        try {
            SimulationFeature simulationFeature = new SimulationFeature(webDriver, extentTest, extentReports);
            SchoolFeature schoolFeature = new SchoolFeature(webDriver, extentTest, extentReports);

            simulationFeature.clickOnCk12ImageIcon();

            String assertTextVCNDD = "Presence of 'Header' Container.";
            Assert.assertTrue(schoolFeature.verifyHeaderContainer(), assertFailurePreText + assertTextVCNDD);
            reportLog(assertTextVCNDD);

            schoolFeature.clickOnHeaderContainer();

            String assertTextVEB = "Presence of 'Simulation' Container.";
            Assert.assertTrue(simulationFeature.verifySimulationContainer(), assertFailurePreText + assertTextVEB);
            reportLog(assertTextVEB);

            simulationFeature.clickOnSimulationContainer();

            String assertTextVSPOG = "Presence of 'Exploration Series' Text.";
            Assert.assertTrue(simulationFeature.verifyExplorationSeriesText(), assertFailurePreText + assertTextVSPOG);
            reportLog(assertTextVSPOG);

        } catch (Exception e) {
            result = handleException(e);
        }
        Assert.assertTrue(result, testCaseFailureText + currentMethodName + errorMessage);
    }

    @Test(priority = 7, description = "Verify UI page Of Simulation.")
    public void verifyUIOfSimulationPage() {
        boolean result = true;
        try {
            SimulationFeature simulationFeature = new SimulationFeature(webDriver, extentTest, extentReports);

            String assertTextVCNDD = "Presence of 'Physics Branch' Tab.";
            Assert.assertTrue(simulationFeature.verifyPhysicsBranchTab(), assertFailurePreText + assertTextVCNDD);
            reportLog(assertTextVCNDD);

            String assertTextVEB = "Presence of 'Chemistry Branch' Tab.";
            Assert.assertTrue(simulationFeature.verifyChemistryBranchTab(), assertFailurePreText + assertTextVEB);
            reportLog(assertTextVEB);

            String assertTextVSPOG = "Presence of 'Instruction Video' Tab.";
            Assert.assertTrue(simulationFeature.verifyInstructionVideoTab(), assertFailurePreText + assertTextVSPOG);
            reportLog(assertTextVSPOG);

        } catch (Exception e) {
            result = handleException(e);
        }
        Assert.assertTrue(result, testCaseFailureText + currentMethodName + errorMessage);
    }

    @Test(priority = 9, description = "Verify Functionality Of Language Dropdown.")
    public void verifyFunctionalityOfLanguageDropDown() {
        boolean result = true;
        try {
            SimulationFeature simulationFeature = new SimulationFeature(webDriver, extentTest, extentReports);

            String assertTextVCNDD = "Presence of 'Language' DropDown.";
            Assert.assertTrue(simulationFeature.verifyLanguageDropDown(), assertFailurePreText + assertTextVCNDD);
            reportLog(assertTextVCNDD);

            simulationFeature.clickOnLanguageDropDown();

            String assertTextVEB = "Presence of 'English Language' Link.";
            Assert.assertTrue(simulationFeature.verifyEnglishLanguageLink(), assertFailurePreText + assertTextVEB);
            reportLog(assertTextVEB);

        } catch (Exception e) {
            result = handleException(e);
        }
        Assert.assertTrue(result, testCaseFailureText + currentMethodName + errorMessage);
    }

    @Test(priority = 11, description = "Verify selected language redirects page successfully.")
    public void verifyFunctionalityOfSelectedLanguage() {
        boolean result = true;
        try {
            SimulationFeature simulationFeature = new SimulationFeature(webDriver, extentTest, extentReports);

            String assertTextVSPOG = "Presence of 'German Language' Link.";
            Assert.assertTrue(simulationFeature.verifyGermanLanguageLink(), assertFailurePreText + assertTextVSPOG);
            reportLog(assertTextVSPOG);

            simulationFeature.clickOnGermanLanguageLink();

            String assertTextVCNDD = "Presence of 'Exploration Series' Text.";
            Assert.assertTrue(simulationFeature.verifyExplorationSeriesText(), assertFailurePreText + assertTextVCNDD);
            reportLog(assertTextVCNDD);

            String assertTextVEB = "Not Presence of 'Chemistry Branch' Tab.";
            Assert.assertTrue(simulationFeature.verifyChemistryBranchTabIsNotPresent(), assertFailurePreText + assertTextVEB);
            reportLog(assertTextVEB);

        } catch (Exception e) {
            result = handleException(e);
        }
        Assert.assertTrue(result, testCaseFailureText + currentMethodName + errorMessage);
    }

    @Test(priority = 13, description = "Verify 'Beta' flag is display after clicking on 'Chemistry' simulation tab.")
    public void verifyBetaFlagIsDisplay() {
        boolean result = true;
        try {
            SimulationFeature simulationFeature = new SimulationFeature(webDriver, extentTest, extentReports);

            String assertTextVCNDD = "Presence of 'Language' DropDown.";
            Assert.assertTrue(simulationFeature.verifyLanguageDropDown(), assertFailurePreText + assertTextVCNDD);
            reportLog(assertTextVCNDD);

            simulationFeature.clickOnLanguageDropDown();

            String assertTextVEB = "Presence of 'English Language' Link.";
            Assert.assertTrue(simulationFeature.verifyEnglishLanguageLink(), assertFailurePreText + assertTextVEB);
            reportLog(assertTextVEB);

            simulationFeature.clickOnEnglishLanguageLink();

            String assertTextVDD = "Presence of 'Exploration Series' Text.";
            Assert.assertTrue(simulationFeature.verifyExplorationSeriesText(), assertFailurePreText + assertTextVDD);
            reportLog(assertTextVDD);

            String assertTextVSPOG = "Presence of 'Chemistry Branch' TAb.";
            Assert.assertTrue(simulationFeature.verifyChemistryBranchTab(), assertFailurePreText + assertTextVSPOG);
            reportLog(assertTextVSPOG);

            simulationFeature.clickOnChemistryBranchTab();

            /*String assertTextVB = "Presence of 'Beta' Flag.";
            Assert.assertTrue(simulationFeature.verifyBetaFlag(), assertFailurePreText + assertTextVB);
            reportLog(assertTextVB);*/

        } catch (Exception e) {
            result = handleException(e);
        }
        Assert.assertTrue(result, testCaseFailureText + currentMethodName + errorMessage);
    }

    @Test(priority = 15, description = "Verify Functionality of 'Physics' simulation tab.")
    public void verifyFunctionalityOfPhysicsBranch() {
        boolean result = true;
        try {
            SimulationFeature simulationFeature = new SimulationFeature(webDriver, extentTest, extentReports);

            String assertTextVCNDD = "Presence of 'Physics' Branch.";
            Assert.assertTrue(simulationFeature.verifyPhysicsBranchTab(), assertFailurePreText + assertTextVCNDD);
            reportLog(assertTextVCNDD);

            simulationFeature.clickOnPhysicsBranchTab();

            String assertTextVDD = "Presence of 'Exploration Series' Text.";
            Assert.assertTrue(simulationFeature.verifyExplorationSeriesText(), assertFailurePreText + assertTextVDD);
            reportLog(assertTextVDD);

            String assertTextVEB = "Presence of 'Search' PlaceHolder.";
            Assert.assertTrue(simulationFeature.verifySearchPlaceHolder(), assertFailurePreText + assertTextVEB);
            reportLog(assertTextVEB);

            String assertTextVSPOG = "Presence of 'Filter' Icon.";
            Assert.assertTrue(simulationFeature.verifyFiltersIcon(), assertFailurePreText + assertTextVSPOG);
            reportLog(assertTextVSPOG);

        } catch (Exception e) {
            result = handleException(e);
        }
        Assert.assertTrue(result, testCaseFailureText + currentMethodName + errorMessage);
    }

    @Test(priority = 17, description = "Verify Functionality of Search Simulation placeHolder with Invalid Data.")
    public void verifyFunctionalityOfSearchWithInvalidData() {
        boolean result = true;
        try {
            SimulationFeature simulationFeature = new SimulationFeature(webDriver, extentTest, extentReports);

            String text = "ABC";

            simulationFeature.setTextInSearchPlaceHolder(text);

            String assertTextVCNDD = "Presence of 'No Match Found' Text.";
            Assert.assertTrue(simulationFeature.verifyNoMatchFoundText(), assertFailurePreText + assertTextVCNDD);
            reportLog(assertTextVCNDD);

        } catch (Exception e) {
            result = handleException(e);
        }
        Assert.assertTrue(result, testCaseFailureText + currentMethodName + errorMessage);
    }

    @Test(priority = 19, description = "Verify Functionality of Search Simulation placeHolder with Valid Data.")
    public void verifyFunctionalityOfSearchWithValidData() {
        boolean result = true;
        try {
            SimulationFeature simulationFeature = new SimulationFeature(webDriver, extentTest, extentReports);

            String text = "Scientific Measurement";

            String assertTextVEB = "Presence of 'Search' PlaceHolder.";
            Assert.assertTrue(simulationFeature.verifySearchPlaceHolder(), assertFailurePreText + assertTextVEB);
            reportLog(assertTextVEB);

            simulationFeature.setTextInSearchPlaceHolder(text);

//            String assertTextVCNDD = "Presence of 'Result Concept' Link.";
//            Assert.assertTrue(simulationFeature.verifyConceptResultLink(), assertFailurePreText + assertTextVCNDD);
//            reportLog(assertTextVCNDD);

            String assertTextVDD = "Presence of 'ChemistryBranch' Tab.";
            Assert.assertTrue(simulationFeature.verifyChemistryBranchTab(), assertFailurePreText + assertTextVDD);
            reportLog(assertTextVDD);

            simulationFeature.clickOnChemistryBranchTab();

            String assertTextVSPOG = "Presence of 'Physics Branch ' TAb.";
            Assert.assertTrue(simulationFeature.verifyPhysicsBranchTab(), assertFailurePreText + assertTextVSPOG);
            reportLog(assertTextVSPOG);

            simulationFeature.clickOnPhysicsBranchTab();

            String assertTextVB = "Presence of 'Exploration Series' Text.";
            Assert.assertTrue(simulationFeature.verifyExplorationSeriesText(), assertFailurePreText + assertTextVB);
            reportLog(assertTextVB);

        } catch (Exception e) {
            result = handleException(e);
        }
        Assert.assertTrue(result, testCaseFailureText + currentMethodName + errorMessage);
    }

    @Test(priority = 21, description = "Verify Functionality of Instruction video.")
    public void verifyFunctionalityOfInstructionVideo() {
        boolean result = true;
        try {
            SimulationFeature simulationFeature = new SimulationFeature(webDriver, extentTest, extentReports);

            String assertTextVEB = "Presence of 'Instruction Video' Tab.";
            Assert.assertTrue(simulationFeature.verifyInstructionVideoTab(), assertFailurePreText + assertTextVEB);
            reportLog(assertTextVEB);

            simulationFeature.clickOnInstructionVideoTab();

            String assertTextVCNDD = "Presence of 'Instruction Title' Text.";
            Assert.assertTrue(simulationFeature.verifyInstructionTitleText(), assertFailurePreText + assertTextVCNDD);
            reportLog(assertTextVCNDD);

        } catch (Exception e) {
            result = handleException(e);
        }
        Assert.assertTrue(result, testCaseFailureText + currentMethodName + errorMessage);
    }

    @Test(priority = 23, description = "Verify Functionality of Close Instruction Icon.")
    public void verifyFunctionalityOfCloseInstructionIcon() {
        boolean result = true;
        try {
            SimulationFeature simulationFeature = new SimulationFeature(webDriver, extentTest, extentReports);

            String assertTextVDD = "Presence of 'Close Instruction' Icon.";
            Assert.assertTrue(simulationFeature.verifyCloseInstructionIcon(), assertFailurePreText + assertTextVDD);
            reportLog(assertTextVDD);

            simulationFeature.clickOnCloseInstructionIcon();

            String assertTextVB = "Presence of 'Exploration Series' Text.";
            Assert.assertTrue(simulationFeature.verifyExplorationSeriesText(), assertFailurePreText + assertTextVB);
            reportLog(assertTextVB);

            String assertTextVEB = "Presence of 'Instruction Video' Tab.";
            Assert.assertTrue(simulationFeature.verifyInstructionVideoTab(), assertFailurePreText + assertTextVEB);
            reportLog(assertTextVEB);

        } catch (Exception e) {
            result = handleException(e);
        }
        Assert.assertTrue(result, testCaseFailureText + currentMethodName + errorMessage);
    }

    @Test(priority = 25, description = "Verify Functionality Of Filter DropDown.")
    public void verifyFunctionalityOfFilterDropDown() {
        boolean result = true;
        try {
            SimulationFeature simulationFeature = new SimulationFeature(webDriver, extentTest, extentReports);

            String assertTextVB = "Presence of 'Filters' Icon.";
            Assert.assertTrue(simulationFeature.verifyFiltersIcon(), assertFailurePreText + assertTextVB);
            reportLog(assertTextVB);

            simulationFeature.clickOnFiltersIcon();

            String assertTextVEB = "Presence of 'Filter Text' button.";
            Assert.assertTrue(simulationFeature.verifyFilterText(), assertFailurePreText + assertTextVEB);
            reportLog(assertTextVEB);

            String assertTextVDD = "Presence of 'BAck Arrow Icon.";
            Assert.assertTrue(simulationFeature.verifyBackArrowIcon(), assertFailurePreText + assertTextVDD);
            reportLog(assertTextVDD);

        } catch (Exception e) {
            result = handleException(e);
        }
        Assert.assertTrue(result, testCaseFailureText + currentMethodName + errorMessage);
    }

    @Test(priority = 27, description = "Verify Presence Of Filter by Concept and standard Are present.")
    public void verifyFilterByArePresent() {
        boolean result = true;
        try {
            SimulationFeature simulationFeature = new SimulationFeature(webDriver, extentTest, extentReports);

            String assertTextVB = "Presence of 'Filters By Concept' Wrapper.";
            Assert.assertTrue(simulationFeature.verifyFilterByConceptWrapper(), assertFailurePreText + assertTextVB);
            reportLog(assertTextVB);

            simulationFeature.clickOnFilterByConceptWrapper();

            String assertTextVEB = "Presence of 'Filter Text' button.";
            Assert.assertTrue(simulationFeature.verifyFilterText(), assertFailurePreText + assertTextVEB);
            reportLog(assertTextVEB);

            String assertTextVCNDD = "Presence of 'Filters By Standard' Wrapper.";
            Assert.assertTrue(simulationFeature.verifyFilterByStandardWrapper(), assertFailurePreText + assertTextVCNDD);
            reportLog(assertTextVCNDD);

        } catch (Exception e) {
            result = handleException(e);
        }
        Assert.assertTrue(result, testCaseFailureText + currentMethodName + errorMessage);
    }

    @Test(priority = 29, description = "Verify Functionality Of Back Arrow Icon.")
    public void verifyFunctionalityOfBackArrowIcon() {
        boolean result = true;
        try {
            SimulationFeature simulationFeature = new SimulationFeature(webDriver, extentTest, extentReports);

            String assertTextVDD = "Presence of 'BAck Arrow Icon.";
            Assert.assertTrue(simulationFeature.verifyBackArrowIcon(), assertFailurePreText + assertTextVDD);
            reportLog(assertTextVDD);

            simulationFeature.clickOnBackArrowIcon();

            String assertTextVB = "Presence of 'Exploration Series' Text.";
            Assert.assertTrue(simulationFeature.verifyExplorationSeriesText(), assertFailurePreText + assertTextVB);
            reportLog(assertTextVB);

        } catch (Exception e) {
            result = handleException(e);
        }
        Assert.assertTrue(result, testCaseFailureText + currentMethodName + errorMessage);
    }
}