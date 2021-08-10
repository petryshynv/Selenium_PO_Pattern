package pageObjects;

import org.openqa.selenium.By;

import java.util.logging.Logger;

public class CompleteOrderPage extends AbstractPage {

    private static final Logger LOG = Logger.getLogger(String.valueOf(CompleteOrderPage.class));

    private final By textOrderCompletedElement = By.xpath("//h1[normalize-space()='Order completed']");


    public boolean isOrderCompleteDisplayed() {
        boolean isDisplayed = isDisplayed(textOrderCompletedElement);
        LOG.info(String.format("text 'Order completed' '%s'", isDisplayed));
        return isDisplayed;
    }

}
