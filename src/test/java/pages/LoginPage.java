package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {

    private WebDriver driver;
    public LoginPage(WebDriver driver){
        this.driver = driver;
    }

    private By txtUserName =  By.id("UserName");
    private By txtPassword = By.id("Password");
    private By btnLogin = By.cssSelector(".btn");

    public void performLogin(String username, String password){
        driver.findElement(txtUserName).sendKeys(username);
        driver.findElement(txtPassword).sendKeys(password);
        driver.findElement(btnLogin).click();
    }
}
