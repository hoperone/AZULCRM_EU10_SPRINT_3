package com.azulcrm.step_definitions;

/*
In the class we will be able to pass pre- & post- conditions to
 each scenario and each step
 */

import com.azulcrm.pages.Gela_Activity_Stream_Top_Tabs_Page;
import com.azulcrm.pages.Gela_Login_Page;
import com.azulcrm.utilities.*;
import io.cucumber.java.*;
import io.cucumber.java.Scenario;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

public class Hooks {
    Gela_Login_Page gelaLoginPage = new Gela_Login_Page();
    Gela_Activity_Stream_Top_Tabs_Page gelaActivityStreamTopTabs = new Gela_Activity_Stream_Top_Tabs_Page();

    //import from io.cucumber.java not from junit
//    @Before (order = 1)
    public void setupScenario() {
        System.out.println("====Setting up browser using cucumber @Before");
    }

    @Before(value = "@login", order = 2)
    public void gelaSetupScenarioForLogins() {
        gelaLoginPage.goLoginPage();

        gelaLoginPage.loginInput.sendKeys(ConfigurationReader.getProperty("gelaTestUser"));
        gelaLoginPage.passInput.sendKeys(ConfigurationReader.getProperty("defaultPassword"));
        gelaLoginPage.loginBtn.click();

        gelaActivityStreamTopTabs.eventTab.click();
    }

    //@Before (value = "@db", order = 0)
    public void setupForDatabaseScenarios() {
        System.out.println("====this will only apply to scenarios with @db tag");
    }


    @After
    public void teardownScenario(Scenario scenario) {

        //scenario.isFailed() --> if scenario fails this method will return TRUE boolean value


        if (scenario.isFailed()) {

            byte[] screenshot = ((TakesScreenshot) Driver.getDriver()).getScreenshotAs(OutputType.BYTES);
            scenario.attach(screenshot, "image/png", scenario.getName());

        }


        //BrowserUtils.sleep(5);
        Driver.closeDriver();

        //System.out.println("====Closing browser using cucumber @After");
        //System.out.println("====Scenario ended/ Take screenshot if failed!");
    }

    // @BeforeStep
    public void setupStep() {
        System.out.println("--------> applying setup using @BeforeStep");
    }

    //@AfterStep
    public void afterStep() {
        System.out.println("--------> applying tearDown using @AfterStep");
    }


}
