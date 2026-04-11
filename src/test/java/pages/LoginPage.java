package pages;

import Extensions.UiElementExtension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {

    private WebDriver driver;
    public LoginPage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(id = "UserName")
    private WebElement txtUserName;

    @FindBy(id = "Password")
    private WebElement txtPassword;

    @FindBy(css = ".btn")
    private WebElement btnLogin;

    public HomePage performLogin(String username, String password){
        UiElementExtension.performEnterText(txtUserName, username);
        UiElementExtension.performEnterText(txtPassword, password);
        UiElementExtension.performClick(btnLogin);
        return  new HomePage(driver);
    }
}
