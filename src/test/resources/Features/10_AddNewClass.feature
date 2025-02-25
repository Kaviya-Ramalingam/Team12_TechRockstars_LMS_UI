@tag
Feature:Add New Class
Background:
 Given Admin is on the Manage Class page

  @tag1
  Scenario: Validate Class Details Popup window
	When Admin clicks a add new class under the class menu bar.
	Then Admin see Class Details popup window with SAVE and CANCEL button and Close(X) Icon on the top right corner of the window
	
  @tag2
  Scenario: Validate input fields and their text boxes in Class details form  
	When Admin clicks a add new class under the class menu bar.
	Then Admin should see few input fields and their respective text boxes in the class details window
