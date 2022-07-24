package uipages.flexbook2feature;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import utils.GuiControl;

public class OpenToolbarFeature  extends PageMenuTab {
    private static final Logger logger = Logger.getLogger(OpenToolbarFeature.class);

    private final GuiControl btnOpen = new GuiControl(getElementMap().get("btnOpen"), webDriver);
    private final GuiControl textToolbar = new GuiControl(getElementMap().get("textToolbar"), webDriver);
    private final GuiControl btnCloseToolbar = new GuiControl(getElementMap().get("btnCloseToolbar"), webDriver);
    private final GuiControl textLearningTool = new GuiControl(getElementMap().get("textLearningTool"), webDriver);
    private final GuiControl textAction = new GuiControl(getElementMap().get("textAction"), webDriver);
    private final GuiControl textMore = new GuiControl(getElementMap().get("textMore"), webDriver);
    private final GuiControl btnRelatedContent = new GuiControl(getElementMap().get("btnRelatedContent"), webDriver);
    private final GuiControl btnResources = new GuiControl(getElementMap().get("btnResources"), webDriver);
    private final GuiControl textRelatedContent = new GuiControl(getElementMap().get("textRelatedContent"), webDriver);
    private final GuiControl NoContentText = new GuiControl(getElementMap().get("NoContentText"), webDriver);
    private final GuiControl iconBack = new GuiControl(getElementMap().get("iconBack"), webDriver);
    private final GuiControl textResources = new GuiControl(getElementMap().get("textResources"), webDriver);
    private final GuiControl iconDownload = new GuiControl(getElementMap().get("iconDownload"), webDriver);
    private final GuiControl btnSetting = new GuiControl(getElementMap().get("btnSetting"), webDriver);
    private final GuiControl textDisplaySetting = new GuiControl(getElementMap().get("textDisplaySetting"), webDriver);
    private final GuiControl iconFontSize = new GuiControl(getElementMap().get("iconFontSize"), webDriver);
    private final GuiControl btnNotesAndHighlight = new GuiControl(getElementMap().get("btnNotesAndHighlight"), webDriver);
    private final GuiControl textNotesAndHighlight = new GuiControl(getElementMap().get("textNotesAndHighlight"), webDriver);
    private final GuiControl iconDelete = new GuiControl(getElementMap().get("iconDelete"), webDriver);
    private final GuiControl btnShare = new GuiControl(getElementMap().get("btnShare"), webDriver);
    private final GuiControl btnAddToFlexBook = new GuiControl(getElementMap().get("btnAddToFlexBook"), webDriver);
    private final GuiControl iconCloseAddToFlexBook = new GuiControl(getElementMap().get("iconCloseAddToFlexBook"), webDriver);
    private final GuiControl btnDetails = new GuiControl(getElementMap().get("btnDetails"), webDriver);

    public OpenToolbarFeature(WebDriver webDriver, ExtentTest extentTest, ExtentReports extentReports) {
        super(webDriver, extentTest, extentReports);
    }

    public boolean verifyOpenButton() {
        waitForSec(5);
        return btnOpen.isElementPresent();
    }

    public void clickOnOpenButton() {
        if (btnOpen.isElementPresent()) {
            btnOpen.clickJScript();
            reportLog("Successfully clicked On OpenButton");
        }
    }

    public void scrollTheScreen(){
        btnAddToFlexBook.scrollIntoView();
        reportLog("Successfully scroll the screen through Add to FlexBook button");
        waitForSec(2);
    }

    public boolean verifyAddToFlexBookButton() {
        return btnAddToFlexBook.isElementPresent();
    }

    public void clickOnAddToFlexBookButton() {
        if (btnAddToFlexBook.isElementPresent()) {
            btnAddToFlexBook.clickJScript();
            reportLog("Successfully clicked On Add To FlexBook Button");
        }
    }

    public boolean verifyDetailsButton() {
        return btnDetails.isElementPresent();
    }

    public void clickOnDetailsButton() {
        if (btnDetails.isElementPresent()) {
            btnDetails.clickJScript();
            reportLog("Successfully clicked On Details Button");
        }
    }

