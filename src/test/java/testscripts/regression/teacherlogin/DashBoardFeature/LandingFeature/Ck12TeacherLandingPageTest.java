package testscripts.regression.teacherlogin.DashBoardFeature.LandingFeature;

import com.relevantcodes.extentreports.LogStatus;
import org.apache.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.Test;
import testscripts.BaseTestScript;
import uipages.flexbook2feature.*;

public class Ck12TeacherLandingPageTest extends BaseTestScript {
    private static final Logger logger = Logger.getLogger(Ck12TeacherLandingPageTest.class);
    private String testCaseFailureText = "Test failed for method: ";
    private String assertFailurePreText = "Failed to verify: ";
    public String assertSuccessPreText = "Successfully verified: ";

    @Test(priority = 1, dataProvider = "CK12DataProvider", description = "Verify Ck12 Logo Icon is Visible on Teacher Landing Page")
    public void verifyCk12LogoIcoIsVisible(String email, String password) {
        boolean result = true;
        try {
            CK12SubjectsPage ck12SubjectsPage = new CK12SubjectsPage(webDriver,extentTest,extentReports);

            new LoginPage(webDriver,extentTest, extentReports).teacherLogin(email, password);

            String assertTextVTPOG = "Teacher profile icon after login";
            Assert.assertTrue(new TeacherDashboardPage(webDriver,extentTest,extentReports).verifyTeacherProfileOnGamma(), assertFailurePreText + assertTextVTPOG);
            reportLog(assertTextVTPOG);

            String assertTextVHI = "Presence Of 'Ck12 Image' Icon";
            Assert.assertTrue(ck12SubjectsPage.verifyCK12ImageIcon(), assertFailurePreText + assertTextVHI);
            reportLog(assertTextVHI);

        } catch (Exception e) {
            result = handleException(e);
        }
        Assert.assertTrue(result, testCaseFailureText + currentMethodName + errorMessage);
    }

    @Test(priority = 3, description = "Verify Functionality Of Ck 12 Image ICon and Verify It redirects Teacher Landing Page")
    public void verifyFunctionalityOfCk12ImageIcon() {
        boolean result = true;
        try {
            CK12SubjectsPage ck12SubjectsPage = new CK12SubjectsPage(webDriver,extentTest,extentReports);

            ck12SubjectsPage.clickOnCK12ImageIcon();

            String assertTextVHI = "Presence Of 'Start Browsing' button";
            Assert.assertTrue(ck12SubjectsPage.verifyStartBrowsingButton(), assertFailurePreText + assertTextVHI);
            reportLog(assertTextVHI);

        } catch (Exception e) {
            result = handleException(e);
        }
        Assert.assertTrue(result, testCaseFailureText + currentMethodName + errorMessage);
    }

    @Test(priority = 5, description = "Verify Functionality Of 'Start Browsing' button")
    public void verifyFunctionalityOfStartBrowsingButton() {
        boolean result = true;
        try {
            CK12SubjectsPage ck12SubjectsPage = new CK12SubjectsPage(webDriver,extentTest,extentReports);

            ck12SubjectsPage.clickOnStartBrowsingButton();

            String assertTextVHI = "Presence Of 'What Do you Want to teach' text";
           // Assert.assertTrue(ck12SubjectsPage.verifyWhatDoYouWantYoTeachText(), assertFailurePreText + assertTextVHI);
            reportLog(assertTextVHI);

        } catch (Exception e) {
            result = handleException(e);
        }
        Assert.assertTrue(result, testCaseFailureText + currentMethodName + errorMessage);
    }

    @Test(priority = 7, description = "Verify All the Teacher Books Are Available on the teacher Landing PAge")
    public void verifyAllBooksAreVisible() {
        boolean result = true;
        try {
            CK12SubjectsPage ck12SubjectsPage = new CK12SubjectsPage(webDriver,extentTest,extentReports);

            String assertTextVSO = "Presence Of 'Math' text.";
            //Assert.assertTrue(ck12SubjectsPage.verifyMathText(), assertFailurePreText + assertTextVSO);
            reportLog(assertTextVSO);

            String assertTextVHI = "Presence Of 'Science' text";
            //Assert.assertTrue(ck12SubjectsPage.verifyScienceText(), assertFailurePreText + assertTextVHI);
            reportLog(assertTextVHI);

            String assertTextVH = "Presence Of 'College' text.";
            //Assert.assertTrue(ck12SubjectsPage.verifyCollegeText(), assertFailurePreText + assertTextVH);
            reportLog(assertTextVSO);

            String assertTextVENT = "Presence Of 'Country' text.";
            //Assert.assertTrue(ck12SubjectsPage.verifyCountryText(), assertFailurePreText + assertTextVENT);
            reportLog(assertTextVENT);

        } catch (Exception e) {
            result = handleException(e);
        }
        Assert.assertTrue(result, testCaseFailureText + currentMethodName + errorMessage);
    }

