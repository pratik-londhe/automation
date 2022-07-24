package uipages.googleclassroom;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import org.apache.log4j.Logger;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import utils.GuiControl;

public class GoogleClassroomPage extends uipages.BasePage {
    private static String googleClassCode;
    private static final Logger logger = Logger.getLogger(GoogleClassroomPage.class);

    public GoogleClassroomPage(WebDriver webDriver, ExtentTest extentTest, ExtentReports extentReports) {
        super(webDriver, extentTest, extentReports);
    }

    private final GuiControl textEmail = new GuiControl(getElementMap().get("textEmail"), webDriver);
    private final GuiControl textPass = new GuiControl(getElementMap().get("textPass"), webDriver);
    private final GuiControl btnNext = new GuiControl(getElementMap().get("btnNext"), webDriver);
    private final GuiControl iconPlus = new GuiControl(getElementMap().get("iconPlus"), webDriver);
    private final GuiControl createClass = new GuiControl(getElementMap().get("createClass"), webDriver);
    private final GuiControl checkBox = new GuiControl(getElementMap().get("checkBox"), webDriver);
    private final GuiControl btnContinue = new GuiControl(getElementMap().get("btnContinue"), webDriver);
    private final GuiControl className = new GuiControl(getElementMap().get("className"), webDriver);
    private final GuiControl btnCreate = new GuiControl(getElementMap().get("btnCreate"), webDriver);
    private final GuiControl googleClass = new GuiControl(getElementMap().get("googleClass"), webDriver);
    private final GuiControl classCode = new GuiControl(getElementMap().get("classCode"), webDriver);
    private final GuiControl btnJoin = new GuiControl(getElementMap().get("btnJoin"), webDriver);
    private final GuiControl textClassCode = new GuiControl(getElementMap().get("textClassCode"), webDriver);
    private final GuiControl btnJoinClass = new GuiControl(getElementMap().get("btnJoinClass"), webDriver);
    private final GuiControl url = new GuiControl(getElementMap().get("url"), webDriver);
    private final GuiControl btnAssign = new GuiControl(getElementMap().get("btnAssign"), webDriver);
    private final GuiControl linkConnectGC = new GuiControl(getElementMap().get("linkConnectGC"), webDriver);
    private final GuiControl GCPlatform = new GuiControl(getElementMap().get("GCPlatform"), webDriver);
    private final GuiControl selectClass = new GuiControl(getElementMap().get("selectClass"), webDriver);
    private final GuiControl dueDate = new GuiControl(getElementMap().get("dueDate"), webDriver);
    private final GuiControl calenderDueDate = new GuiControl(getElementMap().get("calenderDueDate"), webDriver);
    private final GuiControl btnAssignConcept = new GuiControl(getElementMap().get("btnAssignConcept"), webDriver);
    private final GuiControl selectProfile = new GuiControl(getElementMap().get("selectProfile"), webDriver);
    private final GuiControl isGCClassCreated = new GuiControl(getElementMap().get("isGCClassCreated"), webDriver);
    private final GuiControl btnGotIt = new GuiControl(getElementMap().get("btnGotIt"), webDriver);
    private final GuiControl btnGCUsername = new GuiControl(getElementMap().get("btnGCUsername"), webDriver);
    private final GuiControl btnSignOut = new GuiControl(getElementMap().get("btnSignOut"), webDriver);
    private final GuiControl btnRemoveAccount = new GuiControl(getElementMap().get("btnRemoveAccount"), webDriver);
    private final GuiControl btnselectUserAccountToRemove = new GuiControl(getElementMap().get("btnselectUserAccountToRemove"), webDriver);
    private final GuiControl btnsYesRemove = new GuiControl(getElementMap().get("btnsYesRemove"), webDriver);

