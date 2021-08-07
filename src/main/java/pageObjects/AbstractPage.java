package pageObjects;

import driver.DriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

import static consts.DriversConfigs.waitersValue.EXPLICIT_WAIT_VALUE;


public class AbstractPage {

    private WebDriverWait wait = new WebDriverWait(DriverFactory.getDriver(),
            EXPLICIT_WAIT_VALUE.getValue());

    AbstractPage() {
    }

    void proceedToPage(final String url) {
        DriverFactory.getDriver().get(url);
    }

    WebElement getElement(By locator) {
        return DriverFactory.getDriver().findElement(locator);
    }

    List<WebElement> getElements(By locator){
        return DriverFactory.getDriver().findElements(locator);
    }

    public boolean isDisplayed(By locator) {
        try {
            return DriverFactory
                    .getDriver()
                    .findElement(locator)
                    .isDisplayed();
        } catch (NoSuchElementException | TimeoutException e) {
            return false;
        }
    }
}
