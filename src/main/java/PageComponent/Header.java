package PageComponent;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.RemoteWebElement;

public class Header {
    WebElement container;
    By searchBarSelector = By.id("twotabsearchtextbox");
    By buttonSubmitSelector = By.id("nav-search-submit-button");

    public static By headerSelector = By.tagName("header");
    By menuListButtonSelector = By.id("nav-link-accountList-nav-line-1");

    public Header(WebElement container) {
        this.container = container;
    }

    public void search(String keyword) {
        container.findElement(searchBarSelector).clear();
        container.findElement(searchBarSelector).sendKeys(keyword);
        container.findElement(buttonSubmitSelector).click();
    }

    public void openAccountAndList() {
        var remoteElement = (RemoteWebElement) container;
        var driver = remoteElement.getWrappedDriver();

        WebElement menuListButton = container.findElement(menuListButtonSelector);
        Actions action = new Actions(driver);
        action.moveToElement(menuListButton).build().perform();

    }
}
