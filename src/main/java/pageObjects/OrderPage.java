package pageObjects;

import org.openqa.selenium.By;
import java.util.logging.Logger;

public class OrderPage extends AbstractPage {

    private static final Logger LOG = Logger.getLogger(String.valueOf(OrderPage.class));

    private final By proceedToCheckoutButton = By.xpath("//a[@href='/shop/order/checkout.html']");
    private final By reviewOrderElement = By.xpath("//h1[@class='entry-title']");

    private final By textBillingInfo = By.xpath("//h3[normalize-space()='Billing information']");

    public void isReviewOrderDisplayed() {
        boolean isDisplayed = isDisplayed(reviewOrderElement);
        LOG.info(String.format("h1 'Review order' '%s'", isDisplayed));
    }

    public OrderPage clickProceedButton() {
        getElement(proceedToCheckoutButton).click();
        LOG.info("'Proceed Button' is clicked");
        return this;
    }

    public boolean isBillingInfoDisplayed() {
        boolean isDisplayed = isDisplayed(textBillingInfo);
        LOG.info(String.format("h1 'Billing Information' '%s'", isDisplayed));
        return isDisplayed;
    }
}
