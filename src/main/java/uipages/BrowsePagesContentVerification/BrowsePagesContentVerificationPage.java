package uipages.BrowsePagesContentVerification;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import uipages.BasePage;
import utils.GuiControl;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.*;

public class BrowsePagesContentVerificationPage extends BasePage {

    //Teacher landing page: https://www.ck12.org/teacher/
    private final GuiControl xmasPopupClose = new GuiControl(getElementMap().get("xmasPopupClose"), webDriver);
    private final GuiControl whatDoYouWantToTeachHeader = new GuiControl(getElementMap().get("whatDoYouWantToTeachHeader"), webDriver);
    private final GuiControl sectionFlexLets = new GuiControl(getElementMap().get("sectionFlexLets"), webDriver);
    private final GuiControl sectionFlexLetsStu = new GuiControl(getElementMap().get("sectionFlexLetsStu"), webDriver);
    private final GuiControl flexLetsBooks = new GuiControl(getElementMap().get("flexLetsBooks"), webDriver);
    private final GuiControl flexLetsBooksStu = new GuiControl(getElementMap().get("flexLetsBooksStu"), webDriver);
    private final GuiControl sectionMathByLevel = new GuiControl(getElementMap().get("sectionMathByLevel"), webDriver);
    private final GuiControl sectionMathByLevelStu = new GuiControl(getElementMap().get("sectionMathByLevelStu"), webDriver);
    private final GuiControl mathByLevelBooks = new GuiControl(getElementMap().get("mathByLevelBooks"), webDriver);
    private final GuiControl mathByLevelBooksStu = new GuiControl(getElementMap().get("mathByLevelBooksStu"), webDriver);
    private final GuiControl sectionMathByLevelSubject = new GuiControl(getElementMap().get("sectionMathByLevelSubject"), webDriver);
    private final GuiControl sectionMathByLevelSubjectStu = new GuiControl(getElementMap().get("sectionMathByLevelSubjectStu"), webDriver);
    private final GuiControl mathBySubjectBooks = new GuiControl(getElementMap().get("mathBySubjectBooks"), webDriver);
    private final GuiControl mathBySubjectBooksStu = new GuiControl(getElementMap().get("mathBySubjectBooksStu"), webDriver);
    private final GuiControl sectionScience = new GuiControl(getElementMap().get("sectionScience"), webDriver);
    private final GuiControl sectionScienceStu = new GuiControl(getElementMap().get("sectionScienceStu"), webDriver);
    private final GuiControl scienceBooks = new GuiControl(getElementMap().get("scienceBooks"), webDriver);
    private final GuiControl scienceBooksStu = new GuiControl(getElementMap().get("scienceBooksStu"), webDriver);
    private final GuiControl sectionEnglish = new GuiControl(getElementMap().get("sectionEnglish"), webDriver);
    private final GuiControl sectionEnglishStu = new GuiControl(getElementMap().get("sectionEnglishStu"), webDriver);
    private final GuiControl englishBooks = new GuiControl(getElementMap().get("englishBooks"), webDriver);
    private final GuiControl englishBooksStu = new GuiControl(getElementMap().get("englishBooksStu"), webDriver);
    private final GuiControl sectionSocialStudies = new GuiControl(getElementMap().get("sectionSocialStudies"), webDriver);
    private final GuiControl sectionSocialStudiesStu = new GuiControl(getElementMap().get("sectionSocialStudiesStu"), webDriver);
    private final GuiControl socialStudiesBooks = new GuiControl(getElementMap().get("socialStudiesBooks"), webDriver);
    private final GuiControl socialStudiesBooksStu = new GuiControl(getElementMap().get("socialStudiesBooksStu"), webDriver);
    private final GuiControl sectionMore = new GuiControl(getElementMap().get("sectionMore"), webDriver);
    private final GuiControl sectionMoreStu = new GuiControl(getElementMap().get("sectionMoreStu"), webDriver);
    private final GuiControl moreBooks = new GuiControl(getElementMap().get("moreBooks"), webDriver);
    private final GuiControl moreBooksStu = new GuiControl(getElementMap().get("moreBooksStu"), webDriver);
    private final GuiControl sectionCollage = new GuiControl(getElementMap().get("sectionCollage"), webDriver);
    private final GuiControl sectionCollageStu = new GuiControl(getElementMap().get("sectionCollageStu"), webDriver);
    private final GuiControl collageBooks = new GuiControl(getElementMap().get("collageBooks"), webDriver);
    private final GuiControl collageBooksStu = new GuiControl(getElementMap().get("collageBooksStu"), webDriver);
    private final GuiControl sectionAdult = new GuiControl(getElementMap().get("sectionAdult"), webDriver);
    private final GuiControl sectionAdultStu = new GuiControl(getElementMap().get("sectionAdultStu"), webDriver);
    private final GuiControl adultBooks = new GuiControl(getElementMap().get("adultBooks"), webDriver);
    private final GuiControl adultBooksStu = new GuiControl(getElementMap().get("adultBooksStu"), webDriver);
    private final GuiControl sectionTranslations = new GuiControl(getElementMap().get("sectionTranslations"), webDriver);
    private final GuiControl sectionTranslationsStu = new GuiControl(getElementMap().get("sectionTranslationsStu"), webDriver);
    private final GuiControl translationBooks = new GuiControl(getElementMap().get("translationBooks"), webDriver);
    private final GuiControl translationBooksStu = new GuiControl(getElementMap().get("translationBooksStu"), webDriver);
    private final GuiControl sectionCountry = new GuiControl(getElementMap().get("sectionCountry"), webDriver);
    private final GuiControl sectionCountryStu = new GuiControl(getElementMap().get("sectionCountryStu"), webDriver);
    private final GuiControl countryBooks = new GuiControl(getElementMap().get("countryBooks"), webDriver);
    private final GuiControl countryBooksStu = new GuiControl(getElementMap().get("countryBooksStu"), webDriver);
    private final GuiControl headerExplore = new GuiControl(getElementMap().get("headerExplore"), webDriver);
    private final GuiControl exploreProducts = new GuiControl(getElementMap().get("exploreProducts"), webDriver);
    private final GuiControl exploreProductsLinks = new GuiControl(getElementMap().get("exploreProductsLinks"), webDriver);
    private final GuiControl searchMenu = new GuiControl(getElementMap().get("searchMenu"), webDriver);
    private final GuiControl searchMenuMainDropDown = new GuiControl(getElementMap().get("searchMenuMainDropDown"), webDriver);
    private final GuiControl searchMenuChildDropDown = new GuiControl(getElementMap().get("searchMenuChildDropDown"), webDriver);
    private final GuiControl studentSearchDropOption = new GuiControl(getElementMap().get("studentSearchDropOption"), webDriver);
    private final GuiControl studentMainDropDownList = new GuiControl(getElementMap().get("studentMainDropDownList"), webDriver);

    //Teacher FLexBook2.0 landing page: FB2.0 Teacher landing: https://flexbooks.ck12.org/flexbooks/teacher/
    private final GuiControl mathSection = new GuiControl(getElementMap().get("mathSection"), webDriver);
    private final GuiControl mathBooks = new GuiControl(getElementMap().get("mathBooks"), webDriver);
    private final GuiControl scienceSection = new GuiControl(getElementMap().get("scienceSection"), webDriver);
    private final GuiControl scienceBook = new GuiControl(getElementMap().get("scienceBook"), webDriver);
    private final GuiControl socialStudiesSection = new GuiControl(getElementMap().get("socialStudiesSection"), webDriver);
    private final GuiControl socialStudiesBook = new GuiControl(getElementMap().get("socialStudiesBook"), webDriver);
    private final GuiControl translationSection = new GuiControl(getElementMap().get("translationSection"), webDriver);
    private final GuiControl translationBook = new GuiControl(getElementMap().get("translationBook"), webDriver);
    private final GuiControl teacherAssistant = new GuiControl(getElementMap().get("teacherAssistant"), webDriver);
    private final GuiControl studentTutor = new GuiControl(getElementMap().get("studentTutor"), webDriver);

    //Tutor Consent Page: https://www.ck12.org/pages/tutor-consent/
    private final GuiControl tutorConsentPrivacyPolicy = new GuiControl(getElementMap().get("tutorConsentPrivacyPolicy"), webDriver);
    private final GuiControl tutorConsentAITutorMail = new GuiControl(getElementMap().get("tutorConsentAITutorMail"), webDriver);

    //Flexlets Page: https://www.ck12.org/pages/flexlets/
    private final GuiControl flexletsOnFlexletPage = new GuiControl(getElementMap().get("flexletsOnFlexletPage"), webDriver);

    //Slab Page: https://www.ck12.org/pages/slab/
    private final GuiControl ourMissionSlabPage = new GuiControl(getElementMap().get("ourMissionSlabPage"), webDriver);
    private final GuiControl slabMemberToggleUpSlabPage = new GuiControl(getElementMap().get("slabMemberToggleUpSlabPage"), webDriver);
    private final GuiControl slabMemberToggleDownSlabPage = new GuiControl(getElementMap().get("slabMemberToggleDownSlabPage"), webDriver);
    private final GuiControl slabMembersSlabPage = new GuiControl(getElementMap().get("slabMembersSlabPage"), webDriver);
    private final GuiControl whySlabTitles = new GuiControl(getElementMap().get("whySlabTitles"), webDriver);
    private final GuiControl assignToGCPopup = new GuiControl(getElementMap().get("assignToGCPopup"), webDriver);
    private final GuiControl dismissAssignToGCPopup = new GuiControl(getElementMap().get("dismissAssignToGCPopup"), webDriver);
    private final GuiControl courseOptions = new GuiControl(getElementMap().get("courseOptions"), webDriver);
    private final GuiControl exploreCourseLink = new GuiControl(getElementMap().get("exploreCourseLink"), webDriver);

    //Adult Page:
    private final GuiControl adultPageTitle = new GuiControl(getElementMap().get("adultPageTitle"), webDriver);
    private final GuiControl browseAdultFBButton = new GuiControl(getElementMap().get("browseAdultFBButton"), webDriver);
    private final GuiControl adultEduVideoIframe = new GuiControl(getElementMap().get("adultEduVideoIframe"), webDriver);
    private final GuiControl adultEduYoutubeVideo = new GuiControl(getElementMap().get("adultEduYoutubeVideo"), webDriver);
    private final GuiControl adultEduFBSectionTitles = new GuiControl(getElementMap().get("adultEduFBSectionTitles"), webDriver);
    private final GuiControl adultBasicEduFB = new GuiControl(getElementMap().get("adultBasicEduFB"), webDriver);
    private final GuiControl adultHighSchoolDipFB = new GuiControl(getElementMap().get("adultHighSchoolDipFB"), webDriver);
    private final GuiControl adultHighSchoolEquiFB = new GuiControl(getElementMap().get("adultHighSchoolEquiFB"), webDriver);
    private final GuiControl careerTechEduFB = new GuiControl(getElementMap().get("careerTechEduFB"), webDriver);
    private final GuiControl englishSecLangFB = new GuiControl(getElementMap().get("englishSecLangFB"), webDriver);
    private final GuiControl integrationSecTitle = new GuiControl(getElementMap().get("integrationSecTitle"), webDriver);
    private final GuiControl integrationSecLinks = new GuiControl(getElementMap().get("integrationSecLinks"), webDriver);
    private final GuiControl testimonialHeader = new GuiControl(getElementMap().get("testimonialHeader"), webDriver);
    private final GuiControl testimonialTitles = new GuiControl(getElementMap().get("testimonialTitles"), webDriver);



    private final GuiControl bookTitlesOfScienceFlexbooks = new GuiControl(getElementMap().get("bookTitlesOfScienceFlexbooks"), webDriver);
    private final GuiControl titleScienceFlexbooks = new GuiControl(getElementMap().get("titleScienceFlexbooks"), webDriver);
    private final GuiControl coreAlignedConcepts = new GuiControl(getElementMap().get("coreAlignedConcepts"), webDriver);


    public BrowsePagesContentVerificationPage(WebDriver webDriver, ExtentTest extentTest, ExtentReports extentReports) {
        super(webDriver, extentTest, extentReports);
    }

    String hTagsLocator = "xpath" + "_TBD_" + "//h";

    String[] mainDropDown = {"Math", "Science", "Social Studies", "Translations"};

    String[] mathSubDropDown = {"Grade 6", "Grade 7", "Grade 8", "Algebra I", "Geometry", "Algebra II", "PreCalculus"};

    String[] scienceSubDropDown = {"Earth Science", "Life Science", "Physical Science", "Biology", "Chemistry", "Physics"};

    String[] socialStudiesSubDropDown = {"Economics", "Geography", "Government", "Philosophy", "Sociology"};

    String[] translationsSubDropDown = {"Matemáticas Grado 6", "Matemáticas Grado 7", "Matemáticas Grado 8", "Álgebra - Nivel Básico", "Álgebra I - en Español"};

    String[] subOptionsArr;

    String[] studentSections = {"science-Science", "math-Math", "socialStudies-Social Studies", "photography-Photography", "adultEducation-Adult Education", "country-Country"};

    String[] studentScienceSection = {"Physics>/cbook/ck-12-physics-flexbook-2.0/", "Chemistry>/cbook/ck-12-chemistry-flexbook-2.0/", "Biology>/cbook/ck-12-biology-flexbook-2.0/", "Physical Science>/cbook/ck-12-middle-school-physical-science-flexbook-2.0/",
            "Life Science>/cbook/ck-12-middle-school-life-science-2.0/", "Earth Science>/cbook/ck-12-middle-school-earth-science-flexbook-2.0/", "5th Grade Science>/book/ck-12-fifth-grade-science/", "4th Grade Science>/book/ck-12-fourth-grade-science/",
            "3rd Grade Science>/book/ck-12-third-grade-science/", "2nd Grade Science>/book/ck-12-second-grade-science/", "1st Grade Science>/book/ck-12-first-grade-science/", "Kindergarten Science>/book/ck-12-kindergarten-science/"};

