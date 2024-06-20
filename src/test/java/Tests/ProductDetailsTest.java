package Tests;

import Base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;


public class ProductDetailsTest extends BaseTest {

    @BeforeMethod
    public void pageSetUp() {
        driver.manage().window().maximize();
        driver.get(links.saucedemoLink);
        successfulLogin();
    }

    @Test
    public void productDetails() {
        productListingPage.openRandomProductDetails();
        Assert.assertTrue(productDetailsPage.backToProductsButton.isDisplayed());
        Assert.assertTrue(productDetailsPage.inventoryName.isDisplayed());
    }


    @Test
    public void backToProducts() {
        productListingPage.openRandomProductDetails();
        productDetailsPage.clickOnBackToProductsButton();
        Assert.assertEquals(getCurrentUrl(), links.inventoryLink);
        Assert.assertTrue(productListingPage.titlePage.isDisplayed());
    }

    @Test
    public void addToCart() {
        productListingPage.openRandomProductDetails();
        productDetailsPage.clickOnAddToCartButton();
        Assert.assertTrue(productDetailsPage.removeButton.isDisplayed());
        Assert.assertEquals(productListingPage.cartBage.getText(), "1");
    }




}
