package testscripts.regression.interactives;

import org.testng.Assert;
import org.testng.annotations.Test;
import testscripts.BaseTestScript;
import uipages.BasePage;
import uipages.interactives.BiologyBookPage;

public class GeometryUnitElevenNoInteractiveTest extends BaseTestScript {

    private BiologyBookPage biologyBookPage;
    private BasePage basePage;

    @Test(priority = 1, description = "Verify the Content of 11.1 Descriptions of Events concept of Geometry book.")
    public void verifyContentOfDescriptionsOfEventsConcept() {
        biologyBookPage = new BiologyBookPage(webDriver, extentTest, extentReports);
        basePage = new BasePage(webDriver, extentTest, extentReports);

        boolean result = true;
        try {
            String url = "https://flexbooks.ck12.org/cbook/ck-12-interactive-geometry-for-ccss/section/11.1/primary/lesson/descriptions-of-events-geo-ccss/";
            webDriver.navigate().to(url);

            Assert.assertTrue(biologyBookPage.verifyModalityPageTitle("Descriptions of Events"), assertFailurePreText + "Presence of title on the 11.1 concepts of Geometry book.");
            reportLog("Verified Modality title: " + webDriver.getTitle() + "on the 11.1 concept of Geometry book.");

            reportLog("The Page Description is: " + biologyBookPage.pageDescription.getAttribute("content"));

            Assert.assertTrue(biologyBookPage.verifyCanonicalMetaTag(), assertFailurePreText + "Presence of canonical meta tag on the 11.1 concepts of Geometry book.");
            reportLog("Verified Canonical Tag and 1 Tag is found with URL: " + biologyBookPage.canonicalData.getAttribute("href"));

            Assert.assertTrue(biologyBookPage.verifyHTagsInBook(), assertFailurePreText + "Presence of Header tag on the 11.1 concepts of Geometry book.");
            reportLog("Presence of all Header tag on the 11.1 concept of Geometry book.");

            for (int i = 0; i <= 20; i++) {
                scrollByPixel(300);
                basePage.waitForSec(2);
            }

            Assert.assertTrue(biologyBookPage.verifyTheImagesOfBiologyBook(), assertFailurePreText + "Presence of images on the 11.1 concepts of Geometry book.");
            reportLog("Presence of all images on the 11.1 concept of Geometry book.");

            Assert.assertTrue(biologyBookPage.verifyTheVideosOfBiologyBook(), assertFailurePreText + "Presence of videos on the 11.1 concepts of Geometry book.");
            reportLog("Presence of all the videos on the 11.1 concept of Geometry book.");

            Assert.assertTrue(biologyBookPage.verifyMathEquationRenderedCorrect(), assertFailurePreText + "Presence of Math Elements on the 11.1 concepts of Geometry book.");
            reportLog("Verified Math Element rendered correctly on the 11.1 concept of Geometry book.");

        } catch (Exception e) {
            result = handleException(e);
        }
        Assert.assertTrue(result, "Test script failed for" + currentMethodName + errorMessage);
    }

