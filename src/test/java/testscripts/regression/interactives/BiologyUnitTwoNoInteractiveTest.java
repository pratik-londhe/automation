package testscripts.regression.interactives;

import org.openqa.selenium.JavascriptExecutor;
import org.testng.Assert;
import org.testng.annotations.Test;
import testscripts.BaseTestScript;
import uipages.BasePage;
import uipages.flexbook2feature.LoginPage;
import uipages.flexbook2feature.TeacherDashboardPage;
import uipages.interactives.BiologyBookPage;

public class BiologyUnitTwoNoInteractiveTest extends BaseTestScript {
    private BiologyBookPage biologyBookPage;
    private BasePage basePage;

    @Test(priority = 1, dataProvider = "CK12DataProvider", description = "Verify the Content of 2.1 Parts of the Cell concept of Biology book.")
    public void verifyContentOfPartOfTheCellConcept(String email, String password, String conceptScientificMethod) {
        boolean result = true;
        try {
            LoginPage loginPage = new LoginPage(webDriver, extentTest, extentReports);
            biologyBookPage = new BiologyBookPage(webDriver, extentTest, extentReports);
            basePage = new BasePage(webDriver, extentTest, extentReports);

            loginPage.teacherLogin(email, password);

            Assert.assertTrue(new TeacherDashboardPage(webDriver, extentTest, extentReports).verifyTeacherProfileOnGamma(), assertFailurePreText + "Presence of Teacher account icon On Gamma");
            reportLog("Presence of Teacher account icon On Gamma");

            webDriver.navigate().to(conceptScientificMethod);

            Assert.assertTrue(biologyBookPage.verifyModalityPageTitle("Parts of the Cell"), assertFailurePreText + "Presence of title on the 2.1 concepts of biology book.");
            reportLog("Verified Modality title: " + webDriver.getTitle() + "on the 2.1 concept of Biology book.");

            reportLog("The Page Description is: " + biologyBookPage.pageDescription.getAttribute("content"));

            Assert.assertTrue(biologyBookPage.verifyCanonicalMetaTag(), assertFailurePreText + "Presence of canonical meta tag on the 2.1 concepts of biology book.");
            reportLog("Verified Canonical Tag and 1 Tag is found with URL: " + biologyBookPage.canonicalData.getAttribute("href"));

            Assert.assertTrue(biologyBookPage.verifyHyperLinkTagsAndParseTheURLOfTags(), assertFailurePreText + "Presence of hyperlinked words on the 2.1 concepts of biology book.");
            reportLog("Hyperlinked words terms are not there for the 2.1 concept of Biology book.");

            Assert.assertTrue(biologyBookPage.verifyTheVocabularyTermsOfBiologyBook(), assertFailurePreText + "Presence of vocabulary terms on the 2.1 concepts of biology book.");
            reportLog("Vocabulary terms are not there for the 2.1 concept of Biology book.");

            Assert.assertTrue(biologyBookPage.verifyHTagsInBook(), assertFailurePreText + "Presence of Header tag on the 2.1 concepts of biology book.");
            reportLog("Presence of all Header tag on the 2.1 concept of Biology book.");

            Assert.assertTrue(biologyBookPage.verifyDidYouKnowSection(), assertFailurePreText + "Presence of Did you know section on the 2.1 concepts of biology book.");
            reportLog("Did you know section is not there for the 2.1 concept of Biology book.");

            for (int i = 0; i <= 8; i++) {
                scrollByPixel(500);
                basePage.waitForSec(4);
            }

            Assert.assertTrue(biologyBookPage.verifyTheImagesOfBiologyBook(), assertFailurePreText + "Presence of images on the 2.1 concepts of biology book.");
            reportLog("Presence of all images on the 2.1 concept of Biology book.");

            Assert.assertTrue(biologyBookPage.verifyTheVideosOfBiologyBook(), assertFailurePreText + "Presence of videos on the 2.1 concepts of biology book.");
            reportLog("Presence of all the videos on the 2.1 concept of Biology book.");

        } catch (Exception e) {
            result = handleException(e);
        }
        Assert.assertTrue(result, "Test script failed for" + currentMethodName + errorMessage);
    }

    @Test(priority = 2, description = "Verify the Content of 2.2 Prokaryotic and Eukaryotic Cells concept of Biology book.")
    public void verifyContentOfProkaryoticAndEukaryoticCellsConcept() {
        boolean result = true;
        try {
            String url = "https://flexbooks.ck12.org/cbook/ck-12-biology-flexbook-2.0/section/2.2/primary/lesson/prokaryotic-and-eukaryotic-cells-bio/";

            webDriver.navigate().to(url);

            Assert.assertTrue(biologyBookPage.verifyModalityPageTitle("Prokaryotic and Eukaryotic Cells"), assertFailurePreText + "Presence of title on the 2.2 concepts of biology book.");
            reportLog("Verified Modality title: " + webDriver.getTitle() + "on the 2.2 concept of Biology book.");

            reportLog("The Page Description is: " + biologyBookPage.pageDescription.getAttribute("content"));

            Assert.assertTrue(biologyBookPage.verifyCanonicalMetaTag(), assertFailurePreText + "Presence of canonical meta tag on the 2.2 concepts of biology book.");
            reportLog("Verified Canonical Tag and 1 Tag is found with URL: " + biologyBookPage.canonicalData.getAttribute("href"));

            Assert.assertTrue(biologyBookPage.verifyHyperLinkTagsAndParseTheURLOfTags(), assertFailurePreText + "Presence of hyperlinked words on the 2.2 concepts of biology book.");
            reportLog("Hyperlinked words terms are not there for the 2.2 concept of Biology book.");

            Assert.assertTrue(biologyBookPage.verifyTheVocabularyTermsOfBiologyBook(), assertFailurePreText + "Presence of vocabulary terms on the 2.2 concepts of biology book.");
            reportLog("Vocabulary terms are not there for the 2.2 concept of Biology book.");

            Assert.assertTrue(biologyBookPage.verifyHTagsInBook(), assertFailurePreText + "Presence of Header tag on the 2.2 concepts of biology book.");
            reportLog("Presence of all Header tag on the 2.2 concept of Biology book.");

            Assert.assertTrue(biologyBookPage.verifyDidYouKnowSection(), assertFailurePreText + "Presence of Did you know section on the 2.2 concepts of biology book.");
            reportLog("Presence of all Did you know section on the 2.2 concept of Biology book.");

            for (int i = 0; i <= 8; i++) {
                scrollByPixel(500);
                basePage.waitForSec(4);
            }

            Assert.assertTrue(biologyBookPage.verifyTheImagesOfBiologyBook(), assertFailurePreText + "Presence of images on the 2.2 concepts of biology book.");
            reportLog("Presence of all images on the 2.2 concept of Biology book.");

            Assert.assertTrue(biologyBookPage.verifyTheVideosOfBiologyBook(), assertFailurePreText + "Presence of videos on the 2.2 concepts of biology book.");
            reportLog("Presence of all the videos on the 2.2 concept of Biology book.");

        } catch (Exception e) {
            result = handleException(e);
        }
        Assert.assertTrue(result, "Test script failed for" + currentMethodName + errorMessage);
    }

    @Test(priority = 3, description = "Verify the Content of 2.3 Phospholipid Bilayer concept of Biology book.")
    public void verifyContentOfPhospholipidBilayerConcept() {
        boolean result = true;
        try {
            String url = "https://flexbooks.ck12.org/cbook/ck-12-biology-flexbook-2.0/section/2.3/primary/lesson/phospholipid-bilayers-bio/";

            webDriver.navigate().to(url);

            Assert.assertTrue(biologyBookPage.verifyModalityPageTitle("Phospholipid Bilayer"), assertFailurePreText + "Presence of title on the 2.3 concepts of biology book.");
            reportLog("Verified Modality title: " + webDriver.getTitle() + "on the 2.3 concept of Biology book.");

            reportLog("The Page Description is: " + biologyBookPage.pageDescription.getAttribute("content"));

            Assert.assertTrue(biologyBookPage.verifyCanonicalMetaTag(), assertFailurePreText + "Presence of canonical meta tag on the 2.3 concepts of biology book.");
            reportLog("Verified Canonical Tag and 1 Tag is found with URL: " + biologyBookPage.canonicalData.getAttribute("href"));

            Assert.assertTrue(biologyBookPage.verifyHyperLinkTagsAndParseTheURLOfTags(), assertFailurePreText + "Presence of hyperlinked words on the 2.3 concepts of biology book.");
            reportLog("Hyperlinked words terms are not there for the 2.3 concept of Biology book.");

            Assert.assertTrue(biologyBookPage.verifyTheVocabularyTermsOfBiologyBook(), assertFailurePreText + "Presence of vocabulary terms on the 2.3 concepts of biology book.");
            reportLog("Vocabulary terms are not there for the 2.3 concept of Biology book.");

            Assert.assertTrue(biologyBookPage.verifyHTagsInBook(), assertFailurePreText + "Presence of Header tag on the 2.3 concepts of biology book.");
            reportLog("Presence of all Header tag on the 2.3 concept of Biology book.");

            Assert.assertTrue(biologyBookPage.verifyDidYouKnowSection(), assertFailurePreText + "Presence of Did you know section on the 2.3 concepts of biology book.");
            reportLog("Presence of all Did you know section on the 2.3 concept of Biology book.");

            for (int i = 0; i <= 8; i++) {
                scrollByPixel(500);
                basePage.waitForSec(4);
            }

            Assert.assertTrue(biologyBookPage.verifyTheImagesOfBiologyBook(), assertFailurePreText + "Presence of images on the 2.3 concepts of biology book.");
            reportLog("Presence of all images on the 2.3 concept of Biology book.");

            Assert.assertTrue(biologyBookPage.verifyTheVideosOfBiologyBook(), assertFailurePreText + "Presence of videos on the 2.3 concepts of biology book.");
            reportLog("Presence of all the videos on the 2.3 concept of Biology book.");

        } catch (Exception e) {
            result = handleException(e);
        }
        Assert.assertTrue(result, "Test script failed for" + currentMethodName + errorMessage);
    }

    @Test(priority = 4, description = "Verify the Content of 2.4 Membrane Proteins concept of Biology book.")
    public void verifyContentOfMembraneProteinsConcept() {
        boolean result = true;
        try {
            String url = "https://flexbooks.ck12.org/cbook/ck-12-biology-flexbook-2.0/section/2.4/primary/lesson/membrane-proteins-bio/";

            webDriver.navigate().to(url);

            Assert.assertTrue(biologyBookPage.verifyModalityPageTitle("Membrane Proteins"), assertFailurePreText + "Presence of title on the 2.4 concepts of biology book.");
            reportLog("Verified Modality title: " + webDriver.getTitle() + "on the 2.4 concept of Biology book.");

            reportLog("The Page Description is: " + biologyBookPage.pageDescription.getAttribute("content"));

            Assert.assertTrue(biologyBookPage.verifyCanonicalMetaTag(), assertFailurePreText + "Presence of canonical meta tag on the 2.4 concepts of biology book.");
            reportLog("Verified Canonical Tag and 1 Tag is found with URL: " + biologyBookPage.canonicalData.getAttribute("href"));

            Assert.assertTrue(biologyBookPage.verifyHyperLinkTagsAndParseTheURLOfTags(), assertFailurePreText + "Presence of hyperlinked words on the 2.4 concepts of biology book.");
            reportLog("Hyperlinked words terms are not there for the 2.4 concept of Biology book.");

            Assert.assertTrue(biologyBookPage.verifyTheVocabularyTermsOfBiologyBook(), assertFailurePreText + "Presence of vocabulary terms on the 2.4 concepts of biology book.");
            reportLog("Vocabulary terms are not there for the 2.4 concept of Biology book.");

            Assert.assertTrue(biologyBookPage.verifyHTagsInBook(), assertFailurePreText + "Presence of Header tag on the 2.4 concepts of biology book.");
            reportLog("Presence of all Header tag on the 2.4 concept of Biology book.");

            Assert.assertTrue(biologyBookPage.verifyDidYouKnowSection(), assertFailurePreText + "Presence of Did you know section on the 2.4 concepts of biology book.");
            reportLog("Presence of all Did you know section on the 2.4 concept of Biology book.");

            for (int i = 0; i <= 8; i++) {
                scrollByPixel(500);
                basePage.waitForSec(4);
            }

            Assert.assertTrue(biologyBookPage.verifyTheImagesOfBiologyBook(), assertFailurePreText + "Presence of images on the 2.4 concepts of biology book.");
            reportLog("Presence of all images on the 2.4 concept of Biology book.");

            Assert.assertTrue(biologyBookPage.verifyTheVideosOfBiologyBook(), assertFailurePreText + "Presence of videos on the 2.4 concepts of biology book.");
            reportLog("Presence of all the videos on the 2.4 concept of Biology book.");

        } catch (Exception e) {
            result = handleException(e);
        }
        Assert.assertTrue(result, "Test script failed for" + currentMethodName + errorMessage);
    }

