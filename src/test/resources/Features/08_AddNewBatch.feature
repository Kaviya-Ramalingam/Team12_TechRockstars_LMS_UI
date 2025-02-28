@AddNewBatch
Feature: Add New Batch

  Background: 
    Given Admin is on the Batch Page

  @ts_anb1
  Scenario: Verify sub menu displayed in batch menu bar
    When Admin clicks "Batch" on navigation bar
    Then Admin should see sub menu in menu bar as "Add New Batch"

  @ts_anb2
  Scenario: Validate Admin able to click on the Add new Batch Option
    When Admin clicks on Add New batch under the "batch" menu bar
    Then Admin should see the Batch Details pop up window
