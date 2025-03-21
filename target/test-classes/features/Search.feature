
Feature: Search fuctionality

Background:
Given User opens the application

@search @validproduct @smoke @regression
Scenario: Search for a valid product
When User enters valid product "HP" into Search field
And User clicks on search button
Then Valid product should display in search results

@search @non-existingproduct @regression
Scenario: Search for non-existing product
When User enters non-existing product "Honda" into Search field
And User clicks on search button
Then Proper message informing the user about no product matching should be displayed

@search @noproduct @regression
Scenario: Search without providing any product
When User dont enter any product into Search field
And User clicks on search button
Then Proper message informing the user about no product matching should be displayed
