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

public class GeometryUnitTenInteractiveTest extends BaseTestScript {
    private static final Logger logger = Logger.getLogger(GeometryUnitOneInteractivesTest.class);
    private String testCaseFailureText = "Test failed for method: ";
    private String assertFailurePreText = "Failed to verify: ";
    public String assertSuccessPreText = "Successfully verified: ";
    private InteractivesPage interactivesPage;
    private BasePage basePage;
    private String unit = "unit10";

    @Test(priority = 1, description = "Verify the Interactives of 10.1 Conic Sections concept of Geometry book.")
    public void verifyInteractivesOfConicSectionsConcept() {
        boolean result = true;
        try {
            interactivesPage = new InteractivesPage(webDriver, extentTest, extentReports);
            basePage = new BasePage(webDriver, extentTest, extentReports);

            String url = "https://flexbooks.ck12.org/cbook/ck-12-interactive-geometry-for-ccss/section/10.1/primary/lesson/conic-sections-geo-ccss/";
            webDriver.navigate().to(url);

            for (int i = 0; i <= 21; i++) {
                scrollByPixel(300);
                basePage.waitForSec(3);
            }
            Assert.assertTrue(interactivesPage.verifyGeometrySmartPhases("Conic Sections", unit), assertFailurePreText + "Presence of Interactives on the 10.1 concept of geometry book.");
            reportLog("Presence of Interactives on the 10.1 concept of geometry book.");

        } catch (Exception e) {
            result = handleException(e);
        }
        Assert.assertTrue(result, testCaseFailureText + currentMethodName + errorMessage);
    }

    @Test(priority = 2, description = "Verify the Interactives of 10.2 Equations of Circles concept of Geometry book.")
    public void verifyInteractivesOfEquationsOfCirclesConcept() {
        boolean result = true;
        try {
            String url = "https://flexbooks.ck12.org/cbook/ck-12-interactive-geometry-for-ccss/section/10.2/primary/lesson/equations-of-circles-geo-ccss/";
            webDriver.navigate().to(url);

            for (int i = 0; i <= 21; i++) {
                scrollByPixel(300);
                basePage.waitForSec(3);
            }
            Assert.assertTrue(interactivesPage.verifyGeometrySmartPhases("Equations of Circles", unit), assertFailurePreText + "Presence of Interactives on the 10.2 concept of geometry book.");
            reportLog("Presence of Interactives on the 10.2 concept of geometry book.");

            Assert.assertTrue(interactivesPage.verifyDraggableInteractive("10_2_2", unit), assertFailurePreText + "Presence of Draggable Interactives on the 10.2 concept of geometry book.");
            reportLog("Presence of Draggable Interactives on the 10.2 concept of geometry book.");

            Assert.assertTrue(interactivesPage.verifyDraggableInteractive("10_2_3b", unit), assertFailurePreText + "Presence of Draggable Interactives on the 10.2 concept of geometry book.");
            reportLog("Presence of Draggable Interactives on the 10.2 concept of geometry book.");

        } catch (Exception e) {
            result = handleException(e);
        }
        Assert.assertTrue(result, testCaseFailureText + currentMethodName + errorMessage);
    }

    @Test(priority = 3, description = "Verify the Interactives of 10.3 Equations of Parabolas concept of Geometry book.")
    public void verifyInteractivesOfEquationsOfParabolasConcept() {
        boolean result = true;
        try {
            String url = "https://flexbooks.ck12.org/cbook/ck-12-interactive-geometry-for-ccss/section/10.3/primary/lesson/equations-of-parabolas-geo-ccss/";
            webDriver.navigate().to(url);

            for (int i = 0; i <= 21; i++) {
                scrollByPixel(300);
                basePage.waitForSec(3);
            }
            Assert.assertTrue(interactivesPage.verifyGeometrySmartPhases("Equations of Parabolas", unit), assertFailurePreText + "Presence of Interactives on the 10.3 concept of geometry book.");
            reportLog("Presence of Interactives on the 10.3 concept of geometry book.");

            Assert.assertTrue(interactivesPage.verifyEquationInteractive("10_3_eq1", unit), assertFailurePreText + "Presence of Equation Interactives on the 10.3 concept of geometry book.");
            reportLog("Presence of Equation Interactives on the 10.3 concept of geometry book.");

            Assert.assertTrue(interactivesPage.verifyDraggableInteractive("10_3_5b", unit), assertFailurePreText + "Presence of Draggable Interactives on the 10.3 concept of geometry book.");
            reportLog("Presence of Draggable Interactives on the 10.3 concept of geometry book.");

        } catch (Exception e) {
            result = handleException(e);
        }
        Assert.assertTrue(result, testCaseFailureText + currentMethodName + errorMessage);
    }

    @Test(priority = 4, description = "Verify the Interactives of 10.4 Slope of Parallel and Perpendicular Lines concept of Geometry book.")
    public void verifyInteractivesOfSlopeOfParallelAndPerpendicularLinesConcept() {
        boolean result = true;
        try {
            String url = "https://flexbooks.ck12.org/cbook/ck-12-interactive-geometry-for-ccss/section/10.4/primary/lesson/slope-of-parallel-and-perpendicular-lines-geo-ccss/";
            webDriver.navigate().to(url);

            for (int i = 0; i <= 21; i++) {
                scrollByPixel(300);
                basePage.waitForSec(3);
            }
            Assert.assertTrue(interactivesPage.verifyGeometrySmartPhases("Slope of Parallel and Perpendicular Lines", unit), assertFailurePreText + "Presence of Interactives on the 10.4 concept of geometry book.");
            reportLog("Presence of Interactives on the 10.4 concept of geometry book.");

        } catch (Exception e) {
            result = handleException(e);
        }
        Assert.assertTrue(result, testCaseFailureText + currentMethodName + errorMessage);
    }