    String[] studentMathSection = {"PreCalculus>/cbook/ck-12-precalculus-concepts-2.0/", "Algebra 2>/cbook/ck-12-interactive-algebra-2/", "Geometry>/cbook/ck-12-interactive-geometry-for-ccss/", "Algebra 1>/cbook/ck-12-interactive-algebra-1-for-ccss/",
            "8th Grade Math>/cbook/ck-12-interactive-middle-school-math-8-for-ccss/", "7th Grade Math>/cbook/ck-12-interactive-middle-school-math-7-for-ccss/", "6th Grade Math>/cbook/ck-12-interactive-middle-school-math-6-for-ccss/", "5th Grade Math>/elementary-math-grade-5",
            "4th Grade Math>/elementary-math-grade-4", "3rd Grade Math>/elementary-math-grade-3", "2nd Grade Math>/elementary-math-grade-2", "1st Grade Math>/elementary-math-grade-1"};

    String[] studentSocialStudiesSection = {"Economics>/cbook/episd-2019-2020-economics", "Geography>/cbook/episd-world-geo-2019", "Government>/cbook/episd-united-states-government-2019-2020", "History>/fbbrowse/list/?Subject=History", "World History>/cbook/world-history-studies_episd",
            "Philosophy>/cbook/episd-philosophy", "Sociology>/cbook/episd-sociology"};

    String[] studentPhotographySection = {"Digital Imaging 1>/cbook/digital-imaging-1:", "Digital Imaging 2>/cbook/digital-imaging-2:", "Photography>/cbook/lksd-digital-photography/"};

    String[] studentAdultEducationSection = {"Basic Education>/#adult-basic-education", "High School Diploma>/#high-school-diploma", "High School Equivalency>/#high-school-equivalency", "Career Technical Ed>/#career-technical-education", "English as 2nd Language>/#ESL"};

    String[] studentCountrySection = {"Chile>/chile/", "Brasil>/brasil/", "India>/cbse/", "Georgia>/georgia"};

    // This methods verify the What Do you Want To Teach Today Section on the Teacher Landing page.
    public boolean verifyWhatDoYouWantToTeachTodaySection() {
        whatDoYouWantToTeachHeader.scrollIntoView();
        if (whatDoYouWantToTeachHeader.isElementPresent()) {
            if (whatDoYouWantToTeachHeader.getText().equals("What Do You Want to Teach Today?")) {
                reportLog("The What Do you Want To Teach Today Section is present on the Teacher Landing page.");
                return true;
            }
        }
        return false;
    }

    // This methods verify the Items under the What Do you Want To Teach Today Section on the Teacher Landing page.
    public boolean verifyDetailsUnderWhatDoYouWantToTeachTodaySection() {
        reportLog("Verify Books/Items under the Math By Level...");
        if (sectionMathByLevel.isElementPresent() && sectionMathByLevel.getText().equals("Math by Level")) {
            List<WebElement> mathByLevelSectionBooks = mathByLevelBooks.getWebElements();
            reportLog("The number of books/Items under the Math By Level: " + mathByLevelSectionBooks.size());

            String[] urls = {"https://www.ck12.org/elementary-math-grade-1>Grade 1 to 5", "https://flexbooks.ck12.org/cbook/ck-12-interactive-middle-school-math-6-for-ccss/>Grade 6", "https://flexbooks.ck12.org/cbook/ck-12-interactive-middle-school-math-7-for-ccss/>Grade 7",
            "https://flexbooks.ck12.org/cbook/ck-12-interactive-middle-school-math-8-for-ccss/>Grade 8", "https://flexbooks.ck12.org/cbook/ck-12-interactive-algebra-1-for-ccss/>Algebra 1", "https://flexbooks.ck12.org/cbook/ck-12-interactive-geometry-for-ccss/>Geometry",
            "https://flexbooks.ck12.org/cbook/ck-12-interactive-algebra-2/>Algebra 2", "https://flexbooks.ck12.org/cbook/ck-12-precalculus-concepts-2.0/>PreCalculus"};

            for (int i = 0; i < urls.length; i++){
                List<WebElement> links = mathByLevelBooks.getWebElements();
                if (links.get(i).isDisplayed()){
                    String bookName = links.get(i).getText();
                    if (bookName.contains(urls[i].split(">")[1])) {
                        verifyStatusCodeIsCorrect(links.get(i).getAttribute("href"), bookName);
                        ((JavascriptExecutor) webDriver).executeScript("arguments[0].scrollIntoView(true);", links.get(i));
                        waitForSec(3);
                        ((JavascriptExecutor) webDriver).executeScript("arguments[0].click();", links.get(i));
                        waitForSec(6);
                        if (webDriver.getCurrentUrl().contains(urls[i].split(">")[0])) {
                            reportLog("The Book " + bookName + " link is navigated to the correct page");
                        } else {
                            return false;
                        }
                    } else {
                        reportLog("The Book " + bookName + " is incorrect or mismatched");
                        return false;
                    }
                }
                webDriver.navigate().back();
                waitForSec(6);
                webDriver.navigate().refresh();
            }
        } else {
            reportLog("The section is not present: " + sectionMathByLevel.getText());
            return false;
        }

        reportLog("Verify Books/Items under the Math By Subject...");
        if (sectionMathByLevelSubject.isElementPresent() && sectionMathByLevelSubject.getText().equals("Math by Subject")) {
            List<WebElement> mathBySubjectSectionBooks = mathBySubjectBooks.getWebElements();
            reportLog("The number of books/Items under the Math By Subject: " + mathBySubjectSectionBooks.size());

            String[] urls = {"https://www.ck12.org/c/arithmetic/>Arithmetic", "https://www.ck12.org/c/measurement/>Measurement", "https://www.ck12.org/c/algebra/>Algebra", "https://www.ck12.org/c/geometry/>Geometry", "https://www.ck12.org/c/probability/>Probability", "https://www.ck12.org/c/statistics/>Statistics",
                    "https://www.ck12.org/c/trigonometry/>Trigonometry", "https://www.ck12.org/c/analysis/>Analysis", "https://www.ck12.org/c/calculus/>Calculus"};

            for (int i = 0; i < urls.length; i++){
                List<WebElement> links = mathBySubjectBooks.getWebElements();
                if (links.get(i).isDisplayed()){
                    String bookName = links.get(i).getText();
                    if (bookName.contains(urls[i].split(">")[1])) {
                        verifyStatusCodeIsCorrect(links.get(i).getAttribute("href"), bookName);
                        ((JavascriptExecutor) webDriver).executeScript("arguments[0].scrollIntoView(true);", links.get(i));
                        waitForSec(3);
                        ((JavascriptExecutor) webDriver).executeScript("arguments[0].click();", links.get(i));
                        waitForSec(6);
                        if (webDriver.getCurrentUrl().contains(urls[i].split(">")[0])) {
                            reportLog("The Book " + bookName + " link is navigated to the correct page");
                        } else {
                            return false;
                        }
                    } else {
                        reportLog("The Book " + bookName + " is incorrect or mismatched");
                        return false;
                    }
                }
                webDriver.navigate().back();
                waitForSec(6);
                webDriver.navigate().refresh();
            }
        } else {
            reportLog("The section is not present: " + sectionMathByLevelSubject.getText());
            return false;
        }

        reportLog("Verify Books/Items under the Math By Science...");
        if (sectionScience.isElementPresent() && sectionScience.getText().equals("Science")) {
            List<WebElement> scienceSectionBooks = scienceBooks.getWebElements();
            reportLog("The number of books/Items under the Science: " + scienceSectionBooks.size());

            String[] urls = {"https://www.ck12.org/elementary-science/>Grade K to 5", "https://flexbooks.ck12.org/cbook/ck-12-middle-school-earth-science-flexbook-2.0/>Earth Science", "https://flexbooks.ck12.org/cbook/ck-12-middle-school-life-science-2.0/>Life Science",
                    "https://flexbooks.ck12.org/cbook/ck-12-middle-school-physical-science-flexbook-2.0/>Physical Science", "https://flexbooks.ck12.org/cbook/ck-12-biology-flexbook-2.0/>Biology", "https://flexbooks.ck12.org/cbook/ck-12-chemistry-flexbook-2.0/>Chemistry",
                    "https://flexbooks.ck12.org/cbook/ck-12-physics-flexbook-2.0/>Physics"};

            for (int i = 0; i < urls.length; i++){
                List<WebElement> links = scienceBooks.getWebElements();
                if (links.get(i).isDisplayed()){
                    String bookName = links.get(i).getText();
                    if (bookName.contains(urls[i].split(">")[1])) {
                        verifyStatusCodeIsCorrect(links.get(i).getAttribute("href"), bookName);
                        ((JavascriptExecutor) webDriver).executeScript("arguments[0].scrollIntoView(true);", links.get(i));
                        waitForSec(3);
                        ((JavascriptExecutor) webDriver).executeScript("arguments[0].click();", links.get(i));
                        waitForSec(6);
                        if (webDriver.getCurrentUrl().contains(urls[i].split(">")[0])) {
                            reportLog("The Book " + bookName + " link is navigated to the correct page");
                        } else {
                            return false;
                        }
                    } else {
                        reportLog("The Book " + bookName + " is incorrect or mismatched");
                        return false;
                    }
                }
                webDriver.navigate().back();
                waitForSec(6);
                webDriver.navigate().refresh();
            }
        } else {
            reportLog("The section is not present: " + sectionScience.getText());
            return false;
        }

        reportLog("Verify Books/Items under the English...");
        if (sectionEnglish.isElementPresent() && sectionEnglish.getText().equals("English")) {
            List<WebElement> englishSectionBooks = englishBooks.getWebElements();
            reportLog("The number of books/Items under the English: " + englishSectionBooks.size());

            String[] urls = {"https://www.ck12.org/fbbrowse/list/?Language=All%20Languages&Subject=Writing>Writing", "https://www.ck12.org/c/spelling/>Spelling"};

            for (int i = 0; i < urls.length; i++){
                List<WebElement> links = englishBooks.getWebElements();
                if (links.get(i).isDisplayed()){
                    String bookName = links.get(i).getText();
                    if (bookName.contains(urls[i].split(">")[1])) {
                        verifyStatusCodeIsCorrect(links.get(i).getAttribute("href"), bookName);
                        ((JavascriptExecutor) webDriver).executeScript("arguments[0].scrollIntoView(true);", links.get(i));
                        waitForSec(3);
                        ((JavascriptExecutor) webDriver).executeScript("arguments[0].click();", links.get(i));
                        waitForSec(6);
                        if (webDriver.getCurrentUrl().contains(urls[i].split(">")[0])) {
                            reportLog("The Book " + bookName + " link is navigated to the correct page");
                        } else {
                            return false;
                        }
                    } else {
                        reportLog("The Book " + bookName + " is incorrect or mismatched");
                        return false;
                    }
                }
                webDriver.navigate().back();
                waitForSec(6);
                webDriver.navigate().refresh();
            }
        } else {
            reportLog("The section is not present: " + sectionEnglish.getText());
            return false;
        }

        reportLog("Verify Books/Items under the Social Studies...");
        if (sectionSocialStudies.isElementPresent() && sectionSocialStudies.getText().equals("Social Studies")) {
            List<WebElement> socialStudiesSectionBooks = socialStudiesBooks.getWebElements();
            reportLog("The number of books/Items under the Social Studies: " + socialStudiesSectionBooks.size());

            String[] urls = {"/cbook/episd-2019-2020-economics-with-emphasis-on-the-free-enterprise-system>Economics", "/cbook/episd-world-geo-2019>Geography", "/cbook/episd-united-states-government-2019-2020>Government", "/fbbrowse/list/?Subject=History>History",
                    "/cbook/world-history-studies_episd>World History", "/cbook/episd-philosophy>Philosophy", "/cbook/episd-sociology>Sociology"};

            for (int i = 0; i < urls.length; i++){
                List<WebElement> links = socialStudiesBooks.getWebElements();
                if (links.get(i).isDisplayed()){
                    String bookName = links.get(i).getText();
                    if (bookName.contains(urls[i].split(">")[1])) {
                        verifyStatusCodeIsCorrect(links.get(i).getAttribute("href"), bookName);
                        ((JavascriptExecutor) webDriver).executeScript("arguments[0].scrollIntoView(true);", links.get(i));
                        waitForSec(3);
                        ((JavascriptExecutor) webDriver).executeScript("arguments[0].click();", links.get(i));
                        waitForSec(6);
                        if (webDriver.getCurrentUrl().contains(urls[i].split(">")[0])) {
                            reportLog("The Book " + bookName + " link is navigated to the correct page");
                        } else {
                            return false;
                        }
                    } else {
                        reportLog("The Book " + bookName + " is incorrect or mismatched");
                        return false;
                    }
                }
                webDriver.navigate().back();
                waitForSec(6);
                webDriver.navigate().refresh();
            }
        } else {
            reportLog("The section is not present: " + sectionSocialStudies.getText());
            return false;
        }

        reportLog("Verify Books/Items under the More...");
        if (sectionMore.isElementPresent() && sectionMore.getText().equals("More")) {
            List<WebElement> moreSectionBooks = moreBooks.getWebElements();
            reportLog("The number of books/Items under the More: " + moreSectionBooks.size());

            String[] urls = {"https://www.ck12.org/fbbrowse/list/?Grade=All%20Grades&Language=All%20Languages&Subject=Astronomy>Astronomy", "https://www.ck12.org/fbbrowse/list/?Grade=All%20Grades&Language=All%20Languages&Subject=Engineering>Engineering",
                    "https://www.ck12.org/fbbrowse/list/?Grade=All%20Grades&Language=All%20Languages&Subject=Health>Health", "https://www.ck12.org/fbbrowse/list/?Language=All%20Languages&Subject=Photography&Grade=All%20Grades>Photography",
                    "https://www.ck12.org/fbbrowse/list/?Grade=All%20Grades&Language=All%20Languages&Subject=Technology>Technology"};

            for (int i = 0; i < urls.length; i++){
                List<WebElement> links = moreBooks.getWebElements();
                if (links.get(i).isDisplayed()){
                    String bookName = links.get(i).getText();
                    if (bookName.contains(urls[i].split(">")[1])) {
                        verifyStatusCodeIsCorrect(links.get(i).getAttribute("href"), bookName);
                        ((JavascriptExecutor) webDriver).executeScript("arguments[0].scrollIntoView(true);", links.get(i));
                        waitForSec(3);
                        ((JavascriptExecutor) webDriver).executeScript("arguments[0].click();", links.get(i));
                        waitForSec(6);
                        if (webDriver.getCurrentUrl().contains(urls[i].split(">")[0])) {
                            reportLog("The Book " + bookName + " link is navigated to the correct page");
                        } else {
                            return false;
                        }
                    } else {
                        reportLog("The Book " + bookName + " is incorrect or mismatched");
                        return false;
                    }
                }
                webDriver.navigate().back();
                waitForSec(6);
                webDriver.navigate().refresh();
            }
        } else {
            reportLog("The section is not present: " + sectionMore.getText());
            return false;
        }

        reportLog("Verify Books/Items under the College...");
        if (sectionCollage.isElementPresent() && sectionCollage.getText().equals("College")) {
            List<WebElement> moreSectionBooks = collageBooks.getWebElements();
            reportLog("The number of books/Items under the College: " + moreSectionBooks.size());

            String[] urls = {"https://flexbooks.ck12.org/cbook/ck-12-elementary-intermediate-college-algebra/>College Algebra", "https://flexbooks.ck12.org/cbook/ck-12-college-precalculus/>College Precalculus", "cbook/advanced-mathematics-flexbook/>Linear Algebra", "https://flexbooks.ck12.org/cbook/ck-12-college-human-biology-flexbook-2.0/>College Human Biology",
                    "cbook/origins-and-the-search-for-life-in-the-universe/>The Universe"};

            for (int i = 0; i < urls.length; i++){
                List<WebElement> links = collageBooks.getWebElements();
                if (links.get(i).isDisplayed()){
                    String bookName = links.get(i).getText();
                    if (bookName.contains(urls[i].split(">")[1])) {
                        verifyStatusCodeIsCorrect(links.get(i).getAttribute("href"), bookName);
                        ((JavascriptExecutor) webDriver).executeScript("arguments[0].scrollIntoView(true);", links.get(i));
                        waitForSec(3);
                        ((JavascriptExecutor) webDriver).executeScript("arguments[0].click();", links.get(i));
                        waitForSec(6);
                        if (webDriver.getCurrentUrl().contains(urls[i].split(">")[0])) {
                            reportLog("The Book " + bookName + " link is navigated to the correct page");
                        } else {
                            return false;
                        }
                    } else {
                        reportLog("The Book " + bookName + " is incorrect or mismatched");
                        return false;
                    }
                }
                webDriver.navigate().back();
                waitForSec(6);
                webDriver.navigate().refresh();
            }
        } else {
            reportLog("The section is not present: " + sectionCollage.getText());
            return false;
        }

        reportLog("Verify Books/Items under the Adult Education...");
        if (sectionAdult.isElementPresent() && sectionAdult.getText().equals("Adult Education")) {
            List<WebElement> adultSectionBooks = adultBooks.getWebElements();
            reportLog("The number of books/Items under the Adult Education: " + adultSectionBooks.size());

            String[] urls = {"https://www.ck12.org/pages/adult-education/#adult-basic-education>Basic Education", "https://www.ck12.org/pages/adult-education/#high-school-diploma>High School Diploma", "https://www.ck12.org/pages/adult-education/#high-school-equivalency>High School Equivalency",
                    "https://www.ck12.org/pages/adult-education/#career-technical-education>Career Technical Ed", "https://www.ck12.org/pages/adult-education/#ESL>English as 2nd Language"};

            for (int i = 0; i < urls.length; i++){
                List<WebElement> links = adultBooks.getWebElements();
                if (links.get(i).isDisplayed()){
                    String bookName = links.get(i).getText();
                    if (bookName.contains(urls[i].split(">")[1])) {
                        verifyStatusCodeIsCorrect(links.get(i).getAttribute("href"), bookName);
                        ((JavascriptExecutor) webDriver).executeScript("arguments[0].scrollIntoView(true);", links.get(i));
                        waitForSec(3);
                        ((JavascriptExecutor) webDriver).executeScript("arguments[0].click();", links.get(i));
                        waitForSec(6);
                        if (webDriver.getCurrentUrl().contains(urls[i].split(">")[0])) {
                            reportLog("The Book " + bookName + " link is navigated to the correct page");
                        } else {
                            return false;
                        }
                    } else {
                        reportLog("The Book " + bookName + " is incorrect or mismatched");
                        return false;
                    }
                }
                webDriver.navigate().back();
                waitForSec(6);
                webDriver.navigate().refresh();
            }
        } else {
            reportLog("The section is not present: " + sectionAdult.getText());
            return false;
        }

        reportLog("Verify Books/Items under the Translations...");
        if (sectionTranslations.isElementPresent() && sectionTranslations.getText().equals("Translations")) {
            List<WebElement> translationSectionBooks = translationBooks.getWebElements();
            reportLog("The number of books/Items under the Translations: " + translationSectionBooks.size());

            String[] urls = {"https://www.ck12.org/fbbrowse/list/?Language=Spanish>Spanish", "https://interactives.ck12.org/simulations/physics.html?lang=ko>Korean", "https://interactives.ck12.org/simulations/physics.html?lang=de>Deutsch",
                    "https://interactives.ck12.org/simulations/physics.html?lang=zh>Chinese", "https://interactives.ck12.org/simulations/physics.html?lang=EL>Greek", "https://interactives.ck12.org/simulations/physics.html?lang=pl>Polski"};


            for (int i = 0; i < urls.length; i++){
                List<WebElement> links = translationBooks.getWebElements();
                if (links.get(i).isDisplayed()){
                    String bookName = links.get(i).getText();
                    if (bookName.contains(urls[i].split(">")[1])) {
                        verifyStatusCodeIsCorrect(links.get(i).getAttribute("href"), bookName);
                        ((JavascriptExecutor) webDriver).executeScript("arguments[0].scrollIntoView(true);", links.get(i));
                        waitForSec(3);
                        ((JavascriptExecutor) webDriver).executeScript("arguments[0].click();", links.get(i));
                        waitForSec(6);
                        if (webDriver.getCurrentUrl().contains(urls[i].split(">")[0])) {
                            reportLog("The Book " + bookName + " link is navigated to the correct page");
                        } else {
                            return false;
                        }
                    } else {
                        reportLog("The Book " + bookName + " is incorrect or mismatched");
                        return false;
                    }
                }
                webDriver.navigate().back();
                waitForSec(6);
                webDriver.navigate().refresh();
            }
        } else {
            reportLog("The section is not present: " + sectionTranslations.getText());
            return false;
        }


        reportLog("Verify Books/Items under the Country...");
        if (sectionCountry.isElementPresent() && sectionCountry.getText().equals("Country")) {
            List<WebElement> translationSectionBooks = countryBooks.getWebElements();
            reportLog("The number of books/Items under the Country: " + translationSectionBooks.size());

            String[] urls = {"https://www.ck12.org/chile/>Chile", "https://www.ck12.org/brasil/>Brasil", "https://www.ck12.org/cbse/>India", "https://ck12.edu.ge/>Georgia"};


            for (int i = 0; i < urls.length; i++){
                List<WebElement> links = countryBooks.getWebElements();
                if (links.get(i).isDisplayed()){
                    String bookName = links.get(i).getText();
                    if (bookName.contains(urls[i].split(">")[1])) {
                        verifyStatusCodeIsCorrect(links.get(i).getAttribute("href"), bookName);
                        ((JavascriptExecutor) webDriver).executeScript("arguments[0].scrollIntoView(true);", links.get(i));
                        waitForSec(3);
                        ((JavascriptExecutor) webDriver).executeScript("arguments[0].click();", links.get(i));
                        waitForSec(6);
                        if (webDriver.getCurrentUrl().contains(urls[i].split(">")[0])) {
                            reportLog("The Book " + bookName + " link is navigated to the correct page");
                        } else {
                            return false;
                        }
                    } else {
                        reportLog("The Book " + bookName + " is incorrect or mismatched");
                        return false;
                    }
                }
                webDriver.navigate().back();
                waitForSec(6);
                webDriver.navigate().refresh();
            }
        } else {
            reportLog("The section is not present: " + sectionCountry.getText());
            return false;
        }
        return true;
    }

