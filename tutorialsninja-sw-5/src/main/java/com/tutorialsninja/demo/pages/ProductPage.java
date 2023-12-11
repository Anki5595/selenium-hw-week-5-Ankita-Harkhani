package com.tutorialsninja.demo.pages;

import com.tutorialsninja.demo.utilities.Utility;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;

public class ProductPage extends Utility {
    @CacheLookup
    @FindBy(xpath = "//a[normalize-space()='HP LP3065']")
    WebElement text;

    @CacheLookup
    @FindBy(xpath = "//input[@id='input-option225']")
    WebElement deliveryDate;

    @CacheLookup
    @FindBy(name = "quantity")
    WebElement Qty;

    @CacheLookup
    @FindBy(xpath = "//button[@id='button-cart']")
    WebElement addToCart;

    @CacheLookup
    @FindBy(xpath = "//div[@class='alert alert-success alert-dismissible']")
    WebElement message;

    @CacheLookup
    @FindBy(xpath = "//a[normalize-space()='shopping cart']")
    WebElement click;

    public String verifyHPLP3065Text() {
        return getTextFromElement(text);
    }

    public void selectDeliverDate(String date) {
        clearTextFromField(deliveryDate);
        sendTextToElement(deliveryDate, date);
    }

    public void enterQty(String value) {
        clearTextFromField(Qty);
        sendTextToElement(Qty, value);
    }

    public void clickOnAddToCartButton() {
        clickOnElement(addToCart);
    }

    public String verifySuccessMessageToAddInCart() {
        return getTextFromElement(message);
    }

    public void clickOnShoppingCart() {
        clickOnElement(click);
    }
}
