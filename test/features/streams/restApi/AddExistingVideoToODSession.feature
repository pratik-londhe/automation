@streams_on_demand_session
Feature: Strams add existing video to the On Demand session and publish the event

Scenario: Test Streams Home Api
    Given Login to streams
    And Get streams channels by profile
    And Get all events for channel for streams

Scenario: Create all sessions based Event
    Given Get all event templates for channel
    And Check new event name
    And Get all available tracks
    And Create new all sessions based event
    And Get new event by event uuid
    And Check url for the new event

Scenario: Upload existing video to on demand Session
    And Get session details by id
    And Add video to a session
    And Start action
    And Milestone action
    And End action
    And Publish event
    And Get event publish status by event uuid   
