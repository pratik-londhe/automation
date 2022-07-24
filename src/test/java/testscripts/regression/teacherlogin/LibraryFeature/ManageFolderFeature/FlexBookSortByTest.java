package testscripts.regression.teacherlogin.LibraryFeature.ManageFolderFeature;

import com.relevantcodes.extentreports.LogStatus;
import org.apache.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.Test;
import testscripts.BaseTestScript;
import uipages.flexbook2feature.*;

public class FlexBookSortByTest extends BaseTestScript {
    private static final Logger logger = Logger.getLogger(FlexBookSortByTest.class);

    @Test(priority = 1, dataProvider = "CK12DataProvider", description = "Verify  Functionality of 'Sort By' DropDown After Clicking On Library Page")
    public void verifyFunctionalityOfSortByDropDown(String email, String password) {
        boolean result = true;
        try {
            FlexBookSortBy flexBookSortBy = new FlexBookSortBy(webDriver, extentTest, extentReports);

            CourseBookCreateEditAssignDelete courseBookCreateEditAssignDelete = new CourseBookCreateEditAssignDelete(webDriver, extentTest, extentReports);

            new LoginPage(webDriver, extentTest, extentReports).teacherLogin(email, password);

            Assert.assertTrue(new TeacherDashboardPage(webDriver, extentTest, extentReports).verifyTeacherProfileOnGamma(), "Failed to verify user profile for CbookAssignFromModalityPageTest.");
            extentTest.log(LogStatus.PASS, "User Successfully logged in and verified profile icon.");
            logger.info("User Successfully logged in and verified profile icon.");

            new PageMenuTab(webDriver, extentTest, extentReports).clickOnLibraryTab();

            Assert.assertTrue(courseBookCreateEditAssignDelete.verifyCreateNewDropDown(), "Failed to verified Create New DropDown");
            extentTest.log(LogStatus.PASS, "Successfully verified Create New DropDown");
            logger.info("Successfully verified Create New DropDown");

            Assert.assertTrue(flexBookSortBy.verifySortDropDown(), "Failed to verified Sort DropDown");
            extentTest.log(LogStatus.PASS, "Successfully  verified Sort DropDown");
            logger.info("Successfully  verified Sort DropDown");

            flexBookSortBy.clickOnSortDropDown();

            Assert.assertTrue(flexBookSortBy.verifyAscendingLink(), "Failed to verified Ascending Link.");
            extentTest.log(LogStatus.PASS, "Successfully verified Ascending Link.");
            logger.info("Successfully verified Ascending Link.");

            Assert.assertTrue(flexBookSortBy.verifyDescendingLink(), "Failed to verified Descending Link.");
            extentTest.log(LogStatus.PASS, "Successfully verified Descending Link.");
            logger.info("Successfully verified Descending Link.");

            Assert.assertTrue(flexBookSortBy.verifyNewestFirstLink(), "Failed to verified Newest First Link.");
            extentTest.log(LogStatus.PASS, "Successfully verified Newest First Link.");
            logger.info("Successfully verified Newest First Link.");

            Assert.assertTrue(flexBookSortBy.verifyOldestFirstLink(), "Failed to verified Oldest First Link.");
            extentTest.log(LogStatus.PASS, "Successfully verified Oldest First Link.");
            logger.info("Successfully verified Oldest First Link.");

            Assert.assertTrue(flexBookSortBy.verifyRecentlyModifiedLink(), "Failed to verified Recently Modified Link.");
            extentTest.log(LogStatus.PASS, "Successfully verified Recently Modified Link.");
            logger.info("Successfully verified Recently Modified Link.");

            Assert.assertTrue(flexBookSortBy.verifyOldestModifiedLink(), "Failed to verified Oldest Modified Link.");
            extentTest.log(LogStatus.PASS, "Successfully verified Oldest Modified Link.");
            logger.info("Successfully verified Oldest Modified Link.");

        } catch (Exception e) {
            result = handleException(e);
        }
        Assert.assertTrue(result, "Test script failed for  : " + errorMessage);
    }

