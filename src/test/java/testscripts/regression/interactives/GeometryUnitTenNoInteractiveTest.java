package testscripts.regression.interactives;

import org.testng.Assert;
import org.testng.annotations.Test;
import testscripts.BaseTestScript;
import uipages.BasePage;
import uipages.interactives.BiologyBookPage;

public class GeometryUnitTenNoInteractiveTest extends BaseTestScript {

    private BiologyBookPage biologyBookPage;
    private BasePage basePage;

    @Test(priority = 1, description = "Verify the Content of 10.1 Conic Sections concept of Geometry book.")
    public void verifyContentOfConicSectionsConcept() {
        biologyBookPage = new BiologyBookPage(webDriver, extentTest, extentReports);
        basePage = new BasePage(webDriver, extentTest, extentReports);

        boolean result = true;
        try {
            String url = "https://flexbooks.ck12.org/cbook/ck-12-interactive-geometry-for-ccss/section/10.1/primary/lesson/conic-sections-geo-ccss/";
            webDriver.navigate().to(url);

            Assert.assertTrue(biologyBookPage.verifyModalityPageTitle("Conic Sections"), assertFailurePreText + "Presence of title on the 10.1 concepts of Geometry book.");
            reportLog("Verified Modality title: " + webDriver.getTitle() + "on the 10.1 concept of Geometry book.");

            reportLog("The Page Description is: " + biologyBookPage.pageDescription.getAttribute("content"));

            Assert.assertTrue(biologyBookPage.verifyCanonicalMetaTag(), assertFailurePreText + "Presence of canonical meta tag on the 10.1 concepts of Geometry book.");
            reportLog("Verified Canonical Tag and 1 Tag is found with URL: " + biologyBookPage.canonicalData.getAttribute("href"));

            Assert.assertTrue(biologyBookPage.verifyHTagsInBook(), assertFailurePreText + "Presence of Header tag on the 10.1 concepts of Geometry book.");
            reportLog("Presence of all Header tag on the 10.1 concept of Geometry book.");

            for (int i = 0; i <= 20; i++) {
                scrollByPixel(300);
                basePage.waitForSec(2);
            }

            Assert.assertTrue(biologyBookPage.verifyTheImagesOfBiologyBook(), assertFailurePreText + "Presence of images on the 10.1 concepts of Geometry book.");
            reportLog("Presence of all images on the 10.1 concept of Geometry book.");

            Assert.assertTrue(biologyBookPage.verifyTheVideosOfBiologyBook(), assertFailurePreText + "Presence of videos on the 10.1 concepts of Geometry book.");
            reportLog("Presence of all the videos on the 10.1 concept of Geometry book.");

            Assert.assertTrue(biologyBookPage.verifyMathEquationRenderedCorrect(), assertFailurePreText + "Presence of Math Elements on the 10.1 concepts of Geometry book.");
            reportLog("Verified Math Element rendered correctly on the 10.1 concept of Geometry book.");

        } catch (Exception e) {
            result = handleException(e);
        }
        Assert.assertTrue(result, "Test script failed for" + currentMethodName + errorMessage);
    }

