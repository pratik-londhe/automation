
package testscripts.regression.interactives;

import org.apache.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.Test;
import testscripts.BaseTestScript;
//import testscripts.regression.teacherlogin.ExploreFeature.AdaptivePracticeFeature.AdaptivePracticeFeatureTest;
import uipages.BasePage;
import uipages.flexbook2feature.*;


/**
 * @author Tanmay Kashettiwar
 */

public class GeometryUnitOneInteractivesTest extends BaseTestScript {
    private static final Logger logger = Logger.getLogger(GeometryUnitOneInteractivesTest.class);
    private String testCaseFailureText = "Test failed for method: ";
    private String assertFailurePreText = "Failed to verify: ";
    public String assertSuccessPreText = "Successfully verified: ";
    private InteractivesPage interactivesPage;
    private BasePage basePage;
    private String unit = "unit1";

    @Test(priority = 1, description = "Verify the Interactives of 1.1 The Three Dimension concept of Geometry book.")
    public void verifyInteractivesOfThreeDimensionConcept() {
        boolean result = true;
        try {
            interactivesPage = new InteractivesPage(webDriver, extentTest, extentReports);
            basePage = new BasePage(webDriver, extentTest, extentReports);

            String url = "https://flexbooks.ck12.org/cbook/ck-12-interactive-geometry-for-ccss/section/1.1/primary/lesson/the-three-dimensions-geo-ccss/";
            webDriver.navigate().to(url);

            for (int i = 0; i <= 21; i++) {
                scrollByPixel(300);
                basePage.waitForSec(3);
            }

            Assert.assertTrue(interactivesPage.verifyGeometrySmartPhases("Three Dimension", unit), assertFailurePreText + "Presence of Interactives on the 1.1 concept of geometry book.");
            reportLog("Presence of Interactives on the 1.1 concept of geometry book.");

            Assert.assertTrue(interactivesPage.verifyDraggableInteractive("1_1_6", unit), assertFailurePreText + "Presence of Draggable Interactives on the 1.1 concept of geometry book.");
            reportLog("Presence of Draggable Interactives on the 1.1 concept of geometry book.");

        } catch (Exception e) {
            result = handleException(e);
        }
        Assert.assertTrue(result, testCaseFailureText + currentMethodName + errorMessage);
    }

    @Test(priority = 2, description = "Verify the Interactives of 1.2 Angles and Lines concept of Geometry book.")
    public void verifyInteractivesOfAnglesAndLinesConcept() {
        boolean result = true;
        try {
            interactivesPage = new InteractivesPage(webDriver, extentTest, extentReports);
            basePage = new BasePage(webDriver, extentTest, extentReports);

            String url = "https://flexbooks.ck12.org/cbook/ck-12-interactive-geometry-for-ccss/section/1.2/primary/lesson/angles-and-lines-geo-ccss/";
            webDriver.navigate().to(url);

            for (int i = 0; i <= 21; i++) {
                scrollByPixel(300);
                basePage.waitForSec(3);
            }

            Assert.assertTrue(interactivesPage.verifyGeometrySmartPhases("Angles and Lines", unit), assertFailurePreText + "Presence of Interactives on the 1.2 concept of biology book.");
            reportLog("Presence of Interactives on the 1.2 concept of biology book.");

            Assert.assertTrue(interactivesPage.verifyDraggableInteractive("1_2_5", unit), assertFailurePreText + "Presence of Draggable Interactives on the 1.2 concept of geometry book.");
            reportLog("Presence of Draggable Interactives on the 1.2 concept of geometry book.");

            Assert.assertTrue(interactivesPage.verifyDraggableInteractive("1_2_7", unit), assertFailurePreText + "Presence of Draggable Interactives on the 1.2 concept of geometry book.");
            reportLog("Presence of Draggable Interactives on the 1.2 concept of geometry book.");

            Assert.assertTrue(interactivesPage.verifyDraggableInteractive("1_2_8", unit), assertFailurePreText + "Presence of Draggable Interactives on the 1.2 concept of geometry book.");
            reportLog("Presence of Draggable Interactives on the 1.2 concept of geometry book.");

            Assert.assertTrue(interactivesPage.verifyDraggableInteractive("1_2_10", unit), assertFailurePreText + "Presence of Draggable Interactives on the 1.2 concept of geometry book.");
            reportLog("Presence of Draggable Interactives on the 1.2 concept of geometry book.");

            Assert.assertTrue(interactivesPage.verifyEquationInteractive("1_2_11", unit), assertFailurePreText + "Presence of Equation Interactives on the 1.2 concept of geometry book.");
            reportLog("Presence of Equation Interactives on the 1.2 concept of geometry book.");

        } catch (Exception e) {
            result = handleException(e);
        }
        Assert.assertTrue(result, "Test script failed for" + currentMethodName + errorMessage);
    }

