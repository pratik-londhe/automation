package testscripts.regression.interactives;

import org.testng.Assert;
import org.testng.annotations.Test;
import testscripts.BaseTestScript;
import uipages.BasePage;
import uipages.interactives.BiologyBookPage;

public class GeometryUnitTwoNoInteractiveTest extends BaseTestScript {

    private BiologyBookPage biologyBookPage;
    private BasePage basePage;

    @Test(priority = 1, description = "Verify the Content of 2.1 Transformations in the Plane concept of Geometry book.")
    public void verifyContentOfTransformationsInThePlaneConcept() {
        biologyBookPage = new BiologyBookPage(webDriver, extentTest, extentReports);
        basePage = new BasePage(webDriver, extentTest, extentReports);

        boolean result = true;
        try {
            String url = "https://flexbooks.ck12.org/cbook/ck-12-interactive-geometry-for-ccss/section/2.1/primary/lesson/transformations-in-the-plane-geo-ccss/";
            webDriver.navigate().to(url);

            Assert.assertTrue(biologyBookPage.verifyModalityPageTitle("Transformations in the Plane"), assertFailurePreText + "Presence of title on the 2.1 concepts of Geometry book.");
            reportLog("Verified Modality title: " + webDriver.getTitle() + "on the 2.1 concept of Geometry book.");

            reportLog("The Page Description is: " + biologyBookPage.pageDescription.getAttribute("content"));

            Assert.assertTrue(biologyBookPage.verifyCanonicalMetaTag(), assertFailurePreText + "Presence of canonical meta tag on the 2.1 concepts of Geometry book.");
            reportLog("Verified Canonical Tag and 1 Tag is found with URL: " + biologyBookPage.canonicalData.getAttribute("href"));

            Assert.assertTrue(biologyBookPage.verifyHTagsInBook(), assertFailurePreText + "Presence of Header tag on the 2.1 concepts of Geometry book.");
            reportLog("Presence of all Header tag on the 2.1 concept of Geometry book.");

            for (int i = 0; i <= 20; i++) {
                scrollByPixel(300);
                basePage.waitForSec(2);
            }

            Assert.assertTrue(biologyBookPage.verifyTheImagesOfBiologyBook(), assertFailurePreText + "Presence of images on the 1.4 concepts of biology book.");
            reportLog("Presence of all images on the 2.1 concept of Biology book.");

            Assert.assertTrue(biologyBookPage.verifyTheVideosOfBiologyBook(), assertFailurePreText + "Presence of videos on the 2.1 concepts of Geometry book.");
            reportLog("Presence of all the videos on the 2.1 concept of Geometry book.");

            Assert.assertTrue(biologyBookPage.verifyMathEquationRenderedCorrect(), assertFailurePreText + "Presence of Math Elements on the 2.1 concepts of Geometry book.");
            reportLog("Verified Math Element rendered correctly on the 2.1 concept of Geometry book.");

        } catch (Exception e) {
            result = handleException(e);
        }
        Assert.assertTrue(result, "Test script failed for" + currentMethodName + errorMessage);
    }

    @Test(priority = 2, description = "Verify the Content of 2.2 Translations concept of Geometry book.")
    public void verifyContentOfTranslationsConcepts() {
        boolean result = true;
        try {
            String url = "https://flexbooks.ck12.org/cbook/ck-12-interactive-geometry-for-ccss/section/2.2/primary/lesson/translations-geo-ccss/";
            webDriver.navigate().to(url);

            Assert.assertTrue(biologyBookPage.verifyModalityPageTitle("Translations"), assertFailurePreText + "Presence of title on the 2.2 concepts of Geometry book.");
            reportLog("Verified Modality title: " + webDriver.getTitle() + "on the 2.2 concept of Geometry book.");

            reportLog("The Page Description is: " + biologyBookPage.pageDescription.getAttribute("content"));

            Assert.assertTrue(biologyBookPage.verifyCanonicalMetaTag(), assertFailurePreText + "Presence of canonical meta tag on the 2.2 concepts of Geometry book.");
            reportLog("Verified Canonical Tag and 1 Tag is found with URL: " + biologyBookPage.canonicalData.getAttribute("href"));

            Assert.assertTrue(biologyBookPage.verifyHTagsInBook(), assertFailurePreText + "Presence of Header tag on the 2.2 concepts of Geometry book.");
            reportLog("Presence of all Header tag on the 2.2 concept of Geometry book.");

            for (int i = 0; i <= 20; i++) {
                scrollByPixel(300);
                basePage.waitForSec(2);
            }

            Assert.assertTrue(biologyBookPage.verifyTheImagesOfBiologyBook(), assertFailurePreText + "Presence of images on the 1.4 concepts of biology book.");
            reportLog("Presence of all images on the 2.2 concept of Biology book.");

            Assert.assertTrue(biologyBookPage.verifyTheVideosOfBiologyBook(), assertFailurePreText + "Presence of videos on the 2.2 concepts of Geometry book.");
            reportLog("Presence of all the videos on the 2.2 concept of Geometry book.");

            Assert.assertTrue(biologyBookPage.verifyMathEquationRenderedCorrect(), assertFailurePreText + "Presence of Math Elements on the 2.2 concepts of Geometry book.");
            reportLog("Verified Math Element rendered correctly on the 2.2 concept of Geometry book.");

        } catch (Exception e) {
            result = handleException(e);
        }
        Assert.assertTrue(result, "Test script failed for" + currentMethodName + errorMessage);
    }

