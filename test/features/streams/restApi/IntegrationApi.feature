@streams_integration_api
Feature: Streams integrations API Feature

Scenario: Test Streams Home Api
    Given Login to streams
    And Get streams channels by profile
    And Get all events for channel for streams

Scenario: Test Channel Level Integrations Api
    And Get channel integrations solution details
    And Create the channel level integration user
    And Get channel integrations solution instances details
    And Create integrations solution instances
    And Get integrations auth window details
    And Get the passcode details by channel Id
    And Get the passcode encrypt details by channel Id and passcode list
    And Update the solution instances
    And Toggle instance of any Integrations