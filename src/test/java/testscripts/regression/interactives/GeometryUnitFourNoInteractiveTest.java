package testscripts.regression.interactives;

import org.testng.Assert;
import org.testng.annotations.Test;
import testscripts.BaseTestScript;
import uipages.BasePage;
import uipages.interactives.BiologyBookPage;

public class GeometryUnitFourNoInteractiveTest extends BaseTestScript {

    private BiologyBookPage biologyBookPage;
    private BasePage basePage;

    @Test(priority = 1, description = "Verify the Content of 4.1 Theorems and Proofs concept of Geometry book.")
    public void verifyContentOfTheoremsAndProofsConcept() {
        biologyBookPage = new BiologyBookPage(webDriver, extentTest, extentReports);
        basePage = new BasePage(webDriver, extentTest, extentReports);

        boolean result = true;
        try {
            String url = "https://flexbooks.ck12.org/cbook/ck-12-interactive-geometry-for-ccss/section/4.1/primary/lesson/theorems-and-proofs-geo-ccss/";
            webDriver.navigate().to(url);

            Assert.assertTrue(biologyBookPage.verifyModalityPageTitle("Theorems and Proofs"), assertFailurePreText + "Presence of title on the 4.1 concepts of Geometry book.");
            reportLog("Verified Modality title: " + webDriver.getTitle() + "on the 4.1 concept of Geometry book.");

            reportLog("The Page Description is: " + biologyBookPage.pageDescription.getAttribute("content"));

            Assert.assertTrue(biologyBookPage.verifyCanonicalMetaTag(), assertFailurePreText + "Presence of canonical meta tag on the 4.1 concepts of Geometry book.");
            reportLog("Verified Canonical Tag and 1 Tag is found with URL: " + biologyBookPage.canonicalData.getAttribute("href"));

            Assert.assertTrue(biologyBookPage.verifyHTagsInBook(), assertFailurePreText + "Presence of Header tag on the 4.1 concepts of Geometry book.");
            reportLog("Presence of all Header tag on the 4.1 concept of Geometry book.");

            Assert.assertTrue(biologyBookPage.verifyHyperLinkTagsAndParseTheURLOfTags(), assertFailurePreText + "Presence of hyperlinked words on the 4.1 concepts of Geometry book.");
            reportLog("Presence of all the hyperlinked words terms on the 4.1 concept of Geometry book.");

            for (int i = 0; i <= 20; i++) {
                scrollByPixel(300);
                basePage.waitForSec(2);
            }

            Assert.assertTrue(biologyBookPage.verifyTheImagesOfBiologyBook(), assertFailurePreText + "Presence of images on the 4.1 concepts of biology book.");
            reportLog("Presence of all images on the 4.1 concept of Biology book.");

            Assert.assertTrue(biologyBookPage.verifyTheVideosOfBiologyBook(), assertFailurePreText + "Presence of videos on the 4.1 concepts of Geometry book.");
            reportLog("Presence of all the videos on the 4.1 concept of Geometry book.");

            Assert.assertTrue(biologyBookPage.verifyMathEquationRenderedCorrect(), assertFailurePreText + "Presence of Math Elements on the 4.1 concepts of Geometry book.");
            reportLog("Verified Math Element rendered correctly on the 4.1 concept of Geometry book.");

        } catch (Exception e) {
            result = handleException(e);
        }
        Assert.assertTrue(result, "Test script failed for" + currentMethodName + errorMessage);
    }

