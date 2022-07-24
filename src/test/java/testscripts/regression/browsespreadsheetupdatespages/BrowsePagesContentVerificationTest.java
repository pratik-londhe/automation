package testscripts.regression.browsespreadsheetupdatespages;

import org.testng.Assert;
import org.testng.annotations.Test;
import testscripts.BaseTestScript;
import uipages.BasePage;
import uipages.BrowsePagesContentVerification.BrowsePagesContentVerificationPage;

public class BrowsePagesContentVerificationTest extends BaseTestScript {
    private String testCaseFailureText = "Test failed for method: ";
    private BrowsePagesContentVerificationPage browsePagesContentVerificationPage;
    private BasePage basePage;

    @Test(priority = 1, description = "Verify the content details on the Teacher Landing Page - https://www.ck12.org/teacher/")
    public void verifyTeacherLandingPageContents() {
        boolean result = true;
        try {
            browsePagesContentVerificationPage = new BrowsePagesContentVerificationPage(webDriver, extentTest, extentReports);

            webDriver.navigate().to("https://www.ck12.org/teacher/");
            reportLog("Navigated to Teacher Landing Page - https://www.ck12.org/teacher/");

            browsePagesContentVerificationPage.dismissXmasPopup();

            Assert.assertTrue(browsePagesContentVerificationPage.verifyWhatDoYouWantToTeachTodaySection(), assertFailurePreText + "Presence of What Do you Want To Teach Today Section on the Teacher Landing page.");
            reportLog("Successfully verified What Do you Want To Teach Today Section is present on the Teacher Landing page.");

            Assert.assertTrue(browsePagesContentVerificationPage.verifyDetailsUnderWhatDoYouWantToTeachTodaySection(), assertFailurePreText + "Presence of Items/Books of What Do you Want To Teach Today Section on the Teacher Landing page.");
            reportLog("Successfully verified all the Items/Books under the What Do you Want To Teach Today on the Teacher Landing page.");

            Assert.assertTrue(browsePagesContentVerificationPage.verifyExploreProductsSection(), assertFailurePreText + "Presence of Explore products Section on the Teacher Landing page.");
            reportLog("Successfully verified Explore Some Of Our Products Section is present on the Teacher Landing page.");

            Assert.assertTrue(browsePagesContentVerificationPage.verifyExploreProductList(), assertFailurePreText + "Explore Products links on the Teacher Landing page.");
            reportLog("Successfully verified Explore Some Of Our Products links navigation on the Teacher Landing page.");

            Assert.assertTrue(browsePagesContentVerificationPage.verifySearchDropDownMenu(), assertFailurePreText + "Search Drop Down menu on the Teacher Landing page.");
            reportLog("Successfully verified Te all main and sub search drop down menu on the Teacher Landing page.");
        } catch (Exception e) {
            result = handleException(e);
        }
        Assert.assertTrue(result, testCaseFailureText + currentMethodName + errorMessage);
    }

