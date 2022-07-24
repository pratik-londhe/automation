package testscripts.regression.interactives;

import org.testng.Assert;
import org.testng.annotations.Test;
import testscripts.BaseTestScript;
import uipages.BasePage;
import uipages.flexbook2feature.LoginPage;
import uipages.flexbook2feature.TeacherDashboardPage;
import uipages.interactives.BiologyBookPage;

public class BiologyUnitThreeNoInteractivesTest extends BaseTestScript {

    private BiologyBookPage biologyBookPage;
    private BasePage basePage;

    @Test(priority = 1, dataProvider = "CK12DataProvider", description = "Verify the Content of 3.1 Pea Plants concept of Biology book.")
    public void verifyContentOfPeaPlantsConcept(String email, String password, String conceptScientificMethod) {
        biologyBookPage = new BiologyBookPage(webDriver, extentTest, extentReports);
        boolean result = true;
        try {
            LoginPage loginPage = new LoginPage(webDriver, extentTest, extentReports);
            biologyBookPage = new BiologyBookPage(webDriver, extentTest, extentReports);
            basePage = new BasePage(webDriver, extentTest, extentReports);

            loginPage.teacherLogin(email, password);

            Assert.assertTrue(new TeacherDashboardPage(webDriver, extentTest, extentReports).verifyTeacherProfileOnGamma(), assertFailurePreText + "Presence of Teacher account icon On Gamma");
            reportLog("Presence of Teacher account icon On Gamma");

            webDriver.navigate().to(conceptScientificMethod);

            Assert.assertTrue(biologyBookPage.verifyModalityPageTitle("Pea Plants"), assertFailurePreText + "Presence of title on the 3.1 concepts of biology book.");
            reportLog("Verified Modality title: " + webDriver.getTitle() + "on the 3.1 concept of Biology book.");

            reportLog("The Page Description is: " + biologyBookPage.pageDescription.getAttribute("content"));

            Assert.assertTrue(biologyBookPage.verifyCanonicalMetaTag(), assertFailurePreText + "Presence of canonical meta tag on the 3.1 concepts of biology book.");
            reportLog("Verified Canonical Tag and 1 Tag is found with URL: " + biologyBookPage.canonicalData.getAttribute("href"));

            Assert.assertTrue(biologyBookPage.verifyHyperLinkTagsAndParseTheURLOfTags(), assertFailurePreText + "Presence of hyperlinked words on the 3.1 concepts of biology book.");
            reportLog("Presence of all the hyperlinked words terms on the 3.1 concept of Biology book.");

            Assert.assertTrue(biologyBookPage.verifyTheVocabularyTermsOfBiologyBook(), assertFailurePreText + "Presence of vocabulary terms on the 3.1 concepts of biology book.");
            reportLog("Presence of all the vocabulary terms on the 3.1 concept of Biology book.");

            Assert.assertTrue(biologyBookPage.verifyHTagsInBook(), assertFailurePreText + "Presence of Header tag on the 3.1 concepts of biology book.");
            reportLog("Presence of all Header tag on the 3.1 concept of Biology book.");

            Assert.assertTrue(biologyBookPage.verifyDidYouKnowSection(), assertFailurePreText + "Presence of Did you know section on the 3.1 concepts of biology book.");
            reportLog("Did you know section is not present on the 3.1 concept of Biology book.");

            for (int i = 0; i <= 8; i++) {
                scrollByPixel(500);
                basePage.waitForSec(4);
            }

            Assert.assertTrue(biologyBookPage.verifyTheImagesOfBiologyBook(), assertFailurePreText + "Presence of images on the 3.1 concepts of biology book.");
            reportLog("Presence of all images on the 3.1 concept of Biology book.");

            Assert.assertTrue(biologyBookPage.verifyTheVideosOfBiologyBook(), assertFailurePreText + "Presence of videos on the 3.1 concepts of biology book.");
            reportLog("Presence of all the videos on the 3.1 concept of Biology book.");

        } catch (Exception e) {
            result = handleException(e);
        }
        Assert.assertTrue(result, "Test script failed for" + currentMethodName + errorMessage);
    }

    @Test(priority = 2, description = "Verify the Content of 3.2 Mendel's First Experiment concept of Biology book.")
    public void verifyContentOfMendelFirstExperimentConcept() {
        boolean result = true;
        try {
            String url = "https://flexbooks.ck12.org/cbook/ck-12-biology-flexbook-2.0/section/3.2/primary/lesson/mendels-first-set-of-experiments-bio/";

            webDriver.navigate().to(url);

            Assert.assertTrue(biologyBookPage.verifyModalityPageTitle("Mendel's First Experiment"), assertFailurePreText + "Presence of title on the 3.2 concepts of biology book.");
            reportLog("Verified Modality title: " + webDriver.getTitle() + "on the 3.2 concept of Biology book.");

            reportLog("The Page Description is: " + biologyBookPage.pageDescription.getAttribute("content"));

            Assert.assertTrue(biologyBookPage.verifyCanonicalMetaTag(), assertFailurePreText + "Presence of canonical meta tag on the 3.2 concepts of biology book.");
            reportLog("Verified Canonical Tag and 1 Tag is found with URL: " + biologyBookPage.canonicalData.getAttribute("href"));

            Assert.assertTrue(biologyBookPage.verifyHyperLinkTagsAndParseTheURLOfTags(), assertFailurePreText + "Presence of hyperlinked words on the 3.2 concepts of biology book.");
            reportLog("Presence of all the hyperlinked words terms on the 3.2 concept of Biology book.");

            Assert.assertTrue(biologyBookPage.verifyTheVocabularyTermsOfBiologyBook(), assertFailurePreText + "Presence of vocabulary terms on the 3.2 concepts of biology book.");
            reportLog("Presence of all the vocabulary terms on the 3.2 concept of Biology book.");

            Assert.assertTrue(biologyBookPage.verifyHTagsInBook(), assertFailurePreText + "Presence of Header tag on the 3.2 concepts of biology book.");
            reportLog("Presence of all Header tag on the 3.2 concept of Biology book.");

            Assert.assertTrue(biologyBookPage.verifyDidYouKnowSection(), assertFailurePreText + "Presence of Did you know section on the 3.2 concepts of biology book.");
            reportLog("Did you know section is not present on the 3.2 concept of Biology book.");

            for (int i = 0; i <= 8; i++) {
                scrollByPixel(500);
                basePage.waitForSec(4);
            }

            Assert.assertTrue(biologyBookPage.verifyTheImagesOfBiologyBook(), assertFailurePreText + "Presence of images on the 3.2 concepts of biology book.");
            reportLog("Presence of all images on the 3.2 concept of Biology book.");

            Assert.assertTrue(biologyBookPage.verifyTheVideosOfBiologyBook(), assertFailurePreText + "Presence of videos on the 3.2 concepts of biology book.");
            reportLog("Presence of all the videos on the 3.2 concept of Biology book.");

        } catch (Exception e) {
            result = handleException(e);
        }
        Assert.assertTrue(result, "Test script failed for" + currentMethodName + errorMessage);
    }

