package pageObjects;

import org.openqa.selenium.By;
import java.util.logging.Logger;

public class ContactUsPage extends AbstractPage {

    private static final Logger LOG = Logger.getLogger(String.valueOf(ContactUsPage.class));


    private final By textContactUsElement = By.xpath("//h1[@class='contact-title']");
    public static final By fieldName = By.id("name");
    private final By fieldEmail = By.id("email");
    private final By fieldSubject = By.id("subject");
    private final By fieldComment = By.id("comment");
    private final By sendButton = By.xpath("//input[@id='submitContact']");

    public boolean isTextContactUsDisplayed() {
        boolean isDisplayed = isDisplayed(textContactUsElement);
        LOG.info(String.format("ContactUs' '%s'", isDisplayed));
        return isDisplayed;
    }

    public ContactUsPage enterName(String random) {
        getElement(fieldName).sendKeys(random);
        LOG.info("Name was entered");
        return this;
    }

    public ContactUsPage enterEmail(String random) {
        getElement(fieldEmail).sendKeys(random);
        LOG.info("Email was entered");
        return this;
    }

    public ContactUsPage enterSubject(String random) {
        getElement(fieldSubject).sendKeys(random);
        LOG.info("Subject was entered");
        return this;
    }

    public ContactUsPage enterComment(String random) {
        getElement(fieldComment).sendKeys(random);
        LOG.info("Comment was entered");
        return this;
    }

    public boolean getStatusFromAttribute() {
        boolean statusDisabled = getElement(sendButton).getAttribute("class").contains("disabled");
        LOG.info(String.format("Attribute checked '%s'", statusDisabled));
        return statusDisabled;
    }
}
