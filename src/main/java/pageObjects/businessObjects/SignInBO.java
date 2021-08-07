package pageObjects.businessObjects;

import org.testng.Assert;
import pageObjects.HomePage;
import pageObjects.SignInPage;

public class SignInBO {
    private SignInPage signInPage;

    public SignInBO() {
        signInPage = new SignInPage();
    }


    public void verifyRegisteredCustomerIsVisible() {
        Assert.assertTrue(signInPage.isRegisteredCustomerDisplayed(),
                "text 'RegisteredCustomer' is not visible");
    }

    public HomePage login(String email, String password) {
        signInPage.enterEmail(email)
                .enterPassword(password)
                .clickSignInButton();
        return new HomePage();
    }


    public void verifyMyAccountIsVisible() {
        Assert.assertTrue(signInPage.isMyAccountDisplayed(),
                "text 'My Account' is not visible");
    }

    public void verifyLoginErrorIsVisible() {
        Assert.assertTrue(signInPage.isLoginErrorMessageDisplayed(),
                "text 'Login error' is not visible");
    }

}
