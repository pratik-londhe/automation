@gr.events_3_notification_invitation.released

Feature: Test the Home , Notification , Show-sessions and Invitation in the Green room using Events 3.x

  Scenario: Precondition scenario for Home , Notification and Invitation 
    Given Logged in to Events "3.0"
    Given Logged in to Greenroom using Events "3.0"
    And Create a new Event
    And Check all E3 channels
    And Check all GR channels
    And Get all GR Events
  
  Scenario: Check Home APIs in GR for Events 3.0
    And Load Teams
    And Find Users
    And Get Active Rooms
    And Get Events for Producer
    And Get Presenter Invitation Call
    
  Scenario: Check Notification APIs in GR for Events 3.0
    And Create or Update Meeting Room
    And Get Meeting Room Details
    And Get Media Details for Meeting Room
    And Load Shots
 	  And Create Notification
 	  And Retrieve Notitication
 	  And Set Seen Notification
    
	Scenario: Check Session APIs in GR for Events 3.0
    And Get Session Types
 	  And Create Session
 	  And Get Session Details by Meeting Id
 	  And Update Session
 	  And Delete Session
 	  And Check Producer for Session Call
 	  
	Scenario: Check Invitation APIs in GR for Events 3.0
    And Create Invitation
    And Create Multiple Invitations
 	  And Create Invitation Notification
 	  And Create iOS Notification
 	  And Get Invitation by Meeting Id 
    And Revoke Invitation