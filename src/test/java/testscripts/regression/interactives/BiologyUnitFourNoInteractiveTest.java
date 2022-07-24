package testscripts.regression.interactives;

import org.testng.Assert;
import org.testng.annotations.Test;
import testscripts.BaseTestScript;
import uipages.BasePage;
import uipages.flexbook2feature.LoginPage;
import uipages.flexbook2feature.TeacherDashboardPage;
import uipages.interactives.BiologyBookPage;

public class BiologyUnitFourNoInteractiveTest extends BaseTestScript {
    private BiologyBookPage biologyBookPage;
    private BasePage basePage;

    @Test(priority = 1, dataProvider = "CK12DataProvider", description = "Verify the Content of 4.1 Central Dogma concept of Biology book.")
    public void verifyContentOfCentralDogmaConcept(String email, String password, String conceptScientificMethod) {
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

            Assert.assertTrue(biologyBookPage.verifyModalityPageTitle("Central Dogma"), assertFailurePreText + "Presence of title on the 4.1 concepts of biology book.");
            reportLog("Verified Modality title: " + webDriver.getTitle() + "on the 4.1 concept of Biology book.");

            reportLog("The Page Description is: " + biologyBookPage.pageDescription.getAttribute("content"));

            Assert.assertTrue(biologyBookPage.verifyCanonicalMetaTag(), assertFailurePreText + "Presence of canonical meta tag on the 4.1 concepts of biology book.");
            reportLog("Verified Canonical Tag and 1 Tag is found with URL: " + biologyBookPage.canonicalData.getAttribute("href"));

            Assert.assertTrue(biologyBookPage.verifyHyperLinkTagsAndParseTheURLOfTags(), assertFailurePreText + "Presence of hyperlinked words on the 4.1 concepts of biology book.");
            reportLog("Presence of all the hyperlinked words terms on the 4.1 concept of Biology book.");

            Assert.assertTrue(biologyBookPage.verifyTheVocabularyTermsOfBiologyBook(), assertFailurePreText + "Presence of vocabulary terms on the 4.1 concepts of biology book.");
            reportLog("Presence of all the vocabulary terms on the 4.1 concept of Biology book.");

            Assert.assertTrue(biologyBookPage.verifyHTagsInBook(), assertFailurePreText + "Presence of Header tag on the 4.1 concepts of biology book.");
            reportLog("Presence of all Header tag on the 4.1 concept of Biology book.");

            Assert.assertTrue(biologyBookPage.verifyDidYouKnowSection(), assertFailurePreText + "Presence of Did you know section on the 4.1 concepts of biology book.");
            reportLog("Presence of all Did you know section on the 4.1 concept of Biology book.");

            Assert.assertTrue(biologyBookPage.verifyTheImagesOfBiologyBook(), assertFailurePreText + "Presence of images on the 4.1 concepts of biology book.");
            reportLog("Presence of all images on the 4.1 concept of Biology book.");

            Assert.assertTrue(biologyBookPage.verifyTheVideosOfBiologyBook(), assertFailurePreText + "Presence of videos on the 4.1 concepts of biology book.");
            reportLog("Presence of all the videos on the 4.1 concept of Biology book.");

        } catch (Exception e) {
            result = handleException(e);
        }
        Assert.assertTrue(result, "Test script failed for" + currentMethodName + errorMessage);
    }

    @Test(priority = 2, description = "Verify the Content of 4.2 DNA concept of Biology book.")
    public void verifyContentOfDNAConcept() {
        boolean result = true;
        try {
            String url = "https://flexbooks.ck12.org/cbook/ck-12-biology-flexbook-2.0/section/4.2/primary/lesson/dna-the-genetic-material-bio/";
            webDriver.navigate().to(url);

            Assert.assertTrue(biologyBookPage.verifyModalityPageTitle("DNA"), assertFailurePreText + "Presence of title on the 4.2 concepts of biology book.");
            reportLog("Verified Modality title: " + webDriver.getTitle() + "on the 4.2 concept of Biology book.");

            reportLog("The Page Description is: " + biologyBookPage.pageDescription.getAttribute("content"));

            Assert.assertTrue(biologyBookPage.verifyCanonicalMetaTag(), assertFailurePreText + "Presence of canonical meta tag on the 4.2 concepts of biology book.");
            reportLog("Verified Canonical Tag and 1 Tag is found with URL: " + biologyBookPage.canonicalData.getAttribute("href"));

            Assert.assertTrue(biologyBookPage.verifyHyperLinkTagsAndParseTheURLOfTags(), assertFailurePreText + "Presence of hyperlinked words on the 4.2 concepts of biology book.");
            reportLog("Presence of all the hyperlinked words terms on the 4.2 concept of Biology book.");

            Assert.assertTrue(biologyBookPage.verifyTheVocabularyTermsOfBiologyBook(), assertFailurePreText + "Presence of vocabulary terms on the 4.2 concepts of biology book.");
            reportLog("Presence of all the vocabulary terms on the 4.2 concept of Biology book.");

            Assert.assertTrue(biologyBookPage.verifyHTagsInBook(), assertFailurePreText + "Presence of Header tag on the 4.2 concepts of biology book.");
            reportLog("Presence of all Header tag on the 4.2 concept of Biology book.");

            Assert.assertTrue(biologyBookPage.verifyDidYouKnowSection(), assertFailurePreText + "Presence of Did you know section on the 4.2 concepts of biology book.");
            reportLog("Presence of all Did you know section on the 4.2 concept of Biology book.");

            for (int i = 0; i <= 8; i++) {
                scrollByPixel(500);
                basePage.waitForSec(4);
            }

            Assert.assertTrue(biologyBookPage.verifyTheImagesOfBiologyBook(), assertFailurePreText + "Presence of images on the 4.2 concepts of biology book.");
            reportLog("Presence of all images on the 4.2 concept of Biology book.");

            Assert.assertTrue(biologyBookPage.verifyTheVideosOfBiologyBook(), assertFailurePreText + "Presence of videos on the 4.2 concepts of biology book.");
            reportLog("Presence of all the videos on the 4.2 concept of Biology book.");


        } catch (Exception e) {
            result = handleException(e);
        }
        Assert.assertTrue(result, "Test script failed for" + currentMethodName + errorMessage);
    }

    @Test(priority = 3, description = "Verify the Content of 4.3 DNA Structure and Replication.")
    public void verifyContentOfDNAStructureAndReplicaConcept() {
        boolean result = true;
        try {
            String url = "https://flexbooks.ck12.org/cbook/ck-12-biology-flexbook-2.0/section/4.3/primary/lesson/dna-structure-and-replication-bio/";
            webDriver.navigate().to(url);

            Assert.assertTrue(biologyBookPage.verifyModalityPageTitle("DNA Structure and Replication"), assertFailurePreText + "Presence of title on the 4.3 concepts of biology book.");
            reportLog("Verified Modality title: " + webDriver.getTitle() + "on the 4.3 concept of Biology book.");

            reportLog("The Page Description is: " + biologyBookPage.pageDescription.getAttribute("content"));

            Assert.assertTrue(biologyBookPage.verifyCanonicalMetaTag(), assertFailurePreText + "Presence of canonical meta tag on the 4.3 concepts of biology book.");
            reportLog("Verified Canonical Tag and 1 Tag is found with URL: " + biologyBookPage.canonicalData.getAttribute("href"));

            Assert.assertTrue(biologyBookPage.verifyHyperLinkTagsAndParseTheURLOfTags(), assertFailurePreText + "Presence of hyperlinked words on the 4.3 concepts of biology book.");
            reportLog("Hyperlinked words terms are not there for the 4.3 concept of Biology book.");

            Assert.assertTrue(biologyBookPage.verifyTheVocabularyTermsOfBiologyBook(), assertFailurePreText + "Presence of vocabulary terms on the 4.3 concepts of biology book.");
            reportLog("Vocabulary terms are not there for the 4.3 concept of Biology book.");

            Assert.assertTrue(biologyBookPage.verifyHTagsInBook(), assertFailurePreText + "Presence of Header tag on the 4.3 concepts of biology book.");
            reportLog("Presence of all Header tag on the 4.3 concept of Biology book.");

            Assert.assertTrue(biologyBookPage.verifyDidYouKnowSection(), assertFailurePreText + "Presence of Did you know section on the 4.3 concepts of biology book.");
            reportLog("Presence of all Did you know section on the 4.3 concept of Biology book.");

            for (int i = 0; i <= 8; i++) {
                scrollByPixel(500);
                basePage.waitForSec(4);
            }

            Assert.assertTrue(biologyBookPage.verifyTheImagesOfBiologyBook(), assertFailurePreText + "Presence of images on the 4.3 concepts of biology book.");
            reportLog("Presence of all images on the 4.3 concept of Biology book.");

            Assert.assertTrue(biologyBookPage.verifyTheVideosOfBiologyBook(), assertFailurePreText + "Presence of videos on the 4.3 concepts of biology book.");
            reportLog("Presence of all the videos on the 4.3 concept of Biology book.");
        } catch (Exception e) {
            result = handleException(e);
        }
        Assert.assertTrue(result, "Test script failed for" + currentMethodName + errorMessage);
    }

    @Test(priority = 4, description = "Verify the Content of 4.4 RNA.")
    public void verifyContentOfRNAConcept() {
        boolean result = true;
        try {
            String url = "https://flexbooks.ck12.org/cbook/ck-12-biology-flexbook-2.0/section/4.4/primary/lesson/rna-bio/";
            webDriver.navigate().to(url);

            Assert.assertTrue(biologyBookPage.verifyModalityPageTitle("RNA"), assertFailurePreText + "Presence of title on the 4.4 concepts of biology book.");
            reportLog("Verified Modality title: " + webDriver.getTitle() + "on the 4.4 concept of Biology book.");

            reportLog("The Page Description is: " + biologyBookPage.pageDescription.getAttribute("content"));

            Assert.assertTrue(biologyBookPage.verifyCanonicalMetaTag(), assertFailurePreText + "Presence of canonical meta tag on the 4.4 concepts of biology book.");
            reportLog("Verified Canonical Tag and 1 Tag is found with URL: " + biologyBookPage.canonicalData.getAttribute("href"));

            Assert.assertTrue(biologyBookPage.verifyHyperLinkTagsAndParseTheURLOfTags(), assertFailurePreText + "Presence of hyperlinked words on the 4.4 concepts of biology book.");
            reportLog("Hyperlinked words terms are not there for the 4.4 concept of Biology book.");

            Assert.assertTrue(biologyBookPage.verifyTheVocabularyTermsOfBiologyBook(), assertFailurePreText + "Presence of vocabulary terms on the 4.4 concepts of biology book.");
            reportLog("Vocabulary terms are not there for the 4.4 concept of Biology book.");

            Assert.assertTrue(biologyBookPage.verifyHTagsInBook(), assertFailurePreText + "Presence of Header tag on the 4.4 concepts of biology book.");
            reportLog("Presence of all Header tag on the 4.4 concept of Biology book.");

            Assert.assertTrue(biologyBookPage.verifyDidYouKnowSection(), assertFailurePreText + "Presence of Did you know section on the 4.4 concepts of biology book.");
            reportLog("Presence of all Did you know section on the 4.4 concept of Biology book.");

            for (int i = 0; i <= 8; i++) {
                scrollByPixel(500);
                basePage.waitForSec(4);
            }

            Assert.assertTrue(biologyBookPage.verifyTheImagesOfBiologyBook(), assertFailurePreText + "Presence of images on the 4.4 concepts of biology book.");
            reportLog("Presence of all images on the 4.4 concept of Biology book.");

            Assert.assertTrue(biologyBookPage.verifyTheVideosOfBiologyBook(), assertFailurePreText + "Presence of videos on the 4.4 concepts of biology book.");
            reportLog("Presence of all the videos on the 4.4 concept of Biology book.");
        } catch (Exception e) {
            result = handleException(e);
        }
        Assert.assertTrue(result, "Test script failed for" + currentMethodName + errorMessage);
    }

    @Test(priority = 5, description = "Verify the Content of 4.5 Transcription.")
    public void verifyContentOfTranscriptionConcept() {
        boolean result = true;
        try {
            String url = "https://flexbooks.ck12.org/cbook/ck-12-biology-flexbook-2.0/section/4.5/primary/lesson/transcription-of-dna-to-rna-bio/";
            webDriver.navigate().to(url);

            Assert.assertTrue(biologyBookPage.verifyModalityPageTitle("Transcription"), assertFailurePreText + "Presence of title on the 4.5 concepts of biology book.");
            reportLog("Verified Modality title: " + webDriver.getTitle() + "on the 4.5 concept of Biology book.");

            reportLog("The Page Description is: " + biologyBookPage.pageDescription.getAttribute("content"));

            Assert.assertTrue(biologyBookPage.verifyCanonicalMetaTag(), assertFailurePreText + "Presence of canonical meta tag on the 4.5 concepts of biology book.");
            reportLog("Verified Canonical Tag and 1 Tag is found with URL: " + biologyBookPage.canonicalData.getAttribute("href"));

            Assert.assertTrue(biologyBookPage.verifyHyperLinkTagsAndParseTheURLOfTags(), assertFailurePreText + "Presence of hyperlinked words on the 4.5 concepts of biology book.");
            reportLog("Hyperlinked words terms are not there for the 4.5 concept of Biology book.");

            Assert.assertTrue(biologyBookPage.verifyTheVocabularyTermsOfBiologyBook(), assertFailurePreText + "Presence of vocabulary terms on the 4.5 concepts of biology book.");
            reportLog("Vocabulary terms are not there for the 4.5 concept of Biology book.");

            Assert.assertTrue(biologyBookPage.verifyHTagsInBook(), assertFailurePreText + "Presence of Header tag on the 4.5 concepts of biology book.");
            reportLog("Presence of all Header tag on the 4.5 concept of Biology book.");

            Assert.assertTrue(biologyBookPage.verifyDidYouKnowSection(), assertFailurePreText + "Presence of Did you know section on the 4.5 concepts of biology book.");
            reportLog("Presence of all Did you know section on the 4.5 concept of Biology book.");

            for (int i = 0; i <= 8; i++) {
                scrollByPixel(500);
                basePage.waitForSec(4);
            }

            Assert.assertTrue(biologyBookPage.verifyTheImagesOfBiologyBook(), assertFailurePreText + "Presence of images on the 4.5 concepts of biology book.");
            reportLog("Presence of all images on the 4.5 concept of Biology book.");

            Assert.assertTrue(biologyBookPage.verifyTheVideosOfBiologyBook(), assertFailurePreText + "Presence of videos on the 4.5 concepts of biology book.");
            reportLog("Presence of all the videos on the 4.5 concept of Biology book.");
        } catch (Exception e) {
            result = handleException(e);
        }
        Assert.assertTrue(result, "Test script failed for" + currentMethodName + errorMessage);
    }

    @Test(priority = 6, description = "Verify the Content of 4.6 Genetic Code.")
    public void verifyContentOfGeneticCodeConcept() {
        boolean result = true;
        try {
            String url = "https://flexbooks.ck12.org/cbook/ck-12-biology-flexbook-2.0/section/4.6/primary/lesson/genetic-code-bio/";
            webDriver.navigate().to(url);

            Assert.assertTrue(biologyBookPage.verifyModalityPageTitle("Genetic Code"), assertFailurePreText + "Presence of title on the 4.6 concepts of biology book.");
            reportLog("Verified Modality title: " + webDriver.getTitle() + "on the 4.6 concept of Biology book.");

            reportLog("The Page Description is: " + biologyBookPage.pageDescription.getAttribute("content"));

            Assert.assertTrue(biologyBookPage.verifyCanonicalMetaTag(), assertFailurePreText + "Presence of canonical meta tag on the 4.6 concepts of biology book.");
            reportLog("Verified Canonical Tag and 1 Tag is found with URL: " + biologyBookPage.canonicalData.getAttribute("href"));

            Assert.assertTrue(biologyBookPage.verifyHyperLinkTagsAndParseTheURLOfTags(), assertFailurePreText + "Presence of hyperlinked words on the 4.6 concepts of biology book.");
            reportLog("Hyperlinked words terms are not there for the 4.6 concept of Biology book.");

            Assert.assertTrue(biologyBookPage.verifyTheVocabularyTermsOfBiologyBook(), assertFailurePreText + "Presence of vocabulary terms on the 4.6 concepts of biology book.");
            reportLog("Vocabulary terms are not there for the 4.6 concept of Biology book.");

            Assert.assertTrue(biologyBookPage.verifyHTagsInBook(), assertFailurePreText + "Presence of Header tag on the 4.6 concepts of biology book.");
            reportLog("Presence of all Header tag on the 4.6 concept of Biology book.");

            Assert.assertTrue(biologyBookPage.verifyDidYouKnowSection(), assertFailurePreText + "Presence of Did you know section on the 4.6 concepts of biology book.");
            reportLog("Presence of all Did you know section on the 4.6 concept of Biology book.");

            for (int i = 0; i <= 8; i++) {
                scrollByPixel(500);
                basePage.waitForSec(4);
            }

            Assert.assertTrue(biologyBookPage.verifyTheImagesOfBiologyBook(), assertFailurePreText + "Presence of images on the 4.6 concepts of biology book.");
            reportLog("Presence of all images on the 4.6 concept of Biology book.");

            Assert.assertTrue(biologyBookPage.verifyTheVideosOfBiologyBook(), assertFailurePreText + "Presence of videos on the 4.6 concepts of biology book.");
            reportLog("Presence of all the videos on the 4.6 concept of Biology book.");
        } catch (Exception e) {
            result = handleException(e);
        }
        Assert.assertTrue(result, "Test script failed for" + currentMethodName + errorMessage);
    }

    @Test(priority = 7, description = "Verify the Content of 4.7 Translation.")
    public void verifyContentOfTranslationConcept() {
        boolean result = true;
        try {
            String url = "https://flexbooks.ck12.org/cbook/ck-12-biology-flexbook-2.0/section/4.7/primary/lesson/translation-of-rna-to-protein-bio/";
            webDriver.navigate().to(url);

            Assert.assertTrue(biologyBookPage.verifyModalityPageTitle("Translation"), assertFailurePreText + "Presence of title on the 4.7 concepts of biology book.");
            reportLog("Verified Modality title: " + webDriver.getTitle() + "on the 4.7 concept of Biology book.");

            reportLog("The Page Description is: " + biologyBookPage.pageDescription.getAttribute("content"));

            Assert.assertTrue(biologyBookPage.verifyCanonicalMetaTag(), assertFailurePreText + "Presence of canonical meta tag on the 4.7 concepts of biology book.");
            reportLog("Verified Canonical Tag and 1 Tag is found with URL: " + biologyBookPage.canonicalData.getAttribute("href"));

            Assert.assertTrue(biologyBookPage.verifyHyperLinkTagsAndParseTheURLOfTags(), assertFailurePreText + "Presence of hyperlinked words on the 4.7 concepts of biology book.");
            reportLog("Hyperlinked words terms are not there for the 4.7 concept of Biology book.");

            Assert.assertTrue(biologyBookPage.verifyTheVocabularyTermsOfBiologyBook(), assertFailurePreText + "Presence of vocabulary terms on the 4.7 concepts of biology book.");
            reportLog("Vocabulary terms are not there for the 4.7 concept of Biology book.");

            Assert.assertTrue(biologyBookPage.verifyHTagsInBook(), assertFailurePreText + "Presence of Header tag on the 4.7 concepts of biology book.");
            reportLog("Presence of all Header tag on the 4.7 concept of Biology book.");

            Assert.assertTrue(biologyBookPage.verifyDidYouKnowSection(), assertFailurePreText + "Presence of Did you know section on the 4.7 concepts of biology book.");
            reportLog("Presence of all Did you know section on the 4.7 concept of Biology book.");

            for (int i = 0; i <= 8; i++) {
                scrollByPixel(500);
                basePage.waitForSec(4);
            }

            Assert.assertTrue(biologyBookPage.verifyTheImagesOfBiologyBook(), assertFailurePreText + "Presence of images on the 4.7 concepts of biology book.");
            reportLog("Presence of all images on the 4.7 concept of Biology book.");

            Assert.assertTrue(biologyBookPage.verifyTheVideosOfBiologyBook(), assertFailurePreText + "Presence of videos on the 4.7 concepts of biology book.");
            reportLog("Presence of all the videos on the 4.7 concept of Biology book.");
        } catch (Exception e) {
            result = handleException(e);
        }
        Assert.assertTrue(result, "Test script failed for" + currentMethodName + errorMessage);
    }

    @Test(priority = 8, description = "Verify the Content of 4.8 Mutation.")
    public void verifyContentOfMutationConcept() {
        boolean result = true;
        try {
            String url = "https://flexbooks.ck12.org/cbook/ck-12-biology-flexbook-2.0/section/4.8/primary/lesson/mutation-types-bio/";
            webDriver.navigate().to(url);

            Assert.assertTrue(biologyBookPage.verifyModalityPageTitle("Mutation"), assertFailurePreText + "Presence of title on the 4.8 concepts of biology book.");
            reportLog("Verified Modality title: " + webDriver.getTitle() + "on the 4.8 concept of Biology book.");

            reportLog("The Page Description is: " + biologyBookPage.pageDescription.getAttribute("content"));

            Assert.assertTrue(biologyBookPage.verifyCanonicalMetaTag(), assertFailurePreText + "Presence of canonical meta tag on the 4.8 concepts of biology book.");
            reportLog("Verified Canonical Tag and 1 Tag is found with URL: " + biologyBookPage.canonicalData.getAttribute("href"));

            Assert.assertTrue(biologyBookPage.verifyHyperLinkTagsAndParseTheURLOfTags(), assertFailurePreText + "Presence of hyperlinked words on the 4.8 concepts of biology book.");
            reportLog("Hyperlinked words terms are not there for the 4.8 concept of Biology book.");

            Assert.assertTrue(biologyBookPage.verifyTheVocabularyTermsOfBiologyBook(), assertFailurePreText + "Presence of vocabulary terms on the 4.8 concepts of biology book.");
            reportLog("Vocabulary terms are not there for the 4.8 concept of Biology book.");

            Assert.assertTrue(biologyBookPage.verifyHTagsInBook(), assertFailurePreText + "Presence of Header tag on the 4.8 concepts of biology book.");
            reportLog("Presence of all Header tag on the 4.8 concept of Biology book.");

            Assert.assertTrue(biologyBookPage.verifyDidYouKnowSection(), assertFailurePreText + "Presence of Did you know section on the 4.8 concepts of biology book.");
            reportLog("Presence of all Did you know section on the 4.8 concept of Biology book.");

            for (int i = 0; i <= 8; i++) {
                scrollByPixel(500);
                basePage.waitForSec(4);
            }

            Assert.assertTrue(biologyBookPage.verifyTheImagesOfBiologyBook(), assertFailurePreText + "Presence of images on the 4.8 concepts of biology book.");
            reportLog("Presence of all images on the 4.8 concept of Biology book.");

            Assert.assertTrue(biologyBookPage.verifyTheVideosOfBiologyBook(), assertFailurePreText + "Presence of videos on the 4.8 concepts of biology book.");
            reportLog("Presence of all the videos on the 4.8 concept of Biology book.");
        } catch (Exception e) {
            result = handleException(e);
        }
        Assert.assertTrue(result, "Test script failed for" + currentMethodName + errorMessage);
    }

    @Test(priority = 9, description = "Verify the Content of 4.9 Mutation Causes.")
    public void verifyContentOfMutationCausesConcept() {
        boolean result = true;
        try {
            String url = "https://flexbooks.ck12.org/cbook/ck-12-biology-flexbook-2.0/section/4.9/primary/lesson/mutation-causes-bio/";
            webDriver.navigate().to(url);

            Assert.assertTrue(biologyBookPage.verifyModalityPageTitle("Mutation Causes"), assertFailurePreText + "Presence of title on the 4.9 concepts of biology book.");
            reportLog("Verified Modality title: " + webDriver.getTitle() + "on the 4.9 concept of Biology book.");

            reportLog("The Page Description is: " + biologyBookPage.pageDescription.getAttribute("content"));

            Assert.assertTrue(biologyBookPage.verifyCanonicalMetaTag(), assertFailurePreText + "Presence of canonical meta tag on the 4.9 concepts of biology book.");
            reportLog("Verified Canonical Tag and 1 Tag is found with URL: " + biologyBookPage.canonicalData.getAttribute("href"));

            Assert.assertTrue(biologyBookPage.verifyHyperLinkTagsAndParseTheURLOfTags(), assertFailurePreText + "Presence of hyperlinked words on the 4.9 concepts of biology book.");
            reportLog("Hyperlinked words terms are not there for the 4.9 concept of Biology book.");

            Assert.assertTrue(biologyBookPage.verifyTheVocabularyTermsOfBiologyBook(), assertFailurePreText + "Presence of vocabulary terms on the 4.9 concepts of biology book.");
            reportLog("Vocabulary terms are not there for the 4.9 concept of Biology book.");

            Assert.assertTrue(biologyBookPage.verifyHTagsInBook(), assertFailurePreText + "Presence of Header tag on the 4.9 concepts of biology book.");
            reportLog("Presence of all Header tag on the 4.9 concept of Biology book.");

            Assert.assertTrue(biologyBookPage.verifyDidYouKnowSection(), assertFailurePreText + "Presence of Did you know section on the 4.9 concepts of biology book.");
            reportLog("Presence of all Did you know section on the 4.3 concept of Biology book.");

            for (int i = 0; i <= 8; i++) {
                scrollByPixel(500);
                basePage.waitForSec(4);
            }

            Assert.assertTrue(biologyBookPage.verifyTheImagesOfBiologyBook(), assertFailurePreText + "Presence of images on the 4.9 concepts of biology book.");
            reportLog("Presence of all images on the 4.9 concept of Biology book.");

            Assert.assertTrue(biologyBookPage.verifyTheVideosOfBiologyBook(), assertFailurePreText + "Presence of videos on the 4.9 concepts of biology book.");
            reportLog("Presence of all the videos on the 4.9 concept of Biology book.");
        } catch (Exception e) {
            result = handleException(e);
        }
        Assert.assertTrue(result, "Test script failed for" + currentMethodName + errorMessage);
    }

    @Test(priority = 10, description = "Verify the Content of 4.10 Mutation Effects")
    public void verifyContentOfMutationEffectsConcept() {
        boolean result = true;
        try {
            String url = "https://flexbooks.ck12.org/cbook/ck-12-biology-flexbook-2.0/section/4.10/primary/lesson/mutation-effects-bio/";
            webDriver.navigate().to(url);

            Assert.assertTrue(biologyBookPage.verifyModalityPageTitle("Mutation Effects"), assertFailurePreText + "Presence of title on the 4.10 concepts of biology book.");
            reportLog("Verified Modality title: " + webDriver.getTitle() + "on the 4.10 concept of Biology book.");

            reportLog("The Page Description is: " + biologyBookPage.pageDescription.getAttribute("content"));

            Assert.assertTrue(biologyBookPage.verifyCanonicalMetaTag(), assertFailurePreText + "Presence of canonical meta tag on the 4.10 concepts of biology book.");
            reportLog("Verified Canonical Tag and 1 Tag is found with URL: " + biologyBookPage.canonicalData.getAttribute("href"));

            Assert.assertTrue(biologyBookPage.verifyHyperLinkTagsAndParseTheURLOfTags(), assertFailurePreText + "Presence of hyperlinked words on the 4.10 concepts of biology book.");
            reportLog("Hyperlinked words terms are not there for the 4.11 concept of Biology book.");

            Assert.assertTrue(biologyBookPage.verifyTheVocabularyTermsOfBiologyBook(), assertFailurePreText + "Presence of vocabulary terms on the 4.10 concepts of biology book.");
            reportLog("Vocabulary terms are not there for the 4.10 concept of Biology book.");

            Assert.assertTrue(biologyBookPage.verifyHTagsInBook(), assertFailurePreText + "Presence of Header tag on the 4.10 concepts of biology book.");
            reportLog("Presence of all Header tag on the 4.10 concept of Biology book.");

            Assert.assertTrue(biologyBookPage.verifyDidYouKnowSection(), assertFailurePreText + "Presence of Did you know section on the 4.10 concepts of biology book.");
            reportLog("Presence of all Did you know section on the 4.10 concept of Biology book.");

            for (int i = 0; i <= 8; i++) {
                scrollByPixel(500);
                basePage.waitForSec(4);
            }

            Assert.assertTrue(biologyBookPage.verifyTheImagesOfBiologyBook(), assertFailurePreText + "Presence of images on the 4.10 concepts of biology book.");
            reportLog("Presence of all images on the 4.10 concept of Biology book.");

            Assert.assertTrue(biologyBookPage.verifyTheVideosOfBiologyBook(), assertFailurePreText + "Presence of videos on the 4.10 concepts of biology book.");
            reportLog("Presence of all the videos on the 4.10 concept of Biology book.");
        } catch (Exception e) {
            result = handleException(e);
        }
        Assert.assertTrue(result, "Test script failed for" + currentMethodName + errorMessage);
    }

    @Test(priority = 11, description = "Verify the Content of 4.11 Gene Expression.")
    public void verifyContentOfGeneExpressionConcept() {
        boolean result = true;
        try {
            String url = "https://flexbooks.ck12.org/cbook/ck-12-biology-flexbook-2.0/section/4.11/primary/lesson/gene-expression-bio/";
            webDriver.navigate().to(url);

            Assert.assertTrue(biologyBookPage.verifyModalityPageTitle("Gene Expression"), assertFailurePreText + "Presence of title on the 4.11 concepts of biology book.");
            reportLog("Verified Modality title: " + webDriver.getTitle() + "on the 4.11 concept of Biology book.");

            reportLog("The Page Description is: " + biologyBookPage.pageDescription.getAttribute("content"));

            Assert.assertTrue(biologyBookPage.verifyCanonicalMetaTag(), assertFailurePreText + "Presence of canonical meta tag on the 4.11 concepts of biology book.");
            reportLog("Verified Canonical Tag and 1 Tag is found with URL: " + biologyBookPage.canonicalData.getAttribute("href"));

            Assert.assertTrue(biologyBookPage.verifyHyperLinkTagsAndParseTheURLOfTags(), assertFailurePreText + "Presence of hyperlinked words on the 4.11 concepts of biology book.");
            reportLog("Hyperlinked words terms are not there for the 4.11 concept of Biology book.");

            Assert.assertTrue(biologyBookPage.verifyTheVocabularyTermsOfBiologyBook(), assertFailurePreText + "Presence of vocabulary terms on the 4.11 concepts of biology book.");
            reportLog("Vocabulary terms are not there for the 4.11 concept of Biology book.");

            Assert.assertTrue(biologyBookPage.verifyHTagsInBook(), assertFailurePreText + "Presence of Header tag on the 4.11 concepts of biology book.");
            reportLog("Presence of all Header tag on the 4.11 concept of Biology book.");

            Assert.assertTrue(biologyBookPage.verifyDidYouKnowSection(), assertFailurePreText + "Presence of Did you know section on the 4.11 concepts of biology book.");
            reportLog("Presence of all Did you know section on the 4.11 concept of Biology book.");

            for (int i = 0; i <= 8; i++) {
                scrollByPixel(500);
                basePage.waitForSec(4);
            }

            Assert.assertTrue(biologyBookPage.verifyTheImagesOfBiologyBook(), assertFailurePreText + "Presence of images on the 4.11 concepts of biology book.");
            reportLog("Presence of all images on the 4.11 concept of Biology book.");

            Assert.assertTrue(biologyBookPage.verifyTheVideosOfBiologyBook(), assertFailurePreText + "Presence of videos on the 4.11 concepts of biology book.");
            reportLog("Presence of all the videos on the 4.11 concept of Biology book.");
        } catch (Exception e) {
            result = handleException(e);
        }
        Assert.assertTrue(result, "Test script failed for" + currentMethodName + errorMessage);
    }

    @Test(priority = 12, description = "Verify the Content of 4.12 Prokaryotic Gene Regulation.")
    public void verifyContentOfProkaryoticGeneRegulationConcept() {
        boolean result = true;
        try {
            String url = "https://flexbooks.ck12.org/cbook/ck-12-biology-flexbook-2.0/section/4.12/primary/lesson/prokaryotic-gene-regulation-bio/";
            webDriver.navigate().to(url);

            Assert.assertTrue(biologyBookPage.verifyModalityPageTitle("Prokaryotic Gene Regulation"), assertFailurePreText + "Presence of title on the 4.12 concepts of biology book.");
            reportLog("Verified Modality title: " + webDriver.getTitle() + "on the 4.12 concept of Biology book.");

            reportLog("The Page Description is: " + biologyBookPage.pageDescription.getAttribute("content"));

            Assert.assertTrue(biologyBookPage.verifyCanonicalMetaTag(), assertFailurePreText + "Presence of canonical meta tag on the 4.12 concepts of biology book.");
            reportLog("Verified Canonical Tag and 1 Tag is found with URL: " + biologyBookPage.canonicalData.getAttribute("href"));

            Assert.assertTrue(biologyBookPage.verifyHyperLinkTagsAndParseTheURLOfTags(), assertFailurePreText + "Presence of hyperlinked words on the 4.12 concepts of biology book.");
            reportLog("Hyperlinked words terms are not there for the 4.12 concept of Biology book.");

            Assert.assertTrue(biologyBookPage.verifyTheVocabularyTermsOfBiologyBook(), assertFailurePreText + "Presence of vocabulary terms on the 4.12 concepts of biology book.");
            reportLog("Vocabulary terms are not there for the 4.12 concept of Biology book.");

            Assert.assertTrue(biologyBookPage.verifyHTagsInBook(), assertFailurePreText + "Presence of Header tag on the 4.12 concepts of biology book.");
            reportLog("Presence of all Header tag on the 4.12 concept of Biology book.");

            Assert.assertTrue(biologyBookPage.verifyDidYouKnowSection(), assertFailurePreText + "Presence of Did you know section on the 4.12 concepts of biology book.");
            reportLog("Presence of all Did you know section on the 4.12 concept of Biology book.");

            for (int i = 0; i <= 8; i++) {
                scrollByPixel(500);
                basePage.waitForSec(4);
            }

            Assert.assertTrue(biologyBookPage.verifyTheImagesOfBiologyBook(), assertFailurePreText + "Presence of images on the 4.12 concepts of biology book.");
            reportLog("Presence of all images on the 4.12 concept of Biology book.");

            Assert.assertTrue(biologyBookPage.verifyTheVideosOfBiologyBook(), assertFailurePreText + "Presence of videos on the 4.12 concepts of biology book.");
            reportLog("Presence of all the videos on the 4.12 concept of Biology book.");
        } catch (Exception e) {
            result = handleException(e);
        }
        Assert.assertTrue(result, "Test script failed for" + currentMethodName + errorMessage);
    }

    @Test(priority = 13, description = "Verify the Content of 4.13 Eukaryotic Gene Regulation.")
    public void verifyContentOfEukaryoticGeneRegulationConcept() {
        boolean result = true;
        try {
            String url = "https://flexbooks.ck12.org/cbook/ck-12-biology-flexbook-2.0/section/4.13/primary/lesson/eukaryotic-gene-regulation-bio/";
            webDriver.navigate().to(url);

            Assert.assertTrue(biologyBookPage.verifyModalityPageTitle("Eukaryotic Gene Regulation"), assertFailurePreText + "Presence of title on the 4.13 concepts of biology book.");
            reportLog("Verified Modality title: " + webDriver.getTitle() + "on the 4.13 concept of Biology book.");

            reportLog("The Page Description is: " + biologyBookPage.pageDescription.getAttribute("content"));

            Assert.assertTrue(biologyBookPage.verifyCanonicalMetaTag(), assertFailurePreText + "Presence of canonical meta tag on the 4.13 concepts of biology book.");
            reportLog("Verified Canonical Tag and 1 Tag is found with URL: " + biologyBookPage.canonicalData.getAttribute("href"));

            Assert.assertTrue(biologyBookPage.verifyHyperLinkTagsAndParseTheURLOfTags(), assertFailurePreText + "Presence of hyperlinked words on the 4.13 concepts of biology book.");
            reportLog("Hyperlinked words terms are not there for the 4.13 concept of Biology book.");

            Assert.assertTrue(biologyBookPage.verifyTheVocabularyTermsOfBiologyBook(), assertFailurePreText + "Presence of vocabulary terms on the 4.13 concepts of biology book.");
            reportLog("Vocabulary terms are not there for the 4.13 concept of Biology book.");

            Assert.assertTrue(biologyBookPage.verifyHTagsInBook(), assertFailurePreText + "Presence of Header tag on the 4.13 concepts of biology book.");
            reportLog("Presence of all Header tag on the 4.13 concept of Biology book.");

            Assert.assertTrue(biologyBookPage.verifyDidYouKnowSection(), assertFailurePreText + "Presence of Did you know section on the 4.13 concepts of biology book.");
            reportLog("Presence of all Did you know section on the 4.13 concept of Biology book.");

            for (int i = 0; i <= 8; i++) {
                scrollByPixel(500);
                basePage.waitForSec(4);
            }

            Assert.assertTrue(biologyBookPage.verifyTheImagesOfBiologyBook(), assertFailurePreText + "Presence of images on the 4.13 concepts of biology book.");
            reportLog("Presence of all images on the 4.13 concept of Biology book.");

            Assert.assertTrue(biologyBookPage.verifyTheVideosOfBiologyBook(), assertFailurePreText + "Presence of videos on the 4.13 concepts of biology book.");
            reportLog("Presence of all the videos on the 4.13 concept of Biology book.");
        } catch (Exception e) {
            result = handleException(e);
        }
        Assert.assertTrue(result, "Test script failed for" + currentMethodName + errorMessage);
    }
}