    // This methods verify the Explore Some Of Our Products Section on the Teacher Landing page.
    public boolean verifyExploreProductsSection() {
        headerExplore.scrollIntoView();
        if (headerExplore.isElementPresent()) {
            if (headerExplore.getText().equals("Explore Some of Our Products")) {
                reportLog("Verify Explore Some Of Our Products Section is present on the Teacher Landing page.");
                return true;
            }
        }
        return false;
    }

    // This method verify the Explore products navitaion on the landing page
    public boolean verifyExploreProductList() {
        String[] expectedProductLinks = {"https://www.ck12.org/fbbrowse/", "https://www.ck12.org/assessment/ui/browse/practice/?",
                "https://interactives.ck12.org/simulations/physics.html?", "https://interactives.ck12.org/simulations/chemistry.html?",
                "https://interactives.ck12.org/plix/", "https://www.ck12.org/study-guides/algebra/?", "https://www.ck12.org/schools/"};

        if (exploreProducts.isElementPresent()) {
            List<WebElement> exploreProductsList = exploreProducts.getWebElements();
            reportLog("The number of explore products on the landing page: " + exploreProductsList.size());

            for (WebElement exploreProduct : exploreProductsList) {
                if (exploreProduct.isDisplayed()) {
                    reportLog("The product is: " + exploreProduct.getText());
                } else {
                    reportLog("The product is not present: " + exploreProduct.getText());
                    return false;
                }
            }

            reportLog("verify the explore products navigation...");
            List<WebElement> productsLink = exploreProductsLinks.getWebElements();
            reportLog("The explore products links size is: " + productsLink.size());

            for (int i = 0; i < expectedProductLinks.length; i++){
                List<WebElement> exploreProductsLink = exploreProductsLinks.getWebElements();
                if (exploreProductsLink.get(i).isDisplayed()){
                    ((JavascriptExecutor) webDriver).executeScript("arguments[0].scrollIntoView(true);", exploreProductsLink.get(i));
                    waitForSec(3);
                    ((JavascriptExecutor) webDriver).executeScript("arguments[0].click();", exploreProductsLink.get(i));
                    waitForSec(6);
                    if (webDriver.getCurrentUrl().contains(expectedProductLinks[i])) {
                        reportLog("The Product link is navigated to the correct page");
                    } else {
                        return false;
                    }
                }
                webDriver.navigate().back();
                waitForSec(6);
                webDriver.navigate().refresh();
            }

        } else {
            reportLog("The section is not present: " + headerExplore.getText());
        }
        return true;
    }

    // This method verify the all the items from the Search drop down on the landing page
    public boolean verifySearchDropDownMenu() {
        if (searchMenu.isElementPresent()) {
            searchMenu.clickJScript();

            reportLog("Verify the list of items under the main search drop down.");
            List<WebElement> searchMainDropDownList = searchMenuMainDropDown.getWebElements();
            reportLog("The list of items under the main search drop down is: " + searchMainDropDownList.size());

            for (WebElement drpDwnItem : searchMainDropDownList) {
                if (drpDwnItem.isDisplayed()) {
                    reportLog("The item name is : " + drpDwnItem.getText());
                    drpDwnItem.click();
                    reportLog("Clicked on the Item:" + drpDwnItem.getText());

                    reportLog("Verify the list of items under the child search drop down.");
                    List<WebElement> searchChildDropDownList = searchMenuChildDropDown.getWebElements();
                    reportLog("The list of items under the child search drop down is: " + searchChildDropDownList.size());

                    for (WebElement subDrpDwnItem : searchChildDropDownList) {
                        if (subDrpDwnItem.isDisplayed()) {
                            reportLog("The Sub item under the drop down is: " + subDrpDwnItem.getText());
                        } else {
                            reportLog("The Item is not displayed." + subDrpDwnItem.getText());
                            return false;
                        }
                    }

                } else {
                    reportLog("The Item is not displayed." + drpDwnItem.getText());
                    return false;
                }
            }
        }
        return true;
    }

    //This method verify all the items in the Search Dropdown from Student Landing Page with titles
    public boolean verifyStudentSearchDropDown() {
        int i = 0;

        int subCount = 0;
        waitForSec(2);
        if (studentSearchDropOption.isDisplayed()) {
            studentSearchDropOption.click();
            logger.info("Student Search DropDown Selected");
            studentMainDropDownList.isDisplayed();
            List<WebElement> mainOptions = studentMainDropDownList.getWebElements();
            for (WebElement option : mainOptions) {
                if (option.getText().equals(mainDropDown[i])) {
                    if (option.getText().equals("Math")) {
                        subOptionsArr = mathSubDropDown;
                    } else if (option.getText().equals("Science")) {
                        subOptionsArr = scienceSubDropDown;
                    } else if (option.getText().equals("Social Studies")) {
                        subOptionsArr = socialStudiesSubDropDown;
                    } else if (option.getText().equals("Translations")) {
                        subOptionsArr = translationsSubDropDown;
                    }
                    logger.info(option.getText() + " option visible in main dropdown");
                    option.click();
                    for (int j = 1; j < mainOptions.size(); j++){
                        String subList = "xpath" + "_TBD_" + "(//div[@id='searchStudentLanding_search_main_menu']//div[@aria-label='Search Subjects']//div[@role='menu'])[" + j + "]//button[contains(@data-dx-desc,'course_search_dropdown_submenu')]";
                        GuiControl studentSubDropDownList = new GuiControl(subList, webDriver);
                        List<WebElement> subOptions = studentSubDropDownList.getWebElements();
                        if (String.valueOf(subOptions.size()).equals(String.valueOf(subOptionsArr.length))) {
                            for (WebElement subOption : subOptions) {
                                if (subOption.getText().equals(subOptionsArr[subCount])) {
                                    logger.info("Sub Menu Drop Down for " + option.getText() + " have " + subOption.getText());
                                }
                                subCount++;
                            }
                            subCount = 0;
                        }
                    }
                }
                i++;
            }
            return true;
        }
        return false;
    }

