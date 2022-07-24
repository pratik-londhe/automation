package com.brandlive.qa.automation.events3.adapters.live;

import com.brandlive.qa.automation.events3.pages.live.QuestionsPage;
import com.brandlive.qa.automation.utils.Doer;

public class Event3QuestionsAdapter extends Doer {
    QuestionsPage questionsPage = new QuestionsPage();

    public void clickOnQuestionsTab() {
        questionsPage.clickOnQuestionTab();
    }

    public void enterQuestion(String question) {
        questionsPage.enterQuestion(question);
    }

    public void verifyQuestionMessage(String queMsg, String moderationAction, boolean approved) {
        questionsPage.verifyQuestionMessage(queMsg, moderationAction, approved);
    }
}