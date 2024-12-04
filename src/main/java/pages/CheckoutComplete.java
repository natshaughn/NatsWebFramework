package pages;

import element.ElementWrapper;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CheckoutComplete {
    private final Cart cart;
    private final CheckoutStepOne checkoutStepOne;
    private final CheckoutStepTwo checkoutStepTwo;
    private final Inventory inventory;
    private final ElementWrapper checkoutCompleteMsg;

    public CheckoutComplete(WebDriver driver) {
        this.checkoutCompleteMsg = new ElementWrapper(driver, By.xpath("//div/h2"));
        cart = new Cart(driver);
        checkoutStepOne = new CheckoutStepOne(driver);
        checkoutStepTwo = new CheckoutStepTwo(driver);
        inventory = new Inventory(driver);
    }

    public void completeCheckoutProcess(String firstname, String lastname, String postcode) {
        inventory.clickCartButton();
        cart.clickCheckoutButton();
        checkoutStepOne.enterCustomerDetails(firstname, lastname, postcode);
        checkoutStepOne.clickContinueButton();
        checkoutStepTwo.clickFinishButton();
    }

    public String getCheckoutCompleteMessage() {
        return checkoutCompleteMsg.getText();
    }
}