    @Test(priority = 5, description = "Verify the Interactives of 10.5 The Distance Formula concept of Geometry book.")
    public void verifyInteractivesOfTheDistanceFormulaConcept() {
        boolean result = true;
        try {
            String url = "https://flexbooks.ck12.org/cbook/ck-12-interactive-geometry-for-ccss/section/10.5/primary/lesson/the-distance-formula-geo-ccss/";
            webDriver.navigate().to(url);

            for (int i = 0; i <= 21; i++) {
                scrollByPixel(300);
                basePage.waitForSec(3);
            }
            Assert.assertTrue(interactivesPage.verifyGeometrySmartPhases("The Distance Formula", unit), assertFailurePreText + "Presence of Interactives on the 10.5 concept of geometry book.");
            reportLog("Presence of Interactives on the 10.5 concept of geometry book.");

            Assert.assertTrue(interactivesPage.verifyEquationInteractive("10_5_6", unit), assertFailurePreText + "Presence of Equation Interactives on the 10.5 concept of geometry book.");
            reportLog("Presence of Equation Interactives on the 10.5 concept of geometry book.");

            Assert.assertTrue(interactivesPage.verifyEquationInteractive("10_5_7", unit), assertFailurePreText + "Presence of Equation Interactives on the 10.5 concept of geometry book.");
            reportLog("Presence of Equation Interactives on the 10.5 concept of geometry book.");

            Assert.assertTrue(interactivesPage.verifyEquationInteractive("10_5_8", unit), assertFailurePreText + "Presence of Equation Interactives on the 10.5 concept of geometry book.");
            reportLog("Presence of Equation Interactives on the 10.5 concept of geometry book.");

            Assert.assertTrue(interactivesPage.verifyEquationInteractive("10_5_12", unit), assertFailurePreText + "Presence of Equation Interactives on the 10.5 concept of geometry book.");
            reportLog("Presence of Equation Interactives on the 10.5 concept of geometry book.");

        } catch (Exception e) {
            result = handleException(e);
        }
        Assert.assertTrue(result, testCaseFailureText + currentMethodName + errorMessage);
    }

    @Test(priority = 6, description = "Verify the Interactives of 10.6 Points that Partition Line Segments concept of Geometry book.")
    public void verifyInteractivesOfPointsThatPartitionLineSegmentsConcept() {
        boolean result = true;
        try {
            String url = "https://flexbooks.ck12.org/cbook/ck-12-interactive-geometry-for-ccss/section/10.6/primary/lesson/points-that-partition-line-segments-geo-ccss/";
            webDriver.navigate().to(url);

            for (int i = 0; i <= 21; i++) {
                scrollByPixel(300);
                basePage.waitForSec(3);
            }
            Assert.assertTrue(interactivesPage.verifyGeometrySmartPhases("Points that Partition Line Segments", unit), assertFailurePreText + "Presence of Interactives on the 10.6 concept of geometry book.");
            reportLog("Presence of Interactives on the 10.6 concept of geometry book.");

            Assert.assertTrue(interactivesPage.verifyEquationInteractive("10_6_3", unit), assertFailurePreText + "Presence of Equation Interactives on the 10.6 concept of geometry book.");
            reportLog("Presence of Equation Interactives on the 10.6 concept of geometry book.");

            Assert.assertTrue(interactivesPage.verifyEquationInteractive("10_6_4", unit), assertFailurePreText + "Presence of Equation Interactives on the 10.6 concept of geometry book.");
            reportLog("Presence of Equation Interactives on the 10.6 concept of geometry book.");

        } catch (Exception e) {
            result = handleException(e);
        }
        Assert.assertTrue(result, testCaseFailureText + currentMethodName + errorMessage);
    }

    @Test(priority = 7, description = "Verify the Interactives of 10.7 Coordinate Proofs concept of Geometry book.")
    public void verifyInteractivesOfCoordinateProofsConcept() {
        boolean result = true;
        try {
            String url = "https://flexbooks.ck12.org/cbook/ck-12-interactive-geometry-for-ccss/section/10.7/primary/lesson/coordinate-proofs-geo-ccss/";
            webDriver.navigate().to(url);

            for (int i = 0; i <= 21; i++) {
                scrollByPixel(300);
                basePage.waitForSec(3);
            }
            Assert.assertTrue(interactivesPage.verifyGeometrySmartPhases("Coordinate Proofs", unit), assertFailurePreText + "Presence of Interactives on the 10.7 concept of geometry book.");
            reportLog("Presence of Interactives on the 10.7 concept of geometry book.");

            Assert.assertTrue(interactivesPage.verifyDraggableInteractive("10_7_3", unit), assertFailurePreText + "Presence of Draggable Interactives on the 10.7 concept of geometry book.");
            reportLog("Presence of Draggable Interactives on the 10.7 concept of geometry book.");

        } catch (Exception e) {
            result = handleException(e);
        }
        Assert.assertTrue(result, testCaseFailureText + currentMethodName + errorMessage);
    }
}
