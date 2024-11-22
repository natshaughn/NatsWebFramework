package driver;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class DriverManager {
    private static WebDriver driver;

    // Method to set up and get the driver
    public static WebDriver getDriver() {
        if (driver == null) {
            WebDriverManager.chromedriver().setup();
            driver = new ChromeDriver();
            driver.manage().window().maximize(); // Maximize the window for better visibility
            System.out.println("Driver initialized: " + driver);
        }
        return driver;
    }

    // Method to quit the driver
    public static void closeDriver() {
        if (driver != null) {
            driver.quit(); // Close the browser window
            driver = null; // Set the driver reference to null after quitting
            System.out.println("Driver closed: " + driver);
        }
    }
}
