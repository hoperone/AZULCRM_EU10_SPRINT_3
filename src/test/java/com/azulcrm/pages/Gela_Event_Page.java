package com.azulcrm.pages;

import com.azulcrm.utilities.Driver;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.LocalDateTime;


public class Gela_Event_Page extends BasePage {

    /**
     * LOCATORS
     */
    @FindBy(xpath = "//input[@placeholder='Event name']")
    public WebElement eventNameField;


    @FindBy(xpath = "//input[@name='DATE_FROM']")
    public WebElement calendarDateFrom;

    @FindBy(xpath = "//input[@name='DATE_TO']")
    public WebElement calendarDateTo;

    @FindBy(id = "blog-submit-button-save")
    public WebElement sendBtn;

    @FindBy(xpath = "//button[@id='blog-submit-button-cancel']")
    public WebElement cancelBtn;

    //Time Locators
    @FindBy(xpath = "//input[@name='TIME_FROM_']")
    public WebElement timeFrom;

    @FindBy(xpath = "//input[@name='TIME_TO_']")
    public WebElement timeTo;

    @FindBy(xpath = "//input[@name='EVENT_FULL_DAY']")
    public WebElement eventFullDayCheckBox;

    @FindBy(xpath = "//span[@class='feed-ev-tz-open']")
    public WebElement specifyTimeZone;

    @FindBy(id = "feed-cal-tz-fromcal_3Jcl")
    public WebElement timeZoneFromDropdown;

    @FindBy(id = "feed-cal-tz-tocal_3Jcl")
    public WebElement timeZoneToDropdown;

    @FindBy(css = "input[name='EVENT_REMIND_COUNT']")
    public WebElement eventReminderCount;

    @FindBy(css = "select[name='EVENT_REMIND_TYPE']")
    public WebElement eventReminderType;

    @FindBy(xpath = "//input[@name='EVENT_LOCATION']")
    public WebElement eventLocation;

    @FindBy(xpath = "//a[@id='feed-event-dest-add-link']")
    public WebElement addPersonsGroupsOrDepartments;

    @FindBy(xpath = "//a[@class='bx-finder-box-tab bx-lm-tab-department']")
    public WebElement employeesAndDepartments;

    @FindBy(xpath = "//div[@class='feed-event-destination-wrap']//input[@type='text']")
    public WebElement membersInput;


    //Locators from already created Event
    @FindBy(xpath = "//button[@class='ui-btn ui-btn-link']")
    public WebElement deleteButton;

    @FindBy(xpath = "//div[@class='calendar-slider-detail-place-name']")
    public WebElement eventLocationText;


    /**
     * METHODS
     */

    //returns the current time plus custom minutes
    public String getCurrentTimePlusCustomMinutes(Long minutes) {
        // get the current time
        LocalDateTime now = LocalDateTime.now();

        // add 1 hour
        LocalDateTime plusOneHour = now.plusMinutes(minutes);

        // format the date into "08:00 pm" format
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("h:mm a");
        String formattedDateTime = plusOneHour.format(formatter);

        return formattedDateTime.toLowerCase();
    }

    //returns current date in "MM/dd/yyyy" Format
    public String getCurrentDate() {
        // get the current date
        LocalDate currentDate = LocalDate.now();

        // create a formatter for the desired format
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MM/dd/yyyy");


        // print the current date string
        return currentDate.format(formatter);
    }

    //Delete the event
    public void deleteEvent() {
        deleteButton.click();
        Alert alert = Driver.getDriver().switchTo().alert();
        alert.accept();
    }

    public void insertMembersByEmail(String memberEmail) {
        membersInput.sendKeys(memberEmail);
        WebElement emailFound = Driver.getDriver().findElement(By.xpath("//div[contains(text(),'" + memberEmail + "')]"));
        emailFound.click();
    }

    public void selectDepartments(String department) {

        WebElement topDepartment = Driver.getDriver().findElement(By.xpath("//div[contains(text(),'" + department + "')]"));

        WebElement selectDepartment = Driver.getDriver().findElement(By.xpath("//div[contains(@rel,'" + department + ": All department and subdepartment employees')]"));

        topDepartment.click();

        selectDepartment.click();
    }

    //enters random description from Java faker into events description field after switching to an iframe and then back to default content
    public void enterDescription(String randomDescription) {

        // Locate the iframe using xpath
        WebElement iframe = Driver.getDriver().findElement(By.xpath("//div[@id='bx-html-editor-iframe-cnt-oCalEditorcal_3Jcl']//iframe[@class='bx-editor-iframe']"));

        // Switch to the iframe
        WebDriverWait wait = new WebDriverWait(Driver.getDriver(), 10);
        wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(iframe));

        // Enter text into the body of the iframe
        WebElement body = Driver.getDriver().findElement(By.tagName("body"));
        body.sendKeys(randomDescription);

        // Switch back to the main frame
        Driver.getDriver().switchTo().defaultContent();

    }

}


