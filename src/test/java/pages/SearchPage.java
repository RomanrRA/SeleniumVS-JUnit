package pages;

import browserFactory.BrowserFactory;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import testCase.thirdVariant.TestStepsAndMethods;

import static helpersy.ConsoleColors.PURPLE_BOLD_BRIGHT;
import static helpersy.ConsoleColors.RESET;

public class SearchPage {

    private WebDriver driver;
    public static String searchName;

    public SearchPage(WebDriver ldriver) {
        this.driver = ldriver;
        driver.getTitle();
    }

    @FindBy(how = How.CSS, using = "input[id='lst-ib']")
    private WebElement googleSearchLine;

    @FindBy(how = How.CSS, using = "input[aria-label='Запрос']")
    private WebElement yandexSearchLine;

    @FindBy(how = How.CSS, using = "input[name='query']")
    private WebElement ramblerSearchLine;


    public SearchPage searchLineWrite(String searchEngine, String whatFind) {
        BrowserFactory.switchBrowser(searchEngine);

        WebElement findLine;
        switch (searchEngine) {
            case (TestStepsAndMethods.yandex):
                findLine = yandexSearchLine;
                searchName = "Яндекс";

                if (!searchName.equals(driver.getTitle())) {
                    System.out.println(PURPLE_BOLD_BRIGHT + "Это не та страница!!!!" + "Проверте праильность ввода searchName" + RESET);
                }
                Assert.assertEquals(searchName, driver.getTitle());
                break;

            case (TestStepsAndMethods.trambler):
                findLine = ramblerSearchLine;
                searchName = "Рамблер";

                String nameSearchPage = "Рамблер/поиск";
                if (!nameSearchPage.equals(driver.getTitle())) {
                    System.out.println(PURPLE_BOLD_BRIGHT + "Это не та страница!!!!" + "Проверте праильность ввода searchName" + RESET);
                }
                Assert.assertEquals(nameSearchPage, driver.getTitle());
                break;

            default:
                findLine = googleSearchLine;
                searchName = "Google";

                if (!searchName.equals(driver.getTitle())) {
                    System.out.println(PURPLE_BOLD_BRIGHT + "Это не та страница!!!!" + "Проверте праильность ввода searchName" + RESET);
                }
                Assert.assertEquals(searchName, driver.getTitle());
                break;

        }

        findLine.clear();
        findLine.sendKeys(whatFind);
        findLine.submit();
        return this;
    }
}
