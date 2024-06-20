package Tests;

import Base.BaseTest;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class LogoutTest extends BaseTest {


    @BeforeMethod
    public void pageSetUp() {
        driver.manage().window().maximize();
        driver.get(links.saucedemoLink);
        successfulLogin();
    }


    @Test
    public void successfulLogout() throws InterruptedException {
        visibleSidebar();
        productListingPage.clickOnLogoutButton();
        Assert.assertEquals(getCurrentUrl(), links.saucedemoLink);
    }






}
