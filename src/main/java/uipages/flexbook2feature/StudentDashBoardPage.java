package uipages.flexbook2feature;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import org.apache.log4j.Logger;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import uipages.BasePage;
import utils.GuiControl;

public class StudentDashBoardPage extends BasePage {
    private static final Logger logger = Logger.getLogger(StudentDashBoardPage.class);

    private final GuiControl iconStudentProfile = new GuiControl(getElementMap().get("iconStudentProfile"), webDriver);
    private final GuiControl tabClassActivity = new GuiControl(getElementMap().get("tabClassActivity"), webDriver);
    private final GuiControl tabSelfStudy = new GuiControl(getElementMap().get("tabSelfStudy"), webDriver);
    private final GuiControl patchLatestActivity = new GuiControl(getElementMap().get("patchLatestActivity"), webDriver);
    private final GuiControl titleClassName = new GuiControl(getElementMap().get("titleClassName"), webDriver);
    private final GuiControl iconMemberImage = new GuiControl(getElementMap().get("iconMemberImage"), webDriver);
    private final GuiControl textOwnerName = new GuiControl(getElementMap().get("textOwnerName"), webDriver);
    private final GuiControl linkMemberCount = new GuiControl(getElementMap().get("linkMemberCount"), webDriver);
    private final GuiControl linkRecent = new GuiControl(getElementMap().get("linkRecent"), webDriver);
    private final GuiControl linkAllSubjectProgress = new GuiControl(getElementMap().get("linkAllSubjectProgress"), webDriver);
    private final GuiControl iconLatestSelfStudyView = new GuiControl(getElementMap().get("iconLatestSelfStudyView"), webDriver);
    private final GuiControl dropDownSubjectSelector = new GuiControl(getElementMap().get("dropDownSubjectSelector"), webDriver);
    private final GuiControl linkSubjectList = new GuiControl(getElementMap().get("linkSubjectList"), webDriver);
    private final GuiControl btnStart = new GuiControl(getElementMap().get("btnStart"), webDriver);
    private final GuiControl iconGridView = new GuiControl(getElementMap().get("iconGridView"), webDriver);
    private final GuiControl iconListView = new GuiControl(getElementMap().get("iconListView"), webDriver);
    private final GuiControl textTrack = new GuiControl(getElementMap().get("textTrack"), webDriver);
    private final GuiControl textProgress = new GuiControl(getElementMap().get("textProgress"), webDriver);
    private final GuiControl iconJoinClass = new GuiControl(getElementMap().get("iconJoinClass"), webDriver);
    private final GuiControl btnJoin = new GuiControl(getElementMap().get("btnJoin"), webDriver);
    private final GuiControl textClasses = new GuiControl(getElementMap().get("textClasses"), webDriver);

    public StudentDashBoardPage(WebDriver webDriver, ExtentTest extentTest, ExtentReports extentReports) {
        super(webDriver, extentTest, extentReports);
    }

    public boolean verifyStudentProfileOnGamma() {
        boolean result = false;
        int attempts = 0;
        while (attempts < 2) {
            try {
                iconStudentProfile.isElementPresent();
                result = true;
                break;
            } catch (StaleElementReferenceException serEx) {
                logger.error(serEx);
            }
            attempts++;
        }
        return result;
    }

    public boolean verifyJoinClassIcon() {
        iconJoinClass.mouseHover();
        return iconJoinClass.isElementPresent();
    }

    public boolean verifyClassesText() {
        return textClasses.isElementPresent();
    }

    public void clickOnJoinClassIcon() {
        iconJoinClass.mouseHover();
        if (iconJoinClass.isElementPresent()) {
            iconJoinClass.clickJScript();
            reportLog("Successfully Clicked On Join Class Icon.");
        }
    }

    public boolean verifyJoinButton() {
        waitForSec(5);
        return btnJoin.isElementPresent();
    }

    public boolean verifyClassActivityTab() {
        waitForSec(5);
        return tabClassActivity.isElementPresent();
    }

    public void clickOnClassActivityTab() {
        if (tabClassActivity.isElementPresent()) {
            tabClassActivity.clickJScript();
            reportLog("Successfully Clicked On Class Activity Tab.");
        }
    }

    public boolean verifySelfStudyTab() {
        return tabSelfStudy.isElementPresent();
    }

    public void clickOnSelfStudyTab() {
        if (tabSelfStudy.isElementPresent()) {
            tabSelfStudy.clickJScript();
            reportLog("Successfully Clicked On Self Study Tab.");
        }
    }

    public boolean verifyLatestActivityPatch() {
        return patchLatestActivity.isElementPresent();
    }

    public boolean verifyClassNameTitle() {
        return titleClassName.isElementPresent();
    }

    public boolean verifyMemberImageIcon() {
        return iconMemberImage.isElementPresent();
    }

    public boolean verifyOwnerNameText() {
        return textOwnerName.isElementPresent();
    }

    public boolean verifyMemberCountLink() {
        return linkMemberCount.isElementPresent();
    }

    public void scrollScreen() {
        linkRecent.scrollIntoView();
        reportLog("Successfully Scroll Screen Through Recent Link.");
    }

    public boolean verifyAllSubjectProgressLink() {
        waitForSec(2);
        return linkAllSubjectProgress.isElementPresent();
    }

    public void clickOnAllSubjectProgressLink() {
        if (linkAllSubjectProgress.isElementPresent()) {
            linkAllSubjectProgress.clickJScript();
            reportLog("Successfully Clicked On All Subject Progress Link.");
        }
    }

    public boolean verifyLatestSelfStudyViewIcon() {
        return iconLatestSelfStudyView.isElementPresent();
    }

    public void clickOnLatestSelfStudyViewIcon() {
        if (iconLatestSelfStudyView.isElementPresent()) {
            iconLatestSelfStudyView.clickJScript();
            reportLog("Successfully Clicked On LatestSelfStudyViewIcon.");
        }
    }

    public boolean verifySubjectSelectorDropDown() {
        return dropDownSubjectSelector.isElementPresent();
    }

    public void clickOnSubjectSelectorDropDown() {
        if (dropDownSubjectSelector.isElementPresent()) {
            dropDownSubjectSelector.clickJScript();
            reportLog("Successfully Clicked On DropDown Subject Selector.");
        }
    }

    public boolean verifySubjectListLink() {
        return linkSubjectList.isElementPresent();
    }

    public void clickOnSubjectListLink() {
        if (linkSubjectList.isElementPresent()) {
            linkSubjectList.clickJScript();
            reportLog("Successfully Clicked On Subject List.");
        }
    }

    public boolean verifyStartButton() {
        return btnStart.isElementPresent();
    }

    public boolean verifyGridViewIcon() {
        return iconGridView.isElementPresent();
    }

    public void clickOnGridViewIcon() {
        if (iconGridView.isElementPresent()) {
            iconGridView.clickJScript();
            reportLog("Successfully Clicked On Grid View Icon.");
        }
    }

    public boolean verifyListViewIcon() {
        return iconListView.isElementPresent();
    }

    public void clickOnListViewIcon() {
        if (iconListView.isElementPresent()) {
            iconListView.clickJScript();
            reportLog("Successfully Clicked On List View Icon.");
        }
    }

    public boolean verifyTrackText() {
        return textTrack.isElementPresent();
    }

    public boolean verifyProgressText() {
        return textProgress.isElementPresent();
    }
}