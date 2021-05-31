package PageObject;

import PageComponent.Header;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class SearchResultPage {
    WebDriver driver;
    Header header;
    By resultSelector = By.cssSelector("[data-image-index]");

    public SearchResultPage(WebDriver driver) {
        this.driver = driver;

        WebElement headerContainer = driver.findElement(Header.headerSelector);
        header = new Header(headerContainer);
    }

    public ItemPage openResult(int index) {
        System.out.println("Opening result number = " + index);
        List<WebElement> itemList = driver.findElements(resultSelector);
        itemList.get(index).click();

        return new ItemPage(driver);
    }

    public SearchResultPage search(String text) {
        System.out.println("Searching: " + text);
        header.search(text);

        return new SearchResultPage(driver);
    }
}
