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

public class GeometryUnitThreeInteractiveTest extends BaseTestScript {
    private static final Logger logger = Logger.getLogger(GeometryUnitOneInteractivesTest.class);
    private String testCaseFailureText = "Test failed for method: ";
    private String assertFailurePreText = "Failed to verify: ";
    public String assertSuccessPreText = "Successfully verified: ";
    private InteractivesPage interactivesPage;
    private BasePage basePage;
    private String unit = "unit3";

    @Test(priority = 1, description = "Verify the Interactives of 3.1 Definition of Congruence concept of Geometry book.")
    public void verifyInteractivesOfDefinitionOfCongruenceConcept() {
        boolean result = true;
        try {
            interactivesPage = new InteractivesPage(webDriver, extentTest, extentReports);
            basePage = new BasePage(webDriver, extentTest, extentReports);

            String url = "https://flexbooks.ck12.org/cbook/ck-12-interactive-geometry-for-ccss/section/3.1/primary/lesson/definition-of-congruence-geo-ccss/";
            webDriver.navigate().to(url);

            for (int i = 0; i <= 35; i++) {
                scrollByPixel(300);
                basePage.waitForSec(3);
            }

            Assert.assertTrue(interactivesPage.verifyGeometrySmartPhases("Definition of Congruence", unit), assertFailurePreText + "Presence of Interactives on the 3.1 concept of geometry book.");
            reportLog("Presence of Interactives on the 3.1 concept of geometry book.");

        } catch (Exception e) {
            result = handleException(e);
        }
        Assert.assertTrue(result, testCaseFailureText + currentMethodName + errorMessage);
    }

    @Test(priority = 2, description = "Verify the Interactives of 3.2 ASA and AAS Triangle Congruence concept of Geometry book.")
    public void verifyInteractivesOfASAAndAASTriangleCongruenceConcept() {
        boolean result = true;
        try {
            String url = "https://flexbooks.ck12.org/cbook/ck-12-interactive-geometry-for-ccss/section/3.2/primary/lesson/asa-and-aas-triangle-congruence-geo-ccss/";
            webDriver.navigate().to(url);

            for (int i = 0; i <= 35; i++) {
                scrollByPixel(300);
                basePage.waitForSec(3);
            }
            Assert.assertTrue(interactivesPage.verifyGeometrySmartPhases("ASA and AAS Triangle Congruence", unit), assertFailurePreText + "Presence of Interactives on the 3.2 concept of geometry book.");
            reportLog("Presence of Interactives on the 3.2 concept of geometry book.");

            Assert.assertTrue(interactivesPage.verifyDraggableInteractive("3_2_2", unit), assertFailurePreText + "Presence of Draggable Interactives on the 3.2 concept of geometry book.");
            reportLog("Presence of Draggable Interactives on the 3.2 concept of geometry book.");

        } catch (Exception e) {
            result = handleException(e);
        }
        Assert.assertTrue(result, testCaseFailureText + currentMethodName + errorMessage);
    }

    @Test(priority = 3, description = "Verify the Interactives of 3.3 SAS Triangle Congruence concept of Geometry book.")
    public void verifyInteractivesOfSASTriangleCongruenceConcept() {
        boolean result = true;
        try {
            String url = "https://flexbooks.ck12.org/cbook/ck-12-interactive-geometry-for-ccss/section/3.3/primary/lesson/sas-triangle-congruence-geo-ccss/";
            webDriver.navigate().to(url);

            for (int i = 0; i <= 35; i++) {
                scrollByPixel(300);
                basePage.waitForSec(3);
            }
            Assert.assertTrue(interactivesPage.verifyGeometrySmartPhases("SAS Triangle Congruence", unit), assertFailurePreText + "Presence of Interactives on the 3.3 concept of geometry book.");
            reportLog("Presence of Interactives on the 3.3 concept of geometry book.");

            Assert.assertTrue(interactivesPage.verifyDraggableInteractive("3_3_2", unit), assertFailurePreText + "Presence of Draggable Interactives on the 3.3 concept of geometry book.");
            reportLog("Presence of Draggable Interactives on the 3.3 concept of geometry book.");

        } catch (Exception e) {
            result = handleException(e);
        }
        Assert.assertTrue(result, testCaseFailureText + currentMethodName + errorMessage);
    }

    @Test(priority = 4, description = "Verify the Interactives of 3.4 SSS Triangle Congruence concept of Geometry book.")
    public void verifyInteractivesOfSSSTriangleCongruenceConcept() {
        boolean result = true;
        try {
            String url = "https://flexbooks.ck12.org/cbook/ck-12-interactive-geometry-for-ccss/section/3.4/primary/lesson/sss-triangle-congruence-geo-ccss/";
            webDriver.navigate().to(url);

            for (int i = 0; i <= 35; i++) {
                scrollByPixel(300);
                basePage.waitForSec(3);
            }
            Assert.assertTrue(interactivesPage.verifyGeometrySmartPhases("SSS Triangle Congruence", unit), assertFailurePreText + "Presence of Interactives on the 3.4 concept of geometry book.");
            reportLog("Presence of Interactives on the 3.4 concept of geometry book.");

            Assert.assertTrue(interactivesPage.verifyDraggableInteractive("3_4_2", unit), assertFailurePreText + "Presence of Draggable Interactives on the 3.4 concept of geometry book.");
            reportLog("Presence of Draggable Interactives on the 3.4 concept of geometry book.");

        } catch (Exception e) {
            result = handleException(e);
        }
        Assert.assertTrue(result, testCaseFailureText + currentMethodName + errorMessage);
    }

    @Test(priority = 5, description = "Verify the Interactives of 3.5 Applications of Congruent Triangles concept of Geometry book.")
    public void verifyInteractivesOfApplicationsOfCongruentTrianglesConcept() {
        boolean result = true;
        try {
            String url = "https://flexbooks.ck12.org/cbook/ck-12-interactive-geometry-for-ccss/section/3.5/primary/lesson/applications-of-congruent-triangles-geo-ccss/";
            webDriver.navigate().to(url);

            for (int i = 0; i <= 35; i++) {
                scrollByPixel(300);
                basePage.waitForSec(2);
            }
            Assert.assertTrue(interactivesPage.verifyGeometrySmartPhases("Applications of Congruent Triangles", unit), assertFailurePreText + "Presence of Interactives on the 3.5 concept of geometry book.");
            reportLog("Presence of Interactives on the 3.5 concept of geometry book.");

        } catch (Exception e) {
            result = handleException(e);
        }
        Assert.assertTrue(result, testCaseFailureText + currentMethodName + errorMessage);
    }
}
