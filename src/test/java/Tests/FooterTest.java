package Tests;

import Base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import Pages.Footer;

public class FooterTest extends BaseTest {

    @BeforeMethod
    public void pageSetUp() {
        driver.manage().window().maximize();
        driver.get(links.saucedemoLink);
        successfulLogin();
        driver.get(links.inventoryLink);
        footer = new Footer();
    }

    @Test
    public void verifyFooterLoadsCorrectly() {
        Assert.assertTrue(footer.footerText.isDisplayed());
        Assert.assertEquals(footer.footerText.getText(), "© 2024 Sauce Labs. All Rights Reserved. Terms of Service | Privacy Policy", "Footer text is incorrect.");
    }

    @Test
    public void facebookLink() {
        footer.facebookLink.click();
        footer.switchToNewTab();
        Assert.assertEquals(driver.getCurrentUrl(), "https://www.facebook.com/saucelabs");
        driver.close();
        footer.switchToOriginalTab();
    }

    @Test
    public void twitterLink() {
        footer.twitterLink.click();
        footer.switchToNewTab();
        Assert.assertEquals(driver.getCurrentUrl(), "https://x.com/saucelabs");
        driver.close();
        footer.switchToOriginalTab();
    }

    @Test
    public void linkedInLink() {
        footer.linkedinLink.click();
        footer.switchToNewTab();
        Assert.assertEquals(driver.getCurrentUrl(), "https://www.linkedin.com/company/sauce-labs/");
        driver.close();
        footer.switchToOriginalTab();
    }


}