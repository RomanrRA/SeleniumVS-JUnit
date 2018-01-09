package pages;

import browserFactory.BrowserFactory;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import static helpersy.ConsoleColors.PURPLE_BOLD_BRIGHT;
import static helpersy.ConsoleColors.RESET;

public class PflbMainPage {
    private WebDriver driver;
    private Actions actions;
    private final String TITLE = "Перфоманс Лаб - Услуги по тестированию программного обеспечения";

    public PflbMainPage(WebDriver ldriver) {
        this.driver = ldriver;

        if (!TITLE.equals(driver.getTitle())) {
            System.out.println(PURPLE_BOLD_BRIGHT + "Это не та страница!!!!" + "Проверте праильность ввода TITLE" + RESET );
        }
        Assert.assertEquals(TITLE, driver.getTitle());
    }

    //    text = "Автоматизация тестирования"
    @FindBy(how = How.LINK_TEXT, using = "Автоматизация тестирования")
    private WebElement selectMenu;

    public PflbMainPage holdMouse() {
        actions = new Actions(driver);
        actions.moveToElement(selectMenu).build().perform();
        return this;
    }

    public PflbMainPage findPartialTextAndClick() {
        BrowserFactory.switchBrowser(selectMenu.getAttribute("href"));
        return this;
    }

}