    public boolean verifyCloseAddToFlexBookIcon() {
        return iconCloseAddToFlexBook.isElementPresent();
    }

    public void clickOnCloseAddToFlexBookIcon() {
        if (iconCloseAddToFlexBook.isElementPresent()) {
            iconCloseAddToFlexBook.clickJScript();
            reportLog("Successfully clicked On Close Add To FlexBook Icon");
        }
    }

    public boolean verifyShareButton() {
        return btnShare.isElementPresent();
    }

    public void clickOnShareButton() {
        if (btnShare.isElementPresent()) {
            btnShare.clickJScript();
            reportLog("Successfully clicked On Share Button");
        }
    }

    public boolean verifyCloseToolbarButton() {
        return btnCloseToolbar.isElementPresent();
    }

    public void clickOnCloseToolbarButton() {
        if (btnCloseToolbar.isElementPresent()) {
            btnCloseToolbar.clickJScript();
            reportLog("Successfully clicked On Close Toolbar Button");
        }
    }

    public boolean verifyToolbarText() {
        waitForSec(5);
        return textToolbar.isElementPresent();
    }

    public boolean verifyLearningToolText() {
        return textLearningTool.isElementPresent();
    }

    public boolean verifyActionText() {
        return textAction.isElementPresent();
    }

    public boolean verifyMoreText() {
        return textMore.isElementPresent();
    }

    public boolean verifyRelatedContentButton() {
        return btnRelatedContent.isElementPresent();
    }

    public void clickOnRelatedContentButton() {
        if (btnRelatedContent.isElementPresent()) {
            btnRelatedContent.clickJScript();
            reportLog("Successfully clicked On Related Content Button");
        }
    }

    public boolean verifySettingButton() {
        return btnSetting.isElementPresent();
    }

    public void clickOnSettingButton() {
        if (btnSetting.isElementPresent()) {
            btnSetting.clickJScript();
            reportLog("Successfully clicked On Setting Button");
        }
    }

    public boolean verifyRelatedContentText() {
        waitForSec(5);
        return textRelatedContent.isElementPresent();
    }

    public boolean verifySettingText() {
        waitForSec(5);
        return textDisplaySetting.isElementPresent();
    }

    public boolean verifyResourcesText() {
        waitForSec(5);
        return textResources.isElementPresent();
    }

    public boolean verifyNoContentText() {
        return NoContentText.isElementPresent();
    }

    public boolean verifyResourcesButton() {
        return btnResources.isElementPresent();
    }

    public void clickOnResourcesButton() {
        if (btnResources.isElementPresent()) {
            btnResources.clickJScript();
            reportLog("Successfully clicked On Resources Button");
        }
    }

    public boolean verifyFontSizeIcon() {
        return iconFontSize.isElementPresent();
    }

    public boolean verifyBackIcon() {
        return iconBack.isElementPresent();
    }

    public void clickOnBackIcon() {
        if (iconBack.isElementPresent()) {
            iconBack.clickJScript();
            reportLog("Successfully clicked On Back Icon");
        }
    }

    public boolean verifyDownloadIcon() {
        return iconDownload.isElementPresent();
    }

    public boolean verifyNotesAndHighlightButton() {
        return btnNotesAndHighlight.isElementPresent();
    }

    public void clickOnNotesAndHighlightButton() {
        if (btnNotesAndHighlight.isElementPresent()) {
            btnNotesAndHighlight.clickJScript();
            reportLog("Successfully clicked On Notes And Highlight Button");
        }
    }

    public boolean verifyNotesAndHighlightText() {
        waitForSec(5);
        return textNotesAndHighlight.isElementPresent();
    }

    public void clickOnNotesAndHighlightText() {
        if (textNotesAndHighlight.isElementPresent()) {
            textNotesAndHighlight.clickJScript();
            reportLog("Successfully clicked On Notes And Highlight Text");
        }
    }

    public boolean verifyDeleteIcon() {
        return iconDelete.isElementPresent();
    }
}