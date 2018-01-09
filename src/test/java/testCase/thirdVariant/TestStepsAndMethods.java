package testCase.thirdVariant;

import browserFactory.BrowserFactory;
import helpersy.SaveText;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import pages.AutomationPage;
import pages.PflbMainPage;
import pages.ResultPage;
import pages.SearchPage;

public class TestStepsAndMethods {
    //      Выбор поисковика
    public static final String google = "https://www.google.ru";
    public static final String yandex = "https://yandex.ru";
    public static final String trambler = "https://nova.rambler.ru";

    //      Что ищем?
    private String whatFind = "www.performance-lab.ru";

    //      Выбор браузера
    private String chrome ="Chrome";
    private String firefox ="FireFox";

    //    Каким браузером пользоваться
    private WebDriver driver = BrowserFactory.startBrowser(chrome);

    @Test
    public void firstTest() {

    //        Передаем через что ищем и что ищем
        PageFactory.initElements(driver, SearchPage.class)
                .searchLineWrite(yandex, whatFind);

        PageFactory.initElements(driver, ResultPage.class)
                .selectResult();
        PageFactory.initElements(driver, PflbMainPage.class)
                .holdMouse()
                .findPartialTextAndClick();
        PageFactory.initElements(driver, AutomationPage.class).selectSaveText();
        PageFactory.initElements(driver, SaveText.class).fileSave();

        driver.quit();
    }

}