    @Test(priority = 3, description = "Verify the Content of 3.3 Mendel's Second Experiment concept of Biology book.")
    public void verifyContentOfMendelSecondExperimentConcept() {
        boolean result = true;
        try {
            String url = "https://flexbooks.ck12.org/cbook/ck-12-biology-flexbook-2.0/section/3.3/primary/lesson/mendels-second-set-of-experiments-bio/";

            webDriver.navigate().to(url);

            Assert.assertTrue(biologyBookPage.verifyModalityPageTitle("Mendel's Second Experiment"), assertFailurePreText + "Presence of title on the 3.3 concepts of biology book.");
            reportLog("Verified Modality title: " + webDriver.getTitle() + "on the 3.3 concept of Biology book.");

            reportLog("The Page Description is: " + biologyBookPage.pageDescription.getAttribute("content"));

            Assert.assertTrue(biologyBookPage.verifyCanonicalMetaTag(), assertFailurePreText + "Presence of canonical meta tag on the 3.3 concepts of biology book.");
            reportLog("Verified Canonical Tag and 1 Tag is found with URL: " + biologyBookPage.canonicalData.getAttribute("href"));

            Assert.assertTrue(biologyBookPage.verifyHyperLinkTagsAndParseTheURLOfTags(), assertFailurePreText + "Presence of hyperlinked words on the 3.3 concepts of biology book.");
            reportLog("Presence of all the hyperlinked words terms on the 3.3 concept of Biology book.");

            Assert.assertTrue(biologyBookPage.verifyTheVocabularyTermsOfBiologyBook(), assertFailurePreText + "Presence of vocabulary terms on the 3.3 concepts of biology book.");
            reportLog("Presence of all the vocabulary terms on the 3.3 concept of Biology book.");

            Assert.assertTrue(biologyBookPage.verifyHTagsInBook(), assertFailurePreText + "Presence of Header tag on the 3.3 concepts of biology book.");
            reportLog("Presence of all Header tag on the 3.3 concept of Biology book.");

            Assert.assertTrue(biologyBookPage.verifyDidYouKnowSection(), assertFailurePreText + "Presence of Did you know section on the 3.3 concepts of biology book.");
            reportLog("Did you know section is not present on the 3.3 concept of Biology book.");

            for (int i = 0; i <= 8; i++) {
                scrollByPixel(500);
                basePage.waitForSec(4);
            }

            Assert.assertTrue(biologyBookPage.verifyTheImagesOfBiologyBook(), assertFailurePreText + "Presence of images on the 3.3 concepts of biology book.");
            reportLog("Presence of all images on the 3.3 concept of Biology book.");

            Assert.assertTrue(biologyBookPage.verifyTheVideosOfBiologyBook(), assertFailurePreText + "Presence of videos on the 3.3 concepts of biology book.");
            reportLog("Presence of all the videos on the 3.3 concept of Biology book.");

        } catch (Exception e) {
            result = handleException(e);
        }
        Assert.assertTrue(result, "Test script failed for" + currentMethodName + errorMessage);
    }

