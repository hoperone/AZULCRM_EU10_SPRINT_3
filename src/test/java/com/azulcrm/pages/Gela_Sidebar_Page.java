package com.azulcrm.pages;

import com.azulcrm.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class Gela_Sidebar_Page extends BasePage {


    /**
     * METHODS
     */
    //clicks on last created event in upcoming events
    public void clickOnEvent(String eventName) {
        //go to last created event
        WebElement calendarItemLink = Driver.getDriver().findElement(By.xpath("//span[contains(text(),'" + eventName + "')]"));
        calendarItemLink.click();
    }

    //checks if the last created event is displayed in upcoming events
    public boolean checkIfEventIsCreated(String eventName) {
        //go to last created event
        WebElement calendarItemLink = Driver.getDriver().findElement(By.xpath("//span[contains(text(),'" + eventName + "')]"));
        return calendarItemLink.isDisplayed();
    }
}



