package testscripts.regression.interactives;

import org.testng.Assert;
import org.testng.annotations.Test;
import testscripts.BaseTestScript;
import uipages.BasePage;
import uipages.interactives.BiologyBookPage;

public class GeometryUnitThreeNoInteractiveTest extends BaseTestScript {

    private BiologyBookPage biologyBookPage;
    private BasePage basePage;

    @Test(priority = 1, description = "Verify the Content of 3.1 Definition of Congruence concept of Geometry book.")
    public void verifyContentOfDefinitionOfCongruenceConcept() {
        biologyBookPage = new BiologyBookPage(webDriver, extentTest, extentReports);
        basePage = new BasePage(webDriver, extentTest, extentReports);

        boolean result = true;
        try {
            String url = "https://flexbooks.ck12.org/cbook/ck-12-interactive-geometry-for-ccss/section/3.1/primary/lesson/definition-of-congruence-geo-ccss/";
            webDriver.navigate().to(url);

            Assert.assertTrue(biologyBookPage.verifyModalityPageTitle("Definition of Congruence"), assertFailurePreText + "Presence of title on the 3.1 concepts of Geometry book.");
            reportLog("Verified Modality title: " + webDriver.getTitle() + "on the 3.1 concept of Geometry book.");

            reportLog("The Page Description is: " + biologyBookPage.pageDescription.getAttribute("content"));

            Assert.assertTrue(biologyBookPage.verifyCanonicalMetaTag(), assertFailurePreText + "Presence of canonical meta tag on the 3.1 concepts of Geometry book.");
            reportLog("Verified Canonical Tag and 1 Tag is found with URL: " + biologyBookPage.canonicalData.getAttribute("href"));

            Assert.assertTrue(biologyBookPage.verifyHTagsInBook(), assertFailurePreText + "Presence of Header tag on the 3.1 concepts of Geometry book.");
            reportLog("Presence of all Header tag on the 3.1 concept of Geometry book.");

            for (int i = 0; i <= 20; i++) {
                scrollByPixel(300);
                basePage.waitForSec(2);
            }

            Assert.assertTrue(biologyBookPage.verifyTheImagesOfBiologyBook(), assertFailurePreText + "Presence of images on the 1.4 concepts of biology book.");
            reportLog("Presence of all images on the 3.1 concept of Biology book.");

            Assert.assertTrue(biologyBookPage.verifyTheVideosOfBiologyBook(), assertFailurePreText + "Presence of videos on the 3.1 concepts of Geometry book.");
            reportLog("Presence of all the videos on the 3.1 concept of Geometry book.");

            Assert.assertTrue(biologyBookPage.verifyMathEquationRenderedCorrect(), assertFailurePreText + "Presence of Math Elements on the 3.1 concepts of Geometry book.");
            reportLog("Verified Math Element rendered correctly on the 3.1 concept of Geometry book.");

        } catch (Exception e) {
            result = handleException(e);
        }
        Assert.assertTrue(result, "Test script failed for" + currentMethodName + errorMessage);
    }

    @Test(priority = 2, description = "Verify the Content of 3.2 ASA and AAS Triangle Congruence concept of Geometry book.")
    public void verifyContentOfASAAndAASTriangleCongruenceConcepts() {
        boolean result = true;
        try {
            String url = "https://flexbooks.ck12.org/cbook/ck-12-interactive-geometry-for-ccss/section/3.2/primary/lesson/asa-and-aas-triangle-congruence-geo-ccss/";
            webDriver.navigate().to(url);

            Assert.assertTrue(biologyBookPage.verifyModalityPageTitle("ASA and AAS Triangle Congruence"), assertFailurePreText + "Presence of title on the 3.2 concepts of Geometry book.");
            reportLog("Verified Modality title: " + webDriver.getTitle() + "on the 3.2 concept of Geometry book.");

            reportLog("The Page Description is: " + biologyBookPage.pageDescription.getAttribute("content"));

            Assert.assertTrue(biologyBookPage.verifyCanonicalMetaTag(), assertFailurePreText + "Presence of canonical meta tag on the 3.2 concepts of Geometry book.");
            reportLog("Verified Canonical Tag and 1 Tag is found with URL: " + biologyBookPage.canonicalData.getAttribute("href"));

            Assert.assertTrue(biologyBookPage.verifyHTagsInBook(), assertFailurePreText + "Presence of Header tag on the 3.2 concepts of Geometry book.");
            reportLog("Presence of all Header tag on the 3.2 concept of Geometry book.");

            for (int i = 0; i <= 20; i++) {
                scrollByPixel(300);
                basePage.waitForSec(2);
            }

            Assert.assertTrue(biologyBookPage.verifyTheImagesOfBiologyBook(), assertFailurePreText + "Presence of images on the 1.4 concepts of biology book.");
            reportLog("Presence of all images on the 3.2 concept of Biology book.");

            Assert.assertTrue(biologyBookPage.verifyTheVideosOfBiologyBook(), assertFailurePreText + "Presence of videos on the 3.2 concepts of Geometry book.");
            reportLog("Presence of all the videos on the 3.2 concept of Geometry book.");

            Assert.assertTrue(biologyBookPage.verifyMathEquationRenderedCorrect(), assertFailurePreText + "Presence of Math Elements on the 3.2 concepts of Geometry book.");
            reportLog("Verified Math Element rendered correctly on the 3.2 concept of Geometry book.");

        } catch (Exception e) {
            result = handleException(e);
        }
        Assert.assertTrue(result, "Test script failed for" + currentMethodName + errorMessage);
    }

