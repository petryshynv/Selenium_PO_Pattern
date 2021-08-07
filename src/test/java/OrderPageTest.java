import org.testng.annotations.Test;
import pageObjects.businessObjects.HomeBO;
import pageObjects.businessObjects.OrderBO;


public class OrderPageTest extends BaseTest {

    @Test(description = "Complete order of item from main page (Featured item)")
    public void completeOrderFromHomePage() {
        new HomeBO()
                .proceedToHomePage();
        new HomeBO()
                .addFeaturedItemToCard()
                .isReviewOrderDisplayed();
        new OrderBO()
                .proceedToBillingInformation()
                .verifyBillingInfoTextIsVisible();
        new OrderBO()
                .fillBillingInformation();
        new OrderBO()
                .proceedToSubmitButton()
                .verifyOrderCompletedTextIsVisible();
    }
}
