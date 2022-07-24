@greenroom_home_api
Feature: Greenroom Home API Feature

Scenario: Test Greenroom Home Api
    Given Check producer app access
    And Login to greenroom with events
    And Get greenroom channels by profile
    And Get show session types
    And Get all events for channel for greenroom