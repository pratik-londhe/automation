package testscripts.regression.interactives;

import org.testng.Assert;
import org.testng.annotations.Test;
import testscripts.BaseTestScript;
import uipages.BasePage;
import uipages.flexbook2feature.LoginPage;
import uipages.flexbook2feature.TeacherDashboardPage;
import uipages.interactives.BiologyBookPage;

public class BiologyUnitOneNoInteractivesTest extends BaseTestScript {

    private BiologyBookPage biologyBookPage;
    private BasePage basePage;

    @Test(priority = 1, dataProvider = "CK12DataProvider", description = "Verify the Content of 1.1 Scientific Method concept of Biology book.")
    public void verifyContentOfScientificMethodConcept(String email, String password, String conceptScientificMethod) {
        boolean result = true;
        try {
            LoginPage loginPage = new LoginPage(webDriver, extentTest, extentReports);
            biologyBookPage = new BiologyBookPage(webDriver, extentTest, extentReports);
            basePage = new BasePage(webDriver, extentTest, extentReports);

            loginPage.teacherLogin(email, password);

            Assert.assertTrue(new TeacherDashboardPage(webDriver, extentTest, extentReports).verifyTeacherProfileOnGamma(), assertFailurePreText + "Presence of Teacher account icon On Gamma");
            reportLog("Presence of Teacher account icon On Gamma");

            webDriver.navigate().to(conceptScientificMethod);

            biologyBookPage.dismissInsightPopup();

            Assert.assertTrue(biologyBookPage.verifyModalityPageTitle("Scientific Method"), assertFailurePreText + "Presence of title on the 1.1 concepts of biology book.");
            reportLog("Verified Modality title: " + webDriver.getTitle() + "on the 1.1 concept of Biology book.");

            reportLog("The Page Description is: " + biologyBookPage.pageDescription.getAttribute("content"));

            Assert.assertTrue(biologyBookPage.verifyCanonicalMetaTag(), assertFailurePreText + "Presence of canonical meta tag on the 1.1 concepts of biology book.");
            reportLog("Verified Canonical Tag and 1 Tag is found with URL: " + biologyBookPage.canonicalData.getAttribute("href"));

            Assert.assertTrue(biologyBookPage.verifyHyperLinkTagsAndParseTheURLOfTags(), assertFailurePreText + "Presence of hyperlinked words on the 1.1 concepts of biology book.");
            reportLog("Presence of all the hyperlinked words terms on the 1.1 concept of Biology book.");

            Assert.assertTrue(biologyBookPage.verifyTheVocabularyTermsOfBiologyBook(), assertFailurePreText + "Presence of vocabulary terms on the 1.1 concepts of biology book.");
            reportLog("Presence of all the vocabulary terms on the 1.1 concept of Biology book.");

            Assert.assertTrue(biologyBookPage.verifyHTagsInBook(), assertFailurePreText + "Presence of Header tag on the 1.1 concepts of biology book.");
            reportLog("Presence of all Header tag on the 1.1 concept of Biology book.");

            Assert.assertTrue(biologyBookPage.verifyDidYouKnowSection(), assertFailurePreText + "Presence of Did you know section on the 1.1 concepts of biology book.");
            reportLog("Presence of all Did you know section on the 1.1 concept of Biology book.");

            for (int i = 0; i <= 8; i++) {
                scrollByPixel(500);
                basePage.waitForSec(4);
            }

            Assert.assertTrue(biologyBookPage.verifyTheImagesOfBiologyBook(), assertFailurePreText + "Presence of images on the 1.1 concepts of biology book.");
            reportLog("Presence of all images on the 1.1 concept of Biology book.");

            Assert.assertTrue(biologyBookPage.verifyTheVideosOfBiologyBook(), assertFailurePreText + "Presence of videos on the 1.1 concepts of biology book.");
            reportLog("Presence of all the videos on the 1.1 concept of Biology book.");

        } catch (Exception e) {
            result = handleException(e);
        }
        Assert.assertTrue(result, "Test script failed for" + currentMethodName + errorMessage);
    }

    @Test(priority = 2, description = "Verify the Content of 1.2 Experiment concept of Biology book.")
    public void verifyContentOfExperimentConcept() {
        boolean result = true;
        try {
            String url = "https://flexbooks.ck12.org/cbook/ck-12-biology-flexbook-2.0/section/1.2/primary/lesson/science-experiments-bio/";

            webDriver.navigate().to(url);

            Assert.assertTrue(biologyBookPage.verifyModalityPageTitle("Experiment"), assertFailurePreText + "Presence of title on the 1.2 concepts of biology book.");
            reportLog("Verified Modality title: " + webDriver.getTitle() + "on the 1.2 concept of Biology book.");

            reportLog("The Page Description is: " + biologyBookPage.pageDescription.getAttribute("content"));

            Assert.assertTrue(biologyBookPage.verifyCanonicalMetaTag(), assertFailurePreText + "Presence of canonical meta tag on the 1.2 concepts of biology book.");
            reportLog("Verified Canonical Tag and 1 Tag is found with URL: " + biologyBookPage.canonicalData.getAttribute("href"));

            Assert.assertTrue(biologyBookPage.verifyHyperLinkTagsAndParseTheURLOfTags(), assertFailurePreText + "Presence of hyperlinked words on the 1.2 concepts of biology book.");
            reportLog("Presence of all the hyperlinked words terms on the 1.2 concept of Biology book.");

            Assert.assertTrue(biologyBookPage.verifyTheVocabularyTermsOfBiologyBook(), assertFailurePreText + "Presence of vocabulary terms on the 1.2 concepts of biology book.");
            reportLog("Presence of all the vocabulary terms on the 1.2 concept of Biology book.");

            Assert.assertTrue(biologyBookPage.verifyHTagsInBook(), assertFailurePreText + "Presence of Header tag on the 1.2 concepts of biology book.");
            reportLog("Presence of all Header tag on the 1.2 concept of Biology book.");

            Assert.assertTrue(biologyBookPage.verifyDidYouKnowSection(), assertFailurePreText + "Presence of Did you know section on the 1.2 concepts of biology book.");
            reportLog("Presence of all Did you know section on the 1.2 concept of Biology book.");

            for (int i = 0; i <= 8; i++) {
                scrollByPixel(500);
                basePage.waitForSec(4);
            }

            Assert.assertTrue(biologyBookPage.verifyTheImagesOfBiologyBook(), assertFailurePreText + "Presence of images on the 1.2 concepts of biology book.");
            reportLog("Presence of all images on the 1.2 concept of Biology book.");

            Assert.assertTrue(biologyBookPage.verifyTheVideosOfBiologyBook(), assertFailurePreText + "Presence of videos on the 1.2 concepts of biology book.");
            reportLog("Presence of all the videos on the 1.2 concept of Biology book.");


        } catch (Exception e) {
            result = handleException(e);
        }
        Assert.assertTrue(result, "Test script failed for" + currentMethodName + errorMessage);
    }

