package tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.Assert;
import org.testng.annotations.*;
import org.testng.asserts.SoftAssert;
import pages.HomePage;

import static org.testng.AssertJUnit.assertEquals;
import static org.testng.AssertJUnit.assertTrue;

public class LoginPageTest {
    private WebDriver driver;
    HomePage homePage;
    private pages.LoginPage loginPage;


    @Parameters({"browser", "url"})
    @BeforeMethod
    public void beforeMethod(String browser, String testURL) {
        switch (browser) {
            case "chrome":
                driver = new ChromeDriver();
                break;
                case "edge":
                    driver = new EdgeDriver();
                    break;
        }
        driver.navigate().to(testURL);
        driver.manage().window().maximize();
    }

    @Parameters("signInPageTitle")
    @Test(priority = 0)
    public void testLogin(String signInPageTitle) {

        homePage = new HomePage(driver);
        loginPage = homePage.clickLogin();
        Assert.assertEquals(signInPageTitle, driver.getTitle());
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

    @Parameters({"username", "password"})
    @Test(priority = 2)
    public void testValidLogin(String username, String password) {

        homePage = new HomePage(driver);
        loginPage = homePage.clickLogin();

        homePage = loginPage.performLogin(username, password) ;
        Assert.assertTrue(homePage.isLogoutDisplayed(), "Login Failed");
    }

    @Test(priority = 3)
    public void testInvalidLogin() {

        homePage = new HomePage(driver);
        loginPage = homePage.clickLogin();

        loginPage.performLogin("admin", "wrongpassword");

        Assert.assertTrue(loginPage.isErrorDisplayed());
    }

    @Test(priority = 4)
    public void testEmptyLogin() {
        SoftAssert softAssert = new SoftAssert();

        homePage = new HomePage(driver);
        loginPage = homePage.clickLogin();

        loginPage.performLogin("", "");

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
