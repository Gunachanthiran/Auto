Feature: Testing Guru99 demo site  #Goal
Scenario: to test login and register functionality 
Given I should be login page of Guru99 demo site
And Enter The Username "user"
And Enter  The Password "user"
When Click on The Submit button
Then I Should see the Title as "Login: Mercury Tours"
And Click on Register button
When I Should see the Page Title as "Register: Mercury Tours" 
And Enter First Name "Guna"
And Enter Last Name "k"
And Enter Phone "1234566789"
And Enter Gmail "guna@gmail.com"
And Enter Address "Ulundurpet"
And Enter City  "Ulundurpet"
And Enter State/Provience "Tamil Nadu" 
And Enter Postal Code "606107"
And Select Country  "India"
And Enter Username "Guna"
And Enter Password "guna"
And Enter Confirm Password "guna"
When Click on Submit button
Then I Should see Title as "Register: Mercury Tours"