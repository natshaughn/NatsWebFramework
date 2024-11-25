package pages;

import element.ElementWrapper;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Inventory {
    private WebDriver driver;

    private ElementWrapper cartButton;
    private ElementWrapper inventoryTitle;

    public Inventory(WebDriver driver) {
        this.driver = driver;
        this.cartButton = new ElementWrapper(driver, By.xpath("//a[@class='shopping_cart_link']"));
        this.inventoryTitle = new ElementWrapper(driver, By.xpath("//span[@class='title']"));
    }

    public ElementWrapper productElement(String product) {
        return new ElementWrapper(driver, By.xpath(String.format("//*[@id='add-to-cart-%s']", product)));
    }

    public ElementWrapper productName(String product) {
        return new ElementWrapper(driver, By.xpath(String.format("//div[contains(@class, 'inventory_item') and contains(text(), '%s')]", product)));
    }

    public ElementWrapper productPrice(String product) {
        return new ElementWrapper(driver, By.xpath(String.format(
                "//div[contains(@class, 'inventory_item') and .//div[contains(text(), '%s')]]//div[contains(@class, 'inventory_item_price')]",
                product
        )));
    }

    public void addProductToCart(String product) {
        productElement(product).click();
    }

    public void clickCartButton() {
        cartButton.click();
    }

    public String getInventoryPageTitle() {
        return inventoryTitle.getText();
    }

    public String getProductName(String product) {
        return productName(product).getText();
    }

    public String getProductPrice(String product) {
        return productPrice(product).getText().replace("$", "").trim();
    }
}

