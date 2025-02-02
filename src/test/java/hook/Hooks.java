package hook;

import driver.DriverManager;
import io.cucumber.java.*;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import utility.ConfigReader;

public class Hooks {
    private WebDriver driver;

    @Before
    public void setUp() {
        String baseUrl = ConfigReader.getProperty("baseURL");
        driver = DriverManager.getDriver();
        driver.get(baseUrl);
        System.out.println("Navigating to base URL: " + baseUrl);
    }

    @After
    public void tearDown() {
        DriverManager.closeDriver();
        System.out.println("WebDriver closed after scenario.");
    }

    @BeforeStep
    public void beforeStep() {
        System.out.println("Executing before each step...");
    }

    @AfterStep
    public void afterStep(Scenario scenario) {
        System.out.println("Executing after each step...");
        if (scenario.isFailed()) {
            captureScreenshot(scenario);
        }
    }

    private void captureScreenshot(Scenario scenario) {
        try {
            TakesScreenshot screenshotTaker = (TakesScreenshot) driver;
            byte[] screenshotBytes = screenshotTaker.getScreenshotAs(OutputType.BYTES);
            scenario.attach(screenshotBytes, "image/png", "Failure Screenshot");
        } catch (Exception e) {
            System.err.println("Failed to capture screenshot: " + e.getMessage());
        }
    }
}