    @Test(priority = 2, description = "Verify the Content of 11.2 Independent Events concept of Geometry book.")
    public void verifyContentOfIndependentEventsConcepts() {
        boolean result = true;
        try {
            String url = "https://flexbooks.ck12.org/cbook/ck-12-interactive-geometry-for-ccss/section/11.2/primary/lesson/independent-events-geo-ccss/";
            webDriver.navigate().to(url);

            Assert.assertTrue(biologyBookPage.verifyModalityPageTitle("Independent Events"), assertFailurePreText + "Presence of title on the 11.2 concepts of Geometry book.");
            reportLog("Verified Modality title: " + webDriver.getTitle() + "on the 11.2 concept of Geometry book.");

            reportLog("The Page Description is: " + biologyBookPage.pageDescription.getAttribute("content"));

            Assert.assertTrue(biologyBookPage.verifyCanonicalMetaTag(), assertFailurePreText + "Presence of canonical meta tag on the 11.2 concepts of Geometry book.");
            reportLog("Verified Canonical Tag and 1 Tag is found with URL: " + biologyBookPage.canonicalData.getAttribute("href"));

            Assert.assertTrue(biologyBookPage.verifyHTagsInBook(), assertFailurePreText + "Presence of Header tag on the 11.2 concepts of Geometry book.");
            reportLog("Presence of all Header tag on the 11.2 concept of Geometry book.");

            Assert.assertTrue(biologyBookPage.verifyHyperLinkTagsAndParseTheURLOfTags(), assertFailurePreText + "Presence of hyperlinked words on the 11.2 concepts of Geometry book.");
            reportLog("Presence of all the hyperlinked words terms on the 11.2 concept of Geometry book.");

            for (int i = 0; i <= 20; i++) {
                scrollByPixel(300);
                basePage.waitForSec(2);
            }

            Assert.assertTrue(biologyBookPage.verifyTheImagesOfBiologyBook(), assertFailurePreText + "Presence of images on the 11.2 concepts of Geometry book.");
            reportLog("Presence of all images on the 11.2 concept of Geometry book.");

            Assert.assertTrue(biologyBookPage.verifyTheVideosOfBiologyBook(), assertFailurePreText + "Presence of videos on the 11.2 concepts of Geometry book.");
            reportLog("Presence of all the videos on the 11.2 concept of Geometry book.");

            Assert.assertTrue(biologyBookPage.verifyMathEquationRenderedCorrect(), assertFailurePreText + "Presence of Math Elements on the 11.2 concepts of Geometry book.");
            reportLog("Verified Math Element rendered correctly on the 11.2 concept of Geometry book.");

        } catch (Exception e) {
            result = handleException(e);
        }
        Assert.assertTrue(result, "Test script failed for" + currentMethodName + errorMessage);
    }

    @Test(priority = 3, description = "Verify the Content of 11.3 Conditional Probability concept of Geometry book.")
    public void verifyContentOfConditionalProbabilityConcept() {
        boolean result = true;
        try {
            String url = "https://flexbooks.ck12.org/cbook/ck-12-interactive-geometry-for-ccss/section/11.3/primary/lesson/conditional-probability-geo-ccss/";
            webDriver.navigate().to(url);

            Assert.assertTrue(biologyBookPage.verifyModalityPageTitle("Conditional Probability"), assertFailurePreText + "Presence of title on the 11.3 concepts of Geometry book.");
            reportLog("Verified Modality title: " + webDriver.getTitle() + "on the 11.3 concept of Geometry book.");

            reportLog("The Page Description is: " + biologyBookPage.pageDescription.getAttribute("content"));

            Assert.assertTrue(biologyBookPage.verifyCanonicalMetaTag(), assertFailurePreText + "Presence of canonical meta tag on the 11.3 concepts of biology book.");
            reportLog("Verified Canonical Tag and 1 Tag is found with URL: " + biologyBookPage.canonicalData.getAttribute("href"));

            Assert.assertTrue(biologyBookPage.verifyHTagsInBook(), assertFailurePreText + "Presence of Header tag on the 11.3 concepts of Geometry book.");
            reportLog("Presence of all Header tag on the 11.3 concept of Geometry book.");

            Assert.assertTrue(biologyBookPage.verifyHyperLinkTagsAndParseTheURLOfTags(), assertFailurePreText + "Presence of hyperlinked words on the 11.3 concepts of Geometry book.");
            reportLog("Presence of all the hyperlinked words terms on the 10.3 concept of Geometry book.");

            for (int i = 0; i <= 20; i++) {
                scrollByPixel(300);
                basePage.waitForSec(2);
            }

            Assert.assertTrue(biologyBookPage.verifyTheImagesOfBiologyBook(), assertFailurePreText + "Presence of images on the 11.3 concepts of Geometry book.");
            reportLog("Presence of all images on the 11.3 concept of Geometry book.");

            Assert.assertTrue(biologyBookPage.verifyTheVideosOfBiologyBook(), assertFailurePreText + "Presence of videos on the 11.3 concepts of Geometry book.");
            reportLog("Presence of all the videos on the 11.3 concept of Geometry book.");

            Assert.assertTrue(biologyBookPage.verifyMathEquationRenderedCorrect(), assertFailurePreText + "Presence of Math Elements on the 11.3 concepts of Geometry book.");
            reportLog("Verified Math Element rendered correctly on the 11.3 concept of Geometry book.");

        } catch (Exception e) {
            result = handleException(e);
        }
        Assert.assertTrue(result, "Test script failed for" + currentMethodName + errorMessage);
    }