    @Test(priority = 3, description = "Verify the Interactives of 1.3 Polygons concept of Geometry book.")
    public void verifyInteractivesOfPolygonsConcept() {
        boolean result = true;
        try {
            interactivesPage = new InteractivesPage(webDriver, extentTest, extentReports);
            basePage = new BasePage(webDriver, extentTest, extentReports);

            String url = "https://flexbooks.ck12.org/cbook/ck-12-interactive-geometry-for-ccss/section/1.3/primary/lesson/polygons-geo-ccss/";
            webDriver.navigate().to(url);

            for (int i = 0; i <= 21; i++) {
                scrollByPixel(300);
                basePage.waitForSec(3);
            }

            Assert.assertTrue(interactivesPage.verifyGeometrySmartPhases("Polygons", unit), assertFailurePreText + "Presence of Interactives on the 1.3 concept of biology book.");
            reportLog("Presence of Interactives on the 1.3 concept of biology book.");

            Assert.assertTrue(interactivesPage.verifyEquationInteractive("1_3_9", unit), assertFailurePreText + "Presence of Equation Interactives on the 1.3 concept of geometry book.");
            reportLog("Presence of Equation Interactives on the 1.3 concept of geometry book.");

            Assert.assertTrue(interactivesPage.verifyPolygonDraggableInteractive(unit), assertFailurePreText + "Presence of Draggable Interactives on the 1.3 concept of geometry book.");
            reportLog("Presence of Draggable Interactives on the 1.3 concept of geometry book.");

        } catch (Exception e) {
            result = handleException(e);
        }
        Assert.assertTrue(result, "Test script failed for" + currentMethodName + errorMessage);
    }

    @Test(priority = 4, description = "Verify the Interactives of 1.4 Triangles concept of Geometry book.")
    public void verifyInteractivesOfTrianglesConcept() {
        boolean result = true;
        try {
            interactivesPage = new InteractivesPage(webDriver, extentTest, extentReports);
            basePage = new BasePage(webDriver, extentTest, extentReports);

            String url = "https://flexbooks.ck12.org/cbook/ck-12-interactive-geometry-for-ccss/section/1.4/primary/lesson/triangles-geo-ccss/";
            webDriver.navigate().to(url);

            for (int i = 0; i <= 21; i++) {
                scrollByPixel(300);
                basePage.waitForSec(3);
            }

            Assert.assertTrue(interactivesPage.verifyGeometrySmartPhases("Triangles", unit), assertFailurePreText + "Presence of Interactives on the 1.4 concept of biology book.");
            reportLog("Presence of Interactives on the 1.4 concept of biology book.");

            Assert.assertTrue(interactivesPage.verifyDraggableInteractive("1_4_1", unit), assertFailurePreText + "Presence of Draggable Interactives on the 1.4 concept of geometry book.");
            reportLog("Presence of Draggable Interactives on the 1.4 concept of geometry book.");

            Assert.assertTrue(interactivesPage.verifyDraggableInteractive("1_4_2", unit), assertFailurePreText + "Presence of Draggable Interactives on the 1.4 concept of geometry book.");
            reportLog("Presence of Draggable Interactives on the 1.4 concept of geometry book.");

        } catch (Exception e) {
            result = handleException(e);
        }
        Assert.assertTrue(result, "Test script failed for" + currentMethodName + errorMessage);
    }

    @Test(priority = 5, description = "Verify the Interactives of 1.5 Quadrilaterals concept of Geometry book.")
    public void verifyInteractivesOfQuadrilateralsConcept() {
        boolean result = true;
        try {
            interactivesPage = new InteractivesPage(webDriver, extentTest, extentReports);
            basePage = new BasePage(webDriver, extentTest, extentReports);

            String url = "https://flexbooks.ck12.org/cbook/ck-12-interactive-geometry-for-ccss/section/1.5/primary/lesson/quadrilaterals-geo-ccss/";
            webDriver.navigate().to(url);

            for (int i = 0; i <= 21; i++) {
                scrollByPixel(500);
                basePage.waitForSec(3);
            }

            Assert.assertTrue(interactivesPage.verifyGeometrySmartPhases("Quadrilaterals", unit), assertFailurePreText + "Presence of Interactives on the 1.5 concept of biology book.");
            reportLog("Presence of Interactives on the 1.5 concept of biology book.");

            Assert.assertTrue(interactivesPage.verifyQuadrilateralDraggableInteractive(unit), assertFailurePreText + "Presence of Draggable Interactives on the 1.5 concept of geometry book.");
            reportLog("Presence of Draggable Interactives on the 1.5 concept of geometry book.");

        } catch (Exception e) {
            result = handleException(e);
        }
        Assert.assertTrue(result, "Test script failed for" + currentMethodName + errorMessage);
    }

