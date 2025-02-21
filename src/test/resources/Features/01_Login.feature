@login 
Feature: Login Page Validation

  Background: Admin gives correct lms portal url
   Given Admin gives the correct LMS portal URL

@tag1
   Scenario: Verify Admin is able to land on login page
   Given The browser is open
   When Admin gives the correct LMS portal URL
   Then Admin should land on the login page 
   
   @tag2
    Scenario: Verify Admin is able to land on home page with invalid URL
     Given The browser is open
    When Admin gives the invalid LMS portal URL
    Then Admin should receive application error


    @tag3
    Scenario: Verify for broken link
     Given The browser is open
   When  Admin gives the invalid LMS portal URL
    Then HTTP response >= 400. Then the link is broken
    
    @tag4
    Scenario: Verify the text spelling in the page
     Given The browser is open 
    When Admin gives the correct LMS portal URL
    Then Admin should see correct spellings in all fields 
    
    @tag5
    Scenario: Verify application name
    Given The browser is open 
    When  Admin gives the correct LMS portal URL
    Then Admin should see  LMS - Learning Management System
    
    @tag6
    Scenario: Verify company name
    Given The browser is open 
    When Admin gives the correct LMS portal URL
    Then Admin should see company name below the app name
    
    