    @Test(priority = 4, description = "Verify the Content of 11.4 Two-Way Frequency Tables concept of Geometry book.")
    public void verifyContentOfTwoWayFrequencyTablesConcept() {
        boolean result = true;
        try {
            String url = "https://flexbooks.ck12.org/cbook/ck-12-interactive-geometry-for-ccss/section/11.4/primary/lesson/two-way-frequency-tables-geo-ccss/";
            webDriver.navigate().to(url);

            Assert.assertTrue(biologyBookPage.verifyModalityPageTitle("Two-Way Frequency Tables"), assertFailurePreText + "Presence of title on the 11.4 concepts of Geometry book.");
            reportLog("Verified Modality title: " + webDriver.getTitle() + "on the 11.4 concept of Geometry book.");

            reportLog("The Page Description is: " + biologyBookPage.pageDescription.getAttribute("content"));

            Assert.assertTrue(biologyBookPage.verifyCanonicalMetaTag(), assertFailurePreText + "Presence of canonical meta tag on the 11.4 concepts of Geometry book.");
            reportLog("Verified Canonical Tag and 1 Tag is found with URL: " + biologyBookPage.canonicalData.getAttribute("href"));

            Assert.assertTrue(biologyBookPage.verifyHTagsInBook(), assertFailurePreText + "Presence of Header tag on the 11.4 concepts of Geometry book.");
            reportLog("Presence of all Header tag on the 11.4 concept of Geometry book.");

            Assert.assertTrue(biologyBookPage.verifyHyperLinkTagsAndParseTheURLOfTags(), assertFailurePreText + "Presence of hyperlinked words on the 11.4 concepts of Geometry book.");
            reportLog("Presence of all the hyperlinked words terms on the 11.4 concept of Geometry book.");

            for (int i = 0; i <= 20; i++) {
                scrollByPixel(300);
                basePage.waitForSec(2);
            }

            Assert.assertTrue(biologyBookPage.verifyTheImagesOfBiologyBook(), assertFailurePreText + "Presence of images on the 11.4 concepts of Geometry book.");
            reportLog("Presence of all images on the 11.4 concept of Geometry book.");

            Assert.assertTrue(biologyBookPage.verifyTheVideosOfBiologyBook(), assertFailurePreText + "Presence of videos on the 11.4 concepts of Geometry book.");
            reportLog("Presence of all the videos on the 11.4 concept of Geometry book.");

            Assert.assertTrue(biologyBookPage.verifyMathEquationRenderedCorrect(), assertFailurePreText + "Presence of Math Elements on the 11.4 concepts of Geometry book.");
            reportLog("Verified Math Element rendered correctly on the 11.4 concept of Geometry book.");

        } catch (Exception e) {
            result = handleException(e);
        }
        Assert.assertTrue(result, "Test script failed for" + currentMethodName + errorMessage);
    }