    @Test(priority = 3, description = "Verify the Content of 2.3 Geometry Software for Translations concept of Geometry book.")
    public void verifyContentOfGeometrySoftwareForTranslationsConcept() {
        boolean result = true;
        try {
            String url = "https://flexbooks.ck12.org/cbook/ck-12-interactive-geometry-for-ccss/section/2.3/primary/lesson/geometry-software-for-translations-geo-ccss/";
            webDriver.navigate().to(url);

            Assert.assertTrue(biologyBookPage.verifyModalityPageTitle("Geometry Software for Translations"), assertFailurePreText + "Presence of title on the 2.3 concepts of Geometry book.");
            reportLog("Verified Modality title: " + webDriver.getTitle() + "on the 2.3 concept of Geometry book.");

            reportLog("The Page Description is: " + biologyBookPage.pageDescription.getAttribute("content"));

            Assert.assertTrue(biologyBookPage.verifyCanonicalMetaTag(), assertFailurePreText + "Presence of canonical meta tag on the 2.3 concepts of biology book.");
            reportLog("Verified Canonical Tag and 1 Tag is found with URL: " + biologyBookPage.canonicalData.getAttribute("href"));

            Assert.assertTrue(biologyBookPage.verifyHTagsInBook(), assertFailurePreText + "Presence of Header tag on the 2.3 concepts of Geometry book.");
            reportLog("Presence of all Header tag on the 2.3 concept of Geometry book.");

            for (int i = 0; i <= 20; i++) {
                scrollByPixel(300);
                basePage.waitForSec(2);
            }

            Assert.assertTrue(biologyBookPage.verifyTheImagesOfBiologyBook(), assertFailurePreText + "Presence of images on the 1.4 concepts of biology book.");
            reportLog("Presence of all images on the 2.3 concept of Biology book.");

            Assert.assertTrue(biologyBookPage.verifyTheVideosOfBiologyBook(), assertFailurePreText + "Presence of videos on the 2.3 concepts of Geometry book.");
            reportLog("Presence of all the videos on the 2.3 concept of Geometry book.");

            Assert.assertTrue(biologyBookPage.verifyMathEquationRenderedCorrect(), assertFailurePreText + "Presence of Math Elements on the 2.3 concepts of Geometry book.");
            reportLog("Verified Math Element rendered correctly on the 2.3 concept of Geometry book.");

        } catch (Exception e) {
            result = handleException(e);
        }
        Assert.assertTrue(result, "Test script failed for" + currentMethodName + errorMessage);
    }

