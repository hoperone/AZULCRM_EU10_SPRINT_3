package com.azulcrm.step_definitions;

import com.azulcrm.pages.*;
import com.azulcrm.utilities.BrowserUtils;
import com.azulcrm.utilities.ConfigurationReader;
import com.azulcrm.utilities.Driver;
import com.github.javafaker.Faker;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.asserts.SoftAssert;

import java.util.ArrayList;
import java.util.List;


public class Gela_US_04_Create_Events_Step_Definitions {


    //Creating Page objects to call locators and common methods
    Gela_Login_Page gelaLoginPage = new Gela_Login_Page();
    Gela_Event_Page gelaEventPage = new Gela_Event_Page();
    Gela_Sidebar_Page gelaSidebarPage = new Gela_Sidebar_Page();
    Gela_Activity_Stream_Top_Tabs_Page gelaActivityStreamTopTabs = new Gela_Activity_Stream_Top_Tabs_Page();
    Gela_Calendar_Slider_Sidebar_Page gelaCalendarSliderSidebar = new Gela_Calendar_Slider_Sidebar_Page();
    Gela_Calendar_Slider_Workarea_Page gelaCalendarSliderWorkareaPage = new Gela_Calendar_Slider_Workarea_Page();
    Gela_Internal_Container_Page gelaInternalContainerPage = new Gela_Internal_Container_Page();

    //Using Faker Class to generate Event Title and Description
    Faker faker = new Faker();


    public String eventName = faker.book().title();
    public String eventDescription = faker.book().author();

    public String currentDate = gelaEventPage.getCurrentDate();
    public String startTime = gelaEventPage.getCurrentTimePlusCustomMinutes(30L);
    public String endTime = gelaEventPage.getCurrentTimePlusCustomMinutes(50L);


    //Backgrounds
    @Given("the user logs in successfully")
    public void the_user_logs_in_successfully() {
        gelaLoginPage.goLoginPage(); //Calls log in method
        //inserts user and password from Conf. reader
        gelaLoginPage.loginInput.sendKeys(ConfigurationReader.getProperty("gelaTestUser"));
        gelaLoginPage.passInput.sendKeys(ConfigurationReader.getProperty("defaultPassword"));
        gelaLoginPage.loginBtn.click();//clicks on login btn

        //Assert that the user is successfully logged in, therefore he is on Portal page
        Assert.assertTrue(gelaEventPage.getPageTitle().contains("Portal"));
    }

    @When("user clicks on Activity Stream")
    public void user_clicks_on_activity_stream() {
        gelaLoginPage.activityStreamModule.click();
    }

    @When("user clicks on event")
    public void user_clicks_on_event() {
        gelaActivityStreamTopTabs.eventTab.click(); //click on event tab

    }


    @When("user enters Event name")
    public void user_enters_event_name() {
        gelaEventPage.eventNameField.sendKeys(eventName);
    }

    @When("user enters Event description")
    public void user_enters_event_description() {

        gelaEventPage.enterDescription(eventDescription);

    }

    @When("user enters event start date")
    public void user_enters_event_start_date() {
        gelaEventPage.calendarDateFrom.sendKeys(Keys.chord(Keys.CONTROL, "a"), Keys.DELETE);
        BrowserUtils.waitFor(1);
    }

    /**
     * Test Case 1.1: Verify that the user can select the start and end dates and times for the event.
     */
    //Takes dates from feature files steps text
    @When("user enters event start date {string} and end date {string}")
    public void user_enters_event_start_date_and_end_date(String startDate, String endDate) {

        gelaEventPage.calendarDateFrom.sendKeys(Keys.chord(Keys.CONTROL, "a"), Keys.DELETE);
        gelaEventPage.calendarDateFrom.sendKeys(startDate);
        gelaEventPage.calendarDateTo.sendKeys(Keys.chord(Keys.CONTROL, "a"), Keys.DELETE);
        gelaEventPage.calendarDateTo.sendKeys(endDate);
    }

    //takes dates from getCurrentDate(), actual dates
    @When("user enters events start and end date")
    public void user_enters_events_start_and_end_date() {
        gelaEventPage.calendarDateFrom.sendKeys(Keys.chord(Keys.CONTROL, "a"), Keys.DELETE);
        gelaEventPage.calendarDateFrom.sendKeys(currentDate);
        gelaEventPage.calendarDateTo.sendKeys(Keys.chord(Keys.CONTROL, "a"), Keys.DELETE);
        gelaEventPage.calendarDateTo.sendKeys(currentDate);
        BrowserUtils.waitFor(1);
    }


