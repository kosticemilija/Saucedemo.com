package Pages;

import Base.BaseTest;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ProductDetailsPage extends BaseTest {

    public ProductDetailsPage() {
        PageFactory.initElements(driver, this);
    }

    @FindBy (id = "back-to-products")
    public WebElement backToProductsButton;

    @FindBy (css = ".inventory_details_name.large_size")
    public WebElement inventoryName;

    @FindBy (id = "add-to-cart")
    public WebElement addToCartButton;

    @FindBy (id = "remove")
    public WebElement removeButton;


    public void clickOnBackToProductsButton() {
        backToProductsButton.click();
    }

    public void clickOnAddToCartButton() {
        addToCartButton.click();
    }






}
