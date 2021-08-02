package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

import static java.lang.Thread.sleep;

public class CartPage extends BasePage {
    public CartPage(WebDriver driver) {super(driver);}

    @FindBy(className = "card-block")
    WebElement cardBlock;

    @FindBy(xpath = "//*[@id=\"main\"]/div/div[2]/div[1]/div[2]/div/a")
    WebElement buttonProceedToCheckout;

    public boolean isCardBlockDisplayed() {
        return cardBlock.isDisplayed();
    }

    public String getCardBlockText() {
        return cardBlock.getText().toUpperCase();
    }

    public void clickProceedToCheckoutButton() {
        buttonProceedToCheckout.click();
    }
}