    @Then("the start and end dates have been selected")
    public void the_start_and_end_dates_have_been_selected() {
        //go to last created event
        gelaSidebarPage.clickOnEvent(eventName);

        //click on edit button
        gelaCalendarSliderWorkareaPage.editBtn.click();

        Assert.assertEquals(currentDate, gelaCalendarSliderWorkareaPage.eventStartDate.getAttribute("value"));
        Assert.assertEquals(currentDate, gelaCalendarSliderWorkareaPage.eventEndDate.getAttribute("value"));

        gelaCalendarSliderWorkareaPage.cancelBtn.click();
        gelaLoginPage.activityStreamModule.click();

        gelaSidebarPage.clickOnEvent(eventName);

        //Delete the event after the Assertion
        gelaEventPage.deleteEvent();
    }

    /**
     * Test Case 1.2: Verify that the user can specify the start and the end times and the time zone for the event.
     */

    //sets the start and end time by deleting the input fields default times and entering the current time from local machine
    @When("user enters start and end time")
    public void user_enters_start_and_end_time() {

        gelaEventPage.timeFrom.sendKeys(Keys.chord(Keys.CONTROL, "a"), Keys.DELETE);
        gelaEventPage.timeFrom.sendKeys(startTime);
        gelaEventPage.timeTo.sendKeys(Keys.chord(Keys.CONTROL, "a"), Keys.DELETE);
        gelaEventPage.timeTo.sendKeys(endTime);
    }

    @Then("the start and the end times have been selected")
    public void the_start_and_the_end_times_have_been_selected() {
        //go to last created event
        gelaSidebarPage.clickOnEvent(eventName);

        //click on edit button
        gelaCalendarSliderWorkareaPage.editBtn.click();
        BrowserUtils.waitFor(2);

        Assert.assertEquals(startTime, gelaCalendarSliderWorkareaPage.timeFrom.getAttribute("value"));
        Assert.assertEquals(endTime, gelaCalendarSliderWorkareaPage.timeTo.getAttribute("value"));

        gelaCalendarSliderWorkareaPage.cancelBtn.click();
        gelaLoginPage.activityStreamModule.click();

        gelaSidebarPage.clickOnEvent(eventName);

        //Delete the event after the Assertion
        gelaEventPage.deleteEvent();
    }

    @When("user enters start time {string} and end time {string}")
    public void user_enters_start_time_and_end_time(String startTime, String endTime) {
        gelaEventPage.timeFrom.sendKeys(Keys.chord(Keys.CONTROL, "a"), Keys.DELETE);
        gelaEventPage.timeFrom.sendKeys(startTime);
        gelaEventPage.timeTo.sendKeys(Keys.chord(Keys.CONTROL, "a"), Keys.DELETE);
        gelaEventPage.timeTo.sendKeys(endTime);
    }

    /**
     * Test Case 1.3: Verify that the user can specify the time zone for the event.
     */
    @When("user specifies the event start and end time zones")
    public void user_specifies_the_event_start_and_end_time_zones() {
        gelaEventPage.specifyTimeZone.click();

        Select timeZoneFrom = new Select(gelaEventPage.timeZoneFromDropdown);
        Select timeZoneTo = new Select(gelaEventPage.timeZoneToDropdown);
        timeZoneFrom.selectByVisibleText(ConfigurationReader.getProperty("Europe_Berlin_TimeZone"));
        timeZoneTo.selectByVisibleText(ConfigurationReader.getProperty("Europe_Berlin_TimeZone"));
        BrowserUtils.waitFor(2);
    }

    @Then("event start and end time zones have been selected")
    public void event_start_and_end_time_zones_have_been_selected() {
        //go to last created event
        gelaSidebarPage.clickOnEvent(eventName);

        //click on edit button
        gelaCalendarSliderWorkareaPage.editBtn.click();
        BrowserUtils.waitFor(2);

        //Click on Time zone
        gelaCalendarSliderWorkareaPage.timeZoneLink.click();

        Assert.assertTrue(ConfigurationReader.getProperty("Europe_Berlin_TimeZone").contains(gelaCalendarSliderWorkareaPage.timeZoneFrom.getAttribute("value")));
        Assert.assertTrue(ConfigurationReader.getProperty("Europe_Berlin_TimeZone").contains(gelaCalendarSliderWorkareaPage.timeZoneTo.getAttribute("value")));

        //cancel and go to activity stream
        gelaCalendarSliderWorkareaPage.cancelBtn.click();
        gelaLoginPage.activityStreamModule.click();

        gelaSidebarPage.clickOnEvent(eventName); //click on event

        //Delete the event after the Assertion
        gelaEventPage.deleteEvent();
    }