    @Test(priority = 2, description = "Verify the content details on the Teacher FB2.0 Landing Page - https://flexbooks.ck12.org/flexbooks/teacher/")
    public void verifyTeacherFB20LandingPageContents() {
        boolean result = true;
        try {
            browsePagesContentVerificationPage = new BrowsePagesContentVerificationPage(webDriver, extentTest, extentReports);

            webDriver.navigate().to("https://flexbooks.ck12.org/flexbooks/teacher/");
            reportLog("Navigated to Teacher Landing Page - https://flexbooks.ck12.org/flexbooks/teacher/");

            browsePagesContentVerificationPage.dismissXmasPopup();

            Assert.assertTrue(browsePagesContentVerificationPage.verifyMathSectionOnTeacherFBLandingPage(), assertFailurePreText + "Presence of Math section on the Teacher FB2.0 Landing page.");
            reportLog("Successfully verified Math section on the Teacher FB2.0 Landing page.");

            Assert.assertTrue(browsePagesContentVerificationPage.verifyBooksUnderMathSection(), assertFailurePreText + "Presence of Items/Books of Math Section on the Teacher Landing page.");
            reportLog("Successfully verified Math section books on the Teacher FB2.0 Landing page.");

            Assert.assertTrue(browsePagesContentVerificationPage.verifyScienceSectionOnTeacherFBLandingPage(), assertFailurePreText + "Presence of Science section on the Teacher FB2.0 Landing page.");
            reportLog("Successfully verified Science section on the Teacher FB2.0 Landing page.");

            Assert.assertTrue(browsePagesContentVerificationPage.verifyBooksUnderScienceSection(), assertFailurePreText + "Books under the science section on teacher FB2.0 landing page.");
            reportLog("Successfully verified Science section books on the Teacher FB2.0 Landing page.");

            Assert.assertTrue(browsePagesContentVerificationPage.verifySocialStudiesSectionOnTeacherFBLandingPage(), assertFailurePreText + "Presence of Social Studies section on teacher FB2.0 landing page.");
            reportLog("Successfully verified Social Studies section on the Teacher FB2.0 Landing page.");

            Assert.assertTrue(browsePagesContentVerificationPage.verifyBooksUnderSocialStudiesSection(), assertFailurePreText + "Books under Social Studies on the Teacher FB2.0 Landing page.");
            reportLog("Successfully verified Social Studies books on the Teacher FB2.0 Landing page.");

            Assert.assertTrue(browsePagesContentVerificationPage.verifyTranslationSectionOnTeacherFBLandingPage(), assertFailurePreText + "Presence of Translation section on the Teacher FB2.0 Landing page.");
            reportLog("Successfully verified Translation section on the Teacher FB2.0 Landing page.");

            Assert.assertTrue(browsePagesContentVerificationPage.verifyBooksUnderTranslationSection(), assertFailurePreText + "Books under Translation section on the Teacher FB2.0 Landing page.");
            reportLog("Successfully verified Translation section books on the Teacher FB2.0 Landing page.");

        } catch (Exception e) {
            result = handleException(e);
        }
        Assert.assertTrue(result, testCaseFailureText + currentMethodName + errorMessage);
    }

    @Test(priority = 3, description = "Verify the content details on the Student Landing Page - https://www.ck12.org/student/")
    public void verifyStudentLandingPageContents() {
        boolean result = true;
        try {
            browsePagesContentVerificationPage = new BrowsePagesContentVerificationPage(webDriver, extentTest, extentReports);

            webDriver.navigate().to("https://www.ck12.org/student/");
            reportLog("Navigated to Teacher Landing Page - https://www.ck12.org/student/");

            browsePagesContentVerificationPage.dismissXmasPopup();

            Assert.assertTrue(browsePagesContentVerificationPage.verifyStudentSearchDropDown(), assertFailurePreText + "Presence of Search Option Drop Down from Student Landing page.");
            reportLog("Successfully verified Search Option Drop Down from Student Landing page.");

            Assert.assertTrue(browsePagesContentVerificationPage.verifyStudentSuggestedSections(), assertFailurePreText + "Presence of Suggested Sections with concept/book on Student Landing page.");
            reportLog("Successfully verified Suggested Sections with concept/book on Student Landing page.");

            Assert.assertTrue(browsePagesContentVerificationPage.verifyExploreSectionStudentLandingPage(), assertFailurePreText + "Presence of Explore Sections on Student Landing page.");
            reportLog("Successfully verified Explore Sections on Student Landing page.");

        } catch (Exception e) {
            result = handleException(e);
        }
        Assert.assertTrue(result, testCaseFailureText + currentMethodName + errorMessage);
    }

    @Test(priority = 4, description = "Verify the content details on the Subject Browse Page - https://www.ck12.org/browse/")
    public void verifySubjectBrowsePageContents() {
        boolean result = true;
        try {
            browsePagesContentVerificationPage = new BrowsePagesContentVerificationPage(webDriver, extentTest, extentReports);

            webDriver.navigate().to("https://www.ck12.org/browse/");
            reportLog("Navigated to Teacher Landing Page - https://www.ck12.org/browse/");

            browsePagesContentVerificationPage.dismissXmasPopup();

            Assert.assertTrue(browsePagesContentVerificationPage.verifyDetailsOfSubjectPageUnderWhatAreYouLookingTodaySection(), assertFailurePreText + "Presence Items/Books of What are you Looking for Today Section from Subject Browse page.");
            reportLog("Successfully verified Items/Books of What are you Looking for Today Section from Subject Browse page.");

        } catch (Exception e) {
            result = handleException(e);
        }
        Assert.assertTrue(result, testCaseFailureText + currentMethodName + errorMessage);
    }

