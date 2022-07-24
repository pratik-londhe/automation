package uipages.flexbook2feature;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import org.openqa.selenium.WebDriver;
import uipages.BasePage;
import utils.GuiControl;

public class SharedResourcesFeature extends BasePage {

    private final GuiControl textSortBy = new GuiControl(getElementMap().get("textSortBy"), webDriver);
    private final GuiControl textShow = new GuiControl(getElementMap().get("textShow"), webDriver);
    private final GuiControl linkTypeTitle = new GuiControl(getElementMap().get("linkTypeTitle"), webDriver);
    private final GuiControl textRead = new GuiControl(getElementMap().get("textRead"), webDriver);
    private final GuiControl dropDownSortBy = new GuiControl(getElementMap().get("dropDownSortBy"), webDriver);
    private final GuiControl linkType = new GuiControl(getElementMap().get("linkType"), webDriver);
    private final GuiControl linkMembers = new GuiControl(getElementMap().get("linkMembers"), webDriver);
    private final GuiControl textResourceName = new GuiControl(getElementMap().get("textResourceName"), webDriver);
    private final GuiControl checkBoxSharedByMe = new GuiControl(getElementMap().get("checkBoxSharedByMe"), webDriver);
    private final GuiControl checkBoxSharedByOthers = new GuiControl(getElementMap().get("checkBoxSharedByOthers"), webDriver);
    private final GuiControl textNoResources = new GuiControl(getElementMap().get("textNoResources"), webDriver);
    private final GuiControl iconDeleteResources = new GuiControl(getElementMap().get("iconDeleteResources"), webDriver);
    private final GuiControl textRemoveResources = new GuiControl(getElementMap().get("textRemoveResources"), webDriver);
    private final GuiControl btnDeleteResources = new GuiControl(getElementMap().get("btnDeleteResources"), webDriver);
    private final GuiControl btnCancelDeleteResources = new GuiControl(getElementMap().get("btnCancelDeleteResources"), webDriver);

    public SharedResourcesFeature(WebDriver webDriver, ExtentTest extentTest, ExtentReports extentReports) {
        super(webDriver, extentTest, extentReports);
    }

    public boolean verifyShowText() {
        return textShow.isElementPresent();
    }

    public boolean verifyTypeTitleLink() {
        return linkTypeTitle.isElementPresent();
    }

    public boolean verifyReadText() {
        return textRead.isElementPresent();
    }

    public boolean verifySortByText() {
        waitForSec(5);
        return textSortBy.isElementPresent();
    }

    public boolean verifySortByDropDown() {
        return dropDownSortBy.isElementPresent();
    }

    public void clickOnSortByDropDown() {
        if (dropDownSortBy.isElementPresent()) {
            dropDownSortBy.clickJScript();
            reportLog("Successfully Click On Sort By DropDown");
        }
    }

    public boolean verifyTypeLink() {
        return linkType.isElementPresent();
    }

    public void clickOnTypeLink() {
        if (linkType.isElementPresent()) {
            linkType.clickJScript();
            reportLog("Successfully Click On Type Link");
        }
    }

    public boolean verifyMembersLink() {
        return linkMembers.isElementPresent();
    }

    public void clickOnMembersLink() {
        if (linkMembers.isElementPresent()) {
            linkMembers.clickJScript();
            reportLog("Successfully Click On Members Link");
        }
    }

    public boolean verifyResourceNameText() {
        return textResourceName.isElementPresent();
    }

    public boolean verifySharedByMeCheckBox() {
        return checkBoxSharedByMe.isElementPresent();
    }

    public void clickOnSharedByMeCheckBox() {
        if (checkBoxSharedByMe.isElementPresent()) {
            checkBoxSharedByMe.clickJScript();
            reportLog("Successfully Click On Shared By Me CheckBox");
        }
    }

    public boolean verifySharedByOthersCheckBox() {
        return checkBoxSharedByOthers.isElementPresent();
    }

    public void clickOnSharedByOthersCheckBox() {
        if (checkBoxSharedByOthers.isElementPresent()) {
            checkBoxSharedByOthers.clickJScript();
            reportLog("Successfully Click On Shared By Others CheckBox");
        }
    }

    public boolean verifyNoResourcesText() {
        return textNoResources.isElementPresent();
    }

    public boolean verifyDeleteIcon() {
        waitForSec(5);
        return iconDeleteResources.isElementPresent();
    }

    public void clickOnDeleteIcon() {
        if (iconDeleteResources.isElementPresent()) {
            iconDeleteResources.clickJScript();
            reportLog("Successfully Click On Delete Icon");
        }
    }

    public boolean verifyRemoveResourcesText() {
        waitForSec(5);
        return textRemoveResources.isElementPresent();
    }

    public boolean verifyDeleteResourcesButton() {
        return btnDeleteResources.isElementPresent();
    }

    public boolean verifyCancelDeleteResourcesButton() {
        return btnCancelDeleteResources.isElementPresent();
    }

    public void clickOnCancelDeleteButton() {
        if (btnCancelDeleteResources.isElementPresent()) {
            btnCancelDeleteResources.clickJScript();
            reportLog("Successfully Click On Cancel Delete Resources Button");
        }
    }
}