    //This method verify Suggested Sections in Student Landing Page with Header, concept/book titles and hyperlinks
    public boolean verifyStudentSuggestedSections() {
        String[] titleArr = new String[0];
        for (int i = 0; i < studentSections.length; i++) {
            String sectionHeader = "xpath" + "_TBD_" + "//div[@id='" + studentSections[i].split("-")[0] + "']//h2";
            GuiControl header = new GuiControl(sectionHeader, webDriver);
            if (header.isDisplayed() && header.getText().equals(studentSections[i].split("-")[1])) {
                logger.info("Section Header " + studentSections[i].split("-")[1] + " verified");
                if (studentSections[i].split("-")[1].equals("Science")) {
                    titleArr = studentScienceSection;
                } else if (studentSections[i].split("-")[1].equals("Math")) {
                    titleArr = studentMathSection;
                } else if (studentSections[i].split("-")[1].equals("Social Studies")) {
                    titleArr = studentSocialStudiesSection;
                } else if (studentSections[i].split("-")[1].equals("Photography")) {
                    titleArr = studentPhotographySection;
                } else if (studentSections[i].split("-")[1].equals("Adult Education")) {
                    titleArr = studentAdultEducationSection;
                } else if (studentSections[i].split("-")[1].equals("Country")) {
                    titleArr = studentCountrySection;
                }
                String itemsInSection = "xpath" + "_TBD_" + "((//div[@id='" + studentSections[i].split("-")[0] + "']//following-sibling::div[contains(@class,'FlexbooksWrapper')])[1]//div[contains(@class,'CardTitle-')])";
                GuiControl items = new GuiControl(itemsInSection, webDriver);
                List<WebElement> itemsTitle = items.getWebElements();
                for (int j = 0; j < itemsTitle.size(); j++) {
                    String hyperlink = "xpath" + "_TBD_" + "((//div[@id='" + studentSections[i].split("-")[0] + "']//following-sibling::div[contains(@class,'FlexbooksWrapper')])[1]//a[@data-dx-elementinfo='link_cbook'])[" + (j + 1) + "]";
                    GuiControl link = new GuiControl(hyperlink, webDriver);
                    if (itemsTitle.get(j).getText().equals(titleArr[j].split(">")[0]) && link.getAttribute("href").contains(titleArr[j].split(">")[1])) {
                        logger.info(itemsTitle.get(j).getText() + " concept/book is verified and goto link " + link.getAttribute("href") + " verified");
                    } else {
                        logger.info(itemsTitle.get(j).getText() + " or " + link.getAttribute("href") + " is incorrect");
                        return false;
                    }
                }
            } else {
                logger.info(studentSections[i].split("-")[1] + " section not displayed");
                return false;
            }
        }
        return true;
    }

    //This method verify Suggested Sections in Student Landing Page with Header, concept/book titles and hyperlinks
    public boolean verifyStudentSuggestedSectionsStudentFlexBookSection() {
        String[] titleArr = new String[0];

        String[] stuSections = {"math-Math", "science-Science", "social studies-Social Studies", "translations-Translations"};

        String[] stuMathSection = {"CK-12 Interactive Middle School Math 6>/cbook/ck-12-interactive-middle-school-math-6-for-ccss", "CK-12 Interactive Middle School Math 7>/cbook/ck-12-interactive-middle-school-math-7-for-ccss",
                "CK-12 Interactive Middle School Math 8>/cbook/ck-12-interactive-middle-school-math-8-for-ccss", "CK-12 Interactive Algebra 1>/cbook/ck-12-interactive-algebra-1-for-ccss",
                "CK-12 Interactive Geometry>/cbook/ck-12-interactive-geometry-for-ccss", "CK-12 Interactive Algebra 2>/cbook/ck-12-interactive-algebra-2", "CK-12 Precalculus>/cbook/ck-12-precalculus-concepts-2.0"};

        String[] stuScienceSection = {"CK-12 Middle School Earth Science FlexBook 2.0>/cbook/ck-12-middle-school-earth-science-flexbook-2.0", "CK-12 Middle School Life Science 2.0>/cbook/ck-12-middle-school-life-science-2.0",
                "CK-12 Middle School Physical Science FlexBook 2.0>/cbook/ck-12-middle-school-physical-science-flexbook-2.0", "CK-12 Biology FlexBook 2.0>/cbook/ck-12-biology-flexbook-2.0", "CK-12 Chemistry FlexBook 2.0>/cbook/ck-12-chemistry-flexbook-2.0",
                "CK-12 Physics FlexBook 2.0>/cbook/ck-12-physics-flexbook-2.0"};

        String[] stuSocialStudySection = {"Economics>/cbook/episd-2019-2020-economics-with-emphasis-on-the-free-enterprise-system", "Geography>/cbook/episd-world-geo-2019", "Government>/cbook/episd-united-states-government-2019-2020", "Philosophy>/cbook/episd-philosophy", "Sociology>/cbook/episd-sociology"};

        String[] stuTranslationSection = {"Matemáticas de la Escuela Secundaria - Grado 6>/cbook/ck-12-conceptos-de-matem%C3%A1ticas-de-la-escuela-secundaria-grado-6-en", "Matemáticas de la Escuela Secundaria - Grado 7>/cbook/ck-12-conceptos-de-matem%C3%A1ticas-de-la-escuela-secundaria-grado-7-en-",
                "Matemáticas de la Escuela Secundaria - Grado 8>/cbook/ck-12-conceptos-de-matem%C3%A1ticas-de-la-escuela-secundaria-grado-8-en", "CK-12 Conceptos de Álgebra - Nivel Básico - en Español>/cbook/ck-12-conceptos-de-%C3%A1lgebra-nivel-b%C3%A1sico-en",
                "CK-12 Álgebra 1 - en Español>/cbook/ck-12-%C3%A1lgebra-i-en", "CK-12 Cálculo 2.0>/cbook/c%C3%A1lculo-2.0"};

        for (int i = 0; i < stuSections.length; i++) {
            String sectionHeader = "xpath" + "_TBD_" + "//div[@id='" + stuSections[i].split("-")[0] + "']//b";
            GuiControl header = new GuiControl(sectionHeader, webDriver);
            if (header.isDisplayed() && header.getText().equals(stuSections[i].split("-")[1])) {
                logger.info("Section Header " + stuSections[i].split("-")[1] + " verified");
                if (stuSections[i].split("-")[1].equals("Math")) {
                    titleArr = stuMathSection;
                } else if (stuSections[i].split("-")[1].equals("Science")) {
                    titleArr = stuScienceSection;
                } else if (stuSections[i].split("-")[1].equals("Social Studies")) {
                    titleArr = stuSocialStudySection;
                } else if (stuSections[i].split("-")[1].equals("Translations")) {
                    titleArr = stuTranslationSection;
                }
                String itemsInSection = "xpath" + "_TBD_" + "//div[@id='" + stuSections[i].split("-")[0] + "']//following-sibling::div[1]//a//div[contains(@class,'rmq')]//b";
                GuiControl items = new GuiControl(itemsInSection, webDriver);
                List<WebElement> itemsTitle = items.getWebElements();
                for (int j = 0; j < itemsTitle.size(); j++) {
                    String hyperlink = "xpath" + "_TBD_" + "//div[@id='" + stuSections[i].split("-")[0] + "']//following-sibling::div[1]//a[" + (j + 1) + "]";
                    GuiControl link = new GuiControl(hyperlink, webDriver);
                    if (itemsTitle.get(j).getText().equals(titleArr[j].split(">")[0]) && link.getAttribute("href").contains(titleArr[j].split(">")[1])) {
                        logger.info(itemsTitle.get(j).getText() + " concept/book is verified and goto link " + link.getAttribute("href") + " verified");
                    } else {
                        logger.info(itemsTitle.get(j).getText() + " or " + link.getAttribute("href") + " is incorrect");
                        return false;
                    }
                }
            } else {
                reportLog("Section Header not visible " + stuSections[i].split("-")[1]);
                return false;
            }
        }
        return true;
    }

    // This method verify the Explore products and navigation on the Student landing page
    public boolean verifyExploreSectionStudentLandingPage() {
        String[] exploreHeaders = {"Reinforce Your Learning", "Learn Interactively"};

        String[] reinforceSection = {"Adaptive Practice>/assessment/ui/browse/practice/?referrer=student", "Study Guides>/study-guides/algebra/?referrer=student"};

        String[] interactiveSection = {"PLIX>/plix/arithmetic/", "Physics>interactives.ck12.org/simulations/physics", "Chemistry>interactives.ck12.org/simulations/chemistry"};

        String[] titleArr = new String[0];

        if (headerExplore.isElementPresent()) {
            for (int i = 0; i < exploreHeaders.length; i++) {
                List<WebElement> headers = headerExplore.getWebElements();
                if (headers.get(i).isDisplayed() && headers.get(i).getText().equals(exploreHeaders[i])) {
                    logger.info(headers.get(i).getText() + " is displayed");
                    if (headers.get(i).getText().contains("Reinforce Your Learning")) {
                        titleArr = reinforceSection;
                    } else if (headers.get(i).getText().contains("Learn Interactively")) {
                        titleArr = interactiveSection;
                    }
                    String sections = "xpath" + "_TBD_" + "(//h2[contains(@class,'ExploreProducts')]//parent::div)[" + (i + 1) + "]//a[contains(@class,'ProductContainer__Link')]";
                    GuiControl section = new GuiControl(sections, webDriver);
                    for (int j = 0; j < titleArr.length; j++) {
                        List<WebElement> secTitles = section.getWebElements();
                        if (secTitles.get(j).isDisplayed() && secTitles.get(j).getText().contains(titleArr[j].split(">")[0])) {
                            logger.info(secTitles.get(j).getText() + " is displayed");
                            ((JavascriptExecutor) webDriver).executeScript("arguments[0].scrollIntoView(true);", secTitles.get(j));
                            waitForSec(3);
                            ((JavascriptExecutor) webDriver).executeScript("arguments[0].click();", secTitles.get(j));
                            waitForSec(3);
                            if (webDriver.getCurrentUrl().contains(titleArr[j].split(">")[1])) {
                                reportLog("The Product link is navigated to the correct page");
                            } else {
                                return false;
                            }
                            webDriver.navigate().back();
                            waitForSec(6);
                        } else {
                            logger.info(secTitles.get(j).getText() + " is incorrect");
                            return false;
                        }
                    }
                } else {
                    logger.info(headers.get(i).getText() + " is incorrect");
                }
            }
        }
        return true;
    }