    @Test(priority = 2, description = "Verify the Content of 4.2 Theorems about Lines and Angles concept of Geometry book.")
    public void verifyContentOfTheoremsAboutLinesAndAnglesConcepts() {
        boolean result = true;
        try {
            String url = "https://flexbooks.ck12.org/cbook/ck-12-interactive-geometry-for-ccss/section/4.2/primary/lesson/theorems-about-lines-and-angles-geo-ccss/";
            webDriver.navigate().to(url);

            Assert.assertTrue(biologyBookPage.verifyModalityPageTitle("Theorems about Lines and Angles"), assertFailurePreText + "Presence of title on the 4.2 concepts of Geometry book.");
            reportLog("Verified Modality title: " + webDriver.getTitle() + "on the 4.2 concept of Geometry book.");

            reportLog("The Page Description is: " + biologyBookPage.pageDescription.getAttribute("content"));

            Assert.assertTrue(biologyBookPage.verifyCanonicalMetaTag(), assertFailurePreText + "Presence of canonical meta tag on the 4.2 concepts of Geometry book.");
            reportLog("Verified Canonical Tag and 1 Tag is found with URL: " + biologyBookPage.canonicalData.getAttribute("href"));

            Assert.assertTrue(biologyBookPage.verifyHTagsInBook(), assertFailurePreText + "Presence of Header tag on the 4.2 concepts of Geometry book.");
            reportLog("Presence of all Header tag on the 4.2 concept of Geometry book.");

            Assert.assertTrue(biologyBookPage.verifyHyperLinkTagsAndParseTheURLOfTags(), assertFailurePreText + "Presence of hyperlinked words on the 4.2 concepts of Geometry book.");
            reportLog("Presence of all the hyperlinked words terms on the 4.2 concept of Geometry book.");

            for (int i = 0; i <= 20; i++) {
                scrollByPixel(300);
                basePage.waitForSec(2);
            }

            Assert.assertTrue(biologyBookPage.verifyTheImagesOfBiologyBook(), assertFailurePreText + "Presence of images on the 1.4 concepts of biology book.");
            reportLog("Presence of all images on the 4.2 concept of Biology book.");

            Assert.assertTrue(biologyBookPage.verifyTheVideosOfBiologyBook(), assertFailurePreText + "Presence of videos on the 4.2 concepts of Geometry book.");
            reportLog("Presence of all the videos on the 4.2 concept of Geometry book.");

            Assert.assertTrue(biologyBookPage.verifyMathEquationRenderedCorrect(), assertFailurePreText + "Presence of Math Elements on the 4.2 concepts of Geometry book.");
            reportLog("Verified Math Element rendered correctly on the 4.2 concept of Geometry book.");

        } catch (Exception e) {
            result = handleException(e);
        }
        Assert.assertTrue(result, "Test script failed for" + currentMethodName + errorMessage);
    }

    @Test(priority = 3, description = "Verify the Content of 4.3 Applications of Line and Angle Theorems concept of Geometry book.")
    public void verifyContentOfApplicationsOfLineAndAngleTheoremsConcept() {
        boolean result = true;
        try {
            String url = "https://flexbooks.ck12.org/cbook/ck-12-interactive-geometry-for-ccss/section/4.3/primary/lesson/applications-of-line-and-angle-theorems-geo-ccss/";
            webDriver.navigate().to(url);

            Assert.assertTrue(biologyBookPage.verifyModalityPageTitle("Applications of Line and Angle Theorems"), assertFailurePreText + "Presence of title on the 4.3 concepts of Geometry book.");
            reportLog("Verified Modality title: " + webDriver.getTitle() + "on the 4.3 concept of Geometry book.");

            reportLog("The Page Description is: " + biologyBookPage.pageDescription.getAttribute("content"));

            Assert.assertTrue(biologyBookPage.verifyCanonicalMetaTag(), assertFailurePreText + "Presence of canonical meta tag on the 4.3 concepts of biology book.");
            reportLog("Verified Canonical Tag and 1 Tag is found with URL: " + biologyBookPage.canonicalData.getAttribute("href"));

            Assert.assertTrue(biologyBookPage.verifyHTagsInBook(), assertFailurePreText + "Presence of Header tag on the 4.3 concepts of Geometry book.");
            reportLog("Presence of all Header tag on the 4.3 concept of Geometry book.");

            Assert.assertTrue(biologyBookPage.verifyHyperLinkTagsAndParseTheURLOfTags(), assertFailurePreText + "Presence of hyperlinked words on the 4.3 concepts of Geometry book.");
            reportLog("Presence of all the hyperlinked words terms on the 4.3 concept of Geometry book.");

            for (int i = 0; i <= 20; i++) {
                scrollByPixel(300);
                basePage.waitForSec(2);
            }

            Assert.assertTrue(biologyBookPage.verifyTheImagesOfBiologyBook(), assertFailurePreText + "Presence of images on the 4.3 concepts of biology book.");
            reportLog("Presence of all images on the 4.3 concept of Biology book.");

            Assert.assertTrue(biologyBookPage.verifyTheVideosOfBiologyBook(), assertFailurePreText + "Presence of videos on the 4.3 concepts of Geometry book.");
            reportLog("Presence of all the videos on the 4.3 concept of Geometry book.");

            Assert.assertTrue(biologyBookPage.verifyMathEquationRenderedCorrect(), assertFailurePreText + "Presence of Math Elements on the 4.3 concepts of Geometry book.");
            reportLog("Verified Math Element rendered correctly on the 4.3 concept of Geometry book.");

        } catch (Exception e) {
            result = handleException(e);
        }
        Assert.assertTrue(result, "Test script failed for" + currentMethodName + errorMessage);
    }

