package Pages;

import Base.BaseTest;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.ArrayList;

public class Footer extends BaseTest {
    public Footer() {
        PageFactory.initElements(driver, this);
    }

    @FindBy(className = "social_facebook")
    public WebElement facebookLink;

    @FindBy(className = "social_twitter")
    public WebElement twitterLink;

    @FindBy(className = "social_linkedin")
    public WebElement linkedinLink;

    @FindBy(className = "footer_copy")
    public WebElement footerText;

    public void switchToNewTab() {
        ArrayList<String> tabs = new ArrayList<>(driver.getWindowHandles());
        driver.switchTo().window(tabs.get(1));
    }

    public void switchToOriginalTab() {
        ArrayList<String> tabs = new ArrayList<>(driver.getWindowHandles());
        driver.switchTo().window(tabs.getFirst());
    }
}