    @Test(priority = 3, description = "Verify the Content of 1.3 Scientific Theories concept of Biology book.")
    public void verifyContentOfScientificTheoriesConcept() {
        boolean result = true;
        try {
            String url = "https://flexbooks.ck12.org/cbook/ck-12-biology-flexbook-2.0/section/1.3/primary/lesson/scientific-theories-bio/";
            webDriver.navigate().to(url);

            Assert.assertTrue(biologyBookPage.verifyModalityPageTitle("Scientific Theories"), assertFailurePreText + "Presence of title on the 1.3 concepts of biology book.");
            reportLog("Verified Modality title: " + webDriver.getTitle() + "on the 1.3 concept of Biology book.");

            reportLog("The Page Description is: " + biologyBookPage.pageDescription.getAttribute("content"));

            Assert.assertTrue(biologyBookPage.verifyCanonicalMetaTag(), assertFailurePreText + "Presence of canonical meta tag on the 1.3 concepts of biology book.");
            reportLog("Verified Canonical Tag and 1 Tag is found with URL: " + biologyBookPage.canonicalData.getAttribute("href"));

            Assert.assertTrue(biologyBookPage.verifyHyperLinkTagsAndParseTheURLOfTags(), assertFailurePreText + "Presence of hyperlinked words on the 1.3 concepts of biology book.");
            reportLog("Presence of all the hyperlinked words terms on the 1.3 concept of Biology book.");

            Assert.assertTrue(biologyBookPage.verifyTheVocabularyTermsOfBiologyBook(), assertFailurePreText + "Presence of vocabulary terms on the 1.3 concepts of biology book.");
            reportLog("Presence of all the vocabulary terms on the 1.3 concept of Biology book.");

            Assert.assertTrue(biologyBookPage.verifyHTagsInBook(), assertFailurePreText + "Presence of Header tag on the 1.3 concepts of biology book.");
            reportLog("Presence of all Header tag on the 1.3 concept of Biology book.");

            Assert.assertTrue(biologyBookPage.verifyDidYouKnowSection(), assertFailurePreText + "Presence of Did you know section on the 1.3 concepts of biology book.");
            reportLog("Presence of all Did you know section on the 1.3 concept of Biology book.");

            for (int i = 0; i <= 8; i++) {
                scrollByPixel(500);
                basePage.waitForSec(4);
            }

            Assert.assertTrue(biologyBookPage.verifyTheImagesOfBiologyBook(), assertFailurePreText + "Presence of images on the 1.3 concepts of biology book.");
            reportLog("Presence of all images on the 1.3 concept of Biology book.");

            Assert.assertTrue(biologyBookPage.verifyTheVideosOfBiologyBook(), assertFailurePreText + "Presence of videos on the 1.3 concepts of biology book.");
            reportLog("Presence of all the videos on the 1.3 concept of Biology book.");


        } catch (Exception e) {
            result = handleException(e);
        }
        Assert.assertTrue(result, "Test script failed for" + currentMethodName + errorMessage);
    }

    @Test(priority = 4, description = "Verify the Content of 1.4 Characteristics of Life concept of Biology book.")
    public void verifyContentOfCharacteristicsOfLifeConcept() {
        boolean result = true;
        try {
            String url = "https://flexbooks.ck12.org/cbook/ck-12-biology-flexbook-2.0/section/1.4/primary/lesson/characteristics-of-life-bio/";
            webDriver.navigate().to(url);

            Assert.assertTrue(biologyBookPage.verifyModalityPageTitle("Characteristics of Life"), assertFailurePreText + "Presence of title on the 1.4 concepts of biology book.");
            reportLog("Verified Modality title: " + webDriver.getTitle() + "on the 1.4 concept of Biology book.");

            reportLog("The Page Description is: " + biologyBookPage.pageDescription.getAttribute("content"));

            Assert.assertTrue(biologyBookPage.verifyCanonicalMetaTag(), assertFailurePreText + "Presence of canonical meta tag on the 1.4 concepts of biology book.");
            reportLog("Verified Canonical Tag and 1 Tag is found with URL: " + biologyBookPage.canonicalData.getAttribute("href"));

            Assert.assertTrue(biologyBookPage.verifyHyperLinkTagsAndParseTheURLOfTags(), assertFailurePreText + "Presence of hyperlinked words on the 1.4 concepts of biology book.");
            reportLog("Hyper tags are not there for 1.4 concept of Biology book.");

            Assert.assertTrue(biologyBookPage.verifyTheVocabularyTermsOfBiologyBook(), assertFailurePreText + "Presence of vocabulary terms on the 1.4 concepts of biology book.");
            reportLog("Vocabulary terms are not there for 1.4 concept of Biology book.");

            Assert.assertTrue(biologyBookPage.verifyHTagsInBook(), assertFailurePreText + "Presence of Header tag on the 1.4 concepts of biology book.");
            reportLog("Presence of all Header tag on the 1.4 concept of Biology book.");

            Assert.assertTrue(biologyBookPage.verifyDidYouKnowSection(), assertFailurePreText + "Presence of Did you know section on the 1.4 concepts of biology book.");
            reportLog("Presence of all Did you know section on the 1.4 concept of Biology book.");

            for (int i = 0; i <= 8; i++) {
                scrollByPixel(500);
                basePage.waitForSec(4);
            }

            Assert.assertTrue(biologyBookPage.verifyTheImagesOfBiologyBook(), assertFailurePreText + "Presence of images on the 1.4 concepts of biology book.");
            reportLog("Presence of all images on the 1.4 concept of Biology book.");

            Assert.assertTrue(biologyBookPage.verifyTheVideosOfBiologyBook(), assertFailurePreText + "Presence of videos on the 1.4 concepts of biology book.");
            reportLog("Presence of all the videos on the 1.4 concept of Biology book.");


        } catch (Exception e) {
            result = handleException(e);
        }
        Assert.assertTrue(result, "Test script failed for" + currentMethodName + errorMessage);
    }

    @Test(priority = 5, description = "Verify the Content of 1.5 Principles of Biology concept of Biology book.")
    public void verifyContentOfPrinciplesOfBiologyConcept() {
        boolean result = true;
        try {
            String url = "https://flexbooks.ck12.org/cbook/ck-12-biology-flexbook-2.0/section/1.5/primary/lesson/principles-of-biology-bio/";
            webDriver.navigate().to(url);

            Assert.assertTrue(biologyBookPage.verifyModalityPageTitle("Principles of Biology"), assertFailurePreText + "Presence of title on the 1.5 concepts of biology book.");
            reportLog("Verified Modality title: " + webDriver.getTitle() + "on the 1.5 concept of Biology book.");

            reportLog("The Page Description is: " + biologyBookPage.pageDescription.getAttribute("content"));

            Assert.assertTrue(biologyBookPage.verifyCanonicalMetaTag(), assertFailurePreText + "Presence of canonical meta tag on the 1.5 concepts of biology book.");
            reportLog("Verified Canonical Tag and 1 Tag is found with URL: " + biologyBookPage.canonicalData.getAttribute("href"));

            Assert.assertTrue(biologyBookPage.verifyHyperLinkTagsAndParseTheURLOfTags(), assertFailurePreText + "Presence of hyperlinked words on the 1.5 concepts of biology book.");
            reportLog("Hyperlinked words terms are not there for 1.5 concept of Biology book.");

            Assert.assertTrue(biologyBookPage.verifyTheVocabularyTermsOfBiologyBook(), assertFailurePreText + "Presence of vocabulary terms on the 1.5 concepts of biology book.");
            reportLog("Vocabulary terms are not there for the 1.5 concept of Biology book.");

            Assert.assertTrue(biologyBookPage.verifyHTagsInBook(), assertFailurePreText + "Presence of Header tag on the 1.5 concepts of biology book.");
            reportLog("Presence of all Header tag on the 1.5 concept of Biology book.");

            Assert.assertTrue(biologyBookPage.verifyDidYouKnowSection(), assertFailurePreText + "Presence of Did you know section on the 1.5 concepts of biology book.");
            reportLog("Presence of all Did you know section on the 1.5 concept of Biology book.");

            for (int i = 0; i <= 8; i++) {
                scrollByPixel(500);
                basePage.waitForSec(4);
            }

            Assert.assertTrue(biologyBookPage.verifyTheImagesOfBiologyBook(), assertFailurePreText + "Presence of images on the 1.5 concepts of biology book.");
            reportLog("Presence of all images on the 1.5 concept of Biology book.");

            Assert.assertTrue(biologyBookPage.verifyTheVideosOfBiologyBook(), assertFailurePreText + "Presence of videos on the 1.5 concepts of biology book.");
            reportLog("Presence of all the videos on the 1.5 concept of Biology book.");


        } catch (Exception e) {
            result = handleException(e);
        }
        Assert.assertTrue(result, "Test script failed for" + currentMethodName + errorMessage);
    }

