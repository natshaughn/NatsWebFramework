package stepDefinitions;

import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;
import org.openqa.selenium.WebDriver;
import pages.Inventory;
import driver.DriverManager;
import static org.junit.Assert.assertEquals;

public class InventorySteps {
    private Inventory inventory;
    private WebDriver driver;

    public InventorySteps() {
        driver = DriverManager.getDriver();
        inventory = new Inventory(driver);
    }

    @When("^I click the cart button$")
    public void whenIClickTheCartButton() {
        inventory.clickCartButton();
    }

    @Then("^I am on the inventory page$")
    public void thenIAmOnTheInventoryPage() {
        String actualTitle = inventory.getInventoryPageTitle();
        String expectedTitle = "Products";
        assertEquals("Expected inventory page title", expectedTitle, actualTitle);
    }
}
