@HomePage
Feature: Home Page Validation

  Background: Admin gives the correct LMS portal URL
   Given Admin is on login Page 
   When Admin enter valid data in all field and clicks login button
   
@validHomePage
   Scenario: Verify LMS title
   Then Admin should see LMS - Learning Management System as title 
   
   Scenario: Verify LMS title alignment
   Then LMS title should be on the top left corner of page
   
   Scenario: Validate navigation bar text
   Then Admin should see correct spelling in navigation bar text
   
   Scenario: Validate LMS title has correct spelling and space
   Then Admin should see correct spelling and space in LMS title
   
   Scenario: Validate alignment for navigation bar
   Then Admin should see the navigation bar text on the top right side
   
   Scenario: Validate navigation bar order 1st home
   Then Admin should see home in the 1st place
   
   Scenario: Validate navigation bar order 2nd Program
   Then Admin should see program in the 2nd place
   
   Scenario: Validate navigation bar order 3rd  batch
   Then Admin should see batch in the 3rd place
   
   Scenario: Validate navigation bar order 4th  class
   Then Admin should see class in the 4th place
   
   Scenario: validate navigation bar order 5th logout
   Then Admin should see logout in the 5th place
   
   Scenario: verify pie-chart presence
   Then Admin should see pie chart
   
   Scenario: Verify user details
   Then Admin should see welcome message with user name and role
   
   Scenario: Verify bar chart
   Then Admin should see bar chart for Active and inactive user
    
   Scenario: Verify user count
   Then Admin should see user count
   
   Scenario: Verify staff count
   Then Admin should see staff count  
   
   Scenario: verify program count
   Then Admin should see Program count 
   
   Scenario: Verify batch count 
   Then Admin should see batch count
   
   Scenario: Verify staff table pagination
   Then Admin should see staff table with pagination icons

   Scenario: Verify staff data page split
   Then Admin should see 5 staff data in a page
   
   Scenario: verify previous page icon disable
   Then Admin should see previous page icon disabled
   
   Scenario: verify first page icon disabled
   Then Admin should see first page icon disabled
   
   
   
   
   
   
   
   
   
   
   
   
   
   