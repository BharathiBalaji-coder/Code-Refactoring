package tests;

import base.TestBase;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.LoginPage;
import pages.ResultsPage;

import java.io.IOException;

import static utils.TestUtil.takeScreenshotAtEndOfTest;

public class ResultsPageTest extends TestBase {

    LoginPage loginPage;
    HomePage homePage;

    ResultsPage resultsPage;

    public ResultsPageTest() {
        super();
    }

    @BeforeMethod
    public void setUp() throws InterruptedException {
        initialization();
        loginPage = new LoginPage();
        homePage = new HomePage();
        resultsPage = new ResultsPage();

        loginPage.clickOnAccountsMenu();
        loginPage.login(prop.getProperty("email"), prop.getProperty("password"));
        homePage.clickOnHamburgerMenu();
        homePage.selectAppliancesMenu();
        homePage.selectTelevisionsMenu();
        homePage.filterSamsungBrand();
        homePage.ClickSamsungBrand();
    }

    @Test(priority = 1)
    public void validateSamsungResults() throws InterruptedException, IOException {
        resultsPage.validateResultsPageTitle();
        resultsPage.sortSamsungResultsPriceInDescendingOrder();
        resultsPage.clickSecondHighestPrice();
        resultsPage.aboutThisItemValidation();
        takeScreenshotAtEndOfTest();
    }

    @Test(priority = 2)
    public void logOut() throws InterruptedException {
        resultsPage.signOut();
    }

    @AfterMethod
    public void tearDown() {
        driver.quit();
    }
}