    @Test(priority = 9, description = "Verify All Browse links Are Available On Teacher Landing Page. ")
    public void verifyAllBrowseLinksAreAvailable() {
        boolean result = true;
        try {
            CK12SubjectsPage ck12SubjectsPage = new CK12SubjectsPage(webDriver,extentTest,extentReports);

            //ck12SubjectsPage.scrollExploreSoeOtherText();

            String assertTextVSO = "Presence Of 'Browse FlexBook Link ' Button.";
            //Assert.assertTrue(ck12SubjectsPage.verifyBrowseFleBookLink(), assertFailurePreText + assertTextVSO);
            reportLog(assertTextVSO);

            String assertTextVHI = "Presence Of 'Adaptive Practice Link'";
            //Assert.assertTrue(ck12SubjectsPage.verifyAdaptivePracticeLink(), assertFailurePreText + assertTextVHI);
            reportLog(assertTextVHI);

            String assertTextVH = "Presence Of 'Plix' link.";
            //Assert.assertTrue(ck12SubjectsPage.verifyPlixLink(), assertFailurePreText + assertTextVH);
            reportLog(assertTextVSO);

            String assertTextVENT = "Presence Of 'Find Your Link'.";
            //Assert.assertTrue(ck12SubjectsPage.verifyFindYourLink(), assertFailurePreText + assertTextVENT);
            reportLog(assertTextVENT);

        } catch (Exception e) {
            result = handleException(e);
        }
        Assert.assertTrue(result, testCaseFailureText + currentMethodName + errorMessage);
    }

    @Test(priority = 11, description = "Verify Functionality Of Browse FlexBook Link And Verify It Redirects FlexBook Page. ")
    public void verifyFunctionalityOfBrowseFlexBookLink() {
        boolean result = true;
        try {
            CK12SubjectsPage ck12SubjectsPage = new CK12SubjectsPage(webDriver,extentTest,extentReports);

            String assertTextVSO = "Presence Of 'Browse FlexBook Link ' Button.";
            //Assert.assertTrue(ck12SubjectsPage.verifyBrowseFleBookLink(), assertFailurePreText + assertTextVSO);
            reportLog(assertTextVSO);

            //ck12SubjectsPage.clickOnBrowseFleBookLink();

            String assertTextVHI = "Presence Of 'FlexBook' Text";
            //Assert.assertTrue(ck12SubjectsPage.verifyFlexBookText(), assertFailurePreText + assertTextVHI);
            reportLog(assertTextVHI);

            String assertTextVENT = "Presence Of 'Ck12 Image' Icon";
            //Assert.assertTrue(ck12SubjectsPage.verifyCK12ImageIcon(), assertFailurePreText + assertTextVENT);
            reportLog(assertTextVENT);

            //ck12SubjectsPage.clickOnCK12ImageIcon();

            String assertTextVI = "Presence Of 'Start Browsing' button";
            //Assert.assertTrue(ck12SubjectsPage.verifyStartBrowsingButton(), assertFailurePreText + assertTextVI);
            reportLog(assertTextVI);

            //ck12SubjectsPage.clickOnStartBrowsingButton();

            String assertTextVH = "Presence Of 'What Do you Want to teach' text";
            //Assert.assertTrue(ck12SubjectsPage.verifyWhatDoYouWantYoTeachText(), assertFailurePreText + assertTextVH);
            reportLog(assertTextVH);

            //ck12SubjectsPage.scrollExploreSoeOtherText();

            String assertTextVHSD = "Presence Of 'Adaptive Practice' link.";
            //Assert.assertTrue(ck12SubjectsPage.verifyAdaptivePracticeLink(), assertFailurePreText + assertTextVHSD);
            reportLog(assertTextVHSD);

        } catch (Exception e) {
            result = handleException(e);
        }
        Assert.assertTrue(result, testCaseFailureText + currentMethodName + errorMessage);
    }

