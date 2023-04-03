package com.azulcrm.step_definitions;
import com.azulcrm.pages.LoginPage;
import com.azulcrm.pages.MessageTabPage;
import com.azulcrm.utilities.BrowserUtils;
import com.azulcrm.utilities.ConfigurationReader;
import com.azulcrm.utilities.Driver;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;

import java.util.List;
public class Jiranic3_US02_Message_StepDefinitions {
    MessageTabPage messageTabPage = new MessageTabPage();
    LoginPage loginPage = new LoginPage();

    @Given("user logs in successfully")
    public void user_logs_in_successfully() {
        loginPage.login(ConfigurationReader.getProperty("cananTestUser"),
                ConfigurationReader.getProperty("defaultPassword"));
    }
    @Given("user clicks Messages menu")
    public void user_clicks_messages_menu() {
        messageTabPage.messageTab.click();
    }
    @Given("user clicks upload file link")
    public void user_clicks_upload_file_link() {
        messageTabPage.uploadFilesLink.click();
    }

    @When("user uploads three files")
    public void user_uploads_three_files() throws InterruptedException{
        messageTabPage.uploadFilesAndImagesButton.sendKeys(
                ConfigurationReader.getProperty("path1") + "\n" +
                        ConfigurationReader.getProperty("path2") + "\n" +
                        ConfigurationReader.getProperty("path3"));

    }
    @Then("user sees three files attached")
    public void user_sees_three_files_attached() {
        Assert.assertTrue(messageTabPage.uploadedFile1.isDisplayed());
        Assert.assertTrue(messageTabPage.uploadedFile2.isDisplayed());
        Assert.assertTrue(messageTabPage.uploadedFile3.isDisplayed());
    }

    @When("user uploads a {string}")
    public void user_uploads_a(String file) {
        switch (file){
            case "png":
                messageTabPage.uploadFilesAndImagesButton.sendKeys(ConfigurationReader.getProperty("path1"));
                break;
            case "document":
                messageTabPage.uploadFilesAndImagesButton.sendKeys(ConfigurationReader.getProperty("path2"));
                break;
            case "textfile":
                messageTabPage.uploadFilesAndImagesButton.sendKeys(ConfigurationReader.getProperty("path3"));
                break;
            case "jpeg":
                messageTabPage.uploadFilesAndImagesButton.sendKeys(ConfigurationReader.getProperty("path4"));
                break;
        }
    }

    @Then("user sees the {string} attached")
    public void user_sees_the_file_attached(String file) {
        switch (file){
            case "png":
                Assert.assertTrue(messageTabPage.uploadedFile1.isDisplayed());
                break;
            case "document":
                Assert.assertTrue(messageTabPage.uploadedFile2.isDisplayed());
                break;
            case "textfile":
                Assert.assertTrue(messageTabPage.uploadedFile3.isDisplayed());
                break;
            case "jpeg":
                Assert.assertTrue(messageTabPage.uploadedFile4.isDisplayed());
                break;
        }

    }

    @When("user uploads a file")
    public void user_uploads_a_file() {
        messageTabPage.uploadFilesAndImagesButton.sendKeys(ConfigurationReader.getProperty("path1"));
    }

    @And("user clicks Send button")
    public void userClicksSendButton() {
        messageTabPage.sendButton.click();
    }




    @And("user clicks Insert in text button")
    public void userClicksInsertInTextButton() {
        messageTabPage.insertInTextButton.click();
    }


    @Then("user sees the {string} on message area")
    public void userSeesTheFileOnMessageArea(String file) {

        messageTabPage.switchToMessageIframe();
        switch (file){
            case "document":
                Assert.assertTrue(messageTabPage.fileTextInMessageBody.isDisplayed());
                break;
            case "png":
                BrowserUtils.waitForVisibility(messageTabPage.pictureInMessageBody, 10);
                Assert.assertTrue(messageTabPage.pictureInMessageBody.isDisplayed());
        }


    }

    @Then("picture is displayed on activity stream")
    public void pictureIsDisplayedOnActivityStream() throws InterruptedException {
        BrowserUtils.waitForVisibility(messageTabPage.pictureDisplayedOnActivityStream, 10);
        Assert.assertTrue(messageTabPage.pictureDisplayedOnActivityStream.isDisplayed());
        Thread.sleep(5000);
    }

    @And("user selects Allow a recipient to edit documents checkbox")
    public void userSelectsAllowARecipientToEditDocumentsCheckbox() throws InterruptedException {
        messageTabPage.allowEditCheckbox.click();

    }

    @Then("Allow to edit checkbox is selected")
    public void allowToEditCheckboxIsSelected() {
        Assert.assertTrue(messageTabPage.allowEditCheckbox.isSelected());
    }

    @Then("Allow to edit checkbox is unselected")
    public void allowToEditCheckboxIsUnselected() {
        Assert.assertFalse(messageTabPage.allowEditCheckbox.isSelected());
    }

    @And("user clicks delete sign next to file")
    public void userClicksDeleteSignNextToFile() {
        messageTabPage.deleteButton.click();
    }

    @Then("file is removed from screen")
    public void fileIsRemovedFromScreen() {
        List<WebElement> elements = messageTabPage.findElementsInPreviewArea();
        Assert.assertEquals(0, elements.size());
    }

    @When("user hover over file name")
    public void user_hover_over_file_name() throws InterruptedException {
        BrowserUtils.hover(messageTabPage.fileNameText);
    }
    @When("user clicks pencil sign")
    public void user_clicks_pencil_sign() {
        messageTabPage.fileNameEditButton.click();
    }
    @When("user changes file name and clicks pencil sign")
    public void user_changes_file_name_and_clicks_pencil_sign() throws InterruptedException {
        messageTabPage.fileNameEditBox.clear();
        BrowserUtils.hover(messageTabPage.fileNameText);
        messageTabPage.fileNameEditButton.click();
        messageTabPage.fileNameEditBox.sendKeys("new file" + Keys.ENTER);

    }
    @Then("file name is changed")
    public void file_name_is_changed() {
        Assert.assertTrue(messageTabPage.fileNameText.getText().contains("new file"));
    }
}
