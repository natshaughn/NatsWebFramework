import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.*;

public class SampleTest {

    WebDriver driver;
    String baseUrl = "https://www.saucedemo.com/";

    @BeforeMethod
    public void setUp() {
        // Initialize ChromeDriver
        driver = new ChromeDriver();

        // Maximize the browser window
        driver.manage().window().maximize();

        // Navigate to the website
        driver.get(baseUrl);
    }

    @Test
    public void verifyLogoPresence() {
        // Locate the logo element on the homepage
        WebElement logo = driver.findElement(By.className("login_logo"));

        // Log some useful information about the logo element
        System.out.println("Located logo element: " + logo);

        // Assert that the logo is displayed
        Assert.assertTrue(logo.isDisplayed(), "Logo is not displayed on the homepage.");
    }

    @AfterMethod
    public void tearDown() {
        // Close the browser after the test
        driver.quit();
    }
}

