@gr.events_3_teleprompter_note_chat.released

Feature: Test Teleprompters, Chat and the Notes in the Green room using Events 3.x
  
  Scenario: Check Chats APIs in GR for Events 3.0
    And Create Chat Message
    And Get Chat Direct Message by meeting id
    And Get Chat of Room by meeting id
    
  Scenario: Check Notes APIs in GR for Events 3.0
    And Create a Note
    And Save and Share a Note
    And Get All Notes
    And Update Note by Id and Meeting Id
 
 	Scenario: Check Teleprompters APIs in GR for Events 3.0
 	  And Create a Teleprompter
    And Update Teleprompter by id
    And Share Teleprompter by id
    And Get Teleprompter information by id
    And Search Teleprompter
    And Create Teleprompter Section by id
    And Update Teleprompter Section by id 
