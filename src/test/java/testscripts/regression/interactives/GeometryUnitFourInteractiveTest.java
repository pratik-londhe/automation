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

public class GeometryUnitFourInteractiveTest extends BaseTestScript {
    private static final Logger logger = Logger.getLogger(GeometryUnitOneInteractivesTest.class);
    private String testCaseFailureText = "Test failed for method: ";
    private String assertFailurePreText = "Failed to verify: ";
    public String assertSuccessPreText = "Successfully verified: ";
    private InteractivesPage interactivesPage;
    private BasePage basePage;
    private String unit = "unit4";

    @Test(priority = 1, description = "Verify the Interactives of 4.1 Theorems and Proofs concept of Geometry book.")
    public void verifyInteractivesOfTheoremsAndProofsConcept() {
        boolean result = true;
        try {
            interactivesPage = new InteractivesPage(webDriver, extentTest, extentReports);
            basePage = new BasePage(webDriver, extentTest, extentReports);

            String url = "https://flexbooks.ck12.org/cbook/ck-12-interactive-geometry-for-ccss/section/4.1/primary/lesson/theorems-and-proofs-geo-ccss/";
            webDriver.navigate().to(url);

            for (int i = 0; i <= 40; i++) {
                scrollByPixel(300);
                basePage.waitForSec(3);
            }
            Assert.assertTrue(interactivesPage.verifyGeometrySmartPhases("Theorems and Proofs", unit), assertFailurePreText + "Presence of Interactives on the 4.1 concept of geometry book.");
            reportLog("Presence of Interactives on the 4.1 concept of geometry book.");

        } catch (Exception e) {
            result = handleException(e);
        }
        Assert.assertTrue(result, testCaseFailureText + currentMethodName + errorMessage);
    }

    @Test(priority = 2, description = "Verify the Interactives of 4.2 Theorems about Lines and Angles concept of Geometry book.")
    public void verifyInteractivesOfTheoremsAboutLinesAndAnglesConcept() {
        boolean result = true;
        try {
            String url = "https://flexbooks.ck12.org/cbook/ck-12-interactive-geometry-for-ccss/section/4.2/primary/lesson/theorems-about-lines-and-angles-geo-ccss/";
            webDriver.navigate().to(url);

            for (int i = 0; i <= 40; i++) {
                scrollByPixel(300);
                basePage.waitForSec(3);
            }
            Assert.assertTrue(interactivesPage.verifyGeometrySmartPhases("Theorems about Lines and Angles", unit), assertFailurePreText + "Presence of Interactives on the 4.2 concept of geometry book.");
            reportLog("Presence of Interactives on the 4.2 concept of geometry book.");

            Assert.assertTrue(interactivesPage.verifyDraggableInteractive("4_3_2", unit), assertFailurePreText + "Presence of Draggable Interactives on the 4.2 concept of geometry book.");
            reportLog("Presence of Draggable Interactives on the 4.2 concept of geometry book.");

        } catch (Exception e) {
            result = handleException(e);
        }
        Assert.assertTrue(result, testCaseFailureText + currentMethodName + errorMessage);
    }

    @Test(priority = 3, description = "Verify the Interactives of 4.3 Applications of Line and Angle Theorems concept of Geometry book.")
    public void verifyInteractivesOfSpheresConcept() {
        boolean result = true;
        try {
            String url = "https://flexbooks.ck12.org/cbook/ck-12-interactive-geometry-for-ccss/section/4.3/primary/lesson/applications-of-line-and-angle-theorems-geo-ccss/";
            webDriver.navigate().to(url);

            for (int i = 0; i <= 40; i++) {
                scrollByPixel(300);
                basePage.waitForSec(3);
            }
            Assert.assertTrue(interactivesPage.verifyGeometrySmartPhases("Applications of Line and Angle Theorems", unit), assertFailurePreText + "Presence of Interactives on the 4.3 concept of geometry book.");
            reportLog("Presence of Interactives on the 4.3 concept of geometry book.");

            Assert.assertTrue(interactivesPage.verifyDraggableInteractive("4_3_1", unit), assertFailurePreText + "Presence of Draggable Interactives on the 4.3 concept of geometry book.");
            reportLog("Presence of Draggable Interactives on the 4.3 concept of geometry book.");

            Assert.assertTrue(interactivesPage.verifyDraggableInteractive("4_3_2", unit), assertFailurePreText + "Presence of Draggable Interactives on the 4.3 concept of geometry book.");
            reportLog("Presence of Draggable Interactives on the 4.3 concept of geometry book.");

        } catch (Exception e) {
            result = handleException(e);
        }
        Assert.assertTrue(result, testCaseFailureText + currentMethodName + errorMessage);
    }

