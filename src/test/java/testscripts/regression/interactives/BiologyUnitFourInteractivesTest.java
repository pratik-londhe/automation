package testscripts.regression.interactives;

import org.testng.Assert;
import org.testng.annotations.Test;
import testscripts.BaseTestScript;
import uipages.BasePage;
import uipages.flexbook2feature.LoginPage;
import uipages.flexbook2feature.TeacherDashboardPage;
import uipages.interactives.BiologyBookPage;
import uipages.interactives.BiologyInteractivesPage;

public class BiologyUnitFourInteractivesTest extends BaseTestScript {

    private BiologyInteractivesPage biologyInteractivesPage;
    private BasePage basePage;
    private BiologyBookPage biologyBookPage;

    @Test(priority = 1, dataProvider = "CK12DataProvider", description = "Verify the Interactives of 4.1 Central Dogma concept of Biology book.")
    public void verifyInteractivesOfCentralDogmaConcept(String email, String password, String conceptScientificMethod) {
        boolean result = true;
        try {
            LoginPage loginPage = new LoginPage(webDriver, extentTest, extentReports);
            biologyInteractivesPage = new BiologyInteractivesPage(webDriver, extentTest, extentReports);
            basePage = new BasePage(webDriver, extentTest, extentReports);
            biologyBookPage = new BiologyBookPage(webDriver, extentTest, extentReports);

            loginPage.teacherLogin(email, password);

            Assert.assertTrue(new TeacherDashboardPage(webDriver, extentTest, extentReports).verifyTeacherProfileOnGamma(), assertFailurePreText + "Presence of Teacher account icon On Gamma");
            reportLog("Presence of Teacher account icon On Gamma");

            webDriver.navigate().to(conceptScientificMethod);

            for (int i = 0; i <= 8; i++) {
                scrollByPixel(300);
                basePage.waitForSec(4);
            }
            Assert.assertTrue(biologyInteractivesPage.verifyDNAInformationInteractive(), assertFailurePreText + "Presence of 'Central Dogma DNA Information' Interactives on the 4.1 concept of biology book.");
            reportLog("'Central Dogma DNA Information' interactive is present and functioning as expected.");

        } catch (Exception e) {
            result = handleException(e);
        }
        Assert.assertTrue(result, "Test script failed for" + currentMethodName + errorMessage);
    }

    @Test(priority = 3, description = "Verify the Interactives of 4.3 DNA Structure and Replication concept of Biology book.")
    public void verifyInteractivesOfDNAStructureAndReplicationConcept() {
        boolean result = true;
        try {
            String url = "https://flexbooks.ck12.org/cbook/ck-12-biology-flexbook-2.0/section/4.3/primary/lesson/dna-structure-and-replication-bio/";
            webDriver.navigate().to(url);

            for (int i = 0; i <= 8; i++) {
                scrollByPixel(500);
                basePage.waitForSec(4);
            }

            Assert.assertTrue(biologyInteractivesPage.verifyNitrogenBaseInteractives(), assertFailurePreText + "Presence of 'Nitrogen' Interactives on the 4.3 concept of biology book.");
            reportLog("'Nitrogen' interactive is present and functioning as expected.");

            Assert.assertTrue(biologyInteractivesPage.verifyDoubleHelixInteractives(), assertFailurePreText + "Presence of The Double Helix' Interactives on the 4.3 concept of biology book.");
            reportLog("'The Double Helix' interactive is present and functioning as expected.");

            Assert.assertTrue(biologyInteractivesPage.verifyDNAReplicaInteractive(), assertFailurePreText + "Presence of 'DNA Replication' Interactives on the 4.3 concept of biology book.");
            reportLog("'DNA Replication' interactive is present and functioning as expected.");

        } catch (Exception e) {
            result = handleException(e);
        }
        Assert.assertTrue(result, "Test script failed for" + currentMethodName + errorMessage);
    }

    @Test(priority = 4, description = "Verify the Interactives of 4.4 RNA concept of Biology book.")
    public void verifyInteractivesOfRNAConcept() {
        boolean result = true;
        try {
            String url = "https://flexbooks.ck12.org/cbook/ck-12-biology-flexbook-2.0/section/4.4/primary/lesson/rna-bio/";
            webDriver.navigate().to(url);

            biologyBookPage.dismissInsightPopup();

            for (int i = 0; i <= 10; i++) {
                scrollByPixel(300);
                basePage.waitForSec(4);
            }

            Assert.assertTrue(biologyInteractivesPage.verifyDNAAndRNAMatchingInteractive("Correct"), assertFailurePreText + "Presence of 'Match the DNA and RNA' Interactive on the 4.4 concept of biology book.");
            reportLog("'Match the DNA and RNA' Interactive is present and functioning as expected.");

            webDriver.navigate().refresh();

            for (int i = 0; i <= 10; i++) {
                scrollByPixel(300);
                basePage.waitForSec(4);
            }

            Assert.assertTrue(biologyInteractivesPage.verifyDNAAndRNAMatchingInteractive("Incorrect"), assertFailurePreText + "Presence of 'Match the DNA and RNA' Interactive on the 4.4 concept of biology book.");
            reportLog("'Match the DNA and RNA' Interactive is present and functioning as expected.");

        } catch (Exception e) {
            result = handleException(e);
        }
        Assert.assertTrue(result, "Test script failed for" + currentMethodName + errorMessage);
    }

