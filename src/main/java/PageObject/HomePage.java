package PageObject;

import PageComponent.Header;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class HomePage {
    WebDriver driver;
    Header header;

    public HomePage(WebDriver driver) {
        this.driver = driver;

        WebElement headerContainer = driver.findElement(Header.headerSelector);
        header = new Header(headerContainer);
    }

    public SearchResultPage search(String text) {
        System.out.println("Searching: " + text);
        header.search(text);

        return new SearchResultPage(driver);
    }

    public HomePage openAccountList() {
        header.openAccountAndList();

        return this;
    }
}
