@BatchNavigation
Feature: Batch Page Navigation

  Background: Admin successfully Logged on to LMS Portal
    Given Admin is on the Home Page

  @ts_bn1
  Scenario: Verify Admin Navigate to Batch page successfully
    When Admin Clicks on the Batch menu from header
    Then Admin should be in the Manage Batch Page
