package Tests;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import pageObjects.LoginPage;

import java.time.Duration;

public class TestLogin {
    private WebDriver driver;
    private WebDriverWait wait;

    // This method runs before each test, setting up WebDriver & navigating to login page
    @Before
    public void setUp() {
        driver = new ChromeDriver();

        // Initialise explicit wait
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        // Navigate to login page
        driver.get("https://d2vo1vcw0l31zb.cloudfront.net/login");
    }

    @Test
    public void testLogin() {
        // Create instance of LoginPage
        LoginPage loginPage = new LoginPage();

        // Initialise explicit wait
        wait = new WebDriverWait(driver, Duration.ofSeconds(5));

        // Perform login using valid credentials
        loginPage.login("user", "user");

        // Initialise explicit wait
        wait = new WebDriverWait(driver, Duration.ofSeconds(5));

        // Wait for post-login element (element ClassName "LoanApplicationPortal") to ensure login success
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("mb-4 Home_header__1Nkvr")));

        // Verify the post-login element is displayed
        Assert.assertTrue("Loan Application Portal is not displayed after login",
                driver.findElement(By.className("mb-4 Home_header__1Nkvr")).isDisplayed());
    }

    @After
    public void tearDown() {
        // Quitting driver
        if (driver != null) {
            driver.quit();
        }
    }
}
