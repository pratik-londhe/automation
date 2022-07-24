@gr.events3_metrics.released

Feature: Events3.0 Metrics Scenarios

  Scenario: Events 3.0 Metrics Channel Scenario
    Given Logged in to Events "3.0"
    And Check all E3 channels
    And Get Events by channel Id
    And Get Events metrics by channel Id
    And Get Device Types metrics by channel Id
    And Get Registrations metrics by channel Id
    And Get Browsers metrics by channel Id
    And Get Audience metrics by channel Id
    And Get Average Duration metrics by channel Id
    And Get Views metrics by channel Id
    And Get Watch Time metrics by channel Id
    And Get Regions metrics by channel Id
    And Get Retention Average metrics by channel Id
    And Get Retention Buckets metrics by channel Id
    
  Scenario: Events 3.0 Metrics Event Scenario
  #  Given Logged in to Events "3.0"
    And Get Sessions metrics by Event Uuid for Channel
    And Get Device Types metrics by Event Uuid for Channel
    And Get Registrations metrics by Event Uuid for Channel
    And Get Emails metrics by Event Uuid for Channel
    And Get Browsers metrics by Event Uuid for Channel
    And Get Average Duration metrics by Event Uuid for Channel
    And Get Views metrics by Event Uuid for Channel
    And Get Watch Time metrics by Event Uuid for Channel
    And Get Regions metrics by Event Uuid for Channel
    And Get Languages metrics by Event Uuid for Channel
    And Get Country Map metrics by Event Uuid for Channel
    And Get Rention Average metrics by Event Uuid for Channel
    And Get Retention Buckets metrics by Event Uuid for Channel
    And Get Export Summary metrics by Event Uuid for Channel
    And Get Export Products metrics by Event Uuid for Channel
    And Get Export Documents metrics by Event Uuid for Channel
    And Get Export Sponsors metrics by Event Uuid for Channel
    And Get Export Videos metrics by Event Uuid for Channel
    
 Scenario: Events 3.0 Metrics Session Scenario   
  # Given Logged in to Events "3.0"
   And Get Device Types metrics by Session Uuid for Channel
   And Get Registrations metrics by Session Uuid for Channel
   And Get Emails metrics by Session Uuid for Channel
   And Get Browsers metrics by Session Uuid for Channel
   And Get Average Duration metrics by Session Uuid for Channel
   And Get Views metrics by Session Uuid for Channel
   And Get Watch Time metrics by Session Uuid for Channel
   And Get Regions metrics by Session Uuid for Channel
   And Get Languages metrics by Session Uuid for Channel
   And Get Timeline metrics by Session Uuid for Channel
   And Get Country Map metrics by Session Uuid for Channel
   And Get Retention Average metrics by Session Uuid for Channel
   And Get Export Summary metrics by Session Uuid for Channel
   And Get Export Documents metrics by Session Uuid for Channel
   And Get Export Questions metrics by Session Uuid for Channel
   
   