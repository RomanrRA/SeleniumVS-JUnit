package pages;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

import static helpersy.ConsoleColors.PURPLE_BOLD_BRIGHT;
import static helpersy.ConsoleColors.RESET;

public class AutomationPage {
    WebDriver driver;
    public static List<WebElement> buffer;
    private final String TITLE = "Автоматизация тестирования | Перфоманс Лаб";

    public AutomationPage(WebDriver ldriver) {
        this.driver = ldriver;

        if (!TITLE.equals(driver.getTitle())) {
            System.out.println(PURPLE_BOLD_BRIGHT + "Это не та страница!!!!" + "Проверте праильность ввода TITLE" + RESET );
        }
        Assert.assertEquals(TITLE,driver.getTitle());
    }

    public AutomationPage selectSaveText() {
        buffer = driver.findElements(By.cssSelector("div[class='entry-main']"));
        return this;
    }

}
