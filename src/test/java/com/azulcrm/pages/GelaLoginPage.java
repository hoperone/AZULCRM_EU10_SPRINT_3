package com.azulcrm.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class GelaLoginPage extends BasePage {

    //--Locators--
    @FindBy(name = "USER_LOGIN")
    public WebElement loginInput;

    @FindBy(name = "USER_PASSWORD")
    public WebElement passInput;

    @FindBy(className = "login-btn")
    public WebElement loginBtn;
}
