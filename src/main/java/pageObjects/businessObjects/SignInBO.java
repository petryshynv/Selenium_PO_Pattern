package pageObjects.businessObjects;

import org.openqa.selenium.WebElement;
import org.testng.Assert;
import pageObjects.SignInPage;

import java.util.List;

public class SignInBO {
    private final SignInPage signInPage;

    public SignInBO() {
        signInPage = new SignInPage();
    }


    public void verifyRegisteredCustomerIsVisible() {
        Assert.assertTrue(signInPage.isRegisteredCustomerDisplayed(),
                "text 'RegisteredCustomer' is not visible");
    }

    public SignInPage login(String email, String password) {
        signInPage.enterEmail(email)
                .enterPassword(password)
                .clickSignInButton();
        return new SignInPage();
    }

    public void verifyLoginErrorIsVisible() {
        Assert.assertTrue(signInPage.isLoginErrorMessageDisplayed(),
                "text 'Login error' is not visible");
    }

    public List<WebElement> getLinksAfterLogin() {
        return signInPage.getLinksListAfterSignIn();
    }

}
