@DeleteBatchValidation
Feature: Delete Batch validation

  Background: 
    Given Admin is on the Batch Page for Delete

  @ts_dbc01
  Scenario: validate delete Icon on any row
    When Admin clicks the delete Icon on any row
    Then Admin should see the confirm alert box with yes and no button

  @ts_dbc02
  Scenario: Validate yes button on the confirm alert box
    When Admin clicks on the delete icon and click yes buttton
    Then Admin should see the successfull message and the batch should be deleted

  @ts_dbc03
  Scenario: validate no button on the confirm alert box
    When Admin clicks on the delete icon and click no buttton
    Then Admin should see the alert box closed and the batch is not deleted

  @ts_dbc04
  Scenario: validate close Icon on the alert box
    When Admin clicks on the close icon
    Then Admin should see the alert box closed
