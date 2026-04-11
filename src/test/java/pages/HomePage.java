package pages;

import Extensions.UiElementExtension;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {

    private WebDriver driver;
    public HomePage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    //locators for login
    @FindBy(linkText = "Login")
    private WebElement lnkLogin;

    //locators for Employee List
    @FindBy(xpath = "//a[contains(text(),'Employee')]")
    private WebElement employeeList;

    @FindBy(linkText = "Logout")
    private WebElement btnLogout;

    public LoginPage clickLogin(){
        UiElementExtension.performClick(lnkLogin);
        return new LoginPage(driver);
    }

    public EmployeeListPage clickEmployeeList(){
        UiElementExtension.performClick(employeeList);
        return new EmployeeListPage(driver);
    }

    public void Logoff(WebDriver driver){
        UiElementExtension.performClick(btnLogout);
    }
}
