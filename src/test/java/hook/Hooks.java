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
        System.out.println("Starting scenario...");
        WebDriver driver = DriverManager.getDriver();
    }

    @After
    public void afterScenario() {
        System.out.println("Ending scenario...");
        DriverManager.closeDriver();
    }

    @BeforeStep
    public void beforeStep() {
        System.out.println("Before Step...");
    }

    @AfterStep
    public void afterStep() {
        WebDriver driver = DriverManager.getDriver();
        System.out.println("After Step...");
    }
}
