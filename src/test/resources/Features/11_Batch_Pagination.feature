Feature: Pagination

  Background: Admin is on the Batch Page

  Scenario: Validate next page link
    Given Admin is on the Batch Page
    When Admin clicks next page link on the data table
    Then Admin should see the Next enabled link

  Scenario: validate last page link
    Given Admin is on the Batch Page
    When Admin clicks last page link on the data table
    Then Admin should see the last page link with next page link disabled on the table

  Scenario: validate the previous page link
    Given Admin is on the Batch Page
    When Admin clicks previous page link on the data table
    Then Admin should see the previous page on the table

  Scenario: validate the first page link
    Given Admin is on the Batch Page
    When Admin clicks first page link on the data table
    Then Admin should see the very first page on the data table
