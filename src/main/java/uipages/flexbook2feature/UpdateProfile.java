package uipages.flexbook2feature;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import uipages.BasePage;
import utils.GuiControl;

public class UpdateProfile extends BasePage {

    private String userName;

    private final GuiControl textTeacherProfile = new GuiControl(getElementMap().get("textTeacherProfile"), webDriver);
    private final GuiControl btnEdit = new GuiControl(getElementMap().get("btnEdit"), webDriver);
    private final GuiControl textWelcomeToCk12 = new GuiControl(getElementMap().get("textWelcomeToCk12"), webDriver);
    private final GuiControl btnClose = new GuiControl(getElementMap().get("btnClose"), webDriver);
    private final GuiControl btnChangeLocation = new GuiControl(getElementMap().get("btnChangeLocation"), webDriver);
    private final GuiControl dropdownGrade = new GuiControl(getElementMap().get("dropdownGrade"), webDriver);
    private final GuiControl dropdownSubjects = new GuiControl(getElementMap().get("dropdownSubjects"), webDriver);
    private final GuiControl linkKindergarten = new GuiControl(getElementMap().get("linkKindergarten"), webDriver);
    private final GuiControl containerScience = new GuiControl(getElementMap().get("containerScience"), webDriver);
    private final GuiControl containerMath = new GuiControl(getElementMap().get("containerMath"), webDriver);
    private final GuiControl containerEnglish = new GuiControl(getElementMap().get("containerEnglish"), webDriver);
    private final GuiControl checkBoxEarthScience = new GuiControl(getElementMap().get("checkBoxEarthScience"), webDriver);
    private final GuiControl checkBoxLifeCycle = new GuiControl(getElementMap().get("checkBoxLifeCycle"), webDriver);
    private final GuiControl checkBoxGrade1 = new GuiControl(getElementMap().get("checkBoxGrade1"), webDriver);
    private final GuiControl checkBoxGrade2 = new GuiControl(getElementMap().get("checkBoxGrade2"), webDriver);
    private final GuiControl checkBoxSpelling = new GuiControl(getElementMap().get("checkBoxSpelling"), webDriver);
    private final GuiControl userNamePlaceHolder = new GuiControl(getElementMap().get("userNamePlaceHolder"), webDriver);
    private final GuiControl btnUpdateProfile = new GuiControl(getElementMap().get("btnUpdateProfile"), webDriver);
    private final GuiControl textEnterYourName = new GuiControl(getElementMap().get("textEnterYourName"), webDriver);

    public UpdateProfile(WebDriver webDriver, ExtentTest extentTest, ExtentReports extentReports) {
        super(webDriver, extentTest, extentReports);
    }

    public boolean verifyTeacherProfileText() {
        waitForSec(5);
        return textTeacherProfile.isElementPresent();
    }

    public boolean verifyWelcomeToCk12Text() {
        waitForSec(5);
        return textWelcomeToCk12.isElementPresent();
    }

    public boolean verifyEditButton() {
        return btnEdit.isElementPresent();
    }

    public void clickOnEditButton() {
        if (btnEdit.isElementPresent()) {
            btnEdit.clickJScript();
            reportLog("Successfully click On Edit Button");
        }
    }

    public boolean verifyChangeLocationButton() {
        return btnChangeLocation.isElementPresent();
    }

    public void clickOnChangeLocationButton() {
        if (btnChangeLocation.isElementPresent()) {
            btnChangeLocation.clickJScript();
            reportLog("Successfully click On Change Location Button");
        }
    }

    public boolean verifyCloseButton() {
        return btnClose.isElementPresent();
    }

    public void clickOnCloseButton() {
        if (btnClose.isElementPresent()) {
            btnClose.clickJScript();
            reportLog("Successfully click On Close Button");
        }
    }

    public boolean verifyGradeDropDown() {
        return dropdownGrade.isElementPresent();
    }

    public void clickOnGradeDropDown() {
        if (dropdownGrade.isElementPresent()) {
            dropdownGrade.clickJScript();
            reportLog("Successfully click On Grade DropDown");
        }
    }

    public boolean verifySubjectDropDown() {
        return dropdownSubjects.isElementPresent();
    }

    public void clickOnSubjectDropDown() {
        if (dropdownSubjects.isElementPresent()) {
            dropdownSubjects.clickJScript();
            reportLog("Successfully click On Grade DropDown");
        }
    }

    public boolean verifyKindgartenLink() {
        return linkKindergarten.isElementPresent();
    }

    public boolean verifyScienceContainer() {
        return containerScience.isElementPresent();
    }

    public void clickOnScienceContainer() {
        if (containerScience.isElementPresent()) {
            containerScience.clickJScript();
            reportLog("Successfully click On Science Container");
        }
    }

    public boolean verifyMathContainer() {
        return containerMath.isElementPresent();
    }

    public void clickOnMathContainer() {
        if (containerMath.isElementPresent()) {
            containerMath.clickJScript();
            reportLog("Successfully click On Math Container");
        }
    }

    public boolean verifyEnglishContainer() {
        return containerEnglish.isElementPresent();
    }

    public void clickOnEnglishContainer() {
        if (containerEnglish.isElementPresent()) {
            containerEnglish.clickJScript();
            reportLog("Successfully click On English Container");
        }
    }

    public boolean verifyEarthScienceContainer() {
        return checkBoxEarthScience.isElementPresent();
    }

    public boolean verifyLifeScienceContainer() {
        return checkBoxLifeCycle.isElementPresent();
    }

    public boolean verifyGrade1Container() {
        return checkBoxGrade1.isElementPresent();
    }

    public boolean verifyGrade2Container() {
        return checkBoxGrade2.isElementPresent();
    }

    public boolean verifySpellingContainer() {
        return checkBoxSpelling.isElementPresent();
    }

    public void removeNameFromUserNamePlaceHolder() {
        String name="teacher123";
        for(int i=0;i<=name.length();i++){
            userNamePlaceHolder.sendKeys(String.valueOf(Keys.BACK_SPACE));
        }
        reportLog("Successfully Remove Name From UserName PlaceHolder.");
    }

    public void changeUserName() {
        userName = "teacher123";
        userNamePlaceHolder.setText(userName);
        reportLog("Successfully Change UserName And Current UserName Is = " + userName);
    }

    public boolean verifyUpdateProfileButton() {
        return btnUpdateProfile.isElementPresent();
    }

    public void clickOnUpdateProfileButton() {
        if (btnUpdateProfile.isElementPresent()) {
            btnUpdateProfile.clickJScript();
            reportLog("Successfully click On Update Profile Button");
        }
    }

    public boolean verifyEnterYourNameText() {
        waitForSec(5);
        return textEnterYourName.isElementPresent();
    }

    public boolean verifyUpdatedUserName() {
        waitForSec(5);
        return userName.equalsIgnoreCase(textTeacherProfile.getText());
    }
}