package pages;

import base.TestBase;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.ArrayList;
import java.util.List;

public class ResultsPage extends TestBase {

    /**
     * Page Factory-Object repository
     */

    @FindBy(xpath = "//span[text()='RESULTS']")
    WebElement resultsPage;

    @FindBy(xpath = "//span[normalize-space()='Sign Out']")
    WebElement signOut;

    @FindBy(xpath = "//span[normalize-space()='Account & Lists']")
    WebElement accountsAndListsMenu;

    @FindBy(xpath = "//span[normalize-space()='2,68,311']")
    WebElement clickSecondHighestPrice;

    @FindBy(xpath = "//span[@id='a-autoid-0-announce']")
    WebElement clickDropDown;
    @FindBy(xpath = "//a[@id='s-result-sort-select_2']")
    WebElement sortSamsungResults;
    @FindBy(xpath = "//h1[normalize-space()='About this item']")
    WebElement aboutThisItem;

    /**
     * Initialize Page objects
     */

    public ResultsPage() {
        PageFactory.initElements(driver, this);

    }

    /**
     * Method to validate the page title in the Results Page
     */
    public void validateResultsPageTitle() throws InterruptedException {
        Thread.sleep(5000);
        String actualPageTitle = resultsPage.getText();
        String expectedPageTitle = "RESULTS";
        Assert.assertEquals(expectedPageTitle, actualPageTitle);
    }

    /**
     * Method to sort the samsung TV results from High to Low
     */
    public void sortSamsungResultsPriceInDescendingOrder() throws InterruptedException {
        Thread.sleep(5000);
        WebDriverWait wait = new WebDriverWait(driver, 30);
        wait.until(ExpectedConditions.elementToBeClickable(clickDropDown)).click();
        System.out.println("DropDown label is clicked successfully");
        sortSamsungResults.click();
        System.out.println("Price:High to Low is clicked successfully");
        Thread.sleep(5000);
        List<WebElement> price = driver.findElements(By.xpath("//span[@class='a-price-whole']"));
        int size = price.size();
        System.out.println("Size of list = " + size);

        ArrayList<String> prices = new ArrayList<>();
        for (WebElement priceValue : price) {
            prices.add(priceValue.getText());
            System.out.println("samsung TV price results:" + priceValue.getText());

        }

//        Collections.sort(prices, Collections.reverseOrder());
        for (String tvPrice : prices) {
            System.out.println("Samsung results sorted with price High to Low:" + tvPrice);
        }
        System.out.println("Second highest price item :\n" + prices.get(1));
    }

    /**
     * Method to click on the Second-Highest price items after sorting the price from High to Low
     */
    public void clickSecondHighestPrice() throws InterruptedException {
        Thread.sleep(4000);
        JavascriptExecutor js2 = (JavascriptExecutor) driver;
        js2.executeScript("window.scrollBy(0,250)", "");
        clickSecondHighestPrice.click();
    }

    /**
     * Method to validate the about this item label in the results page
     */
    public void aboutThisItemValidation() throws InterruptedException {
        Thread.sleep(7000);
        ArrayList<String> tabs2 = new ArrayList<>(driver.getWindowHandles());
        driver.switchTo().window(tabs2.get(1));
        System.out.println("Page title of new tab: " + driver.getTitle());

        Thread.sleep(7000);

        Actions actions = new Actions(driver);

        // Scroll Down using Actions class
        actions.keyDown(Keys.CONTROL).sendKeys(Keys.ARROW_DOWN).perform();
        actions.keyDown(Keys.CONTROL).sendKeys(Keys.ARROW_DOWN).perform();
        actions.keyDown(Keys.CONTROL).sendKeys(Keys.ARROW_DOWN).perform();
        actions.keyDown(Keys.CONTROL).sendKeys(Keys.ARROW_DOWN).perform();
        actions.keyDown(Keys.CONTROL).sendKeys(Keys.ARROW_DOWN).perform();
        actions.keyDown(Keys.CONTROL).sendKeys(Keys.ARROW_DOWN).perform();
        actions.keyDown(Keys.CONTROL).sendKeys(Keys.ARROW_DOWN).perform();
        actions.keyDown(Keys.CONTROL).sendKeys(Keys.ARROW_DOWN).perform();
        actions.keyDown(Keys.CONTROL).sendKeys(Keys.ARROW_DOWN).perform();
        actions.keyDown(Keys.CONTROL).sendKeys(Keys.ARROW_DOWN).perform();

        Thread.sleep(7000);
        boolean value = aboutThisItem.isDisplayed();
        System.out.println(value);

        String actLabel = aboutThisItem.getText().trim();
        System.out.println(actLabel);
        String expLabel = "About this item";
        Assert.assertEquals(actLabel, expLabel);

        //switch to parent window
        driver.switchTo().window(tabs2.get(0));
        System.out.println("Page title of parent window: " + driver.getTitle());
    }

    /**
     * Method to logout from the amazon application
     */
    public void signOut() throws InterruptedException {
        Thread.sleep(7000);
        Actions actions1 = new Actions(driver);
        actions1.moveToElement(accountsAndListsMenu).build().perform();
        signOut.click();
    }

}