    @Test(priority = 4, description = "Verify the Content of 4.4 Theorems about Triangles concept of Geometry book.")
    public void verifyContentOfTheoremsAboutTrianglesConcept() {
        boolean result = true;
        try {
            String url = "https://flexbooks.ck12.org/cbook/ck-12-interactive-geometry-for-ccss/section/4.4/primary/lesson/theorems-about-triangles-geo-ccss/";
            webDriver.navigate().to(url);

            Assert.assertTrue(biologyBookPage.verifyModalityPageTitle("Theorems about Triangles"), assertFailurePreText + "Presence of title on the 4.4 concepts of Geometry book.");
            reportLog("Verified Modality title: " + webDriver.getTitle() + "on the 4.4 concept of Geometry book.");

            reportLog("The Page Description is: " + biologyBookPage.pageDescription.getAttribute("content"));

            Assert.assertTrue(biologyBookPage.verifyCanonicalMetaTag(), assertFailurePreText + "Presence of canonical meta tag on the 4.4 concepts of Geometry book.");
            reportLog("Verified Canonical Tag and 1 Tag is found with URL: " + biologyBookPage.canonicalData.getAttribute("href"));

            Assert.assertTrue(biologyBookPage.verifyHTagsInBook(), assertFailurePreText + "Presence of Header tag on the 4.4 concepts of Geometry book.");
            reportLog("Presence of all Header tag on the 4.4 concept of Geometry book.");

            Assert.assertTrue(biologyBookPage.verifyHyperLinkTagsAndParseTheURLOfTags(), assertFailurePreText + "Presence of hyperlinked words on the 4.4 concepts of Geometry book.");
            reportLog("Presence of all the hyperlinked words terms on the 4.4 concept of Geometry book.");

            for (int i = 0; i <= 20; i++) {
                scrollByPixel(300);
                basePage.waitForSec(2);
            }

            Assert.assertTrue(biologyBookPage.verifyTheImagesOfBiologyBook(), assertFailurePreText + "Presence of images on the 4.4 concepts of biology book.");
            reportLog("Presence of all images on the 4.4 concept of Biology book.");

            Assert.assertTrue(biologyBookPage.verifyTheVideosOfBiologyBook(), assertFailurePreText + "Presence of videos on the 4.4 concepts of Geometry book.");
            reportLog("Presence of all the videos on the 4.4 concept of Geometry book.");

            Assert.assertTrue(biologyBookPage.verifyMathEquationRenderedCorrect(), assertFailurePreText + "Presence of Math Elements on the 4.4 concepts of Geometry book.");
            reportLog("Verified Math Element rendered correctly on the 4.4 concept of Geometry book.");

        } catch (Exception e) {
            result = handleException(e);
        }
        Assert.assertTrue(result, "Test script failed for" + currentMethodName + errorMessage);
    }

