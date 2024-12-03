package stepDefinitions;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import pages.Inventory;
import driver.DriverManager;
import utility.CSVReader;

import java.util.Map;

import static org.junit.Assert.assertEquals;

public class InventorySteps {
    private Inventory inventory;
    private WebDriver driver;

    public InventorySteps() {
        driver = DriverManager.getDriver();
        inventory = new Inventory(driver);
    }

    @When("^I add '([^']*)' to cart$")
    public void iAddProductToCart(String product) {
        inventory.addProductToCart(product);
        System.out.println("Product: " + product);
    }

    @Then("^I am on the inventory page$")
    public void thenIAmOnTheInventoryPage() {
        String actualTitle = inventory.getInventoryPageTitle();
        String expectedTitle = "Products";
        assertEquals("Expected inventory page title did not match", expectedTitle, actualTitle);
        System.out.println("Actual message.. " + actualTitle);
        System.out.println("Expected message.. " + expectedTitle);
    }

    @Then("^the price of all products will be correct")
    public void thePriceOfAllProductsWillBeCorrect() {
        CSVReader csvReader = new CSVReader();

        Map<String, String> productPricesFromCSV = csvReader.readCSV("src/test/resources/SauceLabsPriceList.csv");

        for (Map.Entry<String, String> entry : productPricesFromCSV.entrySet()) {
            String productName = entry.getKey();
            String expectedPrice = entry.getValue();

            String actualPrice = inventory.getProductPrice(productName);

            assertEquals("Price for product " + productName + " doesn't match", expectedPrice, actualPrice);

            System.out.println("ProductName: " + productName);
            System.out.println("Expected price: " + expectedPrice);
            System.out.println("Actual price: " + actualPrice);
        }
    }
}
