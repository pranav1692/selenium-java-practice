package tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.*;
import org.testng.asserts.SoftAssert;
import pages.HomePage;

import static org.testng.AssertJUnit.assertEquals;
import static org.testng.AssertJUnit.assertTrue;

public class LoginPageTest {
    private WebDriver driver;
    HomePage homePage;
    private pages.LoginPage loginPage;


    @BeforeMethod
    public void beforeMethod() {
        driver = new ChromeDriver();
        driver.navigate().to("http://eaapp.somee.com/");
        driver.manage().window().maximize();
    }

    @Test(priority = 0)
    public void testLogin(){
        SoftAssert softAssert = new SoftAssert();

        homePage = new HomePage(driver);
        loginPage = homePage.clickLogin();

        softAssert.assertEquals("Sign In — EA Employee App", driver.getTitle());
        softAssert.assertAll();
    }

    @Test(priority = 1)
    public void verifyLoginPageUI() {
        SoftAssert softAssert = new SoftAssert();

        homePage = new HomePage(driver);
        loginPage = homePage.clickLogin();

        softAssert.assertTrue(loginPage.isUsernameVisible());
        softAssert.assertTrue(loginPage.isPasswordVisible());
        softAssert.assertTrue(loginPage.isLoginButtonVisible());
        softAssert.assertAll();
    }

    @Test(priority = 2)
    public void testValidLogin(){
        SoftAssert softAssert = new SoftAssert();

        homePage = new HomePage(driver);
        loginPage = homePage.clickLogin();

        homePage = loginPage.performLogin("admin", "password") ;
        softAssert.assertTrue(homePage.isLogoutDisplayed(), "Login Failed");
        softAssert.assertAll();
    }

    @Test(priority = 3)
    public void testInvalidLogin() {
        SoftAssert softAssert = new SoftAssert();

        homePage = new HomePage(driver);
        loginPage = homePage.clickLogin();

        homePage = loginPage.performLogin("admin", "wrongpassword");

        softAssert.assertTrue(loginPage.isErrorDisplayed());
        softAssert.assertAll();
    }

    @Test(priority = 4)
    public void testEmptyLogin() {
        SoftAssert softAssert = new SoftAssert();

        homePage = new HomePage(driver);
        loginPage = homePage.clickLogin();

        homePage = loginPage.performLogin("", "");

        softAssert.assertTrue(loginPage.isusernameErrorDisplayed());
        softAssert.assertTrue(loginPage.ispasswordErrorDisplayed());

        softAssert.assertAll();
    }

    @AfterMethod
    public void afterMethod() {
        // homePage.Logoff(driver);
        driver.quit();
    }
}