    @And("user specifies the event start time zone <{int}> and end time zone <{int}>")
    public void userSpecifiesTheEventStartTimeZoneAndEndTimeZone(int startTimeZoneIndex, int endTimeZoneIndex) {
        gelaEventPage.specifyTimeZone.click();

        Select timeZoneFrom = new Select(gelaEventPage.timeZoneFromDropdown);
        Select timeZoneTo = new Select(gelaEventPage.timeZoneToDropdown);
        timeZoneFrom.selectByIndex(startTimeZoneIndex);
        timeZoneTo.selectByIndex(endTimeZoneIndex);
    }

    @When("today's date is set as default form start and end date")
    public void today_s_date_is_set_as_default_form_start_and_end_date() {
        String actualDateFrom = gelaEventPage.calendarDateFrom.getAttribute("value");
        String actualDateTo = gelaEventPage.calendarDateTo.getAttribute("value");
        String expectedDate = gelaEventPage.getCurrentDate();

        Assert.assertEquals(expectedDate, actualDateFrom);
        Assert.assertEquals(expectedDate, actualDateTo);
    }

    @When("user checks all day box")
    public void user_checks_all_day_box() {
        gelaEventPage.eventFullDayCheckBox.click();
        Assert.assertTrue(gelaEventPage.eventFullDayCheckBox.isSelected());
    }

    @Then("user no longer sees, start time, end time and time zone")
    public void user_no_longer_sees_start_time_end_time_and_time_zone() {
        boolean timeFromDisplayed = gelaEventPage.timeFrom.isDisplayed();
        boolean timeToDisplayed = gelaEventPage.timeTo.isDisplayed();
        boolean specifyTimeZoneDisplayed = gelaEventPage.specifyTimeZone.isDisplayed();

        Assert.assertFalse(timeFromDisplayed);
        Assert.assertFalse(timeToDisplayed);
        Assert.assertFalse(specifyTimeZoneDisplayed);
    }

    @When("user clicks on send button")
    public void user_clicks_on_send_button() {
        gelaEventPage.sendBtn.click();
    }


    @Then("user adds individual members {string}")
    public void user_adds_individual_members(String individualMember) {
        gelaEventPage.addPersonsGroupsOrDepartments.click();
        gelaEventPage.membersInput.sendKeys(individualMember, Keys.ENTER);
    }

    @Then("user adds groups {string}")
    public void user_adds_groups(String groups) {

        List<String> createdGroups = new ArrayList<>();

        createdGroups.add(groups);

        for (String group : createdGroups) {
            gelaEventPage.addPersonsGroupsOrDepartments.click();
            gelaEventPage.membersInput.sendKeys(group, Keys.ENTER);
        }
    }


    @When("user sets the reminder")
    public void user_sets_the_reminder() {
        //DropDowns
        Select eventReminderType = new Select(gelaEventPage.eventReminderType);


        //"Set reminder"  is already checked by default

        //set integer time
        gelaEventPage.eventReminderCount.sendKeys(Keys.chord(Keys.CONTROL, "a"), Keys.DELETE);
        gelaEventPage.eventReminderCount.sendKeys(ConfigurationReader.getProperty("eventReminderTimeInMinutes"));

        //set min/hr/day
        eventReminderType.selectByVisibleText(ConfigurationReader.getProperty("eventReminderType"));
    }


    @Then("the reminder is activated")
    public void the_reminder_is_activated() {

        gelaSidebarPage.clickOnEvent(eventName);

        String expectedEventReminderTimeInMinutes = ConfigurationReader.getProperty("eventReminderTimeInMinutes");
        String expectedEventReminderType = ConfigurationReader.getProperty("eventReminderType");
        String actualEventReminderType = gelaCalendarSliderSidebar.reminder.getText().replace("(", "").replace(")", "");

        // Create a SoftAssert object
        SoftAssert softAssert = new SoftAssert();

        // Check that the expected reminder time is contained in the actual reminder text
        softAssert.assertTrue(gelaCalendarSliderSidebar.reminder.getText().contains(expectedEventReminderTimeInMinutes));

        // Check that the expected reminder type is contained in the actual reminder type
        softAssert.assertTrue(actualEventReminderType.contains(expectedEventReminderType));
        System.out.println("actualEventReminderType = " + actualEventReminderType);

        //Assert all the soft assertions
        softAssert.assertAll();

        //Delete the event after the Assertion
        gelaEventPage.deleteEvent();
    }


