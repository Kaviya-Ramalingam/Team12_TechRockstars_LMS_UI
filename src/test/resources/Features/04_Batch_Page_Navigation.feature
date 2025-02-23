Feature: Batch Page Navigation

  Background: Admin successfully Logged on to LMS Portal

  Scenario: Verify Admin Navigate to Batch page successfully
    Given Admin is on Home Page
    When Admin Clicks on the Batch menu from the header
    Then Admin should be in the Manage Batch Page