    @Test(priority = 2, description = "Verify the Content of 10.2 Equations of Circles concept of Geometry book.")
    public void verifyContentOfEquations0fCirclesConcepts() {
        boolean result = true;
        try {
            String url = "https://flexbooks.ck12.org/cbook/ck-12-interactive-geometry-for-ccss/section/10.2/primary/lesson/equations-of-circles-geo-ccss/";
            webDriver.navigate().to(url);

            Assert.assertTrue(biologyBookPage.verifyModalityPageTitle("Equations of Circles"), assertFailurePreText + "Presence of title on the 10.2 concepts of Geometry book.");
            reportLog("Verified Modality title: " + webDriver.getTitle() + "on the 10.2 concept of Geometry book.");

            reportLog("The Page Description is: " + biologyBookPage.pageDescription.getAttribute("content"));

            Assert.assertTrue(biologyBookPage.verifyCanonicalMetaTag(), assertFailurePreText + "Presence of canonical meta tag on the 10.2 concepts of Geometry book.");
            reportLog("Verified Canonical Tag and 1 Tag is found with URL: " + biologyBookPage.canonicalData.getAttribute("href"));

            Assert.assertTrue(biologyBookPage.verifyHTagsInBook(), assertFailurePreText + "Presence of Header tag on the 10.2 concepts of Geometry book.");
            reportLog("Presence of all Header tag on the 10.2 concept of Geometry book.");

            Assert.assertTrue(biologyBookPage.verifyHyperLinkTagsAndParseTheURLOfTags(), assertFailurePreText + "Presence of hyperlinked words on the 10.2 concepts of Geometry book.");
            reportLog("Presence of all the hyperlinked words terms on the 10.2 concept of Geometry book.");

            for (int i = 0; i <= 20; i++) {
                scrollByPixel(300);
                basePage.waitForSec(2);
            }

            Assert.assertTrue(biologyBookPage.verifyTheImagesOfBiologyBook(), assertFailurePreText + "Presence of images on the 10.2 concepts of Geometry book.");
            reportLog("Presence of all images on the 10.2 concept of Geometry book.");

            Assert.assertTrue(biologyBookPage.verifyTheVideosOfBiologyBook(), assertFailurePreText + "Presence of videos on the 10.2 concepts of Geometry book.");
            reportLog("Presence of all the videos on the 10.2 concept of Geometry book.");

            Assert.assertTrue(biologyBookPage.verifyMathEquationRenderedCorrect(), assertFailurePreText + "Presence of Math Elements on the 10.2 concepts of Geometry book.");
            reportLog("Verified Math Element rendered correctly on the 10.2 concept of Geometry book.");

        } catch (Exception e) {
            result = handleException(e);
        }
        Assert.assertTrue(result, "Test script failed for" + currentMethodName + errorMessage);
    }

    @Test(priority = 3, description = "Verify the Content of 10.3 Equations of Parabolas concept of Geometry book.")
    public void verifyContentOfEquationsOfParabolasConcept() {
        boolean result = true;
        try {
            String url = "https://flexbooks.ck12.org/cbook/ck-12-interactive-geometry-for-ccss/section/10.3/primary/lesson/equations-of-parabolas-geo-ccss/";
            webDriver.navigate().to(url);

            Assert.assertTrue(biologyBookPage.verifyModalityPageTitle("Equations of Parabolas"), assertFailurePreText + "Presence of title on the 10.3 concepts of Geometry book.");
            reportLog("Verified Modality title: " + webDriver.getTitle() + "on the 10.3 concept of Geometry book.");

            reportLog("The Page Description is: " + biologyBookPage.pageDescription.getAttribute("content"));

            Assert.assertTrue(biologyBookPage.verifyCanonicalMetaTag(), assertFailurePreText + "Presence of canonical meta tag on the 10.3 concepts of biology book.");
            reportLog("Verified Canonical Tag and 1 Tag is found with URL: " + biologyBookPage.canonicalData.getAttribute("href"));

            Assert.assertTrue(biologyBookPage.verifyHTagsInBook(), assertFailurePreText + "Presence of Header tag on the 10.3 concepts of Geometry book.");
            reportLog("Presence of all Header tag on the 10.3 concept of Geometry book.");

            Assert.assertTrue(biologyBookPage.verifyHyperLinkTagsAndParseTheURLOfTags(), assertFailurePreText + "Presence of hyperlinked words on the 10.3 concepts of Geometry book.");
            reportLog("Presence of all the hyperlinked words terms on the 10.3 concept of Geometry book.");

            for (int i = 0; i <= 20; i++) {
                scrollByPixel(300);
                basePage.waitForSec(2);
            }

            Assert.assertTrue(biologyBookPage.verifyTheImagesOfBiologyBook(), assertFailurePreText + "Presence of images on the 10.3 concepts of Geometry book.");
            reportLog("Presence of all images on the 10.3 concept of Geometry book.");

            Assert.assertTrue(biologyBookPage.verifyTheVideosOfBiologyBook(), assertFailurePreText + "Presence of videos on the 10.3 concepts of Geometry book.");
            reportLog("Presence of all the videos on the 10.3 concept of Geometry book.");

            Assert.assertTrue(biologyBookPage.verifyMathEquationRenderedCorrect(), assertFailurePreText + "Presence of Math Elements on the 10.3 concepts of Geometry book.");
            reportLog("Verified Math Element rendered correctly on the 10.3 concept of Geometry book.");

        } catch (Exception e) {
            result = handleException(e);
        }
        Assert.assertTrue(result, "Test script failed for" + currentMethodName + errorMessage);
    }