    // This methods verify the Items under the What are you Looking for Today Section on the Subject browse page.
    public boolean verifyDetailsOfSubjectPageUnderWhatAreYouLookingTodaySection() {
        int count = 0;
        reportLog("Verify Books/Items under the FlexLets™...");
        if (sectionFlexLetsStu.isElementPresent() && sectionFlexLetsStu.getText().equals("FlexLets")) {
            List<WebElement> flexLetsSectionBooks = flexLetsBooksStu.getWebElements();
            reportLog("The number of books/Items under the FlexLets: " + flexLetsSectionBooks.size());

            String[] urls = {"pages/flexlets/#math:-Math FlexLets™", "pages/flexlets/#science:-Science FlexLets™"};

            for (WebElement book : flexLetsSectionBooks) {
                if (book.isDisplayed() && book.getText().equals(urls[count].split(":-")[1])) {
                    reportLog("The book/Item is: " + book.getText());
                    if (book.getAttribute("href").contains(urls[count].split(":-")[0])) {
                        reportLog("The book/Item URL " + book.getAttribute("href") + " verified");
                        count++;
                    } else {
                        reportLog("The Book/Item URL is incorrect: " + book.getAttribute("href"));
                        return false;
                    }
                } else {
                    reportLog("The Book/Item is not present or incorrect: " + book.getText());
                    return false;
                }
            }
            count = 0;
        } else {
            reportLog("The section is not present: " + sectionFlexLetsStu.getText());
        }

        reportLog("Verify Books/Items under the Math By Level...");
        if (sectionMathByLevelStu.isElementPresent() && sectionMathByLevelStu.getText().equals("Math by Level")) {
            List<WebElement> mathByLevelSectionBooks = mathByLevelBooksStu.getWebElements();
            reportLog("The number of books/Items under the Math By Level: " + mathByLevelSectionBooks.size());

            String[] urls = {"/elementary-math:-Grade 1 to 5", "/cbook/ck-12-interactive-middle-school-math-6-for-ccss/:-Grade 6", "/cbook/ck-12-interactive-middle-school-math-7-for-ccss:-Grade 7", "/cbook/ck-12-interactive-middle-school-math-8-for-ccss/:-Grade 8",
                    "/cbook/ck-12-interactive-algebra-1-for-ccss/:-Algebra 1", "/cbook/ck-12-interactive-geometry-for-ccss/:-Geometry", "/cbook/ck-12-interactive-algebra-2/:-Algebra 2", "/cbook/ck-12-precalculus-concepts-2.0/:-PreCalculus"};

            for (WebElement book : mathByLevelSectionBooks) {
                if (book.isDisplayed() && book.getText().equals(urls[count].split(":-")[1])) {
                    reportLog("The book/Item is: " + book.getText());
                    if (book.getAttribute("href").contains(urls[count].split(":-")[0])) {
                        reportLog("The book/Item URL " + book.getAttribute("href") + " verified");
                        count++;
                    } else {
                        reportLog("The Book/Item URL is incorrect: " + book.getAttribute("href"));
                        return false;
                    }
                } else {
                    reportLog("The Book/Item is not present or incorrect: " + book.getText());
                    return false;
                }
            }
            count = 0;
        } else {
            reportLog("The section is not present: " + sectionMathByLevelStu.getText());
        }

        reportLog("Verify Books/Items under the Math By Subject...");
        if (sectionMathByLevelSubjectStu.isElementPresent() && sectionMathByLevelSubjectStu.getText().equals("Math by Subject")) {
            List<WebElement> mathBySubjectSectionBooks = mathBySubjectBooksStu.getWebElements();
            reportLog("The number of books/Items under the Math By Subject: " + mathBySubjectSectionBooks.size());

            String[] urls = {"/c/arithmetic:-Arithmetic", "/c/measurement:-Measurement", "/c/algebra:-Algebra", "/c/geometry:-Geometry", "/c/probability:-Probability", "/c/statistics:-Statistics",
                    "/c/trigonometry:-Trigonometry", "/c/analysis:-Analysis", "/c/calculus:-Calculus"};

            for (WebElement book : mathBySubjectSectionBooks) {
                if (book.isDisplayed() && book.getText().equals(urls[count].split(":-")[1])) {
                    reportLog("The book/Item is: " + book.getText());
                    if (book.getAttribute("href").contains(urls[count].split(":-")[0])) {
                        reportLog("The book/Item URL " + book.getAttribute("href") + " verified");
                        count++;
                    } else {
                        reportLog("The Book/Item URL is incorrect: " + book.getAttribute("href"));
                        return false;
                    }
                } else {
                    reportLog("The Book/Item is not present or incorrect: " + book.getText());
                    return false;
                }
            }
            count = 0;
        } else {
            reportLog("The section is not present: " + sectionMathByLevelSubjectStu.getText());
        }

        reportLog("Verify Books/Items under the Science...");
        if (sectionScienceStu.isElementPresent() && sectionScienceStu.getText().equals("Science")) {
            List<WebElement> scienceSectionBooks = scienceBooksStu.getWebElements();
            reportLog("The number of books/Items under the Science: " + scienceSectionBooks.size());

            String[] urls = {"/elementary-science:-Grade K to 5", "/cbook/ck-12-middle-school-earth-science-flexbook-2.0:-Earth Science", "/cbook/ck-12-middle-school-life-science-2.0:-Life Science", "/cbook/ck-12-middle-school-physical-science-flexbook-2.0:-Physical Science",
                    "/cbook/ck-12-biology-flexbook-2.0:-Biology", "/cbook/ck-12-chemistry-flexbook-2.0:-Chemistry", "/cbook/ck-12-physics-flexbook-2.0:-Physics"};

            for (WebElement book : scienceSectionBooks) {
                if (book.isDisplayed() && book.getText().equals(urls[count].split(":-")[1])) {
                    reportLog("The book/Item is: " + book.getText());
                    if (book.getAttribute("href").contains(urls[count].split(":-")[0])) {
                        reportLog("The book/Item URL " + book.getAttribute("href") + " verified");
                        count++;
                    } else {
                        reportLog("The Book/Item URL is incorrect: " + book.getAttribute("href"));
                        return false;
                    }
                } else {
                    reportLog("The Book/Item is not present or incorrect: " + book.getText());
                    return false;
                }
            }
            count = 0;
        } else {
            reportLog("The section is not present: " + sectionScienceStu.getText());
        }

        reportLog("Verify Books/Items under the English...");
        if (sectionEnglishStu.isElementPresent() && sectionEnglishStu.getText().equals("English")) {
            List<WebElement> englishSectionBooks = englishBooksStu.getWebElements();
            reportLog("The number of books/Items under the English: " + englishSectionBooks.size());

            String[] urls = {"/c/writing:-Writing", "/c/spelling:-Spelling"};

            for (WebElement book : englishSectionBooks) {
                if (book.isDisplayed() && book.getText().equals(urls[count].split(":-")[1])) {
                    reportLog("The book/Item is: " + book.getText());
                    if (book.getAttribute("href").contains(urls[count].split(":-")[0])) {
                        reportLog("The book/Item URL " + book.getAttribute("href") + " verified");
                        count++;
                    } else {
                        reportLog("The Book/Item URL is incorrect: " + book.getAttribute("href"));
                        return false;
                    }
                } else {
                    reportLog("The Book/Item is not present or incorrect: " + book.getText());
                    return false;
                }
            }
            count = 0;
        } else {
            reportLog("The section is not present: " + sectionEnglishStu.getText());
        }

        reportLog("Verify Books/Items under the Social Studies...");
        if (sectionSocialStudiesStu.isElementPresent() && sectionSocialStudiesStu.getText().equals("Social Studies")) {
            List<WebElement> socialStudiesSectionBooks = socialStudiesBooksStu.getWebElements();
            reportLog("The number of books/Items under the Social Studies: " + socialStudiesSectionBooks.size());

            String[] urls = {"/cbook/episd-2019-2020-economics-with-emphasis-on-the-free-enterprise-system:-Economics", "/cbook/episd-world-geo-2019:-Geography", "/cbook/episd-united-states-government-2019-2020:-Government", "/fbbrowse/list/?Subject=History:-History",
                    "/cbook/world-history-studies_episd:-World History", "/cbook/episd-philosophy:-Philosophy", "/cbook/episd-sociology:-Sociology"};

            for (WebElement book : socialStudiesSectionBooks) {
                if (book.isDisplayed() && book.getText().equals(urls[count].split(":-")[1])) {
                    reportLog("The book/Item is: " + book.getText());
                    if (book.getAttribute("href").contains(urls[count].split(":-")[0])) {
                        reportLog("The book/Item URL " + book.getAttribute("href") + " verified");
                        count++;
                    } else {
                        reportLog("The Book/Item URL is incorrect: " + book.getAttribute("href"));
                        return false;
                    }
                } else {
                    reportLog("The Book/Item is not present or incorrect: " + book.getText());
                    return false;
                }
            }
            count = 0;
        } else {
            reportLog("The section is not present: " + sectionSocialStudiesStu.getText());
        }

        reportLog("Verify Books/Items under the More...");
        if (sectionMoreStu.isElementPresent() && sectionMoreStu.getText().equals("More")) {
            List<WebElement> moreSectionBooks = moreBooksStu.getWebElements();
            reportLog("The number of books/Items under the More: " + moreSectionBooks.size());

            String[] urls = {"/c/astronomy:-Astronomy", "/c/engineering:-Engineering", "/c/health:-Health", "&Subject=Photography:-Photography", "/c/technology:-Technology"};

            for (WebElement book : moreSectionBooks) {
                if (book.isDisplayed() && book.getText().equals(urls[count].split(":-")[1])) {
                    reportLog("The book/Item is: " + book.getText());
                    if (book.getAttribute("href").contains(urls[count].split(":-")[0])) {
                        reportLog("The book/Item URL " + book.getAttribute("href") + " verified");
                        count++;
                    } else {
                        reportLog("The Book/Item URL is incorrect: " + book.getAttribute("href"));
                        return false;
                    }
                } else {
                    reportLog("The Book/Item is not present or incorrect: " + book.getText());
                    return false;
                }
            }
            count = 0;
        } else {
            reportLog("The section is not present: " + sectionMoreStu.getText());
        }

        reportLog("Verify Books/Items under the College...");
        if (sectionCollageStu.isElementPresent() && sectionCollageStu.getText().equals("College")) {
            List<WebElement> moreSectionBooks = collageBooksStu.getWebElements();
            reportLog("The number of books/Items under the College: " + moreSectionBooks.size());

            String[] urls = {"/cbook/CK-12-Elementary-Intermediate-College-Algebra:-College Algebra", "/cbook/CK-12-College-Precalculus:-College Precalculus", "/cbook/advanced-mathematics-flexbook:-Linear Algebra",
                    "/cbook/CK-12-College-Human-Biology-FlexBook-2.0:-College Human Biology", "/cbook/origins-and-the-search-for-life-in-the-universe:-The Universe"};

            for (WebElement book : moreSectionBooks) {
                if (book.isDisplayed() && book.getText().equals(urls[count].split(":-")[1])) {
                    reportLog("The book/Item is: " + book.getText());
                    if (book.getAttribute("href").contains(urls[count].split(":-")[0])) {
                        reportLog("The book/Item URL " + book.getAttribute("href") + " verified");
                        count++;
                    } else {
                        reportLog("The Book/Item URL is incorrect: " + book.getAttribute("href"));
                        return false;
                    }
                } else {
                    reportLog("The Book/Item is not present or incorrect: " + book.getText());
                    return false;
                }
            }
            count = 0;
        } else {
            reportLog("The section is not present: " + sectionCollageStu.getText());
        }

        reportLog("Verify Books/Items under the Adult Education...");
        if (sectionAdultStu.isElementPresent() && sectionAdultStu.getText().equals("Adult Education")) {
            List<WebElement> adultSectionBooks = adultBooksStu.getWebElements();
            reportLog("The number of books/Items under the Adult Education: " + adultSectionBooks.size());

            String[] urls = {"/pages/adult-education/#adult-basic-education:-Basic Education", "/pages/adult-education/#high-school-diploma:-High School Diploma", "/pages/adult-education/#high-school-equivalency:-High School Equivalency", "/pages/adult-education/#career-technical-education:-Career Technical Ed", "/pages/adult-education/#ESL:-English as 2nd Language"};

            for (WebElement book : adultSectionBooks) {
                if (book.isDisplayed() && book.getText().equals(urls[count].split(":-")[1])) {
                    reportLog("The book/Item is: " + book.getText());
                    if (book.getAttribute("href").contains(urls[count].split(":-")[0])) {
                        reportLog("The book/Item URL " + book.getAttribute("href") + " verified");
                        count++;
                    } else {
                        reportLog("The Book/Item URL is incorrect: " + book.getAttribute("href"));
                        return false;
                    }
                } else {
                    reportLog("The Book/Item is not present or incorrect: " + book.getText());
                    return false;
                }
            }
            count = 0;
        } else {
            reportLog("The section is not present: " + sectionAdultStu.getText());
        }

        reportLog("Verify Books/Items under the Translations...");
        if (sectionTranslationsStu.isElementPresent() && sectionTranslationsStu.getText().equals("Translations")) {
            List<WebElement> translationSectionBooks = translationBooksStu.getWebElements();
            reportLog("The number of books/Items under the Translations: " + translationSectionBooks.size());

            String[] urls = {"?Language=Spanish:-Spanish", "/simulations/physics.html?lang=ko:-Korean", "/simulations/physics.html?lang=de:-Deutsch",
                    "/simulations/physics.html?lang=zh-TW:-Chinese", "/simulations/physics.html?lang=EL:-Greek", "/simulations/physics.html?lang=pl:-Polski"};

            for (WebElement book : translationSectionBooks) {
                if (book.isDisplayed() && book.getText().equals(urls[count].split(":-")[1])) {
                    reportLog("The book/Item is: " + book.getText());
                    if (book.getAttribute("href").contains(urls[count].split(":-")[0])) {
                        reportLog("The book/Item URL " + book.getAttribute("href") + " verified");
                        count++;
                    } else {
                        reportLog("The Book/Item URL is incorrect: " + book.getAttribute("href"));
                        return false;
                    }
                } else {
                    reportLog("The Book/Item is not present or incorrect: " + book.getText());
                    return false;
                }
            }
            count = 0;
        } else {
            reportLog("The section is not present: " + sectionTranslationsStu.getText());
        }


        reportLog("Verify Books/Items under the Country...");
        if (sectionCountryStu.isElementPresent() && sectionCountryStu.getText().equals("Country")) {
            List<WebElement> translationSectionBooks = countryBooksStu.getWebElements();
            reportLog("The number of books/Items under the Country: " + translationSectionBooks.size());

            String[] urls = {"/chile:-Chile", "/brasil:-Brasil", "/cbse:-India", "/georgia:-Georgia"};

            for (WebElement book : translationSectionBooks) {
                if (book.isDisplayed() && book.getText().equals(urls[count].split(":-")[1])) {
                    reportLog("The book/Item is: " + book.getText());
                    if (book.getAttribute("href").contains(urls[count].split(":-")[0])) {
                        reportLog("The book/Item URL " + book.getAttribute("href") + " verified");
                        count++;
                    } else {
                        reportLog("The Book/Item URL is incorrect: " + book.getAttribute("href"));
                        return false;
                    }
                } else {
                    reportLog("The Book/Item is not present or incorrect: " + book.getText());
                    return false;
                }
            }
        } else {
            reportLog("The section is not present: " + sectionCountryStu.getText());
        }
        return true;
    }

    // This methods verify the Math section on the teacher FB2.0 landing page
    public boolean verifyMathSectionOnTeacherFBLandingPage() {
        mathSection.scrollIntoView();
        if (mathSection.isElementPresent()) {
            if (mathSection.getText().equals("Math")) {
                reportLog("Verify the Math section on the Teacher FB2.0 landing page.");
                return true;
            }
        }
        return false;
    }

    // This methods verify the Items under the Math section on the teacher FB2.0 landing page
    public boolean verifyBooksUnderMathSection() {
        List<WebElement> mathSectionBooks = mathBooks.getWebElements();
        reportLog("The list of Books/Items under the math section are:" + mathSectionBooks.size());

        for (WebElement mathBooks : mathSectionBooks) {
            if (mathBooks.isDisplayed()) {
                reportLog("The book name is: " + mathBooks.getText());
                reportLog("The book URL is: " + mathBooks.getAttribute("href"));
                return true;
            }
        }
        return false;
    }

    // This methods verify the Science section on the teacher FB2.0 landing page
    public boolean verifyScienceSectionOnTeacherFBLandingPage() {
        scienceSection.scrollIntoView();
        if (scienceSection.isElementPresent()) {
            if (scienceSection.getText().equals("Science")) {
                reportLog("Verify the Science section on the Teacher FB2.0 landing page.");
                return true;
            }
        }
        return false;
    }

    // This methods verify the Items under the Science section on the teacher FB2.0 landing page
    public boolean verifyBooksUnderScienceSection() {
        List<WebElement> scienceSectionBooks = scienceBook.getWebElements();
        reportLog("The list of Books/Items under the Science section are:" + scienceSectionBooks.size());

        for (WebElement scienceBooks : scienceSectionBooks) {
            if (scienceBooks.isDisplayed()) {
                reportLog("The book name is: " + scienceBooks.getText());
                reportLog("The book URL is: " + scienceBooks.getAttribute("href"));
                return true;
            }
        }
        return false;
    }