    private final GuiControl btnUseAnotherAccount = new GuiControl(getElementMap().get("btnUseAnotherAccount"), webDriver);
    private final GuiControl txtBoxEmail = new GuiControl(getElementMap().get("txtBoxEmail"), webDriver);
    private final GuiControl btnSignInNext = new GuiControl(getElementMap().get("btnSignInNext"), webDriver);
    private final GuiControl txtBoxPass = new GuiControl(getElementMap().get("txtBoxPass"), webDriver);
    private final GuiControl btnPassNext = new GuiControl(getElementMap().get("btnPassNext"), webDriver);
    private final GuiControl iconMenu = new GuiControl(getElementMap().get("iconMenu"), webDriver);
    //private final GuiControl goToClassroomLink = new GuiControl(getElementMap().get("goToClassroomLink"), webDriver);
    private final GuiControl btnJoinClassStu = new GuiControl(getElementMap().get("btnJoinClassStu"), webDriver);
    private final GuiControl optionJoinClass = new GuiControl(getElementMap().get("optionJoinClass"), webDriver);
    private final GuiControl txtBoxClassCode = new GuiControl(getElementMap().get("txtBoxClassCode"), webDriver);
    private final GuiControl btnJoinStu = new GuiControl(getElementMap().get("btnJoinStu"), webDriver);
    private final GuiControl txtClassName = new GuiControl(getElementMap().get("txtClassName"), webDriver);
    private final GuiControl linkClassWork = new GuiControl(getElementMap().get("linkClassWork"), webDriver);
    private final GuiControl btnAssignment = new GuiControl(getElementMap().get("btnAssignment"), webDriver);
    private final GuiControl linkAssignment = new GuiControl(getElementMap().get("linkAssignment"), webDriver);
    private final GuiControl btnOkToReviewPermission = new GuiControl(getElementMap().get("btnOkToReviewPermission"), webDriver);
    private final GuiControl linkSelectStudentProfileGC = new GuiControl(getElementMap().get("linkSelectStudentProfileGC"), webDriver);
    private final GuiControl btnStartOrContinuetPractice = new GuiControl(getElementMap().get("btnStartOrContinuetPractice"), webDriver);
    private final GuiControl btnStartOrKeepPracticing = new GuiControl(getElementMap().get("btnStartOrKeepPracticing"), webDriver);
    private final GuiControl btnStartPracticingPrePracticeScreen = new GuiControl(getElementMap().get("btnStartPracticingPrePracticeScreen"), webDriver);
    private final GuiControl btnStopForNow = new GuiControl(getElementMap().get("btnStopForNow"), webDriver);
    private final GuiControl btnTurnIn = new GuiControl(getElementMap().get("btnTurnIn"), webDriver);
    private final GuiControl confirmTurnIn = new GuiControl(getElementMap().get("confirmTurnIn"), webDriver);
    private final GuiControl selectTeacherProfile = new GuiControl(getElementMap().get("selectTeacherProfile"), webDriver);
    private final GuiControl gCClassName = new GuiControl(getElementMap().get("gCClassName"), webDriver);
    private final GuiControl tabMark = new GuiControl(getElementMap().get("tabMark"), webDriver);
    private final GuiControl student = new GuiControl(getElementMap().get("student"), webDriver);
    private final GuiControl score = new GuiControl(getElementMap().get("score"), webDriver);
    private final GuiControl menu = new GuiControl(getElementMap().get("menu"), webDriver);
    private final GuiControl tabClasses = new GuiControl(getElementMap().get("tabClasses"), webDriver);
    private final GuiControl archive = new GuiControl(getElementMap().get("archive"), webDriver);
    private final GuiControl ellipsisIcon = new GuiControl(getElementMap().get("ellipsisIcon"), webDriver);
    private final GuiControl archiveLink = new GuiControl(getElementMap().get("archiveLink"), webDriver);
    private final GuiControl noClass = new GuiControl(getElementMap().get("noClass"), webDriver);
    private final GuiControl signOutAll = new GuiControl(getElementMap().get("signOutAll"), webDriver);
    private final GuiControl assignmentName = new GuiControl(getElementMap().get("assignmentName"), webDriver);
    private final GuiControl assignLink = new GuiControl(getElementMap().get("assignLink"), webDriver);
    private final GuiControl assignmentScore = new GuiControl(getElementMap().get("assignmentScore"), webDriver);
    private final GuiControl studProfile = new GuiControl(getElementMap().get("studProfile"), webDriver);
    private final GuiControl linkSignOut = new GuiControl(getElementMap().get("linkSignOut"), webDriver);
    private final GuiControl linkSelectTeacherProfileGC = new GuiControl(getElementMap().get("linkSelectTeacherProfileGC"), webDriver);

    public void gmailLogin(String username, String password) {
        textEmail.setText(username);
        logger.info("Entered the email.");
        waitForSec(2);
        btnNext.clickJScript();
        logger.info("Clicked on the Next button.");
        waitForSec(2);
        textPass.setText(password);
        logger.info("Entered the password");
        waitForSec(2);
        btnNext.clickJScript();
        logger.info("Clicked on the Next button.");
    }

    public void studentSignOutFromCK12() {
        waitForSec(2);
        studProfile.click();
        waitForSec(2);
        linkSignOut.click();
        waitForSec(4);
    }

    public void ClickOnTheConceptsToVisitGradeBook() {
        assignmentName.clickJScript();
        waitForSec(4);
        assignLink.clickJScript();
        waitForSec(2);
    }

    public String accessCK12ReportViaGradBook() {
        waitForSec(2);
        return assignmentScore.getText();
    }

    public boolean verifyGCClassIsDeleted() {
        return noClass.isDisplayed();
    }

