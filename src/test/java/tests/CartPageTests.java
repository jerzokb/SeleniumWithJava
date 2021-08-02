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

public class CartPageTests extends BaseTest {
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

        productAddedToCartModalPage.clickProceedToCheckoutButton();
    }

    @Test
    public void shouldTestCartBlockText() {
        Assertions.assertThat(cartPage.getCardBlockText()).isEqualTo(CartPageUtils.CARD_BLOCK_HEADER);
    }

    @Test
    public void shouldTestProceedToCheckoutButton() {
        cartPage.clickProceedToCheckoutButton();
        Assertions.assertThat(driver.getCurrentUrl()).isEqualTo(OrderPageUtils.CURRENT_URL);
    }
}
