package Pages;

import Base.BaseTest;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;
import java.util.Random;

public class ProductListingPage extends BaseTest {

    public ProductListingPage() {
        PageFactory.initElements(driver, this);
    }

    @FindBy(id = "react-burger-menu-btn")
    public WebElement burgerMenuButton;

    @FindBy (id = "logout_sidebar_link")
    public WebElement logoutButton;

    @FindBy (className = "bm-item-list")
    public WebElement sidebarList;

    @FindBy (id = "react-burger-cross-btn")
    public WebElement xButton;

    @FindBy (id= "inventory_sidebar_link")
    public WebElement allItemsButton;

    @FindBy (id="about_sidebar_link")
    public WebElement aboutButton;

    @FindBy (id = "reset_sidebar_link")
    public WebElement resetAppStateButton;

    @FindBy (className = "shopping_cart_badge")
    public WebElement cartBage;

    @FindBy (className = "shopping_cart_badge")
    public List<WebElement> cartItems;

    @FindBy (css = ".btn.btn_primary.btn_small.btn_inventory")
    public List<WebElement> allAddToCardButtons;

    @FindBy (css = ".btn.btn_secondary.btn_small.btn_inventory")
    public List<WebElement> allRemoveButtons;

    @FindBy(css = ".inventory_item_name")
    public List<WebElement> productNames;

    @FindBy(className = "header_secondary_container")
    public WebElement titlePage;


    public void clickOnBurgerMenuButton() {
        burgerMenuButton.click();
    }

    public void clickOnLogoutButton() {
        logoutButton.click();
    }

    public void clickOnXButton() {
        xButton.click();
    }

    public void clickOnAllItemsButton() {
        allItemsButton.click();
    }


    public void clickOnAboutButton(){
        aboutButton.click();
    }

    public void clickOnResetAppStateButton () {
        resetAppStateButton.click();
    }

    public void addToCartOneItem() {
        allAddToCardButtons.getFirst().click();
    }

    public void addToCartTwoItems() {
        allAddToCardButtons.get(0).click();
        allAddToCardButtons.get(1).click();
    }

    public void addAllItemsToCart() {
        for (WebElement button : allAddToCardButtons) {
            button.click();
        }
    }

    public void removeFromCart() {
        for (WebElement button : allAddToCardButtons) {
            button.click();
        }
        for (WebElement remove: allRemoveButtons) {
            remove.click();
        }
    }

    public void addRandomItemToCart() {
        Random random = new Random();
        int randomIndex = random.nextInt(allAddToCardButtons.size());
        allAddToCardButtons.get(randomIndex).click();
    }

    public void openRandomProductDetails() {
        Random random = new Random();
        int randomIndex = random.nextInt(productNames.size());
        productNames.get(randomIndex).click();
    }


}
