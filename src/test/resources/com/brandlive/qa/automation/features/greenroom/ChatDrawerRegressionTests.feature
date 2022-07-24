@gr.events3_GR_Basic_RegressionTest.released

Feature: Chat Drawer Regression tests for Greenroom
  Scenario: Start multiple chats with presenters, update them and delete them
    Given Logged in to Events "3.0" successfully
    And Check correct channel selected in events "3.0"
    And Create open event "3.0" with broadcast session
    And Publish event "3.0"
    And Logged in to Greenroom after Events successfully
    And Check correct channel selected in Greenroom
    And Navigate to event card details
    And Enter Greenroom in Live mode
    And Enter Greenroom in builder mode
    And Invite presenter "priyavertis@gmail.com" to the show
    And Navigate to Chat drawer
    And Send a message in presenter group
    And Send a message to one of the presenter
    And Exit Greenroom from Live mode to return shows
    And Logged out of Greenroom
    And Login to greenroom as presenter with following credentials
      | emailId | password |
      | priyavertis@gmail.com | Forgeahead01! |
    And Join the show as presenter
    And Navigate to event card details as presenter
    And Navigate to Chat drawer
    And Validate presenter is able to see unread chat toast notification
    And Validate Chat drawer has chat notification
    And Validate presenter chat shows chat notification
    And Validate presenter group chat from Presenter login
    And Validate chat notification disappear from Chat drawer
    And Logged out as presenter from greenroom
    And Logged out of Events "3.0" after Greenroom


