package uipages.flexbook2feature;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import uipages.BasePage;
import utils.GuiControl;
import java.util.List;

public class CreateNewClassAndDeleteClass extends BasePage {

    private String className;
    private String deleteClassName;

    private final GuiControl btnCreateNewClass = new GuiControl(getElementMap().get("btnCreateNewClass"), webDriver);
    private final GuiControl placeHolderClassName = new GuiControl(getElementMap().get("placeHolderClassName"), webDriver);
    private final GuiControl btnCreateAClass = new GuiControl(getElementMap().get("btnCreateAClass"), webDriver);
    private final GuiControl txtErrorEnterYourName = new GuiControl(getElementMap().get("txtErrorEnterYourName"), webDriver);
    private final GuiControl spanNamesOfClass = new GuiControl(getElementMap().get("spanNamesOfClass"), webDriver);
    private final GuiControl textWelcomeInNewClass = new GuiControl(getElementMap().get("textWelcomeInNewClass"), webDriver);
    private final GuiControl btnDelete = new GuiControl(getElementMap().get("btnDelete"), webDriver);
    private final GuiControl btnCancel = new GuiControl(getElementMap().get("btnCancel"), webDriver);
    private final GuiControl textDeleteClassName = new GuiControl(getElementMap().get("textDeleteClassName"), webDriver);
    private final GuiControl btnAssignment = new GuiControl(getElementMap().get("btnAssignment"), webDriver);
    private final GuiControl btnCreateClass = new GuiControl(getElementMap().get("btnCreateClass"), webDriver);

    public CreateNewClassAndDeleteClass(WebDriver webDriver, ExtentTest extentTest, ExtentReports extentReports) {
        super(webDriver, extentTest, extentReports);
    }

    public boolean verifyCreateNewClassButton() {
        return btnCreateNewClass.isElementPresent();
    }

    public void clickOnCreateNewClassButton() {
        waitForSec(5);
        if (btnCreateNewClass.isElementPresent()) {
            btnCreateNewClass.click();
            reportLog("Successfully Click On Create New Class Button");
        }
    }

    public boolean verifyErrorClassNameMessage() {
        return txtErrorEnterYourName.isElementPresent();
    }

    public void setValueInClassNamePlaceHolder(String name) {
        if (placeHolderClassName.isElementPresent()) {
            placeHolderClassName.click();
            placeHolderClassName.setText(name);
            reportLog("Successfully Set Name In  Class Name PlaceHolder");
        }
    }

    public void scrollIntoAssignment() {
        if (btnAssignment.isElementPresent()) {
            btnAssignment.scrollIntoView();
            reportLog("Successfully Scroll The Screen");
        }
    }

    public void setValueInClassNamePlaceHolderAgain(String name) {
        if (placeHolderClassName.isElementPresent()) {
            placeHolderClassName.click();
            className = name + currentTimeStamp();
            placeHolderClassName.setText(className);
            reportLog("Successfully Set Name In  Class Name PlaceHolder And Name Is = " + className);
        }
    }

    public boolean verifyCreateAClassButton() {
        waitForSec(5);
        return btnCreateAClass.isElementPresent();
    }

    public void clickOnCreateAClassButton() {
        waitForSec(10);
        if (btnCreateAClass.isElementPresent()) {
            btnCreateAClass.click();
            reportLog("Successfully Click On Create A Class Button");
        }
    }

    public boolean verifyCreateClassButton() {
        waitForSec(5);
        return btnCreateClass.isElementPresent();
    }

    public void clickOnCreateClassButton() {
        if (btnCreateClass.isElementPresent()) {
            btnCreateClass.click();
            logger.info("Successfully Click On Create Class Button");
        }
    }


    public boolean verifyNewClassIsAddedInList() {
        waitForSec(5);
        //List<WebElement> link = spanNamesOfClass.getWebElement().findElements(By.xpath("//div[@class='scss-components-GroupCard__headerTitles___Nls9A']//a[1]"));
        List<WebElement> link = spanNamesOfClass.getWebElement().findElements(By.xpath("//a[@data-dx-desc='Go to group page']/span"));
        for (WebElement linksName : link) {
            if (linksName.getText().equalsIgnoreCase(className)) {
                reportLog("Class NAme Is Successfully Added");
                return true;
            }
        }
        return false;
    }

    public boolean verifyWelcomeInNewClassText() {
        return textWelcomeInNewClass.isElementPresent();
    }

    public boolean verifyDeleteButton() {
        waitForSec(5);
        return btnDelete.isElementPresent();
    }

    public void clickOnDeleteButton() {
        if (btnDelete.isElementPresent()) {
            btnDelete.click();
            reportLog("Successfully Click On Delete Button");
            waitForSec(5);
        }
    }

    public boolean verifyCancelButton() {
        return btnCancel.isElementPresent();
    }

    public void clickOnCancelButton() {
        if (btnCancel.isElementPresent()) {
            btnCancel.click();
            reportLog("Successfully Click On Cancel Button");
        }
    }

    public void getTextOfClassName() {
        if (textDeleteClassName.isElementPresent()) {
            deleteClassName=textDeleteClassName.getText();
            reportLog("Successfully Get Class Name And Class Name Is = " + deleteClassName);
        }
    }

    public boolean verifyClassIsNotPresentInList() {
        waitForSec(5);
        List<WebElement> link = spanNamesOfClass.getWebElement().findElements(By.xpath("//div[@class='scss-components-GroupCard__headerTitles___Nls9A']//a[1]"));
        for (WebElement linksName : link) {
            if (!(linksName.getText().equalsIgnoreCase(deleteClassName))) {
                reportLog("Class Is Successfully Deleted");
                return true;
            }
        }
        return false;
    }
}