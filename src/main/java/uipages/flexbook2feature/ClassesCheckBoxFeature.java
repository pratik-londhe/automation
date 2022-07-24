package uipages.flexbook2feature;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import uipages.BasePage;
import utils.GuiControl;

import java.util.List;

public class ClassesCheckBoxFeature extends BasePage {

    private int countOfClasses;

    private final GuiControl textOfClasses = new GuiControl(getElementMap().get("textOfClasses"), webDriver);
    private final GuiControl chkBoxLead = new GuiControl(getElementMap().get("chkBoxLead"), webDriver);
    private final GuiControl chkBoxMember = new GuiControl(getElementMap().get("chkBoxMember"), webDriver);
    private final GuiControl chkBoxCoTeacher = new GuiControl(getElementMap().get("chkBoxCoTeacher"), webDriver);
    private final GuiControl textHaveClasses = new GuiControl(getElementMap().get("textHaveClasses"), webDriver);

    public ClassesCheckBoxFeature(WebDriver webDriver, ExtentTest extentTest, ExtentReports extentReports) {
        super(webDriver, extentTest, extentReports);
    }

    public boolean verifyTextOfClasses() {
        waitForSec(5);
        List<WebElement> classesCount = textOfClasses.getWebElements();
        int countOfClasses = classesCount.size();
        reportLog("Count Of Classes Are = " + countOfClasses);
        if (countOfClasses >= 1) {
            return true;
        }
        return false;
    }

    public boolean verifyIsLeadCheckBox() {
        return chkBoxLead.isElementPresent();
    }

    public void clickOnIsLeadCheckBox() {
        if (chkBoxLead.isElementPresent()) {
            chkBoxLead.clickJScript();
            reportLog("clicked on Is Lead CheckBox");
        }
    }

    public boolean verifyIsMemberCheckBox() {
        return chkBoxMember.isElementPresent();
    }

    public void clickOnIsMemberCheckBox() {
        if (chkBoxMember.isElementPresent()) {
            chkBoxMember.clickJScript();
            reportLog("clicked on Is Member CheckBox");
        }
    }

    public boolean verifyIsCoTeacherCheckBox() {
        return chkBoxCoTeacher.isElementPresent();
    }

    public void clickOnIsCoTeacherCheckBox() {
        if (chkBoxCoTeacher.isElementPresent()) {
            chkBoxCoTeacher.clickJScript();
            reportLog("clicked on Is CoTeacher CheckBox");
        }
    }

    public void getCountOfClasses() {
        waitForSec(5);
        List<WebElement> classesCount = textOfClasses.getWebElements();
        countOfClasses = classesCount.size();
        reportLog("Count Of Classes Are = " + countOfClasses);
    }

    public boolean verifyClassesWhenTeacherIsMemberLeadAndCoTeacher() {
        if (countOfClasses >= 1) {
            reportLog("Successfully Verify All the Classes When Teacher Is Lead , Member And CoTeacher");
            return true;
        }
        return false;
    }

    public boolean verifyClassesWhenTeacherIsMemberAndLead() {
        if (countOfClasses >= 1) {
            reportLog("Successfully Verify All the Classes When Teacher Is Lead And Member");
            return true;
        }
        return false;
    }

    public boolean verifyClassesWhenTeacherIsMember() {
        if (countOfClasses <= 1) {
            reportLog("Successfully Verify All the Classes When Teacher Member");
            return true;
        }
        return false;
    }

    public boolean verifyIDoNotHaveClassesText() {
        return textHaveClasses.isElementPresent();
    }

    public boolean verifyClassesWhenTeacherIsLead() {
        if (countOfClasses >= 1) {
            reportLog("Successfully Verify All the Classes When Teacher Lead");
            return true;
        }
        return false;
    }

    public boolean verifyClassesWhenTeacherIsLeadAndCoTeacher() {
        if (countOfClasses >= 1) {
            reportLog("Successfully Verify All the Classes When Teacher Is Lead , Member And CoTeacher");
            return true;
        }
        return false;
    }

//    public boolean verifyClassesWhenTeacherIsCoTeacher() {
//        if(countOfClasses<=2){
//            reportLog("Successfully Verify All the Classes When Teacher Lead");
//            return true;
//        }
//        return false;
// }

    public boolean verifyClassesWhenTeacherIsMemberAndCoTeacher() {
        if (countOfClasses <= 1) {
            reportLog("Successfully Verify All the Classes When Teacher Is Lead , Member And CoTeacher");
            return true;
        }
        return false;
    }
}