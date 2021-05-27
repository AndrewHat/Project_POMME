import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class HomePage {
    WebDriver driver;

    public HomePage(WebDriver driver) {
        this.driver = driver;
    }

    public HomePage writeSearchBar(String text) {
        WebElement textSearchBarElement= driver.findElement(By.id("twotabsearchtextbox"));
        textSearchBarElement.sendKeys(text);

        return this;
    }

    public SearchResultPage enterSearchSubmitButton() {
        WebElement buttonElement = driver.findElement(By.id("nav-search-submit-button"));
        buttonElement.click();

        return new SearchResultPage(driver);
    }

}
