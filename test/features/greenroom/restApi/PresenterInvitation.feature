@presenterInvitation_gr_api

Feature: GR Presenter Invitation

  Scenario: Log in and create standalone Greenroom
    Given Login to greenroom with greenroom
    And Get all standalone GR channels
    And Create new standalone GR Event
    And Post Load Shots

  Scenario: Invite Presenter to A Room on the detail page
    And Create an invitation for brandlive.loadautomation1@gmail.com
    And Create a notification for brandlive.loadautomation1@gmail.com
    And Create an iOS notification for brandlive.loadautomation1@gmail.com

  Scenario: Revoke Invitation for Presenter to A Room on the detail page
    And Revoke an invitation for brandlive.loadautomation1@gmail.com
    And Get presenter invitations for brandlive.loadautomation1@gmail.com
    And Get notifications for user

  Scenario: Invite Presenter to A Room in the Greenroom
    And Create an invitation for brandlive.loadautomation1@gmail.com
    And Create a notification for brandlive.loadautomation1@gmail.com
    And Create an iOS notification for brandlive.loadautomation1@gmail.com

  Scenario: Revoke Invitation for Presenter to A Room in the Greenroom
    And Revoke an invitation for brandlive.loadautomation1@gmail.com
    And Get presenter invitations for brandlive.loadautomation1@gmail.com
    And Get notifications for user
    And Post Bulk Edit Shots
    And Post Load Shots
    And Write State for SET_PRESENTED_MEDIA in Live mode
    And Request State for current meeting
