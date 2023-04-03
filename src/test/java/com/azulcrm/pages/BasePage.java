package com.azulcrm.pages;

import com.azulcrm.utilities.Driver;
import com.azulcrm.utilities.*;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public abstract class BasePage {

    BasePage(){
        PageFactory.initElements(Driver.getDriver(), this);
    }

    //--Locators--
    @FindBy(xpath = "//span[normalize-space()='Activity Stream']")
    public WebElement activityStreamModule;

    @FindBy(xpath = "//span[@id='feed-add-post-form-tab-calendar']//span[contains(text(),'Event')]")
    public WebElement eventTab;


    //--Methods--

    //Returns page title
    public String getPageTitle(){
        return Driver.getDriver().getTitle();
    }

    //Opens login Page
    public void goLoginPage(){
        Driver.getDriver().get(ConfigurationReader.getProperty("qa.web.url"));
    }



}
