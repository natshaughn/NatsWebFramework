package pages;

import element.ElementWrapper;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Cart {
    private WebDriver driver;

    private ElementWrapper checkoutButton;

    public Cart(WebDriver driver) {
        this.driver = driver;

        this.checkoutButton = new ElementWrapper(driver, By.id("checkout"));
    }

    public void clickCheckoutButton() {
        checkoutButton.click();
    }
}