    @Test(priority = 6, description = "Verify the Content of 1.6 Interdependence of Living Things concept of Biology book.")
    public void verifyContentOfInterdependenceOfLivingThingsConcept() {
        boolean result = true;
        try {
            String url = "https://flexbooks.ck12.org/cbook/ck-12-biology-flexbook-2.0/section/1.6/primary/lesson/interdependence-of-living-things-bio/";
            webDriver.navigate().to(url);

            Assert.assertTrue(biologyBookPage.verifyModalityPageTitle("Interdependence of Living Things"), assertFailurePreText + "Presence of title on the 1.6 concepts of biology book.");
            reportLog("Verified Modality title: " + webDriver.getTitle() + "on the 1.6 concept of Biology book.");

            reportLog("The Page Description is: " + biologyBookPage.pageDescription.getAttribute("content"));

            Assert.assertTrue(biologyBookPage.verifyCanonicalMetaTag(), assertFailurePreText + "Presence of canonical meta tag on the 1.6 concepts of biology book.");
            reportLog("Verified Canonical Tag and 1 Tag is found with URL: " + biologyBookPage.canonicalData.getAttribute("href"));

            Assert.assertTrue(biologyBookPage.verifyHyperLinkTagsAndParseTheURLOfTags(), assertFailurePreText + "Presence of hyperlinked words on the 1.6 concepts of biology book.");
            reportLog("Presence of all the hyperlinked words terms on the 1.6 concept of Biology book.");

            Assert.assertTrue(biologyBookPage.verifyTheVocabularyTermsOfBiologyBook(), assertFailurePreText + "Presence of vocabulary terms on the 1.6 concepts of biology book.");
            reportLog("Presence of all the vocabulary terms on the 1.6 concept of Biology book.");

            Assert.assertTrue(biologyBookPage.verifyHTagsInBook(), assertFailurePreText + "Presence of Header tag on the 1.6 concepts of biology book.");
            reportLog("Presence of all Header tag on the 1.6 concept of Biology book.");

            Assert.assertTrue(biologyBookPage.verifyDidYouKnowSection(), assertFailurePreText + "Presence of Did you know section on the 1.6 concepts of biology book.");
            reportLog("Presence of all Did you know section on the 1.6 concept of Biology book.");

            for (int i = 0; i <= 8; i++) {
                scrollByPixel(500);
                basePage.waitForSec(4);
            }

            Assert.assertTrue(biologyBookPage.verifyTheImagesOfBiologyBook(), assertFailurePreText + "Presence of images on the 1.6 concepts of biology book.");
            reportLog("Presence of all images on the 1.6 concept of Biology book.");

            Assert.assertTrue(biologyBookPage.verifyTheVideosOfBiologyBook(), assertFailurePreText + "Presence of videos on the 1.6 concepts of biology book.");
            reportLog("Presence of all the videos on the 1.6 concept of Biology book.");


        } catch (Exception e) {
            result = handleException(e);
        }
        Assert.assertTrue(result, "Test script failed for" + currentMethodName + errorMessage);
    }

    @Test(priority = 7, description = "Verify the Content of 1.7 Organization of Living Things concept of Biology book.")
    public void verifyContentOfOrganizationOfLivingThingsConcept() {
        boolean result = true;
        try {
            String url = "https://flexbooks.ck12.org/cbook/ck-12-biology-flexbook-2.0/section/1.7/primary/lesson/organization-of-living-things-bio/";
            webDriver.navigate().to(url);

            Assert.assertTrue(biologyBookPage.verifyModalityPageTitle("Organization of Living Things"), assertFailurePreText + "Presence of title on the 1.7 concepts of biology book.");
            reportLog("Verified Modality title: " + webDriver.getTitle() + "on the 1.7 concept of Biology book.");

            reportLog("The Page Description is: " + biologyBookPage.pageDescription.getAttribute("content"));

            Assert.assertTrue(biologyBookPage.verifyCanonicalMetaTag(), assertFailurePreText + "Presence of canonical meta tag on the 1.7 concepts of biology book.");
            reportLog("Verified Canonical Tag and 1 Tag is found with URL: " + biologyBookPage.canonicalData.getAttribute("href"));

            Assert.assertTrue(biologyBookPage.verifyHyperLinkTagsAndParseTheURLOfTags(), assertFailurePreText + "Presence of hyperlinked words on the 1.7 concepts of biology book.");
            reportLog("Hyperlinked words terms are not there for the 1.7 concept of Biology book.");

            Assert.assertTrue(biologyBookPage.verifyTheVocabularyTermsOfBiologyBook(), assertFailurePreText + "Presence of vocabulary terms on the 1.7 concepts of biology book.");
            reportLog("Vocabulary terms are not there for the 1.7 concept of Biology book.");

            Assert.assertTrue(biologyBookPage.verifyHTagsInBook(), assertFailurePreText + "Presence of Header tag on the 1.7 concepts of biology book.");
            reportLog("Presence of all Header tag on the 1.7 concept of Biology book.");

            Assert.assertTrue(biologyBookPage.verifyDidYouKnowSection(), assertFailurePreText + "Presence of Did you know section on the 1.7 concepts of biology book.");
            reportLog("Presence of all Did you know section on the 1.7 concept of Biology book.");

            for (int i = 0; i <= 8; i++) {
                scrollByPixel(500);
                basePage.waitForSec(4);
            }

            Assert.assertTrue(biologyBookPage.verifyTheImagesOfBiologyBook(), assertFailurePreText + "Presence of images on the 1.7 concepts of biology book.");
            reportLog("Presence of all images on the 1.7 concept of Biology book.");

            Assert.assertTrue(biologyBookPage.verifyTheVideosOfBiologyBook(), assertFailurePreText + "Presence of videos on the 1.7 concepts of biology book.");
            reportLog("Presence of all the videos on the 1.7 concept of Biology book.");


        } catch (Exception e) {
            result = handleException(e);
        }
        Assert.assertTrue(result, "Test script failed for" + currentMethodName + errorMessage);
    }

