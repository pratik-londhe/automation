package uipages.flexbook2feature;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import io.qameta.allure.Step;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import uipages.BasePage;
import utils.GuiControl;

public class LoginPage extends BasePage {
    private static final Logger logger = Logger.getLogger(LoginPage.class);

    private final GuiControl linkSignIn = new GuiControl(getElementMap().get("linkSignIn"), webDriver);
    private final GuiControl txtEmail = new GuiControl(getElementMap().get("txtEmail"), webDriver);
    private final GuiControl txtPassword = new GuiControl(getElementMap().get("txtPassword"), webDriver);
    private final GuiControl btnSignIn = new GuiControl(getElementMap().get("btnSignIn"), webDriver);
    private final GuiControl btnJoin = new GuiControl(getElementMap().get("btnJoin"), webDriver);
    private final GuiControl ClosePopUp = new GuiControl(getElementMap().get("ClosePopUp"), webDriver);
    private final GuiControl signInWithGoogle = new GuiControl(getElementMap().get("signInWithGoogle"), webDriver);
    private final GuiControl linkSignInProd = new GuiControl(getElementMap().get("linkSignInProd"), webDriver);
    private final GuiControl halloweenPopUp = new GuiControl(getElementMap().get("halloweenPopUp"), webDriver);
    private final GuiControl acceptTouPopUp = new GuiControl(getElementMap().get("acceptTouPopUp"), webDriver);
    private final GuiControl TOUSystemMessage = new GuiControl(getElementMap().get("TOUSystemMessage"), webDriver);
    private final GuiControl notificationPopUp = new GuiControl(getElementMap().get("notificationPopUp"), webDriver);
    private final GuiControl piePopUP = new GuiControl(getElementMap().get("piePopUP"), webDriver);

    public LoginPage(WebDriver webDriver, ExtentTest extentTest, ExtentReports extentReports) {
        super(webDriver, extentTest, extentReports);
    }

    public void login(String email, String password) {
        waitForSec(4);
        if (txtEmail.isElementPresent()) {
            txtEmail.setText(email);
            reportLog("Entered the Email.");
            txtPassword.setText(password);
            reportLog("Entered the Password.");
        }
    }

    public boolean verifySignInLink() {
        return linkSignIn.isElementPresent();
    }

    public void clickOnSignInLink() {
        if (linkSignIn.isElementPresent()) {
            linkSignIn.click();
            reportLog("Clicked on Sign In link.");
        }
    }

    public void clickOnBtnSignIn() {
        waitForSec(5);
        if (btnSignIn.isElementPresent()) {
            btnSignIn.clickJScript();
            reportLog("Clicked on Sign In button.");
        }
    }

    public void clickOnJoinButton() {
        if (btnJoin.isElementPresent()) {
            btnJoin.click();
            reportLog("Clicked on Join button.");
        }
    }

    public void studentLogin(String email, String password) {
        clickOnSignInLink();
        login(email, password);
        clickOnBtnSignIn();
        clickOkOnTouPopUp();
    }

    public void teacherLogin(String email, String password) {
        closePopUp();
        clickOnSignInLink();
        reportLog("Clicked on Sign In link.");
        login(email, password);
        clickOnBtnSignIn();
        reportLog("Clicked on Sign In button.");
        clickOkOnTouPopUp();
    }

    public void closePopUp() {
        try {
            if (ClosePopUp.isElementPresent()) {
                ClosePopUp.clickJScript();
                reportLog("Closed the Pop Up from the Home page.");
            }
        } catch (Exception e) {
            logger.info(e);
            reportLog("No any pop up are present on the home page.");
        }
    }

    public void signInWithGoogle() {
        signInWithGoogle.click();
        waitForSec(8);
    }

    public void clickOnSinInLinkProd() {
        linkSignInProd.click();
    }

    public void clickOnHalloweenPopUp() {
        try {
            halloweenPopUp.isElementPresent();
            halloweenPopUp.click();
        } catch (Exception e) {
            logger.info("No Pop up is displayed.");
        }
    }

    public void clickOkOnTouPopUp() {
        try {
            acceptTouPopUp.isElementPresent();
            acceptTouPopUp.click();
            waitForSec(4);
        } catch (Exception e) {
            logger.info("Terms of use update Pop up is not displayed.");
        }
    }

    public void closeTouSystemMessage() {
        try {
            TOUSystemMessage.isElementPresent();
            TOUSystemMessage.click();
        } catch (Exception e) {
            logger.info("Terms of use System message is not displayed.");
        }
    }

    public void closeNotificationPopUP() {
        try {
            notificationPopUp.isElementPresent();
            notificationPopUp.click();
        } catch (Exception e) {
            logger.info("Terms of use System message is not displayed.");
        }
    }

    public void closePiePopUP() {
        try {
            piePopUP.isElementPresent();
            piePopUP.click();
            logger.info("Closed the pie pop up.");
        } catch (Exception e) {
            logger.info("Pie pop up is not displayed..");
        }
    }
}