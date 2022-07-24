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

public class GeometryUnitSixInteractiveTest extends BaseTestScript {
    private static final Logger logger = Logger.getLogger(GeometryUnitOneInteractivesTest.class);
    private String testCaseFailureText = "Test failed for method: ";
    private String assertFailurePreText = "Failed to verify: ";
    public String assertSuccessPreText = "Successfully verified: ";
    private InteractivesPage interactivesPage;
    private BasePage basePage;
    private String unit = "unit6";

    @Test(priority = 1, description = "Verify the Interactives of 6.1 Dilations concept of Geometry book.")
    public void verifyInteractivesOfDilationsConcept() {
        boolean result = true;
        try {
            interactivesPage = new InteractivesPage(webDriver, extentTest, extentReports);
            basePage = new BasePage(webDriver, extentTest, extentReports);

            String url = "https://flexbooks.ck12.org/cbook/ck-12-interactive-geometry-for-ccss/section/6.1/primary/lesson/dilations-geo-ccss/";
            webDriver.navigate().to(url);

            for (int i = 0; i <= 40; i++) {
                scrollByPixel(300);
                basePage.waitForSec(3);
            }
            Assert.assertTrue(interactivesPage.verifyGeometrySmartPhases("Dilations", unit), assertFailurePreText + "Presence of Interactives on the 6.1 concept of geometry book.");
            reportLog("Presence of Interactives on the 6.1 concept of geometry book.");

            Assert.assertTrue(interactivesPage.verifyEquationInteractive("6_1_6", unit), assertFailurePreText + "Presence of Equation Interactives on the 6.1 concept of geometry book.");
            reportLog("Presence of Equation Interactives on the 6.1 concept of geometry book.");

            Assert.assertTrue(interactivesPage.verifyEquationInteractive("6_1_7", unit), assertFailurePreText + "Presence of Equation Interactives on the 6.1 concept of geometry book.");
            reportLog("Presence of Equation Interactives on the 6.1 concept of geometry book.");

            Assert.assertTrue(interactivesPage.verifyEquationInteractive("6_1_8", unit), assertFailurePreText + "Presence of Equation Interactives on the 6.1 concept of geometry book.");
            reportLog("Presence of Equation Interactives on the 6.1 concept of geometry book.");

            Assert.assertTrue(interactivesPage.verifyDraggableInteractive("6_1_9", unit), assertFailurePreText + "Presence of Draggable Interactives on the 6.1 concept of geometry book.");
            reportLog("Presence of Draggable Interactives on the 6.1 concept of geometry book.");

        } catch (Exception e) {
            result = handleException(e);
        }
        Assert.assertTrue(result, testCaseFailureText + currentMethodName + errorMessage);
    }

    @Test(priority = 2, description = "Verify the Interactives of 6.2 Definition of Similarity concept of Geometry book.")
    public void verifyInteractivesOfDefinitionOfSimilarityConcept() {
        boolean result = true;
        try {
            String url = "https://flexbooks.ck12.org/cbook/ck-12-interactive-geometry-for-ccss/section/6.2/primary/lesson/definition-of-similarity-geo-ccss/";
            webDriver.navigate().to(url);

            for (int i = 0; i <= 40; i++) {
                scrollByPixel(300);
                basePage.waitForSec(3);
            }
            Assert.assertTrue(interactivesPage.verifyGeometrySmartPhases("Definition of Similarity", unit), assertFailurePreText + "Presence of Interactives on the 6.2 concept of geometry book.");
            reportLog("Presence of Interactives on the 6.2 concept of geometry book.");

        } catch (Exception e) {
            result = handleException(e);
        }
        Assert.assertTrue(result, testCaseFailureText + currentMethodName + errorMessage);
    }

    @Test(priority = 3, description = "Verify the Interactives of 6.3 AA Triangle Similarity concept of Geometry book.")
    public void verifyInteractivesOfAATriangleSimilarityConcept() {
        boolean result = true;
        try {
            String url = "https://flexbooks.ck12.org/cbook/ck-12-interactive-geometry-for-ccss/section/6.3/primary/lesson/aa-triangle-similarity-geo-ccss/";
            webDriver.navigate().to(url);

            for (int i = 0; i <= 40; i++) {
                scrollByPixel(300);
                basePage.waitForSec(3);
            }
            Assert.assertTrue(interactivesPage.verifyGeometrySmartPhases("AA Triangle Similarity", unit), assertFailurePreText + "Presence of Interactives on the 6.3 concept of geometry book.");
            reportLog("Presence of Interactives on the 6.3 concept of geometry book.");

            Assert.assertTrue(interactivesPage.verifyDraggableInteractive("6_3_2", unit), assertFailurePreText + "Presence of Draggable Interactives on the 6.3 concept of geometry book.");
            reportLog("Presence of Draggable Interactives on the 6.3 concept of geometry book.");

        } catch (Exception e) {
            result = handleException(e);
        }
        Assert.assertTrue(result, testCaseFailureText + currentMethodName + errorMessage);
    }