    @Test(priority = 5, description = "Verify the Content of 2.5 Cytoplasm and Cytoskeleton concept of Biology book.")
    public void verifyContentOfCytoplasmAndCytoskeletonConcept() {
        boolean result = true;
        try {
            String url = "https://flexbooks.ck12.org/cbook/ck-12-biology-flexbook-2.0/section/2.5/primary/lesson/cytoplasm-and-cytoskeletons-bio/";

            webDriver.navigate().to(url);

            Assert.assertTrue(biologyBookPage.verifyModalityPageTitle("Cytoplasm and Cytoskeleton"), assertFailurePreText + "Presence of title on the 2.5 concepts of biology book.");
            reportLog("Verified Modality title: " + webDriver.getTitle() + "on the 2.5 concept of Biology book.");

            reportLog("The Page Description is: " + biologyBookPage.pageDescription.getAttribute("content"));

            Assert.assertTrue(biologyBookPage.verifyCanonicalMetaTag(), assertFailurePreText + "Presence of canonical meta tag on the 2.5 concepts of biology book.");
            reportLog("Verified Canonical Tag and 1 Tag is found with URL: " + biologyBookPage.canonicalData.getAttribute("href"));

            Assert.assertTrue(biologyBookPage.verifyHyperLinkTagsAndParseTheURLOfTags(), assertFailurePreText + "Presence of hyperlinked words on the 2.5 concepts of biology book.");
            reportLog("Presence of all the hyperlinked words terms on the 2.5 concept of Biology book.");

            Assert.assertTrue(biologyBookPage.verifyTheVocabularyTermsOfBiologyBook(), assertFailurePreText + "Presence of vocabulary terms on the 2.5 concepts of biology book.");
            reportLog("Presence of all the vocabulary terms on the 2.5 concept of Biology book.");

            Assert.assertTrue(biologyBookPage.verifyHTagsInBook(), assertFailurePreText + "Presence of Header tag on the 2.5 concepts of biology book.");
            reportLog("Presence of all Header tag on the 2.5 concept of Biology book.");

            Assert.assertTrue(biologyBookPage.verifyDidYouKnowSection(), assertFailurePreText + "Presence of Did you know section on the 2.5 concepts of biology book.");
            reportLog("Presence of all Did you know section on the 2.5 concept of Biology book.");

            for (int i = 0; i <= 8; i++) {
                scrollByPixel(500);
                basePage.waitForSec(4);
            }

            Assert.assertTrue(biologyBookPage.verifyTheImagesOfBiologyBook(), assertFailurePreText + "Presence of images on the 2.5 concepts of biology book.");
            reportLog("Presence of all images on the 2.5 concept of Biology book.");

            Assert.assertTrue(biologyBookPage.verifyTheVideosOfBiologyBook(), assertFailurePreText + "Presence of videos on the 2.5 concepts of biology book.");
            reportLog("Presence of all the videos on the 2.5 concept of Biology book.");

        } catch (Exception e) {
            result = handleException(e);
        }
        Assert.assertTrue(result, "Test script failed for" + currentMethodName + errorMessage);
    }

    @Test(priority = 6, description = "Verify the Content of 2.6 Nucleus concept of Biology book.")
    public void verifyContentOfNucleusConcept() {
        boolean result = true;
        try {
            String url = "https://flexbooks.ck12.org/cbook/ck-12-biology-flexbook-2.0/section/2.6/primary/lesson/cell-nucleus-bio/";

            webDriver.navigate().to(url);

            Assert.assertTrue(biologyBookPage.verifyModalityPageTitle("Nucleus"), assertFailurePreText + "Presence of title on the 2.5 concepts of biology book.");
            reportLog("Verified Modality title: " + webDriver.getTitle() + "on the 2.6 concept of Biology book.");

            reportLog("The Page Description is: " + biologyBookPage.pageDescription.getAttribute("content"));

            Assert.assertTrue(biologyBookPage.verifyCanonicalMetaTag(), assertFailurePreText + "Presence of canonical meta tag on the 2.6 concepts of biology book.");
            reportLog("Verified Canonical Tag and 1 Tag is found with URL: " + biologyBookPage.canonicalData.getAttribute("href"));

            Assert.assertTrue(biologyBookPage.verifyHyperLinkTagsAndParseTheURLOfTags(), assertFailurePreText + "Presence of hyperlinked words on the 2.6 concepts of biology book.");
            reportLog("Presence of all the hyperlinked words terms on the 2.6 concept of Biology book.");

            Assert.assertTrue(biologyBookPage.verifyTheVocabularyTermsOfBiologyBook(), assertFailurePreText + "Presence of vocabulary terms on the 2.6 concepts of biology book.");
            reportLog("Presence of all the vocabulary terms on the 2.6 concept of Biology book.");

            Assert.assertTrue(biologyBookPage.verifyHTagsInBook(), assertFailurePreText + "Presence of Header tag on the 2.6 concepts of biology book.");
            reportLog("Presence of all Header tag on the 2.6 concept of Biology book.");

            Assert.assertTrue(biologyBookPage.verifyDidYouKnowSection(), assertFailurePreText + "Presence of Did you know section on the 2.6 concepts of biology book.");
            reportLog("Presence of all Did you know section on the 2.6 concept of Biology book.");

            for (int i = 0; i <= 8; i++) {
                scrollByPixel(500);
                basePage.waitForSec(4);
            }

            Assert.assertTrue(biologyBookPage.verifyTheImagesOfBiologyBook(), assertFailurePreText + "Presence of images on the 2.6 concepts of biology book.");
            reportLog("Presence of all images on the 2.6 concept of Biology book.");

            Assert.assertTrue(biologyBookPage.verifyTheVideosOfBiologyBook(), assertFailurePreText + "Presence of videos on the 2.6 concepts of biology book.");
            reportLog("Presence of all the videos on the 2.6 concept of Biology book.");

        } catch (Exception e) {
            result = handleException(e);
        }
        Assert.assertTrue(result, "Test script failed for" + currentMethodName + errorMessage);
    }

    @Test(priority = 7, description = "Verify the Content of 2.7 Ribosomes and Mitochondria concept of Biology book.")
    public void verifyContentOfRibosomesAndMitochondriaConcept() {
        boolean result = true;
        try {
            String url = "https://flexbooks.ck12.org/cbook/ck-12-biology-flexbook-2.0/section/2.7/primary/lesson/ribosomes-and-mitochondria-bio/";

            webDriver.navigate().to(url);

            Assert.assertTrue(biologyBookPage.verifyModalityPageTitle("Ribosomes and Mitochondria"), assertFailurePreText + "Presence of title on the 2.7 concepts of biology book.");
            reportLog("Verified Modality title: " + webDriver.getTitle() + "on the 2.7 concept of Biology book.");

            reportLog("The Page Description is: " + biologyBookPage.pageDescription.getAttribute("content"));

            Assert.assertTrue(biologyBookPage.verifyCanonicalMetaTag(), assertFailurePreText + "Presence of canonical meta tag on the 2.7 concepts of biology book.");
            reportLog("Verified Canonical Tag and 1 Tag is found with URL: " + biologyBookPage.canonicalData.getAttribute("href"));

            Assert.assertTrue(biologyBookPage.verifyHyperLinkTagsAndParseTheURLOfTags(), assertFailurePreText + "Presence of hyperlinked words on the 2.7 concepts of biology book.");
            reportLog("Hyperlinked words terms are not there for the 2.7 concept of Biology book.");

            Assert.assertTrue(biologyBookPage.verifyTheVocabularyTermsOfBiologyBook(), assertFailurePreText + "Presence of vocabulary terms on the 2.7 concepts of biology book.");
            reportLog("Presence of all the vocabulary terms on the 2.7 concept of Biology book.");

            Assert.assertTrue(biologyBookPage.verifyHTagsInBook(), assertFailurePreText + "Presence of Header tag on the 2.7 concepts of biology book.");
            reportLog("Presence of all Header tag on the 2.7 concept of Biology book.");

            Assert.assertTrue(biologyBookPage.verifyDidYouKnowSection(), assertFailurePreText + "Presence of Did you know section on the 2.7 concepts of biology book.");
            reportLog("Presence of all Did you know section on the 2.7 concept of Biology book.");

            for (int i = 0; i <= 8; i++) {
                scrollByPixel(500);
                basePage.waitForSec(4);
            }

            Assert.assertTrue(biologyBookPage.verifyTheImagesOfBiologyBook(), assertFailurePreText + "Presence of images on the 2.7 concepts of biology book.");
            reportLog("Presence of all images on the 2.7 concept of Biology book.");

            Assert.assertTrue(biologyBookPage.verifyTheVideosOfBiologyBook(), assertFailurePreText + "Presence of videos on the 2.7 concepts of biology book.");
            reportLog("Presence of all the videos on the 2.7 concept of Biology book.");

        } catch (Exception e) {
            result = handleException(e);
        }
        Assert.assertTrue(result, "Test script failed for" + currentMethodName + errorMessage);
    }

    @Test(priority = 8, description = "Verify the Content of 2.8 Cell Structure concept of Biology book.")
    public void verifyContentOfCellStructureConcept() {
        boolean result = true;
        try {
            String url = "https://flexbooks.ck12.org/cbook/ck-12-biology-flexbook-2.0/section/2.8/primary/lesson/other-cell-organelles-bio/";

            webDriver.navigate().to(url);

            Assert.assertTrue(biologyBookPage.verifyModalityPageTitle("Cell Structure"), assertFailurePreText + "Presence of title on the 2.8 concepts of biology book.");
            reportLog("Verified Modality title: " + webDriver.getTitle() + "on the 2.8 concept of Biology book.");

            reportLog("The Page Description is: " + biologyBookPage.pageDescription.getAttribute("content"));

            Assert.assertTrue(biologyBookPage.verifyCanonicalMetaTag(), assertFailurePreText + "Presence of canonical meta tag on the 2.8 concepts of biology book.");
            reportLog("Verified Canonical Tag and 1 Tag is found with URL: " + biologyBookPage.canonicalData.getAttribute("href"));

            Assert.assertTrue(biologyBookPage.verifyHyperLinkTagsAndParseTheURLOfTags(), assertFailurePreText + "Presence of hyperlinked words on the 2.8 concepts of biology book.");
            reportLog("Hyperlinked words terms are not there for the 2.8 concept of Biology book.");

            Assert.assertTrue(biologyBookPage.verifyTheVocabularyTermsOfBiologyBook(), assertFailurePreText + "Presence of vocabulary terms on the 2.8 concepts of biology book.");
            reportLog("Vocabulary terms are not there for the 2.8 concept of Biology book.");

            Assert.assertTrue(biologyBookPage.verifyHTagsInBook(), assertFailurePreText + "Presence of Header tag on the 2.8 concepts of biology book.");
            reportLog("Presence of all Header tag on the 2.8 concept of Biology book.");

            Assert.assertTrue(biologyBookPage.verifyDidYouKnowSection(), assertFailurePreText + "Presence of Did you know section on the 2.8 concepts of biology book.");
            reportLog("Presence of all Did you know section on the 2.8 concept of Biology book.");

            for (int i = 0; i <= 8; i++) {
                scrollByPixel(500);
                basePage.waitForSec(4);
            }

            Assert.assertTrue(biologyBookPage.verifyTheImagesOfBiologyBook(), assertFailurePreText + "Presence of images on the 2.8 concepts of biology book.");
            reportLog("Presence of all images on the 2.8 concept of Biology book.");

            Assert.assertTrue(biologyBookPage.verifyTheVideosOfBiologyBook(), assertFailurePreText + "Presence of videos on the 2.8 concepts of biology book.");
            reportLog("Presence of all the videos on the 2.8 concept of Biology book.");

        } catch (Exception e) {
            result = handleException(e);
        }
        Assert.assertTrue(result, "Test script failed for" + currentMethodName + errorMessage);
    }

    @Test(priority = 9, description = "Verify the Content of 2.9 Plant Cell Structure concept of Biology book.")
    public void verifyContentOfPlantCellStructureConcept() {
        boolean result = true;
        try {
            String url = "https://flexbooks.ck12.org/cbook/ck-12-biology-flexbook-2.0/section/2.9/primary/lesson/plant-cell-structures-bio/";

            webDriver.navigate().to(url);

            Assert.assertTrue(biologyBookPage.verifyModalityPageTitle("Plant Cell Structure"), assertFailurePreText + "Presence of title on the 2.9 concepts of biology book.");
            reportLog("Verified Modality title: " + webDriver.getTitle() + "on the 2.9 concept of Biology book.");

            reportLog("The Page Description is: " + biologyBookPage.pageDescription.getAttribute("content"));

            Assert.assertTrue(biologyBookPage.verifyCanonicalMetaTag(), assertFailurePreText + "Presence of canonical meta tag on the 2.9 concepts of biology book.");
            reportLog("Verified Canonical Tag and 1 Tag is found with URL: " + biologyBookPage.canonicalData.getAttribute("href"));

            Assert.assertTrue(biologyBookPage.verifyHyperLinkTagsAndParseTheURLOfTags(), assertFailurePreText + "Presence of hyperlinked words on the 2.9 concepts of biology book.");
            reportLog("Presence of all the hyperlinked words terms on the 2.9 concept of Biology book.");

            Assert.assertTrue(biologyBookPage.verifyTheVocabularyTermsOfBiologyBook(), assertFailurePreText + "Presence of vocabulary terms on the 2.9 concepts of biology book.");
            reportLog("Presence of all the vocabulary terms on the 2.9 concept of Biology book.");

            Assert.assertTrue(biologyBookPage.verifyHTagsInBook(), assertFailurePreText + "Presence of Header tag on the 2.9 concepts of biology book.");
            reportLog("Presence of all Header tag on the 2.9 concept of Biology book.");

            Assert.assertTrue(biologyBookPage.verifyDidYouKnowSection(), assertFailurePreText + "Presence of Did you know section on the 2.9 concepts of biology book.");
            reportLog("Presence of all Did you know section on the 2.9 concept of Biology book.");

            for (int i = 0; i <= 8; i++) {
                scrollByPixel(500);
                basePage.waitForSec(4);
            }

            Assert.assertTrue(biologyBookPage.verifyTheImagesOfBiologyBook(), assertFailurePreText + "Presence of images on the 2.9 concepts of biology book.");
            reportLog("Presence of all images on the 2.9 concept of Biology book.");

            Assert.assertTrue(biologyBookPage.verifyTheVideosOfBiologyBook(), assertFailurePreText + "Presence of videos on the 2.9 concepts of biology book.");
            reportLog("Presence of all the videos on the 2.9 concept of Biology book.");

        } catch (Exception e) {
            result = handleException(e);
        }
        Assert.assertTrue(result, "Test script failed for" + currentMethodName + errorMessage);
    }