    @Test(priority = 5, description = "Verify the Content of 4.5 Theorems about Concurrence in Triangles concept of Geometry book.")
    public void verifyContentOfTheoremsAboutConcurrenceInTrianglesConcept() {
        boolean result = true;
        try {
            String url = "https://flexbooks.ck12.org/cbook/ck-12-interactive-geometry-for-ccss/section/4.5/primary/lesson/theorems-about-concurrence-in-triangles-geo-ccss/";
            webDriver.navigate().to(url);

            Assert.assertTrue(biologyBookPage.verifyModalityPageTitle("Theorems about Concurrence in Triangles"), assertFailurePreText + "Presence of title on the 4.5 concepts of Geometry book.");
            reportLog("Verified Modality title: " + webDriver.getTitle() + "on the 4.5 concept of Geometry book.");

            reportLog("The Page Description is: " + biologyBookPage.pageDescription.getAttribute("content"));

            Assert.assertTrue(biologyBookPage.verifyCanonicalMetaTag(), assertFailurePreText + "Presence of canonical meta tag on the 4.5 concepts of Geometry book.");
            reportLog("Verified Canonical Tag and 1 Tag is found with URL: " + biologyBookPage.canonicalData.getAttribute("href"));

            Assert.assertTrue(biologyBookPage.verifyHTagsInBook(), assertFailurePreText + "Presence of Header tag on the 4.5 concepts of Geometry book.");
            reportLog("Presence of all Header tag on the 4.5 concept of Geometry book.");

            Assert.assertTrue(biologyBookPage.verifyHyperLinkTagsAndParseTheURLOfTags(), assertFailurePreText + "Presence of hyperlinked words on the 4.5 concepts of Geometry book.");
            reportLog("Presence of all the hyperlinked words terms on the 4.5 concept of Geometry book.");

            for (int i = 0; i <= 20; i++) {
                scrollByPixel(300);
                basePage.waitForSec(2);
            }

            Assert.assertTrue(biologyBookPage.verifyTheImagesOfBiologyBook(), assertFailurePreText + "Presence of images on the 4.5 concepts of biology book.");
            reportLog("Presence of all images on the 4.5 concept of Biology book.");

            Assert.assertTrue(biologyBookPage.verifyTheVideosOfBiologyBook(), assertFailurePreText + "Presence of videos on the 4.5 concepts of Geometry book.");
            reportLog("Presence of all the videos on the 4.5 concept of Geometry book.");

            Assert.assertTrue(biologyBookPage.verifyMathEquationRenderedCorrect(), assertFailurePreText + "Presence of Math Elements on the 4.5 concepts of Geometry book.");
            reportLog("Verified Math Element rendered correctly on the 4.5 concept of Geometry book.");

        } catch (Exception e) {
            result = handleException(e);
        }
        Assert.assertTrue(result, "Test script failed for" + currentMethodName + errorMessage);
    }

