package element;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ElementWrapper {
    private final WebDriver driver;
    private final By by;

    public ElementWrapper(WebDriver driver, By by) {
        this.driver = driver;
        this.by = by;
    }

    public void click() {
        findElement().click();
    }

    public WebElement findElement() {
        return driver.findElement(by);
    }

    public String getText() {
        return findElement().getText();
    }

    public void sendKeys(String text) {
        findElement().sendKeys((text));
    }
}
