package pages;

import element.ElementWrapper;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Login {
    private WebDriver driver;

    private ElementWrapper loginButton;
    private ElementWrapper loginErrorMsg;
    private ElementWrapper loginTitle;
    private ElementWrapper passwordInput;
    private ElementWrapper usernameInput;

    public Login(WebDriver driver) {
        this.driver = driver;

        this.loginButton = new ElementWrapper(driver, By.id("login-button"));
        this.loginErrorMsg = new ElementWrapper(driver, By.xpath("//div/h3"));
        this.loginTitle = new ElementWrapper(driver, By.xpath("//div[@class='login_logo']"));
        this.passwordInput = new ElementWrapper(driver, By.id("password"));
        this.usernameInput = new ElementWrapper(driver, By.id("user-name"));
    }

    public void clickLoginButton() {
        loginButton.click();
    }

    public String getErrorMessage() {
        return loginErrorMsg.getText();
    }

    public String getLoginPageTitle() {
        return loginTitle.getText();
    }

    public void inputPassword(String password) {
        passwordInput.sendKeys(password);
    }

    public void inputUsername(String username) {
        usernameInput.sendKeys(username);
    }

    public void loginToSwagLabs(String username, String password) {
        inputUsername(username);
        inputPassword(password);
        clickLoginButton();
    }

}
