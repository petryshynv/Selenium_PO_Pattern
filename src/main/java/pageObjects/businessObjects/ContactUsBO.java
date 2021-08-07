package pageObjects.businessObjects;

import org.testng.Assert;
import org.testng.asserts.SoftAssert;
import pageObjects.AbstractPage;
import pageObjects.ContactUsPage;
import pageObjects.HomePage;
import pageObjects.SignInPage;

import static consts.BusinessConfigs.randomString;

public class ContactUsBO {
    private ContactUsPage contactUsPage;

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
                            +"@"+ randomString(5)
                            +"."+ randomString(3))
                .enterSubject(randomString(10))
                .enterComment(randomString(50));
        return this;
    }
//
//    public void verifySendIsEnable() {
//        Assert.assertTrue(contactUsPage.isSendButtonEnable(),
//                "Button 'Send' is not visible");
//    }
//
//    public ContactUsBO fillInformationExpectName() {
//        contactUsPage
//                .enterEmail(randomString(10)
//                        +"@"+ randomString(5)
//                        +"."+ randomString(3))
//                .enterSubject(randomString(10))
//                .enterComment(randomString(50));
//        return this;
//    }
//
//    public ContactUsBO fillInformationExpectEmail() {
//        contactUsPage.enterName(randomString(10))
//                .enterSubject(randomString(10))
//                .enterComment(randomString(50));
//        return this;
//    }
//
//    public ContactUsBO fillInformationExpectSubject() {
//        contactUsPage.enterName(randomString(10))
//                .enterEmail(randomString(10)
//                        +"@"+ randomString(5)
//                        +"."+ randomString(3))
//                .enterComment(randomString(50));
//        return this;
//    }

    public ContactUsBO verifySendButtonWithEmptyFieldComment() {
        contactUsPage.enterName(randomString(10))
                .enterEmail(randomString(10)
                        +"@"+ randomString(5)
                        +"."+ randomString(3))
                .enterSubject(randomString(10));
        Assert.assertTrue(contactUsPage.getStatusFromAttribute());
        return this;
    }

    public void verifyStatusSendButtonIfAllFieldFilled() {
       Assert.assertFalse(contactUsPage.getStatusFromAttribute());

    }

//    public void verifyStatusSendButtonIfOneOfFieldIsEmpty() {
//        SoftAssert softAssert = new SoftAssert();
//        fillInformationExpectComment();
//        softAssert.assertTrue(contactUsPage.getStatusFromAttribute());
//        fillInformationExpectEmail();
//        softAssert.assertTrue(contactUsPage.getStatusFromAttribute());
//        fillInformationExpectSubject();
//        softAssert.assertTrue(contactUsPage.getStatusFromAttribute());
//        fillInformationExpectName();
//        softAssert.assertTrue(contactUsPage.getStatusFromAttribute());
//        softAssert.assertAll();
//    }







}
