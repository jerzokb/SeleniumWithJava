package tests;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.chrome.ChromeDriver;
import pages.ProductPage;
import utils.*;

import static java.lang.Thread.sleep;

public class ProductPageTests extends BaseTest {

    private ProductPage productPage;

    @BeforeEach
    public void setupTest() {

        driver = new ChromeDriver();
        driver.get(BASE_URL);

        productPage = new ProductPage(driver);
    }

    @Test
    public void shouldTestSelectProductItem() {
        productPage.clickOnProductItem(ProductPageUtils.PRODUCT_INDEX);
        Assertions.assertThat(productPage.getAddToCartButton()).isTrue();
    }

    @Test
    public void shouldTestSelectedProductName() {
        String productName = productPage.getProductTitle(ProductPageUtils.PRODUCT_INDEX).toUpperCase();
        productPage.clickOnProductItem(ProductPageUtils.PRODUCT_INDEX);
        Assertions.assertThat(productPage.getSelectedProductName().toUpperCase()).isEqualTo(productName);
    }

    @Test
    public void shouldTestSelectedProductPrice() {
        String productPrice = productPage.getProductPrice(ProductPageUtils.PRODUCT_INDEX).toUpperCase();
        productPage.clickOnProductItem(ProductPageUtils.PRODUCT_INDEX);
        Assertions.assertThat(productPage.getSelectedProductPrice().toUpperCase()).isEqualTo(productPrice);
    }
}
