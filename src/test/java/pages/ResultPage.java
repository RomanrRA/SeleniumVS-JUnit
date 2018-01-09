package pages;

import browserFactory.BrowserFactory;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class ResultPage {

    private WebDriver driver;

    public ResultPage(WebDriver ldriver) {
        this.driver = ldriver;
    }

    @FindBy(how = How.PARTIAL_LINK_TEXT, using = "тестирован")
    private WebElement selectResult;

    public ResultPage selectResult() {
        BrowserFactory.switchBrowser(selectResult.getAttribute("href"));
        return this;
    }


}