    @Test(priority = 6, description = "Verify the Interactives of 1.6 Area or Perimeter of Triangles and Quadrilaterals concept of Geometry book.")
    public void verifyInteractivesOfAreaOrPerimeterOfTrianglesAndQuadrilateralsConcept() {
        boolean result = true;
        try {
            interactivesPage = new InteractivesPage(webDriver, extentTest, extentReports);
            basePage = new BasePage(webDriver, extentTest, extentReports);

            String url = "https://flexbooks.ck12.org/cbook/ck-12-interactive-geometry-for-ccss/section/1.6/primary/lesson/area-or-perimeter-of-triangles-and-quadrilaterals-geo-ccss/";
            webDriver.navigate().to(url);

            for (int i = 0; i <= 21; i++) {
                scrollByPixel(300);
                basePage.waitForSec(3);
            }

            Assert.assertTrue(interactivesPage.verifyGeometrySmartPhases("Area or Perimeter of Triangles and Quadrilaterals", unit), assertFailurePreText + "Presence of Interactives on the 1.6 concept of biology book.");
            reportLog("Presence of Interactives on the 1.6 concept of biology book.");

        } catch (Exception e) {
            result = handleException(e);
        }
        Assert.assertTrue(result, "Test script failed for" + currentMethodName + errorMessage);
    }

    @Test(priority = 7, description = "Verify the Interactives of 1.7 The Pythagorean Theorem concept of Geometry book.")
    public void verifyInteractivesOfThePythagoreanTheoremConcept() {
        boolean result = true;
        try {
            interactivesPage = new InteractivesPage(webDriver, extentTest, extentReports);
            basePage = new BasePage(webDriver, extentTest, extentReports);

            String url = "https://flexbooks.ck12.org/cbook/ck-12-interactive-geometry-for-ccss/section/1.7/primary/lesson/the-pythagorean-theorem-geo-ccss/";
            webDriver.navigate().to(url);

            for (int i = 0; i <= 21; i++) {
                scrollByPixel(300);
                basePage.waitForSec(3);
            }

            Assert.assertTrue(interactivesPage.verifyGeometrySmartPhases("The Pythagorean Theorem", unit), assertFailurePreText + "Presence of Interactives on the 1.7 concept of biology book.");
            reportLog("Presence of Interactives on the 1.7 concept of biology book.");

            Assert.assertTrue(interactivesPage.verifyDraggableInteractive("1_7_3", unit), assertFailurePreText + "Presence of Draggable Interactives on the 1.7 concept of geometry book.");
            reportLog("Presence of Draggable Interactives on the 1.7 concept of geometry book.");

            Assert.assertTrue(interactivesPage.verifyDraggableInteractive("1_7_4", unit), assertFailurePreText + "Presence of Draggable Interactives on the 1.7 concept of geometry book.");
            reportLog("Presence of Draggable Interactives on the 1.7 concept of geometry book.");

            Assert.assertTrue(interactivesPage.verifyDraggableInteractive("1_7_7", unit), assertFailurePreText + "Presence of Draggable Interactives on the 1.7 concept of geometry book.");
            reportLog("Presence of Draggable Interactives on the 1.7 concept of geometry book.");

            Assert.assertTrue(interactivesPage.verifyEquationInteractive("1_7_2", unit), assertFailurePreText + "Presence of Equation Interactives on the 1.7 concept of geometry book.");
            reportLog("Presence of Equation Interactives on the 1.7 concept of geometry book.");

            Assert.assertTrue(interactivesPage.verifyEquationInteractive("1_7_5", unit), assertFailurePreText + "Presence of Equation Interactives on the 1.7 concept of geometry book.");
            reportLog("Presence of Equation Interactives on the 1.7 concept of geometry book.");

            Assert.assertTrue(interactivesPage.verifyEquationInteractive("1_7_6", unit), assertFailurePreText + "Presence of Equation Interactives on the 1.7 concept of geometry book.");
            reportLog("Presence of Equation Interactives on the 1.7 concept of geometry book.");

            Assert.assertTrue(interactivesPage.verifyEquationInteractive("1_7_9", unit), assertFailurePreText + "Presence of Equation Interactives on the 1.7 concept of geometry book.");
            reportLog("Presence of Equation Interactives on the 1.7 concept of geometry book.");

            Assert.assertTrue(interactivesPage.verifyEquationInteractive("1_7_10", unit), assertFailurePreText + "Presence of Equation Interactives on the 1.7 concept of geometry book.");
            reportLog("Presence of Equation Interactives on the 1.7 concept of geometry book.");

        } catch (Exception e) {
            result = handleException(e);
        }
        Assert.assertTrue(result, "Test script failed for" + currentMethodName + errorMessage);
    }

