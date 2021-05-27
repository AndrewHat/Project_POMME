import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ItemPage {
    WebDriver driver;
    By titleSelector = By.id("productTitle");

    public ItemPage(WebDriver driver) {
        this.driver = driver;
    }

    public String getProductTitle() {
        return driver.findElement(titleSelector).getText();
    }

}
