
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pages.HomePage;

public class SeleniumTest {
    public static void main(String[] args) {

        // Launch browser
        WebDriver driver = new ChromeDriver();

        // Open website
        driver.navigate().to("http://eaapp.somee.com/");

        driver.manage().window().maximize();

        //login(driver);
        HomePage homePage = new HomePage(driver);
        var loginpage = homePage.clickLogin();
        loginpage.performLogin("admin", "password");

        //createEmployee(driver);
        var employeeListPage = homePage.clickEmployeeList();
        var createEmployeePage = employeeListPage.createEmployeePage();
        createEmployeePage.createNewEmployee("Test11", "32", "50000", "10", "Junior","test11@gmail.com");

    }


}