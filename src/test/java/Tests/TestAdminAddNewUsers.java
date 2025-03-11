package Tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.junit.Before;
import org.junit.Test;
import org.junit.Assert;
import org.junit.After;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

public class TestAdminAddNewUsers {
    private WebDriver driver;
    WebDriverWait wait;

    @Before
    public void setUp() {
        // Set path for ChromeDriver to be executed
        driver = new ChromeDriver();

        // Opens admin login page
        driver.get("https://d2vo1vcw0l31zb.cloudfront.net/login");
    }

    @Test
    public void testAddNewUser() {
        // -- Login Process --

        // Locate username, password fields and the Login button
        WebElement usernameField = driver.findElement(By.id("formBasicUsername"));
        WebElement passwordField = driver.findElement(By.id("formBasicPassword"));
        WebElement loginButton = driver.findElement(By.xpath("//button[@class='w-100 btn btn-primary' and text()='Login']"));

        // Input admin credentials
        usernameField.sendKeys("admin");
        passwordField.sendKeys("admin");
        loginButton.click();

        // -- Navigation to Add New User Page --

        // Get to Admin Dashboard

        // Initialise explicit wait
        wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        WebElement adminDashboard = driver.findElement(By.xpath("//a[@href='/admin']"));
        adminDashboard.click();

        // Get to User Management
        // Initialise explicit wait
        wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        WebElement userManagement = driver.findElement(By.className("mb-3 Admin_customButton__jJ28m btn btn-outline-primary"));
        userManagement.click();

        // Register New User
        // Initialise explicit wait
        wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        WebElement newUser = driver.findElement(By.className("btn btn-success"));

        // -- Fill in New User form --

        // Locate form fields for New User's details
        WebElement newUserName = driver.findElement(By.id("formBasicUsername"));
        WebElement newUserEmail = driver.findElement(By.id("formBasicEmail"));
        WebElement newUserPassword = driver.findElement(By.id("formBasicPassword"));
        // Locate submit button
        WebElement registerUserButton = driver.findElement(By.className("w-100 btn btn-primary"));

        // Input new user's details
        newUserName.sendKeys("Test User");
        newUserEmail.sendKeys("testuser@gmail.com");
        newUserPassword.sendKeys("password");
        // Submit form to register new user
        registerUserButton.click();

        // -- Verification of New User --

        // Wait for up to 10 seconds for success alert to be visible
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement successAlert = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@role='alert' and contains(text(), 'Registration successful!')]")));

        // Assert that the alert is displayed
        Assert.assertTrue("Success alert is now displayed", successAlert.isDisplayed());

        // Verify the text matches the alert "Registration successful!"
        String expectedText = "Registration successful!";
        String actualText = successAlert.getText();
        Assert.assertEquals("Success alert text does not match", expectedText, actualText);

    }

    @After
    public void tearDown() {
        driver.quit();
    }

}
