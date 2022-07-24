package com.brandlive.qa.automation.events3.adapters.live;

import com.brandlive.qa.automation.events3.pages.live.ChatPage;
import com.brandlive.qa.automation.utils.Doer;

public class Event3ChatAdapter extends Doer {
    ChatPage chatPage = new ChatPage();

    public void verifyProfileDetailsPopUpBeforeChatForOpenEvent() {
        chatPage.verifyProfileDetailsPopUpWindow();
    }

    public void verifyChatMessage(String chatMsg, String moderationAction, boolean approved) {
        chatPage.verifyChatMessage(chatMsg, moderationAction, approved);
    }

    public void sendChatMessage(String chatMessage) {
        chatPage.sendChatMessage(chatMessage);
    }
}