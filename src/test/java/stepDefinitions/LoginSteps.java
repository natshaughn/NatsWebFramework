package stepDefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import pages.Login;
import driver.DriverManager;
import static org.junit.Assert.assertEquals;

public class LoginSteps {
    private Login login;
    private WebDriver driver;

    public LoginSteps() {
        driver = DriverManager.getDriver(); // Assuming you are managing the driver here
        login = new Login(driver); // Initialize the Login page with the driver
    }

    @Given("^I am on the login page$")
    public void iAmOnTheLoginPage() {
        driver.get("https://www.saucedemo.com/");
        String actualTitle = login.getLoginPageTitle();
        String expectedTitle = "Swag Labs";
        assertEquals("Expected login page title", expectedTitle, actualTitle);
    }

    @When("^I enter the username '([^']*)'$")
    public void whenIEnterTheUsername(String username) {
        login.inputUsername(username);
    }

    @When("^I enter the password '([^']*)'$")
    public void whenIEnterThePassword(String password) {
        login.inputPassword(password);
    }

    @When("^I click the login button$")
    public void whenIClickTheLoginButton() {
        login.clickLoginButton();
    }

}
