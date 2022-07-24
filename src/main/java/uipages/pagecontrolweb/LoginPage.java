package uipages.pagecontrolweb;

import constants.Constants;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import uipages.BasePageWeb;
import utils.GuiControlWeb;

public class LoginPage extends BasePageWeb {
    private static final org.apache.log4j.Logger logger = Logger.getLogger(LoginPage.class);
    private String message;
    private final GuiControlWeb signInLink = new GuiControlWeb(getElementMap().get("signInLink"), webDriver);
    private final GuiControlWeb inputTextEmail = new GuiControlWeb(getElementMap().get("inputTextEmail"), webDriver);
    private final GuiControlWeb inputTextPassword = new GuiControlWeb(getElementMap().get("inputTextPassword"), webDriver);
    private final GuiControlWeb buttonSignIn = new GuiControlWeb(getElementMap().get("buttonSignIn"), webDriver);
    private final GuiControlWeb messageContent = new GuiControlWeb(getElementMap().get("messageContent"), webDriver);

    public LoginPage(WebDriver webDriver) {
        super(webDriver);
    }

    //Enter credentials for login and click on Sign In button
    public void login(String username, String password) {
        signInLink.clickJScript();
        inputTextEmail.waitUntilClickableAndClick();
        logger.info("Clicked on the email test field.");
        inputTextEmail.setText(username);
        inputTextPassword.waitUntilClickableAndClick();
        inputTextPassword.setText(password);
        buttonSignIn.waitUntilClickableAndClick();
    }

    //Catch message content
    private void catchMsgContent() {
        message = messageContent.getText();
    }

    //Verify error message visibility
    public boolean isToastMessageDisplayed() {
        if (messageContent.getWebElements().isEmpty()) {
            return true;
        } else if (!messageContent.getWebElements().isEmpty()) {
            catchMsgContent();
            return !Constants.MSG_AT_LOGIN.equals(message);
        } else {
            return true;
        }
    }
}