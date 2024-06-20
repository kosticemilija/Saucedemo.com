package Base;

import Pages.*;
import Tests.ProductDetailsTest;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;

import java.time.Duration;

public class BaseTest {
    public static WebDriver driver;
    public WebDriverWait wait;
    public LoginPage loginPage;
    public ProductListingPage productListingPage;
    public CartPage cartPage;
    public CheckoutStepOnePage checkoutStepOnePage;
    public CheckoutStepTwoPage checkoutStepTwoPage;
    public CheckoutCompletePage checkoutCompletePage;
    public ProductDetailsPage productDetailsPage;
    public Sorting sorting;
    public Footer footer;
    public Links links;

    @BeforeClass
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        loginPage=new LoginPage();
        productListingPage=new ProductListingPage();
        cartPage=new CartPage();
        checkoutStepOnePage=new CheckoutStepOnePage();
        checkoutStepTwoPage=new CheckoutStepTwoPage();
        checkoutCompletePage=new CheckoutCompletePage();
        productDetailsPage=new ProductDetailsPage();
        sorting=new Sorting();
        footer=new Footer();
        links=new Links();
    }

    public void successfulLogin() {
        loginPage.usernameField.clear();
        loginPage.passwordField.clear();
        loginPage.inputUsername("standard_user");
        loginPage.inputPassword("secret_sauce");
        loginPage.clickOnLoginButton();
    }

    public void visibleSidebar() {
        productListingPage.clickOnBurgerMenuButton();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("bm-item-list")));
    }

    public String getCurrentUrl() {
        return driver.getCurrentUrl();
    }

    public void goToCheckoutStepOnePage() {
        productListingPage.addToCartOneItem();
        cartPage.clickOnCartIcon();
        cartPage.clickCheckoutButton();
    }

    public void goToCheckoutStepTwoPage() {
        productListingPage.addToCartOneItem();
        cartPage.clickOnCartIcon();
        cartPage.clickCheckoutButton();
        checkoutStepOnePage.inputFistName("Marko");
        checkoutStepOnePage.inputLastName("Markovic");
        checkoutStepOnePage.inputPostalCode("11000");
        checkoutStepOnePage.clickOnContinueButton();
    }

    public void goToCheckoutCompletePage() {
        productListingPage.addToCartOneItem();
        cartPage.clickOnCartIcon();
        cartPage.clickCheckoutButton();
        checkoutStepOnePage.inputFistName("Marko");
        checkoutStepOnePage.inputLastName("Markovic");
        checkoutStepOnePage.inputPostalCode("11000");
        checkoutStepOnePage.clickOnContinueButton();
        checkoutStepTwoPage.clickOnFinishButton();
    }

    public void goBack() {
        driver.navigate().back();
    }

    public void refresh() {
        driver.navigate().refresh();
    }

    @AfterClass
    public void tearDown() {
        driver.quit();
    }
}
