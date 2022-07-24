@streams_event_creation_breakout_v2_session
Feature: Create Event3.0 creation

Scenario: Create Event3.0 and publish it.
    Given Login to streams using UI
    And Select the streams channel for automation
    And Create event3.0 with breakout V2 session with two rooms added
    And publish an event3.0