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

public class GeometryUnitEightInteractiveTest extends BaseTestScript {
    private static final Logger logger = Logger.getLogger(GeometryUnitOneInteractivesTest.class);
    private String testCaseFailureText = "Test failed for method: ";
    private String assertFailurePreText = "Failed to verify: ";
    public String assertSuccessPreText = "Successfully verified: ";
    private InteractivesPage interactivesPage;
    private BasePage basePage;
    private String unit = "unit8";

    @Test(priority = 1, description = "Verify the Interactives of 8.1 Circles and Similarity concept of Geometry book.")
    public void verifyInteractivesOfCirclesAndSimilarityConcept() {
        boolean result = true;
        try {
            interactivesPage = new InteractivesPage(webDriver, extentTest, extentReports);
            basePage = new BasePage(webDriver, extentTest, extentReports);

            String url = "https://flexbooks.ck12.org/cbook/ck-12-interactive-geometry-for-ccss/section/8.1/primary/lesson/circles-and-similarity-geo-ccss/";
            webDriver.navigate().to(url);

            for (int i = 0; i <= 40; i++) {
                scrollByPixel(300);
                basePage.waitForSec(3);
            }
            Assert.assertTrue(interactivesPage.verifyGeometrySmartPhases("Circles and Similarity", unit), assertFailurePreText + "Presence of Interactives on the 8.1 concept of geometry book.");
            reportLog("Presence of Interactives on the 8.1 concept of geometry book.");

        } catch (Exception e) {
            result = handleException(e);
        }
        Assert.assertTrue(result, testCaseFailureText + currentMethodName + errorMessage);
    }

    @Test(priority = 2, description = "Verify the Interactives of 8.2 Area and Circumference of Circles concept of Geometry book.")
    public void verifyInteractivesOfAreaAndCircumferenceOfCirclesConcept() {
        boolean result = true;
        try {
            String url = "https://flexbooks.ck12.org/cbook/ck-12-interactive-geometry-for-ccss/section/8.2/primary/lesson/area-and-circumference-of-circles-geo-ccss/";
            webDriver.navigate().to(url);

            for (int i = 0; i <= 40; i++) {
                scrollByPixel(300);
                basePage.waitForSec(3);
            }
            Assert.assertTrue(interactivesPage.verifyGeometrySmartPhases("Area and Circumference of Circles", unit), assertFailurePreText + "Presence of Interactives on the 8.2 concept of geometry book.");
            reportLog("Presence of Interactives on the 8.2 concept of geometry book.");

            Assert.assertTrue(interactivesPage.verifyDraggableInteractive("8_2_4", unit), assertFailurePreText + "Presence of Draggable Interactives on the 8.2 concept of geometry book.");
            reportLog("Presence of Draggable Interactives on the 8.2 concept of geometry book.");

            Assert.assertTrue(interactivesPage.verifyPolygonPiDiagram(), assertFailurePreText + "Presence of Draggable Interactives on the 8.2 concept of geometry book.");
            reportLog("Presence of Draggable Interactives on the 8.2 concept of geometry book.");

        } catch (Exception e) {
            result = handleException(e);
        }
        Assert.assertTrue(result, testCaseFailureText + currentMethodName + errorMessage);
    }

    @Test(priority = 3, description = "Verify the Interactives of 8.3 Central Angles and Chords concept of Geometry book.")
    public void verifyInteractivesOfSpheresConcept() {
        boolean result = true;
        try {
            String url = "https://flexbooks.ck12.org/cbook/ck-12-interactive-geometry-for-ccss/section/8.3/primary/lesson/central-angles-and-chords-geo-ccss/";
            webDriver.navigate().to(url);

            for (int i = 0; i <= 40; i++) {
                scrollByPixel(300);
                basePage.waitForSec(3);
            }
            Assert.assertTrue(interactivesPage.verifyGeometrySmartPhases("Central Angles and Chords", unit), assertFailurePreText + "Presence of Interactives on the 8.3 concept of geometry book.");
            reportLog("Presence of Interactives on the 8.3 concept of geometry book.");

            Assert.assertTrue(interactivesPage.verifyDraggableInteractive("8_3_3", unit), assertFailurePreText + "Presence of Draggable Interactives on the 8.3 concept of geometry book.");
            reportLog("Presence of Draggable Interactives on the 8.3 concept of geometry book.");

        } catch (Exception e) {
            result = handleException(e);
        }
        Assert.assertTrue(result, testCaseFailureText + currentMethodName + errorMessage);
    }

