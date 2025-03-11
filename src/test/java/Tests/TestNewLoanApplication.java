package Tests;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pageObjects.HomePage;
import pageObjects.LoanApplicationPage;

public class TestNewLoanApplication {

    private WebDriver driver;
    private HomePage homePage;
    private LoanApplicationPage loanApplicationPage;

    @org.junit.Test
    @Before
    public void setUp() {
        // Initialise the WebDriver
        System.setProperty("webdriver.chrome.driver", "path/to/chromedriver");
        driver = new ChromeDriver();

        // Instantiate the page objects using the same driver
        homepage = new HomePage();
        loanApplicationPage = new LoanApplicationPage();
    }
    private HomePage homepage = new HomePage();

    @org.junit.Test
    @Test
    public void testAddValidLoanApplication() {
        // Navigate to the homepage
        homepage.goTo();

        // Naviagte to the Loan Application page
        homepage.navigateToLoanApplicationPage();

        // Use the LoanApplicationPage object to fill out the application form
        loanApplicationPage.fillForm("Conor", "Byrne", "26", "abc", "def", "123",
                "abc@123.com", "20000");

        // Submit the form
        loanApplicationPage.submitForm();

        // Verify the Loan Application was submitted successfully
        Assert.assertTrue("Loan application was not submitted successfully",
                loanApplicationPage.isLoanSubmittedSuccessfully());
    }


    @org.junit.Test
    @After
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}
