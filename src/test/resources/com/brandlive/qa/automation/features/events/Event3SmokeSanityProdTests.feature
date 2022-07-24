@gr.events3_Smoke_Sanity_Prod.released

Feature: Event3.0 Smoke Sanity Scenarios

  Scenario: Event 3.0 smoke scenario 3
    Given Logged in to Events "3.0" successfully
    And Check correct channel selected in events "3.0"
    And Add O2 Event with Broadcast session or OD session with English Language and No registration and No LP
    And Make sure this Open Event has no Home Page
    And Publish and go live. Make sure the Session page is opened live
    And Add message to chat window. Make sure popup window for attendee to add details before sending message displayed
    And Add second session of different type. Make sure the LP and Home page is enabled.
    And Add custom pages to the event.
    And Publish and go live. Make sure the Landing page is opened live with Join Event button
    And Navigate to Home page and Later navigate to session pages.


  Scenario: Event3.0 smoke scenario 4
    And Add O2 Event with Broadcast session or OD session with English Language and LP but No registration
    And Make sure this Open Event has Home Page
    And Publish and go live. Make sure the Landing page is opened live with Join Event button
    And Navigate to Home page and Later navigate to session pages.
    And Enable Registration without email confirmation. Email field removed and FName, LName field kept required on General info
    And Publish and go live. Make sure the Landing page is opened live with Registration button
    And Register without email and navigate to Home page and later session page
      | FirstName | LastName |
      | Pratik    | Londhe   |

  Scenario: Event3.0 smoke scenario 6
    And Add Apollo Event with Broadcast session or OD session with registration and No LP
      | TemplateName |
      | Apollo       |
    And Publish and go live.
    And Make sure Registration page General info is opened
      | GeneralInfoPageHeader   |
      | Register for the event! |
    And Complete the registration flow successfully
      | FirstName | LastName | Email                       |
      | Pratik    | Londhe   | pratik.londhe@forgeahead.io |
    And Add announcements using Moderator window
      | AnnouncementTO | AnnouncementMessage                           |
      | To whole event | Hello Attendees, Enjoy the brandLive session! |
    And make sure announcements appear on live experience side
    And Make sure the Session page is opened live
    And Duplicate this event
    And Delete the original event
    And Make sure the live URL of original event is not accessible as the event is deleted
      | BrandliveURL  |
      | brandlive.com |

  Scenario: Event3.0 smoke scenario 7
    And Add O2 Event with Fireside or Breakout room sessions with LP
      | TemplateName |
      | O2           |
    And Add 2 custom pages and enable page gating on each page.
      | MediaType | MediaName        | ProductName | PListName | PasscodeType            |
      | documents | PasscodeList.csv | Events      | PLName    | Both email and passcode |
    And Publish and Go live
    And Add each page gating passcode during registration.
      | FirstName | LastName | Email                       | Passcode |
      | Pratik    | Londhe   | pratik.londhe@forgeahead.io | 123456   |
    And Verify page gating is functioning correctly
    And Go back to admin and uncheck page gating toggle and all custom pages can be seen.