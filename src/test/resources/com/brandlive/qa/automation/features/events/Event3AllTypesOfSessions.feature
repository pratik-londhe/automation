@gr.events3_all_session.released

Feature: Event3.0 Multiple attendee registrations for all types of sessions

  Scenario: Multiple attendee registrations for all types of sessions
    Given Logged in to Events "3.0" successfully
    And Check correct channel selected in events "3.0"
    And Create event "3.0" with all types of session with english language and registration
    And Publish and Go live
    And Multiple attendee register to an event
      | FirstName | LastName | Email                       |
      | Pratik    | Londhe   | pratik.londhe@forgeahead.io |
      | Pradnyan  | Bhilare  | pradnyan@gmail.com          |
    And Logged out of Events "3.0"