    @Test(priority = 4, description = "Verify the Content of 3.4 Mendel's Laws concept of Biology book.")
    public void verifyContentOfMendelLawsConcept() {
        boolean result = true;
        try {
            String url = "https://flexbooks.ck12.org/cbook/ck-12-biology-flexbook-2.0/section/3.4/primary/lesson/mendels-laws-and-genetics-bio/";

            webDriver.navigate().to(url);

            Assert.assertTrue(biologyBookPage.verifyModalityPageTitle("Mendel's Laws"), assertFailurePreText + "Presence of title on the 3.2 concepts of biology book.");
            reportLog("Verified Modality title: " + webDriver.getTitle() + "on the 3.4 concept of Biology book.");

            reportLog("The Page Description is: " + biologyBookPage.pageDescription.getAttribute("content"));

            Assert.assertTrue(biologyBookPage.verifyCanonicalMetaTag(), assertFailurePreText + "Presence of canonical meta tag on the 3.4 concepts of biology book.");
            reportLog("Verified Canonical Tag and 1 Tag is found with URL: " + biologyBookPage.canonicalData.getAttribute("href"));

            Assert.assertTrue(biologyBookPage.verifyHyperLinkTagsAndParseTheURLOfTags(), assertFailurePreText + "Presence of hyperlinked words on the 3.4 concepts of biology book.");
            reportLog("Presence of all the hyperlinked words terms on the 3.4 concept of Biology book.");

            Assert.assertTrue(biologyBookPage.verifyTheVocabularyTermsOfBiologyBook(), assertFailurePreText + "Presence of vocabulary terms on the 3.4 concepts of biology book.");
            reportLog("Presence of all the vocabulary terms on the 3.4 concept of Biology book.");

            Assert.assertTrue(biologyBookPage.verifyHTagsInBook(), assertFailurePreText + "Presence of Header tag on the 3.4 concepts of biology book.");
            reportLog("Presence of all Header tag on the 3.4 concept of Biology book.");

            Assert.assertTrue(biologyBookPage.verifyDidYouKnowSection(), assertFailurePreText + "Presence of Did you know section on the 3.4 concepts of biology book.");
            reportLog("Did you know section is not present on the 3.4 concept of Biology book.");

            for (int i = 0; i <= 8; i++) {
                scrollByPixel(500);
                basePage.waitForSec(4);
            }

            Assert.assertTrue(biologyBookPage.verifyTheImagesOfBiologyBook(), assertFailurePreText + "Presence of images on the 3.4 concepts of biology book.");
            reportLog("Presence of all images on the 3.4 concept of Biology book.");

            Assert.assertTrue(biologyBookPage.verifyTheVideosOfBiologyBook(), assertFailurePreText + "Presence of videos on the 3.4 concepts of biology book.");
            reportLog("Presence of all the videos on the 3.4 concept of Biology book.");

        } catch (Exception e) {
            result = handleException(e);
        }
        Assert.assertTrue(result, "Test script failed for" + currentMethodName + errorMessage);
    }

    @Test(priority = 5, description = "Verify the Content of 3.5 Probability concept of Biology book.")
    public void verifyContentOfProbabilityConcept() {
        boolean result = true;
        try {
            String url = "https://flexbooks.ck12.org/cbook/ck-12-biology-flexbook-2.0/section/3.5/primary/lesson/probability-and-inheritance-bio/";

            webDriver.navigate().to(url);

            Assert.assertTrue(biologyBookPage.verifyModalityPageTitle("Probability"), assertFailurePreText + "Presence of title on the 3.5 concepts of biology book.");
            reportLog("Verified Modality title: " + webDriver.getTitle() + "on the 3.5 concept of Biology book.");

            reportLog("The Page Description is: " + biologyBookPage.pageDescription.getAttribute("content"));

            Assert.assertTrue(biologyBookPage.verifyCanonicalMetaTag(), assertFailurePreText + "Presence of canonical meta tag on the 3.5 concepts of biology book.");
            reportLog("Verified Canonical Tag and 1 Tag is found with URL: " + biologyBookPage.canonicalData.getAttribute("href"));

            Assert.assertTrue(biologyBookPage.verifyHyperLinkTagsAndParseTheURLOfTags(), assertFailurePreText + "Presence of hyperlinked words on the 3.5 concepts of biology book.");
            reportLog("Presence of all the hyperlinked words terms on the 3.5 concept of Biology book.");

            Assert.assertTrue(biologyBookPage.verifyTheVocabularyTermsOfBiologyBook(), assertFailurePreText + "Presence of vocabulary terms on the 3.5 concepts of biology book.");
            reportLog("Presence of all the vocabulary terms on the 3.5 concept of Biology book.");

            Assert.assertTrue(biologyBookPage.verifyHTagsInBook(), assertFailurePreText + "Presence of Header tag on the 3.5 concepts of biology book.");
            reportLog("Presence of all Header tag on the 3.5 concept of Biology book.");

            Assert.assertTrue(biologyBookPage.verifyDidYouKnowSection(), assertFailurePreText + "Presence of Did you know section on the 3.5 concepts of biology book.");
            reportLog("Did you know section is not present on the 3.5 concept of Biology book.");

            for (int i = 0; i <= 8; i++) {
                scrollByPixel(500);
                basePage.waitForSec(4);
            }

            Assert.assertTrue(biologyBookPage.verifyTheImagesOfBiologyBook(), assertFailurePreText + "Presence of images on the 3.5 concepts of biology book.");
            reportLog("Presence of all images on the 3.5 concept of Biology book.");

            Assert.assertTrue(biologyBookPage.verifyTheVideosOfBiologyBook(), assertFailurePreText + "Presence of videos on the 3.5 concepts of biology book.");
            reportLog("Presence of all the videos on the 3.5 concept of Biology book.");

        } catch (Exception e) {
            result = handleException(e);
        }
        Assert.assertTrue(result, "Test script failed for" + currentMethodName + errorMessage);
    }

