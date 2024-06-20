package Tests;

import Base.BaseTest;
import Pages.LoginPage;
import Pages.ProductListingPage;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;

public class AddToCartTest extends BaseTest {

    @BeforeMethod
    public void pageSetUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        loginPage=new LoginPage();
        productListingPage=new ProductListingPage();

        driver.manage().window().maximize();
        driver.get(links.saucedemoLink);
        successfulLogin();
    }

    @Test
    public void addToCartFunctionality() {
        productListingPage.addToCartOneItem();
        Assert.assertFalse(productListingPage.cartItems.isEmpty());
        Assert.assertEquals(productListingPage.cartBage.getText(), "1");
    }

    @Test
    public void addToCartFunctionalityForTwoItems() {
        productListingPage.addToCartTwoItems();
        Assert.assertFalse(productListingPage.cartItems.isEmpty());
        Assert.assertEquals(productListingPage.cartBage.getText(), "2");
    }

    @Test
    public void addAllItemsToCartFunctionality() {
        productListingPage.addAllItemsToCart();
        Assert.assertFalse(productListingPage.cartItems.isEmpty());
        Assert.assertEquals(productListingPage.cartBage.getText(), "6");
    }

    @Test
    public void removeFromCartFunctionality() {
        productListingPage.removeFromCart();
        Assert.assertTrue(productListingPage.cartItems.isEmpty());
        for (WebElement button : productListingPage.allAddToCardButtons) {
            Assert.assertTrue(button.isDisplayed());
            Assert.assertEquals(button.getText(), "Add to cart");
        }
    }

    @Test
    public void addRandomItemToCartFunctionality() {
        productListingPage.addRandomItemToCart();
        Assert.assertFalse(productListingPage.cartItems.isEmpty());
        Assert.assertEquals(productListingPage.cartBage.getText(), "1");
    }



}
