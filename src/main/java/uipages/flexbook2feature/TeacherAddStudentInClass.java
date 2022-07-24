package uipages.flexbook2feature;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import utils.GuiControl;

import java.util.List;

public class TeacherAddStudentInClass extends PageMenuTab {

    private int studentBeforeCount;
    private int studentAfterCount;
    private String student1;
    private String student2;
    private String student3;

    private final GuiControl iconClassName = new GuiControl(getElementMap().get("iconClassName"), webDriver);
    private final GuiControl btnOk = new GuiControl(getElementMap().get("btnOk"), webDriver);
    private final GuiControl btnMember = new GuiControl(getElementMap().get("btnMember"), webDriver);
    private final GuiControl btnAddStudent = new GuiControl(getElementMap().get("btnAddStudent"), webDriver);
    private final GuiControl linkWithoutEmailIcon = new GuiControl(getElementMap().get("linkWithoutEmailIcon"), webDriver);
    private final GuiControl txtUserName = new GuiControl(getElementMap().get("txtUserName"), webDriver);
    private final GuiControl txtUniqueName = new GuiControl(getElementMap().get("txtUniqueName"), webDriver);
    private final GuiControl txtUserPassword = new GuiControl(getElementMap().get("txtUserPassword"), webDriver);
    private final GuiControl btnCreate = new GuiControl(getElementMap().get("btnCreate"), webDriver);
    private final GuiControl btnViewReport = new GuiControl(getElementMap().get("btnViewReport"), webDriver);
    private final GuiControl btnStudentInfo = new GuiControl(getElementMap().get("btnStudentInfo"), webDriver);
    private final GuiControl btnFixErrors = new GuiControl(getElementMap().get("btnFixErrors"), webDriver);
    private final GuiControl findExistingButton = new GuiControl(getElementMap().get("findExistingButton"), webDriver);
    private final GuiControl linkAlreadyInLibrary = new GuiControl(getElementMap().get("linkAlreadyInLibrary"), webDriver);
    private final GuiControl tabEmailStudent = new GuiControl(getElementMap().get("tabEmailStudent"), webDriver);
    private final GuiControl tabWithEmail = new GuiControl(getElementMap().get("tabWithEmail"), webDriver);
    private final GuiControl iconCross = new GuiControl(getElementMap().get("iconCross"), webDriver);
    private final GuiControl txtFirstName1 = new GuiControl(getElementMap().get("txtFirstName1"), webDriver);
    private final GuiControl txtFirstName2 = new GuiControl(getElementMap().get("txtFirstName2"), webDriver);
    private final GuiControl txtFirstName3 = new GuiControl(getElementMap().get("txtFirstName3"), webDriver);
    private final GuiControl txtUserName1 = new GuiControl(getElementMap().get("txtUserName1"), webDriver);
    private final GuiControl txtUserName2 = new GuiControl(getElementMap().get("txtUserName2"), webDriver);
    private final GuiControl txtUserName3 = new GuiControl(getElementMap().get("txtUserName3"), webDriver);
    private final GuiControl txtPassword1 = new GuiControl(getElementMap().get("txtPassword1"), webDriver);
    private final GuiControl txtPassword2 = new GuiControl(getElementMap().get("txtPassword2"), webDriver);
    private final GuiControl txtPassword3 = new GuiControl(getElementMap().get("txtPassword3"), webDriver);
    private final GuiControl btnAdd = new GuiControl(getElementMap().get("btnAdd"), webDriver);
    private final GuiControl txtErrorMessage = new GuiControl(getElementMap().get("txtErrorMessage"), webDriver);
    private final GuiControl iconValid = new GuiControl(getElementMap().get("iconValid"), webDriver);
    private final GuiControl iconInvalid = new GuiControl(getElementMap().get("iconInvalid"), webDriver);

    public TeacherAddStudentInClass(WebDriver webDriver, ExtentTest extentTest, ExtentReports extentReports) {
        super(webDriver, extentTest, extentReports);
    }

    public void clickOnClassNameIcon(){
        waitForSec(5);
        iconClassName.clickJScript();
        reportLog("Clicked On the First Class");
    }

    public boolean verifyMemberButton() {
        waitForSec(5);
        btnMember.scrollIntoView();
        return btnMember.isElementPresent();
    }

    public void clickOnMemberOption() {
        waitForSec(4);
        if (btnMember.isElementPresent()) {
            btnMember.clickJScript();
            reportLog("Clicked on the 'Member' option.");
        }
    }

    public void clickOnOkButton() {
        waitForSec(5);
        try {
            if (btnOk.isElementPresent()) {
                btnOk.clickJScript();
                reportLog("Clicked on OK button.");
            }
        } catch (Exception e) {
            logger.error("'Ok'buton is not displayed. Printing stack trace and continuing execution... " + "\n" + e);
        }
    }

    public void clickOnAddStudentButton() {
        waitForSec(5);
        if (btnAddStudent.isElementPresent()) {
            btnAddStudent.mouseHover();
            btnAddStudent.click();
            reportLog("Clicked on Add Student Button");
        }
    }

    public void verifyAddStudentButton(){
        waitForSec(5);
         btnAddStudent.waitForPageLoaded();
    }