    @Test(priority = 6, description = "Verify the Content of 4.6 Applications of Triangle Theorems concept of Geometry book.")
    public void verifyContentOfApplicationsOfTriangleTheoremsConcept() {
        boolean result = true;
        try {
            String url = "https://flexbooks.ck12.org/cbook/ck-12-interactive-geometry-for-ccss/section/4.6/primary/lesson/applications-of-triangle-theorems-geo-ccss/";
            webDriver.navigate().to(url);

            Assert.assertTrue(biologyBookPage.verifyModalityPageTitle("Applications of Triangle Theorems"), assertFailurePreText + "Presence of title on the 4.6 concepts of Geometry book.");
            reportLog("Verified Modality title: " + webDriver.getTitle() + "on the 4.6 concept of Geometry book.");

            reportLog("The Page Description is: " + biologyBookPage.pageDescription.getAttribute("content"));

            Assert.assertTrue(biologyBookPage.verifyCanonicalMetaTag(), assertFailurePreText + "Presence of canonical meta tag on the 4.6 concepts of Geometry book.");
            reportLog("Verified Canonical Tag and 1 Tag is found with URL: " + biologyBookPage.canonicalData.getAttribute("href"));

            Assert.assertTrue(biologyBookPage.verifyHTagsInBook(), assertFailurePreText + "Presence of Header tag on the 4.6 concepts of Geometry book.");
            reportLog("Presence of all Header tag on the 4.6 concept of Geometry book.");

            Assert.assertTrue(biologyBookPage.verifyHyperLinkTagsAndParseTheURLOfTags(), assertFailurePreText + "Presence of hyperlinked words on the 4.6 concepts of Geometry book.");
            reportLog("Presence of all the hyperlinked words terms on the 4.6 concept of Geometry book.");

            for (int i = 0; i <= 20; i++) {
                scrollByPixel(300);
                basePage.waitForSec(2);
            }

            Assert.assertTrue(biologyBookPage.verifyTheImagesOfBiologyBook(), assertFailurePreText + "Presence of images on the 4.6 concepts of biology book.");
            reportLog("Presence of all images on the 4.6 concept of Biology book.");

            Assert.assertTrue(biologyBookPage.verifyTheVideosOfBiologyBook(), assertFailurePreText + "Presence of videos on the 4.6 concepts of Geometry book.");
            reportLog("Presence of all the videos on the 4.6 concept of Geometry book.");

            Assert.assertTrue(biologyBookPage.verifyMathEquationRenderedCorrect(), assertFailurePreText + "Presence of Math Elements on the 4.6 concepts of Geometry book.");
            reportLog("Verified Math Element rendered correctly on the 4.6 concept of Geometry book.");

        } catch (Exception e) {
            result = handleException(e);
        }
        Assert.assertTrue(result, "Test script failed for" + currentMethodName + errorMessage);
    }

    @Test(priority = 7, description = "Verify the Content of 4.7 Theorems about Quadrilaterals concept of Geometry book.")
    public void verifyContentOfTheoremsAboutQuadrilateralsConcept() {
        boolean result = true;
        try {
            String url = "https://flexbooks.ck12.org/cbook/ck-12-interactive-geometry-for-ccss/section/4.7/primary/lesson/theorems-about-quadrilaterals-geo-ccss/";
            webDriver.navigate().to(url);

            Assert.assertTrue(biologyBookPage.verifyModalityPageTitle("Theorems about Quadrilaterals"), assertFailurePreText + "Presence of title on the 4.7 concepts of Geometry book.");
            reportLog("Verified Modality title: " + webDriver.getTitle() + "on the 4.7 concept of Geometry book.");

            reportLog("The Page Description is: " + biologyBookPage.pageDescription.getAttribute("content"));

            Assert.assertTrue(biologyBookPage.verifyCanonicalMetaTag(), assertFailurePreText + "Presence of canonical meta tag on the 4.7 concepts of Geometry book.");
            reportLog("Verified Canonical Tag and 1 Tag is found with URL: " + biologyBookPage.canonicalData.getAttribute("href"));

            Assert.assertTrue(biologyBookPage.verifyHTagsInBook(), assertFailurePreText + "Presence of Header tag on the 4.7 concepts of Geometry book.");
            reportLog("Presence of all Header tag on the 4.7 concept of Geometry book.");

            Assert.assertTrue(biologyBookPage.verifyHyperLinkTagsAndParseTheURLOfTags(), assertFailurePreText + "Presence of hyperlinked words on the 4.7 concepts of Geometry book.");
            reportLog("Presence of all the hyperlinked words terms on the 4.7 concept of Geometry book.");

            for (int i = 0; i <= 20; i++) {
                scrollByPixel(300);
                basePage.waitForSec(2);
            }

            Assert.assertTrue(biologyBookPage.verifyTheImagesOfBiologyBook(), assertFailurePreText + "Presence of images on the 4.7 concepts of biology book.");
            reportLog("Presence of all images on the 4.7 concept of Biology book.");

            Assert.assertTrue(biologyBookPage.verifyTheVideosOfBiologyBook(), assertFailurePreText + "Presence of videos on the 4.7 concepts of Geometry book.");
            reportLog("Presence of all the videos on the 4.7 concept of Geometry book.");

            Assert.assertTrue(biologyBookPage.verifyMathEquationRenderedCorrect(), assertFailurePreText + "Presence of Math Elements on the 4.7 concepts of Geometry book.");
            reportLog("Verified Math Element rendered correctly on the 4.7 concept of Geometry book.");

        } catch (Exception e) {
            result = handleException(e);
        }
        Assert.assertTrue(result, "Test script failed for" + currentMethodName + errorMessage);
    }

