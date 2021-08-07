package pageObjects.businessObjects;

import org.testng.Assert;
import pageObjects.HomePage;
import pageObjects.OrderPage;
import pageObjects.ProductPage;
import pageObjects.SignInPage;

public class HomeBO {
    private HomePage homePage;

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
        homePage.proceedToHomePage()
               .clickCookiesDismiss()
                .clickToLogoElement();
        return this;
    }

    public void verifyLogoElementIsVisible() {
        Assert.assertTrue(homePage.isLogoDisplayed(),
                "Logo is not visible");
    }

    public SignInPage proceedToSignInPage(){
        homePage.scrollToMyAccount()
                .clickSignIn()
              ;
        return new SignInPage();
    }

    public OrderPage addFeaturedItemToCard(){
        homePage.scrollToAddToCart()
                .clickAddToCart()
                .scrollToShoppingCartOnHomePage()
                .clickCheckout();
        return new OrderPage();
    }

    public ProductPage proceedToProductPage(){
        homePage
                .clickToProducts()
                .clickHandBugs();
        return new ProductPage();
    }
}
