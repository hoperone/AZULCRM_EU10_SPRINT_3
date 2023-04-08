package com.azulcrm.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;


public class SalimTaskPage {

        @FindBy(xpath = "//span[.='Task']/span")
        public WebElement taskTab;

        @FindBy(xpath = " //input[@id='tasks-task-priority-cb']")
        public WebElement highPriorityCheckBox;

        @FindBy(xpath = " //div[@id='bx-component-scope-lifefeed_task_form-responsible']")
        public WebElement responsiblePersonBox;

        @FindBy(xpath = " //input[@data-bx-id='task-edit-title']")
        public WebElement thingsToDo;

        @FindBy(xpath = " //button[@id='blog-submit-button-save']")
        public WebElement sendBtn;

        @FindBy(xpath = " //span[@class='task-item-index']")
        public WebElement ongoingPre;

        @FindBy(xpath = " //span[@class='task-item-index']")
        public WebElement ongoingAfter;
    }

