package com.tutorialsninja.demo.pages;

import com.tutorialsninja.demo.utilities.Utility;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;

public class MacBookPage extends Utility {
    @CacheLookup
    @FindBy(xpath = "//h1[normalize-space()='MacBook']")
    WebElement checkTextMacBook;

    @CacheLookup
    @FindBy(xpath = "//button[@id='button-cart']")
    WebElement addToCart;

    @CacheLookup
    @FindBy(xpath = "//div[@class='alert alert-success alert-dismissible']")
    WebElement successMessageForAddingProduct;

    @CacheLookup
    @FindBy(xpath = "//a[normalize-space()='shopping cart']")
    WebElement linkToShoppingCartInsideMessage;

    public String verifyTheTextMacBook() {
        return getTextFromElement(checkTextMacBook);
    }

    public void clickOnAddToCart() {
        clickOnElement(addToCart);
    }

    public String verifySuccessMessageForAddingProductToShoppingCart() {
        return getTextFromElement(successMessageForAddingProduct);
    }

    public void clickOnLinkToShoppingCartMessage() {
        clickOnElement(linkToShoppingCartInsideMessage);
    }
}
