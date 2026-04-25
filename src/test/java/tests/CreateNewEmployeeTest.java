package tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import pages.CreateEmployeePage;
import pages.EmployeeListPage;
import pages.HomePage;

public class CreateNewEmployeeTest {
    private WebDriver driver;
    private HomePage homePage;
    private EmployeeListPage employeeListPage;
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

    @Parameters("createNewEmployeePageTitle")
    @Test(priority = 0)
    public void testCreateEmployeePageTitle( String createNewEmployeePageTitle )
    {
        SoftAssert softAssert = new SoftAssert();

        //After login -> Home Page
        softAssert.assertTrue(homePage.isEmployeeButtonVisible(), "Employee button is not visible on Home page");
        employeeListPage = homePage.clickEmployeeList();

        softAssert.assertTrue(employeeListPage.isNewEmployeeButtonVisible(), "New Employee button is not visible on Employee List page");
        CreateEmployeePage createEmployeePage = employeeListPage.createEmployeePage();

        String actualTitle = driver.getTitle();
        String expectedTitle = createNewEmployeePageTitle;

        softAssert.assertEquals(actualTitle, expectedTitle, "Create Employee page title mismatch");
        softAssert.assertAll();
    }

    @Test(priority = 1)
    public void createNewEmployeeTest() {

    }


    @AfterMethod
    public void afterMethod() {
        driver.quit();
    }
}
