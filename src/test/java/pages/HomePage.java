package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage {

    private WebDriver driver;
    public HomePage(WebDriver driver){
        this.driver = driver;
    }

    private By lnkLogin = By.linkText("Login");
    private By employeeList = By.xpath("//a[contains(text(),'Employee')]");

    public LoginPage clickLogin(){
        driver.findElement(lnkLogin).click();
        return new LoginPage(driver);
    }

    public EmployeeList clickEmployeeList(){
        driver.findElement(employeeList).click();
        return new EmployeeList(driver);
    }
}
