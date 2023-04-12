package com.azulcrm.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class Gela_Activity_Stream_Top_Tabs_Page extends BasePage {

    /**
     * LOCATORS
     */
    @FindBy(xpath = "//span[@id='feed-add-post-form-tab-calendar']//span[contains(text(),'Event')]")
    public WebElement eventTab;
}
