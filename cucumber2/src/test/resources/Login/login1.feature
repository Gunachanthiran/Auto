Feature: Testing OrangeHRM #Goal
1)Valid Case
2)Invalid Case
Scenario Outline: Testing Login Functionality with valid and invalid
@PossitiveTesting
Scenario: to test login functionality with valid data
Given I should be login page of OrangeHRM
And Enter Username "Admin"
And Enter Passwod "admin123"
When Click on Login button
Then I Should see the Title as "OrangeHRM"
Examples:
|Admin|admin123|
|Admin|ADmin1244|
@negativeTesting
Scenario: to test login functionality with invalid data
Given I should be login page of OrangeHRM
And Enter Username "Admin"
And Enter Passwod "admin12345"
When Click on Login button
Then I Should see the Title as "OrangeHRM"