package Tests;

import Base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class CheckoutCompleteTest extends BaseTest {

    @BeforeMethod
    public void pageSetUp() {
        driver.manage().window().maximize();
        driver.get(links.saucedemoLink);
        successfulLogin();
    }

    @Test
    public void checkoutCompletePageLoadsCorrectly() {
        goToCheckoutCompletePage();
        Assert.assertTrue(checkoutCompletePage.title.isDisplayed());
        Assert.assertEquals(checkoutCompletePage.header.getText(), "Thank you for your order!");
        Assert.assertEquals(checkoutCompletePage.text.getText(), "Your order has been dispatched, and will arrive just as fast as the pony can get there!");
    }

    @Test
    public void backHome() {
        goToCheckoutCompletePage();
        checkoutCompletePage.clickOnBackHomeButton();
        Assert.assertEquals(getCurrentUrl(), links.inventoryLink);
    }

    @Test
    public void navigationBackToCheckoutStepTwoPage() {
        goToCheckoutCompletePage();
        goBack();
        Assert.assertEquals(getCurrentUrl(),links.checkoutStepTwoLink);
        Assert.assertTrue(checkoutStepTwoPage.finishButton.isDisplayed());
    }



}
