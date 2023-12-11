package com.nopcommerce.demo.pages;

import com.nopcommerce.demo.utilities.Utility;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;

public class DesktopsPage extends Utility {

    @CacheLookup
    @FindBy(xpath = "//div[@class='page-title']")
    WebElement desktopText;

    @CacheLookup
    @FindBy(xpath = "//h2[@class='product-title']//a[normalize-space()='Build your own computer']")
    WebElement clickBuildOnComputer;

    public String getDesktopsText() {
        return getTextFromElement(desktopText);
    }

    public void clickBuildOnComputer() {
        clickOnElement(clickBuildOnComputer);
    }
}
