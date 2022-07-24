@email_confirmation_required_to_event
Feature: Registration Email Confirmation Required to event 

Scenario: Test Streams Home Api
    Given Login to streams
    And Get streams channels by profile
    And Get all events for channel for streams

Scenario: Create On Demand session based Event
    Given Get all event templates for channel
    And Check new event name
    And Get all available tracks
    And Create new "On Demand" session based event
    And Get new event by event uuid
    And Check url for the new event
    And Get event publish status by event uuid
    And Publish event
    And Get event publish status by event uuid 

Scenario: Update the event for email confirmation required
    And Get channel passcode lists
    And Get registration questions for event
    # And Update event with email confirmation required
    # And Publish event
    # And Get event publish status by event uuid 
