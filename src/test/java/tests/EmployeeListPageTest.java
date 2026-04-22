package tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.Assert.*;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import pages.EmployeeListPage;
import pages.HomePage;

import java.util.List;

public class EmployeeListPageTest {
    private WebDriver driver;
    HomePage homePage;
    private pages.LoginPage loginPage;

    @BeforeMethod
    public void beforeMethod()
    {
        driver = new ChromeDriver();
        driver.navigate().to("http://eaapp.somee.com/");
        driver.manage().window().maximize();

        homePage = new HomePage(driver);
        loginPage = homePage.clickLogin();

        homePage = loginPage.performLogin("admin", "password");
    }

    @Test(priority = 0)
    public void testEmployeeButtonClick()
    {
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertTrue(homePage.isEmployeeButtonVisible());
        softAssert.assertAll();
    }

    @Test(priority=1)
    public void testEmployeePageTitle(){
        EmployeeListPage employeeListPage = homePage.clickEmployeeList();

        String actualTitle = driver.getTitle();
        String expectedTitle = "Employee List - EAEmployee";

        Assert.assertEquals(actualTitle, expectedTitle, "Employee page title mismatch");
    }

    @Test(priority=2)
    public void verifyEmployeeListPageUIElements() {
        SoftAssert softAssert = new SoftAssert();
        EmployeeListPage employeeListPage = homePage.clickEmployeeList();

        softAssert.assertTrue(employeeListPage.verifyEmployeeTableVisible(), "Employee table is not displayed");
        softAssert.assertTrue(employeeListPage.verifySearchBoxVisible(), "Employee Search Box is not displayed");
        softAssert.assertTrue(employeeListPage.verifyNewEmployeeButtonVisible(),  "New Employee button is not displayed");

        softAssert.assertAll();
    }

    @Test(priority=2)
    public void testSearchEmployee() {
        EmployeeListPage employeeListPage = homePage.clickEmployeeList();

        String empName = "Sarah Johnson";
        employeeListPage.searchEmployee(empName);
        String empResult = employeeListPage.getEmployeeName();
        Assert.assertEquals(empResult, empName, "Employee name mismatch");
    }

    // Test class - partial search validation

    @Test
    public void testPartialEmployeeSearch() {

        EmployeeListPage employeeListPage = homePage.clickEmployeeList();

        String keyword = "Test";

        employeeListPage.searchEmployee(keyword);

        List<String> results = employeeListPage.getAllEmployeeNames();

        for (String name : results) {
            Assert.assertTrue(
                    name.toLowerCase().contains(keyword.toLowerCase()),
                    "Invalid result found: " + name
            );
        }
    }

    @AfterMethod
    public void afterMethod() {
        driver.quit();
    }
}
