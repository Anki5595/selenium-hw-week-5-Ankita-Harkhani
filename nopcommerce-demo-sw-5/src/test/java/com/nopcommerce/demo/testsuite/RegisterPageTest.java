package com.nopcommerce.demo.testsuite;

import com.nopcommerce.demo.customerslisteners.CustomListeners;
import com.nopcommerce.demo.pages.HomePage;
import com.nopcommerce.demo.pages.RegisterPage;
import com.nopcommerce.demo.testbase.BaseTest;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

@Listeners(CustomListeners.class)
public class RegisterPageTest extends BaseTest {
    HomePage homePage;
    RegisterPage registerPage;

    @BeforeMethod(alwaysRun = true)
    public void intIt() {
        homePage = new HomePage();
        registerPage = new RegisterPage();
    }

    @Test(groups = {"sanity", "smoke", "regression"})
    public void verifyUserShouldNavigateToRegisterPageSuccessfully() {
        //Click on Register Link
        homePage.clickOnRegisterLink();

        // Verify "Register" text
        String expectedText = "Register";
        String actualText = registerPage.verifyRegisterText();
        Assert.assertEquals(actualText, expectedText, "Text not displayed");
    }

    @Test(groups = {"smoke", "regression"})
    public void verifyThatFirstNameLastNameEmailPasswordAndConfirmPasswordFieldsAreMandatory() {
        //Click on Register Link
        homePage.clickOnRegisterLink();

        // Click on "REGISTER" button
        registerPage.clickOnRegisterButton();

        // Verify the error message "First name is required."
        String expectedText = "First name is required.";
        String actualText = registerPage.verifyFirstNameIsRequired();
        Assert.assertEquals(actualText, expectedText, "Text not displayed");

        // Verify the error message "Last name is required."
        String expectedText1 = "Last name is required.";
        String actualText1 = registerPage.verifyLastNameIsRequired();
        Assert.assertEquals(actualText1, expectedText1, "Text not displayed");

        // Verify the error message "Email is required."
        String expectedText2 = "Email is required.";
        String actualText2 = registerPage.verifyEmailIdIsRequired();
        Assert.assertEquals(actualText2, expectedText2, "Text not displayed");

        // Verify the error message "Password is required."
        String expectedText3 = "Password is required.";
        String actualText3 = registerPage.verifyPasswordIsRequired();
        Assert.assertEquals(actualText3, expectedText3, "Text not displayed");

        // Verify the error message "Password is required.
        String expectedText4 = "Password is required.";
        String actualText4 = registerPage.verifyConfirmPasswordIsRequired();
        Assert.assertEquals(actualText4, expectedText4, "Text not displayed");
    }

    @Test(groups = {"regression"})
    public void verifyThatUserShouldCreateAccountSuccessfully() {
        // Click on Register Link
        homePage.clickOnRegisterLink();
        // Select gender "Female"
        registerPage.clickOnRadioButton();
        // Enter firstname
        registerPage.enterFirstName("Michel");
        // Enter lastname
        registerPage.enterLastName("Jackson");
        // Select day
        registerPage.enterDayOfBirth("5");
        // Select month
        registerPage.enterMonthOfBirth("May");
        // Select year
        registerPage.enterYearOfBirth("1995");
        // Enter email
        registerPage.enterEmail();
        // Enter password
        registerPage.enterPassword("1234567");
        // Enter Confirm Password
        registerPage.enterConfirmPassword("1234567");
        // Click on "REGISTER" button
        registerPage.clickOnRegisterButton();
        // Verify message "Your registration completed"
        String expectedText = "Your registration completed";
        String actualText = registerPage.verifyRegistrationCompleteText();
        Assert.assertEquals(actualText, expectedText, "Text not displayed");
    }

}

