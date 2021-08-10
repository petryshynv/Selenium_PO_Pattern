package pageObjects.businessObjects;

import org.testng.Assert;
import pageObjects.BillingPage;

import static consts.BusinessConfigs.randomString;

public class BillingBO {
    private final BillingPage billingPage;

    public BillingBO() {
        billingPage = new BillingPage();
    }


    public void verifyBillingInfoTextIsVisible() {
        Assert.assertTrue(billingPage.isBillingInfoDisplayed(),
                "text 'Billing info' is not visible");
    }

    public BillingBO fillBillingInformation() {
        billingPage
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
        return this;
    }

    public BillingBO proceedToSubmitButton() {
        billingPage
                .clickSubmitButton();
        return this;
    }
}