    @Test(priority = 10, description = "Verify the Content of 2.10 Cell Organization concept of Biology book.")
    public void verifyContentOfCellOrganizationConcept() {
        boolean result = true;
        try {
            String url = "https://flexbooks.ck12.org/cbook/ck-12-biology-flexbook-2.0/section/2.10/primary/lesson/organization-of-cells-bio/";

            webDriver.navigate().to(url);

            Assert.assertTrue(biologyBookPage.verifyModalityPageTitle("Cell Organization"), assertFailurePreText + "Presence of title on the 2.10 concepts of biology book.");
            reportLog("Verified Modality title: " + webDriver.getTitle() + "on the 2.10 concept of Biology book.");

            reportLog("The Page Description is: " + biologyBookPage.pageDescription.getAttribute("content"));

            Assert.assertTrue(biologyBookPage.verifyCanonicalMetaTag(), assertFailurePreText + "Presence of canonical meta tag on the 2.10 concepts of biology book.");
            reportLog("Verified Canonical Tag and 1 Tag is found with URL: " + biologyBookPage.canonicalData.getAttribute("href"));

            Assert.assertTrue(biologyBookPage.verifyHyperLinkTagsAndParseTheURLOfTags(), assertFailurePreText + "Presence of hyperlinked words on the 2.10 concepts of biology book.");
            reportLog("Presence of all the hyperlinked words terms on the 2.10 concept of Biology book.");

            Assert.assertTrue(biologyBookPage.verifyTheVocabularyTermsOfBiologyBook(), assertFailurePreText + "Presence of vocabulary terms on the 2.10 concepts of biology book.");
            reportLog("Presence of all the vocabulary terms on the 2.10 concept of Biology book.");

            Assert.assertTrue(biologyBookPage.verifyHTagsInBook(), assertFailurePreText + "Presence of Header tag on the 2.10 concepts of biology book.");
            reportLog("Presence of all Header tag on the 2.10 concept of Biology book.");

            Assert.assertTrue(biologyBookPage.verifyDidYouKnowSection(), assertFailurePreText + "Presence of Did you know section on the 2.10 concepts of biology book.");
            reportLog("Presence of all Did you know section on the 2.10 concept of Biology book.");

            for (int i = 0; i <= 8; i++) {
                scrollByPixel(500);
                basePage.waitForSec(4);
            }

            Assert.assertTrue(biologyBookPage.verifyTheImagesOfBiologyBook(), assertFailurePreText + "Presence of images on the 2.10 concepts of biology book.");
            reportLog("Presence of all images on the 2.10 concept of Biology book.");

            Assert.assertTrue(biologyBookPage.verifyTheVideosOfBiologyBook(), assertFailurePreText + "Presence of videos on the 2.10 concepts of biology book.");
            reportLog("Presence of all the videos on the 2.10 concept of Biology book.");

        } catch (Exception e) {
            result = handleException(e);
        }
        Assert.assertTrue(result, "Test script failed for" + currentMethodName + errorMessage);
    }

    @Test(priority = 11, description = "Verify the Content of 2.11 Diffusion concept of Biology book.")
    public void verifyContentOfDiffusionConcept() {
        boolean result = true;
        try {
            String url = "https://flexbooks.ck12.org/cbook/ck-12-biology-flexbook-2.0/section/2.11/primary/lesson/diffusion-bio/";

            webDriver.navigate().to(url);

            Assert.assertTrue(biologyBookPage.verifyModalityPageTitle("Diffusion"), assertFailurePreText + "Presence of title on the 2.11 concepts of biology book.");
            reportLog("Verified Modality title: " + webDriver.getTitle() + "on the 2.11 concept of Biology book.");

            reportLog("The Page Description is: " + biologyBookPage.pageDescription.getAttribute("content"));

            Assert.assertTrue(biologyBookPage.verifyCanonicalMetaTag(), assertFailurePreText + "Presence of canonical meta tag on the 2.11 concepts of biology book.");
            reportLog("Verified Canonical Tag and 1 Tag is found with URL: " + biologyBookPage.canonicalData.getAttribute("href"));

            Assert.assertTrue(biologyBookPage.verifyHyperLinkTagsAndParseTheURLOfTags(), assertFailurePreText + "Presence of hyperlinked words on the 2.11 concepts of biology book.");
            reportLog("Presence of all the hyperlinked words terms on the 2.11 concept of Biology book.");

            Assert.assertTrue(biologyBookPage.verifyTheVocabularyTermsOfBiologyBook(), assertFailurePreText + "Presence of vocabulary terms on the 2.11 concepts of biology book.");
            reportLog("Presence of all the vocabulary terms on the 2.11 concept of Biology book.");

            Assert.assertTrue(biologyBookPage.verifyHTagsInBook(), assertFailurePreText + "Presence of Header tag on the 2.11 concepts of biology book.");
            reportLog("Presence of all Header tag on the 2.11 concept of Biology book.");

            Assert.assertTrue(biologyBookPage.verifyDidYouKnowSection(), assertFailurePreText + "Presence of Did you know section on the 2.11 concepts of biology book.");
            reportLog("Did you know section is not there for the 2.11 concept of Biology book.");

            for (int i = 0; i <= 8; i++) {
                scrollByPixel(500);
                basePage.waitForSec(4);
            }

            Assert.assertTrue(biologyBookPage.verifyTheImagesOfBiologyBook(), assertFailurePreText + "Presence of images on the 2.11 concepts of biology book.");
            reportLog("Presence of all images on the 2.11 concept of Biology book.");

            Assert.assertTrue(biologyBookPage.verifyTheVideosOfBiologyBook(), assertFailurePreText + "Presence of videos on the 2.11 concepts of biology book.");
            reportLog("Presence of all the videos on the 2.11 concept of Biology book.");

        } catch (Exception e) {
            result = handleException(e);
        }
        Assert.assertTrue(result, "Test script failed for" + currentMethodName + errorMessage);
    }

    @Test(priority = 12, description = "Verify the Content of 2.12 Osmosis concept of Biology book.")
    public void verifyContentOfOsmosisConcept() {
        boolean result = true;
        try {
            String url = "https://flexbooks.ck12.org/cbook/ck-12-biology-flexbook-2.0/section/2.12/primary/lesson/osmosis-bio/";

            webDriver.navigate().to(url);

            Assert.assertTrue(biologyBookPage.verifyModalityPageTitle("Osmosis"), assertFailurePreText + "Presence of title on the 2.12 concepts of biology book.");
            reportLog("Verified Modality title: " + webDriver.getTitle() + "on the 2.12 concept of Biology book.");

            reportLog("The Page Description is: " + biologyBookPage.pageDescription.getAttribute("content"));

            Assert.assertTrue(biologyBookPage.verifyCanonicalMetaTag(), assertFailurePreText + "Presence of canonical meta tag on the 2.12 concepts of biology book.");
            reportLog("Verified Canonical Tag and 1 Tag is found with URL: " + biologyBookPage.canonicalData.getAttribute("href"));

            Assert.assertTrue(biologyBookPage.verifyHyperLinkTagsAndParseTheURLOfTags(), assertFailurePreText + "Presence of hyperlinked words on the 2.12 concepts of biology book.");
            reportLog("Presence of all the hyperlinked words terms on the 2.12 concept of Biology book.");

            Assert.assertTrue(biologyBookPage.verifyTheVocabularyTermsOfBiologyBook(), assertFailurePreText + "Presence of vocabulary terms on the 2.12 concepts of biology book.");
            reportLog("Presence of all the vocabulary terms on the 2.12 concept of Biology book.");

            Assert.assertTrue(biologyBookPage.verifyHTagsInBook(), assertFailurePreText + "Presence of Header tag on the 2.12 concepts of biology book.");
            reportLog("Presence of all Header tag on the 2.12 concept of Biology book.");

            Assert.assertTrue(biologyBookPage.verifyDidYouKnowSection(), assertFailurePreText + "Presence of Did you know section on the 2.12 concepts of biology book.");
            reportLog("Did you know section is not there for the 2.12 concept of Biology book.");

            ((JavascriptExecutor) webDriver).executeScript("window.scrollBy(0,0)");

            for (int i = 0; i <= 10; i++) {
                scrollByPixel(500);
                basePage.waitForSec(4);
            }

            Assert.assertTrue(biologyBookPage.verifyTheImagesOfBiologyBook(), assertFailurePreText + "Presence of images on the 2.12 concepts of biology book.");
            reportLog("Presence of all images on the 2.12 concept of Biology book.");

            Assert.assertTrue(biologyBookPage.verifyTheVideosOfBiologyBook(), assertFailurePreText + "Presence of videos on the 2.12 concepts of biology book.");
            reportLog("Presence of all the videos on the 2.12 concept of Biology book.");

        } catch (Exception e) {
            result = handleException(e);
        }
        Assert.assertTrue(result, "Test script failed for" + currentMethodName + errorMessage);
    }

    @Test(priority = 13, description = "Verify the Content of 2.13 Passive Transport concept of Biology book.")
    public void verifyContentOfPassiveTransportConcept() {
        boolean result = true;
        try {
            String url = "https://flexbooks.ck12.org/cbook/ck-12-biology-flexbook-2.0/section/2.13/primary/lesson/passive-transport-bio/";

            webDriver.navigate().to(url);

            Assert.assertTrue(biologyBookPage.verifyModalityPageTitle("Passive Transport"), assertFailurePreText + "Presence of title on the 2.13 concepts of biology book.");
            reportLog("Verified Modality title: " + webDriver.getTitle() + "on the 2.13 concept of Biology book.");

            reportLog("The Page Description is: " + biologyBookPage.pageDescription.getAttribute("content"));

            Assert.assertTrue(biologyBookPage.verifyCanonicalMetaTag(), assertFailurePreText + "Presence of canonical meta tag on the 2.13 concepts of biology book.");
            reportLog("Verified Canonical Tag and 1 Tag is found with URL: " + biologyBookPage.canonicalData.getAttribute("href"));

            Assert.assertTrue(biologyBookPage.verifyHyperLinkTagsAndParseTheURLOfTags(), assertFailurePreText + "Presence of hyperlinked words on the 2.13 concepts of biology book.");
            reportLog("Hyperlinked words terms are not there for the 2.13 concept of Biology book.");

            Assert.assertTrue(biologyBookPage.verifyTheVocabularyTermsOfBiologyBook(), assertFailurePreText + "Presence of vocabulary terms on the 2.13 concepts of biology book.");
            reportLog("Vocabulary terms are not there for the 2.13 concept of Biology book.");

            Assert.assertTrue(biologyBookPage.verifyHTagsInBook(), assertFailurePreText + "Presence of Header tag on the 2.13 concepts of biology book.");
            reportLog("Presence of all Header tag on the 2.13 concept of Biology book.");

            Assert.assertTrue(biologyBookPage.verifyDidYouKnowSection(), assertFailurePreText + "Presence of Did you know section on the 2.13 concepts of biology book.");
            reportLog("Did you know section is not there for the 2.13 concept of Biology book.");

            for (int i = 0; i <= 8; i++) {
                scrollByPixel(500);
                basePage.waitForSec(4);
            }

            Assert.assertTrue(biologyBookPage.verifyTheImagesOfBiologyBook(), assertFailurePreText + "Presence of images on the 2.13 concepts of biology book.");
            reportLog("Presence of all images on the 2.13 concept of Biology book.");

            Assert.assertTrue(biologyBookPage.verifyTheVideosOfBiologyBook(), assertFailurePreText + "Presence of videos on the 2.13 concepts of biology book.");
            reportLog("Presence of all the videos on the 2.13 concept of Biology book.");

        } catch (Exception e) {
            result = handleException(e);
        }
        Assert.assertTrue(result, "Test script failed for" + currentMethodName + errorMessage);
    }

    @Test(priority = 14, description = "Verify the Content of 2.14 Active Transport concept of Biology book.")
    public void verifyContentOfActiveTransportConcept() {
        boolean result = true;
        try {
            String url = "https://flexbooks.ck12.org/cbook/ck-12-biology-flexbook-2.0/section/2.14/primary/lesson/active-transport-bio/";

            webDriver.navigate().to(url);

            Assert.assertTrue(biologyBookPage.verifyModalityPageTitle("Active Transport"), assertFailurePreText + "Presence of title on the 2.14 concepts of biology book.");
            reportLog("Verified Modality title: " + webDriver.getTitle() + "on the 2.14 concept of Biology book.");

            reportLog("The Page Description is: " + biologyBookPage.pageDescription.getAttribute("content"));

            Assert.assertTrue(biologyBookPage.verifyCanonicalMetaTag(), assertFailurePreText + "Presence of canonical meta tag on the 2.14 concepts of biology book.");
            reportLog("Verified Canonical Tag and 1 Tag is found with URL: " + biologyBookPage.canonicalData.getAttribute("href"));

            Assert.assertTrue(biologyBookPage.verifyHyperLinkTagsAndParseTheURLOfTags(), assertFailurePreText + "Presence of hyperlinked words on the 2.14 concepts of biology book.");
            reportLog("Hyperlinked words terms are not there for the 2.14 concept of Biology book.");

            Assert.assertTrue(biologyBookPage.verifyTheVocabularyTermsOfBiologyBook(), assertFailurePreText + "Presence of vocabulary terms on the 2.14 concepts of biology book.");
            reportLog("Vocabulary terms are not there for the 2.14 concept of Biology book.");

            Assert.assertTrue(biologyBookPage.verifyHTagsInBook(), assertFailurePreText + "Presence of Header tag on the 2.14 concepts of biology book.");
            reportLog("Presence of all Header tag on the 2.14 concept of Biology book.");

            Assert.assertTrue(biologyBookPage.verifyDidYouKnowSection(), assertFailurePreText + "Presence of Did you know section on the 2.14 concepts of biology book.");
            reportLog("Did you know section is not there for the 2.14 concept of Biology book.");

            for (int i = 0; i <= 8; i++) {
                scrollByPixel(500);
                basePage.waitForSec(4);
            }

            Assert.assertTrue(biologyBookPage.verifyTheImagesOfBiologyBook(), assertFailurePreText + "Presence of images on the 2.14 concepts of biology book.");
            reportLog("Presence of all images on the 2.14 concept of Biology book.");

            Assert.assertTrue(biologyBookPage.verifyTheVideosOfBiologyBook(), assertFailurePreText + "Presence of videos on the 2.14 concepts of biology book.");
            reportLog("Presence of all the videos on the 2.14 concept of Biology book.");

        } catch (Exception e) {
            result = handleException(e);
        }
        Assert.assertTrue(result, "Test script failed for" + currentMethodName + errorMessage);
    }

