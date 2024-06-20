package Pages;

import Base.BaseTest;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CheckoutStepOnePage extends BaseTest {
    public CheckoutStepOnePage() {
        PageFactory.initElements(driver, this);
    }

    @FindBy (id = "first-name")
    public WebElement firstNameField;

    @FindBy (id = "last-name")
    public WebElement lastNameField;

    @FindBy (id = "postal-code")
    public WebElement postalCodeField;

    @FindBy (id = "cancel")
    public WebElement cancelButton;

    @FindBy (id = "continue")
    public WebElement continueButton;

    @FindBy (css = ".error-message-container.error")
    public WebElement errorMessage;

    public void clickOnCancelButton() {
        cancelButton.click();
    }

    public void inputFistName(String firstName) {
        firstNameField.clear();
        firstNameField.sendKeys(firstName);
    }

    public void inputLastName(String lastName) {
        lastNameField.clear();
        lastNameField.sendKeys(lastName);
    }

    public void inputPostalCode(String postalCode) {
        postalCodeField.clear();
        postalCodeField.sendKeys(postalCode);
    }

    public void clickOnContinueButton() {
        continueButton.click();
    }






}
