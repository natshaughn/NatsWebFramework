package pages;

import element.ElementWrapper;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CheckoutStepOne {

    private final ElementWrapper continueButton;
    private final ElementWrapper firstNameInput;
    private final ElementWrapper lastNameInput;
    private final ElementWrapper postcodeInput;

    public CheckoutStepOne(WebDriver driver) {
        this.continueButton = new ElementWrapper(driver, By.id("continue"));
        this.firstNameInput = new ElementWrapper(driver, By.id("first-name"));
        this.lastNameInput = new ElementWrapper(driver, By.id("last-name"));
        this.postcodeInput = new ElementWrapper(driver, By.id("postal-code"));
    }

    public void clickContinueButton() {
        continueButton.click();
    }

    public void enterCustomerDetails(String firstname, String lastname, String postcode) {
        firstNameInput.sendKeys(firstname);
        lastNameInput.sendKeys(lastname);
        postcodeInput.sendKeys(postcode);
    }
}
