Feature: US12_As a user,
  I should be able to use functions on Company Structure under Employee menu.
  1. All user types should be able to display company structure.
  2. Hr user should be able to add a department from the company structure.
  3. Hr user should be able to select a parent department from the department dropdown.
  4.Hr user should be able to select a supervisor from "recent", "company" and "search"
  5.Hr user should be able to close add department pop-up at any time before sending.
  6.Hr user should be able to edit departments, add child departments, and delete departments after adding the department.
  7.Hr user should be able to drag and drop the existing department under another department as a subdepartment.
  8. Helpdesk and marketing users can not change company structure.

  Background: User is expected to be on the login page for the scenarios on the feature file
    Given user is on the login page

  Scenario:
    Given user is on the login page
