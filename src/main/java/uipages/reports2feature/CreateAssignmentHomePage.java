package uipages.reports2feature;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import uipages.BasePage;
import utils.GuiControl;

public class CreateAssignmentHomePage extends BasePage {
    public final Logger logger = Logger.getLogger(CreateAssignmentHomePage.class);

    private String subjectTitle;
    private String branchNameHeading;
    private String branchTitle;
    private String conceptHeadingText;

    private final GuiControl textHome = new GuiControl(getElementMap().get("textHome"), webDriver);
    private final GuiControl linkSubjectTitle = new GuiControl(getElementMap().get("linkSubjectTitle"), webDriver);
    private final GuiControl textBranchName = new GuiControl(getElementMap().get("textBranchName"), webDriver);
    private final GuiControl textTopic = new GuiControl(getElementMap().get("textTopic"), webDriver);
    private final GuiControl linkBranchTitle = new GuiControl(getElementMap().get("linkBranchTitle"), webDriver);
    private final GuiControl textConcept = new GuiControl(getElementMap().get("textConcept"), webDriver);
    private final GuiControl textConceptHeading = new GuiControl(getElementMap().get("textConceptHeading"), webDriver);

    public CreateAssignmentHomePage(WebDriver webDriver, ExtentTest extentTest, ExtentReports extentReports) {
        super(webDriver, extentTest, extentReports);
    }

    public boolean verifyHomeText() {
        return textHome.isElementPresent();
    }

    public void clickOnHomeTab() {
        if (textHome.isElementPresent()) {
            textHome.clickJScript();
            reportLog("Successfully click On Home Tab");
        }
    }

    public boolean verifySubjectTitleLink() {
        return linkSubjectTitle.isElementPresent();
    }

    public boolean verifyTopicNameText() {
        waitForSec(5);
        return textTopic.isElementPresent();
    }


    public void clickOnTopicTab() {
        if (textTopic.isElementPresent()) {
            textTopic.clickJScript();
            reportLog("Successfully click On Topic Tab");
        }
    }

    public boolean verifyConceptNameText() {
        return textConcept.isElementPresent();
    }

    public boolean verifyBranchNameHeadingText() {
        return textBranchName.isElementPresent();
    }

    public void clickOnConceptTab() {
        if (textConcept.isElementPresent()) {
            textConcept.clickJScript();
            reportLog("Successfully click On Concept Tab");
        }
    }

    public void clickOnSubjectTitle() {
        if (linkSubjectTitle.isElementPresent()) {
            linkSubjectTitle.clickJScript();
            reportLog("Successfully click On Subject Title Link");
        }
    }

    public void getTextOfSubjectTitle() {
        subjectTitle = linkSubjectTitle.getText();
        reportLog("Successfully Get Text of Subject Title And Text Is = " + subjectTitle);
    }

    public void getTextOfBranchNameHeading() {
        branchNameHeading = textBranchName.getText();
        reportLog("Successfully Get Text of Branch Name Title And Text Is = " + branchNameHeading);
    }

    public void getTextOfBranchTitle() {
        branchTitle = linkBranchTitle.getText();
        reportLog("Successfully Get Text of Branch Name Title And Text Is = " + branchTitle);
    }

    public void clickOnBranchTitle() {
        if (linkBranchTitle.isElementPresent()) {
            linkBranchTitle.clickJScript();
            reportLog("Successfully click On Branch Title Link");
        }
    }

    public boolean verifySelectedSubjectIsOpened(){
        waitForSec(5);
        return branchNameHeading.equalsIgnoreCase(subjectTitle);
    }

    public boolean verifyConceptHeadingText(){
        return textConceptHeading.isElementPresent();
    }

    public void getTextOfConceptHeading() {
        conceptHeadingText = textConceptHeading.getText();
        reportLog("Successfully Get Text of Concept Heading And Text Is = " + branchTitle);
    }

    public boolean verifySelectedBranchIsOpened(){
        return branchTitle.equalsIgnoreCase(conceptHeadingText);
    }
}