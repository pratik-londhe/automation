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

public class GeometryUnitSevenInterativesTest extends BaseTestScript {
    private static final Logger logger = Logger.getLogger(GeometryUnitOneInteractivesTest.class);
    private String testCaseFailureText = "Test failed for method: ";
    private String assertFailurePreText = "Failed to verify: ";
    public String assertSuccessPreText = "Successfully verified: ";
    private InteractivesPage interactivesPage;
    private BasePage basePage;
    private String unit = "unit7";

    @Test(priority = 1, description = "Verify the Interactives of 7.1 Tangent Ratio concept of Geometry book.")
    public void verifyInteractivesOfTangentRatioConcept() {
        boolean result = true;
        try {
            interactivesPage = new InteractivesPage(webDriver, extentTest, extentReports);
            basePage = new BasePage(webDriver, extentTest, extentReports);

            String url = "https://flexbooks.ck12.org/cbook/ck-12-interactive-geometry-for-ccss/section/7.1/primary/lesson/tangent-ratio-geo-ccss/";
            webDriver.navigate().to(url);

            for (int i = 0; i <= 21; i++) {
                scrollByPixel(300);
                basePage.waitForSec(3);
            }
            Assert.assertTrue(interactivesPage.verifyGeometrySmartPhases("Tangent Ratio", unit), assertFailurePreText + "Presence of Interactives on the 7.1 concept of geometry book.");
            reportLog("Presence of Interactives on the 7.1 concept of geometry book.");

            Assert.assertTrue(interactivesPage.verifyEquationInteractive("7_1_7", unit), assertFailurePreText + "Presence of Equation Interactives on the 7.1 concept of geometry book.");
            reportLog("Presence of Equation Interactives on the 7.1 concept of geometry book.");

            Assert.assertTrue(interactivesPage.verifyEquationInteractive("7_1_8", unit), assertFailurePreText + "Presence of Equation Interactives on the 7.1 concept of geometry book.");
            reportLog("Presence of Equation Interactives on the 7.1 concept of geometry book.");

            Assert.assertTrue(interactivesPage.verifyEquationInteractive("7_1_9", unit), assertFailurePreText + "Presence of Equation Interactives on the 7.1 concept of geometry book.");
            reportLog("Presence of Equation Interactives on the 7.1 concept of geometry book.");

            Assert.assertTrue(interactivesPage.verifyEquationInteractive("7_1_10", unit), assertFailurePreText + "Presence of Equation Interactives on the 7.1 concept of geometry book.");
            reportLog("Presence of Equation Interactives on the 7.1 concept of geometry book.");

        } catch (Exception e) {
            result = handleException(e);
        }
        Assert.assertTrue(result, testCaseFailureText + currentMethodName + errorMessage);
    }

    @Test(priority = 2, description = "Verify the Interactives of 7.2 Sine and Cosine Ratios concept of Geometry book.")
    public void verifyInteractivesOfSineAndCosineRatiosConcept() {
        boolean result = true;
        try {
            String url = "https://flexbooks.ck12.org/cbook/ck-12-interactive-geometry-for-ccss/section/7.2/primary/lesson/sine-and-cosine-ratios-geo-ccss/";
            webDriver.navigate().to(url);

            for (int i = 0; i <= 21; i++) {
                scrollByPixel(300);
                basePage.waitForSec(3);
            }

            Assert.assertTrue(interactivesPage.verifyGeometrySmartPhases("Sine and Cosine Ratios", unit), assertFailurePreText + "Presence of Interactives on the 7.2 concept of geometry book.");
            reportLog("Presence of Interactives on the 7.2 concept of geometry book.");

            Assert.assertTrue(interactivesPage.verifyEquationInteractive("7_2_5", unit), assertFailurePreText + "Presence of Equation Interactives on the 7.2 concept of geometry book.");
            reportLog("Presence of Equation Interactives on the 7.2 concept of geometry book.");

            Assert.assertTrue(interactivesPage.verifyEquationInteractive("7_2_6", unit), assertFailurePreText + "Presence of Equation Interactives on the 7.2 concept of geometry book.");
            reportLog("Presence of Equation Interactives on the 7.2 concept of geometry book.");

            Assert.assertTrue(interactivesPage.verifyEquationInteractive("7_2_7", unit), assertFailurePreText + "Presence of Equation Interactives on the 7.2 concept of geometry book.");
            reportLog("Presence of Equation Interactives on the 7.2 concept of geometry book.");

        } catch (Exception e) {
            result = handleException(e);
        }
        Assert.assertTrue(result, testCaseFailureText + currentMethodName + errorMessage);
    }

