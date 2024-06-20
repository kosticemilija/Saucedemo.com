package Pages;

import Base.BaseTest;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CheckoutCompletePage extends BaseTest {
    public CheckoutCompletePage() {
        PageFactory.initElements(driver, this);
    }

    @FindBy (className = "title")
    public WebElement title;

    @FindBy (className = "complete-header")
    public WebElement header;

    @FindBy (className = "complete-text")
    public WebElement text;

    @FindBy (id = "back-to-products")
    public WebElement backHomeButton;

    public void clickOnBackHomeButton() {
        backHomeButton.click();
    }


}
