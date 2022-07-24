package com.brandlive.qa.automation.events3.pages.live;

import com.brandlive.qa.automation.utils.Base;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class QuestionsPage extends Base {

    public void clickOnQuestionTab() {
        log.info("Click on the Questions Tab.");
        String question = "//span[text()='Questions']";
        WebElement questionTab = waitForDisplayedAndEnabled(By.xpath(question), "Questions Tab on event live page");
        questionTab.click();
        log.info("Clicked on the Questions Tab.");
    }

    public void enterQuestion(String questionMsg) {
        log.info("Enter the Question.");
        String question = "//input[@type='text']";
        String askQuestion = "//button[@class='button ']";
        WebElement questionText = waitForDisplayedAndEnabled(By.xpath(question), "Questions text on event live page");
        questionText.sendKeys(questionMsg);
        log.info("Entered the Question.");
        WebElement askQuestionButton = waitForDisplayedAndEnabled(By.xpath(askQuestion), "Ask Questions button on event live page");
        askQuestionButton.click();
        log.info("Clicked on the Ask Questions button.");
        sleep(3);
    }

    public boolean verifyQuestionMessage(String queMsg, String moderationAction, boolean approved) {
        boolean result = false;
        String queMessage = "//h4[text()='" + queMsg + "']";
        if (moderationAction.equals("OFF")) {
            if (elementPresent(By.xpath(queMessage))) {
                log.info("The Question message is displayed.");
                result = true;
            } else {
                log.info("The Question message is not present.");
                return false;
            }
        } else if (moderationAction.equals("ON")) {
            if (!approved) {
                if (!elementPresent(By.xpath(queMessage))) {
                    log.info("The Question message is not displayed.");
                    result = true;
                } else {
                    log.info("The Question message is present.");
                    return false;
                }
            } else {
                if (elementPresent(By.xpath(queMessage))) {
                    log.info("The Question message is displayed after approved.");
                    result = true;
                } else {
                    log.info("The Question message is not displayed after approved.");
                    return false;
                }
            }
        }
        return result;
    }
}