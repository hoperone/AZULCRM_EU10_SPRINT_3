@wip
Feature: Assigning tasks under Quick Navigate Menu
  Background:
    Given user is in home page but in Tasks Quick Navigate Menu

  @AC1
  Scenario: Verify that, HR User should be able to create a "High priority" tasks with the mandatory fields.
    When user check High priority box.
    And fulfill mandatory fields for defining what the task is.
    And user click on send button.
    Then user can able to create task

  @AC2
  Scenario Outline: Verify that, HR User should be able to assign a task to more than one user (Test with adding 3 users max.)
    When user click on "add more" button
    Then user can able to assign more than one user "<user>"
    Examples:
      | user                                                                  |
      | hr52@cybertekschool.com hr4@cybertekschool.com                        |
      | hr52@cybertekschool.com hr4@cybertekschool.com hr5@cybertekschool.com |

  @AC3
  Scenario:  Verify that, when task is created, can be seen on the count on the homepage under "MY TASKS" table.
    When assert prior create new task
    And fulfill mandatory fields for defining what the task is.
    And user click on send button.
    Then new task should be counted on the homepage under "MY TASKS" table

  @AC4
  Scenario: Verify that, checklist should be able to be added while creating a task.
    When user click on "checklist" button
    And write something and accept button
    Then user should be able to be add a new checklist

  @AC5
  Scenario: Verify that, deadline should be able to be added while creating a task.
    When user click on "deadline" box
    And choose something and click Select button
    Then user should be able to be add a new deadline

  @AC6
  Scenario: Verify that, time planning function should be able to be used in the setting of deadline.
    When user click on "time planning" link
    And user click on "Start task on" box
    And choose something and click Select button
    And user click on "Duration" box
    And write sometime and Enter
    Then user should be able to see Finish date