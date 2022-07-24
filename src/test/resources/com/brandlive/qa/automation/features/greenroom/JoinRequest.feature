@gr.events_3_join_request.released
Feature: Test the Broadcast in the Green room using Events 3.x

  Scenario: Precondition scenario for Join Request
    Given Logged in to Events "3.0"
    Given Logged in to Greenroom using Events "3.0"
    And Create a new Event
    And Check all E3 channels
    And Check all GR channels
    And Get all GR Events
    And Create or Update Meeting Room
    And Get Meeting Room Details
    And Get Media Details for Meeting Room

  Scenario: Test all the calls regarding Join Request
    And Check if meeting is live
    And Request join meeting
    And List Pending Join Request
    And Check Join Request
    And Update Approve Join request
    And Reject Join Request
    And Check if Approval Required for joining
    And Check Watcher only
