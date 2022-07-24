@gr.events3_GR_SmokeTest_SGR.released

Feature: Smoke Test scenario for SGR
  Scenario:Basic smoke test for SGR
	  Given Logged in to greenroom SGR successfully
	  And Check correct channel selected in Greenroom
	  And Create an event in SGR with broadcast session
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
	  And go to Streaming tab of the show
	  And add streaming destination with following details with rtmp address as "rtmp://1.24041363.fme.ustream.tv/ustreamVideo/24041363" and stream key as "zD7u9rT6fxmVVxk5vkZAMCgscQ23JAE7"
	      | destinationType | streamTitle |
	      | Other           | StreamAPI   |
	  And Invite presenter "brandlive.automation1@gmail.com" to the show
	  And Exit builder mode to enter live mode
	  And Go live with the GR show
      And stream the show on Stream Viewer with channel code "1410-96MO"
	  And Exit Stream Viewer
	  And Exit Greenroom from Live mode to return shows
	  And Logged out of Greenroom
	  And Login to greenroom as presenter with following credentials
		  | emailId | password |
		  | brandlive.automation1@gmail.com | Brandlive123! |
	  And Join the show as presenter
	  And Navigate to event card details as presenter
	  And Check the show is streaming for presenter
	  And Logged out as presenter from greenroom