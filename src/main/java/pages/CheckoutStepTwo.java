package pages;

import element.ElementWrapper;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CheckoutStepTwo {

    private final ElementWrapper finishButton;

    public CheckoutStepTwo(WebDriver driver) {
        this.finishButton = new ElementWrapper(driver, By.id("finish"));
    }

    public void clickFinishButton() {
        finishButton.click();
    }
}
