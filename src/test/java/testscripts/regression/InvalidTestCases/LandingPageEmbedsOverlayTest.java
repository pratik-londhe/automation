package testscripts.regression.InvalidTestCases;

import com.relevantcodes.extentreports.LogStatus;
import org.apache.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.Test;
import testscripts.BaseTestScript;
import uipages.flexbook2feature.CBookLandingPage;
import uipages.flexbook2feature.LoginPage;
import uipages.flexbook2feature.TeacherDashboardPage;

public class LandingPageEmbedsOverlayTest extends BaseTestScript {
    private static final Logger logger = Logger.getLogger(CK12LandingPageTest.class);

    public String assertSuccessPreText = "Successfully verified: ";
    public String testCaseFailureText = "Test failed for method: ";
    public String assertFailurePreText = "Failed to verify: ";
    CBookLandingPage cBookLandingPage;



    @Test(priority = 1, dataProvider = "CK12DataProvider", description = "Verify 'Discover a new way of learning physics and Chemistry using Real world Simulations' text is displayed hover the cursor Simulation overlay")
    public void verifyTheFunctionalityOfSimulationOverlay(String email, String password) {
        boolean result = true;
        try {
            cBookLandingPage = new CBookLandingPage(webDriver,extentTest,extentReports);
            new LoginPage(webDriver,extentTest, extentReports).teacherLogin(email, password);

            String assertTextVTPG = "Presence of teacher profile icon.";
            Assert.assertTrue(new TeacherDashboardPage(webDriver,extentTest,extentReports).verifyTeacherProfileOnGamma(), assertFailurePreText + assertTextVTPG);
            reportLog(assertTextVTPG);

            cBookLandingPage.clickOnCK12LandingPageLink();

            String assertTextVSTBMH = "Presence of Simulation text by mouse hover.";
            Assert.assertTrue(cBookLandingPage.verifySimulationTextByMouseHover(), assertFailurePreText + assertTextVSTBMH);
            reportLog(assertTextVSTBMH);

        } catch (Exception e) {
            result = handleException(e);
        }
        Assert.assertTrue(result, testCaseFailureText + currentMethodName + errorMessage);
    }

    @Test(priority = 2, description = "Verify 'Play, Learn, Interact and Xplore a concept with PLIX' text is displayed hover the cursor  PLIX overlay")
    public void verifyTheFunctionalityOfPlixOverlay() {
        boolean result = true;
        try {
            String assertTextVPTBMH = "Presence of PLIX text by mouse hover.";
            Assert.assertTrue(cBookLandingPage.verifyPlixTextByMouseHover(), assertFailurePreText + assertTextVPTBMH);
            reportLog(assertTextVPTBMH);

        } catch (Exception e) {
            result = handleException(e);
        }
        Assert.assertTrue(result, testCaseFailureText + currentMethodName + errorMessage);
    }

    @Test(priority = 3, description = "Verify 'Master Math and Science concepts through regular practice.' text is displayed hover the cursor Adaptive Practice overlay")
    public void verifyTheFunctionalityOfAdaptivePracticeOverlay() {
        boolean result = true;
        try {
            String assertTextVAPTBMH = "Presence of Adaptive Practice text by mouse hover.";
            Assert.assertTrue(cBookLandingPage.verifyAdaptivePracticeTextByMouseHover(), assertFailurePreText + assertTextVAPTBMH);
            reportLog(assertTextVAPTBMH);

        } catch (Exception e) {
            result = handleException(e);
        }
        Assert.assertTrue(result, testCaseFailureText + currentMethodName + errorMessage);
    }

    @Test(priority = 4, description = "Verify 'Find schools and districts near you that are on CK-12.' text is displayed hover the cursor  Study Guide overlay")
    public void verifyTheFunctionalityOfStudyGuideOverlay() {
        boolean result = true;
        try {
            String assertTextVSGTBMH = "Presence of Study Guide text by mouse hover.";
            Assert.assertTrue(cBookLandingPage.verifyStudyGuideTextByMouseHover(), assertFailurePreText + assertTextVSGTBMH);
            reportLog(assertTextVSGTBMH);

        } catch (Exception e) {
            result = handleException(e);
        }
        Assert.assertTrue(result, testCaseFailureText + currentMethodName + errorMessage);
    }

    //@Test(priority = 5, description = "Verify '100% Free, Personalized Learning for Every Student Create digital classrooms, customize textbooks, and learn K-12 STEM concepts.' gets displayed in landing page .")
    public void verifyTheHeaderTextOnLandingPage() {
        boolean result = true;
        try {
            String assertTextVCK12MHT = "Presence of CK12 mission header text.";
            Assert.assertTrue(cBookLandingPage.verifyCK12MissionHeaderText(), assertFailurePreText + assertTextVCK12MHT);
            reportLog(assertTextVCK12MHT);

            String assertTextVCK12MT = "Presence of CK12 mission text.";
            Assert.assertTrue(cBookLandingPage.verifyCK12MissionText(), assertFailurePreText + assertTextVCK12MT);
            reportLog(assertTextVCK12MT);

        } catch (Exception e) {
            result = handleException(e);
        }
        Assert.assertTrue(result, testCaseFailureText + currentMethodName + errorMessage);
    }

   // @Test(priority = 6, description = "Verify 'Grade 1-5' Subject is redirects to Grade subject page.")
    public void verifyTheFunctionalityOfGrade1To5Link() {
        boolean result = true;
        try {
            cBookLandingPage.clickOnLinkGrade1To5();

            String assertTextVDGOSP = "Presence of grades on the subject page.";
            Assert.assertTrue(cBookLandingPage.verifyTheDataGradesOnSubjectPage(), assertFailurePreText + assertTextVDGOSP);
            reportLog(assertTextVDGOSP);

        } catch (Exception e) {
            result = handleException(e);
        }
        Assert.assertTrue(result, testCaseFailureText + currentMethodName + errorMessage);
    }
}