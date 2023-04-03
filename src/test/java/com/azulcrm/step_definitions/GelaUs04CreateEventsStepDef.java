package com.azulcrm.step_definitions;

import com.azulcrm.pages.BasePage;
import com.azulcrm.pages.GelaLoginPage;
import com.azulcrm.utilities.BrowserUtils;
import com.azulcrm.utilities.ConfigurationReader;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;

public class GelaUs04CreateEventsStepDef {

    GelaLoginPage gelaLoginPage = new GelaLoginPage();

    @Given("the user logs in successfully")
    public void the_user_logs_in_successfully() {
        gelaLoginPage.goLoginPage();

        gelaLoginPage.loginInput.sendKeys(ConfigurationReader.getProperty("gelaTestUser"));
        gelaLoginPage.passInput.sendKeys(ConfigurationReader.getProperty("defaultPassword"));
        gelaLoginPage.loginBtn.click();
    }

    @When("user clicks on Activity Stream")
    public void user_clicks_on_activity_stream() {
        gelaLoginPage.activityStreamModule.click();
    }

    @When("user clicks on event")
    public void user_clicks_on_event() {
        gelaLoginPage.eventTab.click();
        BrowserUtils.waitFor(4);
    }
}
