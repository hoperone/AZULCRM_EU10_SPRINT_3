@AZUL10-487 @run
Feature: US_04 Create Events
  User Story:
  As a user, I want to be able to create events by clicking on the Event tab under the Activity Stream.

  Acceptance Criteria:
  1. User should be able to add Event start and ending date and time, select "All day" and specify the time zone.
  2. User should be able to set reminder.
  3. User should be able to select the event location from the dropdown.
  4. User should be able to add members by selecting contacts individually or adding groups and departments.
  5. User should be able to send event by filling the mandatory fields.
  6. User should be able to cancel sending event at any time before sending.

  Background:
    Given the user logs in successfully
    And user clicks on event

  @AZUL10-560
  Scenario: US04 TC01 Test Case 1.1: Verify that the user can select the start and end dates for the event.
    When user enters Event name
    And user enters events start and end date
    And user clicks on send button
    Then the start and end dates have been selected

  @AZUL10-561
  Scenario: US04 TC01 Test Case 1.2: Verify that the user can specify the start and the end times
    When user enters Event name
    And user enters start and end time
    And user clicks on send button
    Then the start and the end times have been selected

  @AZUL10-562
  Scenario: US04 TC01 Test Case 1.3: Verify that the user can specify the time zone for the event.
    When user enters Event name
    And user specifies the event start and end time zones
    And user clicks on send button
    Then event start and end time zones have been selected

  @AZUL10-570
  Scenario: US04 TC01 Test Case 1.4: Verify that the user can select the "All day" option, and the start and end time fields disappear, and the user can't specify the time zone.
    When user checks all day box
    Then user no longer sees, start time, end time and time zone

  @AZUL10-539
  Scenario Outline: US04 TC02 Test Case 2.1: Verify that the user can set a reminder for the event.
    When user enters Event name
    And user sets the reminder time "<EventReminderTimeInMinutes>"
    And user sets the reminder type "<EventReminderType>"
    And user clicks on send button
    Then the reminder is activated reminder time "<EventReminderTimeInMinutes>" reminder type "<EventReminderType>"
    Examples:
      | EventReminderTimeInMinutes | EventReminderType |
      | 33                         | minutes           |
      | 1                          | hours             |
      | 1                          | days              |

  @AZUL10-541
  Scenario Outline: US04 TC03 Test Case 3.1: Verify that the user can select a location from the dropdown list.
    When user enters Event name
    And user selects the event location "<eventLocation>" from the dropdown
    And user clicks on send button
    Then the event location "<eventLocation>" has been selected
    Examples:
      | eventLocation        |
      | Central Meeting Room |
      | East Meeting Room    |
      | West Meeting Room    |

  @AZUL10-563
  Scenario: US04 TC04 Test Case 4.1: Verify that the user can select individual contacts to invite to the event.
    When user enters Event name
    And user selects individual contacts
    And user clicks on send button
    Then individual contacts have been invited to the event

  @AZUL10-564
  Scenario: US04 TC04 Test Case 4.2: Verify that the user can select groups and departments to invite to the event.
    When user enters Event name
    And user selects departments
    And user clicks on send button
    Then selected departments have been invited to the event

  @AZUL10-567
  Scenario: US04 TC05 Test Case 5.1: Verify that the the user is able to send event by filling the mandatory fields.
    When user enters Event name
    And user clicks on send button
    Then the event should be created


  @AZUL10-565
  Scenario: US04 TC06 Test Case 6.1: Verify that the user can cancel creating the event before sending.
    When user enters Event name
    And user enters Event description
    And user sets the reminder
    And user clicks on cancel button
    Then the even should be canceled

  @AZUL10-566
  Scenario: US04 TC08 Test Case 8.1: Verify that the start and end dates are set to today's date by default.
    Then that the start and end dates match to today's date

  @AZUL10-571
  Scenario: US04 TC07 Test Case 7.1: Verify that the user cannot create an event without filling out the "Event name" field.
    When user enters Event description
    And user clicks on send button
    Then the event can't be created