    @Test(priority = 5, description = "Verify the content details on the Teacher Landing Page - https://flexbooks.ck12.org/flexbooks/student/")
    public void verifyFlexBookStudentLandingPageContents() {
        boolean result = true;
        try {
            browsePagesContentVerificationPage = new BrowsePagesContentVerificationPage(webDriver, extentTest, extentReports);

            webDriver.navigate().to("https://flexbooks.ck12.org/flexbooks/student/");
            reportLog("Navigated to Teacher Landing Page - https://flexbooks.ck12.org/flexbooks/student/");

            browsePagesContentVerificationPage.dismissXmasPopup();

            Assert.assertTrue(browsePagesContentVerificationPage.verifyStudentSuggestedSectionsStudentFlexBookSection(), assertFailurePreText + "Presence of Items/Books of What Do you Want To Teach Today Section on the FlexBook Student Landing page.");
            reportLog("Successfully verified all the Items/Books under the What Do you Want To Teach Today on the FlexBook Student Landing page.");

            Assert.assertTrue(browsePagesContentVerificationPage.verifySearchDropDownMenu(), assertFailurePreText + "Search Drop Down menu on the FlexBook Student Landing page.");
            reportLog("Successfully verified Te all main and sub search drop down menu on the FlexBook Student Landing page.");

        } catch (Exception e) {
            result = handleException(e);
        }
        Assert.assertTrue(result, testCaseFailureText + currentMethodName + errorMessage);
    }

    @Test(priority = 6, description = "Verify the content details on the Student Tutor Page - https://www.ck12.org/pages/student-tutor/")
    public void verifyStudentTutorPageContents() {
        boolean result = true;
        try {
            browsePagesContentVerificationPage = new BrowsePagesContentVerificationPage(webDriver, extentTest, extentReports);

            webDriver.navigate().to("https://www.ck12.org/pages/student-tutor/");
            reportLog("Navigated to Student Tutor Page - https://www.ck12.org/pages/student-tutor/");

            Assert.assertTrue(browsePagesContentVerificationPage.verifyStudentTutorPresent(), assertFailurePreText + "Verify Presence of Student Tutor on the Student Tutor page.");
            reportLog("Successfully verified Introducing Student Tutor is present on the Student Tutor page.");

        } catch (Exception e) {
            result = handleException(e);
        }
        Assert.assertTrue(result, testCaseFailureText + currentMethodName + errorMessage);
    }

    @Test(priority = 7, description = "Verify the content details on the Adult Education Page - ")
    public void verifyAdultEducationPageContents() {
        boolean result = true;
        try {
            browsePagesContentVerificationPage = new BrowsePagesContentVerificationPage(webDriver, extentTest, extentReports);
            basePage = new BasePage(webDriver, extentTest, extentReports);

            webDriver.navigate().to("https://www.ck12.org/pages/adult-education/#abe");
            reportLog("Navigated to Adult Education Page - https://www.ck12.org/pages/adult-education/#abe");

            for (int i = 0; i <= 20; i++) {
                scrollByPixel(500);
                basePage.waitForSec(3);
            }

            Assert.assertTrue(browsePagesContentVerificationPage.verifyAdultPageHeaderDetails(), assertFailurePreText + "Presence of Adult Education Youtube Video on Header of Adult Education page.");
            reportLog("Successfully verified Adult Education Youtube Video on Header of Adult Education page.");

            Assert.assertTrue(browsePagesContentVerificationPage.verifyAdultEducationFlexbookSection(), assertFailurePreText + "Presence of Adult Education Flexbook Sections on Adult Education page.");
            reportLog("Successfully verified Adult Education Flexbook Sections on Adult Education page.");

            Assert.assertTrue(browsePagesContentVerificationPage.verifyAdditionalProductsToEnhanceAdultLearning(), assertFailurePreText + "Presence of Additional Product Sections on Adult Education page.");
            reportLog("Successfully verified Additional Product Sections on Adult Education page.");

            Assert.assertTrue(browsePagesContentVerificationPage.verifyIntegrateSectionList(), assertFailurePreText + "Presence of LTI Integrate Option Section on Adult Education page.");
            reportLog("Successfully verified LTI Integrate Option Section on Adult Education page.");

            for (int i = 0; i <= 10; i++) {
                scrollByPixel(500);
                basePage.waitForSec(3);
            }

            Assert.assertTrue(browsePagesContentVerificationPage.verifyTestimonialsList(), assertFailurePreText + "Presence of People Testimonials Section on Adult Education page.");
            reportLog("Successfully verified People Testimonials Section on Adult Education page.");

        } catch (Exception e) {
            result = handleException(e);
        }
        Assert.assertTrue(result, testCaseFailureText + currentMethodName + errorMessage);
    }

