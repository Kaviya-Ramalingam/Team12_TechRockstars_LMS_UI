@PageValidationInClassModule @LMSUI
Feature: Class Page Validation

  Background: Admin is on home page after Login
    Given Admin is on the home page after login

  @TCCPV01
  Scenario: Validating the class manage page
    Given Admin is on the Manage class page after login
    When Admin clicks the Class Navigation bar in the Header
    Then Admin should land on the Manage class page

  @TCCPV02
  Scenario: Validating the Title in the Manage class page
    When Admin clicks the Class Navigation bar in the Header
    Then Admin should see the "LMS-Learning Management System" Title

  @TCCPV03
  Scenario: Validating the Header in the Manage class page
    When Admin clicks the Class Navigation bar in the Header
    Then Admin should see the Mange Class Header

  @TCCPV04
  Scenario: Validating Search bar in class page
    When Admin clicks the Class Navigation bar in the Header
    Then Admin should see the Search Bar in Manage class page

  @TCCPV05
  Scenario: Validating the data table headers in the class page
    When Admin clicks the Class Navigation bar in the Header
    Then Admin should see the datatable heading like Batchname,class topic,class description,status,class Date,staff name,Edit/Delete

  @TCCPV06
  Scenario: Validating the text and pagination icon in the classpage
    When Admin clicks "Class" on the navigation bar
    Then Admin should see the text as "showing x to y of z entries" and enabled pagination controls under the data table

  @TCCPV07
  Scenario: Validate the sort icon of all the field in datatable
    When Admin clicks the Class Navigation bar in the Header
    Then Admin should see the Sort icon of all the field in the datatable.

  @TCCPV08
  Scenario: Validating the Delete button under the Manage class
    When Admin clicks the Class Navigation bar in the Header
    Then Admin should see the Delete button under the Manage class page header.

  @TCCPV09
  Scenario: Validate the total no of classes in manage class page
    When Admin clicks the Class Navigation bar in the Header
    Then Admin should see Total no of classes in below of the data table.