    @Test(priority = 6, description = "Verify the Content of 3.6 Punnett Squares concept of Biology book.")
    public void verifyContentOfPunnettSquaresConcept() {
        boolean result = true;
        try {
            String url = "https://flexbooks.ck12.org/cbook/ck-12-biology-flexbook-2.0/section/3.6/primary/lesson/punnett-squares-bio/";

            webDriver.navigate().to(url);

            Assert.assertTrue(biologyBookPage.verifyModalityPageTitle("Punnett Squares"), assertFailurePreText + "Presence of title on the 3.6 concepts of biology book.");
            reportLog("Verified Modality title: " + webDriver.getTitle() + "on the 3.6 concept of Biology book.");

            reportLog("The Page Description is: " + biologyBookPage.pageDescription.getAttribute("content"));

            Assert.assertTrue(biologyBookPage.verifyCanonicalMetaTag(), assertFailurePreText + "Presence of canonical meta tag on the 3.6 concepts of biology book.");
            reportLog("Verified Canonical Tag and 1 Tag is found with URL: " + biologyBookPage.canonicalData.getAttribute("href"));

            Assert.assertTrue(biologyBookPage.verifyHyperLinkTagsAndParseTheURLOfTags(), assertFailurePreText + "Presence of hyperlinked words on the 3.6 concepts of biology book.");
            reportLog("Presence of all the hyperlinked words terms on the 3.6 concept of Biology book.");

            Assert.assertTrue(biologyBookPage.verifyTheVocabularyTermsOfBiologyBook(), assertFailurePreText + "Presence of vocabulary terms on the 3.6 concepts of biology book.");
            reportLog("Presence of all the vocabulary terms on the 3.6 concept of Biology book.");

            Assert.assertTrue(biologyBookPage.verifyHTagsInBook(), assertFailurePreText + "Presence of Header tag on the 3.6 concepts of biology book.");
            reportLog("Presence of all Header tag on the 3.6 concept of Biology book.");

            Assert.assertTrue(biologyBookPage.verifyDidYouKnowSection(), assertFailurePreText + "Presence of Did you know section on the 3.6 concepts of biology book.");
            reportLog("Did you know section is not present on the 3.6 concept of Biology book.");

            Assert.assertTrue(biologyBookPage.verifyTheImagesOfBiologyBook(), assertFailurePreText + "Presence of images on the 3.6 concepts of biology book.");
            reportLog("Presence of all images on the 3.6 concept of Biology book.");

            Assert.assertTrue(biologyBookPage.verifyTheVideosOfBiologyBook(), assertFailurePreText + "Presence of videos on the 3.6 concepts of biology book.");
            reportLog("Presence of all the videos on the 3.6 concept of Biology book.");

        } catch (Exception e) {
            result = handleException(e);
        }
        Assert.assertTrue(result, "Test script failed for" + currentMethodName + errorMessage);
    }

    @Test(priority = 7, description = "Verify the Content of 3.7 Non-Mendelian Inheritance concept of Biology book.")
    public void verifyContentOfNonMendelianInheritanceConcept() {
        boolean result = true;
        try {
            String url = "https://flexbooks.ck12.org/cbook/ck-12-biology-flexbook-2.0/section/3.7/primary/lesson/non-mendelian-inheritance-bio/";

            webDriver.navigate().to(url);

            Assert.assertTrue(biologyBookPage.verifyModalityPageTitle("Non-Mendelian Inheritance"), assertFailurePreText + "Presence of title on the 3.7 concepts of biology book.");
            reportLog("Verified Modality title: " + webDriver.getTitle() + "on the 3.7 concept of Biology book.");

            reportLog("The Page Description is: " + biologyBookPage.pageDescription.getAttribute("content"));

            Assert.assertTrue(biologyBookPage.verifyCanonicalMetaTag(), assertFailurePreText + "Presence of canonical meta tag on the 3.7 concepts of biology book.");
            reportLog("Verified Canonical Tag and 1 Tag is found with URL: " + biologyBookPage.canonicalData.getAttribute("href"));

            Assert.assertTrue(biologyBookPage.verifyHyperLinkTagsAndParseTheURLOfTags(), assertFailurePreText + "Presence of hyperlinked words on the 3.7 concepts of biology book.");
            reportLog("Presence of all the hyperlinked words terms on the 3.7 concept of Biology book.");

            Assert.assertTrue(biologyBookPage.verifyTheVocabularyTermsOfBiologyBook(), assertFailurePreText + "Presence of vocabulary terms on the 3.7 concepts of biology book.");
            reportLog("Presence of all the vocabulary terms on the 3.7 concept of Biology book.");

            Assert.assertTrue(biologyBookPage.verifyHTagsInBook(), assertFailurePreText + "Presence of Header tag on the 3.7 concepts of biology book.");
            reportLog("Presence of all Header tag on the 3.7 concept of Biology book.");

            Assert.assertTrue(biologyBookPage.verifyDidYouKnowSection(), assertFailurePreText + "Presence of Did you know section on the 3.7 concepts of biology book.");
            reportLog("Did you know section is not present on the 3.7 concept of Biology book.");

            for (int i = 0; i <= 8; i++) {
                scrollByPixel(500);
                basePage.waitForSec(4);
            }

            Assert.assertTrue(biologyBookPage.verifyTheImagesOfBiologyBook(), assertFailurePreText + "Presence of images on the 3.7 concepts of biology book.");
            reportLog("Presence of all images on the 3.7 concept of Biology book.");

            Assert.assertTrue(biologyBookPage.verifyTheVideosOfBiologyBook(), assertFailurePreText + "Presence of videos on the 3.7 concepts of biology book.");
            reportLog("Presence of all the videos on the 3.7 concept of Biology book.");

        } catch (Exception e) {
            result = handleException(e);
        }
        Assert.assertTrue(result, "Test script failed for" + currentMethodName + errorMessage);
    }

