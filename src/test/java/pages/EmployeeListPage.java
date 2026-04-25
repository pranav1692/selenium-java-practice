package pages;

import Extensions.UiElementExtension;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

public class EmployeeListPage {

    private WebDriver driver;

    public EmployeeListPage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
    @FindBy(xpath = "//a[@href='/Employee/Create']")
    private WebElement btnCreateNew;

    @FindBy(className = "table")
    WebElement table;

    @FindBy(name = "searchTerm")
    WebElement txtSearch;

    @FindBy(className = "btn-search")
    WebElement btnSearch;

    @FindBy(className = "btn-create")
    WebElement btnNewEmployee;

    @FindBy(className = "emp-name")
    WebElement txtEmpName;


    public CreateEmployeePage createEmployeePage(){
        UiElementExtension.performClick(btnCreateNew);
        return new CreateEmployeePage(driver);
    }

    public void searchEmployee(String name) {
        txtSearch.sendKeys(name);
        btnSearch.click();
    }

    public int getRowCount() {
        return driver.findElements(By.xpath("//table/tbody/tr")).size();
    }

    public boolean verifyEmployeeTableVisible(){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        return wait.until(ExpectedConditions.visibilityOf(table)).isDisplayed();
    }
    public boolean verifySearchBoxVisible() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        return wait.until(ExpectedConditions.visibilityOf(txtSearch)).isDisplayed();
    }
    public boolean verifyNewEmployeeButtonVisible(){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        return wait.until(ExpectedConditions.visibilityOf(btnNewEmployee)).isDisplayed();
    }
    public String getEmployeeName(){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        return wait.until(ExpectedConditions.visibilityOf(txtEmpName)).getText();
    }

    @FindBy(xpath = "//table/tbody/tr/td[1]")
    private List<WebElement> employeeNameCells;

    public List<String> getAllEmployeeNames() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        wait.until(ExpectedConditions.visibilityOfAllElements(employeeNameCells));

        List<String> names = new ArrayList<>();

        for (WebElement element : employeeNameCells) {
            names.add(element.getText().trim());
        }

        return names;
    }

    public boolean isNewEmployeeButtonVisible() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        return wait.until(ExpectedConditions.visibilityOf(btnNewEmployee)).isDisplayed();
    }
}
