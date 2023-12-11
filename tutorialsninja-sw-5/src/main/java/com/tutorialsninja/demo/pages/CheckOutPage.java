package com.tutorialsninja.demo.pages;

import com.tutorialsninja.demo.utilities.Utility;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;

public class CheckOutPage extends Utility {

    @CacheLookup
    @FindBy(xpath = "//h1[normalize-space()='Checkout']")
    WebElement checkOutText;

    @CacheLookup
    @FindBy(xpath = "(//h2[normalize-space()='New Customer'])[1]")
    WebElement checkNewCustomerText;

    @CacheLookup
    @FindBy(xpath = "//input[@value='guest']")
    WebElement guestCheckoutButton;

    @CacheLookup
    @FindBy(css = "#button-account")
    WebElement continueTabButton;

    @CacheLookup
    @FindBy(id = "input-payment-firstname")
    WebElement firstName;

    @CacheLookup
    @FindBy(id = "input-payment-lastname")
    WebElement lastName;

    @CacheLookup
    @FindBy(id = "input-payment-email")
    WebElement emailAddress;

    @CacheLookup
    @FindBy(id = "input-payment-telephone")
    WebElement telephone;

    @CacheLookup
    @FindBy(id = "input-payment-address-1")
    WebElement addressField;

    @CacheLookup
    @FindBy(id = "input-payment-city")
    WebElement cityName;

    @CacheLookup
    @FindBy(name = "postcode")
    WebElement zipCode;

    @CacheLookup
    @FindBy(id = "input-payment-country")
    WebElement countryName;

    @CacheLookup
    @FindBy(id = "input-payment-zone")
    WebElement zoneName;

    @CacheLookup
    @FindBy(xpath = "//input[@id='button-guest']")
    WebElement continueButton;

    @CacheLookup
    @FindBy(xpath = "//textarea[@name='comment']")
    WebElement addCommentIn;

    @CacheLookup
    @FindBy(css = "input[value='1'][name='agree']")
    WebElement termsAndConditions;

    @CacheLookup
    @FindBy(xpath = "//input[@id='button-payment-method']")
    WebElement continueButtonForPayment;

    @CacheLookup
    @FindBy(xpath = "//div[@class ='alert alert-danger alert-dismissible']")
    WebElement checkWarningForPayment;


    public String verifyCheckOutText() {
        return getTextFromElement(checkOutText);
    }

    public String verifyTextNewCustomer() {
        return getTextFromElement(checkNewCustomerText);
    }

    public void clickOnGuestCheckOutButton() {
        clickOnElement(guestCheckoutButton);
    }

    public void clickOnContinueButtonTab() {
        clickOnElement(continueTabButton);
    }

    public void fillAllMandatoryField(String name, String surname, String email, String phone,
                                      String address, String city, String postcode, String country, String zone){
        sendTextToElement(firstName, name);
        sendTextToElement(lastName, surname);
        sendTextToElement(emailAddress, email);
        sendTextToElement(telephone, phone);
        sendTextToElement(addressField, address);
        sendTextToElement(cityName, city);
        sendTextToElement(zipCode, postcode);
        selectByVisibleTextFromDropDown(countryName, country);
        selectByVisibleTextFromDropDown(zoneName, zone);
    }
//    public void enterFirstName(String name) {
//        sendTextToElement(firstName, name);
//    }

//    public void enterLastName(String surname) {
//        sendTextToElement(lastName, surname);
//    }

//    public void enterEmail(String email) {
//        sendTextToElement(emailAddress, email);
//    }
//
//    public void enterTelephone(String phone) {
//        sendTextToElement(telephone, phone);
//    }

//    public void enterAddress(String address) {
//        sendTextToElement(addressField, address);
//    }

//    public void enterCity(String city) {
//        sendTextToElement(cityName, city);
//    }

//    public void enterPostcode(String postcode) {
//        sendTextToElement(zipCode, postcode);
//    }

//    public void enterCountry(String country) {
//        selectByVisibleTextFromDropDown(countryName, country);
//    }
//
//    public void enterZone(String zone) {
//        selectByVisibleTextFromDropDown(zoneName, zone);
//    }

    public void clickOnContinueButtonForGuest() {
        clickOnElement(continueButton);
    }

    public void addCommentsAboutYourOrderIntoTheTextArea(String comment) {
        sendTextToElement(addCommentIn, comment);
    }

    public void clickOnCheckBoxForTermsAndConditions() {
        clickOnElement(termsAndConditions);
    }

    public void clickOnContinueButtonForPaymentMethod() {
        clickOnElement(continueButtonForPayment);
    }

    public String verifyWarningMessageForPaymentMethod() {
        return getTextFromElement(checkWarningForPayment);
    }

}