    @Test(priority = 8, description = "Verify the Content of 1.8 Evolution of Life concept of Biology book.")
    public void verifyContentOfEvolutionOfLifeConcept() {
        boolean result = true;
        try {
            String url = "https://flexbooks.ck12.org/cbook/ck-12-biology-flexbook-2.0/section/1.8/primary/lesson/evolution-of-life-bio/";
            webDriver.navigate().to(url);

            Assert.assertTrue(biologyBookPage.verifyModalityPageTitle("Evolution of Life"), assertFailurePreText + "Presence of title on the 1.8 concepts of biology book.");
            reportLog("Verified Modality title: " + webDriver.getTitle() + "on the 1.8 concept of Biology book.");

            reportLog("The Page Description is: " + biologyBookPage.pageDescription.getAttribute("content"));

            Assert.assertTrue(biologyBookPage.verifyCanonicalMetaTag(), assertFailurePreText + "Presence of canonical meta tag on the 1.8 concepts of biology book.");
            reportLog("Verified Canonical Tag and 1 Tag is found with URL: " + biologyBookPage.canonicalData.getAttribute("href"));

            Assert.assertTrue(biologyBookPage.verifyHyperLinkTagsAndParseTheURLOfTags(), assertFailurePreText + "Presence of hyperlinked words on the 1.8 concepts of biology book.");
            reportLog("Presence of all the hyperlinked words terms on the 1.8 concept of Biology book.");

            Assert.assertTrue(biologyBookPage.verifyTheVocabularyTermsOfBiologyBook(), assertFailurePreText + "Presence of vocabulary terms on the 1.8 concepts of biology book.");
            reportLog("Presence of all the vocabulary terms on the 1.8 concept of Biology book.");

            Assert.assertTrue(biologyBookPage.verifyHTagsInBook(), assertFailurePreText + "Presence of Header tag on the 1.8 concepts of biology book.");
            reportLog("Presence of all Header tag on the 1.8 concept of Biology book.");

            Assert.assertTrue(biologyBookPage.verifyDidYouKnowSection(), assertFailurePreText + "Presence of Did you know section on the 1.8 concepts of biology book.");
            reportLog("Did you know section is not the for the 1.8 concept of Biology book.");

            for (int i = 0; i <= 8; i++) {
                scrollByPixel(500);
                basePage.waitForSec(4);
            }

            Assert.assertTrue(biologyBookPage.verifyTheImagesOfBiologyBook(), assertFailurePreText + "Presence of images on the 1.8 concepts of biology book.");
            reportLog("Presence of all images on the 1.8 concept of Biology book.");

            Assert.assertTrue(biologyBookPage.verifyTheVideosOfBiologyBook(), assertFailurePreText + "Presence of videos on the 1.8 concepts of biology book.");
            reportLog("Presence of all the videos on the 1.8 concept of Biology book.");


        } catch (Exception e) {
            result = handleException(e);
        }
        Assert.assertTrue(result, "Test script failed for" + currentMethodName + errorMessage);
    }

    @Test(priority = 9, description = "Verify the Content of 1.9 Significance of carbon concept of Biology book.")
    public void verifyContentOfSignificanceOfCarbonConcept() {
        boolean result = true;
        try {
            String url = "https://flexbooks.ck12.org/cbook/ck-12-biology-flexbook-2.0/section/1.9/primary/lesson/significance-of-carbon-bio/";
            webDriver.navigate().to(url);

            Assert.assertTrue(biologyBookPage.verifyModalityPageTitle("Significance of Carbon"), assertFailurePreText + "Presence of title on the 1.9 concepts of biology book.");
            reportLog("Verified Modality title: " + webDriver.getTitle() + "on the 1.9 concept of Biology book.");

            reportLog("The Page Description is: " + biologyBookPage.pageDescription.getAttribute("content"));

            Assert.assertTrue(biologyBookPage.verifyCanonicalMetaTag(), assertFailurePreText + "Presence of canonical meta tag on the 1.9 concepts of biology book.");
            reportLog("Verified Canonical Tag and 1 Tag is found with URL: " + biologyBookPage.canonicalData.getAttribute("href"));

            Assert.assertTrue(biologyBookPage.verifyHyperLinkTagsAndParseTheURLOfTags(), assertFailurePreText + "Presence of hyperlinked words on the 1.9 concepts of biology book.");
            reportLog("Hyperlinked words terms are not there for the 1.9 concept of Biology book.");

            Assert.assertTrue(biologyBookPage.verifyTheVocabularyTermsOfBiologyBook(), assertFailurePreText + "Presence of vocabulary terms on the 1.9 concepts of biology book.");
            reportLog("Vocabulary terms are not there for the 1.9 concept of Biology book.");

            Assert.assertTrue(biologyBookPage.verifyHTagsInBook(), assertFailurePreText + "Presence of Header tag on the 1.9 concepts of biology book.");
            reportLog("Presence of all Header tag on the 1.9 concept of Biology book.");

            Assert.assertTrue(biologyBookPage.verifyDidYouKnowSection(), assertFailurePreText + "Presence of Did you know section on the 1.9 concepts of biology book.");
            reportLog("Presence of all Did you know section on the 1.9 concept of Biology book.");

            for (int i = 0; i <= 8; i++) {
                scrollByPixel(500);
                basePage.waitForSec(4);
            }

            Assert.assertTrue(biologyBookPage.verifyTheImagesOfBiologyBook(), assertFailurePreText + "Presence of images on the 1.9 concepts of biology book.");
            reportLog("Presence of all images on the 1.9 concept of Biology book.");

            Assert.assertTrue(biologyBookPage.verifyTheVideosOfBiologyBook(), assertFailurePreText + "Presence of videos on the 1.9 concepts of biology book.");
            reportLog("Presence of all the videos on the 1.9 concept of Biology book.");


        } catch (Exception e) {
            result = handleException(e);
        }
        Assert.assertTrue(result, "Test script failed for" + currentMethodName + errorMessage);
    }

    @Test(priority = 10, description = "Verify the Content of 1.10 Carbohydrates concept of Biology book.")
    public void verifyContentOfCarbohydratesConcept() {
        boolean result = true;
        try {
            String url = "https://flexbooks.ck12.org/cbook/ck-12-biology-flexbook-2.0/section/1.10/primary/lesson/carbohydrates-bio/";
            webDriver.navigate().to(url);

            Assert.assertTrue(biologyBookPage.verifyModalityPageTitle("Carbohydrates"), assertFailurePreText + "Presence of title on the 1.10 concepts of biology book.");
            reportLog("Verified Modality title: " + webDriver.getTitle() + "on the 1.10 concept of Biology book.");

            reportLog("The Page Description is: " + biologyBookPage.pageDescription.getAttribute("content"));

            Assert.assertTrue(biologyBookPage.verifyCanonicalMetaTag(), assertFailurePreText + "Presence of canonical meta tag on the 1.10 concepts of biology book.");
            reportLog("Verified Canonical Tag and 1 Tag is found with URL: " + biologyBookPage.canonicalData.getAttribute("href"));

            Assert.assertTrue(biologyBookPage.verifyHyperLinkTagsAndParseTheURLOfTags(), assertFailurePreText + "Presence of hyperlinked words on the 1.10 concepts of biology book.");
            reportLog("Hyperlinked words terms are not there for the 1.10 concept of Biology book.");

            Assert.assertTrue(biologyBookPage.verifyTheVocabularyTermsOfBiologyBook(), assertFailurePreText + "Presence of vocabulary terms on the 1.10 concepts of biology book.");
            reportLog("Vocabulary terms are not there for the 1.10 concept of Biology book.");

            Assert.assertTrue(biologyBookPage.verifyHTagsInBook(), assertFailurePreText + "Presence of Header tag on the 1.10 concepts of biology book.");
            reportLog("Presence of all Header tag on the 1.10 concept of Biology book.");

            Assert.assertTrue(biologyBookPage.verifyDidYouKnowSection(), assertFailurePreText + "Presence of Did you know section on the 1.10 concepts of biology book.");
            reportLog("Presence of all Did you know section on the 1.10 concept of Biology book.");

            for (int i = 0; i <= 8; i++) {
                scrollByPixel(500);
                basePage.waitForSec(4);
            }

            Assert.assertTrue(biologyBookPage.verifyTheImagesOfBiologyBook(), assertFailurePreText + "Presence of images on the 1.10 concepts of biology book.");
            reportLog("Presence of all images on the 1.10 concept of Biology book.");

            Assert.assertTrue(biologyBookPage.verifyTheVideosOfBiologyBook(), assertFailurePreText + "Presence of videos on the 1.10 concepts of biology book.");
            reportLog("Presence of all the videos on the 1.10 concept of Biology book.");


        } catch (Exception e) {
            result = handleException(e);
        }
        Assert.assertTrue(result, "Test script failed for" + currentMethodName + errorMessage);
    }

