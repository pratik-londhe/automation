Feature: Chat Drawer Regression Tests

@chat_regression_user_3
Scenario: Login and perform actions related to chat drawer
    Given Login to standalone greenroom as producer using brandlive.loadautomation3@gmail.com
     And Select the channel for automation
	 And Create New SGR Event and invite brandlive.loadautomation4@gmail.com
	 And Search and Navigate to Show Details Page
	 And Navigate to Live Mode
	 And Open Chat Drawer
	 And Open Presenter Group Chat
	 And Send a message to one of the presenter
	 And Sign out the greenroom from Live Mode
   	 And Login to standalone greenroom as producer using brandlive.loadautomation4@gmail.com
     And Select the channel for automation
	 And Search and Navigate to Show Details Page
	 And Navigate to Live Mode
	 And Open Chat Drawer
	 And Validate chat notification on chat drawer
	 And Open Presenter Group Chat
	 And Validate sent message in group chat