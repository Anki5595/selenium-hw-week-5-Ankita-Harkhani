package com.nopcommerce.demo.testsuite;

import com.nopcommerce.demo.customerslisteners.CustomListeners;
import com.nopcommerce.demo.pages.HomePage;
import com.nopcommerce.demo.pages.LoginPage;
import com.nopcommerce.demo.pages.RegisterPage;
import com.nopcommerce.demo.testbase.BaseTest;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

@Listeners(CustomListeners.class)
public class LoginPageTest extends BaseTest {
    HomePage homePage;
    LoginPage loginPage;
    RegisterPage registerPage;

    @BeforeMethod(alwaysRun = true)
    public void intIt() {
        homePage = new HomePage();
        loginPage = new LoginPage();
        registerPage = new RegisterPage();
    }

    @Test(groups = {"sanity", "smoke", "regression"})
    public void userShouldNavigateToLoginPageSuccessFully() {
        // Click on login link
        homePage.clickOnLoginLink();

        //verify that "Welcome, Please Sign In!" message display
        String expectedMessage = "Welcome, Please Sign In!";
        String actualMessage = loginPage.getWelcomeText();
        Assert.assertEquals(expectedMessage, actualMessage, "Login page not displayed");
    }

    @Test(groups = {"smoke", "regression"})
    public void verifyTheErrorMessageWithInValidCredentials() {
        //Click on login link
        homePage.clickOnLoginLink();

        //Enter EmailId
        loginPage.enterEmailId("ankita1234@gmail.com");

        //Enter Password
        loginPage.enterPassword("123456");

        //Click on Login Button
        loginPage.clickOnLoginButton();

        //Verify that the Error message
        String expectedErrorMessage = "Login was unsuccessful. Please correct the errors and try again.\n" +
                "No customer account found";
        String actualErrorMessage = loginPage.getErrorMessage();
        Assert.assertEquals(actualErrorMessage, expectedErrorMessage, "Error Message not displayed");
    }

    @Test(groups = {"regression"})
    public void verifyThatUserShouldLogInSuccessFullyWithValidCredentials() {
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
        //Click on continue
        registerPage.clickOnContinue();

        //Click on login link
        homePage.clickOnLoginLink();

        //Enter EmailId
        loginPage.enterEmailId(RegisterPage.generatedEmail);

        //Enter Password
        loginPage.enterPassword("1234567");

        //Click on Login Button
        loginPage.clickOnLoginButton();

        //Verify the ‘Log out’ text is display
        String expectedText = "Log out";
        String actualText = loginPage.logOutLink();
        Assert.assertEquals(actualText, expectedText, "Text not displayed");
    }

    @Test(groups = {"regression"})
    public void verifyThatUserShouldLogOutSuccessFully() {
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
        //Click on continue
        registerPage.clickOnContinue();

        //Click on login link
        homePage.clickOnLoginLink();

        //Enter EmailId
        loginPage.enterEmailId(RegisterPage.generatedEmail);

        //Enter Password
        loginPage.enterPassword("1234567");

        //Click on Login Button
        loginPage.clickOnLoginButton();

        //Click on LogOut Link
        loginPage.clickOnLogOutLink();

        //Verify that LogIn Link Display
        String expectedText = "Log in";
        String actualText = homePage.getLoginLink();
        Assert.assertEquals(actualText, expectedText, "Text not displayed");

    }


}

