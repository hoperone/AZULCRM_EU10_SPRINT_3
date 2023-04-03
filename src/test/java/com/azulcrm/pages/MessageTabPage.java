package com.azulcrm.pages;

import com.azulcrm.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;
public class MessageTabPage extends BasePage {


    @FindBy(xpath = "//span[@id='feed-add-post-form-tab-message']")
    public WebElement messageTab;

    @FindBy(xpath = "//span[@id='bx-b-uploadfile-blogPostForm']")
    public WebElement uploadFilesLink;

    @FindBy(xpath = "//input[@name='bxu_files[]']")
    public WebElement uploadFilesAndImagesButton;

    @FindBy(xpath = "//button[@id='blog-submit-button-save']")
    public WebElement sendButton;

    @FindBy(xpath = "//span[@class='del-but']")
    public WebElement deleteButton;


    @FindBy(xpath = "(//input[@id='diskuf-edit-rigths-doc'])[1]")
    public WebElement allowEditCheckbox;

    @FindBy(xpath = "//span[@class='insert-btn']")
    public WebElement insertInTextButton;

    @FindBy(xpath = "//span[@title='Click to insert file']")
    public WebElement fileNameText;

    @FindBy(xpath = "//input[@class='files-name-edit-inp']")
    public WebElement fileNameEditBox;

    @FindBy(xpath = "//span[@class='files-name-edit-btn']")
    public WebElement fileNameEditButton;

    @FindBy(xpath = "//body[@contenteditable='true']")
    public WebElement messageContentArea;

    @FindBy(xpath = "//table[@class='files-list']//span[contains(text(),'picture')]")
    public WebElement uploadedFile1;

    @FindBy(xpath = "//table[@class='files-list']//span[contains(text(),'document')]")
    public WebElement uploadedFile2;

    @FindBy(xpath = "//table[@class='files-list']//span[contains(text(),'textfile')]")
    public WebElement uploadedFile3;
    @FindBy(xpath = "//table[@class='files-list']//span[contains(text(),'flower')]")
    public WebElement uploadedFile4;

    @FindBy(xpath = "//div[@id='log_internal_container']//div[@class='feed-item-wrap']//img[contains(@data-bx-title, 'picture')]")
    public WebElement pictureDisplayedOnActivityStream;

    @FindBy(xpath = "//iframe[@class='bx-editor-iframe']")
    public WebElement iFrameMessageBody;

    @FindBy(xpath = "//span[contains(text(), 'document')]")
    public WebElement fileTextInMessageBody;

    @FindBy(xpath = "//img[contains(@src, 'filename=picture')]")
    public WebElement pictureInMessageBody;

    @FindBy(xpath = "//span[@class='files-preview-alignment']//img")
    public WebElement fileInPreviewArea;

    public void switchToMessageIframe(){
        Driver.getDriver().switchTo().frame(iFrameMessageBody);
    }

    public List<WebElement> findElementsInPreviewArea(){
        return Driver.getDriver().findElements(By.xpath("//span[@class='files-preview-alignment']//img"));
    }

    public void hoverOverFile(WebElement element){
        Actions actions = new Actions(Driver.getDriver());
        actions.moveToElement(element).perform();
    }







}

