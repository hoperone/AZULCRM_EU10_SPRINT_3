package com.azulcrm.step_definitions;

import com.azulcrm.pages.LoginPage;
import com.azulcrm.pages.SalimTaskPage;
import com.azulcrm.utilities.BrowserUtils;
import com.azulcrm.utilities.ConfigurationReader;
import com.azulcrm.utilities.Driver;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.Alert;
import org.openqa.selenium.Keys;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;


public class US05_Salim_TaskCreateFunction {

    LoginPage loginPage = new LoginPage();
    SalimTaskPage taskPage = new SalimTaskPage();

    @Given("user login successfully")
    public void user_login_successfully() {
        Driver.getDriver().get("https://qa.azulcrm.com/");
        loginPage.login(ConfigurationReader.getProperty("hrUserName"),ConfigurationReader.getProperty("hrPassword"));
    }

    @And("click to Task Tab")
    public void click_to_Task_Tab(){
        taskPage.taskTab.click();
        BrowserUtils.waitFor(2);
    }


    @When("user check High priority box.")
    public void user_check_high_priority_box() {
        taskPage.highPriorityCheckBox.click();
    }

    @When("fulfill mandatory fields for defining what the task is.")
    public void fulfill_mandatory_fields_for_defining_what_the_task_is() {
        taskPage.thingsToDo.sendKeys("TaskDemoRun");
        //Mandatory fields: Task name, Responsible person
       // taskPage.responsiblePersonBox.click();
     //   taskPage.responsiblePersonBox.sendKeys("hr52@cybertekschool.com");
     //   taskPage.responsiblePersonBox.sendKeys("hr53@cybertekschool.com");
      //  taskPage.thingsToDo.sendKeys(ConfigurationReader.getProperty("defaultTaskName"));
    }

    @When("user click on send button.")
    public void user_click_on_send_button() {
         taskPage.sendBtn.click();
         BrowserUtils.waitFor(10);
    }

    @Then("user can able to create task")
    public void user_can_able_to_create_task() {

        //WebDriverWait wait = new WebDriverWait(Driver.getDriver(),1);
        //  wait.until(ExpectedConditions.elementToBeClickable(taskPage.Task_created_PopUp));
      //  Assert.assertTrue(taskPage.Task_created_PopUp.isDisplayed());

        taskPage.OngoingTasks.click();
        Assert.assertTrue( taskPage.TaskDemoRunInList.isDisplayed());
       //Revert The Task
        taskPage.OngoingTasks.click();
        taskPage.TaskCenterCheckAll.click();
        taskPage.SelectActionDropDown.click();
        taskPage.DeleteInDropDown.click();
        taskPage.ApplyButtonInDropDown.click();
        taskPage.task_confirm_Continue.click();

    }

    @When("user click on {string} button")
    public void user_click_on_button(String string) {
        taskPage.AddMoreBtn.click();
    }

    @Then("user can able to assign more than one user {string}")
    public void user_can_able_to_assign_more_than_one_user(String string) {
        taskPage.AddMoreTextBox.sendKeys(ConfigurationReader.getProperty("gelaTestUser")+ Keys.ENTER);
        taskPage.AddMoreTextBox.sendKeys(ConfigurationReader.getProperty("cananTestUser")+ Keys.ENTER);
        Assert.assertTrue(taskPage.AddMoreBox.getText().contains("hr52"));

    }


    @When("task is created")
    public void task_is_created() {
        taskPage.taskTab.click();
        taskPage.thingsToDo.sendKeys("TaskDemoRun");
        taskPage.sendBtn.click();

    }


    @Then("new task should be counted on the homepage under MY TASKS table")
    public void new_task_should_be_counted_on_the_homepage_under_MY_TASKS_table() {
         Assert.assertTrue(taskPage.OngoingTasksCount.isDisplayed());
        //Revert The Task
        taskPage.OngoingTasks.click();
        taskPage.TaskCenterCheckAll.click();
        taskPage.SelectActionDropDown.click();
        taskPage.DeleteInDropDown.click();
        taskPage.ApplyButtonInDropDown.click();
        taskPage.task_confirm_Continue.click();
    }


    @When("write something and accept button")
    public void write_something_and_accept_button() {
        taskPage.ChecklistLink.click();
        taskPage.ChecklistThingsToDo.sendKeys(ConfigurationReader.getProperty("defaultTaskName"));
        taskPage.ChecklistAcceptBtn.click();
    }

    @Then("user should be able to be add a new checklist")
    public void user_should_be_able_to_be_add_a_new_checklist() {
        taskPage.ChecklistFieldCreatedAndDisplayed.isDisplayed();
        taskPage.ChecklistFieldClearOut.click();
    }



    @When("user click on {string} box")
    public void user_click_on_box(String string) {
        taskPage.DeadlineInputBox.click();

    }

    @When("choose something and click Select button")
    public void choose_something_and_click_select_button() {
        taskPage.PickDate.click();
        taskPage.DeadlineSelect.click();
    }

    @Then("user should be able to be add a new deadline")
    public void user_should_be_able_to_be_add_a_new_deadline() {
        String expectedDate = "04/15/2023 07:00 pm";
        String actual = taskPage.DeadlineDisplay.getAttribute("value");

        Assert.assertEquals(expectedDate,actual);

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