    @Test(priority = 8, description = "Verify the content details on the Tutor Consent Page - https://www.ck12.org/pages/tutor-consent/")
    public void verifyTutorConsentPageContents() {
        boolean result = true;
        try {
            browsePagesContentVerificationPage = new BrowsePagesContentVerificationPage(webDriver, extentTest, extentReports);

            webDriver.navigate().to("https://www.ck12.org/pages/tutor-consent/");
            reportLog("Navigated to Tutor Consent Page - https://www.ck12.org/pages/tutor-consent/");

            Assert.assertTrue(browsePagesContentVerificationPage.verifyHTagsInTutorConsentPage(), assertFailurePreText + "Verify Presence of h tags on the Tutor Consent page.");
            reportLog("Successfully verified h tags is present on the Tutor Consent page.");

            Assert.assertTrue(browsePagesContentVerificationPage.verifyPrivacyPolicyLink(), assertFailurePreText + "Verify Presence of privacy policy link on the Tutor Consent page.");
            reportLog("Successfully verified privacy policy link is present on the Tutor Consent page.");

            Assert.assertTrue(browsePagesContentVerificationPage.verifyAITutorMail(), assertFailurePreText + "Verify Presence of mail to ai tutor link on the Tutor Consent page.");
            reportLog("Successfully verified mail to ai tutor link is present on the Tutor Consent page.");

        } catch (Exception e) {
            result = handleException(e);
        }
        Assert.assertTrue(result, testCaseFailureText + currentMethodName + errorMessage);
    }

    @Test(priority = 9, description = "Verify the content details on the Flexlets Page - https://www.ck12.org/pages/flexlets/")
    public void verifyFlexletsPageContents() {
        boolean result = true;
        try {
            browsePagesContentVerificationPage = new BrowsePagesContentVerificationPage(webDriver, extentTest, extentReports);
            basePage = new BasePage(webDriver, extentTest, extentReports);

            webDriver.navigate().to("https://www.ck12.org/pages/flexlets/");
            reportLog("Navigated to Flexlets Page - https://www.ck12.org/pages/flexlets/");

            for (int i = 0; i <= 8; i++) {
                scrollByPixel(500);
                basePage.waitForSec(3);
            }

            Assert.assertTrue(browsePagesContentVerificationPage.verifyHTagsInFlexletsPage(), assertFailurePreText + "Verify Presence of h tags on the Flexlets page.");
            reportLog("Successfully verified h tags is present on the Flexlets page.");

            Assert.assertTrue(browsePagesContentVerificationPage.verifyFlexbookSectionOnFlexletPage(), assertFailurePreText + "Verify Presence of Flexbook Section on the Flexlets page.");
            reportLog("Successfully verified Flexbook Section on the Flexlets page.");

        } catch (Exception e) {
            result = handleException(e);
        }
        Assert.assertTrue(result, testCaseFailureText + currentMethodName + errorMessage);
    }

    @Test(priority = 10, description = "Verify the content details on the Slab Page - https://www.ck12.org/pages/slab/")
    public void verifySlabPageContents() {
        boolean result = true;
        try {
            browsePagesContentVerificationPage = new BrowsePagesContentVerificationPage(webDriver, extentTest, extentReports);

            webDriver.navigate().to("https://www.ck12.org/pages/slab/");
            reportLog("Navigated to Slab Page - https://www.ck12.org/pages/slab/");

            Assert.assertTrue(browsePagesContentVerificationPage.verifyHTagsInSlabPage(), assertFailurePreText + "Verify Presence of h tags on the Slab page.");
            reportLog("Successfully verified h tags is present on the Slab page.");

            Assert.assertTrue(browsePagesContentVerificationPage.verifySlabMembersSlabPage(), assertFailurePreText + "Verify Presence of Slab Members on the Slab page.");
            reportLog("Successfully verified Slab Members on the Slab page.");

            Assert.assertTrue(browsePagesContentVerificationPage.verifyWhySlab(), assertFailurePreText + "Verify Presence of Why Slab on the Slab page.");
            reportLog("Successfully verified Why Slab on the Slab page.");

        } catch (Exception e) {
            result = handleException(e);
        }
        Assert.assertTrue(result, testCaseFailureText + currentMethodName + errorMessage);
    }

