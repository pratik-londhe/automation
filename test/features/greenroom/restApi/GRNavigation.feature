@navigation_gr_api

Feature: GR Navigation Feature

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

Scenario: Check navigation from home page to event details page
	And Get active rooms
	And Get details using meeting id
	And Send inviations to presenter using meeting id
	And Get inviations using room id
	And Post Load Shots
	And Get Show Sessions
	And Get broadcast check by meeting id
	And Get Graphics Details
	And Get rooms media details
	And Create log for a meeting message type socket_connected
	And Get active rooms

Scenario: Check navigation from event details page to home page
	Given Get active rooms
	And Get Standalone meetings by channel Id
	And Get Green Room Notification
	And Get all session types
	And Get active rooms

Scenario: Check navigation from live mode to home page
	Given Get active rooms
	And Create log for a meeting message type producer_connected
	And Create log for a meeting message type connected_users
	And Create feature flags information
	And Get greenroom profiles
	And Get all standalone GR events
	And Get Green Room Notification
	And Get all session types
	And Post load teams
	And Create log for a meeting message type socket_connected
	
Scenario: Check navigation from live mode to Builder mode
	Given Get active rooms
	And Write State for SET_PRESENTED_MEDIA in Live mode
	And Write State for SET_CURRENT_SHOT_ID in Live mode
	And Post settings in builder mode

Scenario: Check navigation from Builder mode to live mode
	Given Post settings in live mode
	And Write State for SET_PRESENTED_MEDIA in Live mode
	And Write State for SET_CURRENT_SHOT_ID in Live mode
	And Create log for a meeting message type producer_connected
	And Get active rooms