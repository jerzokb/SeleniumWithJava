package tests;

import com.github.javafaker.Faker;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.chrome.ChromeDriver;
import pages.ContactUsPage;
import pages.HomePage;
import utils.*;

import java.util.Random;

public class ContactUsTests extends BaseTest {

    private ContactUsPage contactUsPage;
    Random rn = new Random();

    private Faker faker = new Faker();
    private String email = faker.internet().emailAddress();
    private String name = faker.name().nameWithMiddle();

    @BeforeEach
    public void setupTest() {

        driver = new ChromeDriver();
        driver.get(BASE_URL);

        HomePage homePage = new HomePage(driver);

        homePage.clickContactLink();

        contactUsPage = new ContactUsPage(driver);
    }

    @Test
    public void shouldTestContactForm() {
        Assertions.assertThat(contactUsPage.isContactFormDisplayed()).isTrue();
    }

    @Test
    public void shouldTestFormTitle() {
        Assertions.assertThat(contactUsPage.getFormTitleText().toUpperCase())
                .isEqualTo(HomePageUtils.CONTACT_LINK_TEXT.toUpperCase());
    }

    @Test
    public void shouldTestEmailIsMandatory() {
        int option = rn.nextInt(2) + 1;
        contactUsPage.selectCustomerServiceOption(option);
        contactUsPage.clickSubmitMessageButton();
        Assertions.assertThat(contactUsPage.isAlertDangerDisplayed()).isTrue();
        Assertions.assertThat(contactUsPage.getAlertDangerText()).isEqualTo(ContactUsUtils.ALERT_EMAIL);
    }

    @Test
    public void shouldTestMessageIsMandatory() {
        int option = rn.nextInt(2) + 1;
        contactUsPage.selectCustomerServiceOption(option);
        contactUsPage.inputEmail(email);
        contactUsPage.clickSubmitMessageButton();
        Assertions.assertThat(contactUsPage.isAlertDangerDisplayed()).isTrue();
        Assertions.assertThat(contactUsPage.getAlertDangerText()).isEqualTo(ContactUsUtils.ALERT_MESSAGE);
    }

    @Test
    public void shouldTestSendMessage() {
        int option = rn.nextInt(2) + 1;
        contactUsPage.selectCustomerServiceOption(option);
        contactUsPage.inputEmail(email);
        contactUsPage.inputMessage(name);
        contactUsPage.clickSubmitMessageButton();
        Assertions.assertThat(contactUsPage.isAlertSuccessDisplayed()).isTrue();
        Assertions.assertThat(contactUsPage.getAlertSuccessText()).isEqualTo(ContactUsUtils.ALERT_SUCCESS);
    }
}