    // This methods verify the Social Studies section on the teacher FB2.0 landing page
    public boolean verifySocialStudiesSectionOnTeacherFBLandingPage() {
        socialStudiesSection.scrollIntoView();
        if (socialStudiesSection.isElementPresent()) {
            if (socialStudiesSection.getText().equals("Social Studies")) {
                reportLog("Verify the Social Studies section on the Teacher FB2.0 landing page.");
                return true;
            }
        }
        return false;
    }

    // This methods verify the Items under the Social Studies section on the teacher FB2.0 landing page
    public boolean verifyBooksUnderSocialStudiesSection() {
        List<WebElement> socialStudiesSectionBooks = socialStudiesBook.getWebElements();
        reportLog("The list of Books/Items under the Social Studies section are:" + socialStudiesSectionBooks.size());

        for (WebElement socialStudiesBooks : socialStudiesSectionBooks) {
            if (socialStudiesBooks.isDisplayed()) {
                reportLog("The book name is: " + socialStudiesBooks.getText());
                reportLog("The book URL is: " + socialStudiesBooks.getAttribute("href"));
                return true;
            }
        }
        return false;
    }

    // This methods verify the Translation section on the teacher FB2.0 landing page
    public boolean verifyTranslationSectionOnTeacherFBLandingPage() {
        translationSection.scrollIntoView();
        if (translationSection.isElementPresent()) {
            if (translationSection.getText().equals("Translations")) {
                reportLog("Verify the Social Translations on the Teacher FB2.0 landing page.");
                return true;
            }
        }
        return false;
    }

    // This methods verify the Items under the Translation section on the teacher FB2.0 landing page
    public boolean verifyBooksUnderTranslationSection() {
        List<WebElement> translationSectionBooks = translationBook.getWebElements();
        reportLog("The list of Books/Items under the Translation section are:" + translationSectionBooks.size());

        for (WebElement translationBooks : translationSectionBooks) {
            if (translationBooks.isDisplayed()) {
                reportLog("The book name is: " + translationBooks.getText());
                reportLog("The book URL is: " + translationBooks.getAttribute("href"));
                return true;
            }
        }
        return false;
    }

