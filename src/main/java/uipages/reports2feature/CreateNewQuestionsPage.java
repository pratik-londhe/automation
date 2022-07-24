package uipages.reports2feature;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import uipages.BasePage;
import utils.GuiControl;

public class CreateNewQuestionsPage extends BasePage {
    private String creditValue;

    private final GuiControl textConcepts = new GuiControl(getElementMap().get("textConcepts"), webDriver);
    private final GuiControl textGrades = new GuiControl(getElementMap().get("textGrades"), webDriver);
    private final GuiControl textStandards = new GuiControl(getElementMap().get("textStandards"), webDriver);
    private final GuiControl dropDownQuesType = new GuiControl(getElementMap().get("dropDownQuesType"), webDriver);
    private final GuiControl textSource = new GuiControl(getElementMap().get("textSource"), webDriver);
    private final GuiControl textLanguage = new GuiControl(getElementMap().get("textLanguage"), webDriver);
    private final GuiControl textSearch = new GuiControl(getElementMap().get("textSearch"), webDriver);
    private final GuiControl drpDownLicensed = new GuiControl(getElementMap().get("drpDownLicensed"), webDriver);
    private final GuiControl textAuthor = new GuiControl(getElementMap().get("textAuthor"), webDriver);
    private final GuiControl textCreatedOn = new GuiControl(getElementMap().get("textCreatedOn"), webDriver);
    private final GuiControl btnAddRoleModal = new GuiControl(getElementMap().get("btnAddRoleModal"), webDriver);
    private final GuiControl linkFlexBoxControl = new GuiControl(getElementMap().get("LinkFlexBoxControl"), webDriver);
    private final GuiControl btnAddCreateCredit = new GuiControl(getElementMap().get("btnAddCreateCredit"), webDriver);
    private final GuiControl textCreditValue = new GuiControl(getElementMap().get("textCreditValue"), webDriver);
    private final GuiControl btnCancelOfTranslator = new GuiControl(getElementMap().get("btnCancelOfTranslator"), webDriver);
    private final GuiControl dropDwnCreditRole = new GuiControl(getElementMap().get("dropDwnCreditRole"), webDriver);
    private final GuiControl btnSubmit = new GuiControl(getElementMap().get("btnSubmit"), webDriver);
    private final GuiControl msgQuestionError = new GuiControl(getElementMap().get("msgQuestionError"), webDriver);

    public CreateNewQuestionsPage(WebDriver webDriver, ExtentTest extentTest, ExtentReports extentReports) {
        super(webDriver, extentTest, extentReports);
    }

    public boolean verifyTheQuestionsTypeDropDown() {
        waitForSec(4);
        return dropDownQuesType.isElementPresent();
    }

    public boolean verifySourceText() {
        return textSource.isElementPresent();
    }

    public boolean verifyLanguageText() {
        return textLanguage.isElementPresent();
    }

    public boolean verifySearchText() {
        return textSearch.isElementPresent();
    }

    public boolean verifyLicencedDropDown() {
        return drpDownLicensed.isElementPresent();
    }

    public boolean verifyAuthorText() {
        return textAuthor.isElementPresent();
    }

    public boolean verifyCreatedOnText() {
        return textCreatedOn.isElementPresent();
    }

    public boolean verifyRoleBtn() {
        return btnAddRoleModal.isElementPresent();
    }

    public boolean verifyConceptsText() {
        return textConcepts.isElementPresent();
    }

    public boolean verifyGradesText() {
        return textGrades.isElementPresent();
    }

    public boolean verifyTextStandards() {
        return textStandards.isElementPresent();
    }

    public boolean verifyFlexBoxControlLink() {
        return linkFlexBoxControl.isElementPresent();
    }

    public void clickOnViewMoreLink() {
        if (linkFlexBoxControl.isElementPresent()) {
            linkFlexBoxControl.click();
            reportLog("Clicked on flex box control link.");
        }
    }

    public boolean verifyViewLessFunctionality() {
        boolean result = false;
        if (textSource.isElementPresent()) {
            reportLog("View Less functionality is not worked.");
        } else {
            reportLog("View Less functionality is worked.");
            result = true;
        }
        return result;
    }

    public void clickOnViewLessLink() {
        if (linkFlexBoxControl.isElementPresent()) {
            linkFlexBoxControl.click();
            reportLog("Clicked on flex box control link.");
        }
    }

    public void clickOnAddRoleValueBtn() {
        if (btnAddCreateCredit.isElementPresent()) {
            btnAddCreateCredit.click();
            reportLog("Clicked on add create credit button.");
        }
    }

    public void clickOnAddRoleBtn() {
        if (btnAddRoleModal.isElementPresent()) {
            btnAddRoleModal.click();
            reportLog("Clicked add role modal button..");
        }
    }

    public boolean verifyTheErrorMessage() {
        String roleErrorMessage = "Please enter a role!!!";
        Alert alert = webDriver.switchTo().alert();
        return roleErrorMessage.equals(alert.getText());
    }

    public void acceptTheErrorPopUp() {
        webDriver.switchTo().alert().accept();
        reportLog("Switched to windows pop up.");
    }

    public void enterCreditValueOfRole() {
        creditValue = "Mark";
        if (textCreditValue.isElementPresent()) {
            textCreditValue.sendKeys("Mark");
            reportLog("Entered the credit value of a role.");
        }
    }

    public boolean verifyEnteredCreditValueOfRole() {
        return creditValue.equals(webDriver.findElement(By.xpath("(//span[@class='creditName ellipsis'])[2]")).getAttribute("title"));
    }

    public void clickOnCancelBtnOfTranslator() {
        if (btnCancelOfTranslator.isElementPresent()) {
            btnCancelOfTranslator.click();
            reportLog("Clicked on the cancel button of translator.");
        }
    }

    public boolean verifyFunctionalityOfCancelButton() {
        if (dropDwnCreditRole.isElementPresent()) {
            reportLog("Translator drop down is still present after clicking on cancel button.So, cancel button functionality is not worked.");
            return false;
        } else {
            reportLog("Translator drop down is not present. So, cancel button functionality is worked.");
            return true;
        }
    }

    public void clickOnSubmitButton() {
        if (btnSubmit.isElementPresent()) {
            btnSubmit.click();
            reportLog("Clicked on the submit button.");
        }
    }

    public boolean verifyQuestionErrorMsg() {
        String errorMsg = "You missed some of the required fields.";
        return errorMsg.equals(msgQuestionError.getText());
    }
}