@CMS @lmsui
Feature: Sorting all the data table headers in Class Details

  Background: Admin is on the Manage Class page after login
    Given Admin is on the home page after logged in
    When Admin clicks on the Class link on home page
    Then Admin navigated to Manage Class page

  @TCSCM01
  Scenario: Verify sorting of Batch Name in Ascending order
    Given Admin is on Manage Class
    When Admin clicks on Arrow next to Batch Name
    Then Admin See the Batch Name is sorted in Ascending order

  @TCSCM02
  Scenario: Validate sorting of Batch Name in Descending order
    Given Admin is on Manage Class
    When Admin clicks on Arrow next to Batch Name
    Then Admin See the Batch Name is sorted in Descending order

  @TCSCM03
  Scenario: verify sorting of Class Topic in Ascending order
    Given Admin is on Manage Class
    When Admin clicks on Arrow next to Class Topic
    Then Admin See the Class Topic is sorted in Ascending order

  @TCSCM04
  Scenario: verify sorting of Class Topic in Descending order
    Given Admin is on Manage Class
    When Admin clicks on Arrow next to Class Topic
    Then Admin See the Class Topic is sorted in Ascending order

  @TCSCM05
  Scenario: Validate sorting of Class Description in Ascending order
    Given Admin is on Manage Class
    When Admin clicks on Arrow next to Class Description
    Then Admin See the Class Description is sorted in ascending order

  @TCSCM06
  Scenario: Validate sorting of Class Description in Descending order
    Given Admin is on Manage Class
    When Admin clicks on Arrow next to Class Description
    Then Admin See the Class Description is sorted in Descending order

  @TCSCM07
  Scenario: verify sorting of Class Status in Ascending order
    Given Admin is on Manage Class
    When Admin clicks on Arrow next to Class Status
    Then Admin See the Class Status is sorted in Ascending order

  @TCSCM08
  Scenario: verify sorting of Class Status in Descending order
    Given Admin is on Manage Class
    When Admin clicks on Arrow next to Class Status
    Then Admin See the Class Status is sorted in Ascending order

  @TCSCM09
  Scenario: verify sorting of Class Date in Ascending order
    Given Admin is on Manage Class
    When Admin clicks on Arrow next to Class Date
    Then Admin See the Class Date is sorted in Ascending order

  @TCSCM10
  Scenario: verify sorting of Class Date in Descending order
    Given Admin is on Manage Class
    When Admin clicks on Arrow next to Class Date
    Then Admin See the Class Date is sorted in Ascending order

  @TCSCM011
  Scenario: Verify sorting of Staff Name in Ascending order
    Given Admin is on Manage Class
    When Admin clicks on Arrow next to Staff Name
    Then Admin See the Staff Name is sorted in Ascending order

  @TCSCM12
  Scenario: Validate sorting of Staff Name in Descending order
    Given Admin is on Manage Class
    When Admin clicks on Arrow next to Staff Name
    Then Admin See the Staff Name is sorted in Descending order
