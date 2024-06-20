package Tests;

import Base.BaseTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;


public class BurgerMenuTest extends BaseTest {

    @BeforeMethod
    public void pageSetUp() {
        driver.manage().window().maximize();
        driver.get(links.saucedemoLink);
        successfulLogin();
    }

    @Test
    public void visibleSidebarMenu() throws InterruptedException {
        visibleSidebar();
        Assert.assertTrue(productListingPage.sidebarList.isDisplayed());
        Assert.assertTrue(productListingPage.xButton.isDisplayed());
    }

    @Test
    public void sidebarCloses() throws InterruptedException {
        visibleSidebar();
        productListingPage.clickOnXButton();
        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.className("bm-item-list")));
        Assert.assertFalse(productListingPage.xButton.isDisplayed());
        Assert.assertFalse(productListingPage.xButton.isDisplayed());
    }

    @Test
    public void sidebarRemainsClosedAfterPageRefresh () {
        visibleSidebar();
        refresh();
        Assert.assertTrue(productListingPage.burgerMenuButton.isDisplayed());
        Assert.assertFalse(productListingPage.xButton.isDisplayed());
    }

    @Test
    public void sidebarElementsVisibility () {
        visibleSidebar();
        Assert.assertTrue(productListingPage.allItemsButton.isDisplayed());
        Assert.assertTrue(productListingPage.aboutButton.isDisplayed());
        Assert.assertTrue(productListingPage.logoutButton.isDisplayed());
        Assert.assertTrue(productListingPage.resetAppStateButton.isDisplayed());
        Assert.assertTrue(productListingPage.xButton.isDisplayed());
    }

    @Test
    public void allItemsLinkInSidebar () {
        visibleSidebar();
        productListingPage.clickOnAllItemsButton();
        Assert.assertEquals(getCurrentUrl(), links.inventoryLink);
    }

    @Test
    public void aboutLinkInSidebar() {
        visibleSidebar();
        productListingPage.clickOnAboutButton();
        Assert.assertEquals(getCurrentUrl(), links.saucelabsLink);
    }

    @Test
    public void resetAppStateInSidebar() {
        visibleSidebar();
        productListingPage.clickOnResetAppStateButton();
        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.className("shopping_cart_badge")));
        Assert.assertTrue(productListingPage.cartItems.isEmpty());
        for (WebElement button : productListingPage.allAddToCardButtons) {
            Assert.assertTrue(button.isDisplayed());
            Assert.assertEquals(button.getText(), "Add to cart");
        }
    }


}
