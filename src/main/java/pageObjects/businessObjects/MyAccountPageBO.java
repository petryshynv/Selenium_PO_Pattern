package pageObjects.businessObjects;

import org.testng.Assert;
import pageObjects.MyAccountPage;

public class MyAccountPageBO {
    private final MyAccountPage myAccountPage;

    public MyAccountPageBO() {
        myAccountPage = new MyAccountPage();
    }

    public void verifyMyAccountIsVisible() {
        Assert.assertTrue(myAccountPage.isMyAccountDisplayed(),
                "text 'My Account' is not visible");
    }

}
