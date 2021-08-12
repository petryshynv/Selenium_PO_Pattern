package pageObjects.businessObjects;

import org.openqa.selenium.WebElement;
import org.testng.Assert;
import pageObjects.*;

import java.util.List;

public class HomeBO {
    private final HomePage homePage;

    public HomeBO() {
        homePage = new HomePage();
    }

    public HomeBO proceedToHomePage() {
        homePage.proceedToHomePage()
                .clickCookiesDismiss()
                .isLogoDisplayed();
        return this;
    }

    public HomeBO proceedToHomePageAfterClickLogo() {
        homePage
                .clickToLogoElement();
        return this;
    }

    public void verifyLogoElementIsVisible() {
        Assert.assertTrue(homePage.isLogoDisplayed(),
                "Logo is not visible");
    }

    public SignInPage proceedToSignInPage() {
        homePage.scrollToMyAccount()
                .clickSignIn();
        return new SignInPage();
    }

    public OrderPage addFeaturedItemToCard() {
        homePage.scrollToAddToCart()
                .clickAddToCart()
                .scrollToShoppingCartOnHomePage()
                .clickCheckout();
        return new OrderPage();
    }

    public ProductPage proceedToProductPage() {
        homePage
                .clickToProducts()
                .clickHandBugs();
        return new ProductPage();
    }

    public ProductPage proceedToProductBeachBugsPage() {
        homePage
                .clickToProducts().clickBeachBugs();
        return new ProductPage();
    }

    public ContactUsPage proceedToContactUsPage() {
        homePage.clickContactUsButton();
        return new ContactUsPage();
    }

    public List<WebElement> getLinksBeforeSignIn() {
        return homePage.getLinksListBeforeSignIn();
    }
}
