package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;
import utils.ContactUsUtils;

import java.util.Random;

public class ContactUsPage extends BasePage {
    public ContactUsPage(WebDriver driver) {
        super(driver);
    }

    Random rn = new Random();

    @FindBy(className = "contact-form")
    WebElement contactForm;

    @FindBy(xpath = "//*[@id=\"content\"]/section/form/section/div[1]/div")
    WebElement formTitle;

    @FindBy(name = "id_contact")
    WebElement subjectDropDown;
    public Select subject = new Select(subjectDropDown);

    @FindBy(name = "submitMessage")
    WebElement buttonSubmitMessage;

    @FindBy(className = "alert-danger")
    WebElement alertDanger;

    @FindBy(xpath = "//*[@id=\"content\"]/section/form/section/div[3]/div/input")
    WebElement inputEmail;

    @FindBy(name = "message")
    WebElement inputMessage;

    @FindBy(className = "alert-success")
    WebElement alertSuccess;

    public boolean isContactFormDisplayed() {
        return contactForm.isDisplayed();
    }

    public String getFormTitleText() {
        return formTitle.getText();
    }

    public void selectCustomerServiceOption(int index) {
        int option = rn.nextInt(2) + 1;
        if (option == 2) {
            subject.selectByVisibleText(ContactUsUtils.CUSTOMER_SERVICE);
        } else {
            subject.selectByVisibleText(ContactUsUtils.WEBMASTER);
        }
    }

    public void clickSubmitMessageButton() {
        buttonSubmitMessage.click();
    }

    public String getAlertDangerText() {
        return alertDanger.getText();
    }

    public boolean isAlertDangerDisplayed() {
        return alertDanger.isDisplayed();
    }

    public void inputEmail(String emailAddress) {
        inputEmail.click();
        inputEmail.clear();
        inputEmail.sendKeys(emailAddress);
    }

    public void inputMessage(String message) {
        inputMessage.click();
        inputMessage.clear();
        inputMessage.sendKeys(message);
    }

    public String getAlertSuccessText() {
        return alertSuccess.getText();
    }

    public boolean isAlertSuccessDisplayed() {
        return alertSuccess.isDisplayed();
    }
}
