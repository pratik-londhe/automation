package testscripts.regression.teacherlogin.FlexBookFeature.DetailsPageFeature;

import com.relevantcodes.extentreports.LogStatus;
import org.apache.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.Test;
import testscripts.BaseTestScript;
import uipages.flexbook2feature.CBookLandingPage;
import uipages.flexbook2feature.CBookModalityPage;
import uipages.flexbook2feature.CBookPrimaryConceptPage;
import uipages.flexbook2feature.CourseBookDetailsPage;

public class CourseBookDetailsPageTest extends BaseTestScript {
    private static final Logger logger = Logger.getLogger(CourseBookDetailsPageTest.class);

    @Test(priority = 1, dataProvider = "CK12DataProvider", description = "Verify the UI of the 'Course Details' page after clicking on a CourseBook")
    public void verifyUIPageOfCourseBookDetails(String email, String password, String url) {
        boolean result = true;
        try {
            CBookLandingPage cBookLandingPage = new CBookLandingPage(webDriver, extentTest, extentReports);
            CourseBookDetailsPage courseBookDetailsPage = new CourseBookDetailsPage(webDriver, extentTest, extentReports);

            webDriver.navigate().to(url);
            cBookLandingPage.clickOnTryItNow(email, password);
            courseBookDetailsPage.clickOnFirstFlexBook();

            Assert.assertTrue(courseBookDetailsPage.verifyAuthorLink(), "Test Script Field to Verify Author Link");
            reportLog( "Teacher Successfully Verify Author Link ");

            Assert.assertTrue(courseBookDetailsPage.verifyChooseButton(), "Test Script Field to Verify Choose Button");
            reportLog( "Teacher Successfully  Verify Choose Button");

            Assert.assertTrue(courseBookDetailsPage.verifyDetailsTab(), "Test Script Field to Verify Details Tab");
            reportLog( "Teacher Successfully   Verify Details Tab");

        } catch (Exception e) {
            result = handleException(e);
        }
        Assert.assertTrue(result, "Test script failed : " + errorMessage);
    }

    @Test(priority = 2, description = "Verify the Functionality of 'Choose DropDown' After Clicking Choose Button")
    public void verifyChooseDropDown() {
        boolean result = true;
        try {
            CourseBookDetailsPage courseBookDetailsPage = new CourseBookDetailsPage(webDriver, extentTest, extentReports);

            courseBookDetailsPage.clickOnChooseButton();

            Assert.assertTrue(courseBookDetailsPage.verifyAssignButton(), "Test Script Field to Verify Assign Button");
            reportLog( "Teacher Successfully Verify Assign Button");

            Assert.assertTrue(courseBookDetailsPage.verifyCustomizeButton(), "Test Script Field to Verify Customize Button");
            reportLog( "Teacher Successfully Verify Customize Button");

            courseBookDetailsPage.clickOnChooseButton();

        } catch (Exception e) {
            result = handleException(e);
        }
        Assert.assertTrue(result, "Failed To Verify" + errorMessage);
    }

    @Test(priority = 3, description = "Verify the Functionality of 'Details Tab' After Clicking Details Tab")
    public void verifyDetailsTabOptions() {
        boolean result = true;
        try {
            CourseBookDetailsPage courseBookDetailsPage = new CourseBookDetailsPage(webDriver, extentTest, extentReports);

            courseBookDetailsPage.clickOnDetailsTab();

            Assert.assertTrue(courseBookDetailsPage.verifyGradeText(), "Test Script Field to Verify Grade Text");
            reportLog( "Teacher Successfully Verify Grade Text");

        } catch (Exception e) {
            result = handleException(e);
        }
        Assert.assertTrue(result, "Failed To Verify" + errorMessage);
    }

    @Test(priority = 4, description = "Verify the Functionality of 'OverView Tab' On CourseBook UI Page")
    public void verifyOverviewTabOptions() {
        boolean result = true;
        try {
            CourseBookDetailsPage courseBookDetailsPage = new CourseBookDetailsPage(webDriver, extentTest, extentReports);

            courseBookDetailsPage.clickOnOverviewTab();

            Assert.assertTrue(courseBookDetailsPage.verifyChaptersLink(), "Test Script Field to Verify Chapters Link");
            reportLog( "Teacher Successfully Verify Chapters Link");

        } catch (Exception e) {
            result = handleException(e);
        }
        Assert.assertTrue(result, "Failed To Verify" + errorMessage);
    }

    @Test(priority = 5, description = "Verify the Functionality of 'Chapter Links and Concept Links'after Clicking Overview Tab")
    public void chapterLinksAndConceptLinks() {
        boolean result = true;
        try {
            CourseBookDetailsPage courseBookDetailsPage = new CourseBookDetailsPage(webDriver, extentTest, extentReports);
            CBookModalityPage cBookModalityPage = new CBookModalityPage(webDriver, extentTest, extentReports);

            courseBookDetailsPage.clickOnFirstChapter();

            Assert.assertTrue(courseBookDetailsPage.verifyLinksOfChapterConcept(), "Test Script Field to Verify Concepts Link");
            reportLog( "Teacher Successfully Verify Concepts Link");

            courseBookDetailsPage.clickFirstConceptOfLink();
            new CBookPrimaryConceptPage(webDriver, extentTest, extentReports).clickOnStart();

            Assert.assertTrue(cBookModalityPage.verifyAssignAssignmentButton(), "Test Script Field ");
            reportLog( "Teacher Successfully verify Assign Pop Up");

        } catch (Exception e) {
            result = handleException(e);
        }
        Assert.assertTrue(result, "Failed To Verify" + errorMessage);
    }
}