    @Test(priority = 4, description = "Verify the Content of 2.4 Reflections concept of Geometry book.")
    public void verifyContentOfReflectionsConcept() {
        boolean result = true;
        try {
            String url = "https://flexbooks.ck12.org/cbook/ck-12-interactive-geometry-for-ccss/section/2.4/primary/lesson/reflections-geo-ccss/";
            webDriver.navigate().to(url);

            Assert.assertTrue(biologyBookPage.verifyModalityPageTitle("Reflections"), assertFailurePreText + "Presence of title on the 2.4 concepts of Geometry book.");
            reportLog("Verified Modality title: " + webDriver.getTitle() + "on the 2.4 concept of Geometry book.");

            reportLog("The Page Description is: " + biologyBookPage.pageDescription.getAttribute("content"));

            Assert.assertTrue(biologyBookPage.verifyCanonicalMetaTag(), assertFailurePreText + "Presence of canonical meta tag on the 2.4 concepts of Geometry book.");
            reportLog("Verified Canonical Tag and 1 Tag is found with URL: " + biologyBookPage.canonicalData.getAttribute("href"));

            Assert.assertTrue(biologyBookPage.verifyHTagsInBook(), assertFailurePreText + "Presence of Header tag on the 2.4 concepts of Geometry book.");
            reportLog("Presence of all Header tag on the 2.4 concept of Geometry book.");

            Assert.assertTrue(biologyBookPage.verifyHyperLinkTagsAndParseTheURLOfTags(), assertFailurePreText + "Presence of hyperlinked words on the 2.4 concepts of Geometry book.");
            reportLog("Presence of all the hyperlinked words terms on the 2.4 concept of Geometry book.");

            for (int i = 0; i <= 20; i++) {
                scrollByPixel(300);
                basePage.waitForSec(2);
            }

            Assert.assertTrue(biologyBookPage.verifyTheImagesOfBiologyBook(), assertFailurePreText + "Presence of images on the 1.4 concepts of biology book.");
            reportLog("Presence of all images on the 2.4 concept of Biology book.");

            Assert.assertTrue(biologyBookPage.verifyTheVideosOfBiologyBook(), assertFailurePreText + "Presence of videos on the 2.4 concepts of Geometry book.");
            reportLog("Presence of all the videos on the 2.4 concept of Geometry book.");

            Assert.assertTrue(biologyBookPage.verifyMathEquationRenderedCorrect(), assertFailurePreText + "Presence of Math Elements on the 2.4 concepts of Geometry book.");
            reportLog("Verified Math Element rendered correctly on the 2.4 concept of Geometry book.");

        } catch (Exception e) {
            result = handleException(e);
        }
        Assert.assertTrue(result, "Test script failed for" + currentMethodName + errorMessage);
    }

    @Test(priority = 5, description = "Verify the Content of 2.5 Geometry Software for Reflections concept of Geometry book.")
    public void verifyContentOfGeometrySoftwareForReflectionsConcept() {
        boolean result = true;
        try {
            String url = "https://flexbooks.ck12.org/cbook/ck-12-interactive-geometry-for-ccss/section/2.5/primary/lesson/geometry-software-for-reflections-geo-ccss/";
            webDriver.navigate().to(url);

            Assert.assertTrue(biologyBookPage.verifyModalityPageTitle("Geometry Software for Reflections"), assertFailurePreText + "Presence of title on the 2.5 concepts of Geometry book.");
            reportLog("Verified Modality title: " + webDriver.getTitle() + "on the 2.5 concept of Geometry book.");

            reportLog("The Page Description is: " + biologyBookPage.pageDescription.getAttribute("content"));

            Assert.assertTrue(biologyBookPage.verifyCanonicalMetaTag(), assertFailurePreText + "Presence of canonical meta tag on the 2.5 concepts of Geometry book.");
            reportLog("Verified Canonical Tag and 1 Tag is found with URL: " + biologyBookPage.canonicalData.getAttribute("href"));

            Assert.assertTrue(biologyBookPage.verifyHTagsInBook(), assertFailurePreText + "Presence of Header tag on the 2.5 concepts of Geometry book.");
            reportLog("Presence of all Header tag on the 2.5 concept of Geometry book.");

            for (int i = 0; i <= 20; i++) {
                scrollByPixel(300);
                basePage.waitForSec(2);
            }

            Assert.assertTrue(biologyBookPage.verifyTheImagesOfBiologyBook(), assertFailurePreText + "Presence of images on the 1.4 concepts of biology book.");
            reportLog("Presence of all images on the 2.5 concept of Biology book.");

            Assert.assertTrue(biologyBookPage.verifyTheVideosOfBiologyBook(), assertFailurePreText + "Presence of videos on the 2.5 concepts of Geometry book.");
            reportLog("Presence of all the videos on the 2.5 concept of Geometry book.");

            Assert.assertTrue(biologyBookPage.verifyMathEquationRenderedCorrect(), assertFailurePreText + "Presence of Math Elements on the 2.5 concepts of Geometry book.");
            reportLog("Verified Math Element rendered correctly on the 2.5 concept of Geometry book.");

        } catch (Exception e) {
            result = handleException(e);
        }
        Assert.assertTrue(result, "Test script failed for" + currentMethodName + errorMessage);
    }

