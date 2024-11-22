package pages;

import element.ElementWrapper;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Inventory {
    private WebDriver driver;

    private ElementWrapper inventoryTitle;
    private ElementWrapper cartButton;

    public Inventory(WebDriver driver) {
        this.driver = driver;
        this.inventoryTitle = new ElementWrapper(driver, By.xpath("//span[@class='title']"));
        this.cartButton = new ElementWrapper(driver, By.xpath("//a[@class='shopping_cart_link']"));
    }

    public String getInventoryPageTitle() {
        return inventoryTitle.getText();
    }

    public void clickCartButton() {
        cartButton.click();
    }
}