    @Test(priority = 3, description = "Verify the Interactives of 7.3 Sine and Cosine of Complementary Angles concept of Geometry book.")
    public void verifyInteractivesOfSineAndCosineOfComplementaryAnglesConcept() {
        boolean result = true;
        try {
            String url = "https://flexbooks.ck12.org/cbook/ck-12-interactive-geometry-for-ccss/section/7.3/primary/lesson/sine-and-cosine-of-complementary-angles-geo-ccss/";
            webDriver.navigate().to(url);

            for (int i = 0; i <= 21; i++) {
                scrollByPixel(300);
                basePage.waitForSec(3);
            }

            Assert.assertTrue(interactivesPage.verifyGeometrySmartPhases("Sine and Cosine of Complementary Angles", unit), assertFailurePreText + "Presence of Interactives on the 7.3 concept of geometry book.");
            reportLog("Presence of Interactives on the 7.3 concept of geometry book.");

        } catch (Exception e) {
            result = handleException(e);
        }
        Assert.assertTrue(result, testCaseFailureText + currentMethodName + errorMessage);
    }

    @Test(priority = 4, description = "Verify the Interactives of 7.4 Inverse Trigonometric Ratios concept of Geometry book.")
    public void verifyInteractivesOfInverseTrigonometricRatiosConcept() {
        boolean result = true;
        try {
            String url = "https://flexbooks.ck12.org/cbook/ck-12-interactive-geometry-for-ccss/section/7.4/primary/lesson/inverse-trigonometric-ratios-geo-ccss/";
            webDriver.navigate().to(url);

            for (int i = 0; i <= 21; i++) {
                scrollByPixel(300);
                basePage.waitForSec(3);
            }

            Assert.assertTrue(interactivesPage.verifyGeometrySmartPhases("Inverse Trigonometric Ratios", unit), assertFailurePreText + "Presence of Interactives on the 7.4 concept of geometry book.");
            reportLog("Presence of Interactives on the 7.4 concept of geometry book.");

            Assert.assertTrue(interactivesPage.verifyEquationInteractive("7_4_3", unit), assertFailurePreText + "Presence of Equation Interactives on the 7.4 concept of geometry book.");
            reportLog("Presence of Equation Interactives on the 7.4 concept of geometry book.");

            Assert.assertTrue(interactivesPage.verifyEquationInteractive("7_4_5", unit), assertFailurePreText + "Presence of Equation Interactives on the 7.4 concept of geometry book.");
            reportLog("Presence of Equation Interactives on the 7.4 concept of geometry book.");

        } catch (Exception e) {
            result = handleException(e);
        }
        Assert.assertTrue(result, testCaseFailureText + currentMethodName + errorMessage);
    }

    @Test(priority = 5, description = "Verify the Interactives of 7.5 Sine to Find the Area of a Triangle concept of Geometry book.")
    public void verifyInteractivesOfSineToFindTheAreaOfATriangleRatiosConcept() {
        boolean result = true;
        try {
            String url = "https://flexbooks.ck12.org/cbook/ck-12-interactive-geometry-for-ccss/section/7.5/primary/lesson/sine-to-find-the-area-of-a-triangle-geo-ccss/";
            webDriver.navigate().to(url);

            for (int i = 0; i <= 21; i++) {
                scrollByPixel(300);
                basePage.waitForSec(3);
            }

            Assert.assertTrue(interactivesPage.verifyGeometrySmartPhases("Sine to Find the Area of a Triangle", unit), assertFailurePreText + "Presence of Interactives on the 7.5 concept of geometry book.");
            reportLog("Presence of Interactives on the 7.5 concept of geometry book.");

            Assert.assertTrue(interactivesPage.verifyEquationInteractive("7_5_3", unit), assertFailurePreText + "Presence of Equation Interactives on the 7.5 concept of geometry book.");
            reportLog("Presence of Equation Interactives on the 7.5 concept of geometry book.");

            Assert.assertTrue(interactivesPage.verifyEquationInteractive("7_5_6", unit), assertFailurePreText + "Presence of Equation Interactives on the 7.5 concept of geometry book.");
            reportLog("Presence of Equation Interactives on the 7.5 concept of geometry book.");

        } catch (Exception e) {
            result = handleException(e);
        }
        Assert.assertTrue(result, testCaseFailureText + currentMethodName + errorMessage);
    }

