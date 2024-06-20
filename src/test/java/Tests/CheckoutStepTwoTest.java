package Tests;

import Base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class CheckoutStepTwoTest extends BaseTest {

    @BeforeMethod
    public void pageSetUp() {
        driver.manage().window().maximize();
        driver.get(links.saucedemoLink);
        successfulLogin();
    }

    @Test
    public void checkoutStepTwoPageLoadsCorrectly() {
        goToCheckoutStepTwoPage();
        Assert.assertTrue(checkoutStepTwoPage.summaryInformation.isDisplayed());
        Assert.assertTrue(checkoutStepTwoPage.priceTotalInformation.isDisplayed());
    }

    @Test
    public void cancelButton() {
        goToCheckoutStepTwoPage();
        checkoutStepTwoPage.clickOnCancelButton();
        Assert.assertEquals(getCurrentUrl(), links.inventoryLink);
    }

    @Test
    public void finishButton() {
        goToCheckoutStepTwoPage();
        checkoutStepTwoPage.clickOnFinishButton();
        Assert.assertEquals(getCurrentUrl(), links.checkoutCompleteLink);
        Assert.assertTrue(checkoutCompletePage.title.isDisplayed());
    }

    @Test
    public void navigationBackToCheckoutStepOnePage () {
        goToCheckoutStepTwoPage();
        goBack();
        Assert.assertEquals(getCurrentUrl(), links.checkoutStepOneLink);
        Assert.assertTrue(checkoutStepOnePage.continueButton.isDisplayed());
    }


}
