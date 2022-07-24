@streams_people_api
Feature: Streams People API Feature

Scenario: Test Streams Home Api
    Given Login to streams
    And Get streams channels by profile
    And Get all events for channel for streams

Scenario: Add a member to a paid list
    Given A channel paid list exists
    When A new member is added to paid list
    Then A new memeber is found in paid list
    
Scenario: Add multiple members to a paid list   
    Given A channel paid list exists
    When A csv file of new members is added to paid list
    Then Each new member is found in paid list

Scenario: Create a new passcode lists
    When A new passcode list with no members is created
    And A new passcode list of type email and passcode is created
    And A new passcode list of type email only is created
    And A new passcode list of type passcode only is created 
    #And A new passcode list will only be created with matching type of file
    And A new passcode list is verified
    
Scenario: Update passcode lists
    When Multiple members are added to passcode list
    And A new member is added to a passcode list
    And A member is removed from a passcode list
    And A passcode list max uses is updated
    And A passcode list master passcode is updated
    #And Multiple members cannot be added to a passcode list if the file is of a different type

Scenario: Delete passcode Lists
    Then Passcode lists are deleted

Scenario: Add passcode list to existing event
    Given An event with sessions exists
    When A new passcode list of type email and passcode is created
    And An event is updated with the passcode list
    Then The passcode list will be verifed as added to event
  



