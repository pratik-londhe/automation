package testscripts.regression.interactives;

import org.testng.Assert;
import org.testng.annotations.Test;
import testscripts.BaseTestScript;
import uipages.BasePage;
import uipages.flexbook2feature.LoginPage;
import uipages.flexbook2feature.TeacherDashboardPage;
import uipages.interactives.BiologyInteractivesPage;

public class BiologyUnitTwoInteractivesTest extends BaseTestScript {

    private BiologyInteractivesPage biologyInteractivesPage;
    private BasePage basePage;

    @Test(priority = 1, dataProvider = "CK12DataProvider", description = "Verify the Interactives of 2.1 Parts of the Cell concept.")
    public void verifyInteractivesOfPartsOfTheCellConcept(String email, String password, String conceptScientificMethod) {
        boolean result = true;
        try {
            LoginPage loginPage = new LoginPage(webDriver, extentTest, extentReports);
            biologyInteractivesPage = new BiologyInteractivesPage(webDriver, extentTest, extentReports);
            basePage = new BasePage(webDriver, extentTest, extentReports);

            loginPage.teacherLogin(email, password);

            Assert.assertTrue(new TeacherDashboardPage(webDriver, extentTest, extentReports).verifyTeacherProfileOnGamma(), assertFailurePreText + "Presence of Teacher account icon On Gamma");
            reportLog("Presence of Teacher account icon On Gamma");

            webDriver.navigate().to(conceptScientificMethod);

            for (int i = 0; i <= 8; i++) {
                scrollByPixel(500);
                basePage.waitForSec(4);
            }

            Assert.assertTrue(biologyInteractivesPage.verifyBiologyBookCellInteractives("BIO_HS_2_1_4_CellDiagramHighlight", "2.1"), assertFailurePreText + "Presence of 'Common Parts of a Cell' Interactives on the 2.1 concept of biology book.");
            reportLog("'Common Parts of a Cell' interactive is present and functioning as expected.");

        } catch (Exception e) {
            result = handleException(e);
        }
        Assert.assertTrue(result, "Test script failed for" + currentMethodName + errorMessage);
    }

    @Test(priority = 2, description = "Verify the Interactives of 2.2 Prokaryotic and Eukaryotic Cells concept.")
    public void verifyInteractivesOfProkaryoticAndEukaryoticCellsConcept() {
        boolean result = true;
        try {
            String url = "https://flexbooks.ck12.org/cbook/ck-12-biology-flexbook-2.0/section/2.2/primary/lesson/prokaryotic-and-eukaryotic-cells-bio/";
            webDriver.navigate().to(url);

            for (int i = 0; i <= 8; i++) {
                scrollByPixel(500);
                basePage.waitForSec(4);
            }

            Assert.assertTrue(biologyInteractivesPage.verifyBiologyBookCellInteractives("BIO_HS_2_2_2_CellDiagramHighlight", "2.2"), assertFailurePreText + "Presence of 'Eukaryotic Cells' Interactives on the 2.2 concept of biology book.");
            reportLog("'Eukaryotic Cells' interactive is present and functioning as expected.");

            Assert.assertTrue(biologyInteractivesPage.verifyBiologyBookCellInteractives("BIO_HS_2_2_3_CellComparisionHighlight", "2.2part2"), assertFailurePreText + "Presence of 'Prokaryotic Cells' Interactives on the 2.2 concept of biology book.");
            reportLog("'Prokaryotic Cells' interactive is present and functioning as expected.");

        } catch (Exception e) {
            result = handleException(e);
        }
        Assert.assertTrue(result, "Test script failed for" + currentMethodName + errorMessage);
    }

    @Test(priority = 3, description = "Verify the Interactives of 2.3 Principles concept of Biology book.")
    public void verifyInteractivesOfPhospholipidBilayerConcept() {
        boolean result = true;
        try {
            String url = "https://flexbooks.ck12.org/cbook/ck-12-biology-flexbook-2.0/section/2.3/primary/lesson/phospholipid-bilayers-bio/";
            webDriver.navigate().to(url);

            for (int i = 0; i <= 8; i++) {
                scrollByPixel(300);
                basePage.waitForSec(4);
            }

            Assert.assertTrue(biologyInteractivesPage.verifyBiologyBookCellInteractives("BIO_HS_2_3_3_CellMembraneStructure","2.3"), assertFailurePreText + "Presence of 'The Cell Membrane' Interactives on the 2.3 concept of biology book.");
            reportLog("'The Cell Membrane' interactive is present and functioning as expected.");

            Assert.assertTrue(biologyInteractivesPage.verifyBiologyConceptInteractives("BIO_HS_2_3_2_PhospholipidBilayerComposition", "2.3"), assertFailurePreText + "Presence of 'Phospholipid Bilayer' Interactives on the 2.3 concept of biology book.");
            reportLog("'Phospholipid Bilayer' interactive is present and functioning as expected.");

        } catch (Exception e) {
            result = handleException(e);
        }
        Assert.assertTrue(result, "Test script failed for" + currentMethodName + errorMessage);
    }

