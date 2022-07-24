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

public class GeometryUnitFiveInteractiveTest extends BaseTestScript {
    private static final Logger logger = Logger.getLogger(GeometryUnitOneInteractivesTest.class);
    private String testCaseFailureText = "Test failed for method: ";
    private String assertFailurePreText = "Failed to verify: ";
    public String assertSuccessPreText = "Successfully verified: ";
    private InteractivesPage interactivesPage;
    private BasePage basePage;
    private String unit = "unit5";

    @Test(priority = 1, description = "Verify the Interactives of 5.1 Copies of Line Segments and Angles concept of Geometry book.")
    public void verifyInteractivesOfDefinitionOfCongruenceConcept() {
        boolean result = true;
        try {
            interactivesPage = new InteractivesPage(webDriver, extentTest, extentReports);
            basePage = new BasePage(webDriver, extentTest, extentReports);

            String url = "https://flexbooks.ck12.org/cbook/ck-12-interactive-geometry-for-ccss/section/5.1/primary/lesson/copies-of-line-segments-and-angles-geo-ccss/";
            webDriver.navigate().to(url);

            for (int i = 0; i <= 35; i++) {
                scrollByPixel(300);
                basePage.waitForSec(3);
            }

            Assert.assertTrue(interactivesPage.verifyGeometrySmartPhases("Copies of Line Segments and Angles", unit), assertFailurePreText + "Presence of Interactives on the 5.1 concept of geometry book.");
            reportLog("Presence of Interactives on the 5.1 concept of geometry book.");

        } catch (Exception e) {
            result = handleException(e);
        }
        Assert.assertTrue(result, testCaseFailureText + currentMethodName + errorMessage);
    }

    @Test(priority = 2, description = "Verify the Interactives of 5.2 Bisectors of Line Segments and Angles concept of Geometry book.")
    public void verifyInteractivesOfBisectorsOfLineSegmentsAndAnglesConcept() {
        boolean result = true;
        try {
            String url = "https://flexbooks.ck12.org/cbook/ck-12-interactive-geometry-for-ccss/section/5.2/primary/lesson/bisectors-of-line-segments-and-angles-geo-ccss/";
            webDriver.navigate().to(url);

            for (int i = 0; i <= 35; i++) {
                scrollByPixel(300);
                basePage.waitForSec(3);
            }
            Assert.assertTrue(interactivesPage.verifyGeometrySmartPhases("Bisectors of Line Segments and Angles", unit), assertFailurePreText + "Presence of Interactives on the 3.2 concept of geometry book.");
            reportLog("Presence of Interactives on the 3.2 concept of geometry book.");

        } catch (Exception e) {
            result = handleException(e);
        }
        Assert.assertTrue(result, testCaseFailureText + currentMethodName + errorMessage);
    }

    @Test(priority = 3, description = "Verify the Interactives of 5.3 Parallel and Perpendicular Line Constructions concept of Geometry book.")
    public void verifyInteractivesOfParallelAndPerpendicularLineConstructionsConcept() {
        boolean result = true;
        try {
            String url = "https://flexbooks.ck12.org/cbook/ck-12-interactive-geometry-for-ccss/section/5.3/primary/lesson/parallel-and-perpendicular-line-constructions-geo-ccss/";
            webDriver.navigate().to(url);

            for (int i = 0; i <= 35; i++) {
                scrollByPixel(300);
                basePage.waitForSec(3);
            }
            Assert.assertTrue(interactivesPage.verifyGeometrySmartPhases("Parallel and Perpendicular Line Constructions", unit), assertFailurePreText + "Presence of Interactives on the 5.3 concept of geometry book.");
            reportLog("Presence of Interactives on the 5.3 concept of geometry book.");

        } catch (Exception e) {
            result = handleException(e);
        }
        Assert.assertTrue(result, testCaseFailureText + currentMethodName + errorMessage);
    }

    @Test(priority = 4, description = "Verify the Interactives of 5.4 Constructions of Regular Polygons concept of Geometry book.")
    public void verifyInteractivesOfConstructionsOfRegularPolygonsConcept() {
        boolean result = true;
        try {
            String url = "https://flexbooks.ck12.org/cbook/ck-12-interactive-geometry-for-ccss/section/5.4/primary/lesson/constructions-of-regular-polygons-geo-ccss/";
            webDriver.navigate().to(url);

            for (int i = 0; i <= 35; i++) {
                scrollByPixel(300);
                basePage.waitForSec(3);
            }
            Assert.assertTrue(interactivesPage.verifyGeometrySmartPhases("Constructions of Regular Polygons", unit), assertFailurePreText + "Presence of Interactives on the 5.4 concept of geometry book.");
            reportLog("Presence of Interactives on the 5.4 concept of geometry book.");

        } catch (Exception e) {
            result = handleException(e);
        }
        Assert.assertTrue(result, testCaseFailureText + currentMethodName + errorMessage);
    }
}
