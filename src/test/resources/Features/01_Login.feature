@login 
Feature: Login Page Validation

  Background: Admin gives correct lms portal url
   Given The browser is open 

@validLogin
   Scenario: Validate login with valid credentials

   When Admin gives the correct lms portal url
   Then Admin should land on the login page 

