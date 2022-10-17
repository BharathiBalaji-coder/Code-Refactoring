package pages;

import base.TestBase;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class LoginPage extends TestBase {
    /**
     * Page Factory-Object repository
     */
    @FindBy(id = "ap_email")
    WebElement emailId;

    @FindBy(id = "continue")
    WebElement continueBtn;

    @FindBy(id = "ap_password")
    WebElement password;

    @FindBy(id = "signInSubmit")
    WebElement submitBtn;

    @FindBy(xpath = "//span[normalize-space()='Account & Lists']")
    WebElement accountsAndListsMenu;
    @FindBy(xpath = "//div[@id='nav-flyout-ya-signin']//span[@class='nav-action-inner'][normalize-space()='Sign in']")
    WebElement signInBtn;

    /**
     * Initialize Page objects
     */

    public LoginPage() {

        PageFactory.initElements(driver, this);

    }

    /**
     * Action Methods
     */

    public void clickOnAccountsMenu() {
        Actions action = new Actions(driver);
        action.moveToElement(accountsAndListsMenu).build().perform();
        signInBtn.click();
    }

    public String validateLoginPageTitle() {
        return driver.getTitle();
    }

    public String validateSignInPageTitle() {
        return driver.getTitle();
    }

    public void login(String email, String pwd) {
        emailId.sendKeys(email);
        continueBtn.click();
        password.sendKeys(pwd);
        submitBtn.click();

    }

}
