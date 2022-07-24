package uipages.flexbook2feature;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import uipages.BasePage;
import utils.GuiControl;
import java.util.List;

public class CourseBookDetailsPage extends BasePage {


    private final GuiControl linkAfterGetStarted = new GuiControl(getElementMap().get("linkAfterGetStarted"), webDriver);
    private final GuiControl linkAuthor = new GuiControl(getElementMap().get("linkAuthor"), webDriver);
    private final GuiControl linkHowDoFlexBookWork = new GuiControl(getElementMap().get("linkHowDoFlexBookWork"), webDriver);
    private final GuiControl btnChoose = new GuiControl(getElementMap().get("btnChoose"), webDriver);
    private final GuiControl btnAssign = new GuiControl(getElementMap().get("btnAssign"), webDriver);
    private final GuiControl btnCustomize = new GuiControl(getElementMap().get("btnCustomize"), webDriver);
    private final GuiControl tabDetails = new GuiControl(getElementMap().get("tabDetails"), webDriver);
    private final GuiControl txtGrades = new GuiControl(getElementMap().get("txtGrades"), webDriver);
    private final GuiControl tabOverview = new GuiControl(getElementMap().get("tabOverview"), webDriver);
    private final GuiControl linkChapters = new GuiControl(getElementMap().get("linkChapters"), webDriver);
    private final GuiControl linkConcepts = new GuiControl(getElementMap().get("linkConcepts"), webDriver);
    private final GuiControl btnNext = new GuiControl(getElementMap().get("btnNext"), webDriver);
    private final GuiControl btnStart = new GuiControl(getElementMap().get("btnStart"), webDriver);
    private final GuiControl btnPublish = new GuiControl(getElementMap().get("btnPublish"), webDriver);
    private final GuiControl checkBoxCk12ContentDerived = new GuiControl(getElementMap().get("checkBoxCk12ContentDerived"), webDriver);
    private final GuiControl txtErrorPublish = new GuiControl(getElementMap().get("txtErrorPublish"), webDriver);
    private final GuiControl tabPublish = new GuiControl(getElementMap().get("tabPublish"), webDriver);
    private final GuiControl txtThanksFor = new GuiControl(getElementMap().get("txtThanksFor"), webDriver);
    private final GuiControl btnGotIt = new GuiControl(getElementMap().get("btnGotIt"), webDriver);
    private final GuiControl btnEdit = new GuiControl(getElementMap().get("btnEdit"), webDriver);
    private final GuiControl dropDownResume = new GuiControl(getElementMap().get("dropDownResume"), webDriver);
    private final GuiControl linkAddToFlexBook = new GuiControl(getElementMap().get("linkAddToFlexBook"), webDriver);
    private final GuiControl textSuccess = new GuiControl(getElementMap().get("textSuccess"), webDriver);

    public CourseBookDetailsPage(WebDriver webDriver, ExtentTest extentTest, ExtentReports extentReports) {
        super(webDriver, extentTest, extentReports);
    }

    public void clickOnFirstCBookAndFurtherProcess(String email, String password) {
        CBookLandingPage cBookLandingPage = new CBookLandingPage(webDriver,extentTest,extentReports);

        cBookLandingPage.clickOnTryItNow(email, password);
        clickOnFirstFlexBook();
        verifyAuthorLink();
        verifyChooseButton();
        clickOnDetailsTab();
        clickOnOverviewTab();
        verifyChaptersLink();
        clickOnFirstChapter();
        verifyLinksOfChapterConcept();
        clickFirstConceptOfLink();
    }

    public void userLogin() {
        //The first flexbook now requires a logged in user to access it.
        //clickOnFirstFlexBook();
        String bookUrlForNonLoggedInUser = "https://flexbooks-master.ck12.org/cbook/ck-12-interactive-middle-school-math-8-for-ccss/";
        webDriver.navigate().to(bookUrlForNonLoggedInUser);
        verifyAuthorLink();
        clickOnDetailsTab();
        clickOnOverviewTab();
        verifyChaptersLink();
        clickOnFirstChapter();
        verifyLinksOfChapterConcept();
        clickFirstConceptOfLink();
    }

    public void clickOnFirstFlexBook() {
        waitForSec(5);
        if (linkAfterGetStarted.isElementPresent()) {
            linkAfterGetStarted.clickJScript();
            reportLog("Successfully clicked on FlexBook");
        } else {
            reportLog(" Not clicked on First FlexBook");
        }
    }

    public boolean verifyAuthorLink() {
        waitForSec(5);
        return linkAuthor.isElementPresent();
    }

    public boolean verifySuccessText() {
        waitForSec(5);
        return textSuccess.isElementPresent();
    }

    public boolean verifyLinkHowDoFlexBookWork() {
        return linkHowDoFlexBookWork.isElementPresent();
    }

    public boolean verifyChooseButton() {
        waitForSec(2);
        return btnChoose.isElementPresent();
    }

    public void clickOnChooseButton() {
        btnChoose.scrollIntoView();
        btnChoose.clickJScript();
        reportLog("Click on Choose DropDown");
    }

