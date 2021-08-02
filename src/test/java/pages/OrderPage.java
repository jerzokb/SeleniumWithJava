package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;
import java.util.Random;

import static java.lang.Thread.sleep;

public class OrderPage extends BasePage {
    public OrderPage(WebDriver driver) {super(driver);}

    Random rn = new Random();

    @FindBy(className = "step-title")
    List<WebElement> stepTitles;

    @FindBy(name = "firstname")
    WebElement firstName;

    @FindBy(name = "lastname")
    WebElement lastname;

    @FindBy(name = "email")
    WebElement email;

    @FindBy(className = "continue")
    WebElement buttonContinue;

    @FindBy(name = "company")
    WebElement company;

    @FindBy(name = "address1")
    WebElement address1;

    @FindBy(name = "postcode")
    WebElement postCode;

    @FindBy(name = "city")
    WebElement city;

    @FindBy(name = "phone")
    WebElement phone;

    @FindBy(name = "confirm-addresses")
    WebElement buttonConfirmAddresses;

    @FindBy(className = "delivery-options")
    WebElement formDeliveryOptions;

    @FindBy(name = "confirmDeliveryOption")
    WebElement buttonConfirmDelivery;

    @FindBy(id = "payment-option-1")
    WebElement paymentOption1;

    @FindBy(id = "payment-option-2")
    WebElement paymentOption2;

    @FindBy(id = "conditions_to_approve[terms-and-conditions]")
    WebElement approveConditions;

    @FindBy(xpath = "//*[@id=\"payment-confirmation\"]/div[1]/button")
    WebElement buttonConfirmPayment;

    @FindBy(className = "card-title")
    WebElement cardTitle;

    @FindBy(xpath = "//*[@id=\"content-hook_order_confirmation\"]/div/div/div/p")
    WebElement confirmationText;

    public String getStepTitleText(int index) {
        return stepTitles.get(index).getText().trim();
    }

    public void inputFirstName(String firstNameText) {
        firstName.clear();
        firstName.sendKeys(firstNameText);
    }

    public void inputLastName(String lastNameText) {
        lastname.clear();
        lastname.sendKeys(lastNameText);
    }

    public void inputEmail(String emailText) {
        email.clear();
        email.sendKeys(emailText);
    }

    public void clickContinueButton() {
        buttonContinue.click();
    }

    public void fillInFirstStepData(String firstNameText, String lastNameText, String emailText) {
        this.inputFirstName(firstNameText);
        this.inputLastName(lastNameText);
        this.inputEmail(emailText);
        this.clickContinueButton();
    }

    public String getFirstNameValue() {
        return firstName.getAttribute("value");
    }

    public String getLastNameValue() {
        return lastname.getAttribute("value");
    }

    public void inputCompany(String companyText) {
        company.clear();
        company.sendKeys(companyText);
    }

    public void inputAddress(String addressText) {
        address1.clear();
        address1.sendKeys(addressText);
    }

    public void inputPostalCode(String postalCodeText) {
        postCode.clear();
        postCode.sendKeys(postalCodeText);
    }

    public void inputCity(String cityText) {
        city.clear();
        city.sendKeys(cityText);
    }

    public void inputPhone(String phoneText) {
        phone.clear();
        phone.sendKeys(phoneText);
    }

    public void clickConfirmAddressesButton() {
        buttonConfirmAddresses.click();
    }

    public void fillInSecondStepData(String companyText, String addressText, String postalCodeText, String cityText, String phoneText) {
        this.inputCompany(companyText);
        this.inputAddress(addressText);
        this.inputPostalCode(postalCodeText);
        this.inputCity(cityText);
        this.inputPhone(phoneText);
        this.clickConfirmAddressesButton();
    }

    public boolean isDeliveryOptionDisplayed() {
        return formDeliveryOptions.isDisplayed();
    }

    public void clickConfirmDeliveryButton() {
        buttonConfirmDelivery.click();
    }

    public void clickPaymentOption() {
        int option = rn.nextInt(2) + 1;
        if (option == 1) {
            paymentOption1.click();
        } else {
            paymentOption2.click();
        }
    }

    public void approveConditions() {
        approveConditions.click();
    }

    public void clickConfirmPaymentButton() {
        buttonConfirmPayment.click();
    }

    public void confirmOrder() {
        this.clickConfirmDeliveryButton();
        this.clickPaymentOption();
        this.approveConditions();
        this.clickConfirmPaymentButton();
    }

    public String getCardTitleText() {
        return cardTitle.getText().trim().toUpperCase();
    }

    public String getConfirmationText() {
        return confirmationText.getText();
    }
}
