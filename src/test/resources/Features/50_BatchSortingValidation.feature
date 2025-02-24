Feature: Batch Sorting

  Background: 
   Given Admin is on the Batch Page 
    
  Scenario: verify sorting of program name in ascending order
    When Admin clicks on Arrow next to program Name
    Then Admin should see the Program Name is sorted in Ascending order

  Scenario: Validate sorting of program name in Descending order
    When Admin clicks on Arrow next to program Name
    Then Admin should see the Program Name is sorted in Descending order
    
  
  Scenario: Validate sorting of batch description in ascending order
    When Admin clicks on Arrow next to batch description
    Then Admin should see the batch description is sorted in ascending order
    
  Scenario: Validate sorting of batch description in Descending order
    When Admin clicks on Arrow next to batch description
    Then Admin should see the batch description is sorted in Descending order
  
  
  Scenario: verify sorting of batch status in ascending order
    When Admin clicks on Arrow next to batch status
    Then Admin should see the batch status is sorted in Ascending order
    
  Scenario: verify sorting of batch status in descending order
    When Admin clicks on Arrow next to batch status
    Then Admin should see the batch status is sorted in descending order 

  
  Scenario: verify sorting of No. Of Classes in ascending order
    When Admin clicks on Arrow next to No. Of Classes
    Then Admin should see the No. Of Classes is sorted in Ascending order
    
  Scenario: verify sorting of No. Of Classes in descending order
    When Admin clicks on Arrow next to No. Of Classes
    Then Admin should see the No. Of Classes is sorted in descending order 
  