package com.nopcommerce.demo.pages;

import com.nopcommerce.demo.utilities.Utility;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;

public class ComputerPage extends Utility {
    @CacheLookup
    @FindBy(xpath = "//h1[normalize-space()='Computers']")
    WebElement computerText;

    public String getComputerText() {
        return getTextFromElement(computerText);
    }
}


