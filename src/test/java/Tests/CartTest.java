package Tests;

import Base.BaseTest;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class CartTest extends BaseTest {

    @BeforeMethod
    public void pageSetUp() {
        driver.manage().window().maximize();
        driver.get(links.saucedemoLink);
        successfulLogin();
    }

    @Test
    public void cartIconNavigation () {
        cartPage.clickOnCartIcon();
        Assert.assertEquals(cartPage.getCurrentURL(), links.cartLink);
        Assert.assertTrue(cartPage.cartFooter.isDisplayed());
    }

    @Test
    public void removeFromCart() {
        productListingPage.addToCartOneItem();
        cartPage.clickOnCartIcon();
        cartPage.removeFistFromCart();
        Assert.assertTrue(productListingPage.cartItems.isEmpty());
    }

    @Test
    public void continueShoppingButton() {
        cartPage.clickOnCartIcon();
        cartPage.clickContinueShoppingButton();
        Assert.assertEquals(getCurrentUrl(), links.inventoryLink);
    }

    @Test
    public void checkoutButton() {
        cartPage.clickOnCartIcon();
        cartPage.clickCheckoutButton();
        Assert.assertEquals(getCurrentUrl(), links.checkoutStepOneLink);
    }

    @Test
    public void verifyCartItemDetails() {
        productListingPage.addToCartOneItem();
        cartPage.clickOnCartIcon();
        Assert.assertEquals(cartPage.inventoryName.getText(), "Sauce Labs Backpack");
        Assert.assertEquals(cartPage.inventoryDescription.getText(), "carry.allTheThings() with the sleek, streamlined Sly Pack that melds uncompromising style with unequaled laptop and tablet protection.");
        Assert.assertEquals(cartPage.inventoryPrice.getText(), "$29.99");
    }

    @Test
    public void removeAllItemsFromCart() {
        productListingPage.addAllItemsToCart();
        cartPage.clickOnCartIcon();
        cartPage.removeAllItemsFromCart();
        Assert.assertTrue(productListingPage.cartItems.isEmpty());
    }

    @Test
    public void cartStateAfterLogoutAndLogin() {
        productListingPage.addToCartTwoItems();
        cartPage.clickOnCartIcon();
        String numberOfItems = productListingPage.cartBage.getText();
        visibleSidebar();
        productListingPage.clickOnLogoutButton();
        successfulLogin();
        Assert.assertEquals(productListingPage.cartBage.getText(), numberOfItems);
    }




}
