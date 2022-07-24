@gr.events_3.released

Feature: Test the calendar view feature and navigation in the Green room using Events 3.x

  Scenario: Check Rest APIs of Events Home 3.0
    Given Logged in to Events "3.0"
    And Check all E3 channels
    And Get Events by channel Id
    And Get Events metrics by channel Id

  Scenario: Create events rest api for events 3.0
    #Given Logged in to Events "3.0"
    #And Check all E3 channels
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

  Scenario: Check Rest APIs of GR Home for Events 3.0
    Given Logged in to Greenroom using Events "3.0"
    And Check all GR channels
    And Get all GR Events

  Scenario: Check Rest APIs of GR Details Page for Events 3.0
    And Create or Update Meeting Room
    And Load Shots
    And Get Meeting Room Details
    And Get Media Details for Meeting Room
    And Check Broadcast for Meeting Room
    And Get RTMP Details for Meeting Room
    
  Scenario: Check Rest APIs of GR Live Mode Page for Events 3.0
    And Create or Update Meeting Room
    And FeatureFlag API Call
    And Load Shots
    And Post Tokbox Token API
    And Write State for "ADD_PRESENTER_VIDEO" in "Live" mode
    And Get Background in Live Mode
    And Write State for "SET_PRESENTED_MEDIA" in "Live" mode

  Scenario: Check Rest APIs of GR Builder Mode Page for Events 3.0
    And Post Setting API
    And Write State for "SET_PRESENTED_MEDIA" in "Builder" mode
    And Write State for "SET_CURRENT_SHOT_ID" in "Builder" mode
    And Check if producer is present in session call
    
  Scenario: Add a new shot with single feed inside Builder Mode Page
    And Add a new shot 
    And Load Shots
    And Bulk Edit Shots
    And Load Shots
    And Write State for "SET_CURRENT_SHOT_ID" in "Builder" mode
    And Edit the shot
    And Load Shots
    
  Scenario: Select a newly created shot 
    And Load Shots
    And Write State for "SET_CURRENT_SHOT_ID" in "Builder" mode
    And Select the shot
    And Add Shot duration
    And Load Shots
    
 Scenario: Upload a media to newly selected shot
    And Upload "sample.mp4" file
    And Verify upload for "sample.mp4"
    And Upload "dummy.pdf" file
    And Verify upload for "dummy.pdf"
    And Upload "image1.jpg" file
    And Verify upload for "image1.jpg"
    And Upload "image2.png" file
    And Verify upload for "image2.png"
    And Select the shot
    And Drag n Drop Media to Shot 
    And Write State for "SET_CURRENT_SHOT_ID" in "Builder" mode
    And Load Shots

 Scenario: Navigate to LiveMode from BuilderMode 
    And Go to LiveMode from BuilderMode 
    And Edit the first Shot
    And Write State for "SET_CURRENT_SHOT_ID" in "Builder" mode
    And Load Shots
    
 
 Scenario: Start GR show in Live mode
    And Go "Live" with Start Api Call
    And Go "Live" with Stream Api Call
    And Write State for "SET_PRESENTED_MEDIA" in "Live" mode
 
 
 Scenario: Start playshot to broadcast first shot
  	And Write State for "SET_CURRENT_SHOT_ID" in "Builder" mode
    And Load Shots
   
 Scenario: Start nextshot to broadcast second shot
    And Edit the next shot
    And Write State for "SET_CURRENT_SHOT_ID" in "Builder" mode
    And Write State for "SET_PRESENTED_MEDIA" in "Broadcast" mode
    And Load Shots   
    
Scenario: End GR show in Live mode
	 And "End" with Stop Api Call
	 And "End" with Stream Api Call
	 And  FeatureFlag API Call 
	
 Scenario: Delete Newly added Media and Shot
    And Delete newly added media
    And Bulk Edit Shots for Delete Media
    And Load Shots
    And Delete newly added shot 
    And Write State for "SET_CURRENT_SHOT_ID" in "Live" mode
    And Load Shots
    And Get Opentok session Details for Meeting Room
    
   