    @Then("the reminder is activated reminder time {string} reminder type {string}")
    public void the_reminder_is_activated_reminder_time_reminder_type(String time, String type) {

        gelaSidebarPage.clickOnEvent(eventName);

        // remove any parentheses
        String actualEventReminderTypeAfterRemovingParenthesis = gelaCalendarSliderSidebar.reminder.getText().replace("(", "").replace(")", "");

        //Assertions, after the creation of the event, checks on Calendar Work area that reminder is activated and the values are correct

        // Check that the expected reminder time is contained in the actual reminder text
        Assert.assertTrue(gelaCalendarSliderSidebar.reminder.getText().contains(time));
        // Check that the expected reminder type is contained in the actual reminder type
        Assert.assertTrue("There is a typo: minite(s) instead of minute(s)", actualEventReminderTypeAfterRemovingParenthesis.contains(type));

        System.out.println("actualEventReminderType = " + gelaCalendarSliderSidebar.reminder.getText());


        //Delete the event after the Assertion
        gelaEventPage.deleteEvent();
    }

    @When("user sets the reminder time {int}")
    public void user_sets_the_reminder_time(int eventReminderTimeInMinutes) {


        //"Set reminder"  is already checked by default

        //set integer time
        gelaEventPage.eventReminderCount.sendKeys(Keys.chord(Keys.CONTROL, "a"), Keys.DELETE);
        gelaEventPage.eventReminderCount.sendKeys(String.valueOf(eventReminderTimeInMinutes));
    }

    @When("user sets the reminder time {string}")
    public void user_sets_the_reminder_time(String string) {
        gelaEventPage.eventReminderCount.sendKeys(Keys.chord(Keys.CONTROL, "a"), Keys.DELETE);
        gelaEventPage.eventReminderCount.sendKeys(String.valueOf(string));
    }

    @When("user sets the reminder type {string}")
    public void user_sets_the_reminder_type(String string) {
        //DropDowns
        Select eventReminderType = new Select(gelaEventPage.eventReminderType);

        //set min/hr/day
        eventReminderType.selectByVisibleText(string);
    }

    @Then("user is able to select the event location {string}")
    public void user_is_able_to_select_the_event_location(String eventLocation) {

        gelaSidebarPage.clickOnEvent(eventName);

        Assert.assertEquals(eventLocation, gelaEventPage.eventLocationText.getText());

        //Delete the event after the Assertion
        gelaEventPage.deleteEvent();
    }

    /**
     * Test Case 4.1: Verify that the user can select a location from the dropdown list.
     */

    @When("user selects the event location {string} from the dropdown")
    public void user_selects_the_event_location_from_the_dropdown(String eventLocation) {
        //gelaEventPage.eventLocation.click();
        gelaEventPage.eventLocation.sendKeys(eventLocation);
    }


    @Then("the event location {string} has been selected")
    public void the_event_location_has_been_selected(String eventLocation) {

        gelaSidebarPage.clickOnEvent(eventName);

        Assert.assertEquals(eventLocation, gelaEventPage.eventLocationText.getText());

        //Delete the event after the Assertion
        gelaEventPage.deleteEvent();
    }

    /**
     * Test Case 5.1: Verify that the user can select individual contacts to invite to the event.
     */

    @When("user selects individual contacts")
    public void user_selects_individual_contacts() {
        gelaEventPage.addPersonsGroupsOrDepartments.click();

        gelaEventPage.insertMembersByEmail(ConfigurationReader.getProperty("member1"));
        gelaEventPage.insertMembersByEmail(ConfigurationReader.getProperty("member2"));
        gelaEventPage.insertMembersByEmail(ConfigurationReader.getProperty("member3"));
        gelaEventPage.insertMembersByEmail(ConfigurationReader.getProperty("member4"));
    }