    @Test(priority = 3, description = "Verify the Content of 3.3 SAS Triangle Congruence concept of Geometry book.")
    public void verifyContentOfSASTriangleCongruenceConcept() {
        boolean result = true;
        try {
            String url = "https://flexbooks.ck12.org/cbook/ck-12-interactive-geometry-for-ccss/section/3.3/primary/lesson/sas-triangle-congruence-geo-ccss/";
            webDriver.navigate().to(url);

            Assert.assertTrue(biologyBookPage.verifyModalityPageTitle("SAS Triangle Congruence"), assertFailurePreText + "Presence of title on the 3.3 concepts of Geometry book.");
            reportLog("Verified Modality title: " + webDriver.getTitle() + "on the 3.3 concept of Geometry book.");

            reportLog("The Page Description is: " + biologyBookPage.pageDescription.getAttribute("content"));

            Assert.assertTrue(biologyBookPage.verifyCanonicalMetaTag(), assertFailurePreText + "Presence of canonical meta tag on the 3.3 concepts of biology book.");
            reportLog("Verified Canonical Tag and 1 Tag is found with URL: " + biologyBookPage.canonicalData.getAttribute("href"));

            Assert.assertTrue(biologyBookPage.verifyHTagsInBook(), assertFailurePreText + "Presence of Header tag on the 3.3 concepts of Geometry book.");
            reportLog("Presence of all Header tag on the 3.3 concept of Geometry book.");

            for (int i = 0; i <= 20; i++) {
                scrollByPixel(300);
                basePage.waitForSec(2);
            }

            Assert.assertTrue(biologyBookPage.verifyTheImagesOfBiologyBook(), assertFailurePreText + "Presence of images on the 1.4 concepts of biology book.");
            reportLog("Presence of all images on the 3.3 concept of Biology book.");

            Assert.assertTrue(biologyBookPage.verifyTheVideosOfBiologyBook(), assertFailurePreText + "Presence of videos on the 3.3 concepts of Geometry book.");
            reportLog("Presence of all the videos on the 3.3 concept of Geometry book.");

            Assert.assertTrue(biologyBookPage.verifyMathEquationRenderedCorrect(), assertFailurePreText + "Presence of Math Elements on the 3.3 concepts of Geometry book.");
            reportLog("Verified Math Element rendered correctly on the 3.3 concept of Geometry book.");

        } catch (Exception e) {
            result = handleException(e);
        }
        Assert.assertTrue(result, "Test script failed for" + currentMethodName + errorMessage);
    }

