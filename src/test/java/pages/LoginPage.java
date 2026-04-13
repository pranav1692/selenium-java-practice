package pages;

import Extensions.UiElementExtension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class LoginPage {

    private WebDriver driver;
    private WebDriverWait wait;

    public LoginPage(WebDriver driver){
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(15));
        PageFactory.initElements(driver, this);
    }


    @FindBy(id = "UserName")
    private WebElement txtUserName;

    @FindBy(id = "Password")
    private WebElement txtPassword;

    @FindBy(css = ".btn")
    private WebElement btnLogin;

    public HomePage performLogin(String username, String password){
        //UiElementExtension.performEnterText(txtUserName, username);
        //UiElementExtension.performEnterText(txtPassword, password);
        wait.until(ExpectedConditions.visibilityOf(txtUserName)).sendKeys(username);
        wait.until(ExpectedConditions.visibilityOf(txtPassword)).sendKeys(password);
        UiElementExtension.performClick(btnLogin);



        return  new HomePage(driver);
    }
}