    public void deleteGoogleClass() {
        waitForSec(4);
        menu.click();
        waitForSec(2);
        tabClasses.click();
        waitForSec(2);
        ellipsisIcon.click();
        waitForSec(4);
        archive.click();
        waitForSec(2);
        archiveLink.click();
    }

    public String getScore() {
        waitForSec(4);
        return score.getText();
    }

    public void goToGradeBook() {
        waitForSec(4);
        gCClassName.click();
        waitForSec(2);
        tabMark.click();
        waitForSec(2);
        student.click();
    }

    public void selectTeacherProfileAndEnterPass(String teacherPass) {
        waitForSec(4);
        selectTeacherProfile.click();
        waitForSec(2);
        textPass.setText(teacherPass);
        waitForSec(2);
        btnNext.clickJScript();
    }

    public void turnInScore() {
        btnTurnIn.click();
        waitForSec(4);
        confirmTurnIn.click();
        waitForSec(4);
    }

    public void clickOnPlusIcon() {
        waitForSec(10);
        iconPlus.click();
        logger.info("Clicked on the plus icon.");
    }

    public void clickOnCreateClass() {
        createClass.click();
        logger.info("Clicked on the create class button.");
    }

    public void clickOnCheckBox() {
        checkBox.scrollIntoView();
        checkBox.clickJScript();
        logger.info("Clicked on the checkbox.");
    }

    public void clickOnBtnContinue() {
        btnContinue.click();
        logger.info("Clicked on the continue button.");
    }

    public void createGoogleClass(String googleClass) {
        waitForSec(4);
        className.setText(googleClass);
        logger.info("Entered the Google Class name.");
        btnCreate.clickJScript();
        logger.info("Clicked on the Create button.");
        waitForSec(20);
    }

    public void clickOnCreatedGoogleClass() {
        googleClass.click();
        logger.info("Clicked on the google class.");
    }

    synchronized public void getClassCode() {
        googleClassCode = classCode.getText();
        System.out.println("===============================================================" + classCode);
    }

    public void openNewTabAndCK12URL() {
        webDriver.get("https://flexbooks.ck12.org/cbook/ck-12-interactive-geometry-for-ccss/section/1.2/primary/lesson/angles-and-lines-geo-ccss");
    }

    public void clickOnBtnAssign() {
        waitForSec(10);
        btnAssign.click();
    }

    public void clickOnGCPlatform() {
        GCPlatform.click();
        logger.info("Clicked on the GC platform.");
    }

    public void clickOnConnectGCLink() {
        linkConnectGC.click();
        logger.info("Clicked on the connect to GC link.");
    }

    public void selectClass() {
        selectClass.click();
        logger.info("Clicked on the select class.");
    }

    public void assignConceptToGCClass() {
        dueDate.click();
        logger.info("Clicked on the due date.");
        calenderDueDate.click();
        logger.info("Selected the due date.");
        btnAssignConcept.click();
        logger.info("Clicked on the assign button.");
        waitForSec(4);
    }

    public void selectProfile() {
        selectProfile.click();
        logger.info("Clicked on the google account profile.");
        waitForSec(20);
    }

    public boolean isGCClassCreated(String createdClassName) {
        return isGCClassCreated.getText().equals(createdClassName);
    }

    public boolean verifyGotItButton() {
        return btnGotIt.isDisplayed();
    }

    public void gcSignOut() {
        if (btnGCUsername.isElementPresent()) {
            btnGCUsername.click();
            logger.info("Clicked on the user name button at the top right corner of the GC page");
        }
        if (btnSignOut.isElementPresent()) {
            btnSignOut.click();
            logger.info("Clicked on the Sign out button");
        }
    }

    public void gcRemoveAccount() {
        if (btnRemoveAccount.isElementPresent()) {
            btnRemoveAccount.click();
            logger.info("Clicked on the Remove an account button on Google page");
        }
        if (btnselectUserAccountToRemove.isElementPresent()) {
            btnselectUserAccountToRemove.click();
            logger.info("Clicked on the Account name button on Google page to remove it from logged in users list");
        }
        if (btnsYesRemove.isElementPresent()) {
            btnsYesRemove.click();
            logger.info("Clicked on Yes Remove button on Google page");
        }
    }

    public void gcSignOutAll() {
        waitForSec(4);
        if (btnGCUsername.isElementPresent()) {
            btnGCUsername.click();
            logger.info("Clicked on the user name button at the top right corner of the GC page");
            waitForSec(2);
            //signOutAll.click();
            btnSignOut.click();
            logger.info("Clicked on the Sign Out button on the GC page");
        }
    }

    //Student methods