    @Test(priority = 6, description = "Verify the Interactives of 7.6 Law of Sines concept of Geometry book.")
    public void verifyInteractivesOfLawOfSinesConcept() {
        boolean result = true;
        try {
            String url = "https://flexbooks.ck12.org/cbook/ck-12-interactive-geometry-for-ccss/section/7.6/primary/lesson/law-of-sines-geo-ccss/";
            webDriver.navigate().to(url);

            for (int i = 0; i <= 21; i++) {
                scrollByPixel(300);
                basePage.waitForSec(3);
            }

            Assert.assertTrue(interactivesPage.verifyGeometrySmartPhases("Law of Sines", unit), assertFailurePreText + "Presence of Interactives on the 7.6 concept of geometry book.");
            reportLog("Presence of Interactives on the 7.6 concept of geometry book.");

            Assert.assertTrue(interactivesPage.verifyEquationInteractive("7_6_8", unit), assertFailurePreText + "Presence of Equation Interactives on the 7.6 concept of geometry book.");
            reportLog("Presence of Equation Interactives on the 7.6 concept of geometry book.");

            Assert.assertTrue(interactivesPage.verifyEquationInteractive("7_6_9", unit), assertFailurePreText + "Presence of Equation Interactives on the 7.6 concept of geometry book.");
            reportLog("Presence of Equation Interactives on the 7.6 concept of geometry book.");

            Assert.assertTrue(interactivesPage.verifyDraggableInteractive("7_6_7", unit), assertFailurePreText + "Presence of Draggable Interactives on the 7.6 concept of geometry book.");
            reportLog("Presence of Draggable Interactives on the 7.6 concept of geometry book.");

        } catch (Exception e) {
            result = handleException(e);
        }
        Assert.assertTrue(result, testCaseFailureText + currentMethodName + errorMessage);
    }

    @Test(priority = 7, description = "Verify the Interactives of 7.7 Law of Cosines concept of Geometry book.")
    public void verifyInteractivesOfLawOfCosinesConcept() {
        boolean result = true;
        try {
            String url = "https://flexbooks.ck12.org/cbook/ck-12-interactive-geometry-for-ccss/section/7.7/primary/lesson/law-of-cosines-geo-ccss/";
            webDriver.navigate().to(url);

            for (int i = 0; i <= 21; i++) {
                scrollByPixel(300);
                basePage.waitForSec(3);
            }

            Assert.assertTrue(interactivesPage.verifyGeometrySmartPhases("Law of Cosines", unit), assertFailurePreText + "Presence of Interactives on the 7.7 concept of geometry book.");
            reportLog("Presence of Interactives on the 7.7 concept of geometry book.");

            Assert.assertTrue(interactivesPage.verifyEquationInteractive("7_7_3", unit), assertFailurePreText + "Presence of Equation Interactives on the 7.7 concept of geometry book.");
            reportLog("Presence of Equation Interactives on the 7.7 concept of geometry book.");

            Assert.assertTrue(interactivesPage.verifyEquationInteractive("7_7_5", unit), assertFailurePreText + "Presence of Equation Interactives on the 7.7 concept of geometry book.");
            reportLog("Presence of Equation Interactives on the 7.7 concept of geometry book.");

        } catch (Exception e) {
            result = handleException(e);
        }
        Assert.assertTrue(result, testCaseFailureText + currentMethodName + errorMessage);
    }

    @Test(priority = 8, description = "Verify the Interactives of 7.8 Triangles in Applied Problems concept of Geometry book.")
    public void verifyInteractivesOfTrianglesInAppliedProblemsConcept() {
        boolean result = true;
        try {
            String url = "https://flexbooks.ck12.org/cbook/ck-12-interactive-geometry-for-ccss/section/7.8/primary/lesson/triangles-in-applied-problems-geo-ccss/";
            webDriver.navigate().to(url);

            for (int i = 0; i <= 21; i++) {
                scrollByPixel(300);
                basePage.waitForSec(3);
            }

            Assert.assertTrue(interactivesPage.verifyGeometrySmartPhases("Triangles in Applied Problems", unit), assertFailurePreText + "Presence of Interactives on the 7.8 concept of geometry book.");
            reportLog("Presence of Interactives on the 7.8 concept of geometry book.");

            Assert.assertTrue(interactivesPage.verifyEquationInteractive("7_8_9", unit), assertFailurePreText + "Presence of Equation Interactives on the 7.8 concept of geometry book.");
            reportLog("Presence of Equation Interactives on the 7.8 concept of geometry book.");

            Assert.assertTrue(interactivesPage.verifyEquationInteractive("7_8_10", unit), assertFailurePreText + "Presence of Equation Interactives on the 7.8 concept of geometry book.");
            reportLog("Presence of Equation Interactives on the 7.8 concept of geometry book.");

        } catch (Exception e) {
            result = handleException(e);
        }
        Assert.assertTrue(result, testCaseFailureText + currentMethodName + errorMessage);
    }

}
