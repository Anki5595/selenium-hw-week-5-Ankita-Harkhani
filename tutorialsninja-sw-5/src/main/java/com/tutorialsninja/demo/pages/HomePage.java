package com.tutorialsninja.demo.pages;

import com.tutorialsninja.demo.utilities.Utility;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;

public class HomePage extends Utility {

    //call selectMenu method and pass the menu name
//    By topMenu = By.xpath("//nav[@id='menu']//ul/li[contains(@class, 'open')]/div/child::*");

    @CacheLookup
    @FindBy(linkText = "Desktops")
    WebElement desktop;

    @CacheLookup
    @FindBy(xpath = "//h2[contains(text(),'Desktops')]")
    WebElement desktopText;

    @CacheLookup
    @FindBy(xpath = "//a[normalize-space()='Laptops & Notebooks']")
    WebElement laptopAndNotebook;

    @CacheLookup
    @FindBy(xpath = "//h2[normalize-space()='Laptops & Notebooks']")
    WebElement laptopAndNoteBookText;

    @CacheLookup
    @FindBy(xpath = "//a[normalize-space()='Components']")
    WebElement components;

    @CacheLookup
    @FindBy(xpath = "//h2[normalize-space()='Components']")
    WebElement componentsText;

    @CacheLookup
    @FindBy(xpath = "//button[@class='btn btn-link dropdown-toggle']")
    WebElement dropdown;

    @CacheLookup
    @FindBy(xpath = "(//button[normalize-space()='£Pound Sterling'])[1]")
    WebElement sterling;

    @CacheLookup
    @FindBy(xpath = "//span[normalize-space()='My Account']")
    WebElement accountLink;


    public void selectMenu(String menu) {
        WebElement menuList = driver.findElement(By.linkText(menu));
        Actions actions = new Actions(driver);
        actions.moveToElement(menuList).click().build().perform();
//        List<WebElement> topMenuList = getListOfElements(topMenu);
//        try {
//            for (WebElement element : topMenuList) {
//                if (element.getText().equalsIgnoreCase(menu)) {
//                    element.click();
//                }
//            }
//        } catch (StaleElementReferenceException e) {
//            topMenuList = getListOfElements(topMenu);
//        }
    }


    public void clickOnDesktopTab() {
        mouseHoverToElementAndClick(desktop);
    }

    public String verifyDesktopsText() {
        return getTextFromElement(desktopText);
    }

    public void clickOnLaptopAndNotebook() {
        mouseHoverToElementAndClick(laptopAndNotebook);
    }

    public String verifyLaptopAndNoteText() {
        return getTextFromElement(laptopAndNoteBookText);
    }

    public void clickOnComponents() {
        mouseHoverToElementAndClick(components);
    }

    public String verifyComponentsText() {
        return getTextFromElement(componentsText);
    }

    public void mouseHoverOnCurrencyDropdownAndClick() {
        mouseHoverToElementAndClick(dropdown);
    }

    public void mouseHoverOnPoundAndClick() {
        mouseHoverToElementAndClick(sterling);
    }

    public void clickOnAccountLink() {
      mouseHoverToElementAndClick(accountLink);
    }
}




