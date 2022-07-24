@events_3.event_session_crud.released

Feature: Test Event and Session CRUD operations using REST

  Scenario: Check Rest APIs of Events Home 3.0
    Given Logged in to Events "3.0"
    And Check all E3 channels
    And Get Events by channel Id

  Scenario: Create events rest api for events 3.0
    And Get Event Templates
    And Check event name for duplication
    And Check all available tracks
    And Create a new Event
    And Get Event Details by event uuid
    And Update Registration Steps
    And Check Live URL for duplication
    And Check Unpublished Event Status
    And Get Event Videos by channel Id
    And Get Event Speakers by channel Id
    And Get Event Products by channel Id
    And Get Event Sponsors by channel Id
    And Publish Event
    And Check Published Event Status
    And Get Events by channel Id
    #And Get registration questions for channel
    
  Scenario: Add a favicon to events 3.0
	 And Upload a favicon with social sharing    
	 And Delete a favicon with social sharing  
    
  Scenario: Add a custom page to events 3.0
		And Add a custom page to event     
		And Update a custom page to event
		And Get custom pages of event 	
  	
  Scenario: Add announcements to events 3.0  
    And Add announcement for whole event
    And Add announcement for registered attendees
    And Add announcement for all sessions
    
  Scenario: Add ToC and Privacy Policy to events 3.0  
    And Add terms and conditions for the event
    And Get terms and conditions for the event   
    And Update terms and conditions for the event 
    And Add privacy policy for the event
    And Get privacy policy for the event   
    And Update privacy policy for the event 
    
  Scenario: Duplicate Event for events 3.0
  	And Duplicate Event  
  	And Publish Duplicate Event
  	And Update the duplicate published event URL
  	And Add new Broadcast session
  	And Get Session by Id
  	And Get Session by Uuid
  	And Get session RTMP details
  	And Update Broadcast session for schedule
  	And Update the duplicated event
  	And Delete session by id
  	And Delete the duplicated event  	
  	