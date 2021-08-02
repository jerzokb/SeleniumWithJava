package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

import static java.lang.Thread.sleep;

public class ProductPage extends BasePage {
    public ProductPage(WebDriver driver) {super(driver);}

    @FindBy(className = "thumbnail")
    List<WebElement> productItem;

    @FindBy(className = "product-title")
    List<WebElement> productTitle;

    @FindBy(className = "price")
    List<WebElement> productPrice;

    @FindBy(xpath = "//*[@id=\"add-to-cart-or-refresh\"]/div[2]/div/div[2]/button")
    WebElement buttonAddToCart;

    @FindBy(xpath = "//*[@id=\"main\"]/div[1]/div[2]/h1")
    WebElement selectedProductName;

    @FindBy(xpath = "//*[@id=\"main\"]/div[1]/div[2]/div[1]/div[2]/div/span[1]")
    WebElement selectedProductPrice;

    public void clickOnProductItem(int index) {
        if (index >= productItem.size()) {
            System.out.println("Item not found");
        } else {
            productItem.get(index).click();
        }
    }

    public String getProductTitle(int index) {
        return productTitle.get(index).getText();
    }

    public String getProductPrice(int index) {
        return productPrice.get(index).getText();
    }

    public boolean getAddToCartButton() {
        return buttonAddToCart.isDisplayed();
    }

    public String getSelectedProductName() {
        return selectedProductName.getText();
    }

    public String getSelectedProductPrice() {
        return selectedProductPrice.getText();
    }

    public void clickAddToCartButton() {
        buttonAddToCart.click();
    }
}