    @Test(priority = 6, description = "Verify the Content of 2.6 Reflection Symmetry concept of Geometry book.")
    public void verifyContentOfReflectionSymmetryConcept() {
        boolean result = true;
        try {
            String url = "https://flexbooks.ck12.org/cbook/ck-12-interactive-geometry-for-ccss/section/2.6/primary/lesson/reflection-symmetry-geo-ccss/";
            webDriver.navigate().to(url);

            Assert.assertTrue(biologyBookPage.verifyModalityPageTitle("Reflection Symmetry"), assertFailurePreText + "Presence of title on the 2.6 concepts of Geometry book.");
            reportLog("Verified Modality title: " + webDriver.getTitle() + "on the 2.6 concept of Geometry book.");

            reportLog("The Page Description is: " + biologyBookPage.pageDescription.getAttribute("content"));

            Assert.assertTrue(biologyBookPage.verifyCanonicalMetaTag(), assertFailurePreText + "Presence of canonical meta tag on the 2.6 concepts of Geometry book.");
            reportLog("Verified Canonical Tag and 1 Tag is found with URL: " + biologyBookPage.canonicalData.getAttribute("href"));

            Assert.assertTrue(biologyBookPage.verifyHTagsInBook(), assertFailurePreText + "Presence of Header tag on the 2.6 concepts of Geometry book.");
            reportLog("Presence of all Header tag on the 2.6 concept of Geometry book.");

            Assert.assertTrue(biologyBookPage.verifyHyperLinkTagsAndParseTheURLOfTags(), assertFailurePreText + "Presence of hyperlinked words on the 2.6 concepts of Geometry book.");
            reportLog("Presence of all the hyperlinked words terms on the 2.6 concept of Geometry book.");

            Assert.assertTrue(biologyBookPage.verifyTheVideosOfBiologyBook(), assertFailurePreText + "Presence of videos on the 2.6 concepts of Geometry book.");
            reportLog("Presence of all the videos on the 2.6 concept of Geometry book.");

            Assert.assertTrue(biologyBookPage.verifyMathEquationRenderedCorrect(), assertFailurePreText + "Presence of Math Elements on the 2.6 concepts of Geometry book.");
            reportLog("Verified Math Element rendered correctly on the 2.6 concept of Geometry book.");

        } catch (Exception e) {
            result = handleException(e);
        }
        Assert.assertTrue(result, "Test script failed for" + currentMethodName + errorMessage);
    }

    @Test(priority = 7, description = "Verify the Content of 2.7 Rotations concept of Geometry book.")
    public void verifyContentOfRotationsConcept() {
        boolean result = true;
        try {
            String url = "https://flexbooks.ck12.org/cbook/ck-12-interactive-geometry-for-ccss/section/2.7/primary/lesson/rotations-geo-ccss/";
            webDriver.navigate().to(url);

            Assert.assertTrue(biologyBookPage.verifyModalityPageTitle("Rotations"), assertFailurePreText + "Presence of title on the 2.7 concepts of Geometry book.");
            reportLog("Verified Modality title: " + webDriver.getTitle() + "on the 2.7 concept of Geometry book.");

            reportLog("The Page Description is: " + biologyBookPage.pageDescription.getAttribute("content"));

            Assert.assertTrue(biologyBookPage.verifyCanonicalMetaTag(), assertFailurePreText + "Presence of canonical meta tag on the 2.7 concepts of Geometry book.");
            reportLog("Verified Canonical Tag and 1 Tag is found with URL: " + biologyBookPage.canonicalData.getAttribute("href"));

            Assert.assertTrue(biologyBookPage.verifyHTagsInBook(), assertFailurePreText + "Presence of Header tag on the 2.7 concepts of Geometry book.");
            reportLog("Presence of all Header tag on the 2.7 concept of Geometry book.");

            for (int i = 0; i <= 20; i++) {
                scrollByPixel(300);
                basePage.waitForSec(2);
            }

            Assert.assertTrue(biologyBookPage.verifyTheImagesOfBiologyBook(), assertFailurePreText + "Presence of images on the 1.4 concepts of biology book.");
            reportLog("Presence of all images on the 2.7 concept of Biology book.");

            Assert.assertTrue(biologyBookPage.verifyTheVideosOfBiologyBook(), assertFailurePreText + "Presence of videos on the 2.7 concepts of Geometry book.");
            reportLog("Presence of all the videos on the 2.7 concept of Geometry book.");

            Assert.assertTrue(biologyBookPage.verifyMathEquationRenderedCorrect(), assertFailurePreText + "Presence of Math Elements on the 2.7 concepts of Geometry book.");
            reportLog("Verified Math Element rendered correctly on the 2.7 concept of Geometry book.");

        } catch (Exception e) {
            result = handleException(e);
        }
        Assert.assertTrue(result, "Test script failed for" + currentMethodName + errorMessage);
    }