    @Test(priority = 4, description = "Verify the Interactives of 4.4 Theorems about Triangles concept of Geometry book.")
    public void verifyInteractivesOfTheoremsAboutTrianglesConcept() {
        boolean result = true;
        try {
            String url = "https://flexbooks.ck12.org/cbook/ck-12-interactive-geometry-for-ccss/section/4.4/primary/lesson/theorems-about-triangles-geo-ccss/";
            webDriver.navigate().to(url);

            for (int i = 0; i <= 40; i++) {
                scrollByPixel(300);
                basePage.waitForSec(3);
            }
            Assert.assertTrue(interactivesPage.verifyGeometrySmartPhases("Theorems about Triangles", unit), assertFailurePreText + "Presence of Interactives on the 4.4 concept of geometry book.");
            reportLog("Presence of Interactives on the 4.4 concept of geometry book.");

            Assert.assertTrue(interactivesPage.verifyDraggableInteractive("4_4_1", unit), assertFailurePreText + "Presence of Draggable Interactives on the 4.4 concept of geometry book.");
            reportLog("Presence of Draggable Interactives on the 4.4 concept of geometry book.");

            Assert.assertTrue(interactivesPage.verifyDraggableInteractive("4_4_2", unit), assertFailurePreText + "Presence of Draggable Interactives on the 4.4 concept of geometry book.");
            reportLog("Presence of Draggable Interactives on the 4.4 concept of geometry book.");

            Assert.assertTrue(interactivesPage.verifyDraggableInteractive("4_4_5", unit), assertFailurePreText + "Presence of Draggable Interactives on the 4.4 concept of geometry book.");
            reportLog("Presence of Draggable Interactives on the 4.4 concept of geometry book.");

            Assert.assertTrue(interactivesPage.verifyDraggableInteractive("4_4_8", unit), assertFailurePreText + "Presence of Draggable Interactives on the 4.4 concept of geometry book.");
            reportLog("Presence of Draggable Interactives on the 4.4 concept of geometry book.");

            Assert.assertTrue(interactivesPage.verifyDraggableInteractive("4_4_10", unit), assertFailurePreText + "Presence of Draggable Interactives on the 4.4 concept of geometry book.");
            reportLog("Presence of Draggable Interactives on the 4.4 concept of geometry book.");

            Assert.assertTrue(interactivesPage.verifyDraggableInteractive("4_4_12", unit), assertFailurePreText + "Presence of Draggable Interactives on the 4.4 concept of geometry book.");
            reportLog("Presence of Draggable Interactives on the 4.4 concept of geometry book.");

        } catch (Exception e) {
            result = handleException(e);
        }
        Assert.assertTrue(result, testCaseFailureText + currentMethodName + errorMessage);
    }

    @Test(priority = 5, description = "Verify the Interactives of 4.5 Theorems about Concurrence in Triangles concept of Geometry book.")
    public void verifyInteractivesOfTheoremsAboutConcurrenceInTrianglesConcept() {
        boolean result = true;
        try {
            String url = "https://flexbooks.ck12.org/cbook/ck-12-interactive-geometry-for-ccss/section/4.5/primary/lesson/theorems-about-concurrence-in-triangles-geo-ccss/";
            webDriver.navigate().to(url);

            for (int i = 0; i <= 40; i++) {
                scrollByPixel(300);
                basePage.waitForSec(3);
            }
            Assert.assertTrue(interactivesPage.verifyGeometrySmartPhases("Theorems about Concurrence in Triangles", unit), assertFailurePreText + "Presence of Interactives on the 4.5 concept of geometry book.");
            reportLog("Presence of Interactives on the 4.5 concept of geometry book.");

            Assert.assertTrue(interactivesPage.verifyDraggableInteractive("4_5_1", unit), assertFailurePreText + "Presence of Draggable Interactives on the 4.5 concept of geometry book.");
            reportLog("Presence of Draggable Interactives on the 4.5 concept of geometry book.");

            Assert.assertTrue(interactivesPage.verifyDraggableInteractive("4_5_2", unit), assertFailurePreText + "Presence of Draggable Interactives on the 4.5 concept of geometry book.");
            reportLog("Presence of Draggable Interactives on the 4.5 concept of geometry book.");

            Assert.assertTrue(interactivesPage.verifyDraggableInteractive("4_5_3", unit), assertFailurePreText + "Presence of Draggable Interactives on the 4.5 concept of geometry book.");
            reportLog("Presence of Draggable Interactives on the 4.5 concept of geometry book.");

            Assert.assertTrue(interactivesPage.verifyDraggableInteractive("4_5_4", unit), assertFailurePreText + "Presence of Draggable Interactives on the 4.5 concept of geometry book.");
            reportLog("Presence of Draggable Interactives on the 4.5 concept of geometry book.");

            Assert.assertTrue(interactivesPage.verifyDraggableInteractive("4_5_5", unit), assertFailurePreText + "Presence of Draggable Interactives on the 4.5 concept of geometry book.");
            reportLog("Presence of Draggable Interactives on the 4.5 concept of geometry book.");

        } catch (Exception e) {
            result = handleException(e);
        }
        Assert.assertTrue(result, testCaseFailureText + currentMethodName + errorMessage);
    }

