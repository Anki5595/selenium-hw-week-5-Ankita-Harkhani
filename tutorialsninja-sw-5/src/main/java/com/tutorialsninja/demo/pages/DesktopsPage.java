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
    @FindBy(xpath = "//div[@class='caption']//a[contains(text(),'HTC Touch HD')]")
    WebElement click;

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

    public void selectProduct(String product) {
      sendTextToElement(click, product);

    }
}