    @Test(priority = 8, description = "Verify the Interactives of 1.8 Circles concept of Geometry book.")
    public void verifyInteractivesOfCirclesConcept() {
        boolean result = true;
        try {
            interactivesPage = new InteractivesPage(webDriver, extentTest, extentReports);
            basePage = new BasePage(webDriver, extentTest, extentReports);

            String url = "https://flexbooks.ck12.org/cbook/ck-12-interactive-geometry-for-ccss/section/1.8/primary/lesson/circles-geo-ccss/";
            webDriver.navigate().to(url);

            for (int i = 0; i <= 21; i++) {
                scrollByPixel(300);
                basePage.waitForSec(3);
            }

            Assert.assertTrue(interactivesPage.verifyGeometrySmartPhases("Circles", unit), assertFailurePreText + "Presence of Interactives on the 1.8 concept of biology book.");
            reportLog("Presence of Interactives on the 1.8 concept of biology book.");

            Assert.assertTrue(interactivesPage.verifyDraggableInteractive("1_8_5", unit), assertFailurePreText + "Presence of Draggable Interactives on the 1.8 concept of geometry book.");
            reportLog("Presence of Draggable Interactives on the 1.8 concept of geometry book.");

            Assert.assertTrue(interactivesPage.verifyDraggableInteractive("1_8_7", unit), assertFailurePreText + "Presence of Draggable Interactives on the 1.8 concept of geometry book.");
            reportLog("Presence of Draggable Interactives on the 1.8 concept of geometry book.");

            Assert.assertTrue(interactivesPage.verifyEquationInteractive("1_8_9", unit), assertFailurePreText + "Presence of Equation Interactives on the 1.8 concept of geometry book.");
            reportLog("Presence of Equation Interactives on the 1.8 concept of geometry book.");

            Assert.assertTrue(interactivesPage.verifyEquationInteractive("1_8_10", unit), assertFailurePreText + "Presence of Equation Interactives on the 1.8 concept of geometry book.");
            reportLog("Presence of Equation Interactives on the 1.8 concept of geometry book.");

        } catch (Exception e) {
            result = handleException(e);
        }
        Assert.assertTrue(result, "Test script failed for" + currentMethodName + errorMessage);
    }

    @Test(priority = 9, description = "Verify the Interactives of 1.9 Composite Shapes concept of Geometry book.")
    public void verifyInteractivesOfCompositeShapesConcept() {
        boolean result = true;
        try {
            interactivesPage = new InteractivesPage(webDriver, extentTest, extentReports);
            basePage = new BasePage(webDriver, extentTest, extentReports);

            String url = "https://flexbooks.ck12.org/cbook/ck-12-interactive-geometry-for-ccss/section/1.9/primary/lesson/composite-shapes-geo-ccss/";
            webDriver.navigate().to(url);

            for (int i = 0; i <= 21; i++) {
                scrollByPixel(300);
                basePage.waitForSec(3);
            }

            Assert.assertTrue(interactivesPage.verifyGeometrySmartPhases("Composite Shapes", unit), assertFailurePreText + "Presence of Interactives on the 1.9 concept of biology book.");
            reportLog("Presence of Interactives on the 1.9 concept of biology book.");

        } catch (Exception e) {
            result = handleException(e);
        }
        Assert.assertTrue(result, "Test script failed for" + currentMethodName + errorMessage);
    }

