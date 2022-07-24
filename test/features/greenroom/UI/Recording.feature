Feature: Recodring Regression Tests

@recodring_regression_user_1
Scenario: Login and perform actions related to recodrings
    Given Login to standalone greenroom as producer using brandlive.loadautomation1@gmail.com
     And Select the channel for automation
	 And Create New SGR Event and invite brandlive.loadautomation4@gmail.com
	 And Search and Navigate to Show Details Page
	 And Navigate to Live Mode
	 And Open Media Drawer
	 And Start recording of the show
	 And Play Intro Shot
	 And Pause 1 times execution for 1 mins
   	 And Stop recodring of the show
     And Navigate to Recordings tab
	 And Validate that recording is saved with correct name