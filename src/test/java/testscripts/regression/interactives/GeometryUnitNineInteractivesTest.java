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

public class GeometryUnitNineInteractivesTest extends BaseTestScript {
    private static final Logger logger = Logger.getLogger(GeometryUnitOneInteractivesTest.class);
    private String testCaseFailureText = "Test failed for method: ";
    private String assertFailurePreText = "Failed to verify: ";
    public String assertSuccessPreText = "Successfully verified: ";
    private InteractivesPage interactivesPage;
    private BasePage basePage;
    private String unit = "unit9";

    @Test(priority = 1, description = "Verify the Interactives of 9.1 Cylinders concept of Geometry book.")
    public void verifyInteractivesOfCylindersConcept() {
        boolean result = true;
        try {
            interactivesPage = new InteractivesPage(webDriver, extentTest, extentReports);
            basePage = new BasePage(webDriver, extentTest, extentReports);

            String url = "https://flexbooks.ck12.org/cbook/ck-12-interactive-geometry-for-ccss/section/9.1/primary/lesson/cylinders-geo-ccss/";
            webDriver.navigate().to(url);

            for (int i = 0; i <= 21; i++) {
                scrollByPixel(300);
                basePage.waitForSec(3);
            }
            Assert.assertTrue(interactivesPage.verifyGeometrySmartPhases("Cylinders", unit), assertFailurePreText + "Presence of Interactives on the 9.1 concept of geometry book.");
            reportLog("Presence of Interactives on the 9.1 concept of geometry book.");

            Assert.assertTrue(interactivesPage.verifyDraggableInteractive("9_1_3", unit), assertFailurePreText + "Presence of Draggable Interactives on the 9.1 concept of geometry book.");
            reportLog("Presence of Draggable Interactives on the 9.1 concept of geometry book.");

        } catch (Exception e) {
            result = handleException(e);
        }
        Assert.assertTrue(result, testCaseFailureText + currentMethodName + errorMessage);
    }

    @Test(priority = 2, description = "Verify the Interactives of 9.2 Pyramids and Cones concept of Geometry book.")
    public void verifyInteractivesOfPyramidsAndConesConcept() {
        boolean result = true;
        try {
            String url = "https://flexbooks.ck12.org/cbook/ck-12-interactive-geometry-for-ccss/section/9.2/primary/lesson/pyramids-and-cones-geo-ccss/";
            webDriver.navigate().to(url);

            for (int i = 0; i <= 21; i++) {
                scrollByPixel(300);
                basePage.waitForSec(3);
            }
            Assert.assertTrue(interactivesPage.verifyGeometrySmartPhases("Pyramids and Cones", unit), assertFailurePreText + "Presence of Interactives on the 9.2 concept of geometry book.");
            reportLog("Presence of Interactives on the 9.2 concept of geometry book.");

            Assert.assertTrue(interactivesPage.verifyEquationInteractive("9_2_8", unit), assertFailurePreText + "Presence of Equation Interactives on the 9.2 concept of geometry book.");
            reportLog("Presence of Equation Interactives on the 9.2 concept of geometry book.");

            Assert.assertTrue(interactivesPage.verifyEquationInteractive("9_2_9", unit), assertFailurePreText + "Presence of Equation Interactives on the 9.2 concept of geometry book.");
            reportLog("Presence of Equation Interactives on the 9.2 concept of geometry book.");

        } catch (Exception e) {
            result = handleException(e);
        }
        Assert.assertTrue(result, testCaseFailureText + currentMethodName + errorMessage);
    }

    @Test(priority = 3, description = "Verify the Interactives of 9.3 Spheres concept of Geometry book.")
    public void verifyInteractivesOfSpheresConcept() {
        boolean result = true;
        try {
            String url = "https://flexbooks.ck12.org/cbook/ck-12-interactive-geometry-for-ccss/section/9.2/primary/lesson/pyramids-and-cones-geo-ccss/";
            webDriver.navigate().to(url);

            for (int i = 0; i <= 21; i++) {
                scrollByPixel(300);
                basePage.waitForSec(3);
            }
            Assert.assertTrue(interactivesPage.verifyGeometrySmartPhases("Spheres", unit), assertFailurePreText + "Presence of Interactives on the 9.3 concept of geometry book.");
            reportLog("Presence of Interactives on the 9.3 concept of geometry book.");

            Assert.assertTrue(interactivesPage.verifyDraggableInteractive("9_3_6", unit), assertFailurePreText + "Presence of Draggable Interactives on the 9.3 concept of geometry book.");
            reportLog("Presence of Draggable Interactives on the 9.3 concept of geometry book.");

        } catch (Exception e) {
            result = handleException(e);
        }
        Assert.assertTrue(result, testCaseFailureText + currentMethodName + errorMessage);
    }

