package com.orangehrmlive.demo.pages;

import com.orangehrmlive.demo.utilities.Utility;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends Utility {
    @CacheLookup
    @FindBy(name = "username")
    WebElement enterUserName;

    @CacheLookup
    @FindBy(name = "password")
    WebElement enterPassword;

    @CacheLookup
    @FindBy(xpath = "//button[normalize-space()='Login']")
    WebElement clickLogin;

    @CacheLookup
    @FindBy(xpath = ("(//img[@alt='orangehrm-logo'])[2]"))
    WebElement logoElement;
    // By logoElement = By.xpath("//div[@id='divLogo']//img");
    @CacheLookup
    @FindBy(xpath = ("(//img[@alt='client brand banner'])[1]"))
    WebElement logoElement1;

    @CacheLookup
    @FindBy(xpath = ("(//button[normalize-space()='Login'])[1]"))
    WebElement loginPanel;

    @CacheLookup
    @FindBy(xpath = "(//span[@class='oxd-text oxd-text--span oxd-input-field-error-message oxd-input-group__message'][normalize-space()='Required'])[1]")
    WebElement errorMessage;

    @CacheLookup
    @FindBy(xpath = "//p[@class='oxd-text oxd-text--p oxd-alert-content-text']")
    WebElement invalidInput;


    //HR for All Logo
    public void getLogoElement(String text) {

        verifyThatTextIsDisplayed(logoElement, text);
    }

    public void getLogoElement1(String text) {
        verifyThatTextIsDisplayed(logoElement1, text);
    }

    // LOGIN panel locator
    public void getTextForLoginPanel(String text) {
        verifyThatTextIsDisplayed(loginPanel, text);
    }

    public String getErrorMessage() {
        return getTextFromElement(errorMessage);

    }

    public String getInvalidInputMessage() {
        return getTextFromElement(invalidInput);

    }

    public void logInToApplication(String userName, String password) {
        sendTextToElement(enterUserName, userName);
        sendTextToElement(enterPassword, password);

    }

    public void clickOnLogin() {
        clickOnElement(clickLogin);
    }
}
