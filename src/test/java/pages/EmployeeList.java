package pages;

import Extensions.UiElementExtension;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;

public class EmployeeList {

    private WebDriver driver;
    public EmployeeList(WebDriver driver){
        this.driver = driver;
    }

    UiElementExtension element;
    private By CreateNewEmployeeButton = By.xpath("//a[@href='/Employee/Create']");
    private By empName = By.id("Name");
    private By empAge = By.id("Age");
    private By empSalary = By.id("Salary");
    private By empDurationWorked = By.id("DurationWorked");
    private By empGrade = By.id("Grade");
    private By empEmail = By.id("Email");
    private By submitbtn = By.className("btn-submit");


    //createEmployee
    public void createEmployee(String name, String age, String salary, String durationWorked, String email){
        //driver.findElement(CreateNewEmployeeButton).click();
        UiElementExtension.performClick(driver, CreateNewEmployeeButton);

        //driver.findElement(empName).sendKeys(name);
        UiElementExtension.performEnterText(driver, empName, name);

        //driver.findElement(empAge).sendKeys(age);
        UiElementExtension.performEnterText(driver, empAge, age);

        //driver.findElement(empSalary).sendKeys(salary);
        UiElementExtension.performEnterText(driver, empSalary, salary);


        //driver.findElement(empDurationWorked).sendKeys(durationWorked);
        UiElementExtension.performEnterText(driver, empDurationWorked, durationWorked);

        //Select select = new Select(driver.findElement(empGrade));
        //select.selectByVisibleText("Middle");
        UiElementExtension.performDropDownSelectionByText(driver, empGrade, "Middle");


        //driver.findElement(empEmail).sendKeys(email);
        UiElementExtension.performEnterText(driver, empEmail, email);

        //driver.findElement(submitbtn).click();
        UiElementExtension.performClick(driver, submitbtn);
    }
}
