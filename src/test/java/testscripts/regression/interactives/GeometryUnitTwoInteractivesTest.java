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

public class GeometryUnitTwoInteractivesTest extends BaseTestScript {
    private static final Logger logger = Logger.getLogger(GeometryUnitOneInteractivesTest.class);
    private String testCaseFailureText = "Test failed for method: ";
    private String assertFailurePreText = "Failed to verify: ";
    public String assertSuccessPreText = "Successfully verified: ";
    private InteractivesPage interactivesPage;
    private BasePage basePage;
    private String unit = "unit2";

    @Test(priority = 1, description = "Verify the Interactives of 2.1 Transformations in the Plane concept of Geometry book.")
    public void verifyInteractivesOfTransformationsInThePlaneConcept() {
        interactivesPage = new InteractivesPage(webDriver, extentTest, extentReports);
        basePage = new BasePage(webDriver, extentTest, extentReports);
        boolean result = true;
        try {
            String url = "https://flexbooks.ck12.org/cbook/ck-12-interactive-geometry-for-ccss/section/2.1/primary/lesson/transformations-in-the-plane-geo-ccss/";
            webDriver.navigate().to(url);

            for (int i = 0; i <= 21; i++) {
                scrollByPixel(300);
                basePage.waitForSec(3);
            }

            Assert.assertTrue(interactivesPage.verifyGeometrySmartPhases("Transformations in the Plane", unit), assertFailurePreText + "Presence of Interactives on the 2.1 concept of geometry book.");
            reportLog("Presence of Interactives on the 2.1 concept of geometry book.");

            Assert.assertTrue(interactivesPage.verifyEquationInteractive("2_1_6", unit), assertFailurePreText + "Presence of Equation Interactives on the 2.1 concept of geometry book.");
            reportLog("Presence of Equation Interactives on the 2.1 concept of geometry book.");

            Assert.assertTrue(interactivesPage.verifyEquationInteractive("2_1_7", unit), assertFailurePreText + "Presence of Equation Interactives on the 2.1 concept of geometry book.");
            reportLog("Presence of Equation Interactives on the 2.1 concept of geometry book.");

        } catch (Exception e) {
            result = handleException(e);
        }
        Assert.assertTrue(result, testCaseFailureText + currentMethodName + errorMessage);
    }

    @Test(priority = 2, description = "Verify the Interactives of 2.2 Translations concept of Geometry book.")
    public void verifyInteractivesOfTranslationsConcept() {
        boolean result = true;
        try {
            String url = "https://flexbooks.ck12.org/cbook/ck-12-interactive-geometry-for-ccss/section/2.2/primary/lesson/translations-geo-ccss/";
            webDriver.navigate().to(url);

            for (int i = 0; i <= 21; i++) {
                scrollByPixel(300);
                basePage.waitForSec(3);
            }

            Assert.assertTrue(interactivesPage.verifyGeometrySmartPhases("Translations", unit), assertFailurePreText + "Presence of Interactives on the 2.2 concept of geometry book.");
            reportLog("Presence of Interactives on the 2.2 concept of geometry book.");

            Assert.assertTrue(interactivesPage.verifyDraggableInteractive("2_2_8", unit), assertFailurePreText + "Presence of Draggable Interactives on the 2.2 concept of geometry book.");
            reportLog("Presence of Draggable Interactives on the 2.2 concept of geometry book.");

        } catch (Exception e) {
            result = handleException(e);
        }
        Assert.assertTrue(result, testCaseFailureText + currentMethodName + errorMessage);
    }

    @Test(priority = 3, description = "Verify the Interactives of 2.3 Geometry Software for Translations concept of Geometry book.")
    public void verifyInteractivesOfGeometrySoftwareForTranslationsConcept() {
        boolean result = true;
        try {
            String url = "https://flexbooks.ck12.org/cbook/ck-12-interactive-geometry-for-ccss/section/2.3/primary/lesson/geometry-software-for-translations-geo-ccss/";
            webDriver.navigate().to(url);

            for (int i = 0; i <= 21; i++) {
                scrollByPixel(300);
                basePage.waitForSec(3);
            }

            Assert.assertTrue(interactivesPage.verifyGeometrySmartPhases("Geometry Software for Translations", unit), assertFailurePreText + "Presence of Interactives on the 2.3 concept of geometry book.");
            reportLog("Presence of Interactives on the 2.3 concept of geometry book.");

        } catch (Exception e) {
            result = handleException(e);
        }
        Assert.assertTrue(result, testCaseFailureText + currentMethodName + errorMessage);
    }

