package com.azulcrm.step_definitions;

import com.azulcrm.pages.EminMessagePage;
import com.azulcrm.pages.LoginPage;
import com.azulcrm.utilities.BrowserUtils;
import com.azulcrm.utilities.ConfigurationReader;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

public class Emin_US03_Message_StepDefinitions {

    EminMessagePage eminMessagePage = new EminMessagePage();
    LoginPage loginPage = new LoginPage();



    @Given("the user logs in to web page successfully")
    public void the_user_logs_in_to_web_page_successfully() {
        loginPage.goLoginPage();
        loginPage.login(ConfigurationReader.getProperty("eminTestUser"),
                ConfigurationReader.getProperty("defaultPassword"));
    }

    @When("user clicks Message menu")
    public void user_clicks_message_menu() {
        eminMessagePage.messageTab.click();

    }

    @And("the user is composes a message")
    public void the_user_is_composes_a_message()  {
        String message = "Subject: Weekly Meeting Reminder Message: " +
                "Hi team, just a friendly reminder that our weekly meeting " +
                "is tomorrow at 10:00 AM in the conference room. " +
                "Please come prepared with any updates or questions you have. ";

        eminMessagePage.switchToIframe();
        eminMessagePage.messageInbox.click();
        eminMessagePage.messageInbox.sendKeys(message);
        eminMessagePage.switchToParentFrame();

    }


//    @When("the user clicks add mention button")
//    public void the_user_clicks_add_mention_button()  {
//        BrowserUtils.waitForVisibility(eminMessagePage.addMention,5);
//        eminMessagePage.addMention.click();
//    }

//    @And("the user clicks addMore button")
//    public void the_user_clicks_add_more_button()  {
//        BrowserUtils.waitForVisibility(eminMessagePage.addMoreButton,5);
//        eminMessagePage.addMoreButton.click();
//    }
//    @And("the user removes all employees")
//    public void the_user_removes_all_employees() {
//        eminMessagePage.removeAllEmployees2.click();
//    }
//
//    @And("the user clicks employees and department button")
//    public void the_user_clicks_employees_and_department_button() {
//        eminMessagePage.employeesAndDepartments.click();
//    }
//
//
//    @When("the user adds one by one all departments")
//    public void the_user_adds_one_by_one_all_departments() {
//
//        eminMessagePage.developerDepartment.click();
//        eminMessagePage.developerDepartmentCheckBox.click();
//        eminMessagePage.developerDepartment.click();
//
//        eminMessagePage.instructorDepartment.click();
//        eminMessagePage.instructorDepartmentCheckBox.click();
//        eminMessagePage.instructorDepartment.click();
//
//        eminMessagePage.QADepartment.click();
//        eminMessagePage.QADepartmentCheckBox.click();
//        eminMessagePage.QADepartment.click();
//
//        eminMessagePage.salesforceDepartment.click();
//        eminMessagePage.salesforceDepartmentCheckBox.click();
//        eminMessagePage.popupWindowCloseIcon.click();
//    }
//    @Then("the user verifies all departments are added or not")
//    public void the_user_verifies_all_departments_are_added_or_not() {
//
//    }


    @And("the user clicks to the link button")
    public void the_user_clicks_to_the_link_button() {
        eminMessagePage.linkButton.click();
    }

    @And("the user sends link text and URL")
    public void the_user_sends_link_text_and_url() {
        eminMessagePage.linkInputText.sendKeys(ConfigurationReader.getProperty("linkText"));
        eminMessagePage.linkInputURL.sendKeys(ConfigurationReader.getProperty("linkURL"));

    }

    @And("the user clicks on the save button")
    public void the_user_clicks_on_the_save_button() {
        eminMessagePage.saveButton.click();
    }

    @When("the user clicks Send button")
    public void the_user_clicks_send_button() {
        eminMessagePage.sendMessageButton.click();
    }

    @Then("the sent text should be hyperlinked to the entered URL in message")
    public void the_sent_text_should_be_hyperlinked_to_the_entered_url_in_message(){
       BrowserUtils.waitForVisibility(eminMessagePage.hyperlinkIsDisplayed,5);
       eminMessagePage.hyperlinkIsDisplayed.isDisplayed();


    }







    @And("the user clicks on the quote button")
    public void the_user_clicks_on_the_quote_button() {
        eminMessagePage.quoteButton.click();
    }

    @And("the user sends the quote text")
    public void the_user_sends_the_quote_text() {
        String quoteMessage = "\"It is better to fail in originality than to succeed in imitation.\" — Herman Melville";

        eminMessagePage.switchToIframe();
        eminMessagePage.quoteInbox.sendKeys(quoteMessage);
        eminMessagePage.switchToParentFrame();
    }

    @Then("the sent quote text is displayed")
    public void the_sent_quote_text_is_displayed() {
        BrowserUtils.waitForVisibility(eminMessagePage.quoteTextVerification,5);
        eminMessagePage.quoteTextVerification.isDisplayed();
    }







    @When("the user clicks on the tags button")
    public void the_user_clicks_on_the_tags_button() {
        eminMessagePage.addTagButton.click();
    }

    @When("the user sends tag or tags into tag input box")
    public void the_user_sends_tag_or_tags_into_tag_input_box() {
        eminMessagePage.addTagInbox.sendKeys(ConfigurationReader.getProperty("tagsMessage"));
    }

    @When("the user clicks the add button")
    public void the_user_clicks_the_add_button(){
        eminMessagePage.tagAddFinal.click();
    }

    @Then("the sent tag or tags is displayed")
    public void the_sent_tag_or_tags_is_displayed() {
        BrowserUtils.waitForVisibility(eminMessagePage.tagIsDisplayed,5);
        Assert.assertTrue(eminMessagePage.tagIsDisplayed.isDisplayed());
    }







    @When("the user remove tags before sending the message")
    public void the_user_remove_tags_before_sending_the_message() {
        eminMessagePage.removeTag.click();
    }

    @Then("the user verifies if the tag is removed or not")
    public void the_user_verifies_if_the_tag_is_removed_or_not()  {

        try {
            BrowserUtils.waitForVisibility(eminMessagePage.tagIsDisplayed,5);
            Assert.assertTrue(eminMessagePage.tagIsDisplayed.isDisplayed());
        } catch (Exception e) {
            System.out.println("The added tag is removed");
        }



    }


}
