package pageObjects.businessObjects;

import org.testng.Assert;
import pageObjects.OrderPage;

import static consts.BusinessConfigs.randomString;

public class OrderBO {
    private OrderPage orderPage;

    public OrderBO() {
        orderPage = new OrderPage();
    }

    public OrderBO proceedToBillingInformation() {
        orderPage.clickProceedButton()
        ;
        return this;
    }

    public OrderBO fillBillingInformation() {
        orderPage
                .enterFirstName()
                .enterLastName()
                .enterStreetAddress()
                .enterCity()
                .selectCountry()
                .selectState()
                .enterPostalCode()
                .enterEmail(randomString(10)
                        +"@"+ randomString(5)
                        +"."+ randomString(3))
                .enterPhone()
                .verifySubmitButtonIsEnable();
        ;
        return this;
    }

    public OrderBO proceedToSubmitButton() {
        orderPage
                .clickSubmitButton();
        ;
        return this;
    }

    public void verifyBillingInfoTextIsVisible() {
        Assert.assertTrue(orderPage.isBillingInfoDisplayed(),
                "text 'Billing info' is not visible");
    }

    public void verifyOrderCompletedTextIsVisible() {
        Assert.assertTrue(orderPage.isOrderCompleteDisplayed(),
                "text 'Billing info' is not visible");
    }

}
