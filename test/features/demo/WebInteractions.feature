Feature: Demo Web Interactions Feature

    @webInteract
    Scenario Outline: web interactions
        Given A web page is opened
            | Username  | Password  |
            | Rick      | Rick123   |
            | Nick      | Nick123   |
        When Perform web interactions

        Examples:  
        | TestID        | 
        | DEMO_TC002    |  