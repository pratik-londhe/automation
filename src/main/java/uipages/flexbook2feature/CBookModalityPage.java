package uipages.flexbook2feature;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import uipages.BasePage;
import utils.GuiControl;
import java.util.List;

public class CBookModalityPage extends BasePage {

    private final GuiControl btnAssignAssignment = new GuiControl(getElementMap().get("btnAssignAssignment"), webDriver);
    private final GuiControl iconCross = new GuiControl(getElementMap().get("iconCross"), webDriver);
    private final GuiControl iconMinimizeAssign = new GuiControl(getElementMap().get("iconMinimizeAssign"), webDriver);
    private final GuiControl iconToc = new GuiControl(getElementMap().get("iconToc"), webDriver);
    private final GuiControl linkChaptersConcepts = new GuiControl(getElementMap().get("linkChaptersConcepts"), webDriver);
    private final GuiControl iconClose = new GuiControl(getElementMap().get("iconClose"), webDriver);
    private final GuiControl iconResources = new GuiControl(getElementMap().get("iconResources"), webDriver);
    private final GuiControl txtResourcesAndFiles = new GuiControl(getElementMap().get("txtResourcesAndFiles"), webDriver);
    private final GuiControl iconSettings = new GuiControl(getElementMap().get("iconSettings"), webDriver);
    private final GuiControl txtSettings = new GuiControl(getElementMap().get("txtSettings"), webDriver);
    private final GuiControl linksOfSettingChange = new GuiControl(getElementMap().get("linksOfSettingChange"), webDriver);
    private final GuiControl linkNextConcept = new GuiControl(getElementMap().get("linkNextConcept"), webDriver);
    private final GuiControl linkPreviousConcept = new GuiControl(getElementMap().get("linkPreviousConcept"), webDriver);
    private final GuiControl btnViewPractice = new GuiControl(getElementMap().get("btnViewPractice"), webDriver);
    private final GuiControl btnPreview = new GuiControl(getElementMap().get("btnPreview"), webDriver);
    private final GuiControl btnAssign = new GuiControl(getElementMap().get("btnAssign"), webDriver);
    private final GuiControl btnTodayDate = new GuiControl(getElementMap().get("btnTodayDate"), webDriver);
    private final GuiControl chkBoxClass = new GuiControl(getElementMap().get("chkBoxClass"), webDriver);
    private final GuiControl btnCreateAssignment = new GuiControl(getElementMap().get("btnCreateAssignment"), webDriver);
    private final GuiControl disabledDate = new GuiControl(getElementMap().get("disabledDate"), webDriver);
    private final GuiControl btnStartPractice = new GuiControl(getElementMap().get("btnStartPractice"), webDriver);
    private final GuiControl btnStartPracticing = new GuiControl(getElementMap().get("btnStartPracticing"), webDriver);
    private final GuiControl labelAdaptivePractice = new GuiControl(getElementMap().get("labelAdaptivePractice"), webDriver);
    private final GuiControl btnContinuePractice = new GuiControl(getElementMap().get("btnContinuePractice"), webDriver);
    private final GuiControl iconArrowDown = new GuiControl(getElementMap().get("iconArrowDown"), webDriver);
    private final GuiControl textProgress = new GuiControl(getElementMap().get("textProgress"), webDriver);
    private final GuiControl indicatorProgress = new GuiControl(getElementMap().get("indicatorProgress"), webDriver);
    private final GuiControl textFlexBookName = new GuiControl(getElementMap().get("textFlexBookName"), webDriver);

    public CBookModalityPage(WebDriver webDriver, ExtentTest extentTest, ExtentReports extentReports) {
        super(webDriver, extentTest, extentReports);
    }

    public boolean verifyAssignAssignmentButton() {
        return btnAssignAssignment.isElementPresent();
    }

    public void clickOnCrossIcon() {
        if (iconCross.isElementPresent()) {
            iconCross.click();
            reportLog("Successfully clicked on Cross Icon");
        }
    }

