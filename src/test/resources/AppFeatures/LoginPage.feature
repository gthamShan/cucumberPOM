Feature: Login page Feature

  Scenario: 
    Given user on loginpage
    When user gets the title of the page
    Then page title should be "Swag Labs"

  Scenario: 
    Given user on loginpage
    Then login credentials should be displayed

  Scenario: 
    Given user on loginpage
    When user enters username "standard_user" and password "secret_sauce"
    And user clicks on login button
    Then page title should be "Swag Labs"
