package Tests;

import Base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class LoginTests extends BaseTest {

    @BeforeMethod
    public void pageSetUp() {
        driver.manage().window().maximize();
        driver.get(links.saucedemoLink);
    }


    @Test
    public void successfulLoginWithValidCredentials() {
        successfulLogin();
        Assert.assertEquals(loginPage.getCurrentUrl(), links.inventoryLink);
    }

    @Test
    public void loginWithInvalidUsername() {
        loginPage.inputUsername("STANDARD_USER");
        loginPage.inputPassword("secret_sauce");
        loginPage.clickOnLoginButton();
        Assert.assertTrue(loginPage.errorMessage.isDisplayed());
        Assert.assertEquals(loginPage.errorMessage.getText(), "Epic sadface: Username and password do not match any user in this service");
    }

    @Test
    public void loginWithInvalidPassword() {
        loginPage.inputUsername("standard_user");
        loginPage.inputPassword("invalid_password");
        loginPage.clickOnLoginButton();
        Assert.assertTrue(loginPage.errorMessage.isDisplayed());
        Assert.assertEquals(loginPage.errorMessage.getText(), "Epic sadface: Username and password do not match any user in this service");
    }

    @Test
    public void loginWithInvalidCredentials() {
        loginPage.inputUsername("invalid_username");
        loginPage.inputPassword("invalid_password");
        loginPage.clickOnLoginButton();
        Assert.assertTrue(loginPage.errorMessage.isDisplayed());
        Assert.assertEquals(loginPage.errorMessage.getText(), "Epic sadface: Username and password do not match any user in this service");
    }

    @Test
    public void loginWithoutPassword() {
        loginPage.inputUsername("standard_user");
        loginPage.clickOnLoginButton();
        Assert.assertTrue(loginPage.errorMessage.isDisplayed());
        Assert.assertEquals(loginPage.errorMessage.getText(),  "Epic sadface: Password is required");
    }

    @Test
    public void loginWithoutUsername() {
        loginPage.inputPassword("secret_sauce");
        loginPage.clickOnLoginButton();
        Assert.assertTrue(loginPage.errorMessage.isDisplayed());
        Assert.assertEquals(loginPage.errorMessage.getText(),  "Epic sadface: Username is required");
    }

    @Test
    public void loginWithoutCredentials() {
        loginPage.clickOnLoginButton();
        Assert.assertTrue(loginPage.errorMessage.isDisplayed());
        Assert.assertEquals(loginPage.errorMessage.getText(),  "Epic sadface: Username is required");
    }


}
