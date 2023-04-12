@wip
Feature: As a user, I should be able to use functions on Find Employee under Employee menu.
Background:
  Given User logs in successfully
  And User clicks on Employee menu
  And user clicks on Find Employee menu

  Scenario: Verify that user is able to see the employee list in "Find Employee" under "Employees" tab.
    Then user can see Employee list


  Scenario: Verify that user is able to see the inactive employees by clicking the the "Inactive" tab
    When user clicks inactive button
    Then user can see inactive employees list


  Scenario: Verify that user is able to find employees by search by Alphabet.
    When user clicks search by alphabet button
    And user clicks a letter from list
    Then user can see selected employees on the list

  Scenario: Verify that user is able to find employees by search box.
    When user enters a name on search box
    And user clicks search icon
    Then user can see searched employees on the list

