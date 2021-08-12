package pageObjects;

import driver.DriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;

import java.util.List;
import java.util.logging.Logger;

import static consts.BusinessConfigs.page.HOME_PAGE_URL;

public class HomePage extends AbstractPage {

    Actions actions = new Actions(DriverFactory.getDriver());


    private static final Logger LOG = Logger.getLogger(String.valueOf(HomePage.class));

    private final By productElement = By.xpath("//a[contains(text(),'Products')]");
    private final By handBugsElement = By.xpath("//a[contains(text(),'Handbags')]");
    private final By beachBugDropMenuElement = By.xpath("//ul[@class='dropdown-menu row']//a[contains(text(),'Beach bags')]");

    private final By featuredItemAddToCartElement = By.xpath("//a[@productid='1']");
    private final By shoppingCartOnHomePageElement = By.xpath("//nav[@class='topBar']//li[3]");
    private final By checkoutElement = By.xpath("//a[normalize-space()='Checkout']");

    private final By logoElement = By.xpath("//img[@class='logoImage']");
    private final By cookiesDismissElement = By.xpath("//a[@class='cc-btn cc-dismiss']");

    private final By myAccountButtonElement = By.xpath("//li[@id='customerAccount']");
    private final By signInElement = By.xpath("//a[@id='registerLink'][contains(text(),'Sign in')]");
    private final By contactUsElement = By.xpath("//a[@href='/shop/store/contactus.html']");
    private final By getAllLinkFromFooter = By.xpath("//div[@class='footer-wrapper']//div[1]//ul[1]//a");


    public HomePage proceedToHomePage() {
        proceedToPage(HOME_PAGE_URL.getUrl());
        Assert.assertTrue(isDisplayed(logoElement), "Logo Element is not visible");
        LOG.info(String.format("Proceeded to '%s' URL.", HOME_PAGE_URL));
        return this;
    }

    public HomePage clickCookiesDismiss() {
        getElement(cookiesDismissElement).click();
        LOG.info("Cookies is clicked");
        return this;
    }

    public void clickToLogoElement() {
        getElement(logoElement).click();
        LOG.info("Logo Element is clicked");
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

    public void clickSignIn() {
        JavascriptExecutor executor = (JavascriptExecutor) DriverFactory.getDriver();
        executor.executeScript("arguments[0].click();", getElement(signInElement));
        LOG.info("'Sign In' is clicked");
    }

    public HomePage scrollToAddToCart() {
        actions.moveToElement(getElement(featuredItemAddToCartElement));
        LOG.info("to Featured Item scrolled");
        return this;
    }

    public HomePage clickAddToCart() {
        getElement(featuredItemAddToCartElement).click();
        LOG.info("'Add to cart' is clicked");
        return this;
    }

    public HomePage scrollToShoppingCartOnHomePage() {
        JavascriptExecutor executor = (JavascriptExecutor) DriverFactory.getDriver();
        executor.executeScript("arguments[0].scrollIntoView(true);", getElement(shoppingCartOnHomePageElement));
        LOG.info("to 'Shopping cart' scrolled");
        return this;
    }

    public void clickCheckout() {
        JavascriptExecutor executor = (JavascriptExecutor) DriverFactory.getDriver();
        executor.executeScript("arguments[0].click();", getElement(checkoutElement));
        LOG.info("'Checkout' is clicked");
    }

    public HomePage clickToProducts() {
        actions.moveToElement(getElement(productElement));
        LOG.info("'Products' is clicked");
        return this;
    }

    public void clickBeachBugs() {
        actions.moveToElement(getElement(beachBugDropMenuElement)).click().build().perform();
        LOG.info("'Beach bugs' is clicked");
    }

    public void clickHandBugs() {
        actions.moveToElement(getElement(handBugsElement)).click().build().perform();
        LOG.info("'HandBugs' is clicked");
    }

    public void clickContactUsButton() {
        actions.moveToElement(getElement(contactUsElement)).click().build().perform();
        LOG.info("'ContactUs' is clicked");
    }

    public List<WebElement> getLinksListBeforeSignIn() {
        List<WebElement> linksListBeforeLogin = getElements(getAllLinkFromFooter);
        LOG.info("'Links on footer' got");
        return linksListBeforeLogin;
    }
}
