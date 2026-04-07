package Extensions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;

public class UiElementExtension {

    public static void performClick(WebDriver driver, By locator) {
        driver.findElement(locator).click();
    }

    //to perform enter text
    public static void performEnterText(WebDriver driver, By locator, String text) {
        driver.findElement(locator).click();
        driver.findElement(locator).clear();
        driver.findElement(locator).sendKeys(text);
    }

    public static void performDropDownSelectionByText(WebDriver driver, By locator, String dropdownText) {
        var select = new Select(driver.findElement(locator));
        select.selectByVisibleText(dropdownText);
    }

    public static void performDropDownSelectionByIndex(WebDriver driver, By locator, int index) {
        var select = new Select(driver.findElement(locator));
        select.selectByIndex(index);
    }
}
