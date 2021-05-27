import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class TestSwitch {
    WebDriver driver;

    @BeforeMethod
    public void openChrome() {
        driver = new ChromeDriver();
        driver.get("https://www.amazon.fr/");
        driver.manage().window().maximize();

        By cookiesSelector = By.name("accept");
        driver.findElement(cookiesSelector).click();
    }

    @AfterMethod
    public void closeChrome() {
        driver.quit();
    }

    @Test
    public void testSearchBar() {
        // Arrange
        String item = "Nintendo Switch";

        // Act
        HomePage amazonHomePage = new HomePage(driver);
        String productTitle = amazonHomePage
                .search(item)
                .openResult(0)
                .getProductTitle();

        Assert.assertTrue(productTitle.contains(item), "Title does not contains what was written in the search bar");
    }
}
