@greenroom_home_ui
Feature: Greenroom Home UI Feature

Scenario: Test Greenroom Home Page UI
    Given Login to greenroom app: streams as producer
    And Select the channel for automation
    And Check header info at the home page
    And Search "automation" team member at team menu
    And Search "session" show at shows menu
    And Sign out the greenroom

Scenario: Test the Profile Options
    Given Login to greenroom app: streams as producer
    And Select the channel for automation
    And Check profile: "edit profile" option
    And Check profile: "video settings" option
    And Check profile: "all notes" option
    And Check profile: "sign out" option
    And Sign out the greenroom