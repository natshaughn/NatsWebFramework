package stepDefinitions;

import driver.DriverManager;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import pages.CheckoutComplete;

import java.util.UUID;

public class CheckoutCompleteSteps {
    private WebDriver driver;
    private CheckoutComplete checkoutComplete;

    public CheckoutCompleteSteps() {
        driver = DriverManager.getDriver();
        checkoutComplete = new CheckoutComplete(driver);
    }

    @And("^I complete the checkout process$")
    public void iCompleteTheCheckoutProcess() {
        String firstname = UUID.randomUUID().toString();
        String lastname = UUID.randomUUID().toString();
        String postcode = UUID.randomUUID().toString();
        checkoutComplete.completeCheckoutProcess(firstname, lastname, postcode);
    }

    @Then("^a message will appear confirming my order$")
    public void aMessageWillAppearConfirmingMyOrder() {
        String actualMessage = checkoutComplete.getCheckoutCompleteMessage();

        String expectedMessage = "Thank you for your order!";

        Assert.assertEquals("The confirmation message is incorrect", expectedMessage, actualMessage);
    }
}
