import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class HomePage {
    WebDriver driver;
    By textSearchBarSelector = By.id("twotabsearchtextbox");
    By buttonSubmitSelector = By.id("nav-search-submit-button");

    public HomePage(WebDriver driver) {
        this.driver = driver;
    }

    public SearchResultPage search(String text) {
        driver.findElement(textSearchBarSelector).sendKeys(text);
        driver.findElement(buttonSubmitSelector).click();

        return new SearchResultPage(driver);
    }
}
