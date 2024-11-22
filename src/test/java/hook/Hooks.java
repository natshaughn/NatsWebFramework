package hook;

import driver.DriverManager;
import io.cucumber.java.After;
import io.cucumber.java.AfterStep;
import io.cucumber.java.Before;
import io.cucumber.java.BeforeStep;
import org.openqa.selenium.WebDriver;

public class Hooks {
    @Before
    public void beforeScenario() {
        WebDriver driver = DriverManager.getDriver();
        System.out.println("Before Scenario: WebDriver initialized");
    }

    @After
    public void afterScenario() {
        System.out.println("After Scenario: WebDriver closed");
        DriverManager.closeDriver();
    }

    @AfterStep
    public void afterStep() {
        WebDriver driver = DriverManager.getDriver();
        System.out.println("After Step: Log or Screenshot (if needed)");
    }

    @BeforeStep
    public void beforeStep() {
        System.out.println("Before Step: Setup before each step (optional)");
    }
}
