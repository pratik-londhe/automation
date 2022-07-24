package testscripts.regression.teacherlogin.CreateNewFeature.CreatedModalityFeature;

import com.relevantcodes.extentreports.LogStatus;
import org.apache.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.Test;
import testscripts.BaseTestScript;
import uipages.flexbook2feature.*;

/**
 * Created by pratik.londhe on 8/24/2018.
 */
public class WriteModalityWithoutFillingCBookNameTest extends BaseTestScript {
    private static final Logger logger = Logger.getLogger(WriteModalityWithoutFillingCBookNameTest.class);

    @Test(dataProvider = "CK12DataProvider", description = "Verify the click on functionality on \"Write a Modality\" option without filling FlexBook name.")
    public void WriteModalityWithoutFillingCBookName(String email, String password) {
        boolean result = true;
        try {
            CreateFlexBookPage createFlexBookPage = new CreateFlexBookPage(webDriver,extentTest,extentReports);
            LibraryPage libraryPage = new LibraryPage(webDriver,extentTest,extentReports);
            PageMenuTab pageMenuTab = new PageMenuTab(webDriver,extentTest,extentReports);
            TeacherDashboardPage teacherDashboardPage = new TeacherDashboardPage(webDriver,extentTest,extentReports);
            CourseBookCreateEditAssignDelete courseBookCreateEditAssignDelete = new CourseBookCreateEditAssignDelete(webDriver,extentTest,extentReports);

            new LoginPage(webDriver,extentTest, extentReports).teacherLogin(email, password);

            Assert.assertTrue(teacherDashboardPage.verifyTeacherProfileOnGamma(), "Failed to verify user profile in WriteModalityWithoutFillingCBookName method.");
            extentTest.log(LogStatus.PASS, "User Successfully logged in and verified profile icon.");
            logger.info("User Successfully logged in and verified profile icon.");

            pageMenuTab.clickOnLibraryTab();

            Assert.assertTrue(courseBookCreateEditAssignDelete.verifyCreateNewDropDown(), "Failed to verified Create New DropDown");
            extentTest.log(LogStatus.PASS, "Successfully verified Create New DropDown");
            logger.info("Successfully verified Create New DropDown");

            courseBookCreateEditAssignDelete.clickOnCreateNewDropDown();
            libraryPage.clickOnLinkFlexBook();
            createFlexBookPage.clickOnGotItButtonPopUp();
            //createFlexBookPage.clickOnAddContentBtn();
            createFlexBookPage.clickOnNewChapterLink();

            Assert.assertTrue(createFlexBookPage.isInvalidTitleOnPopUpVisible(), "Failed to verify Invalid Title on validation pop up.");
            extentTest.log(LogStatus.PASS, "Successfully verified Invalid Title on validation pop up.");
            logger.info("Successfully verified Invalid Title on validation pop up.");

            Assert.assertTrue(createFlexBookPage.isMessageOnPopUpVisible(), "Failed to verify message on validation pop up.");
            extentTest.log(LogStatus.PASS, "Successfully verified message on validation pop up.");
            logger.info("Successfully verified message on validation pop up.");

            Assert.assertTrue(createFlexBookPage.isCancelBtnOnPopUpVisible(), "Failed to verify cancel button on validation pop up.");
            extentTest.log(LogStatus.PASS, "Successfully verified Cancel button on validation pop up.");
            logger.info("Successfully verified Cancel button on validation pop up.");

            Assert.assertTrue(createFlexBookPage.isEditTitleBtnOnPopUpVisible(), "Failed to verify Edit Title button on validation pop up.");
            extentTest.log(LogStatus.PASS, "Successfully verified Edit Title button on validation pop up.");
            logger.info("Successfully verified Edit Title button on validation pop up.");

        } catch (Exception e) {
            result = handleException(e);
        }
        Assert.assertTrue(result, "Test script failed for WriteModalityWithoutFillingCBookName method." + errorMessage);
    }
}