    @Test(priority = 15, description = "Verify the Content of 2.15 Sodium-Potassium Pump concept of Biology book.")
    public void verifyContentOfSodiumPotassiumPumpConcept() {
        boolean result = true;
        try {
            String url = "https://flexbooks.ck12.org/cbook/ck-12-biology-flexbook-2.0/section/2.15/primary/lesson/sodium-potassium-pump-bio/";

            webDriver.navigate().to(url);

            Assert.assertTrue(biologyBookPage.verifyModalityPageTitle("Sodium-Potassium Pump"), assertFailurePreText + "Presence of title on the 2.15 concepts of biology book.");
            reportLog("Verified Modality title: " + webDriver.getTitle() + "on the 2.15 concept of Biology book.");

            reportLog("The Page Description is: " + biologyBookPage.pageDescription.getAttribute("content"));

            Assert.assertTrue(biologyBookPage.verifyCanonicalMetaTag(), assertFailurePreText + "Presence of canonical meta tag on the 2.15 concepts of biology book.");
            reportLog("Verified Canonical Tag and 1 Tag is found with URL: " + biologyBookPage.canonicalData.getAttribute("href"));

            Assert.assertTrue(biologyBookPage.verifyHyperLinkTagsAndParseTheURLOfTags(), assertFailurePreText + "Presence of hyperlinked words on the 2.15 concepts of biology book.");
            reportLog("Presence of all the hyperlinked words terms on the 2.15 concept of Biology book.");

            Assert.assertTrue(biologyBookPage.verifyTheVocabularyTermsOfBiologyBook(), assertFailurePreText + "Presence of vocabulary terms on the 2.15 concepts of biology book.");
            reportLog("Presence of all the vocabulary terms on the 2.15 concept of Biology book.");

            Assert.assertTrue(biologyBookPage.verifyHTagsInBook(), assertFailurePreText + "Presence of Header tag on the 2.15 concepts of biology book.");
            reportLog("Presence of all Header tag on the 2.15 concept of Biology book.");

            Assert.assertTrue(biologyBookPage.verifyDidYouKnowSection(), assertFailurePreText + "Presence of Did you know section on the 2.15 concepts of biology book.");
            reportLog("Did you know section is not the for the 2.15 concept of Biology book.");

            for (int i = 0; i <= 8; i++) {
                scrollByPixel(500);
                basePage.waitForSec(4);
            }

            Assert.assertTrue(biologyBookPage.verifyTheImagesOfBiologyBook(), assertFailurePreText + "Presence of images on the 2.15 concepts of biology book.");
            reportLog("Presence of all images on the 2.15 concept of Biology book.");

            Assert.assertTrue(biologyBookPage.verifyTheVideosOfBiologyBook(), assertFailurePreText + "Presence of videos on the 2.15 concepts of biology book.");
            reportLog("Presence of all the videos on the 2.15 concept of Biology book.");

        } catch (Exception e) {
            result = handleException(e);
        }
        Assert.assertTrue(result, "Test script failed for" + currentMethodName + errorMessage);
    }

    @Test(priority = 16, description = "Verify the Content of 2.16 Exocytosis and Endocytosis concept of Biology book.")
    public void verifyContentOfExocytosisAndEndocytosisConcept() {
        boolean result = true;
        try {
            String url = "https://flexbooks.ck12.org/cbook/ck-12-biology-flexbook-2.0/section/2.16/primary/lesson/exocytosis-and-endocytosis-bio/";

            webDriver.navigate().to(url);

            Assert.assertTrue(biologyBookPage.verifyModalityPageTitle("Exocytosis and Endocytosis"), assertFailurePreText + "Presence of title on the 2.16 concepts of biology book.");
            reportLog("Verified Modality title: " + webDriver.getTitle() + "on the 2.16 concept of Biology book.");

            reportLog("The Page Description is: " + biologyBookPage.pageDescription.getAttribute("content"));

            Assert.assertTrue(biologyBookPage.verifyCanonicalMetaTag(), assertFailurePreText + "Presence of canonical meta tag on the 2.16 concepts of biology book.");
            reportLog("Verified Canonical Tag and 1 Tag is found with URL: " + biologyBookPage.canonicalData.getAttribute("href"));

            Assert.assertTrue(biologyBookPage.verifyHyperLinkTagsAndParseTheURLOfTags(), assertFailurePreText + "Presence of hyperlinked words on the 2.16 concepts of biology book.");
            reportLog("Presence of all the hyperlinked words terms on the 2.16 concept of Biology book.");

            Assert.assertTrue(biologyBookPage.verifyTheVocabularyTermsOfBiologyBook(), assertFailurePreText + "Presence of vocabulary terms on the 2.16 concepts of biology book.");
            reportLog("Presence of all the vocabulary terms on the 2.16 concept of Biology book.");

            Assert.assertTrue(biologyBookPage.verifyHTagsInBook(), assertFailurePreText + "Presence of Header tag on the 2.16 concepts of biology book.");
            reportLog("Presence of all Header tag on the 2.16 concept of Biology book.");

            Assert.assertTrue(biologyBookPage.verifyDidYouKnowSection(), assertFailurePreText + "Presence of Did you know section on the 2.16 concepts of biology book.");
            reportLog("Did you know section is not there for the 2.16 concept of Biology book.");

            for (int i = 0; i <= 8; i++) {
                scrollByPixel(500);
                basePage.waitForSec(4);
            }

            Assert.assertTrue(biologyBookPage.verifyTheImagesOfBiologyBook(), assertFailurePreText + "Presence of images on the 2.16 concepts of biology book.");
            reportLog("Presence of all images on the 2.16 concept of Biology book.");

            Assert.assertTrue(biologyBookPage.verifyTheVideosOfBiologyBook(), assertFailurePreText + "Presence of videos on the 2.16 concepts of biology book.");
            reportLog("Presence of all the videos on the 2.16 concept of Biology book.");

        } catch (Exception e) {
            result = handleException(e);
        }
        Assert.assertTrue(result, "Test script failed for" + currentMethodName + errorMessage);
    }

    @Test(priority = 17, description = "Verify the Content of 2.17 Autotrophs and Heterotrophs concept of Biology book.")
    public void verifyContentOfAutotrophsAndHeterotrophsConcept() {
        boolean result = true;
        try {
            String url = "https://flexbooks.ck12.org/cbook/ck-12-biology-flexbook-2.0/section/2.17/primary/lesson/autotrophs-and-heterotrophs-bio/";

            webDriver.navigate().to(url);

            Assert.assertTrue(biologyBookPage.verifyModalityPageTitle("Autotrophs and Heterotrophs"), assertFailurePreText + "Presence of title on the 2.17 concepts of biology book.");
            reportLog("Verified Modality title: " + webDriver.getTitle() + "on the 2.17 concept of Biology book.");

            reportLog("The Page Description is: " + biologyBookPage.pageDescription.getAttribute("content"));

            Assert.assertTrue(biologyBookPage.verifyCanonicalMetaTag(), assertFailurePreText + "Presence of canonical meta tag on the 2.17 concepts of biology book.");
            reportLog("Verified Canonical Tag and 1 Tag is found with URL: " + biologyBookPage.canonicalData.getAttribute("href"));

            Assert.assertTrue(biologyBookPage.verifyHyperLinkTagsAndParseTheURLOfTags(), assertFailurePreText + "Presence of hyperlinked words on the 2.17 concepts of biology book.");
            reportLog("Presence of all the hyperlinked words terms on the 2.17 concept of Biology book.");

            Assert.assertTrue(biologyBookPage.verifyTheVocabularyTermsOfBiologyBook(), assertFailurePreText + "Presence of vocabulary terms on the 2.17 concepts of biology book.");
            reportLog("Presence of all the vocabulary terms on the 2.17 concept of Biology book.");

            Assert.assertTrue(biologyBookPage.verifyHTagsInBook(), assertFailurePreText + "Presence of Header tag on the 2.17 concepts of biology book.");
            reportLog("Presence of all Header tag on the 2.17 concept of Biology book.");

            Assert.assertTrue(biologyBookPage.verifyDidYouKnowSection(), assertFailurePreText + "Presence of Did you know section on the 2.17 concepts of biology book.");
            reportLog("Presence of Did you know section on 2.17 concept of Biology book.");

            for (int i = 0; i <= 8; i++) {
                scrollByPixel(500);
                basePage.waitForSec(4);
            }

            Assert.assertTrue(biologyBookPage.verifyTheImagesOfBiologyBook(), assertFailurePreText + "Presence of images on the 2.17 concepts of biology book.");
            reportLog("Presence of all images on the 2.17 concept of Biology book.");

            Assert.assertTrue(biologyBookPage.verifyTheVideosOfBiologyBook(), assertFailurePreText + "Presence of videos on the 2.17 concepts of biology book.");
            reportLog("Presence of all the videos on the 2.17 concept of Biology book.");

        } catch (Exception e) {
            result = handleException(e);
        }
        Assert.assertTrue(result, "Test script failed for" + currentMethodName + errorMessage);
    }

    @Test(priority = 18, description = "Verify the Content of 2.18 Glucose and ATP concept of Biology book.")
    public void verifyContentOfGlucoseAndATPConcept() {
        boolean result = true;
        try {
            String url = "https://flexbooks.ck12.org/cbook/ck-12-biology-flexbook-2.0/section/2.18/primary/lesson/glucose-and-atp-bio/";

            webDriver.navigate().to(url);

            Assert.assertTrue(biologyBookPage.verifyModalityPageTitle("Glucose and ATP"), assertFailurePreText + "Presence of title on the 2.18 concepts of biology book.");
            reportLog("Verified Modality title: " + webDriver.getTitle() + "on the 2.18 concept of Biology book.");

            reportLog("The Page Description is: " + biologyBookPage.pageDescription.getAttribute("content"));

            Assert.assertTrue(biologyBookPage.verifyCanonicalMetaTag(), assertFailurePreText + "Presence of canonical meta tag on the 2.18 concepts of biology book.");
            reportLog("Verified Canonical Tag and 1 Tag is found with URL: " + biologyBookPage.canonicalData.getAttribute("href"));

            Assert.assertTrue(biologyBookPage.verifyHyperLinkTagsAndParseTheURLOfTags(), assertFailurePreText + "Presence of hyperlinked words on the 2.18 concepts of biology book.");
            reportLog("Presence of all the hyperlinked words terms on the 2.18 concept of Biology book.");

            Assert.assertTrue(biologyBookPage.verifyTheVocabularyTermsOfBiologyBook(), assertFailurePreText + "Presence of vocabulary terms on the 2.18 concepts of biology book.");
            reportLog("Presence of all the vocabulary terms on the 2.18 concept of Biology book.");

            Assert.assertTrue(biologyBookPage.verifyHTagsInBook(), assertFailurePreText + "Presence of Header tag on the 2.18 concepts of biology book.");
            reportLog("Presence of all Header tag on the 2.18 concept of Biology book.");

            Assert.assertTrue(biologyBookPage.verifyDidYouKnowSection(), assertFailurePreText + "Presence of Did you know section on the 2.18 concepts of biology book.");
            reportLog("Did you know section is not there for the 2.18 concept of Biology book.");

            for (int i = 0; i <= 8; i++) {
                scrollByPixel(500);
                basePage.waitForSec(4);
            }

            Assert.assertTrue(biologyBookPage.verifyTheImagesOfBiologyBook(), assertFailurePreText + "Presence of images on the 2.18 concepts of biology book.");
            reportLog("Presence of all images on the 2.18 concept of Biology book.");

            Assert.assertTrue(biologyBookPage.verifyTheVideosOfBiologyBook(), assertFailurePreText + "Presence of videos on the 2.18 concepts of biology book.");
            reportLog("Presence of all the videos on the 2.18 concept of Biology book.");

        } catch (Exception e) {
            result = handleException(e);
        }
        Assert.assertTrue(result, "Test script failed for" + currentMethodName + errorMessage);
    }

    @Test(priority = 19, description = "Verify the Content of 2.19 Chloroplast concept of Biology book.")
    public void verifyContentOfChloroplastConcept() {
        boolean result = true;
        try {
            String url = "https://flexbooks.ck12.org/cbook/ck-12-biology-flexbook-2.0/section/2.19/primary/lesson/chloroplasts-bio/";

            webDriver.navigate().to(url);

            Assert.assertTrue(biologyBookPage.verifyModalityPageTitle("Chloroplast"), assertFailurePreText + "Presence of title on the 2.19 concepts of biology book.");
            reportLog("Verified Modality title: " + webDriver.getTitle() + "on the 2.19 concept of Biology book.");

            reportLog("The Page Description is: " + biologyBookPage.pageDescription.getAttribute("content"));

            Assert.assertTrue(biologyBookPage.verifyCanonicalMetaTag(), assertFailurePreText + "Presence of canonical meta tag on the 2.19 concepts of biology book.");
            reportLog("Verified Canonical Tag and 1 Tag is found with URL: " + biologyBookPage.canonicalData.getAttribute("href"));

            Assert.assertTrue(biologyBookPage.verifyHyperLinkTagsAndParseTheURLOfTags(), assertFailurePreText + "Presence of hyperlinked words on the 2.19 concepts of biology book.");
            reportLog("Presence of all the hyperlinked words terms on the 2.19 concept of Biology book.");

            Assert.assertTrue(biologyBookPage.verifyTheVocabularyTermsOfBiologyBook(), assertFailurePreText + "Presence of vocabulary terms on the 2.19 concepts of biology book.");
            reportLog("Presence of all the vocabulary terms on the 2.19 concept of Biology book.");

            Assert.assertTrue(biologyBookPage.verifyHTagsInBook(), assertFailurePreText + "Presence of Header tag on the 2.19 concepts of biology book.");
            reportLog("Presence of all Header tag on the 2.19 concept of Biology book.");

            Assert.assertTrue(biologyBookPage.verifyDidYouKnowSection(), assertFailurePreText + "Presence of Did you know section on the 2.19 concepts of biology book.");
            reportLog("Did you know section is not there for the 2.19 concept of Biology book.");

            ((JavascriptExecutor) webDriver).executeScript("window.scrollBy(0,0)");

            for (int i = 0; i <= 10; i++) {
                scrollByPixel(500);
                basePage.waitForSec(4);
            }

            Assert.assertTrue(biologyBookPage.verifyTheImagesOfBiologyBook(), assertFailurePreText + "Presence of images on the 2.19 concepts of biology book.");
            reportLog("Presence of all images on the 2.19 concept of Biology book.");

            Assert.assertTrue(biologyBookPage.verifyTheVideosOfBiologyBook(), assertFailurePreText + "Presence of videos on the 2.19 concepts of biology book.");
            reportLog("Presence of all the videos on the 2.19 concept of Biology book.");

        } catch (Exception e) {
            result = handleException(e);
        }
        Assert.assertTrue(result, "Test script failed for" + currentMethodName + errorMessage);
    }