    @Test(priority = 5, description = "Verify the Content of 11.5 Everyday Examples of Independence and Probability concept of Geometry book.")
    public void verifyContentOfEverydayExamplesOfIndependenceAndProbabilityConcept() {
        boolean result = true;
        try {
            String url = "https://flexbooks.ck12.org/cbook/ck-12-interactive-geometry-for-ccss/section/11.5/primary/lesson/everyday-examples-of-independence-and-probability-geo-ccss/";
            webDriver.navigate().to(url);

            Assert.assertTrue(biologyBookPage.verifyModalityPageTitle("Everyday Examples of Independence and Probability"), assertFailurePreText + "Presence of title on the 11.5 concepts of Geometry book.");
            reportLog("Verified Modality title: " + webDriver.getTitle() + "on the 11.5 concept of Geometry book.");

            reportLog("The Page Description is: " + biologyBookPage.pageDescription.getAttribute("content"));

            Assert.assertTrue(biologyBookPage.verifyCanonicalMetaTag(), assertFailurePreText + "Presence of canonical meta tag on the 11.5 concepts of Geometry book.");
            reportLog("Verified Canonical Tag and 1 Tag is found with URL: " + biologyBookPage.canonicalData.getAttribute("href"));

            Assert.assertTrue(biologyBookPage.verifyHTagsInBook(), assertFailurePreText + "Presence of Header tag on the 11.5 concepts of Geometry book.");
            reportLog("Presence of all Header tag on the 11.5 concept of Geometry book.");

            Assert.assertTrue(biologyBookPage.verifyHyperLinkTagsAndParseTheURLOfTags(), assertFailurePreText + "Presence of hyperlinked words on the 11.6 concepts of Geometry book.");
            reportLog("Presence of all the hyperlinked words terms on the 11.5 concept of Geometry book.");

            for (int i = 0; i <= 20; i++) {
                scrollByPixel(300);
                basePage.waitForSec(2);
            }

            Assert.assertTrue(biologyBookPage.verifyTheImagesOfBiologyBook(), assertFailurePreText + "Presence of images on the 11.5 concepts of Geometry book.");
            reportLog("Presence of all images on the 11.5 concept of Biology book.");

            Assert.assertTrue(biologyBookPage.verifyTheVideosOfBiologyBook(), assertFailurePreText + "Presence of videos on the 11.5 concepts of Geometry book.");
            reportLog("Presence of all the videos on the 11.5 concept of Geometry book.");

            Assert.assertTrue(biologyBookPage.verifyMathEquationRenderedCorrect(), assertFailurePreText + "Presence of Math Elements on the 11.5 concepts of Geometry book.");
            reportLog("Verified Math Element rendered correctly on the 11.5 concept of Geometry book.");

        } catch (Exception e) {
            result = handleException(e);
        }
        Assert.assertTrue(result, "Test script failed for" + currentMethodName + errorMessage);
    }

    @Test(priority = 6, description = "Verify the Content of 11.6 Probability of Unions concept of Geometry book.")
    public void verifyContentOfProbabilityOfUnionsConcept() {
        boolean result = true;
        try {
            String url = "https://flexbooks.ck12.org/cbook/ck-12-interactive-geometry-for-ccss/section/11.6/primary/lesson/probability-of-unions-geo-ccss/";
            webDriver.navigate().to(url);

            Assert.assertTrue(biologyBookPage.verifyModalityPageTitle("Probability of Unions"), assertFailurePreText + "Presence of title on the 11.6 concepts of Geometry book.");
            reportLog("Verified Modality title: " + webDriver.getTitle() + "on the 11.6 concept of Geometry book.");

            reportLog("The Page Description is: " + biologyBookPage.pageDescription.getAttribute("content"));

            Assert.assertTrue(biologyBookPage.verifyCanonicalMetaTag(), assertFailurePreText + "Presence of canonical meta tag on the 11.6 concepts of Geometry book.");
            reportLog("Verified Canonical Tag and 1 Tag is found with URL: " + biologyBookPage.canonicalData.getAttribute("href"));

            Assert.assertTrue(biologyBookPage.verifyHTagsInBook(), assertFailurePreText + "Presence of Header tag on the 11.6 concepts of Geometry book.");
            reportLog("Presence of all Header tag on the 11.6 concept of Geometry book.");

            for (int i = 0; i <= 20; i++) {
                scrollByPixel(300);
                basePage.waitForSec(2);
            }

            Assert.assertTrue(biologyBookPage.verifyTheImagesOfBiologyBook(), assertFailurePreText + "Presence of images on the 11.6 concepts of Geometry book.");
            reportLog("Presence of all images on the 11.6 concept of Geometry book.");

            Assert.assertTrue(biologyBookPage.verifyTheVideosOfBiologyBook(), assertFailurePreText + "Presence of videos on the 11.6 concepts of Geometry book.");
            reportLog("Presence of all the videos on the 11.6 concept of Geometry book.");

            Assert.assertTrue(biologyBookPage.verifyMathEquationRenderedCorrect(), assertFailurePreText + "Presence of Math Elements on the 11.6 concepts of Geometry book.");
            reportLog("Verified Math Element rendered correctly on the 11.6 concept of Geometry book.");

        } catch (Exception e) {
            result = handleException(e);
        }
        Assert.assertTrue(result, "Test script failed for" + currentMethodName + errorMessage);
    }