    @Test(priority = 11, description = "Verify the Content of 1.11 Proteins concept of Biology book.")
    public void verifyContentOfProteinsConcept() {
        boolean result = true;
        try {
            String url = "https://flexbooks.ck12.org/cbook/ck-12-biology-flexbook-2.0/section/1.11/primary/lesson/proteins-bio/";
            webDriver.navigate().to(url);

            Assert.assertTrue(biologyBookPage.verifyModalityPageTitle("Proteins"), assertFailurePreText + "Presence of title on the 1.11 concepts of biology book.");
            reportLog("Verified Modality title: " + webDriver.getTitle() + "on the 1.11 concept of Biology book.");

            reportLog("The Page Description is: " + biologyBookPage.pageDescription.getAttribute("content"));

            Assert.assertTrue(biologyBookPage.verifyCanonicalMetaTag(), assertFailurePreText + "Presence of canonical meta tag on the 1.11 concepts of biology book.");
            reportLog("Verified Canonical Tag and 1 Tag is found with URL: " + biologyBookPage.canonicalData.getAttribute("href"));

            Assert.assertTrue(biologyBookPage.verifyHyperLinkTagsAndParseTheURLOfTags(), assertFailurePreText + "Presence of hyperlinked words on the 1.11 concepts of biology book.");
            reportLog("Hyperlinked words terms are not there for the 1.11 concept of Biology book.");

            Assert.assertTrue(biologyBookPage.verifyTheVocabularyTermsOfBiologyBook(), assertFailurePreText + "Presence of vocabulary terms on the 1.11 concepts of biology book.");
            reportLog("Vocabulary terms are not there for the 1.11 concept of Biology book.");

            Assert.assertTrue(biologyBookPage.verifyHTagsInBook(), assertFailurePreText + "Presence of Header tag on the 1.11 concepts of biology book.");
            reportLog("Presence of all Header tag on the 1.11 concept of Biology book.");

            Assert.assertTrue(biologyBookPage.verifyDidYouKnowSection(), assertFailurePreText + "Presence of Did you know section on the 1.11 concepts of biology book.");
            reportLog("Presence of all Did you know section on the 1.11 concept of Biology book.");

            for (int i = 0; i <= 8; i++) {
                scrollByPixel(500);
                basePage.waitForSec(4);
            }

            Assert.assertTrue(biologyBookPage.verifyTheImagesOfBiologyBook(), assertFailurePreText + "Presence of images on the 1.11 concepts of biology book.");
            reportLog("Presence of all images on the 1.11 concept of Biology book.");

            Assert.assertTrue(biologyBookPage.verifyTheVideosOfBiologyBook(), assertFailurePreText + "Presence of videos on the 1.11 concepts of biology book.");
            reportLog("Presence of all the videos on the 1.11 concept of Biology book.");


        } catch (Exception e) {
            result = handleException(e);
        }
        Assert.assertTrue(result, "Test script failed for" + currentMethodName + errorMessage);
    }

    @Test(priority = 12, description = "Verify the Content of 1.12 Lipids concept of Biology book.")
    public void verifyContentOfLipidsConcept() {
        boolean result = true;
        try {
            String url = "https://flexbooks.ck12.org/cbook/ck-12-biology-flexbook-2.0/section/1.12/primary/lesson/lipids-bio/";
            webDriver.navigate().to(url);

            Assert.assertTrue(biologyBookPage.verifyModalityPageTitle("Lipids"), assertFailurePreText + "Presence of title on the 1.12 concepts of biology book.");
            reportLog("Verified Modality title: " + webDriver.getTitle() + "on the 1.12 concept of Biology book.");

            reportLog("The Page Description is: " + biologyBookPage.pageDescription.getAttribute("content"));

            Assert.assertTrue(biologyBookPage.verifyCanonicalMetaTag(), assertFailurePreText + "Presence of canonical meta tag on the 1.12 concepts of biology book.");
            reportLog("Verified Canonical Tag and 1 Tag is found with URL: " + biologyBookPage.canonicalData.getAttribute("href"));

            Assert.assertTrue(biologyBookPage.verifyHyperLinkTagsAndParseTheURLOfTags(), assertFailurePreText + "Presence of hyperlinked words on the 1.12 concepts of biology book.");
            reportLog("Presence of all the hyperlinked words terms on the 1.12 concept of Biology book.");

            Assert.assertTrue(biologyBookPage.verifyTheVocabularyTermsOfBiologyBook(), assertFailurePreText + "Presence of vocabulary terms on the 1.12 concepts of biology book.");
            reportLog("Presence of all the vocabulary terms on the 1.12 concept of Biology book.");

            Assert.assertTrue(biologyBookPage.verifyHTagsInBook(), assertFailurePreText + "Presence of Header tag on the 1.12 concepts of biology book.");
            reportLog("Presence of all Header tag on the 1.12 concept of Biology book.");

            Assert.assertTrue(biologyBookPage.verifyDidYouKnowSection(), assertFailurePreText + "Presence of Did you know section on the 1.12 concepts of biology book.");
            reportLog("Presence of all Did you know section on the 1.12 concept of Biology book.");

            for (int i = 0; i <= 8; i++) {
                scrollByPixel(500);
                basePage.waitForSec(4);
            }

            Assert.assertTrue(biologyBookPage.verifyTheImagesOfBiologyBook(), assertFailurePreText + "Presence of images on the 1.12 concepts of biology book.");
            reportLog("Presence of all images on the 1.12 concept of Biology book.");

            Assert.assertTrue(biologyBookPage.verifyTheVideosOfBiologyBook(), assertFailurePreText + "Presence of videos on the 1.12 concepts of biology book.");
            reportLog("Presence of all the videos on the 1.12 concept of Biology book.");


        } catch (Exception e) {
            result = handleException(e);
        }
        Assert.assertTrue(result, "Test script failed for" + currentMethodName + errorMessage);
    }