    @Test(priority = 20, description = "Verify the Content of 2.20 Leaves and Photosynthesis concept of Biology book.")
    public void verifyContentOfLeavesAndPhotosynthesisConcept() {
        boolean result = true;
        try {
            String url = "https://flexbooks.ck12.org/cbook/ck-12-biology-flexbook-2.0/section/2.20/primary/lesson/photosynthesis-bio/";

            webDriver.navigate().to(url);

            Assert.assertTrue(biologyBookPage.verifyModalityPageTitle("Leaves and Photosynthesis"), assertFailurePreText + "Presence of title on the 2.20 concepts of biology book.");
            reportLog("Verified Modality title: " + webDriver.getTitle() + "on the 2.20 concept of Biology book.");

            reportLog("The Page Description is: " + biologyBookPage.pageDescription.getAttribute("content"));

            Assert.assertTrue(biologyBookPage.verifyCanonicalMetaTag(), assertFailurePreText + "Presence of canonical meta tag on the 2.20 concepts of biology book.");
            reportLog("Verified Canonical Tag and 1 Tag is found with URL: " + biologyBookPage.canonicalData.getAttribute("href"));

            Assert.assertTrue(biologyBookPage.verifyHyperLinkTagsAndParseTheURLOfTags(), assertFailurePreText + "Presence of hyperlinked words on the 2.20 concepts of biology book.");
            reportLog("Presence of all the hyperlinked words terms on the 2.20 concept of Biology book.");

            Assert.assertTrue(biologyBookPage.verifyTheVocabularyTermsOfBiologyBook(), assertFailurePreText + "Presence of vocabulary terms on the 2.20 concepts of biology book.");
            reportLog("Presence of all the vocabulary terms on the 2.20 concept of Biology book.");

            Assert.assertTrue(biologyBookPage.verifyHTagsInBook(), assertFailurePreText + "Presence of Header tag on the 2.20 concepts of biology book.");
            reportLog("Presence of all Header tag on the 2.20 concept of Biology book.");

            Assert.assertTrue(biologyBookPage.verifyDidYouKnowSection(), assertFailurePreText + "Presence of Did you know section on the 2.20 concepts of biology book.");
            reportLog("Did you know section is present for the 2.20 concept of Biology book.");

            for (int i = 0; i <= 8; i++) {
                scrollByPixel(500);
                basePage.waitForSec(4);
            }

            Assert.assertTrue(biologyBookPage.verifyTheImagesOfBiologyBook(), assertFailurePreText + "Presence of images on the 2.20 concepts of biology book.");
            reportLog("Presence of all images on the 2.20 concept of Biology book.");

            Assert.assertTrue(biologyBookPage.verifyTheVideosOfBiologyBook(), assertFailurePreText + "Presence of videos on the 2.20 concepts of biology book.");
            reportLog("Presence of all the videos on the 2.20 concept of Biology book.");

        } catch (Exception e) {
            result = handleException(e);
        }
        Assert.assertTrue(result, "Test script failed for" + currentMethodName + errorMessage);
    }

    @Test(priority = 21, description = "Verify the Content of 2.21 Photosynthesis concept of Biology book.")
    public void verifyContentOfPhotosynthesisConcept() {
        boolean result = true;
        try {
            String url = "https://flexbooks.ck12.org/cbook/ck-12-biology-flexbook-2.0/section/2.21/primary/lesson/light-reactions-of-photosynthesis-bio/";

            webDriver.navigate().to(url);

            Assert.assertTrue(biologyBookPage.verifyModalityPageTitle("Photosynthesis"), assertFailurePreText + "Presence of title on the 2.21 concepts of biology book.");
            reportLog("Verified Modality title: " + webDriver.getTitle() + "on the 2.21 concept of Biology book.");

            reportLog("The Page Description is: " + biologyBookPage.pageDescription.getAttribute("content"));

            Assert.assertTrue(biologyBookPage.verifyCanonicalMetaTag(), assertFailurePreText + "Presence of canonical meta tag on the 2.21 concepts of biology book.");
            reportLog("Verified Canonical Tag and 1 Tag is found with URL: " + biologyBookPage.canonicalData.getAttribute("href"));

            Assert.assertTrue(biologyBookPage.verifyHyperLinkTagsAndParseTheURLOfTags(), assertFailurePreText + "Presence of hyperlinked words on the 2.21 concepts of biology book.");
            reportLog("Presence of all the hyperlinked words terms on the 2.21 concept of Biology book.");

            Assert.assertTrue(biologyBookPage.verifyTheVocabularyTermsOfBiologyBook(), assertFailurePreText + "Presence of vocabulary terms on the 2.21 concepts of biology book.");
            reportLog("Presence of all the vocabulary terms on the 2.21 concept of Biology book.");

            Assert.assertTrue(biologyBookPage.verifyHTagsInBook(), assertFailurePreText + "Presence of Header tag on the 2.21 concepts of biology book.");
            reportLog("Presence of all Header tag on the 2.21 concept of Biology book.");

            Assert.assertTrue(biologyBookPage.verifyDidYouKnowSection(), assertFailurePreText + "Presence of Did you know section on the 2.21 concepts of biology book.");
            reportLog("Did you know section is not there for the 2.21 concept of Biology book.");

            for (int i = 0; i <= 8; i++) {
                scrollByPixel(500);
                basePage.waitForSec(4);
            }

            Assert.assertTrue(biologyBookPage.verifyTheImagesOfBiologyBook(), assertFailurePreText + "Presence of images on the 2.21 concepts of biology book.");
            reportLog("Presence of all images on the 2.21 concept of Biology book.");

            Assert.assertTrue(biologyBookPage.verifyTheVideosOfBiologyBook(), assertFailurePreText + "Presence of videos on the 2.21 concepts of biology book.");
            reportLog("Presence of all the videos on the 2.21 concept of Biology book.");

        } catch (Exception e) {
            result = handleException(e);
        }
        Assert.assertTrue(result, "Test script failed for" + currentMethodName + errorMessage);
    }

    @Test(priority = 22, description = "Verify the Content of 2.22 Calvin Cycle concept of Biology book.")
    public void verifyContentOfCalvinCycleConcept() {
        boolean result = true;
        try {
            String url = "https://flexbooks.ck12.org/cbook/ck-12-biology-flexbook-2.0/section/2.22/primary/lesson/calvin-cycle-bio/";

            webDriver.navigate().to(url);

            Assert.assertTrue(biologyBookPage.verifyModalityPageTitle("Calvin Cycle"), assertFailurePreText + "Presence of title on the 2.22 concepts of biology book.");
            reportLog("Verified Modality title: " + webDriver.getTitle() + "on the 2.22 concept of Biology book.");

            reportLog("The Page Description is: " + biologyBookPage.pageDescription.getAttribute("content"));

            Assert.assertTrue(biologyBookPage.verifyCanonicalMetaTag(), assertFailurePreText + "Presence of canonical meta tag on the 2.22 concepts of biology book.");
            reportLog("Verified Canonical Tag and 1 Tag is found with URL: " + biologyBookPage.canonicalData.getAttribute("href"));

            Assert.assertTrue(biologyBookPage.verifyHyperLinkTagsAndParseTheURLOfTags(), assertFailurePreText + "Presence of hyperlinked words on the 2.22 concepts of biology book.");
            reportLog("Presence of all the hyperlinked words terms on the 2.22 concept of Biology book.");

            Assert.assertTrue(biologyBookPage.verifyTheVocabularyTermsOfBiologyBook(), assertFailurePreText + "Presence of vocabulary terms on the 2.22 concepts of biology book.");
            reportLog("Presence of all the vocabulary terms on the 2.22 concept of Biology book.");

            Assert.assertTrue(biologyBookPage.verifyHTagsInBook(), assertFailurePreText + "Presence of Header tag on the 2.22 concepts of biology book.");
            reportLog("Presence of all Header tag on the 2.22 concept of Biology book.");

            Assert.assertTrue(biologyBookPage.verifyDidYouKnowSection(), assertFailurePreText + "Presence of Did you know section on the 2.22 concepts of biology book.");
            reportLog("Did you know section is not there for the 2.22 concept of Biology book.");

            for (int i = 0; i <= 8; i++) {
                scrollByPixel(500);
                basePage.waitForSec(4);
            }

            Assert.assertTrue(biologyBookPage.verifyTheImagesOfBiologyBook(), assertFailurePreText + "Presence of images on the 2.22 concepts of biology book.");
            reportLog("Presence of all images on the 2.22 concept of Biology book.");

            Assert.assertTrue(biologyBookPage.verifyTheVideosOfBiologyBook(), assertFailurePreText + "Presence of videos on the 2.22 concepts of biology book.");
            reportLog("Presence of all the videos on the 2.22 concept of Biology book.");

        } catch (Exception e) {
            result = handleException(e);
        }
        Assert.assertTrue(result, "Test script failed for" + currentMethodName + errorMessage);
    }

    @Test(priority = 23, description = "Verify the Content of 2.23 Photosynthesis Summary concept of Biology book.")
    public void verifyContentOfPhotosynthesisSummaryConcept() {
        boolean result = true;
        try {
            String url = "https://flexbooks.ck12.org/cbook/ck-12-biology-flexbook-2.0/section/2.23/primary/lesson/photosynthesis-summary-bio/";

            webDriver.navigate().to(url);

            Assert.assertTrue(biologyBookPage.verifyModalityPageTitle("Photosynthesis Summary"), assertFailurePreText + "Presence of title on the 2.23 concepts of biology book.");
            reportLog("Verified Modality title: " + webDriver.getTitle() + "on the 2.23 concept of Biology book.");

            reportLog("The Page Description is: " + biologyBookPage.pageDescription.getAttribute("content"));

            Assert.assertTrue(biologyBookPage.verifyCanonicalMetaTag(), assertFailurePreText + "Presence of canonical meta tag on the 2.23 concepts of biology book.");
            reportLog("Verified Canonical Tag and 1 Tag is found with URL: " + biologyBookPage.canonicalData.getAttribute("href"));

            Assert.assertTrue(biologyBookPage.verifyHyperLinkTagsAndParseTheURLOfTags(), assertFailurePreText + "Presence of hyperlinked words on the 2.23 concepts of biology book.");
            reportLog("Presence of all the hyperlinked words terms on the 2.23 concept of Biology book.");

            Assert.assertTrue(biologyBookPage.verifyTheVocabularyTermsOfBiologyBook(), assertFailurePreText + "Presence of vocabulary terms on the 2.23 concepts of biology book.");
            reportLog("Presence of all the vocabulary terms on the 2.23 concept of Biology book.");

            Assert.assertTrue(biologyBookPage.verifyHTagsInBook(), assertFailurePreText + "Presence of Header tag on the 2.23 concepts of biology book.");
            reportLog("Presence of all Header tag on the 2.23 concept of Biology book.");

            Assert.assertTrue(biologyBookPage.verifyDidYouKnowSection(), assertFailurePreText + "Presence of Did you know section on the 2.23 concepts of biology book.");
            reportLog("Did you know section is not there for the 2.23 concept of Biology book.");

            for (int i = 0; i <= 8; i++) {
                scrollByPixel(500);
                basePage.waitForSec(4);
            }

            Assert.assertTrue(biologyBookPage.verifyTheImagesOfBiologyBook(), assertFailurePreText + "Presence of images on the 2.23 concepts of biology book.");
            reportLog("Presence of all images on the 2.23 concept of Biology book.");

            Assert.assertTrue(biologyBookPage.verifyTheVideosOfBiologyBook(), assertFailurePreText + "Presence of videos on the 2.23 concepts of biology book.");
            reportLog("Presence of all the videos on the 2.23 concept of Biology book.");

        } catch (Exception e) {
            result = handleException(e);
        }
        Assert.assertTrue(result, "Test script failed for" + currentMethodName + errorMessage);
    }

    @Test(priority = 24, description = "Verify the Content of 2.24 Chemosynthesis concept of Biology book.")
    public void verifyContentOfChemosynthesisConcept() {
        boolean result = true;
        try {
            String url = "https://flexbooks.ck12.org/cbook/ck-12-biology-flexbook-2.0/section/2.24/primary/lesson/chemosynthesis-bio/";

            webDriver.navigate().to(url);

            Assert.assertTrue(biologyBookPage.verifyModalityPageTitle("Chemosynthesis"), assertFailurePreText + "Presence of title on the 2.24 concepts of biology book.");
            reportLog("Verified Modality title: " + webDriver.getTitle() + "on the 2.24 concept of Biology book.");

            reportLog("The Page Description is: " + biologyBookPage.pageDescription.getAttribute("content"));

            Assert.assertTrue(biologyBookPage.verifyCanonicalMetaTag(), assertFailurePreText + "Presence of canonical meta tag on the 2.24 concepts of biology book.");
            reportLog("Verified Canonical Tag and 1 Tag is found with URL: " + biologyBookPage.canonicalData.getAttribute("href"));

            Assert.assertTrue(biologyBookPage.verifyHyperLinkTagsAndParseTheURLOfTags(), assertFailurePreText + "Presence of hyperlinked words on the 2.24 concepts of biology book.");
            reportLog("Presence of all the hyperlinked words terms on the 2.24 concept of Biology book.");

            Assert.assertTrue(biologyBookPage.verifyTheVocabularyTermsOfBiologyBook(), assertFailurePreText + "Presence of vocabulary terms on the 2.24 concepts of biology book.");
            reportLog("Presence of all the vocabulary terms on the 2.24 concept of Biology book.");

            Assert.assertTrue(biologyBookPage.verifyHTagsInBook(), assertFailurePreText + "Presence of Header tag on the 2.24 concepts of biology book.");
            reportLog("Presence of all Header tag on the 2.24 concept of Biology book.");

            Assert.assertTrue(biologyBookPage.verifyDidYouKnowSection(), assertFailurePreText + "Presence of Did you know section on the 2.24 concepts of biology book.");
            reportLog("Did you know section is not there for the 2.24 concept of Biology book.");

            for (int i = 0; i <= 8; i++) {
                scrollByPixel(500);
                basePage.waitForSec(4);
            }

            Assert.assertTrue(biologyBookPage.verifyTheImagesOfBiologyBook(), assertFailurePreText + "Presence of images on the 2.24 concepts of biology book.");
            reportLog("Presence of all images on the 2.24 concept of Biology book.");

            Assert.assertTrue(biologyBookPage.verifyTheVideosOfBiologyBook(), assertFailurePreText + "Presence of videos on the 2.24 concepts of biology book.");
            reportLog("Presence of all the videos on the 2.24 concept of Biology book.");

        } catch (Exception e) {
            result = handleException(e);
        }
        Assert.assertTrue(result, "Test script failed for" + currentMethodName + errorMessage);
    }