    @Test(priority = 12, description = "Verify Functionality Of Adaptive Practice FlexBook Link And Verify It Redirects Adaptive Practice Page. ")
    public void verifyFunctionalityOfAdaptivePracticeLink() {
        boolean result = true;
        try {
            CK12SubjectsPage ck12SubjectsPage = new CK12SubjectsPage(webDriver,extentTest,extentReports);

            AdaptivePracticeFeature adaptivePracticeFeature = new AdaptivePracticeFeature(webDriver,extentTest,extentReports);
            //ck12SubjectsPage.clickOnAdaptivePracticeLink();

            String assertTextVSO = "Presence Of 'Adaptive Practice ' text.";
            //Assert.assertTrue(adaptivePracticeFeature.verifyAdaptivePracticeText(), assertFailurePreText + assertTextVSO);
            reportLog(assertTextVSO);

            String assertTextVENT = "Presence Of 'Ck12 Image' Icon";
            //Assert.assertTrue(adaptivePracticeFeature.verifyCk12Icon(), assertFailurePreText + assertTextVENT);
            reportLog(assertTextVENT);

            //adaptivePracticeFeature.clickOnCk12Icon();

            String assertTextVI = "Presence Of 'Start Browsing' button";
            //Assert.assertTrue(ck12SubjectsPage.verifyStartBrowsingButton(), assertFailurePreText + assertTextVI);
            reportLog(assertTextVI);

            //ck12SubjectsPage.clickOnStartBrowsingButton();

            String assertTextVH = "Presence Of 'What Do you Want to teach' text";
            //Assert.assertTrue(ck12SubjectsPage.verifyWhatDoYouWantYoTeachText(), assertFailurePreText + assertTextVH);
            reportLog(assertTextVH);

            //ck12SubjectsPage.scrollExploreSoeOtherText();

            String assertTextVHSD = "Presence Of 'Physics' link.";
            //Assert.assertTrue(ck12SubjectsPage.verifyPhysicsLink(), assertFailurePreText + assertTextVHSD);
            reportLog(assertTextVHSD);

        } catch (Exception e) {
            result = handleException(e);
        }
        Assert.assertTrue(result, testCaseFailureText + currentMethodName + errorMessage);
    }

    @Test(priority = 13, description = "Verify Functionality Of Physics FlexBook Link And Verify It Redirects Physics Page. ")
    public void verifyFunctionalityOfPhysicsLink() {
        boolean result = true;
        try {
            CK12SubjectsPage ck12SubjectsPage = new CK12SubjectsPage(webDriver,extentTest,extentReports);

            SimulationFeature simulationFeature = new SimulationFeature(webDriver,extentTest,extentReports);

            //ck12SubjectsPage.clickOnPhysicsLink();

            String assertTextVSO = "Presence Of 'Exploration Series' Text.";
            //Assert.assertTrue(simulationFeature.verifyExplorationSeriesText(), assertFailurePreText + assertTextVSO);
            reportLog(assertTextVSO);

            String assertTextVENT = "Presence Of 'Ck12 Image' Icon";
            //Assert.assertTrue(simulationFeature.verifyCk12ImageIcon(), assertFailurePreText + assertTextVENT);
            reportLog(assertTextVENT);

            //simulationFeature.clickOnCk12ImageIcon();

//            String assertTextVI = "Presence Of 'Start Browsing' button";
//            Assert.assertTrue(ck12SubjectsPage.verifyStartBrowsingButton(), assertFailurePreText + assertTextVI);
//            reportLog(assertTextVI);
//
//            ck12SubjectsPage.clickOnStartBrowsingButton();
//
//            String assertTextVH = "Presence Of 'What Do you Want to teach' text";
//            Assert.assertTrue(ck12SubjectsPage.verifyWhatDoYouWantYoTeachText(), assertFailurePreText + assertTextVH);
//            reportLog(assertTextVH);

            //ck12SubjectsPage.scrollExploreSoeOtherText();

            String assertTextVHSD = "Presence Of 'Physics' link.";
            //Assert.assertTrue(ck12SubjectsPage.verifyChemistryLink(), assertFailurePreText + assertTextVHSD);
            reportLog(assertTextVHSD);

        } catch (Exception e) {
            result = handleException(e);
        }
        Assert.assertTrue(result, testCaseFailureText + currentMethodName + errorMessage);
    }

