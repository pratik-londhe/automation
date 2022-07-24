@events_3.event_content_entities.released

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
    
  Scenario: Update contents and entities to events 3.0
	 And Add a channel product to event
	 #And Upload a new product to channel
	 #And Delete the newly uploaded product to channel    
   And Add a channel sponsor to event
   And Add a channel speaker to event 
   #And Upload a new video to channel
   #And Delete the newly uploaded video to channel
   And Add a channel video to event
   #And Get Recorded Videos by channel Id
   And Upload a new document to channel
   And Delete the newly uploaded document to channel 
   And Add a channel document to event session
   And Add a channel survey to event session
   And Get all registrations for an event
