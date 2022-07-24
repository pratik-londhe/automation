@gr.events3_On_Demand.Video.iframe.released

Feature: Event3.0 On Demand functionality

  Scenario: Create events 3.0 with upload a video using iframe for On Demand session
    Given Logged in to Events "3.0" successfully
    And Check correct channel selected in events "3.0"
    And Create event "3.0" with on demand session
    And Upload a video using iframe
      | Stream Option   | Video Iframe                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                     |
      | Embedded Iframe | <iframe width="560" height="315" src="https://www.youtube.com/embed/Wd8SxdtIx4w" title="YouTube video player" frameborder="0" allow="accelerometer; autoplay; clipboard-write; encrypted-media; gyroscope; picture-in-picture" allowfullscreen></iframe> |
    And Publish event "3.0"
    And Go live with the event "3.0"
    And Check the streaming for the uploaded video iframe for on demand session