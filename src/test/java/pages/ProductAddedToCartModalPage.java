package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

import static java.lang.Thread.sleep;

public class ProductAddedToCartModalPage extends BasePage {
    public ProductAddedToCartModalPage(WebDriver driver) {super(driver);}

    @FindBy(className = "modal-header")
    WebElement modalHeader;

    @FindBy(id = "myModalLabel")
    WebElement modalTitle;

    @FindBy(className = "product-name")
    WebElement modalProductName;

    @FindBy(xpath = "//*[@id=\"blockcart-modal\"]/div/div/div[2]/div/div[1]/div/div[2]/p[1]")
    WebElement modalProductPrice;

    @FindBy(xpath = "//*[@id=\"blockcart-modal\"]/div/div/div[2]/div/div[2]/div/div/button")
    WebElement buttonContinueShopping;

    @FindBy(xpath = "//*[@id=\"blockcart-modal\"]/div/div/div[2]/div/div[2]/div/div/a")
    WebElement buttonProceedToCheckout;

    public boolean isModalDialogDisplayed() throws InterruptedException {
        sleep(5000);
        return modalHeader.isDisplayed();
    }

    public String getModalScreenText() throws InterruptedException {
        sleep(5000);
        return modalTitle.getText();
    }

    public String getModalProductName() throws InterruptedException {
        sleep(5000);
        return modalProductName.getText();
    }

    public String getModalProductPrice() throws InterruptedException {
        sleep(5000);
        return modalProductPrice.getText();
    }

    public void clickContinueShoppingButton() {
        buttonContinueShopping.click();
    }

    public void clickProceedToCheckoutButton() {
        buttonProceedToCheckout.click();
    }
}
