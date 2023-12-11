package com.tutorialsninja.demo.pages;

import com.tutorialsninja.demo.utilities.Utility;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;

public class MyAccountPage extends Utility {
    @CacheLookup
    @FindBy(xpath = "//h1[normalize-space()='Your Account Has Been Created!']")
    WebElement accountCreation;


    @CacheLookup
    @FindBy(xpath = "//h1[normalize-space()='Your Account Has Been Created!']")
    WebElement continueAccountButton;

    @CacheLookup
    @FindBy(xpath = "//a[normalize-space()='Logout']")
    WebElement accountLogOutText;

    @CacheLookup
    @FindBy(xpath = "//a[normalize-space()='Continue']")
    WebElement continueLogOutButton;

    @CacheLookup
    @FindBy(xpath = "//input[@value='Login']")
    WebElement loginButton;

    @CacheLookup
    @FindBy(xpath = "//h2[normalize-space()='My Account']")
    WebElement checkTextForMyAccount;

    @CacheLookup
    @FindBy(xpath = "//div[@id='top-links']//li[contains(@class,'open')]/ul/li")
    WebElement clickOnOption;

    @CacheLookup
    @FindBy(xpath = "//span[normalize-space()='My Account']")
    WebElement clickOnMyAccount;

    @CacheLookup
    @FindBy(xpath = "//span[normalize-space()='My Account']")
    WebElement accountLink;


    public String verifyTheMessageYourAccountHasBeenCreated() {
        return getTextFromElement(accountCreation);
    }

    public void clickOnContinueAccountButton() {
        clickOnElement(continueAccountButton);
    }

    public String verifyTextForAccountLogOut() {
        return getTextFromElement(accountLogOutText);
    }

    public void clickOnContinueLogOutButton() {
        clickOnElement(continueLogOutButton);
    }

    public void clickOnLoginButton() {
        clickOnElement(loginButton);
    }

    public String verifyTheTextMyAccount() {
        return getTextFromElement(checkTextForMyAccount);
    }

//    public void selectMyAccountOptions(String option) {
//        listOfProductsElement(clickOnOption, option);
//    }

    public void selectOption(String option) {
        WebElement menuList = driver.findElement(By.linkText(option));
        Actions actions = new Actions(driver);
        actions.moveToElement(menuList).click().build().perform();
    }

    public void clickOnMyAccountLink() {
        mouseHoverToElementAndClick(clickOnMyAccount);
    }

//    public void clickOnMyAccount() {
//        // Implement a method to wait for the element to be present before clicking
//        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
//        wait.until(ExpectedConditions.presenceOfElementLocated((By) accountLink)).click();
//    }


}