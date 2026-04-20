package tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.Assert.*;
import org.testng.annotations.*;
import pages.HomePage;
import pages.LoginPage;

import static org.testng.AssertJUnit.assertEquals;
import static org.testng.AssertJUnit.assertTrue;

public class TestngTest2 {
    private WebDriver driver;
    HomePage homePage;
    private LoginPage loginPage;

    @BeforeTest
    public void beforeTest() {
        driver = new ChromeDriver();
        driver.navigate().to("http://eaapp.somee.com/");
        driver.manage().window().maximize();
    }

    @Test(priority = 0)
    public void Test1(){
        homePage = new HomePage(driver);
        String actualTitle = driver.getTitle();
        String expectedTitle = "Home - EAEmployee";
        assertEquals(expectedTitle, actualTitle);
    }

    @Test(priority = 1)
    public void testLogin(){
        homePage = new HomePage(driver);
        loginPage = homePage.clickLogin();

        homePage = loginPage.performLogin("admin", "password");

        Assert.assertTrue(
                homePage.isLogoutDisplayed(),
                "Login failed"
        );
    }

    @Test(priority = 2)
    public void testBCreateEmployee() {

        var employeeListPage = homePage.clickEmployeeList();
        var createEmployeePage = employeeListPage.createEmployeePage();
        createEmployeePage.createNewEmployee("Test13", "32", "50000", "10", "test13@gmail.com");
    }

    @AfterTest
    public void afterTest() {
        // homePage.Logoff(driver);
        driver.quit();
    }
}
