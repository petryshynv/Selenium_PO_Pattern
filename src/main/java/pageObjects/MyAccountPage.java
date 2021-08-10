package pageObjects;

import org.openqa.selenium.By;
import java.util.logging.Logger;

public class MyAccountPage extends AbstractPage {


    private static final Logger LOG = Logger.getLogger(String.valueOf(MyAccountPage.class));

    private final By checkMessageOnMyAccount = By.xpath("//p[normalize-space()='My Account']");

    public boolean isMyAccountDisplayed() {
        boolean isDisplayed = isDisplayed(checkMessageOnMyAccount);
        LOG.info(String.format("text 'My account' '%s'", isDisplayed));
        return isDisplayed;
    }
}
