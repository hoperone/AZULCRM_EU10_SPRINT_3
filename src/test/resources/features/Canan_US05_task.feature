@AZUL10-557
Feature: As a user, I should be able to assign tasks under Quick Navigate Menu

  Background:
    Given user logs in successfully
    And user clicks Task menu

  @AZUL10-558
  Scenario: Verify hr user can assign high priority task-1
    When user enters task name
    And user clicks high priority checkbox
    Then high priority checkbox is selected

  @AZUL10-549
  Scenario: Verify hr user can assign high priority task-2
    When user enters task name
    And user clicks high priority checkbox
    And user adds responsible person
      | marketing7@cybertekschool.com |
    And user clicks Send button
    Then user gets task created message

  @AZUL10-550
  Scenario: Verify hr user can not assign high priority task without task name
    When user clicks high priority checkbox
    And user adds responsible person
      | marketing7@cybertekschool.com |
    And user clicks Send button
    Then user gets "The task name is not specified." message

  @AZUL10-551
  Scenario: Verify hr user can not assign high priority task without responsible person
    When user enters task name
    And user clicks high priority checkbox
    And user removes responsible person
    And user clicks Send button
    Then user gets "A user specified in the field \"Responsible Person\" was not found." message

  @AZUL10-552
  Scenario: Verify that hr user can assign a task to three person
    When user enters task name
    And user clicks high priority checkbox
    And user adds responsible person
      | marketing7@cybertekschool.com |
      | helpdesk22@cybertekschool.com |
      | helpdesk23@cybertekschool.com |
    And user clicks Send button
    Then user gets task created message

  @AZUL10-553
  Scenario: Verify that hr user can see see created tasks under My Tasks table
    When user assigns high priority task
    When user clicks Tasks on homepage
    Then user sees created task under My Tasks table
    Then user sees task has high priority icon

  @AZUL10-554
  Scenario: Verify that user can add checklist to the task
    When user clicks Checklist link
    And user adds text to things to do input box
    And user clicks add link
    Then user sees a checklist element is added

  @AZUL10-555
  Scenario Outline: Verify user can add deadline to the task
    When user clicks deadline toolbox
    And user selects month "<month>"
    And user selects year "<year>"
    And user selects day "<day>"
    And user selects hour "<hour>", minute "<minute>" and amPm "<amPm>"
    And user clicks select button
    Then user sees "<deadline>" was added
    Examples:
      | month | year | day | hour | minute | amPm | deadline               |
      | May   | 2024 | 1   | 9    | 30     | AM   | 05/01/2024 09:30:00 am |
      | June  | 2025 | 2   | 1    | 00     | PM   | 06/02/2025 01:00:00 pm |

  @AZUL10-556
  Scenario Outline: Verify user can use time planning function
    When user clicks time planning option
    And user selects start time
    |May,2024,31,10,30,AM |
    And user enters "<duration>"
    Then finish box shows finish "<time>" correctly
    Examples:
      | duration   | time                   |
      | 10 days    | 06/10/2024 10:30:00 am |
      | 10 hours   | 05/31/2024 08:30:00 pm |
      | 10 minutes | 05/31/2024 10:40:00 am |





