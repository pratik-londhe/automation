@uploadFile_gr_api

Feature: GR Upload File

Scenario: Log in and create standalone Greenroom
    Given Login to greenroom with greenroom
    And Get all standalone GR channels
    And Create new standalone GR Event

Scenario: Check Producer is able to upload MP4 file
    Then Upload a mp4 to GR Event
    Then Upload the mp4 to AWS
    Then Notify backend that upload has completed
    Then Create thumbnail for mp4
    Then Upload thumbnail to AWS
    Then Notify backend that upload has completed
    Then Tell the backend to create the mp4 media item
    Then Request the newly created media item

Scenario: Check Producer is able to upload JPG file
    And Upload a jpg to GR Event
    And Upload the jpg to AWS
    And Notify backend that upload has completed
    And Create thumbnail for jpg
    And Upload thumbnail to AWS
    And Notify backend that upload has completed
    And Tell the backend to create the jpg media item
    And Request the newly created media item

Scenario: Check Producer is able to upload PDF file
    And Create log for a meeting message type producer_connected
    And Create log for a meeting message type connected_users
    And Get active rooms
    Then Mock get CloudConvert job for the PDF
    Then Tell the backend to create the PDF
    Then Create log for a meeting message type producer_connected
    Then Create log for a meeting message type connected_users
    Then Get active rooms
    Then Get converted PDF ID
    Then Request the newly created media item