    @Test(priority = 25, description = "Verify the Content of 2.25 Cellular Respiration concept of Biology book.")
    public void verifyContentOfCellularRespirationConcept() {
        boolean result = true;
        try {
            String url = "https://flexbooks.ck12.org/cbook/ck-12-biology-flexbook-2.0/section/2.25/primary/lesson/cellular-respiration-bio/";

            webDriver.navigate().to(url);

            Assert.assertTrue(biologyBookPage.verifyModalityPageTitle("Cellular Respiration"), assertFailurePreText + "Presence of title on the 2.25 concepts of biology book.");
            reportLog("Verified Modality title: " + webDriver.getTitle() + "on the 2.25 concept of Biology book.");

            reportLog("The Page Description is: " + biologyBookPage.pageDescription.getAttribute("content"));

            Assert.assertTrue(biologyBookPage.verifyCanonicalMetaTag(), assertFailurePreText + "Presence of canonical meta tag on the 2.25 concepts of biology book.");
            reportLog("Verified Canonical Tag and 1 Tag is found with URL: " + biologyBookPage.canonicalData.getAttribute("href"));

            Assert.assertTrue(biologyBookPage.verifyHyperLinkTagsAndParseTheURLOfTags(), assertFailurePreText + "Presence of hyperlinked words on the 2.25 concepts of biology book.");
            reportLog("Hyperlinked words terms are not there for the 2.25 concept of Biology book.");

            Assert.assertTrue(biologyBookPage.verifyTheVocabularyTermsOfBiologyBook(), assertFailurePreText + "Presence of vocabulary terms on the 2.25 concepts of biology book.");
            reportLog("Vocabulary terms terms are not there for the 2.25 concept of Biology book.");

            Assert.assertTrue(biologyBookPage.verifyHTagsInBook(), assertFailurePreText + "Presence of Header tag on the 2.25 concepts of biology book.");
            reportLog("Presence of all Header tag on the 2.25 concept of Biology book.");

            Assert.assertTrue(biologyBookPage.verifyDidYouKnowSection(), assertFailurePreText + "Presence of Did you know section on the 2.25 concepts of biology book.");
            reportLog("Did you know section is not there for the 2.25 concept of Biology book.");

            for (int i = 0; i <= 8; i++) {
                scrollByPixel(500);
                basePage.waitForSec(4);
            }

            Assert.assertTrue(biologyBookPage.verifyTheImagesOfBiologyBook(), assertFailurePreText + "Presence of images on the 2.25 concepts of biology book.");
            reportLog("Presence of all images on the 2.25 concept of Biology book.");

            Assert.assertTrue(biologyBookPage.verifyTheVideosOfBiologyBook(), assertFailurePreText + "Presence of videos on the 2.25 concepts of biology book.");
            reportLog("Presence of all the videos on the 2.25 concept of Biology book.");

        } catch (Exception e) {
            result = handleException(e);
        }
        Assert.assertTrue(result, "Test script failed for" + currentMethodName + errorMessage);
    }

    @Test(priority = 26, description = "Verify the Content of 2.26 Glycolysis concept of Biology book.")
    public void verifyContentOfGlycolysisConcept() {
        boolean result = true;
        try {
            String url = "https://flexbooks.ck12.org/cbook/ck-12-biology-flexbook-2.0/section/2.26/primary/lesson/glycolysis-bio/";

            webDriver.navigate().to(url);

            Assert.assertTrue(biologyBookPage.verifyModalityPageTitle("Glycolysis"), assertFailurePreText + "Presence of title on the 2.26 concepts of biology book.");
            reportLog("Verified Modality title: " + webDriver.getTitle() + "on the 2.26 concept of Biology book.");

            reportLog("The Page Description is: " + biologyBookPage.pageDescription.getAttribute("content"));

            Assert.assertTrue(biologyBookPage.verifyCanonicalMetaTag(), assertFailurePreText + "Presence of canonical meta tag on the 2.26 concepts of biology book.");
            reportLog("Verified Canonical Tag and 1 Tag is found with URL: " + biologyBookPage.canonicalData.getAttribute("href"));

            Assert.assertTrue(biologyBookPage.verifyHyperLinkTagsAndParseTheURLOfTags(), assertFailurePreText + "Presence of hyperlinked words on the 2.26 concepts of biology book.");
            reportLog("Hyperlinked words terms are not there for the 2.26 concept of Biology book.");

            Assert.assertTrue(biologyBookPage.verifyTheVocabularyTermsOfBiologyBook(), assertFailurePreText + "Presence of vocabulary terms on the 2.26 concepts of biology book.");
            reportLog("Vocabulary terms terms are not there for the 2.26 concept of Biology book.");

            Assert.assertTrue(biologyBookPage.verifyHTagsInBook(), assertFailurePreText + "Presence of Header tag on the 2.26 concepts of biology book.");
            reportLog("Presence of all Header tag on the 2.26 concept of Biology book.");

            Assert.assertTrue(biologyBookPage.verifyDidYouKnowSection(), assertFailurePreText + "Presence of Did you know section on the 2.26 concepts of biology book.");
            reportLog("Did you know section is not there for the 2.26 concept of Biology book.");

            for (int i = 0; i <= 8; i++) {
                scrollByPixel(500);
                basePage.waitForSec(4);
            }

            Assert.assertTrue(biologyBookPage.verifyTheImagesOfBiologyBook(), assertFailurePreText + "Presence of images on the 2.26 concepts of biology book.");
            reportLog("Presence of all images on the 2.26 concept of Biology book.");

            Assert.assertTrue(biologyBookPage.verifyTheVideosOfBiologyBook(), assertFailurePreText + "Presence of videos on the 2.26 concepts of biology book.");
            reportLog("Presence of all the videos on the 2.26 concept of Biology book.");

        } catch (Exception e) {
            result = handleException(e);
        }
        Assert.assertTrue(result, "Test script failed for" + currentMethodName + errorMessage);
    }

    @Test(priority = 27, description = "Verify the Content of 2.27 Krebs Cycle concept of Biology book.")
    public void verifyContentOfKrebsCycleConcept() {
        boolean result = true;
        try {
            String url = "https://flexbooks.ck12.org/cbook/ck-12-biology-flexbook-2.0/section/2.27/primary/lesson/krebs-cycle-bio/";

            webDriver.navigate().to(url);

            Assert.assertTrue(biologyBookPage.verifyModalityPageTitle("Krebs Cycle"), assertFailurePreText + "Presence of title on the 2.27 concepts of biology book.");
            reportLog("Verified Modality title: " + webDriver.getTitle() + "on the 2.27 concept of Biology book.");

            reportLog("The Page Description is: " + biologyBookPage.pageDescription.getAttribute("content"));

            Assert.assertTrue(biologyBookPage.verifyCanonicalMetaTag(), assertFailurePreText + "Presence of canonical meta tag on the 2.27 concepts of biology book.");
            reportLog("Verified Canonical Tag and 1 Tag is found with URL: " + biologyBookPage.canonicalData.getAttribute("href"));

            Assert.assertTrue(biologyBookPage.verifyHyperLinkTagsAndParseTheURLOfTags(), assertFailurePreText + "Presence of hyperlinked words on the 2.27 concepts of biology book.");
            reportLog("Hyperlinked words terms are not there for the 2.27 concept of Biology book.");

            Assert.assertTrue(biologyBookPage.verifyTheVocabularyTermsOfBiologyBook(), assertFailurePreText + "Presence of vocabulary terms on the 2.27 concepts of biology book.");
            reportLog("Vocabulary terms terms are not there for the 2.27 concept of Biology book.");

            Assert.assertTrue(biologyBookPage.verifyHTagsInBook(), assertFailurePreText + "Presence of Header tag on the 2.27 concepts of biology book.");
            reportLog("Presence of all Header tag on the 2.27 concept of Biology book.");

            Assert.assertTrue(biologyBookPage.verifyDidYouKnowSection(), assertFailurePreText + "Presence of Did you know section on the 2.27 concepts of biology book.");
            reportLog("Did you know section is not there for the 2.27 concept of Biology book.");

            for (int i = 0; i <= 8; i++) {
                scrollByPixel(500);
                basePage.waitForSec(4);
            }

            Assert.assertTrue(biologyBookPage.verifyTheImagesOfBiologyBook(), assertFailurePreText + "Presence of images on the 2.27 concepts of biology book.");
            reportLog("Presence of all images on the 2.27 concept of Biology book.");

            Assert.assertTrue(biologyBookPage.verifyTheVideosOfBiologyBook(), assertFailurePreText + "Presence of videos on the 2.27 concepts of biology book.");
            reportLog("Presence of all the videos on the 2.27 concept of Biology book.");

        } catch (Exception e) {
            result = handleException(e);
        }
        Assert.assertTrue(result, "Test script failed for" + currentMethodName + errorMessage);
    }

    @Test(priority = 28, description = "Verify the Content of 2.28 Electron Transport concept of Biology book.")
    public void verifyContentOfElectronTransportConcept() {
        boolean result = true;
        try {
            String url = "https://flexbooks.ck12.org/cbook/ck-12-biology-flexbook-2.0/section/2.28/primary/lesson/electron-transport-bio/";

            webDriver.navigate().to(url);

            Assert.assertTrue(biologyBookPage.verifyModalityPageTitle("Electron Transport"), assertFailurePreText + "Presence of title on the 2.27 concepts of biology book.");
            reportLog("Verified Modality title: " + webDriver.getTitle() + "on the 2.28 concept of Biology book.");

            reportLog("The Page Description is: " + biologyBookPage.pageDescription.getAttribute("content"));

            Assert.assertTrue(biologyBookPage.verifyCanonicalMetaTag(), assertFailurePreText + "Presence of canonical meta tag on the 2.28 concepts of biology book.");
            reportLog("Verified Canonical Tag and 1 Tag is found with URL: " + biologyBookPage.canonicalData.getAttribute("href"));

            Assert.assertTrue(biologyBookPage.verifyHyperLinkTagsAndParseTheURLOfTags(), assertFailurePreText + "Presence of hyperlinked words on the 2.28 concepts of biology book.");
            reportLog("Hyperlinked words terms are not there for the 2.28 concept of Biology book.");

            Assert.assertTrue(biologyBookPage.verifyTheVocabularyTermsOfBiologyBook(), assertFailurePreText + "Presence of vocabulary terms on the 2.28 concepts of biology book.");
            reportLog("Vocabulary terms terms are not there for the 2.28 concept of Biology book.");

            Assert.assertTrue(biologyBookPage.verifyHTagsInBook(), assertFailurePreText + "Presence of Header tag on the 2.28 concepts of biology book.");
            reportLog("Presence of all Header tag on the 2.28 concept of Biology book.");

            Assert.assertTrue(biologyBookPage.verifyDidYouKnowSection(), assertFailurePreText + "Presence of Did you know section on the 2.28 concepts of biology book.");
            reportLog("Did you know section is not there for the 2.28 concept of Biology book.");

            for (int i = 0; i <= 8; i++) {
                scrollByPixel(500);
                basePage.waitForSec(4);
            }

            Assert.assertTrue(biologyBookPage.verifyTheImagesOfBiologyBook(), assertFailurePreText + "Presence of images on the 2.28 concepts of biology book.");
            reportLog("Presence of all images on the 2.28 concept of Biology book.");

            Assert.assertTrue(biologyBookPage.verifyTheVideosOfBiologyBook(), assertFailurePreText + "Presence of videos on the 2.28 concepts of biology book.");
            reportLog("Presence of all the videos on the 2.28 concept of Biology book.");

        } catch (Exception e) {
            result = handleException(e);
        }
        Assert.assertTrue(result, "Test script failed for" + currentMethodName + errorMessage);
    }

    @Test(priority = 29, description = "Verify the Content of 2.29 Fermentation concept of Biology book.")
    public void verifyContentOfFermentationConcept() {
        boolean result = true;
        try {
            String url = "https://flexbooks.ck12.org/user:aw50zxjhy3rpdmutywrtaw5ay2sxmi5vcmc./cbook/ck-12-biology-for-high-school-ux-enhance/section/2.29/primary/lesson/fermentation/";

            webDriver.navigate().to(url);

            Assert.assertTrue(biologyBookPage.verifyModalityPageTitle("Fermentation"), assertFailurePreText + "Presence of title on the 2.29 concepts of biology book.");
            reportLog("Verified Modality title: " + webDriver.getTitle() + "on the 2.29 concept of Biology book.");

            reportLog("The Page Description is: " + biologyBookPage.pageDescription.getAttribute("content"));

            Assert.assertTrue(biologyBookPage.verifyCanonicalMetaTag(), assertFailurePreText + "Presence of canonical meta tag on the 2.29 concepts of biology book.");
            reportLog("Verified Canonical Tag and 1 Tag is found with URL: " + biologyBookPage.canonicalData.getAttribute("href"));

            Assert.assertTrue(biologyBookPage.verifyHyperLinkTagsAndParseTheURLOfTags(), assertFailurePreText + "Presence of hyperlinked words on the 2.29 concepts of biology book.");
            reportLog("Presence of all the hyperlinked words terms on the 2.29 concept of Biology book.");

            Assert.assertTrue(biologyBookPage.verifyTheVocabularyTermsOfBiologyBook(), assertFailurePreText + "Presence of vocabulary terms on the 2.29 concepts of biology book.");
            reportLog("Presence of all the vocabulary terms on the 2.29 concept of Biology book.");

            Assert.assertTrue(biologyBookPage.verifyHTagsInBook(), assertFailurePreText + "Presence of Header tag on the 2.29 concepts of biology book.");
            reportLog("Presence of all Header tag on the 2.29 concept of Biology book.");

            Assert.assertTrue(biologyBookPage.verifyDidYouKnowSection(), assertFailurePreText + "Presence of Did you know section on the 2.29 concepts of biology book.");
            reportLog("Did you know section is not there for the 2.29 concept of Biology book.");

            for (int i = 0; i <= 8; i++) {
                scrollByPixel(500);
                basePage.waitForSec(4);
            }

            Assert.assertTrue(biologyBookPage.verifyTheImagesOfBiologyBook(), assertFailurePreText + "Presence of images on the 2.29 concepts of biology book.");
            reportLog("Presence of all images on the 2.29 concept of Biology book.");

            Assert.assertTrue(biologyBookPage.verifyTheVideosOfBiologyBook(), assertFailurePreText + "Presence of videos on the 2.29 concepts of biology book.");
            reportLog("Presence of all the videos on the 2.29 concept of Biology book.");

        } catch (Exception e) {
            result = handleException(e);
        }
        Assert.assertTrue(result, "Test script failed for" + currentMethodName + errorMessage);
    }

