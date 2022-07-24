package testscripts.regression.interactives;

import org.testng.Assert;
import org.testng.annotations.Test;
import testscripts.BaseTestScript;
import uipages.BasePage;
import uipages.flexbook2feature.LoginPage;
import uipages.flexbook2feature.TeacherDashboardPage;
import uipages.interactives.BiologyBookPage;

public class BiologyUnitSixNoInteractiveTest extends BaseTestScript {
    private BiologyBookPage biologyBookPage;
    private BasePage basePage;

    @Test(priority = 2, dataProvider = "CK12DataProvider", description = "Verify the Content of 6.2 Energy Flow concept of Biology book.")
    public void verifyContentOfEnergyFlowConcept(String email, String password, String conceptScientificMethod) {
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

            Assert.assertTrue(biologyBookPage.verifyModalityPageTitle("Energy Flow"), assertFailurePreText + "Presence of title on the 6.2 concepts of biology book.");
            reportLog("Verified Modality title: " + webDriver.getTitle() + "on the 6.2 concept of Biology book.");

            reportLog("The Page Description is: " + biologyBookPage.pageDescription.getAttribute("content"));

            Assert.assertTrue(biologyBookPage.verifyCanonicalMetaTag(), assertFailurePreText + "Presence of canonical meta tag on the 6.2 concepts of biology book.");
            reportLog("Verified Canonical Tag and 1 Tag is found with URL: " + biologyBookPage.canonicalData.getAttribute("href"));

            Assert.assertTrue(biologyBookPage.verifyHyperLinkTagsAndParseTheURLOfTags(), assertFailurePreText + "Presence of hyperlinked words on the 6.2 concepts of biology book.");
            reportLog("Presence of all the hyperlinked words terms on the 6.2 concept of Biology book.");

            for (int i = 0; i <= 14; i++) {
                scrollByPixel(500);
                basePage.waitForSec(4);
            }

            Assert.assertTrue(biologyBookPage.verifyTheVocabularyTermsOfBiologyBook(), assertFailurePreText + "Presence of vocabulary terms on the 6.2 concepts of biology book.");
            reportLog("Presence of all the vocabulary terms on the 6.2 concept of Biology book.");

            Assert.assertTrue(biologyBookPage.verifyHTagsInBook(), assertFailurePreText + "Presence of Header tag on the 6.2  concepts of biology book.");
            reportLog("Presence of all Header tag on the 6.2 concept of Biology book.");

            Assert.assertTrue(biologyBookPage.verifyDidYouKnowSection(), assertFailurePreText + "Presence of Did you know section on the 6.2 concepts of biology book.");
            reportLog("Presence of all Did you know section on the 6.2 concept of Biology book.");

            Assert.assertTrue(biologyBookPage.verifyTheImagesOfBiologyBook(), assertFailurePreText + "Presence of images on the 6.2 concepts of biology book.");
            reportLog("Presence of all images on the 6.2 concept of Biology book.");

            Assert.assertTrue(biologyBookPage.verifyTheVideosOfBiologyBook(), assertFailurePreText + "Presence of videos on the 6.2 concepts of biology book.");
            reportLog("Presence of all the videos on the 6.2 concept of Biology book.");

        } catch (Exception e) {
            result = handleException(e);
        }
        Assert.assertTrue(result, "Test script failed for" + currentMethodName + errorMessage);
    }

    @Test(priority = 11, description = "Verify the Content of 6.11 Freshwater and Wetland Biomes concept of Biology book.")
    public void verifyContentOfFreshwaterAndWetlandBiomesConcept() {
        boolean result = true;
        try {
            String url = "https://flexbooks.ck12.org/user:aw50zxjhy3rpdmutywrtaw5ay2sxmi5vcmc./cbook/ck-12-biology-for-high-school-ux-enhance/section/6.11/primary/lesson/freshwater-and-wetlands-biomes-bio/";
            webDriver.navigate().to(url);

            Assert.assertTrue(biologyBookPage.verifyModalityPageTitle("Freshwater and Wetland Biomes"), assertFailurePreText + "Presence of title on the 6.11 concepts of biology book.");
            reportLog("Verified Modality title: " + webDriver.getTitle() + "on the 6.11 concept of Biology book.");

            reportLog("The Page Description is: " + biologyBookPage.pageDescription.getAttribute("content"));

            Assert.assertTrue(biologyBookPage.verifyCanonicalMetaTag(), assertFailurePreText + "Presence of canonical meta tag on the 6.11 concepts of biology book.");
            reportLog("Verified Canonical Tag and 1 Tag is found with URL: " + biologyBookPage.canonicalData.getAttribute("href"));

            Assert.assertTrue(biologyBookPage.verifyHyperLinkTagsAndParseTheURLOfTags(), assertFailurePreText + "Presence of hyperlinked words on the 6.11 concepts of biology book.");
            reportLog("Presence of all the hyperlinked words terms on the 6.11 concept of Biology book.");

            for (int i = 0; i <= 14; i++) {
                scrollByPixel(500);
                basePage.waitForSec(4);
            }

            Assert.assertTrue(biologyBookPage.verifyTheVocabularyTermsOfBiologyBook(), assertFailurePreText + "Presence of vocabulary terms on the 6.11 concepts of biology book.");
            reportLog("Presence of all the vocabulary terms on the 6.11 concept of Biology book.");

            Assert.assertTrue(biologyBookPage.verifyHTagsInBook(), assertFailurePreText + "Presence of Header tag on the 6.11 concepts of biology book.");
            reportLog("Presence of all Header tag on the 6.11 concept of Biology book.");

            Assert.assertTrue(biologyBookPage.verifyDidYouKnowSection(), assertFailurePreText + "Presence of Did you know section on the 6.11 concepts of biology book.");
            reportLog("Presence of all Did you know section on the 6.11 concept of Biology book.");

            Assert.assertTrue(biologyBookPage.verifyTheImagesOfBiologyBook(), assertFailurePreText + "Presence of images on the 6.11 concepts of biology book.");
            reportLog("Presence of all images on the 6.11 concept of Biology book.");

            Assert.assertTrue(biologyBookPage.verifyTheVideosOfBiologyBook(), assertFailurePreText + "Presence of videos on the 6.11 concepts of biology book.");
            reportLog("Presence of all the videos on the 6.11 concept of Biology book.");

        } catch (Exception e) {
            result = handleException(e);
        }
        Assert.assertTrue(result, "Test script failed for" + currentMethodName + errorMessage);
    }

    @Test(priority = 19, description = "Verify the Content of 6.19 Population Growth concept of Biology book.")
    public void verifyContentOfPopulationGrowthConcept() {
        boolean result = true;
        try {
            String url = "https://flexbooks.ck12.org/user:aw50zxjhy3rpdmutywrtaw5ay2sxmi5vcmc./cbook/ck-12-biology-for-high-school-ux-enhance/section/6.19/primary/lesson/population-growth/";
            webDriver.navigate().to(url);

            Assert.assertTrue(biologyBookPage.verifyModalityPageTitle("Population Growth"), assertFailurePreText + "Presence of title on the 6.19 concepts of biology book.");
            reportLog("Verified Modality title: " + webDriver.getTitle() + "on the 6.19 concept of Biology book.");

            reportLog("The Page Description is: " + biologyBookPage.pageDescription.getAttribute("content"));

            Assert.assertTrue(biologyBookPage.verifyCanonicalMetaTag(), assertFailurePreText + "Presence of canonical meta tag on the 6.19 concepts of biology book.");
            reportLog("Verified Canonical Tag and 1 Tag is found with URL: " + biologyBookPage.canonicalData.getAttribute("href"));

            Assert.assertTrue(biologyBookPage.verifyHyperLinkTagsAndParseTheURLOfTags(), assertFailurePreText + "Presence of hyperlinked words on the 6.19 concepts of biology book.");
            reportLog("Presence of all the hyperlinked words terms on the 6.19 concept of Biology book.");

            for (int i = 0; i <= 14; i++) {
                scrollByPixel(500);
                basePage.waitForSec(4);
            }

            Assert.assertTrue(biologyBookPage.verifyTheVocabularyTermsOfBiologyBook(), assertFailurePreText + "Presence of vocabulary terms on the 6.19 concepts of biology book.");
            reportLog("Presence of all the vocabulary terms on the 6.19 concept of Biology book.");

            Assert.assertTrue(biologyBookPage.verifyHTagsInBook(), assertFailurePreText + "Presence of Header tag on the 6.19 concepts of biology book.");
            reportLog("Presence of all Header tag on the 6.19 concept of Biology book.");

            Assert.assertTrue(biologyBookPage.verifyDidYouKnowSection(), assertFailurePreText + "Presence of Did you know section on the 6.19 concepts of biology book.");
            reportLog("Presence of all Did you know section on the 6.19 concept of Biology book.");

            Assert.assertTrue(biologyBookPage.verifyTheImagesOfBiologyBook(), assertFailurePreText + "Presence of images on the 6.19 concepts of biology book.");
            reportLog("Presence of all images on the 6.19 concept of Biology book.");

            Assert.assertTrue(biologyBookPage.verifyTheVideosOfBiologyBook(), assertFailurePreText + "Presence of videos on the 6.19 concepts of biology book.");
            reportLog("Presence of all the videos on the 6.19 concept of Biology book.");

        } catch (Exception e) {
            result = handleException(e);
        }
        Assert.assertTrue(result, "Test script failed for" + currentMethodName + errorMessage);
    }
}
