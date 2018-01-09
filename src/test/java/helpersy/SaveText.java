package helpersy;

import browserFactory.BrowserFactory;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import pages.AutomationPage;
import pages.SearchPage;

import java.io.File;
import java.io.FileWriter;
import java.text.SimpleDateFormat;
import java.util.Date;

public class SaveText {

    private WebDriver driver;

    public SaveText(WebDriver ldriver) {
        this.driver = ldriver;
    }

    public void fileSave() {
//        List<WebElement> buffer = driver.findElements(By.cssSelector("div[class='entry-main']"));
        SimpleDateFormat format = new SimpleDateFormat("dd.MM.yyyy-HH-mm-ss");
        String dat = format.format(new Date());
        String separator = File.separator;
        try (FileWriter file = new FileWriter(
                "C:" + separator +
                        "TestResults" + separator +
                        BrowserFactory.nameBrowser + " " +
                        SearchPage.searchName + "-" +
                        dat + ".txt")) {
            for (WebElement el : AutomationPage.buffer) {
                file.write(el.getText());
            }
        } catch (Exception e) {
            System.out.println("Всё печально!" + e.getMessage());
        }
    }
}