    @Test(priority = 13, description = "Verify the Content of 1.13 Nucleic Acids concept of Biology book.")
    public void verifyContentOfNucleicAcidsConcept() {
        boolean result = true;
        try {
            String url = "https://flexbooks.ck12.org/cbook/ck-12-biology-flexbook-2.0/section/1.13/primary/lesson/nucleic-acids-bio/";
            webDriver.navigate().to(url);

            Assert.assertTrue(biologyBookPage.verifyModalityPageTitle("Nucleic Acids"), assertFailurePreText + "Presence of title on the 1.13 concepts of biology book.");
            reportLog("Verified Modality title: " + webDriver.getTitle() + "on the 1.13 concept of Biology book.");

            reportLog("The Page Description is: " + biologyBookPage.pageDescription.getAttribute("content"));

            Assert.assertTrue(biologyBookPage.verifyCanonicalMetaTag(), assertFailurePreText + "Presence of canonical meta tag on the 1.13 concepts of biology book.");
            reportLog("Verified Canonical Tag and 1 Tag is found with URL: " +biologyBookPage.canonicalData.getAttribute("href"));

            Assert.assertTrue(biologyBookPage.verifyHyperLinkTagsAndParseTheURLOfTags(), assertFailurePreText + "Presence of hyperlinked words on the 1.13 concepts of biology book.");
            reportLog("Hyperlinked words terms are not there for the 1.13 concept of Biology book.");

            Assert.assertTrue(biologyBookPage.verifyTheVocabularyTermsOfBiologyBook(), assertFailurePreText + "Presence of vocabulary terms on the 1.13 concepts of biology book.");
            reportLog("Vocabulary terms are not there for the 1.13 concept of Biology book.");

            Assert.assertTrue(biologyBookPage.verifyHTagsInBook(), assertFailurePreText + "Presence of Header tag on the 1.13 concepts of biology book.");
            reportLog("Presence of all Header tag on the 1.13 concept of Biology book.");

            Assert.assertTrue(biologyBookPage.verifyDidYouKnowSection(), assertFailurePreText + "Presence of Did you know section on the 1.13 concepts of biology book.");
            reportLog("Presence of all Did you know section on the 1.13 concept of Biology book.");

            for (int i = 0; i <= 8; i++) {
                scrollByPixel(500);
                basePage.waitForSec(4);
            }

            Assert.assertTrue(biologyBookPage.verifyTheImagesOfBiologyBook(), assertFailurePreText + "Presence of images on the 1.13 concepts of biology book.");
            reportLog("Presence of all images on the 1.13 concept of Biology book.");

            Assert.assertTrue(biologyBookPage.verifyTheVideosOfBiologyBook(), assertFailurePreText + "Presence of videos on the 1.13 concepts of biology book.");
            reportLog("Presence of all the videos on the 1.13 concept of Biology book.");


        } catch (Exception e) {
            result = handleException(e);
        }
        Assert.assertTrue(result, "Test script failed for" + currentMethodName + errorMessage);
    }

    @Test(priority = 14, description = "Verify the Content of 1.14 Biochemical Reactions concept of Biology book.")
    public void verifyContentOfBiochemicalReactionsConcept() {
        boolean result = true;
        try {
            String url = "https://flexbooks.ck12.org/cbook/ck-12-biology-flexbook-2.0/section/1.14/primary/lesson/biochemical-reactions-bio/";
            webDriver.navigate().to(url);

            Assert.assertTrue(biologyBookPage.verifyModalityPageTitle("Biochemical Reactions"), assertFailurePreText + "Presence of title on the 1.14 concepts of biology book.");
            reportLog("Verified Modality title: " + webDriver.getTitle() + "on the 1.14 concept of Biology book.");

            reportLog("The Page Description is: " + biologyBookPage.pageDescription.getAttribute("content"));

            Assert.assertTrue(biologyBookPage.verifyCanonicalMetaTag(), assertFailurePreText + "Presence of canonical meta tag on the 1.14 concepts of biology book.");
            reportLog("Verified Canonical Tag and 1 Tag is found with URL: " + biologyBookPage.canonicalData.getAttribute("href"));

            Assert.assertTrue(biologyBookPage.verifyHyperLinkTagsAndParseTheURLOfTags(), assertFailurePreText + "Presence of hyperlinked words on the 1.14 concepts of biology book.");
            reportLog("Presence of all the hyperlinked words terms on the 1.14 concept of Biology book.");

            Assert.assertTrue(biologyBookPage.verifyTheVocabularyTermsOfBiologyBook(), assertFailurePreText + "Presence of vocabulary terms on the 1.14 concepts of biology book.");
            reportLog("Presence of all the vocabulary terms on the 1.14 concept of Biology book.");

            Assert.assertTrue(biologyBookPage.verifyHTagsInBook(), assertFailurePreText + "Presence of Header tag on the 1.14 concepts of biology book.");
            reportLog("Presence of all Header tag on the 1.14 concept of Biology book.");

            Assert.assertTrue(biologyBookPage.verifyDidYouKnowSection(), assertFailurePreText + "Presence of Did you know section on the 1.14 concepts of biology book.");
            reportLog("Presence of all Did you know section on the 1.14 concept of Biology book.");

            for (int i = 0; i <= 8; i++) {
                scrollByPixel(500);
                basePage.waitForSec(4);
            }

            Assert.assertTrue(biologyBookPage.verifyTheImagesOfBiologyBook(), assertFailurePreText + "Presence of images on the 1.14 concepts of biology book.");
            reportLog("Presence of all images on the 1.14 concept of Biology book.");

            Assert.assertTrue(biologyBookPage.verifyTheVideosOfBiologyBook(), assertFailurePreText + "Presence of videos on the 1.14 concepts of biology book.");
            reportLog("Presence of all the videos on the 1.14 concept of Biology book.");


        } catch (Exception e) {
            result = handleException(e);
        }
        Assert.assertTrue(result, "Test script failed for" + currentMethodName + errorMessage);
    }

    @Test(priority = 15, description = "Verify the Content of 1.15 Energy and Biochemical Reactions concept of Biology book.")
    public void verifyContentOfEnergyAndBiochemicalReactionsConcept() {
        boolean result = true;
        try {
            String url = "https://flexbooks.ck12.org/cbook/ck-12-biology-flexbook-2.0/section/1.15/primary/lesson/energy-and-biochemical-reactions-bio/";
            webDriver.navigate().to(url);

            Assert.assertTrue(biologyBookPage.verifyModalityPageTitle("Energy and Biochemical Reactions"), assertFailurePreText + "Presence of title on the 1.15 concepts of biology book.");
            reportLog("Verified Modality title: " + webDriver.getTitle() + "on the 1.15 concept of Biology book.");

            reportLog("The Page Description is: " + biologyBookPage.pageDescription.getAttribute("content"));

            Assert.assertTrue(biologyBookPage.verifyCanonicalMetaTag(), assertFailurePreText + "Presence of canonical meta tag on the 1.15 concepts of biology book.");
            reportLog("Verified Canonical Tag and 1 Tag is found with URL: " + biologyBookPage.canonicalData.getAttribute("href"));

            Assert.assertTrue(biologyBookPage.verifyHyperLinkTagsAndParseTheURLOfTags(), assertFailurePreText + "Presence of hyperlinked words on the 1.15 concepts of biology book.");
            reportLog("Presence of all the hyperlinked words terms on the 1.15 concept of Biology book.");

            Assert.assertTrue(biologyBookPage.verifyTheVocabularyTermsOfBiologyBook(), assertFailurePreText + "Presence of vocabulary terms on the 1.15 concepts of biology book.");
            reportLog("Presence of all the vocabulary terms on the 1.15 concept of Biology book.");

            Assert.assertTrue(biologyBookPage.verifyHTagsInBook(), assertFailurePreText + "Presence of Header tag on the 1.15 concepts of biology book.");
            reportLog("Presence of all Header tag on the 1.15 concept of Biology book.");

            Assert.assertTrue(biologyBookPage.verifyDidYouKnowSection(), assertFailurePreText + "Presence of Did you know section on the 1.15 concepts of biology book.");
            reportLog("Presence of all Did you know section on the 1.15 concept of Biology book.");

            for (int i = 0; i <= 8; i++) {
                scrollByPixel(500);
                basePage.waitForSec(4);
            }

            Assert.assertTrue(biologyBookPage.verifyTheImagesOfBiologyBook(), assertFailurePreText + "Presence of images on the 1.15 concepts of biology book.");
            reportLog("Presence of all images on the 1.15 concept of Biology book.");

            Assert.assertTrue(biologyBookPage.verifyTheVideosOfBiologyBook(), assertFailurePreText + "Presence of videos on the 1.15 concepts of biology book.");
            reportLog("Presence of all the videos on the 1.15 concept of Biology book.");


        } catch (Exception e) {
            result = handleException(e);
        }
        Assert.assertTrue(result, "Test script failed for" + currentMethodName + errorMessage);
    }

