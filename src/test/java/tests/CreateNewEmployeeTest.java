package tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
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
    private CreateEmployeePage createEmployeePage;

    //@Parameters({"browser", "url", "username", "password"})
    @BeforeMethod
    public void beforeMethod() {
//        switch (browser) {
//            case "chrome":
//                driver = new ChromeDriver();
//                break;
//            case "edge":
//                driver = new EdgeDriver();
//                break;
//        }
        driver = new ChromeDriver();
        driver.navigate().to("http://eaapp.somee.com/");
        driver.manage().window().maximize();

        homePage = new HomePage(driver);
        loginPage = homePage.clickLogin();

        homePage = loginPage.performLogin("admin", "password");

        SoftAssert softAssert = new SoftAssert();

        //After login -> Home Page
        softAssert.assertTrue(homePage.isEmployeeButtonVisible(), "Employee button is not visible on Home page");
        employeeListPage = homePage.clickEmployeeList();

        softAssert.assertTrue(employeeListPage.isNewEmployeeButtonVisible(), "New Employee button is not visible on Employee List page");
        createEmployeePage = employeeListPage.createEmployeePage();

        softAssert.assertAll();
    }

    //@Parameters("createNewEmployeePageTitle")
    @Test(priority = 0)
    public void VerifyEmployeePageTitle() {
        SoftAssert softAssert = new SoftAssert();

        String actualTitle = driver.getTitle();
        String expectedTitle = "Create Employee - EAEmployee";

        softAssert.assertEquals(actualTitle, expectedTitle, "Create Employee page title mismatch");
        softAssert.assertAll();
    }

    @Test(priority = 1)
    public void verifyCreateEmployeePageUi() {
        SoftAssert softAssert = new SoftAssert();

        softAssert.assertTrue(createEmployeePage.isNameVisible(), "Name field is not visible");
        softAssert.assertTrue(createEmployeePage.isAgeVisible(), "Age field is not visible");
        softAssert.assertTrue(createEmployeePage.isSalaryVisible(), "Salary field is not visible");
        softAssert.assertTrue(createEmployeePage.isDurationWorkedVisible(), "Duration worked field is not visible");
        softAssert.assertTrue(createEmployeePage.isGradeVisible(), "Grade field is not visible");
        softAssert.assertTrue(createEmployeePage.isEmailVisible(), "Email field is not visible");
        softAssert.assertAll();
    }

    @Test(priority = 1)
    public void createNewEmployee() {
        SoftAssert softAssert = new SoftAssert();

        createEmployeePage.createNewEmployee("", "", "", "", "");

        softAssert.assertTrue(createEmployeePage.isNameErrorDisplayed(), "Name error is not visible");
        softAssert.assertTrue(createEmployeePage.isAgeErrorDisplayed(), "Age error is not visible");
        softAssert.assertTrue(createEmployeePage.isSalaryErrorDisplayed(), "Salary error is not visible");
        softAssert.assertTrue(createEmployeePage.isDurationWorkedErrorDisplayed(), "Duration worked error is not visible");
        softAssert.assertTrue(createEmployeePage.isEmailErrorDisplayed(), "Email error is not visible");

        softAssert.assertAll();
    }


    @AfterMethod
    public void afterMethod() {
        driver.quit();
    }
}



