package pageObjects.businessObjects;

import org.testng.Assert;
import pageObjects.CompleteOrderPage;


public class CompleteOrderPageBO {
    private final CompleteOrderPage completeOrderPage;

    public CompleteOrderPageBO() {
        completeOrderPage = new CompleteOrderPage();
    }


    public void verifyOrderCompletedTextIsVisible() {
        Assert.assertTrue(completeOrderPage.isOrderCompleteDisplayed(),
                "text 'Billing info' is not visible");
    }
}
