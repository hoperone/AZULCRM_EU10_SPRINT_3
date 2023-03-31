package com.azulcrm.pages;

import com.azulcrm.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public abstract class BasePage {

    BasePage(){
        PageFactory.initElements(Driver.getDriver(), this);
    }

    //--Locators--



    //--Methods--
    public String getPageTitle(){
        return Driver.getDriver().getTitle();
    }



}