    @Test(priority = 10, description = "Verify the Interactives of 1.10 Volume Of Solids concept of Geometry book.")
    public void verifyInteractivesOfVolumeOfSolidsConcept() {
        boolean result = true;
        try {
            interactivesPage = new InteractivesPage(webDriver, extentTest, extentReports);
            basePage = new BasePage(webDriver, extentTest, extentReports);

            String url = "https://flexbooks.ck12.org/cbook/ck-12-interactive-geometry-for-ccss/section/1.10/primary/lesson/volume-of-solids-geo-ccss/";
            webDriver.navigate().to(url);

            for (int i = 0; i <= 21; i++) {
                scrollByPixel(300);
                basePage.waitForSec(3);
            }

            Assert.assertTrue(interactivesPage.verifyGeometrySmartPhases("Volume Of Solids", unit), assertFailurePreText + "Presence of Interactives on the 1.10 concept of biology book.");
            reportLog("Presence of Interactives on the 1.10 concept of biology book.");

            Assert.assertTrue(interactivesPage.verifyEquationInteractive("1_10_11", unit), assertFailurePreText + "Presence of Equation Interactives on the 1.10 concept of geometry book.");
            reportLog("Presence of Equation Interactives on the 1.10 concept of geometry book.");

            Assert.assertTrue(interactivesPage.verifyEquationInteractive("1_10_13", unit), assertFailurePreText + "Presence of Equation Interactives on the 1.10 concept of geometry book.");
            reportLog("Presence of Equation Interactives on the 1.10 concept of geometry book.");

            Assert.assertTrue(interactivesPage.verifyEquationInteractive("1_10_17", unit), assertFailurePreText + "Presence of Equation Interactives on the 1.10 concept of geometry book.");
            reportLog("Presence of Equation Interactives on the 1.10 concept of geometry book.");

        } catch (Exception e) {
            result = handleException(e);
        }
        Assert.assertTrue(result, "Test script failed for" + currentMethodName + errorMessage);
    }

    @Test(priority = 11, description = "Verify the Interactives of 1.11 Surface Area and Nets concept of Geometry book.")
    public void verifyInteractivesOfSurfaceAreaAndNetsConcept() {
        boolean result = true;
        try {
            interactivesPage = new InteractivesPage(webDriver, extentTest, extentReports);
            basePage = new BasePage(webDriver, extentTest, extentReports);

            String url = "https://flexbooks.ck12.org/cbook/ck-12-interactive-geometry-for-ccss/section/1.11/primary/lesson/surface-area-and-nets-geo-ccss/";
            webDriver.navigate().to(url);

            for (int i = 0; i <= 21; i++) {
                scrollByPixel(300);
                basePage.waitForSec(3);
            }

            Assert.assertTrue(interactivesPage.verifyGeometrySmartPhases("Surface Area and Nets", unit), assertFailurePreText + "Presence of Interactives on the 1.11 concept of biology book.");
            reportLog("Presence of Interactives on the 1.11 concept of biology book.");

            Assert.assertTrue(interactivesPage.verifyEquationInteractive("1_11_4", unit), assertFailurePreText + "Presence of Equation Interactives on the 1.11 concept of geometry book.");
            reportLog("Presence of Equation Interactives on the 1.11 concept of geometry book.");

            Assert.assertTrue(interactivesPage.verifyEquationInteractive("1_11_8", unit), assertFailurePreText + "Presence of Equation Interactives on the 1.11 concept of geometry book.");
            reportLog("Presence of Equation Interactives on the 1.11 concept of geometry book.");

            Assert.assertTrue(interactivesPage.verifyEquationInteractive("1_11_13", unit), assertFailurePreText + "Presence of Equation Interactives on the 1.11 concept of geometry book.");
            reportLog("Presence of Equation Interactives on the 1.11 concept of geometry book.");

            Assert.assertTrue(interactivesPage.verifyEquationInteractive("1_11_15", unit), assertFailurePreText + "Presence of Equation Interactives on the 1.11 concept of geometry book.");
            reportLog("Presence of Equation Interactives on the 1.11 concept of geometry book.");

        } catch (Exception e) {
            result = handleException(e);
        }
        Assert.assertTrue(result, "Test script failed for" + currentMethodName + errorMessage);
    }

    @Test(priority = 12, description = "Verify the Interactives of 1.12 Cross Sections of Solids concept of Geometry book.")
    public void verifyInteractivesOfCrossSectionsOfSolidsConcept() {
        boolean result = true;
        try {
            interactivesPage = new InteractivesPage(webDriver, extentTest, extentReports);
            basePage = new BasePage(webDriver, extentTest, extentReports);

            String url = "https://flexbooks.ck12.org/cbook/ck-12-interactive-geometry-for-ccss/section/1.12/primary/lesson/cross-sections-of-solids-geo-ccss/";
            webDriver.navigate().to(url);

            for (int i = 0; i <= 21; i++) {
                scrollByPixel(300);
                basePage.waitForSec(3);
            }

            Assert.assertTrue(interactivesPage.verifyGeometrySmartPhases("Cross Sections of Solids", unit), assertFailurePreText + "Presence of Interactives on the 1.12 concept of biology book.");
            reportLog("Presence of Interactives on the 1.12 concept of biology book.");

        } catch (Exception e) {
            result = handleException(e);
        }
        Assert.assertTrue(result, "Test script failed for" + currentMethodName + errorMessage);
    }
}