    @Test(priority = 7, description = "Verify the Content of 11.7 Probability of Intersections concept of Geometry book.")
    public void verifyContentOfProbabilityOfIntersectionsConcept() {
        boolean result = true;
        try {
            String url = "https://flexbooks.ck12.org/cbook/ck-12-interactive-geometry-for-ccss/section/11.7/primary/lesson/probability-of-intersections-geo-ccss/";
            webDriver.navigate().to(url);

            Assert.assertTrue(biologyBookPage.verifyModalityPageTitle("Probability of Intersections"), assertFailurePreText + "Presence of title on the 11.7 concepts of Geometry book.");
            reportLog("Verified Modality title: " + webDriver.getTitle() + "on the 11.7 concept of Geometry book.");

            reportLog("The Page Description is: " + biologyBookPage.pageDescription.getAttribute("content"));

            Assert.assertTrue(biologyBookPage.verifyCanonicalMetaTag(), assertFailurePreText + "Presence of canonical meta tag on the 11.7 concepts of Geometry book.");
            reportLog("Verified Canonical Tag and 1 Tag is found with URL: " + biologyBookPage.canonicalData.getAttribute("href"));

            Assert.assertTrue(biologyBookPage.verifyHTagsInBook(), assertFailurePreText + "Presence of Header tag on the 11.7 concepts of Geometry book.");
            reportLog("Presence of all Header tag on the 11.7 concept of Geometry book.");

            Assert.assertTrue(biologyBookPage.verifyHyperLinkTagsAndParseTheURLOfTags(), assertFailurePreText + "Presence of hyperlinked words on the 11.7 concepts of Geometry book.");
            reportLog("Presence of all the hyperlinked words terms on the 11.7 concept of Geometry book.");

            for (int i = 0; i <= 20; i++) {
                scrollByPixel(300);
                basePage.waitForSec(2);
            }

            Assert.assertTrue(biologyBookPage.verifyTheImagesOfBiologyBook(), assertFailurePreText + "Presence of images on the 11.7 concepts of Geometry book.");
            reportLog("Presence of all images on the 11.7 concept of Geometry book.");

            Assert.assertTrue(biologyBookPage.verifyTheVideosOfBiologyBook(), assertFailurePreText + "Presence of videos on the 11.7 concepts of Geometry book.");
            reportLog("Presence of all the videos on the 11.7 concept of Geometry book.");

            Assert.assertTrue(biologyBookPage.verifyMathEquationRenderedCorrect(), assertFailurePreText + "Presence of Math Elements on the 11.7 concepts of Geometry book.");
            reportLog("Verified Math Element rendered correctly on the 11.7 concept of Geometry book.");

        } catch (Exception e) {
            result = handleException(e);
        }
        Assert.assertTrue(result, "Test script failed for" + currentMethodName + errorMessage);
    }

    @Test(priority = 8, description = "Verify the Content of 11.8 Permutations and Combinations concept of Geometry book.")
    public void verifyContentOfPermutationsAndCombinationsConcept() {
        boolean result = true;
        try {
            String url = "https://flexbooks.ck12.org/cbook/ck-12-interactive-geometry-for-ccss/section/11.8/primary/lesson/permutations-and-combinations-geo-ccss/";
            webDriver.navigate().to(url);

            Assert.assertTrue(biologyBookPage.verifyModalityPageTitle("Permutations and Combinations"), assertFailurePreText + "Presence of title on the 11.8 concepts of Geometry book.");
            reportLog("Verified Modality title: " + webDriver.getTitle() + "on the 11.8 concept of Geometry book.");

            reportLog("The Page Description is: " + biologyBookPage.pageDescription.getAttribute("content"));

            Assert.assertTrue(biologyBookPage.verifyCanonicalMetaTag(), assertFailurePreText + "Presence of canonical meta tag on the 11.8 concepts of Geometry book.");
            reportLog("Verified Canonical Tag and 1 Tag is found with URL: " + biologyBookPage.canonicalData.getAttribute("href"));

            Assert.assertTrue(biologyBookPage.verifyHTagsInBook(), assertFailurePreText + "Presence of Header tag on the 11.8 concepts of Geometry book.");
            reportLog("Presence of all Header tag on the 11.8 concept of Geometry book.");

            Assert.assertTrue(biologyBookPage.verifyHyperLinkTagsAndParseTheURLOfTags(), assertFailurePreText + "Presence of hyperlinked words on the 11.8 concepts of Geometry book.");
            reportLog("Presence of all the hyperlinked words terms on the 10.6 concept of Geometry book.");

            for (int i = 0; i <= 20; i++) {
                scrollByPixel(300);
                basePage.waitForSec(2);
            }

            Assert.assertTrue(biologyBookPage.verifyTheImagesOfBiologyBook(), assertFailurePreText + "Presence of images on the 1.4 concepts of Geometry book.");
            reportLog("Presence of all images on the 11.8 concept of Geometry book.");

            Assert.assertTrue(biologyBookPage.verifyTheVideosOfBiologyBook(), assertFailurePreText + "Presence of videos on the 11.8 concepts of Geometry book.");
            reportLog("Presence of all the videos on the 11.8 concept of Geometry book.");

            Assert.assertTrue(biologyBookPage.verifyMathEquationRenderedCorrect(), assertFailurePreText + "Presence of Math Elements on the 11.8 concepts of Geometry book.");
            reportLog("Verified Math Element rendered correctly on the 11.8 concept of Geometry book.");

        } catch (Exception e) {
            result = handleException(e);
        }
        Assert.assertTrue(result, "Test script failed for" + currentMethodName + errorMessage);
    }

