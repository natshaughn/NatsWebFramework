package pages;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Login {
    public static WebDriver driver;

    public static String loginButtonId = "login-button";
    public static String loginTitleXpath = "//div[@class='login_logo']";
    public static String PasswordId = "password";
    public static String standard_user = "standard_user";
    public static String usernameId = "user-name";

    public static void inputUsername() throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.get("https://www.saucedemo.com/");
        Thread.sleep(2000);
        driver.findElement(By.id(usernameId)).sendKeys(standard_user);
    }
}
