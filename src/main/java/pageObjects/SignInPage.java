package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;
import java.util.logging.Logger;

public class SignInPage extends AbstractPage {


    private static final Logger LOG = Logger.getLogger(String.valueOf(SignInPage.class));

    private final By checkMessageOnSignPage = By.xpath("//span[contains(text(),'If you have an account')]");

    private final By fieldCustomerEmail = By.xpath("//input[@id='signin_userName']");
    private final By fieldCustomerPassword = By.xpath("//input[@id='signin_password']");
    private final By signInButton = By.xpath("//button[@id='genericLogin-button']");

    private final By loginErrorElement = By.xpath("//div[@id='loginError']");

    private final By getAllLinkFromFooter = By.xpath("//div[@class='footer-wrapper']//div[1]//ul[1]//a");


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

    public MyAccountPage clickSignInButton() {
        getElement(signInButton).click();
        LOG.info("'Proceed Sign in' is clicked");
        return new MyAccountPage();
    }

    public boolean isLoginErrorMessageDisplayed() {
        boolean isDisplayed = isDisplayed(loginErrorElement);
        LOG.info(String.format("text 'Login error...' '%s'", isDisplayed));
        return isDisplayed;
    }

    public List<WebElement> getLinksListAfterSignIn() {
        List<WebElement> linksListAfterLogin = getElements(getAllLinkFromFooter);
        LOG.info("'Links on footer' are got");
        return linksListAfterLogin;
    }
}
