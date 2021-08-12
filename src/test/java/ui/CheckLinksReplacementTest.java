package ui;

import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import pageObjects.businessObjects.HomeBO;
import pageObjects.businessObjects.SignInBO;

import java.util.List;

import static consts.BusinessConfigs.userInputs.*;

public class CheckLinksReplacementTest extends BaseTest {

    @Test(description = "Check link replacement in footer after login", groups = "UITest")
    public void verifyIsLinksReplacement() {
        List<WebElement> listBeforeSignIn = new HomeBO()
                .proceedToHomePage().getLinksBeforeSignIn();
        new HomeBO()
                .proceedToSignInPage();
        new SignInBO()
                .verifyRegisteredCustomerIsVisible();
         new SignInBO()
                .login(EMAIL.getInput(), PASSWORD.getInput());
        List<WebElement> listAfterSignIn = new SignInBO().getLinksAfterLogin();
        Assert.assertNotEquals(listAfterSignIn, listBeforeSignIn, "Links are same (not replaced)");
    }
}
