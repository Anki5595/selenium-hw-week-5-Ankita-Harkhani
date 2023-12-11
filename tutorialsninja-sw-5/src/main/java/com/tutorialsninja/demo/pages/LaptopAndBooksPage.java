package com.tutorialsninja.demo.pages;

import com.tutorialsninja.demo.utilities.Utility;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;

public class LaptopAndBooksPage extends Utility {
    @CacheLookup
    @FindBy(xpath = "(//select[@id='input-sort'])[1]")
    WebElement sortByPriceHighToLow;

    @CacheLookup
    @FindBy(xpath = "//p[@class ='price']")
    WebElement arrayListOfProducts;

    @CacheLookup
    @FindBy(id = "input-sort")
    WebElement price;

    @CacheLookup
    @FindBy(linkText = "MacBook")
    WebElement product;

    public void selectSortByPriceHighToLow(String options) {
        selectByVisibleTextFromDropDown(sortByPriceHighToLow, options);
        getArrayListOfProductsInChoice(arrayListOfProducts);

    }

    public String verifyProductPriceArrangeInHighToLow() {
        return verifyTheProductArrangementInArrayList(arrayListOfProducts);
    }

    public void sortByPrice(String option) {
        selectByVisibleTextFromDropDown(price, option);
    }

    public void selectMacBookProduct() {
        clickOnElement(product);
    }
}
