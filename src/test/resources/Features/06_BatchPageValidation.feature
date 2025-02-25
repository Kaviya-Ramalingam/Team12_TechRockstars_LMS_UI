@BatchPageValidation
Feature: Batch Page Validation

  Background: Admin is on the Home Page after Login
    Given Admin is on the Home Page

  @ts_bpv1
  Scenario: Validate "Title" in Batch Page
    When Admin Clicks on the Batch menu from header
    Then Admin should see the "LMS-Learning Management System" Title

  @ts_bpv2
  Scenario: Validate "heading" in the Batch Page
    When Admin Clicks on the Batch menu from header
    Then Admin should see the "Manage Batch" Heading

  @ts_bpv3
  Scenario: Validate disabled "Delete Icon" under the header in the Batch Page
    When Admin Clicks on the Batch menu from header
    Then Admin should see the disabled "Delete Icon" under the header

  @ts_bpv4
  Scenario: Validate pagination in the Batch Page
    When Admin Clicks on the Batch menu from header
    Then Admin should see the enabled pagination controls under the data table

  @ts_bpv5
  Scenario: Validate edit icon in each data rows
    When Admin Clicks on the Batch menu from header
    Then Admin should see the edit icon in each row

  @ts_bpv6
  Scenario: validate delete icon in each data rows
    When Admin Clicks on the Batch menu from header
    Then Admin should see the delete icon in each row

  @ts_bpv7
  Scenario: validate checkbox in each data rows
    When Admin Clicks on the Batch menu from header
    Then Admin should see the checkbox in each row

  @ts_bpv8
  Scenario: Validate Datatable headers
    When Admin Clicks on the Batch menu from header
    Then Admin should see the datatable headers Batch name, Batch Description,Batch Status, No Of classes, Program Name, Edit/Delete

  @ts_bpv9
  Scenario: Validate "Checkbox" in the Datatable header row
    When Admin Clicks on the Batch menu from header
    Then Admin should see the checkbox  in the datatable header row

  @ts_bpv10
  Scenario: Validate "sort icon" next to all the datatable header
    When Admin Clicks on the Batch menu from header
    Then Admin should see the sort icon next to all Datatable headers
