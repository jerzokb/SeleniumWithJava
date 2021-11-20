package tests;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.chrome.ChromeDriver;
import pages.HomePage;
import utils.*;

public class HomePageTests extends BaseTest {

    private HomePage homePage;

    @BeforeEach
    public void setupTest() {

        driver = new ChromeDriver();
        driver.get(BASE_URL);

        homePage = new HomePage(driver);
    }

    @Test
    public void shouldTestHomePageTitle() {
        Assertions.assertThat(driver.getTitle()).isEqualTo(HomePageUtils.HOME_PAGE_TITLE);
    }

    @Test
    public void shouldTestClothesMenuOption() {
        homePage.clickDropDownItem(3);
        Assertions.assertThat(driver.getCurrentUrl()).isEqualTo(ClothesPageUtils.CURRENT_URL);
    }

    @Test
    public void shouldTestAccessoriesMenuOption() {
        homePage.clickDropDownItem(6);
        Assertions.assertThat(driver.getCurrentUrl()).isEqualTo(AccessoriesUtils.CURRENT_URL);
    }

    @Test
    public void shouldTestArtMenuOption() {
        homePage.clickDropDownItem(9);
        Assertions.assertThat(driver.getCurrentUrl()).isEqualTo(ArtUtils.CURRENT_URL);
    }

    @Test
    public void shouldTestNumberOfSlides() {
        Assertions.assertThat(homePage.getSliderElementSize()).isEqualTo(3);
    }

    @Test
    public void shouldTestContactListText() {
        Assertions.assertThat(homePage.getContactLinkText()).isEqualTo(HomePageUtils.CONTACT_LINK_TEXT);
    }

    @Test
    public void shouldTestContactUsOption() {
        homePage.clickContactLink();
        Assertions.assertThat(driver.getCurrentUrl()).isEqualTo(ContactUsUtils.CURRENT_URL);
    }

    @Test
    public void shouldTestSignInText() {
        Assertions.assertThat(homePage.getSignInText()).isEqualTo(HomePageUtils.SIGN_IN_TEXT);
    }

    @Test
    public void shouldTestSignInOption() {
        homePage.clickSignIn();
        Assertions.assertThat(driver.getCurrentUrl()).isEqualTo(SignInUtils.CURRENT_URL);
    }
}
