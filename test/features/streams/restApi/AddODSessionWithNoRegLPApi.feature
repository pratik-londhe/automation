Feature: Streams with On Demand session without registration, Landing Page and Home Page

@streams_on_demand_session_No_Reg_LP
Scenario: Test Streams Home Api
    Given Login to streams
    And Get streams channels by profile
    And Get all events for channel for streams

@streams_on_demand_session_No_Reg_LP
Scenario: Create On Demand session based Event without Reg, LP and Home page.
    Given Get all event templates for channel
    And Check new event name
    And Get all available tracks
    And Add Event with "On Demand" session and No registration and No LP
    And Get new event by event uuid
    And Check url for the new event
    And Get event publish status by event uuid
    And Publish event
    And Get event publish status by event uuid 

@streams_streaming_Type_Change_GR_To_RTMP
Scenario: Test Streams Home Api
    Given Login to streams
    And Get streams channels by profile
    And Get all events for channel for streams

@streams_streaming_Type_Change_GR_To_RTMP
 Scenario: Create Broadcast session based Event
     Given Get all event templates for channel
     And Check new event name
     And Get all available tracks
     And Create new "Broadcast" session based event
     And Get new event by event uuid
     And Check url for the new event
     And Get event publish status by event uuid
     And Publish event
     And Get event publish status by event uuid  

@streams_streaming_Type_Change_GR_To_RTMP
 Scenario: Change streaming type of broadcast session from Greenroom to RTMP
     And Get products details by channel id
     And Get secondary video details by session id
     And Get speaker details by channel id for session
     And Get recorded video details by channel id for session
     And Get video details by channel id for session
     And Get session details by session id
     And Update the session with new streaming type