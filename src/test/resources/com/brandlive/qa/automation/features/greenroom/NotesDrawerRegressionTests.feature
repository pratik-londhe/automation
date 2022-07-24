@gr.events3_GR_Basic_RegressionTest.released

Feature: Regression tests for  Greenroom

    Scenario: Add multiple notes and share them with presenters and delete them
      Given Logged in to Events "3.0" successfully
      And Check correct channel selected in events "3.0"
      And Create open event "3.0" with broadcast session
      And Publish event "3.0"
      And Logged in to Greenroom after Events successfully
      And Check correct channel selected in Greenroom
      And Navigate to event card details
      And Enter Greenroom in Live mode
      And Enter Greenroom in builder mode
      And Invite presenter "priyavertis@gmail.com" to the show
      And Open notes drawer
      And Create a new "Note" as "NoteQA" in notes drawer
      And Share the note with presenter
      And Validate note is shared with presenter from producer notes drawer

  Scenario: Add multiple short notes (teleprompters) and share them with presenters and delete them
    And Create a new "Shot Notes" as "TestQA" in notes drawer
    And Share the note with presenter
    And Validate note is shared with presenter from producer notes drawer
    And Exit Greenroom from Live mode to return shows
    And Logged out of Greenroom
    And Login to greenroom as presenter with following credentials
      | emailId | password |
      | priyavertis@gmail.com | Forgeahead01! |
    And Join the show as presenter
    And Navigate to event card details as presenter
    And Open notes drawer
    And Validate presenter is able to see the shared note "ShotNoteQA"
    And Logged out as presenter from greenroom
    And Logged out of Events "3.0" after Greenroom