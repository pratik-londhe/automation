package testscripts.regression.studentlogin.GroupsFeature.NonLoginUserFeature;

import com.relevantcodes.extentreports.LogStatus;
import org.apache.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.Test;
import testscripts.BaseTestScript;
import uipages.flexbook2feature.CBookLandingPage;
import uipages.flexbook2feature.CBookModalityPage;
import uipages.flexbook2feature.CBookPrimaryConceptPage;
import uipages.flexbook2feature.CourseBookDetailsPage;

public class UserCBookDetailsPageTest extends BaseTestScript {
    private static final Logger logger = Logger.getLogger(UserCBookDetailsPageTest.class);

    @Test(priority = 1, description = "Verify the UI of the 'Course Details' page after clicking on a CourseBook")
    public void verifyUIPageOfCourseBookDetailsPage() {
        boolean result = true;
        try {
            CBookLandingPage cBookLandingPage = new CBookLandingPage(webDriver,extentTest,extentReports);
            CourseBookDetailsPage courseBookDetailsPage = new CourseBookDetailsPage(webDriver,extentTest,extentReports);

            cBookLandingPage.clickOnFlexBookLink();
            //The first flexbook now requires a logged in user to access it.
            //courseBookDetailsPage.clickOnFirstFlexBook();
            String bookUrlForNonLoggedInUser = "https://flexbooks-master.ck12.org/cbook/ck-12-interactive-middle-school-math-8-for-ccss/";
            webDriver.navigate().to(bookUrlForNonLoggedInUser);

            Assert.assertTrue(courseBookDetailsPage.verifyAuthorLink(), "Test Script Field to Verify Author Link");
            reportLog("User Successfully Verify Author Link ");

            Assert.assertTrue(courseBookDetailsPage.verifyDetailsTab(), "Test Script Field to Verify Details Tab");
            reportLog("User Successfully   Verify Details Tab");

        } catch (Exception e) {
            result = handleException(e);
        }
        Assert.assertTrue(result, "Test script failed : " + errorMessage);
    }

    @Test(priority = 3, description = "Verify the Functionality of 'Details Tab' After Clicking Details Tab")
    public void verifyFunctionalityOfDetailsTab() {
        boolean result = true;
        try {
            CourseBookDetailsPage courseBookDetailsPage = new CourseBookDetailsPage(webDriver,extentTest,extentReports);

            courseBookDetailsPage.clickOnDetailsTab();

            Assert.assertTrue(courseBookDetailsPage.verifyGradeText(), "Test Script Field to Verify Grade Text");
            reportLog("User Successfully Verify Grade Text");

        } catch (Exception e) {
            result = handleException(e);
        }
        Assert.assertTrue(result, "Failed To Verify" + errorMessage);
    }

    @Test(priority = 5, description = "Verify the Functionality of 'OverView Tab' On CourseBook UI Page")
    public void verifyFunctionalityOfOverviewTab() {
        boolean result = true;
        try {
            CourseBookDetailsPage courseBookDetailsPage = new CourseBookDetailsPage(webDriver,extentTest,extentReports);

            courseBookDetailsPage.clickOnOverviewTab();

            Assert.assertTrue(courseBookDetailsPage.verifyChaptersLink(), "Test Script Field to Verify Chapters Link");
            reportLog("User Successfully Verify Chapters Link");

        } catch (Exception e) {
            result = handleException(e);
        }
        Assert.assertTrue(result, "Failed To Verify" + errorMessage);
    }

    @Test(priority = 7, description = "Verify the Functionality of 'Start Course Details' Button of CourseBook Details Page")
    public void verifyStartCourseDetailsButton() {
        boolean result = true;
        try {
            CourseBookDetailsPage courseBookDetailsPage = new CourseBookDetailsPage(webDriver,extentTest,extentReports);
            CBookModalityPage cBookModalityPage = new CBookModalityPage(webDriver,extentTest,extentReports);

            courseBookDetailsPage.clickOnFirstChapter();

            Assert.assertTrue(courseBookDetailsPage.verifyLinksOfChapterConcept(), "Test Script Field to Verify Concepts Link");
            reportLog("Teacher Successfully Verify Concepts Link");

            courseBookDetailsPage.clickFirstConceptOfLink();
            new CBookPrimaryConceptPage(webDriver,extentTest,extentReports).clickOnStart();

            Assert.assertTrue(cBookModalityPage.verifyLinkOfNextConcept(), "Test Script Field to verify Next Concept Link");
            reportLog("Student Successfully verify Next Concept Link");

        } catch (Exception e) {
            result = handleException(e);
        }
        Assert.assertTrue(result, "Failed To Verify" + errorMessage);
    }
}