    @Test(priority = 8, description = "Verify the Content of 4.8 Applications of Quadrilateral Theorems concept of Geometry book.")
    public void verifyContentOfApplicationsOfQuadrilateralTheoremsConcept() {
        boolean result = true;
        try {
            String url = "https://flexbooks.ck12.org/cbook/ck-12-interactive-geometry-for-ccss/section/4.8/primary/lesson/applications-of-quadrilateral-theorems-geo-ccss/";
            webDriver.navigate().to(url);

            Assert.assertTrue(biologyBookPage.verifyModalityPageTitle("Applications of Quadrilateral Theorems"), assertFailurePreText + "Presence of title on the 4.8 concepts of Geometry book.");
            reportLog("Verified Modality title: " + webDriver.getTitle() + "on the 4.8 concept of Geometry book.");

            reportLog("The Page Description is: " + biologyBookPage.pageDescription.getAttribute("content"));

            Assert.assertTrue(biologyBookPage.verifyCanonicalMetaTag(), assertFailurePreText + "Presence of canonical meta tag on the 4.8 concepts of Geometry book.");
            reportLog("Verified Canonical Tag and 1 Tag is found with URL: " + biologyBookPage.canonicalData.getAttribute("href"));

            Assert.assertTrue(biologyBookPage.verifyHTagsInBook(), assertFailurePreText + "Presence of Header tag on the 4.8 concepts of Geometry book.");
            reportLog("Presence of all Header tag on the 4.8 concept of Geometry book.");

            Assert.assertTrue(biologyBookPage.verifyHyperLinkTagsAndParseTheURLOfTags(), assertFailurePreText + "Presence of hyperlinked words on the 4.8 concepts of Geometry book.");
            reportLog("Presence of all the hyperlinked words terms on the 4.8 concept of Geometry book.");

            for (int i = 0; i <= 20; i++) {
                scrollByPixel(300);
                basePage.waitForSec(2);
            }

            Assert.assertTrue(biologyBookPage.verifyTheImagesOfBiologyBook(), assertFailurePreText + "Presence of images on the 4.8 concepts of biology book.");
            reportLog("Presence of all images on the 4.8 concept of Biology book.");

            Assert.assertTrue(biologyBookPage.verifyTheVideosOfBiologyBook(), assertFailurePreText + "Presence of videos on the 4.8 concepts of Geometry book.");
            reportLog("Presence of all the videos on the 4.8 concept of Geometry book.");

            Assert.assertTrue(biologyBookPage.verifyMathEquationRenderedCorrect(), assertFailurePreText + "Presence of Math Elements on the 4.8 concepts of Geometry book.");
            reportLog("Verified Math Element rendered correctly on the 4.8 concept of Geometry book.");

        } catch (Exception e) {
            result = handleException(e);
        }
        Assert.assertTrue(result, "Test script failed for" + currentMethodName + errorMessage);
    }
}
