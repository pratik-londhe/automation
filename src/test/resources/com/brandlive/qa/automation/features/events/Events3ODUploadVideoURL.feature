@gr.events3_On_Demand.released

Feature: Event3.0 On Demand functionality

  Scenario: Create events 3.0 with upload a video using URL for On Demand session
    Given Logged in to Events "3.0" successfully
    And Check correct channel selected in events "3.0"
    And Create event "3.0" with on demand session
    And Upload a video using URL
      | Stream Option | Video URL                                   |
      | Link video    | https://www.youtube.com/watch?v=Wd8SxdtIx4w |
    And Publish event "3.0"
    And Go live with the event "3.0"
    And Check the streaming for the uploaded video for on demand session