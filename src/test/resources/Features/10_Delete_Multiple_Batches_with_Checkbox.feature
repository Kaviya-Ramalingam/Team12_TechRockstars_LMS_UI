Feature: Delete multiple batches with check box

  Background: Admin is on the Batch Page

  Scenario: Validate single row delete with checkbox
    Given Admin is on the Batch Page
    When Admin clicks on the delete icon under the Manage batch header for single row
    Then The respective row in the table should be deleted

  Scenario: Validate multiple row delete with checkbox
    Given Admin is on the Batch Page
    When Admin clicks on the delete icon under the Manage batch header for multiple row
    Then The respective row in the table should be deleted