    @Test(priority = 4, description = "Verify the Content of 10.4 Slope of Parallel and Perpendicular Lines concept of Geometry book.")
    public void verifyContentOfSlopeOfParallelAndPerpendicularLinesConcept() {
        boolean result = true;
        try {
            String url = "https://flexbooks.ck12.org/cbook/ck-12-interactive-geometry-for-ccss/section/10.4/primary/lesson/slope-of-parallel-and-perpendicular-lines-geo-ccss/";
            webDriver.navigate().to(url);

            Assert.assertTrue(biologyBookPage.verifyModalityPageTitle("Slope of Parallel and Perpendicular Lines"), assertFailurePreText + "Presence of title on the 10.4 concepts of Geometry book.");
            reportLog("Verified Modality title: " + webDriver.getTitle() + "on the 10.4 concept of Geometry book.");

            reportLog("The Page Description is: " + biologyBookPage.pageDescription.getAttribute("content"));

            Assert.assertTrue(biologyBookPage.verifyCanonicalMetaTag(), assertFailurePreText + "Presence of canonical meta tag on the 10.4 concepts of Geometry book.");
            reportLog("Verified Canonical Tag and 1 Tag is found with URL: " + biologyBookPage.canonicalData.getAttribute("href"));

            Assert.assertTrue(biologyBookPage.verifyHTagsInBook(), assertFailurePreText + "Presence of Header tag on the 10.4 concepts of Geometry book.");
            reportLog("Presence of all Header tag on the 10.4 concept of Geometry book.");

            Assert.assertTrue(biologyBookPage.verifyHyperLinkTagsAndParseTheURLOfTags(), assertFailurePreText + "Presence of hyperlinked words on the 10.4 concepts of Geometry book.");
            reportLog("Presence of all the hyperlinked words terms on the 10.4 concept of Geometry book.");

            for (int i = 0; i <= 20; i++) {
                scrollByPixel(300);
                basePage.waitForSec(2);
            }

            Assert.assertTrue(biologyBookPage.verifyTheImagesOfBiologyBook(), assertFailurePreText + "Presence of images on the 10.4 concepts of Geometry book.");
            reportLog("Presence of all images on the 10.4 concept of Geometry book.");

            Assert.assertTrue(biologyBookPage.verifyTheVideosOfBiologyBook(), assertFailurePreText + "Presence of videos on the 10.4 concepts of Geometry book.");
            reportLog("Presence of all the videos on the 10.4 concept of Geometry book.");

            Assert.assertTrue(biologyBookPage.verifyMathEquationRenderedCorrect(), assertFailurePreText + "Presence of Math Elements on the 10.4 concepts of Geometry book.");
            reportLog("Verified Math Element rendered correctly on the 10.4 concept of Geometry book.");

        } catch (Exception e) {
            result = handleException(e);
        }
        Assert.assertTrue(result, "Test script failed for" + currentMethodName + errorMessage);
    }

