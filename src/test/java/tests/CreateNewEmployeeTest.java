package tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import pages.CreateEmployeePage;
import pages.EmployeeListPage;
import pages.HomePage;

import java.time.Duration;

public class CreateNewEmployeeTest {
    private WebDriver driver;
    private HomePage homePage;
    private EmployeeListPage employeeListPage;
    private pages.LoginPage loginPage;
    private CreateEmployeePage createEmployeePage;

    @Parameters({"browser", "url", "username", "password"})
    @BeforeMethod
    public void beforeMethod(String browser, String url, String username, String password) {
        switch (browser) {
            case "chrome":
                driver = new ChromeDriver();
                break;
            case "edge":
                driver = new EdgeDriver();
                break;
        }
        driver = new ChromeDriver();
        driver.navigate().to(url);
        driver.manage().window().maximize();

        homePage = new HomePage(driver);
        loginPage = homePage.clickLogin();

        homePage = loginPage.performLogin(username, password);

        SoftAssert softAssert = new SoftAssert();

        //After login -> Home Page
        softAssert.assertTrue(homePage.isEmployeeButtonVisible(), "Employee button is not visible on Home page");
        employeeListPage = homePage.clickEmployeeList();



        softAssert.assertAll();
    }

//    @Parameters("createNewEmployeePageTitle")
//    @Test(priority = 0)
//    public void VerifyEmployeePageTitle(String createNewEmployeePageTitle) {
//        SoftAssert softAssert = new SoftAssert();
//
//        softAssert.assertTrue(employeeListPage.isNewEmployeeButtonVisible(), "New Employee button is not visible on Employee List page");
//        createEmployeePage = employeeListPage.createEmployeePage();
//
//        String actualTitle = driver.getTitle();
//        String expectedTitle = createNewEmployeePageTitle;
//
//        softAssert.assertEquals(actualTitle, expectedTitle, "Create Employee page title mismatch");
//        softAssert.assertAll();
//    }
//
//    @Test(priority = 1)
//    public void verifyCreateEmployeePageUi() {
//        SoftAssert softAssert = new SoftAssert();
//
//        softAssert.assertTrue(employeeListPage.isNewEmployeeButtonVisible(), "New Employee button is not visible on Employee List page");
//        createEmployeePage = employeeListPage.createEmployeePage();
//
//        softAssert.assertTrue(createEmployeePage.isNameVisible(), "Name field is not visible");
//        softAssert.assertTrue(createEmployeePage.isAgeVisible(), "Age field is not visible");
//        softAssert.assertTrue(createEmployeePage.isSalaryVisible(), "Salary field is not visible");
//        softAssert.assertTrue(createEmployeePage.isDurationWorkedVisible(), "Duration worked field is not visible");
//        softAssert.assertTrue(createEmployeePage.isGradeVisible(), "Grade field is not visible");
//        softAssert.assertTrue(createEmployeePage.isEmailVisible(), "Email field is not visible");
//        softAssert.assertAll();
//    }
//
//    @Test(priority = 1)
//    public void createNewEmptyEmployee() {
//        SoftAssert softAssert = new SoftAssert();
//
//        softAssert.assertTrue(employeeListPage.isNewEmployeeButtonVisible(), "New Employee button is not visible on Employee List page");
//        createEmployeePage = employeeListPage.createEmployeePage();
//
//        createEmployeePage.createNewEmployee("", "", "", "", "", "");
//
//        softAssert.assertTrue(createEmployeePage.isNameErrorDisplayed(), "Name error is not visible");
//        softAssert.assertTrue(createEmployeePage.isAgeErrorDisplayed(), "Age error is not visible");
//        softAssert.assertTrue(createEmployeePage.isSalaryErrorDisplayed(), "Salary error is not visible");
//        softAssert.assertTrue(createEmployeePage.isDurationWorkedErrorDisplayed(), "Duration worked error is not visible");
//        softAssert.assertTrue(createEmployeePage.isEmailErrorDisplayed(), "Email error is not visible");
//
//        softAssert.assertAll();
//    }
//
//    @Parameters({"name", "age", "salary", "durationWorked", "grade", "email"})
//    @Test(priority = 2)
//    public void createNewEmployee(String name, String  age, String salary, String durationWorked, String grade, String email) {
//        SoftAssert softAssert = new SoftAssert();
//
//        int beforeCount = employeeListPage.getEmpCount();
//
//        softAssert.assertTrue(employeeListPage.isNewEmployeeButtonVisible(), "New Employee button is not visible on Employee List page");
//        createEmployeePage = employeeListPage.createEmployeePage();
//
//        createEmployeePage.createNewEmployee(name, age, salary, durationWorked, grade, email);
//
//        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
//        wait.until(ExpectedConditions.titleIs("Employee List - EAEmployee"));
//
//        String actualTitle = driver.getTitle();
//        String expectedTitle = "Employee List - EAEmployee";
//
//        softAssert.assertEquals(actualTitle, expectedTitle, "Employee page title mismatch");
//        int afterCount = employeeListPage.getEmpCount();
//
//        softAssert.assertEquals(beforeCount + 1, afterCount, "Employee page count mismatch");
//        softAssert.assertAll();
//    }
//
//    @Parameters({"name", "age", "salary", "durationWorked", "grade", "email"})
//    @Test(priority = 3)
//    public void verifyDuplicateEmailValidation(String name, String  age, String salary, String durationWorked, String grade, String email) {
//        SoftAssert softAssert = new SoftAssert();
//
//        softAssert.assertTrue(employeeListPage.isNewEmployeeButtonVisible(), "New Employee button is not visible");
//        createEmployeePage = employeeListPage.createEmployeePage();
//
//        createEmployeePage.createNewEmployee(name, age, salary, durationWorked, grade, email);
//
//        String actualTitle = driver.getTitle();
//
//        softAssert.assertEquals(actualTitle, "Create Employee - EAEmployee", "Duplicate email should not allow employee creation");
//
//        softAssert.assertAll();
//    }
//
//    @Test(priority = 4)
//    public void verifyInvalidAgeFieldValidation() {
//        SoftAssert softAssert = new SoftAssert();
//
//        String[][] testData = {
//                {"", "Age empty"},
//                {"abc", "Age with letters"},
//                {"-1", "Negative age"},
//                {"0", "Zero age"},
//                {"200", "Huge age"}
//        };
//
//        for (String[] data : testData) {
//
//            // Open Create Employee Page
//            softAssert.assertTrue(employeeListPage.isNewEmployeeButtonVisible(),
//                    "New Employee button is not visible");
//
//            createEmployeePage = employeeListPage.createEmployeePage();
//
//            // Fill form with invalid age
//            createEmployeePage.createNewEmployee(
//                    "TestUser",
//                    data[0],          // invalid age
//                    "50000",
//                    "3",
//                    "Junior",
//                    "testuser@gmail.com"
//            );
//
//            // Verify age validation error
//            softAssert.assertTrue(
//                    createEmployeePage.isAgeErrorDisplayed(),
//                    "Validation failed for case: " + data[1]
//            );
//
//            driver.navigate().back();
//        }
//
//        softAssert.assertAll();
//    }


    @Test
    public void updateEmployee(){

        String empName = "automated";
        String empEmail = "automated@gmail.com";

        employeeListPage.searchEmployee(empName);
        employeeListPage.clickEditButtonByEmail(empEmail);

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.titleIs("Edit Employee - EAEmployee"));

        String actualTitle = driver.getTitle();
        String expectedTitle = "Edit Employee - EAEmployee";
        Assert.assertEquals(actualTitle, expectedTitle, "Update page Title mismatch");
    }


    @AfterMethod
    public void afterMethod() {
        //driver.quit();
    }
}