    @Test(priority = 4, description = "Verify the Interactives of 2.4 Reflections concept of Geometry book.")
    public void verifyInteractivesOfReflectionsConcept() {
        boolean result = true;
        try {
            String url = "https://flexbooks.ck12.org/cbook/ck-12-interactive-geometry-for-ccss/section/2.4/primary/lesson/reflections-geo-ccss/";
            webDriver.navigate().to(url);

            for (int i = 0; i <= 21; i++) {
                scrollByPixel(300);
                basePage.waitForSec(3);
            }

            Assert.assertTrue(interactivesPage.verifyGeometrySmartPhases("Reflections", unit), assertFailurePreText + "Presence of Interactives on the 2.4 concept of geometry book.");
            reportLog("Presence of Interactives on the 2.4 concept of geometry book.");

            Assert.assertTrue(interactivesPage.verifyDraggableInteractive("2_4_4", unit), assertFailurePreText + "Presence of Draggable Interactives on the 2.4 concept of geometry book.");
            reportLog("Presence of Draggable Interactives on the 2.4 concept of geometry book.");

        } catch (Exception e) {
            result = handleException(e);
        }
        Assert.assertTrue(result, testCaseFailureText + currentMethodName + errorMessage);
    }

    @Test(priority = 5, description = "Verify the Interactives of 2.5 Geometry Software for Reflections concept of Geometry book.")
    public void verifyInteractivesOfGeometrySoftwareForReflectionsConcept() {
        boolean result = true;
        try {
            String url = "https://flexbooks.ck12.org/cbook/ck-12-interactive-geometry-for-ccss/section/2.5/primary/lesson/geometry-software-for-reflections-geo-ccss/";
            webDriver.navigate().to(url);

            for (int i = 0; i <= 21; i++) {
                scrollByPixel(300);
                basePage.waitForSec(3);
            }

            Assert.assertTrue(interactivesPage.verifyGeometrySmartPhases("Geometry Software for Reflections", unit), assertFailurePreText + "Presence of Interactives on the 2.5 concept of geometry book.");
            reportLog("Presence of Interactives on the 2.5 concept of geometry book.");

        } catch (Exception e) {
            result = handleException(e);
        }
        Assert.assertTrue(result, testCaseFailureText + currentMethodName + errorMessage);
    }

    @Test(priority = 6, description = "Verify the Interactives of 2.6 Reflection Symmetry concept of Geometry book.")
    public void verifyInteractivesOfReflectionSymmetryConcept() {
        boolean result = true;
        try {
            String url = "https://flexbooks.ck12.org/cbook/ck-12-interactive-geometry-for-ccss/section/2.6/primary/lesson/reflection-symmetry-geo-ccss/";
            webDriver.navigate().to(url);

            for (int i = 0; i <= 21; i++) {
                scrollByPixel(300);
                basePage.waitForSec(3);
            }

            Assert.assertTrue(interactivesPage.verifyGeometrySmartPhases("Reflection Symmetry", unit), assertFailurePreText + "Presence of Interactives on the 2.6 concept of geometry book.");
            reportLog("Presence of Interactives on the 2.6 concept of geometry book.");

        } catch (Exception e) {
            result = handleException(e);
        }
        Assert.assertTrue(result, testCaseFailureText + currentMethodName + errorMessage);
    }