    @Test(priority = 5, description = "Verify the Content of 10.5 The Distance Formula concept of Geometry book.")
    public void verifyContentOfTheDistanceFormulaConcept() {
        boolean result = true;
        try {
            String url = "https://flexbooks.ck12.org/cbook/ck-12-interactive-geometry-for-ccss/section/10.5/primary/lesson/the-distance-formula-geo-ccss/";
            webDriver.navigate().to(url);

            Assert.assertTrue(biologyBookPage.verifyModalityPageTitle("The Distance Formula"), assertFailurePreText + "Presence of title on the 10.5 concepts of Geometry book.");
            reportLog("Verified Modality title: " + webDriver.getTitle() + "on the 10.5 concept of Geometry book.");

            reportLog("The Page Description is: " + biologyBookPage.pageDescription.getAttribute("content"));

            Assert.assertTrue(biologyBookPage.verifyCanonicalMetaTag(), assertFailurePreText + "Presence of canonical meta tag on the 10.5 concepts of Geometry book.");
            reportLog("Verified Canonical Tag and 1 Tag is found with URL: " + biologyBookPage.canonicalData.getAttribute("href"));

            Assert.assertTrue(biologyBookPage.verifyHTagsInBook(), assertFailurePreText + "Presence of Header tag on the 10.5 concepts of Geometry book.");
            reportLog("Presence of all Header tag on the 10.5 concept of Geometry book.");

            Assert.assertTrue(biologyBookPage.verifyHyperLinkTagsAndParseTheURLOfTags(), assertFailurePreText + "Presence of hyperlinked words on the 10.6 concepts of Geometry book.");
            reportLog("Presence of all the hyperlinked words terms on the 10.5 concept of Geometry book.");

            for (int i = 0; i <= 20; i++) {
                scrollByPixel(300);
                basePage.waitForSec(2);
            }

            Assert.assertTrue(biologyBookPage.verifyTheImagesOfBiologyBook(), assertFailurePreText + "Presence of images on the 10.5 concepts of Geometry book.");
            reportLog("Presence of all images on the 10.5 concept of Geometry book.");

            Assert.assertTrue(biologyBookPage.verifyTheVideosOfBiologyBook(), assertFailurePreText + "Presence of videos on the 10.5 concepts of Geometry book.");
            reportLog("Presence of all the videos on the 10.5 concept of Geometry book.");

            Assert.assertTrue(biologyBookPage.verifyMathEquationRenderedCorrect(), assertFailurePreText + "Presence of Math Elements on the 10.5 concepts of Geometry book.");
            reportLog("Verified Math Element rendered correctly on the 10.5 concept of Geometry book.");

        } catch (Exception e) {
            result = handleException(e);
        }
        Assert.assertTrue(result, "Test script failed for" + currentMethodName + errorMessage);
    }

    @Test(priority = 6, description = "Verify the Content of 10.6 Points that Partition Line Segments concept of Geometry book.")
    public void verifyContentOfPointsThatPartitionLineSegmentsConcept() {
        boolean result = true;
        try {
            String url = "https://flexbooks.ck12.org/cbook/ck-12-interactive-geometry-for-ccss/section/10.6/primary/lesson/points-that-partition-line-segments-geo-ccss/";
            webDriver.navigate().to(url);

            Assert.assertTrue(biologyBookPage.verifyModalityPageTitle("Points that Partition Line Segments"), assertFailurePreText + "Presence of title on the 10.6 concepts of Geometry book.");
            reportLog("Verified Modality title: " + webDriver.getTitle() + "on the 10.6 concept of Geometry book.");

            reportLog("The Page Description is: " + biologyBookPage.pageDescription.getAttribute("content"));

            Assert.assertTrue(biologyBookPage.verifyCanonicalMetaTag(), assertFailurePreText + "Presence of canonical meta tag on the 10.6 concepts of Geometry book.");
            reportLog("Verified Canonical Tag and 1 Tag is found with URL: " + biologyBookPage.canonicalData.getAttribute("href"));

            Assert.assertTrue(biologyBookPage.verifyHTagsInBook(), assertFailurePreText + "Presence of Header tag on the 10.6 concepts of Geometry book.");
            reportLog("Presence of all Header tag on the 10.6 concept of Geometry book.");

            Assert.assertTrue(biologyBookPage.verifyHyperLinkTagsAndParseTheURLOfTags(), assertFailurePreText + "Presence of hyperlinked words on the 10.6 concepts of Geometry book.");
            reportLog("Presence of all the hyperlinked words terms on the 10.6 concept of Geometry book.");

            for (int i = 0; i <= 20; i++) {
                scrollByPixel(300);
                basePage.waitForSec(2);
            }

            Assert.assertTrue(biologyBookPage.verifyTheImagesOfBiologyBook(), assertFailurePreText + "Presence of images on the 10.6 concepts of Geometry book.");
            reportLog("Presence of all images on the 10.6 concept of Geometry book.");

            Assert.assertTrue(biologyBookPage.verifyTheVideosOfBiologyBook(), assertFailurePreText + "Presence of videos on the 10.6 concepts of Geometry book.");
            reportLog("Presence of all the videos on the 10.6 concept of Geometry book.");

            Assert.assertTrue(biologyBookPage.verifyMathEquationRenderedCorrect(), assertFailurePreText + "Presence of Math Elements on the 10.6 concepts of Geometry book.");
            reportLog("Verified Math Element rendered correctly on the 10.6 concept of Geometry book.");

        } catch (Exception e) {
            result = handleException(e);
        }
        Assert.assertTrue(result, "Test script failed for" + currentMethodName + errorMessage);
    }

