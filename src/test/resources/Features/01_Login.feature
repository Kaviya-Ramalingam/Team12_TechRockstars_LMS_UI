@login 
Feature: Login Page Validation

  Background: 
   Given The browser is open
  

@tag1
   Scenario: Verify Admin is able to land on login page
   When Admin gives the correct LMS portal URL
   Then Admin should land on the login page 
   
   @tag2
    Scenario: Verify Admin is able to land on home page with invalid URL
    When Admin gives the invalid LMS portal URL
    Then Admin should receive application error


    @tag3
    Scenario: Verify for broken link
    When  Admin gives the correct LMS portal URL
    Then HTTP response >= 400. Then the link is broken
    
    @tag4
    Scenario: Verify the text spelling in the page 
    When Admin gives the correct LMS portal URL
    Then Admin should see correct spellings in all fields 
    
    @tag5
    Scenario: Verify application name 
    When  Admin gives the correct LMS portal URL
    Then Admin should see  LMS - Learning Management System
    
    @tag6
    Scenario: Verify company name
    When Admin gives the correct LMS portal URL
    Then Admin should see company name below the app name
    
    @tag7
    Scenario: Validate sign in content
    When Admin gives the correct LMS portal URL
    Then Admin should see "Please login to LMS application"
    
    
    @tag8
    Scenario: Verify text field is present
    When Admin gives the correct LMS portal URL
    Then Admin should see two text field

 @tag9
    Scenario: Verify text on the first field 
    When Admin gives the correct LMS portal URL
    Then Admin should "User" in the first text field
    
    
    @tag10
    Scenario: Verify dropdown is present
    When  Admin gives the correct LMS portal URL
    Then Admin should see one dropdown
    
    
    @tag11
    Scenario: Verify asterisk next to USER text
    When Admin gives the correct LMS portal URL
    Then Admin should see asterisk mark symbol next to text for mandatory fields
    
    @tag12
    Scenario: Verify text on the second field
    When  Admin gives the correct LMS portal URL
    Then Admin should "Password" in the second text field
    
    
    @tag13
    Scenario: Verify asterisk mark symbol next to password text
    When  Admin gives the correct LMS portal URL
    Then Admin should see asterisk mark symbol next to password text
    
    @tag14
    Scenario: Verify placeholder in dropdown to select role
    When  Admin gives the correct LMS portal URL
    Then Admin should see "Select the role" placeholder in dropdown
    
    
     @tag15
    Scenario: Verify dropdown option to select role
    When  Admin gives the correct LMS portal URL 
    Then Admin should see "Admin , Staff, Student" options in dropdown
    
    
    @tag16
    Scenario: Verify the alignment input field for the login
    When  Admin gives the correct LMS portal URL 
    Then Admin should see input field on the centre of the page
    
    @tag17
    Scenario: verify Login button is present
    When  Admin gives the correct LMS portal URL
    Then Admin should see login button 
    
    @tag18
    Scenario: Verify input descriptive text in user field
    When  Admin gives the correct LMS portal URL
    Then Admin should see user in gray color
    
    
    @tag19
    Scenario: Verify input descriptive text in password field
    When  Admin gives the correct LMS portal URL
    Then Admin should see password in gray color
    
    @tag20
    Scenario: Validate login with valid data in all field 
    When  Admin enter valid data in all field and clicks login button
    Then Admin should land on home page 
    
    @tag21
    Scenario: Validate login with invalid data 
    When Admin enter invalid data and clicks login button
    Then Error message "Invalid username and password Please try again"
    
    
     @tag22
    Scenario: Validate login credentials with null user name 
    When Admin enter value only in password and clicks login button
    Then Error message" Please enter your user name"
    
    
     @tag23
    Scenario: Validate login credentials with null password 
    When Admin enter value only in user name and clicks login button
    Then Error message" Please enter your password "
    
    @tag24
    Scenario: verify login button action through keyboard 
    When Admin enter valid credentials  and clicks login button through keyboard
    Then Admin should land on home page
    
    @tag25
    Scenario: verify login button action through mouse 
    When Admin enter valid credentials  and clicks login button through mouse
    Then Admin should land on home page
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    