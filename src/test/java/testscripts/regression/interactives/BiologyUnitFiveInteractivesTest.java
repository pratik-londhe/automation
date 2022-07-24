package testscripts.regression.interactives;

import org.testng.Assert;
import org.testng.annotations.Test;
import testscripts.BaseTestScript;
import uipages.BasePage;
import uipages.flexbook2feature.LoginPage;
import uipages.flexbook2feature.TeacherDashboardPage;
import uipages.interactives.BiologyInteractivesPage;

public class BiologyUnitFiveInteractivesTest extends BaseTestScript {

    private BiologyInteractivesPage biologyInteractivesPage;
    private BasePage basePage;

    @Test(priority = 1, dataProvider = "CK12DataProvider", description = "Verify the Interactives of 5.21 Natural Selection concept of Biology book.")
    public void verifyInteractivesOfNaturalSelectionConcept(String email, String password, String conceptScientificMethod) {
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

            Assert.assertTrue(biologyInteractivesPage.verifyMatchTheFunctionsInteractive("Natural Selection", "Correct"), assertFailurePreText + "Presence of 'Match the functions' Interactives on the 5.21 concept of biology book.");
            reportLog("'Match the functions' interactive is present and functioning as expected.");

            webDriver.navigate().refresh();

            for (int i = 0; i <= 10; i++) {
                scrollByPixel(300);
                basePage.waitForSec(4);
            }

            Assert.assertTrue(biologyInteractivesPage.verifyMatchTheFunctionsInteractive("Natural Selection", "Incorrect"), assertFailurePreText + "Presence of 'Match the functions' Interactives on the 5.21 concept of biology book.");
            reportLog("'Match the functions' interactive is present and functioning as expected.");

        } catch (Exception e) {
            result = handleException(e);
        }
        Assert.assertTrue(result, "Test script failed for" + currentMethodName + errorMessage);
    }

    @Test(priority = 3, description = "Verify the Interactives of 5.18 Population Genetics concept of Biology book.")
    public void verifyInteractivesOfDNAStructureAndReplicationConcept() {
        boolean result = true;
        try {
            String url = "https://flexbooks.ck12.org/user:aw50zxjhy3rpdmutywrtaw5ay2sxmi5vcmc./cbook/ck-12-biology-for-high-school-ux-enhance/section/5.18/primary/lesson/population-genetics/";
            webDriver.navigate().to(url);

            for (int i = 0; i <= 8; i++) {
                scrollByPixel(500);
                basePage.waitForSec(4);
            }

            Assert.assertTrue(biologyInteractivesPage.verifyBiologyBookCellInteractives("BIO_HS_AN_5_18_1_AllelesFrequencyEvolution", "5.18"), assertFailurePreText + "Presence of 'Common Parts of a Cell' Interactives on the 2.1 concept of biology book.");
            reportLog("'Common Parts of a Cell' interactive is present and functioning as expected.");

        } catch (Exception e) {
            result = handleException(e);
        }
        Assert.assertTrue(result, "Test script failed for" + currentMethodName + errorMessage);
    }
}
