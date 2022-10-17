package tests;

import base.TestBase;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.LoginPage;

import java.io.IOException;

import static utils.TestUtil.takeScreenshotAtEndOfTest;


public class HomePageTest extends TestBase {

    LoginPage loginPage;
    HomePage homePage;

    public HomePageTest() {
        super();
    }

    @BeforeMethod
    public void setUp() throws IOException {
        initialization();
        loginPage = new LoginPage();
        homePage = new HomePage();
        loginPage.clickOnAccountsMenu();
        loginPage.login(prop.getProperty("email"), prop.getProperty("password"));
        takeScreenshotAtEndOfTest();
    }

    @Test
    public void clickSamsung() throws InterruptedException, IOException {
        homePage.clickOnHamburgerMenu();
        homePage.selectAppliancesMenu();
        homePage.selectTelevisionsMenu();
        homePage.filterSamsungBrand();
        homePage.ClickSamsungBrand();
        takeScreenshotAtEndOfTest();
    }

    @AfterMethod
    public void tearDown() {
        driver.quit();
    }
}