    @Test(priority = 4, description = "Verify the Interactives of 6.4 SAS Triangle Similarity concept of Geometry book.")
    public void verifyInteractivesOfSASTriangleSimilarityConcept() {
        boolean result = true;
        try {
            String url = "https://flexbooks.ck12.org/cbook/ck-12-interactive-geometry-for-ccss/section/6.4/primary/lesson/sas-triangle-similarity-geo-ccss/";
            webDriver.navigate().to(url);

            for (int i = 0; i <= 40; i++) {
                scrollByPixel(300);
                basePage.waitForSec(3);
            }
            Assert.assertTrue(interactivesPage.verifyGeometrySmartPhases("SAS Triangle Similarity", unit), assertFailurePreText + "Presence of Interactives on the 6.4 concept of geometry book.");
            reportLog("Presence of Interactives on the 6.4 concept of geometry book.");

            Assert.assertTrue(interactivesPage.verifyDraggableInteractive("6_4_1a", unit), assertFailurePreText + "Presence of Draggable Interactives on the 6.4 concept of geometry book.");
            reportLog("Presence of Draggable Interactives on the 6.4 concept of geometry book.");

        } catch (Exception e) {
            result = handleException(e);
        }
        Assert.assertTrue(result, testCaseFailureText + currentMethodName + errorMessage);
    }

    @Test(priority = 5, description = "Verify the Interactives of 6.5 SSS Triangle Similarity concept of Geometry book.")
    public void verifyInteractivesOfSSSTriangleSimilarityConcept() {
        boolean result = true;
        try {
            String url = "https://flexbooks.ck12.org/cbook/ck-12-interactive-geometry-for-ccss/section/6.5/primary/lesson/sss-triangle-similarity-geo-ccss/";
            webDriver.navigate().to(url);

            for (int i = 0; i <= 40; i++) {
                scrollByPixel(300);
                basePage.waitForSec(3);
            }
            Assert.assertTrue(interactivesPage.verifyGeometrySmartPhases("SSS Triangle Similarity", unit), assertFailurePreText + "Presence of Interactives on the 6.5 concept of geometry book.");
            reportLog("Presence of Interactives on the 6.5 concept of geometry book.");

            Assert.assertTrue(interactivesPage.verifyDraggableInteractive("6_5_2", unit), assertFailurePreText + "Presence of Draggable Interactives on the 6.5 concept of geometry book.");
            reportLog("Presence of Draggable Interactives on the 6.5 concept of geometry book.");

        } catch (Exception e) {
            result = handleException(e);
        }
        Assert.assertTrue(result, testCaseFailureText + currentMethodName + errorMessage);
    }

    @Test(priority = 6, description = "Verify the Interactives of 6.6 Theorems Involving Similarity concept of Geometry book.")
    public void verifyInteractivesOfTheoremsInvolvingSimilarityConcept() {
        boolean result = true;
        try {
            String url = "https://flexbooks.ck12.org/cbook/ck-12-interactive-geometry-for-ccss/section/4.6/primary/lesson/applications-of-triangle-theorems-geo-ccss/";
            webDriver.navigate().to(url);

            for (int i = 0; i <= 40; i++) {
                scrollByPixel(300);
                basePage.waitForSec(3);
            }
            Assert.assertTrue(interactivesPage.verifyGeometrySmartPhases("Theorems Involving Similarity", unit), assertFailurePreText + "Presence of Interactives on the 6.6 concept of geometry book.");
            reportLog("Presence of Interactives on the 6.6 concept of geometry book.");

        } catch (Exception e) {
            result = handleException(e);
        }
        Assert.assertTrue(result, testCaseFailureText + currentMethodName + errorMessage);
    }

    @Test(priority = 7, description = "Verify the Interactives of 6.7 Applications of Similar Triangles concept of Geometry book.")
    public void verifyInteractivesOfApplicationsOfSimilarTrianglesConcept() {
        boolean result = true;
        try {
            String url = "https://flexbooks.ck12.org/cbook/ck-12-interactive-geometry-for-ccss/section/6.7/primary/lesson/applications-of-similar-triangles-geo-ccss/";
            webDriver.navigate().to(url);

            for (int i = 0; i <= 40; i++) {
                scrollByPixel(300);
                basePage.waitForSec(3);
            }
            Assert.assertTrue(interactivesPage.verifyGeometrySmartPhases("Applications of Similar Triangles", unit), assertFailurePreText + "Presence of Interactives on the 6.7 concept of geometry book.");
            reportLog("Presence of Interactives on the 6.7 concept of geometry book.");

        } catch (Exception e) {
            result = handleException(e);
        }
        Assert.assertTrue(result, testCaseFailureText + currentMethodName + errorMessage);
    }
}
