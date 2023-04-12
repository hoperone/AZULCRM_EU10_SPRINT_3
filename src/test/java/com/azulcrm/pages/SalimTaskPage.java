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

    @FindBy(xpath = "//span[@class='task-item-index']")
    public WebElement OngoingTasksCount;

    @FindBy(xpath = "//a[.='TaskDemoRun']")
    public WebElement TaskDemoRunInList;

    @FindBy(id = "TASKS_GRID_ROLE_ID_4096_0_ADVANCED_N_check_all")
    public WebElement TaskCenterCheckAll;

    @FindBy(id = "action_button_TASKS_GRID_ROLE_ID_4096_0_ADVANCED_N_control")
    public WebElement SelectActionDropDown;

    @FindBy(xpath = "//span[.='Delete']")
    public WebElement DeleteInDropDown;

    @FindBy(id = "apply_button_control")
    public WebElement ApplyButtonInDropDown;

    @FindBy(id = "task-confirm-popup")
    public WebElement task_confirm_popup;

    @FindBy(xpath = "//span[@class='popup-window-button popup-window-button-accept']")
    public WebElement task_confirm_Continue;

    @FindBy(xpath = "//a[@class='js-id-tdp-mem-sel-is-open-form task-form-field-when-filled task-form-field-link add']")
    public WebElement AddMoreBtn;

    @FindBy(xpath = "//input[@class='js-id-tdp-mem-sel-is-search js-id-network-selector-search task-form-field-search task-form-field-input']")
    public WebElement AddMoreTextBox;

    @FindBy(id = "bx-component-scope-lifefeed_task_form-responsible")
    public WebElement AddMoreBox;

    @FindBy(xpath = "//span[@class='tasks-task-mpf-link']")
    public WebElement ChecklistLink;

    @FindBy(xpath = "//input[@class='js-id-checklist-is-form-title task-checklist-field-add']")
    public WebElement ChecklistThingsToDo;

    @FindBy(xpath = "//span[@class='js-id-checklist-is-form-submit block-edit tasks-btn-apply task-field-title-ok']")
    public WebElement ChecklistAcceptBtn;

    @FindBy(xpath = "//div[@class='task-checklist-field-inner']")
    public WebElement ChecklistFieldCreatedAndDisplayed;

    @FindBy(xpath = "//span[@class='js-id-checklist-is-i-delete task-field-title-del tasks-btn-delete']")
    public WebElement ChecklistFieldClearOut;

    @FindBy(xpath = "//input[@class='task-options-inp']")
    public WebElement DeadlineInputBox;

    @FindBy(xpath = "//a[@data-date='1681516800000']")
    public WebElement PickDate;

    @FindBy(xpath = "//span[@class='bx-calendar-button-text']")
    public WebElement DeadlineSelect;

    @FindBy(xpath = "//*[@id=\"bx-component-scope-lifefeed_task_form\"]/div/div[3]/div[2]/div/div[1]/span[1]/span/input[1]")
    public WebElement DeadlineDisplay;
}