    @Test(priority = 30, description = "Verify the Content of 2.30 Anaerobic and Aerobic Respiration concept of Biology book.")
    public void verifyContentOfAnaerobicAndAerobicRespirationConcept() {
        boolean result = true;
        try {
            String url = "https://flexbooks.ck12.org/cbook/ck-12-biology-flexbook-2.0/section/2.30/primary/lesson/anaerobic-and-aerobic-respiration-bio/";

            webDriver.navigate().to(url);

            Assert.assertTrue(biologyBookPage.verifyModalityPageTitle("Anaerobic and Aerobic Respiration"), assertFailurePreText + "Presence of title on the 2.30 concepts of biology book.");
            reportLog("Verified Modality title: " + webDriver.getTitle() + "on the 2.30 concept of Biology book.");

            reportLog("The Page Description is: " + biologyBookPage.pageDescription.getAttribute("content"));

            Assert.assertTrue(biologyBookPage.verifyCanonicalMetaTag(), assertFailurePreText + "Presence of canonical meta tag on the 2.30 concepts of biology book.");
            reportLog("Verified Canonical Tag and 1 Tag is found with URL: " + biologyBookPage.canonicalData.getAttribute("href"));

            Assert.assertTrue(biologyBookPage.verifyHyperLinkTagsAndParseTheURLOfTags(), assertFailurePreText + "Presence of hyperlinked words on the 2.30 concepts of biology book.");
            reportLog("Presence of all the hyperlinked words terms on the 2.30 concept of Biology book.");

            Assert.assertTrue(biologyBookPage.verifyTheVocabularyTermsOfBiologyBook(), assertFailurePreText + "Presence of vocabulary terms on the 2.30 concepts of biology book.");
            reportLog("Presence of all the vocabulary terms on the 2.30 concept of Biology book.");

            Assert.assertTrue(biologyBookPage.verifyHTagsInBook(), assertFailurePreText + "Presence of Header tag on the 2.30 concepts of biology book.");
            reportLog("Presence of all Header tag on the 2.30 concept of Biology book.");

            Assert.assertTrue(biologyBookPage.verifyDidYouKnowSection(), assertFailurePreText + "Presence of Did you know section on the 2.30 concepts of biology book.");
            reportLog("Did you know section is not there for the 2.30 concept of Biology book.");

            for (int i = 0; i <= 8; i++) {
                scrollByPixel(500);
                basePage.waitForSec(4);
            }

            Assert.assertTrue(biologyBookPage.verifyTheImagesOfBiologyBook(), assertFailurePreText + "Presence of images on the 2.30 concepts of biology book.");
            reportLog("Presence of all images on the 2.30 concept of Biology book.");

            Assert.assertTrue(biologyBookPage.verifyTheVideosOfBiologyBook(), assertFailurePreText + "Presence of videos on the 2.30 concepts of biology book.");
            reportLog("Presence of all the videos on the 2.30 concept of Biology book.");

        } catch (Exception e) {
            result = handleException(e);
        }
        Assert.assertTrue(result, "Test script failed for" + currentMethodName + errorMessage);
    }

    @Test(priority = 31, description = "Verify the Content of 2.31 Cell Division concept of Biology book.")
    public void verifyContentOfCellDivisionConcept() {
        boolean result = true;
        try {
            String url = "https://flexbooks.ck12.org/cbook/ck-12-biology-flexbook-2.0/section/2.31/primary/lesson/cell-division-bio/";

            webDriver.navigate().to(url);

            Assert.assertTrue(biologyBookPage.verifyModalityPageTitle("Cell Division"), assertFailurePreText + "Presence of title on the 2.31 concepts of biology book.");
            reportLog("Verified Modality title: " + webDriver.getTitle() + "on the 2.31 concept of Biology book.");

            reportLog("The Page Description is: " + biologyBookPage.pageDescription.getAttribute("content"));

            Assert.assertTrue(biologyBookPage.verifyCanonicalMetaTag(), assertFailurePreText + "Presence of canonical meta tag on the 2.31 concepts of biology book.");
            reportLog("Verified Canonical Tag and 1 Tag is found with URL: " + biologyBookPage.canonicalData.getAttribute("href"));

            Assert.assertTrue(biologyBookPage.verifyHyperLinkTagsAndParseTheURLOfTags(), assertFailurePreText + "Presence of hyperlinked words on the 2.31 concepts of biology book.");
            reportLog("Presence of all the hyperlinked words terms on the 2.31 concept of Biology book.");

            Assert.assertTrue(biologyBookPage.verifyTheVocabularyTermsOfBiologyBook(), assertFailurePreText + "Presence of vocabulary terms on the 2.31 concepts of biology book.");
            reportLog("Presence of all the vocabulary terms on the 2.31 concept of Biology book.");

            Assert.assertTrue(biologyBookPage.verifyHTagsInBook(), assertFailurePreText + "Presence of Header tag on the 2.31 concepts of biology book.");
            reportLog("Presence of all Header tag on the 2.31 concept of Biology book.");

            Assert.assertTrue(biologyBookPage.verifyDidYouKnowSection(), assertFailurePreText + "Presence of Did you know section on the 2.31 concepts of biology book.");
            reportLog("Did you know section is not there for the 2.31 concept of Biology book.");

            for (int i = 0; i <= 8; i++) {
                scrollByPixel(500);
                basePage.waitForSec(4);
            }

            Assert.assertTrue(biologyBookPage.verifyTheImagesOfBiologyBook(), assertFailurePreText + "Presence of images on the 2.31 concepts of biology book.");
            reportLog("Presence of all images on the 2.31 concept of Biology book.");

            Assert.assertTrue(biologyBookPage.verifyTheVideosOfBiologyBook(), assertFailurePreText + "Presence of videos on the 2.31 concepts of biology book.");
            reportLog("Presence of all the videos on the 2.31 concept of Biology book.");

        } catch (Exception e) {
            result = handleException(e);
        }
        Assert.assertTrue(result, "Test script failed for" + currentMethodName + errorMessage);
    }

    @Test(priority = 32, description = "Verify the Content of 2.32 Cell Cycle concept of Biology book.")
    public void verifyContentOfCellCycleConcept() {
        boolean result = true;
        try {
            String url = "https://flexbooks.ck12.org/cbook/ck-12-biology-flexbook-2.0/section/2.32/primary/lesson/cell-cycle-bio/";

            webDriver.navigate().to(url);

            Assert.assertTrue(biologyBookPage.verifyModalityPageTitle("Cell Cycle"), assertFailurePreText + "Presence of title on the 2.32 concepts of biology book.");
            reportLog("Verified Modality title: " + webDriver.getTitle() + "on the 2.32 concept of Biology book.");

            reportLog("The Page Description is: " + biologyBookPage.pageDescription.getAttribute("content"));

            Assert.assertTrue(biologyBookPage.verifyCanonicalMetaTag(), assertFailurePreText + "Presence of canonical meta tag on the 2.32 concepts of biology book.");
            reportLog("Verified Canonical Tag and 1 Tag is found with URL: " + biologyBookPage.canonicalData.getAttribute("href"));

            Assert.assertTrue(biologyBookPage.verifyHyperLinkTagsAndParseTheURLOfTags(), assertFailurePreText + "Presence of hyperlinked words on the 2.32 concepts of biology book.");
            reportLog("Presence of all the hyperlinked words terms on the 2.32 concept of Biology book.");

            Assert.assertTrue(biologyBookPage.verifyTheVocabularyTermsOfBiologyBook(), assertFailurePreText + "Presence of vocabulary terms on the 2.32 concepts of biology book.");
            reportLog("Presence of all the vocabulary terms on the 2.32 concept of Biology book.");

            Assert.assertTrue(biologyBookPage.verifyHTagsInBook(), assertFailurePreText + "Presence of Header tag on the 2.32 concepts of biology book.");
            reportLog("Presence of all Header tag on the 2.32 concept of Biology book.");

            Assert.assertTrue(biologyBookPage.verifyDidYouKnowSection(), assertFailurePreText + "Presence of Did you know section on the 2.32 concepts of biology book.");
            reportLog("Did you know section is not there for the 2.32 concept of Biology book.");

            for (int i = 0; i <= 8; i++) {
                scrollByPixel(500);
                basePage.waitForSec(4);
            }

            Assert.assertTrue(biologyBookPage.verifyTheImagesOfBiologyBook(), assertFailurePreText + "Presence of images on the 2.32 concepts of biology book.");
            reportLog("Presence of all images on the 2.32 concept of Biology book.");

            Assert.assertTrue(biologyBookPage.verifyTheVideosOfBiologyBook(), assertFailurePreText + "Presence of videos on the 2.32 concepts of biology book.");
            reportLog("Presence of all the videos on the 2.32 concept of Biology book.");

        } catch (Exception e) {
            result = handleException(e);
        }
        Assert.assertTrue(result, "Test script failed for" + currentMethodName + errorMessage);
    }

    @Test(priority = 33, description = "Verify the Content of 2.33 Cell Division concept of Biology book.")
    public void verifyContentOfChromosomesConcept() {
        boolean result = true;
        try {
            String url = "https://flexbooks.ck12.org/cbook/ck-12-biology-flexbook-2.0/section/2.33/primary/lesson/chromosomes-bio/";

            webDriver.navigate().to(url);

            Assert.assertTrue(biologyBookPage.verifyModalityPageTitle("Chromosomes"), assertFailurePreText + "Presence of title on the 2.33 concepts of biology book.");
            reportLog("Verified Modality title: " + webDriver.getTitle() + "on the 2.33 concept of Biology book.");

            reportLog("The Page Description is: " + biologyBookPage.pageDescription.getAttribute("content"));

            Assert.assertTrue(biologyBookPage.verifyCanonicalMetaTag(), assertFailurePreText + "Presence of canonical meta tag on the 2.33 concepts of biology book.");
            reportLog("Verified Canonical Tag and 1 Tag is found with URL: " + biologyBookPage.canonicalData.getAttribute("href"));

            Assert.assertTrue(biologyBookPage.verifyHyperLinkTagsAndParseTheURLOfTags(), assertFailurePreText + "Presence of hyperlinked words on the 2.33 concepts of biology book.");
            reportLog("There are no hyperlinked words terms on the 2.33 concept of Biology book.");

            Assert.assertTrue(biologyBookPage.verifyTheVocabularyTermsOfBiologyBook(), assertFailurePreText + "Presence of vocabulary terms on the 2.33 concepts of biology book.");
            reportLog("Presence of all the vocabulary terms on the 2.33 concept of Biology book.");

            Assert.assertTrue(biologyBookPage.verifyHTagsInBook(), assertFailurePreText + "Presence of Header tag on the 2.33 concepts of biology book.");
            reportLog("Presence of all Header tag on the 2.33 concept of Biology book.");

            Assert.assertTrue(biologyBookPage.verifyDidYouKnowSection(), assertFailurePreText + "Presence of Did you know section on the 2.33 concepts of biology book.");
            reportLog("Did you know section is not there for the 2.33 concept of Biology book.");

            for (int i = 0; i <= 8; i++) {
                scrollByPixel(500);
                basePage.waitForSec(4);
            }

            Assert.assertTrue(biologyBookPage.verifyTheImagesOfBiologyBook(), assertFailurePreText + "Presence of images on the 2.33 concepts of biology book.");
            reportLog("Presence of all images on the 2.33 concept of Biology book.");

            Assert.assertTrue(biologyBookPage.verifyTheVideosOfBiologyBook(), assertFailurePreText + "Presence of videos on the 2.33 concepts of biology book.");
            reportLog("Presence of all the videos on the 2.33 concept of Biology book.");

        } catch (Exception e) {
            result = handleException(e);
        }
        Assert.assertTrue(result, "Test script failed for" + currentMethodName + errorMessage);
    }

    @Test(priority = 34, description = "Verify the Content of 2.34 Mitosis concept of Biology book.")
    public void verifyContentOfMitosisConcept() {
        boolean result = true;
        try {
            String url = "https://flexbooks.ck12.org/cbook/ck-12-biology-flexbook-2.0/section/2.34/primary/lesson/mitosis-and-cytokinesis-bio/";

            webDriver.navigate().to(url);

            Assert.assertTrue(biologyBookPage.verifyModalityPageTitle("Mitosis"), assertFailurePreText + "Presence of title on the 2.34 concepts of biology book.");
            reportLog("Verified Modality title: " + webDriver.getTitle() + "on the 2.34 concept of Biology book.");

            reportLog("The Page Description is: " + biologyBookPage.pageDescription.getAttribute("content"));

            Assert.assertTrue(biologyBookPage.verifyCanonicalMetaTag(), assertFailurePreText + "Presence of canonical meta tag on the 2.34 concepts of biology book.");
            reportLog("Verified Canonical Tag and 1 Tag is found with URL: " + biologyBookPage.canonicalData.getAttribute("href"));

            Assert.assertTrue(biologyBookPage.verifyHyperLinkTagsAndParseTheURLOfTags(), assertFailurePreText + "Presence of hyperlinked words on the 2.34 concepts of biology book.");
            reportLog("Presence of all the hyperlinked words terms on the 2.34 concept of Biology book.");

            Assert.assertTrue(biologyBookPage.verifyTheVocabularyTermsOfBiologyBook(), assertFailurePreText + "Presence of vocabulary terms on the 2.34 concepts of biology book.");
            reportLog("Presence of all the vocabulary terms on the 2.34 concept of Biology book.");

            Assert.assertTrue(biologyBookPage.verifyHTagsInBook(), assertFailurePreText + "Presence of Header tag on the 2.34 concepts of biology book.");
            reportLog("Presence of all Header tag on the 2.34 concept of Biology book.");

            Assert.assertTrue(biologyBookPage.verifyDidYouKnowSection(), assertFailurePreText + "Presence of Did you know section on the 2.34 concepts of biology book.");
            reportLog("Did you know section is not there for the 2.34 concept of Biology book.");

            for (int i = 0; i <= 8; i++) {
                scrollByPixel(500);
                basePage.waitForSec(4);
            }

            Assert.assertTrue(biologyBookPage.verifyTheImagesOfBiologyBook(), assertFailurePreText + "Presence of images on the 2.34 concepts of biology book.");
            reportLog("Presence of all images on the 2.34 concept of Biology book.");

            Assert.assertTrue(biologyBookPage.verifyTheVideosOfBiologyBook(), assertFailurePreText + "Presence of videos on the 2.34 concepts of biology book.");
            reportLog("Presence of all the videos on the 2.34 concept of Biology book.");

        } catch (Exception e) {
            result = handleException(e);
        }
        Assert.assertTrue(result, "Test script failed for" + currentMethodName + errorMessage);
    }

