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
    private Login login;
    private WebDriver driver;

    public LoginSteps() {
        driver = DriverManager.getDriver();
        login = new Login(driver);
    }

    @Given("^I am on the login page$")
    public void iAmOnTheLoginPage() {
        driver.get("https://www.saucedemo.com/");
        String actualTitle = login.getLoginPageTitle();
        String expectedTitle = "Swag Labs";
        System.out.println("actual title" + actualTitle);
        System.out.println("expected title" + expectedTitle);
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
        System.out.println("username" + username);
    }

    @When("^I enter the password '([^']*)'$")
    public void whenIEnterThePassword(String password) {
        login.inputPassword(password);
        System.out.println("password" + password);
    }

    @When("^I click the login button$")
    public void whenIClickTheLoginButton() {
        login.clickLoginButton();
    }

    @Then("^an error message should appear$")
    public void anErrorMessageShouldAppear() {
        String actualMessage = login.getErrorMessage();
        String expectedMessage = "Epic sadface: Username and password do not match any user in this service";
        System.out.println("actual msg" + actualMessage);
        System.out.println("expected msg" + expectedMessage);
        Assert.assertEquals("The error message is incorrect", expectedMessage, actualMessage);
    }

}
