package com.azulcrm.pages;

import com.azulcrm.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class Tugba_employee_page {
    public Tugba_employee_page(){
        PageFactory.initElements(Driver.getDriver(),this);
    }
    @FindBy(xpath = "//a[@title='Employees']")
    public WebElement employeesMenu;

    @FindBy(xpath ="//span[text()='Find Employee']")
    public WebElement findEmployeeButton;



    @FindBy(xpath = "//span[text()='Inactive']")
    public WebElement inactiveButton ;

    @FindBy(xpath = "//span[text()='Search By Alphabet']")
    public WebElement searchByAlphabet ;

     @FindBy(xpath = "//a[text()='D']")
    public WebElement letterD ;

     @FindBy(id="user-fio")
    public WebElement searchBox;



     @FindBy(xpath = "//a[@class='employee-name-link']")
    public WebElement searchResult ;

     @FindBy(xpath = "//div[@class='employee-state']")
    public List<WebElement> inactiveEmployeeList ;

     @FindBy(id="employee-table")
    public WebElement employeeTable ;

}
