
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import pages.HomePage;

public class FirstTest {
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
        var employeelist = homePage.clickEmployeeList();
        employeelist.createEmployee("John", "27", "50000", "8", "john@gmail.com");

        // Close browser
        //driver.quit();
    }

    public static void login(WebDriver driver){
        driver.findElement(By.linkText("Login")).click();

        By username = By.id("UserName");
        driver.findElement(username).sendKeys("admin");


        By password = By.id("Password");
        driver.findElement(password).sendKeys("password"); ;

        driver.findElement(By.cssSelector(".btn")).submit();
    }
    public static void createEmployee(WebDriver driver){

        driver.findElement(By.xpath("//a[contains(text(),'Employee')]")).click();
        driver.findElement(By.xpath("//a[@href='/Employee/Create']")).click();

        driver.findElement(By.id("Name")).sendKeys("AutoUser2");
        driver.findElement(By.id("Age")).sendKeys("25");
        driver.findElement(By.id("Salary")).sendKeys("20000");
        driver.findElement(By.id("DurationWorked")).sendKeys("12");

        Select selectGrade = new Select(driver.findElement(By.name("Grade")));
        selectGrade.selectByVisibleText("Middle");

        driver.findElement(By.id("Email")).sendKeys("AutoUser1234@gmail.com");

        driver.findElement(By.className("btn-submit")).click();
    }
}