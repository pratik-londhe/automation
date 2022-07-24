@standalone_api
Feature: Standalone API Feature

Scenario: Create Standalone Event 
	Given Check producer app access
	And Login to greenroom with greenroom
	And Get all standalone GR channels
	And Get all standalone GR events
	And Create new standalone GR Event 
	And Verify newly created standalone GR Event
	And Copy newly created greenroom

Scenario: Check Standalone Api Home Page
	And Check presenter app access
	And Update profile details for greenroom
	And Get Standalone meetings by channel Id
	And Get Standalone meetings by event id

Scenario: Check Standalone Api for Details Page
	And Get active rooms
	And Get details using meeting id
	And Send inviations to presenter using meeting id
	And Get inviations using room id
	And Get broadcast check by meeting id
	
Scenario: Check Standalone Api for Live Mode
	And Get rooms media details
	And Write State for SET_PRESENTED_MEDIA in Live mode
	And Get Direct Chat Messages 
	And Get Room Chat Messages 