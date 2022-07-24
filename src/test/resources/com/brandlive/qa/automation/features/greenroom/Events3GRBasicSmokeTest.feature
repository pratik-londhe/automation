@gr.events3_GR_Basic_SmokeTest.released

Feature: Basic Smoke Test between Events 3.0 and Greenroom

	Scenario: Basic smoke test between Events 3.0 and Greenroom
	#Given Logged in to Events "3.0" successfully
	#And Check correct channel selected in events "3.0"
#	And Create open event "3.0" with broadcast session
#	And Publish event "3.0"
	#And Logged in to Greenroom after Events successfully
	#And Check correct channel selected in Greenroom
	#And Navigate to event card details
	#And Enter Greenroom in Live mode
#	And Enter Greenroom in builder mode
#	And Add one shot with 2 feeds
#	And Upload two files: picture and video
#	And Drag and drop two files on canvas
#	And Exit builder mode to enter live mode
#	And Go live with one shot GR show
#	And Go live with the event "3.0"
#	And Check the Greenroom show is streaming
	#And Exit Greenroom from Live mode to return shows
	#And Logged out of Greenroom
	#And Logged out of Events "3.0"

  Given Logged in to Events "3.0" successfully
	And Check correct channel selected in events "3.0"
	And Create open event "3.0" with broadcast session
	And Publish event "3.0"
	And Logged in to Greenroom after Events successfully
	And Check correct channel selected in Greenroom
	And Navigate to event card details
	And Enter Greenroom in Live mode
	And Enter Greenroom in builder mode
	And Validate Intro and Outro shots
		And Invite presenter "brandlive.automation1@gmail.com" to the show
	And Exit builder mode to enter live mode
	And Go live with the GR show
	And Go live with the event "3.0"
		And Check the Greenroom show is streaming live
		And Play the next shot from the show
		And Check the Greenroom show is streaming
		And Exit Greenroom from Live mode to return shows
		And Logged out of Greenroom
		And Login to greenroom as presenter with following credentials
			| emailId | password |
			| brandlive.automation1@gmail.com | Brandlive123!|
		And Join the show as presenter
		And Navigate to event card details as presenter
		And Check the show is streaming for presenter
		And Logged out as presenter from greenroom
		And Logged out of Events "3.0" after Greenroom
	
	#Scenario: Create event with Events 3.0
	#Given Logged in to Events "3.0" successfully
	#And Check correct channel selected in events "3.0"
	#And Created and published event "3.0" successfully
	#And Logged out of Events "3.0"
	
	#Scenario: View the Calendar at the Green room landing page
	#Given Logged in to Greenroom after Events successfully
	#And Check correct channel selected in Greenroom
	#When Select Calendar view
	#And Calendar view format changed to "Week" successfully
	#And Select List view again
	#And Logged out of Greenroom
	
	#Scenario: Navigate to Event Card Details
	#Given Logged in to Greenroom after Events successfully
	#And Check correct channel selected in Greenroom
	#When Navigate to event card details
	#And Enter Greenroom in Live mode
	#Then Exit Greenroom from Live mode to return shows
	#And Logged out of Greenroom