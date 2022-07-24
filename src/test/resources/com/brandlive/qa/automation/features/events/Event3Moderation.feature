@gr.events3_Moderation.released

Feature: Event3.0 Moderation functionality

  Scenario: Add chat and questions during live session and check that functionality on the Moderator window
    Given Logged in to Events "3.0" successfully
    And Check correct channel selected in events "3.0"
    And Create event "3.0" with broadcast session
    And Moderation is OFF
    And Publish and Go live
    And Add Chat and Questions during live session
      | FirstName | LastName | Email                       | ChatMessageModerationOFF | QuestionMessageModerationOFF |
      | Pratik    | Londhe   | pratik.londhe@forgeahead.io | Hello Moderation is OFF  | What are streaming types     |
    And Check that functionality on the Moderator window when Moderation is OFF
      | ChatMessageModerationOFF | QuestionMessageModerationOFF |
      | Hello Moderation is OFF  | What are streaming types     |
    And Moderation is ON
    And Check that functionality on the Moderator window when Moderation is ON
      | ChatMessageModerationON | QuestionMessageModerationON |
      | Hello Moderation is ON  | What are session types       |
