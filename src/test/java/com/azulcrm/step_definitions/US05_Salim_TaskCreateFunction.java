package com.azulcrm.step_definitions;

import com.azulcrm.pages.LoginPage;
import com.azulcrm.pages.SalimTaskPage;
import com.azulcrm.utilities.BrowserUtils;
import com.azulcrm.utilities.ConfigurationReader;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class US05_Salim_TaskCreateFunction {

    LoginPage loginPage = new LoginPage();
    SalimTaskPage taskPage = new SalimTaskPage();

    @Given("user is in home page but in Tasks Quick Navigate Menu")
    public void user_is_in_home_page_but_in_tasks_quick_navigate_menu() {
        loginPage.login(ConfigurationReader.getProperty("hrUserName"),ConfigurationReader.getProperty("hrPassword"));
        BrowserUtils.waitFor(2);
        taskPage.taskTab.click();
    }

    @When("user check High priority box.")
    public void user_check_high_priority_box() {
        taskPage.highPriorityCheckBox.click();
    }

    @When("fulfill mandatory fields for defining what the task is.")
    public void fulfill_mandatory_fields_for_defining_what_the_task_is() {
        //Mandatory fields: Task name, Responsible person
        taskPage.responsiblePersonBox.click();
        taskPage.responsiblePersonBox.sendKeys("hr52@cybertekschool.com");
        taskPage.responsiblePersonBox.sendKeys("hr53@cybertekschool.com");
        taskPage.thingsToDo.sendKeys("Salim Task Tests");
    }

    @When("user click on send button.")
    public void user_click_on_send_button() {
       // String b = taskPage.ongoingPre.getText();
        taskPage.sendBtn.click();
    }

    @Then("user can able to create task")
    public void user_can_able_to_create_task() {
       // user_click_on_send_button
        String a = taskPage.ongoingAfter.getText();
      //  if (a>b)
    }

    @When("user click on {string} button")
    public void user_click_on_button(String string) {

    }

    @Then("user can able to assign more than one user {string}")
    public void user_can_able_to_assign_more_than_one_user(String string) {

    }


    @When("assert prior create new task")
    public void assert_prior_create_new_task() {

    }


    @Then("new task should be counted on the homepage under {string} table")
    public void new_task_should_be_counted_on_the_homepage_under_table(String string) {

    }


    @When("write something and accept button")
    public void write_something_and_accept_button() {

    }

    @Then("user should be able to be add a new checklist")
    public void user_should_be_able_to_be_add_a_new_checklist() {

    }



    @When("user click on {string} box")
    public void user_click_on_box(String string) {

    }

    @When("choose something and click Select button")
    public void choose_something_and_click_select_button() {

    }

    @Then("user should be able to be add a new deadline")
    public void user_should_be_able_to_be_add_a_new_deadline() {

    }

    @When("user click on {string} link")
    public void user_click_on_link(String string) {

    }

    @When("write sometime and Enter")
    public void write_sometime_and_enter() {

    }

    @Then("user should be able to see Finish date")
    public void user_should_be_able_to_see_finish_date() {

    }

}
