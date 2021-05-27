import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ItemPage {
    WebDriver driver;

    public ItemPage(WebDriver driver) {
        this.driver = driver;
    }

    public Boolean containsProductTitleResult(String expectedText) {
        WebElement titleElement = driver.findElement(By.id("productTitle"));
        boolean containsTitle = titleElement.getText().contains(expectedText);

        return containsTitle;
    }

}