    @Test(priority = 6, description = "Verify the Interactives of 4.6 Genetic Code concept of Biology book.")
    public void verifyInteractivesOfGeneticCodeConcept() {
        boolean result = true;
        try {
            String url = "https://flexbooks.ck12.org/cbook/ck-12-biology-flexbook-2.0/section/4.6/primary/lesson/genetic-code-bio/";
            webDriver.navigate().to(url);

            biologyBookPage.dismissInsightPopup();

            for (int i = 0; i <= 10; i++) {
                scrollByPixel(300);
                basePage.waitForSec(4);
            }

            Assert.assertTrue(biologyInteractivesPage.verifyMatchTheGeneticCode("Correct"), assertFailurePreText + "Presence of 'Match the Genetic Code' Interactive on the 4.6 concept of biology book.");
            reportLog("'Match the Genetic Code' interactive is present and functioning as expected.");

            webDriver.navigate().refresh();

            for (int i = 0; i <= 10; i++) {
                scrollByPixel(300);
                basePage.waitForSec(4);
            }

            Assert.assertTrue(biologyInteractivesPage.verifyMatchTheGeneticCode("Incorrect"), assertFailurePreText + "Presence of 'Match the Genetic Code' Interactive on the 4.6 concept of biology book.");
            reportLog("'Match the Genetic Code' interactive is present and functioning as expected.");

        } catch (Exception e) {
            result = handleException(e);
        }
        Assert.assertTrue(result, "Test script failed for" + currentMethodName + errorMessage);
    }

    @Test(priority = 7, description = "Verify the Interactives of 4.7 Translation concept of Biology book.")
    public void verifyInteractivesOfTranslationConcept() {
        boolean result = true;
        try {
            String url = "https://flexbooks.ck12.org/cbook/ck-12-biology-flexbook-2.0/section/4.7/primary/lesson/translation-of-rna-to-protein-bio/";
            webDriver.navigate().to(url);

            biologyBookPage.dismissInsightPopup();

            for (int i = 0; i <= 8; i++) {
                scrollByPixel(300);
                basePage.waitForSec(4);
            }

            Assert.assertTrue(biologyInteractivesPage.verifyTranslationMolecularRNAInteractive(), assertFailurePreText + "Presence of 'Translation Molecular RNA' Interactive on the 4.7 concept of biology book.");
            reportLog("'Translation Molecular RNA' interactive is present and functioning as expected.");

        } catch (Exception e) {
            result = handleException(e);
        }
        Assert.assertTrue(result, "Test script failed for" + currentMethodName + errorMessage);
    }

    @Test(priority = 8, description = "Verify the Interactives of 4.8 Mutation concept of Biology book.")
    public void verifyInteractivesOfMutationConcept() {
        boolean result = true;
        try {
            String url = "https://flexbooks.ck12.org/cbook/ck-12-biology-flexbook-2.0/section/4.8/primary/lesson/mutation-types-bio/";
            webDriver.navigate().to(url);

            biologyBookPage.dismissInsightPopup();

            for (int i = 0; i <= 18; i++) {
                scrollByPixel(300);
                basePage.waitForSec(4);
            }

            Assert.assertTrue(biologyInteractivesPage.verifyAminoAcidMatchInteractive(), assertFailurePreText + "Presence of 'Match the Amino Acid' Interactive on the 4.8 concept of biology book.");
            reportLog("'Match the Genetic Code' interactive is present and functioning as expected.");

            Assert.assertTrue(biologyInteractivesPage.verifyBiologyBookCellInteractives("BIO_HS_AN_4_8_2_ChromosomeAlteration", "4.8"), assertFailurePreText + "Presence of 'Chromosomal Alterations' Interactive on the 4.8 concept of biology book.");
            reportLog("Chromosomal Alterations' Interactive on the 4.8 is present and functioning as expected.");

        } catch (Exception e) {
            result = handleException(e);
        }
        Assert.assertTrue(result, "Test script failed for" + currentMethodName + errorMessage);
    }
}