    @Test(priority = 8, description = "Verify the Content of 3.8 Human Genome concept of Biology book.")
    public void verifyContentOfHumanGenomeConcept() {
        boolean result = true;
        try {
            String url = "https://flexbooks.ck12.org/cbook/ck-12-biology-flexbook-2.0/section/3.8/primary/lesson/human-genome-bio/";

            webDriver.navigate().to(url);

            Assert.assertTrue(biologyBookPage.verifyModalityPageTitle("Human Genome"), assertFailurePreText + "Presence of title on the 3.8 concepts of biology book.");
            reportLog("Verified Modality title: " + webDriver.getTitle() + "on the 3.8 concept of Biology book.");

            reportLog("The Page Description is: " + biologyBookPage.pageDescription.getAttribute("content"));

            Assert.assertTrue(biologyBookPage.verifyCanonicalMetaTag(), assertFailurePreText + "Presence of canonical meta tag on the 3.8 concepts of biology book.");
            reportLog("Verified Canonical Tag and 1 Tag is found with URL: " + biologyBookPage.canonicalData.getAttribute("href"));

            Assert.assertTrue(biologyBookPage.verifyHyperLinkTagsAndParseTheURLOfTags(), assertFailurePreText + "Presence of hyperlinked words on the 3.8 concepts of biology book.");
            reportLog("Presence of all the hyperlinked words terms on the 3.8 concept of Biology book.");

            Assert.assertTrue(biologyBookPage.verifyTheVocabularyTermsOfBiologyBook(), assertFailurePreText + "Presence of vocabulary terms on the 3.8 concepts of biology book.");
            reportLog("Presence of all the vocabulary terms on the 3.8 concept of Biology book.");

            Assert.assertTrue(biologyBookPage.verifyHTagsInBook(), assertFailurePreText + "Presence of Header tag on the 3.8 concepts of biology book.");
            reportLog("Presence of all Header tag on the 3.8 concept of Biology book.");

            Assert.assertTrue(biologyBookPage.verifyDidYouKnowSection(), assertFailurePreText + "Presence of Did you know section on the 3.8 concepts of biology book.");
            reportLog("Did you know section is not present on the 3.8 concept of Biology book.");

            for (int i = 0; i <= 8; i++) {
                scrollByPixel(500);
                basePage.waitForSec(4);
            }

            Assert.assertTrue(biologyBookPage.verifyTheImagesOfBiologyBook(), assertFailurePreText + "Presence of images on the 3.8 concepts of biology book.");
            reportLog("Presence of all images on the 3.8 concept of Biology book.");

            Assert.assertTrue(biologyBookPage.verifyTheVideosOfBiologyBook(), assertFailurePreText + "Presence of videos on the 3.8 concepts of biology book.");
            reportLog("Presence of all the videos on the 3.8 concept of Biology book.");

        } catch (Exception e) {
            result = handleException(e);
        }
        Assert.assertTrue(result, "Test script failed for" + currentMethodName + errorMessage);
    }

    @Test(priority = 9, description = "Verify the Content of 3.9 Human Chromosomes concept of Biology book.")
    public void verifyContentOfHumanChromosomesConcept() {
        boolean result = true;
        try {
            String url = "https://flexbooks.ck12.org/cbook/ck-12-biology-flexbook-2.0/section/3.9/primary/lesson/human-chromosomes-and-genes-bio/";

            webDriver.navigate().to(url);

            Assert.assertTrue(biologyBookPage.verifyModalityPageTitle("Human Chromosomes"), assertFailurePreText + "Presence of title on the 3.9 concepts of biology book.");
            reportLog("Verified Modality title: " + webDriver.getTitle() + "on the 3.9 concept of Biology book.");

            reportLog("The Page Description is: " + biologyBookPage.pageDescription.getAttribute("content"));

            Assert.assertTrue(biologyBookPage.verifyCanonicalMetaTag(), assertFailurePreText + "Presence of canonical meta tag on the 3.9 concepts of biology book.");
            reportLog("Verified Canonical Tag and 1 Tag is found with URL: " + biologyBookPage.canonicalData.getAttribute("href"));

            Assert.assertTrue(biologyBookPage.verifyHyperLinkTagsAndParseTheURLOfTags(), assertFailurePreText + "Presence of hyperlinked words on the 3.9 concepts of biology book.");
            reportLog("Presence of all the hyperlinked words terms on the 3.9 concept of Biology book.");

            Assert.assertTrue(biologyBookPage.verifyTheVocabularyTermsOfBiologyBook(), assertFailurePreText + "Presence of vocabulary terms on the 3.9 concepts of biology book.");
            reportLog("Presence of all the vocabulary terms on the 3.9 concept of Biology book.");

            Assert.assertTrue(biologyBookPage.verifyHTagsInBook(), assertFailurePreText + "Presence of Header tag on the 3.9 concepts of biology book.");
            reportLog("Presence of all Header tag on the 3.9 concept of Biology book.");

            Assert.assertTrue(biologyBookPage.verifyDidYouKnowSection(), assertFailurePreText + "Presence of Did you know section on the 3.9 concepts of biology book.");
            reportLog("Did you know section is not present on the 3.9 concept of Biology book.");

            for (int i = 0; i <= 8; i++) {
                scrollByPixel(500);
                basePage.waitForSec(4);
            }

            Assert.assertTrue(biologyBookPage.verifyTheImagesOfBiologyBook(), assertFailurePreText + "Presence of images on the 3.9 concepts of biology book.");
            reportLog("Presence of all images on the 3.9 concept of Biology book.");

            Assert.assertTrue(biologyBookPage.verifyTheVideosOfBiologyBook(), assertFailurePreText + "Presence of videos on the 3.9 concepts of biology book.");
            reportLog("Presence of all the videos on the 3.9 concept of Biology book.");

        } catch (Exception e) {
            result = handleException(e);
        }
        Assert.assertTrue(result, "Test script failed for" + currentMethodName + errorMessage);
    }

