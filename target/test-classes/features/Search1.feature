Feature: Search functionality


Scenario: User searchs a valid product
Given User opens the application
When User enters a valid product "hp" in to the search field
And User clicks on the search button
Then User should get valid product to be displayed on the search results

Scenario: User searchs an invalid product
Given User opens the application
When User enters a invalid product "honda" into the search field
And User clicks on the search button
Then User should get a message about no product matching 

Scenario: User searchs without any product
Given User opens the application
When User enters nothing in to the search field
And User clicks on the search button
Then User should get a message about no product matching 
