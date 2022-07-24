package testscripts.regression.interactives;

import org.testng.Assert;
import org.testng.annotations.Test;
import testscripts.BaseTestScript;
import uipages.BasePage;
import uipages.flexbook2feature.LoginPage;
import uipages.flexbook2feature.TeacherDashboardPage;
import uipages.interactives.BiologyInteractivesPage;

public class BiologyUnitOneInteractivesTest extends BaseTestScript {

    private BiologyInteractivesPage biologyInteractivesPage;
    private BasePage basePage;

    @Test(priority = 1, dataProvider = "CK12DataProvider", description = "Verify the Interactives of 1.4 Characteristics of Life concept of Biology book.")
    public void verifyInteractivesOfCharacteristicsOfLifeConcept(String email, String password, String conceptScientificMethod) {
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
                scrollByPixel(300);
                basePage.waitForSec(4);
            }
            Assert.assertTrue(biologyInteractivesPage.verifyBiologyConceptInteractives("BIO_HS_1_4_5_Homeostasis", "1.4"), assertFailurePreText + "Presence of 'Homeostasis in Tree Frog' Interactives on the 1.4 concept of biology book.");
            reportLog("'Homeostasis in Tree Frog' interactive is present and functioning as expected.");

        } catch (Exception e) {
            result = handleException(e);
        }
        Assert.assertTrue(result, "Test script failed for" + currentMethodName + errorMessage);
    }

    @Test(priority = 2, description = "Verify the Interactives of 1.5 Principles concept of Biology book.")
    public void verifyInteractivesOfPrinciplesConcept() {
        boolean result = true;
        try {
            String url = "https://flexbooks.ck12.org/cbook/ck-12-biology-flexbook-2.0/section/1.5/primary/lesson/principles-of-biology-bio/";
            webDriver.navigate().to(url);

            for (int i = 0; i <= 8; i++) {
                scrollByPixel(300);
                basePage.waitForSec(4);
            }

            Assert.assertTrue(biologyInteractivesPage.verifyBiologyConceptInteractives("BIO_HS_1_5_2_Genes", "1.5"), assertFailurePreText + "Presence of 'The Gene Theory' Interactives on the 1.5 concept of biology book.");
            reportLog("'The Gene Theory' interactive is present and functioning as expected.");

        } catch (Exception e) {
            result = handleException(e);
        }
        Assert.assertTrue(result, "Test script failed for" + currentMethodName + errorMessage);
    }

    @Test(priority = 3, description = "Verify the Interactives of 1.7 Organization Of Living Things concept of Biology book.")
    public void verifyInteractivesOfOrganizationOfLivingConcept() {
        boolean result = true;
        try {
            String url = "https://flexbooks.ck12.org/cbook/ck-12-biology-flexbook-2.0/section/1.7/primary/lesson/organization-of-living-things-bio/";
            webDriver.navigate().to(url);

            for (int i = 0; i <= 8; i++) {
                scrollByPixel(50);
                basePage.waitForSec(4);
            }

            Assert.assertTrue(biologyInteractivesPage.verifyBiologyConceptInteractives("BIO_HS_1_7_2_LevelsHuman", "1.7.1"), assertFailurePreText + "Presence of 'Levels of Organization' Interactives on the 1.7 concept of biology book.");
            reportLog("'Levels of Organization' interactive is present and functioning as expected.");

            Assert.assertTrue(biologyInteractivesPage.verifyBiologyConceptInteractives("BIO_HS_1_7_3_LevelsNature", "1.7.2"), assertFailurePreText + "Presence of 'Biosphere' Interactives on the 1.7 concept of biology book.");
            reportLog("'Biosphere' interactive is present and functioning as expected.");

        } catch (Exception e) {
            result = handleException(e);
        }
        Assert.assertTrue(result, "Test script failed for" + currentMethodName + errorMessage);
    }

    @Test(priority = 5, description = "Verify the Interactives of 1.9 Significance of Carbon concept of Biology book.")
    public void verifyInteractivesOfPSignificanceOfCarbonConcept() {
        boolean result = true;
        try {
            String url = "https://flexbooks.ck12.org/cbook/ck-12-biology-flexbook-2.0/section/1.9/primary/lesson/significance-of-carbon-bio/";
            webDriver.navigate().to(url);

            for (int i = 0; i <= 8; i++) {
                scrollByPixel(300);
                basePage.waitForSec(4);
            }

            Assert.assertTrue(biologyInteractivesPage.verifyMatchTheFunctionsInteractive("Significance of Carbon", "Correct"), assertFailurePreText + "Presence of 'Match the functions' Interactives on the 1.9 concept of biology book.");
            reportLog("'Match the functions' interactive is present and functioning as expected.");

            webDriver.navigate().refresh();

            for (int i = 0; i <= 10; i++) {
                scrollByPixel(300);
                basePage.waitForSec(4);
            }

            Assert.assertTrue(biologyInteractivesPage.verifyMatchTheFunctionsInteractive("Significance of Carbon", "Incorrect"), assertFailurePreText + "Presence of 'Match the functions' Interactives on the 1.9 concept of biology book.");
            reportLog("'Match the functions' interactive is present and functioning as expected.");

        } catch (Exception e) {
            result = handleException(e);
        }
        Assert.assertTrue(result, "Test script failed for" + currentMethodName + errorMessage);
    }

    @Test(priority = 6, description = "Verify the Interactives of 1.10 Carbohydrates concept of Biology book.")
    public void verifyInteractivesOfCarbohydratesConcept() {
        boolean result = true;
        try {
            String url = "https://flexbooks.ck12.org/cbook/ck-12-biology-flexbook-2.0/section/1.10/primary/lesson/carbohydrates-bio/";
            webDriver.navigate().to(url);

            for (int i = 0; i <= 8; i++) {
                scrollByPixel(300);
                basePage.waitForSec(4);
            }

            Assert.assertTrue(biologyInteractivesPage.verifyBiologyConceptInteractives("BIO_HS_1_10_3_CarbohydratesTypes", "1.10"), assertFailurePreText + "Presence of 'Monosaccharides and Disaccharides' Interactives on the 1.10 concept of biology book.");
            reportLog("'Monosaccharides and Disaccharides' interactive is present and functioning as expected.");

        } catch (Exception e) {
            result = handleException(e);
        }
        Assert.assertTrue(result, "Test script failed for" + currentMethodName + errorMessage);
    }

    @Test(priority = 7, description = "Verify the Interactives of 1.11 Proteins concept of Biology book.")
    public void verifyInteractivesOfProteinsConcept() {
        boolean result = true;
        try {
            String url = "https://flexbooks.ck12.org/cbook/ck-12-biology-flexbook-2.0/section/1.11/primary/lesson/proteins-bio/";
            webDriver.navigate().to(url);

            for (int i = 0; i <= 8; i++) {
                scrollByPixel(300);
                basePage.waitForSec(4);
            }

            Assert.assertTrue(biologyInteractivesPage.verifyBiologyConceptInteractives("BIO_HS_1_11_3_ProtienStructureLevels", "1.11"), assertFailurePreText + "Presence of 'Protein Structure' Interactives on the 1.11 concept of biology book.");
            reportLog("'Protein Structure' interactive is present and functioning as expected.");

            Assert.assertTrue(biologyInteractivesPage.verifyMatchTheFunctionsInteractive("Proteins", "Correct"), assertFailurePreText + "Presence of 'Proteins and Diet' Interactives on the 1.11 concept of biology book.");
            reportLog("'Proteins and Diet' interactive is present and functioning as expected.");

            webDriver.navigate().refresh();

            for (int i = 0; i <= 10; i++) {
                scrollByPixel(300);
                basePage.waitForSec(4);
            }

            Assert.assertTrue(biologyInteractivesPage.verifyMatchTheFunctionsInteractive("Proteins", "Incorrect"), assertFailurePreText + "Presence of 'Proteins and Diet' Interactives on the 1.11 concept of biology book.");
            reportLog("'Proteins and Diet' interactive is present and functioning as expected.");

        } catch (Exception e) {
            result = handleException(e);
        }
        Assert.assertTrue(result, "Test script failed for" + currentMethodName + errorMessage);
    }

    @Test(priority = 9, description = "Verify the Interactives of 1.13 Nucleic Acids concept of Biology book.")
    public void verifyInteractivesOfNucleicAcidsConcept() {
        boolean result = true;
        try {
            String url = "https://flexbooks.ck12.org/cbook/ck-12-biology-flexbook-2.0/section/1.13/primary/lesson/nucleic-acids-bio/";
            webDriver.navigate().to(url);

            for (int i = 0; i <= 8; i++) {
                scrollByPixel(300);
                basePage.waitForSec(4);
            }

            Assert.assertTrue(biologyInteractivesPage.verifyNucleicAcidInteractive(), assertFailurePreText + "Presence of 'Nucleic Acids' Interactives on the 1.13 concept of biology book.");
            reportLog("'Nucleic Acids' interactive is present and functioning as expected.");

        } catch (Exception e) {
            result = handleException(e);
        }
        Assert.assertTrue(result, "Test script failed for" + currentMethodName + errorMessage);
    }

    @Test(priority = 13, description = "Verify the Interactives of 1.17 Enzymes concept.")
    public void verifyInteractivesOfEnzymesConcept() {
        boolean result = true;
        try {
            String url = "https://flexbooks-master.ck12.org/cbook/ck-12-biology-for-high-school-6096989/section/1.17/primary/lesson/enzymes/";
            webDriver.navigate().to(url);

            for (int i = 0; i <= 2; i++) {
                scrollByPixel(500);
                basePage.waitForSec(4);
            }

            Assert.assertTrue(biologyInteractivesPage.verifyEnzymesInteractive(), assertFailurePreText + "Presence of 'Enzymes' Interactives on the 4.3 concept of biology book.");
            reportLog("'Enzymes' interactive is present and functioning as expected.");

        } catch (Exception e) {
            result = handleException(e);
        }
        Assert.assertTrue(result, "Test script failed for" + currentMethodName + errorMessage);
    }

    @Test(priority = 14, description = "Verify the Interactives of 1.18 Enzyme Function concept.")
    public void verifyInteractivesOfEnzymeFunctionConcept() {
        boolean result = true;
        try {
            String url = "https://flexbooks.ck12.org/cbook/ck-12-biology-flexbook-2.0/section/1.18/primary/lesson/enzyme-function-bio/";
            webDriver.navigate().to(url);

            for (int i = 0; i <= 2; i++) {
                scrollByPixel(500);
                basePage.waitForSec(4);
            }

            Assert.assertTrue(biologyInteractivesPage.verifyBiologyConceptInteractives("BIO_HS_1_18_2_LevelsOfProteinStruct", "1.18"), assertFailurePreText + "Presence of 'Enzymes Functions' Interactives on the 1.11 concept of biology book.");
            reportLog("'Enzymes Functions' interactive is present and functioning as expected.");

            Assert.assertTrue(biologyInteractivesPage.verifyPHActivityOnEnzymeInteractives(), assertFailurePreText + "Presence of 'Explore the effect of pH on the activity of the pepsin enzyme' Interactives on the 1.18 concept of biology book.");
            reportLog("'Explore the effect of pH on the activity of the pepsin enzyme' interactive is present and functioning as expected.");

        } catch (Exception e) {
            result = handleException(e);
        }
        Assert.assertTrue(result, "Test script failed for" + currentMethodName + errorMessage);
    }

    @Test(priority = 15, description = "Verify the Interactives of 1.19 Water and Life concept.")
    public void verifyInteractivesOfWaterAndLifeConcept() {
        boolean result = true;
        try {
            String url = "https://flexbooks.ck12.org/cbook/ck-12-biology-flexbook-2.0/section/1.19/primary/lesson/water-and-life-bio/";
            webDriver.navigate().to(url);

            for (int i = 0; i <= 8; i++) {
                scrollByPixel(500);
                basePage.waitForSec(4);
            }

            Assert.assertTrue(biologyInteractivesPage.verifyHydrogenBondInteractive(), assertFailurePreText + "Presence of 'Structure and Properties of Water' Interactives on the 1.19 concept of biology book.");
            reportLog("'Structure and Properties of Water' interactive is present and functioning as expected.");

        } catch (Exception e) {
            result = handleException(e);
        }
        Assert.assertTrue(result, "Test script failed for" + currentMethodName + errorMessage);
    }
}