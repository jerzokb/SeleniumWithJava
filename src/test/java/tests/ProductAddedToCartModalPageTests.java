package tests;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.chrome.ChromeDriver;
import pages.CartPage;
import pages.ProductAddedToCartModalPage;
import pages.ProductPage;
import utils.*;

import static java.lang.Thread.sleep;

public class ProductAddedToCartModalPageTests extends BaseTest{

    private ProductPage productPage;
    private ProductAddedToCartModalPage productAddedToCartModalPage;
    private CartPage cartPage;
    private String productName;
    private String productPrice;

    @BeforeEach
    public void setupTest() {

        driver = new ChromeDriver();
        driver.get(BASE_URL);

        productPage = new ProductPage(driver);
        productAddedToCartModalPage = new ProductAddedToCartModalPage(driver);
        cartPage = new CartPage(driver);

        productName = productPage.getProductTitle(ProductPageUtils.PRODUCT_INDEX).toUpperCase();
        productPrice = productPage.getProductPrice(ProductPageUtils.PRODUCT_INDEX).toUpperCase();
        productPage.clickOnProductItem(ProductPageUtils.PRODUCT_INDEX);
        productPage.clickAddToCartButton();
    }

    @Test
    public void shouldTestModalScreenIsDisplayed() throws InterruptedException {
        Assertions.assertThat(productAddedToCartModalPage.isModalDialogDisplayed()).isTrue();
    }

    @Test
    public void shouldTestModalScreenTitleText() throws InterruptedException {
        Assertions.assertThat(productAddedToCartModalPage.getModalScreenText()).isEqualTo(ProductAddedToCartModalPageUtils.MODAL_SCREEN_TITLE);
    }

    @Test
    public void shouldTestModalScreenProductName() throws InterruptedException {
        Assertions.assertThat(productAddedToCartModalPage.getModalProductName().toUpperCase()).isEqualTo(productName);
    }

    @Test
    public void shouldTestModalScreenProductPrice() throws InterruptedException {
        Assertions.assertThat(productAddedToCartModalPage.getModalProductPrice().toUpperCase()).isEqualTo(productPrice);
    }

    @Test
    public void shouldTestContinueShopping() {
        productAddedToCartModalPage.clickContinueShoppingButton();
        Assertions.assertThat(productPage.getAddToCartButton()).isTrue();
    }

    @Test
    public void shouldTestProceedToCheckout() {
        productAddedToCartModalPage.clickProceedToCheckoutButton();
        Assertions.assertThat(cartPage.isCardBlockDisplayed()).isTrue();
    }
}