    @Test(priority = 35, description = "Verify the Content of 2.35 Reproduction concept of Biology book.")
    public void verifyContentOfReproductionConcept() {
        boolean result = true;
        try {
            String url = "https://flexbooks.ck12.org/cbook/ck-12-biology-flexbook-2.0/section/2.35/primary/lesson/asexual-vs.-sexual-reproduction-bio/";

            webDriver.navigate().to(url);

            Assert.assertTrue(biologyBookPage.verifyModalityPageTitle("Reproduction"), assertFailurePreText + "Presence of title on the 2.35 concepts of biology book.");
            reportLog("Verified Modality title: " + webDriver.getTitle() + "on the 2.35 concept of Biology book.");

            reportLog("The Page Description is: " + biologyBookPage.pageDescription.getAttribute("content"));

            Assert.assertTrue(biologyBookPage.verifyCanonicalMetaTag(), assertFailurePreText + "Presence of canonical meta tag on the 2.35 concepts of biology book.");
            reportLog("Verified Canonical Tag and 1 Tag is found with URL: " + biologyBookPage.canonicalData.getAttribute("href"));

            Assert.assertTrue(biologyBookPage.verifyHyperLinkTagsAndParseTheURLOfTags(), assertFailurePreText + "Presence of hyperlinked words on the 2.35 concepts of biology book.");
            reportLog("Presence of all the hyperlinked words terms on the 2.35 concept of Biology book.");

            Assert.assertTrue(biologyBookPage.verifyTheVocabularyTermsOfBiologyBook(), assertFailurePreText + "Presence of vocabulary terms on the 2.35 concepts of biology book.");
            reportLog("Presence of all the vocabulary terms on the 2.35 concept of Biology book.");

            Assert.assertTrue(biologyBookPage.verifyHTagsInBook(), assertFailurePreText + "Presence of Header tag on the 2.35 concepts of biology book.");
            reportLog("Presence of all Header tag on the 2.35 concept of Biology book.");

            Assert.assertTrue(biologyBookPage.verifyDidYouKnowSection(), assertFailurePreText + "Presence of Did you know section on the 2.35 concepts of biology book.");
            reportLog("Did you know section is not there for the 2.35 concept of Biology book.");

            webDriver.navigate().refresh();

            for (int i = 0; i <= 20; i++) {
                scrollByPixel(300);
                basePage.waitForSec(3);
            }

            Assert.assertTrue(biologyBookPage.verifyTheImagesOfBiologyBook(), assertFailurePreText + "Presence of images on the 2.35 concepts of biology book.");
            reportLog("Presence of all images on the 2.35 concept of Biology book.");

            Assert.assertTrue(biologyBookPage.verifyTheVideosOfBiologyBook(), assertFailurePreText + "Presence of videos on the 2.35 concepts of biology book.");
            reportLog("Presence of all the videos on the 2.35 concept of Biology book.");

        } catch (Exception e) {
            result = handleException(e);
        }
        Assert.assertTrue(result, "Test script failed for" + currentMethodName + errorMessage);
    }

    @Test(priority = 36, description = "Verify the Content of 2.36 Meiosis concept of Biology book.")
    public void verifyContentOfMeiosisConcept() {
        boolean result = true;
        try {
            String url = "https://flexbooks.ck12.org/cbook/ck-12-biology-flexbook-2.0/section/2.36/primary/lesson/meiosis-bio/";

            webDriver.navigate().to(url);

            Assert.assertTrue(biologyBookPage.verifyModalityPageTitle("Meiosis"), assertFailurePreText + "Presence of title on the 2.36 concepts of biology book.");
            reportLog("Verified Modality title: " + webDriver.getTitle() + "on the 2.36 concept of Biology book.");

            reportLog("The Page Description is: " + biologyBookPage.pageDescription.getAttribute("content"));

            Assert.assertTrue(biologyBookPage.verifyCanonicalMetaTag(), assertFailurePreText + "Presence of canonical meta tag on the 2.36 concepts of biology book.");
            reportLog("Verified Canonical Tag and 1 Tag is found with URL: " + biologyBookPage.canonicalData.getAttribute("href"));

            Assert.assertTrue(biologyBookPage.verifyHyperLinkTagsAndParseTheURLOfTags(), assertFailurePreText + "Presence of hyperlinked words on the 2.36 concepts of biology book.");
            reportLog("Presence of all the hyperlinked words terms on the 2.36 concept of Biology book.");

            Assert.assertTrue(biologyBookPage.verifyTheVocabularyTermsOfBiologyBook(), assertFailurePreText + "Presence of vocabulary terms on the 2.36 concepts of biology book.");
            reportLog("Presence of all the vocabulary terms on the 2.36 concept of Biology book.");

            Assert.assertTrue(biologyBookPage.verifyHTagsInBook(), assertFailurePreText + "Presence of Header tag on the 2.36 concepts of biology book.");
            reportLog("Presence of all Header tag on the 2.36 concept of Biology book.");

            Assert.assertTrue(biologyBookPage.verifyDidYouKnowSection(), assertFailurePreText + "Presence of Did you know section on the 2.36 concepts of biology book.");
            reportLog("Did you know section is not there for the 2.36 concept of Biology book.");

            for (int i = 0; i <= 8; i++) {
                scrollByPixel(500);
                basePage.waitForSec(4);
            }

            Assert.assertTrue(biologyBookPage.verifyTheImagesOfBiologyBook(), assertFailurePreText + "Presence of images on the 2.36 concepts of biology book.");
            reportLog("Presence of all images on the 2.36 concept of Biology book.");

            Assert.assertTrue(biologyBookPage.verifyTheVideosOfBiologyBook(), assertFailurePreText + "Presence of videos on the 2.36 concepts of biology book.");
            reportLog("Presence of all the videos on the 2.36 concept of Biology book.");

        } catch (Exception e) {
            result = handleException(e);
        }
        Assert.assertTrue(result, "Test script failed for" + currentMethodName + errorMessage);
    }

    @Test(priority = 37, description = "Verify the Content of 2.37 Game to genesis concept of Biology book.")
    public void verifyContentOfGameToGenesisConcept() {
        boolean result = true;
        try {
            String url = "https://flexbooks.ck12.org/cbook/ck-12-biology-flexbook-2.0/section/2.37/primary/lesson/gametogenesis-bio/";

            webDriver.navigate().to(url);

            Assert.assertTrue(biologyBookPage.verifyModalityPageTitle("Gametogenesis"), assertFailurePreText + "Presence of title on the 2.37 concepts of biology book.");
            reportLog("Verified Modality title: " + webDriver.getTitle() + "on the 2.37 concept of Biology book.");

            reportLog("The Page Description is: " + biologyBookPage.pageDescription.getAttribute("content"));

            Assert.assertTrue(biologyBookPage.verifyCanonicalMetaTag(), assertFailurePreText + "Presence of canonical meta tag on the 2.37 concepts of biology book.");
            reportLog("Verified Canonical Tag and 1 Tag is found with URL: " + biologyBookPage.canonicalData.getAttribute("href"));

            Assert.assertTrue(biologyBookPage.verifyHyperLinkTagsAndParseTheURLOfTags(), assertFailurePreText + "Presence of hyperlinked words on the 2.37 concepts of biology book.");
            reportLog("Presence of hyperlinked words terms on the 2.37 concept of Biology book.");

            Assert.assertTrue(biologyBookPage.verifyTheVocabularyTermsOfBiologyBook(), assertFailurePreText + "Presence of vocabulary terms on the 2.37 concepts of biology book.");
            reportLog("Presence of all the vocabulary terms on the 2.37 concept of Biology book.");

            Assert.assertTrue(biologyBookPage.verifyHTagsInBook(), assertFailurePreText + "Presence of Header tag on the 2.37 concepts of biology book.");
            reportLog("Presence of all Header tag on the 2.37 concept of Biology book.");

            Assert.assertTrue(biologyBookPage.verifyDidYouKnowSection(), assertFailurePreText + "Presence of Did you know section on the 2.37 concepts of biology book.");
            reportLog("Did you know section is not there for the 2.37 concept of Biology book.");

            webDriver.navigate().refresh();

            for (int i = 0; i <= 20; i++) {
                scrollByPixel(300);
                basePage.waitForSec(3);
            }

            Assert.assertTrue(biologyBookPage.verifyTheImagesOfBiologyBook(), assertFailurePreText + "Presence of images on the 2.37 concepts of biology book.");
            reportLog("Presence of all images on the 2.37 concept of Biology book.");

            Assert.assertTrue(biologyBookPage.verifyTheVideosOfBiologyBook(), assertFailurePreText + "Presence of videos on the 2.37 concepts of biology book.");
            reportLog("Presence of all the videos on the 2.37 concept of Biology book.");

        } catch (Exception e) {
            result = handleException(e);
        }
        Assert.assertTrue(result, "Test script failed for" + currentMethodName + errorMessage);
    }

    @Test(priority = 38, description = "Verify the Content of 2.38 Genetic Variation concept of Biology book.")
    public void verifyContentOfGeneticVariationConcept() {
        boolean result = true;
        try {
            String url = "https://flexbooks.ck12.org/cbook/ck-12-biology-flexbook-2.0/section/2.38/primary/lesson/genetic-variation-bio/";

            webDriver.navigate().to(url);

            Assert.assertTrue(biologyBookPage.verifyModalityPageTitle("Genetic Variation"), assertFailurePreText + "Presence of title on the 2.38 concepts of biology book.");
            reportLog("Verified Modality title: " + webDriver.getTitle() + "on the 2.38 concept of Biology book.");

            reportLog("The Page Description is: " + biologyBookPage.pageDescription.getAttribute("content"));

            Assert.assertTrue(biologyBookPage.verifyCanonicalMetaTag(), assertFailurePreText + "Presence of canonical meta tag on the 2.38 concepts of biology book.");
            reportLog("Verified Canonical Tag and 1 Tag is found with URL: " + biologyBookPage.canonicalData.getAttribute("href"));

            Assert.assertTrue(biologyBookPage.verifyHyperLinkTagsAndParseTheURLOfTags(), assertFailurePreText + "Presence of hyperlinked words on the 2.38 concepts of biology book.");
            reportLog("Presence of all the hyperlinked words terms on the 2.38 concept of Biology book.");

            Assert.assertTrue(biologyBookPage.verifyTheVocabularyTermsOfBiologyBook(), assertFailurePreText + "Presence of vocabulary terms on the 2.38 concepts of biology book.");
            reportLog("Presence of all the vocabulary terms on the 2.38 concept of Biology book.");

            Assert.assertTrue(biologyBookPage.verifyHTagsInBook(), assertFailurePreText + "Presence of Header tag on the 2.38 concepts of biology book.");
            reportLog("Presence of all Header tag on the 2.38 concept of Biology book.");

            Assert.assertTrue(biologyBookPage.verifyDidYouKnowSection(), assertFailurePreText + "Presence of Did you know section on the 2.38 concepts of biology book.");
            reportLog("Did you know section is not there for the 2.38 concept of Biology book.");

            for (int i = 0; i <= 8; i++) {
                scrollByPixel(500);
                basePage.waitForSec(4);
            }

            Assert.assertTrue(biologyBookPage.verifyTheVideosOfBiologyBook(), assertFailurePreText + "Presence of videos on the 2.38 concepts of biology book.");
            reportLog("Presence of all the videos on the 2.38 concept of Biology book.");

        } catch (Exception e) {
            result = handleException(e);
        }
        Assert.assertTrue(result, "Test script failed for" + currentMethodName + errorMessage);
    }

    @Test(priority = 39, description = "Verify the Content of 2.39 Life Cycle concept of Biology book.")
    public void verifyContentOfLifeCycleConcept() {
        boolean result = true;
        try {
            String url = "https://flexbooks.ck12.org/cbook/ck-12-biology-flexbook-2.0/section/2.39/primary/lesson/reproductive-life-cycles-bio/";

            webDriver.navigate().to(url);

            Assert.assertTrue(biologyBookPage.verifyModalityPageTitle("Life Cycle"), assertFailurePreText + "Presence of title on the 2.39 concepts of biology book.");
            reportLog("Verified Modality title: " + webDriver.getTitle() + "on the 2.39 concept of Biology book.");

            reportLog("The Page Description is: " + biologyBookPage.pageDescription.getAttribute("content"));

            Assert.assertTrue(biologyBookPage.verifyCanonicalMetaTag(), assertFailurePreText + "Presence of canonical meta tag on the 2.39 concepts of biology book.");
            reportLog("Verified Canonical Tag and 1 Tag is found with URL: " + biologyBookPage.canonicalData.getAttribute("href"));

            Assert.assertTrue(biologyBookPage.verifyHyperLinkTagsAndParseTheURLOfTags(), assertFailurePreText + "Presence of hyperlinked words on the 2.39 concepts of biology book.");
            reportLog("There are no hyperlinked words terms on the 2.39 concept of Biology book.");

            Assert.assertTrue(biologyBookPage.verifyTheVocabularyTermsOfBiologyBook(), assertFailurePreText + "Presence of vocabulary terms on the 2.39 concepts of biology book.");
            reportLog("Presence of all the vocabulary terms on the 2.39 concept of Biology book.");

            Assert.assertTrue(biologyBookPage.verifyHTagsInBook(), assertFailurePreText + "Presence of Header tag on the 2.39 concepts of biology book.");
            reportLog("Presence of all Header tag on the 2.39 concept of Biology book.");

            Assert.assertTrue(biologyBookPage.verifyDidYouKnowSection(), assertFailurePreText + "Presence of Did you know section on the 2.39 concepts of biology book.");
            reportLog("Did you know section is not there for the 2.39 concept of Biology book.");

            webDriver.navigate().refresh();

            for (int i = 0; i <= 20; i++) {
                scrollByPixel(300);
                basePage.waitForSec(3);
            }

            Assert.assertTrue(biologyBookPage.verifyTheImagesOfBiologyBook(), assertFailurePreText + "Presence of images on the 2.39 concepts of biology book.");
            reportLog("Presence of all images on the 2.39 concept of Biology book.");

            Assert.assertTrue(biologyBookPage.verifyTheVideosOfBiologyBook(), assertFailurePreText + "Presence of videos on the 2.39 concepts of biology book.");
            reportLog("Presence of all the videos on the 2.39 concept of Biology book.");

        } catch (Exception e) {
            result = handleException(e);
        }
        Assert.assertTrue(result, "Test script failed for" + currentMethodName + errorMessage);
    }
}