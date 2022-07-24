package testscripts.regression.InvalidTestCases;

import com.relevantcodes.extentreports.LogStatus;
import org.apache.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.Test;
import testscripts.BaseTestScript;
import uipages.flexbook2feature.CBookLandingPage;
import uipages.flexbook2feature.CK12SubjectsPage;

public class CK12LandingPageSubjectsTest extends BaseTestScript {
    private static final Logger logger = Logger.getLogger(CK12LandingPageSubjectsTest.class);

    public String assertSuccessPreText = "Successfully verified: ";
    public String testCaseFailureText = "Test failed for method: ";
    public String assertFailurePreText = "Failed to verify: ";
    CBookLandingPage cBookLandingPage;
    CK12SubjectsPage ck12SubjectsPage;



    @Test(priority = 1, description = "Verify 'Arithmetic' Subject is redirects to Arithmetic subject page.")
    public void verifyTheFunctionalityOfArithmeticSubjectLink() {
        boolean result = true;
        try {
            cBookLandingPage = new CBookLandingPage(webDriver,extentTest,extentReports);
            ck12SubjectsPage = new CK12SubjectsPage(webDriver,extentTest,extentReports);

            cBookLandingPage.scrollToElement();
            cBookLandingPage.clickOnArithmeticSubjectLink();

            String assertTextVTLOCOS = "Presence of Arithmetic subject page.";
            Assert.assertTrue(ck12SubjectsPage.verifyTheListOfChaptersOfSubject(), assertFailurePreText + assertTextVTLOCOS);
            reportLog(assertTextVTLOCOS);

        } catch (Exception e) {
            result = handleException(e);
        }
        Assert.assertTrue(result, testCaseFailureText + currentMethodName + errorMessage);
    }

    @Test(priority = 2, description = "Verify 'Measurement' Subject is redirects to Measurement subject page.")
    public void verifyTheFunctionalityOfMeasurementSubjectLink() {
        boolean result = true;
        try {
            webDriver.navigate().back();
            cBookLandingPage.clickOnMeasurementSubjectLink();

            String assertTextVTLOCOS = "Presence of Measurement subject page.";
            Assert.assertTrue(ck12SubjectsPage.verifyTheListOfChaptersOfSubject(), assertFailurePreText + assertTextVTLOCOS);
            reportLog(assertTextVTLOCOS);

        } catch (Exception e) {
            result = handleException(e);
        }
        Assert.assertTrue(result, testCaseFailureText + currentMethodName + errorMessage);
    }

    @Test(priority = 3, description = "Verify 'Algebra' Subject is redirects to Algebra subject page.")
    public void verifyTheFunctionalityOfAlgebraSubjectLink() {
        boolean result = true;
        try {
            webDriver.navigate().back();
            cBookLandingPage.clickOnAlgebraSubjectLink();

            String assertTextVTLOCOS = "Presence of Algebra subject page.";
            Assert.assertTrue(ck12SubjectsPage.verifyTheListOfChaptersOfSubject(), assertFailurePreText + assertTextVTLOCOS);
            reportLog(assertTextVTLOCOS);

        } catch (Exception e) {
            result = handleException(e);
        }
        Assert.assertTrue(result, testCaseFailureText + currentMethodName + errorMessage);
    }

    @Test(priority = 4, description = "Verify 'Geometry' Subject is redirects to Geometry subject page.")
    public void verifyTheFunctionalityOfGeometrySubjectLink() {
        boolean result = true;
        try {
            webDriver.navigate().back();
            cBookLandingPage.clickOnGeometrySubjectLink();

            String assertTextVTLOCOS = "Presence of Geometry subject page.";
            Assert.assertTrue(ck12SubjectsPage.verifyTheListOfChaptersOfSubject(), assertFailurePreText + assertTextVTLOCOS);
            reportLog(assertTextVTLOCOS);

        } catch (Exception e) {
            result = handleException(e);
        }
        Assert.assertTrue(result, testCaseFailureText + currentMethodName + errorMessage);
    }

    @Test(priority = 5, description = "Verify 'Probability' Subject is redirects to  Probability subject page.")
    public void verifyTheFunctionalityOfProbabilitySubjectLink() {
        boolean result = true;
        try {
            webDriver.navigate().back();
            cBookLandingPage.clickOnProbabiliySubjectLink();

            String assertTextVTLOCOS = "Presence of Probability subject page.";
            Assert.assertTrue(ck12SubjectsPage.verifyTheListOfChaptersOfSubject(), assertFailurePreText + assertTextVTLOCOS);
            reportLog(assertTextVTLOCOS);

        } catch (Exception e) {
            result = handleException(e);
        }
        Assert.assertTrue(result, testCaseFailureText + currentMethodName + errorMessage);
    }

    @Test(priority = 6, description = "Verify 'Statistics' Subject is redirects to  Statistics subject page.")
    public void verifyTheFunctionalityOfStatisticsSubjectLink() {
        boolean result = true;
        try {
            webDriver.navigate().back();
            cBookLandingPage.clickOnStatisticsSubjectLink();

            String assertTextVTLOCOS = "Presence of Statistics subject page.";
            Assert.assertTrue(ck12SubjectsPage.verifyTheListOfChaptersOfSubject(), assertFailurePreText + assertTextVTLOCOS);
            reportLog(assertTextVTLOCOS);

        } catch (Exception e) {
            result = handleException(e);
        }
        Assert.assertTrue(result, testCaseFailureText + currentMethodName + errorMessage);
    }
}