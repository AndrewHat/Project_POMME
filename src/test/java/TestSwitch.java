import PageObject.HomePage;
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

        Assert.assertTrue(productTitle.contains(item), "Title does not contains: " + item);
    }

    @Test
    public void testMultipleSearch() {
        // Arrange
        String ps5 = "PlayStation 5";
        String nin = "Nintendo Switch";
        String xbox = "Xbox";

        // Act
        HomePage amazonHomePage = new HomePage(driver);
        String title = amazonHomePage.search(ps5)
                .openResult(0)
                .search(nin)
                .openResult(5)
                .search(xbox)
                .openResult(2)
                .getProductTitle();

        // Assert
        Assert.assertTrue(title.contains(xbox), "Title does not contains: " + xbox);
    }

    @Test
    public void openAccountList() {
        HomePage amazonHomePage = new HomePage(driver);
        amazonHomePage.openAccountList();
    }
}
