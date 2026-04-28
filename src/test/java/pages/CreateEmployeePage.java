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

    @FindBy(id = "Name-error")
    private  WebElement nameError;

    @FindBy(id = "Age-error")
    private   WebElement ageError;

    @FindBy(id = "Salary-error")
    private   WebElement salaryError;

    @FindBy(id = "DurationWorked-error")
    private   WebElement durationWorkedError;

    @FindBy(id = "Email-error")
    private    WebElement emailError;


    //createEmployee
    public void createNewEmployee(String name, String age, String salary, String durationWorked, String grade, String email){

        UiElementExtension.performEnterText(empName, name);
        UiElementExtension.performEnterText(empAge, age);
        UiElementExtension.performEnterText(empSalary, salary);
        UiElementExtension.performEnterText(empDurationWorked, durationWorked);
        UiElementExtension.performDropDownSelectionByText(empGrade, grade);
        UiElementExtension.performEnterText(empEmail, email);
        UiElementExtension.performClick(submitbtn);
    }

    //Ui elements Methods
    public boolean isNameVisible(){
        return empName.isDisplayed();
    }
    public boolean isAgeVisible(){
        return empAge.isDisplayed();
    }
    public boolean isSalaryVisible(){
        return  empSalary.isDisplayed();
    }
    public  boolean isDurationWorkedVisible(){
        return empDurationWorked.isDisplayed();
    }
    public boolean isGradeVisible(){
        return empGrade.isDisplayed();
    }
    public  boolean isEmailVisible(){
        return empEmail.isDisplayed();
    }

    // Error Methods
    public boolean isNameErrorDisplayed(){
        return  nameError.isDisplayed();
    }
    public  boolean isAgeErrorDisplayed(){
        return   ageError.isDisplayed();
    }
    public  boolean isSalaryErrorDisplayed(){
        return   salaryError.isDisplayed();
    }
    public   boolean isDurationWorkedErrorDisplayed(){
        return   durationWorkedError.isDisplayed();
    }
    public   boolean isEmailErrorDisplayed(){
        return    emailError.isDisplayed();
    }
}
