package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginPage extends BasePage{

    // Locators for the login page elements
    private final By usernameField = By.id("formBasicUsername");
    private final By passwordField = By.id("formBasicPassword");
    private final By loginButton = By.xpath("//button[text()='Login']");


    // Method to perform the login action with provided credentials
    public void login(String username, String password) {
        // Locate the username input, clear any existing text, and type the username
        WebElement usernameElement = driver.findElement(usernameField);
        usernameElement.clear();
        usernameElement.sendKeys(username);

        // Locate the password input, clear it, and type the password
        WebElement passwordElement = driver.findElement(passwordField);
        passwordElement.clear();
        passwordElement.sendKeys(password);

        // Locate and click the login button to submit the login form
        driver.findElement(loginButton).click();
    }
}


