@gr.events3_GR_Basic_RegressionTest.released

Feature: Regression tests for  Greenroom

  Scenario: Test for creating,updating and deleting different types of sessions.

    Given Logged in to Events "3.0" successfully
    And Check correct channel selected in events "3.0"
    And Create open event "3.0" with broadcast session
    And Publish event "3.0"
    And Logged in to Greenroom after Events successfully
    And Check correct channel selected in Greenroom
    And Navigate to event card details
    And Add following types of sessions in the show
    |sessionType|
    |Rehearsal |
    |Tech Check |
    |Recording |
    |Broadcast |
    And update rehearsal session name
    And delete all the added sessions
    And Logged out of Greenroom