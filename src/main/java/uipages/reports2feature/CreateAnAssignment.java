package uipages.reports2feature;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import uipages.BasePage;
import utils.GuiControl;

import java.util.List;

public class CreateAnAssignment extends BasePage {

    private String assignmentName;
    private String quizName1;
    String quizName2;
    private int count1 = 0;
    int count2 = 0;
    private int assignmentCountBefore = 0;
    private int assignmentCountAfter = 0;
    private int assignmentCountAtStudent = 0;
    private String assignmentCountXpath = "//div[@class='left assignment-title']//span[@class]";

    private final GuiControl btnAssignments = new GuiControl(getElementMap().get("btnAssignments"), webDriver);
    private final GuiControl iconCloseHeadsUp = new GuiControl(getElementMap().get("iconCloseHeadsUp"), webDriver);
    private final GuiControl txtClassAssignment = new GuiControl(getElementMap().get("txtClassAssignment"), webDriver);
    private final GuiControl btnCreateAssignment = new GuiControl(getElementMap().get("btnCreateAssignment"), webDriver);
    public final GuiControl btnAssign = new GuiControl(getElementMap().get("btnAssign"), webDriver);
    private final GuiControl btnJoinPlus = new GuiControl(getElementMap().get("btnJoinPlus"), webDriver);
    private final GuiControl btnCreateQuiz = new GuiControl(getElementMap().get("btnCreateQuiz"), webDriver);
    private final GuiControl checkBoxFirst = new GuiControl(getElementMap().get("checkBoxFirst"), webDriver);
    private final GuiControl btnSaveFirst = new GuiControl(getElementMap().get("btnSaveFirst"), webDriver);
    public final GuiControl btnSave = new GuiControl(getElementMap().get("btnSave"), webDriver);
    private final GuiControl checkBoxClassName = new GuiControl(getElementMap().get("checkBoxClassName"), webDriver);
    private final GuiControl checkBoxShowCorrectAnswer = new GuiControl(getElementMap().get("checkBoxShowCorrectAnswer"), webDriver);
    private final GuiControl iconAnswerInfo = new GuiControl(getElementMap().get("iconAnswerInfo"), webDriver);
    private final GuiControl placeHolderAssignmentName = new GuiControl(getElementMap().get("placeHolderAssignmentName"), webDriver);
    private final GuiControl iconArrowRight = new GuiControl(getElementMap().get("iconArrowRight"), webDriver);
    private final GuiControl txtNamesOfAssignment = new GuiControl(getElementMap().get("txtNamesOfAssignment"), webDriver);
    private final GuiControl txtNamesOfQuiz = new GuiControl(getElementMap().get("txtNamesOfQuiz"), webDriver);
    private final GuiControl btnRemoveConcept = new GuiControl(getElementMap().get("btnRemoveConcept"), webDriver);
    public final GuiControl btnCancel = new GuiControl(getElementMap().get("btnCancel"), webDriver);
    private final GuiControl btnDeleteAssignment = new GuiControl(getElementMap().get("btnDeleteAssignment"), webDriver);
    private final GuiControl btnUndoAssign = new GuiControl(getElementMap().get("btnUndoAssign"), webDriver);
    private final GuiControl btnYesDeleteAssignment = new GuiControl(getElementMap().get("btnYesDeleteAssignment"), webDriver);
    private final GuiControl btnAssignment = new GuiControl(getElementMap().get("btnAssignment"), webDriver);
    private final GuiControl txtSpanAssignmentNames = new GuiControl(getElementMap().get("txtSpanAssignmentNames"), webDriver);
    private final GuiControl btnStartNow = new GuiControl(getElementMap().get("btnStartNow"), webDriver);

    public CreateAnAssignment(WebDriver webDriver, ExtentTest extentTest, ExtentReports extentReports) {
        super(webDriver, extentTest, extentReports);
    }

    public void clickOnAssignmentsButton() {
        btnAssignments.clickFirstFromListOfElements();
        reportLog("Click On First Assignment Class");
    }

    public boolean verifyStartNowButton() {
        return btnStartNow.isElementPresent();
    }

    public boolean verifyClassAssignmentText() {
        return txtClassAssignment.isElementPresent();
    }

