package tests;


import base.TestBase;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.LoginPage;

import java.io.IOException;

import static utils.TestUtil.takeScreenshotAtEndOfTest;

public class LoginPageTest extends TestBase {
    LoginPage loginPage;

    public LoginPageTest() {
        super();
    }

    @BeforeMethod
    public void setUp() {
        initialization();
        loginPage = new LoginPage();
    }

    @Test(priority = 1)
    public void loginPageTitleTest() throws IOException {
        String title = loginPage.validateLoginPageTitle();
        Assert.assertEquals(title, "Online Shopping site in India: Shop Online for Mobiles, Books, Watches, Shoes and More - Amazon.in");
        takeScreenshotAtEndOfTest();
    }

    @Test(priority = 2)
    public void login() throws IOException {
        loginPage.clickOnAccountsMenu();
        String actualTitle = loginPage.validateSignInPageTitle();
        Assert.assertEquals(actualTitle, "Amazon Sign In");
        loginPage.login(prop.getProperty("email"), prop.getProperty("password"));
        takeScreenshotAtEndOfTest();
    }

    @AfterMethod
    public void tearDown() {
        driver.quit();
    }

}