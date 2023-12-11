package com.nopcommerce.demo.pages;

import com.aventstack.extentreports.Status;
import com.nopcommerce.demo.customerslisteners.CustomListeners;
import com.nopcommerce.demo.utilities.Utility;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;


public class HomePage extends Utility {
    @CacheLookup
    @FindBy(xpath = "//ul[@class='top-menu notmobile']//a[normalize-space()]")
    WebElement selectMenu;

    @CacheLookup
    @FindBy(linkText = "Log in")
    WebElement loginLink;

    @CacheLookup
    @FindBy(xpath = "//a[contains(@class, 'ico-register')]")
    WebElement registerLink;

    @CacheLookup
    @FindBy(xpath = "//a[normalize-space()='Log in']")
    WebElement verifyLoginLink;

    @CacheLookup
    @FindBy(xpath = "//li[@class='active last']//a[normalize-space()='Desktops']")
    WebElement desktopLink;


    public void clickOnLoginLink() {
        clickOnElement(loginLink);
        CustomListeners.test.log(Status.PASS, "Click on login Button");
    }

    public void clickOnRegisterLink() {
        clickOnElement(registerLink);
        CustomListeners.test.log(Status.PASS, "Click on register Button");
    }

    public String getLoginLink() {
        String link = getTextFromElement(verifyLoginLink);
        CustomListeners.test.log(Status.PASS, "Get login text");
        return link;

    }

    public void selectMenu(String menu) {
        mouseHoverToElementAndClick(selectMenu);
    }

    public void clickOnDesktop() {
        mouseHoverToElementAndClick(desktopLink);
    }

}
