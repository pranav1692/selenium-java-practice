package tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.LoginPage;

public class TestNGTest {

    private WebDriver driver;
    HomePage homePage;
    private LoginPage loginPage;

    @BeforeTest
    public void beforeTest() {
        // Open website
        driver = new ChromeDriver();
        driver.navigate().to("http://eaapp.somee.com/");
        driver.manage().window().maximize();
        homePage = new HomePage(driver);
        loginPage = homePage.clickLogin();
        loginPage.performLogin("admin", "password");
    }

    @Test
    public void testBCreateEmployee() {
        var employeeListPage = homePage.clickEmployeeList();
        var createEmployeePage = employeeListPage.createEmployeePage();
        createEmployeePage.createNewEmployee("Test13", "32", "50000", "10", "Junior", "test13@gmail.com");
    }

    @AfterTest
    public void afterTest() {
        // homePage.Logoff(driver);
        driver.quit();
    }
}