    @Test(priority = 7, description = "Verify the Content of 10.7 Coordinate Proofs concept of Geometry book.")
    public void verifyContentOfCoordinateProofsConcept() {
        boolean result = true;
        try {
            String url = "https://flexbooks.ck12.org/cbook/ck-12-interactive-geometry-for-ccss/section/10.7/primary/lesson/coordinate-proofs-geo-ccss/";
            webDriver.navigate().to(url);

            Assert.assertTrue(biologyBookPage.verifyModalityPageTitle("Coordinate Proofs"), assertFailurePreText + "Presence of title on the 10.7 concepts of Geometry book.");
            reportLog("Verified Modality title: " + webDriver.getTitle() + "on the 10.7 concept of Geometry book.");

            reportLog("The Page Description is: " + biologyBookPage.pageDescription.getAttribute("content"));

            Assert.assertTrue(biologyBookPage.verifyCanonicalMetaTag(), assertFailurePreText + "Presence of canonical meta tag on the 10.7 concepts of Geometry book.");
            reportLog("Verified Canonical Tag and 1 Tag is found with URL: " + biologyBookPage.canonicalData.getAttribute("href"));

            Assert.assertTrue(biologyBookPage.verifyHTagsInBook(), assertFailurePreText + "Presence of Header tag on the 10.7 concepts of Geometry book.");
            reportLog("Presence of all Header tag on the 10.7 concept of Geometry book.");

            Assert.assertTrue(biologyBookPage.verifyHyperLinkTagsAndParseTheURLOfTags(), assertFailurePreText + "Presence of hyperlinked words on the 10.7 concepts of Geometry book.");
            reportLog("Presence of all the hyperlinked words terms on the 10.7 concept of Geometry book.");

            for (int i = 0; i <= 20; i++) {
                scrollByPixel(300);
                basePage.waitForSec(2);
            }

            Assert.assertTrue(biologyBookPage.verifyTheImagesOfBiologyBook(), assertFailurePreText + "Presence of images on the 10.7 concepts of Geometry book.");
            reportLog("Presence of all images on the 10.7 concept of Geometry book.");

            Assert.assertTrue(biologyBookPage.verifyTheVideosOfBiologyBook(), assertFailurePreText + "Presence of videos on the 10.7 concepts of Geometry book.");
            reportLog("Presence of all the videos on the 10.7 concept of Geometry book.");

            Assert.assertTrue(biologyBookPage.verifyMathEquationRenderedCorrect(), assertFailurePreText + "Presence of Math Elements on the 10.7 concepts of Geometry book.");
            reportLog("Verified Math Element rendered correctly on the 10.7 concept of Geometry book.");

        } catch (Exception e) {
            result = handleException(e);
        }
        Assert.assertTrue(result, "Test script failed for" + currentMethodName + errorMessage);
    }
}
