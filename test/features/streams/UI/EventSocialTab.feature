@streams_event_social_tab
Feature: Event3.0 social tab

Scenario: Verify the directory functionality
  Given Login to streams using UI
  And Select the streams channel for automation
  And Create event3.0 with broadcast session
  And Enable the Profile and Avatar for the event "3.0" registration
  And Enable the Directory toggle
  And Publish and Go live
  And Multiple attendees register for an event sequentially and the Directory tab is seen
    | FirstName | LastName | Email                       | Passcode | CompanyName | Bio        | FunFact  | MediaName   |
    | Pratik    | Londhe   | pratik.londhe@forgeahead.io | PASS123  | FA          | Tech Lead  | Fun Fact | avatar1.jpg |
    | Pradnyan  | Bhilare  | pradnyan@gmail.com          | PASS123  | Brandlive   | QA Manager | Fun fact | avatar2.jpg |   
  And Check multiple registered attendees list is displayed on the directory page
  And Enable Bookmark attendees toggle
  And Check bookmark icon is displayed on the attendees profile and functioning correctly
  And Enable the Avatar toggles
  And Avatar can be seen to the attendees on the directory page
  And Add multi-select or drop down registration questions
    | QuestionTitle | QuestionType   | NoOfOptions | ValueOne    | ValueTwo   | ValueThree        |
    | Job Title     | Dropdown List  | 3           | Teach Lead  | QA Manager | Product Engineer  |
  And Save filter for the registration questions
  And Enable the filter toggle
  And Check attendee registration with registration questions
    | FirstName | LastName | Email          | Passcode | CompanyName | Bio        | FunFact  | MediaName   |
    | Adam      | Denny    | adam@gmail.com | PASS123  | FA          | Tech Lead  | Fun Fact | avatar1.jpg |
  And Filter is seen on the live page and functioning correctly for the registered attendees

  
 Scenario: Verify the profile details functionality
  And Enable the Profile details About and Topics toggles
  And Check user profile pop up is opened with all the registered details
  And Check profile details with In a Pop-up option and functioning correctly
  And Check profile details with As a Page option and functioning correctly

Scenario: Verify the messaging functionality
  And Enable the Direct Messaging toggle
  And Create a new event channel
    | EventChannelName  | MediaName   |
    | Brandlive Channel | avatar2.jpg |
  And Enable the Topic Group Chats toggle
  And Check the Chat bubble and event channel is displayed on the live page
    | EventChannelName  | 
    | Brandlive Channel |
  And Verify attendee is able to send message in the event channel
    | ChatMessage     | 
    | Hello Brandlive |