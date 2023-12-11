package com.nopcommerce.demo.pages;

import com.aventstack.extentreports.Status;
import com.nopcommerce.demo.customerslisteners.CustomListeners;
import com.nopcommerce.demo.utilities.Utility;
import net.bytebuddy.utility.RandomString;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;

import java.util.Random;

public class RegisterPage extends Utility {

    @CacheLookup
    @FindBy(xpath = "//h1[text()='Register']")
    WebElement registerText;

    @CacheLookup
    @FindBy(id = "FirstName-error")
    WebElement firstNameError;

    @CacheLookup
    @FindBy(id = "LastName-error")
    WebElement lastNameError;

    @CacheLookup
    @FindBy(id = "Email-error")
    WebElement emailIdError;

    @CacheLookup
    @FindBy(id = "Password-error")
    WebElement passwordError;

    @CacheLookup
    @FindBy(id = "ConfirmPassword-error")
    WebElement confirmationPasswordError;

    @CacheLookup
    @FindBy(xpath = "//button[text()= 'Register']")
    WebElement registerButton;

    @CacheLookup
    @FindBy(id = "gender-female")
    WebElement radioButton;

    @CacheLookup
    @FindBy(id = "FirstName")
    WebElement enterFirstName;

    @CacheLookup
    @FindBy(name = "LastName")
    WebElement enterLastName;

    @CacheLookup
    @FindBy(name = "DateOfBirthDay")
    WebElement dateOfBirthDay;

    @CacheLookup
    @FindBy(name = "DateOfBirthMonth")
    WebElement dateOfBirthMonth;

    @CacheLookup
    @FindBy(name = "DateOfBirthYear")
    WebElement dateOfBirthYear;

    @CacheLookup
    @FindBy(id = "Email")
    WebElement enterEmailId;

    @CacheLookup
    @FindBy(id = "Password")
    WebElement enterPassword;

    @CacheLookup
    @FindBy(id = "ConfirmPassword")
    WebElement enterConfirmationPassword;

    @CacheLookup
    @FindBy(xpath = "//div[text()='Your registration completed']")
    WebElement registerCompleteText;

    @CacheLookup
    @FindBy(xpath = "//a[normalize-space()='Continue']")
    WebElement continueButton;

    public String verifyRegisterText() {
        String text = getTextFromElement(registerText);
        CustomListeners.test.log(Status.PASS, "Verify text");
        return text;
    }

    public void clickOnRegisterButton() {
        clickOnElement(registerButton);
        CustomListeners.test.log(Status.PASS, "Click on register Button");
    }

    public String verifyFirstNameIsRequired() {
        String text = getTextFromElement(firstNameError);
        CustomListeners.test.log(Status.PASS, "Verify text");
        return text;
    }

    public String verifyLastNameIsRequired() {
        String text = getTextFromElement(lastNameError);
        CustomListeners.test.log(Status.PASS, "Verify text");
        return text;
    }

    public String verifyEmailIdIsRequired() {
        String text = getTextFromElement(emailIdError);
        CustomListeners.test.log(Status.PASS, "Verify text");
        return text;
    }

    public String verifyPasswordIsRequired() {
        String text = getTextFromElement(passwordError);
        CustomListeners.test.log(Status.PASS, "Verify text");
        return text;
    }

    public String verifyConfirmPasswordIsRequired() {
        String text = getTextFromElement(confirmationPasswordError);
        CustomListeners.test.log(Status.PASS, "Verify text");
        return text;
    }

    public void clickOnRadioButton() {
        clickOnElement(radioButton);
        CustomListeners.test.log(Status.PASS, "Click on female Button");
    }

    public void enterFirstName(String firstName) {
        sendTextToElement(enterFirstName, firstName);
        CustomListeners.test.log(Status.PASS, "Enter First name " + firstName);
    }

    public void enterLastName(String lastName) {
        sendTextToElement(enterLastName, lastName);
        CustomListeners.test.log(Status.PASS, "Enter Last Name " + lastName);
    }

    public void enterDayOfBirth(String day) {
        selectByVisibleTextFromDropDown(dateOfBirthDay, day);
        CustomListeners.test.log(Status.PASS, "Enter Day " + day);
    }

    public void enterMonthOfBirth(String month) {
        selectByVisibleTextFromDropDown(dateOfBirthMonth, month);
        CustomListeners.test.log(Status.PASS, "Enter month " + month);
    }

    public void enterYearOfBirth(String year) {
        selectByVisibleTextFromDropDown(dateOfBirthYear, year);
        CustomListeners.test.log(Status.PASS, "Enter year " + year);
    }

    public static String generatedEmail;

    public void enterEmail() {
        Random randomPartOfEmailGenerator = new Random(5000);
        int randomNumberInEmail = randomPartOfEmailGenerator.nextInt();
        //random string generator - to use in email
        RandomString randomString = new RandomString(5);
        String randomStringInEmailGenerator = randomString.nextString();
        generatedEmail = "michel" + randomNumberInEmail + randomStringInEmailGenerator + "mouse@gmail.com";
        sendTextToElement(enterEmailId, generatedEmail);
        CustomListeners.test.log(Status.PASS, "Enter EmailId " + generatedEmail);
    }

    public void enterPassword(String password) {
        sendTextToElement(enterPassword, password);
        CustomListeners.test.log(Status.PASS, "Enter Password " + password);
    }

    public void enterConfirmPassword(String confirmPassword) {
        sendTextToElement(enterConfirmationPassword, confirmPassword);
        CustomListeners.test.log(Status.PASS, "Enter Confirm Password " + confirmPassword);
    }

    public String verifyRegistrationCompleteText() {
        String text = getTextFromElement(registerCompleteText);
        CustomListeners.test.log(Status.PASS, "Verify text");
        return text;
    }

    public void clickOnContinue() {
        clickOnElement(continueButton);
    }
}

