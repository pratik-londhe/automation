@gr.events3_add_upload.released

Feature: Event3.0 add and upload functionality

  Scenario: Add products, speakers, sponsors, videos, polls and documents on LP,Home Page and Session page and validate it at live experience.
    Given Logged in to Events "3.0" successfully
    And Check correct channel selected in events "3.0"
    And Create event "3.0" with broadcast session
    And Add products, speakers, sponsors, videos on LP
    And Add products, speakers, sponsors, videos on Home Page
    And Add speakers, similar sessions, polls, documents at the session page
    And Publish and Go live
    And Validate the speakers, sponsors, videos, products, polls, documents on LP, Home Page and session page
      | FirstName | LastName | Email                       |
      | Pratik    | Londhe   | pratik.londhe@forgeahead.io |
    And Logged out of Events "3.0"