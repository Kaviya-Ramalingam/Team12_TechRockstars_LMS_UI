@NewBatchPopup
Feature: Add New Batch details pop up

  Background: 
    Given Admin is on the Add new batch pop up

  @ts_anbp1
  Scenario: Validate all the fields exist in pop up
    When Admin checks all the fields are enabled
    Then The pop up should include the fields Batch Name,Number of classes and Description as text box, Program Name as drop down Status as radio button

  @ts_anbp2
  Scenario: Validate batchname prefix selected program name
    When Admin selects program name present in the dropdown
    Then Admin should see selected program name in the batch name prefix box

  @ts_anbp3
  Scenario: Validate batch name suffix box should accept only numbers
    When Admin enters alphabets in batch name suffix box
    Then Admin should get error message below the text box of respective field

  @ts_anbp4
  Scenario: Validate batch name prefix box is not editable
    When Admin enters alphabets in batch name prefix box
    Then Admin should see empty text box

  @ts_anbp5
  Scenario: Validate input data only for mandatory fields
    When Admin enters the data only to the mandatory fiields and clicks save button
    Then Admin should get a successful message

  @ts_anbp6
  Scenario: validate input data missing for mandatory fields
    When Admin leaves blank one of the mandatory fields
    Then Admin should get a error message on the respective mandatory field

  @ts_anbp7
  Scenario: validate save button in Batch details pop up
    When Admin enters the valid data to all the mandatory fields and click save button
    Then Admin should get a succesesful message

  @ts_anbp8
  Scenario: validate cancel button in Batch details pop up
    When Admin enters the valid data to all the mandatory fields and click cancel button
    Then Admin can see the batch details popup closes without creating any batch

  @ts_anbp9
  Scenario: validate close icon on the batch details pop up
    When Admin clicks on close icon
    Then batch details pop up closes
