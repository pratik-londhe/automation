@gr.events_3_broadcast.released

Feature: Test the Broadcast in the Green room using Events 3.x

  Scenario: Precondition scenario for Broadcast 
    Given Logged in to Events "3.0"
    Given Logged in to Greenroom using Events "3.0"
    And Create a new Event
    And Check all E3 channels
    And Check all GR channels
    And Get all GR Events
    And Create or Update Meeting Room
    And Get Meeting Room Details
    And Get Media Details for Meeting Room
  
  
  Scenario: Test all the calls regarding Broadcast server
    And Create manual Broadcast server
    And Get Broacast server
    And Get Events Legacy RTMP Broadcast address
    And Update RTMP End point 
    And Update RTMP Custom End point 
    And Start Broadcast server 
    And Autostart Broadcast server
    And Set Stream State
    And Check Stream State
    And Get Broadcast server error logs
    And Write Broadcast server error logs   
    And Reset Broadcast server State 
    
    