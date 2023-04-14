@AZUL10-590
Feature: US03 As a user, I should be able to add link, insert video, add mention, add quote and add tag in message.

  Background:
    Given the user logs in to web page successfully

    #TC1 This test case manually checked and seen that
                # the add  check box doesn't exist.
                # Because of that this AC cannot be automated.
  @AZUL10-589
#  Scenario: User should be able to add mentions about only department employees.
#    When user clicks Message menu
#    And the user is composes a message
#    And the user removes all employees
#    And the user clicks add mention button
#    And the user clicks employees and department button
#    And the user should only be able to add email addresses of department employees
#    Then the user should not be able to add email addresses from outside of the company




    #TC2
    @AZUL10-584
  Scenario: Attaching a link to specified text
    When user clicks Message menu
    And the user is composes a message
    And the user clicks to the link button
    And the user sends link text and URL
    And the user clicks on the save button
    And the user clicks Send button
    Then the sent text should be hyperlinked to the entered URL in message



      #TC3 This test case manually checked and seen that
            # the youtube or vimeo videos cannot be uploaded.
            # Because of that this AC cannot be automated.
    @AZUL10-588
#    Scenario: User should be able to insert YouTube and Vimeo video
#      When user clicks Message menu
#      And the user clicks to insert video button
#      And the user enters the URL of a youtube or Vimeo
#      Then the video should be disabled in the message


      #TC4
      @AZUL10-585 @smoke
      Scenario: User should be able to add quotes
        When user clicks Message menu
        And the user clicks on the quote button
        And the user sends the quote text
        And the user clicks Send button
        Then the sent quote text is displayed



        #TC5
        @AZUL10-586 @smoke
        Scenario: User should be able to add tags in message
          When user clicks Message menu
          And the user is composes a message
          And the user clicks on the tags button
          And the user sends tag or tags into tag input box
          And the user clicks the add button
          And the user clicks Send button
          Then the sent tag or tags is displayed

        #TC6
        @AZUL10-587
        Scenario: User should be able to remove tags before sending the message
          When user clicks Message menu
          And the user is composes a message
          And the user clicks on the tags button
          And the user sends tag or tags into tag input box
          And the user clicks the add button
          And the user remove tags before sending the message
          And the user verifies if the tag is removed or not
          Then the user clicks Send button



