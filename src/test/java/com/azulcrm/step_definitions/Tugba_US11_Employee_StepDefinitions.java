package com.azulcrm.step_definitions;

import com.azulcrm.pages.LoginPage;
import com.azulcrm.pages.Tugba_employee_page;
import com.azulcrm.utilities.ConfigurationReader;
import com.azulcrm.utilities.Driver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;

public class Tugba_US11_Employee_StepDefinitions {
    LoginPage loginPage = new LoginPage();
    Tugba_employee_page employeePage = new Tugba_employee_page();

    @Given("User logs in successfully")
    public void user_logs_in_successfully() {
        Driver.getDriver().get("https://qa.azulcrm.com");
        loginPage.login(ConfigurationReader.getProperty("tugbaTestUser"),ConfigurationReader.getProperty("defaultPassword"));
    }
    @Given("User clicks on Employee menu")
    public void user_clicks_on_employee_menu() {
        employeePage.employeesMenu.click();

    }
    @Given("user clicks on Find Employee menu")
    public void user_clicks_on_find_employee_menu() {
        employeePage.findEmployeeButton.click();

    }
    @Then("user can see Employee list")
    public void user_can_see_employee_list() {
        Assert.assertTrue(employeePage.employeeTable.isDisplayed());

    }
    @When("user clicks inactive button")
    public void user_clicks_inactive_button() throws InterruptedException {
        employeePage.inactiveButton.click();
        Thread.sleep(1000);

    }
    @Then("user can see inactive employees list")
    public void user_can_see_inactive_employees_list() {
        for (WebElement each : employeePage.inactiveEmployeeList) {
            Assert.assertEquals("offline",each.getText());
        }

    }
    @When("user clicks search by alphabet button")
    public void user_clicks_search_by_alphabet_button() {
        employeePage.searchByAlphabet.click();
    }
    @When("user clicks a letter from list")
    public void user_clicks_a_letter_from_list() throws InterruptedException {
        employeePage.letterD.click();
        Thread.sleep(1000);

    }
    @Then("user can see selected employees on the list")
    public void user_can_see_selected_employees_on_the_list() {

        String actualSearchResult = employeePage.searchResult.getText();

        char c = actualSearchResult.charAt(actualSearchResult.indexOf(" ") + 1);
        System.out.println(actualSearchResult);
        System.out.println(c);
        Assert.assertTrue(c=='D');


    }
    @When("user enters a name on search box")
    public void user_enters_a_name_on_search_box() {
        employeePage.searchBox.sendKeys("Johnny"+ Keys.ENTER);
    }
    @When("user clicks search icon")
    public void user_clicks_search_icon() {
        //employeePage.iconButton.click();

    }
    @Then("user can see searched employees on the list")
    public void user_can_see_searched_employees_on_the_list() {
        String actualSearchResult = employeePage.searchResult.getText();
        System.out.println(actualSearchResult);
        Assert.assertTrue(actualSearchResult.contains("Johnny"));

    }






}
