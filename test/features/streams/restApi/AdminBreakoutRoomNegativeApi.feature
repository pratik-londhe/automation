@streams_breakout_room_api
Feature: Streams Breakout room feature with Room null or with only 1 host or past date 

Scenario: Test Streams Home Api
    Given Login to streams
    And Get streams channels by profile
    And Get all events for channel for streams

Scenario: Create Breakout Room session based Event with empty room
    Given Get all event templates for channel
    And Check new event name
    And Get all available tracks
    And Create new "Breakout Room" session based event with room name null

Scenario: Create Breakout Room session based Event without room name
    Given Get all event templates for channel
    And Check new event name
    And Get all available tracks
    And Create new "Breakout Room" session based event without room name

Scenario: Create Breakout Room session based Event with past date
    Given Get all event templates for channel
    And Check new event name
    And Get all available tracks
    And Create new "Breakout Room" session based event with past date