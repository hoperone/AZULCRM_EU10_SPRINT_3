package com.azulcrm.step_definitions;

import com.azulcrm.pages.Canan_Task_Page;
import com.azulcrm.utilities.BrowserUtils;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;

import java.util.List;

public class Canan_US05_Task_StepDefinitions {

    Canan_Task_Page taskPage = new Canan_Task_Page();

    @Given("user clicks Task menu")
    public void user_clicks_task_menu() {
        taskPage.taskMenuTab.click();
    }

    @When("user enters task name")
    public void user_enters_task_name() {
        taskPage.thingsToDoInputBox.sendKeys("canan new task");
    }

    @When("user clicks high priority checkbox")
    public void user_clicks_high_priority_checkbox() {
        taskPage.highPriorityCheckbox.click();
    }
    @When("user adds responsible person")
    public void user_adds_responsible_person(List<String> people) {
        taskPage.addResponsiblePerson(people);
    }
    @Then("user gets task created message")
    public void user_gets_task_created_message() {
        Assert.assertTrue(taskPage.taskCreatedPopupMessage.isDisplayed());
    }

    @Then("user gets {string} message")
    public void user_gets_message(String expectedMessage) {
        String actualMessage = taskPage.errorMessage.getText();
        Assert.assertEquals(expectedMessage, actualMessage);
    }
    @When("user removes responsible person")
    public void user_removes_responsible_person() throws InterruptedException {
        taskPage.cancelResponsiblePersonIcon.click();
        Thread.sleep(500);
    }
    @When("user clicks Tasks on homepage")
    public void user_clicks_tasks_on_homepage() {
        taskPage.tasksLeftMenu.click();
    }
    @Then("user sees created task under My Tasks table")
    public void user_sees_created_task_under_my_tasks_table() {
        Assert.assertTrue(taskPage.taskItemUnderMyTasksTable.isDisplayed());
    }

    @When("user clicks Checklist link")
    public void user_clicks_checklist_link() {
       taskPage.checklistLink.click();
    }
    @When("user adds text to things to do input box")
    public void user_adds_text_to_things_to_do_input_box() {
        taskPage.checklistInputBox.sendKeys("first item");
    }
    @When("user clicks add link")
    public void user_clicks_add_link() {
       taskPage.checklistAddButton.click();
    }
    @Then("user sees a checklist element is added")
    public void user_sees_a_checklist_element_is_added() {
        Assert.assertTrue(taskPage.newCreatedChecklistItem.isDisplayed());
    }

    @When("user clicks deadline toolbox")
    public void user_clicks_deadline_toolbox() throws InterruptedException {
        taskPage.deadlinePicker.click();
        Thread.sleep(500);

    }
    @When("user selects month {string}")
    public void user_selects_month(String month) throws InterruptedException {
        taskPage.selectMonth(month);

    }
    @When("user selects year {string}")
    public void user_selects_year(String year) throws InterruptedException {

        taskPage.selectYear(year);


    }
    @When("user selects day {string}")
    public void user_selects_day(String day) throws InterruptedException {

        taskPage.selectDay(day);

    }
    @When("user selects hour {string}, minute {string} and amPm {string}")
    public void user_selects_hour_minute_and_am_pm(String hour, String minute, String amPm) throws InterruptedException {

        taskPage.selectHour(hour);
        taskPage.selectMinute(minute);
        taskPage.selectAmPm(amPm);

    }

    @When("user clicks select button")
    public void user_clicks_select_button() {
        taskPage.calenderSelectButton.click();
    }
    @Then("user sees {string} was added")
    public void user_sees_was_added(String expectedDate) {
        String actualDate = taskPage.selectedDeadlineValue.getAttribute("value");
        Assert.assertEquals(expectedDate, actualDate);
    }

    @When("user clicks time planning option")
    public void user_clicks_time_planning_option() {
        BrowserUtils.waitForClickablility(taskPage.timePlanningLink, 10);
        taskPage.timePlanningLink.click();
    }
    @When("user selects start time")
    public void user_selects_start_time(String startTime) throws InterruptedException {
        taskPage.startTaskOnPicker.click();
        Thread.sleep(500);
        String[] timeElements = startTime.split(",");
        taskPage.selectMonth(timeElements[0]);
        taskPage.selectYear(timeElements[1]);
        taskPage.selectDay(timeElements[2]);
        taskPage.selectHour(timeElements[3]);
        taskPage.selectMinute(timeElements[4]);

        taskPage.calenderSelectButton.click();
    }
    @And("user enters {string}")
    public void userEnters(String duration) {
        String[] durationArray = duration.split(" ");
        taskPage.durationInputBox.sendKeys(durationArray[0]);
        switch (durationArray[1]){
            case "days":
                taskPage.durationDaysOption.click();
                break;
            case "hours":
                taskPage.durationHoursOption.click();
                break;
            case "minutes":
                taskPage.durationMinutesOption.click();
                break;


        }

    }
    @Then("finish box shows finish {string} correctly")
    public void finish_box_shows_finish_time_correctly(String expectedFinishTime) {
        String actualFinishTime = taskPage.finishDateInputBox.getAttribute("value");
        Assert.assertEquals(expectedFinishTime, actualFinishTime);
    }


    @Then("high priority checkbox is selected")
    public void highPriorityCheckboxIsSelected() {
        Assert.assertTrue(taskPage.highPriorityCheckbox.isSelected());
    }

    @When("user assigns high priority task")
    public void userAssignsHighPriorityTask() {
        taskPage.assignHighPriorityTask();

    }

    @Then("user sees task has high priority icon")
    public void userSeesTaskHasHighPriorityIcon() {
        Assert.assertTrue(taskPage.highPriorityIconUnderMyTasksTable.isDisplayed());
    }



}
