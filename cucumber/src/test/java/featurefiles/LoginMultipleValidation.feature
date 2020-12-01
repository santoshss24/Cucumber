Feature: Login

Scenario Outline: user should be able to login with correct credentials

Given user navigates to the login page 
And user enters <username> in username TextField 
And user enters <password> in password TextField  
When user clicks on login button
Then user should be able to navigated to homepage 

Examples:

|username|password|
|admin|manager|
|trainee|trainee|