    public void clickOnUseAnotherAccount() {
        if (btnUseAnotherAccount.isElementPresent()) {
            btnUseAnotherAccount.click();
            logger.info("Clicked on the button Use Another Account");
        }
    }

    public void studentLogin(String Stuuname, String Stupword) {
        txtBoxEmail.click();
        txtBoxEmail.sendKeys(Stuuname);
        btnSignInNext.click();
        txtBoxPass.click();
        txtBoxPass.sendKeys(Stupword);
        btnPassNext.click();
    }

    public boolean verifyProductsMenuIcon() {
        waitForSec(4);
        logger.info("Going to Verify that the user has logged in");
        return iconMenu.isElementPresent();
    }

    public void clickJoinClassButtonDashboard() {
        waitForSec(2);
        if (btnJoinClassStu.isElementPresent()) {
            btnJoinClassStu.click();
            logger.info("Clicked on the big '+' button");
        }
    }

    public void selectJoinClassOptionDashboard() {
        waitForSec(2);
        if (optionJoinClass.isElementPresent()) {
            optionJoinClass.click();
            logger.info("Clicked on the Join Class button");
        }
    }

    public void setClassCode() {
        if (txtBoxClassCode.isElementPresent()) {
            txtBoxClassCode.click();
            txtBoxClassCode.sendKeys(googleClassCode);
            logger.info("Clicked on the Join Class button");
        }
    }

    public void clickOnJoinButton() {
        if (btnJoinStu.isElementPresent()) {
            waitForSec(2);
            btnJoinStu.click();
            logger.info("Clicked on the Join button after providing the class code");
        }
    }

    public boolean verifyClassJoined() {
        waitForSec(5);
        return txtClassName.isElementPresent();
    }

    public void clickOnClassworkLink() {
        if (linkClassWork.isElementPresent()) {
            linkClassWork.click();
            logger.info("Clicked on the ClassWork Link at the top of the page");
        }
    }

    public void expandAssignmentBar() {
        waitForSec(2);
        if (btnAssignment.isElementPresent()) {
            btnAssignment.click();
            logger.info("Clicked on the assignment bar to expand it");
        }
    }

    public void clickAssignmentLink() {
        waitForSec(2);
        System.out.println("#######################################WindowHandle----" + webDriver.getWindowHandle());
        if (linkAssignment.isElementPresent()) {
            linkAssignment.click();
            logger.info("Clicked on the assignment link to open the assignment");
        }
    }

    public void clickOkReviewGCPermission() {
        waitForSec(5);
        if (btnOkToReviewPermission.isElementPresent()) {
            btnOkToReviewPermission.click();
            waitForSec(2);
        }
    }

    public void chooseStudentAccount(String stuPass) {
        waitForSec(2);
        if (linkSelectStudentProfileGC.isElementPresent()) {
            linkSelectStudentProfileGC.click();
            waitForSec(4);
            /*txtBoxPass.setText(stuPass);
            waitForSec(2);
            btnNext.clickJScript();*/
        }
    }

    public void chooseTeacherAccount(String stuPass) {
        waitForSec(2);
        if (linkSelectTeacherProfileGC.isElementPresent()) {
            linkSelectTeacherProfileGC.click();
            waitForSec(4);
            txtBoxPass.setText(stuPass);
            waitForSec(2);
            btnNext.clickJScript();
            waitForSec(4);
        }
    }

    public boolean verifyPracticePageOpened() {
        waitForSec(12);
        String pageUrl = "https://flexbooks.ck12.org/cbook/ck-12-interactive-geometry-for-ccss/r115/section/1.2/primary/lesson/angles-and-lines-geo-ccss/";
        return webDriver.getCurrentUrl().equalsIgnoreCase(pageUrl);
    }

    public void beginPracticeAttempt() {
        if (btnStartOrContinuetPractice.isElementPresent()) {
            btnStartOrContinuetPractice.click();
            logger.info("Clicked on Start/Continue Practice button at the bottom of the page");
        }
        if (btnStartOrKeepPracticing.isElementPresent()) {
            btnStartOrKeepPracticing.click();
            logger.info("Clicked on Start/Keep Practicing button in the adaptive practice modal");
        }
        if (btnStartPracticingPrePracticeScreen.isElementPresent()) {
            btnStartPracticingPrePracticeScreen.click();
            logger.info("Clicked on Start Practicing button on the Pre-Practice info screen");
        }
        waitForSec(4);
    }

    public void clickOnStopForNow() {
        if (btnStopForNow.isElementPresent()) {
            btnStopForNow.click();
            logger.info("Clicked on Stop for Now button");
        }
    }

    public boolean verifyConceptPageLoadsAfterSubmit() {
        waitForSec(8);
        return btnStartOrKeepPracticing.isElementPresent();
    }
}
