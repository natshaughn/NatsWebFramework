package hook;

import driver.DriverManager;
import io.cucumber.java.After;
import io.cucumber.java.AfterStep;
import io.cucumber.java.Before;
import io.cucumber.java.BeforeStep;
import org.openqa.selenium.WebDriver;
import utility.ConfigReader;

public class Hooks {
    @Before
    public void setUp() {
        String baseUrl = ConfigReader.getProperty("baseURL");
        WebDriver driver = DriverManager.getDriver();
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
    public void afterStep() {
        System.out.println("Executing after each step...");
    }
}
