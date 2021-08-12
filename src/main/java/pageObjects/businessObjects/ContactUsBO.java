package pageObjects.businessObjects;

import org.testng.Assert;
import pageObjects.ContactUsPage;

import static consts.BusinessConfigs.randomString;

public class ContactUsBO {
    private final ContactUsPage contactUsPage;

    public ContactUsBO() {
        contactUsPage = new ContactUsPage();
    }


    public void verifyContactsUsIsVisible() {
        Assert.assertTrue(contactUsPage.isTextContactUsDisplayed(),
                "text 'Contacts Us' is not visible");
    }

    public ContactUsBO fillAllInformation() {
        contactUsPage.enterName(randomString(10))
                .enterEmail(randomString(10)
                        + "@" + randomString(5)
                        + "." + randomString(3))
                .enterSubject(randomString(10))
                .enterComment(randomString(50));
        return this;
    }

    public void verifySendButtonWithEmptyFieldComment() {
        contactUsPage.enterName(randomString(10))
                .enterEmail(randomString(10)
                        + "@" + randomString(5)
                        + "." + randomString(3))
                .enterSubject(randomString(10));
        Assert.assertTrue(contactUsPage.getStatusFromAttribute());
    }

    public void verifyStatusSendButtonIfAllFieldFilled() {
        Assert.assertFalse(contactUsPage.getStatusFromAttribute());
    }
}