    public void clickOnArrowCloseIcon() {
        if (iconArrowDown.isElementPresent()) {
            iconArrowDown.clickJScript();
            reportLog("Successfully clicked on Close Icon");
        }
    }

    public boolean verifyIconArrowDown() {
        waitForSec(5);
        return iconArrowDown.isElementPresent();
    }

    public boolean verifyCrossIconOfAssignAssignment() {
        return iconCross.isElementPresent();
    }

    public boolean verifyAssignBannerBadge() {
        return iconMinimizeAssign.isElementPresent();
    }

    public void clickOnAssignBannerBadge() {
        if (iconMinimizeAssign.isElementPresent()) {
            iconMinimizeAssign.clickJScript();
            reportLog("Successfully clicked on Assign Banner Badge");
        }
    }

    public void ScrollScreen() {
        iconToc.scrollIntoView();
    }

    public boolean verifyTocIcon() {
        return iconToc.isElementPresent();
    }

    public void clickOnIconToc() {
        if (iconToc.isElementPresent()) {
            iconToc.clickJScript();
            reportLog("Successfully clicked on Toc Icon");
        }
    }

    public boolean verifyChaptersLinkAgain() {
        waitForSec(5);
        List<WebElement> names1 = webDriver.findElements(By.xpath("//a[@data-dx-desc='course_toc_unit_button']"));
        if (!names1.isEmpty()) {
            reportLog("Total No Of Chapter  Is = " + names1.size());
            return true;
        } else {
            reportLog("Fail To Verify Links");
            return false;
        }
    }

    public boolean verifyLinksOfChapterConceptAgain() {
        linkChaptersConcepts.scrollIntoView();
        List<WebElement> conceptNames1 = linkChaptersConcepts.getWebElement().findElements(By.xpath("//a[@data-dx-desc='course_toc_section_button']/span[1]"));
        if (!conceptNames1.isEmpty()) {
            reportLog("Total No Of concepts Is = " + conceptNames1.size());
            return true;
        } else {
            reportLog("Fail To Verify Links");
            return false;
        }
    }

    public boolean verifyCloseIcon() {
        return iconClose.isElementPresent();
    }

    public void clickOnIconClose() {
        if (iconClose.isElementPresent()) {
            iconClose.clickJScript();
            reportLog("Successfully clicked on Close Icon");
        }
    }

    public boolean verifyResourcesIcon() {
        waitForSec(5);
        return iconResources.isElementPresent();
    }

    public boolean verifyProgressText() {
        waitForSec(5);
        return textProgress.isElementPresent();
    }

    public boolean verifyProgressIndicator() {
        return indicatorProgress.isElementPresent();
    }

    public boolean verifyFlexBookNameLink() {
        return textFlexBookName.isElementPresent();
    }

    public void clickOnFlexBookNameLink() {
        if (textFlexBookName.isElementPresent()) {
            textFlexBookName.click();
            reportLog("Successfully clicked on FlexBook Name Link");
        }
    }

    public void clickOnResourcesIcon() {
        if (iconResources.isElementPresent()) {
            iconResources.click();
            reportLog("Successfully clicked on Resources Icon");
        }
    }

    public boolean verifyResourcesAndFilesText() {
        return txtResourcesAndFiles.isElementPresent();
    }

    public boolean verifySettingsIcon() {
        return iconSettings.isElementPresent();
    }

    public void clickOnSettingsIcon() {
        if (iconSettings.isElementPresent()) {
            iconSettings.click();
            reportLog("Successfully clicked on Settings Icon");
        }
    }

    public boolean verifySettingsText() {
        return txtSettings.isElementPresent();
    }

    public boolean verifySettingsOptions() {
        waitForSec(5);
        List<WebElement> contentNames = linksOfSettingChange.getWebElement().findElements(By.xpath("//div[@class='dxtrack-user-action']"));
        return !contentNames.isEmpty();
    }