    @Test(priority = 11, description = "Verify the content details on the Overview Page - https://www.ck12.org/pages/overview/")
    public void verifyOverviewPageContents() {
        boolean result = true;
        try {
            browsePagesContentVerificationPage = new BrowsePagesContentVerificationPage(webDriver, extentTest, extentReports);

            webDriver.navigate().to("https://www.ck12.org/pages/overview/");
            reportLog("Navigated to Overview Page - https://www.ck12.org/pages/overview/");

            Assert.assertTrue(browsePagesContentVerificationPage.verifyPageTitle("overview"), assertFailurePreText + "Verify Presence of Title on the Overview page.");
            reportLog("Successfully verified Title on the Overview page.");

            Assert.assertTrue(browsePagesContentVerificationPage.verifyOverviewContent(), assertFailurePreText + "Verify Presence of Overview Options on the Overview page.");
            reportLog("Successfully verified Overview Options on the Overview page.");

        } catch (Exception e) {
            result = handleException(e);
        }
        Assert.assertTrue(result, testCaseFailureText + currentMethodName + errorMessage);
    }

    @Test(priority = 12, description = "Verify the content details on the Top Concepts Page - https://ck12.org/pages/top-concepts/")
    public void verifyTopConceptsPageContents() {
        boolean result = true;
        try {
            browsePagesContentVerificationPage = new BrowsePagesContentVerificationPage(webDriver, extentTest, extentReports);

            webDriver.navigate().to("https://ck12.org/pages/top-concepts/");
            reportLog("Navigated to Top Concept Page - https://ck12.org/pages/top-concepts/");

            Assert.assertTrue(browsePagesContentVerificationPage.verifyPageTitle("top concepts"), assertFailurePreText + "Verify Presence of Title on the Top Concept page.");
            reportLog("Successfully verified Title on the Top Concept page.");

            Assert.assertTrue(browsePagesContentVerificationPage.verifyCoursesSectionTopConceptPage(), assertFailurePreText + "Verify Presence of Course Section on the Top Concept page.");
            reportLog("Successfully verified Course Section on the Top Concept page.");

        } catch (Exception e) {
            result = handleException(e);
        }
        Assert.assertTrue(result, testCaseFailureText + currentMethodName + errorMessage);
    }

    @Test(priority = 13, description = "Verify the content details on the Next Generation Science FlexBooks Page - https://master.ck12.org/books/standards/ngss/")
    public void verifyNextGenerationScienceFlexBooksContents() {
        boolean result = true;
        try {
            browsePagesContentVerificationPage = new BrowsePagesContentVerificationPage(webDriver, extentTest, extentReports);

            webDriver.navigate().to("https://master.ck12.org/books/standards/ngss/");
            reportLog("Navigated to Next Generation Science FlexBooks Page - https://master.ck12.org/books/standards/ngss/");

            Assert.assertTrue(browsePagesContentVerificationPage.verifyDetailsOfBrowseNextGenerationScienceFlexbooksAndCommonCoreMathFlexbooksPages("Next Generation Science FlexBooks"), assertFailurePreText + "Verify and Click on the Titles and Check the URL of the Next Generation Science FlexBooks page.");
            reportLog("Successfully Verified Titles and URLS on Next Generation Science FlexBooks page");

        } catch (Exception e) {
            result = handleException(e);
        }
        Assert.assertTrue(result, testCaseFailureText + currentMethodName + errorMessage);
    }

    @Test(priority = 14, description = "Verify the content details on the Common Core Math FlexBooks Page - https://master.ck12.org/books/standards/ccss/")
    public void verifyCommonCoreMathFlexBooksContents() {
        boolean result = true;
        try {
            browsePagesContentVerificationPage = new BrowsePagesContentVerificationPage(webDriver, extentTest, extentReports);

            webDriver.navigate().to("https://master.ck12.org/books/standards/ccss/");
            reportLog("Navigated to Common Core Math FlexBooks Page - https://master.ck12.org/books/standards/ccss/");

            Assert.assertTrue(browsePagesContentVerificationPage.verifyDetailsOfBrowseNextGenerationScienceFlexbooksAndCommonCoreMathFlexbooksPages("Common Core Math FlexBooks"), assertFailurePreText + "Verify and Click on the Titles and Check the URL of the Common Core Math FlexBooks page.");
            reportLog("Successfully Verified Titles and URLS on Common Core Math FlexBooks page");

        } catch (Exception e) {
            result = handleException(e);
        }
        Assert.assertTrue(result, testCaseFailureText + currentMethodName + errorMessage);
    }
}
