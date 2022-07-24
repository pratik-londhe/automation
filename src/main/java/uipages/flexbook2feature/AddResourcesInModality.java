package uipages.flexbook2feature;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import uipages.BasePage;
import utils.GuiControl;
import java.io.File;

public class AddResourcesInModality extends BasePage {
    private static final Logger logger = Logger.getLogger(AddResourcesInModality.class);

    private final GuiControl tabResources = new GuiControl(getElementMap().get("tabResources"), webDriver);
    private final GuiControl btnUploadFiles = new GuiControl(getElementMap().get("btnUploadFiles"), webDriver);
    private final GuiControl linkOfFile = new GuiControl(getElementMap().get("linkOfFile"), webDriver);
    private final GuiControl iconClose = new GuiControl(getElementMap().get("iconClose"), webDriver);
    private final GuiControl linkMakePublic = new GuiControl(getElementMap().get("linkMakePublic"), webDriver);
    private final GuiControl btnRemove = new GuiControl(getElementMap().get("btnRemove"), webDriver);
    private final GuiControl btnCancel = new GuiControl(getElementMap().get("btnCancel"), webDriver);
    private final GuiControl pathOfFile = new GuiControl(getElementMap().get("pathOfFile"), webDriver);
    private final GuiControl btnEditResources = new GuiControl(getElementMap().get("btnEditResources"), webDriver);
    private final GuiControl btnCancelEdit = new GuiControl(getElementMap().get("btnCancelEdit"), webDriver);
    private final GuiControl btnSave = new GuiControl(getElementMap().get("btnSave"), webDriver);
    private final GuiControl btnCancelEditResources = new GuiControl(getElementMap().get("btnCancelEditResources"), webDriver);
    private final GuiControl textEditResources = new GuiControl(getElementMap().get("textEditResources"), webDriver);
    private final GuiControl checkBoxPublished = new GuiControl(getElementMap().get("checkBoxPublished"), webDriver);
    private final GuiControl textPleaseEnterDescription = new GuiControl(getElementMap().get("textPleaseEnterDescription"), webDriver);
    private final GuiControl placeHolderDescription = new GuiControl(getElementMap().get("placeHolderDescription"), webDriver);
    private final GuiControl iconEdit = new GuiControl(getElementMap().get("iconEdit"), webDriver);

    public AddResourcesInModality(WebDriver webDriver, ExtentTest extentTest, ExtentReports extentReports) {
        super(webDriver,extentTest,extentReports);
    }

    public boolean verifyResourcesTab() {
        return tabResources.isElementPresent();
    }

    public void clickOnResourcesTab() {
        if (tabResources.isElementPresent()) {
            tabResources.clickJScript();
            reportLog("Successfully clicked on Resources Tab");
        }
    }

    public boolean verifyUploadFilesButton() {
        waitForSec(5);
        return btnUploadFiles.isElementPresent();
    }

    public void setPathOfFile() {
        pathOfFile.sendKeys(System.getProperty("user.dir") + File.separator + "src" + File.separator + "test" + File.separator + "resources" + File.separator + "images" + File.separator + "textbooks.jpg");
        reportLog("Successfully Upload File");
    }

    public boolean verifyUploadedFilesAreVisible() {
        waitForSec(5);
        return linkOfFile.isElementPresent();
    }

    public boolean verifyCloseIcon() {
        return iconClose.isElementPresent();
    }

    public void clickOnCloseIcon() {
        if (iconClose.isElementPresent()) {
            iconClose.clickJScript();
            reportLog("Successfully clicked on Close Icon");
        }
    }

    public boolean verifyMakePublicLink() {
        linkOfFile.mouseHover();
        return linkMakePublic.isElementPresent();
    }

    public void clickOnMakePublicLink() {
        linkOfFile.mouseHover();
        if (linkMakePublic.isElementPresent()) {
            linkMakePublic.clickJScript();
            reportLog("Successfully clicked on Make Public Link");
        }
    }

    public boolean verifyRemoveButton() {
        return btnRemove.isElementPresent();
    }

    public void clickOnRemoveButton() {
        if (btnRemove.isElementPresent()) {
            btnRemove.clickJScript();
            reportLog("Successfully clicked on Remove Button");
        }
    }

    public boolean verifyCancelButton() {
        waitForSec(5);
        return btnCancel.isElementPresent();
    }

    public boolean verifyEditResourcesButton() {
        waitForSec(5);
        return btnEditResources.isElementPresent();
    }

    public void clickOnEditResourcesButton() {
        if (btnEditResources.isElementPresent()) {
            btnEditResources.clickJScript();
            reportLog("Successfully clicked on Edit Resources Button");
        }
    }

    public boolean verifyCancelEditButton() {
        return btnCancelEdit.isElementPresent();
    }

    public boolean verifySaveButton() {
        return btnSave.isElementPresent();
    }

    public void clickOnSaveButton() {
        if (btnSave.isElementPresent()) {
            btnSave.clickJScript();
            reportLog("Successfully clicked on Save Button");
        }
    }

    public boolean verifyCancelEditResourcesButton() {
        return btnCancelEditResources.isElementPresent();
    }

    public void clickOnCancelEditResourcesButton() {
        if (btnCancelEditResources.isElementPresent()) {
            btnCancelEditResources.clickJScript();
            reportLog("Successfully clicked on Cancel Edit Resources Button");
        }
    }

    public boolean verifyEditResourcesText() {
        waitForSec(5);
        return textEditResources.isElementPresent();
    }

    public boolean verifyPublishedCheckBox() {
        return checkBoxPublished.isElementPresent();
    }

    public void clickOnPublishedCheckBox() {
        if (checkBoxPublished.isElementPresent()) {
            checkBoxPublished.clickJScript();
            reportLog("Successfully clicked on Published CheckBox");
        }
    }

    public boolean verifyPleaseEnterDescriptionText() {
        return textPleaseEnterDescription.isElementPresent();
    }

    public void enterDescriptionText(String description) {
        if (placeHolderDescription.isElementPresent()) {
            placeHolderDescription.clickJScript();
            placeHolderDescription.setText(description);
            reportLog("Successfully Entered Text In Description Text");
        }
    }

    public void removeDescriptionText(String description) {
        if (placeHolderDescription.isElementPresent()) {
            placeHolderDescription.clickJScript();
            placeHolderDescription.setText(description);
            reportLog("Successfully Remove Text In Description Text");
        }
    }

    public boolean verifyEditIcon() {
        return iconEdit.isElementPresent();
    }

    public void clickOnEditIcon() {
        if (iconEdit.isElementPresent()) {
            iconEdit.clickJScript();
            reportLog("Successfully clicked on Edit Icon");
        }
    }
}