    @Test(priority = 16, description = "Verify the Content of 1.16 Types of Biochemical Reactions concept of Biology book.")
    public void verifyContentOfTypesOfBiochemicalReactionsConcept() {
        boolean result = true;
        try {
            String url = "https://flexbooks.ck12.org/cbook/ck-12-biology-flexbook-2.0/section/1.16/primary/lesson/types-of-biochemical-reactions-bio/";
            webDriver.navigate().to(url);

            Assert.assertTrue(biologyBookPage.verifyModalityPageTitle("Types of Biochemical Reactions"), assertFailurePreText + "Presence of title on the 1.16 concepts of biology book.");
            reportLog("Verified Modality title: " + webDriver.getTitle() + "on the 1.16 concept of Biology book.");

            reportLog("The Page Description is: " + biologyBookPage.pageDescription.getAttribute("content"));

            Assert.assertTrue(biologyBookPage.verifyCanonicalMetaTag(), assertFailurePreText + "Presence of canonical meta tag on the 1.16 concepts of biology book.");
            reportLog("Verified Canonical Tag and 1 Tag is found with URL: " + biologyBookPage.canonicalData.getAttribute("href"));

            Assert.assertTrue(biologyBookPage.verifyHyperLinkTagsAndParseTheURLOfTags(), assertFailurePreText + "Presence of hyperlinked words on the 1.16 concepts of biology book.");
            reportLog("Hyperlinked words terms are not there for the 1.16 concept of Biology book.");

            Assert.assertTrue(biologyBookPage.verifyTheVocabularyTermsOfBiologyBook(), assertFailurePreText + "Presence of vocabulary terms on the 1.16 concepts of biology book.");
            reportLog("Presence of all the vocabulary terms on the 1.16 concept of Biology book.");

            Assert.assertTrue(biologyBookPage.verifyHTagsInBook(), assertFailurePreText + "Presence of Header tag on the 1.16 concepts of biology book.");
            reportLog("Presence of all Header tag on the 1.16 concept of Biology book.");

            Assert.assertTrue(biologyBookPage.verifyDidYouKnowSection(), assertFailurePreText + "Presence of Did you know section on the 1.16 concepts of biology book.");
            reportLog("Presence of all Did you know section on the 1.16 concept of Biology book.");

            for (int i = 0; i <= 8; i++) {
                scrollByPixel(500);
                basePage.waitForSec(4);
            }

            Assert.assertTrue(biologyBookPage.verifyTheImagesOfBiologyBook(), assertFailurePreText + "Presence of images on the 1.16 concepts of biology book.");
            reportLog("Presence of all images on the 1.16 concept of Biology book.");

            Assert.assertTrue(biologyBookPage.verifyTheVideosOfBiologyBook(), assertFailurePreText + "Presence of videos on the 1.16 concepts of biology book.");
            reportLog("Presence of all the videos on the 1.16 concept of Biology book.");


        } catch (Exception e) {
            result = handleException(e);
        }
        Assert.assertTrue(result, "Test script failed for" + currentMethodName + errorMessage);
    }

    @Test(priority = 17, description = "Verify the Content of 1.17 Types of Enzymes concept of Biology book.")
    public void verifyContentOfEnzymesConcept() {
        boolean result = true;
        try {
            String url = "https://flexbooks.ck12.org/cbook/ck-12-biology-flexbook-2.0/section/1.17/primary/lesson/enzymes-bio/";
            webDriver.navigate().to(url);

            Assert.assertTrue(biologyBookPage.verifyModalityPageTitle("Enzymes"), assertFailurePreText + "Presence of title on the 1.17 concepts of biology book.");
            reportLog("Verified Modality title: " + webDriver.getTitle() + "on the 1.17 concept of Biology book.");

            reportLog("The Page Description is: " + biologyBookPage.pageDescription.getAttribute("content"));

            Assert.assertTrue(biologyBookPage.verifyCanonicalMetaTag(), assertFailurePreText + "Presence of canonical meta tag on the 1.17 concepts of biology book.");
            reportLog("Verified Canonical Tag and 1 Tag is found with URL: " + biologyBookPage.canonicalData.getAttribute("href"));

            Assert.assertTrue(biologyBookPage.verifyHyperLinkTagsAndParseTheURLOfTags(), assertFailurePreText + "Presence of hyperlinked words on the 1.17 concepts of biology book.");
            reportLog("Hyperlinked words terms are not there for the 1.17 concept of Biology book.");

            Assert.assertTrue(biologyBookPage.verifyTheVocabularyTermsOfBiologyBook(), assertFailurePreText + "Presence of vocabulary terms on the 1.17 concepts of biology book.");
            reportLog("Vocabulary terms on the 1.17 concept of Biology book.");

            Assert.assertTrue(biologyBookPage.verifyHTagsInBook(), assertFailurePreText + "Presence of Header tag on the 1.17 concepts of biology book.");
            reportLog("Presence of all Header tag on the 1.17 concept of Biology book.");

            Assert.assertTrue(biologyBookPage.verifyDidYouKnowSection(), assertFailurePreText + "Presence of Did you know section on the 1.17 concepts of biology book.");
            reportLog("Presence of all Did you know section on the 1.17 concept of Biology book.");

            for (int i = 0; i <= 8; i++) {
                scrollByPixel(500);
                basePage.waitForSec(4);
            }

            Assert.assertTrue(biologyBookPage.verifyTheImagesOfBiologyBook(), assertFailurePreText + "Presence of images on the 1.17 concepts of biology book.");
            reportLog("Presence of all images on the 1.17 concept of Biology book.");

            Assert.assertTrue(biologyBookPage.verifyTheVideosOfBiologyBook(), assertFailurePreText + "Presence of videos on the 1.17 concepts of biology book.");
            reportLog("Presence of all the videos on the 1.17 concept of Biology book.");


        } catch (Exception e) {
            result = handleException(e);
        }
        Assert.assertTrue(result, "Test script failed for" + currentMethodName + errorMessage);
    }

