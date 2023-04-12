package com.azulcrm.pages;

import com.azulcrm.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.NoSuchElementException;

public class Gela_Calendar_Slider_Workarea_Page extends BasePage {

    /**
     * LOCATORS
     */
    @FindBy(xpath = "//input[@name='date_from']")
    public WebElement eventStartDate;

    @FindBy(css = ".calendar-planner-all-users")
    public WebElement moreAttendeesLink;

    @FindBy(xpath = "//input[@name='date_to']")
    public WebElement eventEndDate;

    @FindBy(xpath = "//button[@class='ui-btn ui-btn-light-border']")
    public WebElement editBtn;

    @FindBy(xpath = "//button[@class='ui-btn ui-btn-link']")
    public WebElement cancelBtn;

    @FindBy(css = "input[name='time_from']")
    public WebElement timeFrom;

    @FindBy(css = "input[name='time_to']")
    public WebElement timeTo;

    @FindBy(xpath = "//span[.='Time zone']")
    public WebElement timeZoneLink;

    @FindBy(xpath = "//select[@name='tz_from']")
    public WebElement timeZoneFrom;

    @FindBy(xpath = "//select[@name='tz_to']")
    public WebElement timeZoneTo;


    /**
     * METHODS
     */

    public String insertedMemberByEmailIsDisplayed(String email) {
        try {
            // Locate the span element using the email text
            WebDriverWait wait = new WebDriverWait(Driver.getDriver(), 10);
            WebElement emailSpan = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[contains(text(),'" + email + "')]")));

            // Return the extracted email string
            return emailSpan.getText();
        } catch (NoSuchElementException e) {
            // Log an error message if the element is not found
            System.err.println("Could not find email element: " + e.getMessage());
            return null; // Return null to indicate failure
        } catch (Exception e) {
            // Log any other exceptions that may occur
            System.err.println("Error occurred: " + e.getMessage());
            return null; // Return null to indicate failure
        }
    }

    public WebElement locateAttendees(String attendees) {
        return Driver.getDriver().findElement(By.xpath("//span[contains(text(),'" + attendees + "')]"));
    }

}
