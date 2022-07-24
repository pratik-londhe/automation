package uipages.reports2feature;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import uipages.BasePage;
import utils.GuiControl;
import java.util.List;

public class TeacherReports extends BasePage {

    private int countOfStudent;

    private final GuiControl linkNoDueDate = new GuiControl(getElementMap().get("linkNoDueDate"), webDriver);
    private final GuiControl linkAssignmentName = new GuiControl(getElementMap().get("linkAssignmentName"), webDriver);
    private final GuiControl btnUndoAssign = new GuiControl(getElementMap().get("btnUndoAssign"), webDriver);
    private final GuiControl btnRemoveIt = new GuiControl(getElementMap().get("btnRemoveIt"), webDriver);
    private final GuiControl btnAssign = new GuiControl(getElementMap().get("btnAssign"), webDriver);
    private final GuiControl btnYesAssign = new GuiControl(getElementMap().get("btnYesAssign"), webDriver);
    private final GuiControl linkStudentAssignmentName = new GuiControl(getElementMap().get("linkStudentAssignmentName"), webDriver);
    private final GuiControl btnStart = new GuiControl(getElementMap().get("btnStart"), webDriver);
    private final GuiControl btnTurnIn = new GuiControl(getElementMap().get("btnTurnIn"), webDriver);
    private final GuiControl btnTryAgain = new GuiControl(getElementMap().get("btnTryAgain"), webDriver);
    private final GuiControl btnSubmit = new GuiControl(getElementMap().get("btnSubmit"), webDriver);
    private final GuiControl btnOptionTrue = new GuiControl(getElementMap().get("btnOptionTrue"), webDriver);
    private final GuiControl btnNext = new GuiControl(getElementMap().get("btnNext"), webDriver);
    private final GuiControl btnYesSubmit = new GuiControl(getElementMap().get("btnYesSubmit"), webDriver);
    private final GuiControl btnTurnInConfirm = new GuiControl(getElementMap().get("btnTurnInConfirm"), webDriver);
    private final GuiControl textStudentName = new GuiControl(getElementMap().get("textStudentName"), webDriver);
    private final GuiControl textStudentNameData = new GuiControl(getElementMap().get("textStudentNameData"), webDriver);
    private final GuiControl textPercentage = new GuiControl(getElementMap().get("textPercentage"), webDriver);

    public TeacherReports(WebDriver webDriver, ExtentTest extentTest, ExtentReports extentReports) {
        super(webDriver, extentTest, extentReports);
    }

    public boolean verifyNoDueDateLink() {
        waitForSec(5);
        return linkNoDueDate.isElementPresent();
    }

    public void clickOnNoDueDateLink(){
        if(linkNoDueDate.isElementPresent()){
            linkNoDueDate.click();
            reportLog("Successfully clicked On No Due Date Link");
        }
    }

    public boolean verifyAssignmentNameLink() {
        return linkAssignmentName.isElementPresent();
    }

    public void clickOnAssignmentNameLink(){
        if(linkAssignmentName.isElementPresent()){
            linkAssignmentName.click();
            reportLog("Successfully clicked On Assignment Name Link");
        }
    }

    public boolean verifyUndoAssignButton() {
        waitForSec(5);
        linkAssignmentName.scrollIntoView();
        return btnUndoAssign.isElementPresent();
    }

    public void clickOnUndoAssignButton(){
        if(btnUndoAssign.isElementPresent()){
            btnUndoAssign.click();
            reportLog("Successfully clicked On Undo Assign Button");
        }
    }

    public boolean verifyYesRemoveItButton() {
        waitForSec(2);
        return btnRemoveIt.isElementPresent();
    }

    public void clickOnYesRemoveItButton(){
        if(btnRemoveIt.isElementPresent()){
            btnRemoveIt.click();
            reportLog("Successfully clicked On Undo Assign Button");
        }
    }