    @Test(priority = 4, description = "Verify the Interactives of 2.4 Membrane Proteins concept.")
    public void verifyInteractivesOfMembraneProteinsConcept() {
        boolean result = true;
        try {
            String url = "https://flexbooks.ck12.org/cbook/ck-12-biology-flexbook-2.0/section/2.4/primary/lesson/membrane-proteins-bio/";
            webDriver.navigate().to(url);

            for (int i = 0; i <= 15; i++) {
                scrollByPixel(500);
                basePage.waitForSec(4);
            }

            Assert.assertTrue(biologyInteractivesPage.verifyCellMembraneStructureInteractive("Correct"), assertFailurePreText + "Presence of 'Cell Membrane Structure' Interactives on the 2.4 concept of biology book.");
            reportLog("'Cell Membrane Structure' interactive is present and functioning as expected.");

            webDriver.navigate().refresh();

            for (int i = 0; i <= 15; i++) {
                scrollByPixel(300);
                basePage.waitForSec(4);
            }

            Assert.assertTrue(biologyInteractivesPage.verifyCellMembraneStructureInteractive("Incorrect"), assertFailurePreText + "Presence of 'Cell Membrane Structure' Interactives on the 2.4 concept of biology book.");
            reportLog("'Cell Membrane Structure' interactive is present and functioning as expected.");

        } catch (Exception e) {
            result = handleException(e);
        }
        Assert.assertTrue(result, "Test script failed for" + currentMethodName + errorMessage);
    }

    @Test(priority = 8, description = "Verify the Interactives of 2.8 Cell Structure concept of Biology book.")
    public void verifyInteractivesOfCellStructureConcept() {
        boolean result = true;
        try {
            String url = "https://flexbooks.ck12.org/cbook/ck-12-biology-flexbook-2.0/section/2.8/primary/lesson/other-cell-organelles-bio/";
            webDriver.navigate().to(url);

            for (int i = 0; i <= 10; i++) {
                scrollByPixel(300);
                basePage.waitForSec(4);
            }

            Assert.assertTrue(biologyInteractivesPage.verifyMatchTheFunctionsInteractive("Cell Structure", "Correct"), assertFailurePreText + "Presence of 'Match the functions' Interactives on the 2.8 concept of biology book.");
            reportLog("'Match the functions' interactive is present and functioning as expected.");

            webDriver.navigate().refresh();

            for (int i = 0; i <= 10; i++) {
                scrollByPixel(300);
                basePage.waitForSec(4);
            }

            Assert.assertTrue(biologyInteractivesPage.verifyMatchTheFunctionsInteractive("Cell Structure", "Incorrect"), assertFailurePreText + "Presence of 'Match the functions' Interactives on the 2.8 concept of biology book.");
            reportLog("'Match the functions' interactive is present and functioning as expected.");

        } catch (Exception e) {
            result = handleException(e);
        }
        Assert.assertTrue(result, "Test script failed for" + currentMethodName + errorMessage);
    }

    @Test(priority = 11, description = "Verify the Interactives of 2.11 Diffusion concept of Biology book.")
    public void verifyInteractivesOfDiffusionConcept() {
        boolean result = true;
        try {
            String url = "https://flexbooks.ck12.org/cbook/ck-12-biology-flexbook-2.0/section/2.11/primary/lesson/diffusion-bio/";
            webDriver.navigate().to(url);

            for (int i = 0; i <= 15; i++) {
                scrollByPixel(300);
                basePage.waitForSec(4);
            }

            Assert.assertTrue(biologyInteractivesPage.verifyCellDiffusionInteractive(), assertFailurePreText + "Presence of 'Cell Diffusion' Interactives on the 2.11 concept of biology book.");
            reportLog("'Cell Diffusion' interactive is present and functioning as expected.");

            Assert.assertTrue(biologyInteractivesPage.verifyBiologyVideoInteractive("2_11_4_DiffusionFacilitation"), assertFailurePreText + "Presence of 'Cell Diffusion' Video Interactive on the 2.11 concept of biology book.");
            reportLog("'Cell Diffusion' video interactive is present and functioning as expected.");

        } catch (Exception e) {
            result = handleException(e);
        }
        Assert.assertTrue(result, "Test script failed for" + currentMethodName + errorMessage);
    }

