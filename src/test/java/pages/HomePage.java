package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class HomePage extends BasePage {
    public HomePage(WebDriver driver) {
        super(driver);
    }

    @FindBy(id = "category-3")
    WebElement topMenuDropDownItemClothes;

    @FindBy(id = "category-6")
    WebElement topMenuDropDownItemAccessories;

    @FindBy(id = "category-9")
    WebElement topMenuDropDownItemArt;

    @FindBy(xpath = "//*[@id=\"carousel\"]/ul/li")
    List<WebElement> sliderElement;

    @FindBy(id = "contact-link")
    WebElement contactLink;

    @FindBy(xpath = "//*[@id=\"_desktop_user_info\"]/div/a/span")
    WebElement signIn;

    public void clickDropDownItem(int index) {
        switch (index) {
            case 3: {
                topMenuDropDownItemClothes.click();
                break;
            }
            case 6: {
                topMenuDropDownItemAccessories.click();
                break;
            }
            case 9: {
                topMenuDropDownItemArt.click();
                break;
            }
        }
    }

    public Integer getSliderElementSize() {
        return sliderElement.size();
    }

    public void clickContactLink() {
        contactLink.click();
    }

    public String getContactLinkText() {
        return contactLink.getText();
    }

    public void clickSignIn() {
        signIn.click();
    }

    public String getSignInText() {
        return signIn.getText();
    }
}
