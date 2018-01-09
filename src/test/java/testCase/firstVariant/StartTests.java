package testCase.firstVariant;

import org.junit.Test;
//Class Test
public class StartTests {
    //      Выбор поисковика
    private String google = "https://www.google.ru";
    private String yandex = "https://yandex.ru";
    private String trambler = "https://nova.rambler.ru";

    //      Что ищем?
    private String whatFind = "www.performance-lab.ru";

    //      Выбор браузера
    private String chrome = "Chrome";
    private String firefox = "FireFox";

    private Steps step = new Steps();

    @Test
    public void testChromeGoogle() {
        step.testPflbPage(chrome, google, whatFind);
    }

    @Test
    public void testChromeYandex() {
        step.testPflbPage(chrome, yandex, whatFind);
    }

    @Test
    public void testChromeRambler() {
        step.testPflbPage(chrome, trambler, whatFind);
    }

    @Test
    public void testFireFoxGoogle() {
        step.testPflbPage(firefox, google, whatFind);
    }

    @Test
    public void testFireFoxYandex() {
        step.testPflbPage(firefox, yandex, whatFind);
    }

    @Test
    public void testFireFoxRambler() {
        step.testPflbPage(firefox, trambler, whatFind);
    }
}
