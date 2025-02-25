Feature: Add new program

Background: Admin is logged in to LMS Portal
Given The browser is open 
When Admin gives the correct LMS portal URL
Then Admin should land on the login page

@tc01
Scenario: Verify add New Program
Given Admin is on Program page
When Admin clicks on "Add New Program" under the "Program" menu bar
Then Admin should see pop up window for program details

@tc02
Scenario: Verify title of the pop up window
Given Admin is on Program page
When Admin clicks on "Add New Program" under the "Program" menu bar
Then Admin should see window title as "Program Details"

@tc03
Scenario: Verify mandatory fields with red asterisk mark 
Given Admin is on Program page
When Admin clicks on "Add New Program" under the "Program" menu bar
Then Admin should see red  asterisk mark  beside mandatory field "Name"

@tc04
Scenario: Verify empty form submission
Given Admin is on Program details form
When Admin clicks save button without entering mandatory 
Then Admin gets error message 
|Program name is required.|
|Description is required.|
|Status is required.|

@tc05
Scenario: Verify cancel button
Given Admin is on Program details form
When Admin clicks Cancel button
Then Admin can see Program Details form disappears 

@tc06
Scenario Outline: Verify Admin is able to save the program details
Given Admin is on Program details form
When Admin enter details for mandatory fields and Click on save button "<dataKey>" and "<SheetName>".
Then Admin gets message "<ExpectedMessage>"

Examples:
| dataKey                |SheetName  |ExpectedMessage|
|invalidDetails          |programData|programName Must contain only letters and sometimes hyphens|
|validDetails            |programData|Program Created Successfully|
|deletedData|programData|cannot create program , since already exists|
@tc07
Scenario: verify cancel program details
Given Admin is on Program details form
When Admin Click on cancel button
Then Admin can see program details form disappear

@tc08
Scenario: verify added program is created
Given Admin is on Program page
When Admin searches with newly created program name 
Then Records of the newly created program name is displayed and match the data entered

@tc09
Scenario: Verify enter program name
Given Admin is on Program details form
When Admin enters the Name in the text box
Then Admin can see the text entered

@tc10
Scenario: Verify enter description
Given Admin is on Program details form
When Admin enters the Description in text box
Then Admin can see the text entered in description box

@tc11
Scenario: Verify select Status
Given Admin is on Program details form
When Admin selects the status of the program by clicking on the radio button "(Active/InActive)"
Then Admin can see 'Active/Inactive' status selected

@tc12
Scenario: Verify close window with "X" 
Given Admin is on Program details form
When Admin Click on "X" button
Then Admin can see program details form disappear
