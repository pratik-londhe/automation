@streams_event_creation_broadcast_session
Feature: Event3.0 creation

Scenario: Create Event3.0 and publish it.
    Given Login to streams using UI
    And Select the streams channel for automation
    And Create event3.0 with broadcast session
    And publish an event3.0