    @Test(priority = 2, description = "Verify  Functionality of 'Ascending' Link After Clicking On Sort By DropDown")
    public void verifyFunctionalityOfAscendingLink() {
        boolean result = true;
        try {
            FlexBookSortBy flexBookSortBy = new FlexBookSortBy(webDriver, extentTest, extentReports);

            String name = "Test Book";

            Assert.assertTrue(flexBookSortBy.verifyAscendingLink(), "Failed to verified Ascending Link.");
            extentTest.log(LogStatus.PASS, "Successfully verified Ascending Link.");
            logger.info("Successfully verified Ascending Link.");

            flexBookSortBy.clickOnAscendingLink();
            flexBookSortBy.waitForSomeTime();
            flexBookSortBy.getFlexBookNameAfterAscendingOrder();

            Assert.assertTrue(flexBookSortBy.verifyTextAfterAscending(name), "Failed to verified Text After Ascending Order.");
            extentTest.log(LogStatus.PASS, "Successfully verified Text After Ascending Order.");
            logger.info("Successfully verified Text After Ascending Order.");

        } catch (Exception e) {
            result = handleException(e);
        }
        Assert.assertTrue(result, "Test script failed for  : " + errorMessage);
    }

    @Test(priority = 3, description = "Verify  Functionality of 'Descending' Link After Clicking On Sort By DropDown")
    public void verifyFunctionalityOfDescendingLink() {
        boolean result = true;
        try {
            FlexBookSortBy flexBookSortBy = new FlexBookSortBy(webDriver, extentTest, extentReports);

            String name = "Zakurbag";

            Assert.assertTrue(flexBookSortBy.verifySortDropDown(), "Failed to verified Sort DropDown");
            extentTest.log(LogStatus.PASS, "Successfully  verified Sort DropDown");
            logger.info("Successfully  verified Sort DropDown");

            flexBookSortBy.clickOnSortDropDown();

            Assert.assertTrue(flexBookSortBy.verifyDescendingLink(), "Failed to verified Descending Link.");
            extentTest.log(LogStatus.PASS, "Successfully verified Descending Link.");
            logger.info("Successfully verified Descending Link.");

            flexBookSortBy.clickOnDescendingLink();
            flexBookSortBy.waitForSomeTime();
            flexBookSortBy.getFlexBookNameAfterDescendingOrder();

            Assert.assertTrue(flexBookSortBy.verifyTextAfterDescending(name), "Failed to verified Text After Descending Order.");
            extentTest.log(LogStatus.PASS, "Successfully verified Text After Descending Order.");
            logger.info("Successfully verified Text After Descending Order.");

        } catch (Exception e) {
            result = handleException(e);
        }
        Assert.assertTrue(result, "Test script failed for  : " + errorMessage);
    }

    @Test(priority = 4, description = "Verify  Functionality of 'Newest First' Link After Clicking On Sort By DropDown")
    public void verifyFunctionalityOfNewestFirstLink() {
        boolean result = true;
        try {
            FlexBookSortBy flexBookSortBy = new FlexBookSortBy(webDriver, extentTest, extentReports);

            String name = "Zakurbag";

            Assert.assertTrue(flexBookSortBy.verifySortDropDown(), "Failed to verified Sort DropDown");
            extentTest.log(LogStatus.PASS, "Successfully  verified Sort DropDown");
            logger.info("Successfully  verified Sort DropDown");

            flexBookSortBy.clickOnSortDropDown();

            Assert.assertTrue(flexBookSortBy.verifyNewestFirstLink(), "Failed to verified Newest First Link.");
            extentTest.log(LogStatus.PASS, "Successfully verified Newest First Link.");
            logger.info("Successfully verified Newest First Link.");

            flexBookSortBy.clickOnNewestFirstLink();
            flexBookSortBy.waitForSomeTime();
            flexBookSortBy.getFlexBookNameAfterNewestFirst();

            Assert.assertTrue(flexBookSortBy.verifyTextAfterNewestFirst(name), "Failed to verified Text After Newest First.");
            extentTest.log(LogStatus.PASS, "Successfully verified Text After Newest First.");
            logger.info("Successfully verified Text After Newest First.");

        } catch (Exception e) {
            result = handleException(e);
        }
        Assert.assertTrue(result, "Test script failed for  : " + errorMessage);
    }