    @Test(priority = 13, description = "Verify the Interactives of 2.13 Passive Transport concept of Biology book.")
    public void verifyInteractivesOfPassiveTransportConcept() {
        boolean result = true;
        try {
            String url = "https://flexbooks.ck12.org/cbook/ck-12-biology-flexbook-2.0/section/2.13/primary/lesson/passive-transport-bio/";
            webDriver.navigate().to(url);

            for (int i = 0; i <= 15; i++) {
                scrollByPixel(300);
                basePage.waitForSec(4);
            }

            Assert.assertTrue(biologyInteractivesPage.verifyBiologyVideoInteractive("2_13_2_passiveTransport"), assertFailurePreText + "Presence of 'Passive Transport' Video Interactive on the 2.13 concept of biology book.");
            reportLog("'Passive Transport' video interactive is present and functioning as expected.");

        } catch (Exception e) {
            result = handleException(e);
        }
        Assert.assertTrue(result, "Test script failed for" + currentMethodName + errorMessage);
    }

    @Test(priority = 14, description = "Verify the Interactives of 2.14 Active Transport concept of Biology book.")
    public void verifyInteractivesOfActiveTransportConcept() {
        boolean result = true;
        try {
            String url = "https://flexbooks.ck12.org/cbook/ck-12-biology-flexbook-2.0/section/2.14/primary/lesson/active-transport-bio/";
            webDriver.navigate().to(url);

            for (int i = 0; i <= 10; i++) {
                scrollByPixel(300);
                basePage.waitForSec(4);
            }

            Assert.assertTrue(biologyInteractivesPage.verifyMatchTheFunctionsInteractive("Active Transport", "Correct"), assertFailurePreText + "Presence of 'Match the functions' Interactives on the 2.14 concept of biology book.");
            reportLog("'Match the functions' interactive is present and functioning as expected.");

            webDriver.navigate().refresh();

            for (int i = 0; i <= 10; i++) {
                scrollByPixel(300);
                basePage.waitForSec(4);
            }

            Assert.assertTrue(biologyInteractivesPage.verifyMatchTheFunctionsInteractive("Active Transport", "Incorrect"), assertFailurePreText + "Presence of 'Match the functions' Interactives on the 2.14 concept of biology book.");
            reportLog("'Match the functions' interactive is present and functioning as expected.");

        } catch (Exception e) {
            result = handleException(e);
        }
        Assert.assertTrue(result, "Test script failed for" + currentMethodName + errorMessage);
    }

    @Test(priority = 23, description = "Verify the Interactives of 2.23 Photosynthesis Summary concept of Biology book.")
    public void verifyInteractivesOfPhotosynthesisSummaryConcept() {
        boolean result = true;
        try {
            String url = "https://flexbooks.ck12.org/cbook/ck-12-biology-flexbook-2.0/section/2.23/primary/lesson/photosynthesis-summary-bio/";
            webDriver.navigate().to(url);

            for (int i = 0; i <= 10; i++) {
                scrollByPixel(300);
                basePage.waitForSec(4);
            }

            Assert.assertTrue(biologyInteractivesPage.verifyMatchThePhotosynthesis("Correct"), assertFailurePreText + "Presence of 'Match the Photosynthesis Chloroplast' Interactive on the 2.23 concept of biology book.");
            reportLog("'Match the Photosynthesis Chloroplast' interactive is present and functioning as expected.");

            webDriver.navigate().refresh();

            for (int i = 0; i <= 10; i++) {
                scrollByPixel(300);
                basePage.waitForSec(4);
            }

            Assert.assertTrue(biologyInteractivesPage.verifyMatchThePhotosynthesis("Incorrect"), assertFailurePreText + "Presence of 'Match the Photosynthesis Chloroplast' Interactive on the 2.23 concept of biology book.");
            reportLog("'Match the Photosynthesis Chloroplast' interactive is present and functioning as expected.");

        } catch (Exception e) {
            result = handleException(e);
        }
        Assert.assertTrue(result, "Test script failed for" + currentMethodName + errorMessage);
    }

