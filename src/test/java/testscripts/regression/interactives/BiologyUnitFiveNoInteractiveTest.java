package testscripts.regression.interactives;

import org.testng.Assert;
import org.testng.annotations.Test;
import testscripts.BaseTestScript;
import uipages.BasePage;
import uipages.flexbook2feature.LoginPage;
import uipages.flexbook2feature.TeacherDashboardPage;
import uipages.interactives.BiologyBookPage;

public class BiologyUnitFiveNoInteractiveTest extends BaseTestScript {
    private BiologyBookPage biologyBookPage;
    private BasePage basePage;

    @Test(priority = 1, dataProvider = "CK12DataProvider", description = "Verify the Content of 5.1 History of Life concept of Biology book.")
    public void verifyContentOfHistoryOfLifeConcept(String email, String password, String conceptScientificMethod) {
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

            Assert.assertTrue(biologyBookPage.verifyModalityPageTitle("History of Life"), assertFailurePreText + "Presence of title on the 5.1 concepts of biology book.");
            reportLog("Verified Modality title: " + webDriver.getTitle() + "on the 5.1 concept of Biology book.");

            reportLog("The Page Description is: " + biologyBookPage.pageDescription.getAttribute("content"));

            Assert.assertTrue(biologyBookPage.verifyCanonicalMetaTag(), assertFailurePreText + "Presence of canonical meta tag on the 5.1 concepts of biology book.");
            reportLog("Verified Canonical Tag and 1 Tag is found with URL: " + biologyBookPage.canonicalData.getAttribute("href"));

            Assert.assertTrue(biologyBookPage.verifyHyperLinkTagsAndParseTheURLOfTags(), assertFailurePreText + "Presence of hyperlinked words on the 5.1 concepts of biology book.");
            reportLog("Presence of all the hyperlinked words terms on the 5.1 concept of Biology book.");

            Assert.assertTrue(biologyBookPage.verifyTheVocabularyTermsOfBiologyBook(), assertFailurePreText + "Presence of vocabulary terms on the 5.1 concepts of biology book.");
            reportLog("Presence of all the vocabulary terms on the 5.1 concept of Biology book.");

            Assert.assertTrue(biologyBookPage.verifyHTagsInBook(), assertFailurePreText + "Presence of Header tag on the 5.1 concepts of biology book.");
            reportLog("Presence of all Header tag on the 5.1 concept of Biology book.");

            Assert.assertTrue(biologyBookPage.verifyDidYouKnowSection(), assertFailurePreText + "Presence of Did you know section on the 5.1 concepts of biology book.");
            reportLog("Presence of all Did you know section on the 5.1 concept of Biology book.");

            for (int i = 0; i <= 8; i++) {
                scrollByPixel(500);
                basePage.waitForSec(4);
            }

            Assert.assertTrue(biologyBookPage.verifyTheImagesOfBiologyBook(), assertFailurePreText + "Presence of images on the 5.1 concepts of biology book.");
            reportLog("Presence of all images on the 5.1 concept of Biology book.");

            Assert.assertTrue(biologyBookPage.verifyTheVideosOfBiologyBook(), assertFailurePreText + "Presence of videos on the 5.1 concepts of biology book.");
            reportLog("Presence of all the videos on the 5.1 concept of Biology book.");

        } catch (Exception e) {
            result = handleException(e);
        }
        Assert.assertTrue(result, "Test script failed for" + currentMethodName + errorMessage);
    }

    @Test(priority = 2, description = "Verify the Content of 5.2 Formation of Earth concept of Biology book.")
    public void verifyContentOfFormationOfEarthConcept() {
        boolean result = true;
        try {
            String url = "https://flexbooks.ck12.org/cbook/ck-12-biology-flexbook-2.0/section/5.2/primary/lesson/how-earth-formed-bio/";
            webDriver.navigate().to(url);

            Assert.assertTrue(biologyBookPage.verifyModalityPageTitle("Formation of Earth"), assertFailurePreText + "Presence of title on the 5.2 concepts of biology book.");
            reportLog("Verified Modality title: " + webDriver.getTitle() + "on the 5.2 concept of Biology book.");

            reportLog("The Page Description is: " + biologyBookPage.pageDescription.getAttribute("content"));

            Assert.assertTrue(biologyBookPage.verifyCanonicalMetaTag(), assertFailurePreText + "Presence of canonical meta tag on the 5.2 concepts of biology book.");
            reportLog("Verified Canonical Tag and 1 Tag is found with URL: " + biologyBookPage.canonicalData.getAttribute("href"));

            Assert.assertTrue(biologyBookPage.verifyHyperLinkTagsAndParseTheURLOfTags(), assertFailurePreText + "Presence of hyperlinked words on the 5.2 concepts of biology book.");
            reportLog("Presence of all the hyperlinked words terms on the 5.2 concept of Biology book.");

            Assert.assertTrue(biologyBookPage.verifyTheVocabularyTermsOfBiologyBook(), assertFailurePreText + "Presence of vocabulary terms on the 5.2 concepts of biology book.");
            reportLog("Presence of all the vocabulary terms on the 5.2 concept of Biology book.");

            Assert.assertTrue(biologyBookPage.verifyHTagsInBook(), assertFailurePreText + "Presence of Header tag on the 5.2 concepts of biology book.");
            reportLog("Presence of all Header tag on the 5.2 concept of Biology book.");

            Assert.assertTrue(biologyBookPage.verifyDidYouKnowSection(), assertFailurePreText + "Presence of Did you know section on the 5.2 concepts of biology book.");
            reportLog("Presence of all Did you know section on the 5.2 concept of Biology book.");

            for (int i = 0; i <= 8; i++) {
                scrollByPixel(500);
                basePage.waitForSec(4);
            }

            Assert.assertTrue(biologyBookPage.verifyTheImagesOfBiologyBook(), assertFailurePreText + "Presence of images on the 5.2 concepts of biology book.");
            reportLog("Presence of all images on the 5.2 concept of Biology book.");

            Assert.assertTrue(biologyBookPage.verifyTheVideosOfBiologyBook(), assertFailurePreText + "Presence of videos on the 5.2 concepts of biology book.");
            reportLog("Presence of all the videos on the 5.2 concept of Biology book.");

        } catch (Exception e) {
            result = handleException(e);
        }
        Assert.assertTrue(result, "Test script failed for" + currentMethodName + errorMessage);
    }

    @Test(priority = 3, description = "Verify the Content of 5.3 First Organic Molecules concept of Biology book.")
    public void verifyContentOfFirstOrganicMoleculesConcept() {
        boolean result = true;
        try {
            String url = "https://flexbooks.ck12.org/cbook/ck-12-biology-flexbook-2.0/section/5.3/primary/lesson/first-organic-molecules-bio/";
            webDriver.navigate().to(url);

            Assert.assertTrue(biologyBookPage.verifyModalityPageTitle("First Organic Molecules"), assertFailurePreText + "Presence of title on the 5.3 concepts of biology book.");
            reportLog("Verified Modality title: " + webDriver.getTitle() + "on the 5.3 concept of Biology book.");

            reportLog("The Page Description is: " + biologyBookPage.pageDescription.getAttribute("content"));

            Assert.assertTrue(biologyBookPage.verifyCanonicalMetaTag(), assertFailurePreText + "Presence of canonical meta tag on the 5.3 concepts of biology book.");
            reportLog("Verified Canonical Tag and 1 Tag is found with URL: " + biologyBookPage.canonicalData.getAttribute("href"));

            Assert.assertTrue(biologyBookPage.verifyHyperLinkTagsAndParseTheURLOfTags(), assertFailurePreText + "Presence of hyperlinked words on the 5.3 concepts of biology book.");
            reportLog("Presence of all the hyperlinked words terms on the 5.3 concept of Biology book.");

            Assert.assertTrue(biologyBookPage.verifyTheVocabularyTermsOfBiologyBook(), assertFailurePreText + "Presence of vocabulary terms on the 5.3 concepts of biology book.");
            reportLog("Presence of all the vocabulary terms on the 5.3 concept of Biology book.");

            Assert.assertTrue(biologyBookPage.verifyHTagsInBook(), assertFailurePreText + "Presence of Header tag on the 5.3 concepts of biology book.");
            reportLog("Presence of all Header tag on the 5.3 concept of Biology book.");

            Assert.assertTrue(biologyBookPage.verifyDidYouKnowSection(), assertFailurePreText + "Presence of Did you know section on the 5.3 concepts of biology book.");
            reportLog("Presence of all Did you know section on the 5.3 concept of Biology book.");

            for (int i = 0; i <= 8; i++) {
                scrollByPixel(500);
                basePage.waitForSec(4);
            }

            Assert.assertTrue(biologyBookPage.verifyTheImagesOfBiologyBook(), assertFailurePreText + "Presence of images on the 5.3 concepts of biology book.");
            reportLog("Presence of all images on the 5.3 concept of Biology book.");

            Assert.assertTrue(biologyBookPage.verifyTheVideosOfBiologyBook(), assertFailurePreText + "Presence of videos on the 5.3 concepts of biology book.");
            reportLog("Presence of all the videos on the 5.3 concept of Biology book.");


        } catch (Exception e) {
            result = handleException(e);
        }
        Assert.assertTrue(result, "Test script failed for" + currentMethodName + errorMessage);
    }

    @Test(priority = 4, description = "Verify the Content of 5.4 First Cell concept of Biology book.")
    public void verifyContentOfFirstCellConcept() {
        boolean result = true;
        try {
            String url = "https://flexbooks.ck12.org/cbook/ck-12-biology-flexbook-2.0/section/5.4/primary/lesson/first-cells-bio/";
            webDriver.navigate().to(url);

            Assert.assertTrue(biologyBookPage.verifyModalityPageTitle("First Cell"), assertFailurePreText + "Presence of title on the 5.4 concepts of biology book.");
            reportLog("Verified Modality title: " + webDriver.getTitle() + "on the 5.4 concept of Biology book.");

            reportLog("The Page Description is: " + biologyBookPage.pageDescription.getAttribute("content"));

            Assert.assertTrue(biologyBookPage.verifyCanonicalMetaTag(), assertFailurePreText + "Presence of canonical meta tag on the 5.4 concepts of biology book.");
            reportLog("Verified Canonical Tag and 1 Tag is found with URL: " + biologyBookPage.canonicalData.getAttribute("href"));

            Assert.assertTrue(biologyBookPage.verifyHyperLinkTagsAndParseTheURLOfTags(), assertFailurePreText + "Presence of hyperlinked words on the 5.4 concepts of biology book.");
            reportLog("Presence of all the hyperlinked words terms on the 5.4 concept of Biology book.");

            Assert.assertTrue(biologyBookPage.verifyTheVocabularyTermsOfBiologyBook(), assertFailurePreText + "Presence of vocabulary terms on the 5.4 concepts of biology book.");
            reportLog("Presence of all the vocabulary terms on the 5.4 concept of Biology book.");

            Assert.assertTrue(biologyBookPage.verifyHTagsInBook(), assertFailurePreText + "Presence of Header tag on the 5.4 concepts of biology book.");
            reportLog("Presence of all Header tag on the 5.4 concept of Biology book.");

            Assert.assertTrue(biologyBookPage.verifyDidYouKnowSection(), assertFailurePreText + "Presence of Did you know section on the 5.4 concepts of biology book.");
            reportLog("Presence of all Did you know section on the 5.4 concept of Biology book.");

            for (int i = 0; i <= 8; i++) {
                scrollByPixel(500);
                basePage.waitForSec(4);
            }

            Assert.assertTrue(biologyBookPage.verifyTheImagesOfBiologyBook(), assertFailurePreText + "Presence of images on the 5.4 concepts of biology book.");
            reportLog("Presence of all images on the 5.4 concept of Biology book.");

            Assert.assertTrue(biologyBookPage.verifyTheVideosOfBiologyBook(), assertFailurePreText + "Presence of videos on the 5.4 concepts of biology book.");
            reportLog("Presence of all the videos on the 5.4 concept of Biology book.");


        } catch (Exception e) {
            result = handleException(e);
        }
        Assert.assertTrue(result, "Test script failed for" + currentMethodName + errorMessage);
    }

    @Test(priority = 5, description = "Verify the Content of 5.5 Eukaryote Evolution concept of Biology book.")
    public void verifyContentOfEukaryoteEvolutionConcept() {
        boolean result = true;
        try {
            String url = "https://flexbooks.ck12.org/cbook/ck-12-biology-flexbook-2.0/section/5.5/primary/lesson/evolution-of-eukaryotes-bio/";
            webDriver.navigate().to(url);

            Assert.assertTrue(biologyBookPage.verifyModalityPageTitle("Eukaryote Evolution"), assertFailurePreText + "Presence of title on the 5.5 concepts of biology book.");
            reportLog("Verified Modality title: " + webDriver.getTitle() + "on the 5.5 concept of Biology book.");

            reportLog("The Page Description is: " + biologyBookPage.pageDescription.getAttribute("content"));

            Assert.assertTrue(biologyBookPage.verifyCanonicalMetaTag(), assertFailurePreText + "Presence of canonical meta tag on the 5.5 concepts of biology book.");
            reportLog("Verified Canonical Tag and 1 Tag is found with URL: " + biologyBookPage.canonicalData.getAttribute("href"));

            Assert.assertTrue(biologyBookPage.verifyHyperLinkTagsAndParseTheURLOfTags(), assertFailurePreText + "Presence of hyperlinked words on the 5.5 concepts of biology book.");
            reportLog("Presence of all the hyperlinked words terms on the 5.5 concept of Biology book.");

            Assert.assertTrue(biologyBookPage.verifyTheVocabularyTermsOfBiologyBook(), assertFailurePreText + "Presence of vocabulary terms on the 5.5 concepts of biology book.");
            reportLog("Presence of all the vocabulary terms on the 5.5 concept of Biology book.");

            Assert.assertTrue(biologyBookPage.verifyHTagsInBook(), assertFailurePreText + "Presence of Header tag on the 5.5 concepts of biology book.");
            reportLog("Presence of all Header tag on the 5.5 concept of Biology book.");

            Assert.assertTrue(biologyBookPage.verifyDidYouKnowSection(), assertFailurePreText + "Presence of Did you know section on the 5.5 concepts of biology book.");
            reportLog("Presence of all Did you know section on the 5.5 concept of Biology book.");

            for (int i = 0; i <= 8; i++) {
                scrollByPixel(500);
                basePage.waitForSec(4);
            }

            Assert.assertTrue(biologyBookPage.verifyTheImagesOfBiologyBook(), assertFailurePreText + "Presence of images on the 5.5 concepts of biology book.");
            reportLog("Presence of all images on the 5.5 concept of Biology book.");

            Assert.assertTrue(biologyBookPage.verifyTheVideosOfBiologyBook(), assertFailurePreText + "Presence of videos on the 5.5 concepts of biology book.");
            reportLog("Presence of all the videos on the 5.5 concept of Biology book.");


        } catch (Exception e) {
            result = handleException(e);
        }
        Assert.assertTrue(result, "Test script failed for" + currentMethodName + errorMessage);
    }

    @Test(priority = 6, description = "Verify the Content of 5.6 Late Precambrian concept of Biology book.")
    public void verifyContentOfLatePrecambrianConcept() {
        boolean result = true;
        try {
            String url = "https://flexbooks.ck12.org/cbook/ck-12-biology-flexbook-2.0/section/5.6/primary/lesson/late-precambrian-period-bio/";
            webDriver.navigate().to(url);

            Assert.assertTrue(biologyBookPage.verifyModalityPageTitle("Late Precambrian"), assertFailurePreText + "Presence of title on the 5.6 concepts of biology book.");
            reportLog("Verified Modality title: " + webDriver.getTitle() + "on the 5.6 concept of Biology book.");

            reportLog("The Page Description is: " + biologyBookPage.pageDescription.getAttribute("content"));

            Assert.assertTrue(biologyBookPage.verifyCanonicalMetaTag(), assertFailurePreText + "Presence of canonical meta tag on the 5.6 concepts of biology book.");
            reportLog("Verified Canonical Tag and 1 Tag is found with URL: " + biologyBookPage.canonicalData.getAttribute("href"));

            Assert.assertTrue(biologyBookPage.verifyHyperLinkTagsAndParseTheURLOfTags(), assertFailurePreText + "Presence of hyperlinked words on the 5.6 concepts of biology book.");
            reportLog("Presence of all the hyperlinked words terms on the 5.6 concept of Biology book.");

            Assert.assertTrue(biologyBookPage.verifyTheVocabularyTermsOfBiologyBook(), assertFailurePreText + "Presence of vocabulary terms on the 5.6 concepts of biology book.");
            reportLog("Presence of all the vocabulary terms on the 5.6 concept of Biology book.");

            Assert.assertTrue(biologyBookPage.verifyHTagsInBook(), assertFailurePreText + "Presence of Header tag on the 5.6 concepts of biology book.");
            reportLog("Presence of all Header tag on the 5.6 concept of Biology book.");

            Assert.assertTrue(biologyBookPage.verifyDidYouKnowSection(), assertFailurePreText + "Presence of Did you know section on the 5.6 concepts of biology book.");
            reportLog("Presence of all Did you know section on the 5.6 concept of Biology book.");

            for (int i = 0; i <= 8; i++) {
                scrollByPixel(500);
                basePage.waitForSec(4);
            }

            Assert.assertTrue(biologyBookPage.verifyTheImagesOfBiologyBook(), assertFailurePreText + "Presence of images on the 5.6 concepts of biology book.");
            reportLog("Presence of all images on the 5.6 concept of Biology book.");

            Assert.assertTrue(biologyBookPage.verifyTheVideosOfBiologyBook(), assertFailurePreText + "Presence of videos on the 5.6 concepts of biology book.");
            reportLog("Presence of all the videos on the 5.6 concept of Biology book.");

        } catch (Exception e) {
            result = handleException(e);
        }
        Assert.assertTrue(result, "Test script failed for" + currentMethodName + errorMessage);
    }

    @Test(priority = 7, description = "Verify the Content of 5.7 Paleozoic Era concept of Biology book.")
    public void verifyContentOfPaleozoicEraConcept() {
        boolean result = true;
        try {
            String url = "https://flexbooks.ck12.org/cbook/ck-12-biology-flexbook-2.0/section/5.7/primary/lesson/life-during-the-paleozoic-bio/";
            webDriver.navigate().to(url);

            Assert.assertTrue(biologyBookPage.verifyModalityPageTitle("Paleozoic Era"), assertFailurePreText + "Presence of title on the 5.7 concepts of biology book.");
            reportLog("Verified Modality title: " + webDriver.getTitle() + "on the 5.7 concept of Biology book.");

            reportLog("The Page Description is: " + biologyBookPage.pageDescription.getAttribute("content"));

            Assert.assertTrue(biologyBookPage.verifyCanonicalMetaTag(), assertFailurePreText + "Presence of canonical meta tag on the 5.7 concepts of biology book.");
            reportLog("Verified Canonical Tag and 1 Tag is found with URL: " + biologyBookPage.canonicalData.getAttribute("href"));

            Assert.assertTrue(biologyBookPage.verifyHyperLinkTagsAndParseTheURLOfTags(), assertFailurePreText + "Presence of hyperlinked words on the 5.7 concepts of biology book.");
            reportLog("Presence of all the hyperlinked words terms on the 5.7 concept of Biology book.");

            Assert.assertTrue(biologyBookPage.verifyTheVocabularyTermsOfBiologyBook(), assertFailurePreText + "Presence of vocabulary terms on the 5.7 concepts of biology book.");
            reportLog("Presence of all the vocabulary terms on the 5.7 concept of Biology book.");

            Assert.assertTrue(biologyBookPage.verifyHTagsInBook(), assertFailurePreText + "Presence of Header tag on the 5.7 concepts of biology book.");
            reportLog("Presence of all Header tag on the 5.7 concept of Biology book.");

            Assert.assertTrue(biologyBookPage.verifyDidYouKnowSection(), assertFailurePreText + "Presence of Did you know section on the 5.7 concepts of biology book.");
            reportLog("Presence of all Did you know section on the 5.7 concept of Biology book.");

            for (int i = 0; i <= 8; i++) {
                scrollByPixel(500);
                basePage.waitForSec(4);
            }

            Assert.assertTrue(biologyBookPage.verifyTheImagesOfBiologyBook(), assertFailurePreText + "Presence of images on the 5.7 concepts of biology book.");
            reportLog("Presence of all images on the 5.7 concept of Biology book.");

            Assert.assertTrue(biologyBookPage.verifyTheVideosOfBiologyBook(), assertFailurePreText + "Presence of videos on the 5.7 concepts of biology book.");
            reportLog("Presence of all the videos on the 5.7 concept of Biology book.");

        } catch (Exception e) {
            result = handleException(e);
        }
        Assert.assertTrue(result, "Test script failed for" + currentMethodName + errorMessage);
    }

    @Test(priority = 8, description = "Verify the Content of 5.8 Mesozoic Era concept of Biology book.")
    public void verifyContentOfMesozoicEraConcept() {
        boolean result = true;
        try {
            String url = "https://flexbooks.ck12.org/cbook/ck-12-biology-flexbook-2.0/section/5.8/primary/lesson/mesozoic-era-the-age-of-dinosaurs-bio/";
            webDriver.navigate().to(url);

            Assert.assertTrue(biologyBookPage.verifyModalityPageTitle("Mesozoic Era"), assertFailurePreText + "Presence of title on the 5.8 concepts of biology book.");
            reportLog("Verified Modality title: " + webDriver.getTitle() + "on the 5.8 concept of Biology book.");

            reportLog("The Page Description is: " + biologyBookPage.pageDescription.getAttribute("content"));

            Assert.assertTrue(biologyBookPage.verifyCanonicalMetaTag(), assertFailurePreText + "Presence of canonical meta tag on the 5.8 concepts of biology book.");
            reportLog("Verified Canonical Tag and 1 Tag is found with URL: " + biologyBookPage.canonicalData.getAttribute("href"));

            Assert.assertTrue(biologyBookPage.verifyHyperLinkTagsAndParseTheURLOfTags(), assertFailurePreText + "Presence of hyperlinked words on the 5.8 concepts of biology book.");
            reportLog("Presence of all the hyperlinked words terms on the 5.8 concept of Biology book.");

            Assert.assertTrue(biologyBookPage.verifyTheVocabularyTermsOfBiologyBook(), assertFailurePreText + "Presence of vocabulary terms on the 5.8 concepts of biology book.");
            reportLog("Presence of all the vocabulary terms on the 5.8 concept of Biology book.");

            Assert.assertTrue(biologyBookPage.verifyHTagsInBook(), assertFailurePreText + "Presence of Header tag on the 5.8 concepts of biology book.");
            reportLog("Presence of all Header tag on the 5.8 concept of Biology book.");

            Assert.assertTrue(biologyBookPage.verifyDidYouKnowSection(), assertFailurePreText + "Presence of Did you know section on the 5.8 concepts of biology book.");
            reportLog("Presence of all Did you know section on the 5.8 concept of Biology book.");

            for (int i = 0; i <= 8; i++) {
                scrollByPixel(500);
                basePage.waitForSec(4);
            }

            Assert.assertTrue(biologyBookPage.verifyTheImagesOfBiologyBook(), assertFailurePreText + "Presence of images on the 5.8 concepts of biology book.");
            reportLog("Presence of all images on the 5.8 concept of Biology book.");

            Assert.assertTrue(biologyBookPage.verifyTheVideosOfBiologyBook(), assertFailurePreText + "Presence of videos on the 5.8 concepts of biology book.");
            reportLog("Presence of all the videos on the 5.8 concept of Biology book.");

        } catch (Exception e) {
            result = handleException(e);
        }
        Assert.assertTrue(result, "Test script failed for" + currentMethodName + errorMessage);
    }

    @Test(priority = 9, description = "Verify the Content of 5.9 Cenozoic Era concept of Biology book.")
    public void verifyContentOfCenozoicEraConcept() {
        boolean result = true;
        try {
            String url = "https://flexbooks.ck12.org/cbook/ck-12-biology-flexbook-2.0/section/5.9/primary/lesson/cenozoic-era-the-age-of-mammals-bio/";
            webDriver.navigate().to(url);

            Assert.assertTrue(biologyBookPage.verifyModalityPageTitle("Cenozoic Era"), assertFailurePreText + "Presence of title on the 5.9 concepts of biology book.");
            reportLog("Verified Modality title: " + webDriver.getTitle() + "on the 5.9 concept of Biology book.");

            reportLog("The Page Description is: " + biologyBookPage.pageDescription.getAttribute("content"));

            Assert.assertTrue(biologyBookPage.verifyCanonicalMetaTag(), assertFailurePreText + "Presence of canonical meta tag on the 5.9 concepts of biology book.");
            reportLog("Verified Canonical Tag and 1 Tag is found with URL: " + biologyBookPage.canonicalData.getAttribute("href"));

            Assert.assertTrue(biologyBookPage.verifyHyperLinkTagsAndParseTheURLOfTags(), assertFailurePreText + "Presence of hyperlinked words on the 5.9 concepts of biology book.");
            reportLog("Presence of all the hyperlinked words terms on the 5.9 concept of Biology book.");

            Assert.assertTrue(biologyBookPage.verifyTheVocabularyTermsOfBiologyBook(), assertFailurePreText + "Presence of vocabulary terms on the 5.9 concepts of biology book.");
            reportLog("Presence of all the vocabulary terms on the 5.9 concept of Biology book.");

            Assert.assertTrue(biologyBookPage.verifyHTagsInBook(), assertFailurePreText + "Presence of Header tag on the 5.9 concepts of biology book.");
            reportLog("Presence of all Header tag on the 5.9 concept of Biology book.");

            Assert.assertTrue(biologyBookPage.verifyDidYouKnowSection(), assertFailurePreText + "Presence of Did you know section on the 5.9 concepts of biology book.");
            reportLog("Presence of all Did you know section on the 5.9 concept of Biology book.");

            for (int i = 0; i <= 8; i++) {
                scrollByPixel(500);
                basePage.waitForSec(4);
            }

            Assert.assertTrue(biologyBookPage.verifyTheImagesOfBiologyBook(), assertFailurePreText + "Presence of images on the 5.9 concepts of biology book.");
            reportLog("Presence of all images on the 5.9 concept of Biology book.");

            Assert.assertTrue(biologyBookPage.verifyTheVideosOfBiologyBook(), assertFailurePreText + "Presence of videos on the 5.9 concepts of biology book.");
            reportLog("Presence of all the videos on the 5.9 concept of Biology book.");


        } catch (Exception e) {
            result = handleException(e);
        }
        Assert.assertTrue(result, "Test script failed for" + currentMethodName + errorMessage);
    }

    @Test(priority = 10, description = "Verify the Content of 5.10 Classification concept of Biology book.")
    public void verifyContentOfClassificationConcept() {
        boolean result = true;
        try {
            String url = "https://flexbooks.ck12.org/cbook/ck-12-biology-flexbook-2.0/section/5.10/primary/lesson/linnaean-classification-bio/";
            webDriver.navigate().to(url);

            Assert.assertTrue(biologyBookPage.verifyModalityPageTitle("Classification"), assertFailurePreText + "Presence of title on the 5.10 concepts of biology book.");
            reportLog("Verified Modality title: " + webDriver.getTitle() + "on the 5.10 concept of Biology book.");

            reportLog("The Page Description is: " + biologyBookPage.pageDescription.getAttribute("content"));

            Assert.assertTrue(biologyBookPage.verifyCanonicalMetaTag(), assertFailurePreText + "Presence of canonical meta tag on the 5.10 concepts of biology book.");
            reportLog("Verified Canonical Tag and 1 Tag is found with URL: " + biologyBookPage.canonicalData.getAttribute("href"));

            Assert.assertTrue(biologyBookPage.verifyHyperLinkTagsAndParseTheURLOfTags(), assertFailurePreText + "Presence of hyperlinked words on the 5.10 concepts of biology book.");
            reportLog("Presence of all the hyperlinked words terms on the 5.10 concept of Biology book.");

            Assert.assertTrue(biologyBookPage.verifyTheVocabularyTermsOfBiologyBook(), assertFailurePreText + "Presence of vocabulary terms on the 5.10 concepts of biology book.");
            reportLog("Presence of all the vocabulary terms on the 5.10 concept of Biology book.");

            Assert.assertTrue(biologyBookPage.verifyHTagsInBook(), assertFailurePreText + "Presence of Header tag on the 5.10 concepts of biology book.");
            reportLog("Presence of all Header tag on the 5.10 concept of Biology book.");

            Assert.assertTrue(biologyBookPage.verifyDidYouKnowSection(), assertFailurePreText + "Presence of Did you know section on the 5.10 concepts of biology book.");
            reportLog("Presence of all Did you know section on the 5.10 concept of Biology book.");

            for (int i = 0; i <= 8; i++) {
                scrollByPixel(500);
                basePage.waitForSec(4);
            }

            Assert.assertTrue(biologyBookPage.verifyTheImagesOfBiologyBook(), assertFailurePreText + "Presence of images on the 5.10 concepts of biology book.");
            reportLog("Presence of all images on the 5.10 concept of Biology book.");

            Assert.assertTrue(biologyBookPage.verifyTheVideosOfBiologyBook(), assertFailurePreText + "Presence of videos on the 5.10 concepts of biology book.");
            reportLog("Presence of all the videos on the 5.10 concept of Biology book.");


        } catch (Exception e) {
            result = handleException(e);
        }
        Assert.assertTrue(result, "Test script failed for" + currentMethodName + errorMessage);
    }

    @Test(priority = 11, description = "Verify the Content of 5.11 Phylogeny and Cladistics concept of Biology book.")
    public void verifyContentOfPhylogenyAndCladisticsConcept() {
        boolean result = true;
        try {
            String url = "https://flexbooks.ck12.org/cbook/ck-12-biology-flexbook-2.0/section/5.11/primary/lesson/phylogenetic-classification-bio/";
            webDriver.navigate().to(url);

            Assert.assertTrue(biologyBookPage.verifyModalityPageTitle("Phylogeny and Cladistics"), assertFailurePreText + "Presence of title on the 5.11 concepts of biology book.");
            reportLog("Verified Modality title: " + webDriver.getTitle() + "on the 5.11 concept of Biology book.");

            reportLog("The Page Description is: " + biologyBookPage.pageDescription.getAttribute("content"));

            Assert.assertTrue(biologyBookPage.verifyCanonicalMetaTag(), assertFailurePreText + "Presence of canonical meta tag on the 5.11 concepts of biology book.");
            reportLog("Verified Canonical Tag and 1 Tag is found with URL: " + biologyBookPage.canonicalData.getAttribute("href"));

            Assert.assertTrue(biologyBookPage.verifyHyperLinkTagsAndParseTheURLOfTags(), assertFailurePreText + "Presence of hyperlinked words on the 5.11 concepts of biology book.");
            reportLog("Presence of all the hyperlinked words terms on the 5.11 concept of Biology book.");

            Assert.assertTrue(biologyBookPage.verifyTheVocabularyTermsOfBiologyBook(), assertFailurePreText + "Presence of vocabulary terms on the 5.11 concepts of biology book.");
            reportLog("Presence of all the vocabulary terms on the 5.11 concept of Biology book.");

            Assert.assertTrue(biologyBookPage.verifyHTagsInBook(), assertFailurePreText + "Presence of Header tag on the 5.11 concepts of biology book.");
            reportLog("Presence of all Header tag on the 5.11 concept of Biology book.");

            Assert.assertTrue(biologyBookPage.verifyDidYouKnowSection(), assertFailurePreText + "Presence of Did you know section on the 5.11 concepts of biology book.");
            reportLog("Presence of all Did you know section on the 5.11 concept of Biology book.");

            for (int i = 0; i <= 8; i++) {
                scrollByPixel(500);
                basePage.waitForSec(4);
            }

            Assert.assertTrue(biologyBookPage.verifyTheImagesOfBiologyBook(), assertFailurePreText + "Presence of images on the 5.11 concepts of biology book.");
            reportLog("Presence of all images on the 5.11 concept of Biology book.");

            Assert.assertTrue(biologyBookPage.verifyTheVideosOfBiologyBook(), assertFailurePreText + "Presence of videos on the 5.11 concepts of biology book.");
            reportLog("Presence of all the videos on the 5.11 concept of Biology book.");


        } catch (Exception e) {
            result = handleException(e);
        }
        Assert.assertTrue(result, "Test script failed for" + currentMethodName + errorMessage);
    }

    @Test(priority = 12, description = "Verify the Content of 5.12 Darwin concept of Biology book.")
    public void verifyContentOfDarwinConcept() {
        boolean result = true;
        try {
            String url = "https://flexbooks.ck12.org/cbook/ck-12-biology-flexbook-2.0/section/5.12/primary/lesson/darwins-voyage-of-the-beagle-bio/";
            webDriver.navigate().to(url);

            Assert.assertTrue(biologyBookPage.verifyModalityPageTitle("Darwin"), assertFailurePreText + "Presence of title on the 5.12 concepts of biology book.");
            reportLog("Verified Modality title: " + webDriver.getTitle() + "on the 5.12 concept of Biology book.");

            reportLog("The Page Description is: " + biologyBookPage.pageDescription.getAttribute("content"));

            Assert.assertTrue(biologyBookPage.verifyCanonicalMetaTag(), assertFailurePreText + "Presence of canonical meta tag on the 5.12 concepts of biology book.");
            reportLog("Verified Canonical Tag and 1 Tag is found with URL: " + biologyBookPage.canonicalData.getAttribute("href"));

            Assert.assertTrue(biologyBookPage.verifyHyperLinkTagsAndParseTheURLOfTags(), assertFailurePreText + "Presence of hyperlinked words on the 5.12 concepts of biology book.");
            reportLog("Presence of all the hyperlinked words terms on the 5.12 concept of Biology book.");

            Assert.assertTrue(biologyBookPage.verifyTheVocabularyTermsOfBiologyBook(), assertFailurePreText + "Presence of vocabulary terms on the 5.12 concepts of biology book.");
            reportLog("Presence of all the vocabulary terms on the 5.12 concept of Biology book.");

            Assert.assertTrue(biologyBookPage.verifyHTagsInBook(), assertFailurePreText + "Presence of Header tag on the 5.12 concepts of biology book.");
            reportLog("Presence of all Header tag on the 5.12 concept of Biology book.");

            Assert.assertTrue(biologyBookPage.verifyDidYouKnowSection(), assertFailurePreText + "Presence of Did you know section on the 5.12 concepts of biology book.");
            reportLog("Presence of all Did you know section on the 5.12 concept of Biology book.");

            for (int i = 0; i <= 8; i++) {
                scrollByPixel(500);
                basePage.waitForSec(4);
            }

            Assert.assertTrue(biologyBookPage.verifyTheImagesOfBiologyBook(), assertFailurePreText + "Presence of images on the 5.12 concepts of biology book.");
            reportLog("Presence of all images on the 5.12 concept of Biology book.");

            Assert.assertTrue(biologyBookPage.verifyTheVideosOfBiologyBook(), assertFailurePreText + "Presence of videos on the 5.12 concepts of biology book.");
            reportLog("Presence of all the videos on the 5.12 concept of Biology book.");


        } catch (Exception e) {
            result = handleException(e);
        }
        Assert.assertTrue(result, "Test script failed for" + currentMethodName + errorMessage);
    }

    @Test(priority = 13, description = "Verify the Content of 5.13 Influences on Darwin concept of Biology book.")
    public void verifyContentOfInfluencesOnDarwinConcept() {
        boolean result = true;
        try {
            String url = "https://flexbooks.ck12.org/cbook/ck-12-biology-flexbook-2.0/section/5.13/primary/lesson/influences-on-darwin-bio/";
            webDriver.navigate().to(url);

            Assert.assertTrue(biologyBookPage.verifyModalityPageTitle("Influences on Darwin"), assertFailurePreText + "Presence of title on the 5.13 concepts of biology book.");
            reportLog("Verified Modality title: " + webDriver.getTitle() + "on the 5.13 concept of Biology book.");

            reportLog("The Page Description is: " + biologyBookPage.pageDescription.getAttribute("content"));

            Assert.assertTrue(biologyBookPage.verifyCanonicalMetaTag(), assertFailurePreText + "Presence of canonical meta tag on the 5.13 concepts of biology book.");
            reportLog("Verified Canonical Tag and 1 Tag is found with URL: " + biologyBookPage.canonicalData.getAttribute("href"));

            Assert.assertTrue(biologyBookPage.verifyHyperLinkTagsAndParseTheURLOfTags(), assertFailurePreText + "Presence of hyperlinked words on the 5.13 concepts of biology book.");
            reportLog("Presence of all the hyperlinked words terms on the 5.13 concept of Biology book.");

            Assert.assertTrue(biologyBookPage.verifyTheVocabularyTermsOfBiologyBook(), assertFailurePreText + "Presence of vocabulary terms on the 5.13 concepts of biology book.");
            reportLog("Presence of all the vocabulary terms on the 5.13 concept of Biology book.");

            Assert.assertTrue(biologyBookPage.verifyHTagsInBook(), assertFailurePreText + "Presence of Header tag on the 5.13 concepts of biology book.");
            reportLog("Presence of all Header tag on the 5.13 concept of Biology book.");

            Assert.assertTrue(biologyBookPage.verifyDidYouKnowSection(), assertFailurePreText + "Presence of Did you know section on the 5.13 concepts of biology book.");
            reportLog("Presence of all Did you know section on the 5.13 concept of Biology book.");

            for (int i = 0; i <= 8; i++) {
                scrollByPixel(500);
                basePage.waitForSec(4);
            }

            Assert.assertTrue(biologyBookPage.verifyTheImagesOfBiologyBook(), assertFailurePreText + "Presence of images on the 5.13 concepts of biology book.");
            reportLog("Presence of all images on the 5.13 concept of Biology book.");

            Assert.assertTrue(biologyBookPage.verifyTheVideosOfBiologyBook(), assertFailurePreText + "Presence of videos on the 5.13 concepts of biology book.");
            reportLog("Presence of all the videos on the 5.13 concept of Biology book.");


        } catch (Exception e) {
            result = handleException(e);
        }
        Assert.assertTrue(result, "Test script failed for" + currentMethodName + errorMessage);
    }

    @Test(priority = 14, description = "Verify the Content of 5.14 Theory of Evolution concept of Biology book.")
    public void verifyContentOfTheoryOfEvolutionConcept() {
        boolean result = true;
        try {
            String url = "https://flexbooks.ck12.org/cbook/ck-12-biology-flexbook-2.0/section/5.14/primary/lesson/theory-of-evolution-by-natural-selection-bio/";
            webDriver.navigate().to(url);

            Assert.assertTrue(biologyBookPage.verifyModalityPageTitle("Theory of Evolution"), assertFailurePreText + "Presence of title on the 5.14 concepts of biology book.");
            reportLog("Verified Modality title: " + webDriver.getTitle() + "on the 5.14 concept of Biology book.");

            reportLog("The Page Description is: " + biologyBookPage.pageDescription.getAttribute("content"));

            Assert.assertTrue(biologyBookPage.verifyCanonicalMetaTag(), assertFailurePreText + "Presence of canonical meta tag on the 5.14 concepts of biology book.");
            reportLog("Verified Canonical Tag and 1 Tag is found with URL: " + biologyBookPage.canonicalData.getAttribute("href"));

            Assert.assertTrue(biologyBookPage.verifyHyperLinkTagsAndParseTheURLOfTags(), assertFailurePreText + "Presence of hyperlinked words on the 5.14 concepts of biology book.");
            reportLog("Presence of all the hyperlinked words terms on the 5.14 concept of Biology book.");

            Assert.assertTrue(biologyBookPage.verifyTheVocabularyTermsOfBiologyBook(), assertFailurePreText + "Presence of vocabulary terms on the 5.14 concepts of biology book.");
            reportLog("Presence of all the vocabulary terms on the 5.14 concept of Biology book.");

            Assert.assertTrue(biologyBookPage.verifyHTagsInBook(), assertFailurePreText + "Presence of Header tag on the 5.14 concepts of biology book.");
            reportLog("Presence of all Header tag on the 5.14 concept of Biology book.");

            Assert.assertTrue(biologyBookPage.verifyDidYouKnowSection(), assertFailurePreText + "Presence of Did you know section on the 5.14 concepts of biology book.");
            reportLog("Presence of all Did you know section on the 5.14 concept of Biology book.");

            for (int i = 0; i <= 8; i++) {
                scrollByPixel(500);
                basePage.waitForSec(4);
            }

            Assert.assertTrue(biologyBookPage.verifyTheImagesOfBiologyBook(), assertFailurePreText + "Presence of images on the 5.14 concepts of biology book.");
            reportLog("Presence of all images on the 5.14 concept of Biology book.");

            Assert.assertTrue(biologyBookPage.verifyTheVideosOfBiologyBook(), assertFailurePreText + "Presence of videos on the 5.14 concepts of biology book.");
            reportLog("Presence of all the videos on the 5.14 concept of Biology book.");


        } catch (Exception e) {
            result = handleException(e);
        }
        Assert.assertTrue(result, "Test script failed for" + currentMethodName + errorMessage);
    }

    @Test(priority = 15, description = "Verify the Content of 5.15 Fossils concept of Biology book.")
    public void verifyContentOfFossilsConcept() {
        boolean result = true;
        try {
            String url = "https://flexbooks.ck12.org/cbook/ck-12-biology-flexbook-2.0/section/5.15/primary/lesson/fossils-bio/";
            webDriver.navigate().to(url);

            Assert.assertTrue(biologyBookPage.verifyModalityPageTitle("Fossils"), assertFailurePreText + "Presence of title on the 5.15 concepts of biology book.");
            reportLog("Verified Modality title: " + webDriver.getTitle() + "on the 5.15 concept of Biology book.");

            reportLog("The Page Description is: " + biologyBookPage.pageDescription.getAttribute("content"));

            Assert.assertTrue(biologyBookPage.verifyCanonicalMetaTag(), assertFailurePreText + "Presence of canonical meta tag on the 5.15 concepts of biology book.");
            reportLog("Verified Canonical Tag and 1 Tag is found with URL: " + biologyBookPage.canonicalData.getAttribute("href"));

            Assert.assertTrue(biologyBookPage.verifyHyperLinkTagsAndParseTheURLOfTags(), assertFailurePreText + "Presence of hyperlinked words on the 5.15 concepts of biology book.");
            reportLog("Presence of all the hyperlinked words terms on the 5.15 concept of Biology book.");

            Assert.assertTrue(biologyBookPage.verifyTheVocabularyTermsOfBiologyBook(), assertFailurePreText + "Presence of vocabulary terms on the 5.15 concepts of biology book.");
            reportLog("Presence of all the vocabulary terms on the 5.15 concept of Biology book.");

            Assert.assertTrue(biologyBookPage.verifyHTagsInBook(), assertFailurePreText + "Presence of Header tag on the 5.15 concepts of biology book.");
            reportLog("Presence of all Header tag on the 5.15 concept of Biology book.");

            Assert.assertTrue(biologyBookPage.verifyDidYouKnowSection(), assertFailurePreText + "Presence of Did you know section on the 5.15 concepts of biology book.");
            reportLog("Presence of all Did you know section on the 5.15 concept of Biology book.");

            for (int i = 0; i <= 8; i++) {
                scrollByPixel(500);
                basePage.waitForSec(4);
            }

            Assert.assertTrue(biologyBookPage.verifyTheImagesOfBiologyBook(), assertFailurePreText + "Presence of images on the 5.15 concepts of biology book.");
            reportLog("Presence of all images on the 5.15 concept of Biology book.");

            Assert.assertTrue(biologyBookPage.verifyTheVideosOfBiologyBook(), assertFailurePreText + "Presence of videos on the 5.15 concepts of biology book.");
            reportLog("Presence of all the videos on the 5.15 concept of Biology book.");


        } catch (Exception e) {
            result = handleException(e);
        }
        Assert.assertTrue(result, "Test script failed for" + currentMethodName + errorMessage);
    }

    @Test(priority = 17, description = "Verify the Content of 5.17 Biogeography concept of Biology book.")
    public void verifyContentOfBiogeographyConcept() {
        boolean result = true;
        try {
            String url = "https://flexbooks.ck12.org/cbook/ck-12-biology-flexbook-2.0/section/5.17/primary/lesson/biogeography-bio/";
            webDriver.navigate().to(url);

            Assert.assertTrue(biologyBookPage.verifyModalityPageTitle("Biogeography"), assertFailurePreText + "Presence of title on the 5.17 concepts of biology book.");
            reportLog("Verified Modality title: " + webDriver.getTitle() + "on the 5.17 concept of Biology book.");

            reportLog("The Page Description is: " + biologyBookPage.pageDescription.getAttribute("content"));

            Assert.assertTrue(biologyBookPage.verifyCanonicalMetaTag(), assertFailurePreText + "Presence of canonical meta tag on the 5.17 concepts of biology book.");
            reportLog("Verified Canonical Tag and 1 Tag is found with URL: " + biologyBookPage.canonicalData.getAttribute("href"));

            Assert.assertTrue(biologyBookPage.verifyHyperLinkTagsAndParseTheURLOfTags(), assertFailurePreText + "Presence of hyperlinked words on the 5.17 concepts of biology book.");
            reportLog("Presence of all the hyperlinked words terms on the 5.17 concept of Biology book.");

            Assert.assertTrue(biologyBookPage.verifyTheVocabularyTermsOfBiologyBook(), assertFailurePreText + "Presence of vocabulary terms on the 5.17 concepts of biology book.");
            reportLog("Presence of all the vocabulary terms on the 5.17 concept of Biology book.");

            Assert.assertTrue(biologyBookPage.verifyHTagsInBook(), assertFailurePreText + "Presence of Header tag on the 5.17 concepts of biology book.");
            reportLog("Presence of all Header tag on the 5.17 concept of Biology book.");

            Assert.assertTrue(biologyBookPage.verifyDidYouKnowSection(), assertFailurePreText + "Presence of Did you know section on the 5.17 concepts of biology book.");
            reportLog("Presence of all Did you know section on the 5.17 concept of Biology book.");

            for (int i = 0; i <= 8; i++) {
                scrollByPixel(500);
                basePage.waitForSec(4);
            }

            Assert.assertTrue(biologyBookPage.verifyTheImagesOfBiologyBook(), assertFailurePreText + "Presence of images on the 5.17 concepts of biology book.");
            reportLog("Presence of all images on the 5.17 concept of Biology book.");

            Assert.assertTrue(biologyBookPage.verifyTheVideosOfBiologyBook(), assertFailurePreText + "Presence of videos on the 5.17 concepts of biology book.");
            reportLog("Presence of all the videos on the 5.17 concept of Biology book.");


        } catch (Exception e) {
            result = handleException(e);
        }
        Assert.assertTrue(result, "Test script failed for" + currentMethodName + errorMessage);
    }

    @Test(priority = 18, description = "Verify the Content of 5.18 Population Genetics concept of Biology book.")
    public void verifyContentOfPopulationGeneticsConcept() {
        boolean result = true;
        try {
            String url = "https://flexbooks.ck12.org/cbook/ck-12-biology-flexbook-2.0/section/5.18/primary/lesson/population-genetics-bio/";
            webDriver.navigate().to(url);

            Assert.assertTrue(biologyBookPage.verifyModalityPageTitle("Population Genetics"), assertFailurePreText + "Presence of title on the 5.18 concepts of biology book.");
            reportLog("Verified Modality title: " + webDriver.getTitle() + "on the 5.18 concept of Biology book.");

            reportLog("The Page Description is: " + biologyBookPage.pageDescription.getAttribute("content"));

            Assert.assertTrue(biologyBookPage.verifyCanonicalMetaTag(), assertFailurePreText + "Presence of canonical meta tag on the 5.18 concepts of biology book.");
            reportLog("Verified Canonical Tag and 1 Tag is found with URL: " + biologyBookPage.canonicalData.getAttribute("href"));

            Assert.assertTrue(biologyBookPage.verifyHyperLinkTagsAndParseTheURLOfTags(), assertFailurePreText + "Presence of hyperlinked words on the 5.18 concepts of biology book.");
            reportLog("Presence of all the hyperlinked words terms on the 5.18 concept of Biology book.");

            Assert.assertTrue(biologyBookPage.verifyTheVocabularyTermsOfBiologyBook(), assertFailurePreText + "Presence of vocabulary terms on the 5.18 concepts of biology book.");
            reportLog("Presence of all the vocabulary terms on the 5.18 concept of Biology book.");

            Assert.assertTrue(biologyBookPage.verifyHTagsInBook(), assertFailurePreText + "Presence of Header tag on the 5.18 concepts of biology book.");
            reportLog("Presence of all Header tag on the 5.18 concept of Biology book.");

            Assert.assertTrue(biologyBookPage.verifyDidYouKnowSection(), assertFailurePreText + "Presence of Did you know section on the 5.18 concepts of biology book.");
            reportLog("Presence of all Did you know section on the 5.18 concept of Biology book.");

            for (int i = 0; i <= 8; i++) {
                scrollByPixel(500);
                basePage.waitForSec(4);
            }

            Assert.assertTrue(biologyBookPage.verifyTheImagesOfBiologyBook(), assertFailurePreText + "Presence of images on the 5.18 concepts of biology book.");
            reportLog("Presence of all images on the 5.18 concept of Biology book.");

            Assert.assertTrue(biologyBookPage.verifyTheVideosOfBiologyBook(), assertFailurePreText + "Presence of videos on the 5.18 concepts of biology book.");
            reportLog("Presence of all the videos on the 5.18 concept of Biology book.");


        } catch (Exception e) {
            result = handleException(e);
        }
        Assert.assertTrue(result, "Test script failed for" + currentMethodName + errorMessage);
    }

    @Test(priority = 19, description = "Verify the Content of 5.19 Hardy-Weinberg concept of Biology book.")
    public void verifyContentOfHardyWeinbergConcept() {
        boolean result = true;
        try {
            String url = "https://flexbooks.ck12.org/cbook/ck-12-biology-flexbook-2.0/section/5.19/primary/lesson/hardy-weinberg-theorem-bio/";
            webDriver.navigate().to(url);

            Assert.assertTrue(biologyBookPage.verifyModalityPageTitle("Hardy-Weinberg"), assertFailurePreText + "Presence of title on the 5.19 concepts of biology book.");
            reportLog("Verified Modality title: " + webDriver.getTitle() + "on the 5.19 concept of Biology book.");

            reportLog("The Page Description is: " + biologyBookPage.pageDescription.getAttribute("content"));

            Assert.assertTrue(biologyBookPage.verifyCanonicalMetaTag(), assertFailurePreText + "Presence of canonical meta tag on the 5.19 concepts of biology book.");
            reportLog("Verified Canonical Tag and 1 Tag is found with URL: " + biologyBookPage.canonicalData.getAttribute("href"));

            Assert.assertTrue(biologyBookPage.verifyHyperLinkTagsAndParseTheURLOfTags(), assertFailurePreText + "Presence of hyperlinked words on the 5.19 concepts of biology book.");
            reportLog("Presence of all the hyperlinked words terms on the 5.19 concept of Biology book.");

            Assert.assertTrue(biologyBookPage.verifyTheVocabularyTermsOfBiologyBook(), assertFailurePreText + "Presence of vocabulary terms on the 5.19 concepts of biology book.");
            reportLog("Presence of all the vocabulary terms on the 5.19 concept of Biology book.");

            Assert.assertTrue(biologyBookPage.verifyHTagsInBook(), assertFailurePreText + "Presence of Header tag on the 5.19 concepts of biology book.");
            reportLog("Presence of all Header tag on the 5.19 concept of Biology book.");

            Assert.assertTrue(biologyBookPage.verifyDidYouKnowSection(), assertFailurePreText + "Presence of Did you know section on the 5.19 concepts of biology book.");
            reportLog("Presence of all Did you know section on the 5.19 concept of Biology book.");

            for (int i = 0; i <= 8; i++) {
                scrollByPixel(500);
                basePage.waitForSec(4);
            }

            Assert.assertTrue(biologyBookPage.verifyTheImagesOfBiologyBook(), assertFailurePreText + "Presence of images on the 5.19 concepts of biology book.");
            reportLog("Presence of all images on the 5.19 concept of Biology book.");

            Assert.assertTrue(biologyBookPage.verifyTheVideosOfBiologyBook(), assertFailurePreText + "Presence of videos on the 5.19 concepts of biology book.");
            reportLog("Presence of all the videos on the 5.19 concept of Biology book.");


        } catch (Exception e) {
            result = handleException(e);
        }
        Assert.assertTrue(result, "Test script failed for" + currentMethodName + errorMessage);
    }

    @Test(priority = 20, description = "Verify the Content of 5.20 Forces of Evolution concept of Biology book.")
    public void verifyContentOfForcesOfEvolutionConcept() {
        boolean result = true;
        try {
            String url = "https://flexbooks.ck12.org/cbook/ck-12-biology-flexbook-2.0/section/5.20/primary/lesson/forces-of-evolution-bio/";
            webDriver.navigate().to(url);

            Assert.assertTrue(biologyBookPage.verifyModalityPageTitle("Forces of Evolution"), assertFailurePreText + "Presence of title on the 5.20 concepts of biology book.");
            reportLog("Verified Modality title: " + webDriver.getTitle() + "on the 5.20 concept of Biology book.");

            reportLog("The Page Description is: " + biologyBookPage.pageDescription.getAttribute("content"));

            Assert.assertTrue(biologyBookPage.verifyCanonicalMetaTag(), assertFailurePreText + "Presence of canonical meta tag on the 5.20 concepts of biology book.");
            reportLog("Verified Canonical Tag and 1 Tag is found with URL: " + biologyBookPage.canonicalData.getAttribute("href"));

            Assert.assertTrue(biologyBookPage.verifyHyperLinkTagsAndParseTheURLOfTags(), assertFailurePreText + "Presence of hyperlinked words on the 5.20 concepts of biology book.");
            reportLog("Presence of all the hyperlinked words terms on the 5.20 concept of Biology book.");

            Assert.assertTrue(biologyBookPage.verifyTheVocabularyTermsOfBiologyBook(), assertFailurePreText + "Presence of vocabulary terms on the 5.20 concepts of biology book.");
            reportLog("Presence of all the vocabulary terms on the 5.20 concept of Biology book.");

            Assert.assertTrue(biologyBookPage.verifyHTagsInBook(), assertFailurePreText + "Presence of Header tag on the 5.20 concepts of biology book.");
            reportLog("Presence of all Header tag on the 5.20 concept of Biology book.");

            Assert.assertTrue(biologyBookPage.verifyDidYouKnowSection(), assertFailurePreText + "Presence of Did you know section on the 5.20 concepts of biology book.");
            reportLog("Presence of all Did you know section on the 5.20 concept of Biology book.");

            for (int i = 0; i <= 8; i++) {
                scrollByPixel(500);
                basePage.waitForSec(4);
            }

            Assert.assertTrue(biologyBookPage.verifyTheImagesOfBiologyBook(), assertFailurePreText + "Presence of images on the 5.20 concepts of biology book.");
            reportLog("Presence of all images on the 5.20 concept of Biology book.");

            Assert.assertTrue(biologyBookPage.verifyTheVideosOfBiologyBook(), assertFailurePreText + "Presence of videos on the 5.20 concepts of biology book.");
            reportLog("Presence of all the videos on the 5.20 concept of Biology book.");


        } catch (Exception e) {
            result = handleException(e);
        }
        Assert.assertTrue(result, "Test script failed for" + currentMethodName + errorMessage);
    }

    @Test(priority = 21, description = "Verify the Content of 5.21 Natural Selection concept of Biology book.")
    public void verifyContentOfNaturalSelectionConcept() {
        boolean result = true;
        try {
            String url = "https://flexbooks.ck12.org/cbook/ck-12-biology-flexbook-2.0/section/5.21/primary/lesson/natural-selection-bio/";
            webDriver.navigate().to(url);

            Assert.assertTrue(biologyBookPage.verifyModalityPageTitle("Natural Selection"), assertFailurePreText + "Presence of title on the 5.21 concepts of biology book.");
            reportLog("Verified Modality title: " + webDriver.getTitle() + "on the 5.21 concept of Biology book.");

            reportLog("The Page Description is: " + biologyBookPage.pageDescription.getAttribute("content"));

            Assert.assertTrue(biologyBookPage.verifyCanonicalMetaTag(), assertFailurePreText + "Presence of canonical meta tag on the 5.21 concepts of biology book.");
            reportLog("Verified Canonical Tag and 1 Tag is found with URL: " + biologyBookPage.canonicalData.getAttribute("href"));

            Assert.assertTrue(biologyBookPage.verifyHyperLinkTagsAndParseTheURLOfTags(), assertFailurePreText + "Presence of hyperlinked words on the 5.21 concepts of biology book.");
            reportLog("Presence of all the hyperlinked words terms on the 5.21 concept of Biology book.");

            Assert.assertTrue(biologyBookPage.verifyTheVocabularyTermsOfBiologyBook(), assertFailurePreText + "Presence of vocabulary terms on the 5.21 concepts of biology book.");
            reportLog("Presence of all the vocabulary terms on the 5.21 concept of Biology book.");

            Assert.assertTrue(biologyBookPage.verifyHTagsInBook(), assertFailurePreText + "Presence of Header tag on the 5.21 concepts of biology book.");
            reportLog("Presence of all Header tag on the 5.21 concept of Biology book.");

            Assert.assertTrue(biologyBookPage.verifyDidYouKnowSection(), assertFailurePreText + "Presence of Did you know section on the 5.21 concepts of biology book.");
            reportLog("Presence of all Did you know section on the 5.21 concept of Biology book.");

            for (int i = 0; i <= 8; i++) {
                scrollByPixel(500);
                basePage.waitForSec(4);
            }

            Assert.assertTrue(biologyBookPage.verifyTheImagesOfBiologyBook(), assertFailurePreText + "Presence of images on the 5.21 concepts of biology book.");
            reportLog("Presence of all images on the 5.21 concept of Biology book.");

            Assert.assertTrue(biologyBookPage.verifyTheVideosOfBiologyBook(), assertFailurePreText + "Presence of videos on the 5.21 concepts of biology book.");
            reportLog("Presence of all the videos on the 5.21 concept of Biology book.");


        } catch (Exception e) {
            result = handleException(e);
        }
        Assert.assertTrue(result, "Test script failed for" + currentMethodName + errorMessage);
    }

    @Test(priority = 22, description = "Verify the Content of 5.22 Origin of Species concept of Biology book.")
    public void verifyContentOfOriginOfSpeciesConcept() {
        boolean result = true;
        try {
            String url = "https://flexbooks.ck12.org/cbook/ck-12-biology-flexbook-2.0/section/5.22/primary/lesson/origin-of-species-bio/";
            webDriver.navigate().to(url);

            Assert.assertTrue(biologyBookPage.verifyModalityPageTitle("Origin of Species"), assertFailurePreText + "Presence of title on the 5.22 concepts of biology book.");
            reportLog("Verified Modality title: " + webDriver.getTitle() + "on the 5.22 concept of Biology book.");

            reportLog("The Page Description is: " + biologyBookPage.pageDescription.getAttribute("content"));

            Assert.assertTrue(biologyBookPage.verifyCanonicalMetaTag(), assertFailurePreText + "Presence of canonical meta tag on the 5.22 concepts of biology book.");
            reportLog("Verified Canonical Tag and 1 Tag is found with URL: " + biologyBookPage.canonicalData.getAttribute("href"));

            Assert.assertTrue(biologyBookPage.verifyHyperLinkTagsAndParseTheURLOfTags(), assertFailurePreText + "Presence of hyperlinked words on the 5.22 concepts of biology book.");
            reportLog("Presence of all the hyperlinked words terms on the 5.22 concept of Biology book.");

            Assert.assertTrue(biologyBookPage.verifyTheVocabularyTermsOfBiologyBook(), assertFailurePreText + "Presence of vocabulary terms on the 5.22 concepts of biology book.");
            reportLog("Presence of all the vocabulary terms on the 5.22 concept of Biology book.");

            Assert.assertTrue(biologyBookPage.verifyHTagsInBook(), assertFailurePreText + "Presence of Header tag on the 5.22 concepts of biology book.");
            reportLog("Presence of all Header tag on the 5.22 concept of Biology book.");

            Assert.assertTrue(biologyBookPage.verifyDidYouKnowSection(), assertFailurePreText + "Presence of Did you know section on the 5.22 concepts of biology book.");
            reportLog("Presence of all Did you know section on the 5.22 concept of Biology book.");

            for (int i = 0; i <= 8; i++) {
                scrollByPixel(500);
                basePage.waitForSec(4);
            }

            Assert.assertTrue(biologyBookPage.verifyTheImagesOfBiologyBook(), assertFailurePreText + "Presence of images on the 5.22 concepts of biology book.");
            reportLog("Presence of all images on the 5.22 concept of Biology book.");

            Assert.assertTrue(biologyBookPage.verifyTheVideosOfBiologyBook(), assertFailurePreText + "Presence of videos on the 5.22 concepts of biology book.");
            reportLog("Presence of all the videos on the 5.22 concept of Biology book.");


        } catch (Exception e) {
            result = handleException(e);
        }
        Assert.assertTrue(result, "Test script failed for" + currentMethodName + errorMessage);
    }

    @Test(priority = 23, description = "Verify the Content of 5.23 Coevolution concept of Biology book.")
    public void verifyContentOfCoevolutionConcept() {
        boolean result = true;
        try {
            String url = "https://flexbooks.ck12.org/cbook/ck-12-biology-flexbook-2.0/section/5.23/primary/lesson/coevolution-bio/";
            webDriver.navigate().to(url);

            Assert.assertTrue(biologyBookPage.verifyModalityPageTitle("Coevolution"), assertFailurePreText + "Presence of title on the 5.23 concepts of biology book.");
            reportLog("Verified Modality title: " + webDriver.getTitle() + "on the 5.23 concept of Biology book.");

            reportLog("The Page Description is: " + biologyBookPage.pageDescription.getAttribute("content"));

            Assert.assertTrue(biologyBookPage.verifyCanonicalMetaTag(), assertFailurePreText + "Presence of canonical meta tag on the 5.23 concepts of biology book.");
            reportLog("Verified Canonical Tag and 1 Tag is found with URL: " + biologyBookPage.canonicalData.getAttribute("href"));

            Assert.assertTrue(biologyBookPage.verifyHyperLinkTagsAndParseTheURLOfTags(), assertFailurePreText + "Presence of hyperlinked words on the 5.23 concepts of biology book.");
            reportLog("Presence of all the hyperlinked words terms on the 5.23 concept of Biology book.");

            Assert.assertTrue(biologyBookPage.verifyTheVocabularyTermsOfBiologyBook(), assertFailurePreText + "Presence of vocabulary terms on the 5.23 concepts of biology book.");
            reportLog("Presence of all the vocabulary terms on the 5.23 concept of Biology book.");

            Assert.assertTrue(biologyBookPage.verifyHTagsInBook(), assertFailurePreText + "Presence of Header tag on the 5.23 concepts of biology book.");
            reportLog("Presence of all Header tag on the 5.23 concept of Biology book.");

            Assert.assertTrue(biologyBookPage.verifyDidYouKnowSection(), assertFailurePreText + "Presence of Did you know section on the 5.23 concepts of biology book.");
            reportLog("Presence of all Did you know section on the 5.23 concept of Biology book.");

            for (int i = 0; i <= 8; i++) {
                scrollByPixel(500);
                basePage.waitForSec(4);
            }

            Assert.assertTrue(biologyBookPage.verifyTheImagesOfBiologyBook(), assertFailurePreText + "Presence of images on the 5.23 concepts of biology book.");
            reportLog("Presence of all images on the 5.23 concept of Biology book.");

            Assert.assertTrue(biologyBookPage.verifyTheVideosOfBiologyBook(), assertFailurePreText + "Presence of videos on the 5.23 concepts of biology book.");
            reportLog("Presence of all the videos on the 5.23 concept of Biology book.");


        } catch (Exception e) {
            result = handleException(e);
        }
        Assert.assertTrue(result, "Test script failed for" + currentMethodName + errorMessage);
    }

    @Test(priority = 24, description = "Verify the Content of 5.24 Macroevolution concept of Biology book.")
    public void verifyContentOfMacroevolutionConcept() {
        boolean result = true;
        try {
            String url = "https://flexbooks.ck12.org/cbook/ck-12-biology-flexbook-2.0/section/5.24/primary/lesson/macroevolution-bio/";
            webDriver.navigate().to(url);

            Assert.assertTrue(biologyBookPage.verifyModalityPageTitle("Macroevolution"), assertFailurePreText + "Presence of title on the 5.24 concepts of biology book.");
            reportLog("Verified Modality title: " + webDriver.getTitle() + "on the 5.24 concept of Biology book.");

            reportLog("The Page Description is: " + biologyBookPage.pageDescription.getAttribute("content"));

            Assert.assertTrue(biologyBookPage.verifyCanonicalMetaTag(), assertFailurePreText + "Presence of canonical meta tag on the 5.24 concepts of biology book.");
            reportLog("Verified Canonical Tag and 1 Tag is found with URL: " + biologyBookPage.canonicalData.getAttribute("href"));

            Assert.assertTrue(biologyBookPage.verifyHyperLinkTagsAndParseTheURLOfTags(), assertFailurePreText + "Presence of hyperlinked words on the 5.24 concepts of biology book.");
            reportLog("Presence of all the hyperlinked words terms on the 5.24 concept of Biology book.");

            Assert.assertTrue(biologyBookPage.verifyTheVocabularyTermsOfBiologyBook(), assertFailurePreText + "Presence of vocabulary terms on the 5.24 concepts of biology book.");
            reportLog("Presence of all the vocabulary terms on the 5.24 concept of Biology book.");

            Assert.assertTrue(biologyBookPage.verifyHTagsInBook(), assertFailurePreText + "Presence of Header tag on the 5.24 concepts of biology book.");
            reportLog("Presence of all Header tag on the 5.24 concept of Biology book.");

            Assert.assertTrue(biologyBookPage.verifyDidYouKnowSection(), assertFailurePreText + "Presence of Did you know section on the 5.24 concepts of biology book.");
            reportLog("Presence of all Did you know section on the 5.24 concept of Biology book.");

            for (int i = 0; i <= 8; i++) {
                scrollByPixel(500);
                basePage.waitForSec(4);
            }

            Assert.assertTrue(biologyBookPage.verifyTheImagesOfBiologyBook(), assertFailurePreText + "Presence of images on the 5.24 concepts of biology book.");
            reportLog("Presence of all images on the 5.24 concept of Biology book.");

            Assert.assertTrue(biologyBookPage.verifyTheVideosOfBiologyBook(), assertFailurePreText + "Presence of videos on the 5.24 concepts of biology book.");
            reportLog("Presence of all the videos on the 5.24 concept of Biology book.");


        } catch (Exception e) {
            result = handleException(e);
        }
        Assert.assertTrue(result, "Test script failed for" + currentMethodName + errorMessage);
    }

    @Test(priority = 25, description = "Verify the Content of 5.25 Animal Evolution concept of Biology book.")
    public void verifyContentOfAnimalEvolutionConcept() {
        boolean result = true;
        try {
            String url = "https://flexbooks.ck12.org/cbook/ck-12-biology-flexbook-2.0/section/5.25/primary/lesson/animal-evolution-bio/";
            webDriver.navigate().to(url);

            Assert.assertTrue(biologyBookPage.verifyModalityPageTitle("Animal Evolution"), assertFailurePreText + "Presence of title on the 5.25 concepts of biology book.");
            reportLog("Verified Modality title: " + webDriver.getTitle() + "on the 5.25 concept of Biology book.");

            reportLog("The Page Description is: " + biologyBookPage.pageDescription.getAttribute("content"));

            Assert.assertTrue(biologyBookPage.verifyCanonicalMetaTag(), assertFailurePreText + "Presence of canonical meta tag on the 5.25 concepts of biology book.");
            reportLog("Verified Canonical Tag and 1 Tag is found with URL: " + biologyBookPage.canonicalData.getAttribute("href"));

            Assert.assertTrue(biologyBookPage.verifyHyperLinkTagsAndParseTheURLOfTags(), assertFailurePreText + "Presence of hyperlinked words on the 5.25 concepts of biology book.");
            reportLog("Presence of all the hyperlinked words terms on the 5.25 concept of Biology book.");

            Assert.assertTrue(biologyBookPage.verifyTheVocabularyTermsOfBiologyBook(), assertFailurePreText + "Presence of vocabulary terms on the 5.25 concepts of biology book.");
            reportLog("Presence of all the vocabulary terms on the 5.25 concept of Biology book.");

            Assert.assertTrue(biologyBookPage.verifyHTagsInBook(), assertFailurePreText + "Presence of Header tag on the 5.25 concepts of biology book.");
            reportLog("Presence of all Header tag on the 5.25 concept of Biology book.");

            Assert.assertTrue(biologyBookPage.verifyDidYouKnowSection(), assertFailurePreText + "Presence of Did you know section on the 5.25 concepts of biology book.");
            reportLog("Presence of all Did you know section on the 5.25 concept of Biology book.");

            for (int i = 0; i <= 8; i++) {
                scrollByPixel(500);
                basePage.waitForSec(4);
            }

            Assert.assertTrue(biologyBookPage.verifyTheImagesOfBiologyBook(), assertFailurePreText + "Presence of images on the 5.25 concepts of biology book.");
            reportLog("Presence of all images on the 5.25 concept of Biology book.");

            Assert.assertTrue(biologyBookPage.verifyTheVideosOfBiologyBook(), assertFailurePreText + "Presence of videos on the 5.25 concepts of biology book.");
            reportLog("Presence of all the videos on the 5.25 concept of Biology book.");


        } catch (Exception e) {
            result = handleException(e);
        }
        Assert.assertTrue(result, "Test script failed for" + currentMethodName + errorMessage);
    }
}
