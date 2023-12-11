package com.orangehrmlive.demo.pages;

import com.orangehrmlive.demo.utilities.Utility;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;

public class AdminPage extends Utility {
    @CacheLookup
    @FindBy(xpath = "//h5[normalize-space()='System Users']")
    WebElement systemUsersText;

    @CacheLookup
    @FindBy(xpath = "//button[normalize-space()='Add']")
    WebElement addButton;

    public void verifySystemUsersText(String text) {
        verifyThatTextIsDisplayed(systemUsersText, text);
    }

    public void clickOnAddButton() {
        clickOnElement(addButton);
    }
}
