Feature: Demo Feature

@api
Scenario: Test Api
    Given Get user details by page number: 2
    And Add new user
    | Email                 | Password      |
    | eve.holt@reqres.in    | pistol        |