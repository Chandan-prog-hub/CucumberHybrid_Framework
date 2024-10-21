Feature: Registration functionality

Scenario: Register with only the mandatory fields
Given User navigates to the register page
When User enters the below details into the respective fields
|FirstName| |Chandan            |
|Lastname | |Jena               |
|Email    | |chandan120@gmail.com|
|Telephone| |8114955379         |
|password | |12345              |
And User checks the privace policy field
And user clicks on the continue button
Then user should land on the account success page 

Scenario: Register with all the fields
Given User navigates to the register page
When User enters the below details into the respective fields
|FirstName| |Chandan            |
|Lastname | |Jena               |
|Email    | |chandan12@gmail.com|
|Telephone| |8114955379         |
|password | |12345              |
And User opts yes for newsletter
And User checks the privace policy field
And user clicks on the continue button
Then user should land on the account success page 

Scenario: Register with duplicate values
Given User navigates to the register page
When User enters the below details into the respective fields
|FirstName| |Chandan            |
|Lastname | |Jena               |
|Email    | |chandan12@gmail.com|
|Telephone| |8114955379         |
|password | |12345              |
And User opts yes for newsletter
And User checks the privace policy field
And user clicks on the continue button
Then user should get a proper warning message about duplicate email



Scenario: register without filling any details
Given User navigates to the register page
When user does not enter any details to the fields
And user clicks on the continue button
Then User should get proper warning message for every field