    public boolean verifyStatusCodeIsCorrect(String bookURL, String book){
        try {
            URL url = new URL(bookURL);
            HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
            httpURLConnection.setRequestMethod("GET");
            httpURLConnection.connect();

            int statusCode = httpURLConnection.getResponseCode();
            reportLog("The Status code of " + book + " hyper tag for the URL : " + bookURL + "is : " + statusCode);

            if (statusCode >= 200 && statusCode < 400) {
                reportLog("The URL is working : " + bookURL);
                return true;
            } else {
                reportLog("The URL is broken : " + bookURL);
                return false;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return false;
    }


    public boolean verifyStudentTutorPresent(){
        if (studentTutor.isElementPresent()){
            reportLog("Student Tutor is present");
            return true;
        }
        return false;
    }

    public boolean verifyHTagsInTutorConsentPage() {
        String h3Tag = hTagsLocator + "3//strong";
        GuiControl h3TagLocator = new GuiControl(h3Tag, webDriver);
        if (h3TagLocator.isDisplayed() && h3TagLocator.getText().contains("Please read this disclosure carefully before clicking the “Submit” button below.")){
            reportLog("h3 Tag is displayed and verified");
        } else {
            logger.info("Tag h3 is not displayed");
            return false;
        }

        int i = 0;
        String[] h4TagText = {"About the Beta Test of the AI Program", "There is no fee for your child or student to participate in the AI tutoring program.",
                "Data Collection and Use", "Audio and video functionality will be disabled during the tutoring session."};
        String h4Tag = hTagsLocator + "4";
        GuiControl h4TagLocator = new GuiControl(h4Tag, webDriver);
        List<WebElement> h4TagElements = h4TagLocator.getWebElements();
        if (!h4TagElements.isEmpty()) {
            for (WebElement hElement : h4TagElements) {
                if (hElement.isDisplayed() && hElement.getText().contains(h4TagText[i])) {
                    logger.info("Verified h tag is displayed");
                    logger.info("Following Tag Text is " + hElement.getText());
                } else {
                    logger.info("Following Tag text is not displayed");
                    return false;
                }
                i++;
            }
        } else {
            logger.info("Tag h4 is not displayed");
            return false;
        }

        return true;
    }

    public boolean verifyPrivacyPolicyLink(){
        if (tutorConsentPrivacyPolicy.isDisplayed() && tutorConsentPrivacyPolicy.getAttribute("href").contains("https://www.ck12info.org/privacy-policy/")){
            reportLog("Privacy Policy link present on page");
            tutorConsentPrivacyPolicy.click();
            String parent = switchToChildWindow();
            if (webDriver.getCurrentUrl().contains("https://www.ck12info.org/privacy-policy/")){
                reportLog("Privacy Policy Link redirected to new with correct URL");
                webDriver.switchTo().window(parent);
            } else {
                reportLog("Privacy policy link redirected to incorrect page");
                return false;
            }
        } else {
            reportLog("Privacy Policy link not present on page or link attribute is incorrect");
            return false;
        }
        return true;
    }

    public boolean verifyAITutorMail(){
        if (tutorConsentAITutorMail.isDisplayed()) {
            reportLog("mail to ai tutor link is present on Tutor Consent Page");
            return true;
        }
        return false;
    }

    public boolean verifyHTagsInFlexletsPage() {
        String h1Tag = hTagsLocator + "1//span//strong";
        GuiControl h1TagLocator = new GuiControl(h1Tag, webDriver);
        if (h1TagLocator.isDisplayed() && h1TagLocator.getText().contains("FlexLets™")){
            reportLog("h1 Tag is displayed and verified");
        } else {
            logger.info("Tag h1 is not displayed");
            return false;
        }

        String h2Tag = hTagsLocator + "2";
        GuiControl h2TagLocator = new GuiControl(h2Tag, webDriver);
        if (h2TagLocator.isDisplayed() && h2TagLocator.getText().contains("FlexLets™")){
            reportLog("h2 Tag is displayed and verified");
        } else {
            logger.info("Tag h2 is not displayed");
            return false;
        }

        String[] h3TagText = {"MATH", "SCIENCE"};
        String h3Tag = hTagsLocator + "3";
        GuiControl h3TagLocator = new GuiControl(h3Tag, webDriver);
        List<WebElement> h3TagElements = h3TagLocator.getWebElements();
        if (!h3TagElements.isEmpty()) {
            for (int i = 0; i < h3TagText.length; i++) {
                if (h3TagElements.get(i).isDisplayed() && h3TagElements.get(i).getText().contains(h3TagText[i])) {
                    reportLog("Verified h tag is displayed");
                    reportLog("Following Tag Text is " + h3TagElements.get(i).getText());
                } else {
                    reportLog("Following Tag text is not displayed");
                    return false;
                }
                i++;
            }
        } else {
            reportLog("Tag h3 is not displayed");
            return false;
        }

        return true;
    }

    public boolean verifyFlexbookSectionOnFlexletPage(){
       String[] flexlets = {"6th Grade Math Essentials", "7th Grade Math Essentials", "8th Grade Math Essentials", "Algebra I Essentials",
               "Geometry Essentials", "Algebra II Essentials", "Earth Science Essentials", "Life Science Essentials", "Physical Science Essentials",
               "Biology Essentials", "Chemistry Essentials", "Physics Essentials"};


       List<WebElement> totalFlexlets = flexletsOnFlexletPage.getWebElements();
       if (!totalFlexlets.isEmpty()) {
           for (int i = 0; i < flexlets.length; i++) {
               if (totalFlexlets.get(i).isDisplayed() && totalFlexlets.get(i).getText().equals(flexlets[i])){
                   reportLog(totalFlexlets.get(i).getText() + " is displayed");
                   verifyStatusCodeIsCorrect(totalFlexlets.get(i).getAttribute("href"), totalFlexlets.get(i).getText());

               } else {
                   reportLog("flexlet is not displayed or new flexlet added/removed in flexlet page");
                   return false;
               }
           }
       } else {
           reportLog("Flexlets are not present");
           return false;
       }
        return true;
    }

    public boolean verifyHTagsInSlabPage() {
        String h1Tag = hTagsLocator + "1";
        GuiControl h1TagLocator = new GuiControl(h1Tag, webDriver);

        String[] h1Headers = {"We are the SLAB team from CK-12.", "Our Mission", "Our Story", "Why SLAB?", "Past Webinars", "Blog Posts"};

        int i = 0;
        List<WebElement> h1TagElements = h1TagLocator.getWebElements();
        if (!h1TagElements.isEmpty()) {
            for (WebElement hElement : h1TagElements) {
                if (hElement.isDisplayed() && hElement.getText()!=null) {
                    if (hElement.getText().equals(h1Headers[i])){
                        logger.info(hElement.getText() + " is present and correct");
                        if (hElement.getText().equals("Our Mission")){
                            ourMissionSlabPage.isDisplayed();
                            logger.info("Our Mission is present and verified");
                        }
                        i++;
                    }
                }
            }
        } else {
            logger.info("Tag h1 is not displayed");
            return false;
        }

        return true;
    }

    public boolean verifySlabMembersSlabPage(){
        String[] currentMembersName = {"Sean Nguyen", "Adriana Amatriain", "Vansh Sharma", "Raina Kakani"};

        int i = 0;
        Actions actions = new Actions(webDriver);
        if (slabMemberToggleUpSlabPage.isDisplayed() && slabMemberToggleUpSlabPage.getText().equals("Current Members")){
            logger.info("Initially Slab Member are set to Current Members");
            List<WebElement> currentMembers = slabMembersSlabPage.getWebElements();
            for (WebElement member : currentMembers){
                if (member.getText().contains(currentMembersName[i])){
                    logger.info(member.getText() + " is present and displayed correctly");
                } else {
                    logger.info("Current Member is not displayed or Member is changed");
                    return false;
                }
                actions.moveToElement(member).build().perform();
                i++;
            }
            actions.moveToElement(slabMemberToggleUpSlabPage.getWebElement()).click().build().perform();
            waitForSec(2);
            slabMemberToggleDownSlabPage.isEnable();
            slabMemberToggleDownSlabPage.click();
            if (slabMemberToggleUpSlabPage.getText().equals("Ex-SLAB Members")){
                reportLog("Switched to Ex-SLAB Members");
            }
        }
        return true;
    }

    public boolean verifyWhySlab(){
        String[] slabTitles = {"#StudentsSpeak Webinar", "Reviewed over 1k Flexbooks®", "CK-12 Product Development"};
        int i = 0;
        List<WebElement> titles = whySlabTitles.getWebElements();
        for (WebElement title : titles){
            logger.info(title.getText());
            if (title.getText().contains(slabTitles[i])){
                logger.info(title.getText() + " is present and displayed correctly");
            } else {
                logger.info("Slab Title is not displayed or changed");
            }
            i++;
        }
        return true;
    }

    public boolean verifyPageTitle(String page){
        String h1Tag = hTagsLocator + "1";
        GuiControl h1TagLocator = new GuiControl(h1Tag, webDriver);
        if (page.equals("overview")) {
            if (h1TagLocator.isDisplayed() && h1TagLocator.getText().contains("Overview of CK-12 Resources")) {
                reportLog("Overview Header is displayed and verified");
                return true;
            } else {
                logger.info("Tag h1 is not displayed");
            }
        } else if (page.equals("top concepts")){
            if (h1TagLocator.isDisplayed() && h1TagLocator.getText().contains("Top Concepts for the Month")) {
                reportLog("Top Concept Header is displayed and verified");
                return true;
            } else {
                logger.info("Tag h1 is not displayed");
            }
        }
        return false;
    }

    public boolean verifyOverviewContent(){
        String[] overviewTitles = {"FlexBook® 2.0 Platform", "Concept-Based Learning", "Adaptive  Practice", "Interactives", "Assignments", "CK-12 Cafe Forums", "LMS Integration"};
        for (int i = 0; i < overviewTitles.length; i++){
            GuiControl overviewContentHeader = new GuiControl("xpath_TBD_" + "(//div[@class='accordion-title'])[" + (i+1) + "]//h2", webDriver);
            if (overviewContentHeader.isDisplayed() && overviewContentHeader.getText().equals(overviewTitles[i])){
                logger.info(overviewContentHeader.getText() + " is displayed and verified");
            }
            GuiControl overviewContentExpand = new GuiControl("xpath_TBD_" + "(//div[@class='accordion-title'])[" + (i+1) + "]//div[@class='expan-plus']", webDriver);
            GuiControl overviewContentBrowseOpt = new GuiControl("xpath_TBD_" + "(//div[@class='accordion-content'])[" + (i+1) + "]//a[contains(@class,'button-teal-primary')]", webDriver);
            if (overviewContentExpand.isDisplayed()){
                logger.info("Expand button is displayed for " + overviewContentHeader.getText());
                overviewContentExpand.clickJScript();
                waitForSec(3);
                if (overviewContentBrowseOpt.isDisplayed()){
                    logger.info("Browse option available for " + overviewContentHeader.getText());
                } else {
                    logger.info("Browse option not available");
                    return false;
                }
            }
        }
        return true;
    }

    public boolean verifyCoursesSectionTopConceptPage(){
        String[] bookTitles = {"Scaling Shrinking Rectangle", "Volume of Prisms", "Unit Conversion", "Pictures of Part-Part-Whole Ratios", "Adding and Subtracting Decimals with Diagrams", "Using Greatest Common Factor",
                "Area of Quadrilaterals", "Multiplying Decimals with the Standard Method", "Dividing Decimals in Diagrams", "Positives and Negatives", "Area of Triangles", "The Four Quadrants", "Area of Polygons",
                "Shapes in the Coordinate Plane", "Introducing Percentages", "Polyhedra", "Expressions with Exponents", "Constant Speed Unit Rate", "Scaling Shrinking Rectangle", "Histograms", "Equivalent Ratio Equations",
                "Expressions with Variables", "Letters Stand for Numbers", "Order of Operations", "Points on the Coordinate Plane"};

        String[] courseOptionLinks = {"Math Grade 6>https://flexbooks.ck12.org/cbook/ck-12-interactive-middle-school-math-6-for-ccss/", "Math Grade 7>https://flexbooks.ck12.org/cbook/ck-12-interactive-middle-school-math-7-for-ccss/",
                "Math Grade 8>https://flexbooks.ck12.org/cbook/ck-12-interactive-middle-school-math-8-for-ccss/", "Algebra 1>https://flexbooks.ck12.org/cbook/ck-12-interactive-algebra-1-for-ccss/",
                "Geometry>https://flexbooks.ck12.org/cbook/ck-12-interactive-geometry-for-ccss/", "Precalculus>https://flexbooks.ck12.org/cbook/ck-12-precalculus-concepts-2.0/", "Earth Science>https://flexbooks.ck12.org/cbook/ck-12-middle-school-earth-science-flexbook-2.0/",
                "Life Science>https://flexbooks.ck12.org/cbook/ck-12-middle-school-life-science-2.0/", "Physical Science>https://flexbooks.ck12.org/cbook/ck-12-middle-school-physical-science-flexbook-2.0/",
                "Biology>https://flexbooks.ck12.org/cbook/ck-12-biology-flexbook-2.0/", "Chemistry>https://flexbooks.ck12.org/cbook/ck-12-chemistry-flexbook-2.0/", "Physics>https://flexbooks.ck12.org/cbook/ck-12-physics-flexbook-2.0/"};
        for (int i = 0; i < bookTitles.length; i++) {
            GuiControl bookHead = new GuiControl("xpath_TBD_" + "(//div[@data-dx-desc='TopConcepts_ItemTitleClick'])[" + (i + 1) + "]//a", webDriver);
            if (bookHead.isDisplayed() && bookHead.getText().equals(bookTitles[i])){
                reportLog(bookHead.getText() + " is displayed and verified");
                verifyStatusCodeIsCorrect(bookHead.getAttribute("href"), bookHead.getText());
            } else {
                logger.info("Book is not displayed or updated");
                return false;
            }
            GuiControl assignToClass = new GuiControl("xpath_TBD_" + "(//div[@data-dx-assignment-platform='CK-12'])[" + (i + 1) + "]", webDriver);
            GuiControl assignToGC = new GuiControl("xpath_TBD_" + "(//div[@data-dx-assignment-platform='GoogleClassroom'])[" + (i + 1) + "]", webDriver);
            GuiControl copyBookLink = new GuiControl("xpath_TBD_" + "(//div[@data-dx-desc='TopConcepts_URLCopy'])[" + (i + 1) + "]", webDriver);
            if (assignToClass.isDisplayed()){
                logger.info("Assign to class is available for " + bookHead.getText());
            } else {
                logger.info("Assign to class is missing for " + bookHead.getText());
                return false;
            }

            if (assignToGC.isDisplayed()){
                logger.info("Assign to Google Classroom is available for " + bookHead.getText());
                assignToGC.click();
                waitForSec(3);
                if (assignToGCPopup.isDisplayed()){
                    logger.info("Connect to Google Classroom popup is visible");
                    dismissAssignToGCPopup.clickJScript();
                    waitForSec(2);
                }
            } else {
                logger.info("Assign to Google Classroom is missing for " + bookHead.getText());
                return false;
            }

            if (copyBookLink.isDisplayed()){
                logger.info("Copy the Link of Book is available for " + bookHead.getText());
                copyBookLink.click();
                waitForSec(1);
                if (copyBookLink.getText().equals("Link Copied!")){
                    logger.info("Link Copied");
                    waitForSec(2);
                } else {
                    logger.info("link is not getting copied");
                }
            } else {
                logger.info("Assign to Google Classroom is missing for " + bookHead.getText());
                return false;
            }
        }

        List<WebElement> Courses = courseOptions.getWebElements();
        for (int i = 0; i< Courses.size(); i++){
            if (Courses.get(i).isDisplayed() && Courses.get(i).getText().equals(courseOptionLinks[i].split(">")[0])){
                logger.info(Courses.get(i).getText() + " is Displayed and verified");
                waitForSec(2);
                if (exploreCourseLink.getAttribute("href").equals(courseOptionLinks[i].split(">")[1])){
                    logger.info("Flexbook Link is verified");
                    verifyStatusCodeIsCorrect(exploreCourseLink.getAttribute("href"), Courses.get(i).getText());
                } else {
                    logger.info("Correct link not present");
                }
            } else {
                logger.info("Course Option not displayed");
                return false;
            }
        }
        return true;
    }


    public void dismissXmasPopup(){
        waitForSec(2);
        if (xmasPopupClose.isElementPresent()) {
            xmasPopupClose.click();
        }
    }

    public boolean verifyAdultPageHeaderDetails(){
        waitForSec(3);
        if (adultPageTitle.isDisplayed() && adultPageTitle.getText().equals("Adult Education")){
            reportLog("Adult page Title is verified");
            if (browseAdultFBButton.isElementPresent() && browseAdultFBButton.isEnable()){
                reportLog("Button for browsing adult education flexbooks is present and enabled");
                webDriver.switchTo().frame(adultEduVideoIframe.getWebElement());
                waitForSec(2);
                webDriver.switchTo().frame("player");
                if (adultEduYoutubeVideo.isDisplayed()){
                    reportLog("Adult Education youtube Video is present in Header");
                    webDriver.switchTo().defaultContent();
                    return true;
                }
            }
        }
        return false;
    }

    public boolean verifyAdultEducationFlexbookSection(){
        String[] fbSectionTitles = {"Adult Basic Education (ABE)", "Adult Secondary Education (ASE) - High School Diploma", "Adult Secondary Education (ASE) - High School Equivalency",
                "Career Technical Education (CTE)", "English as a Second Language (ESL)"};

        String[] urlsABESection = {"https://flexbooks.ck12.org/user:b3rhbi5wyxj0bmvyqgnrmtiub3jn/cbook/foundational-math-for-adult-basic-learners/>Foundational Math for Adult Basic Education",
                "https://flexbooks.ck12.org/user:b3rhbi5wyxj0bmvyqgnrmtiub3jn/cbook/mathematics-for-adult-basic-education/>Mathematics for Adult Basic Education",
                "https://flexbooks.ck12.org/user:b3rhbi5wyxj0bmvyqgnrmtiub3jn/cbook/interactive-mathematics-for-adult-basic-education/>Interactive Mathematics for Adult Basic Education",
                "https://flexbooks.ck12.org/user:b3rhbi5wyxj0bmvyqgnrmtiub3jn/cbook/pre-algebra-for-adult-basic-education/>Pre-Algebra for Adult Basic Education"};

        String[] urlsASEEquivalencySection = {"https://flexbooks.ck12.org/user:b3rhbi5wyxj0bmvyqgnrmtiub3jn/cbook/foundational-math-for-high-school-equivalency/>Foundational Math for High School Equivalency",
                "https://flexbooks.ck12.org/user:b3rhbi5wyxj0bmvyqgnrmtiub3jn/cbook/algebra-basics-for-the-high-school-equivalency/>Algebra Basics for High School Equivalency",
                "https://flexbooks.ck12.org/user:b3rhbi5wyxj0bmvyqgnrmtiub3jn/cbook/geometry-for-high-school-equivalency/>Geometry for High School Equivalency",
                "https://flexbooks.ck12.org/user:b3rhbi5wyxj0bmvyqgnrmtiub3jn/cbook/data-statistics-probability-for-high-school-equivalency/>Data, Statistics & Probability for High School Equivalency",
                "https://flexbooks.ck12.org/user:b3rhbi5wyxj0bmvyqgnrmtiub3jn/cbook/algebra-for-high-school-equivalency/>Algebra for High School Equivalency",
                "https://flexbooks.ck12.org/user:b3rhbi5wyxj0bmvyqgnrmtiub3jn/cbook/mathematics-companion-for-high-school-equivalency/>Mathematics Companion for High School Equivalency",
                "https://flexbooks.ck12.org/user:b3rhbi5wyxj0bmvyqgnrmtiub3jn/cbook/science-for-high-school-equivalency/>Science for High School Equivalency",
                "https://flexbooks.ck12.org/user:b3rhbi5wyxj0bmvyqgnrmtiub3jn/cbook/science-companion-for-high-school-equivalency/>Science Companion for High School Equivalency"};

        String[] urlsASEDiplomaSection = {"https://flexbooks.ck12.org/user:b3rhbi5wyxj0bmvyqgnrmtiub3jn/cbook/us-history-for-high-school-diploma/>US History for High School Diploma",
                "https://flexbooks.ck12.org/user:b3rhbi5wyxj0bmvyqgnrmtiub3jn/cbook/us-government-for-high-school-diploma/>US Government for High School Diploma",
                "https://flexbooks.ck12.org/user:b3rhbi5wyxj0bmvyqgnrmtiub3jn/cbook/economics-for-high-school-diploma/>Economics for High School Diploma",
                "https://flexbooks.ck12.org/user:b3rhbi5wyxj0bmvyqgnrmtiub3jn/cbook/biology-for-high-school-diploma/>Biology for High School Diploma",
                "https://flexbooks.ck12.org/user:b3rhbi5wyxj0bmvyqgnrmtiub3jn/cbook/chemistry-for-high-school-diploma/>Chemistry for High School Diploma",
                "https://flexbooks.ck12.org/user:b3rhbi5wyxj0bmvyqgnrmtiub3jn/cbook/physics-for-high-school-diploma/>Physics for High School Diploma",
                "https://flexbooks.ck12.org/user:b3rhbi5wyxj0bmvyqgnrmtiub3jn/cbook/pre-algebra-for-high-school-diploma/>Pre-Algebra for High School Diploma",
                "https://flexbooks.ck12.org/user:b3rhbi5wyxj0bmvyqgnrmtiub3jn/cbook/algebra-1-for-high-school-diploma/>Algebra 1 for High School Diploma"};

        String[] urlsCTESection = {"https://flexbooks.ck12.org/user:zgviymllamvuc2vumjawmebob3rtywlslmnvbq../cbook/bpace-topics>Career and Technical Education Topics",
                "https://flexbooks.ck12.org/user:yxjtawxszxjab3jlz29uy2hhcnrlci5vcmc./cbook/anatomy-physiology/>Anatomy and Physiology",
                "https://flexbooks.ck12.org/user:zgviymllamvuc2vumjawmebob3rtywlslmnvbq../cbook/ck-12-college-human-biology/>CTE: Health Science",
                "https://flexbooks.ck12.org/user:zgviymllamvuc2vumjawmebob3rtywlslmnvbq../cbook/cosmetology/>CTE Cosmetology"};

        String[] urlsESLSection = {"https://flexbooks.ck12.org/user:c3vzyw5nywvyqgdtywlslmnvbq../cbook/employment-safety-for-esl-students/>Employment Safety for ESL Students",
                "https://www.ck12.org/my/na/Safety-Equipment-1-12487886/lesson/user:c3vzyw5nywvyqgdtywlslmnvbq../Safety-Equipment/>ESL BEG Safety Equipment"};

        List<WebElement> flexbookTitles = adultEduFBSectionTitles.getWebElements();
        for (int i = 0; i<flexbookTitles.size(); i++){
            if (flexbookTitles.get(i).isDisplayed() && flexbookTitles.get(i).getText().equals(fbSectionTitles[i])){
                reportLog("Flexbook Section with Title Head: " + flexbookTitles.get(i).getText() + " is present and verified");
            }
        }

        for (int i = 0; i < urlsABESection.length; i++){
            List<WebElement> links = adultBasicEduFB.getWebElements();
            ((JavascriptExecutor) webDriver).executeScript("arguments[0].scrollIntoView(true);", links.get(i));
            if (links.get(i).isDisplayed()){
                String bookName = links.get(i).getText();
                if (bookName.contains(urlsABESection[i].split(">")[1])){
                    reportLog(bookName + " is displayed and verified");
                } else {
                    reportLog("Book is not displayed");
                    return false;
                }
                verifyStatusCodeIsCorrect(links.get(i).getAttribute("href"), bookName);
                links.get(i).click();
                waitForSec(6);
                if (webDriver.getCurrentUrl().contains(urlsABESection[i].split(">")[0])) {
                    reportLog("The Book " + bookName + " link is navigated to the correct page");
                } else {
                    reportLog("The Book " + bookName + " link is navigated to the incorrect page");
                    return false;
                }
                webDriver.navigate().back();
            } else {
                System.out.println("Link not displayed");
                return false;
            }
        }
        ((JavascriptExecutor) webDriver).executeScript("window.scrollBy(0,300)");

        for (int i = 0; i < urlsASEDiplomaSection.length; i++){
            List<WebElement> links = adultHighSchoolDipFB.getWebElements();
            ((JavascriptExecutor) webDriver).executeScript("arguments[0].scrollIntoView(true);", links.get(i));
            if (links.get(i).isDisplayed()){
                String bookName = links.get(i).getText();
                if (bookName.contains(urlsASEDiplomaSection[i].split(">")[1])){
                    reportLog(bookName + " is displayed and verified");
                } else {
                    reportLog("Book is not displayed");
                    return false;
                }
                verifyStatusCodeIsCorrect(links.get(i).getAttribute("href"), bookName);
                links.get(i).click();
                waitForSec(6);
                if (webDriver.getCurrentUrl().contains(urlsASEDiplomaSection[i].split(">")[0])) {
                    reportLog("The Book " + bookName + " link is navigated to the correct page");
                } else {
                    reportLog("The Book " + bookName + " link is navigated to the incorrect page");
                    return false;
                }
                webDriver.navigate().back();
            } else {
                System.out.println("Link not displayed");
                return false;
            }
        }
        ((JavascriptExecutor) webDriver).executeScript("window.scrollBy(0,300)");

        for (int i = 0; i < urlsASEEquivalencySection.length; i++){
            List<WebElement> links = adultHighSchoolEquiFB.getWebElements();
            ((JavascriptExecutor) webDriver).executeScript("arguments[0].scrollIntoView(true);", links.get(i));
            if (links.get(i).isDisplayed()){
                String bookName = links.get(i).getText();
                if (bookName.contains(urlsASEEquivalencySection[i].split(">")[1])){
                    reportLog(bookName + " is displayed and verified");
                } else {
                    reportLog("Book is not displayed");
                    return false;
                }
                verifyStatusCodeIsCorrect(links.get(i).getAttribute("href"), bookName);
                links.get(i).click();
                waitForSec(6);
                if (webDriver.getCurrentUrl().contains(urlsASEEquivalencySection[i].split(">")[0])) {
                    reportLog("The Book " + bookName + " link is navigated to the correct page");
                } else {
                    reportLog("The Book " + bookName + " link is navigated to the incorrect page");
                    return false;
                }
                webDriver.navigate().back();
            } else {
                System.out.println("Link not displayed");
                return false;
            }
        }
        ((JavascriptExecutor) webDriver).executeScript("window.scrollBy(0,300)");

        for (int i = 0; i < urlsCTESection.length; i++){
            List<WebElement> links = careerTechEduFB.getWebElements();
            ((JavascriptExecutor) webDriver).executeScript("arguments[0].scrollIntoView(true);", links.get(i));
            if (links.get(i).isDisplayed()){
                String bookName = links.get(i).getText();
                if (bookName.contains(urlsCTESection[i].split(">")[1])){
                    reportLog(bookName + " is displayed and verified");
                } else {
                    reportLog("Book is not displayed");
                    return false;
                }
                verifyStatusCodeIsCorrect(links.get(i).getAttribute("href"), bookName);
                links.get(i).click();
                waitForSec(6);
                if (webDriver.getCurrentUrl().contains(urlsCTESection[i].split(">")[0])) {
                    reportLog("The Book " + bookName + " link is navigated to the correct page");
                } else {
                    reportLog("The Book " + bookName + " link is navigated to the incorrect page");
                    return false;
                }
                webDriver.navigate().back();
            } else {
                System.out.println("Link not displayed");
                return false;
            }
        }
        ((JavascriptExecutor) webDriver).executeScript("window.scrollBy(0,300)");

        for (int i = 0; i < urlsESLSection.length; i++){
            List<WebElement> links = englishSecLangFB.getWebElements();
            ((JavascriptExecutor) webDriver).executeScript("arguments[0].scrollIntoView(true);", links.get(i));
            if (links.get(i).isDisplayed()){
                String bookName = links.get(i).getText();
                if (bookName.contains(urlsESLSection[i].split(">")[1])){
                    reportLog(bookName + " is displayed and verified");
                } else {
                    reportLog("Book is not displayed");
                    return false;
                }
                verifyStatusCodeIsCorrect(links.get(i).getAttribute("href"), bookName);
                links.get(i).click();
                waitForSec(6);
                if (webDriver.getCurrentUrl().contains(urlsESLSection[i].split(">")[0])) {
                    reportLog("The Book " + bookName + " link is navigated to the correct page");
                } else {
                    reportLog("The Book " + bookName + " link is navigated to the incorrect page");
                    return false;
                }
                webDriver.navigate().back();
            } else {
                System.out.println("Link not displayed");
                return false;
            }
        }
        ((JavascriptExecutor) webDriver).executeScript("window.scrollBy(0,500)");
        return true;
    }

    // This method verify the Explore products navitaion on the landing page
    public boolean verifyAdditionalProductsToEnhanceAdultLearning() {
        String[] expectedProductLinks = {"https://www.ck12.org/fbbrowse/", "https://www.ck12.org/assessment/ui/browse/practice/?",
                "https://interactives.ck12.org/simulations/physics.html?", "https://interactives.ck12.org/simulations/chemistry.html?",
                "https://interactives.ck12.org/plix/", "https://www.ck12.org/study-guides/algebra/?", "https://www.ck12info.org/certifiededucator/"};

        if (exploreProducts.isElementPresent()) {
            List<WebElement> exploreProductsList = exploreProducts.getWebElements();
            ((JavascriptExecutor) webDriver).executeScript("arguments[0].scrollIntoView(true);", exploreProductsList.get(3));
            ((JavascriptExecutor) webDriver).executeScript("window.scrollBy(0,200)");
            waitForSec(2);
            reportLog("The number of explore products on the landing page: " + exploreProductsList.size());

            for (WebElement exploreProduct : exploreProductsList) {
                if (exploreProduct.isDisplayed()) {
                    reportLog("The product is: " + exploreProduct.getText());
                } else {
                    reportLog("The product is not present: " + exploreProduct.getText());
                    return false;
                }
            }

            reportLog("verify the explore products navigation...");
            List<WebElement> productsLink = exploreProductsLinks.getWebElements();
            reportLog("The explore products links size is: " + productsLink.size());

            for (int i = 0; i < expectedProductLinks.length; i++){
                List<WebElement> exploreProductsLink = exploreProductsLinks.getWebElements();
                ((JavascriptExecutor) webDriver).executeScript("arguments[0].scrollIntoView(true);", exploreProductsLink.get(i));
                if (exploreProductsLink.get(i).isDisplayed()){
                    ((JavascriptExecutor) webDriver).executeScript("arguments[0].click();", exploreProductsLink.get(i));
                    String parent = switchToChildWindow();
                    waitForSec(6);
                    if (webDriver.getCurrentUrl().contains(expectedProductLinks[i])) {
                        reportLog("The Product link is navigated to the correct page");
                    } else {
                        return false;
                    }
                    webDriver.close();
                    webDriver.switchTo().window(parent);
                }
                waitForSec(3);
            }

        } else {
            reportLog("The section is not present: " + headerExplore.getText());
        }
        return true;
    }

    public boolean verifyIntegrateSectionList() {
        String[] expectedProductLinks = {"https://www.ck12info.org/using-ck-12-with-google-classroom/", "https://www.ck12info.org/using-ck-12-with-canvas/",
                "https://www.ck12info.org/using-ck-12-with-schoology/"};

        if (integrationSecTitle.isDisplayed() && integrationSecTitle.getText().equals("Integrate with CK-12")) {

            for (int i = 0; i < expectedProductLinks.length; i++) {
                List<WebElement> exploreProductsLink = integrationSecLinks.getWebElements();
                if (exploreProductsLink.get(i).isDisplayed()) {
                    exploreProductsLink.get(i).click();
                    waitForSec(6);
                    if (webDriver.getCurrentUrl().contains(expectedProductLinks[i])) {
                        reportLog("The Integrate link is navigated to the correct page");
                    } else {
                        return false;
                    }
                }
                webDriver.navigate().back();
                waitForSec(6);
            }
        } else {
            reportLog("Integrate Section not Present");
            return false;
        }
        ((JavascriptExecutor) webDriver).executeScript("window.scrollBy(0,500)");
        return true;
    }

    public boolean verifyTestimonialsList() {
        String[] expectedTestimonialsTitle = {"With CK-12 Adult Education, It's \"Don't Give Up\"", "CK-12 Is Free and Helps Adult Learners Achieve Their Dreams",
                "Adult Educators Need to Use CK-12", "CK-12 Makes Tough Subjects Easier"};

        testimonialHeader.scrollIntoView();
        if (testimonialHeader.isDisplayed() && testimonialHeader.getText().equals("Testimonials")) {

            for (int i = 0; i < expectedTestimonialsTitle.length; i++) {
                List<WebElement> testimonials = testimonialTitles.getWebElements();
                if (testimonials.get(i).isDisplayed()) {
                    if (testimonials.get(i).getText().contains(expectedTestimonialsTitle[i])) {
                        reportLog("The Testimonial Title is correct");
                    } else {
                        return false;
                    }
                } else {
                    reportLog("Testimonial Not Displayed/Present");
                    return false;
                }
            }
        } else {
            reportLog("Testimonial Section Not Present");
            return false;
        }
        return true;
    }



    public String switchToChildWindow() {
        String parentWindow = webDriver.getWindowHandle();
        Set<String> childWindow = webDriver.getWindowHandles();
        for (String window : childWindow) {
            if (!parentWindow.equals(window)) {
                webDriver.switchTo().window(window);
                reportLog("Successfully Move To Child Window");
            }
        }
        return parentWindow;
    }

    public boolean verifyDetailsOfBrowseNextGenerationScienceFlexbooksAndCommonCoreMathFlexbooksPages(String page) {

        String[] nextGenerationScienceFlexbooksUrls = {"CK-12 CBSE Biology Class 9:-https://master.ck12.org/book/CBSE_Biology_Book_Class_9:-https://master.ck12.org/book/cbse_biology_book_class_9/",
                                                       "CK-12 CBSE Biology Class 10:-https://master.ck12.org/book/CBSE_Biology_Book_Class_X:-https://master.ck12.org/book/cbse_biology_book_class_x/",
                                                       "CK-12 CBSE Biology Class 11:-https://master.ck12.org/book/CBSE_Biology_Book_Class_XI:-https://master.ck12.org/book/cbse_biology_book_class_xi/",
                                                       "CK-12 CBSE Maths Class 9:-https://master.ck12.org/book/CBSE-Maths-Book-Class-9:-https://master.ck12.org/book/cbse-maths-book-class-9/",
                                                       "CK-12 CBSE Maths Class 10:-https://master.ck12.org/book/CBSE-Maths-Book-Class-10:-https://master.ck12.org/book/cbse-maths-book-class-10/",
                                                       "CK-12 CBSE Maths Class 11:-https://master.ck12.org/book/CBSE_Maths_Book_Class_11:-https://master.ck12.org/book/cbse_maths_book_class_11/"};

        String[] commonCoreMathFlexbooksUrls = {"CK-12 Interactive Algebra I for CCSS:-https://www.ck12.org/book/CK-12-Interactive-Algebra-I-for-CCSS/:-https://www.ck12.org/book/ck-12-interactive-algebra-i-for-ccss/",
                                                "CK-12 Interactive Geometry for CCSS:-https://www.ck12.org/book/CK-12-Interactive-Geometry-for-CCSS/:-https://www.ck12.org/book/ck-12-interactive-geometry-for-ccss/",
                                                "CK-12 Interactive Algebra II for CCSS:-https://www.ck12.org/book/CK-12-Interactive-Algebra-II-Concepts-for-CCSS/:-https://www.ck12.org/book/ck-12-interactive-algebra-ii-concepts-for-ccss/",
                                                "CK-12 Interactive Algebra I for CCSS - Teacher's Guide:-https://www.ck12.org/tebook/CK-12-Interactive-Algebra-I-For-CCSS-Teachers-Guide/:-https://www.ck12.org/tebook/ck-12-interactive-algebra-i-for-ccss-teachers-guide/",
                                                "CK-12 Interactive Geometry for CCSS - Teacher's Guide:-https://www.ck12.org/tebook/CK-12-Interactive-Geometry-for-CCSS-Teachers-Guide/:-https://www.ck12.org/tebook/ck-12-interactive-geometry-for-ccss-teachers-guide/",
                                                "CK-12 Interactive Algebra II for CCSS - Teacher's Guide:-https://www.ck12.org/tebook/CK-12-Interactive-Algebra-II-Concepts-for-CCSS-Teachers-Guide/:-https://www.ck12.org/tebook/ck-12-interactive-algebra-ii-concepts-for-ccss-teachers-guide/"};


        if (page.equals("Next Generation Science FlexBooks")) {
            if  (titleScienceFlexbooks.isElementPresent() && titleScienceFlexbooks.getText().equals("Next Generation Science FlexBooks")) {
                subOptionsArr = nextGenerationScienceFlexbooksUrls;
            }
        } else if (page.equals("Common Core Math FlexBooks")) {
            if  (titleScienceFlexbooks.isElementPresent() && titleScienceFlexbooks.getText().equals("Common Core Math FlexBooks")) {
                subOptionsArr = commonCoreMathFlexbooksUrls;
            }
        }


            for (int i = 0; i < subOptionsArr.length; i++) {
                List<WebElement> bookTitles = bookTitlesOfScienceFlexbooks.getWebElements();
                if (bookTitles.get(i).isDisplayed() && bookTitles.get(i).getText().contains(subOptionsArr[i].split(":-")[0])) {
                    reportLog("The next generation book title is " + bookTitles.get(i).getText());
                    if (verifyStatusCodeIsCorrect(bookTitles.get(i).getAttribute("href"), "url" + i)) {
                        logger.info("url " + i + " is not broken and loaded correctly");
                        if (bookTitles.get(i).getAttribute("href").contains(subOptionsArr[i].split(":-")[1])) {
                            reportLog("The book link attribute " + bookTitles.get(i).getAttribute("href") + " verified");
                            bookTitles.get(i).click();
                            reportLog("Clicked on the book title");
                            waitForSec(3);
                            if (webDriver.getCurrentUrl().contains(subOptionsArr[i].split(":-")[2])) {
                                int retry = 3;
                                while (retry > 0) {
                                    webDriver.navigate().back();
                                    waitForSec(5);
                                    if (webDriver.getCurrentUrl().contains("https://master.ck12.org/books/standards/")) {
                                        retry = retry - 3;
                                    }
                                    retry--;
                                }
                            }
                        } else {
                            reportLog("The book url is incorrect: " + bookTitles.get(i).getAttribute("href"));
                            return false;
                        }
                    } else {
                    logger.info("url " + i + " is broken");
                    return false;
                }

                } else {
                    reportLog("The book is not present or incorrect: " + bookTitles.get(i).getText());
                    return false;
                      }
                reportLog(i + " Book done");
            }
            if (coreAlignedConcepts.isElementPresent() && coreAlignedConcepts.getText().equals("Common Core Aligned Concepts")) {
                reportLog("Common Core Aligned Concepts is verified");
                coreAlignedConcepts.click();
            if (webDriver.getCurrentUrl().contains("https://master.ck12.org/ccss/")) {
                reportLog("The Common Core Aligned Concepts url is verified");
            }
        }
        return true;
    }
}