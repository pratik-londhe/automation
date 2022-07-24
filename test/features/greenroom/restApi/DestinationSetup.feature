@destination_setup_gr_api

Feature: Destination Setup Streaming Feature

Scenario: Create Standalone Event 
	Given Check producer app access
	And Login to greenroom with greenroom
	And Get all standalone GR channels
	And Get all standalone GR events
	And Create new standalone GR Event 

Scenario: Check Home Page navigation api
	And Get Standalone meetings by channel Id
	And Get Standalone meetings by event id

Scenario: Check navigation from home page to live mode api
	And Get active rooms
	And Get details using meeting id
	And Send inviations to presenter using meeting id
	And Get inviations using room id
	And Create log for a meeting message type producer_connected
	And Get broadcast check by meeting id
	And Get active rooms
	And Create log for a meeting message type load_meeting
	And Get Request State Sync
	And Post Load Shots
	And Get rooms media details
	And Get Graphics Details
	And Get Show Sessions
	And Get media all meeting background
	And Get presenter messages 
	And Create log for a meeting message type socket_connected
	And Get Join Request by meeting id
	And Post Tokbox token
	And Get Green Room Notification
	And Write State for SET_PRESENTED_MEDIA in Live mode
	And Get Direct Chat Messages
	And Get Room Chat Messages

Scenario: Check navigation from live mode to Builder mode
	Given Get active rooms
	And Write State for SET_PRESENTED_MEDIA in Live mode
	And Write State for SET_CURRENT_SHOT_ID in Live mode
	And Post settings in builder mode

# FYI: The RtmpAddress and StreamKey used for this test was just pulled from an existing Stream GR. 

Scenario: Enter the destination details
    Given Get active rooms
    And Settings call for adding streaming destination
    | Name                 | RtmpAddress      | StreamKey   |
    | Streams    | rtmps://a3f18f6a93ea.global-contribute.live-video.net:443/app        | sk_us-west-2_bBIsF7AMaopY_dXWpi8q773JX2THB2YGVbg5WcddPU0     | 
    And Update broadcast details to meeting room
     | Name                 | RtmpAddress      | StreamKey   |
    | Streams    | rtmps://a3f18f6a93ea.global-contribute.live-video.net:443/app        | sk_us-west-2_bBIsF7AMaopY_dXWpi8q773JX2THB2YGVbg5WcddPU0     | 

Scenario: Enable the same destination
    Given Get active rooms
    And Settings call for enabling streaming destination
    | Name                 | RtmpAddress      | StreamKey   |
    | Streams    | rtmps://a3f18f6a93ea.global-contribute.live-video.net:443/app        | sk_us-west-2_bBIsF7AMaopY_dXWpi8q773JX2THB2YGVbg5WcddPU0     | 
    And Update broadcast details to meeting room
    | Name                 | RtmpAddress      | StreamKey   |
    | Streams    | rtmps://a3f18f6a93ea.global-contribute.live-video.net:443/app        | sk_us-west-2_bBIsF7AMaopY_dXWpi8q773JX2THB2YGVbg5WcddPU0     | 