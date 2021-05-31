package PageObject;

import PageComponent.Header;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ItemPage {
    WebDriver driver;
    By titleSelector = By.id("productTitle");

    Header header;

    public ItemPage(WebDriver driver) {
        this.driver = driver;
        WebElement headerContainer = driver.findElement(Header.headerSelector);
        header = new Header(headerContainer);
    }

    public String getProductTitle() {
        String title = driver.findElement(titleSelector).getText();
        System.out.println("Getting product title = " + title);

        return title;
    }

    public SearchResultPage search(String text) {
        System.out.println("Searching: " + text);
        header.search(text);

        return new SearchResultPage(driver);
    }

}