    @Test(priority = 10, description = "Verify the Content of 3.10 Genetic Linkage concept of Biology book.")
    public void verifyContentOfGeneticLinkageConcept() {
        boolean result = true;
        try {
            String url = "https://flexbooks.ck12.org/cbook/ck-12-biology-flexbook-2.0/section/3.10/primary/lesson/genetic-linkage-bio/";

            webDriver.navigate().to(url);

            Assert.assertTrue(biologyBookPage.verifyModalityPageTitle("Genetic Linkage"), assertFailurePreText + "Presence of title on the 3.10 concepts of biology book.");
            reportLog("Verified Modality title: " + webDriver.getTitle() + "on the 3.10 concept of Biology book.");

            reportLog("The Page Description is: " + biologyBookPage.pageDescription.getAttribute("content"));

            Assert.assertTrue(biologyBookPage.verifyCanonicalMetaTag(), assertFailurePreText + "Presence of canonical meta tag on the 3.10 concepts of biology book.");
            reportLog("Verified Canonical Tag and 1 Tag is found with URL: " + biologyBookPage.canonicalData.getAttribute("href"));

            Assert.assertTrue(biologyBookPage.verifyHyperLinkTagsAndParseTheURLOfTags(), assertFailurePreText + "Presence of hyperlinked words on the 3.10 concepts of biology book.");
            reportLog("Presence of all the hyperlinked words terms on the 3.10 concept of Biology book.");

            Assert.assertTrue(biologyBookPage.verifyTheVocabularyTermsOfBiologyBook(), assertFailurePreText + "Presence of vocabulary terms on the 3.10 concepts of biology book.");
            reportLog("Presence of all the vocabulary terms on the 3.10 concept of Biology book.");

            Assert.assertTrue(biologyBookPage.verifyHTagsInBook(), assertFailurePreText + "Presence of Header tag on the 3.10 concepts of biology book.");
            reportLog("Presence of all Header tag on the 3.10 concept of Biology book.");

            Assert.assertTrue(biologyBookPage.verifyDidYouKnowSection(), assertFailurePreText + "Presence of Did you know section on the 3.10 concepts of biology book.");
            reportLog("Did you know section is present on the 3.10 concept of Biology book.");

            for (int i = 0; i <= 8; i++) {
                scrollByPixel(500);
                basePage.waitForSec(4);
            }

            Assert.assertTrue(biologyBookPage.verifyTheImagesOfBiologyBook(), assertFailurePreText + "Presence of images on the 3.10 concepts of biology book.");
            reportLog("Presence of all images on the 3.10 concept of Biology book.");

            Assert.assertTrue(biologyBookPage.verifyTheVideosOfBiologyBook(), assertFailurePreText + "Presence of videos on the 3.10 concepts of biology book.");
            reportLog("Presence of all the videos on the 3.10 concept of Biology book.");

        } catch (Exception e) {
            result = handleException(e);
        }
        Assert.assertTrue(result, "Test script failed for" + currentMethodName + errorMessage);
    }

    @Test(priority = 11, description = "Verify the Content of 3.11 Mendelian Inheritance concept of Biology book.")
    public void verifyContentOfMendelianInheritanceConcept() {
        boolean result = true;
        try {
            String url = "https://flexbooks.ck12.org/cbook/ck-12-biology-flexbook-2.0/section/3.11/primary/lesson/mendelian-inheritance-in-humans-bio/";

            webDriver.navigate().to(url);

            Assert.assertTrue(biologyBookPage.verifyModalityPageTitle("Mendelian Inheritance"), assertFailurePreText + "Presence of title on the 3.11 concepts of biology book.");
            reportLog("Verified Modality title: " + webDriver.getTitle() + "on the 3.11 concept of Biology book.");

            reportLog("The Page Description is: " + biologyBookPage.pageDescription.getAttribute("content"));

            Assert.assertTrue(biologyBookPage.verifyCanonicalMetaTag(), assertFailurePreText + "Presence of canonical meta tag on the 3.11 concepts of biology book.");
            reportLog("Verified Canonical Tag and 1 Tag is found with URL: " + biologyBookPage.canonicalData.getAttribute("href"));

            Assert.assertTrue(biologyBookPage.verifyHyperLinkTagsAndParseTheURLOfTags(), assertFailurePreText + "Presence of hyperlinked words on the 3.11 concepts of biology book.");
            reportLog("Presence of all the hyperlinked words terms on the 3.11 concept of Biology book.");

            Assert.assertTrue(biologyBookPage.verifyTheVocabularyTermsOfBiologyBook(), assertFailurePreText + "Presence of vocabulary terms on the 3.11 concepts of biology book.");
            reportLog("Presence of all the vocabulary terms on the 3.11 concept of Biology book.");

            Assert.assertTrue(biologyBookPage.verifyHTagsInBook(), assertFailurePreText + "Presence of Header tag on the 3.11 concepts of biology book.");
            reportLog("Presence of all Header tag on the 3.11 concept of Biology book.");

            Assert.assertTrue(biologyBookPage.verifyDidYouKnowSection(), assertFailurePreText + "Presence of Did you know section on the 3.11 concepts of biology book.");
            reportLog("Did you know section is present on the 3.11 concept of Biology book.");

            for (int i = 0; i <= 8; i++) {
                scrollByPixel(500);
                basePage.waitForSec(4);
            }

            Assert.assertTrue(biologyBookPage.verifyTheImagesOfBiologyBook(), assertFailurePreText + "Presence of images on the 3.11 concepts of biology book.");
            reportLog("Presence of all images on the 3.11 concept of Biology book.");

            Assert.assertTrue(biologyBookPage.verifyTheVideosOfBiologyBook(), assertFailurePreText + "Presence of videos on the 3.11 concepts of biology book.");
            reportLog("Presence of all the videos on the 3.11 concept of Biology book.");

        } catch (Exception e) {
            result = handleException(e);
        }
        Assert.assertTrue(result, "Test script failed for" + currentMethodName + errorMessage);
    }

