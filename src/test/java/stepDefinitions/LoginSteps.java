package stepDefinitions;

import io.cucumber.java.en.Given;

import static pages.Login.*;

public class LoginSteps {
    @Given("^I am on the login page$")
    public void iAmOnTheLoginPage() throws InterruptedException {
        inputUsername();
    }
}
