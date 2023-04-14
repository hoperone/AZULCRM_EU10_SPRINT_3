package com.azulcrm.pages;

import com.azulcrm.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class EminMessagePage extends BasePage{
    public EminMessagePage(){
        PageFactory.initElements(Driver.getDriver(), this);}



    @FindBy(xpath = "//body[@contenteditable='true']")
    public WebElement messageInbox;

    @FindBy(xpath = "//span[@id='feed-add-post-form-tab-message']")
    public WebElement messageTab;

    @FindBy(xpath = "//*[@id=\"bx-b-link-blogPostForm\"]/span/i")
    public WebElement linkButton;

    @FindBy(xpath ="//input[@id=\"linkidPostFormLHE_blogPostForm-text\"]" )
    public WebElement linkInputText;

    @FindBy(xpath ="//input[@id=\"linkidPostFormLHE_blogPostForm-href\"]" )
    public WebElement linkInputURL;

    @FindBy(xpath = "//*[@id=\"undefined\"]")
    public WebElement saveButton;

    @FindBy(xpath = "//*[@id=\"blog-submit-button-save\"]")
    public WebElement sendMessageButton;

    @FindBy(xpath = "//a[.='CydeoLink']")
    public WebElement hyperlinkIsDisplayed;

    @FindBy(xpath = "//a[.='Add more']")
    public WebElement addMoreButton;

    @FindBy(xpath = "//*[@id=\"bx-b-video-blogPostForm\"]/span/i")
    public WebElement insertVideo;

    @FindBy(xpath = "//*[@id=\"video_idPostFormLHE_blogPostForm-source\"]")
    public WebElement videoSourceInbox;

    @FindBy(xpath = "//*[@id=\"bx-b-tag-input-blogPostForm\"]")
    public WebElement addTagButton;

    @FindBy(xpath = "//*[@id=\"TAGS_blogPostForm67abSn\"]")
    public WebElement addTagInbox;

    @FindBy(xpath = "//span[@class='popup-window-button']")
    public WebElement tagAddFinal;

    @FindBy(xpath = "//div[@id=\"post-tags-container-blogPostForm\"]/span[1]/span")
    public WebElement removeTag;

    @FindBy(xpath = "//*[@id=\"post-tags-container-blogPostForm\"]/span[1]/span")
    public WebElement addedTag;

    @FindBy(xpath = "/html/body/blockquote")
    public WebElement quoteInbox;

    @FindBy(xpath = "//*[@id=\"bx-b-quote-blogPostForm\"]/span/i")
    public WebElement quoteButton;

    @FindBy(xpath = "//*[contains(@id,\"blog_post_body\")]/div/table/tbody/tr/td")
    public WebElement quoteTextVerification;

    @FindBy(xpath = "//*[@id=\"bx-b-mention-blogPostForm\"]")
    public WebElement addMention;

    @FindBy(xpath = "//*[contains(@id,\"last_UA\")]/div[3]/div")
    public WebElement removeAllEmployees1;

    @FindBy(xpath = "//*[@id=\"feed-add-post-destination-item\"]/span/span[2]")
    public WebElement removeAllEmployees2;

    @FindBy(xpath = "//*[contains(@id,\"blogpost-tags\")]/a")
    public WebElement tagIsDisplayed;

    @FindBy(xpath = "//span[@class='feed-add-post-destination-text']")
    public WebElement addMore;

    @FindBy(xpath = "//a[.='Add more']")
    public WebElement toInbox;

    @FindBy(xpath = "//a[.='Add persons, groups or department']")
    public WebElement toInbox2;

    @FindBy(xpath = "//a[@class='bx-finder-box-tab bx-lm-tab-department']")
    public WebElement employeesAndDepartments;

    @FindBy(xpath = "//*[@id=\"bx-lm-box-last-content\"]/table/tr/td/div[3]/div[2]/div[3]/a/div[2]")
    public WebElement developerDepartment;

    @FindBy(xpath = "//*[@id=\"bx-lm-box-last-content\"]/table/tr/td/div[3]/div[2]/div[4]/a/span/div[2]")
    public WebElement developerDepartmentCheckBox;

    @FindBy(xpath = "//*[@id=\"bx-lm-box-last-content\"]/table/tr/td/div[3]/div[2]/div[5]/a/div[2]")
    public WebElement instructorDepartment;

    @FindBy(xpath = "//*[@id=\"bx-lm-box-last-content\"]/table/tr/td/div[3]/div[2]/div[6]/a/span/div[2]")
    public WebElement instructorDepartmentCheckBox;

    @FindBy(xpath = "//*[@id=\"bx-lm-box-last-content\"]/table/tr/td/div[3]/div[2]/div[7]/a/div[2]")
    public WebElement QADepartment;

    @FindBy(xpath = "//*[@id=\"bx-lm-box-last-content\"]/table/tr/td/div[3]/div[2]/div[8]/a/span/div[2]")
    public WebElement QADepartmentCheckBox;

    @FindBy(xpath = "//*[@id=\"bx-lm-box-last-content\"]/table/tr/td/div[3]/div[2]/div[9]/a/div[2]")
    public WebElement salesforceDepartment;

    @FindBy(xpath = "//*[@id=\"bx-lm-box-last-content\"]/table/tr/td/div[3]/div[2]/div[10]/a/span/div[2]")
    public WebElement salesforceDepartmentCheckBox;

    @FindBy(xpath = "//span[@class='popup-window-close-icon']")
    public WebElement popupWindowCloseIcon;

    @FindBy(xpath = "//iframe[@class='bx-editor-iframe']")
    public WebElement iFrameMessageBox;

    public void switchToIframe(){
        Driver.getDriver().switchTo().frame(iFrameMessageBox);
    }

    public void switchToParentFrame(){
        Driver.getDriver().switchTo().parentFrame();
    }



}









