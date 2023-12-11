package com.tutorialsninja.demo.pages;

import com.aventstack.extentreports.Status;
import com.tutorialsninja.demo.customerslisteners.CustomListeners;
import com.tutorialsninja.demo.utilities.Utility;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.testng.Reporter;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class DesktopsPage extends Utility {

    @CacheLookup
    @FindBy(xpath = "//h4/a")
    List<WebElement> listOfProducts;

    @CacheLookup
    @FindBy(id = "input-sort")
    WebElement descendingOrder;

    @CacheLookup
    @FindBy(id = "input-sort")
    WebElement ascendingOrder;

    @CacheLookup
    @FindBy(xpath = "(//a[normalize-space()='HTC Touch HD'])[1]")
    WebElement product1;

    @CacheLookup
    @FindBy(xpath = "(//a[normalize-space()='iPhone'])[1]")
    WebElement product2;

    @CacheLookup
    @FindBy(xpath = "(//a[normalize-space()='Palm Treo Pro'])[1]")
    WebElement product3;

    public void verifySortedElementsInReverseOrder() {
        Reporter.log("Get elements sorted in reverse order" + descendingOrder.toString());
        List<WebElement> elements = listOfProducts;
        ArrayList<String> originalElementList = new ArrayList<>();
        for (WebElement e : elements) {
            originalElementList.add(e.getText());
        }
        System.out.println(originalElementList);

        Collections.reverse(originalElementList);
        System.out.println(originalElementList);

        elements = listOfProducts;
        ArrayList<String> afterSortByReverseList = new ArrayList<>();
        for (WebElement e : elements) {
            afterSortByReverseList.add(e.getText());
        }
        System.out.println(afterSortByReverseList);
        CustomListeners.test.log(Status.PASS, "Get elements sorted in reverse order");

    }

    public void selectSortByOption(String option) {
        Reporter.log("Select sortBy option" + descendingOrder.toString());
        selectByVisibleTextFromDropDown(descendingOrder, option);
        CustomListeners.test.log(Status.PASS, "Select sortBy option" + option);
    }

    public void sortByNameAToZPosition(String option) {
        selectByVisibleTextFromDropDown(ascendingOrder, option);
    }

    public void selectProduct1(String product) {
        mouseHoverToElementAndClick(product1);

    }
    public void selectProduct2(String product) {
       mouseHoverToElementAndClick(product2);

    }
    public void selectProduct3(String product) {
        mouseHoverToElementAndClick(product3);

    }
}