    public boolean verifyAssignButton() {
        waitForSec(5);
        return btnAssign.isElementPresent();
    }

    public void clickOnAssignButton(){
        if(btnAssign.isElementPresent()){
            btnAssign.click();
            reportLog("Successfully clicked On Assign Button");
        }
    }

    public boolean verifyYesAssignButton() {
        waitForSec(2);
        return btnYesAssign.isElementPresent();
    }

    public void clickOnYesAssignButton(){
        if(btnYesAssign.isElementPresent()){
            btnYesAssign.click();
            reportLog("Successfully clicked On Yes Assign Button");
        }
    }

    public boolean verifyStudentAssignmentLink() {
        return linkStudentAssignmentName.isElementPresent();
    }

    public void clickOnStudentAssignmentLink(){
        if(linkStudentAssignmentName.isElementPresent()){
            linkStudentAssignmentName.click();
            reportLog("Successfully clicked On Student Assignment Link");
        }
    }

    public boolean verifyStartButton() {
        waitForSec(5);
        return btnStart.isElementPresent();
    }

    public void clickOnStartButton(){
        if(btnStart.isElementPresent()){
            btnStart.click();
            reportLog("Successfully clicked On Start Button");
        }
    }

    public boolean verifyTurnInButton() {
        return btnTurnIn.isElementPresent();
    }

    public void clickOnTurnInButton(){
        if(btnTurnIn.isElementPresent()){
            btnTurnIn.click();
            reportLog("Successfully clicked On Turn In Button");
        }
    }

    public boolean verifyTryAgainButton() {
        waitForSec(5);
        if(btnTryAgain.isElementPresent()){
            btnTurnIn.scrollIntoView();
           return true;
        }
        return false;
    }

    public void clickOnTryAgainButton(){
        if(btnTryAgain.isElementPresent()){
            btnTryAgain.click();
            reportLog("Successfully clicked On Turn In Button");
        }
    }

    public boolean verifySubmitButton() {
        waitForSec(2);
        return btnSubmit.isElementPresent();
    }

    public void clickOnSubmitButton(){
        if(btnSubmit.isElementPresent()){
            btnSubmit.click();
            reportLog("Successfully clicked On Submit Button");
        }
    }

    public boolean verifyTrueOptionButton() {
        waitForSec(5);
        return btnOptionTrue.isElementPresent();
    }

    public void clickOnTrueOptionButton(){
        if(btnOptionTrue.isElementPresent()){
            btnOptionTrue.click();
            reportLog("Successfully clicked On True Option Button");
        }
    }

    public boolean verifyNextButton() {
        waitForSec(5);
        return btnNext.isElementPresent();
    }

    public void clickOnNextButton(){
        if(btnNext.isElementPresent()){
            btnNext.click();
            reportLog("Successfully clicked On Next Button");
        }
    }

    public boolean verifyYesSubmitButton() {
        return btnYesSubmit.isElementPresent();
    }

    public void clickOnYesSubmitButton(){
        if(btnYesSubmit.isElementPresent()){
            btnYesSubmit.click();
            reportLog("Successfully clicked On Yes Submit Button");
        }
    }

    public boolean verifyTurnInConfirmButton() {
        waitForSec(2);
        return btnTurnInConfirm.isElementPresent();
    }

    public void clickOnTurnInConfirmButton(){
        if(btnTurnInConfirm.isElementPresent()){
            btnTurnInConfirm.clickJScript();
            reportLog("Successfully clicked On Turn In Button");
        }
    }

    public void getCountOfStudent() {
        List<WebElement> studentCount = textStudentName.getWebElements();
        countOfStudent=studentCount.size();
        reportLog("Total Number Of Student In report Is = " + countOfStudent);
    }

    public boolean verifyStudentInformation(){
        if(countOfStudent <= 4){
            reportLog("Reports Data is visible For All Student");
            return true;
        }
        return false;
    }
}
