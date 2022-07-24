@gr.events3_fireside.released

Feature: Event3.0 Fireside functionality

  Scenario: Create events 3.0 with fireside session
    Given Logged in to Events "3.0" successfully
    And Check correct channel selected in events "3.0"
    And Create event "3.0" with fireside session
    And Enable the Profile Avatar and tickets for the event "3.0" registration
    And Publish event "3.0"

  Scenario: Check the Fireside session rooms for the single user
    Given The event "3.0" live page is opened and registration is successful by host user
      | FirstName | LastName | Email                           | Passcode | CardName      | CardNumber          | Expiration | cvv | CompanyName | Bio       | FunFact  | Location   |
      | Pratik    | Londhe   | brandlive.automation1@gmail.com | PASS123  | Pratik Londhe | 4242 4242 4242 4242 | 1126       | 123 | FA          | Tech Lead | Fun Fact | Pune India |
    And Verify the Sign in page
      | SignInMessage                                                                                      |
      | Please check your email. We've sent you a confirmation with a link you can use to enter the event. |
    And Logged out of Events "3.0"