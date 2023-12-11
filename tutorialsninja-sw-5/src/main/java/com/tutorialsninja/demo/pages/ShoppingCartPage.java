package com.tutorialsninja.demo.pages;

import com.tutorialsninja.demo.utilities.Utility;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;

public class ShoppingCartPage extends Utility {
    @CacheLookup
    @FindBy(xpath = "//div[@id='content']//h1")
    WebElement text;

    @CacheLookup
    @FindBy(xpath = "//div[@class = 'table-responsive']/table/tbody/tr/td[2]/a")
    WebElement productName;

    @CacheLookup
    @FindBy(xpath = "//div[@class = 'table-responsive']/table/tbody/tr/td[2]/small[1]")
    WebElement date;

    @CacheLookup
    @FindBy(xpath = "//div[@class = 'table-responsive']/table/tbody/tr/td[3]")
    WebElement model;

    @CacheLookup
    @FindBy(xpath = "//div[@class = 'table-responsive']/table/tbody/tr/td[6]")
    WebElement total;

    @CacheLookup
    @FindBy(xpath = "(//a[contains(text(),'MacBook')])[2]")
    WebElement checkNameOfProductMacBook;

    @CacheLookup
    @FindBy(xpath = "//input[@class='form-control']")
    WebElement clearTheQtyBox;

    @CacheLookup
    @FindBy(xpath = "//input[@class='form-control']")
    WebElement changeQuantity;

    @CacheLookup
    @FindBy(xpath = "(//button[@type='submit'])[1]")
    WebElement updateTheBox;

    @CacheLookup
    @FindBy(xpath = "//div[@class='alert alert-success alert-dismissible']")
    WebElement modifiedSuccessMessage;

    @CacheLookup
    @FindBy(xpath = "(//td[contains(text(),'£737.45')])[3]")
    WebElement totalPrice;

    @CacheLookup
    @FindBy(xpath = "//a[@class='btn btn-primary']")
    WebElement checkOutButton;


    public String verifyShoppingCartText() {
        return getTextFromElement(text);
    }

    public String verifyProductName() {
        return getTextFromElement(productName);
    }

    public String verifyDate() {
        return getTextFromElement(date);
    }

    public String verifyModel() {
        return getTextFromElement(model);
    }

    public String verifyTotal() {
        return getTextFromElement(total);
    }

    public String verifyProductNameIsMacBook() {
        return getTextFromElement(checkNameOfProductMacBook);
    }

    public void clearTheQtyBox() {
        clearTextFromField(clearTheQtyBox);
    }

    public void enterQuantityIntoTheBox(String qty) {
        sendTextToElement(changeQuantity, qty);
    }

    public void clickOnUpdateTheQuantityBox() {
        clickOnElement(updateTheBox);
    }

    public String verifyUpdatedSuccessMessage() {
        return getTextFromElement(modifiedSuccessMessage);
    }

    public String verifyTotalPrice() {
        return getTextFromElement(totalPrice);
    }

    public void clickOnCheckOutButton() {
        clickOnElement(checkOutButton);
    }
}


