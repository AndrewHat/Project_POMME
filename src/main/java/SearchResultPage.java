import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class SearchResultPage {
    WebDriver driver;

    public SearchResultPage(WebDriver driver) {
        this.driver = driver;
    }

    public ItemPage openFirstResult() {
        By firstResultSelector = By.cssSelector("[cel_widget_id=\"MAIN-SEARCH_RESULTS-3\"] .s-image");
        WebElement firstResultElement = driver.findElement(firstResultSelector);

        firstResultElement.click();

        return new ItemPage(driver);
    }
}