    @Test(priority = 25, description = "Verify the Interactives of 2.25 Cellular Respiration concept of Biology book.")
    public void verifyInteractivesOfCellularRespirationConcept() {
        boolean result = true;
        try {
            String url = "https://flexbooks.ck12.org/cbook/ck-12-biology-flexbook-2.0/section/2.25/primary/lesson/cellular-respiration-bio/";
            webDriver.navigate().to(url);

            for (int i = 0; i <= 10; i++) {
                scrollByPixel(300);
                basePage.waitForSec(4);
            }

            Assert.assertTrue(biologyInteractivesPage.verifyMatchTheChemicalEquation(), assertFailurePreText + "Presence of 'Match the Cellular Respiration' Interactive on the 2.25 concept of biology book.");
            reportLog("'Match the Cellular Respiration' interactive is present and functioning as expected.");

            Assert.assertTrue(biologyInteractivesPage.verifyMatchTheAerobicRespiration("Correct"), assertFailurePreText + "Presence of 'Match the Aerobic Respiration' Interactive on the 2.25 concept of biology book.");
            reportLog("'Match the Aerobic Respiration' interactive is present and functioning as expected.");

            webDriver.navigate().refresh();

            for (int i = 0; i <= 10; i++) {
                scrollByPixel(300);
                basePage.waitForSec(4);
            }

            Assert.assertTrue(biologyInteractivesPage.verifyMatchTheAerobicRespiration("Incorrect"), assertFailurePreText + "Presence of 'Match the Aerobic Respiration' Interactive on the 2.25 concept of biology book.");
            reportLog("'Match the Aerobic Respiration' interactive is present and functioning as expected.");

        } catch (Exception e) {
            result = handleException(e);
        }
        Assert.assertTrue(result, "Test script failed for" + currentMethodName + errorMessage);
    }

    @Test(priority = 32, description = "Verify the Interactives of 2.32 Cell Cycle concept of Biology book.")
    public void verifyInteractivesOfCellCycleConcept() {
        boolean result = true;
        try {
            String url = "https://flexbooks.ck12.org/cbook/ck-12-biology-flexbook-2.0/section/2.32/primary/lesson/cell-cycle-bio/";
            webDriver.navigate().to(url);

            for (int i = 0; i <= 10; i++) {
                scrollByPixel(300);
                basePage.waitForSec(4);
            }

            Assert.assertTrue(biologyInteractivesPage.verifyBiologyConceptInteractives("BIO_HS_2_32_2_CellCycleAnimation", "2.32"), assertFailurePreText + "Presence of 'Cell Cycle Animation' Interactives on the 2.32 concept of biology book.");
            reportLog("'Cell Cycle Animation' interactive is present and functioning as expected.");

        } catch (Exception e) {
            result = handleException(e);
        }
        Assert.assertTrue(result, "Test script failed for" + currentMethodName + errorMessage);
    }

    @Test(priority = 34, description = "Verify the Interactives of 2.34 Mitosis concept of Biology book.")
    public void verifyInteractivesOfMitosisConcept() {
        boolean result = true;
        try {
            String url = "https://flexbooks.ck12.org/cbook/ck-12-biology-flexbook-2.0/section/2.34/primary/lesson/mitosis-and-cytokinesis-bio/";
            webDriver.navigate().to(url);

            for (int i = 0; i <= 15; i++) {
                scrollByPixel(300);
                basePage.waitForSec(4);
            }

            Assert.assertTrue(biologyInteractivesPage.verifyBiologyBookCellInteractives("BIO_HS_2_34_2_MitosisHighlight", "2.34"), assertFailurePreText + "Mitosis Cell Structure' Interactives on the 2.34 concept of biology book.");
            reportLog("'Mitosis Cell Structure' interactive is present and functioning as expected.");

            Assert.assertTrue(biologyInteractivesPage.verifyBiologyConceptInteractives("BIO_HS_2_34_1_MitosisAnimation", "2.34"), assertFailurePreText + "Presence of 'Mitosis Cell Cycle Animation' Interactives on the 2.34 concept of biology book.");
            reportLog("'Cell Cycle Animation' interactive is present and functioning as expected.");

        } catch (Exception e) {
            result = handleException(e);
        }
        Assert.assertTrue(result, "Test script failed for" + currentMethodName + errorMessage);
    }
}
