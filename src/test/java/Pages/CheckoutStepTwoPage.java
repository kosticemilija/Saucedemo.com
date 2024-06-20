package Pages;

import Base.BaseTest;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CheckoutStepTwoPage extends BaseTest {
    public CheckoutStepTwoPage() {
        PageFactory.initElements(driver, this);
    }

    @FindBy (id = "finish")
    public WebElement finishButton;

    @FindBy (id = "cancel")
    public WebElement cancelButton;

    @FindBy (className =  "inventory_item_name")
    public WebElement name;

    @FindBy (className = "inventory_item_desc")
    public WebElement description;

    @FindBy (className = "inventory_item_price")
    public WebElement price;

    @FindBy (className = "summary_info")
    public WebElement summaryInformation;

    @FindBy (className = "summary_info_label")
    public WebElement priceTotalInformation;

    @FindBy (className =  "summary_subtotal_label")
    public WebElement itemTotal;

    @FindBy (className = "summary_tax_label")
    public WebElement tax;

    @FindBy (className = "summary_total_label")
    public WebElement totalPrice;

    public void clickOnFinishButton() {
        finishButton.click();
    }

    public void clickOnCancelButton() {
        cancelButton.click();
    }

}