    @Test(priority = 8, description = "Verify the Content of 2.8 Geometry Software for Rotations concept of Geometry book.")
    public void verifyContentOfGeometrySoftwareForRotationsConcept() {
        boolean result = true;
        try {
            String url = "https://flexbooks.ck12.org/cbook/ck-12-interactive-geometry-for-ccss/section/2.8/primary/lesson/geometry-software-for-rotations-geo-ccss/";
            webDriver.navigate().to(url);

            Assert.assertTrue(biologyBookPage.verifyModalityPageTitle("Geometry Software for Rotations"), assertFailurePreText + "Presence of title on the 2.8 concepts of Geometry book.");
            reportLog("Verified Modality title: " + webDriver.getTitle() + "on the 2.8 concept of Geometry book.");

            reportLog("The Page Description is: " + biologyBookPage.pageDescription.getAttribute("content"));

            Assert.assertTrue(biologyBookPage.verifyCanonicalMetaTag(), assertFailurePreText + "Presence of canonical meta tag on the 2.8 concepts of Geometry book.");
            reportLog("Verified Canonical Tag and 1 Tag is found with URL: " + biologyBookPage.canonicalData.getAttribute("href"));

            Assert.assertTrue(biologyBookPage.verifyHTagsInBook(), assertFailurePreText + "Presence of Header tag on the 2.8 concepts of Geometry book.");
            reportLog("Presence of all Header tag on the 2.8 concept of Geometry book.");

            for (int i = 0; i <= 20; i++) {
                scrollByPixel(300);
                basePage.waitForSec(2);
            }

            Assert.assertTrue(biologyBookPage.verifyTheImagesOfBiologyBook(), assertFailurePreText + "Presence of images on the 1.4 concepts of biology book.");
            reportLog("Presence of all images on the 2.8 concept of Biology book.");

            Assert.assertTrue(biologyBookPage.verifyTheVideosOfBiologyBook(), assertFailurePreText + "Presence of videos on the 2.8 concepts of Geometry book.");
            reportLog("Presence of all the videos on the 2.8 concept of Geometry book.");

            Assert.assertTrue(biologyBookPage.verifyMathEquationRenderedCorrect(), assertFailurePreText + "Presence of Math Elements on the 2.8 concepts of Geometry book.");
            reportLog("Verified Math Element rendered correctly on the 2.8 concept of Geometry book.");

        } catch (Exception e) {
            result = handleException(e);
        }
        Assert.assertTrue(result, "Test script failed for" + currentMethodName + errorMessage);
    }

