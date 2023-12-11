package com.orangehrmlive.demo.testsuite;

import com.orangehrmlive.demo.customerslisteners.CustomListeners;
import com.orangehrmlive.demo.pages.*;
import com.orangehrmlive.demo.testbase.BaseTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import resources.testdata.TestData;

@Listeners(CustomListeners.class)
public class UserTest extends BaseTest {
    HomePage homePage;
    LoginPage loginPage;
    DashboardPage dashboardPage;
    AddUserPage addUserPage;
    AdminPage adminPage;
    ViewSystemUsersPage viewSystemUsersPage;

    @BeforeMethod(alwaysRun = true)
    public void intIt() {
        homePage = new HomePage();
        loginPage = new LoginPage();
        dashboardPage = new DashboardPage();
        addUserPage = new AddUserPage();
        adminPage = new AdminPage();
        viewSystemUsersPage = new ViewSystemUsersPage();
    }

    @Test(groups = {"sanity", "smoke", "regression"})
    public void adminShouldAddUserSuccessFully() {
        // Login to Application
        loginPage.logInToApplication("Admin", "admin123");

        //click on login
        loginPage.clickOnLogin();

        // * click On "Admin" Tab
        homePage.clickOnAdminTabOnLeftSideMenu();

        // * Verify "System Users" Text
        adminPage.verifySystemUsersText("System Users");

        // * click On "Add" button
        adminPage.clickOnAddButton();

        // * Verify "Add User" Text
        addUserPage.getTextAddUser("Add User");

        // * Select User Role "Admin"
        addUserPage.clickOnDropDownList();
        addUserPage.selectUserRoleFromDropDownList("Admin");
        addUserPage.clickOnEmployeeNameOption();

        // * enter Employee Name "Ananya Dash"
        addUserPage.enterEmployeeNameToTheField("Ananya Dash");

        // * enter Username
        //addUserPage.selectUsernameInToTheUsernameField("Ananya.Dash");
        // * Select status "Disable"
        addUserPage.clickOnDropDownList();
        addUserPage.selectStatusFromDropDownList("Disable");

        // * enter password
        addUserPage.enterPasswordInToThePasswordField("admin123");

        // * enter Confirm Password
        addUserPage.enterConfirmPasswordInToTheConfirmPasswordField("admin123");

        // * click On "Save" Button
        addUserPage.clickOnSaveButton();

        // * verify message "Successfully Saved"
        addUserPage.getTextForSuccessfullyMessageAfterSavedAddedUser("Successfully Saved");
    }

    @Test(groups = {"sanity", "regression"})
    // 2. searchTheUserCreatedAndVerifyIt().
    public void searchTheUserCreatedAndVerifyIt() {
        // Login to Application
        loginPage.logInToApplication("Admin", "admin123");

        //click on login
        loginPage.clickOnLogin();

        // * click On "Admin" Tab
        homePage.clickOnAdminTabOnLeftSideMenu();

        // * Verify "System Users" Text
        adminPage.verifySystemUsersText("System Users");

        // * Enter Username
        viewSystemUsersPage.searchWithUsername("Linda.Anderson");

        // * Select User Role
        addUserPage.clickOnDropDownList();
        addUserPage.selectUserRoleFromDropDownList("Admin");

        // * Select status
        viewSystemUsersPage.clickOnSearchWithStatusDropDown();
        addUserPage.selectStatusFromDropDownList("Disable");

        // * Click on "Search" Button
        viewSystemUsersPage.clickOnSearchButton();

        // * Verify the User should be in Result list.
        viewSystemUsersPage.verifyTheSearchResultList("Linda.Anderson");
    }

    @Test(groups = {"regression"})
    // 3. verifyThatAdminShouldDeleteTheUserSuccessFully().
    public void verifyThatAdminShouldDeleteTheUserSuccessFully() {
        // Login to Application
        loginPage.logInToApplication("Admin", "admin123");

        //click on login
        loginPage.clickOnLogin();

        // * click On "Admin" Tab
        homePage.clickOnAdminTabOnLeftSideMenu();

        // * Verify "System Users" Text
        adminPage.verifySystemUsersText("System Users");

        // * Enter Username
        viewSystemUsersPage.searchWithUsername("Linda.Anderson");

        // * Select User Role
        addUserPage.clickOnDropDownList();
        addUserPage.selectUserRoleFromDropDownList("Admin");

        // * Select status
        viewSystemUsersPage.clickOnSearchWithStatusDropDown();
        addUserPage.selectStatusFromDropDownList("Disable");

        // * Click on "Search" Button
        viewSystemUsersPage.clickOnSearchButton();

        // * Verify the User should be in Result list.
        viewSystemUsersPage.verifyTheSearchResultList("Linda.Anderson");

        // * Click on Check box
        viewSystemUsersPage.clickOnCheckBoxRadioButton();

        // * Click on Delete Button
        viewSystemUsersPage.clickOnDeleteButton();

        // * Popup will display
        viewSystemUsersPage.verifyThePopUpWindowIsDisplayed();

        // * Click on Ok Button on Popup
        viewSystemUsersPage.clickOnYesButton();

        // * verify message "Successfully Deleted"
        addUserPage.getTextForSuccessfullyMessageAfterSavedAddedUser("Successfully Saved");

    }

    @Test(groups = {"regression"}, dataProvider = "Data Set", dataProviderClass = TestData.class)
    // 4. searchTheUserAndVerifyTheMessageRecordFound().
    public void searchTheUserAndVerifyTheMessageRecordFound() {
        // Login to Application
        loginPage.logInToApplication("Admin", "admin123");

        //click on login
        loginPage.clickOnLogin();

        // * click On "Admin" Tab
        homePage.clickOnAdminTabOnLeftSideMenu();

        // * Verify "System Users" Text
        adminPage.verifySystemUsersText("System Users");
        // * Enter Username <username>
        viewSystemUsersPage.searchWithUsername("Linda.Anderson");

        // * Select User Role
        addUserPage.clickOnDropDownList();
        addUserPage.selectUsernameInToTheUsernameField("Admin");

        // * Enter EmployeeName <employeeName>
        viewSystemUsersPage.enterEmployeeName("Ananya Dash");

        // * Select status
        viewSystemUsersPage.clickOnSearchWithStatusDropDown();

        addUserPage.selectStatusFromDropDownList("Disable");
        // viewSystemUsersPage.selectStatusFromDropDownList("Enabled");

        // * Click on "Search" Button
        viewSystemUsersPage.clickOnSearchButton();

        // * verify message "(1) Record Found"
        viewSystemUsersPage.verifyNoRecordFoundMessage("No Records Found");

        // * Verify username <username>
        viewSystemUsersPage.verifyUsernameLabel("Username");

        // * Click on Reset Tab
        viewSystemUsersPage.clickOnReSetButton();

    }
}