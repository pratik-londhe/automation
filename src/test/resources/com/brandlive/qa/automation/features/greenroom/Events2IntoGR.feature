@gr.events_2.released

Feature: Test the calendar view feature and navigation in the Green room using Events 2.x

	Scenario: Check Rest APIs of Events Home 2.5
	Given Logged in to Events "2.5"
	And Check all E2 channels
	
	Scenario: Create events rest api for events 2.5
	Given Logged in to Events "2.5"
	And Check all E2 channels
	And Check E2 event name for duplication
	And Create a new E2 Event
	And Publish E2 Event
	
	#Scenario: Create event with Events 2.5
	#Given Logged in to Events "2.5" successfully
	#And Check correct channel selected in events "2.5"
	#And Created and published event "2.5" successfully
	#And Logged out of Events "2.5"
	
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
	
	Scenario: Check Rest APIs of GR Home for Events 2.5
	Given Logged in to Greenroom using Events "2.5"
	And Check all GR channels
  And Get all GR Events