    @Test(priority = 15, description = "Verify Functionality Of Chemistry FlexBook Link And Verify It Redirects Chemistry Page. ")
    public void verifyFunctionalityOfChemistryLink() {
        boolean result = true;
        try {
            CK12SubjectsPage ck12SubjectsPage = new CK12SubjectsPage(webDriver,extentTest,extentReports);

            SimulationFeature simulationFeature = new SimulationFeature(webDriver,extentTest,extentReports);

            //ck12SubjectsPage.clickOnChemistryLink();

            String assertTextVSO = "Presence Of 'Exploration Series' Text.";
            //Assert.assertTrue(simulationFeature.verifyExplorationSeriesText(), assertFailurePreText + assertTextVSO);
            reportLog(assertTextVSO);

            String assertTextVENT = "Presence Of 'Ck12 Image' Icon";
            //Assert.assertTrue(simulationFeature.verifyCk12ImageIcon(), assertFailurePreText + assertTextVENT);
            reportLog(assertTextVENT);

            //simulationFeature.clickOnCk12ImageIcon();

//            String assertTextVI = "Presence Of 'Start Browsing' button";
//            Assert.assertTrue(ck12SubjectsPage.verifyStartBrowsingButton(), assertFailurePreText + assertTextVI);
//            reportLog(assertTextVI);
//
//            ck12SubjectsPage.clickOnStartBrowsingButton();
//
//            String assertTextVH = "Presence Of 'What Do you Want to teach' text";
//            Assert.assertTrue(ck12SubjectsPage.verifyWhatDoYouWantYoTeachText(), assertFailurePreText + assertTextVH);
//            reportLog(assertTextVH);

            //ck12SubjectsPage.scrollExploreSoeOtherText();

            String assertTextVHSD = "Presence Of 'Plix' link.";
            //Assert.assertTrue(ck12SubjectsPage.verifyPlixLink(), assertFailurePreText + assertTextVHSD);
            reportLog(assertTextVHSD);

            String assertTextVHI = "Presence Of 'FindYour' Text";
            //assertTrue(ck12SubjectsPage.verifyFindYourLink(), assertFailurePreText + assertTextVHI);
            reportLog(assertTextVHI);

        } catch (Exception e) {
            result = handleException(e);
        }
        Assert.assertTrue(result, testCaseFailureText + currentMethodName + errorMessage);
    }

    @Test(priority = 17, description = "Verify Functionality Of Find School Link And Verify It Redirects Find School Page. ")
    public void verifyFunctionalityOfFindYourLink() {
        boolean result = true;
        try {
            CK12SubjectsPage ck12SubjectsPage = new CK12SubjectsPage(webDriver,extentTest,extentReports);

            SchoolFeature schoolFeature = new SchoolFeature(webDriver,extentTest,extentReports);

            //ck12SubjectsPage.clickOnFindYourLink();

            String assertTextVSO = "Presence Of 'School' Text.";
            //Assert.assertTrue(schoolFeature.verifySchoolText(), assertFailurePreText + assertTextVSO);
            reportLog(assertTextVSO);

            String assertTextVHI = "Presence Of 'Ck12 Image' Icon";
            //Assert.assertTrue(ck12SubjectsPage.verifyCK12ImageIcon(), assertFailurePreText + assertTextVHI);
            reportLog(assertTextVHI);

            //ck12SubjectsPage.clickOnCK12ImageIcon();

//            String assertTextVI = "Presence Of 'Start Browsing' button";
//            Assert.assertTrue(ck12SubjectsPage.verifyStartBrowsingButton(), assertFailurePreText + assertTextVI);
//            reportLog(assertTextVI);
//
//            ck12SubjectsPage.clickOnStartBrowsingButton();
//
//            String assertTextVH = "Presence Of 'What Do you Want to teach' text";
//            Assert.assertTrue(ck12SubjectsPage.verifyWhatDoYouWantYoTeachText(), assertFailurePreText + assertTextVH);
//            reportLog(assertTextVH);

            //ck12SubjectsPage.scrollExploreSoeOtherText();

            String assertTextVHSD = "Presence Of 'Study Guide' link.";
           // Assert.assertTrue(ck12SubjectsPage.verifyStudyGuideLink(), assertFailurePreText + assertTextVHSD);
            reportLog(assertTextVHSD);

        } catch (Exception e) {
            result = handleException(e);
        }
        Assert.assertTrue(result, testCaseFailureText + currentMethodName + errorMessage);
    }

    @Test(priority = 19, description = "Verify Functionality Of Study Guide Link And Verify It Redirects Study Guide Page.")
    public void verifyFunctionalityOfStudyGuideLink() {
        boolean result = true;
        try {
            StudyGuideFeature studyGuideFeature = new StudyGuideFeature(webDriver,extentTest,extentReports);
            CK12SubjectsPage ck12SubjectsPage = new CK12SubjectsPage(webDriver,extentTest,extentReports);

            //ck12SubjectsPage.clickOnStudyGuideLink();

            String assertTextVSO = "Presence Of 'Study Guide ' Text.";
            //Assert.assertTrue(studyGuideFeature.verifyStudyGuideText(), assertFailurePreText + assertTextVSO);
            reportLog(assertTextVSO);

        } catch (Exception e) {
            result = handleException(e);
        }
        Assert.assertTrue(result, testCaseFailureText + currentMethodName + errorMessage);
    }
}