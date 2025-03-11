package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoanApplicationPage extends BasePage{

    private final By applicantFirstNameField = By.id("formFirstName");
    private final By applicantLastNameField = By.id("formLastName");
    private final By ageField = By.id("formAge");
    private final By addressLine1Field = By.id("formAddressLine1");
    private final By addressLine2Field = By.id("formAddressLine2");
    private final By postcodeField = By.id("formPostCode");
    private final By emailField = By.id("formEmail");
    private final By loanAmountField = By.id("formLoanAmount");
    private final By submitApplicationButton = By.className("btn btn-primary");
    private final By successMessageLocator = By.xpath("//p[@class='lead' and text()='The initial application has been successful.']");


    // Fills in the loan application form with provided data
    public void fillForm(String applicantFirstName, String applicantLastName, String age, String addressLine1,
                         String addressLine2, String postcode, String email, String loanAmount) {
        driver.findElement(applicantFirstNameField).sendKeys(applicantFirstName);
        driver.findElement(applicantLastNameField).sendKeys(applicantLastName);
        driver.findElement(ageField).sendKeys(age);
        driver.findElement(addressLine1Field).sendKeys(addressLine1);
        driver.findElement(addressLine2Field).sendKeys(addressLine2);
        driver.findElement(postcodeField).sendKeys(postcode);
        driver.findElement(emailField).sendKeys(email);
        driver.findElement(loanAmountField).sendKeys(loanAmount);
    }

    // Submits the loan application form
    public void submitForm() {
        driver.findElement(submitApplicationButton).click();
    }

    // Checks if Loan Application was submitted successfully
    public boolean isLoanSubmittedSuccessfully() {
        WebElement successMessage = driver.findElement(successMessageLocator);
        return successMessage.isDisplayed();
    }
}
