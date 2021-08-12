package pageObjects.businessObjects;

import pageObjects.OrderPage;

public class OrderBO {
    private final OrderPage orderPage;

    public OrderBO() {
        orderPage = new OrderPage();
    }

    public OrderBO proceedToBillingInformation() {
        orderPage.clickProceedButton();
        return this;
    }
}
