package pageObjects;

import driver.DriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.logging.Logger;

public class ContactUsPage extends AbstractPage {

    Actions actions = new Actions(DriverFactory.getDriver());

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

//    public boolean isSendButtonEnable() {
//        boolean enableButton = getElement(sendButton).isEnabled();
//        Assert.assertTrue(enableButton, "'Send' is not enabled");
//        LOG.info(String.format("'send' is enabled '%s'", enableButton));
//        return enableButton;
//    }

//    public boolean isSendButtonDisable() {
//        getElement(sendButton).;
//        Assert.assertTrue(enableButton, "'Send' is not enabled");
//        LOG.info(String.format("'send' is enabled '%s'", enableButton));
//        return enableButton;
//    }

    public boolean getStatusFromAttribute() {
        boolean statusDisabled =getElement(sendButton).getAttribute("class").contains("disabled");
        //System.out.println(s);
        //LOG.info("Status 'disabled' is got");
        LOG.info(String.format("Logo is visible '%s'", statusDisabled));
        return statusDisabled;
    }

}