    public void clickOnAddStudentWithoutEmail() {
        if (linkWithoutEmailIcon.isElementPresent()) {
            linkWithoutEmailIcon.mouseHover();
            linkWithoutEmailIcon.click();
            reportLog("Clicked on Add Student Without Email Link");
        }
    }

    public void setFirstName(String userName) {
        if (txtUserName.isElementPresent()) {
            txtUserName.setText(userName + currentTimeStamp());
            String studentName = txtUserName.getAttribute("Value");
            reportLog("Student Name is = " + studentName);
        }
    }

    public void setUniqueName(String uniqueName) {
        if (txtUniqueName.isElementPresent()) {
            txtUniqueName.setText(uniqueName + currentTimeStamp());
        }
    }

    public void setDuplicateUniqueName(String uniqueName) {
        txtUniqueName.setText(uniqueName);
    }

    public void setUserPassword(String userPassword) {
        txtUserPassword.setText(userPassword);
    }

    public void clickOnCreate() {
        if (btnCreate.isElementPresent()) {
            btnCreate.click();
            reportLog("Clicked on 'Create' Button");
        }
    }

    public void clickOnViewReport() {
        if (btnViewReport.isElementPresent()) {
            btnViewReport.click();
            reportLog("Clicked on 'View Report' Button");
        }
    }

    public boolean verifyHomeIcon() {
        waitForSec(10);
        return btnStudentInfo.isElementPresent();
    }

    public boolean verifyFixErrorsButton() {
        return btnFixErrors.isElementPresent();
    }

    public void clickOnFixErrorsButton() {
        if (btnFixErrors.isElementPresent()) {
            btnFixErrors.click();
            reportLog("Clicked on 'Fix Error' Button");
        }
    }

    public void clickOnFindExistingButton() {
        if (findExistingButton.isElementPresent()) {
            findExistingButton.mouseHover();
            findExistingButton.click();
            reportLog("Clicked on 'Find Existing' Link");
        }
    }

    public boolean verifyAlreadyInLibrary() {
        return linkAlreadyInLibrary.isElementPresent();
    }

    public boolean verifyEmailIcon() {
        return tabEmailStudent.isElementPresent();
    }

    public boolean verifyCrossBar() {
        return iconCross.isElementPresent();
    }

    public void clickOnCrossBar() {
        if (iconCross.isElementPresent()) {
            iconCross.mouseHover();
            iconCross.click();
            reportLog("Clicked on Cross Bar Icon");
        }
    }

    public void clickOnAddWithEmail() {
        if (tabWithEmail.isElementPresent()) {
            tabWithEmail.mouseHover();
            tabWithEmail.click();
            reportLog("Clicked on 'Add with Email' Link");
        }
    }

    public void studentBeforeAdded() {
        waitForSec(5);
        List<WebElement> studentBefore = webDriver.findElements(By.xpath("//span[@class='ie8text']"));
        studentBeforeCount = studentBefore.size();
        reportLog("Count Of Student is__" + studentBeforeCount);
    }

    public void studentAfterAdded() {
        waitForSec(5);
        List<WebElement> studentAfter = webDriver.findElements(By.xpath("//span[@class='ie8text']"));
        studentAfterCount = studentAfter.size();
        reportLog("Count Of Student is__" + studentAfterCount);
    }

    public boolean verifyTheStudentInfo() {
        return studentBeforeCount != studentAfterCount;
    }

    public boolean verifyAddButton() {
        return btnAdd.isElementPresent();
    }

    public void clickOnAddButton() {
        if (btnAdd.isElementPresent()) {
            btnAdd.click();
            reportLog("Successfully Click on Add Button");
        }
    }

    public boolean verifyFirstName2() {
        return txtFirstName2.isElementPresent();
    }

    public boolean verifyUserName2() {
        return txtUserName2.isElementPresent();
    }

    public boolean verifyPassword2() {
        return txtPassword2.isElementPresent();
    }

    public void setFirstName1(String userName) {
        txtFirstName1.setText(userName + currentTimeStamp());
        waitForSec(5);
    }

    public void setFirstName2(String userName) {
        txtFirstName2.setText(userName + currentTimeStamp());
        waitForSec(5);
    }

    public String setUniqueName1(String uniqueName) {
        student1=uniqueName + currentTimeStamp();
        txtUserName1.setText(student1);
        return student1;
    }

    public String setUniqueName2(String uniqueName) {
        student2=uniqueName + currentTimeStamp();
        txtUserName2.setText(student2);
        return student2;
    }

    public void setUserPassword1(String userPassword) {
        txtPassword1.setText(userPassword);
    }

    public void setUserPassword2(String userPassword) {
        txtPassword2.setText(userPassword);
    }

    public void setDuplicateUniqueName1(String uniqueName) {
        txtUserName1.setText(uniqueName);
    }

    public void setDuplicateUniqueName2(String uniqueName) {
        txtUserName2.setText(uniqueName);
    }

    public boolean verifyErrorMessage() {
        List<WebElement> errorMessage = txtErrorMessage.getWebElement().findElements(By.xpath("//div[@class='large-12 columns error-message']"));
        return errorMessage.size() > 1;
    }

    public boolean verifyValidIcon() {
        return iconValid.isElementPresent();
    }

    public boolean verifyInvalidIcon() {
        return iconInvalid.isElementPresent();
    }
}