    @Test(priority = 9, description = "Verify the Content of 11.9 Probability to Analyze Fairness and Decisions concept of Geometry book.")
    public void verifyContentOfProbabilityToAnalyzeFairnessAndDecisionsConcept() {
        boolean result = true;
        try {
            String url = "https://flexbooks.ck12.org/cbook/ck-12-interactive-geometry-for-ccss/section/11.9/primary/lesson/probability-to-analyze-fairness-and-decisions-geo-ccss/";
            webDriver.navigate().to(url);

            Assert.assertTrue(biologyBookPage.verifyModalityPageTitle("Probability to Analyze Fairness and Decisions"), assertFailurePreText + "Presence of title on the 11.9 concepts of Geometry book.");
            reportLog("Verified Modality title: " + webDriver.getTitle() + "on the 11.9 concept of Geometry book.");

            reportLog("The Page Description is: " + biologyBookPage.pageDescription.getAttribute("content"));

            Assert.assertTrue(biologyBookPage.verifyCanonicalMetaTag(), assertFailurePreText + "Presence of canonical meta tag on the 11.9 concepts of Geometry book.");
            reportLog("Verified Canonical Tag and 1 Tag is found with URL: " + biologyBookPage.canonicalData.getAttribute("href"));

            Assert.assertTrue(biologyBookPage.verifyHTagsInBook(), assertFailurePreText + "Presence of Header tag on the 11.9 concepts of Geometry book.");
            reportLog("Presence of all Header tag on the 11.9 concept of Geometry book.");

            Assert.assertTrue(biologyBookPage.verifyHyperLinkTagsAndParseTheURLOfTags(), assertFailurePreText + "Presence of hyperlinked words on the 11.9 concepts of Geometry book.");
            reportLog("Presence of all the hyperlinked words terms on the 11.9 concept of Geometry book.");

            for (int i = 0; i <= 20; i++) {
                scrollByPixel(300);
                basePage.waitForSec(2);
            }

            Assert.assertTrue(biologyBookPage.verifyTheImagesOfBiologyBook(), assertFailurePreText + "Presence of images on the 11.9 concepts of Geometry book.");
            reportLog("Presence of all images on the 11.9 concept of Geometry book.");

            Assert.assertTrue(biologyBookPage.verifyTheVideosOfBiologyBook(), assertFailurePreText + "Presence of videos on the 11.9 concepts of Geometry book.");
            reportLog("Presence of all the videos on the 11.9 concept of Geometry book.");

            Assert.assertTrue(biologyBookPage.verifyMathEquationRenderedCorrect(), assertFailurePreText + "Presence of Math Elements on the 11.9 concepts of Geometry book.");
            reportLog("Verified Math Element rendered correctly on the 11.9 concept of Geometry book.");

        } catch (Exception e) {
            result = handleException(e);
        }
        Assert.assertTrue(result, "Test script failed for" + currentMethodName + errorMessage);
    }
}