Feature: Design Drawer Regression Tests

@design_regression_user_1
Scenario: Login and perform actions related to design drawer
    Given Login to standalone greenroom as producer using brandlive.loadautomation1@gmail.com
     And Select the channel for automation
	 And Create New SGR Event and invite brandlive.loadautomation4@gmail.com
	 And Search and Navigate to Show Details Page
	 And Navigate to Live Mode
     And Navigate to Showbuilder Mode
     And Expand Show board
     And Add 1B Layout between Intro and Outro shot
     And Open feeds Tab
     And Drag and drop feeds to the canvas
     And Open Design Tab
     And Navigate to Tiltes Tab
     And Add title design and animation for the shot
     And Open Shot Tab
     And Turn the Titles on for the shot
     And Exit Showbuilder mode
	 And Play Intro Shot
     And Click Next Shot
