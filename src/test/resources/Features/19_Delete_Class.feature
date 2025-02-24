@DeleteClass @LMSUI 
Feature: Delete Class in Class Module
  Background: 
   Given Admin is on the  Manage Class Page
   
	Scenario: Validate row level delete icon	
	When Admin clicks the delete icon
	Then Admin should see a alert open with heading Confirm along with YES and NO button for deletion
	
	Scenario: Click No on deletion window
  Given Admin is on Confirm Deletion alert
	When Admin clicks No option
	Then Admin can see the deletion alert closed without deleting
	
	Scenario: Click Yes on deletion window
  Given Admin is on Confirm Deletion alert
	When Admin clicks yes option
	Then Admin gets a message Successful Class Deleted alert and do not see that Class in the data table
	
	Scenario: Validate Close(X) icon on Confirm Deletion alert
  Given Admin is on Confirm Deletion alert
	When Admin clicks on close button 
	Then Admin can see the deletion alert closed without deleting
	
	