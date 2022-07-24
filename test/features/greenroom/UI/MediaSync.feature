Feature: Media Sync Tests

@media_sync_user_1
Scenario: Login and perform actions related to video play
     Given Login to standalone greenroom as producer using brandlive.loadautomation1@gmail.com
     And Select the channel for automation
	And Create New SGR Event and invite brandlive.loadautomation5@gmail.com
	And Search and Navigate to Show Details Page
	And Navigate to Live Mode
	And Expand Show board
     And Play Intro Shot
	And Pause 1 times execution for 1 mins
     And Pause video playing on the shot
     And Get the duration at which the video is paused
     And Pause 2 times execution for 3 mins

@media_sync_user_2
     Scenario: Login and perform actions related to video play as producer
     Given Login to standalone greenroom as producer using brandlive.loadautomation2@gmail.com
     And Select the channel for automation
	And Search and Navigate to Show Details Page
     And Navigate to Live Mode
     And Get the duration at which the video is paused
     And Validate that the video is paused at the correct duration



