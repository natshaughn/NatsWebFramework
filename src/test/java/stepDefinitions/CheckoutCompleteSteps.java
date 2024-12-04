package stepDefinitions;

import driver.DriverManager;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import pages.CheckoutComplete;

import java.util.UUID;

public class CheckoutCompleteSteps {
    private final CheckoutComplete checkoutComplete;

    public CheckoutCompleteSteps() {
        WebDriver driver = DriverManager.getDriver();
        checkoutComplete = new CheckoutComplete(driver);
    }

    @And("^I complete the checkout process$")
    public void iCompleteTheCheckoutProcess() {
        String firstname = UUID.randomUUID().toString();
        String lastname = UUID.randomUUID().toString();
        String postcode = UUID.randomUUID().toString();
        System.out.println("Firstname: " + firstname);
        System.out.println("Lastname: " + lastname);
        System.out.println("Postcode: " + postcode);
        checkoutComplete.completeCheckoutProcess(firstname, lastname, postcode);
    }

    @Then("^a message will appear confirming my order$")
    public void aMessageWillAppearConfirmingMyOrder() {
        String actualMessage = checkoutComplete.getCheckoutCompleteMessage();
        String expectedMessage = "Thank you for your order!";
        Assert.assertEquals("The confirmation message is incorrect", expectedMessage, actualMessage);
        System.out.println("actual message.. " + actualMessage);
        System.out.println("expected message.. " + expectedMessage);
    }
}