    @Test(priority = 9, description = "Verify the Content of 2.9 Rotation Symmetry concept of Geometry book.")
    public void verifyContentOfRotationSymmetryConcept() {
        boolean result = true;
        try {
            String url = "https://flexbooks.ck12.org/cbook/ck-12-interactive-geometry-for-ccss/section/2.9/primary/lesson/rotation-symmetry-geo-ccss/";
            webDriver.navigate().to(url);

            Assert.assertTrue(biologyBookPage.verifyModalityPageTitle("Rotation Symmetry"), assertFailurePreText + "Presence of title on the 2.9 concepts of Geometry book.");
            reportLog("Verified Modality title: " + webDriver.getTitle() + "on the 2.9 concept of Geometry book.");

            reportLog("The Page Description is: " + biologyBookPage.pageDescription.getAttribute("content"));

            Assert.assertTrue(biologyBookPage.verifyCanonicalMetaTag(), assertFailurePreText + "Presence of canonical meta tag on the 2.9 concepts of Geometry book.");
            reportLog("Verified Canonical Tag and 1 Tag is found with URL: " + biologyBookPage.canonicalData.getAttribute("href"));

            Assert.assertTrue(biologyBookPage.verifyHTagsInBook(), assertFailurePreText + "Presence of Header tag on the 2.9 concepts of Geometry book.");
            reportLog("Presence of all Header tag on the 2.9 concept of Geometry book.");

            Assert.assertTrue(biologyBookPage.verifyHyperLinkTagsAndParseTheURLOfTags(), assertFailurePreText + "Presence of hyperlinked words on the 2.9 concepts of Geometry book.");
            reportLog("Presence of all the hyperlinked words terms on the 2.9 concept of Geometry book.");

            for (int i = 0; i <= 20; i++) {
                scrollByPixel(300);
                basePage.waitForSec(2);
            }

            Assert.assertTrue(biologyBookPage.verifyTheImagesOfBiologyBook(), assertFailurePreText + "Presence of images on the 1.4 concepts of biology book.");
            reportLog("Presence of all images on the 2.9 concept of Biology book.");

            Assert.assertTrue(biologyBookPage.verifyTheVideosOfBiologyBook(), assertFailurePreText + "Presence of videos on the 2.9 concepts of Geometry book.");
            reportLog("Presence of all the videos on the 2.9 concept of Geometry book.");

            Assert.assertTrue(biologyBookPage.verifyMathEquationRenderedCorrect(), assertFailurePreText + "Presence of Math Elements on the 2.9 concepts of Geometry book.");
            reportLog("Verified Math Element rendered correctly on the 2.9 concept of Geometry book.");

        } catch (Exception e) {
            result = handleException(e);
        }
        Assert.assertTrue(result, "Test script failed for" + currentMethodName + errorMessage);
    }

    @Test(priority = 10, description = "Verify the Content of 2.10 Composite Transformations concept of Geometry book.")
    public void verifyContentOfCompositeTransformationsConcept() {
        boolean result = true;
        try {
            String url = "https://flexbooks.ck12.org/cbook/ck-12-interactive-geometry-for-ccss/section/2.10/primary/lesson/composite-transformations-geo-ccss/";
            webDriver.navigate().to(url);

            Assert.assertTrue(biologyBookPage.verifyModalityPageTitle("Composite Transformations"), assertFailurePreText + "Presence of title on the 2.10 concepts of Geometry book.");
            reportLog("Verified Modality title: " + webDriver.getTitle() + "on the 2.10 concept of Geometry book.");

            reportLog("The Page Description is: " + biologyBookPage.pageDescription.getAttribute("content"));

            Assert.assertTrue(biologyBookPage.verifyCanonicalMetaTag(), assertFailurePreText + "Presence of canonical meta tag on the 2.10 concepts of Geometry book.");
            reportLog("Verified Canonical Tag and 1 Tag is found with URL: " + biologyBookPage.canonicalData.getAttribute("href"));

            Assert.assertTrue(biologyBookPage.verifyHTagsInBook(), assertFailurePreText + "Presence of Header tag on the 2.10 concepts of Geometry book.");
            reportLog("Presence of all Header tag on the 2.10 concept of Geometry book.");

            for (int i = 0; i <= 20; i++) {
                scrollByPixel(300);
                basePage.waitForSec(2);
            }

            Assert.assertTrue(biologyBookPage.verifyTheImagesOfBiologyBook(), assertFailurePreText + "Presence of images on the 1.4 concepts of biology book.");
            reportLog("Presence of all images on the 2.10 concept of Biology book.");

            Assert.assertTrue(biologyBookPage.verifyTheVideosOfBiologyBook(), assertFailurePreText + "Presence of videos on the 2.10 concepts of Geometry book.");
            reportLog("Presence of all the videos on the 2.10 concept of Geometry book.");

            Assert.assertTrue(biologyBookPage.verifyMathEquationRenderedCorrect(), assertFailurePreText + "Presence of Math Elements on the 2.10 concepts of Geometry book.");
            reportLog("Verified Math Element rendered correctly on the 2.10 concept of Geometry book.");

        } catch (Exception e) {
            result = handleException(e);
        }
        Assert.assertTrue(result, "Test script failed for" + currentMethodName + errorMessage);
    }
}