    public boolean verifyLinkOfNextConcept() {
        return linkNextConcept.isElementPresent();
    }

    public boolean verifyLinkOfPreviousConcept() {
        return linkPreviousConcept.isElementPresent();
    }


    public void clickOnNextConceptLink() {
        if (linkNextConcept.isElementPresent()) {
            linkNextConcept.clickJScript();
            reportLog("Successfully clicked on Next Concept Link");
        }
    }

    public void clickOnPreviousConceptLink() {
        if (linkPreviousConcept.isElementPresent()) {
            linkPreviousConcept.clickJScript();
            reportLog("Successfully clicked on Next Concept Link");
        }
    }

    public boolean verifyButtonViewPractice() {
        waitForSec(5);
        return btnViewPractice.isElementPresent();
    }

    public boolean verifyButtonPreview() {
        return btnPreview.isElementPresent();
    }

    public void clickOnButtonViewPractice() {
        if (btnViewPractice.isElementPresent()) {
            btnViewPractice.click();
            reportLog("Successfully clicked on Button View Practice");
        }
    }

    public void clickOnButtonPreview() {
        if (btnPreview.isElementPresent()) {
            btnPreview.clickJScript();
            reportLog("Successfully clicked on Button Preview");
        }
    }

    public void clickOnAssignBtn() {
        waitForSec(5);
        if (btnAssign.isElementPresent()) {
            btnAssign.clickJScript();
            reportLog("Clicked on Assign button on Primary Modality Page.");
        }
        waitForSec(5);
    }

    public boolean verifyAssignBtn() {
        return btnAssign.isElementPresent();
    }

    public void selectDueDate() {
        if (btnTodayDate.isElementPresent()) {
            btnTodayDate.click();
            reportLog("Selected today's date as Due date.");
        }
    }

    public boolean verifyClassCheckBox() {
        return chkBoxClass.isElementPresent();
    }

    public void selectClasses() {
        if (chkBoxClass.isElementPresent()) {
            chkBoxClass.clickFirstFromListOfElements();
            reportLog("Clicked on class check box.");
        }
    }

    public void clickOnCreateAssignment() {
        if (btnCreateAssignment.isElementPresent()) {
            btnCreateAssignment.click();
            reportLog("Clicked on Assign button under Assign to class modal.");
        }
        waitForSec(5);
    }

    public boolean verifyCreateAssignmentButton() {
        return btnCreateAssignment.isElementPresent();
    }

    public boolean verifyDisabledStartDate() {
        disabledDate.waitForUntilVisibilityOfElement(10);
        String classAttributeValue = disabledDate.getAttribute("class");
        return classAttributeValue.contains("disabled");
    }

    public void clickOnStartPractice() {
        if (btnStartPractice.isElementPresent()) {
            btnStartPractice.clickJScript();
            reportLog("Clicked on Start Practice button.");
        }
    }

    public void clickOnStartPracticing() {
        if (btnStartPracticing.isElementPresent()) {
            btnStartPracticing.clickJScript();
            reportLog("Clicked on Start Practicing button inside Adaptive Practice widget.");
        }
    }

    public boolean verifyAdaptivePracticeWidgetLabel() {
        return labelAdaptivePractice.isElementPresent();
    }

    public boolean verifyStartPracticeButton() {
        btnStartPractice.waitForUntilVisibilityOfElement(10);
        return btnStartPractice.isElementPresent();
    }

    public boolean verifyStartPracticingButton() {
        return btnStartPracticing.isElementPresent();
    }

    public boolean verifyContinuePracticeButton() {
        return btnContinuePractice.isElementPresent();
    }

    public void clickOnContinuePractice() {
        if (btnContinuePractice.isElementPresent()) {
            btnContinuePractice.clickJScript();
            reportLog("Clicked on continue practice button.");
        }
    }
}