@gr.events3_GR_Prod_SmokeTest_LegacyEvents.released

Feature: Smoke Test scenario for Legacy Events
  Scenario:Basic smoke test for Legacy Events
	  And Logged in to greenroom legacy events "2.5" successfully
	  And Check correct channel selected in Greenroom
	  And Check correct channel selected in Greenroom
	  And Navigate to event "My First Brandlive Event" card details
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
      And stream the show on Stream Viewer with channel code "1410-KMDH"
	  And Exit Stream Viewer
	  And Exit Greenroom from Live mode to return shows
	  And Logged out of Greenroom