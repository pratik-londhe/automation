/*
package uipages.flexbook2feature;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import uipages.BasePage;
import utils.GuiControl;
import org.apache.log4j.Logger;


public class ChatBotPage extends BasePage {
    private static final Logger logger = Logger.getLogger(ChatBotPage.class);

    private final GuiControl textChatBot = new GuiControl(getElementMap().get("textChatBot"), webDriver);
    private final GuiControl firstCreditOption = new GuiControl(getElementMap().get("firstCreditOption"), webDriver);
    private final GuiControl secondCreditOption = new GuiControl(getElementMap().get("secondCreditOption"), webDriver);
    private final GuiControl thirdCreditOption = new GuiControl(getElementMap().get("thirdCreditOption"), webDriver);
    private final GuiControl msgPaymentCard = new GuiControl(getElementMap().get("msgPaymentCard"), webDriver);
    private final GuiControl btnDueDate = new GuiControl(getElementMap().get("btnDueDate"), webDriver);
    private final GuiControl msgPaymentDetails = new GuiControl(getElementMap().get("msgPaymentDetails"), webDriver);
    private final GuiControl errorMessageOfPaymentDetails = new GuiControl(getElementMap().get("errorMessageOfPaymentDetails"), webDriver);
    private final GuiControl messagePaymentConfirmation = new GuiControl(getElementMap().get("messagePaymentConfirmation"), webDriver);
    private final GuiControl balanceRemaining = new GuiControl(getElementMap().get("balanceRemaining"), webDriver);

    public ChatBotPage(WebDriver webDriver, ExtentTest extentTest, ExtentReports extentReports) {
        super(webDriver, extentTest, extentReports);
    }

    public void enterText(String questions) {
        webDriver.switchTo().frame(0);
        textChatBot.scrollIntoView();
        textChatBot.setText(questions);
        waitForSec(4);
        textChatBot.sendKeys(String.valueOf(Keys.ENTER));
        waitForSec(6);
    }

    public boolean verifyPresenceOfChatTextBox() {
        return textChatBot.isElementPresent();
    }


    public boolean isCreditCardsOptionVisible() {
        return firstCreditOption.isElementPresent() && secondCreditOption.isElementPresent() && thirdCreditOption.isElementPresent();
    }

    public void clickOnFirstCreditOption() {
        if (firstCreditOption.isElementPresent()) {
            firstCreditOption.click();
            logger.info("Clicked on the first credit option.");
            waitForSec(4);
        }
    }

    public boolean isCreditCardsPaymentMessageVisible() {
        String creditCardMessage = "Your payment for credit card 5624 is due on Wed, Jun 26, 2019. You can choose one of the options below, or enter your preferred payment date.";
        return creditCardMessage.equals(msgPaymentCard.getText());
    }

    public void clickOnDueDateButton() {
        if (btnDueDate.isElementPresent()) {
            btnDueDate.click();
            logger.info("Clicked on the due date button.");
            waitForSec(2);
        }
    }

    public boolean verifyThePaymentDetailsMessage() {
        String paymentDetails = "Your minimum payment for credit card 5624 is $50. Your balance is $430. How much would you like to pay on your credit card?";
        return paymentDetails.equals(msgPaymentDetails.getText());
    }

    public void enterValueMoreThanBalance(String paymentValue) {
        textChatBot.setText(paymentValue);
        waitForSec(4);
        textChatBot.sendKeys(String.valueOf(Keys.ENTER));
        waitForSec(6);
    }

    public boolean verifyTheInvalidMessageWhenBalanceIsMore() {
        String errorMessage = "Unfortunately that's more than the current balance of $430. Please enter a new amount.";
        return errorMessage.equals(errorMessageOfPaymentDetails.getText());
    }

    public boolean verifyThePaymentConfirmationMessage() {
        String errorMessage = "Okay, we'll make a payment of $50 on Wed, Jun 26, 2019 to credit card 5624. Is this information correct?";
        return errorMessage.equals(messagePaymentConfirmation.getText());
    }

    public void replayYes(String replay) {
        textChatBot.setText(replay);
        waitForSec(4);
        textChatBot.sendKeys(String.valueOf(Keys.ENTER));
        waitForSec(6);
    }

    public String verifyTheRemainingBalanceAfterPay() {
        return balanceRemaining.getText();
    }
}
*/