    @Test(priority = 18, description = "Verify the Content of 1.18 Enzyme Function concept of Biology book.")
    public void verifyContentOfEnzymeFunctionConcept() {
        boolean result = true;
        try {
            String url = "https://flexbooks.ck12.org/cbook/ck-12-biology-flexbook-2.0/section/1.18/primary/lesson/enzyme-function-bio/";
            webDriver.navigate().to(url);

            Assert.assertTrue(biologyBookPage.verifyModalityPageTitle("Enzyme Function"), assertFailurePreText + "Presence of title on the 1.18 concepts of biology book.");
            reportLog("Verified Modality title: " + webDriver.getTitle() + "on the 1.18 concept of Biology book.");

            reportLog("The Page Description is: " + biologyBookPage.pageDescription.getAttribute("content"));

            Assert.assertTrue(biologyBookPage.verifyCanonicalMetaTag(), assertFailurePreText + "Presence of canonical meta tag on the 1.18 concepts of biology book.");
            reportLog("Verified Canonical Tag and 1 Tag is found with URL: " + biologyBookPage.canonicalData.getAttribute("href"));

            Assert.assertTrue(biologyBookPage.verifyHyperLinkTagsAndParseTheURLOfTags(), assertFailurePreText + "Presence of hyperlinked words on the 1.18 concepts of biology book.");
            reportLog("Hyperlinked words terms are not there for the 1.18 concept of Biology book.");

            Assert.assertTrue(biologyBookPage.verifyTheVocabularyTermsOfBiologyBook(), assertFailurePreText + "Presence of vocabulary terms on the 1.18 concepts of biology book.");
            reportLog("Vocabulary terms are not there for the 1.18 concept of Biology book.");

            Assert.assertTrue(biologyBookPage.verifyHTagsInBook(), assertFailurePreText + "Presence of Header tag on the 1.18 concepts of biology book.");
            reportLog("Presence of all Header tag on the 1.18 concept of Biology book.");

            Assert.assertTrue(biologyBookPage.verifyDidYouKnowSection(), assertFailurePreText + "Presence of Did you know section on the 1.18 concepts of biology book.");
            reportLog("Presence of all Did you know section on the 1.18 concept of Biology book.");

            for (int i = 0; i <= 8; i++) {
                scrollByPixel(500);
                basePage.waitForSec(4);
            }

            Assert.assertTrue(biologyBookPage.verifyTheImagesOfBiologyBook(), assertFailurePreText + "Presence of images on the 1.18 concepts of biology book.");
            reportLog("Presence of all images on the 1.18 concept of Biology book.");

            Assert.assertTrue(biologyBookPage.verifyTheVideosOfBiologyBook(), assertFailurePreText + "Presence of videos on the 1.18 concepts of biology book.");
            reportLog("Presence of all the videos on the 1.18 concept of Biology book.");


        } catch (Exception e) {
            result = handleException(e);
        }
        Assert.assertTrue(result, "Test script failed for" + currentMethodName + errorMessage);
    }

    @Test(priority = 19, description = "Verify the Content of 1.19 Water and Life of Biology book.")
    public void verifyContentOfWaterAndLifeConcept() {
        boolean result = true;
        try {
            String url = "https://flexbooks.ck12.org/cbook/ck-12-biology-flexbook-2.0/section/1.19/primary/lesson/water-and-life-bio/";
            webDriver.navigate().to(url);

            Assert.assertTrue(biologyBookPage.verifyModalityPageTitle("Water and Life"), assertFailurePreText + "Presence of title on the 1.19 concepts of biology book.");
            reportLog("Verified Modality title: " + webDriver.getTitle() + "on the 1.19 concept of Biology book.");

            reportLog("The Page Description is: " + biologyBookPage.pageDescription.getAttribute("content"));

            Assert.assertTrue(biologyBookPage.verifyCanonicalMetaTag(), assertFailurePreText + "Presence of canonical meta tag on the 1.19 concepts of biology book.");
            reportLog("Verified Canonical Tag and 1 Tag is found with URL: " + biologyBookPage.canonicalData.getAttribute("href"));

            Assert.assertTrue(biologyBookPage.verifyHyperLinkTagsAndParseTheURLOfTags(), assertFailurePreText + "Presence of hyperlinked words on the 1.19 concepts of biology book.");
            reportLog("Hyperlinked words terms are not there the 1.19 concept of Biology book.");

            Assert.assertTrue(biologyBookPage.verifyTheVocabularyTermsOfBiologyBook(), assertFailurePreText + "Presence of vocabulary terms on the 1.19 concepts of biology book.");
            reportLog("Vocabulary terms are not there fop the 1.19 concept of Biology book.");

            Assert.assertTrue(biologyBookPage.verifyHTagsInBook(), assertFailurePreText + "Presence of Header tag on the 1.19 concepts of biology book.");
            reportLog("Presence of all Header tag on the 1.19 concept of Biology book.");

            Assert.assertTrue(biologyBookPage.verifyDidYouKnowSection(), assertFailurePreText + "Presence of Did you know section on the 1.19 concepts of biology book.");
            reportLog("Presence of all Did you know section on the 1.19 concept of Biology book.");

            for (int i = 0; i <= 8; i++) {
                scrollByPixel(500);
                basePage.waitForSec(4);
            }

            Assert.assertTrue(biologyBookPage.verifyTheImagesOfBiologyBook(), assertFailurePreText + "Presence of images on the 1.19 concepts of biology book.");
            reportLog("Presence of all images on the 1.19 concept of Biology book.");

            Assert.assertTrue(biologyBookPage.verifyTheVideosOfBiologyBook(), assertFailurePreText + "Presence of videos on the 1.19 concepts of biology book.");
            reportLog("Presence of all the videos on the 1.19 concept of Biology book.");


        } catch (Exception e) {
            result = handleException(e);
        }
        Assert.assertTrue(result, "Test script failed for" + currentMethodName + errorMessage);
    }

    @Test(priority = 20, description = "Verify the Content of 1.20 Types of Acids and Bases concept of Biology book.")
    public void verifyContentOfAcidsAndBasesConcept() {
        boolean result = true;
        try {
            String url = "https://flexbooks.ck12.org/cbook/ck-12-biology-flexbook-2.0/section/1.20/primary/lesson/acids-and-bases-in-biology-bio/";
            webDriver.navigate().to(url);

            Assert.assertTrue(biologyBookPage.verifyModalityPageTitle("Acids and Bases"), assertFailurePreText + "Presence of title on the 1.20 concepts of biology book.");
            reportLog("Verified Modality title: " + webDriver.getTitle() + "on the 1.20 concept of Biology book.");

            reportLog("The Page Description is: " + biologyBookPage.pageDescription.getAttribute("content"));

            Assert.assertTrue(biologyBookPage.verifyCanonicalMetaTag(), assertFailurePreText + "Presence of canonical meta tag on the 1.20 concepts of biology book.");
            reportLog("Verified Canonical Tag and 1 Tag is found with URL: " + biologyBookPage.canonicalData.getAttribute("href"));

            Assert.assertTrue(biologyBookPage.verifyHyperLinkTagsAndParseTheURLOfTags(), assertFailurePreText + "Presence of hyperlinked words on the 1.20 concepts of biology book.");
            reportLog("Presence of all the hyperlinked words terms on the 1.20 concept of Biology book.");

            Assert.assertTrue(biologyBookPage.verifyTheVocabularyTermsOfBiologyBook(), assertFailurePreText + "Presence of vocabulary terms on the 1.20 concepts of biology book.");
            reportLog("Presence of all the vocabulary terms on the 1.20 concept of Biology book.");

            Assert.assertTrue(biologyBookPage.verifyHTagsInBook(), assertFailurePreText + "Presence of Header tag on the 1.20 concepts of biology book.");
            reportLog("Presence of all Header tag on the 1.20 concept of Biology book.");

            Assert.assertTrue(biologyBookPage.verifyDidYouKnowSection(), assertFailurePreText + "Presence of Did you know section on the 1.20 concepts of biology book.");
            reportLog("Presence of all Did you know section on the 1.20 concept of Biology book.");

            for (int i = 0; i <= 8; i++) {
                scrollByPixel(500);
                basePage.waitForSec(4);
            }

            Assert.assertTrue(biologyBookPage.verifyTheImagesOfBiologyBook(), assertFailurePreText + "Presence of images on the 1.20 concepts of biology book.");
            reportLog("Presence of all images on the 1.20 concept of Biology book.");

            Assert.assertTrue(biologyBookPage.verifyTheVideosOfBiologyBook(), assertFailurePreText + "Presence of videos on the 1.20 concepts of biology book.");
            reportLog("Presence of all the videos on the 1.20 concept of Biology book.");

        } catch (Exception e) {
            result = handleException(e);
        }
        Assert.assertTrue(result, "Test script failed for" + currentMethodName + errorMessage);
    }
}