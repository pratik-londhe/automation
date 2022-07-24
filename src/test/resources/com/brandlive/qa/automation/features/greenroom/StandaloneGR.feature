@gr.sgr.released

Feature: Test Standalone Greenroom Event Creation
	
	Scenario: Check Rest APIs of Standalone Greenroom Home
	Given Logged in to Greenroom in Standalone mode
	And Check all Standalone GR channels
	And Check all Standalone GR events
	And Create new Standalone GR Event 
	And Check newly created Standalone GR Event


	Scenario: Check Standalone Meeting APIs
		And Retrieve Meetings for standalone
		And Retrieve Meetings for standalone by Meeting Id
		And Retrieve Meetings for standalone by Channel Id