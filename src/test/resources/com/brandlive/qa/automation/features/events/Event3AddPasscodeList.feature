@gr.events3_passcode.released

Feature: Event3.0 add and upload functionality

  Scenario: Add passcode list (Email with Passcode) with master passcode and perform multiple registrations with live experience
    Given Logged in to Events "3.0" successfully
    And Check correct channel selected in events "3.0"
    And Create an event with multi Broadcast sessions, English Language and registration
      | TemplateName | Language |
      | Studio 54    | french   |
    And Add passcode list (Email with Passcode) with master passcode added.
      | GatingType    | MediaType | MediaName        | ProductName | PasscodeListName | MasterPasscode | PasscodeType            |
      | Audience List | documents | PasscodeList.csv | Events      | PasscodeListName | MasterPass123  | Both email and passcode |
    And Publish and Go live
    And Multiple attendee able to register successfully with passcode with live experience
      | FirstName | LastName | Email                       | MasterPasscode |
      | Pratik    | Londhe   | pratik.londhe@forgeahead.io | MasterPass123  |
      | Pradnyan  | Bhilare  | pradnyan@gmail.com          | MasterPass123  |
    And Logged out of Events "3.0"