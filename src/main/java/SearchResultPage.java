import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class SearchResultPage {
    WebDriver driver;
    By resultSelector = By.cssSelector("[data-image-index]");

    public SearchResultPage(WebDriver driver) {
        this.driver = driver;
    }

    public ItemPage openResult(int index) {
        List<WebElement> itemList = driver.findElements(resultSelector);
        itemList.get(index).click();

        return new ItemPage(driver);
    }
}
