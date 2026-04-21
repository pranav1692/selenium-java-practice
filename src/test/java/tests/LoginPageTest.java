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
    SoftAssert softAssert = new SoftAssert();


    @BeforeTest
    public void beforeTest() {
        driver = new ChromeDriver();
        driver.navigate().to("http://eaapp.somee.com/");
        driver.manage().window().maximize();
    }

    @Test(priority = 0)
    public void testLogin(){
        homePage = new HomePage(driver);
        loginPage = homePage.clickLogin();

        assertEquals("Login - EAEmployee", driver.getTitle());
    }

    @Test(priority = 1)
    public void verifyLoginPageUI() {
        homePage = new HomePage(driver);
        loginPage = homePage.clickLogin();

        assertTrue(loginPage.isUsernameVisible());
        assertTrue(loginPage.isPasswordVisible());
        assertTrue(loginPage.isLoginButtonVisible());
    }

    @Test(priority = 2)
    public void testValidLogin(){
        homePage = new HomePage(driver);
        loginPage = homePage.clickLogin();

        loginPage.performLogin("admin", "password") ;
        assertTrue("Login Failed", homePage.isLogoutDisplayed());
    }

    @Test(priority = 3)
    public void testInvalidLogin() {
        homePage = new HomePage(driver);
        loginPage = homePage.clickLogin();

        loginPage.performLogin("admin", "wrongpassword");

        assertTrue(loginPage.isErrorDisplayed());
    }

    @Test(priority = 4)
    public void testEmptyLogin() {
        homePage = new HomePage(driver);
        loginPage = homePage.clickLogin();

        loginPage.performLogin("", "");

        assertTrue(loginPage.isErrorDisplayed());
    }

    @AfterTest
    public void afterTest() {
        // homePage.Logoff(driver);
        driver.quit();
    }
}
