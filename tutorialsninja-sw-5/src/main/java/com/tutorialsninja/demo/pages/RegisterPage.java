package com.tutorialsninja.demo.pages;

import com.tutorialsninja.demo.utilities.Utility;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;

import java.util.UUID;

public class RegisterPage extends Utility {

    @CacheLookup
    @FindBy(xpath = "//h1[normalize-space()='Register Account']")
    WebElement registerAccount;

    @CacheLookup
    @FindBy(xpath = "//h2[normalize-space()='Returning Customer']")
    WebElement returningCustomerText;

    @CacheLookup
    @FindBy(id = "input-firstname")
    WebElement firstName;

    @CacheLookup
    @FindBy(id = "input-lastname")
    WebElement lastName;

    @CacheLookup
    @FindBy(id = "input-email")
    WebElement email;

    @CacheLookup
    @FindBy(id = "input-telephone")
    WebElement telephoneNumber;

    @CacheLookup
    @FindBy(id = "input-password")
    WebElement passwordField;

    @CacheLookup
    @FindBy(xpath = "//input[@id='input-confirm']")
    WebElement confirmPasswordField;

    @CacheLookup
    @FindBy(xpath = "//label[normalize-space()='Yes']")
    WebElement subscribeRadioButton;

    @CacheLookup
    @FindBy(css = "input[value='1'][name='agree']")
    WebElement privacyCheckBox;

    @CacheLookup
    @FindBy(xpath = "//input[@value='Continue']")
    WebElement continueButton;

    public String verifyRegisterAccountText() {
        return getTextFromElement(registerAccount);
    }

    public String verifyTextReturningCustomerOnLoginPage() {
        return getTextFromElement(returningCustomerText);
    }

    public void enterFirstName(String name) {
        sendTextToElement(firstName, name);
    }

    public void enterLastName(String surname) {
        sendTextToElement(lastName, surname);
    }

    final String randomEmail = randomEmail();

    public void enterEmail(String emailAddress) {
        sendTextToElement(email, emailAddress);
    }

    public static String randomEmail() {

        return "random-" + UUID.randomUUID().toString() + "@gmail.com";
    }

    public void enterTelephoneNumber(String phone) {
        sendTextToElement(telephoneNumber, phone);
    }

    public void enterPassword(String password) {
        sendTextToElement(passwordField, password);
    }

    public void enterConfirmPassword(String confirmPassword) {
        sendTextToElement(confirmPasswordField, confirmPassword);
    }

    public void clickOnSubscribeRadioButton() {
        clickOnElement(subscribeRadioButton);
    }

    public void clickOnPrivacyPolicyCheckBox() {
        clickOnElement(privacyCheckBox);
    }

    public void clickOnContinueButton() {
        clickOnElement(continueButton);
    }
}
