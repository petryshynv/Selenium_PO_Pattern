package ui;

import org.testng.annotations.Test;
import pageObjects.businessObjects.HomeBO;

public class HomePageTest extends BaseTest {

    @Test(description = "Check that logo leads to main page", groups = "UITest")
    public void verifyIsProceedToHomePageAfterClickLogo() {
        new HomeBO()
                .proceedToHomePage()
                .proceedToHomePageAfterClickLogo()
                .verifyLogoElementIsVisible();
    }
}