    @Then("individual contacts have been invited to the event")
    public void individual_contacts_have_been_invited_to_the_event() {
        //Click on Event from right sidebar
        gelaSidebarPage.clickOnEvent(eventName);

        try {
            WebDriverWait wait = new WebDriverWait(Driver.getDriver(), 10);
            WebElement moreAttendeesLink = wait.until(ExpectedConditions.elementToBeClickable(gelaCalendarSliderWorkareaPage.moreAttendeesLink));
            moreAttendeesLink.click();
        } catch (StaleElementReferenceException e) {
            System.err.println("Error: Stale element reference encountered: " + e.getMessage());
        } catch (TimeoutException e) {
            System.err.println("Error: Timeout occurred while waiting for element: " + e.getMessage());
        } catch (Exception e) {
            System.err.println("Error: " + e.getMessage());
        }

        Assert.assertEquals(ConfigurationReader.getProperty("member1"), gelaCalendarSliderWorkareaPage.insertedMemberByEmailIsDisplayed(ConfigurationReader.getProperty("member1")));
        Assert.assertEquals(ConfigurationReader.getProperty("member2"), gelaCalendarSliderWorkareaPage.insertedMemberByEmailIsDisplayed(ConfigurationReader.getProperty("member2")));
        Assert.assertEquals(ConfigurationReader.getProperty("member3"), gelaCalendarSliderWorkareaPage.insertedMemberByEmailIsDisplayed(ConfigurationReader.getProperty("member3")));
        Assert.assertEquals(ConfigurationReader.getProperty("member4"), gelaCalendarSliderWorkareaPage.insertedMemberByEmailIsDisplayed(ConfigurationReader.getProperty("member4")));

        //Delete the event after the Assertion
        gelaEventPage.deleteEvent();
    }

    @When("user selects departments")
    public void user_selects_departments() {

        gelaEventPage.addPersonsGroupsOrDepartments.click();

        gelaEventPage.employeesAndDepartments.click();

        gelaEventPage.selectDepartments("QA Department");
        gelaEventPage.selectDepartments("Catch The Bug");
        gelaEventPage.selectDepartments("Instructors Department");

    }

    @Then("selected departments have been invited to the event")
    public void selected_departments_have_been_invited_to_the_event() {

        gelaSidebarPage.clickOnEvent(eventName); //clicks and opens the event created from "UPCOMING EVENTS" sidebar
        gelaCalendarSliderWorkareaPage.editBtn.click(); //clicks on "EDIT" button in Calendar Slider Work area

        Assert.assertTrue(gelaCalendarSliderWorkareaPage.locateAttendees("QA Department").isDisplayed());
        Assert.assertTrue(gelaCalendarSliderWorkareaPage.locateAttendees("Catch The Bug").isDisplayed());
        Assert.assertTrue(gelaCalendarSliderWorkareaPage.locateAttendees("Instructors Department").isDisplayed());

        gelaCalendarSliderWorkareaPage.cancelBtn.click(); //clicks on cancel button

        gelaEventPage.activityStreamModule.click(); //goes to Activity Stream Module
        gelaSidebarPage.clickOnEvent(eventName); //clicks and opens the event created from "UPCOMING EVENTS" sidebar
        gelaEventPage.deleteEvent(); //deletes the event
    }

    /**
     * Test Case 8.1: Verify that the start and end dates are set to today's date by default.
     */
    @Then("that the start and end dates match to today's date")
    public void that_the_start_and_end_dates_match_to_today_s_date() {
        //gets the default start date from the event
        String actualDateFrom = BrowserUtils.waitForVisibility(gelaEventPage.calendarDateFrom, 10).getAttribute("value");
        //gets the default end date from the event

        String actualDateTo = BrowserUtils.waitForVisibility(gelaEventPage.calendarDateTo, 10).getAttribute("value");

        //returns the current date from the local machine
        String expectedDate = gelaEventPage.getCurrentDate();

        Assert.assertEquals(expectedDate, actualDateFrom);
        Assert.assertEquals(expectedDate, actualDateTo);
    }

    /**
     * Test Case 7.1: Verify that the user can cancel creating the event before sending.
     */
    @When("user clicks on cancel button")
    public void user_clicks_on_cancel_button() {
        //click on cancel button
        gelaEventPage.cancelBtn.click();
    }

    @Then("the even should be canceled")
    public void the_even_should_be_canceled() {
        Assert.assertFalse("The event name is displayed", gelaEventPage.eventNameField.isDisplayed());
    }

    @Then("the event should be created")
    public void the_event_should_be_created() {
        //checks if the last created event is displayed in upcoming events
        Assert.assertTrue(gelaSidebarPage.checkIfEventIsCreated(eventName));
        //clicks on events
        gelaSidebarPage.clickOnEvent(eventName);
        //deletes the event
        gelaEventPage.deleteEvent();
    }

    @Then("the event can't be created")
    public void the_event_can_t_be_created() {
        // to prove that the event has not been created, when not filling out the mandatory field "Event Name"
        //I will try to create an event without the "Event Name" and add event description only, in order to have
        //an element to Assert later

        Assert.assertFalse("The event has been created, without entering the \"Event Name\"", gelaInternalContainerPage.eventDescription.getText().contains(eventDescription));

        gelaSidebarPage.clickOnEvent("My event");
        gelaEventPage.deleteEvent();
    }


}
