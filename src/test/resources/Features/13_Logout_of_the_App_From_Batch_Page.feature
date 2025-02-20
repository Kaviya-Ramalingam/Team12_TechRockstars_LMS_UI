Feature: LogOut of the application from the Batch Page

  Background: Admin is on the Batch Page

  Scenario: Validate logout option in the header is visible and enabled from the batch page
    Given Admin is on the Batch Page
    When Admin clicks on the logout button
    Then Admin should see the Login Screen Page
