@streams_registration_api
Feature: Streams Registration API Feature

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
    And Get event publish status by event uuid
    And Publish event
    And Get event publish status by event uuid   

Scenario: Update Registration Steps to Event
    And Update registration profile and avatar steps to event
    And Publish event
    And Get event publish status by event uuid 

Scenario: Complete registration live and navigate to sessions
    And Load the landing page using API
    And Fill general info form using API
    And Get generated page session using API
    And Validate registration user session using API
    And Fill profile info form using API
    And Fill avatar form using API
    And Validate registration using API
    And Validate registration user session using API
    And Navigate to On Demand session using API
    And Enter chat at On Demand session using API
    And Get chat at On Demand session using API
    And Enter question at On Demand session using API
    And Get questions at On Demand session using API
    And Enter answer at On Demand session using API
    And Get answers by question id at On Demand session using API
    And Navigate to Broadcast session using API
    And Enter chat at Broadcast session using API
    And Get chat at Broadcast session using API
    And Enter question at Broadcast session using API
    And Get questions at Broadcast session using API
    And Enter answer at Broadcast session using API
    And Get answers by question id at Broadcast session using API

Scenario: Navigate to Breakout Room session
    And Navigate to Breakout Room session using API
    And Get Breakout Room Ended using API
    And Get Breakout Room Usage using API
    And Get room opentok test for Breakout Room using API
    And Get opentok session by id for Breakout Room using API
    And Get to the breakout session by uuid using API
    And Get opentok token for Breakout Room by session id using API
    And Get opentok session by id for Breakout Room using API
    And Revalidate registration using API
    And Validate registration user session using API
    And Get Breakout Room Ended using API
    And Get Breakout Room Usage using API

Scenario: Navigate to Fireside session
    And Navigate to Fireside session using API
    And Get room opentok test for Fireside using API
    And Get opentok session by id for Fireside using API
    And Get opentok token for Fireside by session id using API
    And Post broadcast for the Fireside using API
    And Access fireside live event using API
    And Check broadcast for fireside using API
    And Get opentok session by id for Fireside using API 
    And Enter chat at Fireside session using API
    And Get chat at Fireside session using API
    And Start broadcast for the Fireside using API
    And Check broadcast for fireside using API
    And Stop broadcast for the fireside using API
    And Check start action for Fireside using API
    And Check milestone action for Fireside using API
    And Check end action for Fireside using API

