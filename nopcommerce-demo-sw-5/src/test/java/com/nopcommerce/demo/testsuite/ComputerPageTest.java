package com.nopcommerce.demo.testsuite;

import com.nopcommerce.demo.customerslisteners.CustomListeners;
import com.nopcommerce.demo.pages.BuildYourOwnComputerPage;
import com.nopcommerce.demo.pages.ComputerPage;
import com.nopcommerce.demo.pages.DesktopsPage;
import com.nopcommerce.demo.pages.HomePage;
import com.nopcommerce.demo.testbase.BaseTest;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import resources.testdata.TestData;

@Listeners(CustomListeners.class)
public class ComputerPageTest extends BaseTest {
    HomePage homePage;
    ComputerPage computerPage;
    DesktopsPage desktopsPage;
    BuildYourOwnComputerPage buildYourOwnComputerPage;

    @BeforeMethod(alwaysRun = true)
    public void intIt() {
        homePage = new HomePage();
        computerPage = new ComputerPage();
        desktopsPage = new DesktopsPage();
        buildYourOwnComputerPage = new BuildYourOwnComputerPage();
    }

    @Test(groups = {"sanity", "smoke", "regression"})
    public void verifyUserShouldNavigateToComputerPageSuccessfully() {
        //Click on Computer tab
        homePage.selectMenu("Computers");

        //Verify "Computer" text
        String expectedText = "Computers";
        String actualText = computerPage.getComputerText();
        Assert.assertEquals(actualText, expectedText, "Text not displayed");
    }

    @Test(groups = {"smoke", "regression"})
    public void verifyUserShouldNavigateToDesktopsPageSuccessfully() {
        // Click on Computer tab
        homePage.selectMenu("Computers");

        // Click on Desktops link
        homePage.clickOnDesktop();

        // Verify "Desktops" text
        String expectedText = "Desktops";
        String actualText = desktopsPage.getDesktopsText();
        Assert.assertEquals(actualText, expectedText, "Text not displayed");
    }

    @Test(groups = {"regression"}, dataProvider = "dataSet", dataProviderClass = TestData.class)
    public void verifyThatUserShouldBuildYouOwnComputerAndAddThemToCartSuccessfully(String processor, String ram, String hdd, String os, String software) {
        // Click on Computer tab
        homePage.selectMenu("Computers");

        // Click on Desktops link
        homePage.clickOnDesktop();

        // Click on product name "Build your own computer"
        desktopsPage.clickBuildOnComputer();

        // Select processor "processor"
        buildYourOwnComputerPage.selectProcessor(processor);

        // Select RAM "ram"
        buildYourOwnComputerPage.selectRAM(ram);

        // Select HDD "hdd"
        buildYourOwnComputerPage.selectHDD(hdd);

        // Select OS "os"
        buildYourOwnComputerPage.selectOS(os);

        // Select Software "software"
        buildYourOwnComputerPage.selectSoftware(software);

        // Click on "ADD TO CART" Button
        buildYourOwnComputerPage.clickOnAddToCartLink();

        // Verify message "The product has been added to your shopping cart
        String expectedText = "The product has been added to your shopping cart";
        String actualText = buildYourOwnComputerPage.getMessageText();
        Assert.assertEquals(actualText, expectedText, "Text not displayed");

        //Take screenshot

    }
}

