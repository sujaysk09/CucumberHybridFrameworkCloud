@smok
Feature: Register functionality

Background:
Given User navigates to Register account page

  Scenario: Register with mandatory fields
    When User enters below details into fields
    |firstname|sujay|
    |lastname|kekare|
    |telephone|1234|
    |password|1234|
    And Selects Privacy Policy field
    And Clicks on Continue button
    Then Account should be successfully created

  Scenario: Register with all fields
   When User enters below details into fields
    |firstname|sujay|
    |lastname|kekare|
    |telephone|1234|
    |password|1234|
    And Selects Yes for Newsletter
    And Selects Privacy Policy field
    And Clicks on Continue button
    Then Account should be successfully created

  Scenario: Register without providing any fields
    When User dont enter details into any fields
    And Clicks on Continue button
    Then Warning messages should be displyaed in the mandatory fields

  Scenario: Register with duplicate email address field
    When User enters below details into fields with duplicate email
    |firstname|sujay|
    |lastname|kekare|
    |email|sujaykekare123@gmail.com|
    |telephone|1234|
    |password|1234|
    And Selects Privacy Policy field
    And Clicks on Continue button
    Then User should get proper warning messsage about duplicate email address
