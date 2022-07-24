package testscripts.regression.interactives;

import org.apache.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.Test;
import testscripts.BaseTestScript;
import uipages.BasePage;
import uipages.flexbook2feature.InteractivesPage;

/**
 * @author Tanmay Kashettiwar
 */

public class GeometryUnitElevenInteractiveTest extends BaseTestScript {
    private static final Logger logger = Logger.getLogger(GeometryUnitOneInteractivesTest.class);
    private String testCaseFailureText = "Test failed for method: ";
    private String assertFailurePreText = "Failed to verify: ";
    public String assertSuccessPreText = "Successfully verified: ";
    private InteractivesPage interactivesPage;
    private BasePage basePage;
    private String unit = "unit11";

    @Test(priority = 1, description = "Verify the Interactives of 11.1 Descriptions of Events concept of Geometry book.")
    public void verifyInteractivesOfDescriptionsOfEventsConcept() {
        boolean result = true;
        try {
            interactivesPage = new InteractivesPage(webDriver, extentTest, extentReports);
            basePage = new BasePage(webDriver, extentTest, extentReports);

            String url = "https://flexbooks.ck12.org/cbook/ck-12-interactive-geometry-for-ccss/section/11.1/primary/lesson/descriptions-of-events-geo-ccss/";
            webDriver.navigate().to(url);

            for (int i = 0; i <= 21; i++) {
                scrollByPixel(300);
                basePage.waitForSec(3);
            }
            Assert.assertTrue(interactivesPage.verifyGeometrySmartPhases("Descriptions of Events", unit), assertFailurePreText + "Presence of Interactives on the 11.1 concept of geometry book.");
            reportLog("Presence of Interactives on the 11.1 concept of geometry book.");

        } catch (Exception e) {
            result = handleException(e);
        }
        Assert.assertTrue(result, testCaseFailureText + currentMethodName + errorMessage);
    }

    @Test(priority = 2, description = "Verify the Interactives of 11.2 Independent Events concept of Geometry book.")
    public void verifyInteractivesOfIndependentEventsConcept() {
        boolean result = true;
        try {
            String url = "https://flexbooks.ck12.org/cbook/ck-12-interactive-geometry-for-ccss/section/11.2/primary/lesson/independent-events-geo-ccss/";
            webDriver.navigate().to(url);

            for (int i = 0; i <= 21; i++) {
                scrollByPixel(300);
                basePage.waitForSec(3);
            }
            Assert.assertTrue(interactivesPage.verifyGeometrySmartPhases("Independent Events", unit), assertFailurePreText + "Presence of Interactives on the 11.2 concept of geometry book.");
            reportLog("Presence of Interactives on the 11.2 concept of geometry book.");

            Assert.assertTrue(interactivesPage.verifyDraggableInteractive("11_2_0e", unit), assertFailurePreText + "Presence of Draggable Interactives on the 11.2 concept of geometry book.");
            reportLog("Presence of Draggable Interactives on the 11.2 concept of geometry book.");

        } catch (Exception e) {
            result = handleException(e);
        }
        Assert.assertTrue(result, testCaseFailureText + currentMethodName + errorMessage);
    }

    @Test(priority = 3, description = "Verify the Interactives of 11.3 Conditional Probability concept of Geometry book.")
    public void verifyInteractivesOfConditionalProbabilityConcept() {
        boolean result = true;
        try {
            String url = "https://flexbooks.ck12.org/cbook/ck-12-interactive-geometry-for-ccss/section/11.3/primary/lesson/conditional-probability-geo-ccss/";
            webDriver.navigate().to(url);

            for (int i = 0; i <= 21; i++) {
                scrollByPixel(300);
                basePage.waitForSec(3);
            }
            Assert.assertTrue(interactivesPage.verifyGeometrySmartPhases("Conditional Probability", unit), assertFailurePreText + "Presence of Interactives on the 11.3 concept of geometry book.");
            reportLog("Presence of Interactives on the 11.3 concept of geometry book.");

        } catch (Exception e) {
            result = handleException(e);
        }
        Assert.assertTrue(result, testCaseFailureText + currentMethodName + errorMessage);
    }

    @Test(priority = 4, description = "Verify the Interactives of 11.4 Two-Way Frequency Tables concept of Geometry book.")
    public void verifyInteractivesOfTwoWayFrequencyTablesConcept() {
        boolean result = true;
        try {
            String url = "https://flexbooks.ck12.org/cbook/ck-12-interactive-geometry-for-ccss/section/11.4/primary/lesson/two-way-frequency-tables-geo-ccss/";
            webDriver.navigate().to(url);

            for (int i = 0; i <= 21; i++) {
                scrollByPixel(300);
                basePage.waitForSec(3);
            }
            Assert.assertTrue(interactivesPage.verifyGeometrySmartPhases("Two-Way Frequency Tables", unit), assertFailurePreText + "Presence of Interactives on the 11.4 concept of geometry book.");
            reportLog("Presence of Interactives on the 11.4 concept of geometry book.");

        } catch (Exception e) {
            result = handleException(e);
        }
        Assert.assertTrue(result, testCaseFailureText + currentMethodName + errorMessage);
    }

