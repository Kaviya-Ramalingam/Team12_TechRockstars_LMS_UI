Feature: DELETE MULTIPLE program Validation

Background: Admin is logged in to LMS Portal
Given The browser is open 
When Admin gives the correct LMS portal URL

@d1
Scenario: Verify Admin is able to select multiple programs
Given Admin is on Program page
When Admin selects more than one program by clicking on the checkbox
Then Programs get selected

@d2
Scenario: Verify Admin is able to delete Multiple programs
Given Admin is on Program page
When Admin clicks on the delete button on the left top of the program page
Then Admin lands on Confirmation form

@d3
Scenario: Verify Admin is able to click 'Yes'
Given Admin is on Program Confirm Deletion Page after selecting a program to delete
When Admin clicks on yes button
Then Admin can see 'Successful Program Deleted' message


@d4
Scenario: Verify Admin is able to see deleted program
Given Admin is on Program page
When Admin Searches for "Deleted Program names"
Then There should be zero results.

@d5
Scenario: Verify Admin is able to close the window with "X" 
Given Admin is on Program Confirm Deletion Page after selecting a program to delete
When Admin Click on X button
Then Admin can see Confirmation form disappears