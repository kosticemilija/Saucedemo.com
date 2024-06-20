package Pages;

import Base.BaseTest;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import java.util.List;

public class CartPage extends BaseTest {
    public CartPage() {
        PageFactory.initElements(driver, this);
    }

    @FindBy(id = "shopping_cart_container")
    public WebElement cartIcon;

    @FindBy(className = "cart_footer")
    public WebElement cartFooter;

    @FindBy (id = "remove-sauce-labs-backpack")
    public WebElement firstItemRemoveButton;

    @FindBy(id = "continue-shopping")
    public WebElement continueShoppingButton;

    @FindBy(id = "checkout")
    public WebElement checkoutButton;

    @FindBy(className = "inventory_item_name")
    public WebElement inventoryName;

    @FindBy(className = "inventory_item_desc")
    public WebElement inventoryDescription;

    @FindBy(className = "inventory_item_price")
    public WebElement inventoryPrice;

    @FindBy (css = ".btn.btn_secondary.btn_small.cart_button")
    public List<WebElement> allRemoveButtons;

    public void clickOnCartIcon() {
        cartIcon.click();
    }

    public String getCurrentURL() {
       return driver.getCurrentUrl();
    }

    public void removeFistFromCart(){
        firstItemRemoveButton.click();
    }

    public void clickContinueShoppingButton() {
        continueShoppingButton.click();
    }

    public void clickCheckoutButton() {
        checkoutButton.click();
    }


    public void removeAllItemsFromCart() {
        for (WebElement remove : allRemoveButtons) {
            remove.click();
        }

    }


}
