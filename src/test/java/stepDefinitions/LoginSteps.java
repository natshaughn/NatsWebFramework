package stepDefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import pages.Login;
import driver.DriverManager;
import static org.junit.Assert.assertEquals;

public class LoginSteps {
    private final Login login;

    public LoginSteps() {
        WebDriver driver = DriverManager.getDriver();
        login = new Login(driver);
    }

    @Given("^I am on the login page$")
    public void iAmOnTheLoginPage() {
        String actualTitle = login.getLoginPageTitle();
        String expectedTitle = "Swag Labs";
        System.out.println("Actual Title: " + actualTitle);
        System.out.println("Expected Title: " + expectedTitle);
        assertEquals("Expected login page title", expectedTitle, actualTitle);
    }

    @Given("^I have logged in$")
    public void iHaveLoggedIn() {
        iAmOnTheLoginPage();
        login.loginToSwagLabs("standard_user", "secret_sauce");
    }

    @When("^I enter the username '([^']*)'$")
    public void whenIEnterTheUsername(String username) {
        login.inputUsername(username);
        System.out.println("Username: " + username);
    }

    @When("^I enter the password '([^']*)'$")
    public void whenIEnterThePassword(String password) {
        login.inputPassword(password);
        System.out.println("Password: " + password);
    }

    @When("^I click the login button$")
    public void whenIClickTheLoginButton() {
        login.clickLoginButton();
    }

    @Then("^an error message should appear$")
    public void anErrorMessageShouldAppear() {
        String actualMessage = login.getErrorMessage();
        String expectedMessage = "Epic sadface: Username and password do not match any user in this service";
        System.out.println("Actual msg: " + actualMessage);
        System.out.println("Expected msg: " + expectedMessage);
        Assert.assertEquals("The error message is incorrect", expectedMessage, actualMessage);
    }
}
