package Pages;

import Base.BaseTest;
import org.openqa.selenium.support.PageFactory;

public class Links extends BaseTest {

    public Links() {
        PageFactory.initElements(driver, this);
    }

    public String saucedemoLink="https://www.saucedemo.com/";
    public String inventoryLink="https://www.saucedemo.com/inventory.html";
    public String saucelabsLink="https://saucelabs.com/";
    public String cartLink="https://www.saucedemo.com/cart.html";
    public String checkoutStepOneLink="https://www.saucedemo.com/checkout-step-one.html";
    public String checkoutStepTwoLink="https://www.saucedemo.com/checkout-step-two.html";
    public String checkoutCompleteLink="https://www.saucedemo.com/checkout-complete.html";






}
