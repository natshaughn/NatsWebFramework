package pages;

import element.ElementWrapper;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Login {
    private WebDriver driver;

    private ElementWrapper usernameInput;
    private ElementWrapper passwordInput;
    private ElementWrapper loginButton;
    private ElementWrapper loginTitle;

    public Login(WebDriver driver) {
        this.driver = driver;
        this.usernameInput = new ElementWrapper(driver, By.id("user-name"));
        this.passwordInput = new ElementWrapper(driver, By.id("password"));
        this.loginButton = new ElementWrapper(driver, By.id("login-button"));
        this.loginTitle = new ElementWrapper(driver, By.xpath("//div[@class='login_logo']"));
    }

    public void inputUsername(String username) {
        usernameInput.sendKeys(username);
    }

    public void inputPassword(String password) {
        passwordInput.sendKeys(password);
    }

    public void clickLoginButton() {
        loginButton.click();
    }

    public String getLoginPageTitle() {
        return loginTitle.getText();
    }

    public void loginToSwagLabs(String username, String password) {
        inputUsername(username);
        inputPassword(password);
        clickLoginButton();
    }

}