    public boolean verifyAssignButton() {
        return btnAssign.isElementPresent();
    }

    public boolean verifyCustomizeButton() {
        return btnCustomize.isElementPresent();
    }

    public void clickOnCustomizeButton() {
        if (btnCustomize.isElementPresent()) {
            btnCustomize.mouseHover();
            btnCustomize.click();
            reportLog("Click on Customize Button");
        }
    }

    public boolean verifyDetailsTab() {
        return tabDetails.isElementPresent();
    }

    public void clickOnDetailsTab() {
        tabDetails.scrollIntoView();
        tabDetails.click();
        reportLog("Click on Details Tab");
    }

    public boolean verifyGradeText() {
        waitForSec(5);
        return txtGrades.isElementPresent();
    }

    public void clickOnOverviewTab() {
        if (tabOverview.isElementPresent()) {
            tabOverview.scrollIntoView();
            tabOverview.click();
            reportLog("Click On Overview Button");
        }
    }

    public boolean verifyChaptersLink() {
        linkChapters.scrollIntoView();
        int countOfChapters;
        List<WebElement> names = linkChapters.getWebElement().findElements(By.xpath("//a[@data-dx-desc='course_toc_unit_button']"));
        countOfChapters = names.size();
        if (countOfChapters > 0) {
            reportLog("Total No Of Chapter Is = " + countOfChapters);
            return true;
        } else {
            reportLog("Fail To Verify  Chapter Links");
            return false;
        }
    }

    public void clickOnFirstChapter() {
        linkChapters.scrollIntoView();
        List<WebElement> names = linkChapters.getWebElement().findElements(By.xpath("//a[@data-dx-desc='course_toc_unit_button']"));
        for (WebElement Links : names) {
            if (Links.isDisplayed()) {
                Links.click();
                reportLog("Click on First Link Of Chapter");
                break;
            }
        }
    }

    public boolean verifyLinksOfChapterConcept() {
        waitForSec(5);
        linkConcepts.scrollIntoView();
        List<WebElement> conceptNames = linkConcepts.getWebElement().findElements(By.xpath("//a[@data-dx-desc='course_toc_section_button']/span[1]"));
        int countOfConcepts = conceptNames.size();
        if (countOfConcepts > 0) {
            reportLog("Total No Of concepts Is = " + countOfConcepts);
            return true;
        } else {
            reportLog("Fail To Verify Links");
            return false;
        }
    }

    public void clickFirstConceptOfLink() {
        waitForSec(5);
        linkConcepts.scrollIntoView();
        linkConcepts.clickFirstFromListOfElements();
    }

    public boolean verifyStartButton() {
        return btnStart.isDisplayed();
    }

    public boolean verifyNextButton() {
        return btnNext.isElementPresent();
    }

    public boolean verifyCk12ContentDriveCheckBox() {
        return checkBoxCk12ContentDerived.isElementPresent();
    }

    public void clickOnCk12ContentDriveCheckBox() {
        if (checkBoxCk12ContentDerived.isElementPresent()) {
            checkBoxCk12ContentDerived.click();
            reportLog("click on Ck12 Content Drive CheckBox ");
        }
    }

    public boolean verifyResumeDropDown() {
        return dropDownResume.isElementPresent();
    }

    public void clickOnResumeDropDown() {
        if (dropDownResume.isElementPresent()) {
            dropDownResume.click();
            reportLog("click on Resume DropDown");
        }
    }

    public boolean verifyAddToFlexBookLink() {
        waitForSec(5);
        return linkAddToFlexBook.isElementPresent();
    }

    public void clickOnAddToFlexBookLink() {
        if (linkAddToFlexBook.isElementPresent()) {
            linkAddToFlexBook.clickJScript();
            reportLog("click on Add To FlexBoo kLink");
        }
    }

    public boolean verifyPublishButton() {
        return btnPublish.isElementPresent();
    }

    public void clickOnPublishButton() {
        waitForSec(5);
        if (btnPublish.isElementPresent()) {
            btnPublish.click();
            reportLog("click on Publish Button");
        }
    }

    public boolean verifyPublishTab() {
        return tabPublish.isElementPresent();
    }

    public void clickOnPublishTab() {
        if (tabPublish.isElementPresent()) {
            tabPublish.click();
            reportLog("click on Publish Tab");
        }
    }

    public boolean verifyErrorPublishMessage() {
        return txtErrorPublish.isElementPresent();
    }

    public boolean verifyThanksForMessage() {
        return txtThanksFor.isElementPresent();
    }

    public boolean verifyGotItButton() {
        waitForSec(5);
        return btnGotIt.isElementPresent();
    }

    public void clickOnGotItButton() {
        if (btnGotIt.isElementPresent()) {
            btnGotIt.click();
            reportLog("click on Got It Button");
        }
    }

    public boolean verifyEditButton() {
        return btnEdit.isElementPresent();
    }

    public void clickOnEditButton() {
        if (btnEdit.isElementPresent()) {
            btnEdit.click();
            reportLog("clicked on Edit Button");
        }
    }
}