package tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.Assert;
import org.testng.Assert.*;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import pages.EmployeeListPage;
import pages.HomePage;

import java.util.List;

public class EmployeeListPageTest {
    private WebDriver driver;
    HomePage homePage;
    private pages.LoginPage loginPage;

    @Parameters({"browser", "url", "username", "password"})
    @BeforeMethod
    public void beforeMethod(String browser, String testURL, String username, String password) {
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

        homePage = new HomePage(driver);
        loginPage = homePage.clickLogin();

        homePage = loginPage.performLogin(username, password);
    }

    @Test(priority = 0)
    public void testEmployeeButtonClick()
    {
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertTrue(homePage.isEmployeeButtonVisible());
        softAssert.assertAll();
    }

    @Parameters("employeePageTitle")
    @Test(priority=1)
    public void testEmployeePageTitle(String employeePageTitle){
        EmployeeListPage employeeListPage = homePage.clickEmployeeList();

        String actualTitle = driver.getTitle();
        String expectedTitle = employeePageTitle;

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

    @Parameters("empname")
    @Test(priority=2)
    public void testSearchEmployee(String empname) {
        EmployeeListPage employeeListPage = homePage.clickEmployeeList();

        employeeListPage.searchEmployee(empname);
        String empResult = employeeListPage.getEmployeeName();
        Assert.assertEquals(empResult, empname, "Employee name mismatch");
    }

    // Test class - partial search validation
    @Parameters("partialempname")
    @Test
    public void testPartialEmployeeSearch(String partialempname) {

        EmployeeListPage employeeListPage = homePage.clickEmployeeList();

        String keyword = partialempname;

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
