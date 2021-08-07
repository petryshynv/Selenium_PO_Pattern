import org.testng.annotations.Test;
import pageObjects.businessObjects.ContactUsBO;
import pageObjects.businessObjects.HomeBO;
import pageObjects.businessObjects.ProductPO;

public class ContactUsPageTest extends BaseTest {

    @Test(description = "Check that 'Contact us' form can be submitted only when all fields are filled")
    public void verifyContactUsWithAllFilledFields() {
        new HomeBO()
                .proceedToHomePage()
                .proceedToContactUsPage();
        new ContactUsBO()
                .verifyContactsUsIsVisible();
        new ContactUsBO()
                .fillAllInformation()
                .verifyStatusSendButtonIfAllFieldFilled();
    }

    @Test(description = "Check that 'Contact us' form can be submitted only when all fields are filled")
    public void verifyContactUsWithSomeFilledField() {
        new HomeBO()
                .proceedToHomePage()
                .proceedToContactUsPage();
        new ContactUsBO()
                .verifyContactsUsIsVisible();
        new ContactUsBO().verifySendButtonWithEmptyFieldComment();
    }
}
