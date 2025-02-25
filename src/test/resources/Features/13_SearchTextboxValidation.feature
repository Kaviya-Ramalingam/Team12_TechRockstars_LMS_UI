Feature: Search Text Box Validation

  Background: 
  Given Admin is on the Batch Page

  Scenario: validate serach box functionality
    When Admin enters the batch name in the search text box
    Then Admin should see the filtered batches in the data table