    @Test(priority = 12, description = "Verify the Content of 3.12 Genetic Disorders concept of Biology book.")
    public void verifyContentOfGeneticDisordersConcept() {
        boolean result = true;
        try {
            String url = "https://flexbooks.ck12.org/cbook/ck-12-biology-flexbook-2.0/section/3.12/primary/lesson/genetic-disorders-bio/";

            webDriver.navigate().to(url);

            Assert.assertTrue(biologyBookPage.verifyModalityPageTitle("Genetic Disorders"), assertFailurePreText + "Presence of title on the 3.12 concepts of biology book.");
            reportLog("Verified Modality title: " + webDriver.getTitle() + "on the 3.12 concept of Biology book.");

            reportLog("The Page Description is: " + biologyBookPage.pageDescription.getAttribute("content"));

            Assert.assertTrue(biologyBookPage.verifyCanonicalMetaTag(), assertFailurePreText + "Presence of canonical meta tag on the 3.12 concepts of biology book.");
            reportLog("Verified Canonical Tag and 1 Tag is found with URL: " + biologyBookPage.canonicalData.getAttribute("href"));

            Assert.assertTrue(biologyBookPage.verifyHyperLinkTagsAndParseTheURLOfTags(), assertFailurePreText + "Presence of hyperlinked words on the 3.12 concepts of biology book.");
            reportLog("Presence of all the hyperlinked words terms on the 3.12 concept of Biology book.");

            Assert.assertTrue(biologyBookPage.verifyTheVocabularyTermsOfBiologyBook(), assertFailurePreText + "Presence of vocabulary terms on the 3.12 concepts of biology book.");
            reportLog("Presence of all the vocabulary terms on the 3.12 concept of Biology book.");

            Assert.assertTrue(biologyBookPage.verifyHTagsInBook(), assertFailurePreText + "Presence of Header tag on the 3.12 concepts of biology book.");
            reportLog("Presence of all Header tag on the 3.12 concept of Biology book.");

            Assert.assertTrue(biologyBookPage.verifyDidYouKnowSection(), assertFailurePreText + "Presence of Did you know section on the 3.12 concepts of biology book.");
            reportLog("Did you know section is present on the 3.12 concept of Biology book.");

            for (int i = 0; i <= 8; i++) {
                scrollByPixel(500);
                basePage.waitForSec(4);
            }

            Assert.assertTrue(biologyBookPage.verifyTheImagesOfBiologyBook(), assertFailurePreText + "Presence of images on the 3.12 concepts of biology book.");
            reportLog("Presence of all images on the 3.12 concept of Biology book.");

            Assert.assertTrue(biologyBookPage.verifyTheVideosOfBiologyBook(), assertFailurePreText + "Presence of videos on the 3.12 concepts of biology book.");
            reportLog("Presence of all the videos on the 3.12 concept of Biology book.");

        } catch (Exception e) {
            result = handleException(e);
        }
        Assert.assertTrue(result, "Test script failed for" + currentMethodName + errorMessage);
    }

    @Test(priority = 13, description = "Verify the Content of 3.13 Biotechnology concept of Biology book.")
    public void verifyContentOfBiotechnologyConcept() {
        boolean result = true;
        try {
            String url = "https://flexbooks.ck12.org/cbook/ck-12-biology-flexbook-2.0/section/3.13/primary/lesson/biotechnology-bio/";

            webDriver.navigate().to(url);

            Assert.assertTrue(biologyBookPage.verifyModalityPageTitle("Biotechnology"), assertFailurePreText + "Presence of title on the 3.13 concepts of biology book.");
            reportLog("Verified Modality title: " + webDriver.getTitle() + "on the 3.13 concept of Biology book.");

            reportLog("The Page Description is: " + biologyBookPage.pageDescription.getAttribute("content"));

            Assert.assertTrue(biologyBookPage.verifyCanonicalMetaTag(), assertFailurePreText + "Presence of canonical meta tag on the 3.13 concepts of biology book.");
            reportLog("Verified Canonical Tag and 1 Tag is found with URL: " + biologyBookPage.canonicalData.getAttribute("href"));

            Assert.assertTrue(biologyBookPage.verifyHyperLinkTagsAndParseTheURLOfTags(), assertFailurePreText + "Presence of hyperlinked words on the 3.13 concepts of biology book.");
            reportLog("Presence of all the hyperlinked words terms on the 3.13 concept of Biology book.");

            Assert.assertTrue(biologyBookPage.verifyTheVocabularyTermsOfBiologyBook(), assertFailurePreText + "Presence of vocabulary terms on the 3.13 concepts of biology book.");
            reportLog("Presence of all the vocabulary terms on the 3.13 concept of Biology book.");

            Assert.assertTrue(biologyBookPage.verifyHTagsInBook(), assertFailurePreText + "Presence of Header tag on the 3.13 concepts of biology book.");
            reportLog("Presence of all Header tag on the 3.13 concept of Biology book.");

            Assert.assertTrue(biologyBookPage.verifyDidYouKnowSection(), assertFailurePreText + "Presence of Did you know section on the 3.13 concepts of biology book.");
            reportLog("Did you know section is present on the 3.13 concept of Biology book.");

            for (int i = 0; i <= 8; i++) {
                scrollByPixel(500);
                basePage.waitForSec(4);
            }

            Assert.assertTrue(biologyBookPage.verifyTheImagesOfBiologyBook(), assertFailurePreText + "Presence of images on the 3.13 concepts of biology book.");
            reportLog("Presence of all images on the 3.13 concept of Biology book.");

            Assert.assertTrue(biologyBookPage.verifyTheVideosOfBiologyBook(), assertFailurePreText + "Presence of videos on the 3.13 concepts of biology book.");
            reportLog("Presence of all the videos on the 3.13 concept of Biology book.");

        } catch (Exception e) {
            result = handleException(e);
        }
        Assert.assertTrue(result, "Test script failed for" + currentMethodName + errorMessage);
    }

