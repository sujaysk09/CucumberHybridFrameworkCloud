@all
Feature: Login Functionality

Background:
Given User navigates to login page

Scenario Outline: Login with valid credentials
When User enters valid email address <username>
And User enters valid password <password>
And User clicks on login button
Then User should login successfully

Examples:
|username					|password|
|sujay1@gmail.com |12345   |
|sujay2@gmail.com |12345   |
|sujay3@gmail.com |12345   |

Scenario: Login with invalid credentials
When User enters invalid email address
And User enters invalid password "12345"
And User clicks on login button
Then User should get proper warning messsage

Scenario: Login with valid email and invalid password
When User enters valid email address "sujaykekare111@gmail.com"
And User enters invalid password "6789"
And User clicks on login button
Then User should get proper warning messsage

Scenario: Login with invalid email and valid password
When User enters invalid email address
And User enters valid password "12345"
And User clicks on login button
Then User should get proper warning messsage

Scenario: Login with no credentials
When User do not enter email address
And User do not enter password
And User clicks on login button
Then User should get proper warning messsage
