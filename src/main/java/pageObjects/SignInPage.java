package pageObjects;

import driver.DriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.interactions.Actions;

import java.util.logging.Logger;

public class SignInPage extends AbstractPage {

    Actions actions = new Actions(DriverFactory.getDriver());

    private static final Logger LOG = Logger.getLogger(String.valueOf(SignInPage.class));


    private final By checkMessageOnSignPage = By.xpath("//span[contains(text(),'If you have an account')]");

    private final By fieldCustomerEmail = By.xpath("//input[@id='signin_userName']");
    private final By fieldCustomerPassword = By.xpath("//input[@id='signin_password']");
    private final By signInButton = By.xpath("//button[@id='genericLogin-button']");

    private final By checkMessageOnMyAccount = By.xpath("//p[normalize-space()='My Account']");
    private final By loginErrorElement = By.xpath("//div[@id='loginError']");

    private final By homeButtonElement = By.xpath("//a[@href='/shop/' and @class='dropdown-toggle']");
    private final By logoElement = By.xpath("//img[@class='logoImage']");


    private final By featuredItemAddToCartElement = By.xpath("//a[@productid='4']");
    private final By shoppingCartOnHomePageElement = By.xpath("//a[@aria-expanded='true']//span[@class='hidden-xs']");
    private final By checkoutElement = By.xpath("//a[@onclick='viewShoppingCartPage();']");
    private final By cookiesDismissElement = By.xpath("//a[@class='cc-btn cc-dismiss']");


    public boolean isRegisteredCustomerDisplayed() {
        boolean isDisplayed = isDisplayed(checkMessageOnSignPage);
        LOG.info(String.format("text 'If you have an account...' '%s'", isDisplayed));
        return isDisplayed;
    }


    public SignInPage enterEmail(String email) {
        getElement(fieldCustomerEmail).sendKeys(email);
        LOG.info("Mail was entered");
        return this;
    }

    public SignInPage enterPassword (String password) {
        getElement(fieldCustomerPassword).sendKeys(password);
        LOG.info("Password was entered");
        return this;
    }

    public SignInPage clickSignInButton() {
        getElement(signInButton).click();
        LOG.info("'Proceed Sign in' is clicked");
        return this;
    }

    public boolean isMyAccountDisplayed() {
        boolean isDisplayed = isDisplayed(checkMessageOnMyAccount);
        LOG.info(String.format("text 'My account' '%s'", isDisplayed));
        return isDisplayed;
    }

    public boolean isLoginErrorMessageDisplayed() {
        boolean isDisplayed = isDisplayed(loginErrorElement);
        LOG.info(String.format("text 'Login error...' '%s'", isDisplayed));
        return isDisplayed;
    }

//        public HomePage clickHomeButton() {
//        WebDriverWait wait = new WebDriverWait(DriverFactory.getDriver(), 10);
//         wait.until(ExpectedConditions.visibilityOfElementLocated(homeButtonElement)).click();// getElement(checkoutElement);
//        //getElement(homeButtonElement).click();
//        // Assert.assertTrue(isDisplayed(logoElement), "Logo Element is not visible");
//        LOG.info("'Home' is clicked");
//        return new HomePage();
//    }

    public HomePage clickToLogoElement() {
        actions.moveToElement( getElement(logoElement)).click();
        // Assert.assertTrue(isDisplayed(logoElement), "Logo Element is not visible");
        LOG.info("Logo Element is clicked");
        return new HomePage();
    }

}