    @Test(priority = 4, description = "Verify the Interactives of 9.4 Connections Between Two and Three Dimensions concept of Geometry book.")
    public void verifyInteractivesOfConnectionsBetweenTwoAndThreeDimensionsConcept() {
        boolean result = true;
        try {
            String url = "https://flexbooks.ck12.org/cbook/ck-12-interactive-geometry-for-ccss/section/9.4/primary/lesson/connections-between-two-and-three-dimensions-geo-ccss/";
            webDriver.navigate().to(url);

            for (int i = 0; i <= 21; i++) {
                scrollByPixel(300);
                basePage.waitForSec(3);
            }
            Assert.assertTrue(interactivesPage.verifyGeometrySmartPhases("Connections Between Two and Three Dimensions", unit), assertFailurePreText + "Presence of Interactives on the 9.4 concept of geometry book.");
            reportLog("Presence of Interactives on the 9.4 concept of geometry book.");

            Assert.assertTrue(interactivesPage.verifyEquationInteractive("9_4_EQ1", unit), assertFailurePreText + "Presence of Equation Interactives on the 9.4 concept of geometry book.");
            reportLog("Presence of Equation Interactives on the 9.4 concept of geometry book.");

            Assert.assertTrue(interactivesPage.verifyEquationInteractive("9_4_EQ2", unit), assertFailurePreText + "Presence of Equation Interactives on the 9.4 concept of geometry book.");
            reportLog("Presence of Equation Interactives on the 9.4 concept of geometry book.");

            Assert.assertTrue(interactivesPage.verifyEquationInteractive("9_4_EQ3", unit), assertFailurePreText + "Presence of Equation Interactives on the 9.4 concept of geometry book.");
            reportLog("Presence of Equation Interactives on the 9.4 concept of geometry book.");

            Assert.assertTrue(interactivesPage.verifyEquationInteractive("9_4_EQ4", unit), assertFailurePreText + "Presence of Equation Interactives on the 9.4 concept of geometry book.");
            reportLog("Presence of Equation Interactives on the 9.4 concept of geometry book.");

            Assert.assertTrue(interactivesPage.verifyEquationInteractive("9_4_EQ5", unit), assertFailurePreText + "Presence of Equation Interactives on the 9.4 concept of geometry book.");
            reportLog("Presence of Equation Interactives on the 9.4 concept of geometry book.");

            Assert.assertTrue(interactivesPage.verifyEquationInteractive("9_4_EQ6", unit), assertFailurePreText + "Presence of Equation Interactives on the 9.4 concept of geometry book.");
            reportLog("Presence of Equation Interactives on the 9.4 concept of geometry book.");

        } catch (Exception e) {
            result = handleException(e);
        }
        Assert.assertTrue(result, testCaseFailureText + currentMethodName + errorMessage);
    }

    @Test(priority = 5, description = "Verify the Interactives of 9.5 Modeling in Three Dimensions concept of Geometry book.")
    public void verifyInteractivesOfModelingInThreeDimensionsConcept() {
        boolean result = true;
        try {
            String url = "https://flexbooks.ck12.org/cbook/ck-12-interactive-geometry-for-ccss/section/9.5/primary/lesson/modeling-in-three-dimensions-geo-ccss/";
            webDriver.navigate().to(url);

            for (int i = 0; i <= 21; i++) {
                scrollByPixel(300);
                basePage.waitForSec(3);
            }
            Assert.assertTrue(interactivesPage.verifyGeometrySmartPhases("Modeling in Three Dimensions", unit), assertFailurePreText + "Presence of Interactives on the 9.5 concept of geometry book.");
            reportLog("Presence of Interactives on the 9.5 concept of geometry book.");

            Assert.assertTrue(interactivesPage.verifyEquationInteractive("9_5_1", unit), assertFailurePreText + "Presence of Equation Interactives on the 9.5 concept of geometry book.");
            reportLog("Presence of Equation Interactives on the 9.5 concept of geometry book.");

        } catch (Exception e) {
            result = handleException(e);
        }
        Assert.assertTrue(result, testCaseFailureText + currentMethodName + errorMessage);
    }