    @Test(priority = 6, description = "Verify the Interactives of 4.6 Applications of Triangle Theorems concept of Geometry book.")
    public void verifyInteractivesOfApplicationsOfTriangleTheoremsConcept() {
        boolean result = true;
        try {
            String url = "https://flexbooks.ck12.org/cbook/ck-12-interactive-geometry-for-ccss/section/4.6/primary/lesson/applications-of-triangle-theorems-geo-ccss/";
            webDriver.navigate().to(url);

            for (int i = 0; i <= 40; i++) {
                scrollByPixel(300);
                basePage.waitForSec(3);
            }
            Assert.assertTrue(interactivesPage.verifyGeometrySmartPhases("Applications of Triangle Theorems", unit), assertFailurePreText + "Presence of Interactives on the 4.6 concept of geometry book.");
            reportLog("Presence of Interactives on the 4.6 concept of geometry book.");

        } catch (Exception e) {
            result = handleException(e);
        }
        Assert.assertTrue(result, testCaseFailureText + currentMethodName + errorMessage);
    }

    @Test(priority = 7, description = "Verify the Interactives of 4.7 Theorems about Quadrilaterals concept of Geometry book.")
    public void verifyInteractivesOfTheoremsAboutQuadrilateralsConcept() {
        boolean result = true;
        try {
            String url = "https://flexbooks.ck12.org/cbook/ck-12-interactive-geometry-for-ccss/section/4.7/primary/lesson/theorems-about-quadrilaterals-geo-ccss/";
            webDriver.navigate().to(url);

            for (int i = 0; i <= 40; i++) {
                scrollByPixel(300);
                basePage.waitForSec(3);
            }
            Assert.assertTrue(interactivesPage.verifyGeometrySmartPhases("Theorems about Quadrilaterals", unit), assertFailurePreText + "Presence of Interactives on the 4.7 concept of geometry book.");
            reportLog("Presence of Interactives on the 4.7 concept of geometry book.");

            Assert.assertTrue(interactivesPage.verifyDraggableInteractive("4_7_2a_Interactive", unit), assertFailurePreText + "Presence of Draggable Interactives on the 4.7 concept of geometry book.");
            reportLog("Presence of Draggable Interactives on the 4.7 concept of geometry book.");

            Assert.assertTrue(interactivesPage.verifyDraggableInteractive("4_7_4a_Interactive", unit), assertFailurePreText + "Presence of Draggable Interactives on the 4.7 concept of geometry book.");
            reportLog("Presence of Draggable Interactives on the 4.7 concept of geometry book.");

            Assert.assertTrue(interactivesPage.verifyDraggableInteractive("4_7_5a_Interactive", unit), assertFailurePreText + "Presence of Draggable Interactives on the 4.7 concept of geometry book.");
            reportLog("Presence of Draggable Interactives on the 4.7 concept of geometry book.");

            Assert.assertTrue(interactivesPage.verifyDraggableInteractive("4_7_10a_Interactive", unit), assertFailurePreText + "Presence of Draggable Interactives on the 4.7 concept of geometry book.");
            reportLog("Presence of Draggable Interactives on the 4.7 concept of geometry book.");

            Assert.assertTrue(interactivesPage.verifyDraggableInteractive("4_7_12a_Interactive", unit), assertFailurePreText + "Presence of Draggable Interactives on the 4.7 concept of geometry book.");
            reportLog("Presence of Draggable Interactives on the 4.7 concept of geometry book.");

        } catch (Exception e) {
            result = handleException(e);
        }
        Assert.assertTrue(result, testCaseFailureText + currentMethodName + errorMessage);
    }

    @Test(priority = 8, description = "Verify the Interactives of 4.8 Applications of Quadrilateral Theorems concept of Geometry book.")
    public void verifyInteractivesOfApplicationsOfQuadrilateralTheoremsConcept() {
        boolean result = true;
        try {
            String url = "https://flexbooks.ck12.org/cbook/ck-12-interactive-geometry-for-ccss/section/4.8/primary/lesson/applications-of-quadrilateral-theorems-geo-ccss/";
            webDriver.navigate().to(url);

            for (int i = 0; i <= 40; i++) {
                scrollByPixel(300);
                basePage.waitForSec(3);
            }

            Assert.assertTrue(interactivesPage.verifyGeometrySmartPhases("Applications of Quadrilateral Theorems", unit), assertFailurePreText + "Presence of Interactives on the 4.8 concept of geometry book.");
            reportLog("Presence of Interactives on the 4.8 concept of geometry book.");

        } catch (Exception e) {
            result = handleException(e);
        }
        Assert.assertTrue(result, testCaseFailureText + currentMethodName + errorMessage);
    }
}
