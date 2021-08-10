import org.testng.Assert;
import org.testng.annotations.Test;
import pageObjects.businessObjects.HomeBO;
import pageObjects.businessObjects.MyAccountPageBO;
import pageObjects.businessObjects.SignInBO;

import static consts.BusinessConfigs.*;
import static consts.BusinessConfigs.userInputs.*;
import static consts.BusinessConfigs.userInputs.EMAIL;
import static consts.BusinessConfigs.userInputs.INCORRECT_EMAIL;
import static consts.BusinessConfigs.userInputs.PASSWORD;

public class SignPageTest extends BaseTest {

    @Test(description = "Login with correct email and password.")
    public void verifySignInPageWithCorrectInputs() {
        new HomeBO()
                .proceedToHomePage()
                .proceedToSignInPage();
        new SignInBO()
                .verifyRegisteredCustomerIsVisible();
        new SignInBO()
                .login(EMAIL.getInput(), PASSWORD.getInput());
        new MyAccountPageBO()
                .verifyMyAccountIsVisible();
    }

    @Test(description = "Login with correct invalid email")
    public void verifySignInPageWithIncorrectEmail() {
        new HomeBO()
                .proceedToHomePage()
                .proceedToSignInPage();
        new SignInBO()
                .verifyRegisteredCustomerIsVisible();
        new SignInBO()
                .login(INCORRECT_EMAIL.getInput(), PASSWORD.getInput());
        new SignInBO()
                .verifyLoginErrorIsVisible();
    }

    @Test(description = "Negative scenario")
    public void test() {
        new HomeBO()
                .proceedToHomePage()
                ;


    }
}