    @Test(priority = 4, description = "Verify the Interactives of 8.4 Inscribed Angles concept of Geometry book.")
    public void verifyInteractivesOfInscribedAnglesConcept() {
        boolean result = true;
        try {
            String url = "https://flexbooks.ck12.org/cbook/ck-12-interactive-geometry-for-ccss/section/8.4/primary/lesson/inscribed-angles-geo-ccss/";
            webDriver.navigate().to(url);

            for (int i = 0; i <= 40; i++) {
                scrollByPixel(300);
                basePage.waitForSec(3);
            }
            Assert.assertTrue(interactivesPage.verifyGeometrySmartPhases("Inscribed Angles", unit), assertFailurePreText + "Presence of Interactives on the 8.4 concept of geometry book.");
            reportLog("Presence of Interactives on the 8.4 concept of geometry book.");

            Assert.assertTrue(interactivesPage.verifyDraggableInteractive("8_4_4a_Interactive", unit), assertFailurePreText + "Presence of Draggable Interactives on the 8.4 concept of geometry book.");
            reportLog("Presence of Draggable Interactives on the 8.4 concept of geometry book.");

            Assert.assertTrue(interactivesPage.verifyDraggableInteractive("8_4_8a_Interactive", unit), assertFailurePreText + "Presence of Draggable Interactives on the 8.4 concept of geometry book.");
            reportLog("Presence of Draggable Interactives on the 8.4 concept of geometry book.");

        } catch (Exception e) {
            result = handleException(e);
        }
        Assert.assertTrue(result, testCaseFailureText + currentMethodName + errorMessage);
    }

    @Test(priority = 5, description = "Verify the Interactives of 8.5 Inscribed and Circumscribed Circles of Triangles concept of Geometry book.")
    public void verifyInteractivesOfInscribedAndCircumscribedCirclesOfTrianglesConcept() {
        boolean result = true;
        try {
            String url = "https://flexbooks.ck12.org/cbook/ck-12-interactive-geometry-for-ccss/section/8.5/primary/lesson/inscribed-and-circumscribed-circles-of-triangles-geo-ccss/";
            webDriver.navigate().to(url);

            for (int i = 0; i <= 40; i++) {
                scrollByPixel(300);
                basePage.waitForSec(3);
            }
            Assert.assertTrue(interactivesPage.verifyGeometrySmartPhases("Inscribed and Circumscribed Circles of Triangles", unit), assertFailurePreText + "Presence of Interactives on the 8.5 concept of geometry book.");
            reportLog("Presence of Interactives on the 8.5 concept of geometry book.");

        } catch (Exception e) {
            result = handleException(e);
        }
        Assert.assertTrue(result, testCaseFailureText + currentMethodName + errorMessage);
    }

    @Test(priority = 6, description = "Verify the Interactives of 8.6 Quadrilaterals Inscribed in Circles concept of Geometry book.")
    public void verifyInteractivesOfQuadrilateralsInscribedInCirclesConcept() {
        boolean result = true;
        try {
            String url = "https://flexbooks.ck12.org/cbook/ck-12-interactive-geometry-for-ccss/section/8.6/primary/lesson/quadrilaterals-inscribed-in-circles-geo-ccss/";
            webDriver.navigate().to(url);

            for (int i = 0; i <= 40; i++) {
                scrollByPixel(300);
                basePage.waitForSec(3);
            }
            Assert.assertTrue(interactivesPage.verifyGeometrySmartPhases("Quadrilaterals Inscribed in Circles", unit), assertFailurePreText + "Presence of Interactives on the 8.6 concept of geometry book.");
            reportLog("Presence of Interactives on the 8.6 concept of geometry book.");

            Assert.assertTrue(interactivesPage.verifyDraggableInteractive("8_6_2_Interactive", unit), assertFailurePreText + "Presence of Draggable Interactives on the 8.6 concept of geometry book.");
            reportLog("Presence of Draggable Interactives on the 8.6 concept of geometry book.");

        } catch (Exception e) {
            result = handleException(e);
        }
        Assert.assertTrue(result, testCaseFailureText + currentMethodName + errorMessage);
    }

