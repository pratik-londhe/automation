@streams_event_content_manager
Feature: Event3.0 product Add, Edit and Delete functionality

Scenario: Add and Delete event3.0 contents.
    Given Login to streams using UI
    And Select the streams channel for automation
    And Add a Document
    | DocumentName             |
    | sample_document_file.pdf |
    And Delete a Document
    | DocumentName         |
    | sample_document_file |
    And Add a Image
    | ImageName   |
    | avatar1.jpg |
    And Delete a Image
    | ImageName |
    | avatar1   |
   # And Add a Video
   # | VideoName        |
   # | sample_video.mp4 |
   # And Delete a Video
   # | VideoName    |
   # | sample_video |
    And Add a Fonts
    | FontsName          |
    | ObelixProB-cyr.ttf |
    And Delete a Fonts
    | FontsName |
    | ObelixPro |
    And Add a palettes
    | PaletteName               |
    | Auromation Grey  Palettes |
    And Delete a palettes
    | PaletteName               |
    | Auromation Grey  Palettes |