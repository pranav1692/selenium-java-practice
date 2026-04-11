package Extensions;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class UiElementExtension {

    public static void performClick(WebElement locator) {
        locator.click();
    }

    //to perform enter text
    public static void performEnterText(WebElement locator, String text) {
        locator.click();
        locator.clear();
        locator.sendKeys(text);
    }

    public static void performDropDownSelectionByText(WebElement locator, String dropdownText) {
        var select = new Select(locator);
        select.selectByVisibleText(dropdownText);
    }

    public static void performDropDownSelectionByIndex(WebElement locator, int index) {
        var select = new Select(locator);
        select.selectByIndex(index);
    }
}
