package browserFactory;

import cucumber.api.java.ru.Дано;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.concurrent.TimeUnit;

public class BrowserFactory {

    private static WebDriver driver;
    public static String nameBrowser;
    private static int browser;

    public static WebDriver startBrowser(String brosName) {

        if (brosName.equalsIgnoreCase("firefox")) {
            nameBrowser = "Bros_FireFox";
            browser = 1;
            driver = new FirefoxDriver();
        } else if (brosName.equalsIgnoreCase("chrome")) {
            nameBrowser = "Bros_Chrome";
            browser = 2;
            driver = new ChromeDriver();
        }else System.out.println("Введите имя браузера: firefox или chrome");

        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        return driver;
    }

    public static void switchBrowser(String text) {
        switch (BrowserFactory.browser) {
            case (1):
                driver.get(text);
                break;
            case (2):
                driver.navigate().to(text);
                break;
            default:
                break;
        }
    }

}