    @Test(priority = 7, description = "Verify the Interactives of 8.7 Tangent Lines to Circles concept of Geometry book.")
    public void verifyInteractivesOfTangentLinesToCirclesConcept() {
        boolean result = true;
        try {
            String url = "https://flexbooks.ck12.org/cbook/ck-12-interactive-geometry-for-ccss/section/8.7/primary/lesson/tangent-lines-to-circles-geo-ccss/";
            webDriver.navigate().to(url);

            for (int i = 0; i <= 40; i++) {
                scrollByPixel(300);
                basePage.waitForSec(3);
            }
            Assert.assertTrue(interactivesPage.verifyGeometrySmartPhases("Tangent Lines to Circles", unit), assertFailurePreText + "Presence of Interactives on the 8.7 concept of geometry book.");
            reportLog("Presence of Interactives on the 8.7 concept of geometry book.");

            Assert.assertTrue(interactivesPage.verifyDraggableInteractive("8_7_1", unit), assertFailurePreText + "Presence of Draggable Interactives on the 8.7 concept of geometry book.");
            reportLog("Presence of Draggable Interactives on the 8.7 concept of geometry book.");

        } catch (Exception e) {
            result = handleException(e);
        }
        Assert.assertTrue(result, testCaseFailureText + currentMethodName + errorMessage);
    }

    @Test(priority = 8, description = "Verify the Interactives of 8.8 Secant Lines to Circles concept of Geometry book.")
    public void verifyInteractivesOfSecantLinesToCirclesConcept() {
        boolean result = true;
        try {
            String url = "https://flexbooks.ck12.org/cbook/ck-12-interactive-geometry-for-ccss/section/8.8/primary/lesson/secant-lines-to-circles-geo-ccss/";
            webDriver.navigate().to(url);

            for (int i = 0; i <= 40; i++) {
                scrollByPixel(300);
                basePage.waitForSec(3);
            }

            Assert.assertTrue(interactivesPage.verifyGeometrySmartPhases("Secant Lines to Circles", unit), assertFailurePreText + "Presence of Interactives on the 8.8 concept of geometry book.");
            reportLog("Presence of Interactives on the 8.8 concept of geometry book.");

            Assert.assertTrue(interactivesPage.verifyDraggableInteractive("8_8_1", unit), assertFailurePreText + "Presence of Draggable Interactives on the 8.8 concept of geometry book.");
            reportLog("Presence of Draggable Interactives on the 8.8 concept of geometry book.");

        } catch (Exception e) {
            result = handleException(e);
        }
        Assert.assertTrue(result, testCaseFailureText + currentMethodName + errorMessage);
    }

    @Test(priority = 9, description = "Verify the Interactives of 8.9 Arc Length concept of Geometry book.")
    public void verifyInteractivesOfArcLengthConcept() {
        boolean result = true;
        try {
            String url = "https://flexbooks.ck12.org/cbook/ck-12-interactive-geometry-for-ccss/section/8.9/primary/lesson/arc-length-geo-ccss/";
            webDriver.navigate().to(url);

            for (int i = 0; i <= 40; i++) {
                scrollByPixel(300);
                basePage.waitForSec(3);
            }

            Assert.assertTrue(interactivesPage.verifyGeometrySmartPhases("Arc Length", unit), assertFailurePreText + "Presence of Interactives on the 8.9 concept of geometry book.");
            reportLog("Presence of Interactives on the 8.9 concept of geometry book.");

            Assert.assertTrue(interactivesPage.verifyDraggableInteractive("1_8_5", unit), assertFailurePreText + "Presence of Draggable Interactives on the 8.9 concept of geometry book.");
            reportLog("Presence of Draggable Interactives on the 8.9 concept of geometry book.");

        } catch (Exception e) {
            result = handleException(e);
        }
        Assert.assertTrue(result, testCaseFailureText + currentMethodName + errorMessage);
    }

    @Test(priority = 10, description = "Verify the Interactives of 8.10 Sector Area concept of Geometry book.")
    public void verifyInteractivesOfSectorAreaConcept() {
        boolean result = true;
        try {
            String url = "https://flexbooks.ck12.org/cbook/ck-12-interactive-geometry-for-ccss/section/8.10/primary/lesson/sector-area-geo-ccss/";
            webDriver.navigate().to(url);

            for (int i = 0; i <= 40; i++) {
                scrollByPixel(300);
                basePage.waitForSec(3);
            }

            Assert.assertTrue(interactivesPage.verifyGeometrySmartPhases("Sector Area", unit), assertFailurePreText + "Presence of Interactives on the 8.10 concept of geometry book.");
            reportLog("Presence of Interactives on the 8.10 concept of geometry book.");

            Assert.assertTrue(interactivesPage.verifyDraggableInteractive("8_10_4a", unit), assertFailurePreText + "Presence of Draggable Interactives on the 8.10 concept of geometry book.");
            reportLog("Presence of Draggable Interactives on the 8.10 concept of geometry book.");

        } catch (Exception e) {
            result = handleException(e);
        }
        Assert.assertTrue(result, testCaseFailureText + currentMethodName + errorMessage);
    }
}
