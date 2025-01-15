package driver;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.RemoteWebDriver;
import utility.ConfigReader;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;

public class DriverManager {
    private static WebDriver driver;

    public static WebDriver getDriver() {
        if (driver == null) {
            String jenkinsEnv = System.getenv("JENKINS_HOME");
            boolean isJenkins = jenkinsEnv != null;

            String browserType = ConfigReader.getProperty("browser").toLowerCase();
            String gridUrl = ConfigReader.getProperty("gridURL");

            if (isJenkins) {
                gridUrl = "http://selenium-hub:4444/wd/hub";
            }

            switch (browserType) {
                case "chrome":
                    WebDriverManager.chromedriver().setup();
                    driver = new ChromeDriver();
                    break;
                case  "firefox":
                    WebDriverManager.firefoxdriver().setup();
                    driver = new FirefoxDriver();
                    break;
                case "chromedocker":
                    ChromeOptions chromeOptions = new ChromeOptions();
                    chromeOptions.addArguments("--headless");
                    chromeOptions.addArguments("--no-sandbox");
                    try {
                        driver = new RemoteWebDriver(new URL(gridUrl), chromeOptions);
                    } catch (MalformedURLException e) {
                        e.printStackTrace();
                        throw new RuntimeException("Invalid Selenium Grid URL");
                    }
                    break;
                case "firefoxdocker":
                    FirefoxOptions firefoxOptions = new FirefoxOptions();
                    firefoxOptions.addArguments("--headless");
                    firefoxOptions.addArguments("--no-sandbox");
                    firefoxOptions.addArguments("--disable-dev-shm-usage");
                    try {
                        driver = new RemoteWebDriver(new URL(gridUrl), firefoxOptions);
                    } catch (MalformedURLException e) {
                        e.printStackTrace();
                        throw new RuntimeException("Invalid Selenium Grid URL");
                    }
                    break;
                default:
                    throw new IllegalArgumentException("Unsupported browser: " + browserType);
            }

            driver.manage().window().maximize();
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
            System.out.println("Initialised new WebDriver instance: " + driver);
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
