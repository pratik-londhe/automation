@gr.events3_Breakout_V2.released

Feature: Event3.0 Breakout V2(non zoom) functionality

  Scenario: Create events 3.0 with breakout v2 session (non zoom)
    Given Logged in to Events "3.0" successfully
    And Check correct channel selected in events "3.0"
    And Create event "3.0" with breakout v2 session with two rooms added
    And Enable the Profile Avatar and tickets for the event "3.0" registration
    And Publish event "3.0"

  Scenario: Check the breakout(non zoom) session rooms for the single user
    Given The event "3.0" live page is opened and registration is successful
      | FirstName | LastName | Email                       | Passcode | CardName      | CardNumber          | Expiration | cvv | CompanyName | Bio       | FunFact  | Location   |
      | Pratik    | Londhe   | pratik.londhe@forgeahead.io | PASS123  | Pratik Londhe | 4242 4242 4242 4242 | 1126       | 123 | FA          | Tech Lead | Fun Fact | Pune India |
    And Check the breakout room and Join the room
    And Validate the breakout room
    And Close the breakout room
    And Logged out of Events "3.0"