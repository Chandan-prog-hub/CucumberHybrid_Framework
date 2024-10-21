Feature: Login Functionality

Scenario: Login with valid credentials
Given User navigates to login page
When User enters valid email "chandanjena003@gmail.com" into the email field
And User enters the valid password "Chandan123" into the password field
And User clicks on the login button
Then User should get successfully loggedin

Scenario: Login with invalid credentials.
Given User navigates to login page
When User enters  invalid email "chandan@gmail.com" into the email field
And User enters the invalid password "12121" into the password field
And User clicks on the login button
Then user should get a proper waring msg about credentials mismatch 

Scenario: Login with valid email and invalid password
Given User navigates to login page
When User enters valid email "chandanjena03@gamil.com" into the email field
And User enters the invalid password "bbbbb" into the password field
And User clicks on the login button
Then user should get a proper waring msg about credentials mismatch 

Scenario: Login with invalid email and valid password
Given User navigates to login page
When User enters  invalid email "chandan77@gmail.com" into the email field
And User enters the invalid password "34342" into the password field
And User clicks on the login button
Then user should get a proper waring msg about credentials mismatch 

Scenario: Login without providing any credentials
Given User navigates to login page
When User doesnot enter email adress in to the email adress field
And User doesnot enter password  in to the password field
And User clicks on the login button
Then user should get a proper waring msg about credentials mismatch 



