package pageObjects.businessObjects;

import org.testng.Assert;
import pageObjects.OrderPage;

import static consts.BusinessConfigs.randomString;

public class OrderBO {
    private final OrderPage orderPage;

    public OrderBO() {
        orderPage = new OrderPage();
    }

    public OrderBO proceedToBillingInformation() {
        orderPage.clickProceedButton();
        return this;
    }


    public void verifyBillingInfoTextIsVisible() {
        Assert.assertTrue(orderPage.isBillingInfoDisplayed(),
                "text 'Billing info' is not visible");
    }
}
