package testCase.firstVariant;

import browserFactory.BrowserFactory;
import helpersy.SaveText;
import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import pages.AutomationPage;
import pages.PflbMainPage;
import pages.ResultPage;
import pages.SearchPage;

public class Steps {
    private WebDriver driver;
    //      Выбор поисковика
    private String google = "https://www.google.ru";
    private String yandex = "https://yandex.ru";
    private String trambler = "https://nova.rambler.ru";

    //      Что ищем?
    private String whatFind = "www.performance-lab.ru";

    //      Выбор браузера
    private String chrome = "Chrome";
    private String firefox = "FireFox";


    //    Каким браузером пользоваться
    @Step
    private void start(String brows) {
        driver = BrowserFactory.startBrowser(brows);
    }

    @Step
    private void iitialSearchPage(String searchPage, String whatFind) {

        //        Передаем через что ищем и что ищем
        PageFactory.initElements(driver, SearchPage.class)
                .searchLineWrite(searchPage, whatFind);
    }

    @Step
    private void whatFind() {
        PageFactory.initElements(driver, ResultPage.class)
                .selectResult();
    }

    @Step
    private void whatChoose() {
        PageFactory.initElements(driver, PflbMainPage.class)
                .holdMouse()
                .findPartialTextAndClick();
    }

    @Step
    private void selectAutoText() {
        PageFactory.initElements(driver, AutomationPage.class).selectSaveText();
    }

    @Step
    private void saveSelectedText() {
        PageFactory.initElements(driver, SaveText.class).fileSave();
    }

    @Step
    private void end() {
        driver.quit();
    }

    public void testPflbPage(String browser, String searchSystem, String whatFind) {
        start(browser);
        iitialSearchPage(searchSystem, whatFind);
        whatFind();
        whatChoose();
        selectAutoText();
        saveSelectedText();
        end();
    }
}


