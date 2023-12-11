package com.orangehrmlive.demo.pages;

import com.orangehrmlive.demo.utilities.Utility;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;

public class HomePage extends Utility {
    @CacheLookup
    @FindBy(xpath = ("//i[@class='oxd-icon bi-caret-down-fill oxd-userdropdown-icon']"))
    WebElement userProfileLogo;

    @CacheLookup
    @FindBy(linkText = ("Logout"))
    WebElement logoutButton;

    @CacheLookup
    @FindBy(xpath = ("//li[1]//a[1]//span[1]"))
    WebElement adminTab;


    // *    Click on User Profile logo
    public void clickOnUserProfileLogo() {
        mouseHoverToElementAndClick(userProfileLogo);
    }

    // *    Mouse hover on "Logout" and click
    public void mouseHoverAndClickOnLogoutButton() {
        mouseHoverToElementAndClick(logoutButton);
    }

    //	click On "Admin" Tab
    public void clickOnAdminTabOnLeftSideMenu() {
        clickOnElement(adminTab);
    }
}
