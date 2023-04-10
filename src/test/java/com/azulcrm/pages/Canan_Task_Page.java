package com.azulcrm.pages;

import com.azulcrm.utilities.BrowserUtils;
import com.azulcrm.utilities.Driver;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class Canan_Task_Page {

    MessageTabPage messageTabPage = new MessageTabPage();
    public Canan_Task_Page(){
        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy(xpath = "//span[@id='feed-add-post-form-tab-tasks']")
    public WebElement taskMenuTab;

    @FindBy(xpath = "//input[@data-bx-id='task-edit-title']")
    public WebElement thingsToDoInputBox;

    @FindBy(xpath = "//input[@data-bx-id='task-edit-priority-cb']")
    public WebElement highPriorityCheckbox;


    @FindBy(xpath = "//div[@class='task-message-label error']")
    public WebElement errorMessage;

    @FindBy(xpath = "(//span[@title='Cancel selection'])[1]")
    public WebElement cancelResponsiblePersonIcon;

    @FindBy(xpath = "(//div[@id='bx-component-scope-lifefeed_task_form-responsible']//a)[2]")
    public WebElement addMoreLink;

    @FindBy(xpath = "//a[text()='Employees and departments']")
    public WebElement employeesAndDepartmentsLink;

    @FindBy(xpath = "//div[text()='marketing7@cybertekschool.com']")
    public WebElement marketing7UserLink;

    @FindBy(xpath = "//div[text()='helpdesk22@cybertekschool.com']")
    public WebElement helpdesk22UserLink;

    @FindBy(xpath = "//div[text()='helpdesk23@cybertekschool.com']")
    public WebElement helpdesk23UserLink;

    @FindBy(xpath = "//span[@class='popup-window-close-icon']")
    public WebElement peoplePopUpWindowCloseIcon;

    @FindBy(xpath = "//div[@id='blogPostEditCreateTaskPopup_content']")
    public WebElement taskCreatedPopupMessage;

    @FindBy(xpath = "//span[@class='popup-window-close-icon']")
    public WebElement taskCreatedPopupMessageCloseIcon;

    @FindBy(xpath = "//a[@title='Tasks']")
    public WebElement tasksLeftMenu;

    @FindBy(xpath = "//a[text()='canan verification task']")
    public WebElement taskItemUnderMyTasksTable;

    @FindBy(xpath = "//a[text()='canan verification task']/..//span[@class='task-priority-high']")
    public WebElement highPriorityIconUnderMyTasksTable;

    @FindBy(xpath = "//a[text()='canan verification task']/../../preceding::td[2]//input")
    public WebElement checkboxOfCreatedTaskUnderMyTasksTable;

    @FindBy(xpath = "//span[@id='action_button_TASKS_GRID_ROLE_ID_4096_0_ADVANCED_N']")
    public WebElement selectActionButton;

    @FindBy(xpath = "//span[@data-value='delete']")
    public WebElement deleteOptionUnderSelectActionDropdown;

    @FindBy(xpath = "//span[@id='apply_button_control']")
    public WebElement applyButtonUnderMyTasksTable;

    @FindBy(xpath = "//span[text()='Continue']")
    public WebElement continueButtonForDeleteOption;

    @FindBy(xpath = "//span[text()='Checklist']")
    public WebElement checklistLink;

    @FindBy(xpath = "//input[@class='js-id-checklist-is-form-title task-checklist-field-add']")
    public WebElement checklistInputBox;

    @FindBy(xpath = "//span[text()='add']")
    public WebElement checklistAddButton;

    @FindBy(xpath = "//label[@class='block-read task-checklist-field-label']")
    public WebElement newCreatedChecklistItem;

    @FindBy(xpath = "//span[@data-bx-id='dateplanmanager-deadline']//input[@data-bx-id='datepicker-display']")
    public WebElement deadlinePicker;

    @FindBy(xpath = "//a[@class='bx-calendar-top-month']")
    public WebElement monthPicker;

    @FindBy(xpath = "//span[@data-bx-month='3']")
    public WebElement monthApril;
    @FindBy(xpath = "//span[@data-bx-month='4']")
    public WebElement monthMay;

    @FindBy(xpath = "//span[@data-bx-month='5']")
    public WebElement monthJune;

    @FindBy(xpath = "//a[@class='bx-calendar-top-year']")
    public WebElement yearPicker;

    @FindBy(xpath = "//span[@data-bx-year='2023']")
    public WebElement year2023;

    @FindBy(xpath = "//span[@data-bx-year='2024']")
    public WebElement year2024;

    @FindBy(xpath = "//span[@data-bx-year='2025']")
    public WebElement year2025;

    @FindBy(xpath = "//div[@class='bx-calendar-range']//a[text()='1']")
    public WebElement day1;

    @FindBy(xpath = "//div[@class='bx-calendar-range']//a[text()='2']")
    public WebElement day2;
    @FindBy(xpath = "//div[@class='bx-calendar-range']//a[text()='31']")
    public WebElement day31;

    @FindBy(xpath = "//input[@class='bx-calendar-form-input'][1]")
    public WebElement hourInputBox;

    @FindBy(xpath = "//span[@class='bx-calendar-form-arrow-l']//a[@class='bx-calendar-form-arrow bx-calendar-form-arrow-top']")
    public WebElement hourTopArrow;
    @FindBy(xpath = "//span[@class='bx-calendar-form-arrow-l']//a[@class='bx-calendar-form-arrow bx-calendar-form-arrow-bottom']")
    public WebElement hourBottomArrow;


    @FindBy(xpath = "//input[@class='bx-calendar-form-input'][2]")
    public WebElement minuteInputBox;

    @FindBy(xpath = "//span[@class='bx-calendar-form-arrow-r']//a[@class='bx-calendar-form-arrow bx-calendar-form-arrow-top']")
    public WebElement minuteTopArrow;
    @FindBy(xpath = "//span[@class='bx-calendar-form-arrow-r']//a[@class='bx-calendar-form-arrow bx-calendar-form-arrow-bottom']")
    public WebElement minuteBottomArrow;

    @FindBy(xpath = "//span[@class='bx-calendar-AM-PM-block']")
    public WebElement amPmSelector;

    @FindBy(xpath = "//span[@class='bx-calendar-AM-PM-text']")
    public WebElement amPmText;

    @FindBy(xpath = "//span[text()='Select']")
    public WebElement calenderSelectButton;

    @FindBy(xpath = "//span[@data-bx-id='dateplanmanager-deadline']//input[@data-bx-id='datepicker-value']")
    public WebElement selectedDeadlineValue;   //verify value attribute is expected

    @FindBy(xpath = "//span[text()='Time planning']")
    public WebElement timePlanningLink;

    @FindBy(xpath = "//span[@data-bx-id='dateplanmanager-start-date-plan']//input[@data-bx-id='datepicker-display']")
    public WebElement startTaskOnPicker;

    @FindBy(xpath = "//input[@data-bx-id='dateplanmanager-duration']")
    public WebElement durationInputBox;

    @FindBy(xpath = "//span[@data-unit='days']")
    public WebElement durationDaysOption;

    @FindBy(xpath = "//span[@data-bx-id='dateplanmanager-end-date-plan']//input[@data-bx-id='datepicker-value']")
    public WebElement finishDateInputBox;  //verify its value attribute is expected


//-------methods

    public void addResponsiblePerson(List<String> people){
        addMoreLink.click();
        employeesAndDepartmentsLink.click();


        for (String person : people) {
            if (person.contains("marketing7"))
                BrowserUtils.clickWithJS(marketing7UserLink);
            else if (person.contains("helpdesk22"))
                BrowserUtils.clickWithJS(helpdesk22UserLink);
            else if (person.contains("helpdesk23"))
                BrowserUtils.clickWithJS(helpdesk23UserLink);
        }
        peoplePopUpWindowCloseIcon.click();
    }

    public void addResponsiblePerson(WebElement person){
        addMoreLink.click();
        employeesAndDepartmentsLink.click();
        BrowserUtils.clickWithJS(person);
        peoplePopUpWindowCloseIcon.click();
    }

    public void selectMonth(String month) throws InterruptedException {
       BrowserUtils.waitForClickablility(monthPicker, 10);
        monthPicker.click();
        Thread.sleep(500);
        switch (month){
            case "April":
                monthApril.click();
                Thread.sleep(500);
                break;
            case "May":
                monthMay.click();
                Thread.sleep(500);
                break;
            case "June":
                monthJune.click();
                Thread.sleep(1000);
                break;


        }
    }

    public void selectYear(String year) throws InterruptedException {
        BrowserUtils.waitForClickablility(yearPicker, 10);
        yearPicker.click();
        Thread.sleep(500);
        switch (year){
            case "2023":
                year2023.click();
                Thread.sleep(1000);
                break;
            case "2024":
                year2024.click();
                Thread.sleep(1000);
                break;
            case "2025":
                year2025.click();
                Thread.sleep(1000);
                break;

        }
    }

    public void selectDay(String day) throws InterruptedException {

        switch (day){
            case "1":
                day1.click();
                Thread.sleep(500);
                break;
            case "2":
                day2.click();
                Thread.sleep(500);
                break;
            case "31":
                day31.click();
                Thread.sleep(500);
                break;

        }
    }

    public void selectHour(String hour) throws InterruptedException {

        int actualHour = Integer.parseInt(hourInputBox.getAttribute("value"));
        System.out.println("actualHour = " + actualHour);
        int expectedHour = Integer.parseInt(hour);

        if (actualHour>expectedHour){
            int count = actualHour - expectedHour;
            for (int i = 0; i < count; i++) {
                hourBottomArrow.click();
            }
        } else if (actualHour<expectedHour) {
            int count = expectedHour-actualHour;
            for (int i = 0; i < count; i++) {
                hourTopArrow.click();
            }
        }

    }

    public void selectMinute(String minute) throws InterruptedException {
        BrowserUtils.waitForClickablility(minuteInputBox, 10);
        minuteInputBox.sendKeys(minute);
        Thread.sleep(500);
    }
    public void selectAmPm(String amPm){
        String actualAmPm = amPmText.getText();
        if (!actualAmPm.equals(amPm))
            amPmSelector.click();
    }

    public void assignHighPriorityTask(){
        thingsToDoInputBox.sendKeys("canan verification task");
        highPriorityCheckbox.click();
        addResponsiblePerson(marketing7UserLink);
        messageTabPage.sendButton.click();
        BrowserUtils.waitForVisibility(taskCreatedPopupMessageCloseIcon, 5);
        taskCreatedPopupMessageCloseIcon.click();
    }










}