    @Test(priority = 5, description = "Verify  Functionality of 'Oldest First' Link After Clicking On Sort By DropDown")
    public void verifyFunctionalityOfOldestFirstLink() {
        boolean result = true;
        try {
            FlexBookSortBy flexBookSortBy = new FlexBookSortBy(webDriver, extentTest, extentReports);

            String name = "Test Book";

            Assert.assertTrue(flexBookSortBy.verifySortDropDown(), "Failed to verified Sort DropDown");
            extentTest.log(LogStatus.PASS, "Successfully  verified Sort DropDown");
            logger.info("Successfully  verified Sort DropDown");

            flexBookSortBy.clickOnSortDropDown();

            Assert.assertTrue(flexBookSortBy.verifyOldestFirstLink(), "Failed to verified Oldest First Link.");
            extentTest.log(LogStatus.PASS, "Successfully verified Oldest First Link.");
            logger.info("Successfully verified Oldest First Link.");

            flexBookSortBy.clickOnOldestFirstLink();
            flexBookSortBy.waitForSomeTime();
            flexBookSortBy.getFlexBookNameAfterOldestFirst();

            Assert.assertTrue(flexBookSortBy.verifyTextAfterOldestFirst(name), "Failed to verified Text After Oldest First.");
            extentTest.log(LogStatus.PASS, "Successfully verified Text After Oldest First.");
            logger.info("Successfully verified Text After Oldest First.");

        } catch (Exception e) {
            result = handleException(e);
        }
        Assert.assertTrue(result, "Test script failed for  : " + errorMessage);
    }

    @Test(priority = 6, description = "verify  Functionality of 'Recently Modified' Link After Clicking On Sort By DropDown")
    public void verifyFunctionalityOfRecentlyModifiedLink() {
        boolean result = true;
        try {
            FlexBookSortBy flexBookSortBy = new FlexBookSortBy(webDriver, extentTest, extentReports);

            String name = "Zakurbag";

            Assert.assertTrue(flexBookSortBy.verifySortDropDown(), "Failed to verified Sort DropDown");
            extentTest.log(LogStatus.PASS, "Successfully  verified Sort DropDown");
            logger.info("Successfully  verified Sort DropDown");

            flexBookSortBy.clickOnSortDropDown();

            Assert.assertTrue(flexBookSortBy.verifyRecentlyModifiedLink(), "Failed to verified Recently Modified Link.");
            extentTest.log(LogStatus.PASS, "Successfully verified Recently Modified Link.");
            logger.info("Successfully verified Recently Modified Link.");

            flexBookSortBy.clickOnRecentlyModifiedLink();
            flexBookSortBy.waitForSomeTime();
            flexBookSortBy.getFlexBookNameAfterRecentlyModified();

            Assert.assertTrue(flexBookSortBy.verifyTextAfterRecentlyModified(name), "Failed to verified Text After Recently Modified.");
            extentTest.log(LogStatus.PASS, "Successfully verified Text After Recently Modified.");
            logger.info("Successfully verified Text After Recently Modified.");

        } catch (Exception e) {
            result = handleException(e);
        }
        Assert.assertTrue(result, "Test script failed for  : " + errorMessage);
    }

    @Test(priority = 7, description = "Verify  Functionality of 'Oldest Modified' Link After Clicking On Sort By DropDown")
    public void verifyFunctionalityOfOldestModifiedLink() {
        boolean result = true;
        try {
            FlexBookSortBy flexBookSortBy = new FlexBookSortBy(webDriver, extentTest, extentReports);

            String name = "Test Book";

            Assert.assertTrue(flexBookSortBy.verifySortDropDown(), "Failed to verified Sort DropDown");
            extentTest.log(LogStatus.PASS, "Successfully  verified Sort DropDown");
            logger.info("Successfully  verified Sort DropDown");

            flexBookSortBy.clickOnSortDropDown();

            Assert.assertTrue(flexBookSortBy.verifyOldestModifiedLink(), "Failed to verified Oldest Modified Link.");
            extentTest.log(LogStatus.PASS, "Successfully verified Oldest Modified Link.");
            logger.info("Successfully verified Oldest Modified Link.");

            flexBookSortBy.clickOnOldestModifiedLink();
            flexBookSortBy.waitForSomeTime();
            flexBookSortBy.getFlexBookNameAfterOldestModified();

            Assert.assertTrue(flexBookSortBy.verifyTextAfterOldestModified(name), "Failed to verified Text After Oldest Modified.");
            extentTest.log(LogStatus.PASS, "Successfully verified Text After Oldest Modified.");
            logger.info("Successfully verified Text After Oldest Modified.");

        } catch (Exception e) {
            result = handleException(e);
        }
        Assert.assertTrue(result, "Test script failed for  : " + errorMessage);
    }
}