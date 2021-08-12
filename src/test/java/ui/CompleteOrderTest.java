package ui;

import org.testng.annotations.Test;
import pageObjects.businessObjects.BillingBO;
import pageObjects.businessObjects.CompleteOrderPageBO;
import pageObjects.businessObjects.HomeBO;
import pageObjects.businessObjects.OrderBO;


public class CompleteOrderTest extends BaseTest {

    @Test(description = "Complete order of item from main page (Featured item)", groups = "UITest")
    public void completeOrderFromHomePage() {
        new HomeBO()
                .proceedToHomePage();
        new HomeBO()
                .addFeaturedItemToCard()
                .isReviewOrderDisplayed();
        new OrderBO()
                .proceedToBillingInformation();
        new BillingBO()
                .verifyBillingInfoTextIsVisible();
        new BillingBO()
                .fillBillingInformation()
                .proceedToSubmitButton();
        new CompleteOrderPageBO()
                .verifyOrderCompletedTextIsVisible();
    }
}
