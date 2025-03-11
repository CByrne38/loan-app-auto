package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage extends BasePage {

    private static final String URL = "https://d2vo1vcw0l31zb.cloudfront.net/";

    // Locator for the Loan Application link on the homepage
    private By loanApplicationLink = By.className("mb-3 Home_customButton__8cVdM btn btn-primary");

    // Navigate to the home page URL
    public void goTo() {
        driver.get(URL);
    }

    // Click the Loan Application link & navigate to page
    public void navigateToLoanApplicationPage() {
        driver.findElement(loanApplicationLink).click();
    }

}
