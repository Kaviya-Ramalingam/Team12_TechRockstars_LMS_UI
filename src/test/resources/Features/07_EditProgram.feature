Feature: Edit program Validation

Background: Admin is logged in to LMS Portal
Given The browser is open 
When Admin gives the correct lms portal url
Then Admin should land on the login page

@tce01
  Scenario: Verify Edit option
    Given Admin is on Program page
    When Admin clicks on edit icon for particular program
    Then Admin lands on Program details form

@tce02
  Scenario: Verify title of the pop up window
    Given Admin is on Program page
    When Admin clicks on edit icon for particular program
    Then Admin should see window title as "Program Details"

@tce03
  Scenario: Verify mandatory fields with red asterisk mark 
    Given Admin is on Program page
    When Admin clicks on edit icon for particular program
    Then Admin should see red  asterisk mark  beside mandatory field "Name"

@tce04
  Scenario: Verify edit Program Name
    Given Admin is on Program page
    When Admin edits the program name "<dataKey>" and "<SheetName>" and click on save button 
    Then Updated program name is seen by the Admin
    
    Examples:
    |dataKey    |SheetName|
    |editProgram|programData|
    
    
@tce05
  Scenario: Verify edit Description
    Given Admin is on Program page
    When Admin edits the description text "<dataKey>" and "<SheetName>" and click on save button
    Then Admin can see the description is updated
        
    Examples:
    |dataKey    |SheetName|
    |editDescription|programData|
    
@tce06
  Scenario: Verify edit Status
    Given Admin is on Program page
    When Admin can change the status of the program and click on save button
    Then Status updated can be viewed by the Admin
    
@tce07
Scenario: Verify edited Program details
Given Admin is on Program page
When Admin searches with newly updated "Program Name"
Then Admin verifies that the details are correctly updated.
