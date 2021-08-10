package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import java.util.logging.Logger;

public class BillingPage extends AbstractPage {


    private static final Logger LOG = Logger.getLogger(String.valueOf(BillingPage.class));

    private final By fieldFirstName = By.xpath("//input[@id='customer.firstName']");
    private final By fieldLastName = By.xpath("//input[@id='customer.lastName']");
    private final By fieldBillingAddress = By.xpath("//input[@id='customer.billing.address']");
    private final By fieldCity = By.xpath("//input[@id='customer.billing.city']");
    private final By selectCountryElement = By.xpath("//select[@id='customer.billing.country']");
    private final By selectStateElement = By.xpath("//select[@id='billingStateList']");
    private final By fieldPostalCode = By.xpath("//input[@id='billingPostalCode']");
    private final By fieldEmail = By.xpath("//input[@id='customer.emailAddress']");
    private final By fieldPhone = By.xpath("//input[@id='customer.billing.phone']");

    private final By submitButtonElement = By.xpath("//button[@id='submitOrder']");

    private final By textBillingInfo = By.xpath("//h3[normalize-space()='Billing information']");

    public boolean isBillingInfoDisplayed() {
        boolean isDisplayed = isDisplayed(textBillingInfo);
        LOG.info(String.format("h1 'Billing Information' '%s'", isDisplayed));
        return isDisplayed;
    }

    public BillingPage enterFirstName() {
        getElement(fieldFirstName).sendKeys("Name");
        LOG.info("FirstName was entered");
        return this;
    }

    public BillingPage enterLastName() {
        getElement(fieldLastName).sendKeys("Surname");
        LOG.info("Surname was entered");
        return this;
    }

    public BillingPage enterStreetAddress() {
        getElement(fieldBillingAddress).sendKeys("Street 12");
        LOG.info("Street was entered");
        return this;
    }

    public BillingPage enterCity() {
        getElement(fieldCity).sendKeys("City");
        LOG.info("City was entered");
        return this;
    }

    public BillingPage selectCountry() {
        Select select = new Select(getElement(selectCountryElement));
        select.selectByVisibleText("Australia");
        LOG.info("Country was selected");
        return this;
    }

    public BillingPage selectState() {
        Select select = new Select(getElement(selectStateElement));
        select.selectByVisibleText("New South Wales");
        LOG.info("State was selected");
        return this;
    }

    public BillingPage enterPostalCode() {
        getElement(fieldPostalCode).sendKeys("00000");
        LOG.info("PostalCode was entered");
        return this;
    }

    public BillingPage enterEmail(String random) {
        getElement(fieldEmail).sendKeys(random);
        LOG.info("Email was entered");
        return this;
    }

    public BillingPage enterPhone() {
        getElement(fieldPhone).sendKeys("1234567890");
        LOG.info("Phone was entered");
        return this;
    }

    public void verifySubmitButtonIsEnable() {
        boolean enable = getElement(submitButtonElement).isEnabled();
        Assert.assertTrue(enable, "'Submit Button' is not enabled");
        LOG.info(String.format("'Submit Button' is enabled '%s'", enable));
    }

    public OrderPage clickSubmitButton() {
        getElement(submitButtonElement).click();
        LOG.info("'Proceed Button' is clicked");
        return new OrderPage();
    }
}