    @Test(priority = 5, description = "Verify the Interactives of 11.5 Everyday Examples of Independence and Probability concept of Geometry book.")
    public void verifyInteractivesOfEverydayExamplesOfIndependenceAndProbabilityConcept() {
        boolean result = true;
        try {
            String url = "https://flexbooks.ck12.org/cbook/ck-12-interactive-geometry-for-ccss/section/11.5/primary/lesson/everyday-examples-of-independence-and-probability-geo-ccss/";
            webDriver.navigate().to(url);

            for (int i = 0; i <= 21; i++) {
                scrollByPixel(300);
                basePage.waitForSec(3);
            }
            Assert.assertTrue(interactivesPage.verifyGeometrySmartPhases("Everyday Examples of Independence and Probability", unit), assertFailurePreText + "Presence of Interactives on the 11.5 concept of geometry book.");
            reportLog("Presence of Interactives on the 11.5 concept of geometry book.");

        } catch (Exception e) {
            result = handleException(e);
        }
        Assert.assertTrue(result, testCaseFailureText + currentMethodName + errorMessage);
    }

    @Test(priority = 6, description = "Verify the Interactives of 11.6 Probability of Unions concept of Geometry book.")
    public void verifyInteractivesOfProbabilityOfUnionsConcept() {
        boolean result = true;
        try {
            String url = "https://flexbooks.ck12.org/cbook/ck-12-interactive-geometry-for-ccss/section/11.6/primary/lesson/probability-of-unions-geo-ccss/";
            webDriver.navigate().to(url);

            for (int i = 0; i <= 21; i++) {
                scrollByPixel(300);
                basePage.waitForSec(3);
            }
            Assert.assertTrue(interactivesPage.verifyGeometrySmartPhases("Probability of Unions", unit), assertFailurePreText + "Presence of Interactives on the 11.6 concept of geometry book.");
            reportLog("Presence of Interactives on the 11.6 concept of geometry book.");

            Assert.assertTrue(interactivesPage.verifyEquationInteractive("11_6_5", unit), assertFailurePreText + "Presence of Equation Interactives on the 11.6 concept of geometry book.");
            reportLog("Presence of Equation Interactives on the 11.6 concept of geometry book.");

        } catch (Exception e) {
            result = handleException(e);
        }
        Assert.assertTrue(result, testCaseFailureText + currentMethodName + errorMessage);
    }

    @Test(priority = 7, description = "Verify the Interactives of 11.7 Probability of Intersections concept of Geometry book.")
    public void verifyInteractivesOfProbabilityOfIntersectionsConcept() {
        boolean result = true;
        try {
            String url = "https://flexbooks.ck12.org/cbook/ck-12-interactive-geometry-for-ccss/section/11.7/primary/lesson/probability-of-intersections-geo-ccss/";
            webDriver.navigate().to(url);

            for (int i = 0; i <= 21; i++) {
                scrollByPixel(300);
                basePage.waitForSec(3);
            }
            Assert.assertTrue(interactivesPage.verifyGeometrySmartPhases("Probability of Intersections", unit), assertFailurePreText + "Presence of Interactives on the 11.7 concept of geometry book.");
            reportLog("Presence of Interactives on the 11.7 concept of geometry book.");

        } catch (Exception e) {
            result = handleException(e);
        }
        Assert.assertTrue(result, testCaseFailureText + currentMethodName + errorMessage);
    }

    @Test(priority = 8, description = "Verify the Interactives of 11.8 Permutations and Combinations concept of Geometry book.")
    public void verifyInteractivesOfPermutationsAndCombinationsConcept() {
        boolean result = true;
        try {
            String url = "https://flexbooks.ck12.org/cbook/ck-12-interactive-geometry-for-ccss/section/11.8/primary/lesson/permutations-and-combinations-geo-ccss/";
            webDriver.navigate().to(url);

            for (int i = 0; i <= 21; i++) {
                scrollByPixel(300);
                basePage.waitForSec(3);
            }
            Assert.assertTrue(interactivesPage.verifyGeometrySmartPhases("Permutations and Combinations", unit), assertFailurePreText + "Presence of Interactives on the 11.8 concept of geometry book.");
            reportLog("Presence of Interactives on the 11.8 concept of geometry book.");

        } catch (Exception e) {
            result = handleException(e);
        }
        Assert.assertTrue(result, testCaseFailureText + currentMethodName + errorMessage);
    }

    @Test(priority = 9, description = "Verify the Interactives of 11.9 Probability to Analyze Fairness and Decisions concept of Geometry book.")
    public void verifyInteractivesOfProbabilityToAnalyzeFairnessAndDecisionsConcept() {
        boolean result = true;
        try {
            String url = "https://flexbooks.ck12.org/cbook/ck-12-interactive-geometry-for-ccss/section/11.9/primary/lesson/probability-to-analyze-fairness-and-decisions-geo-ccss/";
            webDriver.navigate().to(url);

            for (int i = 0; i <= 21; i++) {
                scrollByPixel(300);
                basePage.waitForSec(3);
            }
            Assert.assertTrue(interactivesPage.verifyGeometrySmartPhases("Probability to Analyze Fairness and Decisions", unit), assertFailurePreText + "Presence of Interactives on the 11.9 concept of geometry book.");
            reportLog("Presence of Interactives on the 11.9 concept of geometry book.");

        } catch (Exception e) {
            result = handleException(e);
        }
        Assert.assertTrue(result, testCaseFailureText + currentMethodName + errorMessage);
    }
}