    @Test(priority = 14, description = "Verify the Content of 3.14 Biotechnology Applications concept of Biology book.")
    public void verifyContentOfBiotechnologyApplicationsConcept() {
        boolean result = true;
        try {
            String url = "https://flexbooks.ck12.org/cbook/ck-12-biology-flexbook-2.0/section/3.14/primary/lesson/biotechnology-applications-bio/";

            webDriver.navigate().to(url);

            Assert.assertTrue(biologyBookPage.verifyModalityPageTitle("Biotechnology Applications"), assertFailurePreText + "Presence of title on the 3.14 concepts of biology book.");
            reportLog("Verified Modality title: " + webDriver.getTitle() + "on the 3.14 concept of Biology book.");

            reportLog("The Page Description is: " + biologyBookPage.pageDescription.getAttribute("content"));

            Assert.assertTrue(biologyBookPage.verifyCanonicalMetaTag(), assertFailurePreText + "Presence of canonical meta tag on the 3.14 concepts of biology book.");
            reportLog("Verified Canonical Tag and 1 Tag is found with URL: " + biologyBookPage.canonicalData.getAttribute("href"));

            Assert.assertTrue(biologyBookPage.verifyHyperLinkTagsAndParseTheURLOfTags(), assertFailurePreText + "Presence of hyperlinked words on the 3.14 concepts of biology book.");
            reportLog("Presence of all the hyperlinked words terms on the 3.14 concept of Biology book.");

            Assert.assertTrue(biologyBookPage.verifyTheVocabularyTermsOfBiologyBook(), assertFailurePreText + "Presence of vocabulary terms on the 3.14 concepts of biology book.");
            reportLog("Presence of all the vocabulary terms on the 3.14 concept of Biology book.");

            Assert.assertTrue(biologyBookPage.verifyHTagsInBook(), assertFailurePreText + "Presence of Header tag on the 3.14 concepts of biology book.");
            reportLog("Presence of all Header tag on the 3.14 concept of Biology book.");

            Assert.assertTrue(biologyBookPage.verifyDidYouKnowSection(), assertFailurePreText + "Presence of Did you know section on the 3.14 concepts of biology book.");
            reportLog("Did you know section is present on the 3.14 concept of Biology book.");

            for (int i = 0; i <= 8; i++) {
                scrollByPixel(500);
                basePage.waitForSec(4);
            }

            Assert.assertTrue(biologyBookPage.verifyTheImagesOfBiologyBook(), assertFailurePreText + "Presence of images on the 3.14 concepts of biology book.");
            reportLog("Presence of all images on the 3.14 concept of Biology book.");

            Assert.assertTrue(biologyBookPage.verifyTheVideosOfBiologyBook(), assertFailurePreText + "Presence of videos on the 3.14 concepts of biology book.");
            reportLog("Presence of all the videos on the 3.14 concept of Biology book.");

        } catch (Exception e) {
            result = handleException(e);
        }
        Assert.assertTrue(result, "Test script failed for" + currentMethodName + errorMessage);
    }

    @Test(priority = 15, description = "Verify the Content of 3.15 (ELSI) concept of Biology book.")
    public void verifyContentOfELSIConcept() {
        boolean result = true;
        try {
            String url = "https://flexbooks.ck12.org/cbook/ck-12-biology-flexbook-2.0/section/3.15/primary/lesson/ethical-legal-and-social-issues-of-biotechnology-bio/";

            webDriver.navigate().to(url);

            Assert.assertTrue(biologyBookPage.verifyModalityPageTitle("Ethical, Legal, and Social Issues in Biotechnology (ELSI)"), assertFailurePreText + "Presence of title on the 3.15 concepts of biology book.");
            reportLog("Verified Modality title: " + webDriver.getTitle() + "on the 3.15 concept of Biology book.");

            reportLog("The Page Description is: " + biologyBookPage.pageDescription.getAttribute("content"));

            Assert.assertTrue(biologyBookPage.verifyCanonicalMetaTag(), assertFailurePreText + "Presence of canonical meta tag on the 3.15 concepts of biology book.");
            reportLog("Verified Canonical Tag and 1 Tag is found with URL: " + biologyBookPage.canonicalData.getAttribute("href"));

            Assert.assertTrue(biologyBookPage.verifyHyperLinkTagsAndParseTheURLOfTags(), assertFailurePreText + "Presence of hyperlinked words on the 3.15 concepts of biology book.");
            reportLog("Presence of all the hyperlinked words terms on the 3.15 concept of Biology book.");

            Assert.assertTrue(biologyBookPage.verifyTheVocabularyTermsOfBiologyBook(), assertFailurePreText + "Presence of vocabulary terms on the 3.15 concepts of biology book.");
            reportLog("Presence of all the vocabulary terms on the 3.15 concept of Biology book.");

            Assert.assertTrue(biologyBookPage.verifyHTagsInBook(), assertFailurePreText + "Presence of Header tag on the 3.15 concepts of biology book.");
            reportLog("Presence of all Header tag on the 3.15 concept of Biology book.");

            Assert.assertTrue(biologyBookPage.verifyDidYouKnowSection(), assertFailurePreText + "Presence of Did you know section on the 3.15 concepts of biology book.");
            reportLog("Did you know section is present on the 3.15 concept of Biology book.");

            for (int i = 0; i <= 8; i++) {
                scrollByPixel(500);
                basePage.waitForSec(4);
            }

            Assert.assertTrue(biologyBookPage.verifyTheImagesOfBiologyBook(), assertFailurePreText + "Presence of images on the 3.15 concepts of biology book.");
            reportLog("Presence of all images on the 3.15 concept of Biology book.");

            Assert.assertTrue(biologyBookPage.verifyTheVideosOfBiologyBook(), assertFailurePreText + "Presence of videos on the 3.15 concepts of biology book.");
            reportLog("Presence of all the videos on the 3.15 concept of Biology book.");

        } catch (Exception e) {
            result = handleException(e);
        }
        Assert.assertTrue(result, "Test script failed for" + currentMethodName + errorMessage);
    }
}