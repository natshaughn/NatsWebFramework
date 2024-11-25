package driver;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class DriverManager {
    private static WebDriver driver;

    public static WebDriver getDriver() {
        if (driver == null) {
            WebDriverManager.chromedriver().setup();
            driver = new ChromeDriver();
            driver.manage().window().maximize();
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
            System.out.println("Initialized new WebDriver instance: " + driver);
        } else {
            System.out.println("Reusing existing WebDriver instance: " + driver);
        }
        return driver;
    }

    public static void closeDriver() {
        if (driver != null) {
            System.out.println("Closing WebDriver instance: " + driver);
            driver.quit();
            driver = null;
        }
    }
}
