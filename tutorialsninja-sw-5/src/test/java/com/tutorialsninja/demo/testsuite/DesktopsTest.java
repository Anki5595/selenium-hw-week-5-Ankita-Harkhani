package com.tutorialsninja.demo.testsuite;

import com.tutorialsninja.demo.customerslisteners.CustomListeners;
import com.tutorialsninja.demo.pages.DesktopsPage;
import com.tutorialsninja.demo.pages.HomePage;
import com.tutorialsninja.demo.pages.ProductPage;
import com.tutorialsninja.demo.pages.ShoppingCartPage;
import com.tutorialsninja.demo.testbase.BaseTest;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import resources.testdata.TestData;

@Listeners(CustomListeners.class)
public class DesktopsTest extends BaseTest {
    HomePage homePage;
    DesktopsPage desktopsPage;
    ProductPage productPage;
    ShoppingCartPage shoppingCartPage;

    @BeforeMethod(alwaysRun = true)
    public void intIt() {
        homePage = new HomePage();
        desktopsPage = new DesktopsPage();
        productPage = new ProductPage();
        shoppingCartPage = new ShoppingCartPage();
    }

    @Test(groups = {"sanity", "smoke", "regression"})
    public void verifyProductArrangeInAlphabeticalOrder() {

        //1.1 Mouse hover on “Desktops” Tab and click
        homePage.clickOnDesktopTab();

        //1.2 call selectMenu method and pass the menu = “Show AllDesktops”
        homePage.selectMenu("Show AllDesktops");

        //1.3 Select Sort By position "Name: Z to A"
        desktopsPage.selectSortByOption("Name (Z - A)");

        //1.4 Verify the Product will arrange in Descending order.
        desktopsPage.verifySortedElementsInReverseOrder();
    }


    @Test(groups = {"smoke", "regression"}, dataProvider = "Product1", dataProviderClass = TestData.class)
    public void verifyProduct1AddedToShoppingCartSuccessFully(String product, String qty, String successMessage,
                                                              String productName, String model, String total) {
        //2.1 Mouse hover on Currency Dropdown and click
        homePage.mouseHoverOnCurrencyDropdownAndClick();

        //2.2 Mouse hover on £Pound Sterling and click
        homePage.mouseHoverOnPoundAndClick();

        //2.3 Mouse hover on Desktops Tab.
        homePage.clickOnDesktopTab();

        //2.4 Click on “Show All Desktops”
        homePage.selectMenu("Show AllDesktops");

        //2.5 Select Sort By position "Name: A to Z"
        desktopsPage.sortByNameAToZPosition("Name (A - Z)");

        //2.6 Select product <product>
        desktopsPage.selectProduct1(product);

        //2.7 Enter Qty <qty> using Select class.
        productPage.enterQty(qty);

        //2.8 Click on “Add to Cart” button
        productPage.clickOnAddToCartButton();

        //2.9 Verify the Message “Success: You have added product to your shopping cart!”

        String expectedMessage = successMessage + "\n×";
        String actualMessage = productPage.verifySuccessMessageToAddInCart();
        Assert.assertEquals(actualMessage, expectedMessage, "Incorrect Text!");

        //2.10 Click on link “shopping cart” display into success message
        productPage.clickOnShoppingCart();

        //2.11 Verify the text "Shopping Cart"
        String expectedTxt = "Shopping Cart  (0.15kg)";
        String actualTxt = shoppingCartPage.verifyShoppingCartText();
        Assert.assertEquals(actualTxt, expectedTxt, "Incorrect Text!");

        //2.12 Verify the Product name
        String expectedName = productName;
        String actualName = shoppingCartPage.verifyProductName();
        Assert.assertEquals(actualName, expectedName, "Incorrect Text!");

        //2.13 Verify the Model
        String expectedModel = model;
        String actualModel = shoppingCartPage.verifyModel();
        Assert.assertEquals(actualModel, expectedModel, "Incorrect Model!");

        //2.14 Verify the Total
        String expectedTotal = total;
        String actualTotal = shoppingCartPage.verifyTotal();
        Assert.assertEquals(actualTotal, expectedTotal, "Incorrect Total!");

    }