    public boolean verifyCreateAssignmentButton() {
        waitForSec(5);
        return btnCreateAssignment.isElementPresent();
    }

    public void clickOnIconCloseHeadsUp() {
        waitForSec(10);
        if (iconCloseHeadsUp.isElementPresent()) {
            iconCloseHeadsUp.clickJScript();
            reportLog("Click on Icon Close HeadsUp");
        }
    }

    public void clickOnJoinPlusButton() {
        if (btnJoinPlus.isElementPresent()) {
            btnJoinPlus.mouseHover();
            btnJoinPlus.clickJScript();
            reportLog("Click on Join Plus Button");
        }
        waitForSec(5);
    }

    public boolean verifyCreateQuizForClassButton() {
        waitForSec(5);
        return btnCreateQuiz.isElementPresent();
    }

    public void clickOnSaveFirstButton() {
        if (btnSaveFirst.isElementPresent()) {
            btnSaveFirst.clickJScript();
            reportLog("Click on Save First Button");
        }
    }

    public void clickOnCancelButton() {
        waitForSec(5);
        if (btnCancel.isElementPresent()) {
            btnCancel.mouseHover();
            btnCancel.clickJScript();
            reportLog("Click on Cancel Button");
        }
    }

    public void clickOnSaveButton() {
        waitForSec(5);
        if (btnSave.isElementPresent()) {
            btnSave.click();
            reportLog("Click On Save Button");
        }
    }

    public void clickOnCheckBoxClassName() {
        waitForSec(5);
        if (checkBoxClassName.isElementPresent()) {
            checkBoxClassName.click();
            reportLog("Click On checkBox Class Name");
        }
    }

    public void clickOnShowAnswerCheckBox() {
        if (checkBoxShowCorrectAnswer.isElementPresent()) {
            checkBoxShowCorrectAnswer.click();
            reportLog("Click On Show Correct Answer checkBox");
        }
    }

    public void hoverShowCorrectAnswerInfo() {
        if (iconAnswerInfo.isElementPresent()) {
            iconAnswerInfo.mouseHover();
            reportLog("Hover On Show Correct Answer Icon");
        }
    }

    public void setAssignmentName(String name1) {
        waitForSec(5);
        placeHolderAssignmentName.clickFirstFromListOfElements();
        assignmentName = name1 + currentTimeStamp();
        placeHolderAssignmentName.setText(assignmentName);
        reportLog("Successfully Set Name Of Assignment Name");
    }

    public boolean verifyNoDueDateIcon() {
        return iconArrowRight.isElementPresent();
    }

    public void clickOnNoDueDateIcon() {
        waitForSec(5);
        if (iconArrowRight.isElementPresent()) {
            iconArrowRight.clickJScript();
            reportLog("Click On No Due Date Icon");
        }
    }

    public boolean verifyAssignmentIsAvailableInClass() {
        waitForSec(5);
        List<WebElement> list = txtNamesOfAssignment.getWebElement().findElements(By.xpath(assignmentCountXpath));
        for (WebElement names : list) {
            if (assignmentName.equalsIgnoreCase(names.getText())) {
                reportLog("Assignment Is Successfully Assign To Class");
                return true;
            }
        }
        reportLog("Failed To Assign Assignment To Class");
        return false;
    }

    public void clickOnFirstQuiz() {
        waitForSec(5);
        List<WebElement> namesOfQuiz = txtNamesOfQuiz.getWebElement().findElements(By.xpath("//span[@class='concept-name']//span"));
        for (WebElement names : namesOfQuiz) {
            if (names.isDisplayed()) {
                names.click();
                quizName1 = names.getText();
                reportLog("Click on First Name Of Quiz And Quiz Name Is = " + quizName1);
                break;
            }
        }
    }

    public void getCountOfQuizSelectedBefore() {
        List<WebElement> count = checkBoxFirst.getWebElement().findElements(By.xpath("//label[@class='checkbox']//span"));
        for (WebElement select : count) {
            if (select.isSelected()) {
                count1++;
            }
        }
        reportLog("Total Number Of Selected Quiz Name Count is = " + count1);
    }