    @Test(priority = 7, description = "Verify the Interactives of 9.7 Design Problems in Three Dimensions concept of Geometry book.")
    public void verifyInteractivesOfDesignProblemsInThreeDimensionsConcept() {
        boolean result = true;
        try {
            String url = "https://flexbooks.ck12.org/cbook/ck-12-interactive-geometry-for-ccss/section/9.7/primary/lesson/design-problems-in-three-dimensions-geo-ccss/";
            webDriver.navigate().to(url);

            for (int i = 0; i <= 21; i++) {
                scrollByPixel(300);
                basePage.waitForSec(3);
            }
            Assert.assertTrue(interactivesPage.verifyGeometrySmartPhases("Design Problems in Three Dimensions", unit), assertFailurePreText + "Presence of Interactives on the 9.7 concept of geometry book.");
            reportLog("Presence of Interactives on the 9.7 concept of geometry book.");

            Assert.assertTrue(interactivesPage.verifyEquationInteractive("9_7_2", unit), assertFailurePreText + "Presence of Equation Interactives on the 9.7 concept of geometry book.");
            reportLog("Presence of Equation Interactives on the 9.7 concept of geometry book.");

            Assert.assertTrue(interactivesPage.verifyEquationInteractive("9_7_3", unit), assertFailurePreText + "Presence of Equation Interactives on the 9.7 concept of geometry book.");
            reportLog("Presence of Equation Interactives on the 9.7 concept of geometry book.");

            Assert.assertTrue(interactivesPage.verifyEquationInteractive("9_7_4", unit), assertFailurePreText + "Presence of Equation Interactives on the 9.7 concept of geometry book.");
            reportLog("Presence of Equation Interactives on the 9.7 concept of geometry book.");

            Assert.assertTrue(interactivesPage.verifyEquationInteractive("9_7_5", unit), assertFailurePreText + "Presence of Equation Interactives on the 9.7 concept of geometry book.");
            reportLog("Presence of Equation Interactives on the 9.7 concept of geometry book.");

            Assert.assertTrue(interactivesPage.verifyEquationInteractive("9_7_7", unit), assertFailurePreText + "Presence of Equation Interactives on the 9.7 concept of geometry book.");
            reportLog("Presence of Equation Interactives on the 9.7 concept of geometry book.");

            Assert.assertTrue(interactivesPage.verifyEquationInteractive("9_7_8", unit), assertFailurePreText + "Presence of Equation Interactives on the 9.7 concept of geometry book.");
            reportLog("Presence of Equation Interactives on the 9.7 concept of geometry book.");

            Assert.assertTrue(interactivesPage.verifyEquationInteractive("9_7_9", unit), assertFailurePreText + "Presence of Equation Interactives on the 9.7 concept of geometry book.");
            reportLog("Presence of Equation Interactives on the 9.7 concept of geometry book.");

            Assert.assertTrue(interactivesPage.verifyEquationInteractive("9_7_10", unit), assertFailurePreText + "Presence of Equation Interactives on the 9.7 concept of geometry book.");
            reportLog("Presence of Equation Interactives on the 9.7 concept of geometry book.");

            Assert.assertTrue(interactivesPage.verifyEquationInteractive("9_7_11", unit), assertFailurePreText + "Presence of Equation Interactives on the 9.7 concept of geometry book.");
            reportLog("Presence of Equation Interactives on the 9.7 concept of geometry book.");

            Assert.assertTrue(interactivesPage.verifyEquationInteractive("9_7_12", unit), assertFailurePreText + "Presence of Equation Interactives on the 9.7 concept of geometry book.");
            reportLog("Presence of Equation Interactives on the 9.7 concept of geometry book.");

            Assert.assertTrue(interactivesPage.verifyEquationInteractive("9_7_13", unit), assertFailurePreText + "Presence of Equation Interactives on the 9.7 concept of geometry book.");
            reportLog("Presence of Equation Interactives on the 9.7 concept of geometry book.");

            Assert.assertTrue(interactivesPage.verifyEquationInteractive("9_7_14", unit), assertFailurePreText + "Presence of Equation Interactives on the 9.7 concept of geometry book.");
            reportLog("Presence of Equation Interactives on the 9.7 concept of geometry book.");

        } catch (Exception e) {
            result = handleException(e);
        }
        Assert.assertTrue(result, testCaseFailureText + currentMethodName + errorMessage);
    }
}
