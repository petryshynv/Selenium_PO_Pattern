package pageObjects;

import consts.BusinessConfigs;
import driver.DriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;

import java.util.List;
import java.util.logging.Logger;

import static consts.BusinessConfigs.*;
import static consts.BusinessConfigs.page.HOME_PAGE_URL;

public class HomePage extends AbstractPage {
    SignInPage signInPage;

    Actions actions = new Actions(DriverFactory.getDriver());


    private static final Logger LOG = Logger.getLogger(String.valueOf(HomePage.class));

    private final By productElement = By.xpath("//a[contains(text(),'Products')]");
    private final By handBugsElement = By.xpath("//a[contains(text(),'Handbags')]");

    private final By featuredItemAddToCartElement = By.xpath("//a[@productid='1']");
    //private final By featuredItemAddToCartElement1 = By.xpath("//div[@class='store-btn-addtocart']/a[@productid='1']");
    private final By shoppingCartOnHomePageElement = By.xpath("//nav[@class='topBar']//li[3]");
    private final By checkoutElement = By.cssSelector(".pull-right[href='#']");
    private final By checkoutElement2 = By.xpath("//a[normalize-space()='Checkout']");

    private final By logoElement = By.xpath("//img[@class='logoImage']");
    private final By cookiesDismissElement = By.xpath("//a[@class='cc-btn cc-dismiss']");

    private final By myAccountButtonElement = By.xpath("//li[@id='customerAccount']");
    private final By signInElement = By.xpath("//a[@id='registerLink'][contains(text(),'Sign in')]");

    private final By homeButtonElement = By.xpath("//a[@class='dropdown-toggle'][normalize-space()='Home']");

    private final By contactUsElement = By.xpath("//a[@href='/shop/store/contactus.html']");

    private final By signInLinkElement = By.xpath("//a[@href='/shop/customer/customLogon.html']");
    private final By registerLinkElement = By.xpath("//a[@href='/shop/customer/registration.html']");
    private final By myAccountLinkElement = By.xpath("//a[@href='/shop/customer/account.html']");
    private final By logOutLinkElement = By.xpath("//a[@href='/shop/customer/logout']");
    private final By getAllTextElementsFromFooter = By.xpath("//div[@class='footer-wrapper']//div[1]//ul[1]//a[text()]");
    private final By getAllLinkFromFooter = By.xpath("//div[@class='footer-wrapper']//div[1]//ul[1]//a");
    private final By inputEmail = By.xpath("//input[@id='signin_userName']");
    private final By inputPassword = By.xpath("//input[@id='signin_password']");
    private final By sign = By.xpath("//button[@id='genericLogin-button']");


    public HomePage proceedToHomePage() {
        proceedToPage(HOME_PAGE_URL.getUrl());
        Assert.assertTrue(isDisplayed(logoElement), "Logo Element is not visible");
        LOG.info(String.format("Proceeded to '%s' URL.", HOME_PAGE_URL));
        return this;
    }

    public HomePage clickCookiesDismiss() {
        getElement(cookiesDismissElement).click();
        // Assert.assertTrue(isDisplayed(logoElement), "Logo Element is not visible");
        LOG.info("Cookies is clicked");
        return this;
    }

    public HomePage clickToLogoElement() {
        getElement(logoElement).click();
        // Assert.assertTrue(isDisplayed(logoElement), "Logo Element is not visible");
        LOG.info("Logo Element is clicked");
        return this;
    }

    public boolean isLogoDisplayed() {
        boolean isDisplayed = isDisplayed(logoElement);
        Assert.assertTrue(isDisplayed, "Logo Element is not visible");
        LOG.info(String.format("Logo is visible '%s'", isDisplayed));
        return isDisplayed;
    }

    public HomePage scrollToMyAccount() {
        actions.moveToElement(getElement(myAccountButtonElement))
                .build().perform();

        LOG.info("to 'My Account' scrolled");
        return this;
    }

    public HomePage clickSignIn() {
        JavascriptExecutor executor = (JavascriptExecutor) DriverFactory.getDriver();
        executor.executeScript("arguments[0].click();", getElement(signInElement));
        // Assert.assertTrue(isDisplayed(logoElement), "Logo Element is not visible");

        LOG.info("'Sign In' is clicked");
        return this;
    }

    public HomePage scrollToAddToCart() {
        actions.moveToElement(getElement(featuredItemAddToCartElement));
        LOG.info("to Featured Item scrolled");
        return this;
    }

    public HomePage clickAddToCart() {
        getElement(featuredItemAddToCartElement).click();
        // Assert.assertTrue(isDisplayed(logoElement), "Logo Element is not visible");
        LOG.info("'Add to cart' is clicked");
        return this;
    }

    public HomePage scrollToShoppingCartOnHomePage() {
//        actions.moveToElement(getElement(shoppingCartOnHomePageElement))
//                .build().perform();
        JavascriptExecutor executor = (JavascriptExecutor) DriverFactory.getDriver();
        executor.executeScript("arguments[0].scrollIntoView(true);", getElement(shoppingCartOnHomePageElement));

        LOG.info("to 'Shopping cart' scrolled");
        return this;
    }

    public HomePage clickCheckout() {
        JavascriptExecutor executor = (JavascriptExecutor) DriverFactory.getDriver();
        executor.executeScript("arguments[0].click();", getElement(checkoutElement2));
//        WebDriverWait wait = new WebDriverWait(DriverFactory.getDriver(), 10);
//        wait.until(ExpectedConditions.visibilityOfElementLocated(checkoutElement)).click();// getElement(checkoutElement);
//        System.out.println(isDisplayed(checkoutElement));
////        Select select = new Select(getElement(shoppingCartOnHomePageElement));
////        select.selectByVisibleText("Checkout");
        // actions.moveToElement(getElement(checkoutElement)).click().build().perform();
////       getElement(checkoutElement).click();
//        // Assert.assertTrue(isDisplayed(logoElement), "Logo Element is not visible");
        LOG.info("'Checkout' is clicked");
        return this;
    }

    public HomePage clickToProducts() {
        actions.moveToElement(getElement(productElement));
        // Assert.assertTrue(isDisplayed(logoElement), "Logo Element is not visible");
        LOG.info("'Products' is clicked");
        return this;
    }

    public ProductPage clickHandBugs() {
        actions.moveToElement(getElement(handBugsElement)).click().build().perform();
        // Assert.assertTrue(isDisplayed(logoElement), "Logo Element is not visible");

        LOG.info("'HandBugs' is clicked");
        return new ProductPage();
    }

    public HomePage clickContactUsButton() {
        actions.moveToElement(getElement(contactUsElement)).click().build().perform();
        // Assert.assertTrue(isDisplayed(logoElement), "Logo Element is not visible");
        LOG.info("'ContactUs' is clicked");
        return this;
    }


    public List<WebElement> getTextsAndLinksListBeforeSignIn() {
        List<WebElement> linksListBeforeLogin = getElements(getAllLinkFromFooter);
        System.out.println(linksListBeforeLogin);
        actions.moveToElement(getElement(signInLinkElement)).click().build().perform();
        getElement(inputEmail).sendKeys(userInputs.EMAIL.getInput());
        getElement(inputPassword).sendKeys(userInputs.PASSWORD.getInput());
        getElement(sign).click();

        List<WebElement> linksListAfterLogin = getElements(getAllLinkFromFooter);
        LOG.info("'Links on footer' are not clicked");
        Assert.assertFalse(linksListBeforeLogin.equals(linksListAfterLogin), "Links on footer are not same");

        return linksListBeforeLogin;
    }


}
