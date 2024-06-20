package Tests;

import Base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class CheckoutStepOneTest extends BaseTest {

    @BeforeMethod
    public void pageSetUp() {
        driver.manage().window().maximize();
        driver.get(links.saucedemoLink);
        successfulLogin();
    }

    @Test
    public void verifyCheckoutLoadsCorrectly () {
        cartPage.clickOnCartIcon();
        cartPage.clickCheckoutButton();
        Assert.assertTrue(checkoutStepOnePage.firstNameField.isDisplayed());
        Assert.assertTrue(checkoutStepOnePage.lastNameField.isDisplayed());
        Assert.assertTrue(checkoutStepOnePage.postalCodeField.isDisplayed());
    }

    @Test
    public void cancelButton() {
        goToCheckoutStepOnePage();
        checkoutStepOnePage.clickOnCancelButton();
        Assert.assertTrue(cartPage.continueShoppingButton.isDisplayed());
        Assert.assertEquals(getCurrentUrl(), links.cartLink);
    }

    @Test
    public void  validInformationEntryAndNavigationToCheckoutStepTwo() {
        goToCheckoutStepOnePage();
        checkoutStepOnePage.inputFistName("Marko");
        checkoutStepOnePage.inputLastName("Markovic");
        checkoutStepOnePage.inputPostalCode("11000");
        checkoutStepOnePage.clickOnContinueButton();
        Assert.assertEquals(getCurrentUrl(), links.checkoutStepTwoLink);
        Assert.assertTrue(checkoutStepTwoPage.finishButton.isDisplayed());
    }

    @Test
    public void errorMessageForMissingFirstName () {
        goToCheckoutStepOnePage();
        checkoutStepOnePage.inputLastName("Markovic");
        checkoutStepOnePage.inputPostalCode("11000");
        checkoutStepOnePage.clickOnContinueButton();
        Assert.assertEquals(checkoutStepOnePage.errorMessage.getText(), "Error: First Name is required");
    }

    @Test
    public void errorMessageForMissingLastName () {
        goToCheckoutStepOnePage();
        checkoutStepOnePage.inputFistName("Marko");
        checkoutStepOnePage.inputPostalCode("11000");
        checkoutStepOnePage.clickOnContinueButton();
        Assert.assertEquals(checkoutStepOnePage.errorMessage.getText(), "Error: Last Name is required");
    }

    @Test
    public void errorMessageForMissingPostalCode () {
        goToCheckoutStepOnePage();
        checkoutStepOnePage.inputFistName("Marko");
        checkoutStepOnePage.inputLastName("Markovic");
        checkoutStepOnePage.clickOnContinueButton();
        Assert.assertEquals(checkoutStepOnePage.errorMessage.getText(), "Error: Postal Code is required");
    }

}
