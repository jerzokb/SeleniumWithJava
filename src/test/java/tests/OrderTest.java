package tests;

import com.github.javafaker.Faker;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.chrome.ChromeDriver;
import pages.CartPage;
import pages.OrderPage;
import pages.ProductAddedToCartModalPage;
import pages.ProductPage;
import utils.*;

import static java.lang.Thread.sleep;

public class OrderTest extends BaseTest{
    private ProductPage productPage;
    private ProductAddedToCartModalPage productAddedToCartModalPage;
    private CartPage cartPage;
    private OrderPage orderPage;
    private String productName;
    private String productPrice;

    private  Faker faker = new Faker();
    private String firstName = faker.name().firstName();
    private String lastName = faker.name().lastName();
    private String email = faker.internet().emailAddress();
    private String company = faker.company().name();
    private String address = faker.address().streetName();
    private String postCode = OrderPageUtils.POST_CODE;
    private String city = faker.address().city();
    private String phone = OrderPageUtils.PHONE_NUMBER;

    @BeforeEach
    public void setupTest() {

        driver = new ChromeDriver();
        driver.get(BASE_URL);

        productPage = new ProductPage(driver);
        productAddedToCartModalPage = new ProductAddedToCartModalPage(driver);
        cartPage = new CartPage(driver);
        orderPage = new OrderPage(driver);

        productName = productPage.getProductTitle(ProductPageUtils.PRODUCT_INDEX).toUpperCase();
        productPrice = productPage.getProductPrice(ProductPageUtils.PRODUCT_INDEX).toUpperCase();
        productPage.clickOnProductItem(ProductPageUtils.PRODUCT_INDEX);
        productPage.clickAddToCartButton();

        productAddedToCartModalPage.clickProceedToCheckoutButton();

        cartPage.clickProceedToCheckoutButton();
    }

    @Test
    public void shouldTestFirstStepTitle() {
        Assertions.assertThat(orderPage.getStepTitleText(0)).containsIgnoringCase(OrderPageUtils.FIRST_STEP_TITLE);
    }

    @Test
    public void shouldTestSecondStepTitle() {
        Assertions.assertThat(orderPage.getStepTitleText(1)).containsIgnoringCase(OrderPageUtils.SECOND_STEP_TITLE);
    }

    @Test
    public void shouldTestThirdStepTitle() {
        Assertions.assertThat(orderPage.getStepTitleText(2)).containsIgnoringCase(OrderPageUtils.THIRD_STEP_TITLE);
    }

    @Test
    public void shouldTestFourthStepTitle() {
        Assertions.assertThat(orderPage.getStepTitleText(3)).containsIgnoringCase(OrderPageUtils.FOURTH_STEP_TITLE);
    }

    @Test
    public void shouldTestFirstStep() {
        orderPage.fillInFirstStepData(firstName, lastName, email);
        Assertions.assertThat(orderPage.getFirstNameValue()).isEqualTo(firstName);
        Assertions.assertThat(orderPage.getLastNameValue()).isEqualTo(lastName);
    }

    @Test
    public void shouldTestSecondStep() {
        orderPage.fillInFirstStepData(firstName, lastName, email);
        orderPage.fillInSecondStepData(company, address, postCode, city, phone);
        System.out.println(orderPage.isDeliveryOptionDisplayed());
        Assertions.assertThat(orderPage.isDeliveryOptionDisplayed()).isTrue();
    }

    @Test
    public void shouldTestConfirmOrder() {
        orderPage.fillInFirstStepData(firstName, lastName, email);
        orderPage.fillInSecondStepData(company, address, postCode, city, phone);
        orderPage.confirmOrder();
        Assertions.assertThat(orderPage.getCardTitleText()).contains(OrderPageUtils.CARD_TITLE.toUpperCase());
        Assertions.assertThat(orderPage.getConfirmationText()).contains(email);
    }
}
