package testscripts.regression.studentlogin.DashBoardFeature.SimulationFeatureTest;

import com.relevantcodes.extentreports.LogStatus;
import org.apache.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.Test;
import testscripts.BaseTestScript;
import uipages.flexbook2feature.LoginPage;
import uipages.flexbook2feature.SchoolFeature;
import uipages.flexbook2feature.SimulationFeature;
import uipages.flexbook2feature.StudentDashBoardPage;

public class SimulationConceptFeatureTest  extends BaseTestScript {
    private static final Logger logger = Logger.getLogger(SimulationConceptFeatureTest.class);
    private String testCaseFailureText = "Test failed for method: ";
    private String assertFailurePreText = "Failed to verify: ";
    public String assertSuccessPreText = "Successfully verified: ";

    @Test(priority = 1, dataProvider = "CK12DataProvider", description = "Verify Functionality Wrapper Icon.")
    public void verifyFunctionalityOfWrapperIcon(String email, String password) {
        boolean result = true;
        try {
            SchoolFeature schoolFeature = new SchoolFeature(webDriver,extentTest,extentReports);
            SimulationFeature simulationFeature = new SimulationFeature(webDriver,extentTest,extentReports);

            new LoginPage(webDriver,extentTest, extentReports).studentLogin(email, password);

            String assertTextVSPOG = "Student profile icon after logging in.";
            Assert.assertTrue(new StudentDashBoardPage(webDriver,extentTest,extentReports).verifyStudentProfileOnGamma(), assertFailurePreText + assertTextVSPOG);
            reportLog(assertTextVSPOG);

            String assertTextVCNDD = "Presence of 'Header' Container.";
            Assert.assertTrue(schoolFeature.verifyHeaderContainer(), assertFailurePreText + assertTextVCNDD);
            reportLog(assertTextVCNDD);

            schoolFeature.clickOnHeaderContainer();

            String assertTextVEB = "Presence of 'Simulation' Container.";
            Assert.assertTrue(simulationFeature.verifySimulationContainer(), assertFailurePreText + assertTextVEB);
            reportLog(assertTextVEB);

            simulationFeature.clickOnSimulationContainer();

            String assertTextVSOG = "Presence of 'Exploration Series' Text.";
            Assert.assertTrue(simulationFeature.verifyExplorationSeriesText(), assertFailurePreText + assertTextVSOG);
            reportLog(assertTextVSOG);

            String assertTextVB = "Presence of 'Filters' Icon.";
            Assert.assertTrue(simulationFeature.verifyFiltersIcon(), assertFailurePreText + assertTextVB);
            reportLog(assertTextVB);

            simulationFeature.clickOnFiltersIcon();

            String assertTextVEBT = "Presence of 'Filter Text' button.";
            Assert.assertTrue(simulationFeature.verifyFilterText(), assertFailurePreText + assertTextVEBT);
            reportLog(assertTextVEBT);

        } catch (Exception e) {
            result = handleException(e);
        }
        Assert.assertTrue(result, testCaseFailureText + currentMethodName + errorMessage);
    }
}