    public void getCountOfQuizSelectedAfter() {
        List<WebElement> count = checkBoxFirst.getWebElement().findElements(By.xpath("//label[@class='checkbox']//span"));
        for (WebElement select : count) {
            if (select.isSelected()) {
                count2++;
            }
        }
        reportLog("Total Number Of Selected Quiz Name Count is = " + count2);
    }

    public boolean verifySelectedQuizAfterRemoveConcept() {
        if (count1 != count2) {
            reportLog("SuccessFully Verify Quiz Name");
            return true;
        }
        reportLog("Failed To Verify Quiz Name");
        return false;
    }

    public void clickOnRemoveConceptButton() {
        if (btnRemoveConcept.isElementPresent()) {
            btnRemoveConcept.click();
            reportLog("Click On Remove Concept Button");
        }
    }

    public void getCountOfAssignmentBefore() {
        waitForSec(5);
        List<WebElement> count = txtNamesOfAssignment.getWebElement().findElements(By.xpath(assignmentCountXpath));
        assignmentCountBefore = count.size();
        reportLog("Successfully Get Count Of Assignment And Count is = " + assignmentCountBefore);
    }

    public void getCountOfAssignmentAfter() {
        waitForSec(5);
        List<WebElement> count = txtNamesOfAssignment.getWebElement().findElements(By.xpath(assignmentCountXpath));
        assignmentCountAfter = count.size();
        reportLog("Successfully Get Count Of Assignment And Count is = " + assignmentCountAfter);
    }

    public boolean verifyCountOfAssignmentAfterDelete() {
        if (assignmentCountBefore != assignmentCountAfter) {
            reportLog("SuccessFully Verify Count Of Assignment");
            return true;
        }
        reportLog("Failed To Verify Count Of Assignment");
        return false;
    }

    public boolean verifyCountOfAssignmentOnStudentSite() {
        if (assignmentCountBefore == assignmentCountAtStudent) {
            reportLog("SuccessFully Verify Count Of Assignment");
            return true;
        }
        reportLog("Failed To Verify Count Of Assignment");
        return false;
    }

    public boolean verifyDeleteAssignmentButton() {
        waitForSec(5);
        return btnDeleteAssignment.isElementPresent();
    }

    public void clickOnDeleteAssignmentButton() {
        if (btnDeleteAssignment.isElementPresent()) {
            btnDeleteAssignment.mouseHover();
            btnDeleteAssignment.clickJScript();
            reportLog("Click on Delete Assignment Button");
        }
    }

    public void scrollUpScreen() {
        waitForSec(5);
        if (btnUndoAssign.isElementPresent()) {
            btnUndoAssign.scrollIntoView();
            reportLog("Successfully Scroll The Screen");
        }
    }

    public void clickOnFirstAssignmentName() {
        txtNamesOfAssignment.clickFirstFromListOfElements();
        reportLog("Click On First Assignment");
        waitForSec(5);
    }

    public void clickOnAssignmentName() {
        if (txtNamesOfAssignment.isElementPresent()) {
            txtNamesOfAssignment.clickJScript();
            reportLog("Click On First Assignment");
        }
        waitForSec(5);
    }

    public boolean verifyYesDeleteAssignmentButton() {
        waitForSec(5);
        return btnYesDeleteAssignment.isElementPresent();
    }

    public void clickOnYesDeleteAssignmentButton() {
        if (btnYesDeleteAssignment.isElementPresent()) {
            btnYesDeleteAssignment.mouseHover();
            btnYesDeleteAssignment.click();
            reportLog("Click on Yes Delete Assignment Button");
        }
        waitForSec(5);
    }

    public void clickOnAssignmentButton() {
        waitForSec(2);
        if (btnAssignment.isElementPresent()) {
            btnAssignment.click();
            reportLog("Click On  Assignment Button");
        }
    }

    public void getCountOfAssignmentsNamesText() {
        waitForSec(2);
        List<WebElement> count = txtSpanAssignmentNames.getWebElements();
        assignmentCountAtStudent = count.size();
        reportLog("Successfully Get Count Of Assignment At Student Side And Count is = " + assignmentCountAtStudent);
    }

    public void verifyAssignmentIsVisibleToTheStudent(){

    }
}