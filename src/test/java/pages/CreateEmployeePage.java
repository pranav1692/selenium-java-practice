package pages;

import Extensions.UiElementExtension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CreateEmployeePage {

    private WebDriver driver;

    public CreateEmployeePage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(id = "Name")
    private WebElement empName;

    @FindBy(id = "Age")
    private WebElement empAge;

    @FindBy(id = "Salary")
    private WebElement empSalary;

    @FindBy(id = "DurationWorked")
    private WebElement empDurationWorked;

    @FindBy(id = "Grade")
    private WebElement empGrade;

    @FindBy(id = "Email")
    private WebElement empEmail;

    @FindBy(className = "btn-submit")
    private WebElement submitbtn;


    //createEmployee
    public void createNewEmployee(String name, String age, String salary, String durationWorked, String email){

        UiElementExtension.performEnterText(empName, name);
        UiElementExtension.performEnterText(empAge, age);
        UiElementExtension.performEnterText(empSalary, salary);
        UiElementExtension.performEnterText(empDurationWorked, durationWorked);
        UiElementExtension.performDropDownSelectionByText(empGrade, "Middle");
        UiElementExtension.performEnterText(empEmail, email);
        UiElementExtension.performClick(submitbtn);
    }
}
