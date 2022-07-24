@streams_home_api
Feature: Streams Home API Feature

Scenario: Test Streams Home Api
    Given Login to streams
    And Get streams channels by profile
    And Get all events for channel for streams

# Scenario: Create On Demand session based Event
#     Given Get all event templates for channel
#     And Check new event name
#     And Get all available tracks
#     And Create new "On Demand" session based event
#     And Get new event by event uuid
#     And Check url for the new event
#     And Get event publish status by event uuid
#     And Publish event
#     And Get event publish status by event uuid 

# Scenario: Create Fireside session based Event
#     Given Get all event templates for channel
#     And Check new event name
#     And Get all available tracks
#     And Create new "Fireside" session based event
#     And Get new event by event uuid
#     And Check url for the new event
#     And Get event publish status by event uuid
#     And Publish event
#     And Get event publish status by event uuid 

# Scenario: Create Breakout Room session based Event
#     Given Get all event templates for channel
#     And Check new event name
#     And Get all available tracks
#     And Create new "Breakout Room" session based event
#     And Get new event by event uuid
#     And Check url for the new event
#     And Get event publish status by event uuid
#     And Publish event
#     And Get event publish status by event uuid   

# Scenario: Create Broadcast session based Event
#     Given Get all event templates for channel
#     And Check new event name
#     And Get all available tracks
#     And Create new "Broadcast" session based event
#     And Get new event by event uuid
#     And Check url for the new event
#     And Get event publish status by event uuid
#     And Publish event
#     And Get event publish status by event uuid  

Scenario: Create all sessions based Event
    Given Get all event templates for channel
    And Check new event name
    And Get all available tracks
    And Create new all sessions based event
    And Get new event by event uuid
    And Check url for the new event
    And Get event publish status by event uuid
    And Publish event
    And Get event publish status by event uuid          