    @Test(priority = 7, description = "Verify the Interactives of 2.7 Rotations concept of Geometry book.")
    public void verifyInteractivesOfRotationsConcept() {
        boolean result = true;
        try {
            String url = "https://flexbooks.ck12.org/cbook/ck-12-interactive-geometry-for-ccss/section/2.7/primary/lesson/rotations-geo-ccss/";
            webDriver.navigate().to(url);

            for (int i = 0; i <= 21; i++) {
                scrollByPixel(300);
                basePage.waitForSec(3);
            }

            Assert.assertTrue(interactivesPage.verifyGeometrySmartPhases("Rotations", unit), assertFailurePreText + "Presence of Interactives on the 2.7 concept of geometry book.");
            reportLog("Presence of Interactives on the 2.7 concept of geometry book.");

            Assert.assertTrue(interactivesPage.verifyDraggableInteractive("2_7_4", unit), assertFailurePreText + "Presence of Draggable Interactives on the 2.7 concept of geometry book.");
            reportLog("Presence of Draggable Interactives on the 2.7 concept of geometry book.");

        } catch (Exception e) {
            result = handleException(e);
        }
        Assert.assertTrue(result, testCaseFailureText + currentMethodName + errorMessage);
    }

    @Test(priority = 8, description = "Verify the Interactives of 2.8 Geometry Software for Rotations concept of Geometry book.")
    public void verifyInteractivesOfGeometrySoftwareForRotationsConcept() {
        boolean result = true;
        try {
            String url = "https://flexbooks.ck12.org/cbook/ck-12-interactive-geometry-for-ccss/section/2.8/primary/lesson/geometry-software-for-rotations-geo-ccss/";
            webDriver.navigate().to(url);

            for (int i = 0; i <= 21; i++) {
                scrollByPixel(300);
                basePage.waitForSec(3);
            }

            Assert.assertTrue(interactivesPage.verifyGeometrySmartPhases("Geometry Software for Rotations", unit), assertFailurePreText + "Presence of Interactives on the 2.8 concept of geometry book.");
            reportLog("Presence of Interactives on the 2.8 concept of geometry book.");

        } catch (Exception e) {
            result = handleException(e);
        }
        Assert.assertTrue(result, testCaseFailureText + currentMethodName + errorMessage);
    }

    @Test(priority = 9, description = "Verify the Interactives of 2.9 Rotation Symmetry concept of Geometry book.")
    public void verifyInteractivesOfRotationSymmetryConcept() {
        boolean result = true;
        try {
            String url = "https://flexbooks.ck12.org/cbook/ck-12-interactive-geometry-for-ccss/section/2.9/primary/lesson/rotation-symmetry-geo-ccss/";
            webDriver.navigate().to(url);

            for (int i = 0; i <= 21; i++) {
                scrollByPixel(300);
                basePage.waitForSec(3);
            }

            Assert.assertTrue(interactivesPage.verifyGeometrySmartPhases("Rotation Symmetry", unit), assertFailurePreText + "Presence of Interactives on the 2.9 concept of geometry book.");
            reportLog("Presence of Interactives on the 2.9 concept of geometry book.");

            Assert.assertTrue(interactivesPage.verifyDraggableInteractive("2_9_8", unit), assertFailurePreText + "Presence of Draggable Interactives on the 2.9 concept of geometry book.");
            reportLog("Presence of Draggable Interactives on the 2.9 concept of geometry book.");

        } catch (Exception e) {
            result = handleException(e);
        }
        Assert.assertTrue(result, testCaseFailureText + currentMethodName + errorMessage);
    }

    @Test(priority = 10, description = "Verify the Interactives of 2.10 Composite Transformations concept of Geometry book.")
    public void verifyInteractivesOfCompositeTransformationsConcept() {
        boolean result = true;
        try {
            String url = "https://flexbooks.ck12.org/cbook/ck-12-interactive-geometry-for-ccss/section/2.10/primary/lesson/composite-transformations-geo-ccss/";
            webDriver.navigate().to(url);

            for (int i = 0; i <= 21; i++) {
                scrollByPixel(300);
                basePage.waitForSec(3);
            }

            Assert.assertTrue(interactivesPage.verifyGeometrySmartPhases("Composite Transformations", unit), assertFailurePreText + "Presence of Interactives on the 2.10 concept of geometry book.");
            reportLog("Presence of Interactives on the 2.10 concept of geometry book.");

        } catch (Exception e) {
            result = handleException(e);
        }
        Assert.assertTrue(result, testCaseFailureText + currentMethodName + errorMessage);
    }
}
