@streams_reaction_api
Feature: Streams Home API Feature

Scenario: Test Streams Home Api
    Given Login to streams
    And Get streams channels by profile
    And Get all events for channel for streams

Scenario: Create Broadcast session based Event
    Given Get all event templates for channel
    And Check new event name
    And Get all available tracks
    And Create new "Broadcast" session based event
    And Get new event by event uuid
 #  And Check url for the new event
 #  And Get event publish status by event uuid
 #  And Publish event
 #  And Get event publish status by event uuid   

Scenario: Test Channel Level Api
    And Get channel reactions
    And Get session by id
    And Update reactions to the session