    @Test(groups = {"regression"}, dataProvider = "Product2", dataProviderClass = TestData.class)
    public void verifyProduct2AddedToShoppingCartSuccessFully(String product, String qty, String successMessage,
                                                              String productName, String model, String total) {
        //2.1 Mouse hover on Currency Dropdown and click
        homePage.mouseHoverOnCurrencyDropdownAndClick();

        //2.2 Mouse hover on £Pound Sterling and click
        homePage.mouseHoverOnPoundAndClick();

        //2.3 Mouse hover on Desktops Tab.
        homePage.clickOnDesktopTab();

        //2.4 Click on “Show All Desktops”
        homePage.selectMenu("Show AllDesktops");

        //2.5 Select Sort By position "Name: A to Z"
        desktopsPage.sortByNameAToZPosition("Name (A - Z)");

        //2.6 Select product <product>
        desktopsPage.selectProduct2(product);

        //2.7 Enter Qty <qty> using Select class.
        productPage.enterQty(qty);

        //2.8 Click on “Add to Cart” button
        productPage.clickOnAddToCartButton();

        //2.9 Verify the Message “Success: You have added product to your shopping cart!”
        String expectedMessage = successMessage + "\n×";
        String actualMessage = productPage.verifySuccessMessageToAddInCart();
        Assert.assertEquals(actualMessage, expectedMessage, "Incorrect Text!");

        //2.10 Click on link “shopping cart” display into success message
        productPage.clickOnShoppingCart();

        //2.11 Verify the text "Shopping Cart"
        String expectedTxt = "Shopping Cart  (20.00kg)";
        String actualTxt = shoppingCartPage.verifyShoppingCartText();
        Assert.assertEquals(actualTxt, expectedTxt, "Incorrect Text!");

        //2.12 Verify the Product name
        String expectedName = productName;
        String actualName = shoppingCartPage.verifyProductName();
        Assert.assertEquals(actualName, expectedName, "Incorrect Text!");

        //2.13 Verify the Model
        String expectedModel = model;
        String actualModel = shoppingCartPage.verifyModel();
        Assert.assertEquals(actualModel, expectedModel, "Incorrect Model!");

        //2.14 Verify the Total
        String expectedTotal = total;
        String actualTotal = shoppingCartPage.verifyTotal();
        Assert.assertEquals(actualTotal, expectedTotal, "Incorrect Total!");

    }

    @Test(groups = {"regression"}, dataProvider = "Product3", dataProviderClass = TestData.class)
    public void verifyProduct3AddedToShoppingCartSuccessFully(String product, String qty, String successMessage,
                                                              String productName, String model, String total) {
        //2.1 Mouse hover on Currency Dropdown and click
        homePage.mouseHoverOnCurrencyDropdownAndClick();

        //2.2 Mouse hover on £Pound Sterling and click
        homePage.mouseHoverOnPoundAndClick();

        //2.3 Mouse hover on Desktops Tab.
        homePage.clickOnDesktopTab();

        //2.4 Click on “Show All Desktops”
        homePage.selectMenu("Show AllDesktops");

        //2.5 Select Sort By position "Name: A to Z"
        desktopsPage.sortByNameAToZPosition("Name (A - Z)");

        //2.6 Select product <product>
        desktopsPage.selectProduct3(product);

        //2.7 Enter Qty <qty> using Select class.
        productPage.enterQty(qty);

        //2.8 Click on “Add to Cart” button
        productPage.clickOnAddToCartButton();

        //2.9 Verify the Message “Success: You have added product to your shopping cart!”
        String expectedMessage = successMessage + "\n×";
        String actualMessage = productPage.verifySuccessMessageToAddInCart();
        Assert.assertEquals(actualMessage, expectedMessage, "Incorrect Text!");

        //2.10 Click on link “shopping cart” display into success message
        productPage.clickOnShoppingCart();

        //2.11 Verify the text "Shopping Cart"
        String expectedTxt = "Shopping Cart  (0.40kg)";
        String actualTxt = shoppingCartPage.verifyShoppingCartText();
        Assert.assertEquals(actualTxt, expectedTxt, "Incorrect Text!");

        //2.12 Verify the Product name
        String expectedName = productName;
        String actualName = shoppingCartPage.verifyProductName();
        Assert.assertEquals(actualName, expectedName, "Incorrect Text!");

        //2.13 Verify the Model
        String expectedModel = model;
        String actualModel = shoppingCartPage.verifyModel();
        Assert.assertEquals(actualModel, expectedModel, "Incorrect Model!");

        //2.14 Verify the Total
        String expectedTotal = total;
        String actualTotal = shoppingCartPage.verifyTotal();
        Assert.assertEquals(actualTotal, expectedTotal, "Incorrect Total!");
        CustomListeners.test.addScreenCaptureFromPath("test-output/html/verifyProduct3AddedToShoppingCartSuccessFullyMon_Dec_11_21_44_11_GMT_2023.jpg");
    }

}

