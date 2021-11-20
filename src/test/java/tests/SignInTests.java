package tests;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.chrome.ChromeDriver;
import pages.SignInPage;
import pages.HomePage;
import utils.SignInUtils;

public class SignInTests extends BaseTest{

    private SignInPage signInPage;

    @BeforeEach
    public void setupTest() {

        driver = new ChromeDriver();
        driver.get(BASE_URL);

        HomePage homePage = new HomePage(driver);

        signInPage = new SignInPage(driver);

        homePage.clickSignIn();
    }

    @Test
    public void shouldTestLoginFormDisplayed() {
        Assertions.assertThat(signInPage.isLoginFormDisplayed()).isTrue();
    }

    @Test
    public void shouldTestLoginFail() {
        signInPage.submitLoginCredentials(SignInUtils.EMAIL_ADDRESS_FAIL, SignInUtils.PASSWORD_FAIL);
        Assertions.assertThat(signInPage.isAuthenticationFailed()).isTrue();
        Assertions.assertThat(signInPage.getAuthenticationFailedText()).isEqualTo(SignInUtils.AUTHENTICATION_FAILED);
    }

    @Test
    public void shouldTestLoginSuccess() {
        signInPage.submitLoginCredentials(SignInUtils.EMAIL_ADDRESS_SUCCESS, SignInUtils.PASSWORD_SUCCESS);
        Assertions.assertThat(signInPage.isAccountNameDisplayed()).isTrue();
        Assertions.assertThat(signInPage.getAccountNameText()).isEqualTo(SignInUtils.ACCOUNT_NAME);
        Assertions.assertThat(signInPage.isAccountSignOutDisplayed()).isTrue();
        Assertions.assertThat(signInPage.getAccountSignOutText()).containsIgnoringCase(SignInUtils.SIGN_OUT);
    }
}
