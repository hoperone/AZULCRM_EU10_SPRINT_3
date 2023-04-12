package com.azulcrm.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class Gela_Calendar_Slider_Sidebar_Page extends BasePage {

    @FindBy(xpath = "//span[@class='calendar-slider-sidebar-remind-warning-name']")
    public WebElement reminder;
}
