package pages;

import element.ElementWrapper;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Cart {
    private final ElementWrapper checkoutButton;

    public Cart(WebDriver driver) {
        this.checkoutButton = new ElementWrapper(driver, By.id("checkout"));
    }

    public void clickCheckoutButton() {
        checkoutButton.click();
    }
}
