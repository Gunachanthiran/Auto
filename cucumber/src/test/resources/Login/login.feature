Feature: Testing OrangeHRM #Goal
Scenario: Testing Login Functionality
Given I should be login page of OrangeHRM
And Enter Username
And Enter Passwod
When Click on Login button
Then I Should see the Title as "OrangeHRM"