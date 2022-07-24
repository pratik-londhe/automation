@streams_home_ui
Feature: Streams Home UI Feature

Scenario: Test Streams Home Page UI
    Given Login to streams using UI
    And Select the streams channel for automation
    And Check the events info at the home page

Scenario: Test Streams All Shows Display
    And Navigate to analytics page
    And Navigate to people page
    And Navigate to content page
    And Navigate to products page
    And Navigate to profile page
    And Navigate to integrations page
    And Navigate to settings page
    And Navigate to events page
    And Logout of streams