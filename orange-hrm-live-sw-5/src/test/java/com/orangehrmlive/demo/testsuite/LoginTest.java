package com.orangehrmlive.demo.testsuite;

import com.orangehrmlive.demo.customerslisteners.CustomListeners;
import com.orangehrmlive.demo.pages.DashboardPage;
import com.orangehrmlive.demo.pages.HomePage;
import com.orangehrmlive.demo.pages.LoginPage;
import com.orangehrmlive.demo.testbase.BaseTest;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import resources.testdata.TestData;

@Listeners(CustomListeners.class)
public class LoginTest extends BaseTest {
    LoginPage loginPage;
    DashboardPage dashboardPage;
    HomePage homePage;

    @BeforeMethod(alwaysRun = true)
    public void inIt() {
        loginPage = new LoginPage();
        dashboardPage = new DashboardPage();
        homePage = new HomePage();
    }

    @Test(groups = {"sanity", "smoke", "regression"})
    public void verifyUserShouldLoginSuccessFully() {
        loginPage.logInToApplication("Admin", "admin123");

        // * Verify "Dashboard" Message
        loginPage.getTextForLoginPanel("Dashboard");
    }

    @Test(groups = {"smoke", "regression"})
    public void verifyThatTheLogoDisplayOnHomePage() {

        // * Verify Logo is Displayed
        loginPage.getLogoElement("Logo HR for All is not displayed on the login page");

        // * Login To The application
        loginPage.logInToApplication("Admin", "admin123");

        // loginPage.getLogoElement1("");
    }

    @Test(groups = {"regression"})
    // 3. verifyUserShouldLogOutSuccessFully()
    public void verifyUserShouldLogOutSuccessFully() {
        // * Login To The application
        loginPage.logInToApplication("Admin", "admin123");

        // * Click on User Profile logo
        homePage.clickOnUserProfileLogo();

        // * Mouse hover on "Logout" and click
        homePage.mouseHoverAndClickOnLogoutButton();

        // * Verify the text "Login Panel" is displayed
        loginPage.getTextForLoginPanel("Login");
    }

    @Test(groups = {"regression"}, dataProvider = "credentials", dataProviderClass = TestData.class)
    public void verifyErrorMessageWithInvalidCredentials(String Username, String Password, String message) {
        // * Login To The application
        loginPage.logInToApplication(Username, Password);

        //click on login
        loginPage.clickOnLogin();

        // * Verify Error message <errorMessage>
        String expected = message;
        String actual = loginPage.getErrorMessage();
        Assert.assertEquals(actual, expected, "Invalid Input");

    }

    @Test(groups = {"regression"}, dataProvider = "credentials", dataProviderClass = TestData.class)
    public void verifyInvalidInputMessageWithInvalidCredentials(String Username, String Password, String message) {
        // * Login To The application
        loginPage.logInToApplication(Username, Password);

        //click on login
        loginPage.clickOnLogin();

        // * Verify Error message <errorMessage>
        String expected = message;
        String actual = loginPage.getInvalidInputMessage();
        Assert.assertEquals(actual, expected, "Invalid Input");
    }
}




