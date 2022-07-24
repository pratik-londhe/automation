package testscripts.regression.studentlogin.FlexBookFeature.FlexBookDetailsPage;

import com.relevantcodes.extentreports.LogStatus;
import org.apache.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.Test;
import testscripts.BaseTestScript;
import uipages.flexbook2feature.CBookModalityPage;
import uipages.flexbook2feature.CBookPageStudent;
import uipages.flexbook2feature.CBookPrimaryConceptPage;
import uipages.flexbook2feature.CourseBookDetailsPage;

public class CBookDetailsPageStudentTest extends BaseTestScript {
    private static final Logger logger = Logger.getLogger(CBookDetailsPageStudentTest.class);
    private String testCaseFailureText = "Test failed for method: ";
    private String assertFailurePreText = "Failed to verify: ";
    public String assertSuccessPreText = "Successfully verified: ";

    @Test(priority = 1, dataProvider = "CK12DataProvider", description = "Verify the UI of the 'Course Details' page after clicking on a Student CourseBook")
    public void verifyUIPageOfCBookDetails(String email, String password) {
        boolean result = true;
        try {
            CourseBookDetailsPage courseBookDetailsPage = new CourseBookDetailsPage(webDriver, extentTest, extentReports);
            CBookPageStudent cBookPageStudent = new CBookPageStudent(webDriver, extentTest, extentReports);

            cBookPageStudent.clickOnTryItNowPopUp(email, password);
            courseBookDetailsPage.clickOnFirstFlexBook();

            String assertTextVAL = "Presence of the 'Author' link.";
            Assert.assertTrue(courseBookDetailsPage.verifyAuthorLink(), assertFailurePreText + assertTextVAL);
            reportLog(assertTextVAL);

        } catch (Exception e) {
            result = handleException(e);
        }
        Assert.assertTrue(result, testCaseFailureText + currentMethodName + errorMessage);
    }

    @Test(priority = 2, description = "Verify 'Resume' dropdown is display in student details page.")
    public void verifyResumeDropdownIsDisplay() {
        boolean result = true;
        try {
            CourseBookDetailsPage courseBookDetailsPage = new CourseBookDetailsPage(webDriver, extentTest, extentReports);
            CBookPageStudent cBookPageStudent = new CBookPageStudent(webDriver, extentTest, extentReports);

            String assertTextVSCDB = "Presence of 'Start Course Details' button.";
            Assert.assertTrue(cBookPageStudent.verifyStartCourseDetailsButton(), assertFailurePreText + assertTextVSCDB);
            reportLog(assertTextVSCDB);

            String assertTextVDT = "Presence of 'Verify Details' tab.";
            Assert.assertTrue(courseBookDetailsPage.verifyDetailsTab(), assertFailurePreText + assertTextVDT);
            reportLog(assertTextVDT);

        } catch (Exception e) {
            result = handleException(e);
        }
        Assert.assertTrue(result, testCaseFailureText + currentMethodName + errorMessage);
    }

    @Test(priority = 4, description = "Verify the Functionality of 'Details Tab' After Clicking Details Tab of CourseBook Details Page")
    public void verifyDetailsTab() {
        boolean result = true;
        try {
            CourseBookDetailsPage courseBookDetailsPage = new CourseBookDetailsPage(webDriver, extentTest, extentReports);
            CBookPageStudent cBookPageStudent = new CBookPageStudent(webDriver, extentTest, extentReports);

            courseBookDetailsPage.clickOnDetailsTab();

            String assertTextVGT = "Presence of 'Grade' text.";
            Assert.assertTrue(courseBookDetailsPage.verifyGradeText(), assertFailurePreText + assertTextVGT);
            reportLog(assertTextVGT);

            String assertTextVTLM = "Presence of 'Last Modified Date'.";
            Assert.assertTrue(cBookPageStudent.verifyTextLastModified(), assertFailurePreText + assertTextVTLM);
            reportLog(assertTextVTLM);

        } catch (Exception e) {
            result = handleException(e);
        }
        Assert.assertTrue(result, testCaseFailureText + currentMethodName + errorMessage);
    }

    @Test(priority = 5, description = "Verify the Functionality of 'OverView Tab' On Student CourseBook UI Page")
    public void verifyOverviewTab() {
        boolean result = true;
        try {
            CourseBookDetailsPage courseBookDetailsPage = new CourseBookDetailsPage(webDriver, extentTest, extentReports);

            courseBookDetailsPage.clickOnOverviewTab();

            String assertTextVCL = "Presence of 'Chapters' link.";
            Assert.assertTrue(courseBookDetailsPage.verifyChaptersLink(), assertFailurePreText + assertTextVCL);
            reportLog(assertTextVCL);

            courseBookDetailsPage.clickOnFirstChapter();

            String assertTextVLCC = "Presence of 'Concepts' link.";
            Assert.assertTrue(courseBookDetailsPage.verifyLinksOfChapterConcept(), assertFailurePreText + assertTextVLCC);
            reportLog(assertTextVLCC);

        } catch (Exception e) {
            result = handleException(e);
        }
        Assert.assertTrue(result, testCaseFailureText + currentMethodName + errorMessage);
    }

    @Test(priority = 7, description = "Verify the Functionality of 'Start Course Details' Button of CourseBook Details Page")
    public void verifyStartCourseDetailsButton() {
        boolean result = true;
        try {
            CBookPageStudent cBookPageStudent = new CBookPageStudent(webDriver, extentTest, extentReports);
            CBookModalityPage cBookModalityPage = new CBookModalityPage(webDriver, extentTest, extentReports);

            cBookPageStudent.getTextOfFirstConceptLink();
            cBookPageStudent.clickOnStartCourseDetailButton();
            new CBookPrimaryConceptPage(webDriver, extentTest, extentReports).clickOnStart();

            String assertTextVLNC = "Presence of 'Next Concept' link.";
            Assert.assertTrue(cBookModalityPage.verifyLinkOfNextConcept(), assertFailurePreText + assertTextVLNC);
            reportLog(assertTextVLNC);

        } catch (Exception e) {
            result = handleException(e);
        }
        Assert.assertTrue(result, testCaseFailureText + currentMethodName + errorMessage);
    }
}