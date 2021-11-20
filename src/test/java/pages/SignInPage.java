package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SignInPage extends BasePage {
    public SignInPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(className = "login-form")
    WebElement formLogin;

    @FindBy(className = "alert")
    WebElement alertAuthentication;

    @FindBy(name = "email")
    WebElement inputEmail;

    @FindBy(name = "password")
    WebElement inputPassword;

    @FindBy(id = "submit-login")
    WebElement buttonSubmitLogin;

    @FindBy(className = "account")
    WebElement accountName;

    @FindBy(className = "logout")
    WebElement buttonSignOut;

    public boolean isLoginFormDisplayed() {
        return formLogin.isDisplayed();
    }

    public void submitLoginCredentials(String email, String password) {
        inputEmail.clear();
        inputEmail.sendKeys(email);
        inputPassword.clear();
        inputPassword.sendKeys(password);
        buttonSubmitLogin.click();
    }

    public boolean isAuthenticationFailed() {
        return alertAuthentication.isDisplayed();
    }

    public String getAuthenticationFailedText() {
        return alertAuthentication.getText();
    }

    public boolean isAccountNameDisplayed() {
        return accountName.isDisplayed();
    }

    public boolean isAccountSignOutDisplayed() {
        return buttonSignOut.isDisplayed();
    }

    public String getAccountNameText() {
        return accountName.getText();
    }

    public String getAccountSignOutText() {
        return buttonSignOut.getText();
    }
}