    @Test(priority = 4, description = "Verify the Content of 3.4 SSS Triangle Congruence concept of Geometry book.")
    public void verifyContentOfSSSTriangleCongruenceConcept() {
        boolean result = true;
        try {
            String url = "https://flexbooks.ck12.org/cbook/ck-12-interactive-geometry-for-ccss/section/3.4/primary/lesson/sss-triangle-congruence-geo-ccss/";
            webDriver.navigate().to(url);

            Assert.assertTrue(biologyBookPage.verifyModalityPageTitle("SSS Triangle Congruence"), assertFailurePreText + "Presence of title on the 3.4 concepts of Geometry book.");
            reportLog("Verified Modality title: " + webDriver.getTitle() + "on the 3.4 concept of Geometry book.");

            reportLog("The Page Description is: " + biologyBookPage.pageDescription.getAttribute("content"));

            Assert.assertTrue(biologyBookPage.verifyCanonicalMetaTag(), assertFailurePreText + "Presence of canonical meta tag on the 3.4 concepts of Geometry book.");
            reportLog("Verified Canonical Tag and 1 Tag is found with URL: " + biologyBookPage.canonicalData.getAttribute("href"));

            Assert.assertTrue(biologyBookPage.verifyHTagsInBook(), assertFailurePreText + "Presence of Header tag on the 3.4 concepts of Geometry book.");
            reportLog("Presence of all Header tag on the 3.4 concept of Geometry book.");

            Assert.assertTrue(biologyBookPage.verifyHyperLinkTagsAndParseTheURLOfTags(), assertFailurePreText + "Presence of hyperlinked words on the 3.4 concepts of Geometry book.");
            reportLog("Presence of all the hyperlinked words terms on the 3.4 concept of Geometry book.");

            for (int i = 0; i <= 20; i++) {
                scrollByPixel(300);
                basePage.waitForSec(2);
            }

            Assert.assertTrue(biologyBookPage.verifyTheImagesOfBiologyBook(), assertFailurePreText + "Presence of images on the 1.4 concepts of biology book.");
            reportLog("Presence of all images on the 3.4 concept of Biology book.");

            Assert.assertTrue(biologyBookPage.verifyTheVideosOfBiologyBook(), assertFailurePreText + "Presence of videos on the 3.4 concepts of Geometry book.");
            reportLog("Presence of all the videos on the 3.4 concept of Geometry book.");

            Assert.assertTrue(biologyBookPage.verifyMathEquationRenderedCorrect(), assertFailurePreText + "Presence of Math Elements on the 3.4 concepts of Geometry book.");
            reportLog("Verified Math Element rendered correctly on the 3.4 concept of Geometry book.");

        } catch (Exception e) {
            result = handleException(e);
        }
        Assert.assertTrue(result, "Test script failed for" + currentMethodName + errorMessage);
    }

    @Test(priority = 5, description = "Verify the Content of 3.5 Applications of Congruent Triangles concept of Geometry book.")
    public void verifyContentOfApplicationsOfCongruentTrianglesConcept() {
        boolean result = true;
        try {
            String url = "https://flexbooks.ck12.org/cbook/ck-12-interactive-geometry-for-ccss/section/3.5/primary/lesson/applications-of-congruent-triangles-geo-ccss/";
            webDriver.navigate().to(url);

            Assert.assertTrue(biologyBookPage.verifyModalityPageTitle("Applications of Congruent Triangles"), assertFailurePreText + "Presence of title on the 3.5 concepts of Geometry book.");
            reportLog("Verified Modality title: " + webDriver.getTitle() + "on the 3.5 concept of Geometry book.");

            reportLog("The Page Description is: " + biologyBookPage.pageDescription.getAttribute("content"));

            Assert.assertTrue(biologyBookPage.verifyCanonicalMetaTag(), assertFailurePreText + "Presence of canonical meta tag on the 3.5 concepts of Geometry book.");
            reportLog("Verified Canonical Tag and 1 Tag is found with URL: " + biologyBookPage.canonicalData.getAttribute("href"));

            Assert.assertTrue(biologyBookPage.verifyHTagsInBook(), assertFailurePreText + "Presence of Header tag on the 3.5 concepts of Geometry book.");
            reportLog("Presence of all Header tag on the 3.5 concept of Geometry book.");

            for (int i = 0; i <= 20; i++) {
                scrollByPixel(300);
                basePage.waitForSec(2);
            }

            Assert.assertTrue(biologyBookPage.verifyTheImagesOfBiologyBook(), assertFailurePreText + "Presence of images on the 1.4 concepts of biology book.");
            reportLog("Presence of all images on the 3.5 concept of Biology book.");

            Assert.assertTrue(biologyBookPage.verifyTheVideosOfBiologyBook(), assertFailurePreText + "Presence of videos on the 3.5 concepts of Geometry book.");
            reportLog("Presence of all the videos on the 3.5 concept of Geometry book.");

            Assert.assertTrue(biologyBookPage.verifyMathEquationRenderedCorrect(), assertFailurePreText + "Presence of Math Elements on the 3.5 concepts of Geometry book.");
            reportLog("Verified Math Element rendered correctly on the 3.5 concept of Geometry book.");

        } catch (Exception e) {
            result = handleException(e);
        }
        Assert.assertTrue(result, "Test script failed for" + currentMethodName + errorMessage);
    }
}