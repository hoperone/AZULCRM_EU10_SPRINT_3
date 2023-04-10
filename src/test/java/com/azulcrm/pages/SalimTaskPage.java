package com.azulcrm.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;


public class SalimTaskPage extends BasePage {

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

        @FindBy(xpath = "//div[.='Task has been created']")
        public WebElement Task_created_PopUp;

        @FindBy(xpath = "//span[.='Ongoing']")
        public WebElement OngoingTasks;

        @FindBy(xpath = "//a[.='TaskDemoRun']")
        public WebElement TaskDemoRunInList;

        @FindBy(id="TASKS_GRID_ROLE_ID_4096_0_ADVANCED_N_check_all")
        public WebElement TaskCenterCheckAll;

        @FindBy(id="action_button_TASKS_GRID_ROLE_ID_4096_0_ADVANCED_N_control")
        public WebElement SelectActionDropDown;

        @FindBy ( xpath = "//span[.='Delete']")
        public WebElement DeleteInDropDown;

        @FindBy(id="apply_button_control")
        public WebElement ApplyButtonInDropDown;

        @FindBy(id="task-confirm-popup")
        public WebElement task_confirm_popup;

        @FindBy(xpath="//span[@class='popup-window-button popup-window-button-accept']")
        public WebElement task_confirm_Continue;



    }

