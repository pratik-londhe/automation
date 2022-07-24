package com.brandlive.qa.automation.greenroom.adapters;

import com.brandlive.qa.automation.greenroom.pages.BuilderModeChatDrawer;
import com.brandlive.qa.automation.utils.Doer;
import org.openqa.selenium.support.ui.ExpectedCondition;

public class ChatDrawerAdapter extends Doer {
    BuilderModeChatDrawer builderModeChatDrawer = new BuilderModeChatDrawer();

    public void navigateToChatDrawer(){
        builderModeChatDrawer.openChatDrawerInBuilderMode();
    }

    public void sendMsgToPresenterGroup(String msg){
        builderModeChatDrawer.openPresenterGroupChatInBuilderMode();
        builderModeChatDrawer.sendMsgInChat(msg);
        builderModeChatDrawer.closeChatMessagesWindow();
    }

    public void sendDMToPresenter(String msg){
        builderModeChatDrawer.openDMChatInBuilderMode();
        builderModeChatDrawer.sendMsgInChat(msg);
        builderModeChatDrawer.closeChatMessagesWindow();
    }

    public boolean validatePresenterGroupNotification(){
        return builderModeChatDrawer.validateChatNotificationOnPresenterGroup();
    }

    public boolean validateChatDrawerNotification(){
        return builderModeChatDrawer.validateChatNotificationOnChatDrawer();
    }

    public boolean validateDMChatNotification(){
        return builderModeChatDrawer.validateChatNotificationOnPresenterDM();
    }

    public void validateUnreadChatToastNotification(){
        builderModeChatDrawer.validateUnreadChatToastNotification();
    }

    public void openPresenterGroup(){
        builderModeChatDrawer.openPresenterGroupChatInBuilderMode();
        builderModeChatDrawer.closeChatMessagesWindow();
        sleep(2);
    }

}
