@gr.events3_GR_SmokeTest_Upload.released

Feature: Smoke Test scenario with media uploads for Greenroom

  Scenario:Test for Greenroom media uploads
	 Given Logged in to Events "3.0" successfully
	 And Check correct channel selected in events "3.0"
	 And Create open event "3.0" with broadcast session
	 And Publish event "3.0"
	 And Logged in to Greenroom after Events successfully
	 And Check correct channel selected in Greenroom
	 And Navigate to event card details
	 And Enter Greenroom in Live mode
	 And Enter Greenroom in builder mode
	 And Add one shot with 2 feeds
	 And Upload two files: picture and video
	  | mediaType | mediaName |
	  | image     | image1.jpg |
	  | video     | video1.mp4 |
	  And select shot from showboard in builder mode
      And Drag and drop two files on canvas
	  And Navigate to overlays tab
	  And drag and drop default overlay to the shot
	  And Add "After delay" animation to the overlay
	  And Preview the overlay animation
	  And Invite presenter "brandlive.automation1@gmail.com" to the show
	  And Exit builder mode to enter live mode
	  And Go live with the GR show
	  And Go live with the event "3.0"
	  And Check the Greenroom show is streaming live
	  And Play the next shot from the show
	  And Play the next shot from the show
	  And Check the Greenroom show is streaming
	  And Exit Greenroom from Live mode to return shows
	  And Logged out of Greenroom
      And Login to greenroom as presenter with following credentials
        | emailId | password |
        | brandlive.automation1@gmail.com | Brandlive123! |
      And Join the show as presenter
      And Navigate to event card details as presenter
      And Check the show is streaming for presenter
      And Logged out as presenter from greenroom
	  And Logged out of Events "3.0" after Greenroom